package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateHouseDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 农房理赔身份证信息表Core接口
 */
public interface PrpLCompensateHouseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCompensateHouseDto prpLCompensateHouseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String idcard,String registNo,String nodeType,String businessNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCompensateHouseDto prpLCompensateHouseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCompensateHouseDto queryByPK(String idcard,String registNo,String nodeType,String businessNo);
}