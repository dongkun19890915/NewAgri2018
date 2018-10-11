package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPengage;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPengageCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPengageCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPengageCopyDao extends JpaBaseDao<PrpPengageCopy,PrpPengageCopyKey> {
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 9:13 9:13
     * @param endorseNo 批单号
     * @return List<PrpPengage>
     */
    @Query(value = "select p from PrpPengageCopy p where p.endorseNo=:endorseNo order by p.serialNo,p.lineNo")
    public List<PrpPengageCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
