package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeType;

/**
 * 核保节点
 *
 * @date: 2018/3/30 14:28
 * @author: 何伟东
 */
public class AuditProposalNode extends ProcessNode {

    public AuditProposalNode() {
    }

    public AuditProposalNode(String nodeState) {
        builder(nodeState, NodeType.AUDIT_PROPOSAL_NODE, false, false, null);
    }

    public AuditProposalNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.AUDIT_PROPOSAL_NODE, false, false, processDto);
    }

}
