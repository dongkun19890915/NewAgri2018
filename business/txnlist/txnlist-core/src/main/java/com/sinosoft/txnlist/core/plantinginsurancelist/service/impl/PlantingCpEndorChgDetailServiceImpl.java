package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingCpEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingCpEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingCpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingCpEndorChgDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantingCpEndorChgDetailServiceImpl extends BaseServiceImpl implements PlantingCpEndorChgDetailService {
    /** log日志 */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PlantingCpEndorChgDetailServiceImpl.class);

    @Autowired
    private PlantingCpEndorChgDetailDao plantingCpEndorChgDetailDao;

    @Transactional
    @Override
    public void removePlantingCpEndorChgDetail(String inusreListCode)throws  Exception{
        if(StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("投保清单编号不能为空！");
        }

        plantingCpEndorChgDetailDao.deletePlantingCpEndorChgDetail(inusreListCode);
    }

    @Override
    public void savePlantingCpEndorChgDetail(List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList)throws  Exception{
        if(plantingCpEndorChgDetailDtoList.size()==0){
            throw new DataVerifyException("集合不能为空！");
        }

        List<PlantingCpEndorChgDetail> plantingCpEndorChgDetailList=new ArrayList<PlantingCpEndorChgDetail>();
        convertCollection(plantingCpEndorChgDetailDtoList,plantingCpEndorChgDetailList,PlantingCpEndorChgDetail.class);
        plantingCpEndorChgDetailDao.save(plantingCpEndorChgDetailList);
    }

    @Override
    public List<PlantingCpEndorChgDetailDto> query(String inusreListCode) throws Exception {
        List<PlantingCpEndorChgDetail> plantingCpEndorChgDetailList=plantingCpEndorChgDetailDao.queryAllByInusreListCode(inusreListCode);
        List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList=new ArrayList<>();
        convertCollection(plantingCpEndorChgDetailList,plantingCpEndorChgDetailDtoList,PlantingCpEndorChgDetailDto.class);
        return plantingCpEndorChgDetailDtoList;
    }

    @Override
    public List<PlantingCpEndorChgDetailDto> queryByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty(insureListCode)){
            throw new DataVerifyException("清单号为空！");
        }
        List<PlantingCpEndorChgDetail> plantingCpEndorChgDetailList=plantingCpEndorChgDetailDao.queryAllByInusreListCode(insureListCode);
        List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailDtoList=new ArrayList<>();
        convertCollection(plantingCpEndorChgDetailList,plantingCpEndorChgDetailDtoList,PlantingCpEndorChgDetailDto.class);
        return plantingCpEndorChgDetailDtoList;
    }
}
