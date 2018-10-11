package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLEndorDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLEndorDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLEndor;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLEndorKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLEndorService;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔冲减保额表Core接口实现
 */
@Service
public class PrpLEndorServiceImpl extends BaseServiceImpl implements PrpLEndorService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLEndorServiceImpl.class);
    
    @Autowired
    private PrpLEndorDao prpLEndorDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLEndorDto prpLEndorDto) {
        PrpLEndor prpLEndor = this.convert(prpLEndorDto, PrpLEndor.class);
        prpLEndorDao.save(prpLEndor);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String compensateNo,String policyNo,String endorType) {
        PrpLEndorKey prpLEndorKey = new PrpLEndorKey(compensateNo,policyNo,endorType);
        prpLEndorDao.delete(prpLEndorKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLEndorDto prpLEndorDto) {
        PrpLEndor prpLEndor = this.convert(prpLEndorDto, PrpLEndor.class);
        prpLEndorDao.save(prpLEndor);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEndorDto queryByPK(String compensateNo,String policyNo,String endorType) {
        PrpLEndorKey prpLEndorKey = new PrpLEndorKey(compensateNo,policyNo,endorType);
        PrpLEndor prpLEndor = prpLEndorDao.findOne(prpLEndorKey);
        return this.convert(prpLEndor,PrpLEndorDto.class);
    }
}