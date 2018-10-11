package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseLogDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseLogDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseLog;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseLogKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseLogService;
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
 * @time  2017-09-12 12:28:59.683 
 * @description 自动生成特约主表日志表Core接口实现
 */
@Service
public class PrpDautoClauseLogServiceImpl extends BaseServiceImpl implements PrpDautoClauseLogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseLogServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseLogDao prpDautoClauseLogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseLogDto prpDautoClauseLogDto) {
        PrpDautoClauseLog prpDautoClauseLog = this.convert(prpDautoClauseLogDto, PrpDautoClauseLog.class);
        prpDautoClauseLogDao.save(prpDautoClauseLog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String uUID) {
        PrpDautoClauseLogKey prpDautoClauseLogKey = new PrpDautoClauseLogKey(uUID);
        prpDautoClauseLogDao.delete(prpDautoClauseLogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseLogDto prpDautoClauseLogDto) {
        PrpDautoClauseLog prpDautoClauseLog = this.convert(prpDautoClauseLogDto, PrpDautoClauseLog.class);
        prpDautoClauseLogDao.save(prpDautoClauseLog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseLogDto queryByPK(String uUID) {
        PrpDautoClauseLogKey prpDautoClauseLogKey = new PrpDautoClauseLogKey(uUID);
        PrpDautoClauseLog prpDautoClauseLog = prpDautoClauseLogDao.findOne(prpDautoClauseLogKey);
        return this.convert(prpDautoClauseLog,PrpDautoClauseLogDto.class);
    }
}