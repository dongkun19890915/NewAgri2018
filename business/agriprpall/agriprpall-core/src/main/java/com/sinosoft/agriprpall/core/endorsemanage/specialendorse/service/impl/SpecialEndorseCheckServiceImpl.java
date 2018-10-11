package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.WorkFlowApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.SpecialEndorseCheckDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainOriginDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpJplanFeeDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPheadService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorseCheckService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpJplanFee;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyOriginService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCplanService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.SettleMainListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 允许特殊批改校验
 * @Author: 李冬松
 * @Date: 2018/1/9 18:50
 */
@Service
public class SpecialEndorseCheckServiceImpl extends BaseServiceImpl implements SpecialEndorseCheckService {
    @Autowired
    private PrpCmainService prpCmainService;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private PolicyOriginService policyOriginService;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private SettleMainListApi settleMainListApi;
    @Autowired
    private WorkFlowApi workFlowApi;
    @Autowired
    private PrpCplanService prpCplanService;
    @Autowired
    private PrpPheadService prpPheadService;
    /**
    * 允许特殊批改校验
    * @param specialEndorseCheckDto 允许特殊批改校验入参DTO
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 10:51 2018/1/19
    */
    @Override
    public String specialEndorseCheck(SpecialEndorseCheckDto specialEndorseCheckDto) throws Exception {
        String strPolicyNo = specialEndorseCheckDto.getPolicyNo();

        String strRiskCode = specialEndorseCheckDto.getRiskCode(); //险种

        String strHPflag = ""; // 扶贫险种专用flag
        String userCode = specialEndorseCheckDto.getUserCode();
        String loginGradeCode = specialEndorseCheckDto.getLoginGradeCode();
        String strEndorType = specialEndorseCheckDto.getStrEndorType();
        Date strValidDate = specialEndorseCheckDto.getValidDate();
        int intHPflag = 0;
        if (strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
            if (strHPflag.equals("Large"))
                intHPflag = 2;
            else if (strHPflag.equals("Retaol"))
                intHPflag = 1;
            else intHPflag = 0;
        }
        String strTableName = "prpcmain"; //权限表名
        String strCheckPower = "";
        Date strStartDate;
        Date strEndDate;
        Date strToday;
        String strCondition = "";
        PubTools pubTools = new PubTools();
        int intCompareResult = 0; //日期比较结果
        PrpCmainOriginDto prpCmainOriginDto = new PrpCmainOriginDto();
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        List<SettleMainListDto> settleMainListDtoList = new ArrayList<>();
        if (strPolicyNo != null) {
            strPolicyNo = strPolicyNo.trim();
        }

        //获得Cmain等信息
        PrpCmainDto prpCmainDto = prpCmainService.queryByPK(strPolicyNo);
        strStartDate = prpCmainDto.getStartDate(); //起保日期
        strEndDate = prpCmainDto.getEndDate(); //终保日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        strToday = df.parse(df.format(new Date()));

        //检查保单是否存在
        //原生SQL
        strCheckPower = " select p.* from PrpCmain p where  p.PolicyNo=:strPolicyNo"
                + " AND p.RiskCode=:strRiskCode";

        // 控制医疗事业部和保险事业部业务不能互查 begin
        String strLoginComCode = specialEndorseCheckDto.getLoginComCode();
        if (!"0000000000".equals(strLoginComCode)) {
            if (strLoginComCode.indexOf("YL") != -1) {
                strCheckPower += " AND p.ComCode like '%YL%'";
            } else {
                strCheckPower += " AND p.ComCode Not like '%YL%'";
            }
        }
        //控制医疗事业部和保险事业部业务不能互查 end

        // 扶贫的险种加一个flag判断
        if (intHPflag == 1) {
            strCheckPower += " AND p.policytype in ('H23','I27','Q1','E1')";
        } else if (intHPflag == 2) {
            strCheckPower += " AND p.policytype in ('H24','I28','Q2','E2')";
        }
        AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(userCode
                , strLoginComCode
                , loginGradeCode
                , strTableName
                , ""
                , "comCode"
                , strRiskCode
                , "p", false);
        strCheckPower = strCheckPower + utiGroupApi.addCodePower(addCodePowerConditionDto); //得到权限查询条件;
        Query query = entityManager.createNativeQuery(strCheckPower, PrpCmain.class);
        query.setParameter("strPolicyNo",strPolicyNo);
        query.setParameter("strRiskCode",strRiskCode);
        List<PrpCmain> prpCmainList = query.getResultList();
        if (prpCmainList.size() == 0) {
            return "不存在保单号为" + strPolicyNo + "的保单！";
        }


        intCompareResult = pubTools.compareDate(strEndDate, strToday);
        //当前系统日期不能超过了保单的终保日期
        // 放开终保保单对于变更保险期限的控制
        UtiPlatConfigRuleDto utiPlatConfigRuleDto = utiPlatConfigRuleApi.queryByPK("prpall", "CHECKEND_SWITCH", 1);
        if (utiPlatConfigRuleDto != null && "1".equals(utiPlatConfigRuleDto.getRule())) {
            if (intCompareResult == -1) {
                if ("01".equals(strEndorType)) {
                    return "此保单已经终保，不允许变更保险期限！";
                } else {
                    return "此保单已经终保，不允许全单退保或注销！";
                }

            }
        }
        //检查保单核保通过
        if (!prpCmainDto.getUnderwriteFlag().equals("1") &&
                !prpCmainDto.getUnderwriteFlag().equals("3") && !"92".equals(strEndorType)&&!"19".equals(strEndorType)) {
            return "保单" + strPolicyNo + "没有审批通过！";
        }
        //该保单是否已经退保
        if (prpCmainDto.getOthFlag().length() >= 3 &&
                prpCmainDto.getOthFlag().charAt(2) == '1') {
            return "保单" + strPolicyNo + "已经退保！";
        }
        //该保单是否已经注销
        if (prpCmainDto.getOthFlag().length() >= 4 &&
                prpCmainDto.getOthFlag().charAt(3) == '1') {
            return "保单" + strPolicyNo + "已经注销！";
        }
        //该保单是否已经终止合同
        if (prpCmainDto.getOthFlag().length() >= 6 &&
                prpCmainDto.getOthFlag().charAt(5) == '1') {
            return "保单" + strPolicyNo + "已经终止合同，不能再进行批改！";
        }
        //该保单是否存在没有审批完的批单
        //原生SQL
        strCondition = " select p.* from PrpPhead p where p.PolicyNo=:strPolicyNo "
                + " AND (p.UnderWriteFlag IS NULL OR (p.UnderWriteFlag!='1' AND p.UnderWriteFlag!='3'))";
        Query prpPheadQuery = entityManager.createNativeQuery(strCondition, PrpPhead.class);
        prpPheadQuery.setParameter("strPolicyNo", strPolicyNo);
        List<PrpPhead> prpPheadList = prpPheadQuery.getResultList();
        if (prpPheadList.size() > 0&&!strEndorType.equals("92")&&!strEndorType.equals("19")) {
            return "保单" + strPolicyNo + "还有没审批完毕的批单，无法再次进行批改！";
        }
        //查询用户输入的批单生效日期后是否存在已经生效的批单头
        //该保单是否存在没有审批完的批单
        //原生SQL
        strCondition = " select p.* from PrpPhead p where p.PolicyNo=:strPolicyNo "
                + " AND p.ValidDate > :strValidDate";
        Query prpPheadQuery1 = entityManager.createNativeQuery(strCondition, PrpPhead.class);
        prpPheadQuery1.setParameter("strPolicyNo", strPolicyNo);
        prpPheadQuery1.setParameter("strValidDate", strValidDate, TemporalType.DATE);
        List<PrpPhead> prpPheadList1 = prpPheadQuery1.getResultList();
        if (prpPheadList1.size() > 0) {
            return "输入的批单生效日期不能小于已经生效的批单日期！";
        }

       /*====================================== 注销保单校验开始 ==================================================*/
        if (strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WRITEOFF").trim())) {
            if (pubTools.compareDate(strToday, strStartDate) >= 0) {
                return "保单已经起保，不能注销！";
            }

    /*  reason：如果保单打印过发票不能做注销批改 */
            //原生SQL
            String sql = "select p.* from prpJplanFee p where p.certiNo=:strPolicyNo ";
            Query query1 = entityManager.createNativeQuery(sql, PrpJplanFee.class);
            query1.setParameter("strPolicyNo", strPolicyNo);
            List<PrpJplanFee> prpJplanFeeList = query1.getResultList();
            List<PrpJplanFeeDto> prpJplanFeeDtoList = new ArrayList<>();
            convertCollection(prpJplanFeeList, prpJplanFeeDtoList, PrpJplanFeeDto.class);
            if (prpJplanFeeDtoList.size() > 0) {
                double strRealPayRefFee = 0.00;
                double strPayRefFee = 0.00;
                for (int i = 0; i < prpJplanFeeDtoList.size(); i++) {
                    PrpJplanFeeDto prpJplanFeeDto = prpJplanFeeDtoList.get(i);
                    strRealPayRefFee = strRealPayRefFee + prpJplanFeeDto.getRealpayreffee();
                    strPayRefFee = strPayRefFee + prpJplanFeeDto.getPayreffee();
                }
                if (strRealPayRefFee != 0) {
                    return "此保单已做实收，无法注销保单！";
                }
            }
            // reason：因货运险调整（保单未收费，可以做注销批改），所以整理此处逻辑 */
            List<PrpCplanDto> prpCplanDtoList = prpCplanService.queryByPolicyNo(strPolicyNo);
            if (prpCplanDtoList.size() > 0) {
                String strIsJF = "N"; //是否收费的标志
                for (int i = 0; i < prpCplanDtoList.size(); i++) {
                    //xiaojian_leave：货运险调整，是否可以用别的条件判断？
                    //如果PrpCplan的应缴金额与未缴金额不一致，表明已经收费
                    if (!prpCplanDtoList.get(i).getPlanFee().equals(prpCplanDtoList.get(i).getDelinquentFee())) {
                        strIsJF = "Y";
                        break;
                    }
                }
                if (strIsJF.equals("Y")) {
                    return "此保单已作过收费，请先取消收费处理，再注销保单！";
                }

            }
            //保单注销控制：生效日期必须相同于原始保单起保日期，若注销前已做过批单，且批单生效日期不同于起保日期，则不允许注销。
            prpCmainOriginDto = policyOriginService.queryByPolicyNo(strPolicyNo);
            List<PrpPheadDto> prpPheadDtoList = prpPheadService.queryByCondition(strPolicyNo, prpCmainOriginDto.getStartDate());
            if (prpPheadDtoList.size() == 0) {
                if (pubTools.compareDate(prpCmainOriginDto.getStartDate(), strValidDate) < 0) {
                    return "所选保单包含已起保保单，不可进行注销！";
                }
            } else {
                return "此保单已经进行过其他批改，且其他批单的生效日期在保单起保日期之后。因此此保单不允许进行注销操作。";
            }
        }
       /*========================================注销保单校验结束 ================================================================*/


       /*============================================= 全单退保校验开始 ===========================================*/
        if (strEndorType.equals(utiPlatConfigRuleApi.getProperty("EDITTYPE_WITHDRAW").trim())) {
            //中央政策性种植险保单，如果保单出过计算书，不许进行全单退保
            String plantingFarmerListFlag = utiPlatConfigRuleApi.getProperty("PLNATING_FARMER_LIST_FLAG");//中央政策险种植险标志
            if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(prpCmainDto.getRiskCode()) > -1) {

                insureMainListApi.queryByPolicyNo(strPolicyNo);
                if (insureMainListDtoList.size() > 0) {
                    SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
                    List<SwfFlowMainDto> swfFlowMainDtoList = workFlowApi.querySwfFlowMainByPolicyNo(strPolicyNo);
                    for (int i = 0; i < swfFlowMainDtoList.size(); i++) {
                        swfFlowMainDto = swfFlowMainDtoList.get(i);
                        if ("1".equals(swfFlowMainDto.getFlowStatus())) {
                            return "该保单有未处理完的理赔任务,保单不允许全单退保！！";
                        }
                    }

                    Map<String, String> map = new HashMap<>();
                    map.put("policyNo", strPolicyNo);
                    map.put("valiDity", "1");
                    settleMainListDtoList = settleMainListApi.queryByCondition(map);
                    if (settleMainListDtoList.size() > 0) {
                        return "该保单项下有已经生效的理赔清单,保单不允许全单退保！！";
                    }
                }
            }

        }
        return "";
       /*=============================================== 全单退保校验结束 ============================================*/
    }
}