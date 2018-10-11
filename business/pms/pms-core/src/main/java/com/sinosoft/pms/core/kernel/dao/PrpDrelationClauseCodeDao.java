package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDrelationClauseCode;
import com.sinosoft.pms.core.kernel.entity.PrpDrelationClauseCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-18 02:37:33.970 
 * 条款与保险责任关联表Dao数据操作对象
 */
@Repository
public interface PrpDrelationClauseCodeDao extends JpaBaseDao<PrpDrelationClauseCode,PrpDrelationClauseCodeKey> {
    /**
     * 根据条款代码集合批量删除条款与保险责任表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:26
     * @param clauseCodes 条款代码集合
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpDrelationClauseCode where clauseCode in(:clauseCodes)")
    void deleteList(@Param("clauseCodes") List<String> clauseCodes);

    /**
     * 根据条款代码删除条款与保险责任关系表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:24
     * @param clauseCode 条款代码
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpDrelationClauseCode where clauseCode=:clauseCode")
    void deleteClauseCode(@Param("clauseCode") String clauseCode);

    /**
     * 根据条款代码查询条款与保险责任关系表信息
     * @author: 刘曼曼
     * @date: 2017/12/19 16:05
     * @param clauseCode 条款代码
     * @return List<PrpDrelationClauseCode> 条款与保险责任关系表信息集合
     */
    public List<PrpDrelationClauseCode> queryAllByClauseCode(String clauseCode);
}