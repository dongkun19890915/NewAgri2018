package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKindAgri;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKindAgriCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPitemKindAgriCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPitemKindAgriCopyDao extends JpaBaseDao<PrpPitemKindAgriCopy,PrpPitemKindAgriCopyKey>{
    /**
     * 根据批单号查询
    * @author: 刘曼曼
    * @date: 17:20 17:20
     * @param endorseNo 批单号
     * @return List<PrpPitemKindAgri>
     */
    @Query("select p from PrpPitemKindAgriCopy p where p.endorseNo=:endorseNo order by p.times")
    public List<PrpPitemKindAgriCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
