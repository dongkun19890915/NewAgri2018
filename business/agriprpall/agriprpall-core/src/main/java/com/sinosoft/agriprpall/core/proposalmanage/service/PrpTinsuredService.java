package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTinsuredDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 保险关系人表Core接口
 */
public interface PrpTinsuredService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTinsuredDto prpTinsuredDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTinsuredDto prpTinsuredDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTinsuredDto queryByPK(String proposalNo, Integer serialNo);

    /**
     *  根据投保单号查询prpTinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 13:37
     * @param proposalNo 投保单号
     * @return  prpTinsuredDtoList 返回PrpTinsuredDto的集合
     * @throws Exception
     */
    public List<PrpTinsuredDto> queryByPolicyNo(String proposalNo)throws Exception;
    /**
     *  根据投保单号、关系人标识查询prpTinsured保险关系人表表信息
     * @author: 田慧
     * @date: 2017/11/20 13:49
     * @param proposalNo 投保单号
     * @param insuredFlag 关系人标识
     * @return prpTinsuredDtoList 返回保险关系人表Dto的集合
     * @throws Exception
     */
    public List<PrpTinsuredDto> queryByCondition(String proposalNo,String insuredFlag) throws Exception;
}