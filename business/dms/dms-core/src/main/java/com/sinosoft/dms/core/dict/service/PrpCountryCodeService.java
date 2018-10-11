package com.sinosoft.dms.core.dict.service;


import com.sinosoft.dms.api.dict.dto.PrpCountryCodeDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:28:12.446 
 * @description prpCountryCodeCore接口
 */
public interface PrpCountryCodeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpCountryCodeDto prpCountryCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String codeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpCountryCodeDto prpCountryCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpCountryCodeDto queryByPK(String codeCode);

    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param codeType 代码种类
     * @param fieldExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    List<PrpCountryCodeDto> queryAreasProvinceInfo(String codeType,String fieldExt);

    /**
     * 按CodeCode查询实体
     * @param codeCode 代码
     * @author 王心洋
     * @time 2018-01-04
     * @return PrpCountryCodeDto
     */
    PrpCountryCodeDto queryByCodeCode(String codeCode);
}