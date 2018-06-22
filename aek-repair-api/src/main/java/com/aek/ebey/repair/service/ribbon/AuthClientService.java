package com.aek.ebey.repair.service.ribbon;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aek.common.core.Result;
import com.aek.ebey.repair.request.WeiXinRepairMessageRequest;

/**
 * 用户远程调用接口value=${feign-auth.serviceId}
 *	
 * @author HongHui
 * @date   2017年12月13日
 */
@FeignClient(value="${feign-auth.serviceId}",fallback = AuthClientHystrix.class)
public interface AuthClientService {

	/**
	 * 发送维修平台消息
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/weixin/send/repair/message")
	public Result<List<Map<String,Object>>> sendWeiXinRepairMessage(@RequestBody WeiXinRepairMessageRequest request,@RequestHeader("X-AEK56-Token") String token);
}