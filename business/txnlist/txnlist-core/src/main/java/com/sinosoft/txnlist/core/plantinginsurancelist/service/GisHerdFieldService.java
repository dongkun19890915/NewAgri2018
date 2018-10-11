package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisHerdFieldDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisHerdField;

import java.util.List;

/**
 * @Description: 投保预确认农户金禾养殖险耳标号表（种植险）service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */
public interface GisHerdFieldService {

    /**
     * @description: 查询农户金禾养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    public List<GisHerdFieldDto> queryAll();

    /**
     * @description: 保存投保预确认金禾养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisHerdFieldDto
     * @return
     * @throws Exception
     */
    public void saveGisHerdField(GisHerdFieldDto gisHerdFieldDto)throws Exception;

    /**
     * @description: 批量保存投保预确认金禾养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisHerdFieldDtoList
     * @return
     * @throws Exception
     */
    public void saveGisHerdField(List<GisHerdFieldDto> gisHerdFieldDtoList)throws Exception;
}
