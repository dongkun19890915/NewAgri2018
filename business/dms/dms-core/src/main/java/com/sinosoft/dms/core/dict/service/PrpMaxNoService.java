package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpMaxNoDto;
import java.lang.Object;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxNoCore接口
 */
public interface PrpMaxNoService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpMaxNoDto prpMaxNoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String groupNo, String tableName, String maxNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpMaxNoDto prpMaxNoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpMaxNoDto queryByPK(String groupNo, String tableName, String maxNo);

    /**
     * （通过分组号，表名 查询最大序号和最小序号和个数）
     * @author: 王志文
     * @date: 2017/12/14 20:06
     * @param groupNo
     * @param tableName
     * @return
     */
    List<Object []> queryMaxNoByGroupNoAndTableName(String groupNo, String tableName);
}