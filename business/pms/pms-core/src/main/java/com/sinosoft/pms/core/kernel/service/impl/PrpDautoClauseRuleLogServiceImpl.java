package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseRuleLogDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseRuleLogDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleLog;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleLogKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseRuleLogService;
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
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-13 02:29:04.419 
 * @description 自动生成特约校验规则表日志表Core接口实现
 */
@Service
public class PrpDautoClauseRuleLogServiceImpl extends BaseServiceImpl implements PrpDautoClauseRuleLogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseRuleLogServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseRuleLogDao prpDautoClauseRuleLogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto) {
        PrpDautoClauseRuleLog prpDautoClauseRuleLog = this.convert(prpDautoClauseRuleLogDto, PrpDautoClauseRuleLog.class);
        prpDautoClauseRuleLogDao.save(prpDautoClauseRuleLog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String uUID) {
        PrpDautoClauseRuleLogKey prpDautoClauseRuleLogKey = new PrpDautoClauseRuleLogKey(uUID);
        prpDautoClauseRuleLogDao.delete(prpDautoClauseRuleLogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseRuleLogDto prpDautoClauseRuleLogDto) {
        PrpDautoClauseRuleLog prpDautoClauseRuleLog = this.convert(prpDautoClauseRuleLogDto, PrpDautoClauseRuleLog.class);
        prpDautoClauseRuleLogDao.save(prpDautoClauseRuleLog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseRuleLogDto queryByPK(String uUID) {
        PrpDautoClauseRuleLogKey prpDautoClauseRuleLogKey = new PrpDautoClauseRuleLogKey(uUID);
        PrpDautoClauseRuleLog prpDautoClauseRuleLog = prpDautoClauseRuleLogDao.findOne(prpDautoClauseRuleLogKey);
        return this.convert(prpDautoClauseRuleLog,PrpDautoClauseRuleLogDto.class);
    }
}