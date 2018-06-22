package com.aek.ebey.repair.query;
import com.aek.common.core.base.page.PageHelp;
import com.aek.ebey.repair.request.MessageResponse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "RepMessageReceiveQuery", description = "消息信息查询query")
public class RepMessageReceiveQuery extends PageHelp<MessageResponse> {
	/**
	 * 消息状态；0未查看1已查看
	 */
	@ApiModelProperty(value="消息状态；0未查看1已查看")
	private Integer messageStatus;
	
	public Integer getMessageStatus() {
		return messageStatus;
	}
	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}
	
}
