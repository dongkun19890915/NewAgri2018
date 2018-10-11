package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLGrowthDto;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLGrowthDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLGrowth;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLGrowthService;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 生长期表实现类
 * @Author: 孙朋飞
 * @Date: 2018/3/21 14:26
 */
@Service
public class PrpLGrowthServiceImpl extends BaseServiceImpl implements PrpLGrowthService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLGrowthServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private PrpLGrowthDao prpLGrowthDao;
    /**
     * 查询生长期
     * @author: 孙朋飞
     * @date: 2018/3/21 14:47
     * @param prpLGrowthDto 险种-riskCode,条款-clauseCode,标的-itemCode,险别-kindCode
     * @return 生长期集合
     * @throws Exception
     */
    @Override
    public List<PrpLGrowthDto> queryPrpLGrowthByConditions(PrpLGrowthDto prpLGrowthDto) throws Exception {

        //根据险种，条款，标的，和险别查询有效的生长期
        StringBuilder sql=new StringBuilder("select p from PrpLGrowth p where p.flag='1'");
        //拼接参数
        Map<String, String> sqlMap = new HashMap<String, String>();
        if(StringUtils.isNotEmpty(prpLGrowthDto.getRiskCode())){
            sql.append(" and p.riskCode=:riskCode");
            sqlMap.put("riskCode",prpLGrowthDto.getRiskCode());
        }
        if(StringUtils.isNotEmpty(prpLGrowthDto.getClauseCode())){
            sql.append(" and p.clauseCode=:clauseCode");
            sqlMap.put("clauseCode",prpLGrowthDto.getClauseCode());
        }
        if(StringUtils.isNotEmpty(prpLGrowthDto.getItemCode())){
            sql.append(" and p.itemCode=:itemCode");
            sqlMap.put("itemCode",prpLGrowthDto.getItemCode());
        }
        if(StringUtils.isNotEmpty(prpLGrowthDto.getKindCode())){
            sql.append(" and p.kindCode=:kindCode");
            sqlMap.put("kindCode",prpLGrowthDto.getKindCode());
        }
        Query query = entityManager.createQuery(sql.toString());
        for (Map.Entry<String, String> entry : sqlMap.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<PrpLGrowth> resultList = query.getResultList();
        //如果没有查询到结果(比如报案登记选择了棚架棚膜是没有生长期的 但是清单中是有草莓这个主险的)
        // 则扩大查询的范围 去掉险种和标的查询条件 数据没问题的情况下是可以查出来种植险主险的生长期的
        if (resultList.size()==0){
            resultList=prpLGrowthDao.queryByCondition(prpLGrowthDto.getClauseCode(),prpLGrowthDto.getRiskCode());
            //如果查出来多套,则直接return null
            for (int i = 0;i<resultList.size();i++){
                if (resultList.get(i).getItemCode()!=resultList.get(i+1).getItemCode()){
                    return null;
                }
            }
        }
        List<PrpLGrowthDto> prpLGrowthDtosList=new ArrayList<>();
        convertCollection(resultList,prpLGrowthDtosList,PrpLGrowthDto.class);
        return prpLGrowthDtosList;
    }
    /**
     * 查询条款和标的
     * @author: 孙朋飞
     * @date: 2018/3/23 17:06
     * @param  policyNo 保单号
     * @param  registNo 报案号
     * @return 条款和标的
     * @throws Exception
     */
    @Override
    public Map<String, String> queryPrpLRegistAndPrpCmainByConditions(String policyNo, String registNo) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        if(StringUtils.isEmpty(registNo)){
            throw new DataVerifyException("报案号不能为空!");
        }
        //根据保单号查询条款
        Map<String,String> param=new HashMap<>();
        param.put("policyNo",policyNo);
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(param);
        //根据报案号查询标的
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(registNo);
        Map<String,String> returnMap=new HashMap<>();
        returnMap.put("versionNo",prpCmainDto.getVersionNo());
        returnMap.put("lossName",prpLRegistDto.getLossCode());
        return returnMap;
    }
}