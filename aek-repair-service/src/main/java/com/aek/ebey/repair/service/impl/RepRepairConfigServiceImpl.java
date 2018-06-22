package com.aek.ebey.repair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aek.common.core.BeanMapper;
import com.aek.common.core.Result;
import com.aek.common.core.base.BaseServiceImpl;
import com.aek.common.core.exception.BusinessException;
import com.aek.common.core.exception.ExceptionFactory;
import com.aek.common.core.serurity.WebSecurityUtils;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.mapper.RepRepairConfigMapper;
import com.aek.ebey.repair.model.RepRepairConfig;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepConfigResponseVo;
import com.aek.ebey.repair.model.vo.RepConfiger;
import com.aek.ebey.repair.model.vo.RepUserVo;
import com.aek.ebey.repair.model.vo.TakeOrderDeptVo;
import com.aek.ebey.repair.service.RepRepairConfigService;
import com.aek.ebey.repair.service.ribbon.UserPermissionService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;

/**
 * <p>
 * 维修配置表 服务实现类
 * </p>
 *
 * @author cyl
 * @since 2018-01-26
 */
@Service
@Transactional
public class RepRepairConfigServiceImpl extends BaseServiceImpl<RepRepairConfigMapper, RepRepairConfig> implements RepRepairConfigService {

	@Autowired
	UserPermissionService userPermissionService;	
	@Autowired
	RepRepairConfigMapper repRepairConfigMapper;
	@Autowired
	RepRepairConfigService repRepairConfigService;
	
	@Override
	public List<RepConfigDeptVo> selectDept(String keyword) {
		String token = WebSecurityUtils.getCurrentToken();
		AuthUser currentUser = WebSecurityUtils.getCurrentUser();
		Long tenantId = currentUser.getTenantId();
		//用户更新repairConfig表
		Result<List<RepUserVo>> takeOrderUserListResult = userPermissionService.getTakeOrderUserList(token);
		if(takeOrderUserListResult != null){
			List<RepUserVo> takeOrderUserList = takeOrderUserListResult.getData();
			if(takeOrderUserList !=null && takeOrderUserList.size()>0){
				List<RepUserVo> repairGroupById = repRepairConfigMapper.getRepairGroupById(tenantId);
				if(repairGroupById !=null && repairGroupById.size()>0){
					repairGroupById.removeAll(takeOrderUserList);
				}
				if(repairGroupById.size()>0){
					repRepairConfigMapper.deletByRepairIdList(repairGroupById, tenantId);
				}
			}
		}
		List<RepConfigDeptVo> deptList = Lists.newArrayList();
		Result<List<RepConfigDeptVo>> result = userPermissionService.getDeptList(keyword, token);
		Result<List<RepConfigDeptVo>> allDeptList = userPermissionService.getAllDeptList(keyword, token);
		if (result !=null&&"200".equals(result.getCode())) {
			deptList = result.getData();
//			List<RepConfigDeptVo> deptListCopy  = BeanMapper.mapList(deptList, RepConfigDeptVo.class);
			if(deptList !=null && deptList.size()>0){
				List<RepConfigDeptVo> takeOrderDepts = repRepairConfigMapper.getTakeOrderDeptId(tenantId);
				if(takeOrderDepts !=null && takeOrderDepts.size()>0){			
					deptList.removeAll(takeOrderDepts);//移除已经分配部门
					if(allDeptList!=null&&"200".equals(allDeptList.getCode())){
						List<RepConfigDeptVo> deptsList = allDeptList.getData();
						if(deptsList!=null&&deptsList.size()>0){
							takeOrderDepts.removeAll(deptsList);//维修冗余且sys已删除的部门
							if(takeOrderDepts.size()>0){
								repRepairConfigMapper.deletByEnableDelDeptId(takeOrderDepts, tenantId);
							}
						}					
					}					
				}
			}	
		}
		return deptList;
	}

	@Override
	public Page<RepUserVo> repairConfigPage(Page<RepUserVo> page) {
		List<RepUserVo> listVo = Lists.newArrayList();
		String currentToken = WebSecurityUtils.getCurrentToken();
		Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
		Result<List<RepUserVo>> result = userPermissionService.getTakeOrderUserList(currentToken);
		if(result !=null){
			List<RepUserVo> repUserList = result.getData();
			if(repUserList !=null && repUserList.size() >0){			
				int total=repUserList.size();
				page.setTotal(total);
				int pageNo = page.getCurrent();
				int pageSize= page.getSize();
				int fromIndex=pageSize*(pageNo-1);
				int toIndex=pageSize*pageNo;
				if(fromIndex <= toIndex){
					listVo=repUserList.subList(fromIndex, (toIndex>total?total:toIndex));
					if(listVo.size()>0){
						for (RepUserVo lv : listVo) {
							String takeOrderDeptNames = repRepairConfigMapper.getTakeOrderDeptNames(lv.getId(),tenantId);
							lv.setTakeOrderDeptNames(takeOrderDeptNames);
						}
					}				
				}
				//异步更新维修工程师数据
				new Thread() {
					@Override
					public void run() {
						for (RepUserVo repUser : repUserList) {
							repRepairConfigMapper.updateRepConfigUser(repUser, tenantId);
						}
					}
				}.start();
			}
		}	
		page.setRecords(listVo);
		return page;
	}
	
	@Override
	public void repConfig(Long repairId, List<RepConfigDeptVo> depts) {
		if(depts.size()==0){
			Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
			repRepairConfigMapper.delByTenantIdRepairId(repairId, tenantId);
		}
		if(depts.size()>0){
			String token = WebSecurityUtils.getCurrentToken();
			//校验是否有维修权限或者是否停用
			Result<Integer> checkIntResult = userPermissionService.checkIsRepHelp(repairId, token);
			Integer checkInt = checkIntResult.getData();
			if(checkInt != null){
				switch (checkInt.intValue()) {
				case 1:
					throw ExceptionFactory.create("A_002");
				case 2:	
					throw ExceptionFactory.create("A_003");
				default:
					break;
				}
			}
			//校验科室是否已分配
			Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
			for (RepConfigDeptVo dep : depts) {
				RepRepairConfig takeOrderDept = repRepairConfigMapper.getByTakeOrderDeptId(dep.getId(),tenantId,repairId);
				if(takeOrderDept != null){
					throw new BusinessException("201", takeOrderDept.getTakeOrderDeptName()+"已被分配，请移除");
				}
			}
			if(repairId == null){
				return;
			}
			//清除个人历史配置
			repRepairConfigMapper.delByTenantIdRepairId(repairId, tenantId);
			
			List<RepRepairConfig> list = Lists.newArrayList();
			Result<RepUserVo> userResult = userPermissionService.getUser(repairId, tenantId, token);
			if(userResult !=null){
				RepUserVo user = userResult.getData();
				if(user == null){
					return;
				}
				for (RepConfigDeptVo dep : depts) {
					RepRepairConfig rc = BeanMapper.map(user, RepRepairConfig.class);
					rc.setRepairId(user.getId());
					rc.setRepairName(user.getRealName());
					rc.setTakeOrderDeptId(dep.getId());
					rc.setTakeOrderDeptName(dep.getName());
					rc.setTenantId(tenantId);
					list.add(rc);
				}
				if(list.size()>0){
					repRepairConfigService.insertBatch(list);
				}
			}		
		}
	}

	@Override
	public RepConfigResponseVo getConfigDetail(Long repairId) {
		String token = WebSecurityUtils.getCurrentToken();
		Long tenantId = WebSecurityUtils.getCurrentUser().getTenantId();
		//校验是否有维修权限或者是否停用
		Result<Integer> checkIntResult = userPermissionService.checkIsRepHelp(repairId, token);
		Integer checkInt = checkIntResult.getData();
		if(checkInt != null){
			switch (checkInt.intValue()) {
			case 1:
				throw ExceptionFactory.create("A_002");
			case 2:	
				throw ExceptionFactory.create("A_003");
			default:
				break;
			}
		}
		//更新repairConfig表
		Result<List<RepUserVo>> takeOrderUserListResult = userPermissionService.getTakeOrderUserList(token);
		if(takeOrderUserListResult != null){
			List<RepUserVo> takeOrderUserList = takeOrderUserListResult.getData();
			if(takeOrderUserList !=null && takeOrderUserList.size()>0){
				List<RepUserVo> repairGroupById = repRepairConfigMapper.getRepairGroupById(tenantId);
				if(repairGroupById !=null && repairGroupById.size()>0){
					repairGroupById.removeAll(takeOrderUserList);
				}
				if(repairGroupById.size()>0){
					repRepairConfigMapper.deletByRepairIdList(repairGroupById, tenantId);
				}
			}
		}
		//已选科室	
		Wrapper<RepRepairConfig> wrapper = new EntityWrapper<RepRepairConfig>();
		wrapper.eq("repair_id", repairId).eq("tenant_id", tenantId).eq("del_flag", 0);
		List<RepRepairConfig> list = repRepairConfigMapper.selectList(wrapper);
		RepConfigResponseVo repCofRep = new RepConfigResponseVo();
		List<TakeOrderDeptVo> mapList = Lists.newArrayList();
		if(list !=null && list.size()>0){
			RepRepairConfig repCof = list.get(0);		
			repCofRep.setRepairId(repCof.getRepairId());
			mapList.addAll(BeanMapper.mapList(list, TakeOrderDeptVo.class));		
		}
		repCofRep.setOwnDepts(mapList);
		
		//可用科室
		Result<List<RepConfigDeptVo>> allDeptsResult = userPermissionService.getDeptList(null, token);
		List<RepConfigDeptVo> takeOrderDepts = repRepairConfigMapper.getTakeOrderDeptId(tenantId);
		List<RepConfigDeptVo> allDeptsList = Lists.newArrayList();
		List<TakeOrderDeptVo> listBo = Lists.newArrayList();
		if(allDeptsResult != null){
			allDeptsList = allDeptsResult.getData();
			if(allDeptsList !=null && allDeptsList.size()>0){
				allDeptsList.removeAll(takeOrderDepts);
			}
			if(allDeptsList.size()>0){
				for (RepConfigDeptVo repConfigDeptVo : allDeptsList) {
					TakeOrderDeptVo takeOrderDept = new TakeOrderDeptVo();
					takeOrderDept.setTakeOrderDeptId(repConfigDeptVo.getId());
					takeOrderDept.setTakeOrderDeptName(repConfigDeptVo.getName());
					listBo.add(takeOrderDept);
				}
			}	
		}
		repCofRep.setAllDepts(listBo);
		
		Result<List<RepConfigDeptVo>> result = userPermissionService.getDeptList(null, token);
		if(result != null){
			List<RepConfigDeptVo> deptList = result.getData();
			if(deptList.size()>0){
				//异步更新配置机构信息
				new Thread() {
					@Override
					public void run() {
						for (RepConfigDeptVo dept : deptList) {
							repRepairConfigMapper.updateDept(dept,tenantId);//根据部门id更新同步过来的部门名称
						}
					}
				}.start();
			}
		}
		return repCofRep;
	}

	@Override
	public RepConfiger selectConfiger(Long deptId) {
		return repRepairConfigMapper.selectConfiger(deptId);
	}

	@Override
	public List<RepConfiger> selectUsers() {
		String currentToken = WebSecurityUtils.getCurrentToken();
		List<RepConfiger> list = Lists.newArrayList();
		Result<List<RepUserVo>> result = userPermissionService.getTakeOrderUserList(currentToken);
		if(result != null){
			List<RepUserVo> userList = result.getData();
			if(userList != null && userList.size()>0){
				list=BeanMapper.mapList(userList, RepConfiger.class);
			}
		}
		return list;
	}

	
}
