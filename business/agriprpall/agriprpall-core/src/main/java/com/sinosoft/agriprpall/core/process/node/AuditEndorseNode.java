package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeType;

/**
 * 核批节点
 *
 * @date: 2018/3/30 14:31
 * @author: 何伟东
 */
public class AuditEndorseNode extends ProcessNode {

    public AuditEndorseNode() {
    }

    public AuditEndorseNode(String nodeState) {
        builder(nodeState, NodeType.ADD_PROPOSAL_NODE, false, false, null);
    }

    public AuditEndorseNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.ADD_PROPOSAL_NODE, false, false, processDto);
    }
}
