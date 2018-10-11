package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfeild;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfeildCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPfeildCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPfeildCopyDao extends JpaBaseDao<PrpPfeildCopy,PrpPfeildCopyKey> {
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:58 17:58
     * @param endorseNo 批单号
     * @return List<PrpPfeild>
     */
    @Query(value = "select p from PrpPfeildCopy p where p.endorseNo=:endorseNo")
    public List<PrpPfeildCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
