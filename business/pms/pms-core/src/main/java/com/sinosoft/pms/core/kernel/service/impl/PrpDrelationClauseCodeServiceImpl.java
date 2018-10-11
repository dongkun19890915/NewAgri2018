package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDrelationClauseCodeDto;
import com.sinosoft.pms.core.kernel.dao.PrpDrelationClauseCodeDao;
import com.sinosoft.pms.core.kernel.entity.PrpDrelationClauseCode;
import com.sinosoft.pms.core.kernel.entity.PrpDrelationClauseCodeKey;
import com.sinosoft.pms.core.kernel.service.PrpDrelationClauseCodeService;
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
 * @time  2017-12-18 02:37:33.970 
 * @description 条款与保险责任关联表Core接口实现
 */
@Service
public class PrpDrelationClauseCodeServiceImpl extends BaseServiceImpl implements PrpDrelationClauseCodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDrelationClauseCodeServiceImpl.class);
    
    @Autowired
    private PrpDrelationClauseCodeDao prpDrelationClauseCodeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto) {
        PrpDrelationClauseCode prpDrelationClauseCode = this.convert(prpDrelationClauseCodeDto, PrpDrelationClauseCode.class);
        prpDrelationClauseCodeDao.save(prpDrelationClauseCode);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String clauseCode,String insuranceCode) {
        PrpDrelationClauseCodeKey prpDrelationClauseCodeKey = new PrpDrelationClauseCodeKey(clauseCode,insuranceCode);
        prpDrelationClauseCodeDao.delete(prpDrelationClauseCodeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDrelationClauseCodeDto prpDrelationClauseCodeDto) {
        PrpDrelationClauseCode prpDrelationClauseCode = this.convert(prpDrelationClauseCodeDto, PrpDrelationClauseCode.class);
        prpDrelationClauseCodeDao.save(prpDrelationClauseCode);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDrelationClauseCodeDto queryByPK(String clauseCode,String insuranceCode) {
        PrpDrelationClauseCodeKey prpDrelationClauseCodeKey = new PrpDrelationClauseCodeKey(clauseCode,insuranceCode);
        PrpDrelationClauseCode prpDrelationClauseCode = prpDrelationClauseCodeDao.findOne(prpDrelationClauseCodeKey);
        return this.convert(prpDrelationClauseCode,PrpDrelationClauseCodeDto.class);
    }
    /**
     *@description 按条款代码查询实体
     *@param
     */
    @Override
    public  List<PrpDrelationClauseCodeDto> queryByClauseCode(String clauseCode) {
        List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList = new ArrayList<>();
        List<PrpDrelationClauseCode> prpDrelationClauseCodes = prpDrelationClauseCodeDao.queryAllByClauseCode(clauseCode);
        this.convertCollection(prpDrelationClauseCodes,prpDrelationClauseCodeDtoList,PrpDrelationClauseCodeDto.class);
        return prpDrelationClauseCodeDtoList;
    }
}