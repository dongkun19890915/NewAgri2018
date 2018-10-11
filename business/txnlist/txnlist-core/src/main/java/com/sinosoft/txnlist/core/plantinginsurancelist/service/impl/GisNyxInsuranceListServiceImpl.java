package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisNyxInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.GisNyxInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisNyxInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.GisNyxInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 投保预确认农户清单表service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */

@Service
public class GisNyxInsuranceListServiceImpl extends BaseServiceImpl implements GisNyxInsuranceListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GisNyxInsuranceListServiceImpl.class);

    @Autowired
    GisNyxInsuranceListDao gisNyxInsuranceListDao;
    /**
     * @description: 查询全部保存投保预确认农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return List<GisNyxInsuranceListDto>
     * @throws Exception
     */
    @Override
    public List<GisNyxInsuranceListDto> queryAll() {
        List<GisNyxInsuranceList> gisNyxInsuranceListList=gisNyxInsuranceListDao.findAll();
        List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList=new ArrayList<GisNyxInsuranceListDto>();
        this.convertCollection(gisNyxInsuranceListList,gisNyxInsuranceListDtoList,GisNyxInsuranceListDto.class);
        return gisNyxInsuranceListDtoList;
    }

    /**
     * @description: 保存投保预确认农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisNyxInsuranceListDto
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor =Exception.class)
    public void saveGisNyxInsuranceList(GisNyxInsuranceListDto gisNyxInsuranceListDto) throws Exception {
        GisNyxInsuranceList gisNyxInsuranceList=convert(gisNyxInsuranceListDto,GisNyxInsuranceList.class);
        //查询最新serialNo
        //Integer serialNo=gisNyxInsuranceListDao.getMaxSerialNo(gisNyxInsuranceList.getInsureListCode())+1;
        //gisNyxInsuranceList.setSerialNo(serialNo);
        gisNyxInsuranceListDao.saveAndFlush(gisNyxInsuranceList);
    }

    /**
     * @description: 批量保存投保预确认农户清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisNyxInsuranceListDtoList
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor =Exception.class)
    public void saveGisNyxInsuranceList(List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList) throws Exception {
        List<GisNyxInsuranceList> gisNyxInsuranceListList=new ArrayList<GisNyxInsuranceList>();
        this.convertCollection(gisNyxInsuranceListDtoList,gisNyxInsuranceListList,GisNyxInsuranceList.class);
        gisNyxInsuranceListDao.save(gisNyxInsuranceListList);
//        if(gisNyxInsuranceListList.size()>0) {
//            //查询最新serialNo
//            Integer serialNo = gisNyxInsuranceListDao.getMaxSerialNo(gisNyxInsuranceListList.get(0).getInsureListCode())+1;
//            //序列号自增
//            for(GisNyxInsuranceList gisNyx:gisNyxInsuranceListList){
//                gisNyx.setSerialNo(serialNo++);
//            }
//            gisNyxInsuranceListDao.save(gisNyxInsuranceListList);
//        }
    }

}
