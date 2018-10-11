package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpMmodelComDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板机构配置表Core接口
 */
public interface PrpMmodelComService {

    /**
     *@description 新增
     *@param
     */
    void save(List<PrpMmodelComDto> prpMmodelComDtos);

    /**
     *@description 删除
     *@param
     */
    void remove(String modelCode, String comCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpMmodelComDto prpMmodelComDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpMmodelComDto queryByPK(String modelcode, String comcode);
    /**
     * 根据机构代码和模板代码模糊查询模板机构配置表信息
     * @author: 田慧
     * @date: 2017/11/7 17:55
     * @param map 模板代码和机构代码
     * @return PrpMmodelComDto模板机构配置表的集合
     */
    List<PrpMmodelComDto> queryCodeListByComcode(Map<String,String> map)throws Exception;


    List<PrpMmodelComDto> findByModelCode(String modelCode);

    void deleteByModelCode(String modelCode);
}