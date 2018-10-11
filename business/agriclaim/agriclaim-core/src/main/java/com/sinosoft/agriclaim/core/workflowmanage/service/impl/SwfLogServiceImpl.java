package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.schedulemanage.dto.ScheduleSaveDto;
import com.sinosoft.agriclaim.api.workflowmanage.PrpLAutoClaimListApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogStoreDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNotionDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogStore;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogService;
import com.sinosoft.agriclaim.core.workflowmanage.service.util.BaseSwfLogServiceImpl;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.UserDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.txnlist.api.claiminsurancelist.LossRateMainListApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-08 05:47:03.090
 * @description 工作流日志表Core接口实现
 */
@Service
public class SwfLogServiceImpl extends BaseSwfLogServiceImpl implements SwfLogService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SwfLogServiceImpl.class);

	@Autowired
	private SwfLogDao swfLogDao;
	@Autowired
	private PrpLRegistDao prplRegistDao;
	@Autowired
	private UserApi userApi;
	@Autowired
	private SwfNotionDao swfNotionDao;
    @Autowired
    private  PrpDriskApi prpDriskApi;
    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
    @Autowired
	private EntityManager entityManager;
	@Autowired
	private LossRateMainListApi lossRateMainListApi;
	@Autowired
	private PrpLAutoClaimListApi prpLAutoClaimListApi;
	@Autowired
	private PrpLCompensateService prpLCompensateService;
	@Autowired
	private SwfLogStoreDao swfLogStoreDao;
	@Autowired
    private PrpLCompensateDao prpLCompensateDao;
	/**
	 * @description 新增
	 * @param
	 */
	public void save(SwfLogDto swfLogDto) {
		SwfLog swfLog = this.convert(swfLogDto, SwfLog.class);
		swfLogDao.save(swfLog);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(String flowId, java.lang.Integer logNo) {
		SwfLogKey swfLogKey = new SwfLogKey(flowId, logNo);
		swfLogDao.delete(swfLogKey);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(SwfLogDto swfLogDto) {
		SwfLog swfLog = this.convert(swfLogDto, SwfLog.class);
		swfLogDao.save(swfLog);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public SwfLogDto queryByPK(String flowId, java.lang.Integer logNo) {
		SwfLogKey swfLogKey = new SwfLogKey(flowId, logNo);
		SwfLog swfLog = swfLogDao.findOne(swfLogKey);
		return this.convert(swfLog, SwfLogDto.class);
	}

	/**
	 * 整理回访主表数据(自动生成回访主表数据)
	 *
	 * @param saveDto
	 * @param registNo
	 *            报案号
	 * @param nodeType
	 *            当前节点
	 * @param state
	 *            回访案件状态
	 * @author 马俊玲
	 * @throws Exception
	 */
	@Override
	public PrplReturnVisitSwflogDto setReturnVisitSwflogDto(ScheduleSaveDto saveDto, String registNo, String nodeType,
			String state) {
		// 通过业务号 获取报案号
		UserInfo userInfo = SinoRequestContext.getCurrentContext().getUser();
		// 取得当前用户信息，写操作员信息到Dto中
		UserDto userDto = new UserDto();
		userDto.setUserCode(userInfo.getUserCode());
		userDto.setUserName(userInfo.getUserName());
		userDto.setComCode(userInfo.getLoginComCode());
		// 通过报案号查询报案信息
		PrpLRegistKey prplRegistKey = new PrpLRegistKey(registNo);
		PrpLRegist prpLregist = prplRegistDao.findOne(prplRegistKey);
		PrplReturnVisitSwflog prplreturnvisitswflog = new PrplReturnVisitSwflog();
		if (prpLregist != null && !"".equals(prpLregist)) {
			// 业务号
			prplreturnvisitswflog.setBusinessNo(prpLregist.getRegistNo());
			// 节点号
			prplreturnvisitswflog.setNodeType(nodeType);
			// 报案号
			prplreturnvisitswflog.setRegistNo(prpLregist.getRegistNo());
			// 承保机构
			prplreturnvisitswflog.setComCode(prpLregist.getComCode());
			prplreturnvisitswflog.setPolicyNo(prpLregist.getPolicyNo());
			// String comName =
			// companyApi.queryCompanyByComCode(prpLregist.getComCode()).getComCName();
			// 机构名称
			// prplreturnvisitswflog.setComCodeName(comName);
			// 被保险人
			prplreturnvisitswflog.setInsuredName(prpLregist.getInsuredName());
			String reportd = prpLregist.getReportDate().toString();
			reportd = reportd + " " + prpLregist.getReportHour();
			DateTime d = new DateTime(reportd, DateTime.YEAR_TO_MONTH);
			// 报案时间
			prplreturnvisitswflog.setReportDate(d);
			if ("sched".equals(nodeType)) {

			} else {
				// 结案时间
				prplreturnvisitswflog
						.setCeaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
			}
			// 处理人代码
			prplreturnvisitswflog.setHandlerCode(userDto.getUserCode());
			// 处理人名称
			prplreturnvisitswflog.setHandlerName(userDto.getUserName());
			// 处理人部门
			prplreturnvisitswflog.setHandlerComCode(userDto.getComCode());
			// 流入时间
			prplreturnvisitswflog.setFlowintoTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
			// 险类
			prplreturnvisitswflog.setClassCode(prpLregist.getClassCode());
			// 状态
			prplreturnvisitswflog.setState(state);
			prplreturnvisitswflog.setRiskCode(prpLregist.getRiskCode());

		}
		return convert(prplreturnvisitswflog, PrplReturnVisitSwflogDto.class);
	}

	/**
	 * 检查该节点是否可以被提交，如果不能提交丢出理由原因
	 *
	 * @param swfLogFlowID
	 *            工作流ID
	 * @param swfLogLogNo
	 *            工作流logNo
	 * @author 马俊玲
	 * @return msg
	 */
	@Override
	public String checkNodeSubmit(String swfLogFlowID, String swfLogLogNo) {
		String nodeType = "";
		String conditions = "";
		String nodeMsg = "";
		String msg = "";
		String nodeName = "";
		int checkCount = 0;
		List<SwfLog> swfLogList = new ArrayList<>();
		SwfLogDto swfLogDtoCurrent = null;
		Iterator it = null;
		int logNo = 0;
		if ("".equals(swfLogLogNo) || "null".equals(swfLogLogNo) || "undefined".equals(swfLogLogNo)) {
			logNo = 0;
		} else {
			logNo = Integer.parseInt(DataUtils.nullToZero(swfLogLogNo));
		}
		if (swfLogFlowID == null || logNo < 1) {
			return msg;
		}
		SwfLogKey swfLogKey = new SwfLogKey(swfLogFlowID, logNo);
		swfLogDtoCurrent = convert(swfLogDao.findOne(swfLogKey), SwfLogDto.class);
		if (swfLogDtoCurrent == null) {
			return msg;
		}
		nodeType = swfLogDtoCurrent.getNodeType();
		// 核价检查是否已经向外询价
		if ("verip".equals(nodeType)) {
			nodeName = "核价";
			swfLogList = swfLogDao.findByflowIdAndNodeType(swfLogDtoCurrent.getFlowId(), "verpo");
		}
		// 单正检查是不是可以提交
		if ("certi".equals(nodeType)) {
			nodeName = "单证";
			swfLogList = swfLogDao.findByflowIdAndNodeTypeNative(swfLogDtoCurrent.getFlowId());
		}
		// 定损检查是不是可以提交
		if ("sched".equals(nodeType)) {
			nodeName = "调度";
			swfLogList = swfLogDao.findByConditon2(swfLogDtoCurrent.getFlowId());
		}
		// 理算检查是不是可以提交
		if ("compe".equals(nodeType) || "compp".equals(nodeType)) {
			nodeName = "理算";
			swfLogList = swfLogDao.findByflowIdAndNodeTypeNative2(swfLogDtoCurrent.getFlowId());
		}
		it = swfLogList.iterator();
		while (it.hasNext()) {
			SwfLogDto swfLogDto = new SwfLogDto();
			swfLogDto = convert((SwfLog) it.next(), SwfLogDto.class);
			if ("claim".equals(swfLogDto.getNodeType())) {
				nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
			} else {
				// 农险（养殖的）itemcode暂定为-2，所以偶改下这里先~~~！
				if ("0".equals(swfLogDto.getLossitemCode()) || "-1".equals(swfLogDto.getLossitemCode())
						|| "-2".equals(swfLogDto.getLossitemCode())) {
					nodeMsg = nodeMsg + "'" + swfLogDto.getNodeName() + "',";
				} else {
					nodeMsg = nodeMsg + "的'" + swfLogDto.getNodeName() + "',";
				}
			}
			checkCount++;
		}
		if (checkCount > 0) {
			msg = nodeMsg.substring(0, nodeMsg.length() - 1) + "节点没有处理完毕，不能结束" + nodeName;
		}
		// 结束单证的判断
		return msg;
	}
	/**
     * 有原因的更换工作流上的处理原因
     * @author 马俊玲
     * @param flowID 工作流ID
     * @param logNo 工作流LogNo
     * @param handlerCode 操作员代码
     * @param  reasion 调度ID
     * @return WorkFlowDto
     */
	@Override
	public WorkFlowDto changeFlowNodeHandler(String flowID, String logNo, String handlerCode, String reasion,
			String handleDept) {

		WorkFlowDto workFlowDto = new WorkFlowDto();
		int intLogNo = Integer.parseInt(DataUtils.nullToZero(logNo));
		SwfLogDto swfLogDto = new SwfLogDto();
		SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(flowID, intLogNo));
		swfLogDto = convert(swfLog, SwfLogDto.class);

		if (swfLogDto == null) {
			return workFlowDto;
		}

		// 默认handleDept为空，则不判断。
		if (!handleDept.equals("")) {
			if (swfLogDto.getHandleDept().equals(handleDept) && swfLogDto.getHandlerCode().equals(handlerCode)) {
				return workFlowDto;
			}
		} else {
			if (swfLogDto.getHandlerCode().equals(handlerCode)) {
				return workFlowDto;
			}
		}
		String handlerName = userApi.queryUserInfo(handlerCode).getUserName();
		swfLogDto.setHandlerCode(handlerCode);
		swfLogDto.setHandlerName(handlerName);

		swfLogDto.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		// 更新时间
		if (!handleDept.equals("")) {
			swfLogDto.setHandleDept(handleDept);
		}
		workFlowDto.setUpdateSwfLogDto(swfLogDto);
		workFlowDto.setUpdate(true);
		SwfNotionDto swfNotionDto = new SwfNotionDto();
		int lineNo = swfNotionDao.getMaxLineNo(flowID, intLogNo);
		swfNotionDto.setFlowId(flowID);
		swfNotionDto.setLogNo(intLogNo);
		swfNotionDto.setLineNo(lineNo);
		swfNotionDto.setHandleText(reasion);
		ArrayList swfNotionList = new ArrayList();
		swfNotionList.add(swfNotionDto);
		workFlowDto.setSwfNotionDtoList(swfNotionList);
		return workFlowDto;
	}
    /**
     * （根据页面输入条件查询结案信息）
     * @author: 董坤
     * @date: 2017/11/10 15:04
     * @param requestQueryEndCaseDto 查询页面数据
     * @return ResponseDto 查询结果页面数据
     * @throws Exception
     */
    @Override
    public QueryEndcaReturnDto queryEndCaseByCondition(RequestQueryEndCaseDto requestQueryEndCaseDto) throws Exception{
        String nodeType="endca";//结案节点
        int pageNo = 1;
        int pageSize = 10;//todo 可以放入配置文件

		List<ResponseQueryEndCaseDto> reponseList=new ArrayList<>();
		Long totalCount;
		reponseList=queryDeal(requestQueryEndCaseDto).getResponseQueryEndCaseDtoList();
		totalCount=queryDeal(requestQueryEndCaseDto).getTotalCount();
//		//未处理情况
//		if ("0".equals(requestQueryEndCaseDto.getState())){
//			reponseList=queryWaitDeal(requestQueryEndCaseDto).getResponseQueryEndCaseDtoList();
//			totalCount=queryWaitDeal(requestQueryEndCaseDto).getTotalCount();
//		}
//		//已处理情况
//		else if ("1".equals(requestQueryEndCaseDto.getState())){
//			reponseList=queryDeal(requestQueryEndCaseDto).getResponseQueryEndCaseDtoList();
//			totalCount=queryDeal(requestQueryEndCaseDto).getTotalCount();
//		}
//		else {
//			requestQueryEndCaseDto.setPageSize(requestQueryEndCaseDto.getPageSize()/2);
//
//
//			List<ResponseQueryEndCaseDto> list1=queryWaitDeal(requestQueryEndCaseDto).getResponseQueryEndCaseDtoList();
//			Long totalCount1=queryWaitDeal(requestQueryEndCaseDto).getTotalCount();
//			List<ResponseQueryEndCaseDto> list2=queryDeal(requestQueryEndCaseDto).getResponseQueryEndCaseDtoList();
//			Long totalCount2=queryDeal(requestQueryEndCaseDto).getTotalCount();
//			reponseList.addAll(list1);
//			reponseList.addAll(list2);
//			totalCount=totalCount1+totalCount2;
//		}
		QueryEndcaReturnDto queryEndcaReturnDto=new QueryEndcaReturnDto();
		queryEndcaReturnDto.setResponseQueryEndCaseDtoList(reponseList);
		queryEndcaReturnDto.setTotalCount(totalCount);
        return queryEndcaReturnDto;
    }

	/**
	 * @description 取消自动理赔数据查询(查询已完成调度，未进行理算的数据)
	 * @return SwfLogDtoList 查询结果
	 * @throws Exception
	 * @author 李磊
	 * @date 2018-01-22 11:54
	 */
	@Override
	public List<SwfLogDto> querySwfLogDtoList() throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowTime = new Date(System.currentTimeMillis());
		StringBuilder sql = new StringBuilder(200);

		sql.append("select * from swflog s ");
		sql.append("where exists (select 1 from swflog a ");
		sql.append("where a.nodetype = 'sched' and a.nodestatus = '4' and a.flowid = s.flowid) ");//选取已经完成调度数据
		sql.append("and not exists (select 1 from swflog b where b.nodetype = 'compe' and b.flowid = s.flowid) ");//排除已理算数据
		sql.append("and not exists (select 1 from PrpLAutoClaimList c where c.registno=s.registno and c.flowid=s.flowid) ");//排除自动理赔清单数据表已有数据
		sql.append("and s.nodestatus in('0','1')  and s.nodetype <>'speci' ");//取待处理状态，排除特殊赔案的数据
		sql.append("and substr(s.handletime,0,10) = '"+df.format(nowTime)+"' ");//查询当天
		//sql.append("and substr(s.handletime,0,7) = '2016-02' ");//测试按月份查询
		sql.append("order by s.flowid,s.logno ");

		Query query = entityManager.createNativeQuery(sql.toString(),SwfLog.class);
		List<SwfLog> resultList = query.getResultList();
		System.err.println("取消自动理赔查询SQL:"+sql.toString());
		List<SwfLogDto> swfLogDtoList=new ArrayList<>();
		convertCollection(resultList,swfLogDtoList,SwfLogDto.class);

		return swfLogDtoList;
	};

	/**
	 * @description 保存自动理赔数据到PrpLAutoClaimList表,并执行自动理赔任务
	 * @throws Exception
	 * @author 李磊
	 * @date 2018-01-23 15:53
	 */
	@Scheduled(cron = "0 */1 * * * ?") //todo 定时任务时间
	@Override
	public void doClaimTask() throws Exception{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date nowTime = new Date(System.currentTimeMillis());
		StringBuilder sql = new StringBuilder(200);

		sql.append("select * from swflog s ");
		sql.append("where exists (select 1 from swflog a ");
		sql.append("where a.nodetype = 'sched' and a.nodestatus = '4' and a.flowid = s.flowid) ");//选取已经完成调度数据
		sql.append("and not exists (select 1 from swflog b where b.nodetype = 'compe' and b.flowid = s.flowid) ");//排除已理算数据
		sql.append("and not exists (select 1 from PrpLAutoClaimList c where c.registno=s.registno and c.flowid=s.flowid) ");//排除自动理赔清单数据表已有数据
		sql.append("and s.nodestatus in('0','1')  and s.nodetype <>'speci' ");//取待处理状态，排除特殊赔案的数据
		sql.append("and substr(s.handletime,0,10) = '"+df.format(nowTime)+"' ");//查询当天
		//sql.append("and substr(s.handletime,0,7) = '2016-02' ");//测试按月份查询
		sql.append("order by s.flowid,s.logno ");

		Query query = entityManager.createNativeQuery(sql.toString(),SwfLog.class);
		List<SwfLog> resultList = query.getResultList();
		System.err.println("执行自动理赔查询SQL:"+sql.toString());
		List<SwfLogDto> swfLogDtoList=new ArrayList<>();
		List<SwfLogDto> swfLogDtoList2=new ArrayList<>();
		convertCollection(resultList,swfLogDtoList,SwfLogDto.class);
		for (SwfLogDto dto:swfLogDtoList) {
			String policyNo = dto.getPolicyNo();
			String registNo = dto.getRegistNo();
			Map<String,String> map = new HashMap<>();
			map.put("policyNo",policyNo);
			map.put("bizNo",registNo);
			String billno =lossRateMainListApi.queryEarLabelCount(map);//判断有无耳标，有耳标则返回定损清单编号billno，执行自动理赔
			if (StringUtils.isNotEmpty(billno)){
				PrpLAutoClaimListDto prpLAutoClaimListDto = new PrpLAutoClaimListDto();
				prpLAutoClaimListDto.setAutoFlag("1");//是否自动理赔,0为不进行自动理赔,默认1为自动理赔
				prpLAutoClaimListDto.setBillNo(billno);//定损清单清单号

				//查询立案号
				System.err.println("报案号:"+dto.getRegistNo());
				String getClaimNo_sql = "select * from prplclaim p where p.registno='"+dto.getRegistNo()+"' and p.policyno='"+dto.getPolicyNo()+"'";
				Query queryClaimNo = entityManager.createNativeQuery(getClaimNo_sql,PrpLClaim.class);
				if(queryClaimNo.getResultList().size()>0){
					PrpLClaim prpLClaim = (PrpLClaim)queryClaimNo.getResultList().get(0);
					String claimNo=prpLClaim.getClaimNo();
					prpLAutoClaimListDto.setClaimNo(claimNo);//立案号
				}else{
					prpLAutoClaimListDto.setClaimNo("");
				}

				prpLAutoClaimListDto.setFalseReason("");//自动理赔失败原因
				prpLAutoClaimListDto.setFinishFlag("");//自动理赔是否完成(1完成,0失败)
				prpLAutoClaimListDto.setFlowId(dto.getFlowId());//流程编号
				prpLAutoClaimListDto.setNodeName(dto.getNodeName());//流入节点名称
                prpLAutoClaimListDto.setNodeNo(dto.getNodeNo());//流入节点号
                prpLAutoClaimListDto.setNodeStartFlag("");//节点开始标志
                prpLAutoClaimListDto.setPolicyNo(dto.getPolicyNo());//保单号
				prpLAutoClaimListDto.setRegistNo(dto.getRegistNo());//报案号
				prpLAutoClaimListDto.setRemark1("");//备注1
				prpLAutoClaimListDto.setRemark2("");//备注2
				prpLAutoClaimListDto.setRiskCode(dto.getRiskCode());//险种

				//保存自动理赔数据到PrpLAutoClaimList表
				prpLAutoClaimListApi.save(prpLAutoClaimListDto);

				//封装自动理赔数据到swfLogDtoList2
				swfLogDtoList2.add(dto);
			}
		}
		//执行自动理赔任务
		if(swfLogDtoList2.size()>0){
			prpLAutoClaimListApi.autoClaimList(swfLogDtoList2);
		}
	}

	/**
	 * 根据工作流号查询最大节点号
	 * @param flowId 流程编号
	 * @return Integer 最大节点号
	 * @author 王心洋
	 * @time 2018-02-07
	 */
	@Override
	public Integer queryMaxLogNo(String flowId) {
		return swfLogDao.findMaxLogNoByFlowId(flowId);
	}

	/**
	 * 根据传入的不同的业务号码返回相应的流程节点的数据
	 * @param registNo 报案号
	 * @return businessNo 业务号 (可以是报案号, 立案号 , 理算书好 , 特殊赔案号)
	 * @author 王保良
	 * @time 2018-02-07
	 */
	@Override
	public SwfLogDto queryByBusinessNo(String registNo,String businessNo) throws Exception {
		if (StringUtils.isEmpty(businessNo)){
			throw new DataVerifyException("业务号不能为空");
		}
		if (StringUtils.isEmpty(registNo)){
			throw new DataVerifyException("报案号不能为空");
		}
		SwfLog swfLog = new SwfLog();
		SwfLogDto swfLogDto = new SwfLogDto();
		//如果是报案号的情况下
		if ("4".equals(businessNo.substring(0,1))) {
			 swfLog = swfLogDao.queryRegistByRegistNo(registNo);
			 swfLogDto = convert(swfLog, SwfLogDto.class);
		}
		//如果是立案号的情况下
		else if ("5".equals(businessNo.substring(0,1))) {
			 swfLog =swfLogDao.queryClaimByRegistNo(registNo);
			 swfLogDto = convert(swfLog,SwfLogDto.class);
		}
		//如果是理算书号的情况下
		else if ("6".equals(businessNo.substring(0,1))){
			 swfLog =swfLogDao.queryComppByRegistNo(registNo);
			 swfLogDto = convert(swfLog,SwfLogDto.class);
		}
		//如果是特殊赔案号的情况下
		else {
			 swfLog = swfLogDao.querySpeciByRegistNo(registNo);
			 swfLogDto = convert(swfLog,SwfLogDto.class);
		}
		return swfLogDto;
	}

	public QueryEndcaReturnDto queryWaitDeal(RequestQueryEndCaseDto requestQueryEndCaseDto) throws Exception {
		String nodeType="endca";//结案节点
		int pageNo = 1;
		int pageSize = 10;//todo 可以放入配置文件
		if(requestQueryEndCaseDto.getPageNo()!=null){
			pageNo = requestQueryEndCaseDto.getPageNo();
		}
		if(requestQueryEndCaseDto.getPageSize()!=null){
			pageSize = requestQueryEndCaseDto.getPageSize();
		}


		StringBuilder sql = new StringBuilder( "select p from SwfLog p where p.nodeType = :nodeType");
		Map<String,Object> map = new HashMap();
		map.put("nodeType",nodeType);
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getClaimNo())){
		    String vagueClaim = requestQueryEndCaseDto.getClaimNo()+"%";
			List<SwfLog> swfLogList=swfLogDao.queryByEndca(vagueClaim);
			List<String> flowList=new ArrayList<>();
			if (swfLogList.size() != 0) {
                for (int i = 0 ;i<swfLogList.size() ; i++){
                    flowList.add(swfLogList.get(i).getFlowId());
                }
			}
			sql.append(" and p.flowId in :flowList");

			map.put("flowList",flowList);
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getPolicyNo())){
			sql.append(" and p.policyNo like :policyNo");
			map.put("policyNo",requestQueryEndCaseDto.getPolicyNo()+"%");
		}
		if (StringUtils.isNotEmpty(requestQueryEndCaseDto.getInsuredName())){
		    sql.append(" and p.insuredName like :insuredName");
		    map.put("insuredName",requestQueryEndCaseDto.getInsuredName()+"%");
        }
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getRegistNo())){
			sql.append(" and p.registNo like :registNo");
			map.put("registNo",requestQueryEndCaseDto.getRegistNo()+"%");
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getFlowInStartDate())){
			sql.append(" and to_date(p.handleTime,'YYYY-MM-DD HH24:mi:ss') >= to_date(:flowStartDate,'YYYY-MM-DD HH24:mi:ss') ");
			map.put("flowStartDate",requestQueryEndCaseDto.getFlowInStartDate());
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getFlowInEndDate())){
			sql.append(" and to_date(p.handleTime,'YYYY-MM-DD HH24:mi:ss') <= to_date(:flowEndDate,'YYYY-MM-DD HH24:mi:ss') ");
			map.put("flowEndDate",requestQueryEndCaseDto.getFlowInEndDate());
		}
		//根据险种大类riskType查询包含的险种riskCode
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getRiskClaimType())){
			String riskType = requestQueryEndCaseDto.getRiskClaimType();
			Map<String,String> riskTypeMap = new HashMap<>();
			riskTypeMap.put("riskType", riskType);
			List<UtiCodeTransferDto> utiCodeTransferDtoList = utiCodeTransferApi.queryByRiskType(riskTypeMap);
			String riskCodes = "";
			for(UtiCodeTransferDto utiCodeTransferDto:utiCodeTransferDtoList){
				riskCodes +=" '"+ utiCodeTransferDto.getOuterCode() +"' ,";
			}
			riskCodes = riskCodes.substring(0,riskCodes.length()-1);
			sql.append(" and p.riskCode in ( "+riskCodes+") ");
		} else {
			List<UtiCodeTransferDto> utiCodeTransferDtoList = new ArrayList<>();
			// 种植险
			Map<String,String> riskTypeHMap = new HashMap<>();
			riskTypeHMap.put("riskType", "H");
			List<UtiCodeTransferDto> utiCodeTransferDtoHList = utiCodeTransferApi.queryByRiskType(riskTypeHMap);
			// 养植险
			Map<String,String> riskTypeIMap = new HashMap<>();
			riskTypeIMap.put("riskType", "I");
			List<UtiCodeTransferDto> utiCodeTransferDtoIList = utiCodeTransferApi.queryByRiskType(riskTypeIMap);
			utiCodeTransferDtoList.addAll(utiCodeTransferDtoHList);
			utiCodeTransferDtoList.addAll(utiCodeTransferDtoIList);
			String riskCodes = "";
			for(UtiCodeTransferDto utiCodeTransferDto:utiCodeTransferDtoList){
				riskCodes +=" '"+ utiCodeTransferDto.getOuterCode() +"' ,";
			}
			riskCodes = riskCodes.substring(0,riskCodes.length()-1);
			sql.append(" and p.riskCode in ( "+riskCodes+") ");
		}
		// 案件状态   （前台：""全部/"1"已处理/"0"未处理/   后台：0待处理 /2正在处理/3回退处理4已提交5不通过退回）
				sql.append(" and p.nodeStatus < '4' ");
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getHandlerCode())){
			sql.append(" and p.handlerCode = :handlerCode");
			map.put("handlerCode",requestQueryEndCaseDto.getHandlerCode());
		}
		sql.append(" order by p.flowInTime desc");
		Query dataQuery = entityManager.createQuery(sql.toString());
		this.setQueryParam(dataQuery,pageNo,pageSize,map);
		List<SwfLog> list = dataQuery.getResultList();



		StringBuilder countSql=sql.replace(7,8,"count(p)");
		Query countQuery = entityManager.createQuery(countSql.toString());
		this.setQueryParamForCount(countQuery,map);
		Object count =countQuery.getSingleResult();

		//Integer count=count2;







		List<ResponseQueryEndCaseDto> reponseList = new ArrayList<>();
		if (list.size()!=0) {
			for (SwfLog swfLog : list) {
				ResponseQueryEndCaseDto responseQueryEndCaseDto = new ResponseQueryEndCaseDto();
				//通过查询理算书表查找报案号
				//经常会在这里报空指针异常 , 要结案的单子一定是有理算书号的么
				String claimNo;
				String queryFlowId = swfLog.getFlowId();
				List<SwfLog> swfLogList=new ArrayList<>();

					swfLogList = swfLogDao.queryByClaim(queryFlowId);

				claimNo = swfLogList.get(0).getBusinessNo();
				responseQueryEndCaseDto.setClaimNo(claimNo);
				responseQueryEndCaseDto.setRegistNo(swfLog.getRegistNo());
				responseQueryEndCaseDto.setPolicyNo(swfLog.getPolicyNo());
				responseQueryEndCaseDto.setFlowInTime(swfLog.getFlowInTime());
				responseQueryEndCaseDto.setHandlerName(swfLog.getHandlerName());
				responseQueryEndCaseDto.setInsuredName(swfLog.getInsuredName());
				if (StringUtils.isNotEmpty(swfLog.getNodeStatus())) {
					if (Integer.parseInt(swfLog.getNodeStatus()) >= 4) {
						responseQueryEndCaseDto.setState("已处理");
					} else {
						responseQueryEndCaseDto.setState("未处理");
					}
				}
				responseQueryEndCaseDto.setRiskCode(swfLog.getRiskCode());
				//根据riskCode查询riskName
				String riskCName = prpDriskApi.translateCodeByPK(swfLog.getRiskCode());
				responseQueryEndCaseDto.setRiskCodeName(riskCName);
				reponseList.add(responseQueryEndCaseDto);
			}
		}
		QueryEndcaReturnDto queryEndcaReturnDto=new QueryEndcaReturnDto();
		queryEndcaReturnDto.setResponseQueryEndCaseDtoList(reponseList);
		queryEndcaReturnDto.setTotalCount((Long) count);
		return queryEndcaReturnDto;

	}


	public QueryEndcaReturnDto queryDeal(RequestQueryEndCaseDto requestQueryEndCaseDto) throws Exception {
		String nodeType="endca";//结案节点
		int pageNo = 1;
		int pageSize = 10;//todo 可以放入配置文件
		if(requestQueryEndCaseDto.getPageNo()!=null){
			pageNo = requestQueryEndCaseDto.getPageNo();
		}
		if(requestQueryEndCaseDto.getPageSize()!=null){
			pageSize = requestQueryEndCaseDto.getPageSize();
		}


		StringBuilder sql = new StringBuilder( "select p.* from (select m.* from SwfLog m where m.nodeType =:nodeType union all select pp.* from SwfLogstore pp where pp.nodeType =:nodeType) p where 1=1" );

        StringBuilder countSql = new StringBuilder("select count(1) from (select m.* from SwfLog m where m.nodeType =:nodeType union all select pp.* from SwfLogstore pp where pp.nodeType =:nodeType) p where 1=1");

		StringBuilder psql = new StringBuilder();
		Map<String,Object> map = new HashMap();
		map.put("nodeType",nodeType);
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getClaimNo())) {
		    psql.append("and p.claimNo like :claimNo");
		    map.put("claimNo",requestQueryEndCaseDto.getClaimNo()+"%");
        }
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getPolicyNo())){
			psql.append(" and p.policyNo like :policyNo");
			map.put("policyNo",requestQueryEndCaseDto.getPolicyNo()+"%");
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getRegistNo())){
			psql.append(" and p.registNo like :registNo");
			map.put("registNo",requestQueryEndCaseDto.getRegistNo()+"%");
		}
        if (StringUtils.isNotEmpty(requestQueryEndCaseDto.getInsuredName())){
			psql.append(" and p.insuredName like :insuredName");
            map.put("insuredName",requestQueryEndCaseDto.getInsuredName()+"%");
        }
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getFlowInStartDate())){
			psql.append(" and to_date(p.flowInTime,'YYYY-MM-DD HH24:mi:ss') >= to_date(:flowStartDate,'YYYY-MM-DD HH24:mi:ss') ");
			map.put("flowStartDate",requestQueryEndCaseDto.getFlowInStartDate());
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getFlowInEndDate())){
			psql.append(" and to_date(p.flowInTime,'YYYY-MM-DD HH24:mi:ss') <= to_date(:flowEndDate,'YYYY-MM-DD HH24:mi:ss') ");
			map.put("flowEndDate",requestQueryEndCaseDto.getFlowInEndDate());
		}

		psql.append(" and (p.handlerCode = :handlerCode or p.handlerCode = '' or p.handlerCode is null) ");
		map.put("handlerCode",requestQueryEndCaseDto.getUserCode());
		//根据险种大类riskType查询包含的险种riskCode
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getRiskClaimType())){
			String riskType = requestQueryEndCaseDto.getRiskClaimType();
			Map<String,String> riskTypeMap = new HashMap<>();
			riskTypeMap.put("riskType", riskType);
			List<UtiCodeTransferDto> utiCodeTransferDtoList = utiCodeTransferApi.queryByRiskType(riskTypeMap);
			String riskCodes = "";
			for(UtiCodeTransferDto utiCodeTransferDto:utiCodeTransferDtoList){
				riskCodes +=" '"+ utiCodeTransferDto.getOuterCode() +"' ,";
			}
			riskCodes = riskCodes.substring(0,riskCodes.length()-1);
			psql.append(" and p.riskCode in ( "+riskCodes+") ");
		} else {
			List<UtiCodeTransferDto> utiCodeTransferDtoList = new ArrayList<>();
			// 种植险
			Map<String,String> riskTypeHMap = new HashMap<>();
			riskTypeHMap.put("riskType", "H");
			List<UtiCodeTransferDto> utiCodeTransferDtoHList = utiCodeTransferApi.queryByRiskType(riskTypeHMap);
			// 养植险
			Map<String,String> riskTypeIMap = new HashMap<>();
			riskTypeIMap.put("riskType", "I");
			List<UtiCodeTransferDto> utiCodeTransferDtoIList = utiCodeTransferApi.queryByRiskType(riskTypeIMap);
			utiCodeTransferDtoList.addAll(utiCodeTransferDtoHList);
			utiCodeTransferDtoList.addAll(utiCodeTransferDtoIList);
			String riskCodes = "";
			for(UtiCodeTransferDto utiCodeTransferDto:utiCodeTransferDtoList){
				riskCodes +=" '"+ utiCodeTransferDto.getOuterCode() +"' ,";
			}
			riskCodes = riskCodes.substring(0,riskCodes.length()-1);
			psql.append(" and p.riskCode in ( "+riskCodes+") ");
		}
		// 案件状态   （前台：""全部/"1"已处理/"0"未处理/   后台：0待处理 /2正在处理/3回退处理4已提交5不通过退回）
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getState())){
			if("1".equals(requestQueryEndCaseDto.getState())){//
				psql.append(" and p.nodeStatus >= '4' ");
			}else if("0".equals(requestQueryEndCaseDto.getState())){
				psql.append(" and p.nodeStatus < '4' ");
			}
		}
		if(StringUtils.isNotEmpty(requestQueryEndCaseDto.getHandlerCode())){
			psql.append(" and p.handlerCode = :handlerCode");
			map.put("handlerCode",requestQueryEndCaseDto.getHandlerCode());
		}
        psql.append(" and p.systemFlag = 'agri' ");
        sql.append(psql);
        sql.append(" order by p.flowInTime desc ");

        Query dataQuery = entityManager.createNativeQuery(sql.toString(), SwfLog.class);
        this.setQueryParam(dataQuery,pageNo,pageSize,map);
		List<SwfLog> list = dataQuery.getResultList();


		Query countQuery=entityManager.createNativeQuery(countSql.toString()+psql.toString());
		this.setQueryParamForCount(countQuery,map);

		 Long count =new BigDecimal(countQuery.getSingleResult().toString()).longValue();




		List<ResponseQueryEndCaseDto> reponseList = new ArrayList<>();
		if (list.size()!=0) {
			for (SwfLog swfLog : list) {
				ResponseQueryEndCaseDto responseQueryEndCaseDto = new ResponseQueryEndCaseDto();
				//通过查询理算书表查找报案号
				//经常会在这里报空指针异常 , 要结案的单子一定是有理算书号的么
				String claimNo;
				String queryFlowId = swfLog.getFlowId();
				List<SwfLog> swfLogList=new ArrayList<>();
				List<SwfLogStore> swfLogList1=new ArrayList<>();



				swfLogList = swfLogDao.queryByClaim(queryFlowId);
				swfLogList1 = swfLogStoreDao.queryByClaim(queryFlowId);
				if (swfLogList.size()!=0) {
					claimNo = swfLogList.get(0).getBusinessNo();
				}
				else if (swfLogList1.size()!=0){
					claimNo = swfLogList1.get(0).getBusinessNo();
				}
				else{
					claimNo="";
				}
				responseQueryEndCaseDto.setClaimNo(claimNo);
				responseQueryEndCaseDto.setRegistNo(swfLog.getRegistNo());
				responseQueryEndCaseDto.setPolicyNo(swfLog.getPolicyNo());
				responseQueryEndCaseDto.setFlowInTime(swfLog.getFlowInTime());
				responseQueryEndCaseDto.setHandlerName(swfLog.getHandlerName());
				responseQueryEndCaseDto.setInsuredName(swfLog.getInsuredName());
				if (StringUtils.isNotEmpty(swfLog.getNodeStatus())) {
					if (Integer.parseInt(swfLog.getNodeStatus()) >= 4) {
						responseQueryEndCaseDto.setState("已处理");
					} else {
						responseQueryEndCaseDto.setState("未处理");
					}
				}
				responseQueryEndCaseDto.setRiskCode(swfLog.getRiskCode());
				//根据riskCode查询riskName
				String riskCName = prpDriskApi.translateCodeByPK(swfLog.getRiskCode());
				responseQueryEndCaseDto.setRiskCodeName(riskCName);
				reponseList.add(responseQueryEndCaseDto);
			}
		}
		QueryEndcaReturnDto queryEndcaReturnDto=new QueryEndcaReturnDto();
		queryEndcaReturnDto.setResponseQueryEndCaseDtoList(reponseList);
		queryEndcaReturnDto.setTotalCount((Long) count);
		return queryEndcaReturnDto;
	}
}