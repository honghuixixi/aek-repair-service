package com.aek.ebey.repair.request;
import com.aek.ebey.repair.model.RepRepairMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "MessageResponse", description = "消息信息")
public class MessageResponse extends RepRepairMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 接收人ID
	 */
	@ApiModelProperty(value="接收人ID")
	private Long userId;
	/**
	 * 消息状态；0未查看1已查看
	 */
	@ApiModelProperty(value="消息状态；0未查看1已查看")
	private Integer messageStatus;
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
	@Override
	public String toString() {
		return "MessageResponse [userId=" + userId + ", messageStatus=" + messageStatus + "]";
	}
	
	

}
