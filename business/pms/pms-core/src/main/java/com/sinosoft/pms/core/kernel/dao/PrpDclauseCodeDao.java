package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.  PrpDclauseCode;
import com.sinosoft.pms.core.kernel.entity.  PrpDclauseCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515
 * 条款配置主表Dao数据操作对象
 */
@Repository
public interface   PrpDclauseCodeDao extends JpaBaseDao<  PrpDclauseCode,  PrpDclauseCodeKey> {
    /**
     * 根据条款代码查询条款配置主表列表信息
     * @author: 刘曼曼
     * @date: 2017/11/9 15:19
     * @param clauseCode
     * @return PrpDclauseCode 条款主表信息
     */
    @Query(value = "select a from PrpDclauseCode a where a.clauseCode=:clauseCode")
    PrpDclauseCode findByClauseCode(@Param("clauseCode") String clauseCode);

    /**
     * 根据条款代码删除列表信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:31
     * @param clauseCode 条款代码
     */
    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "update PrpDclauseCode p set p.logicDelete='0' where p.clauseCode=:clauseCode")
    void deleteClauseCode(@Param("clauseCode") String clauseCode);

    /**
     * 根据条款代码集合批量删除条款配置主表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:26
     * @param clauseCodes 条款代码集合
     */
    @Transactional
    @Modifying
    @Query(value = "update PrpDclauseCode p set p.logicDelete='0' where clauseCode in(:clauseCodes)")
    void deleteList(@Param("clauseCodes") List<String> clauseCodes);
    @Query(value = "select c from PrpDclauseCode c where c.validStatus='1' and c.logicDelete='1' and c.clauseCode=:clauseCode and c.startDate <= :date and c.endDate >= :date and c.flag='1'")
    PrpDclauseCode getPrpDclauseCodeInfo(@Param("clauseCode") String clauseCode, @Param("date") Date date);

}