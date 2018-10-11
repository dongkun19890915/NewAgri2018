package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;


import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisHerdFieldDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.GisHerdFieldDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisHerdField;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.GisHerdFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 投保预确认农户田块清单表 service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */
@Service
public class GisHerdFieldServiceImpl extends BaseServiceImpl implements GisHerdFieldService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GisHerdFieldServiceImpl.class);

    @Autowired
    GisHerdFieldDao gisHerdFieldDao;


    /**
     * @param
     * @return
     * @throws Exception
     * @description: 查询农户养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisHerdFieldDto> queryAll() {
        List<GisHerdField> gisHerdFieldList = gisHerdFieldDao.findAll();
        List<GisHerdFieldDto> gisHerdFieldDtoList = new ArrayList<GisHerdFieldDto>();
        this.convertCollection(gisHerdFieldList, gisHerdFieldDtoList, GisHerdFieldDto.class);
        return gisHerdFieldDtoList;
    }

    /**
     * @param gisHerdFieldDto
     * @return
     * @throws Exception
     * @description: 保存投保预确认农户养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public void saveGisHerdField(GisHerdFieldDto gisHerdFieldDto) throws Exception {
        GisHerdField gisHerdField = convert(gisHerdFieldDto, GisHerdField.class);
        //查询最新serialNo
        //Integer serialNo=gisFeildDao.getMaxSerialNo(gisFeild.getInsureListCode())+1;
        //gisFeild.setSerialNo(serialNo);
        gisHerdFieldDao.saveAndFlush(gisHerdField);

    }


    /**
     * @param gisHerdFieldDtoList
     * @return
     * @throws Exception
     * @description: 批量保存投保预确认农户养殖险耳标号表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public void saveGisHerdField(List<GisHerdFieldDto> gisHerdFieldDtoList) throws Exception {
        List<GisHerdField> gisFeildList = new ArrayList<GisHerdField>();
        this.convertCollection(gisHerdFieldDtoList, gisFeildList, GisHerdField.class);
        gisHerdFieldDao.save(gisFeildList);

    }
}
