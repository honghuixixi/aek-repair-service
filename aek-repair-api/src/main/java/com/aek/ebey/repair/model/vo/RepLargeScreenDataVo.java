package com.aek.ebey.repair.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 维修大屏统计数据
 *	
 * @author HongHui
 * @date   2018年4月17日
 */
public class RepLargeScreenDataVo implements Serializable{

    private static final long serialVersionUID = -5331529467131905703L;

    //待接单总数
    private Long waitTakeNum;
    //维修中总数
    private Long repairingNum;
    //待验收总数
    private Long waitCheckNum;
    //工程师数
    private Integer engineerNum;
    //本周保修数
    private Long currentWeekApplyNum;
    //本周完修数
    private Long currentWeekCompleteNum;
    //本月保修数
    private Long currentMonthApplyNum;
    //本月完修数
    private Long currentMonthCompleteNum;
    //维修申请单集合
    private List<RepRepairApplyVo> repairApplyList;
    
    public Long getWaitTakeNum() {
        return waitTakeNum;
    }
    public void setWaitTakeNum(Long waitTakeNum) {
        this.waitTakeNum = waitTakeNum;
    }
    public Long getRepairingNum() {
        return repairingNum;
    }
    public void setRepairingNum(Long repairingNum) {
        this.repairingNum = repairingNum;
    }
    public Long getWaitCheckNum() {
        return waitCheckNum;
    }
    public void setWaitCheckNum(Long waitCheckNum) {
        this.waitCheckNum = waitCheckNum;
    }
    public Integer getEngineerNum() {
        return engineerNum;
    }
    public void setEngineerNum(Integer engineerNum) {
        this.engineerNum = engineerNum;
    }
    public Long getCurrentWeekApplyNum() {
        return currentWeekApplyNum;
    }
    public void setCurrentWeekApplyNum(Long currentWeekApplyNum) {
        this.currentWeekApplyNum = currentWeekApplyNum;
    }
    public Long getCurrentWeekCompleteNum() {
        return currentWeekCompleteNum;
    }
    public void setCurrentWeekCompleteNum(Long currentWeekCompleteNum) {
        this.currentWeekCompleteNum = currentWeekCompleteNum;
    }
    public Long getCurrentMonthApplyNum() {
        return currentMonthApplyNum;
    }
    public void setCurrentMonthApplyNum(Long currentMonthApplyNum) {
        this.currentMonthApplyNum = currentMonthApplyNum;
    }
    public Long getCurrentMonthCompleteNum() {
        return currentMonthCompleteNum;
    }
    public void setCurrentMonthCompleteNum(Long currentMonthCompleteNum) {
        this.currentMonthCompleteNum = currentMonthCompleteNum;
    }
    public List<RepRepairApplyVo> getRepairApplyList() {
        return repairApplyList;
    }
    public void setRepairApplyList(List<RepRepairApplyVo> repairApplyList) {
        this.repairApplyList = repairApplyList;
    }
    
}
