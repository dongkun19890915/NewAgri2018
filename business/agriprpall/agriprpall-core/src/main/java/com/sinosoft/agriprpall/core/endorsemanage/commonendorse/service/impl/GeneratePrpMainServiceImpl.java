package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpMainService;
import com.sinosoft.dms.api.dict.PrpDprovinceConfigApi;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.utility.misc.ChgData;
import com.sinosoft.utility.string.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 普通批改main表处理实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
public class GeneratePrpMainServiceImpl extends BaseServiceImpl implements GeneratePrpMainService {
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDprovinceConfigApi prpDprovinceConfigApi;
    /**
    * 更新prpCmain信息
    * @param policyEndorseDto 保单批单大对象封装
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:25 2017/12/5
    */
    @Override
    public void updatePrpCmainNew(PolicyEndorseDto policyEndorseDto) throws Exception {

        PrpCmainDto prpCmainDto= policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCmainDto();
        EndorseConditionDto endorseConditionDto= policyEndorseDto.getBlEndorseDto().getEndorseConditionDto();
        if(prpCmainDto == null){
            throw new Exception("prpCmainDto不能为空!");
        }
        String strClassCode = prpCmainDto.getClassCode();
        String strRiskCode = prpCmainDto.getRiskCode();
        if(strClassCode == null || strRiskCode == null || strClassCode.equals("") || strRiskCode.equals("")){
            throw new Exception("险类代码或险种代码不能为空！");
        }
        int intHPflag =0;
        // 扶贫险种专用flag
        String strHPflag = endorseConditionDto.getHpFlag();
        if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
            if(strHPflag.equals("Large")){
                intHPflag = 2;
            }else if(strHPflag.equals("Retaol")) {
                intHPflag = 1;
            }else {
                intHPflag = 0;
            }
        }

        String strOthFlag = "000000YY000000000000";
        //String strGroupFlag = "00000000000000000000";
        //给保单加版本信息
        String strVersionNo = "A01";
        List<PrpDcompanyDto> prpDcompanyDtoList=prpDcompanyApi.queryByComCode(endorseConditionDto.getLoginComCode());
        String strComCodeForProvince=prpDcompanyDtoList.get(0).getComCode();
        PrpDprovinceConfigDto prpDprovinceConfigDto = prpDprovinceConfigApi.queryByPK(strComCodeForProvince, strRiskCode);
        if(prpDprovinceConfigDto != null)
        {
            if(prpDprovinceConfigDto.getVersionNo() != null && !prpDprovinceConfigDto.getVersionNo().equals(""))
            {
                strVersionNo = prpDprovinceConfigDto.getVersionNo();
            }
        }
        //strVersionNo = prpDprovinceConfigDto.getVersionNo();
        //分入不送收付
        prpCmainDto.setAgriFlag("");
//        prpCmainDto.setVersionNo(strVersionNo);
        if("1".equals(endorseConditionDto.getBusinessFlag()))
        {
            strOthFlag = "000000NY000000000000";
        }


        //团单只取第一个被保人存入cpmain表
        String strMessType = endorseConditionDto.getMessType();
        if(((strClassCode.equals("31")&&!strRiskCode.equals("3119"))||strClassCode.equals("32"))&& strMessType!= null && strMessType.trim().length() == 1) {
            prpCmainDto.setInsuredCode(ChgData.chgStrZero(endorseConditionDto.getInsuredInsuredCode()[0]));
            prpCmainDto.setInsuredName(ChgData.chgStrZero(endorseConditionDto.getInsuredInsuredName()[0]));
            prpCmainDto.setInsuredAddress(ChgData.chgStrZero(endorseConditionDto.getInsuredInsuredAddress()[0]));
        }
        //共保标志位为空默认赋值0 非联/共保
        if(prpCmainDto.getCoinsFlag() == null || prpCmainDto.getCoinsFlag().trim().equals("")){
            prpCmainDto.setCoinsFlag("0");
        }
        //可能为空的处理
        if(prpCmainDto.getCoinsPremiumType() == null){
            prpCmainDto.setCoinsPremiumType("");
        }
        if(prpCmainDto.getPolicyType() == null){
            prpCmainDto.setPolicyType("");
        }

        //OthFlag值的处理
        if(endorseConditionDto.getOldPolicyNoRenewal()!=null && !endorseConditionDto.getOldPolicyNoRenewal().trim().equals("")){
            strOthFlag = "1"+strOthFlag.substring(1);
        }
        if(strOthFlag.length()>=17){
            strOthFlag = strOthFlag.substring(0,16)+endorseConditionDto.getShareHolderName()+strOthFlag.substring(17);
        }else{
            strOthFlag = strOthFlag+ Str.space(17-strOthFlag.length())+endorseConditionDto.getShareHolderName();
        }
        String[] businessCategory = endorseConditionDto.getBusinessCategory();
//        int BusCategoryValue = 0;
//        if(businessCategory!=null){
//            for(int i=0;i<businessCategory.length;i++){
//                if(businessCategory[i]!=null&&businessCategory[i]!=""){
//                    BusCategoryValue = Integer.valueOf(ChgData.chgStrZero(businessCategory[i]));
//                    strGroupFlag = strGroupFlag.substring(0,BusCategoryValue-1)+"1"+strGroupFlag.substring(BusCategoryValue);
//                }
//            }
//        }
        //Flag值的处理 第一位做非车批改用，第二位定义：0-非大客户团单 1-大客户团单
        String strFlag = " ";
        if(endorseConditionDto.getMainHeadFlag()!=null && !endorseConditionDto.getMainHeadFlag().trim().equals("")){
            strFlag = endorseConditionDto.getMainHeadFlag();
        }else if(endorseConditionDto.getTailFlag()!=null && !endorseConditionDto.getTailFlag().trim().equals("")){
            strFlag = endorseConditionDto.getTailFlag();
        }
        if(strMessType!=null&&strMessType.trim().length()==1){
            if(strFlag.length()>=2){
                strFlag=strFlag.substring(0,1)+strMessType.trim()+strFlag.substring(2);
            }else if(strFlag.length()==1){
                strFlag=strFlag.substring(0,1)+strMessType.trim();
            }
        }
        prpCmainDto.setManualType("0");
        // 扶贫 直接默认选择0-直接业务
        if(intHPflag == 1 || intHPflag == 2) {
            prpCmainDto.setBusinessNature("0");
        }
        // 扶贫系统,业务大类默认其他
        if(intHPflag == 1 || intHPflag == 2) {
            prpCmainDto.setGroupFlag("10000000000000000000");
            prpCmainDto.setThirdKnow("2");
        } else {
            //prpCmainDto.setGroupFlag(strGroupFlag);
        }

    }
    /**
    * 普通批改Pmain表处理
    * @param policyEndorseDto 保单批单
    * @return void
    * @throws
    * @author 李冬松
    * @date 18:33 2017/12/5
    */
    @Override
    public void updatePrpPmainDto(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew= policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto= policyEndorseDto.getBlEndorseDto();
        blEndorseDto.getPrpPmainDto().setUpdaterCode(blPolicyDtoNew.getPrpCmainDto().getUpdaterCode());
        blEndorseDto.getPrpPmainDto().setUpdateDate(blPolicyDtoNew.getPrpCmainDto().getUpdateDate());
        blEndorseDto.getPrpPmainDto().setUpdateHour(blPolicyDtoNew.getPrpCmainDto().getUpdateHour());
    }
}
