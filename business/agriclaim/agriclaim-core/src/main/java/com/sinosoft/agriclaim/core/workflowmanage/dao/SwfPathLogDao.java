package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLogKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * 工作流路径日志表Dao数据操作对象
 */
@Repository
public interface SwfPathLogDao extends JpaBaseDao<SwfPathLog,SwfPathLogKey> {

    @Query(value="select p from SwfPathLog p where p.flowId=:flowId")
   public List<SwfPathLog> findFlowPathLogByFlowId(@Param("flowId") String flowId);

	@Query(value = "Select max(pathNo)+1 from SwfPathLog Where flowID=?1")
	public Integer findMaxPathNoByFlowId(String flowID);
	/**
     * @description: （获取最大pathNo）
     * @author: 王志文
     * @date: 2017/11/8 20:01
     * @param flowId
     * @return
     */
    @Query("select max(s.pathNo) from SwfPathLog s where s.flowId=:flowId")
    Integer getMaxPathNo(@Param("flowId") String flowId);
    /**
     * @description: （双核回写重开赔案删除工作流信息）
     * @author: 王志文
     * @date: 2017/11/17 9:33
     * @param flowId
     * @param endnodeNo
     */
    @Modifying
    @Query("delete from SwfPathLog s Where s.flowId =:flowId and s.endNodeNo =:endnodeNo ")
    void deleteSwfMsgByCondition(@Param("flowId") String flowId ,@Param("endnodeNo") int endnodeNo);
    /**
     * （workFlow工作流操作，只通过flowId 删除工作流信息）
     * @author: 王志文
     * @date: 2017/11/20 9:38
     * @param flowId
     */
    @Query("delete from SwfPathLog s where s.flowId =:flowId")
    void deleteSwfPathLogsByFlowId(@Param("flowId") String flowId);

    @Query("select p from SwfPathLog p where p.flowId=:flowId and p.startNodeNo=:startNodeNo")
    List<SwfPathLog> queryAllByFlowIdAndStartNodeNo(@Param("flowId") String flowId,@Param("startNodeNo") int startNodeNo);
}