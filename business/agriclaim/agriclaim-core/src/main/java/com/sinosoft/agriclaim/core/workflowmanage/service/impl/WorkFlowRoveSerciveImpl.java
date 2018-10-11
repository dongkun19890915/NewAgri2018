package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.claimmanage.service.impl.ClaimServiceImpl;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistExtService;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleItemService;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainWfService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowRoveService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.auth.MenuApi;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 工作流转移服务类
 * @author yanlei
 * @date 2017年12月23日
 */
@Service
@Transactional
public class WorkFlowRoveSerciveImpl extends BaseServiceImpl implements WorkFlowRoveService {
	
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClaimServiceImpl.class);
	@Autowired
    private SwfLogService swfLogService;
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private PrpLScheduleMainWfService prpLScheduleMainWfService;
    @Autowired
    private PrpLScheduleItemService prpLScheduleItemService ;
    @Autowired
    private PrpLRegistExtService prpLRegistExtService;
    @Autowired
	private PrpDriskApi prpDriskApi;
	@Autowired
	private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private PrpLRegistApi prpLRegistApi;
	@Autowired
	private MenuApi menuApi;
	@Autowired
	private SwfLogDao swfLogDao;
	
	/**
	 * @description 转交任务初始化页面
	 * @author yanlei
	 * @date 2017年12月23日
	 * @param List<PrpLWorkRovePageDto> 主键字段所在的对象
	 * @return List<PrpLWorkRovePageDto> 工作流主表信息对象
	 */
	public List<PrpLWorkRovePageDto> turnPageByPrimary(@RequestBody List<PrpLWorkRovePageDto> prpLWorkRovePageDto){
		if(prpLWorkRovePageDto.size()==0){
			throw new BusinessException("prpLClaimQueryInDto对象不允许为null");
		}
		String swfLogFlowID = "";
		Integer swfLogLogNo = 0;
		//遍历数组将结果集放入prpLCheckWorkRovePageDtoList
		List<PrpLWorkRovePageDto> prpLWorkRovePageDtoList = new ArrayList<>();
		for(int n=0;n<prpLWorkRovePageDto.size();n++){
			swfLogFlowID = prpLWorkRovePageDto.get(n).getSwfLogFlowID();
			swfLogLogNo = prpLWorkRovePageDto.get(n).getSwfLogLogNo();
			if(LOGGER.isDebugEnabled()){
				LOGGER.error("swfLogFlowID={},swfLogLogNo={}",swfLogFlowID,swfLogLogNo);
			}
			String conditions = "select s from SwfLog s where flowId= :flowId and logNo= :logNo";
			Query agentQuery = entityManager.createQuery(conditions);
			agentQuery.setParameter("flowId", swfLogFlowID);
			agentQuery.setParameter("logNo", swfLogLogNo);
			List<SwfLog> swfLogList = agentQuery.getResultList();
			PrpLWorkRovePageDto RovePageOutDto = new PrpLWorkRovePageDto();
			RovePageOutDto.setSwfLogFlowID(swfLogFlowID);
			RovePageOutDto.setSwfLogLogNo(swfLogLogNo);
			RovePageOutDto.setRegistNo(swfLogList.get(0).getRegistNo());
			RovePageOutDto.setNodeName(swfLogList.get(0).getNodeName());
			RovePageOutDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY).toString());
			RovePageOutDto.setNodeType(swfLogList.get(0).getNodeType());
			prpLWorkRovePageDtoList.add(RovePageOutDto);
		}
		return prpLWorkRovePageDtoList;
	}
	
	/**
	 * @description 转交任务提交
	 * @author 闫磊
	 * @date 2017年12月23日
	 * @param prpLWorkRovePageDto 转交对象
	 * @return map 成功或者失败
	 */
	public Map<String,String> workRoveByRovePage(List<PrpLWorkRovePageDto> prpLWorkRovePageDto)throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		String registNos = "";
		boolean turnFlag = true;
		if(prpLWorkRovePageDto==null){
			throw new BusinessException("转交对象不允许为null");
		}else{
			for(int n=0;n<prpLWorkRovePageDto.size();n++){
				PrpLWorkRovePageDto prpLWorkRovePageDtoNew = prpLWorkRovePageDto.get(n);
				Map<String,String> mapNew = new HashMap<String,String>();
				mapNew = workRoveByRovePageZI(prpLWorkRovePageDtoNew);
				String code = mapNew.get("code");
				if("9999".equals(code)){
					turnFlag = false;
					registNos += mapNew.get("registNo") + ",";
				}
			}
		}
		if(turnFlag){
			map.put("code", "0000");
			map.put("message", "转交成功");
		}else{
			map.put("code", "9999");
			map.put("message", "部分转交失败");
			map.put("registNos", registNos);
		}
		return map;
	}
	
	/**
	 * @description 转交工作流程
	 * @author yanlei
	 * @date 2017年11月27日
	 * @param PrpLWorkRovePageDto 转交工作流所需对象
	 * @return Map<String,String> 返回信息
	 */
	public Map<String,String> workRoveByRovePageZI(PrpLWorkRovePageDto prpLWorkRovePageDto){
		boolean turnUp = true;
		try{
			//整理转交数据
			WorkRoveDto workRoveDto = pageFormToDto(prpLWorkRovePageDto);
			//工作流数据处理
			WorkFlowDto workFlowDto = formToWorkFlowDto(prpLWorkRovePageDto);
			//保存数据
			save(workRoveDto, workFlowDto);
			//查勘任务转交，更新定损节点处理部门信息
		}catch(Exception ex){
			if (LOGGER.isInfoEnabled()) {
				LOGGER.error("转交失败={}", ex.getMessage());
			}
			turnUp = false;
		}
		Map<String,String> map = new HashMap<String,String>(2);
		if(turnUp){
			map.put("code", "0000");
			map.put("message", "转交成功");
			map.put("registNo", prpLWorkRovePageDto.getRegistNo());
		}else{
			map.put("code", "9999");
			map.put("message", "转交失败");
			map.put("registNo", prpLWorkRovePageDto.getRegistNo());
		}
		return map;
	}
	
	@Transactional(rollbackFor = Exception.class)
	private void save(WorkRoveDto workRoveDto, WorkFlowDto workFlowDto) throws Exception{
		//保存转交数据
		if("Check".equals(workRoveDto.getNodeType())){
			String registNo = workRoveDto.getRegistNo();
			// 首先删除原来的相关数据 
			this.deleteSubInfo(registNo);
			//1 调度明细表
			if(workRoveDto.getPrpLScheduleItemDto()!=null){
				prpLScheduleItemService.remove(workRoveDto.getPrpLScheduleItemDto().getScheduleId(), workRoveDto.getPrpLScheduleItemDto().getRegistNo(), workRoveDto.getPrpLScheduleItemDto().getItemNo());
				prpLScheduleItemService.save(workRoveDto.getPrpLScheduleItemDto());
			}
			//2调度及查勘主表
			if(workRoveDto.getPrpLScheduleMainWfDto()!=null){
				prpLScheduleMainWfService.modify(workRoveDto.getPrpLScheduleMainWfDto());
			}
		}else{
			if(workRoveDto.getPrpLRegistExtDtoList().size()>0){
				prpLRegistExtService.save(workRoveDto.getPrpLRegistExtDtoList().get(0));
			}
		}
		//保存流数据
		if (workFlowDto != null) {
			workFlowDto.setSubmit(false);
			workFlowService.deal(workFlowDto);
		}
	}

	private void deleteSubInfo(String registNo) {
		// 删除查勘相关信息
		String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
		String condition2 = " registNo = '" + StringUtils.rightTrim(registNo) + "' and nodetype ='check'";
		String statement = ""; 
		//查勘则删除以下子表(非意健险中一般都是查勘)
		statement =  " DELETE FROM prpLcompensateEar Where " + condition2;
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM PrpLregistText Where " + condition +" and (TextType = '3' or TextType='07')";
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM PrpLcheckExt Where " + condition;
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM PrpLcheckLoss Where " + condition;
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM PrpLcheck Where " + condition;
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM prpLprop Where " + condition;
		entityManager.createNativeQuery(statement);
		statement = " DELETE FROM prpLverifyloss Where " + condition;
		entityManager.createNativeQuery(statement);
	}
	
	/**
	 * @description 转交工作流程拆分
	 * @author yanlei
	 * @date 2017年11月27日
	 * @param PrpLCheckWorkRovePageDto 转交工作流所需对象
	 * @return WorkRoveDto 返回信息
	 */
	@SuppressWarnings("unchecked")
	private WorkRoveDto pageFormToDto(PrpLWorkRovePageDto prpLWorkRovePageDto) {
		WorkRoveDto workRoveDto  = new WorkRoveDto();
		PrpLRegistExtDto prpLRegistExtDto = new PrpLRegistExtDto();
		List<PrpLRegistExtDto> accessList = new ArrayList<PrpLRegistExtDto>();
		String registNo = prpLWorkRovePageDto.getRegistNo();
		//1 整理报案补充说明表的数据
		//1.1查询出过往的案件补充说明
		String conditions = "select p from PrpLRegistExt p where registNo = :registNo order by p.serialNo desc";
		Query agentQuery = entityManager.createQuery(conditions);
		agentQuery.setParameter("registNo", registNo);
		List<PrpLRegistExt> prpLRegistExtList = agentQuery.getResultList();
		if(LOGGER.isDebugEnabled()){
			LOGGER.error("当前报案号的案件补充说明有"+prpLRegistExtList.size()+"条");
		}
		if(null!=prpLRegistExtList&&prpLRegistExtList.size()>0){
			prpLRegistExtDto.setSerialNo(((PrpLRegistExt)prpLRegistExtList.get(0)).getSerialNo()+1) ;
		}else{
			prpLRegistExtDto.setSerialNo(1) ; 
		}
		//1.2整理本次转交工作的案件补充说明
		prpLRegistExtDto.setNodeType(prpLWorkRovePageDto.getNodeType());
		prpLRegistExtDto.setRegistNo(prpLWorkRovePageDto.getRegistNo());
		prpLRegistExtDto.setRiskCode(prpLWorkRovePageDto.getRiskCode());
		prpLRegistExtDto.setInputDate(prpLWorkRovePageDto.getInputDate());
		prpLRegistExtDto.setComCode(prpLWorkRovePageDto.getComCode());
		prpLRegistExtDto.setOperatorCode(prpLWorkRovePageDto.getOperatorCode()); 
		prpLRegistExtDto.setContext(prpLWorkRovePageDto.getContext()); 
		accessList.add(prpLRegistExtDto);
		//把整理的结果放入到返回的对象workRoveDto内。
		workRoveDto.setNodeType(prpLWorkRovePageDto.getNodeType());
		workRoveDto.setRegistNo(prpLWorkRovePageDto.getRegistNo());
		workRoveDto.setPrpLRegistExtDtoList(accessList);
		//查看定损节点独有
		if("check".equals(prpLWorkRovePageDto.getNodeType())){
			String conditionsWF = "select p from PrpLScheduleMainWf p where registNo = :registNo and ScheduleID = '1'";
			Query agentQueryWF = entityManager.createQuery(conditionsWF);
			agentQueryWF.setParameter("registNo", registNo);
			List<PrpLScheduleMainWf> prpLScheduleMainWflist = agentQueryWF.getResultList();
			LOGGER.error("zhujianchaxunshuliang"+prpLScheduleMainWflist.size());
			if(prpLScheduleMainWflist.size()==0){
				throw new BusinessException("未查到主表的相关信息");
			}
			PrpLScheduleMainWf prpLScheduleMainWf = prpLScheduleMainWflist.get(0);
			prpLScheduleMainWf.setScheduleObjectId(prpLWorkRovePageDto.getHandleCode());
			prpLScheduleMainWf.setScheduleObjectName(prpLWorkRovePageDto.getHandleName());
			prpLScheduleMainWf.setNextHandlerName(prpLWorkRovePageDto.getHandlerName());
			if(prpLWorkRovePageDto.getHandleCode()==null||"".equals(prpLWorkRovePageDto.getHandleCode())){
				prpLScheduleMainWf.setNextHandlerCode("0000000000");
			}else{
				prpLScheduleMainWf.setNextHandlerCode(prpLWorkRovePageDto.getHandlerCode());
			}
			PrpLScheduleMainWfDto prpLScheduleMainWfDto = new PrpLScheduleMainWfDto();
			prpLScheduleMainWfDto = this.convert(prpLScheduleMainWf,PrpLScheduleMainWfDto.class);
			workRoveDto.setPrpLScheduleMainWfDto(prpLScheduleMainWfDto);
		}
		return workRoveDto;
	}
	/**
	 * @description 转交工作流程拆分
	 * @author yanlei
	 * @date 2017年11月27日
	 * @param PrpLCheckWorkRovePageDto 转交工作流所需对象
	 * @return WorkFlowDto 返回信息
	 */
	private WorkFlowDto formToWorkFlowDto(PrpLWorkRovePageDto prpLWorkRovePageDto) {
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//当前节点
		SwfLogDto swfLogDtoDealNode = new SwfLogDto();
		//下一节点
		SwfLogDto swfLogDtoNextNode = new SwfLogDto();
		List<SwfLogDto> nextNodeList = new ArrayList<SwfLogDto>();
		String swfLogFlowID = prpLWorkRovePageDto.getSwfLogFlowID();
		LOGGER.error("asdlkjf ualhakjdhflaeiurncaiusdha"+prpLWorkRovePageDto.getSwfLogFlowID());
		int swfLogLogNo = prpLWorkRovePageDto.getSwfLogLogNo();
		String conditions = "select s from SwfLog s where flowId = :flowId and logNo = :logNo";
		Query agentQuery = entityManager.createQuery(conditions);
		agentQuery.setParameter("flowId", swfLogFlowID);
		agentQuery.setParameter("logNo", swfLogLogNo);
		swfLogDtoDealNode = this.convert(agentQuery.getResultList().get(0), SwfLogDto.class);
//		swfLogDtoDealNode.setNodeStatus("0");
		//下一节点属性
		swfLogDtoNextNode.setBusinessNo(swfLogDtoDealNode.getBusinessNo());
		swfLogDtoNextNode.setKeyIn(swfLogDtoDealNode.getKeyIn());
		if("check".equals(swfLogDtoDealNode.getNodeType())){
			//转交查勘，前一节点swflog的keyout==keyin
			if(null==swfLogDtoDealNode.getKeyOut()||"".equals(swfLogDtoDealNode.getKeyOut().trim())){
				swfLogDtoDealNode.setKeyOut(swfLogDtoDealNode.getKeyIn());
				swfLogDtoNextNode.setKeyOut(swfLogDtoDealNode.getKeyIn());
			}else{
				swfLogDtoNextNode.setKeyOut(swfLogDtoDealNode.getKeyOut());
			}
		}
		if(prpLWorkRovePageDto.getHandleCode()!=null && !"".equals(prpLWorkRovePageDto.getHandleCode())){
			swfLogDtoNextNode.setHandleDept(prpLWorkRovePageDto.getHandleCode());
		}else{
			swfLogDtoNextNode.setHandleDept("0000000000");
		}
		swfLogDtoNextNode.setNodeType(swfLogDtoDealNode.getNodeType());
		swfLogDtoNextNode.setLossitemCode(swfLogDtoDealNode.getLossitemCode());
		//1.1获取人员记录
		swfLogDtoNextNode.setHandlerCode(prpLWorkRovePageDto.getHandlerCode());
		swfLogDtoNextNode.setHandlerName(prpLWorkRovePageDto.getHandlerName());
		nextNodeList.add(swfLogDtoNextNode);
		SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
		swfLogTransferDto.setNextBusinessNo(swfLogDtoDealNode.getBusinessNo());
		swfLogTransferDto.setNextNodeListType("1");
		swfLogTransferDto.setSwfLogNextList(nextNodeList);
		swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
		swfLogTransferDto.setUserComCode(prpLWorkRovePageDto.getHandleCode());
		swfLogTransferDto.setUserComName(prpLWorkRovePageDto.getHandleName());
		swfLogTransferDto.setUserUserCode(prpLWorkRovePageDto.getHandlerCode());
		swfLogTransferDto.setUserUserName(prpLWorkRovePageDto.getHandlerName());
		workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
		return workFlowDto;
	}
	
	/**
	 * @description 放弃任务
	 * @author yanlei
	 * @date 2017年12月23日
	 * @param  prpLCheckWorkRovePageDto 获取主键的对象
	 * @return Map<String,String> 成功或者失败
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String,String> giveupTemporary(@RequestBody PrpLWorkRovePageDto prpLWorkRovePageDto)throws Exception{
		Long time1= System.currentTimeMillis() ;
		System.out.println(time1);
		if(prpLWorkRovePageDto==null){
			throw new BusinessException("放弃对象不允许为null");
		}
		SwfLog swfLog = new SwfLog();
		if (StringUtils.isNotEmpty(prpLWorkRovePageDto.getRegistNo())){
			swfLog=swfLogDao.queryEndcaByRegistNo(prpLWorkRovePageDto.getRegistNo());
		}
		else {
			String swfLogFlowID = prpLWorkRovePageDto.getSwfLogFlowID();
			Integer swfLogLogNo = prpLWorkRovePageDto.getSwfLogLogNo();
			SwfLogKey swfLogKey = new SwfLogKey(swfLogFlowID,swfLogLogNo);
			swfLog = swfLogDao.findOne(swfLogKey);
		}
		SwfLogDto swfLogDto = convert(swfLog,SwfLogDto.class);
//		String conditions = "select s from SwfLog s where flowId= :flowId and logNo= :logNo";
//		Query agentQuery = entityManager.createQuery(conditions);
//		agentQuery.setParameter("flowId", swfLogFlowID);
//		agentQuery.setParameter("logNo", swfLogLogNo);
//		if(agentQuery.getResultList().size() > 0){
//			swfLogDto = (SwfLogDto) agentQuery.getResultList().get(0);
//		}
		boolean giveUp = true;
		if(swfLogDto.getNodeStatus().equals("2")){
			swfLogDto.setHandlerCode("");
			swfLogDto.setHandlerName("");
			swfLogDto.setNodeStatus("0");
			swfLogDto.setFlowStatus("1");
		}else if(swfLogDto.getNodeStatus().equals("0")){
			swfLogDto.setHandlerCode("");
			swfLogDto.setHandlerName("");
			swfLogDto.setFlowStatus("1");
		}else{
			giveUp = false;
		}
		swfLogService.modify(swfLogDto);
		Map<String,String> map = new HashMap<String,String>();
		if(giveUp){
			map.put("code", "0000");
			map.put("message", "放弃成功");
		}else{
			map.put("code", "9999");
			map.put("message", "放弃失败");
		}
		Long time2 = System.currentTimeMillis();
		Long time =time2 - time1;
		System.out.println("当前程序的总执行时间是======");
		System.out.println(time);
		return map;
	}
	
	/**
	 * @description 工作台任务详查
	 * @author 闫磊
	 * @param  QueryMyJobDetail 入参信息
	 * @return list 返回的数据集合
	 */
	@Override
	public PageInfo queryMyJobDetail(@RequestBody QueryMyJobDetailDto queryMyJobDetailDto)throws Exception{
		if(queryMyJobDetailDto == null){
			throw new BusinessException("当前操作对象为空");
		}
		Integer pageNo = queryMyJobDetailDto.getPageNo();
		Integer pageSize = queryMyJobDetailDto.getPageSize();
		String handlerCode = queryMyJobDetailDto.getHandlerCode();
		String nodeType = queryMyJobDetailDto.getNodeType();
		String nodeStatus = queryMyJobDetailDto.getNodeStatus();
		String registNo = queryMyJobDetailDto.getRegistNo();
		String policyNo = queryMyJobDetailDto.getPolicyNo();
//		if(StringUtils.isEmpty(nodeStatus) && (StringUtils.isEmpty(registNo) || StringUtils.isEmpty(policyNo))){
//			throw new BusinessException("请输入查询条件");
//		}
		if (pageNo < 1) {
			throw new BusinessException("页码不能小于1");
		}
		if (pageSize < 1) {
			throw new BusinessException("每页数量不能小于1");
		}
		return getPageInfoByHandlerCode(handlerCode,pageNo,pageSize,nodeType,nodeStatus,"1",registNo,policyNo);
	}
	
	/**
	 * @description 个人任务查询
	 * @author 闫磊
	 * @param  queryMyJobSwfLogDto 获取主键的对象
	 * @return List 成功或者失败
	 */
	@Override
	public List<QueryMyJobSwfLogDto> queryMyJob(QueryMyJobSwfLogDto queryMyJobSwfLogDto)throws Exception{
		if(queryMyJobSwfLogDto==null || queryMyJobSwfLogDto.getHandlerCode()==null || "".equals(queryMyJobSwfLogDto.getHandlerCode())){
			throw new BusinessException("当前操作人为空");
		}
		List<QueryMyJobSwfLogDto> MyJobList = new ArrayList<QueryMyJobSwfLogDto>();
		String handlerCode = queryMyJobSwfLogDto.getHandlerCode();
		List<UtiMenuDto> utiMenuDtoList = menuApi.getMenusByUserCode(handlerCode);
		List<String> nodeTypeList = new ArrayList<String>();
		if(utiMenuDtoList!=null && utiMenuDtoList.size()>0){
			for(UtiMenuDto utiMenuDto: utiMenuDtoList){
				if(utiMenuDto.getMenuCName().indexOf("报案")>=0){
					nodeTypeList.add("regis");
				}else if(utiMenuDto.getMenuCName().indexOf("调度")>=0){
					nodeTypeList.add("sched");
				}else if(utiMenuDto.getMenuCName().indexOf("查勘定损")>=0){
					nodeTypeList.add("check");
				}else if(utiMenuDto.getMenuCName().indexOf("立案")>=0){
					nodeTypeList.add("claim");
				}else if(utiMenuDto.getMenuCName().indexOf("特殊赔案")>=0){
					nodeTypeList.add("speci");
				}else if(utiMenuDto.getMenuCName().indexOf("理算")>=0){
					nodeTypeList.add("compp");
				}
			}
		}
		for(String nodeType : nodeTypeList){
			LOGGER.error("nodeType===="+nodeType);
		}
		Integer pageNo = queryMyJobSwfLogDto.getPageNo();
		Integer pageSize = queryMyJobSwfLogDto.getPageSize();
		QueryMyJobSwfLogDto queryMyJobSwfLogDtoNew = null;
		for(String nodeType : nodeTypeList){
			queryMyJobSwfLogDtoNew = new QueryMyJobSwfLogDto();
			queryMyJobSwfLogDtoNew.setHandlerCode(handlerCode);
			if("regis".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("报案");
			}else if("sched".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("调度");
			}else if("check".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("查勘定损");
			}else if("claim".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("立案");
			}else if("speci".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("特殊赔案");
			}else if("compp".equals(nodeType)){
				queryMyJobSwfLogDtoNew.setNodeType(nodeType);
				queryMyJobSwfLogDtoNew.setNodeName("理算");
			}
			PageInfo pendPageInfo = getPageInfoByHandlerCode(handlerCode,pageNo,pageSize,nodeType,"2","0","","");
			queryMyJobSwfLogDtoNew.setPendingNo((int)pendPageInfo.getTotalCount());
			PageInfo alrdPageInfo = getPageInfoByHandlerCode(handlerCode,pageNo,pageSize,nodeType,"4","0","","");
			queryMyJobSwfLogDtoNew.setAlreadyNo((int)alrdPageInfo.getTotalCount());
			MyJobList.add(queryMyJobSwfLogDtoNew);
		}
		return MyJobList;
	}
	/**
	 * 获取当前状态对象
	 * @author 闫磊
	 * */
	public PageInfo getPageInfoByHandlerCode(String handlerCode,Integer pageNo,Integer pageSize,String nodeType,String nodeStatus,String init,String registNo,String policyNo) throws Exception{
		PageInfo<QueryMyJobDetailDto> pageInfo = new PageInfo<>();
		Long totalSizeStrLon = null;
		String conditions = "";
		String conditionsCount = "";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		conditionsCount = getConditionsByOperator(handlerCode,nodeType,nodeStatus,paraMap,"count",registNo,policyNo);
		Query agentQueryCount = entityManager.createQuery(conditionsCount);
		for (String key : paraMap.keySet()) {
			agentQueryCount.setParameter(key, paraMap.get(key));
		}
		totalSizeStrLon = new BigInteger(agentQueryCount.getSingleResult().toString()).longValue();
		// 总记录数
		pageInfo.setTotalCount(totalSizeStrLon);
		if("0".equals(init)){
			return pageInfo;
		}
		conditions = getConditionsByOperator(handlerCode,nodeType,nodeStatus,paraMap,"query",registNo,policyNo);
		Query agentQuery = entityManager.createQuery(conditions);
		for (String key : paraMap.keySet()) {
			agentQuery.setParameter(key, paraMap.get(key));
		}
		if (pageNo != null) {
			agentQuery.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
		}
		if (pageSize != null) {
			agentQuery.setMaxResults(pageSize.intValue());
		}

		List<SwfLog> swfLogList=new ArrayList<>();
		if("endca".equals(nodeType)&&"4".equals(nodeStatus)){
			List<SwfLogStore> swfLogStoreList=agentQuery.getResultList();
			convertCollection(swfLogStoreList,swfLogList,SwfLog.class);
		}else {
			 swfLogList = agentQuery.getResultList();
		}
		List<QueryMyJobDetailDto> queryMyJobDetailDtoList = new ArrayList<>();
		for (int n = 0; n < swfLogList.size(); n++) {
			QueryMyJobDetailDto queryMyJobDetailDto = new QueryMyJobDetailDto();
			queryMyJobDetailDto.setPolicyNo(swfLogList.get(n).getPolicyNo());
			queryMyJobDetailDto.setRegistNo(swfLogList.get(n).getRegistNo());
			queryMyJobDetailDto.setFlowId(swfLogList.get(n).getFlowId());
			queryMyJobDetailDto.setLogNo(swfLogList.get(n).getLogNo());
			queryMyJobDetailDto.setNodeStatus(nodeStatus);
			queryMyJobDetailDto.setBusinessNo(swfLogList.get(n).getBusinessNo());
			PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(swfLogList.get(n).getRegistNo());
			if (prpLRegistDto != null ){
			queryMyJobDetailDto.setReportDate(prpLRegistDto.getReportDate());
			}
			queryMyJobDetailDtoList.add(queryMyJobDetailDto);
		}
		// 数据存放dto集合
		pageInfo.setContent(queryMyJobDetailDtoList);
		// 当前页数
		pageInfo.setPages(pageNo);
		return pageInfo;
	}
	
	
	private String getConditionsByOperator(String handlerCode,String nodeType,String nodeStatus,Map<String, Object> paraMap,String flag,String registNo,String policyNo) throws Exception{
		StringBuilder stringBuilder = null;
		if("query".equals(flag)){
			if("endca".equals(nodeType)&&"4".equals(nodeStatus)){
				stringBuilder = new StringBuilder("SELECT s FROM SwfLogStore s WHERE nodeType = :nodeType");
			}else {
				stringBuilder = new StringBuilder("SELECT s FROM SwfLog s WHERE nodeType = :nodeType");
			}
		}else{
			if("endca".equals(nodeType)&&"4".equals(nodeStatus)){
				stringBuilder = new StringBuilder("SELECT count(s) FROM SwfLogStore s WHERE nodeType = :nodeType");
			}
			else {
				stringBuilder = new StringBuilder("SELECT count(s) FROM SwfLog s WHERE nodeType = :nodeType");
			}
		}
		paraMap.put("nodeType", nodeType);

		if(StringUtils.isNotEmpty(handlerCode)){
			//工作台查勘定损环节未处理数字即使没有处理人的查勘定损任务 也应该算到未处理上 这个数不应该精确到人身上
			if ("check".equals(nodeType) && "0".equals(nodeStatus)){
				stringBuilder.append(" and (handlerCode = :handlerCode or handlerCode is null)");
			}
			else if ("endca".equals(nodeType)&&"4".equals(nodeStatus)){
				stringBuilder.append(" and (handlerCode = :handlerCode or handlerCode is null)");
			}
			else {
				stringBuilder.append(" and handlerCode = :handlerCode ");
			}
			paraMap.put("handlerCode",handlerCode);
		}
		if(StringUtils.isNotEmpty(nodeStatus)){
			stringBuilder.append(" and nodeStatus = :nodeStatus ");
			paraMap.put("nodeStatus", nodeStatus);
		}
		if(StringUtils.isNotEmpty(registNo)){
			stringBuilder.append(" and registNo = :registNo ");
			paraMap.put("registNo", registNo);
		}
		if(StringUtils.isNotEmpty(policyNo)){
			stringBuilder.append(" and policyNo = :policyNo ");
			paraMap.put("policyNo", policyNo);
		}
		stringBuilder.append(" and s.riskCode in ('");
		Map<String, String> riskCodeMap = new HashMap<String, String>();
		List<String> outerCodeList = new ArrayList<String>();
		riskCodeMap.put("riskType", "I");
		List<UtiCodeTransferDto> dtoListI = utiCodeTransferApi.queryByRiskType(riskCodeMap);
		if (dtoListI.size() > 0) {
			for (int s = 0; s < dtoListI.size(); s++) {
				outerCodeList.add(dtoListI.get(s).getOuterCode());
			}
		}
		riskCodeMap.replace("riskType", "H");
		List<UtiCodeTransferDto> dtoListH = utiCodeTransferApi.queryByRiskType(riskCodeMap);
		if (dtoListH.size() > 0) {
			for (int s = 0; s < dtoListH.size(); s++) {
				outerCodeList.add(dtoListH.get(s).getOuterCode());
			}
		}
		if (outerCodeList != null && outerCodeList.size() > 0) {
			for (int i = 0; i < outerCodeList.size(); i++) {
				if (i == outerCodeList.size() - 1) {
					stringBuilder.append(outerCodeList.get(i));
				} else {
					stringBuilder.append(outerCodeList.get(i) + "','");
				}
			}
		}
		stringBuilder.append("')");
		//如果是待处理,则没有相应的时间限制 且跟人也没关系 2是正在处理
		if("2".equals(nodeStatus)){
			stringBuilder.append(" and flowInTime > '").append(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY).toString()).append("' ");
		}
		else if ("4".equals(nodeStatus)){
			stringBuilder.append(" and flowInTime between '").append(new DateTime(DateTime.current(),DateTime.YEAR_TO_MONTH).toString()+"-01").append("' and '").append(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY).toString()).append(" 23:59:59' ");
		}
		// 工作流状态不能是关闭
		if (!("endca".equals(nodeType)&&"4".equals(nodeStatus))) {
			stringBuilder.append(" and flowStatus!='0' ");
		}
		// 新老系统数据区别标志
		stringBuilder.append(" and dataFlag is null ");
		stringBuilder.append(" and medicalTransitFlag is null ");
		stringBuilder.append(" order by handleTime desc");
		System.out.println(stringBuilder);
		return stringBuilder.toString();
	}
}
