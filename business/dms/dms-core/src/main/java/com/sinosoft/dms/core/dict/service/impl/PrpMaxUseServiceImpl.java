package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpMaxUseDto;
import com.sinosoft.dms.core.dict.dao.PrpMaxUseDao;
import com.sinosoft.dms.core.dict.entity.PrpMaxUse;
import com.sinosoft.dms.core.dict.entity.PrpMaxUseKey;
import com.sinosoft.dms.core.dict.service.PrpMaxUseService;
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
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxUseCore接口实现
 */
@Service
public class PrpMaxUseServiceImpl extends BaseServiceImpl implements PrpMaxUseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpMaxUseServiceImpl.class);
    
    @Autowired
    private PrpMaxUseDao prpMaxUseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpMaxUseDto prpMaxUseDto) {
        PrpMaxUse prpMaxUse = this.convert(prpMaxUseDto, PrpMaxUse.class);
        prpMaxUseDao.save(prpMaxUse);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String groupNo,String tableName,String maxNo) {
        PrpMaxUseKey prpMaxUseKey = new PrpMaxUseKey(groupNo,tableName,maxNo);
        prpMaxUseDao.delete(prpMaxUseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpMaxUseDto prpMaxUseDto) {
        PrpMaxUse prpMaxUse = this.convert(prpMaxUseDto, PrpMaxUse.class);
        prpMaxUseDao.save(prpMaxUse);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpMaxUseDto queryByPK(String groupNo,String tableName,String maxNo) {
        PrpMaxUseKey prpMaxUseKey = new PrpMaxUseKey(groupNo,tableName,maxNo);
        PrpMaxUse prpMaxUse = prpMaxUseDao.findOne(prpMaxUseKey);
        return this.convert(prpMaxUse,PrpMaxUseDto.class);
    }
}