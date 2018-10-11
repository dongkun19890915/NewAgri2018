package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelItemKindDto;
import com.sinosoft.dms.core.model.dao.PrpModelItemKindDao;
import com.sinosoft.dms.core.model.entity.PrpModelItemKind;
import com.sinosoft.dms.core.model.entity.PrpModelItemKindKey;
import com.sinosoft.dms.core.model.service.PrpModelItemKindService;
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
 * @time  2017-11-16 01:04:20.471 
 * @description 标的子险信息Core接口实现
 */
@Service
public class PrpModelItemKindServiceImpl extends BaseServiceImpl implements PrpModelItemKindService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelItemKindServiceImpl.class);
    
    @Autowired
    private PrpModelItemKindDao prpModelItemKindDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpModelItemKindDto prpModelItemKindDto) {
        PrpModelItemKind prpModelItemKind = this.convert(prpModelItemKindDto, PrpModelItemKind.class);
        prpModelItemKindDao.save(prpModelItemKind);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String modelCode,Integer itemKindNo) {
        PrpModelItemKindKey prpModelItemKindKey = new PrpModelItemKindKey(modelCode,itemKindNo);
        prpModelItemKindDao.delete(prpModelItemKindKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpModelItemKindDto prpModelItemKindDto) {
        PrpModelItemKind prpModelItemKind = this.convert(prpModelItemKindDto, PrpModelItemKind.class);
        prpModelItemKindDao.save(prpModelItemKind);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpModelItemKindDto queryByPK(String modelCode,Integer itemKindNo) {
        PrpModelItemKindKey prpModelItemKindKey = new PrpModelItemKindKey(modelCode,itemKindNo);
        PrpModelItemKind prpModelItemKind = prpModelItemKindDao.findOne(prpModelItemKindKey);
        return this.convert(prpModelItemKind,PrpModelItemKindDto.class);
    }
}