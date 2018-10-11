package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.entity.PrpCPmainLoan;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.entity.PrpCPmainLoanKey;
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
 * @time  2017-11-28 09:52:32.110 
 * 贷款保险保单信息Dao数据操作对象
 */
@Repository
public interface PrpCPmainLoanDao extends JpaBaseDao<PrpCPmainLoan,PrpCPmainLoanKey> {
    /**
     * 根据保单号删除PrpCPmainLoan表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param policyNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpCPmainLoan p WHERE p.policyNo=:policyNo")
    public void deletePrpCPmainLoan(@Param("policyNo") String policyNo) throws Exception;
}