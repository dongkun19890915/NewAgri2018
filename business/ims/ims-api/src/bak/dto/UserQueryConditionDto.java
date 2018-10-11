package com.sinosoft.ims.api.kernel.dto;

import com.sinosoft.framework.dto.BasePageableRequest;

/**
 * @description 用户查询条件对象
 * @author chengzhuo
 * @data 2016/9/14 16:30
 *
 */
public class UserQueryConditionDto extends BasePageableRequest implements java.io.Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**登陆账号*/
	private String userCode;
	/**业务人员姓名*/
	private String salesManName;
	/**所属省级机构*/
	private String proviceComCode;
	/**所属分支机构*/
	private String cityComCode;
	/**所属总公司*/
	private String headComCode;
	/**所属机构*/
	private String comCode;
	
	private String validStatus;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSalesManName() {
		return salesManName;
	}

	public void setSalesManName(String salesManName) {
		this.salesManName = salesManName;
	}

	public String getProviceComCode() {
		return proviceComCode;
	}

	public void setProviceComCode(String proviceComCode) {
		this.proviceComCode = proviceComCode;
	}

	public String getCityComCode() {
		return cityComCode;
	}

	public void setCityComCode(String cityComCode) {
		this.cityComCode = cityComCode;
	}

	public String getHeadComCode() {
		return headComCode;
	}

	public void setHeadComCode(String headComCode) {
		this.headComCode = headComCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

    public String getValidStatus()
    {
        return validStatus;
    }

    public void setValidStatus(String validStatus)
    {
        this.validStatus = validStatus;
    }
	
	

}
