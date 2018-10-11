package com.sinosoft.ims.core.auth.dao;


import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigRule;
import com.sinosoft.ims.core.auth.entity.UtiPlatConfigRuleKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * UtiplatconfigruleDao数据操作对象
 */
@Repository
public interface UtiPlatconfigRuleDao extends JpaBaseDao<UtiPlatConfigRule,UtiPlatConfigRuleKey> {

    @Query(" select u from UtiPlatConfigRule u where u.paramCode=:paramCode")
    public List<UtiPlatConfigRule> findOneUtiplatconfigrule(@Param("paramCode") String paramCode);

    @Query(" select u from UtiPlatConfigRule u where u.systemCode = ?1 and u.paramCode = ?2")
    List<UtiPlatConfigRule> findBySystemCodeAndParamcode(String systemCode,String paramcode);

}