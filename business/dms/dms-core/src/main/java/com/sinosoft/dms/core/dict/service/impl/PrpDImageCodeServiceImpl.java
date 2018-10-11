package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDImageCodeDto;
import com.sinosoft.dms.core.dict.dao.PrpDImageCodeDao;
import com.sinosoft.dms.core.dict.entity.PrpDImageCode;
import com.sinosoft.dms.core.dict.entity.PrpDImageCodeKey;
import com.sinosoft.dms.core.dict.service.PrpDImageCodeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 03:00:47.370 
 * @description 承保理赔镜像代码表Core接口实现
 */
@Service
public class PrpDImageCodeServiceImpl extends BaseServiceImpl implements PrpDImageCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDImageCodeServiceImpl.class);
    
    @Autowired
    private PrpDImageCodeDao prpDImageCodeDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDImageCodeDto prpDImageCodeDto) {
        PrpDImageCode prpDImageCode = this.convert(prpDImageCodeDto, PrpDImageCode.class);
        prpDImageCodeDao.save(prpDImageCode);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode,String comCode) {
        PrpDImageCodeKey prpDImageCodeKey = new PrpDImageCodeKey(riskCode,comCode);
        prpDImageCodeDao.delete(prpDImageCodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDImageCodeDto prpDImageCodeDto) {
        PrpDImageCode prpDImageCode = this.convert(prpDImageCodeDto, PrpDImageCode.class);
        prpDImageCodeDao.save(prpDImageCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDImageCodeDto queryByPK(String riskCode,String comCode) {
        PrpDImageCodeKey prpDImageCodeKey = new PrpDImageCodeKey(riskCode,comCode);
        PrpDImageCode prpDImageCode = prpDImageCodeDao.findOne(prpDImageCodeKey);
        return this.convert(prpDImageCode,PrpDImageCodeDto.class);
    }
}