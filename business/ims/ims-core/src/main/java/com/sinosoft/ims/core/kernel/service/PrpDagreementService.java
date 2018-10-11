package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDagreementDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 代理协议表Core接口
 */
public interface PrpDagreementService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDagreementDto prpDagreementDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String agreementNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDagreementDto prpDagreementDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDagreementDto queryByPK(String agreementNo);
}