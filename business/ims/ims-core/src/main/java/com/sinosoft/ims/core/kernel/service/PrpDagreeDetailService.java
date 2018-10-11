package com.sinosoft.ims.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDagreeDetailDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDagreeDetailCore接口
 */
public interface PrpDagreeDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDagreeDetailDto prpDagreeDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String agreementNo, String riskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDagreeDetailDto prpDagreeDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDagreeDetailDto queryByPK(String agreementNo, String riskCode);
}