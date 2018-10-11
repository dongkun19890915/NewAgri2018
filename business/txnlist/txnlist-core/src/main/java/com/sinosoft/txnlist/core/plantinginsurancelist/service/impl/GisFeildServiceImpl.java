package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.GisFeildDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisFeild;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.GisFeildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 投保预确认农户田块清单表（种植险）service层
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */

@Service
public class GisFeildServiceImpl extends BaseServiceImpl implements GisFeildService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GisFeildServiceImpl.class);

    @Autowired
    GisFeildDao gisFeildDao;

    /**
     * @description: 查询农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public List<GisFeildDto> queryAll() {
        List<GisFeild> gisNyxPolicyListOriginList=gisFeildDao.findAll();
        List<GisFeildDto> gisFeildDtoList=new ArrayList<GisFeildDto>();
        this.convertCollection(gisNyxPolicyListOriginList,gisFeildDtoList,GisFeildDto.class);
        return gisFeildDtoList;
    }

    /**
     * @description: 保存投保预确认农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisFeildDto
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor =Exception.class)
    public void saveGisFeild(GisFeildDto gisFeildDto) throws Exception {
        GisFeild gisFeild=convert(gisFeildDto,GisFeild.class);
        //查询最新serialNo
        //Integer serialNo=gisFeildDao.getMaxSerialNo(gisFeild.getInsureListCode())+1;
        //gisFeild.setSerialNo(serialNo);
        gisFeildDao.saveAndFlush(gisFeild);
    }

    /**
     * @description: 批量保存投保预确认农户田块清单表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisFeildDtoList
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor =Exception.class)
    public void saveGisFeild(List<GisFeildDto> gisFeildDtoList) throws Exception {
        List<GisFeild> gisFeildList=new ArrayList<GisFeild>();
        this.convertCollection(gisFeildDtoList,gisFeildList,GisFeild.class);
        gisFeildDao.save(gisFeildList);
//        if(gisFeildList.size()>0) {
//            //查询最新serialNo
//            Integer serialNo = gisFeildDao.getMaxSerialNo(gisFeildList.get(0).getInsureListCode())+1;
//            //序列号自增
//            for(GisFeild gisFeild:gisFeildList){
//                gisFeild.setSerialNo(serialNo++);
//            }
//            gisFeildDao.save(gisFeildList);
//        }
    }

}
