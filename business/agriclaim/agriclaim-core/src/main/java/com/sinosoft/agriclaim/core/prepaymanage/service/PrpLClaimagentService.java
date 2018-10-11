package com.sinosoft.agriclaim.core.prepaymanage.service;


import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLClaimagentDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * @description 代理赔保单信息表Core接口
 */
public interface PrpLClaimagentService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimagentDto prpLClaimagentDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimagentDto prpLClaimagentDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimagentDto queryByPK(String claimNo);
}