package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 *  共保信息表Core接口
 */
public interface PrpTcoinsService {

    /**
     * 新增
     *@param
     */
    void save(PrpTcoinsDto prpTcoinsDto);

    /**
     * 删除
     *@param
     */
    void remove(String proposalNo, Integer serialNo);
    /**
     * 修改
     *@param
     */
    void modify(PrpTcoinsDto prpTcoinsDto);
    /**
     * 按主键查询实体
     *@param 
     */
    PrpTcoinsDto queryByPK(String proposalNo, Integer serialNo);

    /**
     * 按proposalNo查询实体集合
     * @author 王心洋
     * @param proposalNo 投保单号
     * @time 2017-11-08
     * @return PrpTcoinsDto 共保信息list集合
     */
    public List<PrpTcoinsDto> findByProposalNo(String proposalNo);
}