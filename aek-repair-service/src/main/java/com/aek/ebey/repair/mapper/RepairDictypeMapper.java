package com.aek.ebey.repair.mapper;

import com.aek.common.core.base.BaseMapper;
import com.aek.ebey.repair.model.RepairDictype;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepairDictypeMapper extends BaseMapper<RepairDictype> {

	String getValue(String ketId);

}