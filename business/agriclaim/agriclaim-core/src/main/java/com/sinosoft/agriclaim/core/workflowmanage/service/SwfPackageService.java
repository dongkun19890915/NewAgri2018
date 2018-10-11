package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPackageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流明细信息包表Core接口
 */
public interface SwfPackageService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfPackageDto swfPackageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String packageId,java.lang.Integer detailNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfPackageDto swfPackageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    SwfPackageDto queryByPK(String packageId,java.lang.Integer detailNo);
}