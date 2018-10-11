package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:35:28.283 理赔节点状态表Dao数据操作对象
 */
@Repository
public interface PrpLclaimStatusDao extends JpaBaseDao<PrpLclaimStatus, PrpLclaimStatusKey> {
	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLclaimStatus Where businessno = ?1")
	void deleteByBusinessno(String registNo);

	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLclaimStatus Where businessno = ?1 and nodetype=?2")
	void deleteByBusinessnoAndNodetype(String registNo, String NodeType);

	@Modifying
	@Transactional
	@Query("DELETE FROM PrpLclaimStatus Where businessno = ?1 and nodetype=?2 and serialno=?3")
	void deleteByBusinessnoAndNodetypeAndSerialno(String businessno, String nodetype, int serialno);

	@Query("SELECT p FROM PrpLclaimStatus p Where businessno = ?1 and nodetype = ?2 and serialno = ?3")
	PrpLclaimStatus findByBusinessnoAndNodetypeAndSerialno(String businessno, String nodetype, int serialno);

	@Query("SELECT p FROM PrpLclaimStatus p Where businessno = ?1 and nodetype = ?2")
	PrpLclaimStatus findByBusinessnoAndNodetype(String businessno, String nodeType);

	@Query("SELECT p FROM PrpLclaimStatus p Where businessno = ?1 and nodetype = ?2 and typeflag = ?3")
	PrpLclaimStatus findByBusinessnoAndNodetypeAndTypeflag(String businessno, String nodeType, String typeFlag);

	@Query(value = "Select * from PrplClaimStatus Where businessNo=:businessNo AND  serialNo=:serialNo AND nodeType =:nodeType ", nativeQuery = true)
	public List<PrpLclaimStatus> findByCondition(@Param("businessNo") String BusinessNo,
			@Param("serialNo") int SerialNo, @Param("nodeType") String NodeType);
	/**
     * （根据业务号型删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param businessNo 业务号
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLclaimStatus where businessno = :businessno ")
	public void deleteByBusinessNo(@Param(value = "businessno") String businessno);
	/**
     * （根据业务号、序列号和节点类型删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param businessNo 业务号
     * @param serialno 序列号
     * @param nodeType 节点类型
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLclaimStatus where businessno = :businessno and nodetype= :nodetype and serialno= :serialno")
	public void deleteByBusiNoNodeTypeSer(@Param(value = "businessno") String businessno,@Param(value = "nodetype") String nodetype,@Param(value = "serialno") int serialno);
	
	 /**
     * （根据业务号和节点类型删除实体）
     * @author: 董坤
     * @date: 2017/11/14 11:03
     * @param businessNo 业务号
     * @param nodeType 节点类型
     */
    @Modifying(clearAutomatically = true)//自动清除实体里保存的数据。
    @Query(value=" delete from PrpLclaimStatus p where p.businessno= ?1 and p.nodetype= ?2 ")
    public void deleteByBusinessNoAndNodeType(String businessNo,String nodeType);
    @Modifying
	@Query("delete from PrpLclaimStatus where businessno =:businessno and nodeType =:nodeType")
	void deleteByContion(@Param("businessno") String businessno,@Param("nodeType") String nodeType);
}