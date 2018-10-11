package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanCoinsDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 共保方收费计划表Core接口
 */
public interface PrpTplanCoinsService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTplanCoinsDto prpTplanCoinsDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, String coinsCode, Integer serialNo, String payReason);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTplanCoinsDto prpTplanCoinsDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTplanCoinsDto queryByPK(String proposalNo, String coinsCode, Integer serialNo, String payReason);
}