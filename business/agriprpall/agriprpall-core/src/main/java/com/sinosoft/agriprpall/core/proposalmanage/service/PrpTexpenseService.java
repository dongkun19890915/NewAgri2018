package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTexpenseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 税表Core接口
 */
public interface PrpTexpenseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTexpenseDto prpTexpenseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTexpenseDto prpTexpenseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTexpenseDto queryByPK(String proposalNo);
}