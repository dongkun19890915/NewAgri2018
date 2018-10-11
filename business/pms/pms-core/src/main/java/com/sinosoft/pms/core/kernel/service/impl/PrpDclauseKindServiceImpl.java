package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseKindDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseKindDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKind;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKindKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseKindService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description 条款险别关系表Core接口实现
 */
@Service
public class PrpDclauseKindServiceImpl extends BaseServiceImpl implements PrpDclauseKindService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseKindServiceImpl.class);
    
    @Autowired
    private PrpDclauseKindDao prpDclauseKindDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDclauseKindDto prpDclauseKindDto) {
        PrpDclauseKind prpDclauseKind = this.convert(prpDclauseKindDto, PrpDclauseKind.class);
        prpDclauseKindDao.save(prpDclauseKind);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String clauseType,String kindCode,String relateKindCode) {
        PrpDclauseKindKey prpDclauseKindKey = new PrpDclauseKindKey(riskCode,clauseType,kindCode,relateKindCode);
        prpDclauseKindDao.delete(prpDclauseKindKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDclauseKindDto prpDclauseKindDto) {
        PrpDclauseKind prpDclauseKind = this.convert(prpDclauseKindDto, PrpDclauseKind.class);
        prpDclauseKindDao.save(prpDclauseKind);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDclauseKindDto queryByPK(String riskCode,String clauseType,String kindCode,String relateKindCode) {
        PrpDclauseKindKey prpDclauseKindKey = new PrpDclauseKindKey(riskCode,clauseType,kindCode,relateKindCode);
        PrpDclauseKind prpDclauseKind = prpDclauseKindDao.findOne(prpDclauseKindKey);
        return this.convert(prpDclauseKind,PrpDclauseKindDto.class);
    }
}