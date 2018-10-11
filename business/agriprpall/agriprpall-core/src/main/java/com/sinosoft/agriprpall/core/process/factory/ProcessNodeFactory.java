package com.sinosoft.agriprpall.core.process.factory;

import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.process.node.ProcessNode;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;

import java.lang.reflect.Constructor;

/**
 * 流程节点抽象工厂类，用于生产各节点的对象
 *
 * @date: 2018/4/3 11:20
 * @author: 何伟东
 */
public class ProcessNodeFactory {

    private ProcessNodeFactory() {
    }

    /**
     * 创建节点对象
     *
     * @param nodeType 节点实体类对应的class
     * @return ProcessNode 节点对象
     * @date: 2018/4/3 11:27
     * @author: 何伟东
     */
    public static ProcessNode createNode(Class<? extends ProcessNode> nodeType) throws Exception {
        ProcessNode processNode;
        if (nodeType != null) {
            Constructor<? extends ProcessNode> declaredConstructor = nodeType.getDeclaredConstructor();
            processNode = declaredConstructor.newInstance();
        } else {
            throw new BusinessException("ProcessNodeFactory初始化异常！");
        }
        return processNode;
    }

    /**
     * 使用有参构造函数，创建节点对象,传入节点当前状态
     *
     * @param nodeType  节点实体类对应的class
     * @param nodeState 节点当前状态
     * @return ProcessNode 节点对象
     * @date: 2018/4/4 10:15
     * @author: 何伟东
     */
    public static ProcessNode createNode(Class<? extends ProcessNode> nodeType, String nodeState) throws Exception {
        ProcessNode processNode;
        if (nodeType != null) {
            Constructor<? extends ProcessNode> declaredConstructor = nodeType.getDeclaredConstructor(String.class);
            processNode = declaredConstructor.newInstance(nodeState);
        } else {
            throw new BusinessException("ProcessNodeFactory初始化异常！");
        }
        return processNode;
    }

    /**
     * 使用有参构造函数，创建节点对象,传入节点当前状态
     *
     * @param nodeType   节点实体类对应的class
     * @param processDto 节点所有数据
     * @return ProcessNode 节点对象
     * @date: 2018/4/4 10:15
     * @author: 何伟东
     */
    public static ProcessNode createNode(Class<? extends ProcessNode> nodeType, ProcessDto processDto) throws Exception {
        ProcessNode processNode;
        if (nodeType != null) {
            Constructor<? extends ProcessNode> declaredConstructor = nodeType.getDeclaredConstructor(ProcessDto.class);
            processNode = declaredConstructor.newInstance(processDto);
        } else {
            throw new BusinessException("ProcessNodeFactory初始化异常！");
        }
        return processNode;
    }

    /**
     * 创建节点对象
     *
     * @param nodeCode 节点代码
     * @return ProcessNode 节点对象
     * @date: 2018/4/3 11:32
     * @author: 何伟东
     */
    public static ProcessNode createNode(String nodeCode) throws Exception {
        Class<? extends ProcessNode> processNodeClass = NodeType.nodeTypeMap.get(nodeCode);
        if (processNodeClass == null) {
            throw new DataVerifyException("节点代码不正确！");
        }
        return createNode(processNodeClass);
    }

    /**
     * 使用有参构造函数，创建节点对象,传入节点当前状态
     *
     * @param nodeCode  节点代码
     * @param nodeState 节点当前状态
     * @return ProcessNode 节点对象
     * @date: 2018/4/3 11:32
     * @author: 何伟东
     */
    public static ProcessNode createNode(String nodeCode, String nodeState) throws Exception {
        Class<? extends ProcessNode> processNodeClass = NodeType.nodeTypeMap.get(nodeCode);
        if (processNodeClass == null) {
            throw new DataVerifyException("节点代码不正确！");
        }
        return createNode(processNodeClass, nodeState);
    }

    /**
     * 使用有参构造函数，创建节点对象,传入节点当前状态
     *
     * @param processDto 节点数据
     * @return ProcessNode 节点对象
     * @date: 2018/4/3 11:32
     * @author: 何伟东
     */
    public static ProcessNode createNode(ProcessDto processDto) throws Exception {
        Class<? extends ProcessNode> processNodeClass = NodeType.nodeTypeMap.get(processDto.getStepCode());
        if (processNodeClass == null) {
            throw new DataVerifyException("节点代码不正确！");
        }
        return createNode(processNodeClass, processDto);
    }


}
