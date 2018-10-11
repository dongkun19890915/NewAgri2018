package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔节点状态表Core接口
 */
public interface PrpLclaimStatusService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLclaimStatusDto prpLclaimStatusDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String businessno,String nodetype,java.lang.Integer serialno);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLclaimStatusDto prpLclaimStatusDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLclaimStatusDto queryByPK(String businessno,String nodetype,java.lang.Integer serialno);
}