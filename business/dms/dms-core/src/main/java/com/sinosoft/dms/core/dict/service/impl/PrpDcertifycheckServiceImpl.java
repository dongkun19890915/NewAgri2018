package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDcertifycheckDto;
import com.sinosoft.dms.core.dict.dao.PrpDcertifycheckDao;
import com.sinosoft.dms.core.dict.entity.PrpDcertifycheck;
import com.sinosoft.dms.core.dict.entity.PrpDcertifycheckKey;
import com.sinosoft.dms.core.dict.service.PrpDcertifycheckService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-04 09:05:54.250 
 * @description 单证校验信息表Core接口实现
 */
@Service
public class PrpDcertifycheckServiceImpl extends BaseServiceImpl implements PrpDcertifycheckService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcertifycheckServiceImpl.class);
    
    @Autowired
    private PrpDcertifycheckDao prpDcertifycheckDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDcertifycheckDto prpDcertifycheckDto) {
        PrpDcertifycheck prpDcertifycheck = this.convert(prpDcertifycheckDto, PrpDcertifycheck.class);
        prpDcertifycheckDao.save(prpDcertifycheck);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode,String nodeType,String certifyType) {
        PrpDcertifycheckKey prpDcertifycheckKey = new PrpDcertifycheckKey(riskCode,nodeType,certifyType);
        prpDcertifycheckDao.delete(prpDcertifycheckKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDcertifycheckDto prpDcertifycheckDto) {
        PrpDcertifycheck prpDcertifycheck = this.convert(prpDcertifycheckDto, PrpDcertifycheck.class);
        prpDcertifycheckDao.save(prpDcertifycheck);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDcertifycheckDto queryByPK(String riskCode,String nodeType,String certifyType) {
        PrpDcertifycheckKey prpDcertifycheckKey = new PrpDcertifycheckKey(riskCode,nodeType,certifyType);
        PrpDcertifycheck prpDcertifycheck = prpDcertifycheckDao.findOne(prpDcertifycheckKey);
        return this.convert(prpDcertifycheck,PrpDcertifycheckDto.class);
    }
}