package com.sinosoft.agriclaim.core.combinemanage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sinosoft.agriclaim.core.combinemanage.entity.PrpLCombine;
import com.sinosoft.agriclaim.core.combinemanage.entity.PrpLCombineKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * 并案关联表Dao数据操作对象
 */
@Repository
public interface PrpLCombineDao extends JpaBaseDao<PrpLCombine,PrpLCombineKey> {

	/**
     * @descption 通过并案号查询并案信息
     * @author moujiaxing
     * @date 2017-12-01
     * @param combineNo 并案号
     */
	@Query(value = "Select s From PrpLCombine s Where s.combineNo = :combineNo")
	public List<PrpLCombine> findAllByCombineNo(@Param(value = "combineNo") String combineNo);

}