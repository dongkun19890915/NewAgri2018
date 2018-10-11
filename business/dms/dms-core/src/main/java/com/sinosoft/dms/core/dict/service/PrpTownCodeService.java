package com.sinosoft.dms.core.dict.service;



import com.sinosoft.dms.api.dict.dto.PrpTownCodeDto;


import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 10:26:37.210 
 * @description prpTownCodeCore接口
 */
public interface PrpTownCodeService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTownCodeDto prpTownCodeDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String codeCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTownCodeDto prpTownCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTownCodeDto queryByPK(String codeCode);

    /**
     * codeType和feildExt查询归属机构信息
     * @author: 王保良
     * @date: 2017/11/16 17:46
     * @param codeType 代码种类
     * @param feildExt 上级区域代码
     * @return 返回的是满足条件的PrpDcode实体类对象
     * @throws Exception
     */
    List<PrpTownCodeDto> queryAreasProvinceInfo(String codeType,String fieldExt) throws Exception;
}