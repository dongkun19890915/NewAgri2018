package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisFeildDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisFeild;

import java.util.List;

/**
 * @Description: 投保预确认农户田块清单表（种植险）service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */
public interface GisFeildService {
    /**
     * @description: 查询农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    public List<GisFeildDto> queryAll();

    /**
     * @description: 保存投保预确认农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisFeildDto
     * @return
     * @throws Exception
     */
    public void saveGisFeild(GisFeildDto gisFeildDto)throws Exception;

    /**
     * @description: 批量保存投保预确认农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisFeildDtoList
     * @return
     * @throws Exception
     */
    public void saveGisFeild(List<GisFeildDto> gisFeildDtoList)throws Exception;
}
