package com.sinosoft.agriprpall.core.process.constant;

/**
 * 节点处理结果代码常量类
 *
 * @Author: 何伟东
 * @Date: 2018/4/26 10:32
 */
public interface NodeResultCode {
    /**
     * 无处理结果
     */
    String EMPTY = "R999";
    /**
     * 投保暂存
     */
    String PROPOSAL_SAVE_TEMP = "R001";
    /**
     * 投保保存
     */
    String PROPOSAL_SAVE = "R002";
    /**
     * 已提交核保
     */
    String PROPOSAL_SUBMIT = "R003";
    /**
     * 已删除
     */
    String PROPOSAL_DELETE = "R004";
    /**
     * 修改暂存
     */
    String PROPOSAL_MODIFY_TEMP = "R005";
    /**
     * 修改保存
     */
    String PROPOSAL_MODIFY_SAVE = "R006";
    /**
     * 核保占用
     */
    String PROPOSAL_AUDIT_OCCUPANCY = "R007";
    /**
     * 核保通过
     */
    String PROPOSAL_AUDIT_PASS = "R008";
    /**
     * 核保不通过
     */
    String PROPOSAL_AUDIT_NOT_PASS = "R009";
    /**
     * 核保下发修改
     */
    String PROPOSAL_AUDIT_SEND_BACK = "R010";
    /**
     * 核保提交上级
     */
    String PROPOSAL_AUDIT_SUBMIT_SUPERIOR = "R011";
    /**
     * 已缴费
     */
    String PAYMENT = "R012";
    /**
     * 已承保
     */
    String POLICY = "R013";
    /**
     * 保单已生效
     */
    String POLICY_EFFECTIVE = "R014";
    /**
     * 批改保存
     */
    String ENDORSE_SAVE = "R015";
    /**
     * 已提交核批
     */
    String ENDORSE_SUBMIT = "R016";
    /**
     * 批单删除
     */
    String ENDORSE_DELETE = "R017";
    /**
     * 核批暂存
     */
    String ENDORSE_AUDIT_TEMP = "R018";
    /**
     * 核批通过
     */
    String ENDORSE_AUDIT_PASS = "R019";
    /**
     * 核批不通过
     */
    String ENDORSE_AUDIT_NOT_PASS = "R020";
    /**
     * 核批下划修改
     */
    String ENDORSE_AUDIT_SEND_BACK = "R021";
    /**
     * 核批提交上级
     */
    String ENDORSE_AUDIT_SUBMIT_SUPERIOR = "R022";
    /**
     * 已承批
     */
    String ENDORSE = "R023";
    /**
     * 批单已生效
     */
    String ENDORSE_EFFECTIVE = "R024";
    /**
     * 已到期
     */
    String EXPIRE = "R025";
}
