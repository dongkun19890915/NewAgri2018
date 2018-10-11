package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPitemKind;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPitemKindKey;
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
 * @time  2017-10-24 03:06:48.016 
 * 标的子险信息Dao数据操作对象
 */
@Repository
public interface PrpCPitemKindDao extends JpaBaseDao<PrpCPitemKind,PrpCPitemKindKey> {

    @Query(value = "select p from PrpCPitemKind p where p.policyNo=:policyNo")
    public List<PrpCPitemKind> findPrpCPItemKindsByPolicyNo(@Param("policyNo") String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPitemKind p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}