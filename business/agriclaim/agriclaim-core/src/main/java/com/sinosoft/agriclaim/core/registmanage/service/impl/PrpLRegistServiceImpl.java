package com.sinosoft.agriclaim.core.registmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistService;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息表Core接口实现
 */
@Service
public class PrpLRegistServiceImpl extends BaseServiceImpl implements PrpLRegistService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLRegistServiceImpl.class);
    
    @Autowired
    private PrpLRegistDao prpLRegistDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLRegistDto prpLRegistDto) {
        PrpLRegist prpLRegist = this.convert(prpLRegistDto, PrpLRegist.class);
        prpLRegistDao.save(prpLRegist);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo) {
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey(registNo);
        prpLRegistDao.delete(prpLRegistKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLRegistDto prpLRegistDto) {
        PrpLRegist prpLRegist = this.convert(prpLRegistDto, PrpLRegist.class);
        prpLRegistDao.save(prpLRegist);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistDto queryByPK(String registNo) {
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey(registNo);
        PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
        return this.convert(prpLRegist,PrpLRegistDto.class);
    }
}