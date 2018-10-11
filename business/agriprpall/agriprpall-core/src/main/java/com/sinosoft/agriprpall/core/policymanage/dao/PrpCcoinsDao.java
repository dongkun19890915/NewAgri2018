package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoins;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;

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
 * @time  2017-10-24 07:46:04.010 
 * 共保信息表Dao数据操作对象
 */
@Repository
public interface PrpCcoinsDao extends JpaBaseDao<PrpCcoins,PrpCcoinsKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpCcoins p " +
            "where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);

    @Query(value = "select p from PrpCcoins p " +
            "where p.policyNo= ?1 " +
            "order by p.serialNo")
    public List<PrpCcoins> queryAllByPolicyNo(String policyNo);

    /**
     *  根据保单号查询prpCcoins 共保信息表信息
     * @author: 田慧
     * @date: 2017/11/20 13:22
     * @param policyNo 保单号
     * @return PrpCcoins 共保信息表的集合
     */
    public List<PrpCcoins> findByPolicyNoLike( String policyNo);
}