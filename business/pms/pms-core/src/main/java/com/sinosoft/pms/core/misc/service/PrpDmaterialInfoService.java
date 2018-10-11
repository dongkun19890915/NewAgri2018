package com.sinosoft.pms.core.misc.service;


import com.sinosoft.pms.api.misc.dto.PrpDmaterialInfoDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 参考资料信息表Core接口
 */
public interface PrpDmaterialInfoService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDmaterialInfoDto prpDmaterialInfoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String materialId);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDmaterialInfoDto prpDmaterialInfoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDmaterialInfoDto queryByPK(String materialId);
}