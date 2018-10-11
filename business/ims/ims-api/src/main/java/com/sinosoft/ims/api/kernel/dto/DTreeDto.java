package com.sinosoft.ims.api.kernel.dto;


import java.io.Serializable;
import java.util.List;

public class DTreeDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String parentId;
	private String name;
	private int level;
	private List<DTreeDto> childList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DTreeDto> getChildList() {
		return childList;
	}
	public void setChildList(List<DTreeDto> childList) {
		this.childList = childList;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
