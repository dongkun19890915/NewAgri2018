package com.sinosoft.agriclaim.core.workflowmanage.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPath;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径定义表Dao数据操作对象
 */
@Repository
public interface SwfPathDao extends JpaBaseDao<SwfPath,SwfPathKey> {
	@Query(value = "select p from SwfPath p where p.modelNo=:modelNo and p.startNodeNo=:startNodeNo")
	public List<SwfPath> getNextSumbitNodes(@Param("modelNo") Integer modelNo,@Param("startNodeNo") Integer startNodeNo);

	@Modifying
	@Transactional
	@Query(value = "delete from SwfPath p where p.modelNo = :modelNo")
	public void deleteByModelNo(@Param(value = "modelNo") Integer modelNo);
	
    @Query(value = "Select p From SwfPath p Where p.modelNo = :modelNo and p.startNodeNo = :startNodeNo")
	public List<SwfPath> findModelNextNodes(@Param("modelNo") int modelNo,@Param("startNodeNo") int startNodeNo);
    
	@Query(value = "Select * From SwfPath  Where modelNo = :modelNo and pathNo = :pathNo",nativeQuery=true)
	public List<SwfPath> findByModelNoAndPathNo(@Param("modelNo") int modelNo,@Param("pathNo") int pathNo);
    @Query(value = "Select * From SwfPath  Where modelNo = :modelNo and startNodeNo = :startNodeNo order by defaultFlag,priority" ,nativeQuery=true)
    public List<SwfPath> findByModelNoAndStartNodeNo(@Param("modelNo") int modelNo,@Param("startNodeNo") int startNodeNo);
 
}