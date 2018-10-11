package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPcoinsCopyDao extends JpaBaseDao<PrpPcoinsCopy,PrpPcoinsCopyKey> {

    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:10 17:10
     * @param endorseNo 批单号
     * @return List<PrpPcoins>
     */
    @Query(value = "select p from PrpPcoinsCopy p where p.endorseNo=:endorseNo")
    public List<PrpPcoinsCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
  
}
