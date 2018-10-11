package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 收费计划表Core接口
 */
public interface PrpTplanService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTplanDto prpTplanDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTplanDto prpTplanDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTplanDto queryByPK(String proposalNo, Integer serialNo);
    /**
     *  根据投保单号查询prpTplan收费计划表详细信息
     * @author: 田慧
     * @date: 2017/11/20 9:32
     * @param proposalNo 投保单号
     * @return prpTplanDtoList  返回收费计划表Dto的集合
     */
    public List<PrpTplanDto> queryByProposalNo(String proposalNo)throws Exception;

}