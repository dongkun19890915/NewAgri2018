package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;

import java.util.List;

/**
 * *PrpTmain投保单基本信息表core接口
 * @Author: 田慧
 * @Date: 2017/11/20 14:23
 */

public interface PrpTmainService {
    /**
     *  根据主键查询PrpTmain投保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:58
     * @param proposalNo 投保单号
     * @return PrpTmainDto
     */
    PrpTmainDto queryByPK(String proposalNo);
    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return prpTmainDto 投保单基本信息表信息
     * @throws Exception
     */
    public List<PrpTmainDto> checkPolicyNo(String policyNo, String riskCode)throws Exception;

    /**
     * 获取总条数
     *
     * @param proposalNo 投保单
     * @return 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/14 下午 15:30
     */
    public Integer queryProposalNo(String proposalNo) throws Exception;

    /**
     * 根据主键和核保标志为0查询PrpTmain投保单基本信息表信息
     *
     * @param proposalNo 投保单号 underwriteFlag 核保标志(0初始值/1通过/2不通过/3 无需核保 9待核保)
     * @return PrpTmainDto
     * @author: 潘峰
     * @date: 2017/12/3 11:58
     */
    PrpTmainDto queryByUnderwriteFlag(String proposalNo, String underwriteFlag);


    PrpTmainDto findByProposalNo(String proposalNo);

    /**
     * 批量查询未提交投保单信息
     *
     * @param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/17 15:52
     */
    List<PrpTmainDto> queryInitialProposal(List<String> proposalNos);
}
