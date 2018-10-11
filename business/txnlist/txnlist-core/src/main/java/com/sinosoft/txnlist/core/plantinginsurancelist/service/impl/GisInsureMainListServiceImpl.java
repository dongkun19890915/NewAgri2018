package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.core.gisinsurelist.dao.GisInsureMainListDao;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisInsureMainList;
import com.sinosoft.txnlist.core.gisinsurelist.entity.GisInsureMainListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.GisInsureMainListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 投保预确认清单数据表service实现层
 *
 * @Author: 汪强
 * @Date: 9:00 2017/11/06
 */

@Service
public class GisInsureMainListServiceImpl extends BaseServiceImpl implements GisInsureMainListService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GisInsureMainListServiceImpl.class);

    @Autowired
    GisInsureMainListDao gisInsureMainListDao;


    /**
     * 查询全部投保预确认清单数据表
     * @param
     * @return List<GisInsureMainListDto>
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisInsureMainListDto> queryAll() {
        List<GisInsureMainListDto> gisInsureMainListDtoList = new ArrayList<GisInsureMainListDto>();
        List<GisInsureMainList> gisInsureMainListList = gisInsureMainListDao.findAll();
        this.convertCollection(gisInsureMainListList, gisInsureMainListDtoList, GisInsureMainListDto.class);
        return gisInsureMainListDtoList;
    }


    /**
     * @description: 根据主键查询清单数据表
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insureListCode
     * @param serialNo
     * @return GisInsureMainListDto
     * @throws Exception
     */
    @Override
    public GisInsureMainListDto get(String insureListCode,Integer serialNo){
        GisInsureMainListKey gisInsureMainListKey=new GisInsureMainListKey(insureListCode,serialNo);
        GisInsureMainList gisInsureMainList=gisInsureMainListDao.getOne(gisInsureMainListKey);
        GisInsureMainListDto gisInsureMainListDto=this.convert(gisInsureMainList,GisInsureMainListDto.class);
        return gisInsureMainListDto;
    }

    /**
     * 保存投保预确认清单数据表
     * @param gisInsureMainListDto
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveGisInsureMainList(GisInsureMainListDto gisInsureMainListDto) throws Exception {
        GisInsureMainList gisInsureMainList = convert(gisInsureMainListDto, GisInsureMainList.class);
        //清单号
        String insureListCode=gisInsureMainList.getInsureListCode();
        //新保单标志默认值 Y
        gisInsureMainList.setNewFlag("Y");

        //主键 清单编号+序列号  insureListCode+serialNo
        //1、生成最新序列号 如果没有查到则为零
        Integer serialNo = gisInsureMainListDao.getMaxSerialNo(insureListCode) + 1;
        //2、判断是否最新保单标志 Y N 如果序列号为1 则说明是库里没有记录，是最新保单
        if(serialNo>1){
            //3、修改库里其它记录为非最新保单标志
            gisInsureMainListDao.updateNewFlag(insureListCode,"N");
        }

        //设置最新序列号
        gisInsureMainList.setSerialNo(serialNo);

        //4、保存数据
        gisInsureMainListDao.save(gisInsureMainList);

        return serialNo;
    }

    /**
     * 批量保存投保预确认清单数据表
     * @param gisInsureMainListDtoList
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveGisInsureMainList(List<GisInsureMainListDto> gisInsureMainListDtoList) throws Exception {
        List<GisInsureMainList> gisInsureMainListList = new ArrayList<GisInsureMainList>();
        this.convertCollection(gisInsureMainListDtoList, gisInsureMainListList, GisInsureMainList.class);
        gisInsureMainListDao.save(gisInsureMainListList);
    }
}
