package com.aek.ebey.repair.model;
import java.util.Date;
import com.aek.common.core.base.BaseModel;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 资产信息表
 * </p>
 *
 * @author aek
 * @since 2017-06-13
 */
@ApiModel(value = "AssetsInfo", description = "设备典信息")
public class AssetsInfo extends BaseModel
{
    

    private static final long serialVersionUID = 1L;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="启用时间")
    private Date startUseDate;
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="出产编号")
    private String factoryNum;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="设备品牌")
    private String assetsBrand;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="设备名称")
    private String assetsName;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="设备编号")
    private String assetsNum;
    
    /**
     * 生产商
     *
     */
    @ApiModelProperty(value="生产商")
    private String factoryName;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="设备规格")
    private String assetsSpec;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="供应商")
    private String splName;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="来源 0：入库新增，1：批量导入")
    private String assetsSourceName;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="状态：1未启用、2正常运行、3计量中、4维修中、5停用中、6已报废、7已报损")
    private String statusName;
    
    /**
	 * 关联类型
	 */
    @ApiModelProperty(value="使用科室")
    private String deptName;
    
    public String getAssetsName()
    {
        return assetsName;
    }

    public void setAssetsName(String assetsName)
    {
        this.assetsName = assetsName;
    }

    public String getAssetsNum()
    {
        return assetsNum;
    }

    public void setAssetsNum(String assetsNum)
    {
        this.assetsNum = assetsNum;
    }

    public String getFactoryName()
    {
        return factoryName;
    }

    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }

    public String getAssetsSpec()
    {
        return assetsSpec;
    }

    public void setAssetsSpec(String assetsSpec)
    {
        this.assetsSpec = assetsSpec;
    }

    public String getSplName()
    {
        return splName;
    }

    public void setSplName(String splName)
    {
        this.splName = splName;
    }

    public String getAssetsSourceName()
    {
        return assetsSourceName;
    }

    public void setAssetsSourceName(String assetsSourceName)
    {
        this.assetsSourceName = assetsSourceName;
    }

    public String getStatusName()
    {
        return statusName;
    }

    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public Date getStartUseDate()
    {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate)
    {
        this.startUseDate = startUseDate;
    }

    public String getFactoryNum()
    {
        return factoryNum;
    }

    public void setFactoryNum(String factoryNum)
    {
        this.factoryNum = factoryNum;
    }

    public String getAssetsBrand()
    {
        return assetsBrand;
    }

    public void setAssetsBrand(String assetsBrand)
    {
        this.assetsBrand = assetsBrand;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

	@Override
	public String toString() {
		return "AssetsInfo [startUseDate=" + startUseDate + ", factoryNum=" + factoryNum + ", assetsBrand="
				+ assetsBrand + ", assetsName=" + assetsName + ", assetsNum=" + assetsNum + ", factoryName="
				+ factoryName + ", assetsSpec=" + assetsSpec + ", splName=" + splName + ", assetsSourceName="
				+ assetsSourceName + ", statusName=" + statusName + ", deptName=" + deptName + "]";
	}
    
}
