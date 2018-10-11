package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPengage;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPengageKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpCPengageDao extends JpaBaseDao<PrpCPengage,PrpCPengageKey>{
    @Query(value = "select p from PrpCPengage p " +
            "where p.policyNo=?1 " +
            "order by p.serialNo,p.lineNo")
    public List<PrpCPengage> queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPengage p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);

}
