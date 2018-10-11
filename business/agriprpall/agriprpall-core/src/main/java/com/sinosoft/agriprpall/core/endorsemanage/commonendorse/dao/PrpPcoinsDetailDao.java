package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsDetail;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPcoinsDetailKey;
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
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-28 07:51:01.225 
 * 共保细节表Dao数据操作对象
 */
@Repository
public interface PrpPcoinsDetailDao extends JpaBaseDao<PrpPcoinsDetail,PrpPcoinsDetailKey> {
    @Transactional
    @Modifying
    @Query(value = "delete from PrpPcoinsDetail p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);

    /**
     * 根据批单号查询
     * @author: 王保良
     * @date: 2017/11/27 17:43
     * @param endorseNo 批单号
     * @return List<PrpPcoinsDetail>
     */
    @Query(value = "select p from PrpPcoinsDetail p where p.endorseNo=:endorseNo")
    public List<PrpPcoinsDetail> findAllByEndorseNo(@Param("endorseNo") String endorseNo);
}