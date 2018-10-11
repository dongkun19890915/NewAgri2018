package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEarKey;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLCompensateEarService;
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
 * @time  2017-11-08 05:39:53.061 
 * @description 理赔分户清单表Core接口实现
 */
@Service
public class PrpLCompensateEarServiceImpl extends BaseServiceImpl implements PrpLCompensateEarService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateEarServiceImpl.class);
    
    @Autowired
    private PrpLCompensateEarDao prpLCompensateEarDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCompensateEarDto prpLCompensateEarDto) {
        PrpLCompensateEar prpLCompensateEar = this.convert(prpLCompensateEarDto, PrpLCompensateEar.class);
        prpLCompensateEarDao.save(prpLCompensateEar);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String earNo,String registNo,String nodeType,String businessNo) {
        PrpLCompensateEarKey prpLCompensateEarKey = new PrpLCompensateEarKey(earNo,registNo,nodeType,businessNo);
        prpLCompensateEarDao.delete(prpLCompensateEarKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCompensateEarDto prpLCompensateEarDto) {
        PrpLCompensateEar prpLCompensateEar = this.convert(prpLCompensateEarDto, PrpLCompensateEar.class);
        prpLCompensateEarDao.save(prpLCompensateEar);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCompensateEarDto queryByPK(String earNo,String registNo,String nodeType,String businessNo) {
        PrpLCompensateEarKey prpLCompensateEarKey = new PrpLCompensateEarKey(earNo,registNo,nodeType,businessNo);
        PrpLCompensateEar prpLCompensateEar = prpLCompensateEarDao.findOne(prpLCompensateEarKey);
        return this.convert(prpLCompensateEar,PrpLCompensateEarDto.class);
    }
}