package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 模板主表Core接口
 */
public interface SwfModelMainService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfModelMainDto swfModelMainDto);

    /**
     *@description 删除
     *@param
     */
    void remove(java.lang.Integer modelNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfModelMainDto swfModelMainDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfModelMainDto queryByPK(java.lang.Integer modelNo);
}