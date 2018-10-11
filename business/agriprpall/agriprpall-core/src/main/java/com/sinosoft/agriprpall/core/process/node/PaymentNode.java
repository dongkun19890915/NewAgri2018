package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 缴费节点
 *
 * @date: 2018/3/30 14:28
 * @author: 何伟东
 */
public class PaymentNode extends ProcessNode {

    public PaymentNode() {
    }

    public PaymentNode(String nodeState) {
        builder(nodeState, NodeType.PAYMENT_NODE, false, false, null);
    }

    public PaymentNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.PAYMENT_NODE, false, false, processDto);
    }

    @Override
    protected boolean checkNowState() {
        if (NodeState.PROCESSING.equals(nowState)) {
            throw new DataVerifyException(nodeName + "节点没有" + NodeState.state.get(nowState) + "状态！");
        } else if (!NodeState.UNPROCESSED.equals(nowState) && !NodeState.PROCESSED.equals(nowState)) {
            throw new DataVerifyException("状态代码错误！");
        }
        return true;
    }
}
