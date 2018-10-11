package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpPolicyFeeNotice;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpPolicyFeeNoticeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757 
 * 保费缴款通知书信息表Dao数据操作对象
 */
@Repository
public interface PrpPolicyFeeNoticeDao extends JpaBaseDao<PrpPolicyFeeNotice,PrpPolicyFeeNoticeKey> {
    @Transactional
    @Modifying(clearAutomatically = true)
   @Query(value = "update PrpPolicyFeeNotice f set f.policyFeeNo=:policyFeeNo where f.policyNo=:policyNo")
   public int updatepolicyFeeNo(@Param(value = "policyFeeNo") String policyFeeNo,@Param(value = "policyNo") String policyNo);
}