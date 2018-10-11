package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgri;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainAgriKey;
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
 * 农业险保单信息Dao数据操作对象
 */
@Repository
public interface PrpCmainAgriDao extends JpaBaseDao<PrpCmainAgri,PrpCmainAgriKey> {

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCmainAgri p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo);

    /**
     * 根据保单号查询PrpCmainAgri表信息
     * @author: 田健
     * @date: 2018/5/16 17:17
     * @param policyNo 保单号
     * @return PrpCmainAgri信息
     */
    @Query(value = "select p from PrpCmainAgri p where p.policyNo= ?1")
    public PrpCmainAgri queryByPolicyNo(String policyNo);
}