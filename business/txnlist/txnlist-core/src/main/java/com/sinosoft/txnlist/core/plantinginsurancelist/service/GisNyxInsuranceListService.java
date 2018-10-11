package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisNyxInsuranceListDto;

import java.util.List;

/**
 * @Description: 投保预确认农户清单表service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */
public interface GisNyxInsuranceListService {

    /**
     * @description: 查询农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return GisNyxInsuranceListDto
     * @throws Exception
     */
    public List<GisNyxInsuranceListDto> queryAll();


    /**
     * @description: 保存投保预确认农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisNyxInsuranceListDto
     * @return
     * @throws Exception
     */
    public void saveGisNyxInsuranceList(GisNyxInsuranceListDto gisNyxInsuranceListDto)throws Exception;

    /**
     * @description: 批量保存投保预确认农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisNyxInsuranceListDtoList
     * @return
     * @throws Exception
     */
    public void saveGisNyxInsuranceList(List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList)throws Exception;
}
