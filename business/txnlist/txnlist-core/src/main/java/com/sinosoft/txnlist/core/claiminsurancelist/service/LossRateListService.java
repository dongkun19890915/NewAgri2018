package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestSaveLossRateListDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 08:50:16.862 
 * @description 理赔清单信息主表Core接口
 */
public interface LossRateListService {

    /**
     *@description 新增
     *@param
     */
    void save(LossRateListDto lossRateListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo       );
    /**
     *@description 修改
     *@param
     */
    void modify(LossRateListDto lossRateListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    LossRateListDto queryByPK(String listNo       );
    /**
     * 按条件查询实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    List<LossRateListDto> queryByConditions(String policyNo, String registNo);
    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    void compareInsurance(String listNo, String registNo);
    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    List<LossRateListDto> queryComparable(String policyNo, String registNo);
    /**
     * 金禾调用定损清单保存接口
     * @param requestSaveLossRateListDto 金禾传入保存大对象
     * @author 王心洋
     * @time 2018-01-03
     */
    public void saveLossRateList(RequestSaveLossRateListDto requestSaveLossRateListDto);
}