package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrplPay;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrplPayKey;
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
 * @time  2017-11-08 05:43:17.258 
 * 支付信息子表Dao数据操作对象
 */
@Repository
public interface PrplPayDao extends JpaBaseDao<PrplPay,PrplPayKey> {

    /**
     * （按序号删除所有数据,在2017-08-01后的数据）
     * @author: 王志文
     * @date: 2017/12/15 9:39
     * @param serialNo 序号
     */
    @Query("select p from PrplPay p where p.serialNo =:serialNo and p.inputDate >= to_date('2017-08-01','yyyy-mm-dd')")
    List<PrplPay> findAllBySerialNo(@Param("serialNo") String serialNo);

    /**
     * （通过序号，理算书号和支付金额查询所有数据）
     * @author: 王志文
     * @date: 2017/12/15 11:36
     * @param serialNo 序号
     * @param compensateNo 理算书号
     * @param payAmount 支付金额
     * @return
     */
    @Query("select p from PrplPay p where p.serialNo =:serialNo and p.compensateNo =:compensateNo and p.payAmount =:payAmount ")
    List<PrplPay> queryAllBySerialNoAndCompensateNoAndPayAmount(@Param("serialNo")int serialNo,
                                                                @Param("compensateNo")String compensateNo,
                                                                @Param("payAmount")double payAmount);

    /**
     * （通过序号，理算书号查询所有数据）
     * @author: 王志文
     * @date: 2017/12/15 16:58
     * @param serialNo 序号
     * @param compensateNo 理算书号
     * @return
     */
    @Query("select p from PrplPay p where p.serialNo =:serialNo and p.compensateNo =:compensateNo ")
    List<PrplPay> queryAllBySerialNoAndCompensateNo(@Param("serialNo")String serialNo,@Param("compensateNo")String compensateNo);

    /**
     * （通过支付编号查询所有信息）
     * @author: 王志文
     * @date: 2017/12/28 17:26
     * @param serialNo
     * @return
     */
    @Query("select p from PrplPay p where p.serialNo =:serialNo ")
    List<PrplPay> queryAllBySerialNo(@Param("serialNo") String serialNo);

    /**
     * （按理算书号查询所有信息）
     * @author: 王志文
     * @date: 2017/12/29 8:57
     * @param compensateNo 计算书号
     * @return
     */
    @Query("select p from PrplPay p where p.compensateNo =:compensateNo")
    List<PrplPay> queryAllByCompensateNo(@Param("compensateNo") String compensateNo);

    @Modifying
    @Transactional
    @Query(value = "update PrplPay p set p.vFlag =:vFlag where p.serialNo =:paymentNo")
    void updateVFlagBySerialNo(@Param("vFlag") String vFlag,@Param("paymentNo") String paymentNo);

    @Modifying
    @Transactional
    @Query(value = "update PrplPay p set p.vFlag=:vFlag where p.serialNo=:serialNo")
    public void updatePrpLPayBySerialNo(@Param("vFlag") String vflag, @Param("serialNo") String paymentNo);
}