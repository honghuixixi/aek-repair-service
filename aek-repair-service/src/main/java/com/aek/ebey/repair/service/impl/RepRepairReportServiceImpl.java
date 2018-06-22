package com.aek.ebey.repair.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.enums.WeiXinRepairMessageTypeEnum;
import com.aek.ebey.repair.inter.Constants;
import com.aek.ebey.repair.inter.RepairApplyStatus;
import com.aek.ebey.repair.mapper.RepPartsRecordMapper;
import com.aek.ebey.repair.mapper.RepRepairReportMapper;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.RepRepairReport;
import com.aek.ebey.repair.model.RepRepairTakeOrders;
import com.aek.ebey.repair.request.RepRepairReportDetails;
import com.aek.ebey.repair.request.RepRepairReportResponse;
import com.aek.ebey.repair.request.WeiXinRepairMessageRequest;
import com.aek.ebey.repair.service.RepPartsRecordService;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairReportService;
import com.aek.ebey.repair.service.RepRepairTakeOrdersService;
import com.aek.ebey.repair.service.RepairDictionaryService;
import com.aek.ebey.repair.service.ribbon.AuthClientService;
import com.aek.ebey.repair.service.ribbon.UserPermissionService;
import com.aek.ebey.repair.utils.DateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

/**
 * <p>
 * 维修报告 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepRepairReportServiceImpl extends BaseServiceImpl<RepRepairReportMapper, RepRepairReport> implements RepRepairReportService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairReportServiceImpl.class);
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;

	@Autowired
	private RepRepairReportMapper repRepairReportMapper;
	
	@Autowired
	private RepPartsRecordMapper repPartsRecordMapper;
	
	@Autowired
	private RepPartsRecordService repPartsRecordService;
	
	@Autowired
	private RepairDictionaryService repairDictionaryService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private AuthClientService authClientService;
	
	
	@Autowired
	private RepRepairTakeOrdersService repRepairTakeOrdersService;
	
	@Autowired
	private UserPermissionService userPermissionService;
	
	@Override
	public Boolean save(RepRepairReport data) {
		RepRepairApply repRepairApply = repRepairApplyService.selectById(data.getApplyId());
			// 判断当前订单状态是否为2待维修状态
		
		if (null != repRepairApply && repRepairApply.getStatus() == RepairApplyStatus.REPAIRING) {
			AuthUser authUser = WebSecurityUtils.getCurrentUser();
			Wrapper<RepRepairTakeOrders> wrapperTakeOrders=new EntityWrapper<>();
			wrapperTakeOrders.eq("apply_id", data.getApplyId());
			List<RepRepairTakeOrders> listTakeOrders=repRepairTakeOrdersService.selectList(wrapperTakeOrders);
			RepRepairTakeOrders repRepairTakeOrders=null;
			if(listTakeOrders!=null&&listTakeOrders.size()>0){
				repRepairTakeOrders=listTakeOrders.get(0);
			}
			if (null != authUser && authUser.getId() != null) {
				data.setRepairId(authUser.getId());
				data.setRepairName(authUser.getRealName());
			}
			if(repRepairTakeOrders!=null){
				Result<Integer> result=	userPermissionService.checkIsRep(repRepairTakeOrders.getRepairId(), WebSecurityUtils.getCurrentToken());
				logger.info("用户是否具有维修权限返回结果="+(result!=null?result.getData().toString():null));
				if(result!=null){
					if(result.getData().intValue()==3){
						if(repRepairTakeOrders.getRepairId().longValue()==authUser.getId().longValue()){

							Wrapper<RepRepairReport> wrapper = new EntityWrapper<RepRepairReport>();
							wrapper.eq("apply_id", data.getApplyId());
							wrapper.eq("del_flag", 0);
							List<RepRepairReport> listRepRepairReport = repRepairReportMapper.selectList(wrapper);
							if(data.getPartsCost()!=null&&data.getRepairCost()!=null){
								data.setTotalCost(data.getPartsCost().add(data.getRepairCost()));
							}else{
							    BigDecimal partsCost = new BigDecimal(0);
							    BigDecimal repairCost = new BigDecimal(0);
								if(data.getPartsCost() != null){
								    partsCost = data.getPartsCost();
								}
								if(data.getRepairCost() != null){
								    repairCost = data.getRepairCost();
								}
								data.setPartsCost(partsCost);
								data.setRepairCost(repairCost);
								data.setTotalCost(partsCost.add(repairCost));
							}
							Wrapper<RepPartsRecord> wrapperRepPartsRecord =null;
							List<RepPartsRecord> listRepPartsRecord =null;
							if (!CollectionUtils.isEmpty(listRepRepairReport)) {
								// 删除
								//data.setId(listRepRepairReport.get(0).getId());
								repRepairReportMapper.deleteById(listRepRepairReport.get(0).getId());
								wrapperRepPartsRecord = new EntityWrapper<RepPartsRecord>();
								wrapperRepPartsRecord.eq("report_id", listRepRepairReport.get(0).getId());
								//wrapperRepPartsRecord.eq("del_flag", 0);
								listRepPartsRecord = repPartsRecordMapper.selectList(wrapperRepPartsRecord);
							}
							// 新增
							data.setRepairDate(new Date());
							repRepairReportMapper.insert(data);
							
							List<RepPartsRecord> list = data.getList();
							// 更新
							// 查询所有的来源id
							List<Long> listids = new ArrayList<Long>();
							if (!CollectionUtils.isEmpty(listRepPartsRecord)) {
								for (RepPartsRecord repPartsRecord : listRepPartsRecord) {
									listids.add(repPartsRecord.getId());
								}
							}

							//删除
							if(listids.size()>0){
								repPartsRecordService.deleteBatchIds(listids);
							}
							//新增
							if (list != null && list.size() > 0) {
								if(data.getStatus().intValue() == 2){
									for (RepPartsRecord repPartsRecord : list) {
										if (authUser != null) {
											// 设置机构
											repPartsRecord.setTenantId(Long.parseLong(authUser.getTenantId() + ""));

										}
										repPartsRecord.setReportId(data.getId());
										// 新增
										repPartsRecordService.insert(repPartsRecord);
									}
								}else{
									for (RepPartsRecord repPartsRecord : list) {
										if (authUser != null) {
											// 设置机构
											repPartsRecord.setTenantId(Long.parseLong(authUser.getTenantId() + ""));

										}
										repPartsRecord.setReportId(data.getId());
										repPartsRecord.setDelFlag(true);
										// 新增
										repPartsRecordService.insert(repPartsRecord);
									}
								}
								

							}
							// 更改订单状态
							if (data.getStatus().intValue() == 2) {
								repRepairApply.setStatus(RepairApplyStatus.WAITCHECK);
								repRepairApply.setSevenStatus(DateUtil.getSevenStatus(repRepairApply.getReportRepairDate(), data.getRepairDate()));
								//用户填写维修报告时，将申请单消息推送给本机构下拥有验收维修权限的用户
								WeiXinRepairMessageRequest repairMessageBody = BeanMapper.map(repRepairApply, WeiXinRepairMessageRequest.class);
								repairMessageBody.setApplyId(repRepairApply.getId());
								repairMessageBody.setType(WeiXinRepairMessageTypeEnum.CHECK.getType());
								Result<List<Map<String, Object>>> messageResult = authClientService.sendWeiXinRepairMessage(repairMessageBody, WebSecurityUtils.getCurrentToken());
								logger.info("用户填写维修报告时推送消息接口返回结果="+(messageResult!=null?messageResult.getData().toString():null));
							}
							repRepairApplyService.updateById(repRepairApply);
							return true;
						}else{
							throw ExceptionFactory.create("W_016");
						}
					}else if(result.getData().intValue()==2){
						throw ExceptionFactory.create("W_021");
					}else if(result.getData().intValue()==1){
						//没有权限
						throw ExceptionFactory.create("W_019");
					}
				}else{
					throw ExceptionFactory.create("G_007");
				}
			}else{
				throw ExceptionFactory.create("W_017");
			}
			
		} else {
			throw ExceptionFactory.create("W_002");
		}
		return null;

	}

	@Override
	public RepRepairReportResponse searchResponse(Long id) {
		HashOperations<String, String, String>  hash= redisTemplate.opsForHash();
		RepRepairReportResponse response=new RepRepairReportResponse();
		Wrapper<RepRepairReport> wrapper=new EntityWrapper<RepRepairReport>();
		wrapper.eq("apply_id", id);
		wrapper.eq("del_flag", 0);
		List<RepRepairReport> list=repRepairReportMapper.selectList(wrapper);
		if (!CollectionUtils.isEmpty(list)) {
			RepRepairReport report = list.get(0);

			response.setModeStatusName(getModeStatusName(report.getModeStatus().intValue()));
			response.setOutsideCompany(report.getOutsideCompany());
			response.setOutsidePhone(report.getOutsidePhone());
			response.setFaultPhenomenonList(getList(hash,report.getFaultPhenomenon()));
			response.setFaultReasonList(getList(hash,report.getFaultReason()));
			response.setWorkContentList(getList(hash,report.getWorkContent()));

		}
		Wrapper<RepPartsRecord> wrapperRecord = new EntityWrapper<RepPartsRecord>();
		wrapperRecord.eq("report_id", id);
		wrapperRecord.eq("del_flag", 0);
		List<RepPartsRecord> listRecord = repPartsRecordService.selectList(wrapperRecord);
		if (!CollectionUtils.isEmpty(listRecord)) {
			for(RepPartsRecord repPartsRecord:listRecord){
				getReportsRecord(hash, repPartsRecord);
			}
			response.setList(listRecord);
		}
		
		return response;
	}

	private void getReportsRecord(HashOperations<String, String, String> hash, RepPartsRecord repPartsRecord) {
		if(repPartsRecord.getUnit()!=null){
			if(hash.get(Constants.REPAIR_DICTIONARY, repPartsRecord.getUnit())!=null){
				repPartsRecord.setUnitName(hash.get(Constants.REPAIR_DICTIONARY, repPartsRecord.getUnit()));
			}else{
				  String name= repairDictionaryService.getValue(repPartsRecord.getUnit());
					 if(name!=null){
						 hash.put(Constants.REPAIR_DICTIONARY,repPartsRecord.getUnit(), name);
						 repPartsRecord.setUnitName(name);
					 }
			}
			
		}
	}

	private List<String> getList(HashOperations<String, String, String>  hash,String faultPhenomenon) {
		
		if(faultPhenomenon!=null&&faultPhenomenon.length()>0){
			String[]  listFaultPhenomenon=faultPhenomenon.split(",");
			List<String> list=new ArrayList<String>();
			if(listFaultPhenomenon!=null&&listFaultPhenomenon.length>0){
				for(String keyId:listFaultPhenomenon){
					getKey(list,hash,keyId);
				}
			}
			return list;
		}
		
		return null;
	}

	private void getKey(List<String> list,HashOperations<String, String, String>  hash,String keyId) {
		 String reg = "^\\d+$";
		 boolean b= Pattern.compile(reg).matcher(keyId).find();
		 
		 if(b){
			 String value= hash.get(Constants.REPAIR_DICTIONARY, keyId);
			  if(value!=null){
				  list.add(value);
			  }else{
				  String name= repairDictionaryService.getValue(keyId);
				 if(name!=null){
					 hash.put(Constants.REPAIR_DICTIONARY,keyId, name);
					 list.add(name);
				 }else{
					 list.add(keyId);
				 }
				 
			  }
		 }else{
			 list.add(keyId);
		 }
		 
	}

	private String getModeStatusName(int modeStatus) {
		// 1，自主维修 2，外修 3，现场解决
		String mode = "";
		switch (modeStatus) {
		case 1:
			mode = "自主维修";
			break;
		case 2:
			mode = "外修";
			break;
		case 3:
			mode = "现场解决";
			break;
		default:
			break;

		}
		return mode;
	}

	@Override
	public RepRepairReportDetails search(Long id) {
		Wrapper<RepRepairReport> wrapper=new EntityWrapper<RepRepairReport>();
		wrapper.eq("apply_id", id);
		wrapper.eq("del_flag", 0);
		RepRepairReportDetails details=new RepRepairReportDetails();
		List<RepRepairReport> list=repRepairReportMapper.selectList(wrapper);
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(!CollectionUtils.isEmpty(list)){
			RepRepairReport repRepairReport=list.get(0);
			Wrapper<RepPartsRecord> wrapperRepPartsRecord = new EntityWrapper<RepPartsRecord>();
			wrapperRepPartsRecord.eq("report_id", repRepairReport.getId());
			//wrapperRepPartsRecord.eq("del_flag", 0);
			List<RepPartsRecord> listRepPartsRecord = repPartsRecordService.selectList(wrapperRepPartsRecord);
			repRepairReport.setList(listRepPartsRecord);
			details = BeanMapper.map(repRepairReport, RepRepairReportDetails.class);
			getDetails(details);
		}
		Wrapper<RepRepairTakeOrders> wrapperTakeOrders=new EntityWrapper<>();
		wrapperTakeOrders.eq("apply_id", id);
		List<RepRepairTakeOrders> listTakeOrders=repRepairTakeOrdersService.selectList(wrapperTakeOrders);
		RepRepairTakeOrders repRepairTakeOrders=null;
		if(listTakeOrders!=null&&listTakeOrders.size()>0){
			repRepairTakeOrders=listTakeOrders.get(0);
		}
		if(repRepairTakeOrders!=null){
			if(authUser!=null){
				details.setFlag(repRepairTakeOrders.getRepairId().longValue()==authUser.getId().longValue()?true:false);
			}
		}
		return details;
	}

	private void getDetails(RepRepairReportDetails details) {
		HashOperations<String, String, String>  hash= redisTemplate.opsForHash();
		details.setFaultPhenomenonList(getList(hash,details.getFaultPhenomenon()));
		details.setFaultReasonList(getList(hash,details.getFaultReason()));
		details.setWorkContentList(getList(hash,details.getWorkContent()));
		if (!CollectionUtils.isEmpty(details.getList())) {
			for(RepPartsRecord repPartsRecord:details.getList()){
				getReportsRecord(hash, repPartsRecord);
			}
			details.setList(details.getList());
		}
	}
	
}
