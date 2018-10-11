package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDpersonFeeCodeRiskDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description 人伤费用险种对照表Core接口
 */
public interface PrpDpersonFeeCodeRiskService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String feeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDpersonFeeCodeRiskDto queryByPK(String riskCode, String feeCode);
}