package com.sinosoft.agriprpall.core.process.node;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.agri.core.gycore.NodeItemData;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;

import java.util.Date;

/**
 * 承保流程节点类的抽象父类，提供基本的方法和属性
 *
 * @date: 2018/3/30 14:22
 * @author: 何伟东
 */
public abstract class ProcessNode {

    /**
     * 当前状态
     */
    protected String nowState;

    /**
     * 是否终止节点
     */
    protected boolean isEndNode;

    /**
     * 是否开始节点
     */
    protected boolean isStartNode;

    protected String nodeName;

    /**
     * 节点数据dto，可用于节点数据向金禾推送
     */
    protected NodeItemData nodeItemData;

    /**
     * 抽象的数据校验方法，节点状态校验和其他校验可重写checkNowState或customCheck方法
     *
     * @date: 2018/4/2 16:57
     * @author: 何伟东
     */
    public boolean checkData() {
        if (nodeItemData == null) {
            throw new DataVerifyException("节点数据不能为空！");
        }
        if (StringUtils.isEmpty(nodeItemData.getBizCode())) {
            throw new DataVerifyException("业务号不能为空！");
        }
        if (StringUtils.isEmpty(nodeItemData.getStepCode())) {
            throw new DataVerifyException("环节代码不能为空！");
        }
        if (StringUtils.isEmpty(nodeItemData.getStateCode())) {
            throw new DataVerifyException("状态代码不能为空！");
        }
        if (StringUtils.isEmpty(nodeItemData.getOpCode())) {
            throw new DataVerifyException("操作员代码不能为空！");
        }
        if (StringUtils.isEmpty(nodeItemData.getOpName())) {
            throw new DataVerifyException("操作员名称不能为空！");
        }
        if (nodeItemData.getInflowTime() == null) {
            throw new DataVerifyException("流入时间不能为空！");
        }
        checkNowState();
        customCheck();
        return true;
    }

    /**
     * 自定义的校验,子类有特殊校验时重写此方法即可
     *
     * @date: 2018/4/2 16:47
     * @author: 何伟东
     */
    protected boolean customCheck() {
        return true;
    }

    /**
     * 校验节点状态是否有误，不同节点状态可选范围不同时，子类重写此方法即可
     *
     * @date: 2018/4/8 9:25
     * @author: 何伟东
     */
    protected boolean checkNowState() {
        if (!NodeState.UNPROCESSED.equals(nowState)
                && !NodeState.PROCESSING.equals(nowState)
                && !NodeState.PROCESSED.equals(nowState)) {
            throw new DataVerifyException("状态代码错误！");
        }
        return true;
    }

    /**
     * 设置节点状态，推荐使用NodeState常量类
     *
     * @param nowState 状态代码
     * @return
     * @date: 2018/4/8 9:27
     * @author: 何伟东
     */
    public void setNowState(String nowState) {
        this.nowState = nowState;
    }

    /**
     * 构建节点数据对象
     *
     * @param nowState    节点状态
     * @param stepCode    节点代码
     * @param isEndNode   是否是终止节点
     * @param isStartNode 是否是开始节点
     * @param processDto  接收到的节点数据，该参数可以为空
     * @date: 2018/4/8 9:28
     * @author: 何伟东
     */
    protected void builder(String nowState, String stepCode, boolean isEndNode, boolean isStartNode, ProcessDto processDto) {
        setNowState(nowState);
        this.isEndNode = isEndNode;
        this.isStartNode = isStartNode;
        NodeItemData nodeItemData = new NodeItemData();
        nodeItemData.setStateCode(nowState);
        nodeItemData.setStepCode(stepCode);
        this.nodeName = NodeType.nodeTypeNameMap.get(stepCode);
        this.nodeItemData = nodeItemData;
        if (processDto != null) {
            builderNodeItemData(processDto);
        }
    }

    /**
     * 根据dto构建数据
     *
     * @param processDto 接收到的节点数据
     * @date: 2018/4/8 9:56
     * @author: 何伟东
     */
    protected void builderNodeItemData(ProcessDto processDto) {
        this.nodeItemData.setBizCode(processDto.getBizCode());
        this.nodeItemData.setOpCode(processDto.getOpCode());
        this.nodeItemData.setOpName(processDto.getOpName());
        this.nodeItemData.setInflowTime(processDto.getInflowTime());
        this.nodeItemData.setOpTime(processDto.getOpTime());
        if (processDto.getOutflowTime() == null) {
            this.nodeItemData.setOutflowTime(new Date());
        } else {
            this.nodeItemData.setOutflowTime(processDto.getOutflowTime());
        }
        if (StringUtils.isEmpty(processDto.getPaymentTypeCode())) {
            this.nodeItemData.setPaymentTypeCode("0");
        } else {
            this.nodeItemData.setPaymentTypeCode(processDto.getPaymentTypeCode());
        }
        if (StringUtils.isEmpty(processDto.getAmount())) {
            this.nodeItemData.setAmount("0");
        } else {
            this.nodeItemData.setAmount(processDto.getAmount());
        }
        if (StringUtils.isEmpty(processDto.getResultCode())) {
            this.nodeItemData.setResultCode("0");
        } else {
            this.nodeItemData.setResultCode(processDto.getResultCode());
        }
    }

    public String getNowState() {
        return nowState;
    }

    public boolean isEndNode() {
        return isEndNode;
    }

    public NodeItemData getNodeItemData() {
        return nodeItemData;
    }

    public boolean isStartNode() {
        return isStartNode;
    }

    public void setNodeItemData(NodeItemData nodeItemData) {
        this.nodeItemData = nodeItemData;
    }
}
