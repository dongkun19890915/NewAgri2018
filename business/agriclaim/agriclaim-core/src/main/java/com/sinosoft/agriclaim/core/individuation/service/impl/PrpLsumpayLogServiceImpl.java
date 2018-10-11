package com.sinosoft.agriclaim.core.individuation.service.impl;


import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayLogDto;
import com.sinosoft.agriclaim.core.individuation.dao.PrpLsumpayLogDao;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayLog;
import com.sinosoft.agriclaim.core.individuation.entity.PrpLsumpayLogKey;
import com.sinosoft.agriclaim.core.individuation.service.PrpLsumpayLogService;
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
 * @time  2017-11-22 08:23:52.676 
 * @description 支付信息轨迹表Core接口实现
 */
@Service
public class PrpLsumpayLogServiceImpl extends BaseServiceImpl implements PrpLsumpayLogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLsumpayLogServiceImpl.class);
    
    @Autowired
    private PrpLsumpayLogDao prpLsumpayLogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLsumpayLogDto prpLsumpayLogDto) {
        PrpLsumpayLog prpLsumpayLog = this.convert(prpLsumpayLogDto, PrpLsumpayLog.class);
        prpLsumpayLogDao.save(prpLsumpayLog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,String serialNo,String logNo) {
        PrpLsumpayLogKey prpLsumpayLogKey = new PrpLsumpayLogKey(claimNo,serialNo,logNo);
        prpLsumpayLogDao.delete(prpLsumpayLogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLsumpayLogDto prpLsumpayLogDto) {
        PrpLsumpayLog prpLsumpayLog = this.convert(prpLsumpayLogDto, PrpLsumpayLog.class);
        prpLsumpayLogDao.save(prpLsumpayLog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLsumpayLogDto queryByPK(String claimNo,String serialNo,String logNo) {
        PrpLsumpayLogKey prpLsumpayLogKey = new PrpLsumpayLogKey(claimNo,serialNo,logNo);
        PrpLsumpayLog prpLsumpayLog = prpLsumpayLogDao.findOne(prpLsumpayLogKey);
        return this.convert(prpLsumpayLog,PrpLsumpayLogDto.class);
    }
}