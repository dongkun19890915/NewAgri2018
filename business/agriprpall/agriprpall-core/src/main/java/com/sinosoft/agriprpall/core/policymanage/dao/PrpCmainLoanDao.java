package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainLoan;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainLoanKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 07:46:04.010 
 * 贷款保险保单信息Dao数据操作对象
 */
@Repository
public interface PrpCmainLoanDao extends JpaBaseDao<PrpCmainLoan,PrpCmainLoanKey> {
}