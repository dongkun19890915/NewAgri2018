package com.sinosoft.agriclaim.core.registmanage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案信息表Dao数据操作对象
 */
@Repository
public interface PrpLRegistDao extends JpaBaseDao<PrpLRegist,PrpLRegistKey> {
	
	@Query("SELECT COUNT(u) FROM PrpLRegist u WHERE registNo=?1")
	public int findCountByRegistno(String registNo);
	
	@Query(value = "Select r from PrpLRegist r Where  registNo = :registNo and (cancelDate is null or cancelDate ='')")
	public List<PrpLRegist> findByCondition(@Param("registNo") String registNo);

    @Query(value = "Select Prplregist.*  From Prplregist Prplregist ,prplext t where t.certino(+)=Prplregist.registno and  prplregist.policyNo =:policyNo order by registNo ",nativeQuery=true)
    public List<PrpLRegist> findwithPrplext(@Param("policyNo") String policyNo);
    
	@Modifying
	@Transactional
	@Query("DELETE  FROM PrpLRegist WHERE registNo=?1")
	void deleteByRegistNo(String registNo);

	@Query("SELECT p FROM PrpLRegist p WHERE registNo=?1")
	PrpLRegist findByRegistNo(String registNo);

}