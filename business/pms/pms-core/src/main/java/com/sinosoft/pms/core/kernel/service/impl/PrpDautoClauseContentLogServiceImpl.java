package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseContentLogDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseContentLogDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseContentLog;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseContentLogKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseContentLogService;
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
 * @time  2017-09-13 02:28:53.337 
 * @description 动态生成特约内容规则表日志表Core接口实现
 */
@Service
public class PrpDautoClauseContentLogServiceImpl extends BaseServiceImpl implements PrpDautoClauseContentLogService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseContentLogServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseContentLogDao prpDautoClauseContentLogDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseContentLogDto prpDautoClauseContentLogDto) {
        PrpDautoClauseContentLog prpDautoClauseContentLog = this.convert(prpDautoClauseContentLogDto, PrpDautoClauseContentLog.class);
        prpDautoClauseContentLogDao.save(prpDautoClauseContentLog);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String uUID) {
        PrpDautoClauseContentLogKey prpDautoClauseContentLogKey = new PrpDautoClauseContentLogKey(uUID);
        prpDautoClauseContentLogDao.delete(prpDautoClauseContentLogKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseContentLogDto prpDautoClauseContentLogDto) {
        PrpDautoClauseContentLog prpDautoClauseContentLog = this.convert(prpDautoClauseContentLogDto, PrpDautoClauseContentLog.class);
        prpDautoClauseContentLogDao.save(prpDautoClauseContentLog);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseContentLogDto queryByPK(String uUID) {
        PrpDautoClauseContentLogKey prpDautoClauseContentLogKey = new PrpDautoClauseContentLogKey(uUID);
        PrpDautoClauseContentLog prpDautoClauseContentLog = prpDautoClauseContentLogDao.findOne(prpDautoClauseContentLogKey);
        return this.convert(prpDautoClauseContentLog,PrpDautoClauseContentLogDto.class);
    }
}