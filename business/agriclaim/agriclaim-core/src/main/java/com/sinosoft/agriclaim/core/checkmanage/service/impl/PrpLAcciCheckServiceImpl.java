package com.sinosoft.agriclaim.core.checkmanage.service.impl;

import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckDto;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLAcciCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheckKey;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLAcciCheckService;
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
 * @time  2017-11-08 05:38:49.324 
 * @description 意健险调查主表Core接口实现
 */
@Service
public class PrpLAcciCheckServiceImpl extends BaseServiceImpl implements PrpLAcciCheckService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLAcciCheckServiceImpl.class);
    
    @Autowired
    private PrpLAcciCheckDao prpLAcciCheckDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLAcciCheckDto prpLAcciCheckDto) {
        PrpLAcciCheck prpLAcciCheck = this.convert(prpLAcciCheckDto, PrpLAcciCheck.class);
        prpLAcciCheckDao.save(prpLAcciCheck);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String checkNo) {
        PrpLAcciCheckKey prpLAcciCheckKey = new PrpLAcciCheckKey(checkNo);
        prpLAcciCheckDao.delete(prpLAcciCheckKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLAcciCheckDto prpLAcciCheckDto) {
        PrpLAcciCheck prpLAcciCheck = this.convert(prpLAcciCheckDto, PrpLAcciCheck.class);
        prpLAcciCheckDao.save(prpLAcciCheck);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAcciCheckDto queryByPK(String checkNo) {
        PrpLAcciCheckKey prpLAcciCheckKey = new PrpLAcciCheckKey(checkNo);
        PrpLAcciCheck prpLAcciCheck = prpLAcciCheckDao.findOne(prpLAcciCheckKey);
        return this.convert(prpLAcciCheck,PrpLAcciCheckDto.class);
    }
}