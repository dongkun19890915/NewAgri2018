package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsDetail;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsDetailCopy;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsDetailCopyKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface PrpPcoinsDetailCopyDao extends JpaBaseDao<PrpPcoinsDetailCopy,PrpPcoinsDetailCopyKey> {
    /**
     * 根据批单号查询
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return List<PrpPcoinsDetail>
     */
    @Query(value = "select p from PrpPcoinsDetailCopy p where p.endorseNo=:endorseNo")
    public List<PrpPcoinsDetailCopy> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}