package com.sinosoft.agriclaim.core.endcasemanage.service;


import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * @description 赔案号表Core接口
 */
public interface PrpLCaseNoService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCaseNoDto prpLCaseNoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String certiNo,String certiType,String caseNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCaseNoDto prpLCaseNoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCaseNoDto queryByPK(String certiNo,String certiType,String caseNo);

    /**
     * @author jiaoyunzhen
     * @serialData 2017年12月22日09:51:45
     */
    int count(String caseNo,String strCaseNo);
}