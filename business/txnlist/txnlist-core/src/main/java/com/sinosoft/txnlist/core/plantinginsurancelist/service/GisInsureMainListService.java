package com.sinosoft.txnlist.core.plantinginsurancelist.service;



import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;

import java.util.List;

/**
 * @Description: 投保预确认清单数据表service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */
public interface GisInsureMainListService {

    /**
     * @description: 查询清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return GisInsureMainListDto
     * @throws Exception
     */
    public List<GisInsureMainListDto> queryAll();

    /**
     * @description: 根据主键查询清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insureListCode
     * @param serialNo
     * @return GisInsureMainListDto
     * @throws Exception
     */
    public GisInsureMainListDto get(String insureListCode,Integer serialNo);

    /**
     * @description: 保存投保预确认清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisInsureMainListDto
     * @return
     * @throws Exception
     */
    public Integer saveGisInsureMainList(GisInsureMainListDto gisInsureMainListDto)throws Exception;

    /**
     * @description: 批量保存投保预确认清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisInsureMainListDtoList
     * @return
     * @throws Exception
     */
    public void saveGisInsureMainList(List<GisInsureMainListDto> gisInsureMainListDtoList)throws Exception;
}
