package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCoinsCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCoinsCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPplanCoinsCopyDao extends JpaBaseDao<PrpPplanCoinsCopy,PrpPplanCoinsCopyKey>{
    /**
     * 根据批单号查询
     * @author: 刘曼曼
     * @date: 17:56 17:56
     * @param endorseNo 批单号
     * @return List<PrpPplanCoins>
     */
    @Query(value = "select p from PrpPplanCoinsCopy p where p.endorseNo=:endorseNo")
    public List<PrpPplanCoinsCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
