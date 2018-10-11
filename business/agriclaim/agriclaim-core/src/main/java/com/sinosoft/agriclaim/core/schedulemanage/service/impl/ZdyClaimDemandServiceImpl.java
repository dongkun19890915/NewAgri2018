package com.sinosoft.agriclaim.core.schedulemanage.service.impl;

import com.sinosoft.agriclaim.api.schedulemanage.dto.ZdyClaimDemandDto;
import com.sinosoft.agriclaim.core.schedulemanage.dao.ZdyClaimDemandDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.ZdyClaimDemand;
import com.sinosoft.agriclaim.core.schedulemanage.entity.ZdyClaimDemandKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.ZdyClaimDemandService;
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
 * @time  2017-11-10 02:49:33.975 
 * @description 驻点员App案件推送日志表Core接口实现
 */
@Service
public class ZdyClaimDemandServiceImpl extends BaseServiceImpl implements ZdyClaimDemandService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ZdyClaimDemandServiceImpl.class);
    
    @Autowired
    private ZdyClaimDemandDao zdyClaimDemandDao;

    /**
     *@description 新增
     *@param
     */
    public void save(ZdyClaimDemandDto zdyClaimDemandDto) {
        ZdyClaimDemand zdyClaimDemand = this.convert(zdyClaimDemandDto, ZdyClaimDemand.class);
        zdyClaimDemandDao.save(zdyClaimDemand);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String id) {
        ZdyClaimDemandKey zdyClaimDemandKey = new ZdyClaimDemandKey(id);
        zdyClaimDemandDao.delete(zdyClaimDemandKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(ZdyClaimDemandDto zdyClaimDemandDto) {
        ZdyClaimDemand zdyClaimDemand = this.convert(zdyClaimDemandDto, ZdyClaimDemand.class);
        zdyClaimDemandDao.save(zdyClaimDemand);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public ZdyClaimDemandDto queryByPK(String id) {
        ZdyClaimDemandKey zdyClaimDemandKey = new ZdyClaimDemandKey(id);
        ZdyClaimDemand zdyClaimDemand = zdyClaimDemandDao.findOne(zdyClaimDemandKey);
        return this.convert(zdyClaimDemand,ZdyClaimDemandDto.class);
    }
}