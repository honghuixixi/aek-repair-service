package com.aek.ebey.repair.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 转单表
 * </p>
 *
 * @author aek
 * @since 2018-01-11
 */
@TableName("rep_turn_orders")
public class RepTurnOrders extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 关联维修单id
	 */
	@TableField(value="apply_id")
	private Long applyId;
	/**
	 * 转单人id
	 */
	@TableField(value="from_id")
	private Long fromId;
	/**
	 * 转单人姓名
	 */
	@TableField(value="from_name")
	private String fromName;
	/**
	 * 接单人id
	 */
	@TableField(value="to_id")
	private Long toId;
	/**
	 * 接单人姓名
	 */
	@TableField(value="to_name")
	private String toName;
	/**
	 * 转单时间
	 */
	@TableField(value="turn_time")
	private Date turnTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public Date getTurnTime() {
		return turnTime;
	}

	public void setTurnTime(Date turnTime) {
		this.turnTime = turnTime;
	}

}
