package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalCore接口
 */
public interface PrpTrenewalService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTrenewalDto prpTrenewalDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTrenewalDto prpTrenewalDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTrenewalDto queryByPK(String proposalNo);
}