package com.sinosoft.agriprpall.core.paymanage.entity;

import com.sinosoft.framework.core.dao.BaseEntityImpl;
import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-20 08:18:36.753 
 * 承保支付信息子表实体操作对象
 */
@Entity
@Table(name = "PrpPaySub")
@IdClass(PrpPaySubKey.class)
public class PrpPaySub extends BaseEntityImpl{

	private static final long serialVersionUID = 1L;
	/** 属性支付号/支付号 */
	@Id
	@Column(name = "payNo")
	private String payNo ;
	/** 属性批单号/批单号 */
	@Id
	@Column(name = "endorseNo")
	private String endorseNo ;	

	/** 属性支付类型/支付类型 */
	@Column(name = "payType")
	private String payType ;

	/** 费用类型 */
	@Id
	@Column(name = "costType")
	private String costType;

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}
}