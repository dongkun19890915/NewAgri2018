package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrplQualityCheckDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrplQualityCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheckKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrplQualityCheckService;
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
 * @time  2017-11-10 02:44:49.773 
 * @description 质量评审内容表Core接口实现
 */
@Service
public class PrplQualityCheckServiceImpl extends BaseServiceImpl implements PrplQualityCheckService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrplQualityCheckServiceImpl.class);
    
    @Autowired
    private PrplQualityCheckDao prplQualityCheckDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrplQualityCheckDto prplQualityCheckDto) {
        PrplQualityCheck prplQualityCheck = this.convert(prplQualityCheckDto, PrplQualityCheck.class);
        prplQualityCheckDao.save(prplQualityCheck);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo,String qualityCheckType,java.lang.Integer serialNo) {
        PrplQualityCheckKey prplQualityCheckKey = new PrplQualityCheckKey(registNo,qualityCheckType,serialNo);
        prplQualityCheckDao.delete(prplQualityCheckKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrplQualityCheckDto prplQualityCheckDto) {
        PrplQualityCheck prplQualityCheck = this.convert(prplQualityCheckDto, PrplQualityCheck.class);
        prplQualityCheckDao.save(prplQualityCheck);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrplQualityCheckDto queryByPK(String registNo,String qualityCheckType,java.lang.Integer serialNo) {
        PrplQualityCheckKey prplQualityCheckKey = new PrplQualityCheckKey(registNo,qualityCheckType,serialNo);
        PrplQualityCheck prplQualityCheck = prplQualityCheckDao.findOne(prplQualityCheckKey);
        return this.convert(prplQualityCheck,PrplQualityCheckDto.class);
    }
}