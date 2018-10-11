package com.sinosoft.pms.core.misc.service;


import com.sinosoft.pms.api.misc.dto.PrpDareaLimitDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 地区限额控制配置表Core接口
 */
public interface PrpDareaLimitService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDareaLimitDto prpDareaLimitDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String areaCode,String versionNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDareaLimitDto prpDareaLimitDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDareaLimitDto queryByPK(String riskCode,String areaCode,String versionNo);
}