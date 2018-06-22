package com.aek.ebey.repair.service.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.aek.ebey.repair.inter.AssetsRepairStatusEnum;
import com.aek.ebey.repair.inter.MessageStatus;
import com.aek.ebey.repair.inter.RepairApplyStatus;
import com.aek.ebey.repair.inter.RepairMessage;
import com.aek.ebey.repair.mapper.RepRepairApplyMapper;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.model.RepRepairApply;
import com.aek.ebey.repair.model.RepRepairCheck;
import com.aek.ebey.repair.model.RepRepairMessage;
import com.aek.ebey.repair.model.RepRepairReport;
import com.aek.ebey.repair.model.RepRepairTakeOrders;
import com.aek.ebey.repair.model.RepTurnOrders;
import com.aek.ebey.repair.model.RepairData;
import com.aek.ebey.repair.model.custom.RepairDistributionData;
import com.aek.ebey.repair.model.vo.RepLargeScreenDataVo;
import com.aek.ebey.repair.model.vo.RepRepairApplyVo;
import com.aek.ebey.repair.model.vo.RepUserVo;
import com.aek.ebey.repair.model.vo.RepairDataMonthVo;
import com.aek.ebey.repair.model.vo.RepairDataVo;
import com.aek.ebey.repair.query.RepRepairApplyQuery;
import com.aek.ebey.repair.query.RepRepairBillApplyQuery;
import com.aek.ebey.repair.query.RepRepairRecordQuery;
import com.aek.ebey.repair.request.ApplyDetailsResponse;
import com.aek.ebey.repair.request.ApplyResponse;
import com.aek.ebey.repair.request.ApplyTotalResponse;
import com.aek.ebey.repair.request.ApplyTurnOrderRequest;
import com.aek.ebey.repair.request.RepRepairBillApplyResponse;
import com.aek.ebey.repair.request.RepairRecordResponse;
import com.aek.ebey.repair.request.SevenDataResponse;
import com.aek.ebey.repair.request.SevenQuery;
import com.aek.ebey.repair.request.WeiXinRepairMessageRequest;
import com.aek.ebey.repair.service.RepMessageReceiveService;
import com.aek.ebey.repair.service.RepRepairApplyService;
import com.aek.ebey.repair.service.RepRepairCheckService;
import com.aek.ebey.repair.service.RepRepairMessageService;
import com.aek.ebey.repair.service.RepRepairReportService;
import com.aek.ebey.repair.service.RepRepairTakeOrdersService;
import com.aek.ebey.repair.service.RepTurnOrdersService;
import com.aek.ebey.repair.service.ribbon.AuthClientService;
import com.aek.ebey.repair.service.ribbon.UserClientService;
import com.aek.ebey.repair.service.ribbon.UserPermissionService;
import com.aek.ebey.repair.utils.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 设备维修申请表 服务实现类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@Service
@Transactional
public class RepRepairApplyServiceImpl extends BaseServiceImpl<RepRepairApplyMapper, RepRepairApply> implements RepRepairApplyService {

	private static final Logger logger = LoggerFactory.getLogger(RepRepairApplyServiceImpl.class);
	
	@Autowired
	private RepRepairApplyService repRepairApplyService;
	
	@Autowired
	private RepRepairCheckService repRepairCheckService;
	
	@Autowired
	private RepRepairApplyMapper repRepairApplyMapper;
	
	@Autowired
	private RepMessageReceiveService repMessageReceiveService;
	

	@Autowired
	private RepRepairReportService repRepairReportService;
	
	@Autowired
	private RepRepairMessageService repRepairMessageService;
	
	@Autowired
	private UserClientService userClientService;
	
	@Autowired
	private AuthClientService authClientService;
	
	@Autowired
	private UserPermissionService userPermissionService;
	
	@Autowired
	private RepRepairTakeOrdersService repRepairTakeOrdersService;
	
	@Autowired
	private RepTurnOrdersService repTurnOrdersService;

	@Override
	public void save(RepRepairApply repRepairApply) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if (authUser!= null) {
			repRepairApply.setReportRepairId(authUser.getId());
			//repRepairApply.setDeptId(authUser.getDeptId());
			repRepairApply.setDeptName(authUser.getDeptName());
			repRepairApply.setReportRepairName(authUser.getRealName());
			repRepairApply.setReportRepairPhone(authUser.getMobile());
		} else {
			throw ExceptionFactory.create("W_001");
		}
		repRepairApplyMapper.insert(repRepairApply);
		//userClientService.updateAssetsInfoById(repRepairApply.getAssetsId(), 4,repRepairApply.getId(), WebSecurityUtils.getCurrentToken());
		//将设备维修状态更新为维修中
		if(repRepairApply.getAssetsDesc().intValue()==1){
			Result<Object> result = userClientService.updateAssetsRepairStatusById(repRepairApply.getAssetsId(), AssetsRepairStatusEnum.REPAIRING.getNumber(), repRepairApply.getId(), WebSecurityUtils.getCurrentToken());
			if(null==result){
				throw ExceptionFactory.create("G_007");     //服务器异常,请稍后再试
			}
		}
		//新建维修申请时，将申请单消息推送给本机构下拥有接单权限的用户
		WeiXinRepairMessageRequest repairMessageBody = BeanMapper.map(repRepairApply, WeiXinRepairMessageRequest.class);
		repairMessageBody.setApplyId(repRepairApply.getId());
		repairMessageBody.setTakeOrderId(repRepairApply.getTakeOrderId());
		repairMessageBody.setType(WeiXinRepairMessageTypeEnum.TAKE_ORDER.getType());
		Result<List<Map<String, Object>>> messageResult = authClientService.sendWeiXinRepairMessage(repairMessageBody, WebSecurityUtils.getCurrentToken());
		logger.info("新建维修申请单推送消息接口返回结果="+(messageResult!=null?messageResult.getData().toString():null));
	}

	@Override
	public boolean getRepRepairApply(RepRepairApply repRepairApply) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Wrapper<RepRepairApply> wrapper=new EntityWrapper<RepRepairApply>();
		wrapper.in("status", new Integer[]{1,2,3}).eq("assets_id", repRepairApply.getAssetsId());
		if(authUser!= null){
			wrapper.eq("tenant_id", authUser.getTenantId());
		}else {
			throw ExceptionFactory.create("W_001");
		}
		List<RepRepairApply> list=repRepairApplyMapper.selectList(wrapper);
		
		return list!=null&&list.size()>0?true:false;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ApplyResponse> search(RepRepairApplyQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<ApplyResponse> page = query.getPage();
		List<ApplyResponse> list=repRepairApplyMapper.search(page,query,authUser);
		page.setRecords(list);
		return page;
		
	}

	@Override
	@Transactional(readOnly = true)
	public ApplyDetailsResponse getApplyDetails(Long id) {
		return repRepairApplyMapper.getApplyDetails(id);
	}

	@Override
	public List<ApplyTotalResponse> selectApplyStatus(String tenantid) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		
		
		return repRepairApplyMapper.selectApplyStatus(tenantid,authUser);
	}

	@Override
	public void check(RepRepairCheck data) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(data!=null&&authUser!=null){
			RepRepairApply repRepairApply=repRepairApplyService.selectById(data.getApplyId());
			if(repRepairApply!=null&&repRepairApply.getStatus().intValue()==RepairApplyStatus.WAITCHECK.intValue()){
				data.setRepairCheckId(authUser.getId());
				data.setRepairCheckName(authUser.getRealName());
				repRepairCheckService.insert(data);
				//验收时，还原设备原来状态并将设备维修状态更新为正常
				if(repRepairApply.getAssetsDesc().intValue()==1){
					Result<Object> result = userClientService.updateAssetsRepairStatusById(repRepairApply.getAssetsId(), AssetsRepairStatusEnum.NORMAL.getNumber(), repRepairApply.getId(), WebSecurityUtils.getCurrentToken());
					if(null==result){
						throw ExceptionFactory.create("G_007");     //服务器异常,请稍后再试
					}
				}
				RepRepairMessage repRepairMessage = new RepRepairMessage();
				repRepairMessage.setModuleId(repRepairApply.getId());
				repRepairMessage.setMessageContent(RepairMessage.COMPLETE);
				repRepairMessage.setRemarks(repRepairApply.getAssetsDeptName());
				repRepairMessage.setStatus(1);
				repRepairMessageService.insert(repRepairMessage);
				RepMessageReceive repMessageReceive = new RepMessageReceive();
				repMessageReceive.setMessageId(repRepairMessage.getId());
				repMessageReceive.setMessageStatus(MessageStatus.UNWATCH);
				Wrapper<RepRepairReport> wrapper=new EntityWrapper<RepRepairReport>();
				wrapper.eq("apply_id", repRepairApply.getId());
				wrapper.eq("del_flag", 0);
				repRepairApply.setStatus(RepairApplyStatus.COMPLETED);
				repRepairApplyService.updateById(repRepairApply);
				List<RepRepairReport> list=repRepairReportService.selectList(wrapper);
				if(!CollectionUtils.isEmpty(list)){
					repMessageReceive.setUserId(list.get(0).getRepairId());
					repMessageReceiveService.insert(repMessageReceive);
				}else{
					throw ExceptionFactory.create("G_006");
				}
				
			}else{
				throw ExceptionFactory.create("W_023");
			}
		}else{
			throw ExceptionFactory.create("W_001");
		}

	}

	@Override
	public void taking(RepRepairTakeOrders repRepairTakeOrders) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(repRepairTakeOrders!=null&&authUser!=null){
			Result<Integer> result=	userPermissionService.checkIsRep(repRepairTakeOrders.getRepairId(), WebSecurityUtils.getCurrentToken());
			logger.info("用户是否具有维修权限返回结果="+(result!=null?result.getData().toString():null));
			if(result!=null){
				if(result.getData().intValue()==3){
					RepRepairApply repRepairApply=repRepairApplyService.selectById(repRepairTakeOrders.getApplyId());
					if(repRepairApply!=null&&repRepairApply.getStatus().intValue()==RepairApplyStatus.WAITTAKE.intValue()){
						if(repRepairApply.getTakeOrderId().longValue()!=authUser.getId().longValue()){
							throw ExceptionFactory.create("W_022");
						}
						repRepairTakeOrders.setTakeOrderId(authUser.getId());
						repRepairTakeOrders.setTakeOrderName(authUser.getRealName());
						repRepairTakeOrdersService.insert(repRepairTakeOrders);
						repRepairApply.setStatus(RepairApplyStatus.REPAIRING);
						repRepairApplyService.updateById(repRepairApply);
						
						RepRepairReport report=new RepRepairReport();
						report.setApplyId(repRepairApply.getId());
						report.setReportStatus(repRepairApply.getReportStatus());
						report.setSendPerson(repRepairApply.getSendPerson());
						report.setSendPhone(repRepairApply.getSendPhone());
						// 新增
						repRepairReportService.insert(report);
						
						//用户接单时，将申请单消息推送给本机构下拥有维修(填写维修报告单)权限的用户
						WeiXinRepairMessageRequest repairMessageBody = BeanMapper.map(repRepairApply, WeiXinRepairMessageRequest.class);
						repairMessageBody.setApplyId(repRepairApply.getId());
						repairMessageBody.setRepairId(repRepairTakeOrders.getRepairId());
						repairMessageBody.setType(WeiXinRepairMessageTypeEnum.REPAIR.getType());
						Result<List<Map<String, Object>>> messageResult = authClientService.sendWeiXinRepairMessage(repairMessageBody, WebSecurityUtils.getCurrentToken());
						logger.info("用户接单推送消息接口返回结果="+(messageResult!=null?messageResult.getData().toString():null));
						
					}else{
						throw ExceptionFactory.create("W_002");
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
			throw ExceptionFactory.create("G_006");
		}
		
	}

	@Override
	public Page<RepairRecordResponse> repairRecord(RepRepairRecordQuery query) {
		Page<RepairRecordResponse> page = query.getPage();
		List<RepairRecordResponse> list=repRepairApplyMapper.repairRecord(page,query);
		page.setRecords(list);
		return page;
	}

	@Override
	public int selectCountByTenantid(String tenantid, AuthUser authUser, int status) {
		return repRepairApplyMapper.selectCountByTenantid(tenantid,authUser,status);
	}
	
	@Override
	public int statsTakeOrdersByUserId(AuthUser authUser) {
		return repRepairApplyMapper.statsTakeOrdersByUserId(authUser);
	}
	
	@Override
	public int statsWaitRepairByUserId(AuthUser authUser) {
		return repRepairApplyMapper.statsWaitRepairByUserId(authUser);
	}
	
	@Override
	public int statsWaitCheckByUserDeptId(AuthUser authUser) {
		return repRepairApplyMapper.statsWaitCheckByUserDeptId(authUser);
	}

	@Override
	public void turnOrder(ApplyTurnOrderRequest request) {
		Long id=request.getApplyId();
		RepRepairApply repRepairApply=repRepairApplyMapper.selectById(id);
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		if(repRepairApply!=null){
			Result<Integer> result=	userPermissionService.checkIsRep(request.getToId(), WebSecurityUtils.getCurrentToken());
			logger.info("用户是否具有维修权限返回结果="+(result!=null?result.getData().toString():null));
			if(result!=null){
				if(result.getData().intValue()==3){
					int i=repRepairApply.getTurnNum();
					if(i>=5){
						throw ExceptionFactory.create("W_015");
					}else{
						if(repRepairApply.getStatus().intValue() == RepairApplyStatus.REPAIRING.intValue()){
							Wrapper<RepRepairTakeOrders> wrapperTakeOrders=new EntityWrapper<>();
							wrapperTakeOrders.eq("apply_id", id);
							List<RepRepairTakeOrders> list=repRepairTakeOrdersService.selectList(wrapperTakeOrders);
							RepRepairTakeOrders repRepairTakeOrders=null;
							if(list!=null&&list.size()>0){
								repRepairTakeOrders=list.get(0);
							}
							if(repRepairTakeOrders!=null){
								//if(repRepairTakeOrders.getRepairId().longValue()==authUser.getId().longValue()){
								if(repRepairTakeOrders.getRepairId().equals(authUser.getId())){
									if(request.getToId().longValue()==authUser.getId().longValue()){
										throw ExceptionFactory.create("W_018");
									}
									RepTurnOrders entity=new RepTurnOrders();
									entity.setApplyId(id);
									entity.setFromId(authUser.getId());
									entity.setFromName(authUser.getRealName());
									entity.setToId(request.getToId());
									entity.setToName(request.getToName());
									entity.setTurnTime(new Date());
									repTurnOrdersService.insert(entity);
									repRepairApply.setTurnNum(repRepairApply.getTurnNum().intValue()+1);
									repRepairApplyMapper.updateById(repRepairApply);
									Wrapper<RepRepairReport> wrapper=new EntityWrapper<>();
									wrapper.eq("apply_id", id);
									repRepairReportService.delete(wrapper);
									repRepairTakeOrders.setRepairId(request.getToId());
									repRepairTakeOrders.setRepairName(request.getToName());
									repRepairTakeOrdersService.updateById(repRepairTakeOrders);
								}else{
									throw ExceptionFactory.create("W_014");
								}
							}
						}else{
							throw ExceptionFactory.create("W_014");
						}
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
			throw ExceptionFactory.create("W_014");
		}
		
	}

	@Override
	public Page<RepRepairBillApplyResponse> getRepairApplyPageForBill(RepRepairBillApplyQuery query) {
		AuthUser authUser = WebSecurityUtils.getCurrentUser();
		Page<RepRepairBillApplyResponse> page = query.getPage();
		List<RepRepairBillApplyResponse> list=repRepairApplyMapper.getRepairApplyPageForBill(page,query,authUser);
		page.setRecords(list);
		System.out.println(page.toString());
		return page;
	}

	@Override
	public void autoCheck() {
		//repair_date
		List<RepRepairApply> applyList=null;
		Wrapper<RepRepairApply> wrapperapply=new EntityWrapper<>();
		wrapperapply.eq("status", 3);
		List<RepRepairApply> list=repRepairApplyService.selectList(wrapperapply);
		logger.info("<---------------------------------" +list.size());
		if(list!=null&&list.size()>0){
			applyList=new ArrayList<RepRepairApply>();
			for(RepRepairApply repRepairApply:list){
				Wrapper<RepRepairReport> wrapper2=new EntityWrapper<>();
				wrapper2.eq("apply_id", repRepairApply.getId());
				RepRepairReport repRepairReport=repRepairReportService.selectOne(wrapper2);
				if(repRepairReport.getRepairDate().before(DateUtil.getPre5DayTime())){
					applyList.add(repRepairApply);
				}
			
			}
		}
		if(applyList!=null&&applyList.size()>0){
			for(RepRepairApply repRepairApply:applyList){
				RepRepairCheck data=new RepRepairCheck();
				data.setRepairCheckId(repRepairApply.getReportRepairId());
				data.setApplyId(repRepairApply.getId());
				data.setRepairCheckName(repRepairApply.getReportRepairName());
				data.setRemarks("系统自动验收");
				data.setRepairAttitude("5");
				data.setRepairQuality("5");
				data.setResponseSpeed("5");
				repRepairCheckService.insert(data);
				
				RepRepairMessage repRepairMessage = new RepRepairMessage();
				repRepairMessage.setModuleId(repRepairApply.getId());
				repRepairMessage.setMessageContent(RepairMessage.COMPLETE);
				repRepairMessage.setRemarks(repRepairApply.getAssetsDeptName());
				repRepairMessage.setStatus(1);
				repRepairMessageService.insert(repRepairMessage);
				RepMessageReceive repMessageReceive = new RepMessageReceive();
				repMessageReceive.setMessageId(repRepairMessage.getId());
				repMessageReceive.setMessageStatus(MessageStatus.UNWATCH);
				Wrapper<RepRepairReport> wrapper=new EntityWrapper<RepRepairReport>();
				wrapper.eq("apply_id", repRepairApply.getId());
				wrapper.eq("del_flag", 0);
				repRepairApply.setStatus(RepairApplyStatus.COMPLETED);
				repRepairApplyService.updateById(repRepairApply);
				List<RepRepairReport> list2=repRepairReportService.selectList(wrapper);
				if(!CollectionUtils.isEmpty(list2)){
					repMessageReceive.setUserId(list2.get(0).getRepairId());
					repMessageReceiveService.insert(repMessageReceive);
				}else{
					logger.info("<--------------------G_006----------------------------");
					System.out.println("<--------------------G_006----------------------------");
					throw ExceptionFactory.create("G_006");
				}
				//验收时，还原设备原来状态并将设备维修状态更新为正常
				if(repRepairApply.getAssetsDesc().intValue()==1){
					Result<Object> result = userClientService.updateAssetsRepairStatusByIdNoToken(repRepairApply.getAssetsId(), AssetsRepairStatusEnum.NORMAL.getNumber(), repRepairApply.getId());
					if(null==result){
						logger.info("<--------------------G_007----------------------------");
						System.out.println("<--------------------G_007----------------------------");
						throw ExceptionFactory.create("G_007");     //服务器异常,请稍后再试
					}
				}
			
			}
		}
    
		
	}

    @Override
    public RepLargeScreenDataVo getLargeScreenData(Long tenantId) {
        String token = WebSecurityUtils.getCurrentToken();
        RepLargeScreenDataVo repLargeScreenDataVo = repRepairApplyMapper.getRepLargeScreenData(tenantId);
        if (null != repLargeScreenDataVo) {
            //获取具有维修权限用户列表
            Result<List<RepUserVo>> result = userPermissionService.getRepairUserList(token);
            if (result != null) {
                List<RepUserVo> users = result.getData(); 
                if (null != users && users.size() > 0) {
                    repLargeScreenDataVo.setEngineerNum(users.size());
                }
            }
            //维修单数据
            List<RepRepairApplyVo> repairApplyList = this.getLargeScreenApplyData(tenantId);
            repLargeScreenDataVo.setRepairApplyList(repairApplyList);
        }
        return repLargeScreenDataVo;
    }
    
    @Override
    public List<RepRepairApplyVo> getLargeScreenApplyData(Long tenantId) {
        return repRepairApplyMapper.getLargeScreenApplyData(tenantId);
    }
	
    @Override
    public List<RepairData> getRepairData() {
        List<RepairData> repairDataList = new ArrayList<RepairData>();
        List<RepairDataVo> list = repRepairApplyMapper.getRepairData(com.aek.common.core.util.DateUtil.format(new Date(), "yyyy-MM-dd"));
        for (RepairDataVo repairDataVo : list) {
            RepairData repairData = BeanMapper.map(repairDataVo, RepairData.class);
            RepairDistributionData distribution = BeanMapper.map(repairDataVo, RepairDistributionData.class);
            repairData.setRepairDistributionData(JSON.toJSONString(distribution));
            repairData.setCountDate(DateUtil.getPre1DayTime());
            repairData.setCountTime(new Date());
            repairDataList.add(repairData);
        }
        return repairDataList;
    }

    @Override
    public List<RepairDataMonthVo> getRepairDataMonthByDay() {
        return repRepairApplyMapper.getRepairDataMonthByDay(com.aek.common.core.util.DateUtil.format(new Date(), "yyyy-MM-dd"));
    }

	@Override
	public List<SevenDataResponse> countApply(SevenQuery query) {
		if (query != null && query.getStartDate() == null){
			query = DateUtil.getTime();
		}
		List<SevenDataResponse> sevenDataResponseList = repRepairApplyMapper.selectByQuery(query);
		return sevenDataResponseList;
	}
    
}
