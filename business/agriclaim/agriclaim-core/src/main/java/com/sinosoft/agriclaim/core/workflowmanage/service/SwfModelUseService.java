package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 模板使用设置Core接口
 */
public interface SwfModelUseService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfModelUseDto swfModelUseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer modelNo,String riskCode,String comCode,String modelType);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfModelUseDto swfModelUseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfModelUseDto queryByPK(java.lang.Integer modelNo,String riskCode,String comCode,String modelType);
}