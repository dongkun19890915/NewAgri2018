package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  省级机构配置表Core接口
 */
public interface PrpDprovinceConfigService {

    /**
     * 新增
     *@param
     */
    void save(PrpDprovinceConfigDto prpDprovinceConfigDto);

    /**
     * 删除
     *@param
     */
    void remove(String comCode, String riskCode);
    /**
     * 修改
     *@param
     */
    void modify(PrpDprovinceConfigDto prpDprovinceConfigDto);
    /**
     * 按主键查询实体
     *@param 
     */
    public PrpDprovinceConfigDto queryByPK(String comCode, String riskCode);
}