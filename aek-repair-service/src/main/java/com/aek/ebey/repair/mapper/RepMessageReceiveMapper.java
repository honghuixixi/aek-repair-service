package com.aek.ebey.repair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aek.common.core.base.BaseMapper;
import com.aek.common.core.serurity.model.AuthUser;
import com.aek.ebey.repair.model.RepMessageReceive;
import com.aek.ebey.repair.query.RepMessageReceiveQuery;
import com.aek.ebey.repair.request.MessageResponse;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
public interface RepMessageReceiveMapper extends BaseMapper<RepMessageReceive> {
	
	List<MessageResponse> selectMyPage( Page<MessageResponse> page,@Param("q") RepMessageReceiveQuery query, @Param("user") AuthUser authUser);

	int updateByStatus( @Param("userId") Long userId);

	List<MessageResponse> selectMyPageX( Page<MessageResponse> page,@Param("q") RepMessageReceiveQuery query, @Param("user") AuthUser authUser);

}