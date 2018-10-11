package com.sinosoft.agriclaim.core.workflowmanage.dao;

import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:47:03.090 工作流日志表Dao数据操作对象
 */
@Repository
public interface SwfLogDao extends JpaBaseDao<SwfLog, SwfLogKey> {
	
	/**
	 * @description 通过业务号以及节点类型查询工作流
	 * @author: yanlei
	 * @param businessNo 业务号码
	 * @param nodeType 节点类型
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.businessNo = :businessNo and s.nodeType = :nodeType and nodeStatus < 4")
	public List<SwfLog> findAllByBusinessAndNodeType(@Param("businessNo") String businessNo,
			@Param("nodeType") String nodeType);

	/**
	 * @description 查找当前流程的节点中是否存在NodeNo相同，并且状态为0未处理的Log节点
	 * @author: yanlei
	 * @param flowID 工作流号码
	 * @param nodeNo 当前节点的nodeno
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where flowID=?1 And  NodeNo=?2 and NodeStatus <'4'")
	public List<SwfLog> findAllByFlowIDAndNodeNo(String flowID, int nodeNo);

	/**
	 * 根据工作流号查询最大节点号
	 * @param flowId 流程编号
	 * @return Integer 最大节点号
	 * @author 王心洋
	 * @time 2018-02-07
	 */
	@Query(value = "Select max(s.logNo) from SwfLog s Where s.flowId=?1")
	public Integer findMaxLogNoByFlowId(String flowId);

	/**
	 * @description 通过主键查询工作流
	 * @author: yanlei
	 * @param flowID 工作流号码
	 * @param logNo 工作流的点
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where flowID=?1 And  logNo=?2")
	public List<SwfLog> findAllByFlowIDAndLogNo(String flowID, int logNo);
	
	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId and s.nodeType=:nodeType")
	public List<SwfLog> findByflowIdAndNodeType(@Param("flowId") String flowId,@Param("nodeType") String nodeType);
	
	@Query(value = "Select * From SwfLog  Where flowId= :flowId and (nodeType in ('claim','certa','verif','verip','verpo','wound','veriw','propc','propv')) and  nodeStatus <'4'",nativeQuery=true)
	public List<SwfLog> findByflowIdAndNodeTypeNative(@Param("flowId") String flowId);
	
	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId  and (s.nodeType in('check')) and  s.nodeStatus <'4'")
	public List<SwfLog> findByConditon2(@Param("flowId") String flowId);
	
	@Query(value = "Select * From SwfLog  Where flowId= :flowId and (nodeType in ('claim','certa','verif','verip','verpo','wound','veriw','propc','propv','check')) and  nodeStatus <'4'",nativeQuery=true)
	public List<SwfLog> findByflowIdAndNodeTypeNative2(@Param("flowId") String flowId);
	
	

	@Query(value = "Select s From SwfLog s Where businessNo=?1 And nodeType=?2")
	public List<SwfLog> findByBusinessNoAndNodeType(String businessNo, String nodeType);
	
	@Query(value = "Select s From SwfLog s Where flowID=?1")
	public List<SwfLog> findByFlowId(String flowID);
	@Modifying
	@Query(value = "delete from SwfLog where flowId = :flowId")
	public void deleteByFlowId(@Param(value = "flowId") String flowId);
	
	@Query(value = "Select s From SwfLog s Where s.flowId = :flowId")
	public List<SwfLog> findAllByFlowId(@Param(value = "flowId") String flowId);

	@Query(value="select s.flowId from SwfLog s where s.registNo=:registNo")
	public String findSwfLogByRegistNo(@Param("registNo") String registNo);

	@Query(value = "select count(p) from SwfLog p where p.handlerCode=:handlerCode and p.flowInTime>=:dateBegin and p.flowInTime<:dateEnd and  p.nodeType=:nodeType")
	public Integer findSwfLogByConditions(@Param("handlerCode")String handlerCode, @Param("dateBegin")String dateBegin,@Param("dateEnd")String dateEnd,@Param("nodeType") String nodeType);
	
	/**
	 * @description 通过条件查询工作流
	 * @author: yanlei
	 * @param flowId 工作流号码
	 * @param nodeStatus 工作流状态
	 * @param nodeNo nodeNo
	 * @param riskCode 险种代码
	 * @param policyNo 保单号
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId And  s.nodeStatus<:nodeStatus "
			+ " and s.nodeNo=:nodeNo  and s.riskCode=:riskCode and s.policyNo=:policyNo")
	public List<SwfLog> findNoDealNodeByModelNodeNoByPolicyNo(@Param("flowId") String flowId,@Param("nodeStatus") String nodeStatus,
			@Param("nodeNo") int nodeNo,@Param("riskCode") String riskCode,@Param("policyNo") String policyNo);
	
	/**
	 * @description 通过条件查询工作流
	 * @author: yanlei
	 * @param flowId 工作流号码
	 * @param nodeType 工作流状态
	 * @return
	 */
	@Query(value = "Select * From SwfLog  Where flowId= :flowId and nodetype=:nodeType and nodeStatus < '4' and flowstatus != '0'",nativeQuery=true)
	public List<SwfLog> findByconditions(@Param("flowId") String flowId,@Param("nodeType") String nodeType);
	
	@Query(value = "Select * From SwfLog  Where flowId= :flowId  and logNo in ( select startnodeno from swfpathLog where flowId =:flowId and endnodeno =:endnodeno)",nativeQuery=true)
	public List<SwfLog> findPerviousNodes(@Param("flowId") String flowId,@Param("endnodeno") int endnodeno);
	
    @Modifying
	@Transactional
	@Query(value = "DELETE FROM  SwfLog  Where flowID=?1 And  logNo=?2")
	void deleteByFlowIdAndLogNo(String flowId, int logNo);
    /**
	 * （通过businessNo 查询flowID）
	 * @author: 王志文
	 * @date: 2017/11/9 9:40
	 * @param businessNo
	 * @return
	 */
	@Query("select s.flowId from SwfLog s where s.businessNo=:businessNo")
	List<String> queryFlowId(@Param("businessNo") String businessNo);

	/**
	 * （通过flowID找到最大logNo）
	 * @author: 王志文
	 * @date: 2017/11/9 9:40
	 * @param flowId
	 * @return
	 */
	@Query("select max(logNo) from SwfLog where flowId =:flowId")
	int getMaxLogNo(@Param("flowId") String flowId);

	/**
	 * （通过flowID 找最大logNo）
	 * @author: 王志文
	 * @date: 2017/11/9 9:40
	 * @param flowId
	 * @return
	 */
	@Query("select max(logNo) from SwfLog where nodeType='endca' and flowId =:flowId")
	int getEndCaseLogNo(@Param("flowId")String flowId);

	/**
	 * （通过条件查询并按logNo倒序排序输出）
	 * @author: 王志文
	 * @date: 2017/11/9 9:40
	 * @param flowId
	 * @return
	 */
	@Query("select s from SwfLog s where s.nodeType='compe' and s.flowId=:flowId and s.businessNo =:claimNo order by s.logNo desc")
	List<SwfLog> queryByCondition(@Param("flowId") String flowId, @Param("claimNo") String claimNo);

	/**
	 * （重开赔案确认工作流方法）
	 * @author: 王志文
	 * @date: 2017/11/9 9:40
	 * @param flowId
	 * @return
	 */
	@Query("select count(s.flowId) from SwfLog s where s.flowId =:flowId and s.businessNo =:claimNo and s.nodeType='compe' and s.flowStatus >'0' and s.nodeStatus <'4'")
	int getCount(@Param("flowId") String flowId,@Param("claimNo") String claimNo);

	/**
	 * （双核回写重开赔案检查工作流信息）
	 * @author: 王志文
	 * @date: 2017/11/9 9:49
	 * @param flowId
	 * @return
	 */
	@Query("select s from SwfLog s where s.flowId =:flowId and s.nodeType='compe' order by s.logNo desc")
	List<SwfLog> queryUndwrtBackToReCaseCondition(@Param("flowId") String flowId);

	/**
	 * （双核回写重开赔案增加工作流信息）
	 * @author: 王志文
	 * @date: 2017/11/10 9:02
	 * @param flowId
	 * @param logNo
	 * @param nodeStatus
	 * @param businessNo
	 * @param nodeType
	 * @param nodeNo
	 */
	@Modifying
	@Query("update SwfLog set nodeStatus =:nodeStatus ,businessNo =:businessNo," +
			"nodeType =:nodeType,nodeNo =:nodeNo where logNo =:logNo and flowId =:flowId")
	void upDateSwfNodeByCondition(@Param("flowId") String flowId,
								  @Param("logNo") int logNo,
								  @Param("nodeStatus") String nodeStatus,
								  @Param("businessNo") String businessNo,
								  @Param("nodeType") String nodeType,
								  @Param("nodeNo") int nodeNo);


	/**
	 * （重开赔案申请失败删除工作流信息）
	 * @author: 王志文
	 * @date: 2017/11/17 9:43
	 * @param flowId
	 * @param logNo
	 */
	@Modifying
	@Query("delete from SwfLog s where s.flowId =:flowId and s.logNo =:logNo ")
	void deleteByFlowIdAAndLogNo(@Param("flowId") String flowId,@Param("logNo") int logNo);


	/**
	 * （重开赔案申请失败更新工作流状态）
	 * @author: 王志文
	 * @date: 2017/11/17 9:54
	 * @param flowId
	 */
	@Query("update SwfLog s set s.flowStatus = '0' where s.flowId =:flowId ")
	void updateFlowStatusByFlowId(@Param("flowId") String flowId);

	/**
	 * （找到最大logNo对应数据）
	 * @author: 王志文
	 * @date: 2017/11/20 9:26
	 * @param businessNo
	 * @return
	 */
	@Query("select s.flowId,max(s.logNo) from SwfLog s where s.businessNo =:businessNo group by s.flowId")
	List<Object []> queryMaxLogNoSwfLogByFlowId(@Param("businessNo") String businessNo);

	/**
	 * （workFlow工作流操作按条件查询数据，含固定条件）
	 * @author: 王志文
	 * @date: 2017/11/20 9:30
	 * @param businessNo
	 * @return
	 */
	@Query("select s from SwfLog s where s.businessNo =:businessNo and s.nodeType ='regis'")
	List<SwfLog> querySwfLogsByWorkFlowConditions(@Param("businessNo") String businessNo);
	/**
	 * （通过流程编号查找数据）
	 * @author: 王志文
	 * @date: 2017/11/20 11:35
	 * @param flowId
	 * @return
	 */
	@Query("select s from SwfLog s where s.flowId =:flowId ")
	List<SwfLog> querySwfLogsByFlowId(@Param("flowId") String flowId);
	/**
	 * @description:方法功能简述: 释放所有占号
	 * @author 安齐崇
	 * @date 2017年12月7日下午11:31:12
	 * @param handlerCode
	 */
	@Query(value = "update SwfLog set handlerCode=null,handlerName=null,flowStatus='1' Where nodeStatus='0' and handlerCode= :handlerCode",nativeQuery=true)
	@Modifying
	public void freeAllHoldNode(@Param(value = "handlerCode") String handlerCode);

	/**
	 * @description:方法功能简述: 根据条件查询工作流信息
	 * @author 安齐崇
	 * @date 2017年12月8日上午12:31:27
	 * @param flowId
	 * @param nodeType
	 * @return
	 */
	@Query(value = "select s from SwfLog s where s.flowId = :flowId and s.nodeType = :nodeType and s.nodeType = '0'")
	List<SwfLogDto> findNodesByConditions(@Param(value = "flowId") String flowId,@Param(value = "nodeType") String nodeType);

	@Query(value = "select s from SwfLog s where flowId =?1 order by logNo desc")
	List<SwfLog> findByFlowIdOrderByLogNo(String flowId);

	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId  and s.nodeType=:nodeType and nodeStatus=:nodeStatus and keyOut=:keyOut")
	public List<SwfLog> findByConditon(@Param("flowId") String flowId,@Param("nodeType") String nodeType,@Param("nodeStatus") String nodeStatus,@Param("keyOut") String keyOut);
	/**
	 * @description:方法功能简述: 申请注销拒赔增加，根据条件查询工作流信息
	 * @author 马俊玲
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId  and s.keyIn=:keyIn and s.nodeType=:nodeType and s.nodeStatus<>'0' ")
	public List<SwfLog> findByConditions(@Param("flowId") String flowId,@Param("keyIn") String keyIn,@Param("nodeType") String nodeType);
	/**
	 * @description:方法功能简述: 申请注销拒赔增加，根据条件查询工作流信息
	 * @author 马俊玲
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.flowId= :flowId  and s.policyNo=:policyNo and s.nodeType=:nodeType and s.nodeStatus='0' ")
	public List<SwfLog> findByPolicyNoAndID(@Param("flowId") String flowId,@Param("policyNo") String policyNo,@Param("nodeType") String nodeType);

	/**
	 * @description:方法功能简述: 调度校验，根据条件查询工作流信息
	 * @author 马俊玲
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.nodeType= :nodeType  and s.registNo=:registNo and s.nodeStatus in ('C','6')")
	public List<SwfLog> findByNodeTypeAndRegistNoWithNodeStatus(@Param("nodeType") String nodeType,@Param("registNo") String registNo);
	/**
	 * @description:方法功能简述: 调度校验，根据条件查询工作流信息
	 * @author 马俊玲
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.nodeType= :nodeType  and s.registNo=:registNo")
	public List<SwfLog> findByNodeTypeAndRegistNo(@Param("nodeType") String nodeType,@Param("registNo") String registNo);
	/**
	 * @description:方法功能简述: 调度校验，根据条件查询工作流信息
	 * @author 马俊玲
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "Select s From SwfLog s Where s.nodeType=:nodeType  and s.registNo=:registNo and s.nodeStatus=:nodeStatus")
	public List<SwfLog> findByNodeTypeAndRegistNoAndNodeStatus(@Param("nodeType") String nodeType,@Param("registNo") String registNo,@Param("nodeStatus") String nodeStatus);


	/**
	 * @description:方法功能简述: 查询出swflog节点中的结案未处理节点
	 * @author 王保良
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.registNo=:registNo and p.nodeType='endca'")
	public SwfLog queryEndCa(@Param("registNo") String registNo);

	@Query(value = "select p from SwfLog p where p.flowId = :flowId and p.nodeType='endca' and p.nodeStatus= '0' ")
	public SwfLog queryEndcaByFlowId(@Param("flowId") String flowId);

	@Query(value="select s from SwfLog s where s.flowId=:flowId and rownum=1")
	public SwfLog findModelNoByFlowId(@Param("flowId") String flowId);


	/**
	 * 查询调度的节点
	 * @author: 孙朋飞
	 * @date: 2018/4/17 14:11
	 * @param flowId 流程编号
	 * @param logNo 节点号码
	 * @return
	 */
	@Query(value="select s from SwfLog s where s.flowId=:flowId and s.logNo=:logNo")
	public SwfLog findByFlowIdAndLogNo(@Param("flowId") String flowId,@Param("logNo") Integer logNo);

	@Query(value="select nvl(max(logNo),0) from SwfLog where flowId =:flowId",nativeQuery = true)
	public Integer getMaxSwfLogNo(@Param("flowId") String flowId);

	@Query(value = "select p from SwfLog p where p.registNo=:registNo order by p.logNo desc")
	public List<SwfLog> queryByRegistNo(@Param("registNo") String registNo);

	@Query(value = "select p from SwfLog p where p.flowId=:flowId and p.nodeType='claim'")
	public List<SwfLog> queryByClaim(@Param("flowId") String flowId);

	@Query(value = "select p from SwfLog p where p.businessNo like :businessNo and p.nodeType = 'claim'")
	public List<SwfLog> queryByEndca(@Param("businessNo") String businessNo);

	@Query(value="select * from (select p.* from SwfLog p where p.registNo=:registNo order by p.logNo desc) where rownum=1 ",nativeQuery = true)
	public SwfLog findSwfLogByRegistNo1(@Param("registNo") String registNo);

	@Query(value = "select p from SwfLog p where p.flowId = :flowId")
	public List<SwfLog> queryComppByFlowId (@Param("flowId") String flowId);

	@Query(value = "select p from SwfLog p where p.registNo = :registNo and p.nodeType = 'endca'")
	public SwfLog queryEndcaByRegistNo(@Param("registNo") String registNo);

	/**
	 * @description:方法功能简述: 根据报案号查询报案节点的流程表
	 * @author 王保良
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.registNo = :registNo and p.nodeType ='regis'")
	public SwfLog queryRegistByRegistNo(@Param("registNo") String registNo);

	/**
	 * @description:方法功能简述: 根据报案号查询立案节点的流程表
	 * @author 王保良
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.registNo = :registNo and p.nodeType = 'claim'")
	public SwfLog queryClaimByRegistNo(@Param("registNo") String registNo);

	/**
	 * @description:方法功能简述: 根据报案号查询计算书节点的流程表
	 * @author 王保良
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.registNo = :registNo and p.nodeType = 'compp'")
	public SwfLog queryComppByRegistNo(@Param("registNo") String registNo);

	/**
	 * @description:方法功能简述: 根据报案号查询特殊赔案节点的流程表
	 * @author 王保良
	 * @date 2017年1月26日上午12:31
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.registNo = :registNo and p.nodeType = 'speci'")
	public SwfLog querySpeciByRegistNo(@Param("registNo") String registNo);

	/**
	 * 根据报案号更新调查节点的状态
	 * @author: 孙朋飞
	 * @date: 2018/4/18 9:34
	 * @param registNo 报案号
	 * @param submitTime
	 */
	@Transactional
	@Modifying
	@Query(value="update SwfLog set nodeStatus='4',submitTime=:submitTime where registNo=:registNo and nodeType='inves'")
	public void updateSwfLogByRegistNoAndNodeStatus(@Param("registNo") String registNo, @Param("submitTime")String submitTime);

	/**
	 *	根据流程编号和节点类型查询流程
	 * @author: 孙朋飞
	 * @date: 2018/4/17 15:49
	 * @param flowId 流程编号
	 * @param nodeType 节点类型
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.flowId=:flowId and p.nodeType=:nodeType and p.nodeStatus <>'4'")
	public SwfLog findSwfLogByFlowIdAndNodeType(@Param("flowId") String flowId,@Param("nodeType") String nodeType);
	/**
	 *	根据流程编号和节点类型查询流程
	 * @author: 孙朋飞
	 * @date: 2018/4/17 15:49
	 * @param flowId 流程编号
	 * @param nodeType 节点类型
	 * @return
	 */
	@Query(value = "select p from SwfLog p where p.flowId=:flowId and p.nodeType=:nodeType and p.nodeStatus =:nodeStatus")
	public List<SwfLog> findSwfLogByFlowIdAndNodeTypes(@Param("flowId") String flowId,@Param("nodeType") String nodeType,@Param("nodeStatus")String nodeStatus);

	/**
	 * 查询除调查之外的最大节点
	 * @author: 孙朋飞
	 * @date: 2018/4/18 9:23
	 * @param flowId 流程编号
	 * @return
	 */
	@Query(value="select * from (select p.* from SwfLog p where p.flowId=:flowId and p.nodeType<>'inves' order by p.logNo desc) where rownum=1 ",nativeQuery = true)
	public SwfLog findSwfLogByFlowId(@Param("flowId") String flowId);

	/**
	 * （查询计算书正在处理节点）
	 * @author: 王志文
	 * @date: 2018/4/27 19:39
	 * @param flowId
	 * @return
	 */
	@Query(value = "select count(s.flowId) from SwfLog s where s.flowId =:flowId and s.nodeType = 'compp' and s.nodeStatus = '2'")
	public Long findComppCountByFlowId(@Param("flowId") String flowId);


	@Query(value = "select s.flowId,max (s.logNo) from SwfLog s where s.flowId =:flowId and s.nodeStatus ='2' and s.nodeType = 'compp' group by s.flowId")
	public List<Object[]> findLastComppByFlowIdAndNodeType(@Param("flowId") String flowId);

	/**
	 * （查找当前工作流logno最大的相应节点）
	 * @author: 王志文
	 * @date: 2018/5/14 19:59
	 * @param flowId
	 * @return
	 */
	@Query(value = "select max(s.logNo) from SwfLog s where s.flowId =:flowId and s.nodeType =:nodeType ")
	public Integer findMaxLogNoByFlowIdAndNodeType(@Param("flowId") String flowId,@Param("nodeType") String nodeType);


}