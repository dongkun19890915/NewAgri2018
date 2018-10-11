package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCoins;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPplanCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPplanCoinsDao extends JpaBaseDao<PrpPplanCoins,PrpPplanCoinsKey>{

    /**
     * 根据批单号查询
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return List<PrpPplanCoins>
     */
    @Query(value = "select p from PrpPplanCoins p where p.endorseNo=:endorseNo")
    public List<PrpPplanCoins> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
    /**
     * 根据保单号删除PrpPplanCoins表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param endorseNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpPplanCoins p WHERE p.endorseNo=:endorseNo")
    public void cancelPrpPplanCoins(@Param("endorseNo")String endorseNo) throws Exception;
}
