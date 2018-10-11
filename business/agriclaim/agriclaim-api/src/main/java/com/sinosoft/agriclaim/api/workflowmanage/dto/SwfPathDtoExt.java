package com.sinosoft.agriclaim.api.workflowmanage.dto;

import java.util.List;
/**
 * @description: 类功能简述：扩展类
 * @author chong
 * @date 2017年11月11日上午11:30:56
 */
public class SwfPathDtoExt extends SwfPathDto {

	private static final long serialVersionUID = 1L;
    /** 属性显示列表*/
    private List<SwfPathDto> pathList ;
    
     /** 属性属性下个节点s*/
    private int nextNodeNo ;

     /** 属性属性下个节点s*/
    private String[] nextNodeNoList ;

	public List<SwfPathDto> getPathList() {
		return pathList;
	}

	public void setPathList(List<SwfPathDto> pathList) {
		this.pathList = pathList;
	}

	public int getNextNodeNo() {
		return nextNodeNo;
	}

	public void setNextNodeNo(int nextNodeNo) {
		this.nextNodeNo = nextNodeNo;
	}

	public String[] getNextNodeNoList() {
		return nextNodeNoList;
	}

	public void setNextNodeNoList(String[] nextNodeNoList) {
		this.nextNodeNoList = nextNodeNoList;
	}
    
}
