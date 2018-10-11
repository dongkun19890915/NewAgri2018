package com.sinosoft.agriclaim.core.paymentmanage.dao;

import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayHis;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrpLPayHisKey;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrplPay;
import com.sinosoft.agriclaim.core.paymentmanage.entity.PrplPayKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * 支付信息子表Dao数据操作对象
 */
@Repository
public interface PrplPayHisDao extends JpaBaseDao<PrpLPayHis,PrpLPayHisKey> {

    /**
     * （通过序号理算书号和支付金额查询所有数据条数）
     * @author: 王志文
     * @date: 2017/12/15 11:36
     * @param serialNo 序号
     * @param compensateNo 理算书号
     * @param payAmount 支付金额
     * @return
     */
    @Query("select count(p) from PrpLPayHis p where p.serialNo =:serialNo and p.compensateNo =:compensateNo and p.payAmount =:payAmount ")
    int getCountBySerialNoAndCompensateNoAndPayAmount(@Param("serialNo") String serialNo,
                                                                @Param("compensateNo") String compensateNo,
                                                                @Param("payAmount") double payAmount);

    /**
     * （通过立案号和理算书号和支付类型查询所有数据条数）
     * @author: 王志文
     * @date: 2017/12/15 17:08
     * @param claimNo
     * @param compensateNo
     * @param payType
     * @return
     */
    @Query("select count (p) from PrpLPayHis p where p.claimNo =:claimNo and p.compensateNo =:compensateNo and p.payType =:payType")
    int getCountByClaimNoAndCompensateNoAndPayType(@Param("claimNo")String claimNo,
                                                   @Param("compensateNo")String compensateNo,
                                                   @Param("payType")String payType);

}