package com.sinosoft.framework.agri.core.seal.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-25 16:07
 */
@XStreamAlias("SealDocRequest")
public class SealDocRequest {

    @XStreamAlias("BASE_DATA")
    private BaseData baseData;

    @XStreamAlias("FILE_LIST")
    private List<SealDocRequestTreeNode> fileList;

    public BaseData getBaseData() {
        return baseData;
    }

    public void setBaseData(BaseData baseData) {
        this.baseData = baseData;
    }

    public List<SealDocRequestTreeNode> getFileList() {
        return fileList;
    }

    public void setFileList(List<SealDocRequestTreeNode> fileList) {
        this.fileList = fileList;
    }
}
