package com.aek.ebey.repair.model;

import java.util.Date;

import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 设备维修申请表
 * </p>
 *
 * @author aek
 * @since 2017-08-30
 */
@ApiModel(value = "RepRepairApply", description = "维修申请信息")
@TableName("rep_repair_apply")
public class RepRepairApply extends BaseModel {

    private static final long serialVersionUID = 1L;

	/**
	 * 机构ID
	 */
    @ApiModelProperty(value="机构ID")
	@TableField(value="tenant_id")
	private Long tenantId;
	/**
	 * 维修申请单号
	 */
    @ApiModelProperty(value="维修申请单号")
	@TableField(value="apply_no")
	private String applyNo;
	/**
	 * 关联设备ID
	 */
    @ApiModelProperty(value="关联设备ID")
	@TableField(value="assets_id")
	private Long assetsId;
	/**
	 * 设备使用部门id
	 */
    @ApiModelProperty(value="设备使用部门id")
	@TableField(value="assets_dept_id")
	private Long assetsDeptId;
	
	/**
	 * 用户所在部门id
	 */
    @ApiModelProperty(value="用户所在部门id")
	@TableField(value="dept_id")
	private Long deptId;
	
	/**
	 * 用户所在部门名称
	 */
    @ApiModelProperty(value="用户所在部门名称")
	@TableField(value="dept_name")
	private String deptName;
	/**
	 * 设备使用科室名称
	 */
    @ApiModelProperty(value="设备使用科室名称")
	@TableField(value="assets_dept_name")
	private String assetsDeptName;
	/**
	 * 设备规格型号
	 */
    @ApiModelProperty(value="设备规格型号")
	@TableField(value="assets_spec")
	private String assetsSpec;
	/**
	 * 生产商
	 */
    @ApiModelProperty(value="生产商")
	@TableField(value="factory_name")
	private String factoryName;
	/**
	 * 设备名称
	 */
    @ApiModelProperty(value="设备名称")
	@TableField(value="assets_name")
	private String assetsName;
	/**
	 * 设备品牌
	 */
    @ApiModelProperty(value="设备品牌")
	@TableField(value="assets_brand")
	private String assetsBrand;
	/**
	 * 资产编号
	 */
    @ApiModelProperty(value="资产编号")
	@TableField(value="assets_num")
	private String assetsNum;
	/**
	 * 出厂编号
	 */
    @ApiModelProperty(value="出厂编号")
	@TableField(value="factory_num")
	private String factoryNum;
	/**
	 * 启用日期
	 */
    @ApiModelProperty(value="启用日期")
	@TableField(value="start_use_date")
	private Date startUseDate;
	/**
	 * 保修日期
	 */
    @ApiModelProperty(value="保修日期")
	@TableField(value="warranty_date")
	private Date warrantyDate;
	/**
	 * 故障现象
	 */
    @ApiModelProperty(value="故障现象")
	@TableField(value="fault_desc")
	private String faultDesc;
	/**
	 * 设备图片路径，多图以，分割
	 */
    @ApiModelProperty(value="设备图片路径，多图以，分割")
	@TableField(value="assets_img")
	private String assetsImg;
	/**
	 * 状态，1:待接单、2:维修中、3:待验收、4:已完成
	 */
    @ApiModelProperty(value="状态，1:待接单、2:维修中、3:待验收、4:已完成")
	private Integer status;
	/**
	 * 申请人ID
	 */
    @ApiModelProperty(value="申请人ID")
	@TableField(value="report_repair_id")
	private Long reportRepairId;
	/**
	 * 申请人姓名
	 */
    @ApiModelProperty(value="申请人姓名")
	@TableField(value="report_repair_name")
	private String reportRepairName;
	/**
	 * 申请人联系电话
	 */
    @ApiModelProperty(value="申请人联系电话")
	@TableField(value="report_repair_phone")
	private String reportRepairPhone;
	/**
	 * 报修申请时间
	 */
    @ApiModelProperty(value="报修申请时间")
	@TableField(value="report_repair_date")
	private Date reportRepairDate=new Date();
	/**
	 * 设备原先状态
	 */
    @ApiModelProperty(value="设备原先状态")
	@TableField(value="assets_status")
	private Integer assetsStatus;
	/**
	 * 作废标记，0：启用，1：删除
	 */
    @ApiModelProperty(value="作废标记，0：启用，1：删除")
	@TableField(value="del_flag")
	private Boolean delFlag;
    
    /**
	 * 报修申请状态（1，送修  2，现场维修）
	 */
    @ApiModelProperty(value="报修申请状态（1，送修  2，现场维修）")
	@TableField(value="report_status")
	private Integer reportStatus;
    
    /**
	 * 资产描述（1，固定资产 2，非固定资产）
	 */
    @ApiModelProperty(value="资产描述（1，固定资产 2，非固定资产）")
	@TableField(value="assets_desc")
	private Integer assetsDesc;
    
    
    /**
	 * 设备所在位置
	 */
    @ApiModelProperty(value="设备所在位置")
	@TableField(value="assets_local")
	private String assetsLocal;
    
    /**
	 * 院内编码
	 */
    @ApiModelProperty(value="院内编码")
	@TableField(value="serial_num")
	private String serialNum;
    
    /**
	 * 附件
	 */
    @ApiModelProperty(value="附件")
	@TableField(value="assets_file")
	private String assetsFile;
    
    /**
   	 * 转单次数
   	 */
    @ApiModelProperty(value="转单次数")
   	@TableField(value="turn_num")
   	private Integer turnNum;
    
    /**
   	 *送修人
   	 */
    @ApiModelProperty(value="送修人")
   	@TableField(value="send_person")
   	private String sendPerson;
    
    /**
   	 *送修电话
   	 */
    @ApiModelProperty(value="送修电话")
   	@TableField(value="send_phone")
   	private String sendPhone;
    
    /**
	 * 接单人ID
	 */
    @ApiModelProperty(value="接单人ID")
	@TableField(value="take_order_id")
	private Long takeOrderId;
	/**
	 * 接单人姓名
	 */
    @ApiModelProperty(value="接单人姓名")
	@TableField(value="take_order_name")
	private String takeOrderName;
    
    /**
	 * 七天完修（1，是 2，否）
	 */
    @ApiModelProperty(value="七天完修（1，是 2，否）")
	@TableField(value="seven_status")
	private Integer sevenStatus;
    
    /**
	 * 当前登陆人是否可以接单
	 */
    @ApiModelProperty(value="当前登陆人是否可以接单")
	@TableField(exist=false)
	private Boolean flag=false;
    
    
    

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public Long getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(Long assetsId) {
		this.assetsId = assetsId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getAssetsDeptName() {
		return assetsDeptName;
	}

	public void setAssetsDeptName(String assetsDeptName) {
		this.assetsDeptName = assetsDeptName;
	}

	public String getAssetsSpec() {
		return assetsSpec;
	}

	public void setAssetsSpec(String assetsSpec) {
		this.assetsSpec = assetsSpec;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getAssetsBrand() {
		return assetsBrand;
	}

	public void setAssetsBrand(String assetsBrand) {
		this.assetsBrand = assetsBrand;
	}

	public String getAssetsNum() {
		return assetsNum;
	}

	public void setAssetsNum(String assetsNum) {
		this.assetsNum = assetsNum;
	}

	public String getFactoryNum() {
		return factoryNum;
	}

	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}

	public Date getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}

	public Date getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(Date warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public String getFaultDesc() {
		return faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getAssetsImg() {
		return assetsImg;
	}

	public void setAssetsImg(String assetsImg) {
		this.assetsImg = assetsImg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getReportRepairId() {
		return reportRepairId;
	}

	public void setReportRepairId(Long reportRepairId) {
		this.reportRepairId = reportRepairId;
	}

	public String getReportRepairName() {
		return reportRepairName;
	}

	public void setReportRepairName(String reportRepairName) {
		this.reportRepairName = reportRepairName;
	}

	public String getReportRepairPhone() {
		return reportRepairPhone;
	}

	public void setReportRepairPhone(String reportRepairPhone) {
		this.reportRepairPhone = reportRepairPhone;
	}

	public Date getReportRepairDate() {
		return reportRepairDate;
	}

	public void setReportRepairDate(Date reportRepairDate) {
		this.reportRepairDate = reportRepairDate;
	}

	public Integer getAssetsStatus() {
		return assetsStatus;
	}

	public void setAssetsStatus(Integer assetsStatus) {
		this.assetsStatus = assetsStatus;
	}

	public Boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Long getAssetsDeptId() {
		return assetsDeptId;
	}

	public void setAssetsDeptId(Long assetsDeptId) {
		this.assetsDeptId = assetsDeptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

	public Integer getAssetsDesc() {
		return assetsDesc;
	}

	public void setAssetsDesc(Integer assetsDesc) {
		this.assetsDesc = assetsDesc;
	}

	public String getAssetsLocal() {
		return assetsLocal;
	}

	public void setAssetsLocal(String assetsLocal) {
		this.assetsLocal = assetsLocal;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getAssetsFile() {
		return assetsFile;
	}

	public void setAssetsFile(String assetsFile) {
		this.assetsFile = assetsFile;
	}

	public Integer getTurnNum() {
		return turnNum;
	}

	public void setTurnNum(Integer turnNum) {
		this.turnNum = turnNum;
	}

	public String getSendPerson() {
		return sendPerson;
	}

	public void setSendPerson(String sendPerson) {
		this.sendPerson = sendPerson;
	}

	public String getSendPhone() {
		return sendPhone;
	}

	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public Long getTakeOrderId() {
		return takeOrderId;
	}

	public void setTakeOrderId(Long takeOrderId) {
		this.takeOrderId = takeOrderId;
	}

	public String getTakeOrderName() {
		return takeOrderName;
	}

	public void setTakeOrderName(String takeOrderName) {
		this.takeOrderName = takeOrderName;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Integer getSevenStatus() {
		return sevenStatus;
	}

	public void setSevenStatus(Integer sevenStatus) {
		this.sevenStatus = sevenStatus;
	}
	
}
