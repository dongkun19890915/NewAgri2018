package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobManagerDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLConfigurationDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfiguration;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfigurationKey;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLConfigurationService;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobManager;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 10:18:44.285 
 * @description 条款公式配置表 Core接口实现
 */
@Service
public class PrpLConfigurationServiceImpl extends BaseCustomServiceImpl implements PrpLConfigurationService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLConfigurationServiceImpl.class);
    
    @Autowired
    private PrpLConfigurationDao prpLConfigurationDao;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLConfigurationDto prpLConfigurationDto) {
        PrpLConfiguration prpLConfiguration = this.convert(prpLConfigurationDto, PrpLConfiguration.class);
        prpLConfigurationDao.save(prpLConfiguration);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLConfigurationDto queryByPK(String id) {
        PrpLConfigurationKey prpLConfigurationKey = new PrpLConfigurationKey(id);
        PrpLConfiguration prpLConfiguration = prpLConfigurationDao.findOne(prpLConfigurationKey);
        return this.convert(prpLConfiguration,PrpLConfigurationDto.class);
    }

    /**
    * @description 按条件查询条款公式配置
    * @param prpLConfigurationDto 条款公式配置入参封装对象
    * @return List<PrpLConfigurationDto> 条款公式配置信息列表
    * @throws Exception
    * @author 李磊
    * @date 2017-12-26 8:42
    */
    public List<PrpLConfigurationDto> queryPrpLConfigurationDtoListByCondition( PrpLConfigurationDto  prpLConfigurationDto) throws Exception {

        StringBuilder sql = new StringBuilder(200);

        sql.append("SELECT p FROM com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLConfiguration p ");

        String condition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();

        if (StringUtils.isNotEmpty(prpLConfigurationDto.getClassCode())) {
            conditionList.add("and p.classCode=:classCode");
            paraMap.put("classCode", prpLConfigurationDto.getClassCode());
        }
        if (StringUtils.isNotEmpty(prpLConfigurationDto.getRiskCode())) {
            conditionList.add("and p.riskCode=:riskCode");
            paraMap.put("riskCode", prpLConfigurationDto.getRiskCode());
        }
        if (StringUtils.isNotEmpty(prpLConfigurationDto.getClauseNumber())) {
            conditionList.add("and p.clauseNumber=:clauseNumber");
            paraMap.put("clauseNumber", prpLConfigurationDto.getClauseNumber());
        }
        if (StringUtils.isNotEmpty(prpLConfigurationDto.getItemCode())) {
            conditionList.add("and p.itemCode=:itemCode");
            paraMap.put("itemCode", prpLConfigurationDto.getItemCode());
        }
        if (StringUtils.isNotEmpty(prpLConfigurationDto.getKindCode())) {
            conditionList.add("and p.kindCode=:kindCode");
            paraMap.put("kindCode", prpLConfigurationDto.getKindCode());
        }
        if (StringUtils.isNotEmpty(prpLConfigurationDto.getCalculationMethod())) {
            conditionList.add("and p.calculationMethod=:calculationMethod");
            paraMap.put("calculationMethod", prpLConfigurationDto.getCalculationMethod());
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

        List<PrpLConfiguration> resultList = dataQuery.getResultList();
        List<PrpLConfigurationDto> prpLConfigurationDtoList = new ArrayList<>();


        convertCollection(resultList, prpLConfigurationDtoList, PrpLConfigurationDto.class);
        return prpLConfigurationDtoList;
    }
}