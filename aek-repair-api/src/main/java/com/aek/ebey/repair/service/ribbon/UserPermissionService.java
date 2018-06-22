package com.aek.ebey.repair.service.ribbon;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aek.common.core.Result;
import com.aek.ebey.repair.model.vo.RepConfigDeptVo;
import com.aek.ebey.repair.model.vo.RepUserVo;

@FeignClient(value="${feign-sys.serviceId}",fallback = UserPermissionHystrix.class)
public interface UserPermissionService {
	  @RequestMapping(method = RequestMethod.GET,value = "/sys/invoke/user/tenant/{tenantId}/permission/{permissionCode}")
	    public Result<List<Long>> findByTenantAndCanPermiss(
				@PathVariable(value = "tenantId", required = true) String tenantId,
				@PathVariable(value = "permissionCode", required = true) String permissionCode,@RequestHeader("X-AEK56-Token") String token) ;
	  /**
	   * 根据部门id查询子部门集合
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/dept/{deptId}/sub")
	  public Result<String> findAllSubDeptById(@PathVariable(value = "deptId", required = true) Long deptId,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 校验是否有维修权限和是否停用
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsRep")
	  public Result<Integer> checkIsRep(@RequestParam(value = "id", required = true) Long id,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 校验是否有审批单据权限和是否停用
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsRepBill")
	  public Result<Integer> checkIsRepBill(@RequestParam(value = "id", required = true) Long id,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 校验是否有接单权限和是否停用
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsRepHelp")
	  public Result<Integer> checkIsRepHelp(@RequestParam(value = "id", required = true) Long id,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 根据机构Id获取本机构具有接单权限的用户列表
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/getTakeOrderUserList")
	  public Result<List<RepUserVo>> getTakeOrderUserList(@RequestHeader("X-AEK56-Token") String token);
	  
	  /**
       * 根据机构Id获取本机构具有维修权限的用户列表
       * @param token
       * @return
       */
      @RequestMapping(method = RequestMethod.GET, value = "/sys/user/getRepairUserList")
      public Result<List<RepUserVo>> getRepairUserList(@RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 查询机构里启用未删除的部门
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/dept/getDeptList")
	  public Result<List<RepConfigDeptVo>> getDeptList(@RequestParam(value = "keyword", required = false) String keyword,@RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 查询机构里启用未删除的部门
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/dept/getAllDeptList")
	  public Result<List<RepConfigDeptVo>> getAllDeptList(@RequestParam(value = "keyword", required = false) String keyword,@RequestHeader("X-AEK56-Token") String token);
	 
	  /**
	   * 查询用户信息
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/invoke/user/getUser")
	  public Result<RepUserVo> getUser(@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "tenantId", required = true) Long tenantId,@RequestHeader("X-AEK56-Token") String token);

	  /**
	   * 校验用户是否具有审核报损单权限
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsDiscard")
	  public Result<Boolean> checkIsDiscard(@RequestParam(value = "id", required = true) Long id,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 校验用户是否具有审核转科单权限
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsTransfer")
	  public Result<Boolean> checkIsTransfer(@RequestParam(value = "id", required = true) Long id,
	      @RequestHeader("X-AEK56-Token") String token);
	  
	  /**
	   * 校验用户是否具有审核转科单权限
	   * @param id
	   * @param token
	   * @return
	   */
	  @RequestMapping(method = RequestMethod.GET, value = "/sys/user/checkIsRht")
	  public Result<Boolean> checkIsRht(@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "rht", required = true) String rht,
	      @RequestHeader("X-AEK56-Token") String token);

}
