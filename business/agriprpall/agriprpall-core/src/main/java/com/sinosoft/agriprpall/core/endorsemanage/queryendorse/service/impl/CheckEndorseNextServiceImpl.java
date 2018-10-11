package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriclaim.api.workflowmanage.WorkFlowApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CheckEndorseConditionDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CheckEndorseNextService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.dms.api.dict.PrpDprovinceConfigApi;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.utility.string.ChgDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckEndorseNextServiceImpl extends BaseServiceImpl implements CheckEndorseNextService {

    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private WorkFlowApi workFlowApi;
    @Autowired
    private PrpDprovinceConfigApi prpDprovinceConfigApi;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    /**
    * 允许批改校
    * @param    p o l i c y N o  保单号
    * @return java.lang.String 版本号
    * @throws Exception
    * @author 李冬松
    * @date 14:01 2017/11/10
    */
    @Override
    public String checkEndorse(CheckEndorseConditionDto checkEndorseConditionDto) throws Exception {

        String policyNo=checkEndorseConditionDto.getPolicyNo();
        String strRiskCode=checkEndorseConditionDto.getRiskCode();
        String userCode= SinoRequestContext.getCurrentContext().getUserCode();
        //String loginGradeCodes=checkEndorseConditionDto.getLoginGradeCodes();
        String loginComCode=checkEndorseConditionDto.getLoginComCode();
        Date strValidDate=checkEndorseConditionDto.getStrValidDate();
        int intHPflag = 0;
        String strHPflag = "";
        String strPolicyNo = policyNo;
        if(strPolicyNo == null) {
        	throw new DataVerifyException("保单号不能为空！");
        }
        if (strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
            if (strHPflag.equals("Large"))
                intHPflag = 2;
            else if (strHPflag.equals("Retaol"))
                intHPflag = 1;
            else intHPflag = 0;
        }
        PrpCmain dbPrpCmain = new PrpCmain();
        dbPrpCmain = prpCmainDao.queryPrpCMainByCondition(strPolicyNo);
        if(dbPrpCmain != null) {
        	strRiskCode = dbPrpCmain.getRiskCode();
        }else {
        	throw new DataVerifyException("未找到保单信息！！！");
        }
        
        StringBuilder Sql = new StringBuilder("select p.* from PrpCmain p where ");

        Date strStartDate =null;
        Date strEndDate = null;
        int compareResult = 0; //日期比较结果
        if (strPolicyNo != null) {
            strPolicyNo = strPolicyNo.trim();
            strRiskCode=strPolicyNo.substring(1,5);
        }
        Sql.append("p.PolicyNo='").append(strPolicyNo).append("' AND p.RiskCode='").append(strRiskCode).append("'");
        if (!"0000000000".equals(loginComCode)) {
            if (loginComCode.indexOf("YL") != -1) {
                Sql.append(" AND p.ComCode like '%YL%'");
            } else {
                Sql.append(" AND p.ComCode Not like '%YL%'");
            }
        }
        if (intHPflag == 1) {
            Sql.append(" AND p.policytype in ('H23','I27','Q1','E1')");
        } else if (intHPflag == 2) {
            Sql.append(" AND p.policytype in ('H24','I28','Q2','E2')");
        }
        AddCodePowerConditionDto addCodePowerConditionDto=new AddCodePowerConditionDto(userCode,
                                                              loginComCode,
                                                              "",
                                                              "PrpCmain",
                                                              "",
                                                              "comCode",
                                                              strRiskCode,
                                                              "p",
                                                              false);
        long a=System.currentTimeMillis();
        Sql.append(utiGroupApi.addCodePower(addCodePowerConditionDto));
        System.out.println("执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        System.out.println(Sql);
        Query dataQuery = entityManager.createNativeQuery(Sql.toString());
        List<PrpCmain> prpCmainCheckList = dataQuery.getResultList();
        String plantingFarmerListFlag = "prpall";
        if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            String CompensateNo = "";
            List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(strPolicyNo);
            if (insureMainListDtoList.size() > 0) {
                List<SwfFlowMainDto> swfFlowMainDtoList=new ArrayList<>();
                swfFlowMainDtoList=workFlowApi.querySwfFlowMainByPolicyNo(policyNo);
                for(int i=0;i<swfFlowMainDtoList.size();i++){
                    if("1".equals(swfFlowMainDtoList.get(i).getFlowStatus())){
                        throw new DataVerifyException("该保单有未处理完的理赔任务,保单不允许做批改！！！");
                    }
                }
            }
        }
            if (prpCmainCheckList.size() == 0) {
                throw new DataVerifyException("不存在保单号为" + strPolicyNo + "的保单！");
            }
        dbPrpCmain = prpCmainDao.queryPrpCMainByCondition(strPolicyNo);
        if ("".equals(dbPrpCmain.getPrintNo()) && !"YAB1".equals(dbPrpCmain.getRiskCode())) {
            throw new DataVerifyException("保单号为" + strPolicyNo + "的保单还没打印，不能做批改!");
        }
        UtiPlatConfigRuleDto utiPlatConfigRuleDto=utiPlatConfigRuleApi.queryByPK("prpall","CHECKEND_SWITCH",1);
        if(utiPlatConfigRuleDto!=null&&"1".equals(utiPlatConfigRuleDto.getRule())){
            ChgDate idate=new ChgDate();
            String strtodayDate=idate.getCurrentTime("yyyy-MM-dd");
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date todayDate=fm.parse(strtodayDate);
            compareResult =compareDate(todayDate, dbPrpCmain.getEndDate());
            if(compareResult==1){
                throw new DataVerifyException("当前保单已经终保不能再进行批改！");
            }
        }

        strStartDate = dbPrpCmain.getStartDate();//起保日期
        System.out.println("============="+strStartDate+"=========="+strValidDate);
        compareResult=compareDate(strValidDate,strStartDate);
        if(compareResult==-1){
            throw new DataVerifyException("批改生效日期"+strValidDate+"不能小于起保日期"+strStartDate+"！");
        }
        strEndDate = dbPrpCmain.getEndDate(); //终保日期
        compareResult = compareDate(strEndDate,strValidDate);
        if(compareResult==-1)
        {
            throw new DataVerifyException("批改生效日期"+strValidDate+"不能大于终保日期"+strEndDate+"！");
        }
        strEndDate = dbPrpCmain.getEndDate(); //终保日期
       if(dbPrpCmain.getUnderwriteFlag().equals("4")){
           throw new DataVerifyException("保单" + strPolicyNo + "未收费，请先去收费！");
       }
       //该保单是否已经核保通过
        if (!dbPrpCmain.getUnderwriteFlag().equals("1") &&
                !dbPrpCmain.getUnderwriteFlag().equals("3")) {
            throw new DataVerifyException("保单" + strPolicyNo + "没有审批通过！");
        }
        //该保单是否已经退保
        if (dbPrpCmain.getOthFlag().length() >= 3 && dbPrpCmain.getOthFlag().charAt(2) == '1') {
            throw new DataVerifyException("保单" + strPolicyNo + "已经退保！");
        }
        //该保单是否已经注销
        if (dbPrpCmain.getOthFlag().length() >= 4 && dbPrpCmain.getOthFlag().charAt(3) == '1') {
            throw new DataVerifyException("保单" + strPolicyNo + "已经注销！");
        }
        //该保单是否已经终止合同
        if (dbPrpCmain.getOthFlag().length() >= 6 && dbPrpCmain.getOthFlag().charAt(5) == '1') {
            throw new DataVerifyException("保单" + strPolicyNo + "已经终止合同！");
        }
        //该保单是否存在没有审批完的批单
        if (prpPheadDao.countAllByFlag(strPolicyNo) > 0) {
            throw new DataVerifyException("保单" + strPolicyNo + "还存在没审批完毕的批单,无法再次进行批改！");
        }
        //该保单在用户输入的批单生效日期后是否存在已经生效的批单
            if (prpPheadDao.countAllByDate(strPolicyNo, strValidDate) > 0) {
                throw new DataVerifyException("UIEndorseCommonSubmit", "输入的批单生效日期不能小于已经生效的批单日期！");
            }
        //当前险种的编辑页面
        strRiskCode = dbPrpCmain.getRiskCode();
        String strComCodeForTemp = dbPrpCmain.getComCode();
        String strVersionNo = "";
        String provinceComCode = "0000000000";
        String tempComCode = "";
        String strComCodeForProvince = "";

        if (dbPrpCmain.getVersionNo() != null && !dbPrpCmain.getVersionNo().equals("")) {
            strVersionNo = dbPrpCmain.getVersionNo();
        } else {
            if (strComCodeForTemp.equals(provinceComCode)) {
                strComCodeForProvince = provinceComCode;
            } else {
                List<PrpDcompanyDto> prpDcompanyDtoList=prpDcompanyApi.queryByComCode(strComCodeForTemp);
                tempComCode = prpDcompanyDtoList.get(0).getComCode();
                if (tempComCode != "" && tempComCode != null) {
                    provinceComCode = tempComCode;
                    if (provinceComCode.startsWith("00000", 0)) {
                        provinceComCode = "0000000000";
                    }
                }
                strComCodeForProvince = provinceComCode;
            }


            PrpDprovinceConfigDto prpDprovinceConfigDto = prpDprovinceConfigApi.queryByPK(strComCodeForProvince, strRiskCode);
            if (prpDprovinceConfigDto != null) {
                if (prpDprovinceConfigDto.getVersionNo() != null) {
                    strVersionNo = prpDprovinceConfigDto.getVersionNo();
                }
            }
        }
        return strVersionNo;
    }

    public  int compareDate(Date firstDate, Date secondDate)
            throws Exception {
        int intReturn = 0;

        try {
            if (firstDate.after(secondDate)) {
                intReturn = 1;
            } else if (firstDate.before(secondDate)) {
                intReturn = -1;
            } else if (firstDate.equals(secondDate)) {
                intReturn = 0;
            }
            return intReturn;
        } catch (Exception e) {
            throw e;
        }
    }
}