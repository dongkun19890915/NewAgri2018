package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayBill;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayBillKey;
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
 * @time  2017-12-14 09:04:11.816
 * 支付信息对应清单主键表Dao数据操作对象
 */
@Repository
public interface PrpLPayBillDao extends JpaBaseDao<PrpLPayBill,PrpLPayBillKey> {
    /**
     * （按收付编号删除所有数据）
     * @author: 王志文
     * @date: 2017/12/15 15:40
     * @param paymentNo 收付编号
     */
    @Query("select p from PrpLPayBill p where p.paymentNo =:paymentNo ")
    List<PrpLPayBill> findAllByPaymentNo(@Param("paymentNo") String paymentNo);

    /**
     * （按清单号删除所有数据）
     * @author: 王志文
     * @date: 2017/12/27 10:07
     * @param billNo 清单号
     */
    @Modifying
    @Query("delete from PrpLPayBill p where p.billNo =:billNo")
    void deleteAllByBillNo(@Param("billNo") String billNo);

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2017/12/22 18:33
     * @param billNo 清单号
     * @return
     */
    @Query("select p from PrpLPayBill p where p.billNo =:billNo")
    List<PrpLPayBill> queryAllByBillNo(@Param("billNo") String billNo);

    /**
     * （通过支付编号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 10:24
     * @param paymentNo 支付编号
     * @return
     */
    @Query("select p from PrpLPayBill p where p.paymentNo =:paymentNo")
    List<PrpLPayBill> queryAllByPaymentNo(@Param("paymentNo") String paymentNo);

    @Query(value = "select p from PrpLPayBill p where p.billNo=:billNo")
    public List<PrpLPayBill> findPrpLPayBillByBillNo(@Param("billNo") String businessNo);

    @Query(value = "select p from PrpLPayBill p where p.paymentNo=:paymentNo")
    public List<PrpLPayBill> findPrpLPayBillByPaymentNo(@Param("paymentNo") String businessNo);
}