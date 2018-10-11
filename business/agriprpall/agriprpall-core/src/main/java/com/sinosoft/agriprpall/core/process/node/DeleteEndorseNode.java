package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.exception.DataVerifyException;

/**
 * 批改删除节点
 *
 * @date: 2018/3/30 14:31
 * @author: 何伟东
 */
public class DeleteEndorseNode extends ProcessNode {

    public DeleteEndorseNode() {
    }

    public DeleteEndorseNode(String nodeState) {
        builder(nodeState, NodeType.DELETE_ENDORSE_NODE, false, false, null);

    }

    public DeleteEndorseNode(ProcessDto processDto) {
        builder(processDto.getStateCode(), NodeType.DELETE_ENDORSE_NODE, false, false, processDto);
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
