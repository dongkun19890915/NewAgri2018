package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPtext;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPtextKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 01:44:37.955 
 * 批改文字信息表Dao数据操作对象
 */
@Repository
public interface PrpPtextDao extends JpaBaseDao<PrpPtext,PrpPtextKey> {
    List<PrpPtext> findByEndorseNoOrderByLineNo(String endorseNo);

    /**
     * 根据保单号删除PrpPtext表数据
     * @author: 宋振振
     * @date: 2017/12/4 15:28
     * @param endorseNo
     * @throws Exception
     */
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PrpPtext p WHERE p.endorseNo=:endorseNo")
    public void cancelPrpPtext(@Param("endorseNo") String endorseNo) throws Exception;
}