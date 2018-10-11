package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfee;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfeeCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfeeCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPfeeCopyDao extends JpaBaseDao<PrpPfeeCopy,PrpPfeeCopyKey>{
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:16 17:16
     * @param endorseNo 批单号
     * @return List<PrpPfee>
     */
    @Query("select p from PrpPfeeCopy p where p.endorseNo=:endorseNo")
    public List<PrpPfeeCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
  
}
