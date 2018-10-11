package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;


import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidyCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidyCopyKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPsubSidyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPsubSidyCopyDao extends JpaBaseDao<PrpPsubSidyCopy,PrpPsubSidyCopyKey>{
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:40 17:40
     * @param endorseNo 批单号
     * @return List<PrpPsubsidy>
     */
    @Query(value = "select p from PrpPsubSidyCopy p where p.endorseNo=:endorseNo")
    public List<PrpPsubSidyCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
