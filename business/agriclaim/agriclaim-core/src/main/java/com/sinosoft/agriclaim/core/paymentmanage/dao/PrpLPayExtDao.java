package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayExt;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayExtKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258
 * 支付处理意见表Dao数据操作对象
 */
@Repository
public interface PrpLPayExtDao extends JpaBaseDao<PrpLPayExt,PrpLPayExtKey> {
    /**
     * （根据收付编号删除所有数据）
     * @author: 王志文
     * @date: 2017/12/15 10:07
     * @param paymentNo 收付编号
     */
    @Query("select p from PrpLPayExt p where p.paymentNo =:paymentNo ")
    List<PrpLPayExt> findAllByPaymentNo(@Param("paymentNo") String paymentNo);


    /**
     * （通过支付编码获取数据条数）
     * @author: 王志文
     * @date: 2017/12/15 17:30
     * @param paymentNo 收付编号
     * @return
     */
    @Query("select count(p) from PrpLPayExt p where p.paymentNo =:paymentNo")
    int getCountByPaymentNo(@Param("paymentNo") String paymentNo);

    @Query("select p from PrpLPayExt p where p.paymentNo =:paymentNo")
    List<PrpLPayExt> queryAllByPaymentNo(@Param("paymentNo") String paymentNo);

    @Query(value = "select count(p) from PrpLPayExt p where p.paymentNo=:paymentNo ")
    public int findPrpLPayExtCount(@Param("paymentNo") String businessNo);
}
