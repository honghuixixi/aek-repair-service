package com.aek.ebey.repair.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.model.RepairDictionary;
import com.aek.ebey.repair.model.RepairDictype;
import com.aek.ebey.repair.service.RepairDictionaryService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * <p>
 *   前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepairDictionaryController", description = "数据字典模块")
@RequestMapping("/newrepair/repairDictionary")
public class RepairDictionaryController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(RepairDictionaryController.class);

	@Autowired
	private RepairDictionaryService repairDictionaryService;
	
	/**
	 * 查询数据类型列表(分页)
	 */

	@GetMapping(value = "/search")
	@ApiOperation(value = "查询数据类型列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false)}) 
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepairDictype>> search(PageHelp<RepairDictype> query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		Page<RepairDictype> page = repairDictionaryService.search(query);
		return response(page);
	}
	
	/**
	 * 根据类型ID查询字典内容
	 */
	@GetMapping(value = "/search/{typeKey}")
	@ApiOperation(value = "根据类型key查询字典内容")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepairDictionary>> searchBytypeid(@PathVariable(value = "typeKey", required = true) String typeKey) {
		logger.debug("<---------------------------------typeKey="+typeKey);
		Map map=new HashMap<String,String>();
		map.put("type_key", typeKey);
		List<RepairDictionary> list = repairDictionaryService.selectByMap(map);
		return response(list);
	}
	
	/**
	 * 根据key查询字典内容
	 */
	@GetMapping(value = "/selectkey/{keyId}")
	@ApiOperation(value = "根据key查询字典内容")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<RepairDictionary> selectkey(@PathVariable(value = "keyId", required = true) Long keyId) {
		logger.debug("<---------------------------------keyId="+keyId);
		Wrapper<RepairDictionary> wrapper = new EntityWrapper<RepairDictionary>();
		wrapper.eq("key_id", keyId);
		return response(repairDictionaryService.selectOne(wrapper));
	}
	
}
