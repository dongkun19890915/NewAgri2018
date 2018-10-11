package com.sinosoft.agriclaim.core.jobmanage.entity;

import com.sinosoft.framework.core.dao.BasePKImpl;
import javax.persistence.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 班表管理从表主键操作对象
 */
public class PrpLJobManagerTimeKey extends BasePKImpl{
	private static final long serialVersionUID = 1L;
	public PrpLJobManagerTimeKey(){}
	public PrpLJobManagerTimeKey(String fid){
		this.fid = fid;
	}
	/** 属性外键，保存主表的主键/外键，保存主表的主键 */
	@Column(name = "fid")
	private String fid ;

	private String dateType ;
	/** 属性具体日期/具体日期 */
	private String time  ;

	/**
	 * 属性外键，保存主表的主键/外键，保存主表的主键的getter方法
	 */
	public String getFid() {
    		return fid;
	}
	/**
	 * 属性外键，保存主表的主键/外键，保存主表的主键的setter方法
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}