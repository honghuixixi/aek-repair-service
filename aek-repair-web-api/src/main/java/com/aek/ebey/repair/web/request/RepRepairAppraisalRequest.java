package com.aek.ebey.repair.web.request;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepRepairAppraisalRequest", description = "鉴定申请信息")
public class RepRepairAppraisalRequest {
	/**
	 * 申请单ID
	 */
	@ApiModelProperty(value="申请单ID")
	private Long applyId;
	
	/**
	 * 现场解决1是2否
	 */
	@ApiModelProperty(value="现场解决1是2否")
	private Integer sceneFlag;
	/**
	 * 1:内修；2：外修
	 */
	@ApiModelProperty(value="1:内修；2：外修")
	private Integer repairMode;
	/**
	 * 鉴定备注
	 */
	@ApiModelProperty(value="鉴定备注")
	private String identifyComent;
	public Long getApplyId() {
		return applyId;
	}
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	public Integer getSceneFlag() {
		return sceneFlag;
	}
	public void setSceneFlag(Integer sceneFlag) {
		this.sceneFlag = sceneFlag;
	}
	public Integer getRepairMode() {
		return repairMode;
	}
	public void setRepairMode(Integer repairMode) {
		this.repairMode = repairMode;
	}
	public String getIdentifyComent() {
		return identifyComent;
	}
	public void setIdentifyComent(String identifyComent) {
		this.identifyComent = identifyComent;
	}
	@Override
	public String toString() {
		return "RepRepairAppraisalRequest [applyId=" + applyId + ", sceneFlag=" + sceneFlag + ", repairMode="
				+ repairMode + ", identifyComent=" + identifyComent + "]";
	}
	
	

}
