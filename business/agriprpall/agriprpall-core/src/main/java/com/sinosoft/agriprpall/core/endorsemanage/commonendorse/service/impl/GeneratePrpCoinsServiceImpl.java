package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.EndorseConditionDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDetailDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePrpCoinsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class GeneratePrpCoinsServiceImpl extends BaseServiceImpl implements GeneratePrpCoinsService {
    /*
    * prpccoins表处理
    * @param policyEndorseDto 保单批单大对象
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 16:41 2017/12/21
    */
    @Override
    public void updatePrpCcoinsNew(PolicyEndorseDto policyEndorseDto) throws Exception {
        ResponseQueryPolicyInfoDto blPolicyDtoNew= policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto= policyEndorseDto.getBlEndorseDto();
        EndorseConditionDto endorseConditionDto=blEndorseDto.getEndorseConditionDto();

        //公共
        String strPolicyNo = blPolicyDtoNew.getPrpCcoinsDtoList().get(0).getPolicyNo();
        String strRiskCode = blPolicyDtoNew.getPrpCmainDto().getRiskCode();
        String strTreatyNo = "";

        PrpCcoinsDto prpCoinsDto = null;
        PrpCplanCoinsDto prpPlanCoinsDto = null;
        PrpCcoinsDetailDto prpCoinsDetailDto = null;
        String strCoins_Flag = "" ;
        String strCoinsDetail_Flag = "" ;
        String strProportionFlag = "";

        int index = 0;

        for(index=0;index<endorseConditionDto.getSerialNoCoins().length;index++)
        {
            prpCoinsDto=new PrpCcoinsDto();
            blPolicyDtoNew.getPrpCcoinsDtoList().add(prpCoinsDto);
            prpCoinsDto.setPolicyNo(strPolicyNo);

            if(endorseConditionDto.getSameToPolicyNo()!=null&&endorseConditionDto.getSameToPolicyNo()[index].equals("1"))
                prpCoinsDto.setMainPolicyNo(strPolicyNo);
            else
                prpCoinsDto.setMainPolicyNo(endorseConditionDto.getMainPolicyNo()[index]);

            if(endorseConditionDto.getCoins_Flag()!=null){
                if(endorseConditionDto.getCoins_Flag()[index].length() == 0 ){
                    strCoins_Flag = " " ;
                }else{
                    strCoins_Flag = endorseConditionDto.getCoins_Flag()[index].charAt(0)+"" ;
                    //	System.err.println(strCoins_Flag);
                    if("D".equals(strCoins_Flag)){
                        strCoins_Flag = "B" ;
                    }
                }
            }
            prpCoinsDto.setProportionFlag(strProportionFlag);
            prpCoinsDto.setSerialNo(Integer.parseInt(endorseConditionDto.getSerialNoCoins()[index]));
            prpCoinsDto.setCoinsType(endorseConditionDto.getCoinsType()[index]);
            prpCoinsDto.setChiefFlag(endorseConditionDto.getChiefType()[index]);
            prpCoinsDto.setCoinsCode(endorseConditionDto.getCoinsCode()[index]);
            prpCoinsDto.setCoinsName(endorseConditionDto.getCoinsName()[index]);
            prpCoinsDto.setCoinsRate(Double.parseDouble(endorseConditionDto.getCoinsRate()[index]));
            prpCoinsDto.setCoinsTreatyNo(strTreatyNo==null?"":strTreatyNo);
            prpCoinsDto.setFlag(strCoins_Flag);
        }
        for(index=0;index<endorseConditionDto.getSerialNoDetail().length;index++)
        {
            prpCoinsDetailDto = new PrpCcoinsDetailDto();
            blPolicyDtoNew.getPrpCcoinsDetailDtoList().add(prpCoinsDetailDto);
            prpCoinsDetailDto.setPolicyNo(strPolicyNo);
            if(endorseConditionDto.getFlagDetail()[index].length() == 0 ){
                strCoinsDetail_Flag = " " ;
            }else{
                strCoinsDetail_Flag = endorseConditionDto.getFlagDetail()[index].charAt(0)+"" ;
                if("D".equals(strCoinsDetail_Flag)){
                    strCoinsDetail_Flag = "B" ;
                }
            }
            prpCoinsDetailDto.setSerialNo(Integer.parseInt(endorseConditionDto.getSerialNoDetail()[index]));
            prpCoinsDetailDto.setCoinsCode(endorseConditionDto.getCoinsCodeDetail()[index]);
            prpCoinsDetailDto.setCoinsName(endorseConditionDto.getCoinsNameDetail()[index]);
            prpCoinsDetailDto.setCurrency(endorseConditionDto.getCurrencyDetail()[index]);
            prpCoinsDetailDto.setCoinsAmount(Double.parseDouble(endorseConditionDto.getCoinsAmount()[index]));
            prpCoinsDetailDto.setCoinsPremium(Double.parseDouble(endorseConditionDto.getCoinsPremium()[index]));
            prpCoinsDetailDto.setAgentFee(Double.parseDouble(endorseConditionDto.getAgentFee()[index]));
            prpCoinsDetailDto.setMiddleCostFee(Double.parseDouble(endorseConditionDto.getMiddleCostFee()[index]));

            prpCoinsDetailDto.setFlag(strCoinsDetail_Flag);
        }
        int count;
        String strCoinsPlan_Flag="";
        SimpleDateFormat fm=new SimpleDateFormat();
        if(strRiskCode.equals("1108")||strRiskCode.equals("00H1")||strRiskCode.equals("0310")||strRiskCode.equals("0312")||strRiskCode.equals("0309")||strRiskCode.substring(0,2).equals("31")||strRiskCode.substring(0,2).equals("32")){

            if(endorseConditionDto.getCoins_Flag().equals("1")||endorseConditionDto.getCoins_Flag().equals("2"))
            {
                if(endorseConditionDto.getCoinsPayNo()!=null&&endorseConditionDto.getCoinsPayNo().length>0){
                    for(index=0;index<endorseConditionDto.getCoinsPayNo().length;index++)
                    {
                            prpPlanCoinsDto = new PrpCplanCoinsDto();
                            blPolicyDtoNew.getPrpCplanCoinsDtoList().add(prpPlanCoinsDto);
                            prpPlanCoinsDto.setPolicyNo(strPolicyNo);

                        if(endorseConditionDto.getCoinsPlan_Flag()[index].length() == 0 ){
                            strCoinsPlan_Flag = " " ;
                        }else{
                            strCoinsPlan_Flag = endorseConditionDto.getCoinsPlan_Flag()[index].charAt(0)+"" ;
                            if("D".equals(strCoinsPlan_Flag)){
                                strCoinsPlan_Flag = "B" ;
                            }
                        }
                        if(endorseConditionDto.getCoinsEndorseNoCplan()==null)
                            prpPlanCoinsDto.setEndorseNo("");
                        else
                            prpPlanCoinsDto.setEndorseNo(endorseConditionDto.getCoinsEndorseNoCplan()[index]);
                        prpPlanCoinsDto.setSerialNo(Integer.parseInt(endorseConditionDto.getCoinsPayNo()[index]));
                        prpPlanCoinsDto.setPayNo(1);
                        prpPlanCoinsDto.setPayReason(endorseConditionDto.getCoinsPayReason()[index]);
                        prpPlanCoinsDto.setCoinsCode(endorseConditionDto.getCoinsCodePlan()[index]);
                        prpPlanCoinsDto.setPlanStartDate(fm.parse(endorseConditionDto.getCoinsPlanStartDate()[index]));
                        prpPlanCoinsDto.setPlanRate(Double.parseDouble(endorseConditionDto.getCoinsPlanRate()[index]));
                        prpPlanCoinsDto.setPlanDate(fm.parse(endorseConditionDto.getCoinsPlanDate()[index]));
                        prpPlanCoinsDto.setCurrency(endorseConditionDto.getCoinsPrpPlanCurrency()[index]);
                        prpPlanCoinsDto.setPlanFee(Double.parseDouble(endorseConditionDto.getCoinsPlanFee()[index]));
                        prpPlanCoinsDto.setDelinquentFee(Double.parseDouble(endorseConditionDto.getCoinsDelinquentFee()[index]));
                        prpPlanCoinsDto.setFlag(strCoinsPlan_Flag);
                    }
                }
                if(endorseConditionDto.getCoinsGovPayNo()!=null&&endorseConditionDto.getCoinsGovPayNo().length>0){
                    for(index=0;index<endorseConditionDto.getCoinsGovPayNo().length;index++)
                    {

                        prpPlanCoinsDto = new PrpCplanCoinsDto();
                        blPolicyDtoNew.getPrpCplanCoinsDtoList().add(prpPlanCoinsDto);
                        prpPlanCoinsDto.setPolicyNo(strPolicyNo);

                        if(endorseConditionDto.getCoinsGovEndorseNoCplan()==null)
                            prpPlanCoinsDto.setEndorseNo("");
                        else
                            prpPlanCoinsDto.setEndorseNo(endorseConditionDto.getCoinsGovEndorseNoCplan()[index]);

                        if(endorseConditionDto.getCoinsPlan_Flag()[index].length() == 0 ){
                            strCoinsPlan_Flag = " " ;
                        }else{
                            strCoinsPlan_Flag = endorseConditionDto.getCoinsPlan_Flag()[index].charAt(0)+"" ;
                            if("D".equals(strCoinsPlan_Flag)){
                                strCoinsPlan_Flag = "B" ;
                            }
                        }
                        prpPlanCoinsDto.setSerialNo(Integer.parseInt(endorseConditionDto.getCoinsGovPayNo()[index]));
                        prpPlanCoinsDto.setPayNo(1);
                        prpPlanCoinsDto.setPayReason(endorseConditionDto.getCoinsGovPayReason()[index]);
                        prpPlanCoinsDto.setCoinsCode(endorseConditionDto.getCoinsGovCodePlan()[index]);
                        prpPlanCoinsDto.setPlanStartDate(fm.parse(endorseConditionDto.getCoinsGovPlanStartDate()[index]));
                        prpPlanCoinsDto.setPlanRate(Double.parseDouble(endorseConditionDto.getCoinsGovPlanRate()[index]));
                        prpPlanCoinsDto.setPlanDate(fm.parse(endorseConditionDto.getCoinsGovPlanDate()[index]));
                        prpPlanCoinsDto.setCurrency(endorseConditionDto.getCoinsGovPrpPlanCurrency()[index]);
                        prpPlanCoinsDto.setPlanFee(Double.parseDouble(endorseConditionDto.getCoinsGovPlanFee()[index]));
                        prpPlanCoinsDto.setDelinquentFee(Double.parseDouble(endorseConditionDto.getCoinsGovDelinquentFee()[index]));
                        prpPlanCoinsDto.setFlag(strCoinsPlan_Flag);
                    }
                }
            }
        }

    }
}
