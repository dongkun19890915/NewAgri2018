package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCrenewal;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCrenewalKey;
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
 * @time  2017-10-24 07:46:04.010 
 * 续保信息表Dao数据操作对象
 */
@Repository
public interface PrpCrenewalDao extends JpaBaseDao<PrpCrenewal,PrpCrenewalKey> {
    /**
     * 根据oldPolicyNo查询PrpCrenewal
     * @author: 宋振振
     * @date: 2017/11/8 11:33
     * @param oldPolicyNo
     * @return List<PrpCrenewal>
     */
    public List<PrpCrenewal> findPrpCrenewalByOldPolicyNo(String oldPolicyNo);

    /**
     * 根据policyNo查询PrpCrenewal
     * @author: 宋振振
     * @date: 2017/11/10 11:07
     * @param policyNo
     * @return List<PrpCrenewal>
     */
    public List<PrpCrenewal> findPrpCrenewalByPolicyNo(String policyNo);


    @Query("select p from PrpCrenewal p where p.policyNo=:policyNo and p.oldPolicyNo=:oldPolicyNo")
    public List<PrpCrenewal> findByPolicyNoAndOldPolicyNo(@Param("policyNo")String policyNo,@Param("oldPolicyNo")String oldPolicyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCrenewal p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo") String policyNo);
}