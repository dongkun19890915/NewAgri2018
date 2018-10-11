package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 投保删除节点
 *
 * @date: 2018/3/30 14:27
 * @author: 何伟东
 */
public class DeleteProposalNode extends ProcessNode {

    public DeleteProposalNode() {
    }

    public DeleteProposalNode(String nodeState) {
        builder(nodeState, NodeType.DELETE_PROPOSAL_NODE, true, false, null);
    }

    public DeleteProposalNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.DELETE_PROPOSAL_NODE, true, false, processDto);
    }

    @Override
    protected boolean checkNowState() {
        if (NodeState.PROCESSING.equals(nowState) || NodeState.UNPROCESSED.equals(nowState)) {
            throw new DataVerifyException(nodeName + "节点没有" + NodeState.state.get(nowState) + "状态！");
        } else if (!NodeState.PROCESSED.equals(nowState)) {
            throw new DataVerifyException("状态代码错误！");
        }
        return true;
    }
}
