package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPaddress;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPaddressCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPaddressCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPaddressCopyDao extends JpaBaseDao<PrpPaddressCopy,PrpPaddressCopyKey>{
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPaddressCopy p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:07 17:07
     * @return List<PrpPaddress>
     */
    @Query(value = "select p from PrpPaddressCopy p where p.endorseNo=:endorseNo")
    public List<PrpPaddressCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
   
}
