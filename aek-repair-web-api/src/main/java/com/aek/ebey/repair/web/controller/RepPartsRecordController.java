package com.aek.ebey.repair.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.Result;
import com.aek.common.core.base.BaseController;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.query.RepPartsRecordQuery;
import com.aek.ebey.repair.request.RepPartsRecordResponse;
import com.aek.ebey.repair.service.RepPartsRecordService;
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
 * 配件操作记录表  前端控制器
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@RestController
@Api(value = "RepPartsRecordController", description = "配件操作记录")
@RequestMapping("/newrepair/repPartsRecord")
public class RepPartsRecordController extends BaseController {
private static final Logger logger = LoggerFactory.getLogger(RepPartsRecordController.class);
	
	@Autowired
	private RepPartsRecordService repPartsRecordService;
	
	
	/**
	 * 根据申请单id搜索配件信息
	 */
	// @PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/search/{id}")
	@ApiOperation(value = "根据申请单id搜索配件信息")
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<List<RepPartsRecord>> search(@PathVariable(value = "id", required = true) Long id) {
		logger.debug("<---------------------------------id="+id);
		Wrapper<RepPartsRecord> wrapper = new EntityWrapper<RepPartsRecord>();
		wrapper.eq("report_id", id);
		wrapper.eq("del_flag", 0);
		List<RepPartsRecord> list = repPartsRecordService.selectList(wrapper);
		if (!CollectionUtils.isEmpty(list)) {
			return response(list);
		}
		return response(null);
	}
	
	/**
	 * 查询操作记录列表(分页)
	 */
	@GetMapping(value = "/search")
	@ApiOperation(value = "配件操作记录列表(分页)", httpMethod = "GET", produces = "application/json")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNo", value = "起始页 [默认1]", paramType = "query", required = false),
			@ApiImplicitParam(name = "pageSize", value = "分页大小[默认10]", paramType = "query", required = false),
			@ApiImplicitParam(name = "status", value = "操作类型（1入库 2 出库）", paramType = "query", required = false),
			@ApiImplicitParam(name = "partName", value = "配件名称", paramType = "query", required = false),
			@ApiImplicitParam(name = "orderByField", value = "排序列(operation_time)", paramType = "query", required = false),
			@ApiImplicitParam(name = "isAsc", value = "true,false", paramType = "query", required = false)})
	@ApiResponse(code = 200, message = "OK", response = Result.class)
	public Result<Page<RepPartsRecord>> search(RepPartsRecordQuery query) {
		logger.debug("<---------------------------------"+JSON.toJSONString(query));
		Page<RepPartsRecord> page = repPartsRecordService.search(query.getPage(),query);
		return response(page);
	}
	
}
