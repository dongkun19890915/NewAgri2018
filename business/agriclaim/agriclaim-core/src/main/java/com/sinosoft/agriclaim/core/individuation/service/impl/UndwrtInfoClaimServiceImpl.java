package com.sinosoft.agriclaim.core.individuation.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.agriclaim.api.compensatemanage.CompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateApi;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.endcasemanage.PrpLCaseNoApi;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import com.sinosoft.agriclaim.api.individuation.dto.UndwrtInfoClaimDto;
import com.sinosoft.agriclaim.api.individuation.dto.UserDto;
import com.sinosoft.agriclaim.api.prepaymanage.PrpLPrepayApi;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.recasemanage.PrpLRecaseApi;
import com.sinosoft.agriclaim.api.recasemanage.dto.PrpLRecaseDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.ReCaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.SwfFlowMainApi;
import com.sinosoft.agriclaim.api.workflowmanage.SwfLogApi;
import com.sinosoft.agriclaim.api.workflowmanage.SwfNodeApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLLTextDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.endcasemanage.dao.PrpLCaseNoDao;
import com.sinosoft.agriclaim.core.endcasemanage.entity.PrpLCaseNo;
import com.sinosoft.agriclaim.core.individuation.entity.EndCaseDto;
import com.sinosoft.agriclaim.core.individuation.service.EndToCaseService;
import com.sinosoft.agriclaim.core.individuation.service.UndwrtInfoClaimService;
import com.sinosoft.agriclaim.core.recasemanage.dao.PrpLRecaseDao;
import com.sinosoft.agriclaim.core.recasemanage.entity.PrpLRecase;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfNotionDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfNotion;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxBreedClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxPlantingClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author jiaoyunzhen
 *
 */
@Service
 public class UndwrtInfoClaimServiceImpl extends BaseServiceImpl implements UndwrtInfoClaimService {
	
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UndwrtInfoClaimServiceImpl.class);
    @Autowired
    private PrpLCaseNoDao prpLCaseNoDao;
    @Autowired
    private PrpLRecaseApi prpLRecaseApi;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;
    @Autowired
    private SwfNotionDao swfNotionDao;
    @Autowired
    private PrpLCompensateApi prpLcompensateApi;
    @Autowired
    private PrpLRecaseDao prpLRecaseDao;
    @Autowired
    private PrpLClaimApi PrpLClaimApi;
    @Autowired
    private PrpLCompensateApi prpLCompensateApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PrpDuserApi  prpDuserApi;
    @Autowired
    private SwfNodeApi swfNodeApi;
    @Autowired
    private PrpLRecaseApi prpRecaseApi;
    @Autowired
    private PrpLLTextDao prpLLTextDao;
    @Autowired
    private PrpLCaseNoApi prpCaseNoApi;
    @Autowired
    private CompensateApi compensateApi;
    @Autowired
    private PrpLClaimApi prpLClaimApi;
    @Autowired
    private SwfLogApi swfLogApi;
    @Autowired
    private SwfFlowMainApi  swfFlowMainApi;
    @Autowired
    private WorkFlowService workFlowService; 
    @Autowired
    private EndToCaseService endCaseService;
    @Autowired
    private PrpLPrepayApi prpLPrepayApi;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private NyxEffectiveAmountApi nyxEffectiveAmountApi;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private NyxPlantingClaimListApi nyxPlantingClaimListApi;
    @Autowired
    private SwfPathLogDao swfPathLogDao;
    @Autowired
    private NyxBreedClaimListApi nyxBreedClaimListApi;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Transactional(rollbackFor = Exception.class)
	public int checkPass(UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception {
        String claimNo="";
		String status="";
		String strFinallyflag="";
		String underwriteCode=undwrtInfoClaimDto.getHandlerCode();
		PrpLClaimDto prpLclaimDto = new PrpLClaimDto();
		PrpDuserDto  prpDuserDto;
		PrpLCompensateDto prpLCompensateDto = new PrpLCompensateDto();
		PrpLPrepayDto prpLPrepayDto;
		
		if("C".equals(undwrtInfoClaimDto.getCertiType())){
    	prpLCompensateDto=prpLCompensateApi.queryByPK(undwrtInfoClaimDto.getBusinessNo());
    	String certiNo = prpLCompensateDto.getCompensateNo(); // 理赔计算书号
    	claimNo = prpLCompensateDto.getClaimNo(); // 立案号
    	status=undwrtInfoClaimDto.getUndwrtWriteFlag();//核赔标志  0初始值/1通过/2不通过/3 无需核赔 9待核赔
    	prpLclaimDto=PrpLClaimApi.queryByPK(claimNo);
    	strFinallyflag=prpLclaimDto.getEndCaseFlag();
    	String caseNo="";
    	//大分支判断，首先的获得原逻辑中的开关进行判断
			  if(!"1".equals(strFinallyflag)){
				  if (status.trim().equals("3"))
				  {
					underwriteCode = prpLCompensateDto.getApproverCode();
				  }
				  if (status.equals("2")){
					prpLCompensateDto.setApproverCode("");
				  }
							
				prpDuserDto = prpDuserApi.queryByPK(underwriteCode);
				prpLCompensateDto.setUnderWriteFlag(status);
				prpLCompensateDto.setUnderwriteCode(underwriteCode);
				prpLCompensateDto.setUnderwritEName(prpDuserDto.getUserName());
				prpLCompensateDto.setUnderWriteEndDate(undwrtInfoClaimDto.getFlowinTime());
				prpLcompensateApi.save(prpLCompensateDto);
				//拒赔的计算书立案表处理
				if (status.equals("3") || status.equals("1")|| status.equals("5"))
				{
					double dbSumPaid = 0d;
					String strClaimNo = prpLCompensateDto.getClaimNo();
					dbSumPaid = prpLclaimDto.getSumPaid();
					dbSumPaid = dbSumPaid+ prpLCompensateDto.getSumDutyPaid();
					prpLclaimDto.setSumPaid(dbSumPaid);
					// 在回写prplclaim表的sumpaid的字段之后回写currency字段
					prpLclaimDto.setCurrency(prpLCompensateDto.getCurrency());
					//todo  prpLclaimDto未保存  prpDuserDto未进行修改为何要保存
					prpDuserApi.save(prpDuserDto);
                  }
				
              }
		}else if("Y".equals(undwrtInfoClaimDto.getCertiType())){
			prpLPrepayDto=prpLPrepayApi.queryByPK(undwrtInfoClaimDto.getBusinessNo());
    		status=undwrtInfoClaimDto.getUndwrtWriteFlag();
    		if (status.trim().equals("3"))
			{
    			underwriteCode = prpLPrepayDto.getApproverCode();
			}
			if (status.trim().equals("2"))
			{
				prpLPrepayDto.setApproverCode("");
			}
    		String certiNo = prpLPrepayDto.getPreCompensateNo(); // 理赔计算书号
        	claimNo = prpLPrepayDto.getClaimNo(); // 立案号
        	//String strFinallyflag = prpLPrepayDto.getFinallyFlag(); //自动结案标志
        	prpDuserDto = prpDuserApi.queryByPK(underwriteCode);
        	prpLPrepayDto.setUnderWriteFlag(status);
        	prpLPrepayDto.setUnderWriteCode(underwriteCode);
        	prpLPrepayDto.setUnderwriteName(prpDuserDto.getUserName());
        	prpLPrepayDto.setUnderWriteendDate(undwrtInfoClaimDto.getFlowinTime());
        	prpLPrepayApi.save(prpLPrepayDto);
        	prpLclaimDto=PrpLClaimApi.queryByPK(claimNo);
        	strFinallyflag=prpLclaimDto.getEndCaseFlag();
		}
//			  }
		//理赔逻辑移植在这
    	//具体这些字段是由双核传过来还是自己查表得出，需要仔细思考   你的思考呢?我也想知道
		String interMethod = "";
		int modelNo = 0;
		String LflowID=undwrtInfoClaimDto.getFlowId();   //双核传过来
		String lLogNo=undwrtInfoClaimDto.getLogNo();			//双核传过来
		String businessNo=undwrtInfoClaimDto.getBusinessNo();	//双核传过来
		String notionInfo=undwrtInfoClaimDto.getNitionInfo();	//双核传过来
		String handlerCode=undwrtInfoClaimDto.getHandlerCode();	//双核传过来
		String businessType=undwrtInfoClaimDto.getCertiType();	
		int nodeNo = Integer.parseInt(undwrtInfoClaimDto.getNodeNo());		//双核传过来,双核结束之后的节点状态
		SwfNodeDto sefNodeDto=swfNodeApi.queryByPK(modelNo, nodeNo);
    	boolean blnResult =false;
		if("1".equals(undwrtInfoClaimDto.getUndwrtWriteFlag())){
			 blnResult =true; 
		}
		// 如果当前节点不是审核通过节点
		//1  是否审核通过依据 调整  zmm
		if (!blnResult) {
			if (nodeNo == 1) {
				//非审核通过节点的核赔节点的退回（退回到计算书）
//				return this.backVericToCompp(LflowID, lLogNo, businessNo, notionInfo,
//	                     handlerCode);
                return vericToCompeBack(LflowID,lLogNo,businessNo,notionInfo,handlerCode);

			} else {
				//非审核通过节点双核流程流转中对理赔中的核赔节点的内容变更
				return this.addInformationOnVeric(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode);
		  }			 
		} else { // 核赔通过节点，不管是自动结案，非自动结案，拒赔计算书都调用理赔的方法refuseClaimAndCloseFlow
			int checkflag;
			if ("1".equals(strFinallyflag)) { // 自动结案
				List<PrpLRecase> prpLRecaseList = prpLRecaseDao.findAll(Specifications.<PrpLRecase>and()
						.eq("claimNo", claimNo)
						.build());
				List<PrpLRecaseDto> prpLRecaseDtoList = new ArrayList<PrpLRecaseDto>();
				this.convertCollection(prpLRecaseList, prpLRecaseDtoList, PrpLRecaseDto.class);
				if(prpLRecaseDtoList.size() == 0){
		                 checkflag= this.passVericAndCloseFlow(undwrtInfoClaimDto, LflowID, lLogNo,
		                        businessNo, notionInfo, handlerCode,status);
		                
				}else{
					 checkflag= this.repassVericAndCloseFlow( undwrtInfoClaimDto,  LflowID,  lLogNo,
            				businessNo,  claimNo,  notionInfo,  handlerCode);//重开赔案自动结案
				}				
			} else { // 手工结案
				if("Y".equals(businessType)){//信达需求添加预赔走单独的通过方法（）
					 checkflag= this.passVericByBusinessTypeY(undwrtInfoClaimDto, LflowID, lLogNo, businessNo,
                            notionInfo, handlerCode,status);
            	}else{
            		 checkflag= this.passVeric(undwrtInfoClaimDto, LflowID, lLogNo, businessNo,
                        notionInfo, handlerCode,status);
            	}
			}
			//修改承保有效保额 入参： 保单号，险种，险别，标的，农户代码，茬次,变化量

            if ("1".equals(status)){
                String substring = undwrtInfoClaimDto.getBusinessNo().substring(1, 5);
                //养殖险
                if("3220".equals(substring)||"3233".equals(substring)){
                    RequestNyxBreedClaimListDto requestNyxBreedClaimListDto = new RequestNyxBreedClaimListDto();
                    requestNyxBreedClaimListDto.setCompensateNo(undwrtInfoClaimDto.getBusinessNo());
                    List<NyxBreedClaimListDto>  nyxBreedClaimListDtoList=
                            nyxBreedClaimListApi.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
                    //判断是大户还是统保户
                    List<String> codeList=new ArrayList<>();
                    for (NyxBreedClaimListDto nyxBreedClaimListDto : nyxBreedClaimListDtoList){
                        if(!codeList.contains(nyxBreedClaimListDto.getfCode())){
                            codeList.add(nyxBreedClaimListDto.getfCode());
                        }
                    }
                    if (nyxBreedClaimListDtoList.size()>0){
                        if(codeList.size()>1){
                            //统保户 农户代码不一 要循环更改
                            for (NyxBreedClaimListDto nyxBreedClaimListDto : nyxBreedClaimListDtoList){
                                RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto = new RequestNyxEffectiveAmountDto();
                                requestNyxEffectiveAmountDto.setJudgeFlag("3");
                                NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
                                nyxEffectiveAmountDto.setPolicyNo(prpLCompensateDto.getPolicyNo());
                                nyxEffectiveAmountDto.setRiskCode(prpLCompensateDto.getRiskCode());
                                nyxEffectiveAmountDto.setKindCode(nyxBreedClaimListDto.getClaimRiskCode());
                                nyxEffectiveAmountDto.setItemCode(nyxBreedClaimListDto.getItemCode());
                                nyxEffectiveAmountDto.setFlag(0);
                                nyxEffectiveAmountDto.setChgAmount(nyxBreedClaimListDto.getPayAmount());
                                nyxEffectiveAmountDto.setfCode(nyxBreedClaimListDto.getfCode());
                                List<NyxEffectiveAmountDto> nyxEffectiveAmountDtos = new ArrayList<>();
                                nyxEffectiveAmountDtos.add(nyxEffectiveAmountDto);
                                requestNyxEffectiveAmountDto.setNyxEffectiveAmountDtoList(nyxEffectiveAmountDtos);
                                nyxEffectiveAmountApi.modifyNyxEffectiveAmount(requestNyxEffectiveAmountDto);
                            }
                        }else{
                            //大户
                            RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto = new RequestNyxEffectiveAmountDto();
                            requestNyxEffectiveAmountDto.setJudgeFlag("3");
                            NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
                            nyxEffectiveAmountDto.setPolicyNo(prpLCompensateDto.getPolicyNo());
                            nyxEffectiveAmountDto.setRiskCode(prpLCompensateDto.getRiskCode());
                            nyxEffectiveAmountDto.setKindCode(nyxBreedClaimListDtoList.get(0).getClaimRiskCode());
                            nyxEffectiveAmountDto.setItemCode(nyxBreedClaimListDtoList.get(0).getItemCode());
                            nyxEffectiveAmountDto.setFlag(0);
                            nyxEffectiveAmountDto.setChgAmount(nyxBreedClaimListDtoList.get(0).getPayAmount());
                            nyxEffectiveAmountDto.setfCode(nyxBreedClaimListDtoList.get(0).getfCode());
                            List<NyxEffectiveAmountDto> nyxEffectiveAmountDtos = new ArrayList<>();
                            nyxEffectiveAmountDtos.add(nyxEffectiveAmountDto);
                            requestNyxEffectiveAmountDto.setNyxEffectiveAmountDtoList(nyxEffectiveAmountDtos);
                            nyxEffectiveAmountApi.modifyNyxEffectiveAmount(requestNyxEffectiveAmountDto);
                        }
                    }
                }else{
                    RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto = new RequestNyxPlantingClaimListDto();
                    requestNyxPlantingClaimListDto.setCompensateNo(undwrtInfoClaimDto.getBusinessNo());
                    List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList =
                            nyxPlantingClaimListApi.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
                    if (nyxPlantingClaimListDtoList.size()>0){
                        for (NyxPlantingClaimListDto nyxPlantingClaimListDto : nyxPlantingClaimListDtoList){
                            RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto = new RequestNyxEffectiveAmountDto();
                            requestNyxEffectiveAmountDto.setJudgeFlag("3");
                            NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
                            nyxEffectiveAmountDto.setPolicyNo(prpLCompensateDto.getPolicyNo());
                            nyxEffectiveAmountDto.setRiskCode(prpLCompensateDto.getRiskCode());
                            nyxEffectiveAmountDto.setChgAmount(nyxPlantingClaimListDto.getSettleAmount());
                            String kindCode = "";
                            int itemKindNo = 0;
                            String policyNo = prpLCompensateDto.getPolicyNo();
                        /*List<PrpCitemKindDto> prpCitemKindDtoList =  prpCitemKindApi.queryItemCodeByPolicyNo(prpLCompensateDto.getPolicyNo());
                        if (prpCitemKindDtoList != null && prpCitemKindDtoList.size()>0){
                            kindCode = prpCitemKindDtoList.get(0).getKindCode();
                            itemKindNo = prpCitemKindDtoList.get(0).getItemKindNo();
                            nyxEffectiveAmountDto.setKindCode(kindCode);
                            nyxEffectiveAmountDto.setItemCode(prpCitemKindDtoList.get(0).getItemCode());
                        }*/
                            Map<String,Object> params=new HashMap<>();
                            params.put("policyNo",policyNo);
                            params.put("kindCode",nyxPlantingClaimListDto.getClaimRiskCode());
                            params.put("itemCode",nyxPlantingClaimListDto.getItemCode());
                            List<PrpCitemKindDto> prpCitemKindDtos1 = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(params);
                            if(prpCitemKindDtos1!=null&&prpCitemKindDtos1.size()>0){
                                itemKindNo = prpCitemKindDtos1.get(0).getItemKindNo();
                            }
                            kindCode=nyxPlantingClaimListDto.getClaimRiskCode();
                            nyxEffectiveAmountDto.setKindCode(nyxPlantingClaimListDto.getClaimRiskCode());
                            nyxEffectiveAmountDto.setItemCode(nyxPlantingClaimListDto.getItemCode());
                            Map<String,Object> map = new HashMap<>();
                            map.put("policyNo",policyNo);
                            map.put("kindCode",kindCode);
                            map.put("itemKindNo",itemKindNo);
                            map.put("registNo",nyxPlantingClaimListDto.getRegistNo());
                            nyxEffectiveAmountDto.setFlag(nyxPlantingClaimListApi.checkStubbleByRegistNo(map));
                            nyxEffectiveAmountDto.setfCode(nyxPlantingClaimListDto.getfCode());
                            List<NyxEffectiveAmountDto> nyxEffectiveAmountDtos = new ArrayList<>();
                            nyxEffectiveAmountDtos.add(nyxEffectiveAmountDto);
                            requestNyxEffectiveAmountDto.setNyxEffectiveAmountDtoList(nyxEffectiveAmountDtos);
                            nyxEffectiveAmountApi.modifyNyxEffectiveAmount(requestNyxEffectiveAmountDto);
                        }
                    }
                }
            }
			return checkflag;
    	}

	}

	/**
	 * 核赔节点的通过（手工结案）
	 * @param undwrtInfoClaimDto
	 * @param lflowID  理赔工作流号码
	 * @param lLogNo  理赔工作流节点号码
	 * @param businessNo  业务号码
	 * @param notionInfo  审批意见 人员名 时间时间
	 * @param handlerCode 操作员
	 * @param status
	 * @author jiaoyunzhen
	 * @throws Exception 
	 */
	private int passVeric(UndwrtInfoClaimDto undwrtInfoClaimDto, String lflowID, String lLogNo, String businessNo,
			String notionInfo, String handlerCode, String status) throws Exception {
           String policyNo="";
           String riskCode="";
        //取赔款计算书号        
        String underWriteFlag = "1";
        String swfLogFlowID = lflowID;            							//工作流号码
        int swfLogLogNo =Integer.parseInt(lLogNo);                //工作流logno
        String keyString = ""; 													//工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        //???判断是不是自动结案(从 appconfig+计算书的最终标志)，如果是做passVericAndCloseFlow();
        //是否需要自动结案，是否是案终赔付
//        if (businessNo.substring(0,1).equals("6") ){
//        	PrpLCompensateDto prpLCompensateDto=prpLcompensateApi.queryByPK(businessNo);
//            policyNo =prpLCompensateDto.getPolicyNo();
//            riskCode =prpLCompensateDto.getRiskCode();
//        }

//        passVericAndCloseFlow(undwrtInfoClaimDto, lflowID, lLogNo, businessNo, notionInfo, handlerCode,status);
      
        SwfLogDto swfLogDto = new SwfLogDto();
        //jiaoyunzhen 检查内容是否合法 例如是不是已经回退过了或者提交了等
        swfLogDto = this.checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getBusinessNo();
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());
        //jiaoyunzhen 整理Dto
        try {
            workProcessService.saveWorkProcess(swfLogDto.getPolicyNo(),swfLogDto.getRegistNo(),swfLogDto.getKeyIn(),null,swfLogDto.getRiskCode().substring(0, 2),swfLogDto.getRiskCode(), "compp","endca", AgriclaimWorkProcessEnum.未结案, SinoRequestContext.getCurrentContext().getUserCode());
        } catch (Exception e) {
            throw new BusinessException("保存到工作流程表失败！！");
        }
        WorkFlowDto workFlowDto = this.getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                businessNo, false);
        if (workFlowDto == null)
            return -5;        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        // jiaoyunzhen 处理整个工作流程(这个是整个工作流处理的基础)
        workFlowService.deal(workFlowDto);

        SwfLog swfLog=swfLogDao.queryEndcaByFlowId(swfLogFlowID);
        if (swfLog!= null){
            swfLog.setClaimNo(swfLogDao.queryByClaim(swfLogFlowID).get(0).getBusinessNo());
            swfLogDao.saveAndFlush(swfLog);
        }
        return checkFlag;
	}
	
	/**
     * 核赔节点的通过（手工结案）预赔单独走
     * 
     * @param lflowID String 理赔工作流号码
     * @param lLogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */
	private int passVericByBusinessTypeY(UndwrtInfoClaimDto undwrtInfoClaimDto, String lflowID, String lLogNo,
			String businessNo, String notionInfo, String handlerCode, String status) throws Exception {
           String policyNo="";
           String riskCode="";
        //取赔款计算书号       
        String underWriteFlag = "1";
        String swfLogFlowID = lflowID; 									//工作流号码
        int swfLogLogNo = Integer.parseInt(lLogNo); 				//工作流logno
        String keyString = ""; 													//工作流keyIn
   
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        //???判断是不是自动结案(从 appconfig+计算书的最终标志)，如果是做passVericAndCloseFlow();
        //String autoEndCaseFlag = AppConfig.get("sysconst.AutoEndCase");
        //是否需要自动结案，是否是案终赔付
        //add 2018年2月28日  jiaoyunzhen 预赔回写增加立案表的回写 begin       
        String caseNo=businessNo.substring(0, 19);
        PrpLPrepayDto prpLPrepayDto=prpLPrepayApi.queryByPK(businessNo);
        String claimNo=prpLPrepayDto.getClaimNo();
        PrpLClaimDto prpLclaimDto = prpLClaimApi.queryByPK(claimNo);

        prpLclaimDto.setCaseNo(caseNo);
        prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current()
      					.toString(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setEndCaserCode(handlerCode);       
        prpLClaimApi.save(prpLclaimDto);
      //add 2018年2月28日  jiaoyunzhen 预赔回写增加立案表的回写 end
        if (businessNo.substring(0,1).equals("6") ){
            PrpLCompensateDto prpLCompensateDto=prpLcompensateApi.queryByPK(businessNo);
            policyNo =prpLCompensateDto.getPolicyNo();
            riskCode =prpLCompensateDto.getRiskCode();
        }else  if (businessNo.substring(0,1).equals("Y") ){}      
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();

        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
       
        //WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();  
        swfLogDtoDealNode.setFlowId(swfLogFlowID);
        swfLogDtoDealNode.setLogNo(swfLogLogNo);
        swfLogDtoDealNode.setNodeStatus("4");
        swfLogDtoDealNode.setBusinessNo(businessNo);//计算书号码/赔付号码等
        swfLogDtoDealNode.setBusinessNo(keyString);
        swfLogDtoDealNode.setKeyIn(keyString);
        swfLogDtoDealNode.setKeyOut(businessNo);       
        swfLogDtoDealNode.setNextNodeListType("1");
        swfLogDtoDealNode.setSwfLogList(new ArrayList());
        WorkFlowDto workFlowDto = new WorkFlowDto();
        SwfLogTransferDto swfLogTransferDto=new SwfLogTransferDto();
        swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
        swfLogTransferDto.setUserComCode(swfLogDto.getHandleDept());
        swfLogTransferDto.setUserComName(swfLogDto.getDeptName());
        swfLogTransferDto.setUserUserCode(handlerCode);
        swfLogTransferDto.setUserUserName("双核通过");
        swfLogTransferDto.setNextBusinessNo(businessNo);
        workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
        workFlowDto.setUpdate(true);
        if (workFlowDto == null)
            return -5;
        //追加意见
        this.AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        if(workFlowDto.getSubmitSwfLogDtoList()!=null && workFlowDto.getSubmitSwfLogDtoList().size()>0) {
            workFlowDto.getSubmitSwfLogDtoList().get(0).setClaimNo(claimNo);
        }
        workFlowService.deal(workFlowDto);
        try {
			workProcessService.saveWorkProcess(swfLogDto.getPolicyNo(),swfLogDto.getRegistNo(),swfLogDto.getKeyIn(),null,swfLogDto.getRiskCode().substring(0, 2),swfLogDto.getRiskCode(), "compp","endca", AgriclaimWorkProcessEnum.未结案, SinoRequestContext.getCurrentContext().getUserCode());
		} catch (Exception e) {
            throw new BusinessException("保存到工作流程表失败！！");
		}
        return checkFlag;
	} 
	
	/**
     * 核赔节点的通过（重开赔案自动结案）
     * 
     * @param lflowID String 理赔工作流号码
     * @param lLogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */
	private int repassVericAndCloseFlow(UndwrtInfoClaimDto undwrtInfoClaimDto, String lflowID, String lLogNo,
			String businessNo, String claimNo, String notionInfo, String handlerCode) throws Exception {
        String underWriteFlag = "1";
        String swfLogFlowID = lflowID; 								//工作流号码
        int swfLogLogNo = Integer.parseInt(lLogNo);			 //工作流logno
        String keyString = ""; 												//工作流keyIn
        UserDto user = new UserDto(); 								//因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");
        SwfLogDto swfLogDto = new SwfLogDto();
        ReCaseDto recaseDto = new ReCaseDto();
        swfLogDto = this.checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
        int checkFlag = swfLogDto.getLogNo();

        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getBusinessNo();
        user.setComCode(swfLogDto.getHandleDept());
        //不确定
        user.setComName(swfLogDto.getDeptName()); 
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", keyString, keyString, keyString,
                businessNo, true);
        if (workFlowDto == null){
            return -5;
        }
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        if (StringUtils.isNotEmpty(claimNo)) {
            workFlowDto.getSubmitSwfLogDtoList().get(0).setClaimNo(claimNo);
        }
        workFlowService.deal(workFlowDto);
        SwfLog swfLog=swfLogDao.queryEndcaByFlowId(swfLogFlowID);
        if (swfLog != null){
            swfLog.setClaimNo(claimNo);
            swfLogDao.saveAndFlush(swfLog);
        }

        //把swfflowmain中所有节点的flowStatus置为"0" 
        SwfFlowMainDto swfFlowMainDto=swfFlowMainApi.queryByPK(swfLogFlowID); 				//将flowstatus置为1  
         SwfFlowMainDto updswfFlowMainDto = new  SwfFlowMainDto();      
         updswfFlowMainDto.setPolicyNo(swfFlowMainDto.getPolicyNo());
         updswfFlowMainDto.setModelNo(swfFlowMainDto.getModelNo()); 
         updswfFlowMainDto.setFlowStatus("0");
         //工作流FlowStatus置0，则同时可转储标志置为1
         updswfFlowMainDto.setStoreFlag("1");
         updswfFlowMainDto.setFlowName(swfFlowMainDto.getFlowName());
         updswfFlowMainDto.setFlowId(swfLogFlowID);
         updswfFlowMainDto.setFlag(swfFlowMainDto.getFlag());
         updswfFlowMainDto.setCreatDate(swfFlowMainDto.getCreatDate());
         updswfFlowMainDto.setCloseDate(DateTime.current());
         swfFlowMainApi.save(updswfFlowMainDto);
         PrpLCompensateDto prpLCompensateDto=new PrpLCompensateDto();
         prpLCompensateDto.setCompensateNo(businessNo);
         List<PrpLCompensateDto> arraylist =compensateApi.queryPrpLCompensateByCondition(prpLCompensateDto);
         PrpLClaimDto prpLCaimDto=prpLClaimApi.queryByPK(claimNo);
         String caseNo = prpLCaimDto.getCaseNo();
        try {
            workProcessService.saveWorkProcess(swfLogDto.getPolicyNo(),swfLogDto.getRegistNo(),swfLogDto.getKeyIn(),caseNo,swfLogDto.getRiskCode().substring(0, 2),swfLogDto.getRiskCode(), "compp","endca", AgriclaimWorkProcessEnum.已结案, SinoRequestContext.getCurrentContext().getUserCode());
        } catch (Exception e) {
            throw new BusinessException("保存到工作流程表失败！！");
        }
         //通过prplclaim对象，获取赔案号。重开以前就已经生成了。
         DateTime underwriteDate = new DateTime(DateTime.current().toString().substring(0, 10)); //核赔通过时间
         if (arraylist != null) {
             for (int i = 0; i < arraylist.size(); i++) {
                 PrpLCaseNoDto prpLcaseNoDto = new PrpLCaseNoDto();
                 PrpLCompensateDto  prpLcompensateDto = (PrpLCompensateDto) arraylist.get(i);
                 prpLcompensateDto.setCaseNo(caseNo);
                 String iWherePart = " usercode = '"+handlerCode+"'";
                PrpDuserDto prpDuserDto=prpDuserApi.queryByPK(handlerCode);
                 prpLcompensateDto.setUnderWriteFlag(underWriteFlag);
                 prpLcompensateDto.setUnderwritEName(prpDuserDto.getUserName());
                 prpLcompensateDto.setUnderWriteEndDate(underwriteDate);
                 //不确定
                 prpLcompensateDto.setUnderwriteCode(handlerCode);
                 prpLcompensateApi.save(prpLcompensateDto);
                 prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
                 prpLcaseNoDto.setCertiType("C");
                 prpLcaseNoDto.setCaseNo(caseNo);
                 prpLcaseNoDto.setFlag("");
                 prpLcaseNoDto.setClaimNo(claimNo.trim());
                 prpCaseNoApi.modify(prpLcaseNoDto);               
             }
         }                
         //回写重开赔案表(目前结案时不判断第几次重开赔案，可配置化在重开赔案开始时实现)
         //jiaoyunzhen 现在结构不一样了，这些代码需要简化，只保留其逻辑
         int maxSerialNo=0;
         if(prpRecaseApi.queryReCaseByClaimNo(claimNo)!=null){
        	 Specification<PrpLRecase> build=Specifications.<PrpLRecase>and().eq("claimNo", claimNo).build();
        	   List<PrpLRecase> otherList=prpLRecaseDao.findAll(build);
             maxSerialNo =  otherList.size();
         }else{maxSerialNo =1;}
         PrpLRecaseDto prpLrecaseDto = prpRecaseApi.queryByPK(claimNo, maxSerialNo);
         DateTime current = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
         prpLrecaseDto.setCloseCaseDate(current);
         prpLrecaseDto.setCloseCaseuserCode(user.getUserCode());
         prpRecaseApi.save(prpLrecaseDto);
        /** *******************自动结案结束******************** */
        return checkFlag;
    
	}
	
	
	   /**
     * 核赔节点的退回
     * 
     * @param LflowID String 理赔工作流号码
     * @param lLogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */
	public int backVericToCompp(String LflowID, String lLogNo, String businessNo, String notionInfo, String handlerCode)
            throws Exception {
        //取赔款计算书号
        String compensateNo = businessNo;
        String swfLogFlowID = LflowID; 								//工作流号码
        int swfLogLogNo = Integer.parseInt(lLogNo); 			//工作流logno
        String keyString = "";												 //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核回退");
        SwfLogDto swfLogDto = new SwfLogDto();
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

        PrpLCompensateDto prpLcompensateDto = prpLcompensateApi.queryByPK(compensateNo);
        //预赔案件在赔款计算书表中没有存值，所以此处跳过
        if(prpLcompensateDto!=null){
        	 String strFinallyflag =prpLcompensateDto.getFinallyFlag();
             String classcodeString =prpLcompensateDto.getClassCode();
        }
        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        keyString = swfLogDto.getKeyIn();//获得立案号码
        user.setComCode(swfLogDto.getHandleDept());
        user.setComName(swfLogDto.getDeptName());

        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
       //jiaoyunzhen 未作处理
        swfLogLogNo=swfLogLogNo-2;
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "5", compensateNo, keyString,
                keyString, compensateNo, false);

        if (workFlowDto == null)
            return -5;
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);

        workFlowService.deal(workFlowDto);

        return checkFlag;
    
	}
	
	
	 /**
     * 双核流程流转中对理赔中的核赔节点的内容变更
     * 
     * @param LflowID String 理赔工作流号码
     * @param lLogNo int 理赔工作流节点号码
     * @param businessNo String 业务号码
     * @param notionInfo String 审批意见 人员名 时间时间
     * @param handlerCode String 操作员
     * @throws Exception
     * @return boolean
     */
	 public int addInformationOnVeric(String LflowID, String lLogNo, String businessNo, String notionInfo,
	            String handlerCode) throws Exception {

	        //取赔款计算书号
	        String swfLogFlowID = LflowID;    					//工作流号码
	        int swfLogLogNo =Integer.parseInt(lLogNo); 	//工作流logno
	        
	        SwfLogDto swfLogDto = new SwfLogDto();
	        //jiaoyunzhen
	        swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

	        int checkFlag = swfLogDto.getLogNo();
	        if (checkFlag < 0)
	            return checkFlag;
	        if (checkFlag == 0)
	            return checkFlag;

	        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
	        WorkFlowDto workFlowDto = new WorkFlowDto();
	        swfLogDto.setNodeStatus("2");
	        swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
	        workFlowDto.setUpdate(true);
	        workFlowDto.setUpdateSwfLogDto(swfLogDto);
	        
	        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
                //jiaoyunzhen  未处理
             try{
                 workFlowService.deal(workFlowDto);
             }catch(Exception e){
                e.printStackTrace();
             }
	        return checkFlag;
	    
	 }
	
	 
	  /**
	     * 核赔节点的通过（重开赔案自动结案）不带submit的
	     * 
	     * @param lflowID String 理赔工作流号码
	     * @param lLogNo int 理赔工作流节点号码
	     * @param businessNo String 业务号码
	     * @param notionInfo String 审批意见 人员名 时间时间
	     * @param handlerCode String 操作员
	     * @throws Exception
	     * @return boolean
	     */

	private int passVericAndCloseFlow(UndwrtInfoClaimDto undwrtInfoClaimDto, String lflowID, String lLogNo,
				String businessNo, String notionInfo, String handlerCode, String status) throws Exception {
    	
        //取赔款计算书号
        String compensateNo = businessNo;
        String underWriteFlag = "1";
        String swfLogFlowID = lflowID; //工作流号码s  //3、需要双核回传；增加字段；
        int swfLogLogNo =Integer.parseInt(lLogNo); //工作流logno //3、需要双核回传；增加字段；
        String keyString = ""; //工作流keyIn
        UserDto user = new UserDto(); //因为不是用户自己操作的，所以目前暂时认为就是计算机做的
        user.setUserCode(handlerCode);
        user.setUserName("双核通过");
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
   
        //先获取理算提交时间
        Specification<SwfLog> build=Specifications.<SwfLog>and().eq("businessNo", businessNo).eq("nodeType", "compp").build();
        List<SwfLog> otherList=swfLogDao.findAll(build);
        List<SwfLogDto> list = new ArrayList<SwfLogDto>();
        this.convertCollection(otherList,list,SwfLogDto.class);
        SwfLogDto swfLogDtoCom =list.get(0);
        String compSubmit =swfLogDtoCom.getSubmitTime();
        System.out.println("==compSubmit 先获取理算提交时间=="+compSubmit);

        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto = this.checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);//核赔的节点
        int checkFlag = swfLogDto.getLogNo();
        System.out.println("****checkFlag="+checkFlag);
        
        if (checkFlag < 0)
            return checkFlag;
          if (checkFlag == 0)
            return checkFlag;
          
        keyString = swfLogDto.getKeyIn();

        user.setComCode(swfLogDto.getHandleDept());
        //不确定 //3、 新建一个userdto ；
        user.setComName(swfLogDto.getDeptName());
        //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了    
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
        //4 暂不处理，等了解 工作流引擎处理方式后 调用服务； zmm
        WorkFlowDto workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo, "4", compensateNo, compensateNo, keyString,
        		keyString, true);
        if (workFlowDto == null){
            return -5;
        }

        //追加意见
        AddNotionToWorkFlowDto(workFlowDto, swfLogFlowID, swfLogLogNo, notionInfo);
        /** *******************自动结案开始******************** */
        //生成陪案号

        String tableName = "prplcaseno";
        // 自动结案  归档号的归属机构不取当前理算处理的处理机构，取其对应保单的归属机构 --begin
        //取compensateNo的归属机构，它和保单号属同一机构
        swfLogApi.queryByPK(lflowID, swfLogLogNo-1);
        String comCode = swfLogDto.getComCode();  //取compensateNo的归属机构，它和保单号属同一机构

        // 自动结案  归档号的归属机构不取当前理算处理的处理机构，取其对应保单的归属机构
        //String riskCode = "28";
        String riskCode = swfLogDto.getRiskCode();
       // String riskCode = prpLRegistApi.queryByPK(swfLogDto.getRegistNo()).getRiskCode();
      
        int year = DateTime.current().getYear();
        // 重开赔案结案后生成的归档号要和原结案后归档号一样，即不同计算书号归属于同一个立案号，其归档号要求一样
        //结案主表       
        
        EndCaseDto endcaseDto = new EndCaseDto();
        
        PrpLCompensateDto prpcompensateDto =prpLcompensateApi.queryByPK(compensateNo);
        
        String claimNo = prpcompensateDto.getClaimNo();
        String conditions = "claimNo ='" + claimNo.trim() + "'";        
        //核赔通过更新理算表核赔时间
        Specification<PrpLCaseNo> build1=Specifications.<PrpLCaseNo>and().eq("certiNo", businessNo.trim()).build();
        List<PrpLCaseNo> otherList1=prpLCaseNoDao.findAll(build1);
        List<PrpLCaseNoDto> list1=new ArrayList<PrpLCaseNoDto>();
        this.convertCollection(otherList1, list1, PrpLCaseNoDto.class);
        int Count =otherList1.size();
        String caseNo = "";     //归档号
        BillNoDto billNoDto=new BillNoDto();
        billNoDto.setTableName(tableName);
        billNoDto.setiComCode(comCode);
        billNoDto.setRiskCode(riskCode);
        billNoDto.setiYear(year+"");
        billNoDto.setUserCode(user.getUserCode());
        if(Count<1)
        {
           //caseNo =billNoCDApi.getBillNoCD(billNoCdDto);   //没有归档号，重新生成归档号
            caseNo = billNoApi.getBillNo(billNoDto).get("billNo");
//        	caseNo=businessNo.substring(0, 19);
        }
        else
        {    
        	//如果有归档号，取第一条归档号
        	list1.get(0);
	       PrpLCaseNoDto prplCaseNoDto  =list1.get(0);
	       caseNo = prplCaseNoDto.getCaseNo();
        }
        // jiaoyunzhen 不明白
  /*      httpServletRequest.getSession().setAttribute("caseNo", caseNo);
        httpServletRequest.getSession().setAttribute(caseNo, "caseNo");  */
        try {
            workProcessService.saveWorkProcess(swfLogDto.getPolicyNo(),swfLogDto.getRegistNo(),swfLogDto.getKeyIn(),caseNo,swfLogDto.getRiskCode().substring(0, 2),swfLogDto.getRiskCode(), "compp","endca", AgriclaimWorkProcessEnum.已结案, SinoRequestContext.getCurrentContext().getUserCode());
        } catch (Exception e) {
            throw new BusinessException("保存到工作流程表失败！！");
        }
        //赔案表集合
        DateTime underwriteDate = new DateTime(new DateTime().current().toString().substring(0, 10));
        ArrayList prpLperpayDtoList = new ArrayList();
        //核赔通过更新理算表核赔时间
        Specification<PrpLCompensate> build2=Specifications.<PrpLCompensate>and().eq("compensateNo", businessNo.trim()).build();
        List<PrpLCompensate> otherList2=prpLCompensateDao.findAll(build2);
        List<PrpLCompensateDto> arraylist=new ArrayList<PrpLCompensateDto>();
        this.convertCollection(otherList2, arraylist, PrpLCompensateDto.class);
    
        //核赔通过更新理算表核赔时间 end
//        BLPrpDuser blPrpDuser = new BLPrpDuser();
        String underwriteCode = "";
        if (arraylist != null) {
            for (int i = 0; i < arraylist.size(); i++) {
                PrpLCaseNoDto prpLcaseNoDto = new PrpLCaseNoDto();
                PrpLCompensateDto prpLcompensateDto = new PrpLCompensateDto();
                prpLcompensateDto = (PrpLCompensateDto) arraylist.get(i);
                prpLcompensateDto.setCaseNo(caseNo);
                if(status.trim().equals("3")){
                	underwriteCode = prpLcompensateDto.getApproverCode();
                }else if(status.trim().equals("2")){
                	prpLcompensateDto.setApproverCode("");
                }else{
                	underwriteCode = handlerCode;
                }
               PrpDuserDto prpDuserDao= prpDuserApi.queryByPK(underwriteCode);
               
                prpLcompensateDto.setUnderWriteFlag(status);
                prpLcompensateDto.setUnderwritEName(prpDuserDao.getUserName());
                prpLcompensateDto.setUnderWriteEndDate(underwriteDate);
                prpLcompensateDto.setUnderwriteCode(underwriteCode);
                prpLcaseNoDto.setCaseNo(caseNo);
                prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
                prpLcaseNoDto.setCertiType("C");
                prpLcaseNoDto.setCaseNo(caseNo);
                prpLcaseNoDto.setFlag("");
                prpLcaseNoDto.setClaimNo(claimNo.trim());
                prpLperpayDtoList.add(prpLcaseNoDto);
            }
        }                
        endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
        endcaseDto.setPrpLcompensateDtoList(arraylist);
   

        Specification<PrpLLText> build3=Specifications.<PrpLLText>and().eq("claimNo", claimNo).build();
        List<PrpLLText> otherList3=prpLLTextDao.findAll(build3);
       List<PrpLLTextDto> list3 = new ArrayList<PrpLLTextDto>();
       this.convertCollection(otherList3, list3, PrpLLTextDto.class);
        //取得结案报告
        ArrayList prpLltextListNew = new ArrayList();
        for (int i = 0; i < list3.size(); i++) {
        	PrpLLTextDto prpLltextDto = (PrpLLTextDto) list3.get(i);        	
        	if (prpLltextDto.getTextType().equals("08")) {
        		prpLltextListNew.add(prpLltextDto);
        	}
        }
        endcaseDto.setPrpLltextDtoList(prpLltextListNew);
        
        PrpLClaimDto prpLclaimDto = prpLClaimApi.queryByPK(claimNo);
        prpLclaimDto.setCaseNo(caseNo);

		if (prpLRecaseApi.queryReCaseByClaimNo(claimNo).getSerialNo()!=0) {

		} else {
            prpLclaimDto.setCaseType("2");
			prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
		}
		//重开赔案的结案时间不回写立案表的结案时间。
        prpLclaimDto.setEndCaserCode(user.getUserCode());
        //实赔核赔通过后回写PrpLclaim表中的SumPaid字段。该步骤原来在保存赔款计算书时做。
        PrpLCompensateDto prpLcompensateDto1=prpLcompensateApi.queryByPK(compensateNo);
      /*  if(status.equals("3") || status.equals("1")){
        	double dbSumPaid = prpLclaimDto.getSumPaid() +prpLcompensateDto1.getSumDutyPaid();
        	prpLclaimDto.setSumPaid(dbSumPaid);
        	prpLclaimDto.setCurrency(prpLcompensateDto1.getCurrency());
        }*/
        endcaseDto.setPrpLclaimDto(prpLclaimDto);
    

        if(caseNo != null){
        	
            PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setStatus("4");            
            prpLclaimStatusDto.setBusinessno(caseNo.trim());
            prpLclaimStatusDto.setPolicyno(prpLclaimDto.getPolicyNo());
            prpLclaimStatusDto.setRiskcode(riskCode);
            prpLclaimStatusDto.setNodetype("endca");
            prpLclaimStatusDto.setSerialno(0);
            //取得当前用户信息，写操作员信息到结案中                        
            prpLclaimStatusDto.setHandlercode(user.getUserCode());
            prpLclaimStatusDto.setInputdate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
            prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
            endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        }
        
        //保存结案信息
        try{
        	endCaseService.save(endcaseDto);
        	
            
        PrpLClaimDto prpLclaimDto1 =  prpLClaimApi.queryByPK(claimNo);
        String riskcode=prpLclaimDto1.getRiskCode();
        String comcode=prpLclaimDto1.getComCode();
        String policytype=prpLclaimDto1.getPolicyType();
      
        DateTime StartDate = new DateTime(prpLclaimDto1.getStartDate());
        int StartHour =prpLclaimDto1.getStartHour();
        DateTime EndDate = new DateTime(prpLclaimDto1.getStartDate());
        int EndHour = prpLclaimDto1.getEndHour();
		
		
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        	return -10;
        }
        
        /** *******************自动结案结束******************** */    
        //reason:自动结案的情况，往swflog表中回写keyout
        ArrayList nodeList = new ArrayList();
        nodeList = (ArrayList) workFlowDto.getSubmitSwfLogDtoList();
        if(nodeList != null && nodeList.size()!=0 ){
        	SwfLogDto swfLogDto1 = (SwfLogDto) nodeList.get(0);
        	swfLogDto1.setKeyOut(caseNo);
        	nodeList.set(0, swfLogDto1);
        	workFlowDto.setSubmitSwfLogDtoList(nodeList);
        }
       //做了工作流程，真正的自动结案是要调用endcaseFacade( workflowDto).
        workFlowDto.setCreate(false);
        //workFlowDto.getUpdateSwfLogDto().setBusinessNo("R111111111111111111");
        if (this.checkSpecCompeUndwrtBack(swfLogFlowID,Integer.parseInt(lLogNo))){
            SwfLog swfLog = swfLogDao.queryEndcaByFlowId(swfLogFlowID);
            swfLog.setNodeStatus("4");
            List<SwfLogDto> swfLogDtoList = new ArrayList<>();
            swfLogDtoList.add(this.convert(swfLog,SwfLogDto.class));
            workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
        }
        if (StringUtils.isNotEmpty(claimNo)) {
            workFlowDto.getSubmitSwfLogDtoList().get(0).setClaimNo(claimNo);
        }
        workFlowDto.getSubmitSwfLogDtoList().get(0).setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
        workFlowService.deal(workFlowDto);
        SwfLog swfLog=swfLogDao.queryEndcaByFlowId(swfLogFlowID);
        if (swfLog != null){
            swfLog.setClaimNo(claimNo);
            swfLog.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
            swfLogDao.saveAndFlush(swfLog);
        }
        Specification<PrpLCompensate> build4=Specifications.<PrpLCompensate>and().eq("claimNo", prpLclaimDto.getClaimNo()).build();
        List<PrpLCompensate> otherList4=prpLCompensateDao.findAll(build4);
        
        Specification<SwfLog> build5=Specifications.<SwfLog>and().eq("flowId", lflowID).eq("nodeType", "endca").ne("nodeStatus","4").build();
        List<SwfLog> otherList5=swfLogDao.findAll(build5);
       List<SwfLogDto> list5 = new ArrayList<SwfLogDto>();
       this.convertCollection(otherList5, list5, SwfLogDto.class);
       
       
        /*if(!prpLclaimDto.getClassCode().equals("05") && otherList4.size() > 1){
        	 if(list5.size() > 0){
             	for (Iterator iter = list5.iterator(); iter.hasNext();) {
					SwfLogDto swfLogDto2 = (SwfLogDto) iter.next();
					swfLogDto2.setNodeStatus("4");
					swfLogDto2.setBusinessNo(businessNo);
					swfLogDto2.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
					swfLogDto2.setHandlerName("自动结案");
					swfLogApi.save(swfLogDto2);
					
				}
             }
        }
       
        //重新将时间更新到已经回写的工作流中
        swfLogDtoCom.setSubmitTime(compSubmit);
        swfLogDtoCom.setFlowStatus("0");  
        swfLogApi.save(swfLogDtoCom);*/
        
        return checkFlag;
    }
		


		/**
		 * @author jiaoyunzhen 核赔下发修改流程
		 */
		@Override
		@Transactional(rollbackFor = Exception.class)
		public void issuedRevise(UndwrtInfoClaimDto undwrtInfoClaimDto) throws Exception {
			
		}
		 /**
	     * 检查增加内容是不是合法
	     * 
	     * @param flowID String
	     * @param logNo int
	     * @param businessNo String
	     * @throws Exception
	     * @return int
	     */
	    private SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception {

	        //检查工作流是否合法。。
	    	SwfLogDto swfLogTemp=swfLogApi.queryByPK(flowID, logNo);
	        SwfLogDto swfLogDto = new SwfLogDto();
	        //没查询到工作流，有错误
	        if (swfLogTemp == null) {
	            swfLogDto.setLogNo(-1);
	            return swfLogDto;
	        }
	        //业务号不是这个工作流上的业务号码，直接返回false
	        if (!swfLogTemp.getBusinessNo().equals(businessNo)) {
	            swfLogDto.setLogNo(-2);
	            return swfLogDto;
	        }
	        //已经回退过了
	        if (swfLogTemp.getNodeStatus().equals("5")) {
	            swfLogDto.setLogNo(-3);
	            return swfLogDto;
	        }
	        //已经提交过了，直接返回ture
	        if (swfLogTemp.getNodeStatus().equals("4")) {
	            swfLogDto.setLogNo(0);
	            return swfLogDto;
	        }
	        swfLogDto = swfLogTemp;
	        //没有问题的
	        return swfLogDto;
	    }
	    
	 
	    /**
	     * 追加批办信息
	     * @param workFlowDto
	     * @param flowID
	     * @param logNo
	     * @param notion
	     * @return
	     * @throws Exception
	     */
	    private WorkFlowDto AddNotionToWorkFlowDto(WorkFlowDto workFlowDto, String flowID, int logNo, String notion)
	            throws Exception {
	    	Specification<SwfNotion> build=Specifications.<SwfNotion>and().eq("flowId", flowID).build();    	
	        List<SwfNotion> otherList=swfNotionDao.findAll(build);
	        int maxLineNo = otherList.size();
	        SwfNotionDto swfNotionDto = new SwfNotionDto();
	        swfNotionDto.setFlowId(flowID);
	        swfNotionDto.setLogNo(logNo);
	        swfNotionDto.setLineNo(maxLineNo);
	        if (notion.length() > 255)
	            notion = notion.substring(0, 250) + "...";
	        swfNotionDto.setHandleText(notion);
	        ArrayList notionList = new ArrayList();
	        notionList.add(swfNotionDto);
	        workFlowDto.setSwfNotionDtoList(notionList);
	        return workFlowDto;
	    }
	    
	    /**
	     * 整理dto
	     * 
	     * @param user UserDto
	     * @param flowID String
	     * @param logNo int
	     * @param nodeStatus String
	     * @param nextBusinessNo String
	     * @param keyIn String
	     * @param keyOut String
	     * @param wclose boolean
	     * @throws Exception
	     * @return WorkFlowDto
	     */
	    private WorkFlowDto getWorkFlowDto(UserDto user, String flowID, int logNo, String nodeStatus, String businessNo,
	            String nextBusinessNo, String keyIn, String keyOut, boolean wclose) throws Exception {
	    	
	    	SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	        SwfLogTransferDto  swfLogTransferDto=new SwfLogTransferDto();
	        swfLogDtoDealNode.setFlowId(flowID);
	        swfLogDtoDealNode.setLogNo(logNo);
	        swfLogDtoDealNode.setNodeStatus(nodeStatus);
	        swfLogDtoDealNode.setBusinessNo(businessNo);//计算书号码/赔付号码等
	        //jiaoyunzhen 无此属性，是否需要添加
	        //swfLogDtoDealNode.setNextBusinessNo(nextBusinessNo);
	        swfLogDtoDealNode.setKeyIn(keyIn);
	        swfLogDtoDealNode.setKeyOut(keyOut);
//	        swfLogDtoDealNode.setRiskCode("2801");
	        swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);

	        swfLogTransferDto.setUserUserCode(user.getUserCode());
	        swfLogTransferDto.setUserUserName(user.getUserName());
	        swfLogTransferDto.setUserComCode(user.getComCode());
	        swfLogTransferDto.setUserComName(user.getComName());
	        swfLogTransferDto.setNextBusinessNo(nextBusinessNo);
	        swfLogTransferDto.setCreateFlow(false);
	        WorkFlowDto workFlowDto = new WorkFlowDto();
	        if (nodeStatus.equals("5")) { //回退
	            //查询工作流状态信息,整理输入，用于初始界面显示
	        	//jiaoyunzhen 元逻辑较多，是否考虑移
	            workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
	        } else {
	            workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
	        }

	        if (wclose) {
	            //关闭操作
	            SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
	            swfFlowMainDto =  swfFlowMainApi.queryByPK(flowID);
	            if (swfFlowMainDto != null) {
	                swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
	                swfFlowMainDto.setFlowStatus("0");
	                //工作流FlowStatus置0，则同时可转储标志置为1
	                swfFlowMainDto.setStoreFlag("1");
	            }
	            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto);
	            workFlowDto.setClose(true);
	            //设置submit中的swflog为都提交
	            if (workFlowDto.isSubmit()) {
	                if (workFlowDto.getSubmitSwfLogDtoList() != null) {
	                    List<SwfLogDto> nodeList = workFlowDto.getSubmitSwfLogDtoList();
	                    ArrayList nodeLastList = new ArrayList();
	                    //设置的提交节点都自动结束的
	                    for (int i = 0; i < nodeList.size(); i++) {
	                        SwfLogDto swfLogDto = (SwfLogDto) nodeList.get(i);
	                        swfLogDto.setBusinessNo(nextBusinessNo);
	                        swfLogDto.setSubmitTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
	                        swfLogDto.setNodeType("endca");
	                      //add by jiaoyunzhen
	    					String claimNo=prpLcompensateApi.queryByPK(nextBusinessNo).getClaimNo();
	    					String endFlag = prpLClaimApi.queryByPK(claimNo).getEndCaseFlag();
	    					LOGGER.error("endFlag=========================================="+endFlag);
	    					if("1".equals(endFlag)){
	    						swfLogDto.setHandlerName("自动结案");
                                swfLogDto.setNodeStatus("4");
	    					}else{
	    						swfLogDto.setHandlerName("手动结案");
                                swfLogDto.setNodeStatus("0");
	    					}
	                        nodeLastList.add(swfLogDto);
	                    }
	                    workFlowDto.setSubmitSwfLogDtoList(nodeLastList);
	                }
	            }

	        }
	        if (!workFlowService.checkDealDto(workFlowDto))
	            return null;
	        return workFlowDto;
	    }

    /**
     * （檢查是否是通過特殊賠案后實賠雙核回寫數據，如果是，這時已經有結案節點，工作流處理會少生生成數據）
     * @author: 王志文
     * @date: 2018/4/30 16:59
     * @param flowId
     * @param logNo
     * @return
     */
    private boolean checkSpecCompeUndwrtBack(String flowId,Integer logNo){
        SwfLog swfLog = swfLogDao.queryEndcaByFlowId(flowId);
        if (swfLog != null){
            Integer resultLogNo = swfLog.getLogNo()-logNo;
            if (resultLogNo<0){
                return true;
            }
        }
        return false;
    }

    // 理算 4  核赔 0
    // 理算 3  核赔 5               退回到理算员
    // 理算 4  核赔 4  new核赔 0    重新提交

    /**
     * （核赔退回方法/下发修改）
     * @author: 王志文
     * @date: 2018/5/15 8:14
     * @param flowId
     * @return
     */
    private int vericToCompeBack(String flowId,String swfLogLogNo,String businessNo,String notionInfo,String handlerCode)throws Exception{
        SwfLogDto swfLogDto;
        //保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
        swfLogDto = checkFlowNode(flowId, Integer.parseInt(swfLogLogNo), businessNo);

        //修改理算表Isvericback字段
         prpLCompensateDao.updateByisVericBack(businessNo);
        //预赔案件在赔款计算书表中没有存值，所以此处跳过
        int checkFlag = swfLogDto.getLogNo();
        if (checkFlag < 0)
            return checkFlag;
        if (checkFlag == 0)
            return checkFlag;
        WorkFlowDto workFlowDto = new WorkFlowDto();
        SwfLogDto swfLogUpdateDto = new SwfLogDto();
        List<SwfLogDto> swfLogDtoSubmitList = new ArrayList<>();
        List<SwfPathLogDto> swfPathLogDtoList = new ArrayList<>();
        Integer compeLogNo = swfLogDao.findMaxLogNoByFlowIdAndNodeType(flowId,"compe");
        SwfLogDto swfLog = swfLogApi.queryByPK(flowId,compeLogNo);
        if (swfLog != null ){
            swfLogUpdateDto = this.convert(swfLog,SwfLogDto.class);
        }
        swfLogUpdateDto.setNodeStatus("3");
        Integer vericLogNo = swfLogDao.findMaxLogNoByFlowIdAndNodeType(flowId,"veric");
        SwfLogDto swfLogVericDto = swfLogApi.queryByPK(flowId,vericLogNo);
        Integer comppLogNo = swfLogDao.findMaxLogNoByFlowIdAndNodeType(flowId,"compp");
        SwfLogDto swfLogComppDto = swfLogApi.queryByPK(flowId,comppLogNo);
        String startNodeName = "";
        int modelNo = 0;
        int startLogNo = 0;
        int endNodeNo = 0;
        if (swfLogVericDto!= null){
            String userName = prpDuserApi.queryByPK(handlerCode).getUserName();
            startLogNo = swfLogVericDto.getLogNo();
            startNodeName = swfLogVericDto.getNodeName();
            swfLogVericDto.setNodeStatus("5");
            swfLogVericDto.setHandlerName(userName);
            swfLogVericDto.setHandlerCode(handlerCode);
            swfLogVericDto.setSubmitTime(simpleDateFormat.format(new Date()));
            swfLogDtoSubmitList.add(swfLogVericDto);
        }
        String endNodeName = "";
        if (swfLogComppDto!= null){
            modelNo = swfLogComppDto.getModelNo();
            endNodeName = swfLogComppDto.getNodeName();
            Integer maxLogNo = swfLogDao.getMaxLogNo(flowId)+1;
            swfLogComppDto.setLogNo(maxLogNo);
            swfLogComppDto.setNodeStatus("2");
            swfLogComppDto.setSubmitTime(null);
            swfLogDtoSubmitList.add(swfLogComppDto);
            endNodeNo = maxLogNo;
        }
        int pathNo = swfPathLogDao.getMaxPathNo(flowId);
        SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
        swfPathLogDto.setFlowId(flowId);
        swfPathLogDto.setPathNo(pathNo+1);
        swfPathLogDto.setModelNo(modelNo);
        swfPathLogDto.setPathName("从 核赔 到 计算书");
        swfPathLogDto.setStartNodeNo(startLogNo);
        swfPathLogDto.setStartNodeName(startNodeName);
        swfPathLogDto.setEndNodeNo(endNodeNo);
        swfPathLogDto.setEndNodeName(endNodeName);
        swfPathLogDtoList.add(swfPathLogDto);
        workFlowDto.setUpdate(true);
        workFlowDto.setSubmit(true);
        workFlowDto.setUpdateSwfLogDto(swfLogUpdateDto);
        workFlowDto.setSubmitSwfLogDtoList(swfLogDtoSubmitList);
        workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
        workFlowService.deal(workFlowDto);
        //追加意见
        AddNotionToWorkFlowDto(workFlowDto,flowId,Integer.parseInt(swfLogLogNo),notionInfo);
        return checkFlag;
    }
}
