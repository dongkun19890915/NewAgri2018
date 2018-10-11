package com.sinosoft.framework.agri.core.seal.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-26 11:24
 */

@XStreamAlias("TREE_NODE")
public class SealDocResponseTreeNode {
    @XStreamAlias("RET_CODE")
    private String retCode;

    @XStreamAlias("FILE_NAME")
    private String fileName;

    @XStreamAlias("FILE_MSG")
    private String fileMsg;

    public SealDocResponseTreeNode() {

    }

    public SealDocResponseTreeNode(String retCode, String fileName, String fileMsg) {
        this.retCode = retCode;
        this.fileName = fileName;
        this.fileMsg = fileMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMsg() {
        return fileMsg;
    }

    public void setFileMsg(String fileMsg) {
        this.fileMsg = fileMsg;
    }
}
