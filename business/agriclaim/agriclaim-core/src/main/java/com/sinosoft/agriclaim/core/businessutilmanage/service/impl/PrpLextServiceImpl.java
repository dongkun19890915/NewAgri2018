package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLextDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLext;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLextKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLextService;
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
 * @description 理赔扩展系统表Core接口实现
 */
@Service
public class PrpLextServiceImpl extends BaseServiceImpl implements PrpLextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLextServiceImpl.class);
    
    @Autowired
    private PrpLextDao prpLextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLextDto prpLextDto) {
        PrpLext prpLext = this.convert(prpLextDto, PrpLext.class);
        prpLextDao.save(prpLext);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String certiNo,String certiType) {
        PrpLextKey prpLextKey = new PrpLextKey(certiNo,certiType);
        prpLextDao.delete(prpLextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLextDto prpLextDto) {
        PrpLext prpLext = this.convert(prpLextDto, PrpLext.class);
        prpLextDao.save(prpLext);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLextDto queryByPK(String certiNo,String certiType) {
        PrpLextKey prpLextKey = new PrpLextKey(certiNo,certiType);
        PrpLext prpLext = prpLextDao.findOne(prpLextKey);
        return this.convert(prpLext,PrpLextDto.class);
    }
}