package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDnewCodeRiskDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:01.505 
 * @description 通用代码险种对照表Core接口
 */
public interface PrpDnewCodeRiskService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDnewCodeRiskDto prpDnewCodeRiskDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String codeType,String codeCode,String riskCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDnewCodeRiskDto prpDnewCodeRiskDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDnewCodeRiskDto queryByPK(String codeType,String codeCode,String riskCode);
}