package com.sinosoft.dms.core.model.service.impl;

import com.sinosoft.dms.api.model.dto.PrpModelItemKindAgriDto;
import com.sinosoft.dms.core.model.dao.PrpModelItemKindAgriDao;
import com.sinosoft.dms.core.model.entity.PrpModelItemKindAgri;
import com.sinosoft.dms.core.model.entity.PrpModelItemKindAgriKey;
import com.sinosoft.dms.core.model.service.PrpModelItemKindAgriService;
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
 * @description 模板农险标的附加表Core接口实现
 */
@Service
public class PrpModelItemKindAgriServiceImpl extends BaseServiceImpl implements PrpModelItemKindAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpModelItemKindAgriServiceImpl.class);
    
    @Autowired
    private PrpModelItemKindAgriDao prpModelItemKindAgriDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpModelItemKindAgriDto prpModelItemKindAgriDto) {
        PrpModelItemKindAgri prpModelItemKindAgri = this.convert(prpModelItemKindAgriDto, PrpModelItemKindAgri.class);
        prpModelItemKindAgriDao.save(prpModelItemKindAgri);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String modelCode,Integer itemKindNo,String kindCode,Integer times) {
        PrpModelItemKindAgriKey prpModelItemKindAgriKey = new PrpModelItemKindAgriKey(modelCode,itemKindNo,kindCode,times);
        prpModelItemKindAgriDao.delete(prpModelItemKindAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpModelItemKindAgriDto prpModelItemKindAgriDto) {
        PrpModelItemKindAgri prpModelItemKindAgri = this.convert(prpModelItemKindAgriDto, PrpModelItemKindAgri.class);
        prpModelItemKindAgriDao.save(prpModelItemKindAgri);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpModelItemKindAgriDto queryByPK(String modelCode,Integer itemKindNo,String kindCode,Integer times) {
        PrpModelItemKindAgriKey prpModelItemKindAgriKey = new PrpModelItemKindAgriKey(modelCode,itemKindNo,kindCode,times);
        PrpModelItemKindAgri prpModelItemKindAgri = prpModelItemKindAgriDao.findOne(prpModelItemKindAgriKey);
        return this.convert(prpModelItemKindAgri,PrpModelItemKindAgriDto.class);
    }
}