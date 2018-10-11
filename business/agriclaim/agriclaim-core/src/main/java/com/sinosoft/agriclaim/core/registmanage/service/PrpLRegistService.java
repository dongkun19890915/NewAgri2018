package com.sinosoft.agriclaim.core.registmanage.service;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息表Core接口
 */
public interface PrpLRegistService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRegistDto prpLRegistDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRegistDto prpLRegistDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRegistDto queryByPK(String registNo);
}