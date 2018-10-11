package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKind;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseCodeKindKey;
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
 * @time  2017-11-07 03:36:19.515
 * 条款险别配置表Dao数据操作对象
 */
@Repository
public interface PrpDclauseCodeKindDao extends JpaBaseDao<PrpDclauseCodeKind,PrpDclauseCodeKindKey> {
    /**
     * 根据条款代码查询条款险别配置表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:25
     * @param clauseCode 条款代码
     * @return List<PrpDclauseCodeKind>条款险别表信息集合
     */
    List<PrpDclauseCodeKind> findByClauseCode(String clauseCode);
//    @Query(value = "select p from PrpDclauseCodeKind p where p.clauseCode=:clauseCode ")
//    public List<PrpDclauseCodeKind> selectByClauseCode(@Param("clauseCode") String clauseCode);

    /**
     * 根据条款代码删除条款险别配置表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:24
     * @param clauseCode 条款代码
     */
    @Transactional
//    @Modifying(clearAutomatically = true)
    @Modifying
    @Query(value = "delete from PrpDclauseCodeKind p where p.clauseCode=:clauseCode",nativeQuery = true)
    Integer deleteClauseCode(@Param("clauseCode") String clauseCode);

    /**
     * 根据条款代码集合批量删除条款险别配置表信息
     * @author: 刘曼曼
     * @date: 2017/11/10 10:26
     * @param clauseCodes 条款代码集合
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpDclauseCodeKind where clauseCode in(:clauseCodes)")
    void deleteList(@Param("clauseCodes") List<String> clauseCodes);

    /**
     * 根据clauseCode条款和calculateFlag主险标识代码查询险别
     * @author: 田慧
     * @date: 2017/12/14 14:16
     * @param clauseCode 条款代码
     * @param calculateFlag 主险标识：1-主险，2-附加险
     * @return  kindCodeList kindCode的集合
     * @throws Exception
     */
    @Query(value = "select distinct (p.kindCode) from PrpDclauseCodeKind p where p.clauseCode =:clauseCode and substring(p.calculateFlag,3,1) =:calculateFlag")
    List<String> queryByClauseCode(@Param("clauseCode") String clauseCode,@Param("calculateFlag") String calculateFlag);
    /**
     *  根据clauseCode条款代码和kindCode险别代码查询标的
     * @author: 田慧
     * @date: 2017/12/16 10:38
     * @param clauseCode 条款代码
     * @param kindCode 险别代码
     * @return itemCodeList itemCode的集合
     * @throws Exception
     */
    @Query(value = "select distinct (p.itemCode) from PrpDclauseCodeKind p where p.clauseCode =:clauseCode and p.kindCode =:kindCode")
    List<String>  queryItemCode(@Param("clauseCode") String clauseCode,@Param("kindCode") String kindCode);

    /**
     * 根据条款代码查询条款险别配置
     * @author: 宋振振
     * @date: 2018/4/14 14:20
     * @param clauseCode
     * @return  List<PrpDclauseCodeKind>
     */
    @Query(value = "select p from PrpDclauseCodeKind p where p.clauseCode =:clauseCode")
    List<PrpDclauseCodeKind>  queryByClauseCode(@Param("clauseCode") String clauseCode);
}