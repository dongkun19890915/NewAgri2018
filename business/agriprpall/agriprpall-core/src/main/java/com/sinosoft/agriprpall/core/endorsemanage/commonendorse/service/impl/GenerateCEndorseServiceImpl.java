package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.alibaba.fastjson.JSON;
import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeeDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCplanDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateCEndorseService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.utility.string.Str;

import java.util.HashMap;

public class GenerateCEndorseServiceImpl extends BaseServiceImpl implements GenerateCEndorseService{

    /**
     * @description: 生成批单的缴费计划(不涉及政府补贴)
     * @description：该方法目前只在BLEndorse.webAfterCal中调用，原传参为prpPfeeSchema、strValidDate，
     * @description：因为币别调整，缴费计划中只能有一种币别（支付保费币别），一次批改目前只产生一条数据。
     * @author: 李东东
     * @date: 2017/11/1 16:49
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @throws Exception
     */
    public void append(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception{
        PrpCplanDto prpCplanDto = new PrpCplanDto();
        PrpPfeeDto prpPfeeDto = new PrpPfeeDto();

        double dbChgPremium1 = 0;
        int intCplanCount = blPolicyDtoNew.getPrpCplanDtoList().size();
        int i = 0;

        if (blEndorseDto.getPrpPfeeDtoList().size() >= 0) {

            for (i = 0; i < blEndorseDto.getPrpPfeeDtoList().size(); i++) {
                prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(i);
                if (prpPfeeDto.getChgPremium1() != 0) {
                    dbChgPremium1 = Str.round(dbChgPremium1 + Str.round(prpPfeeDto.getChgPremium1(), 2), 2);
                }
            }

            intCplanCount = intCplanCount + 1;
            prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(0);
            prpCplanDto.setPolicyNo(prpPfeeDto.getPolicyNo());
            prpCplanDto.setEndorseNo(prpPfeeDto.getEndorseNo());
            prpCplanDto.setSerialNo(intCplanCount);
            prpCplanDto.setPayNo(0);
            if (dbChgPremium1 > 0) {
                prpCplanDto.setPayReason("R30");
            } else {
                prpCplanDto.setPayReason("P40");
            }
            prpCplanDto.setPlanDate(blEndorseDto.getPrpPheadDto().getValidDate());
            prpCplanDto.setCurrency(prpPfeeDto.getCurrency1());
            prpCplanDto.setPlanFee(dbChgPremium1);
            prpCplanDto.setDelinquentFee(dbChgPremium1);
            prpCplanDto.setFlag("I");
            prpCplanDto.setPlanStartDate(blEndorseDto.getPrpPheadDto().getValidDate());
            blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);
        }
    }

    /**
     * @description: 生成批单的缴费计划(不涉及政府补贴)
     * @description：该方法目前只在BLEndorse.webAfterCal中调用，原传参为prpPfeeSchema、strValidDate，
     * @description：因为币别调整，缴费计划中只能有一种币别（支付保费币别），一次批改目前只产生一条数据。
     * @author: 李东东
     * @date: 2017/11/1 16:49
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @throws Exception
     */
    public void appendAgriPlan(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception {
        PrpCplanDto prpCplanDto = new PrpCplanDto();
        PrpPfeeDto prpPfeeDto = new PrpPfeeDto();
        double dbChgPremium1 = 0;
        int intCplanCount = blPolicyDtoNew.getPrpCplanDtoList().size();
        PrpCsubsidyDto prpCsubsidyDto=null;
        int i = 0;

        double subsidyPremium=0;//自交保费
        double dbChgPremium=0;//保费变化量
        double govChgPremium=0;//政府补贴保费
        double sumPremium = blPolicyDtoOld.getPrpCmainDto().getSumPremium();
        if (blEndorseDto.getPrpPfeeDtoList().size() >= 0) {

            for (i = 0; i < blEndorseDto.getPrpPfeeDtoList().size(); i++) {
                prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(i);
                if (prpPfeeDto.getChgPremium1() != 0) {
                    dbChgPremium1 = Str.round(dbChgPremium1 + Str.round(prpPfeeDto.getChgPremium1(), 2), 2);
                }
            }
            prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(0);
            for(i=0;i<blPolicyDtoNew.getPrpCsubsidyDtoList().size();i++){
                intCplanCount = intCplanCount + 1;
                prpCplanDto = new PrpCplanDto();
                prpCsubsidyDto=blPolicyDtoNew.getPrpCsubsidyDtoList().get(i);
                prpCplanDto.setPolicyNo(prpPfeeDto.getPolicyNo());
                prpCplanDto.setEndorseNo(prpPfeeDto.getEndorseNo());
                prpCplanDto.setSerialNo(intCplanCount);
                prpCplanDto.setPayNo(0);
                prpCplanDto.setPlanDate(blEndorseDto.getPrpPheadDto().getValidDate());
                prpCplanDto.setCurrency(prpPfeeDto.getCurrency1());
                dbChgPremium=Str.round(dbChgPremium1* Str.round(prpCsubsidyDto.getSubsidyPremium(),2)/sumPremium,2);
                prpCplanDto.setPlanFee(dbChgPremium);
                prpCplanDto.setDelinquentFee(prpCplanDto.getPlanFee());
                prpCplanDto.setPlanStartDate(blEndorseDto.getPrpPheadDto().getValidDate());
                prpCplanDto.setPolicyNo(prpPfeeDto.getPolicyNo());
                prpCplanDto.setFlag("I");
                if("03".equals(prpCsubsidyDto.getSubsidyCode()))
                {
                    prpCplanDto.setPayReason("PS3");
                }
                else if("04".equals(prpCsubsidyDto.getSubsidyCode()))
                {
                    prpCplanDto.setPayReason("PS4");
                }
                else if("05".equals(prpCsubsidyDto.getSubsidyCode()))
                {
                    prpCplanDto.setPayReason("PS5");
                }
                else if("06".equals(prpCsubsidyDto.getSubsidyCode()))
                {
                    prpCplanDto.setPayReason("PS6");
                }
                else if("07".equals(prpCsubsidyDto.getSubsidyCode()))
                {
                    prpCplanDto.setPayReason("PS7");
                }
                else{
                    //如果添加其他类别，必须在此添加逻辑！
                    throw new DataVerifyException("prpCsubsidy.SubsidyCode无此类别["+prpCsubsidyDto.getSubsidyCode()+"]!");
                }

                subsidyPremium=Str.round(subsidyPremium+ Str.round(blPolicyDtoNew.getPrpCsubsidyDtoList().get(i).getSubsidyPremium(),2),2);
                govChgPremium=Str.round(dbChgPremium+govChgPremium,2);
                blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);
                //更新政府补贴
                prpCsubsidyDto.setSubsidyPremium(Str.round(prpCsubsidyDto.getSubsidyPremium()+dbChgPremium,2));
            }


            intCplanCount = intCplanCount + 1;
            prpCplanDto=new PrpCplanDto();
            prpCplanDto.setPolicyNo(prpPfeeDto.getPolicyNo());
            prpCplanDto.setEndorseNo(prpPfeeDto.getEndorseNo());
            prpCplanDto.setSerialNo(intCplanCount);
            prpCplanDto.setPayNo(0);
            if (dbChgPremium1 > 0) {
                prpCplanDto.setPayReason("R30");
            } else {
                prpCplanDto.setPayReason("P10");
            }
            prpCplanDto.setPlanDate(blEndorseDto.getPrpPheadDto().getValidDate());
            prpCplanDto.setCurrency(prpPfeeDto.getCurrency1());
            prpCplanDto.setPlanFee(Str.round(dbChgPremium1-govChgPremium,2));
            prpCplanDto.setDelinquentFee(Str.round(dbChgPremium1-govChgPremium,2));
            prpCplanDto.setPlanStartDate(blEndorseDto.getPrpPheadDto().getValidDate());
            prpCplanDto.setFlag("I");
            blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);
            }

    }

    /**
     * @description: 生成批单的缴费计划(针对71补贴批改)
     * @description：该方法目前只在BLEndorse.webAfterCal中调用，原传参为prpPfeeSchema、strValidDate，
     * @description：因为币别调整，缴费计划中只能有一种币别（支付保费币别），一次批改目前只产生一条数据。
     * @author: 李东东
     * @date: 2018/04/29 16:49
     * @param blPolicyDtoNew
     * @param blEndorseDto
     * @throws Exception
     */
    public void append71AgriPlan(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception {
        PrpCplanDto prpCplanDto = new PrpCplanDto();
        int intCplanCount = blPolicyDtoNew.getPrpCplanDtoList().size();
        PrpCsubsidyDto prpCsubsidyDto=null;//NEW DTO
        PrpCsubsidyDto prpCsubsidyOldDto = null;//OLD DTO
        int i = 0;
        PrpPheadDto prpPheadDto = blEndorseDto.getPrpPheadDto();
        double selfPremiumOld=0;//批改前自缴保费
        double selfPremiumNew=0;//批改后自缴保费
        double dbChgPremium=0;//保费变化量
        double govChgPremiumNew=0;//批改后政府补贴保费
        double selfRateNew = 0;//批改后自缴比例
        double govSubsidyRateNew = 0;//批改后政府补贴比例
        double sumPremium = blPolicyDtoOld.getPrpCmainDto().getSumPremium();

        //补贴信息OLD
        HashMap<String,PrpCsubsidyDto> subsidyOldMap = new HashMap();
        for (i=0; i < blPolicyDtoOld.getPrpCsubsidyDtoList().size(); i++) {
            subsidyOldMap.put(blPolicyDtoOld.getPrpCsubsidyDtoList().get(i).getSubsidyCode(), blPolicyDtoOld.getPrpCsubsidyDtoList().get(i));
        }

        for(i=0;i<blPolicyDtoNew.getPrpCsubsidyDtoList().size();i++){
            intCplanCount = intCplanCount + 1;
            prpCplanDto = new PrpCplanDto();
            prpCsubsidyDto=blPolicyDtoNew.getPrpCsubsidyDtoList().get(i);
            String subsidyCodeKey = prpCsubsidyDto.getSubsidyCode();
            prpCsubsidyOldDto = subsidyOldMap.get(subsidyCodeKey);//匹配old DTO
            //保费变化
            dbChgPremium = Str.round(prpCsubsidyDto.getSubsidyPremium() - prpCsubsidyOldDto.getSubsidyPremium(),2);;

            prpCplanDto.setPolicyNo(prpPheadDto.getPolicyNo());
            prpCplanDto.setEndorseNo(prpPheadDto.getEndorseNo());
            prpCplanDto.setSerialNo(intCplanCount);
            prpCplanDto.setPayNo(0);
            prpCplanDto.setPlanDate(blEndorseDto.getPrpPheadDto().getValidDate());
            prpCplanDto.setCurrency(blPolicyDtoOld.getPrpCfeeDtoList().get(0).getCurrency1());
            prpCplanDto.setPlanFee(dbChgPremium);
            prpCplanDto.setPlanRate(prpCsubsidyDto.getSubsidyRate());//补贴比例
            prpCplanDto.setDelinquentFee(prpCplanDto.getPlanFee());
            prpCplanDto.setPlanStartDate(prpPheadDto.getValidDate());
            prpCplanDto.setPolicyNo(prpPheadDto.getPolicyNo());
            prpCplanDto.setFlag("I");
            if("03".equals(prpCsubsidyDto.getSubsidyCode()))
            {
                prpCplanDto.setPayReason("PS3");
            }
            else if("04".equals(prpCsubsidyDto.getSubsidyCode()))
            {
                prpCplanDto.setPayReason("PS4");
            }
            else if("05".equals(prpCsubsidyDto.getSubsidyCode()))
            {
                prpCplanDto.setPayReason("PS5");
            }
            else if("06".equals(prpCsubsidyDto.getSubsidyCode()))
            {
                prpCplanDto.setPayReason("PS6");
            }
            else if("07".equals(prpCsubsidyDto.getSubsidyCode()))
            {
                prpCplanDto.setPayReason("PS7");
            }
            else{
                //如果添加其他类别，必须在此添加逻辑！
                throw new DataVerifyException("prpCsubsidy.SubsidyCode无此类别["+prpCsubsidyDto.getSubsidyCode()+"]!");
            }

            govChgPremiumNew=Str.round(govChgPremiumNew+prpCsubsidyDto.getSubsidyPremium(),2);
            govSubsidyRateNew = Str.round(govSubsidyRateNew+prpCsubsidyDto.getSubsidyRate(),2);
            blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);
        }

        selfPremiumNew = Str.round(sumPremium - govChgPremiumNew,2);//批改后自缴保费
        selfRateNew = Str.round(100 - govSubsidyRateNew,2);

        intCplanCount = intCplanCount + 1;
        prpCplanDto=new PrpCplanDto();
        prpCplanDto.setPlanRate(selfRateNew);//自缴补贴比例
        prpCplanDto.setPolicyNo(prpPheadDto.getPolicyNo());
        prpCplanDto.setEndorseNo(prpPheadDto.getEndorseNo());
        prpCplanDto.setSerialNo(intCplanCount);
        prpCplanDto.setPayNo(0);

        //计算自缴保费变化量
        for(i = 0;i< blPolicyDtoOld.getPrpCplanDtoList().size();i++){
            if("R10,R30,P10".indexOf(blPolicyDtoOld.getPrpCplanDtoList().get(i).getPayReason()) > -1) {//判断自缴收付类型
                selfPremiumOld = Str.round(selfPremiumOld + blPolicyDtoOld.getPrpCplanDtoList().get(i).getPlanFee(),2);
            }
        }

        dbChgPremium = Str.round(selfPremiumNew - selfPremiumOld,2);

        if (dbChgPremium > 0) {
            prpCplanDto.setPayReason("R30");
        } else {
            prpCplanDto.setPayReason("P10");
        }
        prpCplanDto.setPlanDate(blEndorseDto.getPrpPheadDto().getValidDate());
        prpCplanDto.setCurrency(blPolicyDtoOld.getPrpCfeeDtoList().get(0).getCurrency1());
        prpCplanDto.setPlanFee(dbChgPremium);
        prpCplanDto.setPlanRate(selfRateNew);//自缴比例
        prpCplanDto.setDelinquentFee(dbChgPremium);
        prpCplanDto.setPlanStartDate(blEndorseDto.getPrpPheadDto().getValidDate());
        prpCplanDto.setFlag("I");
        blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);


    }
}
