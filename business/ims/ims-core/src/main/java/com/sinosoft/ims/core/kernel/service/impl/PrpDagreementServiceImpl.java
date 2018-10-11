package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.dto.PrpDagreementDto;
import com.sinosoft.ims.core.kernel.dao.PrpDagreementDao;
import com.sinosoft.ims.core.kernel.entity.PrpDagreement;
import com.sinosoft.ims.core.kernel.entity.PrpDagreementKey;
import com.sinosoft.ims.core.kernel.service.PrpDagreementService;
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
 * @time  2017-11-05 01:10:12.703 
 * @description 代理协议表Core接口实现
 */
@Service
public class PrpDagreementServiceImpl extends BaseServiceImpl implements PrpDagreementService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDagreementServiceImpl.class);
    
    @Autowired
    private PrpDagreementDao prpDagreementDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDagreementDto prpDagreementDto) {
        PrpDagreement prpDagreement = this.convert(prpDagreementDto, PrpDagreement.class);
        prpDagreementDao.save(prpDagreement);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String agreementNo) {
        PrpDagreementKey prpDagreementKey = new PrpDagreementKey(agreementNo);
        prpDagreementDao.delete(prpDagreementKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDagreementDto prpDagreementDto) {
        PrpDagreement prpDagreement = this.convert(prpDagreementDto, PrpDagreement.class);
        prpDagreementDao.save(prpDagreement);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDagreementDto queryByPK(String agreementNo) {
        PrpDagreementKey prpDagreementKey = new PrpDagreementKey(agreementNo);
        PrpDagreement prpDagreement = prpDagreementDao.findOne(prpDagreementKey);
        return this.convert(prpDagreement,PrpDagreementDto.class);
    }
}