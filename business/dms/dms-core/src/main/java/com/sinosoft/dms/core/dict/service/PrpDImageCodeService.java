package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDImageCodeDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 03:00:47.370 
 * @description 承保理赔镜像代码表Core接口
 */
public interface PrpDImageCodeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDImageCodeDto prpDImageCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode,String comCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDImageCodeDto prpDImageCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDImageCodeDto queryByPK(String riskCode,String comCode);
}