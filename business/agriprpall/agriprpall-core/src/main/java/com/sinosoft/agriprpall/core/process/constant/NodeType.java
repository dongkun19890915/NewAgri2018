package com.sinosoft.agriprpall.core.process.constant;

import com.sinosoft.agriprpall.core.process.node.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点名称和节点实体类class的映射关系常量，用于工厂类生产节点对象
 *
 * @date: 2018/4/3 11:15
 * @author: 何伟东
 */
public class NodeType {
    /**
     * 投保录入节点
     */
    private final static Class<? extends ProcessNode> ADD_PROPOSAL = AddProposalNode.class;
    /**
     * 批改录入节点
     */
    private final static Class<? extends ProcessNode> ADD_ENDORSE = AddEndorseNode.class;
    /**
     * 核批节点
     */
    private final static Class<? extends ProcessNode> AUDIT_ENDORSE = AuditEndorseNode.class;
    /**
     * 核保节点
     */
    private final static Class<? extends ProcessNode> AUDIT_PROPOSAL = AuditProposalNode.class;
    /**
     * 批改删除节点
     */
    private final static Class<? extends ProcessNode> DELETE_ENDORSE = DeleteEndorseNode.class;
    /**
     * 投保删除节点
     */
    private final static Class<? extends ProcessNode> DELETE_PROPOSAL = DeleteProposalNode.class;
    /**
     * 批单生效节点
     */
    private final static Class<? extends ProcessNode> ENDORSE_EFFECTIVE = EndorseEffectiveNode.class;
    /**
     * 承批节点
     */
    private final static Class<? extends ProcessNode> ENDORSE = EndorseNode.class;
    /**
     * 保单到期节点
     */
    private final static Class<? extends ProcessNode> EXPIRE = ExpireNode.class;
    /**
     * 投保修改节点
     */
    private final static Class<? extends ProcessNode> MODIFY_PROPOSAL = ModifyProposalNode.class;
    /**
     * 缴费节点
     */
    private final static Class<? extends ProcessNode> PAYMENT = PaymentNode.class;
    /**
     * 保单生效节点
     */
    private final static Class<? extends ProcessNode> POLICY_EFFECTIVE = PolicyEffectiveNode.class;
    /**
     * 承保节点
     */
    private final static Class<? extends ProcessNode> POLICY = PolicyNode.class;
    /**
     * 批改提交核批节点
     */
    private final static Class<? extends ProcessNode> SUBMIT_ENDORSE = SubmitEndorseNode.class;
    /**
     * 投保提交审核节点
     */
    private final static Class<? extends ProcessNode> SUBMIT_PROPOSAL = SubmitProposalNode.class;

    /**
     * 节点代码对应节点实体类的映射map
     */
    public static Map<String, Class<? extends ProcessNode>> nodeTypeMap;

    /**
     * 投保录入节点
     */
    public static final String ADD_PROPOSAL_NODE = "addproposal";
    /**
     * 批改录入节点
     */
    public static final String ADD_ENDORSE_NODE = "addendorse";
    /**
     * 核批节点
     */
    public static final String AUDIT_ENDORSE_NODE = "auditendorse";
    /**
     * 核保节点
     */
    public static final String AUDIT_PROPOSAL_NODE = "auditproposal";
    /**
     * 批改删除节点
     */
    public static final String DELETE_ENDORSE_NODE = "deleteendorse";
    /**
     * 投保删除节点
     */
    public static final String DELETE_PROPOSAL_NODE = "deleteproposal";
    /**
     * 批单生效节点
     */
    public static final String ENDORSE_EFFECTIVE_NODE = "endorseeffective";
    /**
     * 承批节点
     */
    public static final String ENDORSE_NODE = "endorse";
    /**
     * 保单到期节点
     */
    public static final String EXPIRE_NODE = "expire";
    /**
     * 投保修改节点
     */
    public static final String MODIFY_PROPOSAL_NODE = "modifyproposal";
    /**
     * 缴费节点
     */
    public static final String PAYMENT_NODE = "payment";
    /**
     * 保单生效节点
     */
    public static final String POLICY_EFFECTIVE_NODE = "policyeffective";
    /**
     * 承保节点
     */
    public static final String POLICY_NODE = "policy";
    /**
     * 批改提交核批节点
     */
    public static final String SUBMIT_ENDORSE_NODE = "submitendorse";
    /**
     * 投保提交审核节点
     */
    public static final String SUBMIT_PROPOSAL_NODE = "submitproposal";

    /**
     * 节点代码对应节点实体类的映射map
     */
    public static Map<String, String> nodeTypeNameMap;

    /**
     * 初始化映射关系
     */
    static {
        nodeTypeMap = new HashMap<>();
        nodeTypeMap.put(ADD_PROPOSAL_NODE, ADD_PROPOSAL);
        nodeTypeMap.put(ADD_ENDORSE_NODE, ADD_ENDORSE);
        nodeTypeMap.put(AUDIT_ENDORSE_NODE, AUDIT_ENDORSE);
        nodeTypeMap.put(AUDIT_PROPOSAL_NODE, AUDIT_PROPOSAL);
        nodeTypeMap.put(DELETE_ENDORSE_NODE, DELETE_ENDORSE);
        nodeTypeMap.put(DELETE_PROPOSAL_NODE, DELETE_PROPOSAL);
        nodeTypeMap.put(ENDORSE_EFFECTIVE_NODE, ENDORSE_EFFECTIVE);
        nodeTypeMap.put(ENDORSE_NODE, ENDORSE);
        nodeTypeMap.put(EXPIRE_NODE, EXPIRE);
        nodeTypeMap.put(MODIFY_PROPOSAL_NODE, MODIFY_PROPOSAL);
        nodeTypeMap.put(PAYMENT_NODE, PAYMENT);
        nodeTypeMap.put(POLICY_EFFECTIVE_NODE, POLICY_EFFECTIVE);
        nodeTypeMap.put(POLICY_NODE, POLICY);
        nodeTypeMap.put(SUBMIT_ENDORSE_NODE, SUBMIT_ENDORSE);
        nodeTypeMap.put(SUBMIT_PROPOSAL_NODE, SUBMIT_PROPOSAL);
        // 代码和名称对应map
        nodeTypeNameMap = new HashMap<>();
        nodeTypeNameMap.put(ADD_PROPOSAL_NODE, "投保录入");
        nodeTypeNameMap.put(ADD_ENDORSE_NODE, "批改录入");
        nodeTypeNameMap.put(AUDIT_ENDORSE_NODE, "核批");
        nodeTypeNameMap.put(AUDIT_PROPOSAL_NODE, "核保");
        nodeTypeNameMap.put(DELETE_ENDORSE_NODE, "批改删除");
        nodeTypeNameMap.put(DELETE_PROPOSAL_NODE, "投保删除");
        nodeTypeNameMap.put(ENDORSE_EFFECTIVE_NODE, "批单生效");
        nodeTypeNameMap.put(ENDORSE_NODE, "承批");
        nodeTypeNameMap.put(EXPIRE_NODE, "保单到期");
        nodeTypeNameMap.put(MODIFY_PROPOSAL_NODE, "投保修改");
        nodeTypeNameMap.put(PAYMENT_NODE, "缴费");
        nodeTypeNameMap.put(POLICY_EFFECTIVE_NODE, "保单生效");
        nodeTypeNameMap.put(POLICY_NODE, "承保");
        nodeTypeNameMap.put(SUBMIT_ENDORSE_NODE, "批改提交核批");
        nodeTypeNameMap.put(SUBMIT_PROPOSAL_NODE, "投保提交审核");
    }


}
