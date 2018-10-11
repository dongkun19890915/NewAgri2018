package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorHeadDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxEndorHeadDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorHead;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxEndorHeadKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEndorHeadService;
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
 * @description nyxendorheadCore接口实现
 */
@Service
public class NyxEndorHeadServiceImpl extends BaseServiceImpl implements NyxEndorHeadService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxEndorHeadServiceImpl.class);
    
    @Autowired
    private NyxEndorHeadDao nyxEndorHeadDao;

    /**
     *@description 新增
     *@param
     */
    public void save(NyxEndorHeadDto nyxEndorHeadDto)throws Exception {
        NyxEndorHead nyxEndorHead = this.convert(nyxEndorHeadDto, NyxEndorHead.class);
        nyxEndorHead.setIsDeleteFlag("1");
        nyxEndorHeadDao.save(nyxEndorHead);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String endorseNo)throws Exception {
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号为空！");
        }
        nyxEndorHeadDao.removeByEndorseNo(endorseNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxEndorHeadDto nyxEndorHeadDto) {
        NyxEndorHead nyxEndorHead = this.convert(nyxEndorHeadDto, NyxEndorHead.class);
        nyxEndorHeadDao.save(nyxEndorHead);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxEndorHeadDto queryByPK(String endorseNo) {
        NyxEndorHeadKey nyxEndorHeadKey = new NyxEndorHeadKey(endorseNo);
        NyxEndorHead nyxEndorHead = nyxEndorHeadDao.findOne(nyxEndorHeadKey);
        return this.convert(nyxEndorHead,NyxEndorHeadDto.class);
    }
}