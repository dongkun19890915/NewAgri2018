package com.sinosoft.agriclaim.core.combinemanage.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.*;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.registmanage.entity.*;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLCheckDtoExt;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLClaimDtoExt;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLClaimLossDtoExt;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLCombineDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLPropDtoExt;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistTextDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogTransferDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLextDao;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLAccIPersonService;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLclaimStatusService;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLextService;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.cetainmanage.service.PrpLPropService;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLAcciCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLAcciCheckTextDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckExtDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLCheckLossDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossDao;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrpLverifyLossExtDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckKey;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLoss;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLAcciCheckService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckExtService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckLossService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossExtService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimFeeDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimLossDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLCompensateEarDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLEarDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLoss;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLCompensateEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimFeeService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimLossService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLCompensateEarService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLLTextService;
import com.sinosoft.agriclaim.core.combinemanage.dao.PrpLCombineDao;
import com.sinosoft.agriclaim.core.combinemanage.entity.PrpLCombine;
import com.sinosoft.agriclaim.core.combinemanage.entity.PrpLCombineKey;
import com.sinosoft.agriclaim.core.combinemanage.service.PrpLCombineService;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateHouseDao;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateHouseService;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLDocDao;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLDocService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistRPolicyDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistExtService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistRPolicyService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistTextService;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleItemDao;
import com.sinosoft.agriclaim.core.schedulemanage.dao.PrpLScheduleMainWfDao;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWf;
import com.sinosoft.agriclaim.core.schedulemanage.entity.PrpLScheduleMainWfKey;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleItemService;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainWfService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfFlowMainService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogStoreService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNodeService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNotionService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathLogService;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.endorsemanage.CheckStatusApi;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.policymanage.PolicyQueryApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.customer.PrpDcustomerApi;
import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.PrpDriskConfigApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-25 08:10:12.537
 * @description 并案关联表Core接口实现
 */
@Service
@Transactional
public class PrpLCombineServiceImpl extends BaseServiceImpl implements PrpLCombineService {
	/** log志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCombineServiceImpl.class);

	@Autowired
	private PrpLRegistDao prpLRegistDao; 

	@Autowired
	private PageInitCommonService pageInitCommonService;

	@Autowired
	private PolicyQueryApi policyQueryApi;

	@Autowired
	private CheckStatusApi checkStatusApi;

	@Autowired
	private PrpPheadApi prpPheadApi;

	@Autowired
	private PrpDriskConfigApi prpDriskConfigApi;

	@Autowired
	private PrpLCompensateDao prpLCompensateDao;

	@Autowired
	private PrpLRegistDao prpLregistDao;

	@Autowired
	private PrpDcustomerApi prpDcustomerApi;

	@Autowired
	private PrpDcurrencyApi prpDcurrencyApi;
	
	@Autowired
	private PrpLRegistRPolicyDao prpLRegistRPolicyDao;
	
	@Autowired
	private CodeApi codeApi;
	
	@Autowired
	private CompanyApi companyApi;

	
	@Autowired
	private PrpDkindApi prpDkindApi;


	@Autowired
	private PrpDcodeApi prpDcodeApi;

	@Autowired
	private PrpLScheduleMainWfDao prpLScheduleMainWfDao;
	
	@Autowired
	private PrpDriskApi prpDriskApi;

	private int RULE_LENGTH = 70; // rule字段的长度
	
	@Autowired
	private PrpLCombineDao prpLCombineDao;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PrpLRegistService prpLRegistService;
	@Autowired
	private BillNoApi billNoApi;
	@Autowired
	private SwfLogService swfLogService;
	@Autowired
	private SwfNodeService swfNodeService;
	@Autowired
	private PrpLclaimStatusService prpLclaimStatusService;
	@Autowired
	private PrpLScheduleMainWfService prpLScheduleMainWfService;
	@Autowired
	private PrpLScheduleItemDao prpLScheduleItemDao;
	@Autowired
	private PrpLRegistExtDao prpLRegistExtDao;
	@Autowired
	private SwfLogDao swfLogDao;
	@Autowired
	private PrpLCompensateEarDao prpLCompensateEarDao;
	@Autowired
	private PrpLRegistTextDao prpLRegistTextDao;
	@Autowired
	private PrpLCheckExtDao prpLCheckExtDao;
	@Autowired
	private PrpLCheckService prpLCheckService;
	@Autowired
	private PrpLCheckLossDao prpLCheckLossDao;
	@Autowired
	private PrpLextDao prpLextDao;
	@Autowired
	private PrpLCheckDao prpLCheckDao;
	@Autowired
	private PrpLAcciCheckTextDao prpLAcciCheckTextDao;
	@Autowired
	private PrpLAcciCheckDao prpLAcciCheckDao;
	@Autowired
	private PrpLRegistTextService prpLRegistTextService;
	@Autowired
	private PrpLCheckExtService prpLCheckExtService;
	@Autowired
	private PrpLCheckLossService prpLCheckLossService;
	@Autowired
	private PrpLScheduleItemService prpLScheduleItemService;
	@Autowired
	private PrpLextService prpLextService;
	@Autowired
	private PrpLRegistExtService prpLRegistExtService;
	@Autowired
	private PrpLCompensateHouseService prpLCompensateHouseService;
	@Autowired
	private PrpLCompensateHouseDao prpLCompensateHouseDao;
	@Autowired
	private PrpLAcciCheckService prpLAcciCheckService;
	@Autowired
	private PrpLclaimStatusDao prpLclaimStatusDao;
	@Autowired
	private PrpLverifyLossExtDao prpLverifyLossExtDao;
	@Autowired
	private PrpLPropDao prpLPropDao;
	@Autowired
	private PrpLverifyLossDao prpLverifyLossDao;
	@Autowired
	private PrpLverifyLossService prpLverifyLossService;
	@Autowired
	private PrpLverifyLossExtService prpLverifyLossExtService;
	@Autowired
	private PrpLPropService prpLPropService;
	@Autowired
	private PrpLCompensateEarService prpLCompensateEarService;
	@Autowired
	private SwfFlowMainService swfFlowMainService;
	@Autowired
	private SwfPathLogService swfPathLogService;
	@Autowired
	private SwfNotionService swfNotionService;
	@Autowired
	private SwfLogStoreService swfLogStoreService;
	@Autowired
	private UtiCodeTransferApi utiCodeTransferApi;
	@Autowired
	private PrpLClaimService prpLClaimService;
	@Autowired
	private PrpLLTextService prpLLTextService;
	@Autowired
	private PrpLRegistRPolicyService prpLRegistRPolicyService;
	@Autowired
	private PrpLLTextDao prpLLTextDao;
	@Autowired
	private PrpLDocDao prpLDocDao;
	@Autowired
	private PrpLClaimFeeDao prpLClaimFeeDao;
	@Autowired
	private PrpLClaimLossDao prpLClaimLossDao;
	@Autowired
	private PrpLClaimLossService prpLClaimLossService;
	@Autowired
	private PrpLClaimFeeService prpLClaimFeeService;
	@Autowired
	private PrpLDocService prpLDocService;
	@Autowired
	private PrpLAccIPersonService prpLAccIPersonService;
	@Autowired
	private UserApi userApi;
	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private PrpLClaimDao prpLClaimDao;
	@Autowired
	private PrpLLTextDao prpLltextDao;
	@Autowired
	private PrpLAccIPersonDao prpLAccIPersonDao;
	@Autowired
	private PrpLEarDao prpLEarDao;
	@Autowired
	private PrpCmainApi prpCmainApi;
	@Autowired
	private PrpDitemAgriApi prpDitemAgriApi;
	/**
	 * @description 新增
	 * @param
	 */
	public void save(PrpLCombineDto prpLCombineDto) {
		PrpLCombine prpLCombine = this.convert(prpLCombineDto, PrpLCombine.class);
		prpLCombineDao.save(prpLCombine);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(String registNo) {
		PrpLCombineKey prpLCombineKey = new PrpLCombineKey(registNo);
		prpLCombineDao.delete(prpLCombineKey);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(PrpLCombineDto prpLCombineDto) {
		PrpLCombine prpLCombine = this.convert(prpLCombineDto, PrpLCombine.class);
		prpLCombineDao.save(prpLCombine);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public PrpLCombineDto queryByPK(String registNo) {
		PrpLCombineKey prpLCombineKey = new PrpLCombineKey(registNo);
		PrpLCombine prpLCombine = prpLCombineDao.findOne(prpLCombineKey);
		return this.convert(prpLCombine, PrpLCombineDto.class);
	}

    
    /**
     * @descption 新增合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 新增合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
	@Override
	public Map<String,String> saveCombine(List<PrpLCombineDto>  prpLCombineDtos) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		if (prpLCombineDtos.size() < 2) {
			throw new Exception("未选择要合并的报案号");
		} else {
			PrpLCombineDto prpLCombineDto = prpLCombineDtos.get(1);
			PrpLRegistKey prpLRegistKey = new PrpLRegistKey(prpLCombineDto.getRegistNo());
			PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
			PrpLRegistDto prplRegistDto = (PrpLRegistDto) this.convert(prpLRegist, PrpLRegistDto.class);
			SwfLogDto swfLogDto = new SwfLogDto();
			List<String> arrayList = new ArrayList<String>();
			List<String> arrayList1 = new ArrayList<String>();
			List<String> arrayList2 = new ArrayList<String>();
			List<String> arrayList3 = new ArrayList<String>();
			List<String> arrayList4 = new ArrayList<String>();
			List<String> combineNoList = new ArrayList<String>();
			String comCode = "";
			String combineNo = "";
			String nodeStatus = "";
			String policyno = "";
			String riskCode = "";
			for (int i = 0; i < prpLCombineDtos.size(); i++) {
				List<SwfLogDto> swfLogDtos =queryByRegistNo(prpLCombineDtos.get(i).getRegistNo());
				policyno = swfLogDtos.get(0).getPolicyNo();
				arrayList1.add(policyno);
			}
			
			for (int i = 0; i < arrayList1.size(); i++) {
				if (arrayList1.get(0).equals(arrayList1.get(i)) != true) {
					throw new Exception("不在同一保单下，不能合并案件！");
				}
			}
		for (int i = 0; i < prpLCombineDtos.size(); i++) {
				List<SwfLogDto> swfLogDtos = queryByRegistNo(prpLCombineDtos.get(i).getRegistNo());			
				if (swfLogDtos.get(0).getHandlerName()!=null&&!"".equals(swfLogDtos.get(0).getHandlerName()) ||(swfLogDtos.get(0).getHandlerCode()!=null&&!"".equals(swfLogDtos.get(0).getHandlerCode()))) {
					throw new Exception("该并案正在处理中，不能增加合并案件！");
				}
			}
			for (int i = 0; i < prpLCombineDtos.size(); i++) {
				List<SwfLogDto> swfLogDtos = queryByRegistNo(prpLCombineDtos.get(i).getRegistNo());
				nodeStatus = swfLogDtos.get(0).getNodeStatus();
				arrayList3.add(swfLogDtos.get(0).getNodeType());
				SwfLogKey swfLogKey = new SwfLogKey(swfLogDtos.get(0).getFlowId(), 3);
				SwfLog swfLog = swfLogDao.findOne(swfLogKey);
				swfLogDto = this.convert(swfLog, SwfLogDto.class);
				arrayList2.add(swfLogDto.getHandlerCode());
				arrayList4.add(swfLogDto.getHandleDept());
				arrayList.add(nodeStatus);
			}
			for (int i = 0; i < arrayList3.size(); i++) {
				if (arrayList3.get(0).equals(arrayList3.get(i)) != true) {
					throw new Exception("不同节点案件无法合并！");
				}
			}
			for (int i = 0; i < arrayList.size(); i++) {
				if (arrayList.get(0).equals(arrayList.get(i)) != true) {
					throw new Exception("节点状态不一致，不能合并案件！");
				}
			}

			if ("check".equals(String.valueOf(arrayList3.get(0)))) {
				String temp = "";
				for (int i = 0; i < arrayList4.size(); i++) {
					if (!String.valueOf(arrayList4.get(0)).equals(String.valueOf(arrayList4.get(i)))) {
						throw new Exception("定损节点指定案件处理单位须一致 ！");
					}
				}
				for (int i = 0; i < arrayList2.size(); i++) {
					if (arrayList2.get(i) != null && !"".equals(String.valueOf(arrayList2.get(i)).trim())) {
						temp = String.valueOf(arrayList2.get(i)).trim();
						break;
					}
				}
				for (int i = 0; i < arrayList2.size(); i++) {
					if (arrayList2.get(i) != null && !"".equals(String.valueOf(arrayList2.get(i)).trim())
							&& !String.valueOf(arrayList2.get(i)).trim().equals(temp)) {
						throw new Exception("定损节点指定案件处理人须一致 ！ ");
					}
				}
			}

			boolean allEmpty = true;
			PrpLCombineDto prpcombineDto = new PrpLCombineDto();
			for (int i = 0; i < prpLCombineDtos.size(); i++) {
				prpcombineDto = this.queryByPK(prpLCombineDtos.get(i).getRegistNo());
				if (prpcombineDto != null) {
					combineNo = prpcombineDto.getCombineNo();
					policyno = prpcombineDto.getPolicyNo();
					allEmpty = false;
					if (null != combineNo && !"".equals(combineNo))
						combineNoList.add(combineNo);
				}
			}
			if (null != combineNoList && combineNoList.size() >= 2) {
				for (int i = 0; i < combineNoList.size(); i++) {
					String combineNo_i = (String) combineNoList.get(i);
					for (int j = i + 1; j < combineNoList.size(); j++) {
						String combineNo_j = (String) combineNoList.get(j);
						if (!combineNo_i.equals(combineNo_j))
							throw new Exception("所选报案至少属于两个并案中，不能新增合并案件！");
					}
				}
			}
			if (allEmpty && !"".equals(combineNo) && combineNo != null) {
				throw new Exception("请选择至少一条已合并案件！");
			}
			if (prplRegistDto != null) {
				comCode = prplRegistDto.getComCode();
				riskCode = prplRegistDto.getRiskCode();
			}
			int year = DateTime.current().getYear();
			if ("".equals(combineNo) || combineNo == null) {
				String tableName = "prplcombine";
				BillNoDto BillNodto = new BillNoDto();
				BillNodto.setiComCode(comCode);
				BillNodto.setiYear(year + "");
				BillNodto.setRiskCode(riskCode);
				BillNodto.setTableName(tableName);

				Map<String, String> mapComBineNo = billNoApi.getBillNo(BillNodto);
				combineNo = mapComBineNo.get("billNo");
			}
			for (int i = 0; i < prpLCombineDtos.size(); i++) {
				prpcombineDto = new PrpLCombineDto();
				prpcombineDto.setCombineNo(combineNo);
				prpcombineDto.setPolicyNo(policyno);
				prpcombineDto.setRegistNo(prpLCombineDtos.get(i).getRegistNo());
				this.save(prpcombineDto);
			}
			map.put("code", "0000");
			map.put("message", "操作成功,生成合并案件，并案号为：" + combineNo);

		}

		return map;
	}

    /**
     * @descption 删除合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 删除合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
	
	@Override
	public Map<String,String> logicRemoveComCase(List<PrpLCombineDto>  prpLCombineDtos) throws Exception {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();

		for (int i = 0; i < prpLCombineDtos.size(); i++) {
			if(prpLCombineDtos.get(i).getCombineNo()==null||prpLCombineDtos.get(i).getCombineNo()==""){
				throw new BusinessException("您所选择的案件尚未进行合并，不可删除！");
			}
		}
		for (int i = 0; i < prpLCombineDtos.size(); i++) {
			List<SwfLogDto> swfLogDtos = queryByRegistNo(prpLCombineDtos.get(i).getRegistNo());
			if ("2".equals(swfLogDtos.get(0).getNodeStatus())&&swfLogDtos.get(0).getHandlerName()!=null&&!"".equals(swfLogDtos.get(0).getHandlerName()) ||(swfLogDtos.get(0).getHandlerCode()!=null&&!"".equals(swfLogDtos.get(0).getHandlerCode()))) {
				throw new Exception("该并案正在处理中，不能删除合并案件！");
			}
		}
		for (int i = 0; i < prpLCombineDtos.size(); i++) {
			remove(prpLCombineDtos.get(i).getRegistNo());
		}
		map.put("code", "0000");
		map.put("message", "操作成功，已取消合并案件");
		return map;
	}

    /**
     * @descption 合并查勘定损页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并查勘定损页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComCheckDetailQueryDto>  返回初始化对象集合
     */
	@Override
	public  List<ComCheckDetailQueryDto> comCheckPageInit(List<Map<String,String>> listMap) throws Exception {
		// 业务类型：ADD-新增 EDIT-修改 SHOW
		List<ComCheckDetailQueryDto> list = new ArrayList<ComCheckDetailQueryDto>();
		String registNo = ""; // 
		String riskCode = "";// 
         if(listMap.isEmpty()){
        	 throw new Exception("没有选择案件进行查勘定损");
         }
		if (null != listMap && listMap.size() >= 2) {
			for (int i = 0; i < listMap.size(); i++) {
				String combineNo_i = (String) listMap.get(i).get("combineNo");
				for (int j = i + 1; j < listMap.size(); j++) {
					String combineNo_j = (String) listMap.get(j).get("combineNo");
					if (!combineNo_i.equals(combineNo_j))
						throw new Exception("所选报案至少属于两个并案中，不能进行并案的查勘定损！");
				}
			}
		}
        List<PrpLCombineDto> combines = new ArrayList<PrpLCombineDto>();
		List<PrpLCombine> prpLCombines = prpLCombineDao.findAllByCombineNo(listMap.get(0).get("combineNo"));
		 this.convertCollection(prpLCombines,combines, PrpLCombineDto.class);
		for (int i = 0; i < combines.size(); i++) {
			PrpLCombineDto prplcombineDto = combines.get(i);
			registNo = prplcombineDto.getRegistNo();// 
			PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
			prpLRegistKey.setRegistNo(registNo);
			PrpLRegist prpLRegist = prpLRegistDao.getOne(prpLRegistKey);
			PrpLRegistDto prpLRegistDto = this.convert(prpLRegist, PrpLRegistDto.class);
			riskCode = prpLRegistDto.getRiskCode();
			ComCheckDetailQueryDto comCheckDetailQueryDto =new ComCheckDetailQueryDto();
			comCheckDetailQueryDto.setRegistNo(registNo);
			comCheckDetailQueryDto.setPrpLRegistDto(prpLRegistDto);
			comCheckDetailQueryDto.setRiskCode(riskCode);
			comCheckDetailQueryDto.setPolicyNo(prpLRegistDto.getPolicyNo());
			if (listMap.get(0).get("editType").equals("ADD")) {
				for (int j = 0; j < listMap.size(); j++){
					if (listMap.get(j).get("swfLogFlowID") != null
							&& listMap.get(j).get("swfLogLogNo") != null) {
						SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(listMap.get(j).get("swfLogFlowID"), Integer.parseInt(listMap.get(j).get("swfLogLogNo"))));
						if(registNo.equals(swfLog.getRegistNo())){
							comCheckDetailQueryDto.setSwfLogFlowID(listMap.get(j).get("swfLogFlowID"));
							comCheckDetailQueryDto.setSwfLogLogNo(listMap.get(j).get("swfLogLogNo") );
							String userCode = SinoRequestContext.getCurrentContext().getUserCode();
							PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
							SwfLogDto swfLogDto = workFlowService.holdNode(listMap.get(j).get("swfLogFlowID"),
							Integer.parseInt(listMap.get(j).get("swfLogLogNo")), userCode,
						    userInfo.getUserName());
							if ("false".equals(swfLogDto.getFlag())) {
								throw new Exception("案件已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
										+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!");
							}
						}

					}
				}
				//封装对象
				checkDtoToView(comCheckDetailQueryDto);

			} else if (listMap.get(0).get("editType").equals("EDIT")
					|| listMap.get(0).get("editType").equals("SHOW")) {
				//封装对象
				//调整
				for (int j = 0; j < listMap.size(); j++){
					if (listMap.get(j).get("swfLogFlowID") != null
							&& listMap.get(j).get("swfLogLogNo") != null) {
						SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(listMap.get(j).get("swfLogFlowID"), Integer.parseInt(listMap.get(j).get("swfLogLogNo"))));
						if(registNo.equals(swfLog.getRegistNo())){
							comCheckDetailQueryDto.setSwfLogFlowID(listMap.get(j).get("swfLogFlowID"));
							comCheckDetailQueryDto.setSwfLogLogNo(listMap.get(j).get("swfLogLogNo") );
						}

					}
				}
				checkDtoToViewNew(comCheckDetailQueryDto);
			}
			list.add(comCheckDetailQueryDto);
		}
		// 返回list
		return list;

	}

    /**
     * @descption 合并查勘定损页面初始化（EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param comCheckDetailQueryDto 合并查勘定损页面初始化（EDIT.SHOW）条件组织的对象集合
     *
     */
	public void checkDtoToViewNew( ComCheckDetailQueryDto comCheckDetailQueryDto) throws Exception {
       
		//查勘表
		PrpLCheck prpLCheck = prpLCheckDao.findOne(new PrpLCheckKey(comCheckDetailQueryDto.getRegistNo(), 1));
		PrpLCheckDto prpLcheckDto = (PrpLCheckDto) this.convert(prpLCheck, PrpLCheckDto.class);
         PrpLCheckDtoExt  prpLcheckDtoExt  =  new  PrpLCheckDtoExt();
         //报案文字表
		Specification<PrpLRegistText> specification = Specifications.<PrpLRegistText>and().eq("registNo", comCheckDetailQueryDto.getRegistNo()).eq("textType", "3").build();
		List<PrpLRegistText> prpLregistTextDtosList = prpLRegistTextDao.findAll(specification);
		/*设置查勘报告*/
		if(prpLregistTextDtosList!=null&&prpLregistTextDtosList.size()>0){
			StringBuffer context = new StringBuffer();
			for (PrpLRegistText prpLRegistText : prpLregistTextDtosList) {
				context.append("  ");
				context.append(prpLRegistText.getContext());
				context.append("\t");
			}
			comCheckDetailQueryDto.setContext(context.toString());
		}
		List<PrpLRegistTextDto> prpLregistTextDtos = new ArrayList<PrpLRegistTextDto>();
		this.convertCollection(prpLregistTextDtosList, prpLregistTextDtos, PrpLRegistTextDto.class);
		if (null == prpLcheckDto) {
			throw new Exception("该案查勘信息不存在，可能还未进行查勘");
		} else {
			// 设置查勘操作的状态为 案件修改 (正处理任务)
			Specification<PrpLclaimStatus> specification1 = Specifications.<PrpLclaimStatus>and()
					.eq("businessno", prpLcheckDto.getRegistNo()).eq("nodetype", "regis").build();
			List<PrpLclaimStatus> prpLclaimStatusDtos = prpLclaimStatusDao.findAll(specification1);
			List<PrpLclaimStatusDto> prpLclaimStatusDtoList = new ArrayList<PrpLclaimStatusDto>();
			this.convertCollection(prpLclaimStatusDtos, prpLclaimStatusDtoList, PrpLclaimStatusDto.class);
			
			// 设置立案操作的状态为 案件修改 (正处理任务)
			if (prpLclaimStatusDtoList != null&&prpLclaimStatusDtoList.size()>0) {
				if (prpLclaimStatusDtoList.get(0).getStatus().equals("7"))
					prpLcheckDtoExt.setStatus("2");
			} else {
				// 已提交，已经处理完毕的状态
				prpLcheckDtoExt.setStatus("4");
			}
            /** 承保数量 */
            Map<String, String> params = new HashMap<String, String>();
            params.put("policyNo", comCheckDetailQueryDto.getPrpLRegistDto().getPolicyNo());
            PrpCmainDto cmainDto = prpCmainApi.queryByPK(params);
            Double statQuantity = cmainDto == null? 0d:cmainDto.getStatQuantity();
            comCheckDetailQueryDto.setStatQuantity(statQuantity);
			prpLcheckDto.setDamageStartDate(comCheckDetailQueryDto.getPrpLRegistDto().getDamageStartDate());
			prpLcheckDtoExt.setDamageEndDate(comCheckDetailQueryDto.getPrpLRegistDto().getDamageEndDate());
			prpLcheckDtoExt.setRegistEstimateLoss(comCheckDetailQueryDto.getPrpLRegistDto().getEstimateLoss());
			String timeTemp = toStandardTime(comCheckDetailQueryDto.getPrpLRegistDto().getDamageStartHour());
			prpLcheckDtoExt.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
			timeTemp = toStandardTime(comCheckDetailQueryDto.getPrpLRegistDto().getDamageEndHour());
			Map<String,String>   map  =  new  HashMap<String,String>();
			map.put("riskCode",comCheckDetailQueryDto.getRiskCode());
			prpLcheckDtoExt.setRiskName(prpDriskApi.queryByPK(map).getRiskCName());
			prpLcheckDtoExt.setDamageEndHour(timeTemp.substring(0, 2));
			prpLcheckDto.setDamageAddress(comCheckDetailQueryDto.getPrpLRegistDto().getDamageAddress());

			if (comCheckDetailQueryDto.getPrpLRegistDto() != null) {
				prpLcheckDtoExt.setInsuredName(comCheckDetailQueryDto.getPrpLRegistDto().getInsuredName());
			}
		}
		
		UtiCodeTransferDto utiCodeTransferDto = utiCodeTransferApi.queryByPK("RISKCODE_DAA");
		List<PrpDcodeDto> checkNatures = prpDcodeApi.queryCodeInfoByCodeType("CheckNature",
				utiCodeTransferDto.getOuterCode());
		comCheckDetailQueryDto.setCheckNatures(checkNatures);
		int intRecentCount = pageInitCommonService.getSamePolicyRegistInfo(comCheckDetailQueryDto.getPrpLRegistDto().getPolicyNo(),
				comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo());
		prpLcheckDtoExt.setPrpLCheckDto(prpLcheckDto);
		comCheckDetailQueryDto.setPrpLcheckDtoExt(prpLcheckDtoExt);
		comCheckDetailQueryDto.setPrpLregistTextDtos(prpLregistTextDtos);
		comCheckDetailQueryDto.setIntRecentCount(intRecentCount);

		// 增加赔付数量和赔付数量单位属性
		Specification<PrpLverifyLoss> specification2 = Specifications.<PrpLverifyLoss>and()
				.eq("registNo", comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()).build();
		List<PrpLverifyLoss> prpLverifyLossDtos = prpLverifyLossDao.findAll(specification2);
		List<PrpLverifyLossDto> prpLverifyLossDtoList = new ArrayList<PrpLverifyLossDto>();
		this.convertCollection(prpLverifyLossDtos, prpLverifyLossDtoList, PrpLverifyLossDto.class);
		comCheckDetailQueryDto.setPrpLverifyLossDto(prpLverifyLossDtoList.get(0));
		//财产核定损明细清单表
		Specification<PrpLProp> specification3 = Specifications.<PrpLProp>and()
				.eq("registNo", comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()).build();
		List<PrpLProp> prpLPropDtos = prpLPropDao.findAll(specification3);
		List<PrpLPropDtoExt> prpLPropDtoList = new ArrayList<PrpLPropDtoExt>();
		List<PrpLPropDto> prpLPropDtoList1 = new ArrayList<PrpLPropDto>();
		this.convertCollection(prpLPropDtos, prpLPropDtoList1, PrpLPropDto.class);
		PrpLPropDtoExt  prpLPropDtoExt  =  new PrpLPropDtoExt();
		if(prpLPropDtoList1.size()>0){
			for(int i=0;i<prpLPropDtoList1.size();i++){
				PrpLPropDto  prpLPropDto = 	prpLPropDtoList1.get(i);
				PrpDkindDto itemKindDto = prpDkindApi.queryByPK(prpLPropDto.getRiskCode(),prpLPropDto.getKindCode());
				prpLPropDtoExt.setKindName(itemKindDto.getKindCName());
				prpLPropDtoExt.setPrpLPropDto(prpLPropDto);
				prpLPropDtoList.add(prpLPropDtoExt);
			}
		}
		comCheckDetailQueryDto.setPrpLPropDtoList(prpLPropDtoList);
		
		Specification<PrpLCompensateEar> specification4 = Specifications.<PrpLCompensateEar>and()
				.eq("registNo", prpLcheckDto.getRegistNo()).eq("nodeType", "regis")
				.eq("businessNo", prpLcheckDto.getRegistNo()).build();
		List<PrpLCompensateEar> prplCompensateEarDtoList = prpLCompensateEarDao.findAll(specification4);
		List<PrpLCompensateEarDto> prpLCompensates = new ArrayList<PrpLCompensateEarDto>();
		this.convertCollection(prplCompensateEarDtoList, prpLCompensates, PrpLCompensateEarDto.class);
		comCheckDetailQueryDto.setPrpLCompensates(prpLCompensates);

	}

	   /**
     * @descption  合并查勘定损页面初始化（ADD）
     * @author moujiaxing
     * @date 2017-12-01
     * @param comCheckDetailQueryDto 合并查勘定损页面初始化（ADD）条件组织的对象集合 
     * @return void  爻始蠹
     */
	public void checkDtoToView(ComCheckDetailQueryDto comCheckDetailQueryDto) throws Exception {
		 //查勘表
		Specification<PrpLRegistText> specification = Specifications.<PrpLRegistText>and()
				.eq("registNo", comCheckDetailQueryDto.getRegistNo()).eq("textType", "3").build();
		List<PrpLRegistText> prpLregistTextDtosList = prpLRegistTextDao.findAll(specification);
		List<PrpLRegistTextDto> prpLregistTextDtos =  new ArrayList<PrpLRegistTextDto>();
		this.convertCollection(prpLregistTextDtosList, prpLregistTextDtos, PrpLRegistTextDto.class);
		//立案表
		Specification<PrpLClaim> specification1 = Specifications.<PrpLClaim>and()
				.eq("registNo", comCheckDetailQueryDto.getRegistNo()).eq("riskCode", comCheckDetailQueryDto.getRiskCode()).build();
		List<PrpLClaim> claimList = prpLClaimDao.findAll(specification1);
		List<PrpLClaimDto> prpLClaimDtos = new ArrayList<PrpLClaimDto>();
		this.convertCollection(claimList, prpLClaimDtos, PrpLClaimDto.class);
		PrpLCheckDtoExt prpLcheckDtoExt = new PrpLCheckDtoExt();
		PrpLCheckDto prpLcheckDto = new PrpLCheckDto();
		prpLcheckDto.setReferSerialNo(1);
		prpLcheckDto.setRegistNo(comCheckDetailQueryDto.getRegistNo());
		// 如果在查勘前已经立案了，那么如果不把赔案号放入的话会出问题
		if (prpLClaimDtos.size() > 0)
			prpLcheckDto.setClaimNo(prpLClaimDtos.get(0).getClaimNo());

		prpLcheckDto.setRiskCode(comCheckDetailQueryDto.getRiskCode());
		prpLcheckDto.setPolicyNo(comCheckDetailQueryDto.getPrpLRegistDto().getPolicyNo());
		//增加报损金额
		prpLcheckDtoExt.setRegistEstimateLoss(comCheckDetailQueryDto.getPrpLRegistDto().getEstimateLoss());

		UtiCodeTransferDto utiCodeTransferDto = utiCodeTransferApi.queryByPK("RISKCODE_DAA");
		List<PrpDcodeDto> checkNatures = prpDcodeApi.queryCodeInfoByCodeType("CheckNature",
				utiCodeTransferDto.getOuterCode());
		comCheckDetailQueryDto.setCheckNatures(checkNatures);
		// 查勘界面的查勘地址由调度表带出
		PrpLScheduleMainWf prpLScheduleMainWf = prpLScheduleMainWfDao
				.findOne(new PrpLScheduleMainWfKey(1, comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()));
		if (prpLScheduleMainWf != null) {
			prpLcheckDto.setCheckSite(prpLScheduleMainWf.getCheckSite());
			prpLcheckDto.setCheckType(prpLScheduleMainWf.getFlag());
		}

		prpLcheckDto.setFirstSiteFlag(comCheckDetailQueryDto.getPrpLRegistDto().getFirstSiteFlag());
		prpLcheckDto.setClaimType(comCheckDetailQueryDto.getPrpLRegistDto().getClaimType());
		prpLcheckDto.setDamageCode(comCheckDetailQueryDto.getPrpLRegistDto().getDamageCode());
		prpLcheckDto.setDamageName(comCheckDetailQueryDto.getPrpLRegistDto().getDamageName());
		prpLcheckDto.setDamageTypeCode(comCheckDetailQueryDto.getPrpLRegistDto().getDamageTypeCode());
		prpLcheckDto.setDamageTypeName(comCheckDetailQueryDto.getPrpLRegistDto().getDamageTypeName());
		prpLcheckDto.setReferKind("A,M,L");
		prpLcheckDto.setDamageAreaCode(comCheckDetailQueryDto.getPrpLRegistDto().getDamageAreaCode());
		prpLcheckDto.setDamageAddressType(comCheckDetailQueryDto.getPrpLRegistDto().getDamageAddressType());
	
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
     	PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
		
		prpLcheckDto.setChecker1(userInfo.getUserName());
		prpLcheckDto.setHandleUnit(comCheckDetailQueryDto.getPrpLRegistDto().getHandleUnit());
		prpLcheckDto.setRemark(comCheckDetailQueryDto.getPrpLRegistDto().getRemark());
		prpLcheckDto.setFlag(comCheckDetailQueryDto.getPrpLRegistDto().getFlag());

		prpLcheckDtoExt.setEstiCurrency(comCheckDetailQueryDto.getPrpLRegistDto().getEsticurrency());

		prpLcheckDto.setDamageAddress(comCheckDetailQueryDto.getPrpLRegistDto().getDamageAddress());
		prpLcheckDtoExt.setClauseType(comCheckDetailQueryDto.getPrpLRegistDto().getClauseType());
		prpLcheckDto.setDamageStartDate(comCheckDetailQueryDto.getPrpLRegistDto().getDamageStartDate());

		prpLcheckDtoExt.setDamageEndDate(comCheckDetailQueryDto.getPrpLRegistDto().getDamageEndDate());

		// 查勘人1默认为操作人远的名称
		prpLcheckDtoExt.setInsuredName(comCheckDetailQueryDto.getPrpLRegistDto().getInsuredName());

		String timeTemp = toStandardTime(comCheckDetailQueryDto.getPrpLRegistDto().getDamageStartHour());
		prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
		timeTemp = toStandardTime(comCheckDetailQueryDto.getPrpLRegistDto().getDamageEndHour());
	
		Map<String,String>   map  =  new  HashMap<String,String>();
		 map.put("riskCode",comCheckDetailQueryDto.getRiskCode());
		prpLcheckDtoExt.setRiskName(prpDriskApi.queryByPK(map).getRiskCName());

		prpLcheckDto.setDamageArea(comCheckDetailQueryDto.getPrpLRegistDto().getDamageAreaName());
		int intRecentCount = pageInitCommonService.getSamePolicyRegistInfo(comCheckDetailQueryDto.getPrpLRegistDto().getPolicyNo(),
				comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo());
        /** 承保数量 */
        Map<String, String> params = new HashMap<String, String>();
        params.put("policyNo", comCheckDetailQueryDto.getPrpLRegistDto().getPolicyNo());
        PrpCmainDto cmainDto = prpCmainApi.queryByPK(params);
        Double statQuantity = cmainDto == null? 0d:cmainDto.getStatQuantity();
        comCheckDetailQueryDto.setStatQuantity(statQuantity);
		//状态
		Specification<PrpLclaimStatus> specification0 = Specifications.<PrpLclaimStatus>and()
				.eq("businessno", prpLcheckDto.getRegistNo()).eq("nodetype", "regis").build();
		List<PrpLclaimStatus> prpLclaimStatusDtos = prpLclaimStatusDao.findAll(specification0);
		List<PrpLclaimStatusDto> prpLclaimStatusDtoList = new ArrayList<PrpLclaimStatusDto>();
		this.convertCollection(prpLclaimStatusDtos, prpLclaimStatusDtoList, PrpLclaimStatusDto.class);
		// 设置立案操作的状态为 案件修改 (正处理任务)
		if (prpLclaimStatusDtoList != null&&prpLclaimStatusDtoList.size()>0) {
			if (prpLclaimStatusDtoList.get(0).getStatus().equals("7"))
				prpLcheckDtoExt.setStatus("2");
		} else {
			// 已提交，已经处理完毕的状态
			prpLcheckDtoExt.setStatus("4");
		}
		
		
		//
		Specification<PrpLverifyLoss> specification2 = Specifications.<PrpLverifyLoss>and()
				.eq("registNo", comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()).build();
		List<PrpLverifyLoss> prpLverifyLossDtos = prpLverifyLossDao.findAll(specification2);
		if(prpLverifyLossDtos==null||prpLverifyLossDtos.size()==0){
			PrpLRegist prpLregist = prpLRegistDao.findOne(new PrpLRegistKey(comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()));
			PrpLverifyLoss prpLverifyLoss = new PrpLverifyLoss();
			prpLverifyLoss.setAffectEDarea(0.0d);
			prpLverifyLoss.setDamageInsured(0.0d);
			prpLverifyLoss.setDisasterArea(0.0d);
			prpLverifyLoss.setNoProductionArea(0.0d);
			prpLverifyLoss.setKillQuantity(0.0d);
			prpLverifyLoss.setDeathQuantity(0.0d);
			prpLverifyLoss.setLossEsnumBer(prpLregist.getLossesNumber());
			prpLverifyLossDtos.add(prpLverifyLoss);
		}
		List<PrpLverifyLossDto> prpLverifyLossDtoList = new ArrayList<PrpLverifyLossDto>();
		this.convertCollection(prpLverifyLossDtos, prpLverifyLossDtoList, PrpLverifyLossDto.class);
		if(prpLverifyLossDtoList.size()>0){
		comCheckDetailQueryDto.setPrpLverifyLossDto(prpLverifyLossDtoList.get(0));
		}else{
		PrpLverifyLossDto  prpLverifyLossDto  =new  PrpLverifyLossDto();
		comCheckDetailQueryDto.setPrpLverifyLossDto(prpLverifyLossDto);
		}
		//定损明细清单表
		Specification<PrpLProp> specification3 = Specifications.<PrpLProp>and()
				.eq("registNo", comCheckDetailQueryDto.getPrpLRegistDto().getRegistNo()).build();
		List<PrpLProp> prpLPropDtos = prpLPropDao.findAll(specification3);
		List<PrpLPropDtoExt> prpLPropDtoList = new ArrayList<PrpLPropDtoExt>();
		List<PrpLPropDto> prpLPropDtoList1 = new ArrayList<PrpLPropDto>();
		this.convertCollection(prpLPropDtos, prpLPropDtoList1, PrpLPropDto.class);
		PrpLPropDtoExt  prpLPropDtoExt  =  new PrpLPropDtoExt();
		if(prpLPropDtoList1.size()>0){
			for(int i=0;i<prpLPropDtoList1.size();i++){
				PrpLPropDto  prpLPropDto = 	prpLPropDtoList1.get(i);
				PrpDkindDto itemKindDto = prpDkindApi.queryByPK(prpLPropDto.getRiskCode(),prpLPropDto.getKindCode());
				prpLPropDtoExt.setKindName(itemKindDto.getKindCName());
				prpLPropDtoExt.setPrpLPropDto(prpLPropDto);
				prpLPropDtoList.add(prpLPropDtoExt);
			}
		}
		comCheckDetailQueryDto.setPrpLPropDtoList(prpLPropDtoList);
		//理赔分户清单表
		Specification<PrpLCompensateEar> specification4 = Specifications.<PrpLCompensateEar>and()
				.eq("registNo", prpLcheckDto.getRegistNo()).eq("nodeType", "regis")
				.eq("businessNo", prpLcheckDto.getRegistNo()).build();
		List<PrpLCompensateEar> prplCompensateEarDtoList = prpLCompensateEarDao.findAll(specification4);
		List<PrpLCompensateEarDto> prpLCompensates = new ArrayList<PrpLCompensateEarDto>();
		this.convertCollection(prplCompensateEarDtoList, prpLCompensates, PrpLCompensateEarDto.class);
		comCheckDetailQueryDto.setPrpLCompensates(prpLCompensates);// 鐠佸墽鐤嗛懓铏垼閸欓攱绔婚崡鏇炲灙鐞
		
		// 查勘时间
		prpLcheckDto.setCheckDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		// 设置查勘操作的状态为 新案件登记 (未处理任务)
		prpLcheckDtoExt.setStatus("1");
		prpLcheckDtoExt.setPrpLCheckDto(prpLcheckDto);
		comCheckDetailQueryDto.setPrpLcheckDtoExt(prpLcheckDtoExt);
		comCheckDetailQueryDto.setIntRecentCount(intRecentCount);

		comCheckDetailQueryDto.setPrpLregistTextDtos(prpLregistTextDtos);

	}

    /**
     * @descption 合并立案页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并立案页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComClaimDetailQueryDto>  返回初始化对象集合
     */
	@Override
	public List<ComClaimDetailQueryDto> comClaimPageInit(List<Map<String,String>> listMap) throws Exception {
		// TODO Auto-generated method stub
		// 业务类型：ADD-新增 EDIT-修改 SHOW
		if(listMap==null||listMap.isEmpty()){
			throw new Exception(
					"未选择任何需要立案的数据");
		}
		if (null != listMap && listMap.size() >= 2) {
			for (int i = 0; i < listMap.size(); i++) {
				String combineNo_i = (String) listMap.get(i).get("combineNo");
				for (int j = i + 1; j < listMap.size(); j++) {
					String combineNo_j = (String) listMap.get(j).get("combineNo");
					if (!combineNo_i.equals(combineNo_j))
						throw new Exception("所选报案至少属于两个并案中，不能进行并案的立案");
				}
			}
		}
		List<ComClaimDetailQueryDto> list = new ArrayList<ComClaimDetailQueryDto>();
		String registNo = ""; // 
		String riskCode = "";// 
		List<PrpLCombine> prpLCombines = prpLCombineDao.findAllByCombineNo(listMap.get(0).get("combineNo"));
		List<PrpLCombineDto> combines = new ArrayList<PrpLCombineDto>();
		this.convertCollection(prpLCombines, combines, PrpLCombineDto.class);
		if (listMap.get(0).get("editType").equals("ADD")) {
			for (int i = 0; i < combines.size(); i++) {
				ComClaimDetailQueryDto  comClaimDetailQueryDto  =  new ComClaimDetailQueryDto();
				PrpLCombineDto prplcombineDto = combines.get(i);
				registNo = prplcombineDto.getRegistNo();// 
				PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
				comClaimDetailQueryDto.setRegistNo(registNo);
				prpLRegistKey.setRegistNo(registNo);
				PrpLRegist prpLRegist = prpLRegistDao.getOne(prpLRegistKey);
				PrpLRegistDto prpLRegistDto = this.convert(prpLRegist, PrpLRegistDto.class);
				riskCode = prpLRegistDto.getRiskCode();
				String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
				comClaimDetailQueryDto.setRiskType(riskType);
				comClaimDetailQueryDto.setRiskCode(riskCode);
				ResponseQueryPolicyInfoDto policyDto =new ResponseQueryPolicyInfoDto();
				Map<String,String>  policyMap  =  new HashMap<String,String>();
				policyMap.put("policyNo", prpLRegistDto.getPolicyNo());
				PrpCmainDto prpcmainDto = prpCmainApi.queryByPK(policyMap);
				policyDto.setPrpCmainDto(prpcmainDto);
				comClaimDetailQueryDto.setPolicyNo(prplcombineDto.getPolicyNo());
				int intReturn = pageInitCommonService.checkPay(prplcombineDto.getPolicyNo());
				String strPayFlag = String.valueOf(intReturn);
				// 欠费情况
				String delinquentfeeCase = "";
				// 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
				if (intReturn == -2 && policyDto.getPrpCmainDto().getPayTimes() > 1) {
					delinquentfeeCase = pageInitCommonService.getDelinquentfeeCase(policyDto.getPrpCmainDto());
				}
				// 梅诟未
				 PrpDriskConfigDto prpDriskConfigDto = prpDriskConfigApi.queryByPK("00000000",
						policyDto.getPrpCmainDto().getRiskCode(), "ALLOW_UNPAYED_CLAIM");// 获取保费未实收是否立案信息
				 String configValue  =  prpDriskConfigDto.getConfigValue();
				// 
				 prpDriskConfigDto = prpDriskConfigApi.queryByPK("00000000",
						policyDto.getPrpCmainDto().getRiskCode(), "REPORT_DEFER_DAYS");
				 String standard_stringDays  =  prpDriskConfigDto.getConfigValue();

				if (configValue == null || configValue.equals("")) {
					throw new Exception(
							"请联系系统管理员，在平台配置系统中进行险种" + policyDto.getPrpCmainDto().getRiskCode() + "'保费未实收是否允许立案'的初始化！");
				}
				if (standard_stringDays == null || standard_stringDays.equals("")) {
					throw new Exception(
							"请联系系统管理员，在平台配置系统中进行险种" + policyDto.getPrpCmainDto().getRiskCode() + "'报案出险延期天数'的初始化！");
				}
				long standard_days = Long.parseLong(standard_stringDays);

				// configValue =2 intReturn=1则表示未交费不能立案
				if (configValue.equals("2") && intReturn != 1) {
					throw new Exception("未交费不能立案");
				}
				// **************判断报案出险延期天数是否大于系统规定时间，大于不允许立案
				Date damageDate = prpLRegistDto.getDamageStartDate();
				Date reportDate = prpLRegistDto.getReportDate();
				long report_damage_days = (reportDate.getTime() - damageDate.getTime()) / (1000 * 60 * 60 * 24);
				// 获取系统规定时间 standard_days
				if (report_damage_days > standard_days) {
					throw new Exception("报案出险延期天数大于系统规定时间，不允许立案");
				}

				// 首先判断该报案是否已经立过案
				Specification<PrpLClaim> specification = Specifications.<PrpLClaim>and()
						.eq("registNo", prpLRegistDto.getRegistNo()).eq("riskCode", prpLRegistDto.getRiskCode())
						.build();
				List<PrpLClaim> claimList = prpLClaimDao.findAll(specification);
				/* claimList不为空说明查询到该报案已经立过案了 */
				if (claimList.size() > 0) {
					throw new Exception("此报案号已立案！");
				}
				
				PrpLclaimStatus claimStatus = prpLclaimStatusDao
						.findOne(new PrpLclaimStatusKey(prpLRegistDto.getRegistNo(), "regist", 0));
				if (claimStatus != null) {
					if (!claimStatus.getStatus().equals("4")) {

						throw new Exception("报案号为" + prpLRegistDto.getRegistNo() + "的案件不是报案提交状态，不能立案！");
					}
				}
				// 
				for (int j = 0; j < listMap.size(); j++){
					if (listMap.get(j).get("swfLogFlowID") != null
							&& listMap.get(j).get("swfLogLogNo") != null) {
						SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(listMap.get(j).get("swfLogFlowID"), Integer.parseInt(listMap.get(j).get("swfLogLogNo"))));
						if(registNo.equals(swfLog.getRegistNo())){
							String userCode = SinoRequestContext.getCurrentContext().getUserCode();
							comClaimDetailQueryDto.setSwfLogFlowID(listMap.get(j).get("swfLogFlowID"));
							comClaimDetailQueryDto.setSwfLogLogNo(listMap.get(j).get("swfLogLogNo") );

							PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
							SwfLogDto swfLogDto = workFlowService.holdNode(listMap.get(j).get("swfLogFlowID"),
							Integer.parseInt(listMap.get(j).get("swfLogLogNo")), userCode,
						    userInfo.getUserName());
							if ("false".equals(swfLogDto.getFlag())) {
								throw new Exception("案件已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
										+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!");
							}
						}

						
					}
				}
				//封装对象
				registDtoToView(comClaimDetailQueryDto, policyDto);
				//增加与赔付数量对应的单位信息
				List<PrpDcodeDto> units = prpDcodeApi.queryCodeInfoByCodeType("Unit",riskCode);
				comClaimDetailQueryDto.setUnits(units);
				list.add(comClaimDetailQueryDto);

			}
		}
		if (listMap.get(0).get("editType").equals("EDIT")
				|| listMap.get(0).get("editType").equals("SHOW")) {
			for (int i = 0; i < combines.size(); i++) {
				ComClaimDetailQueryDto comClaimDetailQueryDto = new ComClaimDetailQueryDto();
				PrpLCombineDto prplcombineDto = combines.get(i);
				registNo = prplcombineDto.getRegistNo();
					for(int t = 0; t < listMap.size(); t++){
						if (listMap.get(t).get("swfLogFlowID") != null
								&& listMap.get(t).get("swfLogLogNo") != null) {
							SwfLog swfLog = swfLogDao.findOne(new SwfLogKey(listMap.get(t).get("swfLogFlowID"), Integer.parseInt(listMap.get(t).get("swfLogLogNo"))));
							if(registNo.equals(swfLog.getRegistNo())){
								comClaimDetailQueryDto.setSwfLogFlowID(listMap.get(t).get("swfLogFlowID"));
								comClaimDetailQueryDto.setSwfLogLogNo(listMap.get(t).get("swfLogLogNo") );
							}
						}
					}
				Specification<PrpLClaim> specification = Specifications.<PrpLClaim>and()
						.eq("registNo", registNo).build();
				List<PrpLClaim> prpLClaimList = prpLClaimDao.findAll(specification);
				List<PrpLClaimDto> prpLClaimDtoList = new ArrayList<PrpLClaimDto>();
				this.convertCollection(prpLClaimList, prpLClaimDtoList, PrpLClaimDto.class);
				if (prpLClaimDtoList.size() == 0) {
					throw new Exception(
							"未生成立案的数据");
				}
				PrpLClaimDto prpLClaimDto1 = prpLClaimDtoList.get(0);
				PrpLClaimDtoExt prpLClaimDto = new PrpLClaimDtoExt();
				prpLClaimDto.setPrpLClaimDto(prpLClaimDto1);
				riskCode = prpLClaimDto1.getRiskCode();
				registNo = prpLClaimDto1.getRegistNo();// 
				PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
				prpLRegistKey.setRegistNo(registNo);
				PrpLRegist prpLRegist = prpLRegistDao.getOne(prpLRegistKey);
				PrpLRegistDto prpLRegistDto = this.convert(prpLRegist, PrpLRegistDto.class);
				riskCode = prpLRegistDto.getRiskCode();
				String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
				comClaimDetailQueryDto.setRiskType(riskType);
				comClaimDetailQueryDto.setRiskCode(riskCode);
				ResponseQueryPolicyInfoDto policyDto = new ResponseQueryPolicyInfoDto();
				Map<String, String> policyMap = new HashMap<String, String>();
				policyMap.put("policyNo", prpLRegistDto.getPolicyNo());
				PrpCmainDto prpcmainDto = prpCmainApi.queryByPK(policyMap);
				policyDto.setPrpCmainDto(prpcmainDto);
				int intReturn = pageInitCommonService.checkPay(prpLClaimDto1.getPolicyNo());
				String strPayFlag = String.valueOf(intReturn);
				// 欠费情况
				String delinquentfeeCase = "";
				// 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
				if (intReturn == -2 && policyDto.getPrpCmainDto().getPayTimes() > 1) {
					delinquentfeeCase = pageInitCommonService.getDelinquentfeeCase(policyDto.getPrpCmainDto());
				}
				//增加与赔付数量对应的单位信息
				comClaimDetailQueryDto.setPrpLRegistDto(prpLRegistDto);
				comClaimDetailQueryDto.setRegistNo(registNo);
				List<PrpDcodeDto> units = prpDcodeApi.queryCodeInfoByCodeType("Unit", riskCode);
				comClaimDetailQueryDto.setUnits(units);
				//封装对象
				claimDtoToView(comClaimDetailQueryDto, prpLClaimDto, policyDto);

				list.add(comClaimDetailQueryDto);
			}

		}
		return list;
	}

    /**
     * @descption 合并立案页面初始化（EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param comClaimDetailQueryDto 合并立案页面初始化（EDIT.SHOW）条件组织的对象集合
     * 
     */
	public void claimDtoToView(ComClaimDetailQueryDto comClaimDetailQueryDto, PrpLClaimDtoExt prpLclaimDto, ResponseQueryPolicyInfoDto policyDto) throws Exception {
		String timeTemp = toStandardTime(prpLclaimDto.getPrpLClaimDto().getDamageStartHour());
		prpLclaimDto.getPrpLClaimDto().setDamageStartHour(timeTemp.substring(0, 2));
		timeTemp = toStandardTime(prpLclaimDto.getPrpLClaimDto().getDamageEndHour());
		prpLclaimDto.getPrpLClaimDto().setDamageEndHour(timeTemp.substring(0, 2));

		String riskCode = prpLclaimDto.getPrpLClaimDto().getRiskCode();
		String registNo = prpLclaimDto.getPrpLClaimDto().getRegistNo();
		
		if (registNo != null) {
			Specification<PrpLCompensateEar> specification = Specifications.<PrpLCompensateEar>and()
					.eq("registNo", registNo).eq("nodeType", "certa").eq("businessNo", registNo).build();
			List<PrpLCompensateEar> prplCompensateEarDtoList = prpLCompensateEarDao.findAll(specification);
			List<PrpLCompensateEarDto> prpLCompensates = new ArrayList<PrpLCompensateEarDto>();
			this.convertCollection(prplCompensateEarDtoList, prpLCompensates, PrpLCompensateEarDto.class);
			comClaimDetailQueryDto.setPrpLCompensates(prpLCompensates);

		}
		Specification<PrpLclaimStatus> specification = Specifications.<PrpLclaimStatus>and()
				.eq("businessno", prpLclaimDto.getPrpLClaimDto().getClaimNo()).eq("nodetype", "claim").build();
		List<PrpLclaimStatus> prpLclaimStatusDtos = prpLclaimStatusDao.findAll(specification);
		List<PrpLclaimStatusDto> prpLclaimStatusDtoList = new ArrayList<PrpLclaimStatusDto>();
		this.convertCollection(prpLclaimStatusDtos, prpLclaimStatusDtoList, PrpLclaimStatusDto.class);

		// 设置立案操作的状态为 案件修改 (正处理任务)
		if (prpLclaimStatusDtoList != null&&prpLclaimStatusDtoList.size()>0) {
			if (prpLclaimStatusDtoList.get(0).getStatus().equals("7"))
				prpLclaimDto.setStatus("2");
		} else {
			// 已提交，已经处理完毕的状态
			prpLclaimDto.setStatus("4");
		}
		if (!prpLclaimDto.getPrpLClaimDto().getPolicyNo().equals("")) {
		
			prpLclaimDto.getPrpLClaimDto().setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
			prpLclaimDto.getPrpLClaimDto().setClaimTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
			// 取被保险人名称，对于团单需要显示名称
			String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1) {
				strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();
			} else {
				strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName() +"" + insureQuantity + "";
			}
			prpLclaimDto.setInsuredNameShow(strInsuredNameShow);

		}
		// 获取中文名称
		changeCodeToName(prpLclaimDto);

		Specification<PrpLLText> specification1 = Specifications.<PrpLLText>and()
				.eq("claimNo", prpLclaimDto.getPrpLClaimDto().getClaimNo()).eq("textType", "09").build();
		List<PrpLLText> prpLLTextDtos = prpLLTextDao.findAll(specification1);
		List<PrpLLTextDto> prpLLTextDtoList =new ArrayList<PrpLLTextDto>();
		this.convertCollection(prpLLTextDtos, prpLLTextDtoList, PrpLLTextDto.class);
		comClaimDetailQueryDto.setPrpLltextDtoList(prpLLTextDtoList);
		StringBuffer context = new StringBuffer("");
		for (PrpLLTextDto prpLLTextDto : prpLLTextDtoList) {
			context.append("  ");
			if(StringUtils.isNotBlank(prpLLTextDto.getContext())){
				context.append(prpLLTextDto.getContext());
			}
			context.append("\n");
		}
		comClaimDetailQueryDto.setContext(context.toString());
		prpLclaimDto.getPrpLClaimDto().setCurrency(comClaimDetailQueryDto.getPrpLRegistDto().getEsticurrency());
		// 币别中文
		String strCurrencyName = prpDcurrencyApi.translateCode(comClaimDetailQueryDto.getPrpLRegistDto().getEsticurrency(), "");
		prpLclaimDto.setCurrencyName(strCurrencyName);
		Map<String,String>   map  =  new  HashMap<String,String>();
		 map.put("riskCode",comClaimDetailQueryDto.getRiskCode());
		prpLclaimDto.setRiskName(prpDriskApi.queryByPK(map).getRiskCName());
		List<Map<String,String>>  listFlag =  new ArrayList<Map<String,String>>();
		Map<String,String>  flagMap  =  new  HashMap<String,String>();
		flagMap.put("1", "是");
		flagMap.put("0", "否");
		listFlag.add(flagMap);
		comClaimDetailQueryDto.setReplevyFlag(listFlag);
		comClaimDetailQueryDto.setThirdComFlag(listFlag);
		comClaimDetailQueryDto.setPrpLClaimDtoExt(prpLclaimDto);
		Specification<PrpLClaimLoss> specification2 = Specifications.<PrpLClaimLoss>and()
				.eq("claimNo", prpLclaimDto.getPrpLClaimDto().getClaimNo()).build();
		List<PrpLClaimLoss> prpLClaimLossDtos = prpLClaimLossDao.findAll(specification2);
		List<PrpLClaimLossDto> prpLClaimLossDtoList = new ArrayList<PrpLClaimLossDto>() ;
		this.convertCollection(prpLClaimLossDtos, prpLClaimLossDtoList, PrpLClaimLossDto.class);
		List<PrpLClaimLossDtoExt> prpLClaimLossDtoList1  =  new  ArrayList<PrpLClaimLossDtoExt>();
		for (int i =0;i<prpLClaimLossDtoList.size();i++){
			PrpLClaimLossDto  prpLClaimLossDto=  prpLClaimLossDtoList.get(i);
			PrpLClaimLossDtoExt  prpLClaimLossDtoExt  =  new PrpLClaimLossDtoExt();
			prpLClaimLossDtoExt.setPrpLClaimLossDto(prpLClaimLossDto);
			PrpDkindDto itemKindDto = prpDkindApi.queryByPK(comClaimDetailQueryDto.getRiskCode(),prpLClaimLossDto.getKindCode());
			if(itemKindDto!=null){
				prpLClaimLossDtoExt.setKindName(itemKindDto.getKindCName());
			}
			prpLClaimLossDtoList1.add(prpLClaimLossDtoExt);
		}
		comClaimDetailQueryDto.setPrpLclaimLossDtoList(prpLClaimLossDtoList1);

	}

	/**
     * @descption 时间初始化
     * @author moujiaxing
     * @date 2017-12-01
     * @param strTime 
     * 
     */
	public static String toStandardTime(String strTime) {
		String strReturn = "";
		if (strTime != null) {
			java.util.StringTokenizer t = new StringTokenizer(strTime, ":");
			while (t.hasMoreTokens()) {
				String strTemp = t.nextToken();
				if (strTemp.trim().length() == 1) {
					strTemp = "0" + strTemp.trim();
				} else if (strTemp.trim().length() >= 2) {
					strTemp = strTemp.trim().substring(0, 2);
				} else if (strTemp.trim().length() == 0) {
					strTemp = "00";
				}
				strReturn = strReturn + strTemp + ":";
			}
			if (strReturn.length() == 3) {
				strReturn = strReturn + "00:00";
			} else if (strReturn.length() == 6) {
				strReturn = strReturn + "00";
			} else if (strReturn.length() == 9) {
				strReturn = strReturn.substring(0, 8);
			} else if (strReturn.length() == 0) {
				strReturn = "00:00:00";
			}
		} else {
			strReturn = "00:00:00";
		}
		return strReturn;
	}

    /**
     * @descption 合并立案页面初始化（ADD）
     * @author moujiaxing
     * @date 2017-12-01
     * @param comClaimDetailQueryDto 合并立案页面初始化（ADD）条件组织的对象集合
     * 
     */
	public void registDtoToView(ComClaimDetailQueryDto comClaimDetailQueryDto,ResponseQueryPolicyInfoDto policyDto)
			throws Exception {

		String registNo = comClaimDetailQueryDto.getRegistNo();
		String riskCode = comClaimDetailQueryDto.getRiskCode();
	    if (registNo != null) {
			Specification<PrpLCompensateEar> specification = Specifications.<PrpLCompensateEar>and()
					.eq("registNo", registNo).eq("nodeType", "certa").eq("businessNo", registNo).build();
			List<PrpLCompensateEar> prplCompensateEarDtoList = prpLCompensateEarDao.findAll(specification);
			List<PrpLCompensateEarDto> prpLCompensates = new ArrayList<PrpLCompensateEarDto>();
			this.convertCollection(prplCompensateEarDtoList, prpLCompensates, PrpLCompensateEarDto.class);
			comClaimDetailQueryDto.setPrpLCompensates(prpLCompensates);
		}

		PrpLClaimDtoExt prpLClaimDtoExt = new PrpLClaimDtoExt();

		List<Map<String,String>>  listFlag =  new ArrayList<Map<String,String>>();
		Map<String,String>  flagMap  =  new  HashMap<String,String>();
		flagMap.put("1", "是");
		flagMap.put("0", "否");
		listFlag.add(flagMap);
		comClaimDetailQueryDto.setReplevyFlag(listFlag);
		comClaimDetailQueryDto.setThirdComFlag(listFlag);
		PrpLRegist prpLregist = prpLregistDao.findOne(new PrpLRegistKey(registNo));
		PrpLRegistDto prpLregistDto = (PrpLRegistDto) this.convert(prpLregist, PrpLRegistDto.class);

		PrpLRegistRPolicy prpLRegistRPolicy = prpLRegistRPolicyDao
				.findOne(new PrpLRegistRPolicyKey(registNo, comClaimDetailQueryDto.getPolicyNo()));
		PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) this.convert(prpLRegistRPolicy,
				PrpLRegistRPolicyDto.class);
		PrpLCheck prpLCheck = prpLCheckDao.findOne(new PrpLCheckKey(registNo, 1));
		PrpLCheckDto prpLCheckDto = (PrpLCheckDto) this.convert(prpLCheck, PrpLCheckDto.class);
		PrpLext prpLext = prpLextDao.findOne(new PrpLextKey(registNo, "2"));
		PrpLextDto prpLextDto = (PrpLextDto) this.convert(prpLext, PrpLextDto.class);
		Specification<PrpLRegistText> specification = Specifications.<PrpLRegistText>and().eq("registNo", registNo)
				.eq("textType", "3").build();
		List<PrpLRegistText> prpLregistTextDtos = prpLRegistTextDao.findAll(specification);
		List<PrpLRegistTextDto> list = new ArrayList<PrpLRegistTextDto>();
        this.convertCollection(prpLregistTextDtos, list, PrpLRegistTextDto.class);
		Specification<PrpLRegistText> specification1 = Specifications.<PrpLRegistText>and().eq("registNo", registNo)
				.eq("textType", "07").build();
		List<PrpLRegistText> prpLregistTextDtos1 = prpLRegistTextDao.findAll(specification1);
		List<PrpLRegistTextDto> prpLregistTextDtoList3 = new ArrayList<PrpLRegistTextDto>();
        this.convertCollection(prpLregistTextDtos1, prpLregistTextDtoList3, PrpLRegistTextDto.class);

		Specification<PrpLRegistText> specification2 = Specifications.<PrpLRegistText>and().eq("registNo", registNo)
				.build();
		List<PrpLRegistText> prpLregistTextDtosList = prpLRegistTextDao.findAll(specification2);
		List<PrpLRegistTextDto> prpLregistTextDtos2 = new ArrayList<PrpLRegistTextDto>();
        this.convertCollection(prpLregistTextDtosList, prpLregistTextDtos2, PrpLRegistTextDto.class);

		  
		Specification<PrpLRegist> specification3 = Specifications.<PrpLRegist>and()
				.eq("policyNo", comClaimDetailQueryDto.getPolicyNo()).build();
		List<PrpLRegist> prpLregistDtos = prpLRegistDao.findAll(specification3);
		List<PrpLRegistDto> prpLregistDtoList = new ArrayList<PrpLRegistDto>();
        this.convertCollection(prpLregistDtos, prpLregistDtoList, PrpLRegistDto.class);
		PrpLClaimDto prpLClaimDto = new PrpLClaimDto();
		if (prpLext == null) {
			comClaimDetailQueryDto.setPrpLextDto(prpLextDto);
		} else {
			comClaimDetailQueryDto.setPrpLextDto(this.convert(prpLext, PrpLextDto.class));

		}

		// 根据查询出来的数据内容，给PrpLclaimDto赋值
		if (prpLCheck == null) {
			throw new Exception("报案号为" + registNo + "未做查勘定损，不允许立案！");
		} else {
			prpLClaimDto.setIndemnityDuty(prpLCheckDto.getIndemnityDuty());
			String indemnityDuty = prpLCheckDto.getIndemnityDuty();
			double indemnityDutyRate = 100;
			// 转码
			if(indemnityDuty!=null){
				if (indemnityDuty.trim().equals("0")) {
					indemnityDutyRate = 100;
				} else if (indemnityDuty.trim().equals("1")) {
					indemnityDutyRate = 70;
				} else if (indemnityDuty.trim().equals("2")) {
					indemnityDutyRate = 50;
				} else if (indemnityDuty.trim().equals("3")) {
					indemnityDutyRate = 30;
				} else if (indemnityDuty.trim().equals("4")) {
					indemnityDutyRate = 0.0;
				} else if (indemnityDuty.trim().equals("9")) {
					indemnityDutyRate = 0.0;
				}
			}
			prpLClaimDto.setIndemnityDutyRate(indemnityDutyRate);
		}
		// 如果未查勘就立案，此时，从报案带入出险摘要默认作为出险摘要
		// 在这里进行转化将得到的prpLregistTextDto数据传递给prpLltextDto
		List<PrpLLTextDto> prpLltextDtoList = new ArrayList<PrpLLTextDto>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				PrpLRegistTextDto prpLregistTextDto = (PrpLRegistTextDto) list.get(i);
				PrpLLTextDto prpLltextDto = new PrpLLTextDto();
				prpLltextDto.setContext(prpLregistTextDto.getContext());
				prpLltextDto.setTextType(prpLregistTextDto.getTextType());
				prpLltextDtoList.add(prpLltextDto);
			}
		}
		List<PrpLLTextDto> prpLltextDtoList1 = new ArrayList<PrpLLTextDto>();

		if (prpLregistTextDtoList3 != null) {
			for (int i = 0; i < prpLregistTextDtoList3.size(); i++) {
				PrpLRegistTextDto prpLregistTextDto = (PrpLRegistTextDto) prpLregistTextDtoList3.get(i);
				PrpLLTextDto prpLltextDto = new PrpLLTextDto();
				prpLltextDto.setContext(prpLregistTextDto.getContext());
				prpLltextDto.setTextType(prpLregistTextDto.getTextType());
				prpLltextDtoList1.add(prpLltextDto);
			}
		}

		if (list.size() < 1) {
			for (int i = 0; i < prpLregistTextDtos2.size(); i++) {
				PrpLRegistTextDto prpLregistTextDto = (PrpLRegistTextDto) prpLregistTextDtos2.get(i);
				PrpLLTextDto prpLltextDto = new PrpLLTextDto();
				prpLltextDto.setContext(prpLregistTextDto.getContext());
				prpLltextDto.setTextType(prpLregistTextDto.getTextType());
				prpLltextDtoList.add(prpLltextDto);
			}
		}
		if (prpLregistTextDtoList3.size() < 1) {
			for (int i = 0; i < prpLregistTextDtos2.size(); i++) {
				PrpLRegistTextDto prpLregistTextDto = (PrpLRegistTextDto) prpLregistTextDtos2.get(i);
				PrpLLTextDto prpLltextDto = new PrpLLTextDto();
				prpLltextDto.setContext(prpLregistTextDto.getContext());
				prpLltextDto.setTextType(prpLregistTextDto.getTextType());
				prpLltextDtoList1.add(prpLltextDto);
			}
		}
		StringBuffer context = new StringBuffer("");
		for (PrpLLTextDto prpLLTextDto : prpLltextDtoList) {
			context.append("  ");
			if(StringUtils.isNotBlank(prpLLTextDto.getContext())){
				context.append(prpLLTextDto.getContext());
			}
			context.append("\n");
		}
		comClaimDetailQueryDto.setContext(context.toString());
		comClaimDetailQueryDto.setPrpLltextDtoList(prpLltextDtoList);
		prpLClaimDto.setRegistNo(prpLregistDto.getRegistNo());
		prpLClaimDto.setPolicyNo(comClaimDetailQueryDto.getPolicyNo());
		prpLClaimDto.setDamageCode(prpLregistDto.getDamageCode());
		prpLClaimDto.setDamageName(prpLregistDto.getDamageName());
		prpLClaimDto.setDamageTypeCode(prpLregistDto.getDamageTypeCode());
		prpLClaimDto.setDamageTypeName(prpLregistDto.getDamageTypeName());
		prpLClaimDto.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
		prpLClaimDto.setDamageAreaName(prpLregistDto.getDamageAreaName());
		Map<String,String>   map  =  new  HashMap<String,String>();
		 map.put("riskCode",comClaimDetailQueryDto.getRiskCode());
		prpLClaimDtoExt.setRiskName(prpDriskApi.queryByPK(map).getRiskCName());
		
		if (prpLCheckDto == null) {
			prpLClaimDto.setIndemnityDuty("0");
			prpLClaimDto.setIndemnityDutyRate(100.00);
		}
		// 立案时出险地点取查勘的，如果没有就取报案的出险地点
		if (prpLCheckDto == null || prpLCheckDto.getDamageAddress() == null
				|| prpLCheckDto.getDamageAddress().equals("")) {
			prpLClaimDto.setDamageAddress(prpLregistDto.getDamageAddress());
			prpLClaimDto.setDamageAddressType(prpLregistDto.getDamageAddressType());

		} else {
			prpLClaimDto.setDamageAddress(prpLCheckDto.getDamageAddress());
			prpLClaimDto.setDamageAddressType(prpLCheckDto.getDamageAddressType());
		}
		// 赔案类别，如果查勘没有，就从报案取
		if (prpLCheckDto == null ||prpLCheckDto.getClaimType()==null||prpLCheckDto.getClaimType().equals("")) {
			prpLClaimDto.setClaimType(prpLregistDto.getClaimType());
		} else {
			prpLClaimDto.setClaimType(prpLCheckDto.getClaimType());
		}
		prpLClaimDto.setRiskCode(riskCode);
		String timeTemp = "";
		timeTemp = toStandardTime(prpLregistDto.getDamageStartHour());
		prpLClaimDto.setDamageStartDate(prpLregistDto.getDamageStartDate());
		prpLClaimDto.setDamageStartHour(timeTemp.substring(0, 2));
		prpLClaimDtoExt.setDamageStartMinute(timeTemp.substring(3, 5));
		timeTemp = toStandardTime(prpLregistDto.getDamageEndHour());
		prpLClaimDto.setDamageEndDate(prpLregistDto.getDamageEndDate());
		prpLClaimDto.setDamageEndHour(timeTemp.substring(0, 2));
		prpLClaimDto.setClassCode(prpLregistDto.getClassCode());
		if ("05".equals(prpLClaimDto.getClassCode())) {
			prpLClaimDto.setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
		} else {
			prpLClaimDto.setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
			prpLClaimDto.setClaimTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
		}
		prpLClaimDto.setInsuredCode(prpLregistDto.getInsuredCode());
		prpLClaimDto.setInsuredName(prpLregistDto.getInsuredName());
		prpLClaimDto.setComCode(prpLregistDto.getComCode());
		prpLClaimDto.setAddressCode(prpLregistDto.getAddressCode());
		prpLClaimDto.setCurrency(prpLregistDto.getEsticurrency()); // 斜冶转玫
		String strCurrencyName = prpDcurrencyApi.translateCode(prpLregistDto.getEsticurrency(), "");
		prpLClaimDtoExt.setCurrencyName(strCurrencyName);
		prpLClaimDto.setLanguage(prpLregistDto.getLanguage());
		prpLClaimDto.setLossName(prpLregistDto.getLossName());
		prpLClaimDto.setMakeCom(prpLregistDto.getMakeCom());
		prpLClaimDto.setHandler1Code(prpLregistDto.getHandler1Code());
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		prpLClaimDto.setOperatorCode(userCode);
		// 估损金额的获取，如果是查勘，定损，核损都可以立案
		prpLClaimDto.setSumClaim(prpLregistDto.getEstimateLoss());
		// 设置默认的经办人
		prpLClaimDto.setHandlerCode(userCode);

		// 增加赔付数量和赔付数量单位属性
		Specification<PrpLverifyLoss> specification5 = Specifications.<PrpLverifyLoss>and().eq("registNo", registNo)
				.build();
		List<PrpLverifyLoss> prpLverifyLossDtos = prpLverifyLossDao.findAll(specification5);
		List<PrpLverifyLossDto> prpLverifyLossDtoList = new  ArrayList<PrpLverifyLossDto>();
		this.convertCollection(prpLverifyLossDtos, prpLverifyLossDtoList, PrpLverifyLossDto.class);
		if (prpLverifyLossDtoList.size() > 0) {
			PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) prpLverifyLossDtoList.get(0);
			if (prpLverifyLossDto != null) {
				// 如果赔付数量不为0说明存在核损环节并且在核损环节录入了数据
				prpLClaimDto.setLossesNumber(prpLverifyLossDto.getLossEsnumBer());
				prpLClaimDto.setDamageInsured(prpLverifyLossDto.getDamageInsured());
				prpLClaimDto.setDisasterArea(prpLverifyLossDto.getDisasterArea());
				prpLClaimDto.setDisasterUnit(prpLverifyLossDto.getDisasterUnit());
				prpLClaimDto.setNoProductionArea(prpLverifyLossDto.getNoProductionArea());
				prpLClaimDto.setNoProductionUnit(prpLverifyLossDto.getNoProductionUnit());
				prpLClaimDto.setDeathQuantity(prpLverifyLossDto.getDeathQuantity());
				prpLClaimDto.setDeathUnit(prpLverifyLossDto.getDeathUnit());
				prpLClaimDto.setKillQuantity(prpLverifyLossDto.getKillQuantity());
				prpLClaimDto.setKillUnit(prpLverifyLossDto.getKillUnit());
			}
		}

		// 对车型,条款等信息的支持
		prpLClaimDtoExt.setClauseType(prpLregistDto.getClauseType());
		prpLClaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		// 设置立案操作的状态为 新案件登记 (未处理任务)
		prpLClaimDtoExt.setStatus("1");
		// 从保单中获得信息
		if (!prpLregistDto.getPolicyNo().equals("")) { 
			prpLClaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
			prpLClaimDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
			prpLClaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
			prpLClaimDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
			// 取被保险人名称，对于团单需要显示名称
			String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1) {
				strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();

			} else {
				strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName() + "" + insureQuantity + "";

			}
            
			prpLClaimDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
			prpLClaimDtoExt.setInsuredNameShow(strInsuredNameShow);
			prpLClaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
			if(policyDto.getPrpCmainDto().getSumPremium()!=null){
				String replace = (policyDto.getPrpCmainDto().getSumPremium().toString()).replace(".0", "");
				prpLClaimDto.setSumPremium(Integer.valueOf(replace));
            }else{
                prpLClaimDto.setSumPremium(0);
            }
			prpLClaimDto.setBusinessNature(policyDto.getPrpCmainDto().getBusinessNature());
			prpLClaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
			prpLClaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
			prpLClaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
			prpLClaimDto.setStartDate(policyDto.getPrpCmainDto().getStartDate());
			prpLClaimDto.setEndDate(policyDto.getPrpCmainDto().getEndDate());
			prpLClaimDto.setStartHour(policyDto.getPrpCmainDto().getStartHour());
			prpLClaimDto.setEndHour(policyDto.getPrpCmainDto().getEndHour());
			prpLClaimDto.setAgentCode(policyDto.getPrpCmainDto().getAgentCode());
		}
		// 获取系统设置信息：立案天数
		 PrpDriskConfigDto prpDriskConfigDto = prpDriskConfigApi.queryByPK("00000000", policyDto.getPrpCmainDto().getRiskCode(),
				"CLAIM_DAYS");
		String standardDays  = prpDriskConfigDto.getConfigValue();
		if (standardDays == null || standardDays.equals("")) {
			throw new Exception("请联系系统管理员，在平台配置系统中进行险种" + prpLClaimDto.getRiskCode() + "'立案天数'的初始化！");
		}
		// 当前时间减去报案时间
		Date currentDate = new Date();
		Date registDate = prpLregistDto.getReportDate();
		
		comClaimDetailQueryDto.setRegistDate(registDate);
		prpLClaimDto.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
		prpLClaimDto.setCatastropheName1(prpLregistDto.getCatastropheName1());
		prpLClaimDto.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
		prpLClaimDto.setCatastropheName2(prpLregistDto.getCatastropheName2());
		prpLClaimDtoExt.setPrpLClaimDto(prpLClaimDto);
		// 获取中文信息
		changeCodeToName(prpLClaimDtoExt);
		comClaimDetailQueryDto.setPrpLClaimDtoExt(prpLClaimDtoExt);
		// 设置默认的估损金额的子表金额信息
		List<PrpLClaimLossDtoExt> prpLclaimLossDtoList = new ArrayList();
		List<PrpLProp> prpLPropList = prpLPropDao
				.findAll(Specifications.<PrpLProp>and().eq("registNo", prpLregistDto.getRegistNo()).build());
		for (int i = 0; prpLPropList != null && i < prpLPropList.size(); i++) {
			PrpLProp prpLProp = prpLPropList.get(i);
			PrpLClaimLossDtoExt prpLClaimLossDtoExt = new PrpLClaimLossDtoExt();
			PrpLClaimLossDto prpLClaimLossDto = new PrpLClaimLossDto();

			PrpDkindDto itemKindDto = prpDkindApi.queryByPK(prpLProp.getRiskCode(), prpLProp.getKindCode());
			prpLClaimLossDtoExt.setKindName(itemKindDto.getKindCName());
			
			prpLClaimLossDto.setItemDetailName(prpLProp.getLossItemName());
			prpLClaimLossDto.setInputDate((new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY)));
			pageInitCommonService.copyPropertiesIfNull(prpLProp, prpLClaimLossDtoExt);
			prpLClaimLossDtoExt.setPrpLClaimLossDto(prpLClaimLossDto);
			prpLclaimLossDtoList.add(prpLClaimLossDtoExt);
		}
		comClaimDetailQueryDto.setPrpLclaimLossDtoList(prpLclaimLossDtoList);
	}

    /**
     * @descption 获取中文信息
     * @author moujiaxing
     * @date 2017-12-01
     * @param prpLClaimDtoExt 
     * 
     */
	private void changeCodeToName(PrpLClaimDtoExt prpLClaimDtoExt) throws Exception {
		/* (2)对业务归属结构进行转换 */
		String comCode = prpLClaimDtoExt.getPrpLClaimDto().getComCode();
		PrpDcompanyDto companyDto = companyApi.queryCompanyByComCode(comCode);
		prpLClaimDtoExt.setComName(companyDto == null ? "" : companyDto.getComCName());
		/* (3)对归属业务员进行转换 */
		String handler1Code = prpLClaimDtoExt.getPrpLClaimDto().getHandler1Code();
		PrpDuserDto userInfo = userApi.queryUserInfo(handler1Code);
		prpLClaimDtoExt.setHandler1Name(userInfo == null ? "" : userInfo.getUserName());
		/* (4)对代理人进行转换 */
		String agentCode = prpLClaimDtoExt.getPrpLClaimDto().getAgentCode();
		if(!"".equals(agentCode)&&agentCode!=null){
		PrpDuserDto agentInfo = userApi.queryUserInfo(agentCode);
		prpLClaimDtoExt.setAgentName(agentInfo == null ? "" : agentInfo.getUserName());
		}
		/* (5)对经办人进行转换 */
		String handlerCode = prpLClaimDtoExt.getPrpLClaimDto().getHandlerCode();
		PrpDuserDto handlerInfo = userApi.queryUserInfo(handlerCode);
		prpLClaimDtoExt.setHandlerName(handlerInfo == null ? "" : handlerInfo.getUserName());

		/* (6)对案件性质进行转换 */
		String strClaimType = prpLClaimDtoExt.getPrpLClaimDto().getClaimType();
		String strClaimTypeName = null;
		prpLClaimDtoExt.setClaimTypeName(strClaimTypeName);

		/* (7)对业务类型进行转换 */
		String strBusinessNature = prpLClaimDtoExt.getPrpLClaimDto().getBusinessNature();
		String strBusinessNatureName = null;// codeApi.transCodeCodeReturnCodeName("BusinessNature",
											// strBusinessNature, true);
		prpLClaimDtoExt.setBusinessNatureName(strBusinessNatureName);
		/* (8)对makeCom报案登记部门进行转换 */
		String makeCom = prpLClaimDtoExt.getPrpLClaimDto().getMakeCom();
		PrpDcompanyDto makeComDto = companyApi.queryCompanyByComCode(makeCom);
		prpLClaimDtoExt.setMakeComName(makeComDto == null ? "" : makeComDto.getComCName());
		/* (9)接报案员转换 */
		String operatorCode = prpLClaimDtoExt.getPrpLClaimDto().getOperatorCode();
		PrpDuserDto operatorInfo = userApi.queryUserInfo(operatorCode);
		prpLClaimDtoExt.setOperatorName(operatorInfo == null ? "" : operatorInfo.getUserName());

	}

	   /**
     * @descption 通过报案号查询工作流信息
     * @author moujiaxing
     * @date 2017-12-01
     * @param registNo   报案号
     * @return   List<SwfLogDto>  工作流集合
     */
	private List<SwfLogDto>  queryByRegistNo(String registNo) {
		List<SwfLogDto>  swfLogDtos  =  new  ArrayList<SwfLogDto>();	

		String hqlSql ="select l.nodestatus,"+
			    "l.registno,"+
			    "l.logno,"+
			    "l.flowid,"+
			    "l.policyno,"+
			    "l.riskcode,"+
			    "l.insuredname,"+
			    "l.FlowInTime,"+
			    "l.nodename,l.nodetype,l.handlercode,l.handlername from swflog l," +
			    "(select s.registno, min(logno) logno from swflog s " +
			    "where s.registno = :registNo "+
			    " and nodetype in ('check','certa','claim','certi') and nodestatus!='4' group by registno ) t " +
			    "where l.registno=t.registno and l.logno=t.logno";
		Query dataQuery = entityManager.createNativeQuery(hqlSql.toString());
		dataQuery.setParameter("registNo", registNo);
		List<Object[]> list = new ArrayList<>();
		list = dataQuery.getResultList();
		for(int i=0;i<list.size();i++){
			Object[]  obj = list.get(i);
			SwfLogDto swfLogDto  =new  SwfLogDto(); 
			swfLogDto.setNodeStatus(obj[0].toString());
			swfLogDto.setRegistNo(obj[1].toString());
			swfLogDto.setLogNo(Integer.parseInt(obj[2].toString()));
			swfLogDto.setFlowId(obj[3].toString());
			swfLogDto.setPolicyNo(obj[4].toString());
			swfLogDto.setRiskCode(obj[5].toString());
			swfLogDto.setInsuredName(obj[6].toString());
			swfLogDto.setFlowInTime(obj[7].toString());
			swfLogDto.setNodeName(obj[8].toString());
			swfLogDto.setNodeType(obj[9].toString());
			swfLogDtos.add(swfLogDto);
		}
		return swfLogDtos;
	}
	

	/**
     * @descption 合并案件查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCaseQueryInDto 合并案件查询条件组织的对象
     * @return PageInfo 包含并案信息的PageInfo对象
     */
	public PageInfo<ComCaseQueryOutDto> queryByComCaseInDto(ComCaseQueryInDto comCaseQueryInDto) {
		// 查询条件、页码校验
		if (comCaseQueryInDto == null) {
			throw new DataVerifyException("请求参数不能为空！");
		}
		if (comCaseQueryInDto.getPageNo() < 1) {
			throw new DataVerifyException("查询页码不能小于1！");
		}
		if (comCaseQueryInDto.getPageSize() < 1) {
			throw new DataVerifyException("查询每页数量不能小于1！");
		}
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		int pageNo = comCaseQueryInDto.getPageNo();
		int pageSize = comCaseQueryInDto.getPageSize();
		// 查询数据HQL
		StringBuilder dataHql = new StringBuilder();
		// 查询总数量的HQL
		StringBuilder countHql = new StringBuilder();
		// 条件hql拼接
		StringBuilder condition = new StringBuilder();

		Map<String, String> conditions = new HashMap<>();

		condition.append(" 1=1 and o.registno = g.registno ");
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getPolicyNo())) {
			condition.append(" and o.policyNo like :policyNo ");
			conditions.put("policyNo", "%"
					+ comCaseQueryInDto.getPolicyNo().trim() + "%");
		}
		/*if (StringUtils.isNotEmpty(comCaseQueryInDto.getRiskCode())) {
			condition.append(" and s.riskCode in ('");
			Map<String,String> riskCodeMap=new HashMap<String,String>();
			riskCodeMap.put("riskType", comCaseQueryInDto.getRiskCode());
			try{
				List<UtiCodeTransferDto> dtoList = utiCodeTransferApi.queryByRiskType(riskCodeMap);
				if(dtoList.size()>0){
					for(int o=0;o<dtoList.size();o++){
						 if(o==dtoList.size()-1){
							 condition.append(dtoList.get(o).getOuterCode());
						 }else{
							 condition.append(dtoList.get(o).getOuterCode()).append("','");
						 }
					}
				}
			}catch(Exception e){
				throw new DataVerifyException("险种获取异常！");
			}
			condition.append("') ");
		}*/
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getRiskCode())) {
			condition.append(" and o.riskcode=:riskcode ");
			conditions.put("riskcode", comCaseQueryInDto.getRiskCode());
		}
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getStartDate())) {
			condition
					.append("and g.reportdate>=to_date(:reportStartDate,'yyyy-mm-dd') ");
			conditions.put("reportStartDate", comCaseQueryInDto.getStartDate());
		}
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getEndDate())) {
			condition
					.append("and g.reportdate<=to_date(:reportEndDate,'yyyy-mm-dd') ");
			conditions.put("reportEndDate", comCaseQueryInDto.getEndDate());
		}
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getInsuredName())) {
			condition.append(" and o.insuredName like :insuredName ");
			conditions.put("insuredName", "%"+comCaseQueryInDto.getInsuredName()+"%");
		}
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getAccidentNo())) {
			condition.append(" and o.registNo in (select pl.registNo from prplcombine pl where pl.combineNo like :combineNo ) ");
			conditions.put("combineNo", "%"+ comCaseQueryInDto.getAccidentNo().trim() + "%");
		}
		condition.append(" and ((nodeType in('check' ,'certa')  "
				+ " ) or (nodeType not in('check' ,'certa') "
				+ "  OR o.handlerCode= :handlerCode ))"
				+ " and flowStatus!='0' and (flowStatus='1' or flowStatus='2')"
				+ " and (o.handlerCode= :handlerCode or o.handlerCode is null or o.handlerCode='')");
		conditions.put("handlerCode", userCode);
		conditions.put("handlerCode", userCode);
		if (StringUtils.isNotEmpty(comCaseQueryInDto.getAccidentNo())) {
			countHql.append("select count(*) "
					+ "from (select l.* from swflog l,(select s.registno, min(logno) logno "
					+ "from swflog s where s.registno in (select o.registno"
					+ " from swflog o, prplregist g where "
					+ condition.toString()
					+ ") "
					+ "and nodestatus!='4' "
					+ "and nodetype in ('check','certa','claim','certi')  group by s.registno) t,prplcombine u "
					+ "where l.registno = t.registno and l.logno = t.logno and l.registno = u.registno)");
			dataHql.append("select h.policyno,"
					+ "h.registno,"
					+ "h.nodestatus,"
					+ "h.riskcode,"
					+ "h.insuredname,"
					+ "h.nodename,"
                    + "h.flowid,"
                    + "h.logno,"
					+ "p.combineno from (select l.nodestatus,"
					+ "l.registno,"
					+ "l.policyno,"
					+ "l.riskcode,"
					+ "l.insuredname,"
					+ "l.FlowInTime,"
					+ "l.nodename,l.flowid,l.logno from swflog l,(select s.registno, min(logno) logno "
					+ "from swflog s where s.registno in (select o.registno"
					+ " from swflog o, prplregist g where "
					+ condition.toString()
					+ ")"
					+ " and nodestatus!='4' "
					+ " and  nodetype in ('check','certa','claim','certi') "
					+ " group by s.registno order by s.registno) t "
					+ "where l.registno = t.registno and l.logno = t.logno) h, prplcombine p where p.registno = h.registno");

		} else {
			countHql.append("select count(*) from (select s.registno from swflog s "
					+ " where s.registno in (select distinct (o.registno) from swflog o, prplregist g "
					+ " where "
					+ condition.toString()
					+ ") and not exists "
					+ " (select 1 from prplcombine k where k.registno = s.registno) "
					+ "and not exists (select 1 from swflog k where k.registno = s.registno and  nodetype='cance')  "
					+ // 屏蔽立案注销拒赔
					" and nodestatus != 4 "
					+ " and  nodetype in ('check','certa','claim','certi')"
					+ " group by s.registno )");

			dataHql.append("select l.policyno,"
					+ "l.registno,"
					+ "l.nodestatus,"
					+ "l.riskcode,"
					+ "l.insuredname,"
					+ "l.nodename,"
					+ "l.flowid,"
					+ "l.logno "
					+ "from swflog l,"
					+ "(select s.registno, min(logno) logno from swflog s "
					+ "where s.registno in (select o.registno from swflog o, prplregist g where "
					+ condition.toString()
					+ ")"
					+ "and not exists (select 1 from swflog k where k.registno = s.registno and  nodetype='cance')  "
					+ " and nodestatus != 4 "
					+ " and  nodetype in ('check','certa','claim','certi')"
					+ " group by s.registno order by s.registno) t "
					+ "where l.registno=t.registno and l.logno=t.logno");
		}
		javax.persistence.Query countQuery = entityManager
				.createNativeQuery(countHql.toString());
		javax.persistence.Query dataQuery = entityManager
				.createNativeQuery(dataHql.toString());
		// long countNum = (long) countQuery.getSingleResult();
		for (Map.Entry<String, String> entry : conditions.entrySet()) {
			dataQuery.setParameter(entry.getKey(), entry.getValue());
			countQuery.setParameter(entry.getKey(), entry.getValue());
		}
		long countNum = new BigInteger(countQuery.getSingleResult().toString())
				.longValue();
		/*
		 * int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig
		 * .get("sysconst.MaxQueryCount"))); if (maxQueryCount != 0 && countNum
		 * > maxQueryCount) { throw new UserException(1, 3, "0000",
		 * "查询结果个数超过系统限制"); }
		 */
		dataQuery.setFirstResult((pageNo - 1) * pageSize);
		dataQuery.setMaxResults(pageSize);
		List<Object[]> list = new ArrayList<>();
		int count = 0;
		List<ComCaseQueryOutDto> comCaseQueryOutDtoList = new ArrayList<>();
		if (countNum > 0) {// 当查询到的总记录数大于0才继续查询
			list = dataQuery.getResultList();
			// 迭代查询结果
			for (Object[] obj : list) {
				count++;
				ComCaseQueryOutDto comCaseQueryOutDto = new ComCaseQueryOutDto();
				comCaseQueryOutDto.setSerialNo(count);
				if(obj[0] !=null){
					comCaseQueryOutDto.setPolicyNo(obj[0].toString());
				}else{
					comCaseQueryOutDto.setPolicyNo("");
				}
				if(obj[1] !=null){
					comCaseQueryOutDto.setRegistNo(obj[1].toString());
				}else{
					comCaseQueryOutDto.setRegistNo("");
				}
				if(obj[2] !=null){
					comCaseQueryOutDto.setNodeStatus(obj[2].toString());
				}else{
					comCaseQueryOutDto.setNodeStatus("");
				}
				if(obj[3] !=null){
					comCaseQueryOutDto.setRiskCode(obj[3].toString());
				}else{
					comCaseQueryOutDto.setRiskCode("");
				}
				if(obj[4] !=null){
					comCaseQueryOutDto.setInsuredName(obj[4].toString());
				}else{
					comCaseQueryOutDto.setInsuredName("");
				}
				if(obj[5] !=null){
					comCaseQueryOutDto.setNodeName(obj[5].toString());
				}else{
					comCaseQueryOutDto.setNodeName("");
				}
				if(StringUtils.isNotEmpty(comCaseQueryInDto.getAccidentNo())){
					comCaseQueryOutDto.setAccidentNo(comCaseQueryInDto.getAccidentNo());
				}else{
					PrpLCombineDto prpLCombineDto = this.queryByPK(comCaseQueryOutDto.getRegistNo());
					if(prpLCombineDto!=null){
						if(LOGGER.isInfoEnabled()){
							LOGGER.error("combineNo=:" + prpLCombineDto.getCombineNo());
						}
						comCaseQueryOutDto.setAccidentNo(prpLCombineDto.getCombineNo());
					}else{
						comCaseQueryOutDto.setAccidentNo("");
					}
				}
				comCaseQueryOutDto.setSwfLogFlowID(obj[6].toString());
				comCaseQueryOutDto.setSwfLogLogNo(obj[7].toString());
				comCaseQueryOutDtoList.add(comCaseQueryOutDto);
			}
		}
		PageInfo<ComCaseQueryOutDto> pageInfo = new PageInfo<>();
		pageInfo.setContent(comCaseQueryOutDtoList);// 数据存放dto集合
		pageInfo.setPages(comCaseQueryInDto.getPageNo());// 当前页数
		pageInfo.setTotalCount(countNum);// 总记录数
		return pageInfo;
	}

	/**
     * @descption 合并查勘定损查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并查勘定损查询条件组织的对象
     * @return PageInfo 包含合并查勘定损信息的PageInfo对象
     */
	public PageInfo<ComCheckQueryOutDto> queryByComCheckInDto(ComCheckQueryInDto comCheckQueryInDto) throws Exception {
		// 查询条件、页码校验
		if (comCheckQueryInDto == null) {
			throw new DataVerifyException("请求参数不能为空！");
		}
		if (comCheckQueryInDto.getPageNo() < 1) {
			throw new DataVerifyException("查询页码不能小于1！");
		}
		if (comCheckQueryInDto.getPageSize() < 1) {
			throw new DataVerifyException("查询每页数量不能小于1！");
		}
		int pageNo = comCheckQueryInDto.getPageNo();
		int pageSize = comCheckQueryInDto.getPageSize();
		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
		String policyNo = comCheckQueryInDto.getPolicyNo();
		
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		//PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
		
		String insuredName = comCheckQueryInDto.getInsuredName();
		String flowInTimeStart = comCheckQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd = comCheckQueryInDto.getFlowInTimeEnd();
		String combineNo = comCheckQueryInDto.getCombineNo();
		String registNo = comCheckQueryInDto.getRegistNo();
		String nodeStatus = comCheckQueryInDto.getNodeStatus();
		// 查询工作流状态信息,整理输入，用于初始界面显示
		// 需要进行翻页处理
		// 每页显示的行数
		// 查询数据HQL
		StringBuilder dataHql = new StringBuilder();
		// 查询总数量的HQL
		StringBuilder countHql = new StringBuilder();
		// 条件hql拼接

		Map<String, String> conditions1 = new HashMap<>();

		countHql.append("Select count(*) from swflog s, prplcombine p Where ");
		dataHql.append("Select s.RegistNo," + " s.PolicyNo,"
				+ " s.RiskCode," + " s.InsuredName,"
				+ " s.LossItemCode," + " s.LossItemName,"
				+ " s.FlowInTime," + " s.NodeStatus,"
				+ " s.handlername,"
				+ " s.flowid,"
				+ " s.logno,"
				+ " p.COMBINENO" + " From swflog s, prplcombine p Where ");

		// 查询理赔节点状态信息
		// 得到多行报案主表信息
		StringBuilder conditionsTemp = new StringBuilder();
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;

		String orderString = " order by handleTime desc";
		// 如果查询对外核价任务则修改节点类型

		// 开始拼条件。。。。
		// 首先加入联表条件。 GYIC 李杨 20110803 start
		// 首先加入联表条件。 GYIC 李杨 20110803 end
		conditionsTemp.append(" s.RegistNo = p.registNo ");
		// 拼接certa、check类型查询条件
		conditionsTemp.append(" and (nodeType ='check' ");
		conditionsTemp.append(" and s.riskCode in ('");
		Map<String,String> riskCodeMap=new HashMap<String,String>();
		riskCodeMap.put("riskType", "I");
		try{
			List<UtiCodeTransferDto> dtoList = utiCodeTransferApi.queryByRiskType(riskCodeMap);
			if(dtoList.size()>0){
				for(int o=0;o<dtoList.size();o++){
					 if(o==dtoList.size()-1){
						 conditionsTemp.append(dtoList.get(o).getOuterCode());
					 }else{
						 conditionsTemp.append(dtoList.get(o).getOuterCode()).append("','");
					 }
				}
			}
		}catch(Exception e){
			throw new DataVerifyException("险种获取异常！");
		}
		conditionsTemp.append("')) ");

		if (StringUtils.isNotEmpty(userCode)) {
			conditionsTemp
					.append(" and (handlerCode= :handlerCode or handlerCode is null or handlerCode='')");
			conditions1.put("handlerCode", userCode);
		}

		if (StringUtils.isNotEmpty(registNo)) {
			conditionsTemp.append(" and s.RegistNo like :registNo");
			conditions1.put("registNo", "%" + registNo + "%");
		}
		// reason:支持多保单的查询
		if (StringUtils.isNotEmpty(policyNo)) {
			conditionsTemp
					.append(" and s.registNo in (select registNo from "
							+ "prplregistrpolicy where 1=1  and policyNo like :policyNo)");
			conditions1.put("policyNo", "%" + policyNo + "%");
		}

		if (StringUtils.isNotEmpty(insuredName)) {
			conditionsTemp.append(" and insuredName like :insuredName");
			conditions1.put("insuredName", "%" + insuredName + "%");
		}

		if (StringUtils.isNotEmpty(flowInTimeStart)) {
			conditionsTemp
					.append(" and FlowInTime >= :flowInTimeStart");
			conditions1.put("flowInTimeStart", flowInTimeStart);
		}
		if (StringUtils.isNotEmpty(flowInTimeEnd)) {
			conditionsTemp
					.append(" and FlowInTime <= :flowInTimeEnd");
			conditions1.put("flowInTimeEnd", flowInTimeEnd);
		}


		if (StringUtils.isNotEmpty(combineNo)) {
			conditionsTemp
					.append(" and p.combineNo like :combineNo");
			conditions1.put("combineNo", "%" + combineNo + "%");
		}

		if (StringUtils.isNotEmpty(nodeStatus)) {
			if("all".equals(nodeStatus)){
				conditionsTemp.append(" and nodeStatus <= '4' ");
			}else{
				conditionsTemp.append(" and nodeStatus = :nodeStatus");
				conditions1.put("nodeStatus", nodeStatus);
			}
		}

		conditionsTemp.append(orderString);

		conditions = conditionsTemp.toString();
		dataHql.append(conditions.toString());
		// 数量查询去掉order by 语句
		int pos = 0;
		pos = StringUtils.indexOf(conditions.toLowerCase(), " order by ", 0,
				false);
		if (pos > 0) {
			conditions = conditions.substring(0, pos);
		}
		countHql.append(conditions.toString());
		// 查询开始
		Query countQuery = entityManager.createNativeQuery(countHql.toString());
		Query dataQuery = entityManager.createNativeQuery(dataHql.toString());
		// 设置参数
		for (String key : conditions1.keySet()) {
			countQuery.setParameter(key, conditions1.get(key));
			dataQuery.setParameter(key, conditions1.get(key));
		}
		// 查询数据总条数

		long countNum = new BigInteger(countQuery.getSingleResult().toString())
				.longValue();
		dataQuery.setFirstResult((pageNo - 1) * pageSize);
		dataQuery.setMaxResults(pageSize);
		List<Object[]> list = new ArrayList<>();
		List<ComCheckQueryOutDto> comCheckQueryOutDtoList = new ArrayList<>();
		if (countNum > 0) {// 当查询到的总记录数大于0才继续查询
			list = dataQuery.getResultList();
			// 迭代查询结果
			for (Object[] obj : list) {
				ComCheckQueryOutDto comCheckQueryOutDto = new ComCheckQueryOutDto();
				if(obj[0] !=null){
					comCheckQueryOutDto.setRegistNo(obj[0].toString());
				}else{
					comCheckQueryOutDto.setRegistNo("");
				}
				if(obj[1] !=null){
					comCheckQueryOutDto.setPolicyNo(obj[1].toString());
				}else{
					comCheckQueryOutDto.setPolicyNo("");
				}
				if(obj[2] !=null){
					comCheckQueryOutDto.setRiskCode(obj[2].toString());
				}else{
					comCheckQueryOutDto.setRiskCode("");
				}
				if(obj[3] !=null){
					comCheckQueryOutDto.setInsuredName(obj[3].toString());
				}else{
					comCheckQueryOutDto.setInsuredName("");
				}
				if(obj[5] !=null){
					comCheckQueryOutDto.setLossName(obj[5].toString());
				}else{
					//根据报案号查询受损标的
					// 根据报案号查询受损标的名称
					Query lossNameQuery = entityManager.createNativeQuery(
							"select s.lossName from PrpLRegist s where registNo = '" + obj[0].toString() + "'");
					String lossName = "";
					if (lossNameQuery.getResultList().size() > 0) {
						lossName = (String) lossNameQuery.getSingleResult();
					}
					if (StringUtils.isNotEmpty(lossName)) {
						List<String> lists = new ArrayList<>();
						lists.add(lossName);
						QueryItemCodePmsDto queryItemCodePmsDto = new QueryItemCodePmsDto();
						queryItemCodePmsDto.setRiskCode(obj[2].toString());
						queryItemCodePmsDto.setItemCodeList(lists);
						List<PrpDitemAgriDto> prpDitemAgriDtoList=prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
						if (prpDitemAgriDtoList.size()!=0) {
							lossName = prpDitemAgriApi.queryItemName(queryItemCodePmsDto).get(0).getItemCName();
						}
						else {
							lossName="";
						}

					}
					comCheckQueryOutDto.setLossName(lossName);
				}
				if(obj[6] !=null){
					comCheckQueryOutDto.setFlowInTime(obj[6].toString());
				}else{
					comCheckQueryOutDto.setFlowInTime("");
				}
				if(obj[7] !=null){
					comCheckQueryOutDto.setNodeStatus(obj[7].toString());
				}else{
					comCheckQueryOutDto.setNodeStatus("");
				}
				if(obj[8] !=null){
					comCheckQueryOutDto.setHandlerName(obj[8].toString());
				}else{
					comCheckQueryOutDto.setHandlerName("");
				}
				comCheckQueryOutDto.setSwfLogFlowID(obj[9].toString());
				comCheckQueryOutDto.setSwfLogLogNo(obj[10].toString());
				if(obj[9] !=null){
					comCheckQueryOutDto.setCombineNo(obj[11].toString());
				}else{
					comCheckQueryOutDto.setCombineNo("");
				}
				comCheckQueryOutDtoList.add(comCheckQueryOutDto);
			}
		}
		PageInfo<ComCheckQueryOutDto> pageInfo = new PageInfo<>();
		pageInfo.setContent(comCheckQueryOutDtoList);// 数据存放dto集合
		pageInfo.setPages(pageNo);// 当前页数
		pageInfo.setTotalCount(countNum);// 总记录数
		return pageInfo;
	}

	/**
     * @descption 合并立案查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并立案查询条件组织的对象
     * @return PageInfo 包含合并立案信息的PageInfo对象
     */
	public PageInfo<ComClaimQueryOutDto> queryByComClaimInDto(ComClaimQueryInDto comClaimQueryInDto) throws Exception {
		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
		String policyNo = comClaimQueryInDto.getPolicyNo();
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		

		String riskType = comClaimQueryInDto.getRiskType();
		String insuredName = comClaimQueryInDto.getInsuredName();
		String flowInTimeStart = comClaimQueryInDto.getFlowInTimeStart();
		String flowInTimeEnd = comClaimQueryInDto.getFlowInTimeEnd();
		String combineNo = comClaimQueryInDto.getCombineNo();
		String registNo = comClaimQueryInDto.getRegistNo();
		String nodeStatus = comClaimQueryInDto.getNodeStatus();
		String claimNo = comClaimQueryInDto.getClaimNo();
		// 查询工作流状态信息,整理输入，用于初始界面显示
		// 需要进行翻页处理
		// 每页显示的行数
		int pageSize = comClaimQueryInDto.getPageSize();
		int pageNo = comClaimQueryInDto.getPageNo();
		// 查询数据HQL
		StringBuilder dataHql = new StringBuilder();
		// 查询总数量的HQL
		StringBuilder countHql = new StringBuilder();
		// 条件hql拼接

		Map<String, String> conditions1 = new HashMap<>();

		countHql.append("Select count(*) from SwfLog, PRPLCOMBINE Where ");
		dataHql.append("Select SWFLOG.RegistNo," + " SWFLOG.PolicyNo,"
				+ " SWFLOG.RiskCode," + " SWFLOG.InsuredName,"
				+ " SWFLOG.LossItemCode," + " SWFLOG.LossItemName,"
				+ " SWFLOG.FlowInTime," + " SWFLOG.NodeStatus,"
				+ " SWFLOG.handlername,"
				+ " SWFLOG.flowid,"
				+ " SWFLOG.logno,"
				+ " PRPLCOMBINE.COMBINENO" + " From SwfLog, PRPLCOMBINE Where ");

		// 查询理赔节点状态信息
		// 得到多行报案主表信息
		StringBuilder conditionsTemp = new StringBuilder();
		// 判断节点，有的需要根据用户名称进行查询，有的不需要用户名字进行查询
		String conditions = null;

		String orderString = " order by handleTime desc";
		// 如果查询对外核价任务则修改节点类型

		// 开始拼条件。。。。
		// 首先加入联表条件。 GYIC 李杨 20110803 start
		// 首先加入联表条件。 GYIC 李杨 20110803 end
		conditionsTemp.append(" SWFLOG.RegistNo = PRPLCOMBINE.RegistNo ");
		// 拼接certa、check类型查询条件
		conditionsTemp.append("and ( nodeType ='claim')");

		if (StringUtils.isNotEmpty(userCode)) {
			conditionsTemp
					.append(" and (handlerCode= :userCode or handlerCode is null or handlerCode='')");
			conditions1.put("userCode", userCode);
		}

		if (StringUtils.isNotEmpty(registNo)) {
			conditionsTemp.append(" and SWFLOG.RegistNo like :registNo");
			conditions1.put("registNo", "%" + registNo + "%");
		}
		// reason:支持多保单的查询
		if (StringUtils.isNotEmpty(policyNo)) {
			conditionsTemp
					.append(" and SWFLOG.registno in (select registno from "
							+ "prplregistrpolicy where 1=1  and policyNo like :policyNo)");
			conditions1.put("policyNo", "%" + policyNo + "%");
		}

		if (StringUtils.isNotEmpty(insuredName)) {
			conditionsTemp.append(" and insuredName like :insuredName");
			conditions1.put("insuredName", "%" + insuredName + "%");
		}

		if (StringUtils.isNotEmpty(flowInTimeStart)) {
			conditionsTemp
					.append(" and FlowInTime >= :flowInTimeStart");
			conditions1.put("flowInTimeStart", flowInTimeStart);
		}
		if (StringUtils.isNotEmpty(flowInTimeEnd)) {
			conditionsTemp
					.append(" and FlowInTime <= :flowInTimeEnd");
			conditions1.put("flowInTimeEnd", flowInTimeEnd);
		}

		if (StringUtils.isNotEmpty(riskType)) {
			conditionsTemp.append(" and riskCode like :riskCode");
			conditions1.put("riskCode", "%" + riskType + "%");
		}

		if (StringUtils.isNotEmpty(combineNo)) {
			conditionsTemp
					.append(" and PRPLCOMBINE.combineNo like :combineNo");
			conditions1.put("combineNo", "%" + combineNo + "%");
		}

		if (StringUtils.isNotEmpty(nodeStatus)) {
			if("all".equals(nodeStatus)){
				conditionsTemp.append(" and nodeStatus <= '4' ");
			}else{
				conditionsTemp.append(" and nodeStatus = :nodeStatus");
				conditions1.put("nodeStatus", nodeStatus);
			}
		}

		if (StringUtils.isNotEmpty(claimNo)) {
			conditionsTemp
					.append(" and exists  ( select * from prplclaim where prplclaim.registno=PRPLCOMBINE.registno and prplclaim.claimNo like :claimNo)");
			conditions1.put("claimNo", "%" + claimNo + "%");
		}

		conditionsTemp.append(orderString);

		conditions = conditionsTemp.toString();
		dataHql.append(conditions.toString());
		// 数量查询去掉order by 语句
		int pos = 0;
		pos = StringUtils.indexOf(conditions.toLowerCase(), " order by ", 0,
				false);
		if (pos > 0) {
			conditions = conditions.substring(0, pos);
		}
		countHql.append(conditions.toString());
		// 查询开始
		Query countQuery = entityManager.createNativeQuery(countHql.toString());
		Query dataQuery = entityManager.createNativeQuery(dataHql.toString());
		// 设置参数
		for (String key : conditions1.keySet()) {
			countQuery.setParameter(key, conditions1.get(key));
			dataQuery.setParameter(key, conditions1.get(key));
		}
		// 查询数据总条数

		long countNum = new BigInteger(countQuery.getSingleResult().toString())
				.longValue();
		dataQuery.setFirstResult((pageNo - 1) * pageSize);
		dataQuery.setMaxResults(pageSize);
		List<Object[]> list = new ArrayList<>();
		List<ComClaimQueryOutDto> comClaimQueryOutDtoList = new ArrayList<>();
		if (countNum > 0) {// 当查询到的总记录数大于0才继续查询
			list = dataQuery.getResultList();
			// 迭代查询结果
			for (Object[] obj : list) {
				ComClaimQueryOutDto comClaimQueryOutDto = new ComClaimQueryOutDto();
				if(obj[0] !=null){
					comClaimQueryOutDto.setRegistNo(obj[0].toString());
				}else{
					comClaimQueryOutDto.setRegistNo("");
				}
				if(obj[1] !=null){
					comClaimQueryOutDto.setPolicyNo(obj[1].toString());
				}else{
					comClaimQueryOutDto.setPolicyNo("");
				}
				if(obj[2] !=null){
					comClaimQueryOutDto.setRiskCode(obj[2].toString());
				}else{
					comClaimQueryOutDto.setRiskCode("");
				}
				if(obj[3] !=null){
					comClaimQueryOutDto.setInsuredName(obj[3].toString());
				}else{
					comClaimQueryOutDto.setInsuredName("");
				}
				if(obj[5] !=null){
					comClaimQueryOutDto.setLossName(obj[5].toString());
				}else{
					//根据报案号查询受损标的
					// 根据报案号查询受损标的名称
					Query lossNameQuery = entityManager.createNativeQuery(
							"select s.lossName from PrpLRegist s where registNo = '" + obj[0].toString() + "'");
					String lossName = "";
					if (lossNameQuery.getResultList().size() > 0) {
						lossName = (String) lossNameQuery.getSingleResult();
					}
					if (StringUtils.isNotEmpty(lossName)) {
						List<String> lists = new ArrayList<>();
						lists.add(lossName);
						QueryItemCodePmsDto queryItemCodePmsDto = new QueryItemCodePmsDto();
						queryItemCodePmsDto.setRiskCode(obj[2].toString());
						queryItemCodePmsDto.setItemCodeList(lists);
						List<PrpDitemAgriDto> prpDitemAgriDtoList=prpDitemAgriApi.queryItemName(queryItemCodePmsDto);
						if (prpDitemAgriDtoList.size()!=0) {
							lossName = prpDitemAgriApi.queryItemName(queryItemCodePmsDto).get(0).getItemCName();
						}
						else {
							lossName="";
						}

					}
					comClaimQueryOutDto.setLossName(lossName);
					//comClaimQueryOutDto.setLossName("");
				}
				if(obj[6] !=null){
					comClaimQueryOutDto.setFlowInTime(obj[6].toString());
				}else{
					comClaimQueryOutDto.setFlowInTime("");
				}
				if(obj[7] !=null){
					comClaimQueryOutDto.setNodeStatus(obj[7].toString());
				}else{
					comClaimQueryOutDto.setNodeStatus("");
				}
				if(obj[8] !=null){
					comClaimQueryOutDto.setHandlerName(obj[8].toString());
				}else{
					comClaimQueryOutDto.setHandlerName("");
				}
				comClaimQueryOutDto.setSwfLogFlowID(obj[9].toString());
				comClaimQueryOutDto.setSwfLogLogNo(obj[10].toString());
				if(obj[9] !=null){
					comClaimQueryOutDto.setCombineNo(obj[11].toString());
				}else{
					comClaimQueryOutDto.setCombineNo("");
				}
				comClaimQueryOutDtoList.add(comClaimQueryOutDto);
			}
		}
		PageInfo<ComClaimQueryOutDto> pageInfo = new PageInfo<>();
		pageInfo.setContent(comClaimQueryOutDtoList);// 数据存放dto集合
		pageInfo.setPages(pageNo);// 当前页数
		pageInfo.setTotalCount(countNum);// 总记录数
		return pageInfo;
	}

	/**
     * @descption 合并查勘定损暂存、提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并查勘定损暂存、提交信息列表
     */
	public Map<String,String> saveSubmitComCheck(List<ComCheckInDto> comCheckInDtoList)
			throws Exception {
		Map<String,String> mapNew = new HashMap<String,String>();
		String combineNo ="";
		String userCode = SinoRequestContext.getCurrentContext().getUserCode();
		PrpDuserDto user = userApi.queryUserInfo(userCode);
		List<ComCheckInDto> comCheckInDtoCheckList = new ArrayList<ComCheckInDto>();
		List<WorkFlowDto> workFlowDtoCheckList = new ArrayList<WorkFlowDto>();
		List<ComCheckInDto> comCheckInDtoCertaList = new ArrayList<ComCheckInDto>();
		List<WorkFlowDto> workFlowDtoCertaList = new ArrayList<WorkFlowDto>();
		

		for (int i = 0; i < comCheckInDtoList.size(); i++) {
			ComCheckInDto comCheckInDto = comCheckInDtoList.get(i);
			PrpLCombineDto	prpcombineDto = this.queryByPK(comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto().getRegistNo());
			combineNo=  prpcombineDto.getCombineNo();
			String checkNo = comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto().getRegistNo();
			String conditions = "select count(1) from swflog s where registNo = :registNo and nodeType = 'check' and nodestatus !='4'";
			Query countQuery = entityManager.createNativeQuery(conditions);
			countQuery.setParameter("registNo", checkNo);
			//long countNum = (long) countQuery.getSingleResult();
			long countNum = new BigInteger(countQuery.getSingleResult().toString())
			.longValue();
			if (countNum != 1)
				throw new Exception("节点异常,报案号：" + checkNo);
			// ////////////////
			String comCode = user.getComCode();
			String riskCode = comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto().getRiskCode();
			String swfLogFlowID = comCheckInDto.getSwfLogFlowID(); // 工作流号码
			String swfLogLogNo = comCheckInDto.getSwfLogLogNo(); // 工作流logno
			String activeSchedule = comCheckInDto.getMessageToScheduleCheck(); // 通知调度，使调度工作流变成待处理状态
			int year = DateTime.current().getYear();

			if (checkNo == null || checkNo.length() < 1
					|| checkNo.trim().equals("")) {
				BillNoDto billNoDto = new BillNoDto();
				billNoDto.setTableName("prplcheck");
				billNoDto.setRiskCode(riskCode);
				billNoDto.setiComCode(comCode);
				billNoDto.setiYear(year + "");
				billNoDto.setUserCode(user.getUserCode());
				checkNo = billNoApi.getBillNo(billNoDto).get("billNo");
			}
			// 用viewHelper整理界面输入
			// 区分是三者，或者是主车的内容进行分别的数据整理
			// modify by miaowenjun 20060922 农险走自己的viewhelper
			Map<String, String> map = new HashMap<String, String>();
			map.put("outerCode", riskCode);
			String riskType = utiCodeTransferApi.queryUtiCodeTransferDtoByOuterCode(map).get(0).getRiskType();

			if ("I".equals(riskType) || "H".equals(riskType)) {
				comCheckInDto = this.viewToDto(user,comCheckInDto);
				// 在下面这个判断里面写上,关于立案表数据的处理
			}
			// 工作流处理过程
			// -----------------------------------------------------
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			if (swfLogFlowID != null && swfLogLogNo != null) {
				swfLogDtoDealNode.setFlowId(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils
						.nullToZero(swfLogLogNo)));
			} else {
				swfLogDtoDealNode.setNodeType("check");
				swfLogDtoDealNode.setBusinessNo(comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto()
						.getRegistNo());
			}
			swfLogDtoDealNode.setNodeStatus(comCheckInDto.getPrpLclaimStatusDto().getStatus());
			swfLogTransferDto.setNextBusinessNo(comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto().getRegistNo());
			WorkFlowDto workFlowDto = null;
			swfLogDtoDealNode.setKeyOut(checkNo);
			// 回访是查勘提交过来的回访,没有typeflag的值,1表示查勘回访，2表示定损回访
			swfLogDtoDealNode.setTypeFlag("1");
			swfLogDtoDealNode.setKeyIn(comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto()
					.getRegistNo());
			swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
			swfLogTransferDto.setUserComName(user.getUserName());
			swfLogTransferDto.setUserUserCode(user.getUserCode());
			swfLogTransferDto.setUserUserName(user.getUserName());
			workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
			// 修改查勘通知调度的方式
			// 通知调度
			if ("4".equals(swfLogDtoDealNode.getNodeStatus())&& "1".equals(activeSchedule)) {
				if (workFlowDto.getUpdateSwfLogDto() != null) {
					String flowID = workFlowDto.getUpdateSwfLogDto()
							.getFlowId();
					// 查找没有完成的调度，比如正在处理的调度
					String conditonss = "select s from swflog s where flowId= :flowId and nodeType='sched' and nodeStatus='2'";
					Query dataQuery = entityManager.createQuery(conditonss);
					dataQuery.setParameter("flowId", flowID);
					List<SwfLogDto> schedList = dataQuery.getResultList();
					if (schedList != null && schedList.size() > 0) {
						SwfLogDto swfLogDto1 = new SwfLogDto();
						swfLogDto1 = schedList.get(0);
						swfLogDto1.setNodeStatus("0");
						swfLogDto1.setHandlerCode("");
						swfLogDto1.setHandlerName("");
						swfLogDto1.setTypeFlag("15");
						swfLogDto1.setFlowInTime(new DateTime(DateTime.current(),
										DateTime.YEAR_TO_SECOND).toString());
						workFlowDto.setUpdateSwfLog2Dto(swfLogDto1);
					}
				}
			}
			// 不通知调度
			if ("4".equals(swfLogDtoDealNode.getNodeStatus())
					&& "0".equals(activeSchedule)) {
				// 如果为查勘提交，则判断是不是需要通知调度的选项, activeSchedule.equals(
				// "0")说明不需要通知调度的
				// 虽然不需要通知，但是需要判断是否所有的调度都已经做完了，如果做完了，则需要结束调度任务
				if (workFlowDto.getUpdateSwfLogDto() != null) {
					String flowID = workFlowDto.getUpdateSwfLogDto()
							.getFlowId();
					// 查找没有完成的调度，比如正在处理的调度

					String conditonss = "select s from swflog s where flowId= :flowId and nodeType='sched' and nodestatus<'4'";
					Query dataQuery = entityManager.createQuery(conditonss);
					dataQuery.setParameter("flowId", flowID);
					List<SwfLogDto> schedList = dataQuery.getResultList();

					if (schedList != null && schedList.size() > 0) {
						String strSql = "select p from  PrpLScheduleItem p where registno= :registno and surveyTimes<1";
						dataQuery = entityManager.createQuery(strSql);
						dataQuery.setParameter("registno", comCheckInDto
								.getPrpLcheckDtoExt().getPrpLCheckDto().getRegistNo());
						List<PrpLScheduleItemDto> scheduleItemList = dataQuery.getResultList();
						if (scheduleItemList != null
								&& scheduleItemList.size() > 0) {
							// 没有完成调度呢。。
							System.out.println("没有完成调度呢。。");
							workFlowDto.setUpdateSwfLog2Dto(null);
						} else {
							SwfLogDto swfLogDto2 = new SwfLogDto();
							swfLogDto2 = schedList.get(0);
							swfLogDto2.setNodeStatus("4");
							workFlowDto.setUpdateSwfLog2Dto(swfLogDto2);
						}
					}
				}
			}
			if ((workFlowDto.isCreate()) || (workFlowDto.isUpdate())
					|| (workFlowDto.isSubmit()) || (workFlowDto.isClose())) {
				workFlowDtoCheckList.add(workFlowDto);
			}

			// 以下是业务使用
			String registNo = comCheckInDto.getPrpLverifyLossDto().getRegistNo(); // 报案号
			// ////////////
			String conditions1 = "select s from SwfLog s where registNo = :registNo and nodeType = 'check' and nodeStatus !='4'";
			Query dataQuery = entityManager.createQuery(conditions1);
			dataQuery.setParameter("registNo", registNo);
			List<SwfLogDto> swfLogCollection = dataQuery.getResultList();
			if (null == swfLogCollection || swfLogCollection.size() != 1)
				throw new Exception("节点异常,报案号：" + registNo);
			// ////////////////
			String condition = "select s from SwfLog s where flowId =:flowId and  logNo= :logNo and nodeStatus ='4'";
			dataQuery = entityManager.createQuery(condition);
			dataQuery.setParameter("flowId", swfLogFlowID);
			dataQuery.setParameter("logNo", new Integer(swfLogLogNo));
			List<SwfLogDto> certifyNodeList = dataQuery.getResultList();
			if (certifyNodeList != null && certifyNodeList.size() > 0) {
				throw new Exception("该案件定损节点已处理！");
			}
			PrpLRegistDto prpLRegistDto = prpLRegistService.queryByPK(registNo);
			String businessType = prpLRegistDto.getBusinessType();
			String businessType1 = prpLRegistDto.getBusinessType1();

			comCheckInDto.getPrpLverifyLossDto().setBusinessType(businessType);
			comCheckInDto.getPrpLverifyLossDto()
					.setBusinessType1(businessType1);


			String lossItemCode = comCheckInDto.getPrpLverifyLossDto()
					.getLossItemCode(); // 损失代码

			WorkFlowDto workFlowDto1 = new WorkFlowDto();
			// 定损的工作流设置，比较特殊
			SwfLogDto swfLogDtoDealNode1 = new SwfLogDto();
			SwfLogTransferDto swfLogTransferDto1 = new SwfLogTransferDto();
			if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
				swfLogDtoDealNode1.setFlowId(swfLogFlowID);
				swfLogDtoDealNode1.setLogNo(Integer.parseInt(DataUtils
						.nullToZero(swfLogLogNo)));
			}
			swfLogDtoDealNode1.setBusinessNo(registNo);
			swfLogTransferDto1.setNextBusinessNo(registNo);
			String statusTemp = comCheckInDto.getPrpLclaimStatusDto().getStatus();
			swfLogDtoDealNode1.setNodeStatus(statusTemp);
			swfLogDtoDealNode1.setKeyIn(registNo);
			swfLogDtoDealNode1.setKeyOut(registNo);
			swfLogTransferDto1.setConditionBusinessNo(registNo);
			swfLogDtoDealNode1.setLossitemCode(lossItemCode);
			PrpLRegistDto prpLRegistDto1 = prpLRegistService.queryByPK(registNo);
			swfLogDtoDealNode1.setRiskCode(prpLRegistDto1.getRiskCode());
			swfLogTransferDto1.setUserComName(user.getUserName());
			swfLogTransferDto1.setUserUserCode(user.getUserCode());
			swfLogTransferDto1.setUserUserName(user.getUserName());
			// 判断如果是理算退回的定损，并且该定损没有新增加数据，那么可以直接提交回理算的。
			// 相应的问题，如果理算处，以上信息都没完成，是不可以进行出理算书的。
			swfLogTransferDto1.setSwfLogDto(swfLogDtoDealNode1);
			workFlowDto1 = workFlowService.viewToDto(swfLogTransferDto1);
			// 保存定损信息
			if (comCheckInDto.getPrpLclaimStatusDto().getStatus().equals("4")
					&& workFlowDto1.getSubmitSwfLogDtoList() == null) {
				// strRegistNo = strRegistNo + registNo + ";\r";
			} else {
				if ((workFlowDto1.isCreate()) || (workFlowDto1.isUpdate())
						|| (workFlowDto1.isSubmit()) || (workFlowDto1.isClose())) {
					workFlowDtoCertaList.add(workFlowDto1);
					comCheckInDtoCertaList.add(comCheckInDto);
				} else {
					comCheckInDtoCertaList.add(comCheckInDto);
				}
			}
			
			for (int j = 0; j < workFlowDtoCheckList.size(); j++) {
				workFlowService.deal(workFlowDtoCheckList.get(j));
			}
			if (comCheckInDtoCertaList.size() < comCheckInDtoCertaList.size()) {
				
			} else {
				if (workFlowDtoCertaList.size() != comCheckInDtoCertaList.size()) {
					
				} else {
					for (int j = 0; j < workFlowDtoCertaList.size(); j++) {
						workFlowService.deal(workFlowDtoCertaList.get(j));
					}
				}
			}
			comCheckInDtoCheckList.add(comCheckInDto);
		}
		for(int i=0;i<comCheckInDtoCheckList.size();i++){
			saveCheckDto(comCheckInDtoCheckList.get(i));
		}
		if("4".equals(comCheckInDtoList.get(0).getPrpLclaimStatusDto().getStatus())){
			mapNew.put("code", "0000");
			mapNew.put("message", "合并查勘定损提交成功!");
			mapNew.put("combineNo", combineNo);

		}else{
			mapNew.put("code", "0000");
			mapNew.put("message", "合并查勘定损暂存成功!");
			mapNew.put("combineNo", combineNo);

		}
		return mapNew;
	}
	
	/**
     * @descption 合并立案提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并立案提交信息列表
     */
	public Map<String,String> saveSubmitComClaim(List<ComClaimInDto> comCheckInDtoList)
			throws Exception {
		Map<String,String> mapNew = new HashMap<String,String>();
		String  combineNo="";
		// 如果是新登记，则从取号表中取赔案号码，如果是修改，则保持原来的claimNo不变
		// 取赔案号
		// 0 表示不需要， 1表示需要
		String claimNo = "";
		String comCode = "";
		ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();

		for (int indexOfRegistNo = 0; indexOfRegistNo < comCheckInDtoList
				.size(); indexOfRegistNo++) {
			ComClaimInDto comClaimInDto = comCheckInDtoList
					.get(indexOfRegistNo);

			PrpLClaimDto prpLClaimDto = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto();
			String userCode = SinoRequestContext.getCurrentContext().getUserCode();
			PrpDuserDto user = userApi.queryUserInfo(userCode);
			claimNo = prpLClaimDto.getClaimNo(); // 赔案号
			String registNo = prpLClaimDto.getRegistNo();
			PrpLCombineDto	prpcombineDto = this.queryByPK(registNo);
			combineNo=  prpcombineDto.getCombineNo();
			// ////////////
			String strCondition = "select s from SwfLog s where registNo = :registNo and nodeType = 'claim' and nodeStatus !='4'";
			Query dataQuery = entityManager.createQuery(strCondition);
			dataQuery.setParameter("registNo", registNo);
			List<SwfLogDto> swfLogCollection = dataQuery.getResultList();
			if (null == swfLogCollection || swfLogCollection.size() != 1)
				throw new Exception("节点异常,报案号：" + registNo);
			// ////////////////
			String riskCode = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getRiskCode(); // add by lym
															// 20060605 for 强三
			Map<String, String> map = new HashMap<String, String>();
			map.put("outerCode", riskCode);
			String riskType = utiCodeTransferApi.queryUtiCodeTransferDtoByOuterCode(map).get(0)
					.getRiskType();
			String swfLogFlowID = comClaimInDto.getSwfLogFlowID(); // 工作流号码 add
			String swfLogLogNo = comClaimInDto.getSwfLogLogNo(); // 工作流logno add
																	// 20051228

			comCode = user.getComCode();
			int year = DateTime.current().getYear();

			// 防止回退刷新再提交，或多人同时操作提交同一案件。
			String condition = "select s from SwfLog s where flowId = :flowId and logNo = :logNo and nodeStatus in ('4')";
			dataQuery = entityManager.createQuery(condition);
			dataQuery.setParameter("flowId", swfLogFlowID);
			dataQuery.setParameter("logNo", Integer.parseInt(DataUtils
					.nullToZero(swfLogLogNo)));
			Collection certifyNodeList = dataQuery.getResultList();
			if (certifyNodeList != null && certifyNodeList.size() > 0) {
				throw new Exception("该案件立案节点已处理！");
			}
			// 在立案保存或者提交的时候对查勘和定损环节的处理状态进行判断仅仅对养殖险进行处理
			if ("I".equals(riskType)) {
				String conditions = "select s from SwfLog s where flowId=:flowId and nodeType ='check' and nodeStatus !='4'";
				dataQuery = entityManager.createQuery(conditions);
				dataQuery.setParameter("flowId", swfLogFlowID);
				List<SwfLogDto> swfLogList = dataQuery.getResultList();
				if (swfLogList != null && swfLogList.size() > 0)
					throw new Exception("查勘或定损节点未提交,不能立案保存!");
			}

			if ( claimNo == null|| claimNo.length() < 1) {
				// 取号过程还需要进一步完善
				BillNoDto billNoDto = new BillNoDto();
				billNoDto.setTableName("prplclaim");
				billNoDto.setRiskCode(riskCode);
				billNoDto.setiComCode(comCode);
				billNoDto.setiYear(year + "");
				billNoDto.setUserCode(user.getUserCode());
				Map a = billNoApi.getBillNo(billNoDto);
				claimNo = billNoApi.getBillNo(billNoDto).get("billNo");
				prpLClaimDto.setClaimNo(claimNo);
			}

			// 用viewHelper整理界面输入

			if ("I".equals(riskType) || "H".equals(riskType)) {
				comClaimInDto = this.viewToClaimDto(user,comClaimInDto);
			}
			PrpLRegistDto prpLRegistDto = prpLRegistService.queryByPK(registNo);
			String businessType = prpLRegistDto.getBusinessType();
			String businessType1 = prpLRegistDto.getBusinessType1();
			String businessFlag = prpLRegistDto.getBusinessFlag();
			String otherFlag = prpLRegistDto.getOtherFlag();
			comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().setBusinessType(businessType);
			comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().setBusinessType1(businessType1);
			comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().setBusinessFlag(businessFlag);
			comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().setOtherFlag(otherFlag);
			// end by wunier 20080107
			// add by fenglei 20080722 按照国元现在的理赔流程,在立案保存后回写表PrpLprop的立案号码
			prpLPropDao.updateClaimNoByregistNo(claimNo, registNo);
			// -----------------------------------------------------
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();
			// add by liuyanmei 20051228 start
			if (!(swfLogFlowID == null || swfLogFlowID.equals(""))
					&& !(swfLogLogNo == null || swfLogLogNo.equals(""))) {
				swfLogDtoDealNode.setFlowId(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils
						.nullToZero(swfLogLogNo)));
			}
			// add by liuyanmei 20051228 end

			swfLogDtoDealNode.setNodeType("claim");
			swfLogDtoDealNode.setNodeStatus(comClaimInDto.getPrpLclaimStatusDto()
					.getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setComCode(comCode);
			swfLogTransferDto.setNextBusinessNo(claimNo);
			swfLogDtoDealNode.setKeyIn(claimNo);
			swfLogDtoDealNode.setKeyOut(claimNo);
			swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
			swfLogTransferDto.setUserComName(user.getUserName());
			swfLogTransferDto.setUserUserCode(user.getUserCode());
			swfLogTransferDto.setUserUserName(user.getUserName());
			WorkFlowDto workFlowDto = workFlowService.viewToDto(swfLogTransferDto);

			// ------------------------------------------------------------
			// 保存报案信息

			if ((workFlowDto.isCreate()) || (workFlowDto.isUpdate())
					|| (workFlowDto.isSubmit()) || (workFlowDto.isClose())) {
				saveClaimDto(comClaimInDto);
				workFlowDtoList.add(workFlowDto);
			}
		}

		for (int j = 0; j < workFlowDtoList.size(); j++) {
			workFlowService.deal(workFlowDtoList.get(j));
		}
		// 防止重复刷新
		if("4".equals(comCheckInDtoList.get(0).getPrpLclaimStatusDto().getStatus())){
			mapNew.put("code", "0000");
			mapNew.put("message", "合并立案提交成功!");
			mapNew.put("combineNo", combineNo);

		}else{
			mapNew.put("code", "0000");
			mapNew.put("message", "合并立案暂存成功!");
			mapNew.put("combineNo", combineNo);
		}
		return mapNew;
	}

	/**
     * @descption 合并查勘定损提交转换对象
     * @author liyang
     * @date 2017-12-01
     * @param PrpDuserDto 登录人员信息
     * @param ComCheckInDto 提交查勘定损对象信息
     */
	private ComCheckInDto viewToDto(PrpDuserDto user,ComCheckInDto comCheckInDto)
			throws Exception {

		/*---------------------查勘主表prpLcheck------------------------------------*/

		PrpLCheckDto prpLcheckDto = comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto();
		String registNo = prpLcheckDto.getRegistNo();
		prpLcheckDto.setReferSerialNo(1);
		prpLcheckDto.setInsureCarFlag("");
		prpLcheckDto.setCheckType("L");
		prpLcheckDto.setRepeatInsureFlag("-");
		if(comCheckInDto.getPrpLregistExtDtoList() != null){
			for(int i=0;i<comCheckInDto.getPrpLregistExtDtoList().size();i++){
				comCheckInDto.getPrpLregistExtDtoList().get(i).setRegistNo(registNo);
			}
		}
		if(comCheckInDto.getPrpLCompensates() != null){
			for(int i=0;i<comCheckInDto.getPrpLCompensates().size();i++){
				comCheckInDto.getPrpLCompensates().get(i).setRegistNo(registNo);
			}
		}
		if(comCheckInDto.getPrpLPropDtoList() != null){
			for(int i=0;i<comCheckInDto.getPrpLPropDtoList().size();i++){
				comCheckInDto.getPrpLPropDtoList().get(i).getPrpLPropDto().setRegistNo(registNo);
				comCheckInDto.getPrpLPropDtoList().get(i).getPrpLPropDto().setLossItemCode("-2");
				comCheckInDto.getPrpLPropDtoList().get(i).getPrpLPropDto().setRiskCode(prpLcheckDto.getRiskCode());
			}
		}
		/*if(comCheckInDto.getPrpLregistTextDtos() != null){
			for(int i=0;i<comCheckInDto.getPrpLregistTextDtos().size();i++){
				comCheckInDto.getPrpLregistTextDtos().get(i).setRegistNo(registNo);
			}
		}*/
		String TextTemp = comCheckInDto.getContext();
		// rule字段的长度
		int RULE_LENGTH = 70;
		String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
		ArrayList<PrpLRegistTextDto> prpLregistTextDtoList = new ArrayList<>();
		if(rules!=null){
			for (int k = 0; k < rules.length; k++) {
				PrpLRegistTextDto prpLregistTextDto = new PrpLRegistTextDto();
				prpLregistTextDto.setRegistNo(prpLcheckDto.getRegistNo());
				prpLregistTextDto.setContext(rules[k]);
				prpLregistTextDto.setLineNo(k + 1);
				prpLregistTextDto.setTextType("3");
				prpLregistTextDtoList.add(prpLregistTextDto);
			}
		}
		comCheckInDto.setPrpLregistTextDtos(prpLregistTextDtoList);

		comCheckInDto.getPrpLverifyLossDto().setRegistNo(prpLcheckDto.getRegistNo());
		comCheckInDto.getPrpLverifyLossDto().setPolicyNo(prpLcheckDto.getPolicyNo());
		comCheckInDto.getPrpLverifyLossDto().setRiskCode(prpLcheckDto.getRiskCode());
		comCheckInDto.getPrpLverifyLossDto().setInsuredName(comCheckInDto.getPrpLcheckDtoExt().getInsuredName());
		comCheckInDto.getPrpLverifyLossDto().setMakeCom(user.getComCode());
		comCheckInDto.getPrpLverifyLossDto().setHandlerCode(user.getUserCode());
		comCheckInDto.getPrpLverifyLossDto().setHandlerName(user.getUserEName());
		
		 Map<String,String> map = new HashMap<String, String>();
		 map.put("policyNo", prpLcheckDto.getPolicyNo());
		PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
		comCheckInDto.getPrpLverifyLossDto().setComCode(prpCmainDto.getComCode());
		PrpLclaimStatusDto prpLclaimStatusCheckDto = new PrpLclaimStatusDto();
		prpLclaimStatusCheckDto.setStatus(comCheckInDto.getPrpLclaimStatusDto().getStatus());
		prpLclaimStatusCheckDto.setBusinessno(prpLcheckDto.getRegistNo());
		prpLclaimStatusCheckDto.setPolicyno(prpLcheckDto.getPolicyNo());
		prpLclaimStatusCheckDto.setNodetype("check");
		if (StringUtils.isNotEmpty(comCheckInDto.getPrpLverifyLossDto()
				.getLossItemCode())) {
			prpLclaimStatusCheckDto.setSerialno(Integer.parseInt(DataUtils
					.nullToZero(comCheckInDto.getPrpLverifyLossDto()
							.getLossItemCode())));
		} else {
			prpLclaimStatusCheckDto.setSerialno(0);
		}
		prpLclaimStatusCheckDto.setRiskcode(prpLcheckDto.getRiskCode());
		prpLclaimStatusCheckDto.setHandlercode(user.getUserCode());
		if (StringUtils.isNotEmpty(prpLcheckDto.getCheckDate().toString())) {
			prpLclaimStatusCheckDto.setInputdate(prpLcheckDto.getCheckDate());
		} else {
			prpLclaimStatusCheckDto.setInputdate(new DateTime(new Date(),
					DateTime.YEAR_TO_DAY));
		}
		if (StringUtils.isNotEmpty(comCheckInDto.getPrpLverifyLossDto()
				.getLossItemCode())) {
			prpLclaimStatusCheckDto.setTypeflag(comCheckInDto.getPrpLverifyLossDto()
					.getLossItemCode());
		}
		prpLclaimStatusCheckDto.setOperatedate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		
		comCheckInDto.setPrpLclaimStatusDto(prpLclaimStatusCheckDto);
		return comCheckInDto;
	}

	/**
     * @descption 合并立案提交转换对象
     * @author liyang
     * @date 2017-12-01
     * @param PrpDuserDto 登录人员信息
     * @param ComClaimInDto 提交立案对象信息
     */
	public ComClaimInDto viewToClaimDto(PrpDuserDto user,ComClaimInDto comClaimInDto)
			throws Exception {

		/*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
		PrpLClaimDto prpLClaimDto = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto();
		prpLClaimDto.setLFlag("L");
		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		prpLclaimStatusDto.setStatus(comClaimInDto.getPrpLclaimStatusDto().getStatus());
		prpLclaimStatusDto.setBusinessno(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
				.getClaimNo());
		prpLclaimStatusDto.setPolicyno(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
				.getPolicyNo());
		prpLclaimStatusDto.setNodetype("claim");
		prpLclaimStatusDto.setSerialno(0);
		prpLclaimStatusDto.setRiskcode(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
				.getRiskCode());
		// 取得当前用户信息，写操作员信息到实赔中
		prpLclaimStatusDto.setHandlercode(user.getUserCode());
		// prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
		prpLclaimStatusDto.setInputdate(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
				.getInputDate());
		prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		comClaimInDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		PrpLRegistRPolicyDto prpLRegistRPolicyDto = prpLRegistRPolicyService
				.queryByPK(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getRegistNo(),
						comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getPolicyNo());
		if (prpLRegistRPolicyDto != null) {
			prpLRegistRPolicyDto.setClaimNo(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
					.getClaimNo());
			prpLRegistRPolicyDto.setFlowId(comClaimInDto.getSwfLogFlowID());
		}
		/*for(int i=0;i<comClaimInDto.getPrpLltextDtoList().size();i++){
			comClaimInDto.getPrpLltextDtoList().get(i).setClaimNo(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
					.getClaimNo());
			comClaimInDto.getPrpLltextDtoList().get(i).setTextType("09");
			comClaimInDto.getPrpLltextDtoList().get(i).setLineNo(i + 1);
		}*/
		String TextTemp = comClaimInDto.getContext();
		int RULE_LENGTH = 70;
		List<PrpLLTextDto>    prpLltextDtoList=  new ArrayList<PrpLLTextDto>();
		String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
		for (int k = 0; k < rules.length; k++) {
			PrpLLTextDto prpLltextDto = new PrpLLTextDto();
			prpLltextDto.setClaimNo(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
					.getClaimNo());
			prpLltextDto.setContext(rules[k]);
			prpLltextDto.setLineNo(k + 1);
			prpLltextDto.setTextType("09");
			prpLltextDtoList.add(prpLltextDto);
			comClaimInDto.setPrpLltextDtoList(prpLltextDtoList);
		}
		for(int i=0;i<comClaimInDto.getPrpLclaimLossDtoList().size();i++){
			comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto().setClaimNo(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto()
					.getClaimNo());
			comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto().setRiskCode(prpLClaimDto.getRiskCode());
			comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto().setSerialNo(i + 1);
			//comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto().setCurrency(prpLClaimDto.getCurrency());
			//comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto().setSumClaim(prpLClaimDto.getSumAmount());
		}
		comClaimInDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
		return comClaimInDto;

	}

	/**
     * @descption 查勘定损对象保存
     * @author liyang
     * @date 2017-12-01
     * @param ComCheckInDto 提交查勘定损对象信息
     */
	private void saveCheckDto(ComCheckInDto comCheckInDto) {
		String checkNo = "";
		checkNo = comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto().getRegistNo();

		// 查勘则删除以下子表(非意健险中一般都是查勘)
		prpLCompensateEarDao.deleteByRegistNoAndNodeType(checkNo, "check");
		prpLRegistExtDao.deleteByRegistNo(checkNo);
		prpLRegistTextDao.deleteByRegistNoAndType(checkNo);
		prpLCheckExtDao.deleteByRegistNo(checkNo);
		prpLCheckLossDao.deleteByRegistNo(checkNo);
		prpLCheckDao.deleteByRegistNo(checkNo);
		prpLextDao.deleteByCertiNo(checkNo);
		prpLScheduleItemDao.deleteByRegistNo(checkNo);
		// 报案号码 关键字
		PrpLverifyLossDto prpLverifyLossDto = comCheckInDto
				.getPrpLverifyLossDto();
		String registNo = prpLverifyLossDto.getRegistNo();
		String lossItemCode = prpLverifyLossDto.getLossItemCode();
		prpLverifyLossExtDao
				.deleteByRegistNoAndLossCode(registNo, lossItemCode);
		prpLRegistExtDao.deleteByRegistNo(registNo);
		prpLCompensateEarDao.deleteByRegistNoAndNodeType(registNo, "certa");
		prpLPropDao.deleteByRegistNo(registNo);
		prpLverifyLossDao.deleteByRegistNo(registNo, lossItemCode);
		if (lossItemCode == "" || lossItemCode == null) {
			lossItemCode = "-2";
		}
		prpLverifyLossDto.setLossItemCode(lossItemCode);
		prpLCheckService.save(comCheckInDto.getPrpLcheckDtoExt().getPrpLCheckDto());
		prpLverifyLossService.save(comCheckInDto.getPrpLverifyLossDto());
		//保存查勘定损报告
		if (comCheckInDto.getPrpLregistTextDtos() != null) {
			for (int i = 0; i < comCheckInDto.getPrpLregistTextDtos().size(); i++) {
				prpLRegistTextService.save((PrpLRegistTextDto) comCheckInDto
						.getPrpLregistTextDtos().get(i));
			}
		}

		if (comCheckInDto.getPrpLregistExtDtoList() != null) {
			for (int i = 0; i < comCheckInDto.getPrpLregistExtDtoList().size(); i++) {
				prpLRegistExtService.save((PrpLRegistExtDto) comCheckInDto
						.getPrpLregistExtDtoList().get(i));
			}
		}
		

		// 财产核定损明细清单表
		if (comCheckInDto.getPrpLPropDtoList() != null) {
			for (int i = 0; i < comCheckInDto.getPrpLPropDtoList().size(); i++) {
				prpLPropService.save((PrpLPropDto) comCheckInDto
						.getPrpLPropDtoList().get(i).getPrpLPropDto());
			}
		}
		// 耳标号损失清单表保存
		if (comCheckInDto.getPrpLCompensates() != null
				&& comCheckInDto.getPrpLCompensates().size() > 0) {
			for (int i = 0; i < comCheckInDto.getPrpLCompensates()
					.size(); i++) {
				prpLCompensateEarService
						.save(comCheckInDto
								.getPrpLCompensates().get(i));
			}
		}
		prpLclaimStatusDao.deleteByBusinessNo(checkNo);
		prpLclaimStatusDao.deleteByBusiNoNodeTypeSer(registNo, "certa",Integer.parseInt(DataUtils
				.nullToZero(comCheckInDto.getPrpLverifyLossDto()
						.getLossItemCode())));
		prpLclaimStatusService.save(comCheckInDto.getPrpLclaimStatusDto());

	}
	
	/**
     * @descption 立案提交对象保存
     * @author liyang
     * @date 2017-12-01
     * @param ComClaimInDto 提交立案对象信息
     */
	private void saveClaimDto(ComClaimInDto comClaimInDto) throws Exception{
		String strCaseType = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getCaseType();
		if ("1".equals(strCaseType) || "0".equals(strCaseType)) {
			this.saveCancel(comClaimInDto);
		} else {// 如果是新增加或者修改那么用insert
			this.insert(comClaimInDto);
		}
	
	}

	/**
     * @descption 立案提交对象保存
     * @author liyang
     * @date 2017-12-01
     * @param ComClaimInDto 提交立案对象信息
     */
	private void saveCancel(ComClaimInDto comClaimInDto) throws Exception {
		if (comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto() == null) {
			throw new Exception();
		}

		String claimNo = "";
		// 1，更改prplclaim表的caseType的位置的值,进行状态的改变
		PrpLClaimDto prpLClaimDto = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto();
		prpLClaimService.remove(prpLClaimDto.getClaimNo());
		prpLClaimService.save(prpLClaimDto);
		if ("3220".equals(prpLClaimDto.getRiskCode())
				|| "3202".equals(prpLClaimDto.getRiskCode())
				|| "3223".equals(prpLClaimDto.getRiskCode())
				|| "3225".equals(prpLClaimDto.getRiskCode())
				|| "3233".equals(prpLClaimDto.getRiskCode())) {
			if (prpLClaimDto.getCancelDate() != null
					&& StringUtils.isNotEmpty(prpLClaimDto.getCancelDate()
							.toString())) {
				prpLEarDao.updateValidStatusByRegistNo(prpLClaimDto.getRegistNo());
			}
		}
		// Settlemainlist 表引自TXNlist
		/*
		 * if((
		 * "3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3186,3149,3150,3148,3174,3151,3152,3153,3154,3155,3156,3228,3190,3191,3132,3172,3194,3193,3187,3178,3176,3177"
		 * .indexOf(claimDto.getPrpLClaimDto().getRiskCode()) > -1)){ String
		 * settlelistcode=""; BLSettlemainlistFacade blSettlemainlistFacade=new
		 * BLSettlemainlistFacade(); String
		 * str=" Registercode='"+claimDto.getPrpLClaimDto().getClaimNo()+"'";
		 * ArrayList
		 * arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 * SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 * if(arr.size()>0){ settlemainlistDto=(SettlemainlistDto)arr.get(0);
		 * settlelistcode=settlemainlistDto.getSettlelistcode(); String
		 * condition
		 * ="update plantingSettlelist set validity='4' where Settlelistcode='"
		 * +settlelistcode+"' and validity='1'"; String
		 * condition1="update settlemainlist set validity='4' where Registercode='"
		 * +claimDto.getPrpLClaimDto().getClaimNo()+"' and validity='2'";
		 * DBManager dbManager1 = new DBManager(); try{
		 * dbManager1.open("NXDADataSource");
		 * dbManager1.executeUpdate(condition);
		 * dbManager1.executeUpdate(condition1); }catch(Exception exception){
		 * throw exception; }finally{ dbManager1.close(); } } } //yx
		 * //if("3224".equals(claimDto.getPrpLClaimDto().getRiskCode())) if(
		 * "3224,3201,3204,3232,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196"
		 * .indexOf(claimDto.getPrpLClaimDto().getRiskCode()) > -1) { String
		 * settlelistcode=""; BLSettlemainlistFacade blSettlemainlistFacade=new
		 * BLSettlemainlistFacade(); String
		 * str=" Registercode='"+claimDto.getPrpLClaimDto().getClaimNo()+"'";
		 * ArrayList
		 * arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 * SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 * if(arr.size()>0){ settlemainlistDto=(SettlemainlistDto)arr.get(0);
		 * settlelistcode=settlemainlistDto.getSettlelistcode(); String
		 * condition
		 * ="update nyxSettlelist set validity='4' where Settlelistcode='"
		 * +settlelistcode+"' and validity='1'"; String
		 * condition1="update settlemainlist set validity='4' where Registercode='"
		 * +claimDto.getPrpLClaimDto().getClaimNo()+"' and validity='2'";
		 * DBManager dbManager1 = new DBManager(); try{
		 * dbManager1.open("NXDADataSource");
		 * dbManager1.executeUpdate(condition);
		 * dbManager1.executeUpdate(condition1); }catch(Exception exception){
		 * throw exception; }finally{ dbManager1.close(); } } } //险种代码未确定
		 * //String planting31FarmerListFlag =
		 * SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim"); //
		 * if(null != planting31FarmerListFlag &&
		 * (planting31FarmerListFlag.indexOf
		 * (claimDto.getPrpLClaimDto().getRiskCode()) > -1)){ String
		 * settlelistcode=""; BLSettlemainlistFacade blSettlemainlistFacade=new
		 * BLSettlemainlistFacade(); String
		 * str=" Registercode='"+claimDto.getPrpLClaimDto().getClaimNo()+"'";
		 * ArrayList
		 * arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 * SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 * if(arr.size()>0){ settlemainlistDto=(SettlemainlistDto)arr.get(0);
		 * settlelistcode=settlemainlistDto.getSettlelistcode(); String
		 * condition
		 * ="update planting31Settlelist set validity='4' where Settlelistcode='"
		 * +settlelistcode+"' and validity='1'"; String
		 * condition1="update settlemainlist set validity='4' where Registercode='"
		 * +claimDto.getPrpLClaimDto().getClaimNo()+"' and validity='2'";
		 * DBManager dbManager1 = new DBManager(); try{
		 * dbManager1.open("NXDADataSource");
		 * dbManager1.executeUpdate(condition);
		 * dbManager1.executeUpdate(condition1); }catch(Exception exception){
		 * throw exception; }finally{ dbManager1.close(); } } // }
		 */
		// 2,增加拒赔和注销赔案的原因
		if (comClaimInDto.getPrpLltextDtoList() != null) {
			prpLltextDao.deleteByClaimNoAndTextType(prpLClaimDto.getClaimNo(), "10");
			for (int i = 0; i < comClaimInDto.getPrpLltextDtoList().size(); i++) {
				prpLLTextService.save(comClaimInDto.getPrpLltextDtoList()
						.get(i));
			}
		}

		// 3,更新立案操作状态为已提交

		if (comClaimInDto.getPrpLclaimStatusDto() != null) {
			prpLclaimStatusDao.deleteByBusinessNoAndNodeType(comClaimInDto
					.getPrpLclaimStatusDto().getBusinessno(), "claim");
			prpLclaimStatusService.save(comClaimInDto.getPrpLclaimStatusDto());
		}

		// add by lixiang at 20060623 start for 强三----start
		if (comClaimInDto.getPrpLRegistRPolicyDto() != null) {
			prpLRegistRPolicyService.remove(comClaimInDto
					.getPrpLRegistRPolicyDto().getRegistNo(), comClaimInDto
					.getPrpLRegistRPolicyDto().getPolicyNo());
			prpLRegistRPolicyService.save(comClaimInDto
					.getPrpLRegistRPolicyDto());
		}
	}

	public void insert(ComClaimInDto comClaimInDto) throws Exception {
		if (comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto() == null) {
			throw new Exception();
		}
		String claimNo = "";
		String registNo = "";
		String policyNo = "";

		claimNo = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getClaimNo();
		registNo = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getRegistNo();
		policyNo = comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto().getPolicyNo();

		if (comClaimInDto.getPrpLltextDtoList() != null &&comClaimInDto.getPrpLltextDtoList().size()>0
				&&"10".equals(((PrpLLTextDto) comClaimInDto.getPrpLltextDtoList().get(0))
						.getTextType())) {
			saveCancel(comClaimInDto);
			return;
		}
		// 首先删除原来的相关数据

		prpLCompensateEarDao.deleteByClaimNo(claimNo);
		prpLLTextDao.deleteByClaimNo(claimNo);
		prpLDocDao.deleteByClaimNo(claimNo);
		prpLClaimFeeDao.deleteByClaimNo(claimNo);
		prpLClaimLossDao.deleteByClaimNo(claimNo);
		prpLRegistExtDao.deleteByRegistNo(registNo);
		prpLClaimDao.deleteByClaimNo(claimNo);
		prpLextDao.deleteByCertiNo(claimNo);

		PrpLClaim prpLClaim=convert(comClaimInDto.getPrpLClaimDtoExt().getPrpLClaimDto(),PrpLClaim.class);
		prpLClaimDao.saveAndFlush(prpLClaim);


		//耳标号损失清单表保存
		if (comClaimInDto.getPrpLCompensates() != null
				&& comClaimInDto.getPrpLCompensates().size() > 0) {
			for (int i = 0; i < comClaimInDto.getPrpLCompensates()
					.size(); i++) {
				PrpLCompensateEar prpLCompensateEar = convert(comClaimInDto.getPrpLCompensates().get(i), PrpLCompensateEar.class);
				prpLCompensateEarDao.saveAndFlush(prpLCompensateEar);
			}
		}
		
		// add by lym 20060609 for 强三----start
		if (comClaimInDto.getPrpLRegistRPolicyDto() != null) {
			prpLRegistRPolicyService.remove(comClaimInDto
					.getPrpLRegistRPolicyDto().getRegistNo(), comClaimInDto
					.getPrpLRegistRPolicyDto().getPolicyNo());
			prpLRegistRPolicyService.save(comClaimInDto
					.getPrpLRegistRPolicyDto());
		}
		// add by lym 20060609 for 强三----end
		//出险摘要
		if (comClaimInDto.getPrpLltextDtoList() != null||comClaimInDto.getPrpLltextDtoList().size()>0) {
			for (int i = 0; i < comClaimInDto.getPrpLltextDtoList().size(); i++) {
				PrpLLText prpLLText = convert(comClaimInDto.getPrpLltextDtoList().get(i), PrpLLText.class);
				prpLLTextDao.saveAndFlush(prpLLText);
			}
		}
		//估损金额
		if (comClaimInDto.getPrpLclaimLossDtoList() != null) {
			for (int i = 0; i < comClaimInDto.getPrpLclaimLossDtoList().size(); i++) {
				PrpLClaimLoss prpLClaimLoss = convert(comClaimInDto.getPrpLclaimLossDtoList().get(i).getPrpLClaimLossDto(), PrpLClaimLoss.class);
				prpLClaimLossDao.saveAndFlush(prpLClaimLoss);
			}
		}
		// 立案环节增加理赔联系记录，先删后插。 2005-07-18
		if (comClaimInDto.getPrpLRegistExtDtoList() != null) {
			for (int i = 0; i < comClaimInDto.getPrpLRegistExtDtoList().size(); i++) {
				/*prpLRegistExtService.save(comClaimInDto.getPrpLRegistExtDtoList().get(i));*/
				PrpLRegistExt prpLRegistExt = convert(comClaimInDto.getPrpLRegistExtDtoList().get(i), PrpLRegistExt.class);
				prpLRegistExtDao.saveAndFlush(prpLRegistExt);
			}
		}

		// 索赔申请人模块
		if (comClaimInDto.getPrpLAccIPersonDtoList() != null) {
			prpLAccIPersonDao.deleteByCertiNoAndFlag(claimNo, "1");
			for (int i = 0; i < comClaimInDto.getPrpLAccIPersonDtoList().size(); i++) {
				/*prpLAccIPersonService.save(comClaimInDto.getPrpLAccIPersonDtoList().get(i));*/
				PrpLAccIPerson prpLAccIPerson = convert(comClaimInDto.getPrpLAccIPersonDtoList().get(i), PrpLAccIPerson.class);
				prpLAccIPersonDao.saveAndFlush(prpLAccIPerson);
			}
		}
		// add by chenrenda end 20060628
		// 如果为保存立案信息，则修改prpCmain表的claimtimes（理赔次数）字段的值。让它加1。
		/*
		 * if (comClaimInDto.getPrpLclaimStatusDto().getStatus().equals("4")) {
		 * new DBPrpCmain(dbManager).updateClaimTimesAdd1(comClaimInDto.
		 * getPrpLcomClaimInDto().getPolicyNo()); String statement =
		 * " update prpcmain set claimtimes=claimtimes+1" + " Where " +
		 * " PolicyNo = ?";
		 * 
		 * 
		 * }
		 */

		if (comClaimInDto.getPrpLclaimStatusDto() != null) {
			prpLclaimStatusDao.deleteByBusinessNoAndNodeType(comClaimInDto
					.getPrpLclaimStatusDto().getBusinessno(),"claim");
			PrpLclaimStatus prpLclaimStatus = convert(comClaimInDto.getPrpLclaimStatusDto(), PrpLclaimStatus.class);
			prpLclaimStatusDao.saveAndFlush(prpLclaimStatus);
		}

	}
}