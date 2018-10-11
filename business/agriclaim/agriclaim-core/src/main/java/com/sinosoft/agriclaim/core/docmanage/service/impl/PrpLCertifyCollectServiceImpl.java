package com.sinosoft.agriclaim.core.docmanage.service.impl;

import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyCollectDto;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLCertifyCollectDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyCollect;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLCertifyCollectKey;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyCollectService;
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
 * @time  2017-11-08 05:41:23.407 
 * @description 单证收集表Core接口实现
 */
@Service
public class PrpLCertifyCollectServiceImpl extends BaseServiceImpl implements PrpLCertifyCollectService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCertifyCollectServiceImpl.class);
    
    @Autowired
    private PrpLCertifyCollectDao prpLCertifyCollectDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCertifyCollectDto prpLCertifyCollectDto) {
        PrpLCertifyCollect prpLCertifyCollect = this.convert(prpLCertifyCollectDto, PrpLCertifyCollect.class);
        prpLCertifyCollectDao.save(prpLCertifyCollect);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String businessNo,String lossItemCode) {
        PrpLCertifyCollectKey prpLCertifyCollectKey = new PrpLCertifyCollectKey(businessNo,lossItemCode);
        prpLCertifyCollectDao.delete(prpLCertifyCollectKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCertifyCollectDto prpLCertifyCollectDto) {
        PrpLCertifyCollect prpLCertifyCollect = this.convert(prpLCertifyCollectDto, PrpLCertifyCollect.class);
        prpLCertifyCollectDao.save(prpLCertifyCollect);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCertifyCollectDto queryByPK(String businessNo,String lossItemCode) {
        PrpLCertifyCollectKey prpLCertifyCollectKey = new PrpLCertifyCollectKey(businessNo,lossItemCode);
        PrpLCertifyCollect prpLCertifyCollect = prpLCertifyCollectDao.findOne(prpLCertifyCollectKey);
        return this.convert(prpLCertifyCollect,PrpLCertifyCollectDto.class);
    }
}