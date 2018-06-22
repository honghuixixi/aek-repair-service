package com.aek.ebey.repair.model;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 消息接收表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@TableName("rep_message_receive")
public class RepMessageReceive extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 关联消息ID
	 */
	@TableField(value="message_id")
	private Long messageId;
	/**
	 * 接收人ID
	 */
	@TableField(value="user_id")
	private Long userId;
	/**
	 * 消息状态；0未查看1已查看
	 */
	@TableField(value="message_status")
	private Integer messageStatus;
	/**
	 * 作废标记，0：启用，1：删除
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;


	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

}
