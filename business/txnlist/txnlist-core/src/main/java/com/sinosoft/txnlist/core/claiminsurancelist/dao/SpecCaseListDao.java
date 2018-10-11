package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.core.claiminsurancelist.entity.SpecCaseList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.SpecCaseListKey;
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
 * @time  2018-01-23 10:16:34.906 
 * 特殊赔案清单表Dao数据操作对象
 */
@Repository
public interface SpecCaseListDao extends JpaBaseDao<SpecCaseList,SpecCaseListKey> {
    @Query(value = "select p.* from SpecCaseList p where p.listNo=:listNo order by to_number(p.serialNo)",nativeQuery = true)
    public List<SpecCaseList> findSpecCaseListByPreCompensateNo(@Param("listNo") String listNo);

    @Modifying
    @Transactional
    @Query(value="update SpecCaseList set preCompensateNo=:preCompensateNo where listNo=:listNo")
    public void updateSpecCaseListByListNo(@Param("listNo") String listNo,@Param("preCompensateNo") String preCompensateNo);
}