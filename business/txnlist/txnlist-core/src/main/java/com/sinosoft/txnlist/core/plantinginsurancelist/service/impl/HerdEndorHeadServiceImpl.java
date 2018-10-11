package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorHeadDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdEndorHeadDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdEndorHeadKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdEndorHeadService;
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
 * @description 批改头表Core接口实现
 */
@Service
public class HerdEndorHeadServiceImpl extends BaseServiceImpl implements HerdEndorHeadService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdEndorHeadServiceImpl.class);
    
    @Autowired
    private HerdEndorHeadDao herdEndorHeadDao;

    /**
     *@description 新增
     *@param
     */
    public void save(HerdEndorHeadDto herdEndorHeadDto) {
        HerdEndorHead herdEndorHead = this.convert(herdEndorHeadDto, HerdEndorHead.class);
        herdEndorHead.setIsDeleteFlag("1");
        herdEndorHeadDao.save(herdEndorHead);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String endorseNo) {
        HerdEndorHeadKey herdEndorHeadKey = new HerdEndorHeadKey(endorseNo);
        herdEndorHeadDao.delete(herdEndorHeadKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(HerdEndorHeadDto herdEndorHeadDto) {
        HerdEndorHead herdEndorHead = this.convert(herdEndorHeadDto, HerdEndorHead.class);
        herdEndorHeadDao.save(herdEndorHead);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public HerdEndorHeadDto queryByPK(String endorseNo) {
        HerdEndorHeadKey herdEndorHeadKey = new HerdEndorHeadKey(endorseNo);
        HerdEndorHead herdEndorHead = herdEndorHeadDao.findOne(herdEndorHeadKey);
        return this.convert(herdEndorHead,HerdEndorHeadDto.class);
    }
}