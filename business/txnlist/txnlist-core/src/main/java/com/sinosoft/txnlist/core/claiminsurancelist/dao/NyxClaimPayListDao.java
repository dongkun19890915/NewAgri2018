package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxClaimPayList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxClaimPayListKey;
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
 * @time  2018-01-02 07:30:32.914
 * 理赔支付清单表Dao数据操作对象
 */
@Repository
public interface NyxClaimPayListDao extends JpaBaseDao<NyxClaimPayList,NyxClaimPayListKey> {
    @Query(value = "select  p.* from NyxClaimPayList p where p.listNo=:listNo order by to_number(p.serialNo)",nativeQuery = true)
    public List<NyxClaimPayList> findNyxClaimPayListByListNo(@Param("listNo") String listNo);

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param listNo 清单号
     * @return
     */
    @Query("select n from NyxClaimPayList n where n.listNo =:listNo ")
    List<NyxClaimPayList> queryAllByListNo(@Param("listNo") String listNo);

    @Query("select p from NyxClaimPayList p where p.compensateNo=:compensateNo")
    public List<NyxClaimPayList> findNyxClaimPayListByCompensateNo(@Param("compensateNo") String compensateNo);

    @Transactional
    @Modifying
    @Query("delete from NyxClaimPayList where compensateNo=:compensateNo")
    public void deleteNyxClaimPayListByCompensateNo(@Param("compensateNo") String compensateNo);

    @Query("select n from NyxClaimPayList n where n.paymentNo =:paymentNo ")
    List<NyxClaimPayList> queryAllByPaymentNo(@Param("paymentNo") String paymentNo);
}