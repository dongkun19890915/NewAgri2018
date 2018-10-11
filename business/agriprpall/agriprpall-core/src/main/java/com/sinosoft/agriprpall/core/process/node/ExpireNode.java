package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 保单到期节点
 *
 * @date: 2018/3/30 14:32
 * @author: 何伟东
 */
public class ExpireNode extends ProcessNode {

    public ExpireNode() {
    }

    public ExpireNode(String nodeState) {
        builder(nodeState, NodeType.EXPIRE_NODE, true, false, null);
    }

    public ExpireNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.EXPIRE_NODE, true, false, processDto);
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
