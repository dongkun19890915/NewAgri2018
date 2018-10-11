package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrplQualityCheckDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * @description 质量评审内容表Core接口
 */
public interface PrplQualityCheckService {

    /**
     *@description 新增
     *@param
     */
    void save(PrplQualityCheckDto prplQualityCheckDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,String qualityCheckType,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrplQualityCheckDto prplQualityCheckDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrplQualityCheckDto queryByPK(String registNo,String qualityCheckType,java.lang.Integer serialNo);
}