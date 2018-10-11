package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 保单保额保费表Core接口
 */
public interface PrpTfeeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTfeeDto prpTfeeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTfeeDto prpTfeeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTfeeDto queryByPK(String proposalNo, String currency);
}