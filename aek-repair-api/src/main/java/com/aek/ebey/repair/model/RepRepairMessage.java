package com.aek.ebey.repair.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@TableName("rep_repair_message")
public class RepRepairMessage extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * ID主键
	 */
	private Long id;
	/**
	 * 关联维修申请id
	 */
	@TableField(value="module_id")
	private Long moduleId;
	/**
	 * 消息内容
	 */
	@TableField(value="message_content")
	private String messageContent;
	/**
	 * 消息时间
	 */
	@TableField(value="message_time")
	private Date messageTime=new Date();
	/**
	 * 验收人科室
	 */
	@TableField(value="remarks")
	private String remarks;
	/**
	 * 作废标记，0：启用，1：删除
	 */
	@TableField(value="del_flag")
	private Boolean delFlag;
	
	
	@TableField(value="status")
	private Integer status;
	
	@TableField(exist=false)
	private String url;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
