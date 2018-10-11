package com.sinosoft.agriclaim.api.jobmanage.dto;

import java.io.Serializable;

import com.sinosoft.framework.dto.BaseRequest;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 07:22:28.842 
 * 员工代码表Api操作对象
 */
public class PrpDUserDto extends BaseRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性员工代码/员工代码 */
	private String userCode  ;		
	/** 属性员工名称/员工名称 */
	private String userName ;		
	/** 属性属性（usereName）/属性（usereName） */
	private String usereName  ;		
	/** 属性密码/密码 */
	private String passWord ;		
	/** 属性印鉴/印鉴 */
	private String seal                  ;		
	/** 属性属性（passWordSetDate）/属性（passWordSetDate） */
	private java.util.Date passWordSetDate        ;		
	/** 属性属性（passWordExpireDate）/属性（passWordExpireDate） */
	private java.util.Date passWordExpireDate      ;		
	/** 属性归属机构代码/归属机构代码 */
	private String comCode                 ;		
	/** 属性出单机构代码/出单机构代码 */
	private String makeCom                 ;		
	/** 属性属性（accountCode ）/属性（accountCode ） */
	private String accountCode            ;		
	/** 属性电话号码/电话号码 */
	private String phone                  ;		
	/** 属性手机号码/手机号码 */
	private String mobile                 ;		
	/** 属性通信地址/通信地址 */
	private String address               ;		
	/** 属性邮政编码/邮政编码 */
	private String postCode               ;		
	/** 属性邮箱/邮箱 */
	private String email                  ;		
	/** 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员 */
	private String userFlag               ;		
	/** 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统 */
	private String loginSystem            ;		
	/** 属性最新员工代码/最新员工代码 */
	private String newUserCode             ;		
	/** 属性效力状态(0失效/1有效)/效力状态(0失效/1有效) */
	private String validStatus            ;		
	/** 属性专项代码(对应会计科目)/专项代码(对应会计科目) */
	private String articleCode            ;		
	/** 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注) */
	private String flag                   ;		
	/** 属性属性（underWritingAuthority）/属性（underWritingAuthority） */
	private String underWritingAuthority  ;		
	/** 属性终端号/终端号 */
	private String posterMinalNo          ;		
	/** 属性属性（salesFlag ）/属性（salesFlag ） */
	private String salesFlag              ;		
	/** 属性属性（clockStatus）/属性（clockStatus） */
	private String clockStatus            ;		
	/** 属性属性（issales ）/属性（issales ） */
	private String isSales                ;		
	/** 属性属性（locked）/属性（locked） */
	private Integer locked                ;
	/** 属性属性（maxOverDueCount）/属性（maxOverDueCount） */
	private Integer maxOverDueCount        ;
	/** 属性属性（maxOverDueFee ）/属性（maxOverDueFee ） */
	private Double maxOverDueFee          ;
	/** 属性属性（userLevel）/属性（userLevel） */
	private String userLevel              ;		
	/** 属性属性（userNature）/属性（userNature） */
	private String userNature             ;		
	/** 属性属性（userType）/属性（userType） */
	private String userType               ;		
	/** 属性属性业务来源/属性业务来源 */
	private String businessNature         ;		
	/** 属性信息采集机器编号/信息采集机器编号 */
	private String idCardMachineCode      ;		
	/** 属性修改人/修改人 */
	private String update_By              ;
	/** 属性修改时间/修改时间 */
	private java.util.Date update_Date            ;
	/** 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔） */
	private String macAddress             ;		
	/** 属性员工身份证/员工身份证 */
	private String identifyNumber         ;		
	/** 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动 */
	private String macFlag                ;		
	/** 属性属性（createdBy ）/属性（createdBy ） */
	private String createdBy              ;		
	/** 属性属性（createdTime）/属性（createdTime） */
	private java.util.Date createdTime            ;		
	/** 属性属性（updatedBy）/属性（updatedBy） */
	private String updatedBy              ;		
	/** 属性属性（updatedTime）/属性（updatedTime） */
	private java.util.Date updatedTime           ;		
	/** 属性属性（updatedAte）/属性（updatedAte） */
	private java.util.Date updateDate             ;		
	/** 属性属性（updateBy）/属性（updateBy） */
	private String updateBy               ;		
	/**
	 * 属性员工代码/员工代码的getter方法
	 */
	public String getUserCode () {
		return userCode ;
	}
	/**
	 * 属性员工代码/员工代码的setter方法
	 */
	public void setUserCode (String userCode ) {
		this.userCode  = userCode ;
	}	
	/**
	 * 属性员工名称/员工名称的getter方法
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 属性员工名称/员工名称的setter方法
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	/**
	 * 属性属性（usereName）/属性（usereName）的getter方法
	 */
	public String getUsereName () {
		return usereName ;
	}
	/**
	 * 属性属性（usereName）/属性（usereName）的setter方法
	 */
	public void setUsereName (String usereName ) {
		this.usereName  = usereName ;
	}	
	/**
	 * 属性密码/密码的getter方法
	 */
	public String getPassWord() {
		return passWord;
	}
	/**
	 * 属性密码/密码的setter方法
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	
	/**
	 * 属性印鉴/印鉴的getter方法
	 */
	public String getSeal                 () {
		return seal                 ;
	}
	/**
	 * 属性印鉴/印鉴的setter方法
	 */
	public void setSeal                 (String seal                 ) {
		this.seal                  = seal                 ;
	}	
	/**
	 * 属性属性（passWordSetDate）/属性（passWordSetDate）的getter方法
	 */
	public java.util.Date getPassWordSetDate       () {
		return passWordSetDate       ;
	}
	/**
	 * 属性属性（passWordSetDate）/属性（passWordSetDate）的setter方法
	 */
	public void setPassWordSetDate       (java.util.Date passWordSetDate       ) {
		this.passWordSetDate        = passWordSetDate       ;
	}	
	/**
	 * 属性属性（passWordExpireDate）/属性（passWordExpireDate）的getter方法
	 */
	public java.util.Date getPassWordExpireDate     () {
		return passWordExpireDate     ;
	}
	/**
	 * 属性属性（passWordExpireDate）/属性（passWordExpireDate）的setter方法
	 */
	public void setPassWordExpireDate     (java.util.Date passWordExpireDate     ) {
		this.passWordExpireDate      = passWordExpireDate     ;
	}	
	/**
	 * 属性归属机构代码/归属机构代码的getter方法
	 */
	public String getComCode                () {
		return comCode                ;
	}
	/**
	 * 属性归属机构代码/归属机构代码的setter方法
	 */
	public void setComCode                (String comCode                ) {
		this.comCode                 = comCode                ;
	}	
	/**
	 * 属性出单机构代码/出单机构代码的getter方法
	 */
	public String getMakeCom                () {
		return makeCom                ;
	}
	/**
	 * 属性出单机构代码/出单机构代码的setter方法
	 */
	public void setMakeCom                (String makeCom                ) {
		this.makeCom                 = makeCom                ;
	}	
	/**
	 * 属性属性（accountCode ）/属性（accountCode ）的getter方法
	 */
	public String getAccountCode           () {
		return accountCode           ;
	}
	/**
	 * 属性属性（accountCode ）/属性（accountCode ）的setter方法
	 */
	public void setAccountCode           (String accountCode           ) {
		this.accountCode            = accountCode           ;
	}	
	/**
	 * 属性电话号码/电话号码的getter方法
	 */
	public String getPhone                 () {
		return phone                 ;
	}
	/**
	 * 属性电话号码/电话号码的setter方法
	 */
	public void setPhone                 (String phone                 ) {
		this.phone                  = phone                 ;
	}	
	/**
	 * 属性手机号码/手机号码的getter方法
	 */
	public String getMobile                () {
		return mobile                ;
	}
	/**
	 * 属性手机号码/手机号码的setter方法
	 */
	public void setMobile                (String mobile                ) {
		this.mobile                 = mobile                ;
	}	
	/**
	 * 属性通信地址/通信地址的getter方法
	 */
	public String getAddress              () {
		return address              ;
	}
	/**
	 * 属性通信地址/通信地址的setter方法
	 */
	public void setAddress              (String address              ) {
		this.address               = address              ;
	}	
	/**
	 * 属性邮政编码/邮政编码的getter方法
	 */
	public String getPostCode              () {
		return postCode              ;
	}
	/**
	 * 属性邮政编码/邮政编码的setter方法
	 */
	public void setPostCode              (String postCode              ) {
		this.postCode               = postCode              ;
	}	
	/**
	 * 属性邮箱/邮箱的getter方法
	 */
	public String getEmail                 () {
		return email                 ;
	}
	/**
	 * 属性邮箱/邮箱的setter方法
	 */
	public void setEmail                 (String email                 ) {
		this.email                  = email                 ;
	}	
	/**
	 * 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员的getter方法
	 */
	public String getUserFlag              () {
		return userFlag              ;
	}
	/**
	 * 属性员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员/员工标志[1]: 1操作员[2]: 1经办人[3]：1业务员的setter方法
	 */
	public void setUserFlag              (String userFlag              ) {
		this.userFlag               = userFlag              ;
	}	
	/**
	 * 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统的getter方法
	 */
	public String getLoginSystem           () {
		return loginSystem           ;
	}
	/**
	 * 属性允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统/允许登录的应用系统[1]: 1核心业务系统[2]：1财务系统[3]：1再保险系统[4]：1 单证系统[5]：1核保核赔系统的setter方法
	 */
	public void setLoginSystem           (String loginSystem           ) {
		this.loginSystem            = loginSystem           ;
	}	
	/**
	 * 属性最新员工代码/最新员工代码的getter方法
	 */
	public String getNewUserCode            () {
		return newUserCode            ;
	}
	/**
	 * 属性最新员工代码/最新员工代码的setter方法
	 */
	public void setNewUserCode            (String newUserCode            ) {
		this.newUserCode             = newUserCode            ;
	}	
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的getter方法
	 */
	public String getValidStatus           () {
		return validStatus           ;
	}
	/**
	 * 属性效力状态(0失效/1有效)/效力状态(0失效/1有效)的setter方法
	 */
	public void setValidStatus           (String validStatus           ) {
		this.validStatus            = validStatus           ;
	}	
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的getter方法
	 */
	public String getArticleCode           () {
		return articleCode           ;
	}
	/**
	 * 属性专项代码(对应会计科目)/专项代码(对应会计科目)的setter方法
	 */
	public void setArticleCode           (String articleCode           ) {
		this.articleCode            = articleCode           ;
	}	
	/**
	 * 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注)的getter方法
	 */
	public String getFlag                  () {
		return flag                  ;
	}
	/**
	 * 属性标志字段(存放员工权限备注)/标志字段(存放员工权限备注)的setter方法
	 */
	public void setFlag                  (String flag                  ) {
		this.flag                   = flag                  ;
	}	
	/**
	 * 属性属性（underWritingAuthority）/属性（underWritingAuthority）的getter方法
	 */
	public String getUnderWritingAuthority () {
		return underWritingAuthority ;
	}
	/**
	 * 属性属性（underWritingAuthority）/属性（underWritingAuthority）的setter方法
	 */
	public void setUnderWritingAuthority (String underWritingAuthority ) {
		this.underWritingAuthority  = underWritingAuthority ;
	}	
	/**
	 * 属性终端号/终端号的getter方法
	 */
	public String getPosterMinalNo         () {
		return posterMinalNo         ;
	}
	/**
	 * 属性终端号/终端号的setter方法
	 */
	public void setPosterMinalNo         (String posterMinalNo         ) {
		this.posterMinalNo          = posterMinalNo         ;
	}	
	/**
	 * 属性属性（salesFlag ）/属性（salesFlag ）的getter方法
	 */
	public String getSalesFlag             () {
		return salesFlag             ;
	}
	/**
	 * 属性属性（salesFlag ）/属性（salesFlag ）的setter方法
	 */
	public void setSalesFlag             (String salesFlag             ) {
		this.salesFlag              = salesFlag             ;
	}	
	/**
	 * 属性属性（clockStatus）/属性（clockStatus）的getter方法
	 */
	public String getClockStatus           () {
		return clockStatus           ;
	}
	/**
	 * 属性属性（clockStatus）/属性（clockStatus）的setter方法
	 */
	public void setClockStatus           (String clockStatus           ) {
		this.clockStatus            = clockStatus           ;
	}	
	/**
	 * 属性属性（issales ）/属性（issales ）的getter方法
	 */
	public String getIsSales               () {
		return isSales               ;
	}
	/**
	 * 属性属性（issales ）/属性（issales ）的setter方法
	 */
	public void setIsSales               (String isSales               ) {
		this.isSales                = isSales               ;
	}	
	/**
	 * 属性属性（locked）/属性（locked）的getter方法
	 */
	public Integer getLocked               () {
		return locked               ;
	}
	/**
	 * 属性属性（locked）/属性（locked）的setter方法
	 */
	public void setLocked               (Integer locked               ) {
		this.locked                = locked               ;
	}	
	/**
	 * 属性属性（maxOverDueCount）/属性（maxOverDueCount）的getter方法
	 */
	public Integer getMaxOverDueCount       () {
		return maxOverDueCount       ;
	}
	/**
	 * 属性属性（maxOverDueCount）/属性（maxOverDueCount）的setter方法
	 */
	public void setMaxOverDueCount       (Integer maxOverDueCount       ) {
		this.maxOverDueCount        = maxOverDueCount       ;
	}	
	/**
	 * 属性属性（maxOverDueFee ）/属性（maxOverDueFee ）的getter方法
	 */
	public Double getMaxOverDueFee         () {
		return maxOverDueFee         ;
	}
	/**
	 * 属性属性（maxOverDueFee ）/属性（maxOverDueFee ）的setter方法
	 */
	public void setMaxOverDueFee         (Double maxOverDueFee         ) {
		this.maxOverDueFee          = maxOverDueFee         ;
	}	
	/**
	 * 属性属性（userLevel）/属性（userLevel）的getter方法
	 */
	public String getUserLevel             () {
		return userLevel             ;
	}
	/**
	 * 属性属性（userLevel）/属性（userLevel）的setter方法
	 */
	public void setUserLevel             (String userLevel             ) {
		this.userLevel              = userLevel             ;
	}	
	/**
	 * 属性属性（userNature）/属性（userNature）的getter方法
	 */
	public String getUserNature            () {
		return userNature            ;
	}
	/**
	 * 属性属性（userNature）/属性（userNature）的setter方法
	 */
	public void setUserNature            (String userNature            ) {
		this.userNature             = userNature            ;
	}	
	/**
	 * 属性属性（userType）/属性（userType）的getter方法
	 */
	public String getUserType              () {
		return userType              ;
	}
	/**
	 * 属性属性（userType）/属性（userType）的setter方法
	 */
	public void setUserType              (String userType              ) {
		this.userType               = userType              ;
	}	
	/**
	 * 属性属性业务来源/属性业务来源的getter方法
	 */
	public String getBusinessNature        () {
		return businessNature        ;
	}
	/**
	 * 属性属性业务来源/属性业务来源的setter方法
	 */
	public void setBusinessNature        (String businessNature        ) {
		this.businessNature         = businessNature        ;
	}	
	/**
	 * 属性信息采集机器编号/信息采集机器编号的getter方法
	 */
	public String getIdCardMachineCode     () {
		return idCardMachineCode     ;
	}
	/**
	 * 属性信息采集机器编号/信息采集机器编号的setter方法
	 */
	public void setIdCardMachineCode     (String idCardMachineCode     ) {
		this.idCardMachineCode      = idCardMachineCode     ;
	}	
	/**
	 * 属性修改人/修改人的getter方法
	 */
	public String getUpdate_By            () {
		return updateBy             ;
	}
	/**
	 * 属性修改人/修改人的setter方法
	 */
	public void setUpdate_By             (String updateBy             ) {
		this.updateBy              = updateBy             ;
	}	
	/**
	 * 属性修改时间/修改时间的getter方法
	 */
	public java.util.Date getUpdate_Date           () {
		return updateDate           ;
	}
	/**
	 * 属性修改时间/修改时间的setter方法
	 */
	public void setUpdate_Date           (java.util.Date updateDate           ) {
		this.updateDate            = updateDate           ;
	}	
	/**
	 * 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔）的getter方法
	 */
	public String getMacAddress            () {
		return macAddress            ;
	}
	/**
	 * 属性工号绑定MAC地址列表（以|分隔）/工号绑定MAC地址列表（以|分隔）的setter方法
	 */
	public void setMacAddress            (String macAddress            ) {
		this.macAddress             = macAddress            ;
	}	
	/**
	 * 属性员工身份证/员工身份证的getter方法
	 */
	public String getIdentifyNumber        () {
		return identifyNumber        ;
	}
	/**
	 * 属性员工身份证/员工身份证的setter方法
	 */
	public void setIdentifyNumber        (String identifyNumber        ) {
		this.identifyNumber         = identifyNumber        ;
	}	
	/**
	 * 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动的getter方法
	 */
	public String getMacFlag               () {
		return macFlag               ;
	}
	/**
	 * 属性Mac地址启动标志 0-不启动 1-启动/Mac地址启动标志 0-不启动 1-启动的setter方法
	 */
	public void setMacFlag               (String macFlag               ) {
		this.macFlag                = macFlag               ;
	}	
	/**
	 * 属性属性（createdBy ）/属性（createdBy ）的getter方法
	 */
	public String getCreatedBy             () {
		return createdBy             ;
	}
	/**
	 * 属性属性（createdBy ）/属性（createdBy ）的setter方法
	 */
	public void setCreatedBy             (String createdBy             ) {
		this.createdBy              = createdBy             ;
	}	
	/**
	 * 属性属性（createdTime）/属性（createdTime）的getter方法
	 */
	public java.util.Date getCreatedTime           () {
		return createdTime           ;
	}
	/**
	 * 属性属性（createdTime）/属性（createdTime）的setter方法
	 */
	public void setCreatedTime           (java.util.Date createdTime           ) {
		this.createdTime            = createdTime           ;
	}	
	/**
	 * 属性属性（updatedBy）/属性（updatedBy）的getter方法
	 */
	public String getUpdatedBy             () {
		return updatedBy             ;
	}
	/**
	 * 属性属性（updatedBy）/属性（updatedBy）的setter方法
	 */
	public void setUpdatedBy             (String updatedBy             ) {
		this.updatedBy              = updatedBy             ;
	}	
	/**
	 * 属性属性（updatedTime）/属性（updatedTime）的getter方法
	 */
	public java.util.Date getUpdatedTime          () {
		return updatedTime          ;
	}
	/**
	 * 属性属性（updatedTime）/属性（updatedTime）的setter方法
	 */
	public void setUpdatedTime          (java.util.Date updatedTime          ) {
		this.updatedTime           = updatedTime          ;
	}	
	/**
	 * 属性属性（updatedAte）/属性（updatedAte）的getter方法
	 */
	public java.util.Date getUpdateDate            () {
		return updateDate            ;
	}
	/**
	 * 属性属性（updatedAte）/属性（updatedAte）的setter方法
	 */
	public void setUpdateDate            (java.util.Date updateDate            ) {
		this.updateDate             = updateDate            ;
	}	
	/**
	 * 属性属性（updateBy）/属性（updateBy）的getter方法
	 */
	public String getUpdateBy              () {
		return updateBy              ;
	}
	/**
	 * 属性属性（updateBy）/属性（updateBy）的setter方法
	 */
	public void setUpdateBy              (String updateBy              ) {
		this.updateBy               = updateBy              ;
	}	
}
