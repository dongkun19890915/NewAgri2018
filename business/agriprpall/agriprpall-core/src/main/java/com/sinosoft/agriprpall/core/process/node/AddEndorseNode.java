package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 批改录入节点
 *
 * @date: 2018/3/30 14:30
 * @author: 何伟东
 */
public class AddEndorseNode extends ProcessNode {

    public AddEndorseNode() {
    }

    public AddEndorseNode(String nodeState) {
        builder(nowState, NodeType.ADD_ENDORSE_NODE, false, false, null);
    }

    public AddEndorseNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.ADD_ENDORSE_NODE, false, false, processDto);
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
