package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDcertifycheckDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-04 09:05:54.250 
 * @description 单证校验信息表Core接口
 */
public interface PrpDcertifycheckService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcertifycheckDto prpDcertifycheckDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String nodeType,String certifyType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcertifycheckDto prpDcertifycheckDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcertifycheckDto queryByPK(String riskCode,String nodeType,String certifyType);
}