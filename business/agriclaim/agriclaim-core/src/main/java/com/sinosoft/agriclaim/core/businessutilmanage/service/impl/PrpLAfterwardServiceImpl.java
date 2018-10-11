package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAfterwardDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAfterwardDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAfterward;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAfterwardKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLAfterwardService;
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
 * @description 案后费用处理表Core接口实现
 */
@Service
public class PrpLAfterwardServiceImpl extends BaseServiceImpl implements PrpLAfterwardService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLAfterwardServiceImpl.class);
    
    @Autowired
    private PrpLAfterwardDao prpLAfterwardDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLAfterwardDto prpLAfterwardDto) {
        PrpLAfterward prpLAfterward = this.convert(prpLAfterwardDto, PrpLAfterward.class);
        prpLAfterwardDao.save(prpLAfterward);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,java.lang.Double serialNo) {
        PrpLAfterwardKey prpLAfterwardKey = new PrpLAfterwardKey(claimNo,serialNo);
        prpLAfterwardDao.delete(prpLAfterwardKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLAfterwardDto prpLAfterwardDto) {
        PrpLAfterward prpLAfterward = this.convert(prpLAfterwardDto, PrpLAfterward.class);
        prpLAfterwardDao.save(prpLAfterward);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAfterwardDto queryByPK(String claimNo,java.lang.Double serialNo) {
        PrpLAfterwardKey prpLAfterwardKey = new PrpLAfterwardKey(claimNo,serialNo);
        PrpLAfterward prpLAfterward = prpLAfterwardDao.findOne(prpLAfterwardKey);
        return this.convert(prpLAfterward,PrpLAfterwardDto.class);
    }
}