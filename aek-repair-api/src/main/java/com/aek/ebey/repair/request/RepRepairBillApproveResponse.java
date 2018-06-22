package com.aek.ebey.repair.request;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 维修单据实体类
 *	
 * @author HongHui
 * @date   2018年1月26日
 */
@ApiModel(value = "RepRepairBillApproveResponse", description = "审批单据")
public class RepRepairBillApproveResponse{

	/**
	 * 维修单据ID
	 */
	@ApiModelProperty(value="维修单据ID")
	private Long id;
    
	/**
	 * 单据编号
	 */
    @ApiModelProperty(value="单据编号")
	private String billNo;
    
    /**
   	 * 维修申请单ID
   	 */
    @ApiModelProperty(value="维修申请单ID")
   	private Long applyId;
       
       /**
      	 * 维修单号
      	 */
     @ApiModelProperty(value="维修单号")
     private String applyNo;

    /**
	 * 单据类型(1=外修费用,2=配件采购)
	 */
    @ApiModelProperty(value="单据类型(1=外修费用,2=配件采购)")
	private Integer type;
    
    /**
     * 单据类型文本(1=外修费用,2=配件采购)
     */
    @ApiModelProperty(value="单据类型文本(1=外修费用,2=配件采购)")
    private String typeText;
    
    /**
	 * 状态(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态(1=审批中，2=审批通过，3=审批未通过)")
	private Integer status;
    
    /**
	 * 状态文本(1=审批中，2=审批通过，3=审批未通过，4=已撤销)
	 */
    @ApiModelProperty(value="状态文本(1=审批中，2=审批通过，3=审批未通过)")
	private String statusText;
    
   
    
    /**
   	 * 维修设备名称
   	 */
    @ApiModelProperty(value="维修设备名称")
    private String assetsName;
    
    /**
   	 * 设备使用科室名称
   	 */
    @ApiModelProperty(value="设备使用科室名称")
    private String assetsDeptName;
    
    /**
   	 * 申请人ID
   	 */
    @ApiModelProperty(value="申请人ID")
    private Long applyUserId;
    
    /**
  	 * 申请人姓名
  	 */
    @ApiModelProperty(value="申请人姓名")
    private String applyUserName;
    
    /**
   	 * 申请时间
   	 */
    @ApiModelProperty(value="申请时间")
    private Date applyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}

	public Long getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(Long applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
   
   
}

