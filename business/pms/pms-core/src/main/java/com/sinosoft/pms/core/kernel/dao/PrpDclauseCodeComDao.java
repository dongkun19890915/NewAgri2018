package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeCom;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeComKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515
 * 条款机构配置表Dao数据操作对象
 */
@Repository
public interface  PrpDclauseCodeComDao extends JpaBaseDao< PrpDclauseCodeCom, PrpDclauseCodeComKey> {

    /**
     * 根据条款代码查询条款机构配置主表
     * @author: 刘曼曼
     * @date: 2017/11/10 10:31 * @param clauseCode
     * @return List<PrpDclauseCodeCom> 条款机构配置表集合
     */
    List<PrpDclauseCodeCom> findByClauseCode(String clauseCode);



    /**
     * 根据条款代码删除条款机构配置列表信息
     * @author: 刘曼曼
     * @date: 2017/11/9 18:31
     * @param clauseCode 条款代码
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpDclauseCodeCom p where p.clauseCode=:clauseCode")
    void deleteClauseCode(@Param("clauseCode") String clauseCode);
    /**
     * 根据条款代码集合批量删除条机构款配置表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:26
     * @param clauseCodes 条款代码集合
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpDclauseCodeCom where clauseCode in(:clauseCodes)")
    void deleteList(@Param("clauseCodes") List<String> clauseCodes);
}