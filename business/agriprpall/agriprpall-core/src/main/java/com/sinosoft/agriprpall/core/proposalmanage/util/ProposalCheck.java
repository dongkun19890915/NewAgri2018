package com.sinosoft.agriprpall.core.proposalmanage.util;

import com.sinosoft.agriprpall.api.proposalmanage.PrpDbusinessDataCheckApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomLevelTraceDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDriskConfigApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.pms.api.kernel.PrpDkindAgriApi;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * 投保单保存时数据质量校验类
 * @Author: 何伟东
 * @Date: 2017/10/29 12:14
 */
@Service
public class ProposalCheck extends BaseCustomServiceImpl {
    /**从平台配置系统读取配置信息*/
    @Autowired
    private UtiPlatConfigRuleApi sysConfig;
    @Autowired
    private PrpDkindAgriApi prpDkindAgriApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDriskConfigApi prpDriskConfigApi;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi;
    @Autowired
    private PrpDbusinessDataCheckApi prpDbusinessDataCheckApi;

    /**
     * 投保单数据质量校验检查
     * @author: 何伟东
     * @date: 2017/10/28 10:19
     * @param proposalSaveDto 投保单数据大对象
     * @throws BusinessException
     */
    public void checkData(ProposalSaveDto proposalSaveDto) throws Exception{
        try {
            // 投保单号
            String proposalNo = proposalSaveDto.getPrpTmainDto().getProposalNo();
            // 起保日期
            Date startDate = proposalSaveDto.getPrpTmainDto().getStartDate();
            // 政策性商业性标志
            String businessType1 = proposalSaveDto.getPrpTmainDto().getBusinessType1();
            // 投保日期
            Date operateDate = proposalSaveDto.getPrpTmainDto().getOperateDate();
            if (this.checkCmainAndItemKindPremium(proposalSaveDto)) {
                throw new DataVerifyException("投保单" + proposalNo + "总保费与各险别保费之和不一致！");
            }
            if (this.checkCmainAndItemKindAmount(proposalSaveDto)) {
                throw new DataVerifyException("投保单" + proposalNo + "总保额与各险别保额之和不一致！");
            }
            if (!this.checkCommissionInfo(proposalSaveDto)) {
                throw new DataVerifyException("投保单" + proposalNo + "是代理业务，但是其手续费比例为0！");
            }
//            if (this.checkAgriIsDaoQian(startDate,businessType1)){
//                throw new DataVerifyException("政策性农险起保日期早于核保日期的保单不允许保存！");
//            }
            if (!this.checkOperateDate(operateDate)) {
                throw new DataVerifyException("投保日期必须小于等于当前日期！");
            }
            if (!this.checkPlanFee(proposalSaveDto)) {
                throw new DataVerifyException("投保单没有缴费计划！");
            }
            if(!this.checkPlanFeeIsEqualTMain(proposalSaveDto)){
                throw new DataVerifyException("投保单缴费计划中应缴金额与投保单的保费金额不一致！");
            }
            if(!this.checkProposalNo(proposalNo)){
                throw new DataVerifyException("投保单号第一位不为1！");
            }
            // 从共保跳过此校验
//            if ("2".equals(proposalSaveDto.getPrpTmainDto().getCoinsFlag()) && !this.checkIsLastRiskLevel(proposalSaveDto)) {
//                throw new DataVerifyException("投保单客户风险等级不是最新等级！");
//            }
        }catch (DataVerifyException e) {
            // 将错误数据插入表中记录
            this.insertErrorData("Proposal", "投保单保存校验", e.getMessage());
            throw e;
        }
    }

    /**
     * 校验prtmain与prptitemkind中的保费总分一致，允许一分钱误差
     * @author: 何伟东
     * @date: 2017/10/28 10:33
     * @param proposalSaveDto 投保单大对象
     * @return 总分一致返回true，否则返回false
     */
    private boolean checkCmainAndItemKindPremium(ProposalSaveDto proposalSaveDto){
        // 投保单主信息总保费
        Double sumPremium = proposalSaveDto.getPrpTmainDto().getSumPremium();
        // itemkind汇总保费
        Double itemKindPremium = 0.0;
        List<PrpTitemKindDto> prpTitemKindDtoList = proposalSaveDto.getPrpTitemKindDtoList();
        for (PrpTitemKindDto prpTitemKindDto : prpTitemKindDtoList) {
            itemKindPremium += prpTitemKindDto.getPremium();
        }
        if (Math.abs(sumPremium-itemKindPremium)>0.01){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验prtmain与prptitemkind中的保额总分一致允许一分钱误差
     * @author: 何伟东
     * @date: 2017/10/28 10:56
     * @param proposalSaveDto 投保单大对象
     * @return 总分一致返回true，否则返回false
     */
    private boolean checkCmainAndItemKindAmount(ProposalSaveDto proposalSaveDto){
        // 总保额
        Double sumAmount = proposalSaveDto.getPrpTmainDto().getSumAmount();
        // itemkind保费汇总
        Double itemKindAmount=0.0;
        // 险别保额/限额标志集合
        HashMap<String,String> calculateFlagMap = new HashMap<>();
        String riskCode = proposalSaveDto.getPrpTmainDto().getRiskCode();
        // 根据riskcode查询prpdkind，得到kincode和CalculateFlag().substring(0,1)放到calculateFlagMap
        Map<String,String> param = new HashMap<>();
        param.put("riskCode",riskCode);
        List<PrpDkindAgriDto> prpDkindAgriDtoList = prpDkindAgriApi.queryByRiskCode(param);
        for (PrpDkindAgriDto prpDkindagriDto : prpDkindAgriDtoList) {
            calculateFlagMap.put(prpDkindagriDto.getKindCode(),prpDkindagriDto.getCalculateFlag().substring(0,1));
        }
        List<PrpTitemKindDto> prpTitemKindDtoList = proposalSaveDto.getPrpTitemKindDtoList();
        for (PrpTitemKindDto prpTitemKindDto : prpTitemKindDtoList) {
            // 判断险别是否计算保额
            if("Y".equals(calculateFlagMap.get(prpTitemKindDto.getKindCode()))){
                itemKindAmount += prpTitemKindDto.getAmount();
            }
        }
        if (Math.abs(sumAmount-itemKindAmount)>0.01){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 若是代理业务，则手续费比例不能为空
     * @author: 何伟东
     * @date: 2017/10/28 11:00
     * @param proposalSaveDto 投保单大对象
     * @return 代理业务，手续费比例不为空返回true
     */
    private boolean checkCommissionInfo(ProposalSaveDto proposalSaveDto) throws Exception {
        boolean returnFlag = true;
        PrpTmainDto prpTmainDto = proposalSaveDto.getPrpTmainDto();
        String businessNature = prpTmainDto.getBusinessNature();
        String comCode = prpTmainDto.getComCode();
        String riskCode = prpTmainDto.getRiskCode();
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
        // provComCode = comcode到PrpDcompany表查询DaaPlatformComCode
        String provComCode = prpDcompanyDto.getDaaPlatformComCode();
        boolean ctrolDisRate = true;
        // 根据主键查询PrpDRiskConfig表，如果能查到结果则ctrolDisRate = false;
        PrpDriskConfigDto prpDriskConfigDto = prpDriskConfigApi.queryByPK(provComCode, riskCode, "PRPALL_BUSINESS_RISK");
        if (prpDriskConfigDto != null) {
            ctrolDisRate = false;
        }
        if ("1-2-3-4-5".indexOf(businessNature)>-1 && ctrolDisRate){
            Double disRate = prpTmainDto.getDisRate();
            if (disRate==0){
                returnFlag = false;
            }
        }
        return returnFlag;
    }

    /**
     * 校验政策性农险是否是倒签单
     * @author: 何伟东
     * @date: 2017/10/29 9:59
     * @param startDate 起保日期
     * @param businessType1 政策性商业性标志
     * @return 是政策性倒签单返回true，否则返回false
     */
    public boolean checkAgriIsDaoQian(Date startDate,String businessType1) throws Exception {
        final String  AGRIJIANFEI_SWITCH = sysConfig.getProperty("AGRIJIANFEI_SWITCH");
        boolean returnFlag = false;
        if (AGRIJIANFEI_SWITCH==null || "0".equals(AGRIJIANFEI_SWITCH)) {
            return returnFlag;
        }else if ("1".equals(AGRIJIANFEI_SWITCH)) {
            Date date = new Date();
            if (date.after(startDate) && !"00".equals(businessType1) && !"".equals(businessType1)) {
                returnFlag = true;//此保单为政策性倒签单
            }
        }
        return returnFlag;
    }

    /**
     * 校验投保日期是否小于等于当前日期
     * @author: 何伟东
     * @date: 2017/10/29 10:42
     * @param operateDate 投保日期
     * @return 如果投保日期小于等于当前日期返回true，否则返回false
     */
    public boolean checkOperateDate(Date operateDate){
        boolean returnFlag = false;
        // 当前日期
        Date date = new Date();
        if (!operateDate.after(date)) {
            returnFlag = true;
        }
        return returnFlag;
    }

    /**
     * 效验投保单缴费计划是否为空
     * @author: 何伟东
     * @date: 2017/10/29 11:03
     * @param proposalSaveDto 投保单大对象
     * @return 投保单缴费计划不为空返回true
     */
    public boolean checkPlanFee(ProposalSaveDto proposalSaveDto){
        List<PrpTplanDto> prpTplanDtoList = proposalSaveDto.getPrpTplanDtoList();
        if(prpTplanDtoList == null || prpTplanDtoList.size()<1){
            return false;
        }
        return true;
    }

    /**
     * 效验投保单缴费计划中缴费金额是否与投保单的总保费一致
     * @author: 何伟东
     * @date: 2017/10/29 11:17
     * @param proposalSaveDto 投保单大对象
     * @return 投保单缴费计划中缴费金额与投保单的总保费一致返回true
     */
    public boolean checkPlanFeeIsEqualTMain(ProposalSaveDto proposalSaveDto) {
        PrpTmainDto prpTmainDto = proposalSaveDto.getPrpTmainDto();
        List<PrpTplanDto> prpTplanDtoList = proposalSaveDto.getPrpTplanDtoList();
        BigDecimal bigDecimal = new BigDecimal("0");
//        BigDecimal planFee = new BigDecimal("0");
        Double planFee = 0D;
        Double sumPremium = Str.round(prpTmainDto.getSumPremium(),2);
//        BigDecimal sumPremium = new BigDecimal(prpTmainDto.getSumPremium());
        for (PrpTplanDto prpTplanDto : prpTplanDtoList) {
            if (prpTplanDto.getPlanFee()!=null && !"".equals(prpTplanDto.getPlanFee())) {
//                planFee = planFee.add(new BigDecimal(prpTplanDto.getPlanFee().toString()));
                planFee = Str.round(planFee+Str.round(prpTplanDto.getPlanFee(),2),2);
            }
        }
        if (sumPremium.compareTo(planFee)!=0) {
            return false;
        }
        return true;
    }

    /**
     * 效验投保单第一位不为1的情况
     * @author: 何伟东
     * @date: 2017/10/29 11:23
     * @param proposalNo 投保单号
     * @return 投保单第一位为1返回true
     */
    public boolean checkProposalNo(String proposalNo){
        if (!proposalNo.startsWith("1")){
            return false;
        }
        return true;
    }

    /**
     * 效验投保单客户风险等级不是最新等级
     * @author: 何伟东
     * @date: 2017/10/29 11:58
     * @param proposalSaveDto 投保单大对象
     * @return 是最新等级返回true
     */
    public boolean checkIsLastRiskLevel(ProposalSaveDto proposalSaveDto) {
        List<PrpTinsuredDto> prpTinsuredDtoList = new ArrayList<PrpTinsuredDto>();
        PrpTinsuredDto appliPrpTinsuredDto = this.convert(proposalSaveDto.getAppliInsuredDto(),PrpTinsuredDto.class);
        PrpTinsuredDto insuredPrpTinsuredDto = this.convert(proposalSaveDto.getInsuredDto(),PrpTinsuredDto.class);
        prpTinsuredDtoList.add(appliPrpTinsuredDto);
        prpTinsuredDtoList.add(insuredPrpTinsuredDto);
        String oldRiskLevel = "";
        String newRiskLevel = "";
        for (PrpTinsuredDto prpTinsuredDto : prpTinsuredDtoList) {
            oldRiskLevel = prpTinsuredDto.getRiskLevel();
            if (StringUtils.isEmpty(oldRiskLevel) || "0".equals(oldRiskLevel)) {
                oldRiskLevel = "";
            }
            //newRiskLevel = 用InsuredCode到PrpDcustomLevelTrace表查询newrisklevel字段
            PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = prpDcustomLevelTraceApi.queryByPK(prpTinsuredDto.getInsuredCode(), 1);
            if (prpDcustomLevelTraceDto != null) {
                newRiskLevel = prpDcustomLevelTraceDto.getNewRiskLevel();
            }
            if (StringUtils.isEmpty(newRiskLevel) || "0".equals(newRiskLevel)) {
                newRiskLevel = "";
            }
            if (!oldRiskLevel.equals(newRiskLevel)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 投保单数据质量校验出现错误时，向prpDbusinessDataCheck表插入错误信息
     * @author: 何伟东
     * @date: 2017/10/29 12:05
     * @param title 标题
     * @param remark 说明信息
     * @param stackTrace 错误信息
     */
    public void insertErrorData(String title, String remark, String stackTrace) {
        Date date = new Date();
        PrpDbusinessDataCheckDto prpDbusinessDataCheckDto = new PrpDbusinessDataCheckDto();
        prpDbusinessDataCheckDto.setId(UUID.randomUUID().toString());
        prpDbusinessDataCheckDto.setCheckDate(date);
        prpDbusinessDataCheckDto.setTitle(title);
        prpDbusinessDataCheckDto.setRemark(remark);
        prpDbusinessDataCheckDto.setStackTrace(stackTrace);
        prpDbusinessDataCheckApi.save(prpDbusinessDataCheckDto);
    }
}
