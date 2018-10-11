package com.sinosoft.agriclaim.api.individuation.dto;

/**
 * 
 * @description 影像动态树传参
 * @author 周柯宇
 * @date 2018年1月18日 上午11:19:57
 */
public class ImageTypeDto {

	/** 属性 : 单证类型代码*/
	private String id;					
	/** 属性 : 单证类型名称*/
	private String name;				
	/** 属性 : 资料权限    如：CRUDT，分别代表用户拥有：增、删、改、查权限*/
	private String right_type="CRUDT";	
	/** 属性 : 影像资料压缩大小像素*/
	private String reseize="800*600";	
	/** 属性 : 是否是子节点	1-是子节点、0-父节点*/
	private String child_flag="1";		
	/** 属性 : 客户提供*/
	private String bakCode;				
	/** 属性 : 资料最大上传数量*/
	private String maxPages="9999";		
	/** 属性 : 资料最小上传数量*/
	private String minPages="0";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRight_type() {
		return right_type;
	}
	public void setRight_type(String right_type) {
		this.right_type = right_type;
	}
	public String getReseize() {
		return reseize;
	}
	public void setReseize(String reseize) {
		this.reseize = reseize;
	}
	public String getChild_flag() {
		return child_flag;
	}
	public void setChild_flag(String child_flag) {
		this.child_flag = child_flag;
	}
	public String getBakCode() {
		return bakCode;
	}
	public void setBakCode(String bakCode) {
		this.bakCode = bakCode;
	}
	public String getMaxPages() {
		return maxPages;
	}
	public void setMaxPages(String maxPages) {
		this.maxPages = maxPages;
	}
	public String getMinPages() {
		return minPages;
	}
	public void setMinPages(String minPages) {
		this.minPages = minPages;
	}
	
}
