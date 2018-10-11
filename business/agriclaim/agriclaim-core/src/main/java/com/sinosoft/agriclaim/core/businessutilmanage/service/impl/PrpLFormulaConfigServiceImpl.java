package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLFormulaConfigDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLFormulaConfigDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfiguration;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLFormulaConfig;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLFormulaConfigKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLConfigurationService;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLFormulaConfigService;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * @description 条款公式配置项配置表Core接口实现
 */
@Service
public class PrpLFormulaConfigServiceImpl extends BaseCustomServiceImpl implements PrpLFormulaConfigService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLFormulaConfigServiceImpl.class);
    
    @Autowired
    private PrpLFormulaConfigDao prpLFormulaConfigDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpLConfigurationService prpLConfigurationService;
    @Autowired
    private PrpLFormulaConfigService prpLFormulaConfigService;

    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLFormulaConfigDto queryByPK(String id) {
        PrpLFormulaConfigKey prpLFormulaConfigKey = new PrpLFormulaConfigKey(id);
        PrpLFormulaConfig prpLFormulaConfig = prpLFormulaConfigDao.findOne(prpLFormulaConfigKey);
        return this.convert(prpLFormulaConfig,PrpLFormulaConfigDto.class);
    }

    /**
     * @description 按条件查询条款公式配置
     * @param prpLFormulaConfigDto 条款公式配置入参封装对象
     * @return List<prpLFormulaConfigDto> 条款公式配置信息列表
     * @throws Exception
     * @author 李磊
     * @date 2017-12-26 8:42
     */
    public List<PrpLFormulaConfigDto> queryPrpLFormulaConfigDtoListByCondition(PrpLFormulaConfigDto  prpLFormulaConfigDto) throws Exception {

        StringBuilder sql = new StringBuilder(200);

        sql.append("SELECT p FROM com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLFormulaConfig p ");

        String condition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();

        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getClassCode())) {
            conditionList.add("and p.classCode=:classCode");
            paraMap.put("classCode", prpLFormulaConfigDto.getClassCode());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getRiskCode())) {
            conditionList.add("and p.riskCode=:riskCode");
            paraMap.put("riskCode", prpLFormulaConfigDto.getRiskCode());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getConfigCode())) {
            conditionList.add("and p.configCode=:configCode");
            paraMap.put("configCode", prpLFormulaConfigDto.getConfigCode());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getConfigUrationRange())) {
            conditionList.add("and p.configUrationRange=:configUrationRange");
            paraMap.put("configUrationRange", prpLFormulaConfigDto.getConfigUrationRange());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getConfigUrationType())) {
            conditionList.add("and p.configUrationType=:configUrationType");
            paraMap.put("configUrationType", prpLFormulaConfigDto.getConfigUrationType());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getReserve1())) {
            conditionList.add("and p.reserve1 =:reserve1");
            paraMap.put("reserve1", prpLFormulaConfigDto.getReserve1());
        }
        if (StringUtils.isNotEmpty(prpLFormulaConfigDto.getReserve2())) {
            conditionList.add("and p.reserve2 =:reserve2");
            paraMap.put("reserve2", prpLFormulaConfigDto.getReserve2());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            condition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(condition);
        }

        Query dataQuery = entityManager.createQuery(sql.toString());
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());
        }

        List<PrpLFormulaConfig> resultList = dataQuery.getResultList();
        List<PrpLFormulaConfigDto> prpLFormulaConfigDtoList = new ArrayList<>();


        convertCollection(resultList, prpLFormulaConfigDtoList, PrpLFormulaConfigDto.class);
        return prpLFormulaConfigDtoList;
    }
}