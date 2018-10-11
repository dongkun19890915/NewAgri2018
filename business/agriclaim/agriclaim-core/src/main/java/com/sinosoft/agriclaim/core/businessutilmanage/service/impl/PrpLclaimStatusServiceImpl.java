package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLclaimStatusService;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔节点状态表Core接口实现
 */
@Service
public class PrpLclaimStatusServiceImpl extends BaseServiceImpl implements PrpLclaimStatusService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLclaimStatusServiceImpl.class);
    
    @Autowired
    private PrpLclaimStatusDao prpLclaimStatusDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLclaimStatusDto prpLclaimStatusDto) {
        PrpLclaimStatus prpLclaimStatus = this.convert(prpLclaimStatusDto, PrpLclaimStatus.class);
        prpLclaimStatusDao.save(prpLclaimStatus);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String businessno,String nodetype,java.lang.Integer serialno) {
        PrpLclaimStatusKey prpLclaimStatusKey = new PrpLclaimStatusKey(businessno,nodetype,serialno);
        prpLclaimStatusDao.delete(prpLclaimStatusKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLclaimStatusDto prpLclaimStatusDto) {
        PrpLclaimStatus prpLclaimStatus = this.convert(prpLclaimStatusDto, PrpLclaimStatus.class);
        prpLclaimStatusDao.save(prpLclaimStatus);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLclaimStatusDto queryByPK(String businessno,String nodetype,java.lang.Integer serialno) {
        PrpLclaimStatusKey prpLclaimStatusKey = new PrpLclaimStatusKey(businessno,nodetype,serialno);
        PrpLclaimStatus prpLclaimStatus = prpLclaimStatusDao.findOne(prpLclaimStatusKey);
        return this.convert(prpLclaimStatus,PrpLclaimStatusDto.class);
    }
}