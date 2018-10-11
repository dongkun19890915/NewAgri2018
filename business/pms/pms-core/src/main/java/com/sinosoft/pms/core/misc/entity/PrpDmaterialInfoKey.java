package com.sinosoft.pms.core.misc.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-09-15 09:15:28.416 
 * 参考资料信息表主键操作对象
 */
public class PrpDmaterialInfoKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpDmaterialInfoKey(){}
	public PrpDmaterialInfoKey(String materialId){
		this.materialId = materialId;
	}
	/** 属性资料编号/资料编号 */
	private String materialId ;
	/**
	 * 属性资料编号/资料编号的getter方法
	 */
	public String getMaterialId() {
    		return materialId;
	}
	/**
	 * 属性资料编号/资料编号的setter方法
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	} 
}