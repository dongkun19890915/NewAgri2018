package com.sinosoft.agriclaim.core.docmanage.service.impl;

import com.sinosoft.agriclaim.api.docmanage.dto.PrplCertifyDirectDto;
//import com.sinosoft.agriclaim.core.checkmanage.dao.PrplCertifyDirectDao;
//import com.sinosoft.agriclaim.core.checkmanage.entity.PrplCertifyDirect;
//import com.sinosoft.agriclaim.core.checkmanage.entity.PrplCertifyDirectKey;
//import com.sinosoft.agriclaim.core.checkmanage.service.PrplCertifyDirectService;
import com.sinosoft.agriclaim.core.docmanage.dao.PrplCertifyDirectDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirect;
import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirectKey;
import com.sinosoft.agriclaim.core.docmanage.service.PrplCertifyDirectService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * @description 索赔指引表Core接口实现
 */
@Service
public class PrplCertifyDirectServiceImpl extends BaseServiceImpl implements PrplCertifyDirectService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrplCertifyDirectServiceImpl.class);
    
    @Autowired
    private PrplCertifyDirectDao prplCertifyDirectDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrplCertifyDirectDto prplCertifyDirectDto) {
        PrplCertifyDirect prplCertifyDirect = this.convert(prplCertifyDirectDto, PrplCertifyDirect.class);
        prplCertifyDirectDao.save(prplCertifyDirect);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,Integer serialNo,String lossItemCode) {
        PrplCertifyDirectKey prplCertifyDirectKey = new PrplCertifyDirectKey(registNo,serialNo,lossItemCode);
        prplCertifyDirectDao.delete(prplCertifyDirectKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrplCertifyDirectDto prplCertifyDirectDto) {
        PrplCertifyDirect prplCertifyDirect = this.convert(prplCertifyDirectDto, PrplCertifyDirect.class);
        prplCertifyDirectDao.save(prplCertifyDirect);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrplCertifyDirectDto queryByPK(String registNo,Integer serialNo,String lossItemCode) {
        PrplCertifyDirectKey prplCertifyDirectKey = new PrplCertifyDirectKey(registNo,serialNo,lossItemCode);
        PrplCertifyDirect prplCertifyDirect = prplCertifyDirectDao.findOne(prplCertifyDirectKey);
        return this.convert(prplCertifyDirect,PrplCertifyDirectDto.class);
    }
}