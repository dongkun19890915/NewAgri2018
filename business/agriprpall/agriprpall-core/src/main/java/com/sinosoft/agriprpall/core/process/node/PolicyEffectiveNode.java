package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 保单生效节点
 *
 * @date: 2018/3/30 14:29
 * @author: 何伟东
 */
public class PolicyEffectiveNode extends ProcessNode {

    public PolicyEffectiveNode() {
    }

    public PolicyEffectiveNode(String nodeState) {
        builder(nodeState, NodeType.POLICY_EFFECTIVE_NODE, false, false, null);
    }

    public PolicyEffectiveNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.POLICY_EFFECTIVE_NODE, false, false, processDto);
    }

    @Override
    protected boolean checkNowState() {
        if (NodeState.UNPROCESSED.equals(nowState) || NodeState.PROCESSING.equals(nowState)) {
            throw new DataVerifyException(nodeName + "节点没有" + NodeState.state.get(nowState) + "状态！");
        } else if (!NodeState.PROCESSED.equals(nowState)) {
            throw new DataVerifyException("状态代码错误！");
        }
        return true;
    }
}
