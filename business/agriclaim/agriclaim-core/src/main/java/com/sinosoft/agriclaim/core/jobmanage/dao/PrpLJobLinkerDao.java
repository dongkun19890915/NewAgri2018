package com.sinosoft.agriclaim.core.jobmanage.dao;

import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobLinker;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrpLJobLinkerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:38.981 
 * 联系人Dao数据操作对象
 */
@Repository
public interface PrpLJobLinkerDao extends JpaBaseDao<PrpLJobLinker,PrpLJobLinkerKey> {
   @Modifying
    @Transactional
    @Query(value= "delete from PrpLJobLinker  where handleDept=:handleDept and  classCode=:classCode and  month=:month ")
    public void deleteLinkerCondition(@Param("handleDept") String handleDept,
                                      @Param("classCode") String classCode,
                                      @Param("month") String month);

}





