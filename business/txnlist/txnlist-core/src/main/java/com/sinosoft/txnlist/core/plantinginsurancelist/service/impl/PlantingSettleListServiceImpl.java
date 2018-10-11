package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.ValidityAndPKDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingSettleListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingSettleList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingSettleListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingSettleListService;
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
 * @description plantingsettlelistCore接口实现
 */
@Service
public class PlantingSettleListServiceImpl extends BaseServiceImpl implements PlantingSettleListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingSettleListServiceImpl.class);
    
    @Autowired
    private PlantingSettleListDao plantingSettleListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PlantingSettleListDto plantingSettleListDto) {
        PlantingSettleList plantingSettleList = this.convert(plantingSettleListDto, PlantingSettleList.class);
        plantingSettleListDao.save(plantingSettleList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String settleListCode,String fCode,String kindCode,String classCode) {
        PlantingSettleListKey plantingSettleListKey = new PlantingSettleListKey(settleListCode,fCode,kindCode,classCode);
        plantingSettleListDao.delete(plantingSettleListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PlantingSettleListDto plantingSettleListDto) {
        PlantingSettleList plantingSettleList = this.convert(plantingSettleListDto, PlantingSettleList.class);
        plantingSettleListDao.save(plantingSettleList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingSettleListDto queryByPK(String settleListCode,String fCode,String kindCode,String classCode) {
        PlantingSettleListKey plantingSettleListKey = new PlantingSettleListKey(settleListCode,fCode,kindCode,classCode);
        PlantingSettleList plantingSettleList = plantingSettleListDao.findOne(plantingSettleListKey);
        return this.convert(plantingSettleList,PlantingSettleListDto.class);
    }
    /**
     * @author 马俊玲
     *@description 查询实体
     *@param
     */
    @Override
    public List<PlantingSettleListDto> findBySettlelistCodeAndValidity(ValidityAndPKDto validityAndPKDto) {
        List<PlantingSettleListDto> plantingSettleListDtoList=null;
        List<PlantingSettleList> plantingSettleListList = plantingSettleListDao.findAll(Specifications.<PlantingSettleList>and()
                .eq(StringUtils.isEmpty(validityAndPKDto.getSettleListCode()),"settleListCode",validityAndPKDto.getSettleListCode())
                .eq(StringUtils.isEmpty(validityAndPKDto.getValidity()),"validity",validityAndPKDto.getValidity())
                .build());
        if(null!=plantingSettleListList&&plantingSettleListList.size()>0){
            plantingSettleListDtoList=new ArrayList<PlantingSettleListDto>();
            for(PlantingSettleList plantingSettleList:plantingSettleListList){
                plantingSettleListDtoList.add(convert(plantingSettleList,PlantingSettleListDto.class));
            }
        }
        return plantingSettleListDtoList;
    }
}