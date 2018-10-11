package com.sinosoft.agriclaim.core.docmanage.service;


import com.sinosoft.agriclaim.api.docmanage.dto.PrplCertifyDirectDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * @description 索赔指引表Core接口
 */
public interface PrplCertifyDirectService {

    /**
     *@description 新增
     *@param
     */
    void save(PrplCertifyDirectDto prplCertifyDirectDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo, Integer serialNo, String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrplCertifyDirectDto prplCertifyDirectDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrplCertifyDirectDto queryByPK(String registNo, Integer serialNo, String lossItemCode);
}