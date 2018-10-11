package com.sinosoft.ims.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.dto.PrpDagreeDetailDto;
import com.sinosoft.ims.core.kernel.dao.PrpDagreeDetailDao;
import com.sinosoft.ims.core.kernel.entity.PrpDagreeDetail;
import com.sinosoft.ims.core.kernel.entity.PrpDagreeDetailKey;
import com.sinosoft.ims.core.kernel.service.PrpDagreeDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDagreeDetailCore接口实现
 */
@Service
public class PrpDagreeDetailServiceImpl extends BaseServiceImpl implements PrpDagreeDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDagreeDetailServiceImpl.class);
    
    @Autowired
    private PrpDagreeDetailDao prpDagreeDetailDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDagreeDetailDto prpDagreeDetailDto) {
        PrpDagreeDetail prpDagreeDetail = this.convert(prpDagreeDetailDto, PrpDagreeDetail.class);
        prpDagreeDetailDao.save(prpDagreeDetail);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String agreementNo,String riskCode) {
        PrpDagreeDetailKey prpDagreeDetailKey = new PrpDagreeDetailKey(agreementNo,riskCode);
        prpDagreeDetailDao.delete(prpDagreeDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDagreeDetailDto prpDagreeDetailDto) {
        PrpDagreeDetail prpDagreeDetail = this.convert(prpDagreeDetailDto, PrpDagreeDetail.class);
        prpDagreeDetailDao.save(prpDagreeDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDagreeDetailDto queryByPK(String agreementNo,String riskCode) {
        PrpDagreeDetailKey prpDagreeDetailKey = new PrpDagreeDetailKey(agreementNo,riskCode);
        PrpDagreeDetail prpDagreeDetail = prpDagreeDetailDao.findOne(prpDagreeDetailKey);
        return this.convert(prpDagreeDetail,PrpDagreeDetailDto.class);
    }
}