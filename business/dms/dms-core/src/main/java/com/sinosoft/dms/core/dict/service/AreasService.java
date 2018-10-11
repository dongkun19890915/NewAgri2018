package com.sinosoft.dms.core.dict.service;



import com.sinosoft.dms.api.dict.dto.AreasDto;
import com.sinosoft.dms.api.dict.dto.AreasParamsDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 06:45:04.724 
 * @description 行政区域表Core接口
 */
public interface AreasService {

    /**
     *@description 新增
     *@param
     */
    void save(AreasDto areasDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String areaCode);
    /**
     *@description 修改
     *@param
     */
    void modify(AreasDto areasDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    AreasDto queryByPK(String areaCode);

    /**
     * @description:（查询承保清单归属区域信息）
     * @author: 董坤
     * @date: 2017/10/14 9:01
     * @param areasParamsDto
     * @return List<AreasDto>
     * @throws Exception
     */
    public List<AreasDto> queryAreasByCondition(AreasParamsDto areasParamsDto) throws Exception;
}