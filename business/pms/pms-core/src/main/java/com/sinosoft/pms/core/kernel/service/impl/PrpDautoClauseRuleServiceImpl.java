package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.pms.api.kernel.dto.PrpDautoClauseRuleDto;
import com.sinosoft.pms.core.kernel.dao.PrpDautoClauseRuleDao;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRule;
import com.sinosoft.pms.core.kernel.entity.PrpDautoClauseRuleKey;
import com.sinosoft.pms.core.kernel.service.PrpDautoClauseRuleService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail sucong13146@sinosoft.com.cn
 * @time  2017-09-12 12:28:37.662 
 * @description 自动生成特约校验规则表Core接口实现
 */
@Service
public class PrpDautoClauseRuleServiceImpl extends BaseServiceImpl implements PrpDautoClauseRuleService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDautoClauseRuleServiceImpl.class);
    
    @Autowired
    private PrpDautoClauseRuleDao prpDautoClauseRuleDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpDautoClauseRuleDto prpDautoClauseRuleDto) {
        PrpDautoClauseRule prpDautoClauseRule = this.convert(prpDautoClauseRuleDto, PrpDautoClauseRule.class);
        prpDautoClauseRuleDao.save(prpDautoClauseRule);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String comCode,String riskCode,String clauseCode,String groupNo,String serialNo) {
        PrpDautoClauseRuleKey prpDautoClauseRuleKey = new PrpDautoClauseRuleKey(comCode,riskCode,clauseCode,groupNo,serialNo);
        prpDautoClauseRuleDao.delete(prpDautoClauseRuleKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpDautoClauseRuleDto prpDautoClauseRuleDto) {
        PrpDautoClauseRule prpDautoClauseRule = this.convert(prpDautoClauseRuleDto, PrpDautoClauseRule.class);
        prpDautoClauseRuleDao.save(prpDautoClauseRule);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDautoClauseRuleDto queryByPK(String comCode,String riskCode,String clauseCode,String groupNo,String serialNo) {
        PrpDautoClauseRuleKey prpDautoClauseRuleKey = new PrpDautoClauseRuleKey(comCode,riskCode,clauseCode,groupNo,serialNo);
        PrpDautoClauseRule prpDautoClauseRule = prpDautoClauseRuleDao.findOne(prpDautoClauseRuleKey);
        return this.convert(prpDautoClauseRule,PrpDautoClauseRuleDto.class);
    }

    /**
     *@description 按条件查询实体
     *@param
     */
    public List<PrpDautoClauseRuleDto> queryByCondition(String clauseCode, String comCode, String riskCode) {
        List<PrpDautoClauseRule> prpDautoClauseRules = new ArrayList<PrpDautoClauseRule>();
        List<PrpDautoClauseRuleDto> prpDautoClauseRuleDtos = null;
        try {
            //组织查询条件
            Specification<PrpDautoClauseRule> autoClauseSpecification = specifications(clauseCode, comCode, riskCode);
            prpDautoClauseRules =  prpDautoClauseRuleDao.findAll(autoClauseSpecification);

            prpDautoClauseRuleDtos = new ArrayList<PrpDautoClauseRuleDto>(prpDautoClauseRules.size());
            this.convertCollection(prpDautoClauseRules, prpDautoClauseRuleDtos, PrpDautoClauseRuleDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prpDautoClauseRuleDtos;
    }

    public static Specification<PrpDautoClauseRule> specifications(String clauseCode, String comCode, String riskCode) throws Exception {
        return Specifications.<PrpDautoClauseRule>and().eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(clauseCode), "clauseCode", clauseCode)
                .eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(comCode), "comCode", comCode)
                .eq(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(riskCode), "riskCode", riskCode)
                .build();
    }
}