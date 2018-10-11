package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.dto.PrpDconfigCodeDto;
import com.sinosoft.ims.core.kernel.dao.PrpDconfigCodeDao;
import com.sinosoft.ims.core.kernel.entity.PrpDconfigCode;
import com.sinosoft.ims.core.kernel.entity.PrpDconfigCodeKey;
import com.sinosoft.ims.core.kernel.service.PrpDconfigCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description 开关配置表Core接口实现
 */
@Service
public class PrpDconfigCodeServiceImpl extends BaseServiceImpl implements PrpDconfigCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDconfigCodeServiceImpl.class);
    
    @Autowired
    private PrpDconfigCodeDao prpDconfigCodeDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDconfigCodeDto prpDconfigCodeDto) {
        PrpDconfigCode prpDconfigCode = this.convert(prpDconfigCodeDto, PrpDconfigCode.class);
        prpDconfigCodeDao.save(prpDconfigCode);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(java.util.Date id) {
        PrpDconfigCodeKey prpDconfigCodeKey = new PrpDconfigCodeKey(id);
        prpDconfigCodeDao.delete(prpDconfigCodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDconfigCodeDto prpDconfigCodeDto) {
        PrpDconfigCode prpDconfigCode = this.convert(prpDconfigCodeDto, PrpDconfigCode.class);
        prpDconfigCodeDao.save(prpDconfigCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDconfigCodeDto queryByPK(java.util.Date id) {
        PrpDconfigCodeKey prpDconfigCodeKey = new PrpDconfigCodeKey(id);
        PrpDconfigCode prpDconfigCode = prpDconfigCodeDao.findOne(prpDconfigCodeKey);
        return this.convert(prpDconfigCode,PrpDconfigCodeDto.class);
    }
}