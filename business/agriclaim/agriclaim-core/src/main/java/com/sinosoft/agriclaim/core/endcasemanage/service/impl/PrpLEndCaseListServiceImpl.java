package com.sinosoft.agriclaim.core.endcasemanage.service.impl;

import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLEndCaseListDto;
import com.sinosoft.agriclaim.core.endcasemanage.dao.PrpLEndCaseListDao;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLEndCaseList;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLEndCaseListKey;
import com.sinosoft.agriclaim.core.endcasemanage.service.PrpLEndCaseListService;
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
 * @time  2017-11-08 05:42:04.174 
 * @description 结案基本信息表Core接口实现
 */
@Service
public class PrpLEndCaseListServiceImpl extends BaseServiceImpl implements PrpLEndCaseListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLEndCaseListServiceImpl.class);
    
    @Autowired
    private PrpLEndCaseListDao prpLEndCaseListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLEndCaseListDto prpLEndCaseListDto) {
        PrpLEndCaseList prpLEndCaseList = this.convert(prpLEndCaseListDto, PrpLEndCaseList.class);
        prpLEndCaseListDao.save(prpLEndCaseList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(java.lang.Integer id) {
        PrpLEndCaseListKey prpLEndCaseListKey = new PrpLEndCaseListKey(id);
        prpLEndCaseListDao.delete(prpLEndCaseListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLEndCaseListDto prpLEndCaseListDto) {
        PrpLEndCaseList prpLEndCaseList = this.convert(prpLEndCaseListDto, PrpLEndCaseList.class);
        prpLEndCaseListDao.save(prpLEndCaseList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEndCaseListDto queryByPK(java.lang.Integer id) {
        PrpLEndCaseListKey prpLEndCaseListKey = new PrpLEndCaseListKey(id);
        PrpLEndCaseList prpLEndCaseList = prpLEndCaseListDao.findOne(prpLEndCaseListKey);
        return this.convert(prpLEndCaseList,PrpLEndCaseListDto.class);
    }
}