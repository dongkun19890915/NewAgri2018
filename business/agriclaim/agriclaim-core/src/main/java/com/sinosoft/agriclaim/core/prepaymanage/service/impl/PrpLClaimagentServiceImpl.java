package com.sinosoft.agriclaim.core.prepaymanage.service.impl;

import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLClaimagentDto;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLClaimagentDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLClaimagent;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLClaimagentKey;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLClaimagentService;
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
 * @description 代理赔保单信息表Core接口实现
 */
@Service
public class PrpLClaimagentServiceImpl extends BaseServiceImpl implements PrpLClaimagentService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimagentServiceImpl.class);
    
    @Autowired
    private PrpLClaimagentDao prpLClaimagentDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimagentDto prpLClaimagentDto) {
        PrpLClaimagent prpLClaimagent = this.convert(prpLClaimagentDto, PrpLClaimagent.class);
        prpLClaimagentDao.save(prpLClaimagent);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo) {
        PrpLClaimagentKey prpLClaimagentKey = new PrpLClaimagentKey(claimNo);
        prpLClaimagentDao.delete(prpLClaimagentKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimagentDto prpLClaimagentDto) {
        PrpLClaimagent prpLClaimagent = this.convert(prpLClaimagentDto, PrpLClaimagent.class);
        prpLClaimagentDao.save(prpLClaimagent);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimagentDto queryByPK(String claimNo) {
        PrpLClaimagentKey prpLClaimagentKey = new PrpLClaimagentKey(claimNo);
        PrpLClaimagent prpLClaimagent = prpLClaimagentDao.findOne(prpLClaimagentKey);
        return this.convert(prpLClaimagent,PrpLClaimagentDto.class);
    }
}