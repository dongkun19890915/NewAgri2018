package com.sinosoft.agriclaim.core.claimmanage.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.repository.query.Param;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * 立案基本信息表Dao数据操作对象
 */
@Repository
public interface PrpLClaimDao extends JpaBaseDao<PrpLClaim,PrpLClaimKey> {
	@Query("SELECT P FROM PrpLClaim P where registNo=?1 and cancelDate is null")
	public List<PrpLClaim> findByRegistNoAndCancelDateNull(String registNo);

	@Query("SELECT P FROM PrpLClaim P where registNo=?1")
	public List<PrpLClaim> findByRegistNo(String registNo);
	
	@Query("SELECT claimNo FROM PrpLClaim  where registNo=?1")
	public String findClaimNoByRegistNo(String registNo);

	@Transactional(rollbackFor = Exception.class)
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM PrpLClaim Where claimNo = ?1")
	void deleteByClaimNo(String claimNo);
	
	@Transactional(rollbackFor = Exception.class)
	 @Modifying(clearAutomatically = true)
	    @Query(value = " update PrpLClaim set sumPaid=?1" +
	            " Where " +
	            " claimNo =?2")
    public void updatePrpLclaimSumPaid(double sumPaid,String claimNo);
	/**
     * @description: （通过报案号查询对应数据条数）
     * @author: 王志文
     * @date: 2017/11/13 17:32
     * @param registNo
     * @return
     */
    @Query("select count(p.claimNo) from PrpLClaim p where p.registNo =:registNo")
    int getCountByRegistNo(@Param("registNo")String registNo);

    /**
     * @description: （通过报案号查询所有立案信息,支持模糊查询）
     * @author: 王志文
     * @date: 2017/11/13 17:32
     * @param registNo
     * @return
     */
    @Query("select p from PrpLClaim p where p.registNo like:registNo")
    List<PrpLClaim> queryAllByRegistNo(@Param("registNo")String registNo);


    /**
     * （通过结案号查询所有信息,支持模糊查询）
     * @author: 王志文
     * @date: 2017/12/1 17:25
     * @param caseNo
     * @return
     */
    @Query("select p from PrpLClaim p where p.caseNo like:caseNo ")
    List<PrpLClaim> queryAllByCaseNo(@Param("caseNo")String caseNo);

    /**
     * （通过保单号获取所有立案信息,支持模糊查询）
     * @author: 王志文
     * @date: 2017/11/16 10:11
     * @param policyNo
     * @return
     */
    @Query("select p from PrpLClaim p where p.policyNo like:policyNo ")
    List<PrpLClaim> queryListByPolicyNo(@Param("policyNo") String policyNo);


    /**
     * （通过立案号模糊查询，获取所有立案信息）
     * @author: 王志文
     * @date: 2017/12/8 14:47
     * @param claimNo
     * @return
     */
    @Query("select p from PrpLClaim p where p.claimNo like:claimNo ")
    List<PrpLClaim> queryVagueListByClaimNo(@Param("claimNo") String claimNo);
	@Query(value = "Select * from PrpLClaim  Where  claimNo = :claimNo and endcasedate is null ",nativeQuery=true)
	public List<PrpLClaim> findByClaimNo(@Param("claimNo") String claimNo);
	@Query(value = "Select * from PrpLClaim  Where  registNo = :registNo and endcasedate is null ",nativeQuery=true)
	public List<PrpLClaim> findByRegistNoWithEndcaseDate(@Param("registNo") String registNo);
	@Query(value = "Select * from PrpLClaim  Where  registNo = :registNo and claimNo<>:claimNo and endcasedate is null ",nativeQuery=true)
	public List<PrpLClaim> findByRegistNoAndClaimNo(@Param("registNo") String registNo,@Param("claimNo") String claimNo);

	@Query(value="Select DISTINCT prplclaim.claimNo,prplclaim.registNo, prplclaim.operatorCode, prplclaim.caseType, b.OperateDate,b.Status, b.RiskCode, prplregist.reportDate,prplclaim.inputDate "
			+ "From (select * from PrpLClaimStatus where NodeType='claim') b LEFT JOIN prplclaim ON prplclaim.ClaimNo = b.BusinessNo "
			+ "LEFT JOIN prplregist ON prplclaim.registNo = prplregist.registNo where prplclaim.registNo=?1 "
			+ "order by prplclaim.claimno",nativeQuery=true)
	Object[]  findByQueryConditions(String registNo);
}