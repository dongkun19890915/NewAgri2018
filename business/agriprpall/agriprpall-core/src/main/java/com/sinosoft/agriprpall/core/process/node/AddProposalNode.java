package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeType;

/**
 * 投保录入节点
 *
 * @date: 2018/3/30 14:26
 * @author: 何伟东
 */
public class AddProposalNode extends ProcessNode {

    public AddProposalNode() {
    }

    public AddProposalNode(String nodeState) {
        builder(nodeState, NodeType.ADD_PROPOSAL_NODE, false, true, null);
    }

    public AddProposalNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.ADD_PROPOSAL_NODE, false, true, processDto);
    }
}
