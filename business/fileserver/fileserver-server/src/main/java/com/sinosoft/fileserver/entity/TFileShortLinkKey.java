package com.sinosoft.fileserver.entity;

/**
 * @author codegen@研发中心
 * @mail weiyang@sinosoft.com.cn
 * @time  2016-10-06 18:53:43.125 
 * TFileShortLink-文件短链接表 主键操作类
 */
public class TFileShortLinkKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性ShortLinkId/短链接id */
	private String shortLinkId ;
	/**
	 * 属性ShortLinkId/短链接id的getter方法
	 */
	public String getShortLinkId() {
    		return shortLinkId;
	}
	/**
	 * 属性ShortLinkId/短链接id的setter方法
	 */
	public void setShortLinkId(String shortLinkId) {
		this.shortLinkId = shortLinkId;
	} 
}