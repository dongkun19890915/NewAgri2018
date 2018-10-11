package com.sinosoft.ims.api.kernel.dto;

import java.io.Serializable;
import java.util.List;

/**
* @description 机构树TreeNode
* @author hzhongkai
* @date 2016年10月20日上午11:15:40
*/
public class TreeNodeDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String comCode;
	
	private String upperComCode;
	
	private String title;
	
	private boolean checked;
	
	private List<TreeNodeDto> nodes;


	public String getComCode()
    {
        return comCode;
    }

    public void setComCode(String comCode)
    {
        this.comCode = comCode;
    }

    public String getUpperComCode()
    {
        return upperComCode;
    }

    public void setUpperComCode(String upperComCode)
    {
        this.upperComCode = upperComCode;
    }


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<TreeNodeDto> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNodeDto> nodes) {
		this.nodes = nodes;
	}

}
