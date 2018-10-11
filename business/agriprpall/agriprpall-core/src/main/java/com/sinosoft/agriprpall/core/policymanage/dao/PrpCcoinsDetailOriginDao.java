package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsDetailOrigin;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCcoinsDetailOriginKey;
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
 * @time  2017-11-05 01:01:20.710 
 * PrpCcoinsDetailOriginDao数据操作对象
 */
@Repository
public interface PrpCcoinsDetailOriginDao extends JpaBaseDao<PrpCcoinsDetailOrigin,PrpCcoinsDetailOriginKey> {
    @Modifying
    @Transactional
    @Query("delete from PrpCcoinsDetailOrigin p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo")String policyNo) throws Exception;
}