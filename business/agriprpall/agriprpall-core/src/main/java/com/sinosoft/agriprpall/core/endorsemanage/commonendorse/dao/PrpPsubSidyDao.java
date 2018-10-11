package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;


import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPsubSidyDao extends JpaBaseDao<PrpPsubSidy,PrpPsubSidyKey>{
    @Transactional
    @Modifying
    @Query(value = "delete from PrpPsubSidy p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    /**
     * 根据批单号查询
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return List<PrpPsubsidy>
     */
    @Query(value = "select p from PrpPsubSidy p where p.endorseNo=:endorseNo")
    public List<PrpPsubSidy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
