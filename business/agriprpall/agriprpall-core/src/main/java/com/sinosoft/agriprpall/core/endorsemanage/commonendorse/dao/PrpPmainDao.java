package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPmainDao extends JpaBaseDao<PrpPmain,PrpPmainKey>{

    @Modifying
    @Transactional
    @Query(value = "delete from PrpPmain p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    @Query("select count (p.endorseNo) from PrpPmain p where p.policyNo=:policyNo and p.underwriteFlag<>1")
    public int findAllByPolicyNoAndUnderwriteFlag(@Param("policyNo") String policyNo);

    /**
     * 根据批单号码回写printNo
     * @author: 何伟东
     * @date: 2017/12/4 15:31
     * @param endorseNo 批单号
     * @param printNo 印刷流水号
     * @return 操作行数
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update PrpPmain p set p.printNo= :printNo where p.endorseNo = :endorseNo")
    public int updatePrintNo(@Param("endorseNo") String endorseNo,@Param("printNo") String printNo);

    @Query(value = "select p from PrpPmain p where p.endorseNo=?1 ")
    public PrpPmain queryAllByEndorseNo(String endorseNo);

    /**
     * 根据保单号查询最新的批单号码
     * @author: 何伟东
     * @date: 2017/12/25 11:28
     * @param policyNo 保单号码
     * @return 批单号码
     */
    @Query(value = "select max(p.endorseNo) from PrpPmain p where p.policyNo = :policyNo")
    String queryEndorseNoByPolicyNo(@Param(value = "policyNo") String policyNo);
}
