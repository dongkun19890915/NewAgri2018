package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNode;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流节点定义表Dao数据操作对象
 */
@Repository
public interface SwfNodeDao extends JpaBaseDao<SwfNode,SwfNodeKey> {
	@Modifying
	@Transactional
	@Query(value = "delete from SwfNode p where p.modelNo = :modelNo")
	public void deleteByModelNo(@Param(value = "modelNo") Integer modelNo);
	
	/**
	 * @description 寻找nodeNo为当前NodeNo的T类型的节点
	 * @author: yanlei
	 * @param modelNo 模板号码
	 * @param taskNo 当前的NodeNo的值
	 * @return
	 */
	@Query(value = "Select s From SwfNode s Where s.modelNo = :modelNo and s.taskNo = :taskNo  and taskType ='T'")
	public List<SwfNode> findModelNextTNodes(@Param("modelNo") int modelNo,@Param("taskNo") int taskNo);
	
	/**
	 * @description 根据模板号以及节点类型查询
	 * @author: yanlei
	 * @param modelNo 模板号码
	 * @param nodeType 节点类型
	 * @return
	 */
	@Query(value = "Select s From SwfNode s Where s.modelNo = :modelNo and s.nodeType = :nodeType ")
	public List<SwfNode> getFirstNodeTypeNode(@Param("modelNo") int modelNo,@Param("nodeType") String nodeType);
	
	SwfNode findByModelNoAndNodeNo(int modelNo,int nodeNo);
	/**
	 * （根据模板号查询重开赔案节点信息）
	 * @author: 王志文
	 * @date: 2017/12/13 19:31
	 * @param modelNo
	 * @return
	 */
    @Query("select s from SwfNode s where s.modelNo =:modelNo  and  s.nodeNo=:nodeNo ")
    SwfNode queryByCondition(@Param("modelNo") int modelNo,@Param("nodeNo")int nodeNo);
}