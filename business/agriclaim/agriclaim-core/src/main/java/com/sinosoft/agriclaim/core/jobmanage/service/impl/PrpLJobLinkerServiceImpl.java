package com.sinosoft.agriclaim.core.jobmanage.service.impl;

import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobLinkerDto;
import com.sinosoft.agriclaim.core.jobmanage.dao.PrpLJobLinkerDao;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobLinker;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobLinkerKey;
import com.sinosoft.agriclaim.core.jobmanage.service.PrpLJobLinkerService;
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
 * @description 联系人Core接口实现
 */
@Service
public class PrpLJobLinkerServiceImpl extends BaseServiceImpl implements PrpLJobLinkerService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLJobLinkerServiceImpl.class);
    
    @Autowired
    private PrpLJobLinkerDao prpLJobLinkerDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLJobLinkerDto prpLJobLinkerDto) {
        PrpLJobLinker prpLJobLinker = this.convert(prpLJobLinkerDto, PrpLJobLinker.class);
        prpLJobLinkerDao.save(prpLJobLinker);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String staffId) {
        PrpLJobLinkerKey prpLJobLinkerKey = new PrpLJobLinkerKey(staffId);
        prpLJobLinkerDao.delete(prpLJobLinkerKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLJobLinkerDto prpLJobLinkerDto) {
        PrpLJobLinker prpLJobLinker = this.convert(prpLJobLinkerDto, PrpLJobLinker.class);
        prpLJobLinkerDao.save(prpLJobLinker);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLJobLinkerDto queryByPK(String staffId) {
        PrpLJobLinkerKey prpLJobLinkerKey = new PrpLJobLinkerKey(staffId);
        PrpLJobLinker prpLJobLinker = prpLJobLinkerDao.findOne(prpLJobLinkerKey);
        return this.convert(prpLJobLinker,PrpLJobLinkerDto.class);
    }
}