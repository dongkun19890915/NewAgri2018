package com.sinosoft.agriclaim.core.registmanage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistTextKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * 报案文字表Dao数据操作对象
 */

@Repository
public interface PrpLRegistTextDao extends JpaBaseDao<PrpLRegistText, PrpLRegistTextKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLRegistText Where registNo = ?1")
	void deleteByRegistNo(String registNo);

	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLRegistText Where registNo = ?1 and textType = ?2")
	void deleteByRegistNoAndTextType(String registNo, String textType);

	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLRegistText Where registNo = ?1 and (textType = ?2 or textType=?3 or textType=?4)")
	void deleteByRegistNoAndTextType(String registNo, String textType, String textType2,String textType3);

	@Query("SELECT p FROM PrpLRegistText p Where registNo = ?1 and textType = ?2")
	List<PrpLRegistText> findByRegistNoAndTextType(String registNo, String textType);
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLRegistText where registNo = :registNo and (textType = '3' or textType='07')")
	public void deleteByRegistNoAndType(@Param(value = "registNo") String registNo);
}