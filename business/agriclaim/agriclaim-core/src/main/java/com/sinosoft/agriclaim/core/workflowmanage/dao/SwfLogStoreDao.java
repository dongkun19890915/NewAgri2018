package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStoreKey;
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
 * 工作流日志表1Dao数据操作对象
 */
@Repository
public interface SwfLogStoreDao extends JpaBaseDao<SwfLogStore,SwfLogStoreKey> {
    @Query(value="select s.flowId from SwfLogStore s where s.registNo=:registNo")
    public String findSwfLogStoreByRegistNo(@Param("registNo") String registNo);
    /**
     * @description: （通过业务号获取flowId）
     * @author: 王志文
     * @date: 2017/11/13 14:35
     * @param businessNo
     * @return
     */
    @Query("select s.flowId from SwfLogStore s where s.businessNo=:businessNo")
    List<String> queryFlowId(@Param("businessNo") String businessNo);

    /**
     * @description: （根据flowId 找到最大logNo值）
     * @author: 王志文
     * @date: 2017/11/13 14:36
     * @param flowId
     * @return
     */
    @Query("select max(s.logNo) from SwfLogStore s where s.flowId =:flowId")
    int getMaxLogNo(@Param("flowId")String flowId);

    /**
     * @description: （根据businessNo值找到最大logNo值）
     * @author: 王志文
     * @date: 2017/11/13 14:36
     * @param flowId
     * @return
     */
    @Query("select max(s.logNo) from SwfLogStore s where nodeType='endca' and s.flowId =:flowId")
    int getEndCaseLogNo(@Param("flowId")String flowId);

    /**
     *  @description: （通过businessNo值找到entity对象List）
     * @author: 王志文
     * @date: 2017/11/13 14:36
     * @param flowId
     * @param claimNo
     * @return
     */
    @Query("select s from SwfLogStore s where s.nodeType='compe' and s.flowId=:flowId and s.businessNo =:claimNo order by s.logNo desc")
    List<SwfLogStore> queryByCondition(@Param("flowId") String flowId,@Param("claimNo") String claimNo);

    /**
     *  @description: （根据条件查找符合条件的条数）
     * @author: 王志文
     * @date: 2017/11/13 14:36
     * @param flowId
     * @param claimNo
     * @return
     */
    @Query("select count(s.flowId) from SwfLogStore s where s.flowId =:flowId and s.businessNo =:claimNo and s.nodeType='compe' and s.flowStatus >'0' and s.nodeStatus <'4'")
    int getCount(@Param("flowId") String flowId,@Param("claimNo") String claimNo);

    /**
     * @description: （理赔打印判断拒赔注销通知书条件）
     * @author: 王志文
     * @date: 2017/11/13 14:47
     * @param businessNo
     * @return
     */
    @Query("select count(s.businessNo) from SwfLogStore s where s.businessNo =:businessNo and s.nodeType = 'cance'")
    int getCountByCheckCondition(@Param("businessNo")String businessNo);

    /**
     * （通过流程编号查找所有数据）
     * @author: 王志文
     * @date: 2017/11/20 11:58
     * @param flowId
     * @return
     */
    @Query("select s from SwfLogStore s where s.flowId =:flowId ")
    List<SwfLogStore> querySwfLogStoresByFlowId(@Param("flowId") String flowId);

    /**
     * （按流程编号删除信息）
     * @author: 王志文
     * @date: 2017/11/20 14:19
     * @param flowId
     */
    @Modifying
    @Query("delete from SwfLogStore where flowId =:flowId")
    void deleteByFlowId(@Param("flowId") String flowId);

    @Query(value = "select p from SwfLogStore p where p.flowId=:flowId and p.nodeType='claim'")
    public List<SwfLogStore> queryByClaim(@Param("flowId") String flowId);

    @Query(value = "select p from SwfLogStore p where p.businessNo like :businessNo and p.nodeType='claim'")
    public List<SwfLogStore> queryByEndca(@Param("businessNo") String businessNo);

    @Query(value = "select p from SwfLogStore p where p.registNo=:registNo order by p.logNo desc")
    public List<SwfLogStore> queryByRegistNo(@Param("registNo") String registNo);

    @Query(value = "Select s From SwfLogStore s Where s.nodeType= :nodeType  and s.registNo=:registNo and s.nodeStatus in ('C','6')")
    public List<SwfLogStore> findByNodeTypeAndRegistNoWithNodeStatus(@Param("nodeType") String nodeType, @Param("registNo") String registNo);
}