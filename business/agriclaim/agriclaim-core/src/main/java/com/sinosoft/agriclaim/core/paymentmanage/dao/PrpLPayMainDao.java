package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayMain;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayMainKey;
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
 * @time  2017-12-14 09:04:11.816
 * 支付信息主表Dao数据操作对象
 */
@Repository
public interface PrpLPayMainDao extends JpaBaseDao<PrpLPayMain,PrpLPayMainKey> {
    /**
     * （将该支付编号的信息作废）
     * @author: 王志文
     * @date: 2017/12/27 12:04
     * @param paymentNo
     */
    @Modifying
    @Transactional
    @Query("update PrpLPayMain p set p.cancelFlag = '1' where p.paymentNo =:paymentNo")
    void updateCancelFlagByPaymenNo(@Param("paymentNo") String paymentNo);


    @Modifying
    @Transactional
    @Query("update PrpLPayMain p set p.thirdPayFlag =:thirdPayFlag where p.paymentNo =:paymentNo")
    void updateThirdPayFlagByPaymentNo(@Param("thirdPayFlag") String thirdPayFlag,@Param("paymentNo") String paymentNo);

    @Modifying
    @Transactional
    @Query("update PrpLPayMain p set p.vFlag =:vFlag where p.paymentNo =:paymentNo")
    void updateVFlagByPaymentNo(@Param("vFlag") String vFlag,@Param("paymentNo") String paymentNo);

    @Modifying
    @Transactional
    @Query("update PrpLPayMain p set p.vFlag=:vflag where p.paymentNo=:paymentNo")
    public void updatePrpLPayMainByKey(@Param("paymentNo") String paymentNo,@Param("vflag") String vflag);

    @Modifying
    @Transactional
    @Query("update PrpLPayMain p set p.vFlag=:vflag,p.thirdPayFlag=:thirdPayFlag where p.paymentNo=:paymentNo")
    public void updatePrpLPayMainByKeyAndThirdPayFlag(@Param("paymentNo") String paymentNo,@Param("vflag") String vflag,@Param("thirdPayFlag")String thirdPayFlag);
}