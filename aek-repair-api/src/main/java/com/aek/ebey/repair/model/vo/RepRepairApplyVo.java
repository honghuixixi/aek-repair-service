package com.aek.ebey.repair.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 维修大屏维修单数据
 *  
 * @author HongHui
 * @date   2018年4月17日
 */
public class RepRepairApplyVo implements Serializable{

    private static final long serialVersionUID = 4207934121299620206L;
    
    //申请时间
    private Date reportRepairDate;
    //设备所在科室
    private String assetsDeptName;
    //设备编号
    private String assetsNum; 
    //设备名称
    private String assetsName;
    //状态，1:待接单、2:维修中、3:待验收、4:已完成
    private Integer status;
    //状态
    private String statusText;
    //接单人姓名（工程师）
    private String takeOrderName;
    
    public Date getReportRepairDate() {
        return reportRepairDate;
    }
    public void setReportRepairDate(Date reportRepairDate) {
        this.reportRepairDate = reportRepairDate;
    }
    public String getAssetsDeptName() {
        return assetsDeptName;
    }
    public void setAssetsDeptName(String assetsDeptName) {
        this.assetsDeptName = assetsDeptName;
    }
    public String getAssetsNum() {
        return assetsNum;
    }
    public void setAssetsNum(String assetsNum) {
        this.assetsNum = assetsNum;
    }
    public String getAssetsName() {
        return assetsName;
    }
    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTakeOrderName() {
        return takeOrderName;
    }
    public void setTakeOrderName(String takeOrderName) {
        this.takeOrderName = takeOrderName;
    }
    public String getStatusText() {
        return statusText;
    }
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
    
}
