package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPtextDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.*;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BLEndorseCheckService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPtextService;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 普通批改数据保存实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
@Transactional
public class GenerateBLEndorseServiceImpl extends BaseServiceImpl implements GenerateBLEndorseService {
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private GenerateTxnListService generateTxnListService;
    @Autowired
    private GeneratePrpItemKindService generatePrpItemKindService;
    @Autowired
    private GeneratePrpMainService generatePrpMainService;
    @Autowired
    private GeneratePEndorseService generatePEndorseService;
    @Autowired
    private GeneratePtextService generatePtextService;
    @Autowired
    private BLEndorseCheckService blEndorseCheckService;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private PrpPtextService prpPtextService;
    @Autowired
    private ProcessApi processApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;

    /**
     *  批改大对象处理
     * @author: 李东东
     * @date: 2017/11/2 15:59
     * @param policyEndorseDto 保单批单大对象封装
     * @throws Exception
     */
    @Override
    public PolicyEndorseDto updateBLEndorse(PolicyEndorseDto policyEndorseDto) throws Exception{
        BLEndorseDto blEndorseDto= policyEndorseDto.getBlEndorseDto();
        ResponseQueryPolicyInfoDto blPolicyDtoOld=policyQueryService.queryPolicyInfoByPolicyNo(blEndorseDto.getPrpPheadDto().getPolicyNo());
        policyEndorseDto.setBlPolicyInfoDtoOld(blPolicyDtoOld);
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto=prpDcustomerTaxPayInfoApi.queryByPK(policyEndorseDto.getBlPolicyInfoDtoNew().getPrpDcustomerTaxPayInfoDto().getCustomerCode());
        blPolicyDtoOld.setPrpDcustomerTaxPayInfoDto(prpDcustomerTaxPayInfoDto);
        //调整PrpCMainDtoNew中信息
        generatePrpMainService.updatePrpCmainNew(policyEndorseDto);
        //调整PrpCitemkindDtoNew信息 更新标的信息 commonship/tbcbpg/UIPrPoEnItemKindI1GenerateObject.jsp
        generatePrpItemKindService.updatePrpCitemKindNew(policyEndorseDto);
        //生成新的批单对象 commonship/pg/UIEndorseGenerateObject.jsp 152行
        generatePEndorseService.generatePNew(policyEndorseDto);
        //调整农险相关表信息 commonship/pg/UIEndorseGenerateObject.jsp
        generateTxnListService.dealTxnList(policyEndorseDto);
        // 生成批文
        generatePtextService.generateUsual(policyEndorseDto);
        return policyEndorseDto;
    }
    /**
    * 批单保存
    * @param policyEndorseDto 保单批单大对象封装Dto
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 17:16 2017/12/5
    */
    @Override
    public Map<String, String> saveEndorse(PolicyEndorseDto policyEndorseDto) throws Exception{
    	Map<String, String> resultMap = new HashMap<String, String>();
        String endorseNo = "";
        try{
            ResponseQueryPolicyInfoDto blPolicyDtoNew= policyEndorseDto.getBlPolicyInfoDtoNew();
            BLEndorseDto blEndorseDto= policyEndorseDto.getBlEndorseDto();

            endorseNo =billNoApi.getNos("prpphead",blEndorseDto.getPrpPheadDto().getPolicyNo());
            blEndorseDto.getPrpPheadDto().setEndorseNo(endorseNo);
            blEndorseDto.getPrpPmainDto().setEndorseNo(endorseNo);
            blEndorseDto.getPrpPmainAgriDto().setEndorseNo(endorseNo);

            /*List<PrpPtextDto> prpPtextDtoList = policyEndorseDto.getBlEndorseDto().getPrpPtextDtoList();
            String context = prpPtextDtoList.get(0).getEndorseText();
            String[] contextSplit = context.split("\r\n");
            List<PrpPtextDto> newPrpPtextDtoList = new ArrayList<>(contextSplit.length);
            for(int lineNo = 0 ; lineNo < contextSplit.length ; lineNo++){
           	 PrpPtextDto prpPtextDto = new PrpPtextDto();
           	 prpPtextDto = convert(prpPtextDtoList.get(0), PrpPtextDto.class) ;
           	 prpPtextDto.setLineNo(lineNo+1);
           	 prpPtextDto.setEndorseText(contextSplit[lineNo]);
                prpPtextDto.setEndorseNo(endorseNo);
           	 newPrpPtextDtoList.add(prpPtextDto);
            }
            policyEndorseDto.getBlEndorseDto().setPrpPtextDtoList(newPrpPtextDtoList);*/
            if (policyEndorseDto.getBlEndorseDto().getEndorseConditionDto() != null) {
                String pText = policyEndorseDto.getBlEndorseDto().getEndorseConditionDto().getStrText();
                if (StringUtils.isNotEmpty(pText)) {
                    List<PrpPtextDto> prpPtextDtoList = prpPtextService.updatePrpPtext(pText);
                    for (PrpPtextDto prpPtextDto : prpPtextDtoList) {
                        prpPtextDto.setEndorseNo(endorseNo);
                        prpPtextDto.setPolicyNo(blEndorseDto.getPrpPheadDto().getPolicyNo());
                    }
                    policyEndorseDto.getBlEndorseDto().setPrpPtextDtoList(prpPtextDtoList);
                }
           }
           policyEndorseDto.setBlEndorseDto(blEndorseDto);
            
            
            
            
//            policyEndorseDto.setBlEndorse(blEndorseDto);
//            List<PrpPtextDto> prpPtextDtoList=prpPtextService.updatePrpPtext(policyEndorseDto.getBlEndorse().getEndorseConditionDto().getStrText());
//            policyEndorseDto.getBlEndorse().setPrpPtextDtoList(prpPtextDtoList);
            
            // 保存前校验
            blEndorseCheckService.checkBeforeSave(policyEndorseDto);
            // 批改次数更新
            generatePEndorseService.updateEndorseTimes(policyEndorseDto);
            // 保存之前的数据整理
            generatePEndorseService.settleBeforeSave(blPolicyDtoNew,blEndorseDto);
            inputEndorseNo(policyEndorseDto);
            // 判断保存农险清单数据
            generateTxnListService.saveNYXList(policyEndorseDto);
            // 保存批改信息
            generatePEndorseService.saveEndorseInfo(policyEndorseDto);

        }catch (Exception e){
            Map<String,String> map=new HashMap<>();
            map.put("tableName","prpphead");
            map.put("billNo",endorseNo);
            billNoApi.putNo(map);
            throw new DataVerifyException("批单保存失败！");
        }
         resultMap.put("endorseNo", endorseNo);
        // 生成批改的数据
       // this.generateNodeData(policyEndorseDto.getBlEndorseDto().getPrpPmainDto());
         return resultMap;
    }

    /**
     * 生成节点数据
     *
     * @param prpPmainDto 投保单主要信息
     * @return
     * @date: 2018/4/9 11:10
     * @author: 何伟东
     */
    private void generateNodeData(PrpPmainDto prpPmainDto) throws Exception {
        UserInfo user = SinoRequestContext.getCurrentContext().getUser();
        ProcessDto addEndorseProcessDto = new ProcessDto.Builder()
                .stepCode(NodeType.ADD_ENDORSE_NODE)
                .stateCode(NodeState.PROCESSED)
                .bizCode(prpPmainDto.getEndorseNo())
                .inflowTime((Date) prpPmainDto.getOperateDate().clone())
                .outflowTime((Date) prpPmainDto.getOperateDate().clone())
                .opCode(user.getUserCode())
                .opName(user.getUserName())
                .opTime((Date) prpPmainDto.getOperateDate().clone())
                .resultCode(NodeResultCode.ENDORSE_SAVE)
                .build();
        // 同时生成提交核批未处理节点
        ProcessDto submitEndorseProcessDto = new ProcessDto.Builder()
                .stepCode(NodeType.SUBMIT_ENDORSE_NODE)
                .stateCode(NodeState.UNPROCESSED)
                .bizCode(prpPmainDto.getEndorseNo())
                .inflowTime((Date) prpPmainDto.getOperateDate().clone())
                .outflowTime((Date) prpPmainDto.getOperateDate().clone())
                .opCode(user.getUserCode())
                .opName(user.getUserName())
                .opTime((Date) prpPmainDto.getOperateDate().clone())
                .resultCode(NodeResultCode.EMPTY)
                .build();
        List<ProcessDto> processDtos = new ArrayList<>(2);
        processDtos.add(addEndorseProcessDto);
        processDtos.add(submitEndorseProcessDto);
        processApi.generateMultipleNodeData(processDtos);
    }

    /**
     * 普通批改数据保存
     * @param policyEndorseDtoList 保单批单大对象集合
     * @return void
     * @throws Exception
     * @author 王心洋
     * @date 2017/12/19
     */
    @Override
    public Map<String, Object> saveEndorseList(List<PolicyEndorseDto> policyEndorseDtoList)throws Exception{
        Map<String, Object> map = new HashMap<>();
        Map<String, String> endorseNoMap = new HashMap<String, String>();
    	List<String> endorseList = new ArrayList<>();
        String batchNo = "";
        if(policyEndorseDtoList.size()>0){
            batchNo = policyEndorseDtoList.get(0).getBlEndorseDto().getPrpPheadDto().getBatchNo();
        }        
    	for(int i=0;i<policyEndorseDtoList.size();i++){
    		endorseNoMap = saveEndorse(policyEndorseDtoList.get(i));
    		String strEndorse = endorseNoMap.get("endorseNo");
            endorseList.add(strEndorse);
        }
    	map.put("endorseList", endorseList);
    	map.put("batchNo", batchNo);
    	return map ;
    }

    public PolicyEndorseDto inputEndorseNo(PolicyEndorseDto policyEndorseDto)throws Exception{
        String endorseNo=policyEndorseDto.getBlEndorseDto().getPrpPheadDto().getEndorseNo();
        if(policyEndorseDto.getBlEndorseDto().getPlantingEndorChgDetailDtoList()!=null
                &&policyEndorseDto.getBlEndorseDto().getPlantingEndorChgDetailDtoList().size()>0){
            for(int i=0;i<policyEndorseDto.getBlEndorseDto().getPlantingEndorChgDetailDtoList().size();i++){
                policyEndorseDto.getBlEndorseDto().getPlantingEndorChgDetailDtoList().get(i).setEndorseNo(endorseNo);
            }
        }
        if(policyEndorseDto.getBlEndorseDto().getPlantingEndorHeadDtoList()!=null
                &&policyEndorseDto.getBlEndorseDto().getPlantingEndorHeadDtoList().size()>0){
            for(int i=0;i<policyEndorseDto.getBlEndorseDto().getPlantingEndorHeadDtoList().size();i++){
                policyEndorseDto.getBlEndorseDto().getPlantingEndorHeadDtoList().get(i).setEndorseNo(endorseNo);
            }
        }
        if(policyEndorseDto.getBlEndorseDto().getPlanting31EndorChgDetailDtoList()!=null
                &&policyEndorseDto.getBlEndorseDto().getPlanting31EndorChgDetailDtoList().size()>0){
            for(int i=0;i<policyEndorseDto.getBlEndorseDto().getPlanting31EndorChgDetailDtoList().size();i++){
                policyEndorseDto.getBlEndorseDto().getPlanting31EndorChgDetailDtoList().get(i).setEndorseNo(endorseNo);
            }
        }
        return policyEndorseDto;
    }
}
