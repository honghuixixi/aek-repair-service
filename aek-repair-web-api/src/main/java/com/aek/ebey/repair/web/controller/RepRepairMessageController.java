package com.aek.ebey.repair.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.repair.request.SendMessage;
import com.aek.ebey.repair.service.RepRepairMessageService;
import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 * 消息表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@RequestMapping("/newrepair/repRepairMessage")
public class RepRepairMessageController extends BaseController {
	
private static final Logger logger = LoggerFactory.getLogger(RepRepairMessageController.class);
	
	@Autowired
	private RepRepairMessageService repRepairMessageService;
	
	
	/**
	 * 新建消息
	 * 
	 */
	@PostMapping("/send")
	@ApiOperation(value = "新建消息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> send(@RequestBody SendMessage sendMessage){
		logger.debug("<---------------------------------" + JSON.toJSONString(sendMessage));
		repRepairMessageService.save(sendMessage);
		return response();
		
	}
	
	

	/**
	 * 新建消息
	 * 
	 */
	@GetMapping("/save")
	@ApiOperation(value = "新建消息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Object> save(@RequestParam("messageContent") String messageContent,
		      @RequestParam("moduleId") Long moduleId,
		      @RequestParam("remarks") String remarks,
		      @RequestParam("userId") Long userId,
		      @RequestParam("status")Integer status){
		 SendMessage sendMessage =new SendMessage();
		 sendMessage.setMessageContent(messageContent);
		 sendMessage.setModuleId(moduleId);
		 sendMessage.setRemarks(remarks);
		 sendMessage.setStatus(status);
		 sendMessage.setUserId(userId);
		repRepairMessageService.save(sendMessage);
		return response();
		
	}
	
}
