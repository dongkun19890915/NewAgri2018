package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelEngageSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelEngageSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelEngageSub;
import com.sinosoft.dms.core.model.entity.PrpModelEngageSubKey;
import com.sinosoft.dms.core.model.service.PrpModelEngageSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板特别约定表Core接口实现
 */
@Service
public class PrpModelEngageSubServiceImpl extends BaseServiceImpl implements PrpModelEngageSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelEngageSubServiceImpl.class);
    
    @Autowired
    private PrpModelEngageSubDao prpModelEngageSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelEngageSubDto prpModelEngageSubDto) {
        PrpModelEngageSub prpModelEngageSub = this.convert(prpModelEngageSubDto, PrpModelEngageSub.class);
        prpModelEngageSubDao.save(prpModelEngageSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String modelCode,Integer serialNo,Integer lineNo) {
        PrpModelEngageSubKey prpModelEngageSubKey = new PrpModelEngageSubKey(modelCode,serialNo,lineNo);
        prpModelEngageSubDao.delete(prpModelEngageSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpModelEngageSubDto prpModelEngageSubDto) {
        PrpModelEngageSub prpModelEngageSub = this.convert(prpModelEngageSubDto, PrpModelEngageSub.class);
        prpModelEngageSubDao.save(prpModelEngageSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpModelEngageSubDto queryByPK(String modelCode,Integer serialNo,Integer lineNo) {
        PrpModelEngageSubKey prpModelEngageSubKey = new PrpModelEngageSubKey(modelCode,serialNo,lineNo);
        PrpModelEngageSub prpModelEngageSub = prpModelEngageSubDao.findOne(prpModelEngageSubKey);
        return this.convert(prpModelEngageSub,PrpModelEngageSubDto.class);
    }
}