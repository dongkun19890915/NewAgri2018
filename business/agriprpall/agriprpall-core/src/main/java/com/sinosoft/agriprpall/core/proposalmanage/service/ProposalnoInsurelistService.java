package com.sinosoft.agriprpall.core.proposalmanage.service;

/**
 * @Description: 投保单号与清单关联Core接口
 * @Author: 钱浩
 * @Date: 9:00 2017/10/17
 */
public interface ProposalnoInsurelistService {

    /**
     * 投保单号与预投保清单关联
     * @author: 钱浩
     * @date: 2017/11/4 10:06
     * @param proposalNo 投保单号
     * @param inusreListCode 预投保清单号
     */
    public void relatedInsuranceNo(String proposalNo, String inusreListCode)throws Exception;

}