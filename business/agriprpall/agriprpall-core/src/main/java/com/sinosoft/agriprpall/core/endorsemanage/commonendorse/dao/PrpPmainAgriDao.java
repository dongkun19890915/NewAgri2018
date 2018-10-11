package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainAgri;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainAgriKey;
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
 * @time  2017-10-26 08:12:17.248 
 * 农业险保单信息PDao数据操作对象
 */
@Repository
public interface PrpPmainAgriDao extends JpaBaseDao<PrpPmainAgri,PrpPmainAgriKey> {
    @Modifying
    @Transactional
    @Query(value = "delete from PrpPmainAgri p where p.endorseNo=:endorseNo")
    public void deleteByEndorseNo(@Param("endorseNo") String endorseNo);
}