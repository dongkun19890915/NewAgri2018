package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdSettleListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdSettleListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdSettleList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdSettleListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdSettleListService;
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
 * @description 养殖险理赔明细表Core接口实现
 */
@Service
public class HerdSettleListServiceImpl extends BaseServiceImpl implements HerdSettleListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdSettleListServiceImpl.class);
    
    @Autowired
    private HerdSettleListDao herdSettleListDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(HerdSettleListDto herdSettleListDto) {
        HerdSettleList herdSettleList = this.convert(herdSettleListDto, HerdSettleList.class);
        herdSettleListDao.save(herdSettleList);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        HerdSettleListKey herdSettleListKey = new HerdSettleListKey(settleListCode,earLabel,fCode,kindCode,serialNo);
        herdSettleListDao.delete(herdSettleListKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(HerdSettleListDto herdSettleListDto) {
        HerdSettleList herdSettleList = this.convert(herdSettleListDto, HerdSettleList.class);
        herdSettleListDao.save(herdSettleList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public HerdSettleListDto queryByPK(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        HerdSettleListKey herdSettleListKey = new HerdSettleListKey(settleListCode,earLabel,fCode,kindCode,serialNo);
        HerdSettleList herdSettleList = herdSettleListDao.findOne(herdSettleListKey);
        return this.convert(herdSettleList,HerdSettleListDto.class);
    }

    /**
     *  根据GIS清单号查询承保清单 养殖险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    @Override
    public List<HerdSettleListDto> queryByGisInsureListCode(String gisInsureListCode)throws Exception{
        if(StringUtils.isEmpty(gisInsureListCode)){
            LOGGER.warn("请求参数不能为空");
            throw new DataVerifyException("请求参数不能为空！");
        }
        //RISKCODE=3107原方法
        //RISKCODE=3220 查HERDSETTLELIST

        List<HerdSettleList> herdSettleListList =herdSettleListDao.queryByGisInsureListCode(gisInsureListCode);
        List<HerdSettleListDto> herdSettleListDtoList = new ArrayList<HerdSettleListDto>();
        this.convertCollection(herdSettleListList, herdSettleListDtoList, HerdSettleListDto.class);
        return herdSettleListDtoList;
    }
}