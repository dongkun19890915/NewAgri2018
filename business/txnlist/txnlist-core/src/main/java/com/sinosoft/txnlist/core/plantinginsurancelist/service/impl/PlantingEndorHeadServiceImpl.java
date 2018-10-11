package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorHeadDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingEndorHeadDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorHeadKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingEndorHeadService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantingEndorHeadServiceImpl extends BaseServiceImpl implements PlantingEndorHeadService {

    /** log日志 */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PlantingEndorHeadServiceImpl.class);

    @Autowired
    private PlantingEndorHeadDao plantingEndorHeadDao;


    @Transactional
    @Override
    public void removePlantingEndorHead(String endorseNo)throws Exception{
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单类型不能为空");
        }
        plantingEndorHeadDao.deletePlantingEndorHead(endorseNo);
    }

    @Override
    public void savePlantingEndorHead(PlantingEndorHeadDto plantingEndorHeadDto)throws Exception{
        if(plantingEndorHeadDto==null){
            throw new DataVerifyException("对象不能为空！");
        }
        plantingEndorHeadDto.setIsDeleteFlag("1");

        this.plantingEndorHeadDao.save(convert(plantingEndorHeadDto,PlantingEndorHead.class));
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PlantingEndorHeadDto queryByPK(String endorseNo)throws Exception {
        if (com.sinosoft.framework.core.utils.StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空！");
        }
        PlantingEndorHeadKey plantingEndorHeadKey = new PlantingEndorHeadKey(endorseNo);
        PlantingEndorHead plantingEndorHead = plantingEndorHeadDao.findOne(plantingEndorHeadKey);
        return this.convert(plantingEndorHead, PlantingEndorHeadDto.class);
    }
}
