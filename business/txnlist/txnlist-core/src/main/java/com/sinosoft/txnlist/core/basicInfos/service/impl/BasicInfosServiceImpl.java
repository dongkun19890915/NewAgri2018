package com.sinosoft.txnlist.core.basicInfos.service.impl;

import com.sinosoft.txnlist.api.basicInfos.dto.BasicInfosDto;
import com.sinosoft.txnlist.core.basicInfos.dao.BasicInfosDao;
import com.sinosoft.txnlist.core.basicInfos.entity.BasicInfos;
import com.sinosoft.txnlist.core.basicInfos.entity.BasicInfosKey;
import com.sinosoft.txnlist.core.basicInfos.service.BasicInfosService;
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
 * @time  2017-10-23 12:58:53.230 
 * @description basicInfosCore接口实现
 */
@Service
public class BasicInfosServiceImpl extends BaseServiceImpl implements BasicInfosService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicInfosServiceImpl.class);
    
    @Autowired
    private BasicInfosDao basicInfosDao;

    /**
     *@description 新增
     *@param
     */
    public void save(BasicInfosDto basicInfosDto) {
        BasicInfos basicInfos = this.convert(basicInfosDto, BasicInfos.class);
        basicInfosDao.save(basicInfos);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String code) {
        BasicInfosKey basicInfosKey = new BasicInfosKey(code);
        basicInfosDao.delete(basicInfosKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(BasicInfosDto basicInfosDto) {
        BasicInfos basicInfos = this.convert(basicInfosDto, BasicInfos.class);
        basicInfosDao.save(basicInfos);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public BasicInfosDto queryByPK(String code) {
        BasicInfosKey basicInfosKey = new BasicInfosKey(code);
        BasicInfos basicInfos = basicInfosDao.findOne(basicInfosKey);
        return this.convert(basicInfos,BasicInfosDto.class);
    }
}