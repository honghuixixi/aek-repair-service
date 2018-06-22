package com.aek.ebey.repair.service;

import com.aek.common.core.base.BaseService;
import com.aek.ebey.repair.model.RepRepairReport;
import com.aek.ebey.repair.request.RepRepairReportDetails;
import com.aek.ebey.repair.request.RepRepairReportResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepRepairReportService extends BaseService<RepRepairReport> {

	Boolean save(RepRepairReport data);

	RepRepairReportResponse searchResponse(Long id);

	RepRepairReportDetails search(Long id);
	
}
