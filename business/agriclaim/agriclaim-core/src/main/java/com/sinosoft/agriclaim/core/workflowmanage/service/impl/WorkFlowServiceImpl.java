package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.workflowmanage.dao.*;
import com.sinosoft.agriclaim.core.workflowmanage.dao.specification.WorkFlowSpecBuilder;
import com.sinosoft.agriclaim.core.workflowmanage.entity.*;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 工作流服务类
 * @author 杨航
 * @date 2017年10月19日
 */
@Service
@Transactional
public class WorkFlowServiceImpl extends BaseServiceImpl implements WorkFlowService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkFlowServiceImpl.class);

	@Autowired
	private SwfFlowMainDao swfFlowMainDao;

	@Autowired
	private SwfLogDao swfLogDao;

	@Autowired
	private CompanyApi companyApi;

	@Autowired
	private BillNoApi billNoApi;

	@Autowired
	private RiskApi riskApi;

	@Autowired
	private SwfPathService swfPathService;

	@Autowired
	private SwfModelUseDao swfModelUseDao;

	@Autowired
	private SwfNodeDao swfNodeDao;

	@Autowired
	private SwfPathLogDao swfPathLogDao;

	@Autowired
	private SwfPathDao swfPathDao;

	@Autowired
	private SwfModelMainDao swfModelMainDao;

	@Autowired
	private SwfConditionDao swfConditionDao;

	@Autowired
	private SwfNotionDao swfNotionDao;

	@Autowired
	private SwfLogStoreDao swfLogStoreDao;
	@Autowired
	private PrpDuserApi prpDuserApi;
	@Autowired
	private PrpLRegistDao prpLRegistDao;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @description 创建工作流
	 * @author 杨航
	 * @date 2017年11月9日 下午3:15:45
	 * @param workFlowDto
	 *            工作流大对象
	 * @return flowID 工作流ID
	 */
	@Override
	public String createFlow(WorkFlowDto workFlowDto) {
		if (workFlowDto == null) {
			throw new DataVerifyException("WorkFlowServiceImpl.createFlow入参不合法!");
		}
		LOGGER.error("创建工作流方法开始调用");
		String flowID = "";
		if (workFlowDto.getCreateSwfFlowMainDto() != null) {
			// dto对象转数据对象
			SwfFlowMain swfFlowMain = convert(workFlowDto.getCreateSwfFlowMainDto(), SwfFlowMain.class);
			swfFlowMainDao.save(swfFlowMain);
			if (workFlowDto.getCreateSwfLogDto() != null) {
//				workFlowDto.getCreateSwfLogDto().setDeptName("北京分公司营业部");
				SwfLog swfLog = convert(workFlowDto.getCreateSwfLogDto(), SwfLog.class);
				//创建新的工作流节点时加入agri标识符,表示是新系统的单子
				swfLog.setSystemFlag("agri");
				swfLogDao.save(swfLog);
			} else {
				LOGGER.error("工作流节点对象为空!");
			}
		} else {
			LOGGER.error("工作流程对象为空!");
		}
		flowID = workFlowDto.getCreateSwfFlowMainDto().getFlowId();
		if (!StringUtils.isEmpty(flowID)) {
			LOGGER.error("创建工作流成功,流程ID为{}", flowID);
		}
		return flowID;
	}

	/**
	 * @description 获取模板号
	 * @author 杨航
	 * @date 2017年11月9日 下午3:16:54
	 * @param riskCode
	 *            险种
	 * @param comCode
	 *            机构代码
	 * @return modelNo 模板号
	 */
	@Override
	public int getModelNo(String riskCode, String comCode) {
		// 示例未完成
		int modelNo = -1;
		StringBuilder swfModelUseStr = new StringBuilder(
				"select s from SwfModelUse s where s.riskCode =:riskCode and s.comCode =:comCode"
						+ " and s.modelType = '01' ");
		Query query = entityManager.createQuery(swfModelUseStr.toString());
		query.setParameter("riskCode", riskCode);
		query.setParameter("comCode", comCode);
		List<SwfModelUse> modelUseList = query.getResultList();
		//查出来的是集合 凭什么用第一条作为当前模板 以什么为排序规则? ...看错了 还有一个modeType作为条件
		//种植险是2 养殖险是4 他们的swlmodeluse表对应的modelType都是01
		if (modelUseList != null && modelUseList.size() > 0) {
			modelNo = modelUseList.get(0).getModelNo();
		}
		return modelNo;
	}

	/**
	 * @description 检查工作流是否关闭
	 * @author 杨航
	 * @date 2017年11月9日 下午3:21:13
	 * @param flowID
	 *            工作流ID
	 * @return true:已经关闭，false:没有关闭
	 */
	@Override
	public boolean checkFlowClose(String flowID) {
		long count = swfFlowMainDao.count(WorkFlowSpecBuilder.checkFlowCloseSpecification(flowID));
		if (count > 0) {
			LOGGER.error("工作流号flowID={}当前处于关闭状态!", flowID);
			return true;
		}
		LOGGER.error("工作流号flowID={}当前处于未关闭状态!", flowID);
		return false;
	}

	/**
	 * @description 工作流提交节点
	 * @author 杨航
	 * @date 2017年11月9日 下午3:25:11
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void submitNode(WorkFlowDto workFlowDto) {
		LOGGER.error("工作流提交节点信息workFlowService.submitNode开始");
		if (workFlowDto == null) {
			LOGGER.error("提交工作流节点对象为空!");
		}
		// 插入工作流日志信息 依据我的理解 submitSwfLogDto是下一个新的节点的保存
		if (workFlowDto.getSubmitSwfLogDtoList() != null) {
			List<SwfLogDto> submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			List<SwfLog> submitSwfLogList = new ArrayList<>(submitSwfLogDtoList.size());
			convertCollection(submitSwfLogDtoList, submitSwfLogList, SwfLog.class);
			if (submitSwfLogList != null && submitSwfLogList.size() > 0) {
				PrpLRegist registNo=null;
				if(submitSwfLogList.get(0).getLossitemName()==null || submitSwfLogList.get(0).getLossitemName()==""){
					registNo = prpLRegistDao.findByRegistNo(submitSwfLogList.get(0).getRegistNo());
				}
				for (int i =0;i<submitSwfLogList.size();i++){
					//提交工作流 设置新的未处理节点的标识符为agri
					submitSwfLogList.get(i).setSystemFlag("agri");
					if(registNo!=null){
						submitSwfLogList.get(i).setLossitemName(registNo.getLossName());
					}
				}
				swfLogDao.save(submitSwfLogList);
			}
		}
		// 插入工作流路径日志信息
		if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
			List<SwfPathLogDto> submitSwfPathLogDtoList = workFlowDto.getSubmitSwfPathLogDtoList();
			List<SwfPathLog> submitSwfPathLogList = new ArrayList<>(submitSwfPathLogDtoList.size());
			convertCollection(submitSwfPathLogDtoList, submitSwfPathLogList, SwfPathLog.class);
			if (submitSwfPathLogList != null && submitSwfPathLogList.size() > 0) {
				swfPathLogDao.save(submitSwfPathLogList);
			}
		}
		LOGGER.error("工作流提交节点信息workFlowService.submitNode结束");
	}

	/**
	 * @description 工作流修改节点信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:30:47
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateNode(WorkFlowDto workFlowDto) {
		if (workFlowDto.getUpdateSwfLogDto() != null) {
			// 删除原有的数据
			SwfLogKey swfLogKey = new SwfLogKey();
			swfLogKey.setFlowId(workFlowDto.getUpdateSwfLogDto().getFlowId());
			swfLogKey.setLogNo(workFlowDto.getUpdateSwfLogDto().getLogNo());
			swfLogDao.delete(swfLogKey);
			// 插入新的数据 设置要更新的工作流的标识符为agri,新数据biaoshifu
			workFlowDto.getUpdateSwfLogDto().setSystemFlag("agri");
			swfLogDao.save(this.convert(workFlowDto.getUpdateSwfLogDto(), SwfLog.class));
		} else {
			LOGGER.error("WorkFlowServiceImpl.updateNode更新工作流节点异常！");
			throw new BusinessException("更新工作流节点异常！");
		}
		// 保存处理意见
		if (workFlowDto.getSwfNotionDtoList() != null && workFlowDto.getSwfNotionDtoList().size() > 0) {
			List<SwfNotion> swfNotionList = new ArrayList<>();
			this.convertCollection(workFlowDto.getSwfNotionDtoList(), swfNotionList, SwfNotion.class);
			for (SwfNotion entity : swfNotionList) {
				swfNotionDao.save(entity);
			}
		}
		return;
	}

	/**
	 * @description 初始化批量分配模板所需数据
	 * @author 杨航
	 * @date 2017年11月9日 下午6:14:18
	 * @param
	 * @return initSwfModelUseDto 初始化批量分配模板所需数据Dto
	 */
	@Override
	public InitSwfModelUseDto initSwfModelUseSave() throws Exception {
		InitSwfModelUseDto initSwfModelUseDto = new InitSwfModelUseDto();
		// 获取模板列表
		List<SwfModelMain> swfModelMainList = swfModelMainDao.findAll(
				Specifications.<SwfModelMain>and().eq("modelStatus", "1").build(),
				new Sort(Direction.ASC, new String[] { "modelNo" }));
		SwfModelMainDto swfModelMainDto = null;
		List<SwfModelMainDto> swfModelMainDtoList = new ArrayList<SwfModelMainDto>();
		// 将模板名称改成1-财产险模板的方式
		if (swfModelMainList != null && swfModelMainList.size() > 0) {
			for (SwfModelMain swfModelMain : swfModelMainList) {
				swfModelMainDto = this.convert(swfModelMain, SwfModelMainDto.class);
				swfModelMainDto.setModelName(swfModelMainDto.getModelNo() + "-" + swfModelMainDto.getModelName());
				swfModelMainDtoList.add(swfModelMainDto);
			}
		}
		initSwfModelUseDto.setSwfModelMainDtos(swfModelMainDtoList);
		// 获取险种列表
		RiskQueryConditionDto prpdriskDtoCon = new RiskQueryConditionDto();
		prpdriskDtoCon.setValidStatus("1");
		List<PrpDriskDto> prpdriskDtoList = riskApi.findRiskByCondition(prpdriskDtoCon);
		List<ResponseRiskAndCompanyDto> riskInfos = new ArrayList<>();
		// 将险种名称改成QAA-财产险的方式
		if (prpdriskDtoList != null && prpdriskDtoList.size() > 0) {
			for (PrpDriskDto prpdriskDto : prpdriskDtoList) {
				ResponseRiskAndCompanyDto responseRiskAndCompanyDto = new ResponseRiskAndCompanyDto();
				responseRiskAndCompanyDto.setCodecode(prpdriskDto.getRiskCode());
				responseRiskAndCompanyDto.setCodecname(prpdriskDto.getRiskCode() + "-" + prpdriskDto.getRiskCName());
				riskInfos.add(responseRiskAndCompanyDto);
			}
		}
		initSwfModelUseDto.setRiskInfos(riskInfos);
		// 获取部门列表
		List<PrpDcompanyDto> prpDcompanyDtoListNew = new ArrayList<PrpDcompanyDto>();
		List<PrpDcompanyDto> prpDcompanyDtoList = companyApi.querySwfAllCompany();
		List<ResponseRiskAndCompanyDto> companyInfos = new ArrayList<>();
		// 将单位名称改成00000000-总公司的方式
		if (prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0) {
			for (PrpDcompanyDto prpDcompanyDto : prpDcompanyDtoList) {
				ResponseRiskAndCompanyDto responseRiskAndCompanyDto = new ResponseRiskAndCompanyDto();
				responseRiskAndCompanyDto.setCodecode(prpDcompanyDto.getComCode());
				responseRiskAndCompanyDto.setCodecname(prpDcompanyDto.getComCode() + "-" + prpDcompanyDto.getComCName());
				companyInfos.add(responseRiskAndCompanyDto);
			}
		}
		initSwfModelUseDto.setCompanyInfos(companyInfos);
		return initSwfModelUseDto;
	}

	/**
	 * @description 工作流模板批量分配
	 * @author 杨航
	 * @date 2017年11月9日 下午6:16:20
	 * @param swfModelUseSaveDto
	 *            批量分配模板入参
	 * @return entity
	 */
	@Override
	public Map<String, String> saveSwfModelUse(SwfModelUseSaveDto swfModelUseSaveDto) {
		// 初始化模板分配所需数据
		List<SwfModelUseDto> swfModelUseDtoList = initSwfModelUse(swfModelUseSaveDto);
		if (swfModelUseDtoList != null && swfModelUseDtoList.size() > 0) {
			Integer modelNo = swfModelUseDtoList.get(0).getModelNo();
			SwfModelMainKey swfModelMainKey = new SwfModelMainKey();
			swfModelMainKey.setModelNo(modelNo);
			SwfModelMain swfModelMain = swfModelMainDao.findOne(swfModelMainKey);
			String modelType = "";
			if (swfModelMain != null) {
				// 获取模板类型
				modelType = swfModelMain.getModelType();
			} else {
				if (LOGGER.isErrorEnabled()) {
					LOGGER.error("WorkFlowServiceImpl.swfModelUseSave>>>没有对应的模板号为modelNo={}对应的模板", modelNo);
				}
				throw new BusinessException("没有对应的模板");
			}
			SwfModelUse entity = null;
			for (SwfModelUseDto swfModelUseDto : swfModelUseDtoList) {
				List<SwfModelUse> swfModelUseList = swfModelUseDao.findAll(Specifications.<SwfModelUse>and()
						.eq(StringUtils.isNotEmpty(swfModelUseDto.getRiskCode()), "riskCode",
								swfModelUseDto.getRiskCode())
						.eq(StringUtils.isNotEmpty(swfModelUseDto.getComCode()), "comCode", swfModelUseDto.getComCode())
						.eq(StringUtils.isNotEmpty(swfModelUseDto.getModelType()), "modelType",
								swfModelUseDto.getModelType())
						.build());
				// 删除原有的公司对应的模板
				if (swfModelUseList != null && swfModelUseList.size() > 0) {
					for (SwfModelUse swfModelUse : swfModelUseList) {
						Integer modelNoOld = swfModelUse.getModelNo();
						entity = new SwfModelUse();
						entity.setModelNo(modelNoOld);
						entity.setRiskCode(swfModelUseDto.getRiskCode());
						entity.setComCode(swfModelUseDto.getComCode());
						entity.setModelType(modelType);
						swfModelUseDao.delete(entity);
					}
				}
				// 保存分配的新模板
				entity = new SwfModelUse();
				entity.setModelNo(modelNo);
				entity.setRiskCode(swfModelUseDto.getRiskCode());
				entity.setComCode(swfModelUseDto.getComCode());
				entity.setModelType(modelType);
				entity.setModelStatus(swfModelUseDto.getModelStatus());
				swfModelUseDao.save(entity);
			}

		}
		// 设置返回信息
		Map<String, String> result = new HashMap<String, String>();
		result.put("message", "模板分配成功！");
		return result;
	}

	/**
	 * @description 准备批量分配模板所需的SwfModelUseDto集合
	 * @author 杨航
	 * @date 2017年11月9日 下午6:17:33
	 * @param swfModelUseSaveDto
	 *            批量分配模板入参Dto
	 * @return swfModelUseDtoList 模板对象集合
	 */
	private List<SwfModelUseDto> initSwfModelUse(SwfModelUseSaveDto swfModelUseSaveDto) {
		if (swfModelUseSaveDto == null) {
			LOGGER.error("swfModelUseSaveDto对象不允许为null");
		} else {
			LOGGER.error("modelNo={},riskCodes.size={},comCodes.size={},modeStatus={}", swfModelUseSaveDto.getModelNo(),
					swfModelUseSaveDto.getRiskCodes().size(), swfModelUseSaveDto.getComCodes().size(),
					swfModelUseSaveDto.getModelStatus());
		}
		List<SwfModelUseDto> swfModelUseDtoList = new ArrayList<SwfModelUseDto>();
		SwfModelUseDto swfModelUseDto = null;
		Integer modelNo = swfModelUseSaveDto.getModelNo();
		String modelStatus = swfModelUseSaveDto.getModelStatus();
		List<String> riskCodes = swfModelUseSaveDto.getRiskCodes();
		List<String> comCodes = swfModelUseSaveDto.getComCodes();
		if (riskCodes != null && riskCodes.size() > 0 && comCodes != null && comCodes.size() > 0) {
			for (int i = 0; i < riskCodes.size(); i++) {
				for (int j = 0; j < comCodes.size(); j++) {
					swfModelUseDto = new SwfModelUseDto();
					swfModelUseDto.setModelNo(modelNo);
					swfModelUseDto.setRiskCode(riskCodes.get(i));
					swfModelUseDto.setComCode(comCodes.get(j));
					swfModelUseDto.setModelStatus(modelStatus);
					swfModelUseDto.setModelType("01");
					swfModelUseDtoList.add(swfModelUseDto);
				}
			}
		}
		return swfModelUseDtoList;
	}

	/**
	 * @description 工作流模板路径列表
	 * @author 杨航
	 * @date 2017年11月9日 下午6:19:34
	 * @param modelNo
	 *            模板号
	 * @return workFlowModelDto 工作流模板路径列表所需Dto
	 */
	@Override
	public WorkFlowModelDto initSwfModelPath(Integer modelNo) {
		LOGGER.error("初始化工作流模板路径列表开始");
		if (modelNo == null || modelNo <= 0) {
			LOGGER.error("WorkFlowServiceImpl.initSwfModelPath的入参modelNo的值不允许为空或小于0");
			throw new BusinessException("模板号的值不允许为空或小于0");
		}
		WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();
		// 查询模板主表信息
		SwfModelMainKey swfModelMainKey = new SwfModelMainKey();
		swfModelMainKey.setModelNo(modelNo);
		SwfModelMain swfModelMain = swfModelMainDao.findOne(swfModelMainKey);
		workFlowModelDto.setSwfModelMainDto(this.convert(swfModelMain, SwfModelMainDto.class));
		// 查询工作流节点信息
		List<SwfNode> swfNodeList = swfNodeDao.findAll(Specifications.<SwfNode>and().eq("modelNo", modelNo).build(),
				new Sort(Direction.ASC, "modelNo"));
		List<SwfNodeDto> swfNodeDtoList = new ArrayList<SwfNodeDto>();
		this.convertCollection(swfNodeList, swfNodeDtoList, SwfNodeDto.class);
		workFlowModelDto.setSwfNodeDtoList(swfNodeDtoList);
		// 工作流路径信息
		List<SwfPath> swfPathList = swfPathDao.findAll(Specifications.<SwfPath>and().eq("modelNo", modelNo).build(),
				new Sort(Direction.ASC, "modelNo"));
		List<SwfPathDto> swfPathDtoList = new ArrayList<SwfPathDto>();
		this.convertCollection(swfPathList, swfPathDtoList, SwfPathDto.class);
		workFlowModelDto.setSwfPathDtoList(swfPathDtoList);
		// 工作流条件信息
		List<SwfCondition> swfConditionList = swfConditionDao.findAll(
				Specifications.<SwfCondition>and().eq("modelNo", modelNo).build(), new Sort(Direction.ASC, "modelNo"));
		List<SwfConditionDto> swfConditionDtoList = new ArrayList<SwfConditionDto>();
		this.convertCollection(swfConditionList, swfConditionDtoList, SwfConditionDto.class);
		workFlowModelDto.setSwfConditionDtoList(swfConditionDtoList);
		return workFlowModelDto;
	}

	/**
	 * @description 工作流路径条件维护页面初始化
	 * @author 杨航
	 * @date 2017年11月9日 下午6:20:41
	 * @param modelNo
	 *            模板号
	 * @param pathNo
	 *            路径号
	 * @param pathName
	 *            路径名称
	 * @return initSwfConditionsDto 工作流路径条件维护页面初始化Dto
	 */
	@Override
	public InitSwfConditionsDto initSwfConditions(Integer modelNo, Integer pathNo, String pathName) {
		if (modelNo == null || modelNo <= 0 || pathNo == null || pathNo <= 0) {
			LOGGER.error("WorkFlowServiceImpl.initSwfConditions的入参不合法");
			throw new BusinessException("模板号或路径号不合法");
		}
		LOGGER.error("WorkFlowServiceImpl.initSwfConditions开始调用。modelNo={},pathNo={},pathName={}", modelNo, pathNo,
				pathName);
		InitSwfConditionsDto initSwfConditionsDto = new InitSwfConditionsDto();
		initSwfConditionsDto.setModelNo(modelNo);
		initSwfConditionsDto.setPathNo(pathNo);
		initSwfConditionsDto.setPathName(pathName);
		List<SwfCondition> swfConditionList = swfConditionDao.findAll(
				Specifications.<SwfCondition>and().eq("modelNo", modelNo).eq("pathNo", pathNo).build(),
				new Sort(Direction.ASC, "pathNo"));
		List<SwfConditionDto> swfConditionDtoList = new ArrayList<SwfConditionDto>();
		this.convertCollection(swfConditionList, swfConditionDtoList, SwfConditionDto.class);
		initSwfConditionsDto.setSwfConditionDtoList(swfConditionDtoList);
		return initSwfConditionsDto;
	}

	/**
	 * @description 初始化新建模板信息
	 * @author 杨航
	 * @date 2017年11月23日 下午4:42:51
	 * @return workFlowModelDto 初始化模板信息
	 */
	public WorkFlowModelDto initWorkFlowModel() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("初始化创建模板信息开始！");
		}
		// 初始化模板主信息
		SwfModelMainDto swfModelMainDto = new SwfModelMainDto();
		swfModelMainDto.setModelNo(this.getNewModelNo());
		swfModelMainDto.setCreateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		swfModelMainDto.setModifyDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();
		workFlowModelDto.setSwfModelMainDto(swfModelMainDto);
		return workFlowModelDto;
	}

	/**
	 * @description 获取新的模板编号
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param
	 * @return modelNo 模板号
	 */
	public int getNewModelNo() {
		StringBuffer statement = new StringBuffer();
		statement.append("select max(modelNo) from SwfModelMain");
		Query query = entityManager.createQuery(statement.toString());
		int maxModelNo = -1;
		if (query.getSingleResult() != null) {
			maxModelNo = (int) query.getSingleResult();
			return maxModelNo + 1;
		}
		// 没有模板号则返回1
		return 1;
	}

	/**
	 * @description 按条件查询工作流模板主表信息
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param swfModelMainDto
	 *            工作模板条件对象
	 * @return pageInfo 工作流模板Dto集合
	 */
	@Override
	public PageInfo<SwfModelMainDto> querySwfModelMainByCondition(SwfModelMainDto swfModelMainDto) throws Exception {
		// 请求参数不为空校验，以及页码校验
		if (swfModelMainDto == null) {
			throw new DataVerifyException("请求参数不能为空！");
		}
		if (swfModelMainDto.getPageNo() < 1) {
			throw new DataVerifyException("查询页码不能小于1！");
		}
		if (swfModelMainDto.getPageSize() < 1) {
			throw new DataVerifyException("查询每页数量不能小于1！");
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("查询工作流列表服务开始");
		}
		PageInfo<SwfModelMainDto> pageInfo = new PageInfo<>();
		Integer pageNo = swfModelMainDto.getPageNo();
		Integer pageSize = swfModelMainDto.getPageSize();
		Long totalSizeStrLon;
		StringBuffer sql = new StringBuffer("select w from SwfModelMain w where 1=1 ");
		StringBuffer sqlCount = new StringBuffer("select count(w) from SwfModelMain w where 1=1 ");
		StringBuffer conditions = new StringBuffer();
		String createDate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotEmpty(swfModelMainDto.getModelStatus())){
			conditions.append("and w.modelStatus='").append(swfModelMainDto.getModelStatus()).append("' ");
		}
		if(swfModelMainDto.getModelNo() != null){
			conditions.append("and w.modelNo='").append(swfModelMainDto.getModelNo()).append("' ");
		}
		if(StringUtils.isNotEmpty(swfModelMainDto.getAuthorCode())){
			List<String> usernames = prpDuserApi.queryByUserName(swfModelMainDto.getAuthorCode());
			StringBuffer username = new StringBuffer("");
			if(usernames!=null && usernames.size()>0) {
				for (int i = 0; i < usernames.size(); i++) {
					username.append(usernames.get(i)).append("','");
				}
				conditions.append("and w.authorCode in('").append(username).append("') ");
			}
		}
		if(StringUtils.isNotEmpty(swfModelMainDto.getModelName())){
			conditions.append("and w.modelName='").append(swfModelMainDto.getModelName()).append("' ");
		}
		if(swfModelMainDto.getCreateDate() != null){
			createDate = dateFormat.format(swfModelMainDto.getCreateDate());
			conditions.append("and w.createDate=to_date('").append(createDate).append("','yyyy-MM-dd') ");
		}
		sql.append(conditions);
		sqlCount.append(conditions);
		Query agentQuery = entityManager.createQuery(sql.toString());
		Query agentQueryCount = entityManager.createQuery(sqlCount.toString());
		totalSizeStrLon = new BigInteger(agentQueryCount.getSingleResult().toString()).longValue();
		if (pageNo != null) {
			agentQuery.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
		}
		if (pageSize != null) {
			agentQuery.setMaxResults(pageSize.intValue());
		}
		List<SwfModelMain> swfModelMainList = agentQuery.getResultList();
		List<SwfModelMainDto> swfModelMainDtoList = new ArrayList<>();
		this.convertCollection(swfModelMainList,swfModelMainDtoList,SwfModelMainDto.class);
		PrpDuserDto prpDuserDto;
		for(int i=0;i<swfModelMainDtoList.size();i++){
			if(StringUtils.isNotEmpty(swfModelMainDtoList.get(i).getAuthorCode())){
				prpDuserDto = prpDuserApi.queryByPK(swfModelMainDtoList.get(i).getAuthorCode());
				if(StringUtils.isNotEmpty(prpDuserDto.getUserName())){
					swfModelMainDtoList.get(i).setAuthorName(prpDuserDto.getUserName());
				}
			}
		}
		// 数据存放dto集合
		pageInfo.setContent(swfModelMainDtoList);
		// 当前页数
		pageInfo.setPages(pageNo);
		// 总记录数
		pageInfo.setTotalCount(totalSizeStrLon);
		return pageInfo;
	}

	/**
	 * @description 新建工作流模板
	 * @author 杨航
	 * @date 2017年11月17日 下午2:43:23
	 * @param workFlowModelDto
	 *            创建工作流模板所需对象
	 * @return result 返回信息
	 */
	@Override
	public Map<String, String> saveWorkFlowModelInfo(WorkFlowModelDto workFlowModelDto) {
		if (workFlowModelDto == null) {
			throw new DataVerifyException("新建工作流模板入参不合法！");
		}
		Integer modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.error("开始保存模板号为{}的模板信息！", modelNo);
		}
		// 删除原有的数据
		swfPathDao.deleteByModelNo(modelNo);
		swfNodeDao.deleteByModelNo(modelNo);
		// 如果已有分配数据，当模板不可用的要删除已分配数据
		if ("1".equals(workFlowModelDto.getSwfModelMainDto().getModelStatus())) {
			swfModelUseDao.deleteByModelNoAndModelStatus(modelNo,
					workFlowModelDto.getSwfModelMainDto().getModelStatus());
		}
		// 如果有当前的模板号修改，没有的话则删除，但都是save方法
		SwfModelMain swfModelMain = this.convert(workFlowModelDto.getSwfModelMainDto(), SwfModelMain.class);
		swfModelMainDao.save(swfModelMain);
		// 定义底层类集合
		List<SwfNode> swfNodeList = new ArrayList<>();
		List<SwfPath> swfPathList = new ArrayList<>();
		this.convertCollection(workFlowModelDto.getSwfNodeDtoList(), swfNodeList, SwfNode.class);
		this.convertCollection(workFlowModelDto.getSwfPathDtoList(), swfPathList, SwfPath.class);
		// 保存节点信息
		swfNodeDao.save(swfNodeList);
		// 保存路径信息
		swfPathDao.save(swfPathList);
		Map<String, String> result = new HashMap<>();
		result.put("message", "保存新创建的模板成功！");
		return result;
	}

	/**
	 * @description 工作流处理流程主过程
	 * @author 杨航
	 * @date 2017年12月14日 下午3:57:18
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deal(WorkFlowDto workFlowDto) throws Exception {
		// 创建工作流 (保存工作流主表 和新的工作流节点 只有第一个节点(报案才会调用创建新的工作流))
		if (workFlowDto.isCreate()) {
			createFlow(workFlowDto);
		}
		// 重开工作流程
		if (workFlowDto.isReOpen()) {
			reOpenFlow(workFlowDto);
		}
		// 提交-工作流 (先提交-工作流 即保存新增的未处理节点(并且保存相应的swfPathLog数据)，后修改设置当前节点的状态为已处理)
		if (workFlowDto.isSubmit()) {
			submitNode(workFlowDto);
		}
		// 判断是不是释放所有占号的操作(放弃任务应该走的是这里(重置处理人为null,flowStatus由2变1) 但是里面flowStatus = '2' 是什么意思)
		if (workFlowDto.isFreeHoldNode()) {
			freeAllHoldNode(workFlowDto);
		}
		// 修改工作流
		if (workFlowDto.isUpdate()) {
			updateNode(workFlowDto);
		}
		// 关闭-工作流 (包括转储 例如结案:设置所有节点的flowStatus为0 并且更新工作流主表的状态位,删除swflog表中的数据,保存到swflogstore中)
		if (workFlowDto.isClose()) {
			closeAndStoreFlow(workFlowDto);
		}
		// 收回-工作流
		if (workFlowDto.isRecycle()) {
			recycleFlow(workFlowDto);
		}
	}

	/**
	 * @description 重开工作流
	 * @author 王志文
	 * @date 2017年12月14日 下午4:14:22
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void reOpenFlow(WorkFlowDto workFlowDto) {
		if (workFlowDto.getReOpenSwfFlowMainDto() != null) {
			// 1.变更工作流主表的状态位置
			SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
			swfFlowMainKey.setFlowId(workFlowDto.getReOpenSwfFlowMainDto().getFlowId());
			swfFlowMainDao.delete(swfFlowMainKey);
			workFlowDto.getReOpenSwfFlowMainDto().setStoreFlag("0");
			swfFlowMainDao.save(this.convert(workFlowDto.getReOpenSwfFlowMainDto(), SwfFlowMain.class));
			// 2.从转储表取数据并存入Swflog表
			List<SwfLogStore> swfLogStoreList = swfLogStoreDao
					.querySwfLogStoresByFlowId(workFlowDto.getReOpenSwfFlowMainDto().getFlowId());
			for (SwfLogStore swfLogStore : swfLogStoreList) {
				swfLogStore.setFlowStatus("1");
				swfLogStore.setSystemFlag("agri");
				swfLogDao.save(this.convert(swfLogStore, SwfLog.class));
			}
			// 3.删除转储表数据
			swfLogStoreDao.deleteByFlowId(workFlowDto.getReOpenSwfFlowMainDto().getFlowId());
		}
	}

	/**
	 * @description 释放用户的占号信息
	 * @author 王志文
	 * @date 2017年12月14日 下午4:32:35
	 * @param workFlowDto
	 * @return 工作流大对象
	 */
	@Override
	public void freeAllHoldNode(WorkFlowDto workFlowDto) {
		if (workFlowDto.getUpdateSwfLogDto() != null) {
			// 原生sql
			StringBuilder swfLogStr = new StringBuilder("update SwfLog set handlerCode = null,handlerName = null,"
					+ " flowStatus='1' Where (nodeStatus = '0' and handlerCode =:handlerCode and flowStatus = '2' ");
			Query query = entityManager.createNativeQuery(swfLogStr.toString());
			query.setParameter("handlerCode", workFlowDto.getUpdateSwfLogDto().getHandlerCode());
			query.executeUpdate();
		}
	}

	/**
	 * @description 回收工作流
	 * @author: 王志文
	 * @date: 2017/11/20 8:54
	 * @param workFlowDto
	 *            工作流Dto
	 * @throws Exception
	 */
	@Override
	public void recycleFlow(WorkFlowDto workFlowDto) {
		String flowID = workFlowDto.getUpdateSwfLogDto().getFlowId();
		int logNo = workFlowDto.getUpdateSwfLogDto().getLogNo();
		SwfLogKey swfLogKey = new SwfLogKey();
		swfLogKey.setFlowId(flowID);
		swfLogKey.setLogNo(logNo);
		SwfLogDto swfLogDto = this.convert(swfLogDao.findOne(swfLogKey), SwfLogDto.class);
		// 原生sql
		StringBuilder stringBuilder = new StringBuilder("select s from SwfLog s where s.flowId =:flowId and ("
				+ " s.logNo in (select endNodeNo from SwfPathLog where flowId =:flowID and startNodeNo =:logNo ))");
		Query query = entityManager.createNativeQuery(stringBuilder.toString());
		query.setParameter("flowId", flowID);
		query.setParameter("flowID", flowID);
		query.setParameter("logNo", logNo);
		List<SwfLog> swfLogList = query.getResultList();// todo
		if (swfLogList.size() == 0) {
			throw new BusinessException("没有下级节点，不能收回！");
		}
		stringBuilder.append(" and nodeStatus!='0'");
		Query query1 = entityManager.createNativeQuery(stringBuilder.toString());
		query1.setParameter("flowId", flowID);
		query1.setParameter("flowID", flowID);
		query1.setParameter("logNo", logNo);
		swfLogList = query.getResultList();
		if (swfLogList.size() > 0) {
			throw new BusinessException("下一节点正在处理，不能收回！");
		}
		// 增加判断单证的过程
		if (swfLogDto.getNodeType().equals("certi")) {
			// 如果是单证模式，需要检查是否已出计算书，如果出了，则不能进行回收操作
			// 原生sql
			StringBuilder stringBuilder1 = new StringBuilder(
					"select s from SwfLog s where s.flowId =:flowId and s.nodeType ='compp'");
			Query query2 = entityManager.createNativeQuery(stringBuilder1.toString());
			List<SwfLog> swfLogList1 = query2.getResultList();
			if (swfLogList1.size() > 0) {
				throw new BusinessException("已出赔款计算书，不能收回！");
			}
		}
		// 原生sql
		StringBuilder stringBuilder2 = new StringBuilder("delete from SwfLog s where s.flowId =:flowId and ("
				+ " s.logNo in (select endNodeNo from SwfPathLog where flowId =:flowID and startNodeNo =:logNo ))");
		Query query3 = entityManager.createNativeQuery(stringBuilder2.toString());
		query3.setParameter("flowId", flowID);
		query3.setParameter("flowID", flowID);
		query3.setParameter("logNo", logNo);
		// 原生sql
		StringBuilder swfPathLogStr = new StringBuilder(
				"delete from SwfPathLog where flowId =:flowId and startNodeNo =:logNo");
		Query query2 = entityManager.createNativeQuery(swfPathLogStr.toString());
		query2.setParameter("flowId", flowID);
		query2.setParameter("logNo", logNo);
		query2.executeUpdate();
		// 原生sql
		StringBuilder swfLogStr = new StringBuilder(
				" update SwfLog set nodeStatus='2' where flowId =:flowId and logNo =:logNo");
		Query query4 = entityManager.createNativeQuery(swfLogStr.toString());
		query4.setParameter("flowId", flowID);
		query4.setParameter("logNo", logNo);
		query4.executeUpdate();
		// 更新表PrpLclaimStatus
		// 原生sql
		StringBuilder prpLClaimStatusStr = new StringBuilder(
				"update PrpLClaimStatus set Status='2' where nodeType =:nodeType and businessNo=:businessNo");
		Query query5 = entityManager.createNativeQuery(prpLClaimStatusStr.toString());
		query5.setParameter("nodeType", swfLogDto.getNodeType());
		query5.setParameter("businessNo", swfLogDto.getBusinessNo());
		query5.executeUpdate();
	}

	/**
	 * @description 关闭并转储工作流
	 * @author 杨航
	 * @date 2017年11月9日 下午3:34:38
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void closeAndStoreFlow(WorkFlowDto workFlowDto) throws Exception {
		if (workFlowDto.getCloseSwfFlowMainDto() != null) {
			String flowId = workFlowDto.getCloseSwfFlowMainDto().getFlowId();
			// 数据转储 (设置每一个节点的flowStatus为0 并且保存进swflogStore表中)
			storeFlow(workFlowDto);
			// 变更工作流主表状态(设置工作流状态flowStatus为0,设置转储标志为1)
			SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
			swfFlowMainKey.setFlowId(flowId);
			SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
			swfFlowMain.setFlowStatus("0");
			swfFlowMain.setStoreFlag("1");
			swfFlowMainDao.save(swfFlowMain);
			// 删除原有的工作流数据 (先保存再删除)
			swfLogDao.deleteByFlowId(flowId);
		} else {
			LOGGER.error("WorkFlowServiceImpl.closeAndStoreFlow入参不合法!");
			throw new BusinessException("关闭并转储工作流入参不合法!");
		}
		return;
	}

	/**
	 * @description 备份工作流的数据
	 * @author 杨航
	 * @date 2017年11月9日 下午6:13:03
	 * @param workFlowDto
	 *            工作流大对象
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	private void storeFlow(WorkFlowDto workFlowDto) throws Exception {
		if (workFlowDto.getCloseSwfFlowMainDto() != null) {
			String flowID = workFlowDto.getCloseSwfFlowMainDto().getFlowId();
			List<SwfLog> swfLogList = swfLogDao.querySwfLogsByFlowId(flowID);

			List<SwfLogStore> swfLogStoreList = new ArrayList<SwfLogStore>();
			for (SwfLog swfLog : swfLogList) {
				SwfLogDto swfLogDto = this.convert(swfLog, SwfLogDto.class);
				// reason:存储表里的flowstatus的数据应该为0的。。。
				swfLogDto.setFlowStatus("0");
				// 并且理算节点也应该为提交的状态
				if (swfLogDto.getTaskType().equals("M")) {
					swfLogDto.setNodeStatus("4");
				}
				SwfLogStoreDto swfLogStoreDto = new SwfLogStoreDto();
				PropertyUtils.copyProperties(swfLogStoreDto, swfLogDto);
				swfLogStoreList.add(this.convert(swfLogStoreDto, SwfLogStore.class));
			}
			for (SwfLogStore s : swfLogStoreList) {
				swfLogStoreDao.save(s);
			}
		}
	}

	/**
	 * @description 按报案号删除所有工作流
	 * @author: 王志文
	 * @date: 2017/11/18 18:44
	 * @param registNo
	 *            报案号
	 * @throws Exception
	 */
	@Override
	public void deleteByRegistNo(String registNo) {
		// 删除记录
		String flowId = "";
		List<SwfLog> swfLogList = swfLogDao.querySwfLogsByWorkFlowConditions(registNo);
		for (SwfLog swfLog : swfLogList) {
			flowId = this.convert(swfLog, SwfLogDto.class).getFlowId();
		}
		if (StringUtils.isNotEmpty(flowId)) {
			swfPathLogDao.deleteSwfPathLogsByFlowId(flowId);
			swfLogDao.deleteByFlowId(flowId);
			SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
			swfFlowMainKey.setFlowId(flowId);
			swfFlowMainDao.delete(swfFlowMainKey);
		}
	}


	/**
	 * @description 关闭工作流
	 * @author: 王志文
	 * @date: 2017/11/20 8:55
	 * @param workFlowDto
	 *            工作流Dto
	 * @throws Exception
	 */
	@Override
	public void closeFlow(WorkFlowDto workFlowDto) {
		// 1.变更工作流主表的状态位置
		if (workFlowDto.getCloseSwfFlowMainDto() != null) {
			SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
			swfFlowMainKey.setFlowId(workFlowDto.getCloseSwfFlowMainDto().getFlowId());
			swfFlowMainDao.delete(swfFlowMainKey);
			swfFlowMainDao.save(this.convert(workFlowDto.getCloseSwfFlowMainDto(), SwfFlowMain.class));
			// 原生sql
			StringBuilder swfLogStr = new StringBuilder(
					"update SwfLog set nodeStatus='4' where flowId=:flowId and (taskType='M') ");
			Query query = entityManager.createNativeQuery(swfLogStr.toString());
			query.setParameter("flowId", workFlowDto.getCloseSwfFlowMainDto().getFlowId());
			query.executeUpdate();
			StringBuilder swfLogUpdateStr = new StringBuilder(
					" update SwfLog set flowStatus='0' where flowId=:flowId ");
			Query query1 = entityManager.createNativeQuery(swfLogUpdateStr.toString());
			query1.setParameter("flowId", workFlowDto.getCloseSwfFlowMainDto().getFlowId());
			query1.executeUpdate();
		}
		return;
	}

	/**
	 * @description 根据保单号查询工作流主表信息
	 * @author 杨航
	 * @date 2017年11月9日 下午3:02:46
	 * @param policyNo
	 *            保单号
	 * @return swfFlowMainDtoList 工作流主表信息集合
	 */
	@Override
	public List<SwfFlowMainDto> querySwfFlowMainByPolicyNo(String policyNo) {
		List<SwfFlowMain> swfFlowMainList = swfFlowMainDao
				.findAll(Specifications.<SwfFlowMain>and().eq("policyNo", policyNo).build());
		List<SwfFlowMainDto> swfFlowMainDtoList = new ArrayList<>();
		this.convertCollection(swfFlowMainList, swfFlowMainDtoList, SwfFlowMainDto.class);
		return swfFlowMainDtoList;
	}

	/**
	 * @description 对工作流进行占号操作
	 * @author 杨航
	 * @date 2017年12月14日 下午8:07:54
	 * @param flowID
	 *            流程代码
	 * @param logNo
	 *            节点代码
	 * @param userCode
	 *            用户代码
	 * @param userName
	 *            用户名称
	 * @return swfLogDto 工作流对象
	 */
	@Override
	public SwfLogDto holdNode(String flowID, int logNo, String userCode, String userName) {
		/* 占号操作 (默认是没有占号，没有获得分配权) */
		String retHold = "false";
		SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(flowID, logNo));
		if ("2".equals(swfLog.getFlowStatus())) {
			/* 如果工作流已经被占用了，检查是不是同一个人 */
			if (swfLog.getHandlerCode().equals(userCode)) {
				retHold = "true";
			}
			if ("".equals(userCode)) {
				retHold = "true";
			}
		} else {
			/* 没有分配的情况下，独占该工作节点 */
			if (!userCode.equals(swfLog.getHandlerCode())) {
				/* 如果不是指定人的，就占号，如果是指定人的，不改变flowStatus,保持1的状态 */
				swfLog.setFlowStatus("2");
			}
			swfLog.setHandlerCode(userCode);
			swfLog.setHandlerName(userName);
			swfLog.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());

			WorkFlowDto workFlowDto = new WorkFlowDto();
			workFlowDto.setFreeHoldNode(true);
			workFlowDto.setUpdate(true);
			if (workFlowDto.isFreeHoldNode()) {
				swfLogDao.freeAllHoldNode(swfLog.getHandlerCode());
			}
			/* 修改工作流 */
			if (workFlowDto.isUpdate()) {
				swfLogDao.save(swfLog);
			}
			/* 再次判断是不是本人占用的 */
			swfLog = findHoldNode(flowID, logNo, userCode);
			retHold = swfLog.getFlag();
		}
		swfLog.setFlag(retHold);
		return this.convert(swfLog, SwfLogDto.class);
	}

	/**
	 * @description:方法功能简述: 根据流程号和节点判断用户是否具有独占操作
	 * @author 杨航
	 * @date 2017年12月7日下午11:38:00
	 * @param flowID
	 * @param logNo
	 * @param userCode
	 * @return
	 */
	private SwfLog findHoldNode(String flowID, int logNo, String userCode) {
		String holdNodeflag = "false";
		SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(flowID, logNo));
		if (swfLog.getHandlerCode().equals(userCode)) {
			holdNodeflag = "true";
		}
		swfLog.setFlag(holdNodeflag);
		return swfLog;
	}

	/**
	 * 校验工作流DTO是不是合法可以处理的dto
	 * @author 杨昆
	 * @param workFlowDto
	 *            工作流对象
	 * @throws Exception
	 * @return boolean true-合法，false-不合法
	 */
	public boolean checkDealDto(WorkFlowDto workFlowDto) {
		boolean result = false;
		if ((workFlowDto.isCreate()) || (workFlowDto.isUpdate()) || (workFlowDto.isSubmit())
				|| (workFlowDto.isClose())) {
			result = true;
		}
		return result;
	}

	/**
	 * @description 第一部分：工作引擎正向/逆向操作
	 * @author yanlei
	 * @param swfLogTransferDto 工作流中转对象
	 * @return
	 */
	@Override
	public WorkFlowDto viewToDto(SwfLogTransferDto swfLogTransferDto) {
		//取得当前用户信息，写操作员信息到Dto中
		WorkFlowDto workFlowDto = new WorkFlowDto();
		WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
		SwfLogDto swfLogDto = null;
		List<SwfLogDto> swfFlowNodeList = new ArrayList<SwfLogDto>();
		List<SwfLogDto> submitLogList = new ArrayList<SwfLogDto>();
		List<SwfPathLogDto> submitPathLogList = new ArrayList<SwfPathLogDto>();
		SwfLogDto swfLogFunctionInDto = swfLogTransferDto.getSwfLogDto();
		//流程号码
		String swfLogFlowID=swfLogFunctionInDto.getFlowId();
		//流程中的节点号码
		int swfLogLogNo=swfLogFunctionInDto.getLogNo();
		//一般以上两个是必须的
		//操作是哪种 2,4,5,3目前只有这几种
		String nodeStatus=swfLogFunctionInDto.getNodeStatus();
		String nextBusinessNo = swfLogTransferDto.getNextBusinessNo() ;
		String keyIn =swfLogFunctionInDto.getKeyIn() ;
		String keyOut=swfLogFunctionInDto.getKeyOut() ;
		//创建工作流用的参数
		//是否需要创建工作流
		boolean createWorkFlow=swfLogTransferDto.isCreateFlow() ;
		String riskCode = swfLogFunctionInDto.getRiskCode() ;
		String comCode =swfLogFunctionInDto.getComCode() ;
		String policyNo = swfLogFunctionInDto.getPolicyNo() ;
		//只有当flowid没有时起作用
		String businessNo = swfLogFunctionInDto.getBusinessNo()  ;
		//如果为T类型或者没有flowid时有用
		String nodeType=swfLogFunctionInDto.getNodeType() ;
		String conditionBusinessNo = swfLogTransferDto.getConditionBusinessNo();
		String typeFlag = swfLogFunctionInDto.getTypeFlag() ;
		//如果是利用的如上方法，则只需要查询工作流节点中的内容就可以了
		int logMaxNo=0;  //解决取LogNo号的问题
		Integer pathMaxNo=0; //解决取pathNo号的问题
		//1.创建工作流程/查找流程信息
		if (createWorkFlow) {
		    //此方法有两步主要操作,写工作流主表和第一个工作流节点到工作流大对象中
			workFlowDto = createFlowInfo(swfLogTransferDto, businessNo,comCode, riskCode,policyNo,swfLogFunctionInDto.getInsuredName(),swfLogFunctionInDto.getLossitemName());
			if (workFlowDto.getOperateResult() <0){
				//没有取得模板的号码
				return workFlowDto;
			}
			//设置当前节点的内容
			swfLogDto = workFlowDto.getCreateSwfLogDto();
			logMaxNo = 2;
			pathMaxNo = 1;
		}else{
			//查询出工作流数据/查找当前节点
			if (!"".equals(swfLogFlowID)&& swfLogLogNo>0){
				//利用主键flowid,LogNo查工作节点
				this.convertCollection(swfLogDao.findAllByFlowIDAndLogNo(swfLogFlowID, swfLogLogNo), swfFlowNodeList, SwfLogDto.class);
			}else{
				//利用主键businessNo, nodeType查工作节点
				this.convertCollection(swfLogDao.findAllByBusinessAndNodeType(businessNo, nodeType), swfFlowNodeList, SwfLogDto.class);
			}
			if (swfFlowNodeList.size()>0) {
				// 获得当前工作流程的信息(就是当前节点的信息)
				swfLogDto = convert(swfFlowNodeList.get(0), SwfLogDto.class);
				// 并取得工作流上点和边的最大号码 下面的的是查询计算书节点
				List<Object[]> objects = swfLogDao.findLastComppByFlowIdAndNodeType(swfLogFlowID);
				if (objects.size()>0) {
					logMaxNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId());
				}else {//获取当前的logno,并且+1 得到的就是下一个节点应该的logno
					logMaxNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId()) + 1;
				}
				if (logMaxNo == 0) {
					logMaxNo = 1;
				}//查询当前的日志节点 得到后+1得到下一个日志节点
				pathMaxNo = swfPathLogDao.getMaxPathNo(swfLogDto.getFlowId());
				if ( pathMaxNo == null || pathMaxNo == 0 ) {
					pathMaxNo = 0;
				}
				pathMaxNo++;
			}
		}
		//工作流判断是否可以操作(直接到代码末尾) swfLogDto是当前节点的数据 如果没有数据 直接返回? 什么情况下会没有数据
		if (swfLogDto != null) {
			//要判断工作流程是否结束，如果结束了，下面的都不需要操作的(结案节点的endFlag就是1 其余的基本都是0)
			if (checkFlowClose(swfLogDto.getFlowId())){
				//工作流已经关闭了
				workFlowDto.setCheckClose(true);
				return workFlowDto;
			}
			//判断是不是要创建创建子任务，以后都相同的M类型任务的处理 M创建后，和正常的流程是一样的
			//理算环节注销/拒赔需要处理
			if ("M".equals(swfLogDto.getTaskType())&&!"5".equals(nodeStatus) &&!"speci".equals((swfLogTransferDto.getSwfLogNextList()!=null &&swfLogTransferDto.getSwfLogNextList().size()>0)? swfLogTransferDto.getSwfLogNextList().get(0).getNodeType():"")) {
				if("compe".equals(swfLogFunctionInDto.getNodeType())&&swfLogTransferDto.getSwfLogNextList() != null && swfLogTransferDto.getSwfLogNextList().size() > 0){
					//理算注销拒赔不需要生成理算书节点
				}else{
					//创建子任务过程
					swfLogDto.setBusinessNo(nextBusinessNo);
					swfLogDto.setKeyIn(businessNo);
					List<Object[]> objects = swfLogDao.findLastComppByFlowIdAndNodeType(swfLogFlowID);
					workFlowDtoTemp = getSubmitFlowInfo(swfLogTransferDto, swfLogDto, keyIn, logMaxNo, pathMaxNo);

					if (objects.size()>0){
						Object[] object = objects.get(0);
						SwfLogKey swfLogKey = new SwfLogKey();
						swfLogKey.setFlowId(swfLogFlowID);
						swfLogKey.setLogNo((Integer)object[1]);
						SwfLog swfLog = swfLogDao.findOne(swfLogKey);
						logMaxNo = swfLog.getLogNo();
						pathMaxNo = pathMaxNo-1;
					}else {
						logMaxNo=logMaxNo+1;
						pathMaxNo=pathMaxNo+1;
					}

					workFlowDto.setSubmit(true);
					workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
					workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
					//设置创建的子任务为当前的需要处理的任务节点
					swfFlowNodeList.clear();
					swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();

					if (swfFlowNodeList.size()>0) {
						swfLogDto = (SwfLogDto) swfFlowNodeList.get(0);
						swfLogDto.setHandlerCode(swfLogTransferDto.getUserUserCode());
						swfLogDto.setHandlerName(swfLogTransferDto.getUserUserName());
						//M类型出来的子节点直接设置keyOut,不管是否提交
						swfLogDto.setKeyOut(keyOut);
					}
				}
			}
			//传入的参数类型为T特殊类型的节点 新理赔种养殖险基本上没有taskType是T的
			if ("T".equals(swfLogFunctionInDto.getTaskType())) {
				//创建新节点
				//为T类型的节点可以正常的走普通路径，所以做标志判断的时候该用其他内部标志，表示T类型，比如AddNewNode等同于T
				swfLogDto.setTaskType("AddNewNode");
				workFlowDtoTemp = getSubmitFlowInfo(swfLogTransferDto, swfLogDto, keyIn, logMaxNo, pathMaxNo);
				if (workFlowDtoTemp.getSubmitSwfLogDtoList()==null){
					//查出后续是没有节点的。。。直接抛出
					return workFlowDto;
				}
				//因为节点产生了，所以增加了
				logMaxNo=logMaxNo+1;
				pathMaxNo=pathMaxNo+1;
				workFlowDto.setSubmit(true);
				workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
				workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
				//设置创建的子任务为当前的需要处理的任务节点
				swfFlowNodeList.clear();
				swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();
				if (swfFlowNodeList.size()>0) {
					swfLogDto = (SwfLogDto) swfFlowNodeList.get(0);
					swfLogDto.setHandlerCode(swfLogTransferDto.getUserUserCode());
					swfLogDto.setHandlerName(swfLogTransferDto.getUserUserName());
					//因为回勘的要求
					swfLogDto.setTypeFlag(typeFlag);
					//T类型出来的子节点直接设置keyOut,不管是否提交
					swfLogDto.setKeyOut(keyOut);
				}
			}
			//做判断提交，如果不可以提交，那就改为保存操作 这个nodeStatus是从每个节点的swflogDealDto中获取的
			//2.修改工作流0/1/2/3都是修改工作流
			if ("0".equals(nodeStatus) || "1".equals(nodeStatus) ||	"2".equals(nodeStatus) || "3".equals(nodeStatus)) {
				//修改工作流
				swfLogDto.setNodeStatus(nodeStatus);
				swfLogDto.setHandlerCode(swfLogTransferDto.getUserUserCode());
				swfLogDto.setHandlerName(swfLogTransferDto.getUserUserName());
				swfLogDto.setKeyOut(keyOut);
				//reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
				swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
				if (typeFlag!=null&&typeFlag.length()>0){
					swfLogDto.setTypeFlag(typeFlag);
				}
				//如果是M(理算)类型的接点，则不需要处理update情况//优化工作流
				if (workFlowDto.isSubmit()){
					List<SwfLogDto> submitLogMList = new ArrayList<SwfLogDto>();
					submitLogMList.add(swfLogDto);
					workFlowDto.setSubmitSwfLogDtoList(submitLogMList);
				}else{
					//判断当前信息中是否有工作流的存在。。
					if (swfLogDto.getLogNo() > 0){
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLogDto(swfLogDto);
					}
				}
			}
			//3。提交工作流   这个nodeStatus是从每个节点的swflogDealDto中获取的 根源在prplClaimStatus里
			if ("4".equals(nodeStatus)) {
				//判断是否需要人为的结束,人为结束只要设置传入的参数为endflag=1就行了。这个endFlag的含义是什么(结案节点的endFlag标志为1)
				if ("1".equals(swfLogFunctionInDto.getEndFlag())){
					swfLogDto.setEndFlag("1");
				}
				//判断是否允许节点能提交？？这个在页面上已经进行判断了
				//修改工作流nodeStatus=4 swfLogDto是当前节点的数据
				swfLogDto.setNodeStatus(nodeStatus);
				swfLogDto.setKeyOut(keyOut);
				//关联保单定损只有一个，定损时只存商业保单，当从定损处入口申请垫支付时，保单号需要取对应于强制立案号的强制保单，所以不能用定损时的保单。
				if(swfLogFunctionInDto!=null&& swfLogFunctionInDto.getPolicyNo()!=null &&!"".equals(swfLogFunctionInDto.getPolicyNo())){
					swfLogDto.setPolicyNo(swfLogFunctionInDto.getPolicyNo());
				}
				//设置提交的时间 也就是流出时间
				//reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
				swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()) ;
				//还需要设置条件(这个conditionBusinessNo到底是什么)
				swfLogTransferDto.setConditionBusinessNo(conditionBusinessNo);
				//设置是否有typeFlag(这个TypeFlag到底是什么)
				if ((typeFlag!=null) && (typeFlag.length()>0)){
					swfLogDto.setTypeFlag(typeFlag) ;
				}
				//生成下一个提交的节点 pathMaxno是流程信息表的下一个号 logMaxNo是工作流下一个号
				workFlowDtoTemp = submitWorkFlow(swfLogTransferDto, swfLogDto, swfLogFunctionInDto,	logMaxNo, pathMaxNo);
				//为deal方法做准备 (设置update标识符为true,并且设置更新节点)
				workFlowDto.setUpdate(workFlowDtoTemp.isUpdate());
				workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto());
				workFlowDto.setUpdateSwfLog2Dto(workFlowDtoTemp.getUpdateSwfLog2Dto());

				submitLogList = workFlowDtoTemp.getSubmitSwfLogDtoList();
				if (submitLogList==null){
					//考虑到有时候提交后面是空的,允许的
					submitLogList = new ArrayList<SwfLogDto>();
				}
				submitPathLogList = workFlowDtoTemp.getSubmitSwfPathLogDtoList();
				if (submitPathLogList==null){
					//考虑到有时候提交后面是空的,允许的
					submitPathLogList = new ArrayList<SwfPathLogDto>();
				}
				//原来有新增加的数据，需要合并的节点和路径的这里是优化，前面进行M和T操作形成的新节点。
				if (workFlowDto.isSubmit()) {
					for(int n=0;n<workFlowDto.getSubmitSwfLogDtoList().size();n++){
						submitLogList.add(workFlowDto.getSubmitSwfLogDtoList().get(n));
					}
					for(int n=0;n<workFlowDto.getSubmitSwfPathLogDtoList().size();n++){
						submitPathLogList.add(workFlowDto.getSubmitSwfPathLogDtoList().get(n));
					}
					//如果已经有提交的数据了
				}
				workFlowDto.setSubmit(workFlowDtoTemp.isSubmit());
				workFlowDto.setSubmitSwfLogDtoList(submitLogList);
				workFlowDto.setSubmitSwfPathLogDtoList(submitPathLogList);
				workFlowDto.setClose(workFlowDtoTemp.isClose());
				workFlowDto.setCloseSwfFlowMainDto(workFlowDtoTemp.getCloseSwfFlowMainDto());
				workFlowDto.setStatus(workFlowDtoTemp.getStatus());
			}




			//判断是提交操作的结束
			//优化工作流
			if (workFlowDto.isCreate() && workFlowDto.isUpdate()) {
				//新创建的工作流直接创建，就不用在udpate一把了
				workFlowDto.setCreateSwfLogDto(workFlowDto.getUpdateSwfLogDto());
				workFlowDto.setUpdate(false);
			}
			//优化工作流，如果报案的时候同时进行了关闭操作，则关闭的主表当时一定是空的，所以
			if (workFlowDto.isCreate() && workFlowDto.isClose()) {
				//新创建的工作流直接创建，关闭也要进行修整的
				SwfFlowMainDto swfFlowMainDto = workFlowDto.getCreateSwfFlowMainDto();
				swfFlowMainDto.setFlowStatus("0");
				workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto );
			}
			//4。回退工作流
			if ("5".equals(nodeStatus)) {
				//目前只有核损、定损才用得到，无条件到达定损，并且人员是上个节点上的人员
				//首先查找定损的节点，从回退的节点上查询属性为定损的节点，处理类型为typeFlag相同的节点
				//由后向前进行查询。（目前只有核损、核价和人伤核损三个）
				if ("compe".equals(swfLogDto.getNodeType())){
					//核损的退回,理算的退回
					workFlowDto=backWorkFlow(swfLogTransferDto,swfLogDto.getFlowId() ,swfLogDto.getLogNo(),swfLogFunctionInDto);
				}else{
					throw new DataVerifyException("没有发现可以回退的工作流节点");
				}
			}
		}
		return workFlowDto;
	}

	/**
	 * @description 根据传过来的参数创建工作流
	 * @param swfLogTransferDto 工作流中转对象
	 * @param businessNo 业务号
	 * @param comCode 机构代码
	 * @param riskCode 险种代码
	 * @param policyNo 保单号
	 * @param insuredName 被保险人
	 * @param lossitemName 车牌号
	 * @return
	 */
	private WorkFlowDto createFlowInfo(SwfLogTransferDto swfLogTransferDto, String businessNo, String comCode, String riskCode, String policyNo, String insuredName, String lossitemName) {
        if(StringUtils.isEmpty(riskCode)){
            throw new BusinessException("险种代码不能为空");
        }
	    // 1。 取得当前用户信息，写操作员信息到Dto中
        //1 新建工作流对象
		WorkFlowDto workFlowDto = new WorkFlowDto();
		int year = DateTime.current().getYear();
		String strTitle = "创建工作流程";
		String tableName = "swfflowmain";


		//2.取工作流的流号
		BillConditionDto billConditionDto = new BillConditionDto();
		billConditionDto.setBillType(tableName);
		billConditionDto.setRiskCode(riskCode);
		billConditionDto.setComCode(comCode);
		String flowID;
		try {
			//生成flowID 工作流号服务
			BillNoDto billNoDto=new BillNoDto();
			billNoDto.setTableName(tableName);
			billNoDto.setiComCode(comCode);
			billNoDto.setRiskCode(riskCode);
			billNoDto.setiYear(year+"");
			billNoDto.setUserCode(swfLogTransferDto.getUserUserCode());
			flowID = billNoApi.getBillNo(billNoDto).get("billNo");
		} catch (Exception e) {
			String  msg="获取工作流ID出错";
			throw new BusinessException("工作流>>>>>>>>>>>>>>>>>>>>>>{}",msg);
		}


		//3.取工作流的模板号,从swfmodeluse中取得相映的模板设置的号码 种植险为2 养殖险为4(很重要的一步)
		int modelNo = getModelNo(riskCode, comCode);


		// 如果没有取得工作流号码，modelNo为-1,那么则返回一个空的数据集合，通知调用该函数的程序
		// 查找不到分配的模板时候，立刻提示出错误，要不然会有问题
		if (modelNo<0) {
			throw new DataVerifyException("没有发现险种为'" + riskCode + "'，机构为'" + comCode + "'所配置的理赔模板，请和管理员联系！");
		}


		//4.写工作流主表swfFlowMain
		SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
		swfFlowMainDto.setFlowId(flowID);
		swfFlowMainDto.setFlowName(businessNo);
		//flowStatus 1为生效 结案撤销等转出操作会设为0  ??占号的情况下为2
		swfFlowMainDto.setFlowStatus("1");
		swfFlowMainDto.setPolicyNo(policyNo);
		swfFlowMainDto.setCreatDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		swfFlowMainDto.setModelNo(modelNo);
		swfFlowMainDto.setFlag("");
		workFlowDto.setCreateSwfFlowMainDto(swfFlowMainDto);


		//5.查询节点表swfNode的定义
		// 假设所有的模板第一个节点的号码就是1(不用假设 新建出来的工作流的节点号码不是1还能是什么?)
		int nodeNo = 1;
		//以种植险和养殖险为例 查出来的是报案节点
		SwfNode swfNode = swfNodeDao.findOne(new SwfNodeKey(modelNo, nodeNo));
		//6.写流程节点表wfLog
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto.setFlowId(flowID);
		swfLogDto.setLogNo(1);
		swfLogDto.setModelNo(modelNo);
		swfLogDto.setNodeNo(nodeNo);
		swfLogDto.setNodeName(swfNode.getNodeName());
		swfLogDto.setBusinessNo(businessNo);
		swfLogDto.setHandleDept(swfLogTransferDto.getUserComCode());
		swfLogDto.setHandlerCode(swfLogTransferDto.getUserUserCode());
		swfLogDto.setHandlerName(swfLogTransferDto.getUserUserName());
		// 待处理的查询条件，增加报案号，被保险人，车牌号(工作流需要添加)
		swfLogDto.setInsuredName(insuredName);
		swfLogDto.setLossitemName(lossitemName);
		swfLogDto.setRegistNo(businessNo);
		swfLogDto.setTimeLimit(swfNode.getTimeLimit());
		swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		swfLogDto.setNodeStatus("1");
		//工作流打开状态下为1
		swfLogDto.setFlowStatus("1");
		swfLogDto.setPackageId("0");
		swfLogDto.setFlag(swfNode.getFlag());
		swfLogDto.setTaskNo(swfNode.getTaskNo());
		swfLogDto.setTaskType(swfNode.getTaskType());
		swfLogDto.setNodeType(swfNode.getNodeType());
		swfLogDto.setTitleStr(strTitle);
		swfLogDto.setRiskCode(riskCode);
		swfLogDto.setKeyIn(businessNo);
		swfLogDto.setKeyOut("");
		swfLogDto.setDeptName(swfLogTransferDto.getUserComName());
		swfLogDto.setSubFlowId("0");
		swfLogDto.setMainFlowId("0");
		swfLogDto.setPosx(0);
		swfLogDto.setPosy(0);
		swfLogDto.setEndFlag(swfNode.getEndFlag());
		// reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
		swfLogDto.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		swfLogDto.setPolicyNo(policyNo);
		swfLogDto.setComCode(comCode);
		// 加到Dto中
		workFlowDto.setCreateSwfLogDto(swfLogDto);
		workFlowDto.setCreate(true);
		// 创建工作流的过程 不操作数据，只写数据到workFlowDto中
		return workFlowDto;
	}
	/**
	 * @description 提交工作流
	 * @param swfLogTransferDto 工作流中转对象
	 * @param swfLogFunctionInDto 本节点信息
	 * @param keyIn 传入业务号
	 * @param logNo 工作流最大点
	 * @param pathNo 工作流最大边
	 * @return
	 */
	private WorkFlowDto getSubmitFlowInfo(SwfLogTransferDto swfLogTransferDto, SwfLogDto swfLogFunctionInDto, String keyIn, int logNo, int pathNo) {
		//思路：根据当前节点的信息，查找下面的节点。并形成新的wfLog数据,wfpathLog的数据
		//1。 取得当前用户信息，写操作员信息到Dto中
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//2.取工作流号码
		String flowID = swfLogFunctionInDto.getFlowId() ;
		//3.取工作流的模板号 (2是养殖险 4是种植险) nodeNo是当前的工作流节点号
		int modelNo= swfLogFunctionInDto.getModelNo() ;
		int nodeNo = swfLogFunctionInDto.getNodeNo() ;
		//如果是T指定下个节点的话。那么。。
		//程序上认为回归的时候程序置为标志B,但是判断后，直接把值恢复成"S"
 		if ("B".equals(swfLogFunctionInDto.getTaskType())){
			nodeNo=swfLogFunctionInDto.getTaskNo() ;
			swfLogFunctionInDto.setTaskType("S");
		}
		//4.查询节点表wfNode的定义
		//模板的节点
		List<SwfNodeDto> wfNodeDtoList = new ArrayList<SwfNodeDto>();
		//整理后需要新插入的工作流程节点
		List<SwfLogDto> wfLogDtoList = new ArrayList<SwfLogDto>();
		//整理后需要新插入的工作流程边
		List<SwfPathLogDto> wfPathLogDtoList = new ArrayList<SwfPathLogDto>();
		//如果是多任务的节点，只查关系，不查后面的线 M是理算节点的情况下
		if ("M".equals(swfLogFunctionInDto.getTaskType())){
			int nextNodeNo = swfLogFunctionInDto.getTaskNo();
			SwfNodeDto wfNodeDto = new SwfNodeDto();
			wfNodeDto = convert(swfNodeDao.findOne(new SwfNodeKey(modelNo, nextNodeNo)), SwfNodeDto.class);
			if (wfNodeDto!=null){
				wfNodeDtoList.add(wfNodeDto);
			}
		}else if("AddNewNode".equals(swfLogFunctionInDto.getTaskType())){
			//AddNewNode=T,C是T类型节点的特殊内部表示
			this.convertCollection(swfNodeDao.findModelNextTNodes(modelNo, nodeNo),wfNodeDtoList,SwfNodeDto.class);
		}else{
			//查询此节点后的所有的节点信息（正常节点taskType =S 单任务节点 M 理算 双任务节点）
			//目前没有确定执行边条件的业务号是什么？？？swfLogFunctionInDto.getConditionBusinessNo(),从节点上传过来
			wfNodeDtoList = findModelNextNodes(modelNo, nodeNo, swfLogTransferDto.getConditionBusinessNo());
		}
		//5.根据下个工作流节点写工作流程的点和线的数据
		if (wfNodeDtoList.size() > 0){
			for(int n=0;n<wfNodeDtoList.size();n++){
				SwfNodeDto wfNodeDto = new SwfNodeDto();
				SwfNodeTransferDto swfNodeTransferDto = new SwfNodeTransferDto();
				wfNodeDto = (SwfNodeDto) wfNodeDtoList.get(n);
				swfNodeTransferDto.setSwfNodeDto(wfNodeDto);
				//判断有没有传入的指定的typeflag,需要入swflog的。
				if (null != swfLogFunctionInDto.getTypeFlag() && swfLogFunctionInDto.getTypeFlag().length() >0){
					swfNodeTransferDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag());
				}
				//6.写流程节点表wfLog
				SwfLogDto wfLogDtoTemp = new SwfLogDto();
				//设置wfLogDtoTemp
				//判断是否在当前的流程中，已经有被定义成该节点的存在，并且状态为0,没有处理，（特殊节点，如果是核损，实赔呢？因为允许多次提交）
				//如果有，就不用再插入数据库了
				List<SwfLogDto> wfLogHasSaveList = new ArrayList<SwfLogDto>();
				//回访不需要检查是不是有重复的节点
				if (!"backv".equals(wfNodeDto.getNodeType())&&!"compp".equals(wfNodeDto.getNodeType())&&!"veric".equals(wfNodeDto.getNodeType())){
					this.convertCollection(swfLogDao.findAllByFlowIDAndNodeNo(flowID, wfNodeDto.getNodeNo()),wfLogHasSaveList,SwfLogDto.class);
				}
				//由于强三的加入，需要考虑一下，如果结案是按照险种来结案的，那么需要如何做？
				//这里初步考虑用riskcode来区分结案，然后用相同的结案来处理
				if ("endca".equals(wfNodeDto.getNodeType())){
					List<SwfLogDto> wfLogHasSaveListTemp = wfLogHasSaveList;
					wfLogHasSaveList = new ArrayList<SwfLogDto>();
					//只要判断已经产生的结案中是有 riskcode=本身的riskCode的数据，则可以产生新的结案
					for (int i =0;i<wfLogHasSaveListTemp.size() ;i++){
						String riskCode = ((SwfLogDto)wfLogHasSaveListTemp.get(i)).getRiskCode();
						if ( riskCode.equals(swfLogFunctionInDto.getRiskCode())){
							wfLogHasSaveList.add((SwfLogDto)wfLogHasSaveListTemp.get(i));
							break;
						}
					}
				}
				if(wfLogHasSaveList.iterator().hasNext()){
					//解决多点聚合的时候，产生了大量的多余节点的问题
					wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.get(0);
					//如果存在这样的数据，则不需要插入wflog，只要在wfPathlog中增加相应的边就可以了
					//7.写流程线表wfPathLog
				}else{
					swfNodeTransferDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree());
					getSwfLogDtoInfoBySwfNode(wfLogDtoTemp,swfNodeTransferDto,swfLogTransferDto,flowID,modelNo,logNo,"0",keyIn,swfLogFunctionInDto);
					//设置默认值
					wfLogDtoTemp.setTypeFlag(swfLogFunctionInDto.getTypeFlag());
					//节点上的附加信息 当前预设置,以后也不做保留的，只用来对下个节点起作用的
					//默认为本节点数据的附加内容，但是如果外部设置了新的值，则以新的为准
					wfLogDtoList.add(wfLogDtoTemp);
					logNo++;
				}
				//7.写流程线表wfPathLog
				SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
				if("speci".equals(wfLogDtoTemp.getNodeType())){
					swfLogFunctionInDto = convert(swfLogDao.findByflowIdAndNodeType(swfLogFunctionInDto.getFlowId(), "claim").get(0), SwfLogDto.class);
				}
				getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
				wfPathLogDtoList.add(swfPathLogDto);
				pathNo++;
			}
			workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
			workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
			workFlowDto.setSubmit(true);
		}else{
			//如果是单任务节点，但是后面已经没有节点了，查询是不是M的后续节点，如果是（条件是taskNo>0），
			if ("S".equals(swfLogFunctionInDto.getTaskType()) && swfLogFunctionInDto.getTaskNo()>1){
				//回归主线，为了防止重复递归，设置条件为只可以套一次,并且关系只保留一次,其实不用修改数据中的内容
				//给再次递归调用本身的时候加个标志位，在次判断的时候，会给置回S
				swfLogFunctionInDto.setTaskType("B");
				swfLogTransferDto.setNextBusinessNo(swfLogTransferDto.getNextBusinessNo());
				swfLogFunctionInDto.setKeyOut(swfLogFunctionInDto.getKeyOut());
				swfLogFunctionInDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
				//回归主线的bussnessno
				workFlowDto = getSubmitFlowInfo(swfLogTransferDto,swfLogFunctionInDto,keyIn,logNo,pathNo);
			}else{
				//如果以上情况都不是那么。。。 没有正常结束，但是也没有任何下一个节点的记录，需要提示操作员，并且无法进行下去
				//设置异常
				workFlowDto.setStatus("9");
			}
		}
		return workFlowDto;
	}

	/**
	 * @description 查找模板的下多个节点的详细信息
	 * @param modelNo 模板号码
	 * @param nodeNo 模板上的节点号
	 * @param conditionBusinessNo 业务号限制条件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SwfNodeDto> findModelNextNodes(int modelNo, int nodeNo, String conditionBusinessNo) {
		StringBuffer strSql = new StringBuffer();
		String strWhere ="";
		boolean blnResult=true;
		List<SwfPathDto> wfPathDtoList = new ArrayList<SwfPathDto>();
		List<SwfNodeDto> wfNodeDtoList = new ArrayList<SwfNodeDto>();
		//思路是先取得所有符合条件的路径，然后判断路径上的条件是不是满足，只要有一个条件不满足，就不能用这个路径了。
		//最后把符合条件的路径上的最后一个点都可以用的。。
		//获得所有的path数据 model 模板号  nodeNo 模板起始节点
		this.convertCollection(swfPathDao.findModelNextNodes(modelNo, nodeNo),wfPathDtoList,SwfPathDto.class);
		for(int n=0;n<wfPathDtoList.size();n++){
			//由于条件的引入，需要过滤掉不符合wfcondition条件的数据记录，通过pathno来进行。
			SwfPathDto swfPathDto = new SwfPathDto();
			swfPathDto = (SwfPathDto) wfPathDtoList.get(n) ;
			//首先过滤掉是用来选择用的节点
			if ("3".equals(swfPathDto.getDefaultFlag())){
				continue;
			}
			//没有条件限制的情况下
			if ("1".equals(swfPathDto.getConditionStatus())){
			}else{
				strSql.append("," + swfPathDto.getEndNodeNo());
				continue;
			}
			//有条件约束的情况下，首先要取得所以的条件，一一甄别
			blnResult=swfPathService.checkPathCondition(swfPathDto,conditionBusinessNo);
			if (blnResult){
				strSql.append("," + swfPathDto.getEndNodeNo());
			}
		}
		// 判断有没有符合条件的nodeNo
		String sql = "";
		if (strSql.length() > 1){
			strWhere = strSql.toString();
			if(modelNo==1||modelNo==12||modelNo==14||modelNo==87){
				sql = "Select s From SwfNode s Where  modelno = ? and nodeNo in (" + strWhere.substring(1, strWhere.length()) + ") order by decode(nodeNo,-99, " + strWhere.substring(1, strWhere.length()) + ")";
			}else{
				sql =  "Select s From SwfNode s Where  modelno = ? and nodeNo in (" + strWhere.substring(1, strWhere.length()) + ")";
			}
			Query query = entityManager.createQuery(sql,SwfNode.class);
			query.setParameter(1, modelNo);List<SwfNode> swfNodeList = query.getResultList();
			wfNodeDtoList = new ArrayList<SwfNodeDto>(swfNodeList.size());
			convertCollection(swfNodeList, wfNodeDtoList, SwfNodeDto.class);
		}
		return wfNodeDtoList;
	}

	/**
	 * @description 根据工作流模板上的相同节点定义，写wflog表，工作流程节点的操作处理
	 * @param swfLogDto 新的工作流
	 * @param swfNodeTransferDto 工作流节点的中转对象
	 * @param swfLogTransferDto 工作流中转对象
	 * @param flowID 工作流号
	 * @param modelNo 模板号
	 * @param logNo 工作流点
	 * @param nodeStatus 节点状态
	 * @param keyIn 流入业务号
	 * @param swfLogFunctionIn 当前操作的工作流
	 * @return SwfLogDto 工作流
	 */
	private SwfLogDto getSwfLogDtoInfoBySwfNode(SwfLogDto swfLogDto, SwfNodeTransferDto swfNodeTransferDto,SwfLogTransferDto swfLogTransferDto, String flowID, int modelNo, int logNo, String nodeStatus, String keyIn,SwfLogDto swfLogFunctionIn) {
		SwfNodeDto swfNodeDto = new SwfNodeDto();
		swfNodeDto = swfNodeTransferDto.getSwfNodeDto();
		swfLogDto.setFlowId(flowID);
		List<Object[]> objects = swfLogDao.findLastComppByFlowIdAndNodeType(flowID);
		if (objects.size()>0 && "compp".equals(swfLogFunctionIn.getNodeType())&&"veric".equals(swfNodeTransferDto.getSwfNodeDto().getNodeType())){
			swfLogDto.setLogNo(logNo+1);
		}else {
			swfLogDto.setLogNo(logNo);
		}
		swfLogDto.setModelNo(modelNo);
		swfLogDto.setNodeNo(swfNodeDto.getNodeNo());
		swfLogDto.setNodeName(swfNodeDto.getNodeName());
		swfLogDto.setBusinessNo(swfLogFunctionIn.getBusinessNo() );
		swfLogDto.setBeforeHandlerCode(swfLogTransferDto.getUserUserCode());
		swfLogDto.setBeforeHandlerName(swfLogTransferDto.getUserUserName());
		swfLogDto.setTimeLimit(swfNodeDto.getTimeLimit());
		//reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
		swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
		swfLogDto.setNodeStatus(nodeStatus);
		swfLogDto.setFlowStatus("1");
		swfLogDto.setPackageId("0");
		swfLogDto.setFlag(swfNodeDto.getFlag() ) ;
		swfLogDto.setTaskNo(swfNodeDto.getTaskNo());
		swfLogDto.setTaskType(swfNodeDto.getTaskType());
		swfLogDto.setNodeType(swfNodeDto.getNodeType());
		//待处理的查询条件，增加报案号，被保险人，车牌号(工作流需要添加)
		swfLogDto.setRegistNo(swfLogFunctionIn.getRegistNo());
		swfLogDto.setInsuredName(swfLogFunctionIn.getInsuredName());
		swfLogDto.setLossitemName(swfLogFunctionIn.getLossitemName());
		swfLogDto.setRiskCode(swfLogFunctionIn.getRiskCode());
		swfLogDto.setKeyIn(keyIn);
		//等于实赔的情况下，就是claimno,buesssno
		if ("compe".equals(swfLogDto.getNodeType())){
			swfLogDto.setKeyIn(swfLogDto.getBusinessNo());
		}
		swfLogDto.setTypeFlag(swfNodeTransferDto.getTypeFlag() );
		swfLogDto.setKeyOut("");
		swfLogDto.setSubFlowId("0");
		swfLogDto.setMainFlowId("0");
		swfLogDto.setPosx(0);
		swfLogDto.setPosy(0);
		swfLogDto.setEndFlag(swfNodeDto.getEndFlag() );
		//设置流入时间
		//reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
		swfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
		//设置节点的名称
		String titleAttr =swfNodeDto.getNodeName()+"节点"+"流入时间："+swfLogDto.getFlowInTime() +" 上一节点操作人:"+ swfLogTransferDto.getUserUserName() ;
		swfLogDto.setTitleStr(titleAttr);
		//设置保单号码
		swfLogDto.setPolicyNo(swfLogFunctionIn.getPolicyNo());
		//设置默认节点上的人员
		swfLogDto.setHandlerCode(swfNodeDto.getHandlerCode() );
		swfLogDto.setHandlerName(swfNodeDto.getHandlerName() );
		swfLogDto.setComCode(swfLogFunctionIn.getComCode() );
		//设置附加数据
		swfLogDto.setScheduleId(swfNodeTransferDto.getScheduleID()) ;
		swfLogDto.setLossitemCode(swfNodeTransferDto.getLossItemCode());
		swfLogDto.setLossitemName(swfNodeTransferDto.getLossItemName());
		swfLogDto.setInsurecarFlag(swfNodeTransferDto.getInsureCarFlag() );
		swfLogDto.setHandlerRange(swfNodeTransferDto.getHandlerRange() );
		swfLogDto.setExigenceGree (swfNodeTransferDto.getExigenceGree() );
		swfLogDto.setHandleDept(swfNodeTransferDto.getHandleDept() );
		swfLogDto.setDeptName(swfNodeTransferDto.getDeptName());
		if (("claim".equals(swfLogDto.getNodeType()) && "".equals(swfLogDto.getHandleDept()))
				|| ("claim".equals(swfLogDto.getNodeType()) && swfLogDto.getHandleDept() == null)){
			swfLogDto.setHandleDept(swfLogFunctionIn.getComCode());
		}else{
			if ("".equals(swfLogDto.getHandleDept()) || swfLogDto.getHandleDept() == null){
				swfLogDto.setHandleDept(swfLogTransferDto.getNewHandleDept());
			}
			if ("".equals(swfLogDto.getHandleDept()) || swfLogDto.getHandleDept() == null){
				swfLogDto.setHandleDept(swfLogTransferDto.getUserComCode());
			}
		}
		if ("".equals(swfLogDto.getDeptName()) || swfLogDto.getDeptName() == null){
			swfLogDto.setDeptName(swfLogTransferDto.getNewHandleDept());
		}
		if ("".equals(swfLogDto.getDeptName()) || swfLogDto.getDeptName() == null){
			swfLogDto.setDeptName(swfLogTransferDto.getUserComName());
		}
		//resason :增加立案中数据的支持
		if ("claim".equals(swfLogDto.getNodeType())||"compe".equals(swfLogDto.getNodeType())||"cance".equals(swfLogDto.getNodeType())){
			if (!"".equals(swfNodeDto.getRiskCode()) && swfNodeDto.getRiskCode() != null){
				swfLogDto.setRiskCode(swfNodeTransferDto.getRiskCode());
			}
			if (!"".equals(swfNodeDto.getPolicyNo()) && swfNodeDto.getPolicyNo() != null){
				swfLogDto.setPolicyNo(swfNodeTransferDto.getPolicyNo());
			}
			if (!"".equals(swfNodeDto.getKeyIn()) && swfNodeDto.getKeyIn() != null){
				swfLogDto.setKeyIn(swfNodeTransferDto.getKeyIn());
			}
			if (!"".equals(swfNodeDto.getBusinessNo()) && swfNodeDto.getBusinessNo() != null){
				swfLogDto.setBusinessNo(swfNodeTransferDto.getBusinessNo());
			}
		}
		return swfLogDto;
	}

	/**
	 * @description 写wfPathlog表，工作流程线的操作处理
	 * @param swfPathLogDto 新工作流流程路径节点
	 * @param swfLogCurrDto 当前节点
	 * @param swfLogNextDto 下一个节点
	 * @param flowID 工作流流号
	 * @param modelNo 工作流模板号
	 * @param pathNo 工作流程路径号
	 * @return SwfPathLogDto
	 */
	private SwfPathLogDto getSwfPathLogDtoInfoBySwfLog(SwfPathLogDto swfPathLogDto, SwfLogDto swfLogCurrDto,SwfLogDto swfLogNextDto, String flowID, int modelNo, int pathNo) {
		String pathName ="";
		swfPathLogDto.setFlowId(flowID);
		swfPathLogDto.setPathNo(pathNo);
		swfPathLogDto.setModelNo(modelNo);
		pathName = "从 " + swfLogCurrDto.getNodeName() + " 到 " +  swfLogNextDto.getNodeName();
		swfPathLogDto.setPathName(pathName);
		//只记录序号
		swfPathLogDto.setStartNodeNo(swfLogCurrDto.getLogNo());
		swfPathLogDto.setStartNodeName(swfLogCurrDto.getNodeName());
		//这里已经不是模板定义的号码
		swfPathLogDto.setEndNodeNo(swfLogNextDto.getLogNo());
		swfPathLogDto.setEndNodeName(swfLogNextDto.getNodeName());
		swfPathLogDto.setFlag("");
		return swfPathLogDto;
	}

	/**
	 * @description 根据当前节点的内容，提交工作流的下面的节点
	 * @param swfLogTransferDto 工作流中转对象
	 * @param swfLogDto 新的工作流
	 * @param swfLogFunctionIn 当前工作流节点
	 * @param logNo 工作流的点
	 * @param pathNo 工作流的边号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private WorkFlowDto submitWorkFlow(SwfLogTransferDto swfLogTransferDto, SwfLogDto swfLogDto, SwfLogDto swfLogFunctionIn, int logNo, int pathNo) {
		WorkFlowDto workFlowDto = new WorkFlowDto();
		WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
		//变更当前节点的状态
		//暂时保留当前工作节点的信息,作为工作流的提交保存的当前节点内容 swfLogDtoTemp此时是当前节点的信息(已处理)
		SwfLogDto swfLogDtoTemp = new SwfLogDto();
		swfLogDtoTemp = swfLogDto;
		//如果有结束标志的点，无论后面有任何的设置，都要立即结束，不用判断下面的节点和关系等等
		if ("1".equals(swfLogDto.getEndFlag())){
			//结束工作流
			//首先结束该节点前的失陪节点 ,为了稳妥，先查询此流程的taskType='M'类型的结束吧
			workFlowDto.setUpdate(true);
			swfLogDtoTemp.setHandlerCode(swfLogTransferDto.getUserUserCode() );
			swfLogDtoTemp.setHandlerName(swfLogTransferDto.getUserUserName() );
			workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
			//reason :由于结案是可能有多个结案的，所以当判断还存在没有关闭的结案，则流程不结束。
			//等待所有的结案都完毕时，流程才结束。
			if ("endca".equals(swfLogDtoTemp.getNodeType()) || "cance".equals(swfLogDtoTemp.getNodeType())){
//	            	2。查找是否只有一个活动的理算，如果理算超过1个，则不能关闭流程
				String conditionsClaim    = "SELECT * FROM SwfLog s WHERE flowId= ?1 and nodeType='claim' and nodestatus <> '6'";
				String conditionsEndNode  = "SELECT * FROM SwfLog s WHERE flowId= ?1 and endflag='1' and nodestatus = '4'";
				String conditionsCompe  = "SELECT * FROM SwfLog s WHERE flowId= ?1 and nodeType='compe' and nodestatus <> '5'";
				String conditionsEnd  = "SELECT * FROM SwfLog s WHERE flowId= ?1 and endflag='1' ";
				Query claimListQuery = entityManager.createNativeQuery(conditionsClaim);
				claimListQuery.setParameter(1, swfLogDtoTemp.getFlowId());
				Query endNodeListQuery = entityManager.createNativeQuery(conditionsEndNode);
				endNodeListQuery.setParameter(1, swfLogDtoTemp.getFlowId());
				Query compeListQuery = entityManager.createNativeQuery(conditionsCompe);
				compeListQuery.setParameter(1, swfLogDtoTemp.getFlowId());
				Query endListQuery = entityManager.createNativeQuery(conditionsEnd);
				endListQuery.setParameter(1, swfLogDtoTemp.getFlowId());
				//查找该案的立案节点数
				List<SwfLogDto> claimList = claimListQuery.getResultList();
				//查找该案的已结束的节点数
				List<SwfLogDto> endNodeList  = endNodeListQuery.getResultList();
				//查找理算节点数
				List<SwfLogDto> compeList = compeListQuery.getResultList();
				//查找结案节点数
				List<SwfLogDto> endList  = endListQuery.getResultList();
				//假设发现还没有结完案子的流程，则不将流程结束，
				//只是关闭掉目前立案的相关的那个理算，直接返回现有的workFlowDto.
				if ( (claimList !=null && endNodeList != null && claimList.size() - endNodeList.size() >1) ||
						(compeList !=null && endNodeList != null && compeList.size() - endNodeList.size() >1 ||
								(endList != null && endNodeList != null && endList.size() - endNodeList.size() > 1))){
					workFlowDto.setClose(false);
					return workFlowDto ;
				}
			}
			workFlowDto.setClose(true);
			SwfFlowMainDto swfFlowMainDto = new  SwfFlowMainDto();
			//如果是第一个节点，现在还没有工作流主表内容呢，所以不需要查询的。
			SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey(swfLogDto.getFlowId().trim());
			swfFlowMainDto = convert(swfFlowMainDao.findOne(swfFlowMainKey), SwfFlowMainDto.class);
			if (swfFlowMainDto!=null){
				swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ));
				swfFlowMainDto.setFlowStatus("0");
			}
			workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto) ;
			return workFlowDto ;
		}
		//一般情况下，NextBusinessNo和BusinessNo都是相同的;除了赔款计算书的节点
		if (!"compp".equals(swfLogDto.getNodeType())){
			swfLogDto.setBusinessNo(swfLogTransferDto.getNextBusinessNo());
		}
		swfLogDto.setNextBusinessNo(swfLogTransferDto.getNextBusinessNo());
		String nodeType = "";
		List<SwfLogDto> swfLogDtoList = swfLogTransferDto.getSwfLogNextList();
		if(swfLogDtoList!=null){
			for(int i=0;i<swfLogDtoList.size();i++){
				SwfLogDto swfLogDtoM = (SwfLogDto)swfLogDtoList.get(i);
				nodeType = swfLogDtoM.getNodeType();
			}
		}
		if("speci".equals(nodeType)){
			swfLogDto.setRiskCode(swfLogDto.getBusinessNo().substring(1, 5));
		}
		//提交工作流
		//由于有些节点的keyin keyout不是上个节点的流入，所以只得单独加keyin
		//判断是不是人到人的提交,根据设置的标志nextNodeListType
		if("1".equals(swfLogTransferDto.getNextNodeListType())){
			//支持指定的
			workFlowDtoTemp = getSubmitFlowInfo(swfLogTransferDto,swfLogDto,swfLogFunctionIn,logNo,pathNo) ;
		}else{
			//支持从模板上取得
			workFlowDtoTemp=getSubmitFlowInfo(swfLogTransferDto,swfLogDto,swfLogFunctionIn.getKeyIn(),logNo,pathNo) ;
		}

		//设置处理人员
		swfLogDtoTemp.setHandlerCode(swfLogTransferDto.getUserUserCode());
		swfLogDtoTemp.setHandlerName(swfLogTransferDto.getUserUserName());
		if("speci".equals(nodeType)){
			swfLogDtoTemp.setRiskCode(swfLogDtoTemp.getBusinessNo().substring(1, 5));
		}
		//如果有定损的话，设置定损类型
		if (swfLogFunctionIn.getTypeFlag()!=null&&swfLogFunctionIn.getTypeFlag().length()>0){
			swfLogDtoTemp.setTypeFlag(swfLogFunctionIn.getTypeFlag());
		}
		if ("9".equals(workFlowDto.getStatus())){
			//设置工作流的这个节点为异常
			swfLogDtoTemp.setNodeStatus("9");
		}else{
			//正常流转，没有任务异常
			workFlowDto.setUpdate(true);
			//核损，实赔
			if (workFlowDtoTemp.isUpdate()){
				//表示经过提交操作发现以近有后面的节点，只要保存操作即可
				workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto() );
			}else{
				workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
				workFlowDto.setSubmit(true);
				workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList()) ;
				workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList()) ;
			}
		}
		return workFlowDto ;
	}

	/**
	 * @description 提交工作流(人到人的)
	 * @param swfLogTransferDto 工作流中转对象
	 * @param swfLogFunctionInDto 新的工作流
	 * @param swfLogFunctionInOldDto 旧的工作流
	 * @param logNo 工作流点
	 * @param pathNo 工作流的边
	 * @return
	 */
	private WorkFlowDto getSubmitFlowInfo(SwfLogTransferDto swfLogTransferDto, SwfLogDto swfLogFunctionInDto, SwfLogDto swfLogFunctionInOldDto, int logNo, int pathNo) {
		//思路：根据当前节点的信息，查找下面的节点。并形成新的wfLog数据,wfpathLog的数据
		//1。 取得当前用户信息，写操作员信息到Dto中
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//2.取工作流号码
		String flowID = swfLogFunctionInDto.getFlowId() ;
		//3.取工作流的模板号
		int modelNo= swfLogFunctionInDto.getModelNo() ;
		//4.查询节点表wfNode的定义
		//模板的节点
		List<SwfNodeTransferDto> wfNodeDtoList = new ArrayList<SwfNodeTransferDto>();
		//整理后需要新插入的工作流程节点
		List<SwfLogDto> wfLogDtoList = new ArrayList<SwfLogDto>();
		//整理后需要新插入的工作流程边
		List<SwfPathLogDto> wfPathLogDtoList = new ArrayList<SwfPathLogDto>();
		//存放从界面传过来的需要送的多个节点
		List<SwfLogDto> swfNodeNextList = new ArrayList<SwfLogDto>();
		//查询节点的详细定义
		swfNodeNextList = swfLogTransferDto.getSwfLogNextList();
		//下一个节点定义的内容
		int nextNodeNo = 0;
		String nodeType = "";
		for(int n=0;n<swfNodeNextList.size();n++){
			//swfLogNext 下一个节点从界面传进的定义
			SwfLogDto swfLogNext = (SwfLogDto)swfNodeNextList.get(n) ;
			if(swfLogNext.getNodeNo()!=null){
				nextNodeNo = swfLogNext.getNodeNo() ;
			}
			nodeType=swfLogNext.getNodeType() ;
			//异常判断，如果nextNodeNo=0 说明没找到点,那目前只能是不操作这个下个节点了。以后讨论
			//目前允许利用nodeType进行传递内容的
			//在facade只传节点类型进入工作流中就可以的。
			SwfNodeDto swfNodeDto = new SwfNodeDto();
			SwfNodeTransferDto swfNodeTransferDto = new SwfNodeTransferDto();
			if ((nextNodeNo==0)&&(!"".equals(nodeType))){
				List<SwfNode> swfNodeList = swfNodeDao.getFirstNodeTypeNode(modelNo, nodeType);
				if (null != swfNodeList && swfNodeList.size() > 0) {
					swfNodeDto = convert(swfNodeList.get(0), SwfNodeDto.class);
				}
			}else{
				if (nextNodeNo==0){
					continue;
				}
				SwfNodeKey swfNodeKey = new SwfNodeKey(modelNo, nextNodeNo);
				swfNodeDto = convert(swfNodeDao.findOne(swfNodeKey), SwfNodeDto.class);
			}
			if (swfNodeDto!=null){
				//可以正确查询到下一个节点上的信息.
				swfNodeTransferDto.setSwfNodeDto(swfNodeDto);
				if (null!=swfLogNext.getHandlerCode()&&swfLogNext.getHandlerCode().length()>0){
					swfNodeDto.setHandlerCode(swfLogNext.getHandlerCode() );
					swfNodeDto.setHandlerName(swfLogNext.getHandlerName() );
				}
				//节点上的附加信息 当前预设置,以后也不做保留的，只用来对下个节点起作用的
				//默认为本节点数据的附加内容，但是如果外部设置了新的值，则以新的为准
				swfNodeTransferDto.setScheduleID(swfLogFunctionInDto.getScheduleId());
				swfNodeTransferDto.setLossItemCode(swfLogFunctionInDto.getLossitemCode());
				swfNodeTransferDto.setLossItemName(swfLogFunctionInDto.getLossitemName());
				swfNodeTransferDto.setInsureCarFlag(swfLogFunctionInDto.getInsurecarFlag()) ;
				swfNodeTransferDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag()) ;
				swfNodeTransferDto.setHandlerRange(swfLogFunctionInDto.getHandlerRange()) ;
				swfNodeTransferDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree()) ;
				swfNodeTransferDto.setHandleDept(swfLogTransferDto.getNewHandleDept());
				swfNodeTransferDto.setDeptName(swfLogTransferDto.getNewDeptName());

				if (null != swfLogNext.getScheduleId() && swfLogNext.getScheduleId() > 0) {
					swfNodeTransferDto.setScheduleID(swfLogNext.getScheduleId() );
				}
				if (!"".equals(swfLogNext.getLossitemCode())){
					swfNodeTransferDto.setLossItemCode(swfLogNext.getLossitemCode() );
				}
				if (!"".equals(swfLogNext.getLossitemName())){
					swfNodeTransferDto.setLossItemName(swfLogNext.getLossitemName() );
				}
				if (!"".equals(swfLogNext.getInsurecarFlag())){
					swfNodeTransferDto.setInsureCarFlag(swfLogNext.getInsurecarFlag() ) ;
				}
				if (!"".equals(swfLogNext.getTypeFlag())) {
					swfNodeTransferDto.setTypeFlag(swfLogNext.getTypeFlag() ) ;
				}
				if (!"".equals(swfLogNext.getHandlerRange())){
					swfNodeTransferDto.setHandlerRange(swfLogNext.getHandlerRange() ) ;
				}
				if (!"".equals(swfLogNext.getExigenceGree())){
					swfNodeTransferDto.setExigenceGree(swfLogNext.getExigenceGree() ) ;
				}
				if (!"".equals(swfLogNext.getHandleDept())){
					swfNodeTransferDto.setHandleDept (swfLogNext.getHandleDept ()) ;
				}
				if (!"".equals(swfLogNext.getDeptName())){
					swfNodeTransferDto.setDeptName (swfLogNext.getDeptName ()) ;
				}
				//reason : 由于强三必须支持立案是按照不同的保单来的
				if ("claim".equals(swfNodeDto.getNodeType())||"compe".equals(swfNodeDto.getNodeType())||"cance".equals(swfNodeDto.getNodeType())){
					if (!"".equals(swfLogNext.getPolicyNo())){
						swfNodeTransferDto.setPolicyNo (swfLogNext.getPolicyNo ()) ;
					}
					if (!"".equals(swfLogNext.getRiskCode())){
						swfNodeTransferDto.setRiskCode(swfLogNext.getRiskCode ()) ;
					}
					if (!"".equals(swfLogNext.getKeyIn())){
						swfNodeTransferDto.setKeyIn(swfLogNext.getKeyIn() );
					}
					if (!"".equals(swfLogNext.getBusinessNo())){
						swfNodeTransferDto.setBusinessNo(swfLogNext.getBusinessNo() );
					}
				}
				wfNodeDtoList.add(swfNodeTransferDto);
			}
		}
		//5.根据下个工作流节点写工作流程的点和线的数据
		if (wfNodeDtoList.size()>0){
			for(int n=0;n<wfNodeDtoList.size();n++){
				SwfNodeDto wfNodeDto = new SwfNodeDto();
				SwfNodeTransferDto swfNodeTransferDto = new SwfNodeTransferDto();
				swfNodeTransferDto = (SwfNodeTransferDto) wfNodeDtoList.get(n);
				wfNodeDto = swfNodeTransferDto.getSwfNodeDto();
				//6.写流程节点表wfLog
				SwfLogDto wfLogDtoTemp = new SwfLogDto();
				//设置wfLogDtoTemp
				//判断是否在当前的流程中，已经有被定义成该节点的存在，并且状态为0,没有处理，（特殊节点，如果是核损，实赔呢？因为允许多次提交）
				//如果有，就不用再插入数据库了
				List<SwfLogDto> wfLogHasSaveList = new ArrayList<SwfLogDto>();
				//单证节点不应该有大量的多余节点，是要聚合的。。后来的定损调度也需要合并的
				if ("certi".equals(wfNodeDto.getNodeType()) ||"compe".equals(wfNodeDto.getNodeType())){
					//由于强三的加入，是否可以考虑，一个保单上的节点是不能重复的。。比如单证，但是理算因为保单不同，允许一个保单一个。
					if(swfNodeTransferDto.getPolicyNo()!=null&&swfNodeTransferDto.getPolicyNo().length()>1){
						this.convertCollection(swfLogDao.findNoDealNodeByModelNodeNoByPolicyNo(flowID, "4",wfNodeDto.getNodeNo(), swfNodeTransferDto.getRiskCode(), swfNodeTransferDto.getPolicyNo()), wfLogHasSaveList, SwfLogDto.class);
					}
				}
				if(wfLogHasSaveList.size()>0){
					//解决多点聚合的时候，产生了大量的多余节点的问题
					//从数据库中查询到已经存在的节点，并把它设置成要去的节点
					wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.get(0);
					//如果存在这样的数据，则不需要插入wflog，只要在wfPathlog中增加相应的边就可以了
					//7.写流程线表wfPathLog
				}else{
					//如果当前节点为调度，设置当前节点的附加信息
					//初始化下一个节点的各项信息
					getSwfLogDtoInfoBySwfNode(wfLogDtoTemp,swfNodeTransferDto,swfLogTransferDto,flowID,modelNo,logNo,"0",swfLogFunctionInOldDto.getKeyIn(),swfLogFunctionInDto);
					wfLogDtoList.add(wfLogDtoTemp);
					logNo++;
				}
				//7.写流程线表wfPathLog
				SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
				if("speci".equals(wfLogDtoTemp.getNodeType())){
					swfLogFunctionInDto = convert(swfLogDao.findByflowIdAndNodeType(swfLogFunctionInDto.getFlowId(), "claim").get(0), SwfLogDto.class);
				}
				getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
				wfPathLogDtoList.add(swfPathLogDto);
				pathNo++;
			}
			workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
			workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
			workFlowDto.setSubmit(true);
		}else{
			//设置异常
			workFlowDto.setStatus("9");
		}
		return workFlowDto;
	}

	/**
	 * @description 第二部分：工作流引擎逆向操作
	 * @param swfLogTransferDto 工作流中转对象
	 * @param flowId 流号码
	 * @param logNo 工作流点
	 * @param swfLogFunctionInDto 当前工作流
	 * @return
	 */
	private WorkFlowDto backWorkFlow(SwfLogTransferDto swfLogTransferDto, String flowId, Integer logNo,	SwfLogDto swfLogFunctionInDto) {
		WorkFlowDto workFlowDto = new WorkFlowDto();
		if("1".equals(swfLogTransferDto.getNextNodeListType())){
			if (swfLogTransferDto.getSwfLogNextList()!=null&&swfLogTransferDto.getSwfLogNextList().size() >0){
				//指定退回节点集合（通用）,lixiang增加一种直接指定flowid,logno序列的退回方式 假设为NextNodeList不为null的\
				workFlowDto = getBackFlowInfoByNextNodeList(swfLogTransferDto,flowId,logNo,swfLogFunctionInDto);
			}else{
				workFlowDto = getBackFlowInfoByVerif(swfLogTransferDto,flowId,logNo,swfLogFunctionInDto);
				//指定退回节点(按当前LogNo逐级递减找到第一个要退回的节点) 核损专用
			}
		}else{
			//根据工作流日志swflog表进行回退，即退回以当前节点logNo为终点的所有起点logNo对应的节点
			workFlowDto = getBackFlowInfo(swfLogTransferDto, flowId, logNo);
		}
		return workFlowDto;
	}

	/**
	 * @description 回退的工作流(根据指定的节点回退)
	 * @param swfLogTransferDto 工作流中转对象
	 * @param flowId 工作流号
	 * @param logNo 工作流点
	 * @param swfLogFunctionInDto 当前工作流
	 * @return
	 */
	private WorkFlowDto getBackFlowInfoByNextNodeList(SwfLogTransferDto swfLogTransferDto, String flowId, Integer logNo,SwfLogDto swfLogFunctionInDto) {
		// 思路：根据当前节点的信息，查找下面的节点。并形成新的wfLog数据,wfpathLog的数据
		//1。 取得当前用户信息，写操作员信息到Dto
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//2.查询当前节点工作流数据
		SwfLogDto swfLogDto = new SwfLogDto();
		SwfLogKey swfLogKey = new SwfLogKey(flowId, logNo);
		swfLogDto = convert(swfLogDao.findOne(swfLogKey), SwfLogDto.class);
		// 车险关联里赔的时候,理算退回的时候,商业险和交强险同时退回
		SwfLogDto swfLogDto2 = null;
		if ("compe".equals(swfLogDto.getNodeType())) {
			List<SwfLogDto> swfLogList = new ArrayList<SwfLogDto>();
			this.convertCollection(swfLogDao.findByconditions(flowId, "compe"), swfLogList, SwfLogDto.class);
			for(int n=0;n<swfLogList.size();n++){
				SwfLogDto tmpSwfLog = (SwfLogDto) swfLogList.get(n);
				if (tmpSwfLog.getLogNo() != logNo) {
					swfLogDto2 = tmpSwfLog;
					break;
				}
			}
		}
		//3.取工作流的模板号
		int modelNo = swfLogDto.getModelNo();
		//4.查询节点表swfPath中所对应的上个节点的定义
		// 如果从指定节点开始计算的
		List<SwfLogDto> swfNodeNextList = swfLogTransferDto.getSwfLogNextList();
		if (swfNodeNextList != null) {
			// 获取wflog表中flowID的最大的logno的开始值
			int llogNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId());
			if (llogNo == 0) {
				llogNo = 1;
			}
			int pathNo = swfPathLogDao.getMaxPathNo(swfLogDto.getFlowId());
			if (pathNo == 0) {
				pathNo = 1;
			}
			List<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
			List<SwfPathLogDto> swfPathLogDtoList = new ArrayList<SwfPathLogDto>();
			// 根据指定的节点号进行回退的操作。
			for(int n=0;n<swfNodeNextList.size();n++) {
				// 外部定义
				SwfLogDto swfLogDtoTemp = new SwfLogDto();
				swfLogDtoTemp = (SwfLogDto) swfNodeNextList.get(n);
				//6.写流程节点表wfLog
				// 根据定义，和原来的节点内容形成新的节点
				swfLogDtoTemp.setLogNo(llogNo);
				swfLogDtoTemp.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
				swfLogDtoTemp.setHandleTime(swfLogDtoTemp.getFlowInTime());
				swfLogDtoTemp.setSubmitTime("");
				// 表示退回的
				swfLogDtoTemp.setNodeStatus("3");
				// 设置节点的名称
				String titleAttr = swfLogDtoTemp.getNodeName() + "节点" + "流入时间：" + swfLogDto.getFlowInTime() + " 上一节点操作人:" + swfLogTransferDto.getUserUserName();
				swfLogDtoTemp.setTitleStr(titleAttr);
				swfLogDtoTemp.setBeforeHandlerCode(swfLogTransferDto.getUserUserCode());
				swfLogDtoTemp.setBeforeHandlerName(swfLogTransferDto.getUserUserName());
				// 设置从哪个节点回退的标志
				// 比如新产生的节点知道是从哪里退回来的
				swfLogDtoTemp.setBusinessType(swfLogDto.getNodeType());
				swfLogDtoList.add(swfLogDtoTemp);
				// 回退操作特有的内容,但是回退操作的那个人是谁呢??
				//7.写流程线表wfPathLog
				SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
				getSwfPathLogDtoInfoBySwfLog(swfPathLogDto, swfLogDto, swfLogDtoTemp, flowId, modelNo, pathNo);
				swfPathLogDtoList.add(swfPathLogDto);
				if (swfLogDto2 != null) {
					pathNo++;
					SwfPathLogDto swfPathLogDto2 = new SwfPathLogDto();
					getSwfPathLogDtoInfoBySwfLog(swfPathLogDto2, swfLogDto2, swfLogDtoTemp, flowId, modelNo, pathNo);
					swfPathLogDtoList.add(swfPathLogDto2);
				}
				llogNo++;
				pathNo++;
			}
			// 加到Dto中
			workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
			workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
			workFlowDto.setSubmit(true);
			// 设置为已回退
			swfLogDto.setNodeStatus("5");
			// 提交时间
			swfLogDto.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
			workFlowDto.setUpdate(true);
			workFlowDto.setUpdateSwfLogDto(swfLogDto);
			if (swfLogDto2 != null) {
				// 设置为已回退
				swfLogDto2.setNodeStatus("5");
				// 提交时间
				swfLogDto2.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
				workFlowDto.setUpdateSwfLog2Dto(swfLogDto2);
			}
		}
		return workFlowDto;
	}

	/**
	 * @description 回退的工作流(指定退回节点,按当前LogNo逐级递减找到第一个要退回的节点)
	 * @param swfLogTransferDto 工作流中转对象
	 * @param flowId 工作流号
	 * @param logNo 工作流点
	 * @param swfLogFunctionInDto 当前工作流
	 * @return
	 */
	private WorkFlowDto getBackFlowInfoByVerif(SwfLogTransferDto swfLogTransferDto, String flowId, Integer logNo,SwfLogDto swfLogFunctionInDto) {
		// 思路：根据当前节点的信息，查找下面的节点。并形成新的wfLog数据,wfpathLog的数据
		//1。 取得当前用户信息，写操作员信息到Dto中
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//2.查询当前节点工作流数据
		SwfLogDto swfLogDto = new SwfLogDto();
		SwfLogKey swfLogKey = new SwfLogKey(flowId, logNo);
		swfLogDto = convert(swfLogDao.findOne(swfLogKey), SwfLogDto.class);
		//3.取工作流的模板号
		int modelNo = swfLogDto.getModelNo();
		//4.查询上一个要回退的节点所对应的swflog
		// 查询此节点前的所有的节点信息
		SwfLogDto swfLogNextNode = new SwfLogDto();
		// 查询上一个要回退的节点所对应的swflog（按LogNo逐级递减找到第一个要回退的节点）
		for (int i = logNo - 1; i > 0; i--) {
			SwfLogKey lastSwfLogKey = new SwfLogKey(flowId, i);
			swfLogNextNode = convert(swfLogDao.findOne(lastSwfLogKey), SwfLogDto.class);
			if (swfLogNextNode.getNodeType().trim().equals(swfLogFunctionInDto.getNodeType())
					&& swfLogNextNode.getLossitemCode().trim().equals(swfLogFunctionInDto.getLossitemCode().trim())) {
				break;
			}
		}
		//5.获取wflog表中flowID的最大的logno的开始值
		int llogNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId());
		if (llogNo == 0) {
			llogNo = 1;
		}
		int pathNo = swfPathLogDao.getMaxPathNo(swfLogDto.getFlowId());
		if (pathNo == 0) {
			pathNo = 1;
		}
		List<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
		List<SwfPathLogDto> swfPathLogDtoList = new ArrayList<SwfPathLogDto>();
		// 根据定义，和原来的节点内容形成新的节点
		swfLogNextNode.setLogNo(llogNo);
		swfLogNextNode.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		swfLogNextNode.setSubmitTime("");
		swfLogNextNode.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		// 表示退回的
		swfLogNextNode.setNodeStatus("3");
		// 设置节点的名称
		String titleAttr = swfLogNextNode.getNodeName() + "节点" + "流入时间：" + swfLogDto.getFlowInTime() + " 上一节点操作人:"	+ swfLogTransferDto.getUserUserName();
		swfLogNextNode.setTitleStr(titleAttr);
		swfLogNextNode.setBeforeHandlerCode(swfLogTransferDto.getUserUserCode());
		swfLogNextNode.setBeforeHandlerName(swfLogTransferDto.getUserUserName());
		// 定损环节退回的任务写明退回源节点
		if (swfLogFunctionInDto.getBusinessType() != null && !"".equals(swfLogFunctionInDto.getBusinessType())) {
			swfLogNextNode.setBusinessType(swfLogFunctionInDto.getBusinessType());
		}
		swfLogDtoList.add(swfLogNextNode);
		//7.写流程线表wfPathLog
		SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
		getSwfPathLogDtoInfoBySwfLog(swfPathLogDto, swfLogDto, swfLogNextNode, flowId, modelNo, pathNo);
		swfPathLogDtoList.add(swfPathLogDto);
		// 加到Dto中
		workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
		workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
		workFlowDto.setSubmit(true);
		// 设置为已回退
		swfLogDto.setNodeStatus("5");
		// 提交时间
		swfLogDto.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
		workFlowDto.setUpdate(true);
		workFlowDto.setUpdateSwfLogDto(swfLogDto);
		return workFlowDto;
	}

	/**
	 * @description 回退的工作流(根据工作流日志swflog表进行回退，即退回以当前节点logNo为终点的所有起点logNo对应的节点)
	 * @param swfLogTransferDto 工作流中转对象
	 * @param flowId 工作流号
	 * @param logNo 工作流点
	 * @return
	 */
	private WorkFlowDto getBackFlowInfo(SwfLogTransferDto swfLogTransferDto, String flowId, Integer logNo) {
		// 思路：根据当前节点的信息，查找下面的节点。并形成新的wfLog数据,wfpathLog的数据
		//1。 取得当前用户信息，写操作员信息到Dto中
		WorkFlowDto workFlowDto = new WorkFlowDto();
		//2.查询当前节点工作流数据
		SwfLogDto swfLogDto = new SwfLogDto();
		SwfLogKey swfLogKey = new SwfLogKey(flowId, logNo);
		swfLogDto = convert(swfLogDao.findOne(swfLogKey), SwfLogDto.class);
		//3.取工作流的模板号
		int modelNo = swfLogDto.getModelNo();
		//4.查询节点表swfPath中所对应的上个节点的定义
		// 查询此节点前的所有的节点信息
		List<SwfLogDto> swfLogDtoBackList = new ArrayList<SwfLogDto>();
		this.convertCollection(swfLogDao.findPerviousNodes(flowId, logNo), swfLogDtoBackList, SwfLogDto.class);;
		// 如果从数据库
		if (swfLogDtoBackList != null) {
			// 获取wflog表中flowID的最大的logno的开始值
			int llogNo = swfLogDao.getMaxLogNo(swfLogDto.getFlowId());
			llogNo ++ ;
			if (llogNo == 0) {
				llogNo = 1;
			}
			int pathNo = swfPathLogDao.getMaxPathNo(swfLogDto.getFlowId());
			pathNo ++ ;
			if (pathNo == 0) {
				pathNo = 1;
			}
			List<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
			List<SwfPathLogDto> swfPathLogDtoList = new ArrayList<SwfPathLogDto>();
			for(int n=0;n<swfLogDtoBackList.size();n++) {
				SwfLogDto swfLogDtoTemp = new SwfLogDto();
				swfLogDtoTemp = (SwfLogDto) swfLogDtoBackList.get(n);
				//6.写流程节点表wfLog
				// 根据定义，和原来的节点内容形成新的节点
				swfLogDtoTemp.setLogNo(llogNo);
				swfLogDtoTemp.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
				// 表示退回的
				swfLogDtoTemp.setNodeStatus("3");
				// 设置节点的名称
				String titleAttr = swfLogDtoTemp.getNodeName() + "节点" + "流入时间：" + swfLogDto.getFlowInTime() + " 上一节点操作人:" + swfLogTransferDto.getUserUserName();
				swfLogDtoTemp.setTitleStr(titleAttr);
				swfLogDtoTemp.setBeforeHandlerCode(swfLogTransferDto.getUserUserCode());
				swfLogDtoTemp.setBeforeHandlerName(swfLogTransferDto.getUserUserName());

				swfLogDtoList.add(swfLogDtoTemp);
				// 回退操作特有的内容,但是回退操作的那个人是谁呢??
				//7.写流程线表wfPathLog
				SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
				getSwfPathLogDtoInfoBySwfLog(swfPathLogDto, swfLogDto, swfLogDtoTemp, flowId, modelNo, pathNo);
				swfPathLogDtoList.add(swfPathLogDto);
				llogNo++;
				pathNo++;
			}
			// 加到Dto中
			workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
			workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
			workFlowDto.setSubmit(true);
			// 设置为已回退
			swfLogDto.setNodeStatus("5");
			// 日期改成时分秒后，存入数据也是YEAR_TO_SECOND
			// 提交时间
			swfLogDto.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
			workFlowDto.setUpdate(true);
			workFlowDto.setUpdateSwfLogDto(swfLogDto);
		}
		return workFlowDto;
	}
	/**
	 * @description 修改模板信息初始化模板数据
	 * @author 杨航
	 * @date 2017年11月18日 下午2:13:23
	 * @param modelNo 模板号
	 * @return workFlowModelDto 创建工作流模板所需对象
	 */
	@Override
	public WorkFlowModelDto modifyWorkFlowModelInfo(Integer modelNo) {
		if (modelNo == null || modelNo < 1) {
			LOGGER.error("开始修改模板号为{}的模板", modelNo);
		} else {
			LOGGER.error("修改模板信息初始化模板数据模板号入参不合法！");
		}
		// 查询模板主表对象
		SwfModelMain swfModelMain = swfModelMainDao.findOne(new SwfModelMainKey(modelNo));
		// 查询模板路径
		List<SwfPath> swfPathList = swfPathDao.findAll(
				Specifications.<SwfPath>and().eq("modelNo", modelNo).build(),
				new Sort(Direction.ASC, new String[] { "pathNo" }));
		// 查询模板节点
		List<SwfNode> swfNodeList = swfNodeDao.findAll(Specifications.<SwfNode>and().eq("modelNo", modelNo).build(),
				new Sort(Direction.ASC, new String[] { "nodeNo" }));
		WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();
		workFlowModelDto.setSwfModelMainDto(this.convert(swfModelMain,SwfModelMainDto.class));
		// 实体类转换成Dto
		List<SwfPathDto> swfPathDtoList = new ArrayList<>();
		List<SwfNodeDto> SwfNodeDtoList = new ArrayList<>();
		this.convertCollection(swfPathList, swfPathDtoList, SwfPathDto.class);
		this.convertCollection(swfNodeList, SwfNodeDtoList, SwfNodeDto.class);
		workFlowModelDto.setSwfPathDtoList(swfPathDtoList);
		workFlowModelDto.setSwfNodeDtoList(SwfNodeDtoList);
		return workFlowModelDto;
	}

	/**
	 * @description:方法功能简述: 为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
	 * @author 安齐崇
	 * @date 2017年12月8日上午10:28:54
	 * @param flowID
	 * @param logNo
	 * @param userCode
	 * @param userName
	 */
	@Override
	public void avoidUpdateSampCompe(String flowID, int logNo, String userCode, String userName) {
		SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(flowID, logNo));
		if("compe".equals(swfLog.getNodeType())){
			swfLog.setHandlerCode(userCode);
			swfLog.setHandlerName(userName);
		}
		swfLogDao.save(swfLog);
	}
}
