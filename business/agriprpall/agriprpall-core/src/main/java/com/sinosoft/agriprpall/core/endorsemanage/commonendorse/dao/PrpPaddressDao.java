package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPaddress;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPaddressKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrpPaddressDao extends JpaBaseDao<PrpPaddress,PrpPaddressKey>{
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPaddress p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    /**
     * 根据批单号查询
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return List<PrpPaddress>
     */
    @Query(value = "select p from PrpPaddress p where p.endorseNo=:endorseNo")
    public List<PrpPaddress> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}
