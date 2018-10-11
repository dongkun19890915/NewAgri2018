package com.sinosoft.agriclaim.core.docmanage.service;


import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyCollectDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 单证收集表Core接口
 */
public interface PrpLCertifyCollectService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCertifyCollectDto prpLCertifyCollectDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String businessNo,String lossItemCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCertifyCollectDto prpLCertifyCollectDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCertifyCollectDto queryByPK(String businessNo,String lossItemCode);
}