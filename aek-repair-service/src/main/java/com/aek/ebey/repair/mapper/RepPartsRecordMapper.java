package com.aek.ebey.repair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepPartsRecord;
import com.aek.ebey.repair.query.RepPartsRecordQuery;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepPartsRecordMapper extends BaseMapper<RepPartsRecord> {

	List<RepPartsRecord> search(Page<RepPartsRecord> page, @Param("query")RepPartsRecordQuery query,@Param("user")AuthUser authUser);

}