package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPitemAgri;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPitemAgriKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpCPitemAgriDao extends JpaBaseDao<PrpCPitemAgri,PrpCPitemAgriKey>{
    @Query(value = "select p from PrpCPitemAgri p " +
            "where p.policyNo=?1 " +
            "order by p.itemNo")
    public List<PrpCPitemAgri> queryAllByCondition(String policyNo);

    @Modifying
    @Transactional
    @Query(value = "delete from PrpCPitemAgri p where p.policyNo=?1 ")
    public void deleteAllByCondition(String policyNo);
}
