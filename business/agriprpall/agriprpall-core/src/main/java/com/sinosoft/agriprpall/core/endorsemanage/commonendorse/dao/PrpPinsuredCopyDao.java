package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;


import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPinsured;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPinsuredCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPinsuredCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPinsuredCopyDao extends JpaBaseDao<PrpPinsuredCopy,PrpPinsuredCopyKey> {
    /**
     * 根据批单号查询
    * @author: 刘曼曼
    * @date: 17:18 17:18
     * @param endorseNo 批单号
     * @return List<PrpPinsured>
     */
    @Query(value = "select p from PrpPinsuredCopy p where p.endorseNo=:endorseNo")
    public List<PrpPinsuredCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
   
}
