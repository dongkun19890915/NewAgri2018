package com.sinosoft.framework.agri.core.seal.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-01-26 11:21
 */
@XStreamAlias("SealDocResponse")
public class SealDocResponse {

    @XStreamAlias("FILE_LIST")
    private List<SealDocResponseTreeNode> treeNodes;

    public List<SealDocResponseTreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<SealDocResponseTreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }
}
