package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPtextDto;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPtextDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPtext;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPtextKey;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPtextService;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔文字表Core接口实现
 */
@Service
public class PrpLPtextServiceImpl extends BaseServiceImpl implements PrpLPtextService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLPtextServiceImpl.class);
    
    @Autowired
    private PrpLPtextDao prpLPtextDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLPtextDto prpLPtextDto) {
        PrpLPtext prpLPtext = this.convert(prpLPtextDto, PrpLPtext.class);
        prpLPtextDao.save(prpLPtext);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String preCompensateNo,java.lang.Double lineNo) {
        PrpLPtextKey prpLPtextKey = new PrpLPtextKey(preCompensateNo,lineNo);
        prpLPtextDao.delete(prpLPtextKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLPtextDto prpLPtextDto) {
        PrpLPtext prpLPtext = this.convert(prpLPtextDto, PrpLPtext.class);
        prpLPtextDao.save(prpLPtext);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPtextDto queryByPK(String preCompensateNo,java.lang.Double lineNo) {
        PrpLPtextKey prpLPtextKey = new PrpLPtextKey(preCompensateNo,lineNo);
        PrpLPtext prpLPtext = prpLPtextDao.findOne(prpLPtextKey);
        return this.convert(prpLPtext,PrpLPtextDto.class);
    }
}