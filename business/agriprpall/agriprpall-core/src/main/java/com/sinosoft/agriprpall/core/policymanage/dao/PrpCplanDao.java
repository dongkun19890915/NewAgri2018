package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCplan;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCplanKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 收费计划表Dao数据操作对象
 */
@Repository
public interface PrpCplanDao extends JpaBaseDao<PrpCplan,PrpCplanKey> {

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCplan p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo") String policyNo);

    /**
     * 理赔调用服务，查询未缴费的条数
     * @author: 田健
     * @date: 2017/11/10 17:23
     * @param policyNo 保单号
     * @return 查询到的数量（int)
     */
    @Query(value = "select count(a) from PrpCplan a where a.policyNo=:policyNo and a.payReason='R10' and a.planFee=0")
    public long queryPays(@Param("policyNo") String policyNo);

    /**
     * 理赔调用服务，查询计划缴费和已缴费
     * @author: 田健
     * @date: 2017/11/11 11:12
     * @param policyNo 保单号
     * @return List<PrpCplan> 返回实体集合
     */
    @Query(value = "SELECT b FROM PrpCplan b where b.payNo > 0 and b.delinquentFee>0 and b.policyNo=:policyNo")
    public List<PrpCplan> getDelinquentfeeTime(@Param("policyNo") String policyNo);

    /**
     * 根据保单号查询收费计划表PrpCplan的应交费金额总数，拖欠金额总数
     * @author: 宋振振
     * @date: 2017/11/11 14:54
     * @param policyNo
     * @return List<Object[]>
     */
    @Query(value = "SELECT sum(p.planFee),sum(p.delinquentFee) FROM PrpCplan p where (p.endorseNo is null or p.endorseNo='' ) and p.payReason='R20' and p.policyNo =:policyNo")
    public List<Object[]> findFeeSum(@Param("policyNo") String policyNo);
    /**
     *  根据保单号查询prpCplan表（收费计划表）信息
     * @author: 田慧
     * @date: 2017/11/20 9:54
     * @param policyNo 保单号
     * @return prpCplanDtoList 返回PrpCplan的集合
     */
    public List<PrpCplan> findByPolicyNoLike(String policyNo);

    /**
     * @description: （按保单号查询所有的数据，保单抄件用）
     * @author: 王志文
     * @date: 2017/11/16 9:50
     * @param policyNo
     * @return
     */
    @Query("select p from PrpCplan p where p.policyNo =:policyNo ")
    List<PrpCplan> queryListByPolicyNo(@Param("policyNo")String policyNo);


    /**
     * 根据保单号查询收费计划表PrpCplan的应交费金额总数
     *
     * @param policyNo
     * @return Double
     * @author: 潘峰
     * @date: 2017/11/11 14:54
     */
    @Query(value = "SELECT sum(p.delinquentFee) FROM PrpCplan p where payReason='R10' and  p.policyNo =:policyNo")
    public Double sumDelinquentFee(@Param("policyNo") String policyNo);


}