package com.sinosoft.ims.core.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sinosoft.ims.core.auth.dao.UtiPlatConfigDao;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfig;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.ims.core.auth.dao.UtiPlatconfigRuleDao;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigRule;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigRuleKey;
import com.sinosoft.ims.core.auth.service.UtiPlatConfigRuleService;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-05 01:10:45.148
 * @description UtiPlatConfigRuleCore接口实现
 */
@Service
public class UtiPlatConfigRuleServiceImpl extends BaseServiceImpl implements UtiPlatConfigRuleService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiPlatConfigRuleServiceImpl.class);

    @Autowired
    private UtiPlatconfigRuleDao utiPlatConfigRuleDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UtiPlatConfigDao utiPlatConfigDao;

    /**
     * @param
     * @description 新增
     */
    @Override
    public void save(UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        UtiPlatConfigRule utiPlatConfigRule = this.convert(utiPlatConfigRuleDto, UtiPlatConfigRule.class);
        utiPlatConfigRuleDao.save(utiPlatConfigRule);
    }

    /**
     * @param
     * @description 删除
     */
    @Override
    public void remove(String systemCode, String paramCode, Integer serialNo) {
        UtiPlatConfigRuleKey utiPlatConfigRuleKey = new UtiPlatConfigRuleKey(systemCode, paramCode, serialNo);
        utiPlatConfigRuleDao.delete(utiPlatConfigRuleKey);
    }

    /**
     * @param
     * @description 修改
     */
    @Override
    public void modify(UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        UtiPlatConfigRule utiPlatConfigRule = this.convert(utiPlatConfigRuleDto, UtiPlatConfigRule.class);
        utiPlatConfigRuleDao.save(utiPlatConfigRule);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    @Override
    public UtiPlatConfigRuleDto queryByPK(String systemCode, String paramCode, Integer serialNo) {
        UtiPlatConfigRuleKey utiPlatConfigRuleKey = new UtiPlatConfigRuleKey(systemCode, paramCode, serialNo);
        UtiPlatConfigRule utiPlatConfigRule = utiPlatConfigRuleDao.findOne(utiPlatConfigRuleKey);
        return this.convert(utiPlatConfigRule, UtiPlatConfigRuleDto.class);
    }

    /**
     * 查询表名
     *
     * @param paramCode 表代码
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     */
    public String getProperty(String paramCode) throws Exception {
        if (StringUtils.isEmpty(paramCode)) {
            throw new DataVerifyException("表代码不能为空");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(" select p from UtiPlatConfigRule p where p.paramCode=:paramCode and p.systemCode='prpall'");
        Query query = entityManager.createQuery(builder.toString());
        query.setParameter("paramCode",paramCode);
        List<UtiPlatConfigRule> utiPlatConfigRules = query.getResultList();
        if (utiPlatConfigRules == null && utiPlatConfigRules.size() < 0) {
            throw new DataVerifyException("没查到该表代码，所属表");
        }
        UtiPlatConfigRule utiPlatConfigRule = utiPlatConfigRules.get(0);
        String rule = utiPlatConfigRule.getRule();
        return rule;
    }

    /**
     * 根据系统与表代码查询规则信息
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param  paramCode 表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    @Override
    public String getPropertyRule(String paramCode,String systemCode) throws Exception{
        String value = "";
        if (StringUtils.isEmpty(paramCode)) {
            throw new DataVerifyException("表代码不能为空");
        }
        if (StringUtils.isEmpty(systemCode)) {
            throw new DataVerifyException("归属系统代码不能为空");
        }
        //先查主表utiplatconfig
        UtiPlatConfigKey utiPlatConfigKey = new UtiPlatConfigKey(systemCode,paramCode);
        UtiPlatConfig utiPlatConfig = utiPlatConfigDao.findOne(utiPlatConfigKey);
        if(utiPlatConfig!=null){//如果主表不为空就查子表
            List<UtiPlatConfigRule> utiPlatConfigRuleList = utiPlatConfigRuleDao.findBySystemCodeAndParamcode(systemCode,paramCode);
            for(UtiPlatConfigRule utiPlatConfigRule : utiPlatConfigRuleList){
                value += utiPlatConfigRule.getRule();
            }
        }
        return value;
    }
    /**
     * 新老农险数据校验
     *
     * @return 拼接字段
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 上午 10:29
     */
    public String queryNewAgri() throws Exception {

        return " AND  systemFlag='agri'  ";
    }
    
    /**
      * @description 根据SystemCode和Paramcode查询UtiPlatConfigRuleDto集合
      * @author 杨昆
      * @date 2017年12月26日 上午11:32:14
      * @param systemCode,paramcode
      * @return  UtiPlatConfigRuleDto集合
     */
	@Override
	public List<UtiPlatConfigRuleDto> queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(String systemCode,
			String paramcode) {
		List<UtiPlatConfigRule> utiPlatConfigRuleList = utiPlatConfigRuleDao.findBySystemCodeAndParamcode(systemCode, paramcode);
		List<UtiPlatConfigRuleDto> utiPlatConfigRuleDtoList = new ArrayList<>();
		convertCollection(utiPlatConfigRuleList, utiPlatConfigRuleDtoList, UtiPlatConfigRuleDto.class);
		return utiPlatConfigRuleDtoList;
	}
}