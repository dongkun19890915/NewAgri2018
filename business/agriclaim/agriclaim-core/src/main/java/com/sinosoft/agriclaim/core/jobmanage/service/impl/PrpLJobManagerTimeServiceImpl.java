package com.sinosoft.agriclaim.core.jobmanage.service.impl;

import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobManagerTimeDto;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrpLJobManagerTimeDao;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManagerTime;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManagerTimeKey;
import com.sinosoft.agriclaim.core.jobmanage.service.PrpLJobManagerTimeService;
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
 * @time  2017-11-08 05:42:38.981 
 * @description 班表管理从表Core接口实现
 */
@Service
public class PrpLJobManagerTimeServiceImpl extends BaseServiceImpl implements PrpLJobManagerTimeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLJobManagerTimeServiceImpl.class);
    
    @Autowired
    private PrpLJobManagerTimeDao prpLJobManagerTimeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLJobManagerTimeDto prpLJobManagerTimeDto) {
        PrpLJobManagerTime prpLJobManagerTime = this.convert(prpLJobManagerTimeDto, PrpLJobManagerTime.class);
        prpLJobManagerTimeDao.save(prpLJobManagerTime);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String fid) {
        PrpLJobManagerTimeKey prpLJobManagerTimeKey = new PrpLJobManagerTimeKey(fid);
        prpLJobManagerTimeDao.delete(prpLJobManagerTimeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLJobManagerTimeDto prpLJobManagerTimeDto) {
        PrpLJobManagerTime prpLJobManagerTime = this.convert(prpLJobManagerTimeDto, PrpLJobManagerTime.class);
        prpLJobManagerTimeDao.save(prpLJobManagerTime);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLJobManagerTimeDto queryByPK(String fid) {
        PrpLJobManagerTimeKey prpLJobManagerTimeKey = new PrpLJobManagerTimeKey(fid);
        PrpLJobManagerTime prpLJobManagerTime = prpLJobManagerTimeDao.findOne(prpLJobManagerTimeKey);
        return this.convert(prpLJobManagerTime,PrpLJobManagerTimeDto.class);
    }
}