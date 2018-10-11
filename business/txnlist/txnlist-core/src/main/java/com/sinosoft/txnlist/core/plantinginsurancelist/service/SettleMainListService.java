package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RegisterCoderDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description settlemainlistCore接口
 */
public interface SettleMainListService {

    /**
     *@description 新增
     *@param
     */
    void save(SettleMainListDto settleMainListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String settleListCode);
    /**
     *@description 修改
     *@param
     */
    void modify(SettleMainListDto settleMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SettleMainListDto queryByPK(String settleListCode);

    public List<SettleMainListDto> findByCondition(String policyNo,String valiDity)throws Exception;

	 /**
     *@description 查询实体s
     *@param registerCoder
     *@author 马俊玲
     */
    List<SettleMainListDto> findByRegisterCode(String registerCoder);
    /**
     *@description 查询实体
     *@param registerCoder
     *@author 马俊玲
     */
    List<SettleMainListDto> queryByRegisterCodeAndValidity( RegisterCoderDto registerCoder);

}