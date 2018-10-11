package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelAddressSubDto;
import com.sinosoft.dms.core.model.dao.PrpModelAddressSubDao;
import com.sinosoft.dms.core.model.entity.PrpModelAddressSub;
import com.sinosoft.dms.core.model.entity.PrpModelAddressSubKey;
import com.sinosoft.dms.core.model.service.PrpModelAddressSubService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * @description 模板保险地址表Core接口实现
 */
@Service
public class PrpModelAddressSubServiceImpl extends BaseServiceImpl implements PrpModelAddressSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelAddressSubServiceImpl.class);
    
    @Autowired
    private PrpModelAddressSubDao prpModelAddressSubDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpModelAddressSubDto prpModelAddressSubDto) {
        PrpModelAddressSub prpModelAddressSub = this.convert(prpModelAddressSubDto, PrpModelAddressSub.class);
        prpModelAddressSubDao.save(prpModelAddressSub);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String modelCode,Integer addressNo) {
        PrpModelAddressSubKey prpModelAddressSubKey = new PrpModelAddressSubKey(modelCode,addressNo);
        prpModelAddressSubDao.delete(prpModelAddressSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpModelAddressSubDto prpModelAddressSubDto) {
        PrpModelAddressSub prpModelAddressSub = this.convert(prpModelAddressSubDto, PrpModelAddressSub.class);
        prpModelAddressSubDao.save(prpModelAddressSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpModelAddressSubDto queryByPK(String modelCode,Integer addressNo) {
        PrpModelAddressSubKey prpModelAddressSubKey = new PrpModelAddressSubKey(modelCode,addressNo);
        PrpModelAddressSub prpModelAddressSub = prpModelAddressSubDao.findOne(prpModelAddressSubKey);
        return this.convert(prpModelAddressSub,PrpModelAddressSubDto.class);
    }
}