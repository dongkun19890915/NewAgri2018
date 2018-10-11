package com.sinosoft.agriclaim.core.recasemanage.dao;

import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecaseKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * 重开赔案表Dao数据操作对象
 */
@Repository
public interface PrpLRecaseDao extends JpaBaseDao<PrpLRecase,PrpLRecaseKey> {
    /**
     * @description: （找到最大的serialNo）
     * @author: 王志文
     * @date: 2017/11/9 11:05
     * @param claimNo
     * @return
     */
    @Query(" select p from PrpLRecase p where p.claimNo =:claimNo " +
            "and p.serialNo=(select max(a.serialNo) from PrpLRecase a where a.claimNo =:claimNo)")
    PrpLRecase queryMaxSerialNoPrpByClaimNo(@Param("claimNo")String claimNo);

    /**
     * @description: （通过claimNo找到对应数据的条数）
     * @author: 王志文
     * @date: 2017/11/9 15:14
     * @param claimNo
     * @return int
     */
    @Query("select count(claimNo) from PrpLRecase Where claimNo =:claimNo order by serialNo desc")
    int getCountByClaimNo(@Param("claimNo") String claimNo);

    /**
     * @description: （通过主键更新flag）
     * @author: 王志文
     * @date: 2017/11/9 15:35
     * @param flag
     * @param claimNo
     * @param serialNo
     */
    @Modifying
    @Query("update PrpLRecase set flag =:flag ,undwrtFlag =:undwrtFlag,nodeNo =:nodeNo where claimNo =:claimNo and serialNo =:serialNo ")
    void upDateByEntity(@Param("flag") String flag,
                        @Param("undwrtFlag") String undwrtFlag,
                        @Param("nodeNo")int nodeNo,
                        @Param("claimNo")String claimNo,
                        @Param("serialNo")int serialNo);

    /**
     * （根据案件状态查询所有信息）
     * @author: 王志文
     * @date: 2017/12/5 14:49
     * @param undwrtFlag
     * @return
     */
    @Query("select distinct p from PrpLRecase p where p.undwrtFlag =:undwrtFlag")
    List<PrpLRecase> queryAllByUndwrtFlag(@Param("undwrtFlag") String undwrtFlag);
    /**
     * （根据立案号查询实体）
     * @author: 董坤
     * @date: 2017/11/15 10:55
     * @param claimNo 立案号
     * @return 重开赔案实体list
     */
    @Query(value=" select p from PrpLRecase p where p.claimNo= ?1 order by p.serialNo desc ")
    public List<PrpLRecase> findByClaimNoOrderBySerialNo(String claimNo);

    /**
     * （根据立案号查询对应的最大序号）
     * @author: 董坤
     * @date: 2017/11/18 17:13
     * @param claimNo 立案号
     * @return 立案号对应的最大序号
     */
    @Query(value=" select Max(p.serialNo) from PrpLRecase p where p.claimNo= ?1 ")
    public Integer findMaxSerialNoByClaimNo(String claimNo);

    /**
     *  根据投保单号查询PrpLRecase表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLRecaseDtoList 返回PrpLRecaseDto的集合
     */
    public List<PrpLRecase> findByClaimNo(String claimNo);

}