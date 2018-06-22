package com.aek.ebey.repair.model.vo;

/**
 * 维修概览表
 *
 * @author Honghui
 * @since 2018-04-16
 */
public class RepairDataVo{

	/**
	 * 机构ID
	 */
	private Long tenantId;
	/**
	 * 本年度报修总数（台/次）（累加值）
	 */
	private Long applyTotalNumYear;
	/**
	 * 本年度完修总数（累加值）
	 */
	private Long completeTotalNumYear;
	/**
	 * 年度维修费总额
	 */
	private Double repairTotalCapitalYear;
	/**
	 * 在修设备总数
	 */
	private Long repairAssetsNum;
	
	/**
     * 待修设备总数
     */
	private Long waitRepairAssetsNum;
	
	/**
     * 待接单总数
     */
    private Long waitTakeNum;
    
	/**
     * 待接单比例(百分比)
     */
    private Double waitTakeProportion;
    
    /**
     * 维修中总数
     */
    private Long repairingNum;
    
    /**
     * 维修中比例(百分比)
     */
    private Double repairingProportion;
    
    /**
     * 待验收总数
     */
    private Long waitCheckNum;
    
    /**
     * 待验收比例(百分比)
     */
    private Double waitCheckProportion;
    
    /**
     * 已完成总数
     */
    private Long  completedNum;
    
    /**
     * 已完成比例
     */
    private Double completedProportion;
	
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Long getApplyTotalNumYear() {
		return applyTotalNumYear;
	}

	public void setApplyTotalNumYear(Long applyTotalNumYear) {
		this.applyTotalNumYear = applyTotalNumYear;
	}

	public Long getCompleteTotalNumYear() {
		return completeTotalNumYear;
	}

	public void setCompleteTotalNumYear(Long completeTotalNumYear) {
		this.completeTotalNumYear = completeTotalNumYear;
	}

	public Double getRepairTotalCapitalYear() {
		return repairTotalCapitalYear;
	}

	public void setRepairTotalCapitalYear(Double repairTotalCapitalYear) {
		this.repairTotalCapitalYear = repairTotalCapitalYear;
	}

	public Long getRepairAssetsNum() {
		return repairAssetsNum;
	}

	public void setRepairAssetsNum(Long repairAssetsNum) {
		this.repairAssetsNum = repairAssetsNum;
	}

    public Long getWaitRepairAssetsNum() {
        return waitRepairAssetsNum;
    }

    public void setWaitRepairAssetsNum(Long waitRepairAssetsNum) {
        this.waitRepairAssetsNum = waitRepairAssetsNum;
    }

    public Long getWaitTakeNum() {
        return waitTakeNum;
    }

    public void setWaitTakeNum(Long waitTakeNum) {
        this.waitTakeNum = waitTakeNum;
    }

    public Double getWaitTakeProportion() {
        return waitTakeProportion;
    }

    public void setWaitTakeProportion(Double waitTakeProportion) {
        this.waitTakeProportion = waitTakeProportion;
    }

    public Long getRepairingNum() {
        return repairingNum;
    }

    public void setRepairingNum(Long repairingNum) {
        this.repairingNum = repairingNum;
    }

    public Double getRepairingProportion() {
        return repairingProportion;
    }

    public void setRepairingProportion(Double repairingProportion) {
        this.repairingProportion = repairingProportion;
    }

    public Long getWaitCheckNum() {
        return waitCheckNum;
    }

    public void setWaitCheckNum(Long waitCheckNum) {
        this.waitCheckNum = waitCheckNum;
    }

    public Double getWaitCheckProportion() {
        return waitCheckProportion;
    }

    public void setWaitCheckProportion(Double waitCheckProportion) {
        this.waitCheckProportion = waitCheckProportion;
    }

    public Long getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(Long completedNum) {
        this.completedNum = completedNum;
    }

    public Double getCompletedProportion() {
        return completedProportion;
    }

    public void setCompletedProportion(Double completedProportion) {
        this.completedProportion = completedProportion;
    }

}
