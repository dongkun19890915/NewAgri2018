package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindHisDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseCodeKindHisDao;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKindHis;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKindHisKey;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeKindHisService;
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
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置轨迹表Core接口实现
 */
@Service
public class PrpDclauseCodeKindHisServiceImpl extends BaseServiceImpl implements PrpDclauseCodeKindHisService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDclauseCodeKindHisServiceImpl.class);
    
    @Autowired
    private PrpDclauseCodeKindHisDao prpDclauseCodeKindHisDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto) {
        PrpDclauseCodeKindHis prpDclauseCodeKindHis = this.convert(prpDclauseCodeKindHisDto, PrpDclauseCodeKindHis.class);
        prpDclauseCodeKindHisDao.save(prpDclauseCodeKindHis);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo) {
        PrpDclauseCodeKindHisKey prpDclauseCodeKindHisKey = new PrpDclauseCodeKindHisKey(clauseCode,serialNo,kindCode,indexNo);
        prpDclauseCodeKindHisDao.delete(prpDclauseCodeKindHisKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto) {
        PrpDclauseCodeKindHis prpDclauseCodeKindHis = this.convert(prpDclauseCodeKindHisDto, PrpDclauseCodeKindHis.class);
        prpDclauseCodeKindHisDao.save(prpDclauseCodeKindHis);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseCodeKindHisDto queryByPK(String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo) {
        PrpDclauseCodeKindHisKey prpDclauseCodeKindHisKey = new PrpDclauseCodeKindHisKey(clauseCode,serialNo,kindCode,indexNo);
        PrpDclauseCodeKindHis prpDclauseCodeKindHis = prpDclauseCodeKindHisDao.findOne(prpDclauseCodeKindHisKey);
        return this.convert(prpDclauseCodeKindHis,PrpDclauseCodeKindHisDto.class);
    }
}