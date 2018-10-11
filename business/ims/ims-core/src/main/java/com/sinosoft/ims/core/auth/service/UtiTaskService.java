package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.UtiTaskDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 任务定义表Core接口
 */
public interface UtiTaskService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiTaskDto utITaskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String taskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiTaskDto utITaskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiTaskDto queryByPK(String taskCode);
}