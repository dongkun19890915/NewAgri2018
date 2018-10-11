package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListTempDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingSettleListTempDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingSettleListTemp;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingSettleListTempKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingSettleListTempService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description plantingsettlelisttempCore接口实现
 */
@Service
public class PlantingSettleListTempServiceImpl extends BaseServiceImpl implements PlantingSettleListTempService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingSettleListTempServiceImpl.class);
    
    @Autowired
    private PlantingSettleListTempDao plantingSettleListTempDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PlantingSettleListTempDto plantingSettleListTempDto) {
        PlantingSettleListTemp plantingSettleListTemp = this.convert(plantingSettleListTempDto, PlantingSettleListTemp.class);
        plantingSettleListTempDao.save(plantingSettleListTemp);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle) {
        PlantingSettleListTempKey plantingSettleListTempKey = new PlantingSettleListTempKey(registCode,stringTimeStamp,indexOfSettle);
        plantingSettleListTempDao.delete(plantingSettleListTempKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PlantingSettleListTempDto plantingSettleListTempDto) {
        PlantingSettleListTemp plantingSettleListTemp = this.convert(plantingSettleListTempDto, PlantingSettleListTemp.class);
        plantingSettleListTempDao.save(plantingSettleListTemp);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingSettleListTempDto queryByPK(String registCode,String stringTimeStamp,java.lang.Integer indexOfSettle) {
        PlantingSettleListTempKey plantingSettleListTempKey = new PlantingSettleListTempKey(registCode,stringTimeStamp,indexOfSettle);
        PlantingSettleListTemp plantingSettleListTemp = plantingSettleListTempDao.findOne(plantingSettleListTempKey);
        return this.convert(plantingSettleListTemp,PlantingSettleListTempDto.class);
    }
}