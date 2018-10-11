package com.sinosoft.pms.core.misc.service;


import com.sinosoft.pms.api.misc.dto.PrpDareaDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 区域表Core接口
 */
public interface PrpDareaService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDareaDto prpDareaDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String codeCode,String codeType,String areaCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDareaDto prpDareaDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDareaDto queryByPK(String codeCode,String codeType,String areaCode);

    /**
     *@description 按主键查询实体
     *@param areaCode
     *@author 韩雨怀
     *@date 2017年12月20日 下午4:05:09
     */
    PrpDareaDto queryByAreaCode(String areaCode);
}