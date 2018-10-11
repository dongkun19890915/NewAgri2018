package com.sinosoft.agriclaim.core.endcasemanage.dao;

import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNo;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNoKey;
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
 * @time  2017-11-08 05:42:04.174 
 * 赔案号表Dao数据操作对象
 */
@Repository
public interface PrpLCaseNoDao extends JpaBaseDao<PrpLCaseNo,PrpLCaseNoKey> {
    /**
     * （结案信息保存前 根据赔案号删除实体）
     * @author: 董坤
     * @date: 2017/11/14 17:13
     * @param caseNo 赔案号
     */
    @Modifying
    @Query(value="delete from PrpLCaseNo p where p.caseNo = :caseNo ")
    public void deleteByCaseNo(@Param("caseNo") String caseNo);

    /**
     * （根据立案号查询实体list）
     * @author: 董坤
     * @date: 2017/11/15 11:22
     * @param claimNo 立案号
     * @return 实体list
     */
    @Query(value="select p from PrpLCaseNo p where p.claimNo = ?1 ")
    public List<PrpLCaseNo> findByClaimNo(String claimNo);

//    @Query(value = "select p from PrpLCaseNo p where p.caseNo =?1 ")
    public List<PrpLCaseNo> findByCaseNo(String caseNo);
}