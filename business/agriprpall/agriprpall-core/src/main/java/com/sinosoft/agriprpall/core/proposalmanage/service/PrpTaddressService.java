package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 投保单地址信息表Core接口
 */
public interface PrpTaddressService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTaddressDto prpTaddressDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer addressNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTaddressDto prpTaddressDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTaddressDto queryByPK(String proposalNo, Integer addressNo);
}