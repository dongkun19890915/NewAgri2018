package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 投保修改节点
 *
 * @date: 2018/3/30 14:27
 * @author: 何伟东
 */
public class ModifyProposalNode extends ProcessNode {

    public ModifyProposalNode() {
    }

    public ModifyProposalNode(String nodeState) {
        builder(nodeState, NodeType.MODIFY_PROPOSAL_NODE, false, false, null);
    }

    public ModifyProposalNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.MODIFY_PROPOSAL_NODE, false, false, processDto);
    }

    @Override
    protected boolean checkNowState() {
        if (NodeState.UNPROCESSED.equals(nowState)) {
            throw new DataVerifyException(nodeName + "节点没有" + NodeState.state.get(nowState) + "状态！");
        } else if (!NodeState.PROCESSING.equals(nowState) && !NodeState.PROCESSED.equals(nowState)) {
            throw new DataVerifyException("状态代码错误！");
        }
        return true;
    }
}
