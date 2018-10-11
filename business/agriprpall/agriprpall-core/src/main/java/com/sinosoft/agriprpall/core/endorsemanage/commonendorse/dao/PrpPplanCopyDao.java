package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplan;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPplanCopyDao extends JpaBaseDao<PrpPplanCopy,PrpPplanCopyKey>{
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:37 17:37
     * @param endorseNo 批单号
     * @return List<PrpPplan>
     */
    @Query(value = "select p from PrpPplanCopy p where p.endorseNo=:endorseNo order by p.serialNo")
    public List<PrpPplanCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
