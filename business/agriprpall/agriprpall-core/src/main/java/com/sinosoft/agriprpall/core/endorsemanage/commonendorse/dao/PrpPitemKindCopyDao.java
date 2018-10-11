package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKind;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKindCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKindCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPitemKindCopyDao extends JpaBaseDao<PrpPitemKindCopy,PrpPitemKindCopyKey>{
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:22 17:22
     * @param endorseNo 批单号
     * @return List<PrpPitemKind>
     */
    @Query(value = "select p from PrpPitemKindCopy p where p.endorseNo=:endorseNo")
    public List<PrpPitemKindCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);

    @Transactional
    @Modifying
    @Query(value = "delete from PrpPitemKindCopy p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);
  
}
