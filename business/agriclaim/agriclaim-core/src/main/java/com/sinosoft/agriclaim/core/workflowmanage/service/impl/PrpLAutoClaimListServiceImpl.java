package com.sinosoft.agriclaim.core.workflowmanage.service.impl;

import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLPropDto;
import com.sinosoft.agriclaim.api.checkmanage.dto.*;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageRequestDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensatePageResponseDto;
import com.sinosoft.agriclaim.api.compensatemanage.dto.CompensateSaveInDto;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLAutoClaimListDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckService;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckService;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimService;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensateService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistTextDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistText;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainWfService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.PrpLAutoClaimListDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrpLAutoClaimList;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrpLAutoClaimListKey;
import com.sinosoft.agriclaim.core.workflowmanage.service.PrpLAutoClaimListService;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.claiminsurancelist.LossRateMainListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxBreedClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxPlantingClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateMainListDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:17:47.442
 * @description 自动理赔清单数据表Core接口实现
 */
@Service
public class PrpLAutoClaimListServiceImpl extends BaseServiceImpl implements PrpLAutoClaimListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLAutoClaimListServiceImpl.class);

    @Autowired
    private PrpLAutoClaimListDao prpLAutoClaimListDao;
    @Autowired
    private PrpLCheckService prpLCheckService;
    @Autowired
    private PrpLScheduleMainWfService prpLScheduleMainWfService;
    @Autowired
    private PrpLRegistTextDao prpLRegistTextDao;
    @Autowired
    private CheckService checkService;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private CompensateService compensateService;
    @Autowired
    private NyxBreedClaimListApi nyxBreedClaimListApi;
    @Autowired
    private LossRateMainListApi lossRateMainListApi;
    @Autowired
    private SwfLogService swfLogService;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLAutoClaimListDto prpLAutoClaimListDto) {
        PrpLAutoClaimList prpLAutoClaimList = this.convert(prpLAutoClaimListDto, PrpLAutoClaimList.class);
        prpLAutoClaimListDao.save(prpLAutoClaimList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String registNo) {
        PrpLAutoClaimListKey prpLAutoClaimListKey = new PrpLAutoClaimListKey(registNo);
        prpLAutoClaimListDao.delete(prpLAutoClaimListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLAutoClaimListDto prpLAutoClaimListDto) {
        PrpLAutoClaimList prpLAutoClaimList = this.convert(prpLAutoClaimListDto, PrpLAutoClaimList.class);
        prpLAutoClaimListDao.save(prpLAutoClaimList);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpLAutoClaimListDto queryByPK(String registNo) {
        PrpLAutoClaimListKey prpLAutoClaimListKey = new PrpLAutoClaimListKey(registNo);
        PrpLAutoClaimList prpLAutoClaimList = prpLAutoClaimListDao.findOne(prpLAutoClaimListKey);
        return this.convert(prpLAutoClaimList,PrpLAutoClaimListDto.class);
    }

    /**
     * 自动理算接口
     * @param swfLogDtoList 待处理自动理算任务案件集合
     * @author 王心洋
     * @time 2018-01-30
     */
    public void autoClaimList(List<SwfLogDto> swfLogDtoList) throws Exception{
        for(SwfLogDto swfLogDto:swfLogDtoList) {
            this.autoClaim(swfLogDto);
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public void autoClaim(SwfLogDto swfLogDto) throws Exception{
        String registNo;//报案号
        String policyNo;//保单号
        String riskCode;//险种
        String nodeType;//状态节点
        String flowId;
        Integer nodeNo;
        String nodeName;
        String lossListCode = "";
        StringBuffer context;//查勘报告
        PrpLAutoClaimListDto prpLAutoClaimListDto;
        List<LossRateMainListDto> lossRateMainListDtoList;
        CheckPageRequestDto checkPageRequestDto;//查勘定损初始化入参
        CheckPageResponseDto checkPageResponseDto;//查勘定损初始化出参
        CheckLossDto checkLossDto;//查勘定损保存入参
        ClaimPageInitReqDto claimPageInitReqDto;//立案页面初始化入参
        ClaimPageInitResDto claimPageInitResDto;//立案页面初始化出参
        ClaimDto1 claimDto;//立案保存入参
        CompensatePageRequestDto compensatePageRequestDto;//理算页面初始化入参
        CompensatePageResponseDto compensatePageResponseDto;//理算页面初始化出参
        CompensateSaveInDto compensateSaveInDto;//理算保存入参
        List<PrpLPropDto> prpLPropDtoList;
        List<PrpLCompensateEarRegistDto> prpLCompensateEarRegistDtoList;
        PrpLCompensateEarRegistDto prpLCompensateEarRegistDto;
        PrpLClaimDtoExt prpLClaimDtoSaveExt;
        List<PrpLClaimLossDto> prpLClaimLossDtoList;
        Map<String,String> claimNo;
        String strClaimNo = "";
        Map<String,String> map = new HashMap<>();
        List<String> claimNoList = new ArrayList<>();

        registNo = swfLogDto.getRegistNo();
        nodeType = swfLogDto.getNodeType();
        policyNo = swfLogDto.getPolicyNo();
        riskCode = swfLogDto.getRiskCode();
        flowId = swfLogDto.getFlowId();
        nodeNo = swfLogDto.getNodeNo();
        nodeName = swfLogDto.getNodeName();
        map.put("policyNo",policyNo);
        map.put("bizNo",registNo);
        lossRateMainListDtoList = lossRateMainListApi.queryByConditions(map);
        if(lossRateMainListDtoList!=null && lossRateMainListDtoList.size()>0) {
            lossListCode = lossRateMainListDtoList.get(0).getLossListCode();
        }
        if("check".equals(nodeType) || "claim".equals(nodeType) || "compe".equals(nodeType)) {
            /** 查勘定損 */
            if ("check".equals(nodeType)) {
                checkPageRequestDto = new CheckPageRequestDto();
                checkPageRequestDto.setRegistNo(registNo);
                checkPageRequestDto.setEditType("ADD");
                checkPageRequestDto.setFlowId(swfLogDto.getFlowId());
                checkPageRequestDto.setLogNo(swfLogDto.getLogNo() + "");
                checkPageRequestDto.setModelNo(swfLogDto.getModelNo() + "");
                checkPageRequestDto.setNodeNo(swfLogDto.getNodeNo() + "");
                checkPageRequestDto.setStatus(swfLogDto.getNodeStatus());
                checkPageResponseDto = checkService.checkPageInit(checkPageRequestDto);
                checkLossDto = new CheckLossDto();
                List<PrpLRegistText> registTextList = prpLRegistTextDao.findAll(Specifications.<PrpLRegistText>and().eq("registNo", registNo)
                        .in("textType", "1", "3").build(), new Sort("lineNo"));
                context = new StringBuffer();
                for (PrpLRegistText prpLRegistText : registTextList) {
                    context.append("  ");
                    context.append(prpLRegistText.getContext());
                    context.append("\t");
                }
                checkLossDto.setContext(context.toString());
                checkLossDto.setFlowId(checkPageResponseDto.getFlowId());
                checkLossDto.setLogNo(checkPageResponseDto.getLogNo());

                Integer referSerialNo = prpLCheckService.queryMaxSerialByRegistNo(registNo) + 1;
                checkPageResponseDto.getPrpLcheckDto().setRegistNo(registNo);
                checkPageResponseDto.getPrpLcheckDto().setRiskCode(swfLogDto.getRiskCode());
                checkPageResponseDto.getPrpLcheckDto().setPolicyNo(swfLogDto.getPolicyNo());
                checkPageResponseDto.getPrpLcheckDto().setReferSerialNo(referSerialNo);//序列号 获取最大序号加一
                PrpLScheduleMainWfDto prpLScheduleMainWfDto = prpLScheduleMainWfService.queryByPK(1, registNo);
                if (prpLScheduleMainWfDto != null) {
                    checkPageResponseDto.getPrpLcheckDto().setCheckType("L");//查勘类型
                }
                checkPageResponseDto.getPrpLcheckDto().setCheckNature("1");//查勘性质：0 随车查勘；1 现场查勘；9 其他查勘
                //checkPageResponseDto.getPrpLcheckDto().setCheckDate();//保存时自动封装
                checkLossDto.setPrpLcheckDto(checkPageResponseDto.getPrpLcheckDto());
                //checkLossDto.setPrpLregistTextDtoList(prpLRegistTextDtoList);//保存时自动封装
                checkPageResponseDto.getPrpLclaimStatusDto().setStatus("4");//操作状态位 2：暫存 4：提交
                checkLossDto.setPrpLclaimStatusDto(checkPageResponseDto.getPrpLclaimStatusDto());
                if(StringUtils.isEmpty(checkPageResponseDto.getPrpLverifyLossDto().getLossItemCode())){
                    checkPageResponseDto.getPrpLverifyLossDto().setLossItemCode("-2");
                }
                checkLossDto.setPrpLverifyLossDto(checkPageResponseDto.getPrpLverifyLossDto());
                prpLPropDtoList = new ArrayList<>();
                if(checkPageResponseDto.getPrpLpropDtoList() != null) {
                    for (PrpLPropDto prpLpropDto : checkPageResponseDto.getPrpLpropDtoList()) {
                        prpLPropDtoList.add(prpLpropDto);
                    }
                }
                checkLossDto.setPrpLpropDtoList(prpLPropDtoList);
                if(checkPageResponseDto.getPrpLCompensateEarDtoList()!=null) {
                    prpLCompensateEarRegistDtoList = new ArrayList<>();
                    for (int i = 0; i < checkPageResponseDto.getPrpLCompensateEarDtoList().size(); i++) {
                        prpLCompensateEarRegistDto = new PrpLCompensateEarRegistDto();
                        prpLCompensateEarRegistDto.setCode(checkPageResponseDto.getPrpLCompensateEarDtoList().get(i).getFCode());// 农户代码
                        prpLCompensateEarRegistDto.setPrpLCompensateEarDto(checkPageResponseDto.getPrpLCompensateEarDtoList().get(i));
                        prpLCompensateEarRegistDtoList.add(prpLCompensateEarRegistDto);
                    }
                    checkLossDto.setPrpLCompensateEarDtoList(prpLCompensateEarRegistDtoList);
                }
                checkService.saveCheckLoss(checkLossDto);
                /** 查勘定损结束后工作流重置为待立案状态 */
                Integer logNo = swfLogService.queryMaxLogNo(flowId);
                swfLogDto = swfLogService.queryByPK(flowId,logNo);
                /*swfLogDto.setLogNo(logNo);//立案节点号
                swfLogDto.setModelNo(2);//只有养殖险才进行自动理赔
                swfLogDto.setNodeNo(4);
                swfLogDto.setNodeStatus("0");*/
            }
            if("check".equals(nodeType) || "claim".equals(nodeType)) {
                claimPageInitReqDto = new ClaimPageInitReqDto();
                claimPageInitReqDto.setRegistNo(registNo);
                claimPageInitReqDto.setEditType("ADD");
                claimPageInitReqDto.setFlowId(swfLogDto.getFlowId());
                claimPageInitReqDto.setLogNo(swfLogDto.getLogNo() + "");
                claimPageInitReqDto.setModelNo(swfLogDto.getModelNo() + "");
                claimPageInitReqDto.setNodeNo(swfLogDto.getNodeNo() + "");
                claimPageInitReqDto.setStatus(swfLogDto.getNodeStatus());
                claimPageInitResDto = claimService.claimPageInit(claimPageInitReqDto);
                //封装立案保存接口入参
                claimDto = new ClaimDto1();
                claimDto.setContext(claimPageInitResDto.getContext());
                claimDto.setFlowId(claimPageInitResDto.getFlowId());
                claimDto.setLogNo(claimPageInitResDto.getLogNo());
                prpLClaimDtoSaveExt = claimPageInitResDto.getPrpLClaimDto();
                prpLClaimDtoSaveExt.setLlflag(claimPageInitResDto.getPrpLClaimDto().getLlflag());
                //prpLClaimDtoSaveExt.setPrpLClaimDto(claimPageInitResDto.getPrpLClaimDto().getPrpLClaimDto());
                claimDto.setPrpLClaimDto(prpLClaimDtoSaveExt);

                prpLClaimLossDtoList = new ArrayList<>();
                for (PrpLClaimLossDto prpLClaimLossDto : claimPageInitResDto.getPrpLclaimLossDtoList()) {
                    prpLClaimLossDtoList.add(prpLClaimLossDto);
                }
                claimDto.setPrpLclaimLossDtoList(prpLClaimLossDtoList);
                claimDto.setPrpLclaimStatusDto(claimPageInitResDto.getPrpLclaimStatusDto());
                claimDto.setPrpLltextDtoList(claimPageInitResDto.getPrpLLTextDtoList());
                //claimDto.setPrpLRegistRPolicyDto();//立案保存时自动封装
                if (claimPageInitResDto.getPrpLCompensateEarDtoList() != null) {
                    prpLCompensateEarRegistDtoList = new ArrayList<>();
                    for (int i = 0; i < claimPageInitResDto.getPrpLCompensateEarDtoList().size(); i++) {
                        prpLCompensateEarRegistDto = new PrpLCompensateEarRegistDto();
                        prpLCompensateEarRegistDto.setCode(claimPageInitResDto.getPrpLCompensateEarDtoList().get(i).getFCode());// 农户代码
                        prpLCompensateEarRegistDto.setPrpLCompensateEarDto(claimPageInitResDto.getPrpLCompensateEarDtoList().get(i));
                        prpLCompensateEarRegistDtoList.add(prpLCompensateEarRegistDto);
                    }
                    claimDto.setPrpLcompensateeartDtoList(prpLCompensateEarRegistDtoList);
                }
                claimDto.setIfAuto("0");
                claimDto.getPrpLclaimStatusDto().setStatus("4");
                claimNo = claimService.saveClaim(claimDto);
                strClaimNo = claimNo.get("claimNo");
                claimNoList.add(strClaimNo);
                /** 立案结束后工作流重置为待理算状态 */
                Integer logNo = swfLogService.queryMaxLogNo(flowId);
                swfLogDto = swfLogService.queryByPK(flowId,logNo);
                /*swfLogDto.setLogNo(logNo);//理算节点号
                swfLogDto.setModelNo(2);//只有养殖险才进行自动理赔
                swfLogDto.setNodeNo(5);
                swfLogDto.setNodeStatus("0");*/
            }else {
                strClaimNo = swfLogDto.getBusinessNo();
            }
            //添加自动理赔到未核赔
            compensatePageRequestDto = new CompensatePageRequestDto();
            compensatePageRequestDto.setEditType("ADD");
            compensatePageRequestDto.setClaimNo(strClaimNo);
            //compensatePageRequestDto.setCaseType();
            compensatePageRequestDto.setFlowId(swfLogDto.getFlowId());
            compensatePageRequestDto.setLogNo(swfLogDto.getLogNo()+"");
            compensatePageRequestDto.setModelNo(swfLogDto.getModelNo()+"");
            compensatePageRequestDto.setNodeNo(swfLogDto.getNodeNo()+"");
            compensatePageRequestDto.setStatus(swfLogDto.getNodeStatus());
            compensatePageResponseDto = compensateService.compensatePageInit(compensatePageRequestDto);
            //封装理算提交接口入参
            compensateSaveInDto = new CompensateSaveInDto();
            //compensateSaveInDto.setContextPayCalcul(contextPayCalcul);
            compensateSaveInDto.setButtonSaveType("4");
            compensateSaveInDto.setFlowId(swfLogDto.getFlowId());
            compensateSaveInDto.setLogNo(swfLogDto.getLogNo());
            compensateSaveInDto.setPrpLCompensateDtoExt(compensatePageResponseDto.getPrpLCompensateDtoExt());
            compensateSaveInDto.setCoinsFlag(compensatePageResponseDto.getCoinsFlag());
            compensateSaveInDto.setContextReport(compensatePageResponseDto.getContextReport());
            compensateSaveInDto.setContextPayText(compensatePageResponseDto.getContextPayText());
            compensateSaveInDto.setPrpLCompensateEarDtoList(compensatePageResponseDto.getPrpLCompensateEarDtoList());
            compensateSaveInDto.setSettleListCode(compensatePageResponseDto.getSettleListCode());
            compensateSaveInDto.setUserCode(compensatePageResponseDto.getUserCode());
            compensateSaveInDto.setUserName(compensatePageResponseDto.getUserName());
            //compensateSaveInDto.setPrpLChargeDtoExtList(compensatePageResponseDto.getPrpLChargeDtoExtList());
            //compensateSaveInDto.setPrpLcfeecoinsList(compensatePageResponseDto.getprplc);
            /*compensateSaveInDto.setProposerName();
            compensateSaveInDto.setCoinsSerialNo();
            compensateSaveInDto.setCoinsType();
            compensateSaveInDto.setCoinsChiefFlag();
            compensateSaveInDto.setCoinsCode();
            compensateSaveInDto.setCoinsName();
            compensateSaveInDto.setCoinsRate();
            compensateSaveInDto.setCoinsSumpaid();
            compensateSaveInDto.setPrpLctextList();
            compensateSaveInDto.setProposerSerialNo();
            compensateSaveInDto.setProposerIdentifyNumber();
            compensateSaveInDto.setProposerRelation();
            compensateSaveInDto.setProposerPhone();
            compensateSaveInDto.setProposerAddress();
            compensateSaveInDto.setPrpLAccIPersonDtoList();
            compensateSaveInDto.setPrpLagriPersonList(compensatePageResponseDto.getPrpLagriPersonList());//
            compensateSaveInDto.setPrpLClaimDto();
            compensateSaveInDto.setPrpLLossDtoList(compensatePageResponseDto.getPrpLLossDtoList());//
            compensateSaveInDto.setPrpLLTextDtoList();
            compensateSaveInDto.setPrpLAccIPersonDto();*/
            /*compensateSaveInDto.setPrpDlimitDtoList();
            compensateSaveInDto.setPrpLCFeeDtoList(compensatePageResponseDto.getPrpLCFeeDtoList());//
            compensateSaveInDto.setPrpLsumpayDtoList();
            compensateSaveInDto.setSumPrePaid(compensatePageResponseDto.getSumPrePaid());*/
            String compensateNo = compensateService.saveSubmitBySave(compensateSaveInDto).get("compensateNo").toString();
            //保存养殖险理赔清单
            map = new HashMap<>();
            map.put("policyNo",policyNo);
            map.put("registNo",registNo);
            map.put("compensateNo",compensateNo);
            nyxBreedClaimListApi.assembleNyxBreedClaimList(map);

            /** 回写自动理赔表数据 */
            prpLAutoClaimListDto = new PrpLAutoClaimListDto();
            prpLAutoClaimListDto.setPolicyNo(policyNo);
            prpLAutoClaimListDto.setRegistNo(registNo);
            prpLAutoClaimListDto.setClaimNo(strClaimNo);
            prpLAutoClaimListDto.setFlowId(flowId);
            prpLAutoClaimListDto.setNodeNo(nodeNo);
            prpLAutoClaimListDto.setNodeName(nodeName);
            prpLAutoClaimListDto.setBillNo(lossListCode);
            //prpLAutoClaimListDto.setAutoFlag("1");
            prpLAutoClaimListDto.setFinishFlag("1");
            //prpLAutoClaimListDto.setFalseReason("");
            prpLAutoClaimListDto.setRiskCode(riskCode);
            this.save(prpLAutoClaimListDto);
        }
        //return null;
    }
}