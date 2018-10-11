package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.BLCPDataService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.BLPDataService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePEndorseService;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GeneratePMainForYGZService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BLEndorseCheckService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.utility.string.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 普通批改P表处理实现类
 * @Author: 李冬松
 * @Date: 9:00 2017/11/17
 */
@Service
public class GeneratePEndorseServiceImpl extends BaseServiceImpl implements GeneratePEndorseService {

    @Autowired
    private BLEndorseCheckService blEndorseCheckService;
    @Autowired
    private GeneratePMainForYGZService generatePMainForYGZService;
    @Autowired
    private BLPDataService blpDataService;
    @Autowired
    private BLCPDataService blcpDataService;

    /**
    * 生成批单对象主方法
    * @param policyEndorseDto 保单批单
    * @return void
    * @throws Exception
    * @author 李冬松
    * @date 18:53 2017/12/5
    */
    @Override
    public void generatePNew(PolicyEndorseDto policyEndorseDto) throws Exception {

        ResponseQueryPolicyInfoDto blPolicyDtoOld=policyEndorseDto.getBlPolicyInfoDtoOld();
        ResponseQueryPolicyInfoDto blPolicyDtoNew=policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        //将保单数据赋值到P表中
        evaluateFromPolicyToEndor(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        //web批改后金额处理函数（币别调整后，用来获得PrpPmain的变化量）
        webAfterCal(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
    }

    public void adjustChgPremium(PolicyEndorseDto policyEndorseDto) throws Exception {
        int i = 0;
        ResponseQueryPolicyInfoDto blPolicyDtoNew=policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        PrpPitemKindDto prpPitemKindDto = new PrpPitemKindDto();
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        double chgPremiumItemkind = 0d;
        double chgPremium = 0d;
        double AllPremium=0;
        double EveryPremium=0;
        double LastPremium=0;
        //Double.parseDouble(blEndorseDto.getPrpPmainDto().getChgPremium());
        blEndorseDto.getPrpPmainDto().setChgPremium(Str.round(
                Str.round(blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2)-blEndorseDto.getPrpPmainDto().getSumPremium(),2));

        chgPremium = Str.round(blEndorseDto.getPrpPmainDto().getChgPremium(),2);
        for (i = 0; i < blEndorseDto.getPrpPfeeDtoList().size(); i++) {
            blEndorseDto.getPrpPfeeDtoList().get(i).setChgPremium(Str.round(
                    Str.round(blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2)-blEndorseDto.getPrpPmainDto().getSumPremium(),2));
            blEndorseDto.getPrpPfeeDtoList().get(i).setChgPremium1(Str.round(
                    Str.round(blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2)-blEndorseDto.getPrpPmainDto().getSumPremium(),2));
            blEndorseDto.getPrpPfeeDtoList().get(i).setChgPremium2(Str.round(
                    Str.round(blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2)-blEndorseDto.getPrpPmainDto().getSumPremium(),2));
        }

        blPolicyDtoNew.getPrpCmainDto().setSumPremium(Str.round(
                blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2));
        AllPremium=Str.round(
                blPolicyDtoNew.getPrpCmainDto().getSumPremium(),2);


        for (i = 0; i < blPolicyDtoNew.getPrpCfeeDtoList().size(); i++) {
            blPolicyDtoNew.getPrpCfeeDtoList().get(i).setPremium(Str.round(
                    blPolicyDtoNew.getPrpCfeeDtoList().get(i).getPremium(),2));
            blPolicyDtoNew.getPrpCfeeDtoList().get(i).setPremium1(Str.round(
                    blPolicyDtoNew.getPrpCfeeDtoList().get(i).getPremium1(),2));
            blPolicyDtoNew.getPrpCfeeDtoList().get(i).setPremium2(Str.round(
                    blPolicyDtoNew.getPrpCfeeDtoList().get(i).getPremium2(),2));
        }

        for (i = 0; i < blEndorseDto.getPrpPitemKindDtoList().size(); i++) {
            prpPitemKindDto = blEndorseDto.getPrpPitemKindDtoList().get(i);
            prpPitemKindDto.setChgPremium(Str.round(prpPitemKindDto.getChgPremium(),2));
            chgPremiumItemkind += prpPitemKindDto.getChgPremium();
            if(i==blEndorseDto.getPrpPitemKindDtoList().size()-1){// 最后一个险别进行调差
                if(Str.round(Math.abs(chgPremium-chgPremiumItemkind),4)>=0.01){
                    prpPitemKindDto.setChgPremium(Str.round(prpPitemKindDto.getChgPremium()+chgPremium-chgPremiumItemkind,2));
                }
                LastPremium=Str.round(AllPremium-EveryPremium,2);
            }
            for(int j=0; j< blPolicyDtoNew.getPrpCitemKindDtoList().size(); j++){
                prpCitemKindDto = blPolicyDtoNew.getPrpCitemKindDtoList().get(j);
                if(prpPitemKindDto.getItemKindNo().equals(prpCitemKindDto.getItemKindNo())){
                    prpCitemKindDto.setPremium(Str.round(prpPitemKindDto.getPremium()
                            +prpPitemKindDto.getChgPremium(),2));
                    EveryPremium=EveryPremium+Str.round(prpPitemKindDto.getPremium()+prpPitemKindDto.getChgPremium(),2);
                }
                if(j==(blPolicyDtoNew.getPrpCitemKindDtoList().size()-1)&&prpPitemKindDto.getItemKindNo().equals(prpCitemKindDto.getItemKindNo())){// 最后一个险别进行调差
                    prpCitemKindDto.setPremium(LastPremium);
                }
            }
        }
    }


    /**
     * @description: web批改后金额处理函数,老系统中因为阳光调整比较的大，现在此函数只是用来处理批改后生成缴费计划的数据
     * @author: 李东东
     * @date: 2017/11/1 16:12
     * @param
     * @throws Exception
     */
    public void webAfterCal(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception{
        PrpPfeeDto prpPfeeDto = new PrpPfeeDto();
        String strEndorType = blEndorseDto.getPrpPheadDto().getEndorType();
        //特殊批改中目前只有01、19、21涉及金额的变化
        if (strEndorType.equals("01")|| //变更保险期限
                strEndorType.equals("19")||//保单注销
                strEndorType.equals("91")||//批改单位保额
                strEndorType.equals("11")||//费率调整
                strEndorType.indexOf("21")>-1) //全单退保
        {
            for (int i = 0; i < blEndorseDto.getPrpPfeeDtoList().size(); i++) {
                prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(i);
                //是否生成缴费计划由是否有保费变化决定，即至少有一条PrpPfee.ChgPremium1（支付保费币别的保费）不为0
                if (prpPfeeDto.getChgPremium1()!= 0) {
                    break;
                }
            }
            Date validDate = blEndorseDto.getPrpPheadDto().getValidDate();
            if(blPolicyDtoNew.getPrpCsubsidyDtoList().size()==0) {
                new GenerateCEndorseServiceImpl().append(blPolicyDtoNew,blEndorseDto);
            }else {
                new GenerateCEndorseServiceImpl().appendAgriPlan(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
            }
        }else if(strEndorType.equals("71")){//批改补贴
            new GenerateCEndorseServiceImpl().append71AgriPlan(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        }

    }

    /**
     * @description: 生成新的批单对象
     * @author: 李东东
     * @date: 2017/10/31 15:27
     * @param blPolicyDtoOld 原有保单对象
     * @param blPolicyDtoNew 新的保单对象
     */
    public void evaluateFromPolicyToEndor(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto) throws Exception{

        generatePrpPaddress(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPcoins(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPcoinsDetail(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPengage(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPfee(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPhead(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPinsured(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPitemKind(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPmain(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPmainAgri(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPplan(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPplanCoins(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPexpense(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPitemKindAgri(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPsubSidy(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);
        generatePrpPfeild(blPolicyDtoOld,blPolicyDtoNew,blEndorseDto);

    }
    /**
     * @description 地址信息表
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:19 2017/11/10
     */
    public  void generatePrpPaddress(ResponseQueryPolicyInfoDto blPolicyDtoOld, ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        if(blPolicyDtoOld.getPrpCaddressDtoList().size()>blPolicyDtoNew.getPrpCaddressDtoList().size()){
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        PrpPaddressDto prpPaddressDto=null;
        List<PrpPaddressDto> prpPaddressDtoList = new ArrayList<>();
        PrpCaddressDto prpCaddressDtoOld=null;
        PrpCaddressDto prpCaddressDtoNew=null;

        List<PrpCPaddressDto> prpCPaddressDtoList=new ArrayList<>();
        for(int i=0;i<blPolicyDtoNew.getPrpCaddressDtoList().size();i++){
            prpCaddressDtoNew=blPolicyDtoNew.getPrpCaddressDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCaddressDtoNew.getFlag()) && prpCaddressDtoNew.getFlag().length()>0
                    && prpCaddressDtoNew.getFlag().charAt(0)=='I'){
                prpCaddressDtoOld=prpCaddressDtoNew;
            }else {
                prpCaddressDtoOld=blPolicyDtoOld.getPrpCaddressDtoList().get(i);
            }
            prpPaddressDto=new PrpPaddressDto();
            prpPaddressDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPaddressDto.setPolicyNo(prpCaddressDtoOld.getPolicyNo());
            prpPaddressDto.setRiskCode(prpCaddressDtoOld.getRiskCode());
            prpPaddressDto.setAddressNo(prpCaddressDtoOld.getAddressNo());
            prpPaddressDto.setAddressCode(prpCaddressDtoOld.getAddressCode());
            prpPaddressDto.setAddressName(prpCaddressDtoOld.getAddressName());
            prpPaddressDto.setFlag(prpCaddressDtoNew.getFlag());//标志用新的
            prpPaddressDto.setProjectName(prpCaddressDtoNew.getProjectName());
            prpPaddressDtoList.add(prpPaddressDto);
            prpCPaddressDtoList.add(convert(prpCaddressDtoNew,PrpCPaddressDto.class));
        }
        blEndorseDto.setPrpPaddressDtoList(prpPaddressDtoList);
        blEndorseDto.setPrpCPaddressDtoList(prpCPaddressDtoList);
    }
    public  void generatePrpPcoins(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        if(blPolicyDtoNew.getPrpCcoinsDtoList()==null){
            return;
        }

        if(blPolicyDtoNew.getPrpCcoinsDtoList().size()<blPolicyDtoOld.getPrpCcoinsDtoList().size()){
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        if(blPolicyDtoOld.getPrpCcoinsDtoList()==null||blPolicyDtoOld.getPrpCcoinsDtoList().size()==0){
            return;
        }
        PrpPcoinsDto prpPcoinsDto =null;
        List<PrpPcoinsDto> prpPcoinsDtoList = new ArrayList<>();
        PrpCcoinsDto prpCcoinsDtoOld=null;
        PrpCcoinsDto prpCcoinsDtoNew=null;
        List<PrpCPcoinsDto> prpCPcoinsDtoList=new ArrayList<>();
        for(int i=0;i<blPolicyDtoNew.getPrpCcoinsDtoList().size();i++){
            prpCcoinsDtoNew=blPolicyDtoNew.getPrpCcoinsDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCcoinsDtoNew.getFlag()) && prpCcoinsDtoNew.getFlag().length()>0
                    && prpCcoinsDtoNew.getFlag().charAt(0)=='I'){
                prpCcoinsDtoOld=prpCcoinsDtoNew;
            }else {
                prpCcoinsDtoOld=blPolicyDtoOld.getPrpCcoinsDtoList().get(i);
            }
            prpPcoinsDto =new PrpPcoinsDto();
            prpPcoinsDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPcoinsDto.setPolicyNo(prpCcoinsDtoOld.getPolicyNo());
            prpPcoinsDto.setSerialNo(prpCcoinsDtoOld.getSerialNo());
            prpPcoinsDto.setMainPolicyNo(prpCcoinsDtoOld.getMainPolicyNo());
            prpPcoinsDto.setCoinsCode(prpCcoinsDtoOld.getCoinsCode());
            prpPcoinsDto.setCoinsName(prpCcoinsDtoOld.getCoinsName());
            prpPcoinsDto.setCoinsType(prpCcoinsDtoOld.getCoinsType());
            prpPcoinsDto.setChiefFlag(prpCcoinsDtoNew.getChiefFlag());
            prpPcoinsDto.setCoinsRate(prpCcoinsDtoOld.getCoinsRate());
            prpPcoinsDto.setProportionFlag(prpCcoinsDtoNew.getProportionFlag());
            prpPcoinsDto.setCoinsTreatyNo(prpCcoinsDtoNew.getCoinsTreatyNo());
            prpPcoinsDto.setFlag(prpCcoinsDtoNew.getFlag());
            if(StringUtils.isNotEmpty(prpCcoinsDtoNew.getFlag()) && prpCcoinsDtoNew.getFlag().length()>0){
                if(prpPcoinsDto.getFlag().charAt(0)=='I'){
                    prpPcoinsDto.setChgCoinsRate(prpCcoinsDtoNew.getCoinsRate());
                }else {
                    double dbCoinsRateOld= Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDtoOld.getCoinsRate())),4);
                    double dbCoinsRateNew= Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDtoNew.getCoinsRate())),4);
                    prpPcoinsDto.setChgCoinsRate(Str.round(dbCoinsRateNew-dbCoinsRateOld,4));
                }
            }
            prpCPcoinsDtoList.add(convert(prpCcoinsDtoNew,PrpCPcoinsDto.class));
            prpPcoinsDtoList.add(prpPcoinsDto);
        }
        blEndorseDto.setPrpPcoinsDtoList(prpPcoinsDtoList);
        blEndorseDto.setPrpCPcoinsDtoList(prpCPcoinsDtoList);
    }
    /**
     * @description 共保详细信息
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:20 2017/11/10
     */
    public  void generatePrpPcoinsDetail(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();

        if(blPolicyDtoOld.getPrpCcoinsDetailDtoList()==null||blPolicyDtoOld.getPrpCcoinsDetailDtoList().size()==0){
            return;
        }
        PrpCcoinsDetailDto prpCcoinsDetailDtoOld=null;
        PrpCcoinsDetailDto prpCcoinsDetailDtoNew=null;
        PrpPcoinsDetailDto prpPcoinsDetailDto=null;
        List<PrpPcoinsDetailDto> prpPcoinsDetailDtoList = new ArrayList<>();
        List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList = new ArrayList<>();
        double dbCoinsAmountOld = 0;
        double dbCoinsPremiumOld = 0;
        double dbAgentFeeOld = 0;
        double dbMiddleCostFeeOld = 0;
        double dbOperateFeeOld = 0;
        double dbCoinsAmountNew = 0;
        double dbCoinsPremiumNew = 0;
        double dbAgentFeeNew = 0;
        double dbMiddleCostFeeNew = 0;
        double dbOperateFeeNew = 0;
        int intOld=0;
        if(blPolicyDtoNew.getPrpCcoinsDetailDtoList().size()<blPolicyDtoOld.getPrpCcoinsDetailDtoList().size()){
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for(int i=0;i<blPolicyDtoNew.getPrpCcoinsDtoList().size();i++){
            prpCcoinsDetailDtoNew=blPolicyDtoNew.getPrpCcoinsDetailDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCcoinsDetailDtoNew.getFlag()) && prpCcoinsDetailDtoNew.getFlag().length()>0
                    && prpCcoinsDetailDtoNew.getFlag().charAt(0)=='I'){
                prpCcoinsDetailDtoOld=prpCcoinsDetailDtoNew;
            }else {
                prpCcoinsDetailDtoOld=blPolicyDtoOld.getPrpCcoinsDetailDtoList().get(intOld);
                intOld++;
            }
            prpCcoinsDetailDtoNew.setAgentNoTaxPremium(prpCcoinsDetailDtoOld.getAgentNoTaxPremium());
            prpCcoinsDetailDtoNew.setAgentTaxFee(prpCcoinsDetailDtoOld.getAgentTaxFee());
            prpCcoinsDetailDtoNew.setOperateTaxRate(prpCcoinsDetailDtoOld.getOperateTaxRate());
            prpCcoinsDetailDtoNew.setOperateNoTaxPremium(prpCcoinsDetailDtoOld.getOperateNoTaxPremium());
            prpCcoinsDetailDtoNew.setCoinsNoTaxPremium(prpCcoinsDetailDtoOld.getCoinsNoTaxPremium());
            prpCcoinsDetailDtoNew.setCoinsTaxFee(prpCcoinsDetailDtoOld.getCoinsTaxFee());

            prpPcoinsDetailDto=new PrpPcoinsDetailDto();
            prpPcoinsDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPcoinsDetailDto.setPolicyNo(prpCcoinsDetailDtoOld.getPolicyNo());
            prpPcoinsDetailDto.setSerialNo(prpCcoinsDetailDtoOld.getSerialNo());
            prpPcoinsDetailDto.setCoinsCode(prpCcoinsDetailDtoOld.getCoinsCode());
            prpPcoinsDetailDto.setCoinsName(prpCcoinsDetailDtoOld.getCoinsName());
            prpPcoinsDetailDto.setCurrency(prpCcoinsDetailDtoOld.getCurrency());
            prpPcoinsDetailDto.setCoinsAmount(prpCcoinsDetailDtoOld.getCoinsAmount());
            prpPcoinsDetailDto.setCoinsPremium(prpCcoinsDetailDtoOld.getCoinsPremium());
            prpPcoinsDetailDto.setAgentFee(prpCcoinsDetailDtoOld.getAgentFee());
            prpPcoinsDetailDto.setOperateFee(prpCcoinsDetailDtoOld.getOperateFee());
            prpPcoinsDetailDto.setFlag(prpCcoinsDetailDtoNew.getFlag());
            prpPcoinsDetailDto.setMiddleCostFee(prpCcoinsDetailDtoOld.getMiddleCostFee());
            prpPcoinsDetailDto.setAgentNoTaxPremium(prpCcoinsDetailDtoOld.getAgentNoTaxPremium());
            prpPcoinsDetailDto.setAgentTaxFee(prpCcoinsDetailDtoOld.getAgentTaxFee());
            prpPcoinsDetailDto.setOperateNoTaxPremium(prpCcoinsDetailDtoOld.getOperateNoTaxPremium());
            prpPcoinsDetailDto.setOperateTaxFee(prpCcoinsDetailDtoOld.getOperateTaxFee());
            prpPcoinsDetailDto.setCoinsNoTaxPremium(prpCcoinsDetailDtoOld.getCoinsNoTaxPremium());
            prpPcoinsDetailDto.setCoinsTaxFee(prpCcoinsDetailDtoOld.getCoinsTaxFee());
            if(StringUtils.isNotEmpty(prpCcoinsDetailDtoNew.getFlag()) && prpCcoinsDetailDtoNew.getFlag().length()>0){
                if(prpPcoinsDetailDto.getFlag().charAt(0)=='I'){
                    prpPcoinsDetailDto.setChgCoinsAmount(prpCcoinsDetailDtoNew.getCoinsPremium());
                    prpPcoinsDetailDto.setChgCoinsPremium(prpCcoinsDetailDtoNew.getCoinsPremium());
                    prpPcoinsDetailDto.setChgAgentFee(prpCcoinsDetailDtoNew.getAgentFee());
                    prpPcoinsDetailDto.setChgMiddleCostFee(prpCcoinsDetailDtoNew.getMiddleCostFee());
                    prpPcoinsDetailDto.setChgOperateFee(prpCcoinsDetailDtoNew.getOperateFee());
                }else {
                    dbCoinsAmountOld=Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoOld.getCoinsAmount())),2);
                    dbCoinsPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoOld.getCoinsPremium())),2);
                    dbAgentFeeOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoOld.getAgentFee())),2);
                    dbMiddleCostFeeOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoOld.getMiddleCostFee())),2);
                    dbOperateFeeOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoOld.getOperateFee())),2);
                    dbCoinsAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoNew.getCoinsAmount())),2);
                    dbCoinsPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoNew.getCoinsPremium())),2);
                    dbAgentFeeNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoNew.getAgentFee())),2);
                    dbMiddleCostFeeNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCcoinsDetailDtoNew.getMiddleCostFee())),2);

                    prpPcoinsDetailDto.setChgCoinsAmount(Str.round(dbCoinsAmountNew - dbCoinsAmountOld,2));
                    prpPcoinsDetailDto.setChgCoinsPremium(Str.round(dbCoinsPremiumNew - dbCoinsPremiumOld,2));
                    prpPcoinsDetailDto.setChgAgentFee(Str.round(dbAgentFeeNew - dbAgentFeeOld,2));
                    prpPcoinsDetailDto.setChgMiddleCostFee(Str.round(dbMiddleCostFeeNew - dbMiddleCostFeeOld,2));
                    prpPcoinsDetailDto.setChgOperateFee(Str.round(dbOperateFeeNew - dbOperateFeeOld,2));
                }
            }
            prpCPcoinsDetailDtoList.add(convert(prpCcoinsDetailDtoNew,PrpCPcoinsDetailDto.class));
            prpPcoinsDetailDtoList.add(prpPcoinsDetailDto);
        }
        blEndorseDto.setPrpPcoinsDetailDtoList(prpPcoinsDetailDtoList);
        blEndorseDto.setPrpCPcoinsDetailDtoList(prpCPcoinsDetailDtoList);
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    public  void generatePrpPengage(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        //将超长的行拆分为标准长度
        GeneratePrpEngageServiceImpl generatePrpEngageServiceImpl =new GeneratePrpEngageServiceImpl();
        List<PrpPengageDto> prpPengageDtoList=new ArrayList<>();
        blEndorseDto.setPrpPengageDtoList(prpPengageDtoList);
        PrpCengageDto[] arrCengageDto = generatePrpEngageServiceImpl.ungroup(blPolicyDtoNew);
        if(blPolicyDtoNew.getPrpCengageDtoList()==null){
            return;
        }
        int engagecounter =  blPolicyDtoNew.getPrpCengageDtoList().size();
        for (int j = 0; j < engagecounter; j++) {
            blPolicyDtoNew.getPrpCengageDtoList().remove(0);
        }
        for (int j = 0; j < arrCengageDto.length; j++) {
            blPolicyDtoNew.getPrpCengageDtoList().add(arrCengageDto[j]);
        }

        //Map<String,List<PrpCengageDto>>, key是serailNo，value是PrpCengageDto列表
        //对批改后的engage按serialNo分组
        Map newEngagesGroup = generatePrpEngageServiceImpl.getGroupedEngages(blPolicyDtoNew);
        //对批改前的engage按serialNo分组
        Map oldEngagesGroup = generatePrpEngageServiceImpl.getGroupedEngages(blPolicyDtoOld);

        Iterator iter = newEngagesGroup.keySet().iterator();
        while (iter.hasNext()) {
            int serialNo = (int)iter.next();
            //String serialNo = (String) iter.next();
            List newEngagesList = (List) newEngagesGroup.get(serialNo);
            if (newEngagesList == null || newEngagesList.size() == 0) {
                //应该不可能发生的，做一个校验
                throw new DataVerifyException("No engage in group[" + serialNo + "]");
            }

            //这里业务逻辑做一个假设：每一组中engage的批改标志flag都是一致的，要么全部是I，要么全部是D，U，只用取第一个就可以了。
            String flag = ((PrpCengageDto) newEngagesList.get(0)).getFlag();
            if (StringUtils.isNotEmpty(flag) && flag.length() > 0 && 'I' == flag.charAt(0)) {
                //如果是新增，那么p表应该添加这些项;
                generatePrpEngageServiceImpl.addPEngage(flag, newEngagesList,blEndorseDto);
            } else {
                //'U','D':更改或者删除的情况，p表应该相应的记录旧保单engage，但flag应该使用当前的flag
                List oldEngagesList = (List) oldEngagesGroup.get(serialNo);
                if (oldEngagesList != null) {
                    generatePrpEngageServiceImpl.addPEngage(flag, oldEngagesList,blEndorseDto);
                }
            }

        }
        List<PrpCPengageDto> prpCPengageDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCengageDtoList(),prpCPengageDtoList,PrpCPengageDto.class);
        blEndorseDto.setPrpCPengageDtoList(prpCPengageDtoList);
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    @Override
    public  void generatePrpPfee(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        PrpPfeeDto prpPfeeDto = null;
        PrpCfeeDto prpCfeeOldDto = null;
        PrpCfeeDto prpCfeeNewDto = null;
        GeneratePrpFeeServiceImpl generatePrpFeeServiceImpl =new GeneratePrpFeeServiceImpl();
        double dbAmountOld = 0;
        double dbPremiumOld = 0;
        double dbAmountNew = 0;
        double dbPremiumNew = 0;
        double dbChgAmount = 0;
        double dbChgPremium = 0;
        double dbChgAmount1 = 0;
        double dbChgPremium1 = 0;
        double dbChgAmount2 = 0;
        double dbChgPremium2 = 0;
        int icurr = 0;
        int i = 0;
        List<PrpCPfeeDto> prpCPfeeDtoList=new ArrayList<>();
        List<PrpPfeeDto> prpPfeeDtoList=new ArrayList<>();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数
        //因为在UI层的*GenerateObject.jsp将所有的数据都存在保单对象中（未修改、已修改、新增、删除）
        if (blPolicyDtoNew.getPrpCfeeDtoList().size() < blPolicyDtoOld.getPrpCfeeDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCfeeDtoList().size(); i++) {
            prpCfeeNewDto = blPolicyDtoNew.getPrpCfeeDtoList().get(i);
            //新增
            if (StringUtils.isNotEmpty(prpCfeeNewDto.getFlag())
                    && prpCfeeNewDto.getFlag().charAt(0) == 'I') {
                prpCfeeOldDto = prpCfeeNewDto;
                dbChgAmount = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount())),2);
                dbChgPremium = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium())),2);
                dbChgAmount1 = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount1())),2);
                dbChgPremium1 = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium1())),2);
                dbChgAmount2 = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount2())),2);
                dbChgPremium2 = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium2())),2);
            } else {
                icurr= generatePrpFeeServiceImpl.search(blPolicyDtoNew,blPolicyDtoNew.getPrpCfeeDtoList().get(i).getCurrency());
                if (icurr > -1) {
                    prpCfeeOldDto = blPolicyDtoOld.getPrpCfeeDtoList().get(icurr);
                    //原币
                    dbAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getAmount())),2);
                    dbPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getPremium())),2);
                    dbAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount())),2);
                    dbPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium())),4);
                    dbChgAmount = Str.round(dbAmountNew - dbAmountOld,2);
                    dbChgPremium = Str.round(dbPremiumNew - dbPremiumOld,4);
                    //保单汇总币别
                    dbAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getAmount1())),2);
                    dbPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getPremium1())),2);
                    dbAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount1())),2);
                    dbPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium1())),4);
                    dbChgAmount1 = Str.round(dbAmountNew - dbAmountOld,2);
                    dbChgPremium1 = Str.round(dbPremiumNew - dbPremiumOld,4);
                    //支付保费币别
                    dbAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getAmount2())),2);
                    dbPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeOldDto.getPremium2())),2);
                    dbAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getAmount2())),2);
                    dbPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCfeeNewDto.getPremium2())),4);
                    dbChgAmount2 = Str.round(dbAmountNew - dbAmountOld,2);
                    dbChgPremium2 = Str.round(dbPremiumNew - dbPremiumOld,4);
                } else {
                    dbChgAmount = 0;
                    dbChgPremium = 0;
                    dbChgAmount1 = 0;
                    dbChgPremium1 = 0;
                    dbChgAmount2 = 0;
                    dbChgPremium2 = 0;
                }
            }
            //营改增添加-设值原值
            prpCfeeNewDto.setNoTaxPremium(prpCfeeOldDto.getNoTaxPremium());
            prpCfeeNewDto.setNoTaxPremium1(prpCfeeOldDto.getNoTaxPremium1());
            prpCfeeNewDto.setNoTaxPremium2(prpCfeeOldDto.getNoTaxPremium2());
            prpCfeeNewDto.setTaxFee(prpCfeeOldDto.getTaxFee());
            prpCfeeNewDto.setTaxFee1(prpCfeeOldDto.getTaxFee1());
            prpCfeeNewDto.setTaxFee2(prpCfeeOldDto.getTaxFee2());

            //因币别调整，PrpPfee表的存储逻辑变了
            //原来的存储逻辑是记录变化量，原来没有Amount、Premium字段，只有ChgAmount、ChgPremium字段
            //现在更改为，Fee表的数据也从UI层的*GenerateObject.jsp文件中获取，变化量由java处理
            prpPfeeDto = new PrpPfeeDto();
            prpPfeeDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPfeeDto.setPolicyNo(prpCfeeOldDto.getPolicyNo());
            prpPfeeDto.setRiskCode(prpCfeeOldDto.getRiskCode());
            prpPfeeDto.setCurrency(prpCfeeOldDto.getCurrency());
            prpPfeeDto.setAmount(prpCfeeOldDto.getAmount());
            prpPfeeDto.setPremium(prpCfeeOldDto.getPremium());
            prpPfeeDto.setCurrency1(prpCfeeOldDto.getCurrency1());
            prpPfeeDto.setExchangeRate1(prpCfeeOldDto.getExchangeRate1());
            prpPfeeDto.setAmount1(prpCfeeOldDto.getAmount1());
            prpPfeeDto.setPremium1(prpCfeeOldDto.getPremium1());
            prpPfeeDto.setCurrency2(prpCfeeOldDto.getCurrency2());
            prpPfeeDto.setExchangeRate2(prpCfeeOldDto.getExchangeRate2());
            prpPfeeDto.setAmount2(prpCfeeOldDto.getAmount2());
            prpPfeeDto.setPremium2(prpCfeeOldDto.getPremium2());
            prpPfeeDto.setFlag(prpCfeeNewDto.getFlag());
            //金额变化量赋值
            prpPfeeDto.setChgAmount(Str.round(dbChgAmount, 2));
            prpPfeeDto.setChgPremium(Str.round(dbChgPremium, 2));
            prpPfeeDto.setChgAmount1(Str.round(dbChgAmount1, 2));
            prpPfeeDto.setChgPremium1(Str.round(dbChgPremium1, 2));
            prpPfeeDto.setChgAmount2(Str.round(dbChgAmount2, 2));
            prpPfeeDto.setChgPremium2(Str.round(dbChgPremium2, 2));
            prpPfeeDto.setNoTaxPremium(prpCfeeOldDto.getNoTaxPremium());
            prpPfeeDto.setNoTaxPremium1(prpCfeeOldDto.getNoTaxPremium1());
            prpPfeeDto.setNoTaxPremium2(prpCfeeOldDto.getNoTaxPremium2());
            prpPfeeDto.setTaxFee(prpCfeeOldDto.getTaxFee());
            prpPfeeDto.setTaxFee1(prpCfeeOldDto.getTaxFee1());
            prpPfeeDto.setTaxFee2(prpCfeeOldDto.getTaxFee2());
            prpPfeeDtoList.add(prpPfeeDto);
        }
        blEndorseDto.setPrpPfeeDtoList(prpPfeeDtoList);
        convertCollection(blPolicyDtoNew.getPrpCengageDtoList(),prpCPfeeDtoList,PrpCPfeeDto.class);
        blEndorseDto.setPrpCPfeeDtoList(prpCPfeeDtoList);
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    public  void generatePrpPhead(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        blEndorseDto.getPrpPheadDto().setPolicyNo(blPolicyDtoNew.getPrpCmainDto().getPolicyNo());
        blEndorseDto.getPrpPheadDto().setPrintNo("");
        blEndorseDto.getPrpPheadDto().setClassCode(blPolicyDtoNew.getPrpCmainDto().getClassCode());
        blEndorseDto.getPrpPheadDto().setRiskCode(blPolicyDtoNew.getPrpCmainDto().getRiskCode());
        //xiaojian_leave：从业务系统中的文件看，PrpPhead中的批改次数和PrpPmain中的批改次数一致，都是旧的
        //blEndorseDto.getPrpPheadDto().setEndorseTimes(blPolicyDtoOld.getPrpCmainDto().getEndorseTimes());
        blEndorseDto.getPrpPheadDto().setInsuredCode(blPolicyDtoNew.getPrpCmainDto().getInsuredCode());
        blEndorseDto.getPrpPheadDto().setInsuredName(blPolicyDtoNew.getPrpCmainDto().getInsuredName());
        blEndorseDto.getPrpPheadDto().setLanguage(blPolicyDtoNew.getPrpCmainDto().getLanguage());
        blEndorseDto.getPrpPheadDto().setPolicyType(blPolicyDtoNew.getPrpCmainDto().getPolicyType());
        blEndorseDto.getPrpPheadDto().setHandlerCode(blPolicyDtoNew.getPrpCmainDto().getHandlerCode());
        blEndorseDto.getPrpPheadDto().setHandler1Code(blPolicyDtoNew.getPrpCmainDto().getHandler1Code());
        blEndorseDto.getPrpPheadDto().setApproverCode(blPolicyDtoNew.getPrpCmainDto().getApproverCode());
        blEndorseDto.getPrpPheadDto().setVersionNo(blPolicyDtoNew.getPrpCmainDto().getVersionNo());
        blEndorseDto.getPrpPheadDto().setUnderwriteCode("");
        blEndorseDto.getPrpPheadDto().setUnderwriteName("");
        blEndorseDto.getPrpPheadDto().setComCode(blPolicyDtoNew.getPrpCmainDto().getComCode());
        blEndorseDto.getPrpPheadDto().setAgentCode(blPolicyDtoNew.getPrpCmainDto().getAgentCode());
        blEndorseDto.getPrpPheadDto().setStatisticSym(blPolicyDtoNew.getPrpCmainDto().getStatisticSym());
        blEndorseDto.getPrpPheadDto().setUnderwriteEndDate(null);
        blEndorseDto.getPrpPheadDto().setUnderwriteFlag("0");
        blEndorseDto.getPrpPheadDto().setFlag("");
        blEndorseDto.getPrpPheadDto().setMakeCom(blPolicyDtoNew.getPrpCmainDto().getMakeCom());
        if(blPolicyDtoOld.getPrpCmainDto().getEndorseTimes()==0){
            blEndorseDto.getPrpPheadDto().setEndorseTimes(blPolicyDtoOld.getPrpCmainDto().getEndorseTimes());
        }else {
            blEndorseDto.getPrpPheadDto().setEndorseTimes(blPolicyDtoOld.getPrpCmainDto().getEndorseTimes()+1);
        }
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    public  void generatePrpPinsured(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int i = 0;
        PrpPinsuredDto prpPinsuredDto = null;
        List<PrpPinsuredDto> prpPinsuredDtoList = new ArrayList<>();
        PrpCinsuredDto prpCinsuredOldDto = null;
        PrpCinsuredDto prpCinsuredNewDto = null;
        Hashtable oldInsuredHash = new Hashtable();
        List<PrpCPinsuredDto> prpCPinsuredDtoList=new ArrayList<>();
        for (i = 0; i < blPolicyDtoOld.getPrpCinsuredDtoList().size(); i++) {
            prpCinsuredOldDto = blPolicyDtoOld.getPrpCinsuredDtoList().get(i);
            oldInsuredHash.put(prpCinsuredOldDto.getSerialNo(),prpCinsuredOldDto);
        }
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCinsuredDtoList().size() < blPolicyDtoOld.getPrpCinsuredDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCinsuredDtoList().size(); i++) {
            prpCinsuredNewDto = blPolicyDtoNew.getPrpCinsuredDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCinsuredNewDto.getFlag()) && prpCinsuredNewDto.getFlag().length() > 0
                    && prpCinsuredNewDto.getFlag().charAt(0) == 'I') {
                prpCinsuredOldDto = prpCinsuredNewDto;
            } else {
                prpCinsuredOldDto = (PrpCinsuredDto) oldInsuredHash.get(prpCinsuredNewDto.getSerialNo());
            }
            prpPinsuredDto = new PrpPinsuredDto();
            prpPinsuredDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPinsuredDto.setPolicyNo(prpCinsuredOldDto.getPolicyNo());
            prpPinsuredDto.setRiskCode(prpCinsuredOldDto.getRiskCode());
            prpPinsuredDto.setRelateSerialNo(prpCinsuredOldDto.getRelateSerialNo());
            prpPinsuredDto.setSerialNo(prpCinsuredOldDto.getSerialNo());
            prpPinsuredDto.setLanguage(prpCinsuredOldDto.getLanguage());
            prpPinsuredDto.setInsuredType(prpCinsuredOldDto.getInsuredType());
            prpPinsuredDto.setInsuredCode(prpCinsuredOldDto.getInsuredCode());
            prpPinsuredDto.setInsuredName(prpCinsuredOldDto.getInsuredName());
            prpPinsuredDto.setInsuredAddress(prpCinsuredOldDto.getInsuredAddress());
            prpPinsuredDto.setInsuredNature(prpCinsuredOldDto.getInsuredNature());
            prpPinsuredDto.setInsuredFlag(prpCinsuredOldDto.getInsuredFlag());
            prpPinsuredDto.setInsuredIdentity(prpCinsuredOldDto.getInsuredIdentity());
            prpPinsuredDto.setIdentifyType(prpCinsuredOldDto.getIdentifyType());
            prpPinsuredDto.setIdentifyNumber(prpCinsuredOldDto.getIdentifyNumber());
            prpPinsuredDto.setCreditLevel(prpCinsuredOldDto.getCreditLevel());
            prpPinsuredDto.setPossessNature(prpCinsuredOldDto.getPossessNature());
            prpPinsuredDto.setBusinessSource(prpCinsuredOldDto.getBusinessSource());
            prpPinsuredDto.setBusinessSort(prpCinsuredOldDto.getBusinessSort());
            prpPinsuredDto.setOccupationCode(prpCinsuredOldDto.getOccupationCode());
            prpPinsuredDto.setEducationCode(prpCinsuredOldDto.getEducationCode());
            prpPinsuredDto.setBank(prpCinsuredOldDto.getBank());
            prpPinsuredDto.setAccount(prpCinsuredOldDto.getAccount());
            prpPinsuredDto.setLinkerName(prpCinsuredOldDto.getLinkerName());
            prpPinsuredDto.setPostAddress(prpCinsuredOldDto.getPostAddress());
            prpPinsuredDto.setPostCode(prpCinsuredOldDto.getPostCode());
            prpPinsuredDto.setPhoneNumber(prpCinsuredOldDto.getPhoneNumber());
            prpPinsuredDto.setMobile(prpCinsuredOldDto.getMobile());
            prpPinsuredDto.setEmail(prpCinsuredOldDto.getEmail());
            prpPinsuredDto.setBenefitRate(prpCinsuredOldDto.getBenefitRate());
            prpPinsuredDto.setBenefitFlag(prpCinsuredOldDto.getBenefitFlag());
            prpPinsuredDto.setFlag(prpCinsuredNewDto.getFlag());
            prpPinsuredDto.setRiskLevel(prpCinsuredOldDto.getRiskLevel());

            prpPinsuredDto.setIsCareClaim(prpCinsuredOldDto.getIsCareClaim());
            prpPinsuredDto.setCashFocus(prpCinsuredOldDto.getCashFocus());
            prpPinsuredDto.setValidPeriod3(prpCinsuredOldDto.getValidPeriod3());
            prpPinsuredDto.setJobTitle(prpCinsuredOldDto.getJobTitle());
            prpPinsuredDto.setNationality(prpCinsuredOldDto.getNationality());
            prpPinsuredDto.setBusinessCode(prpCinsuredOldDto.getBusinessCode());
            prpPinsuredDto.setRevenueRegistNo(prpCinsuredOldDto.getRevenueRegistNo());
            prpPinsuredDto.setBusinessValidPeriod(prpCinsuredOldDto.getBusinessValidPeriod());
            prpPinsuredDto.setRevenueRegistValidPeriod(prpCinsuredOldDto.getRevenueRegistValidPeriod());
            prpPinsuredDto.setOtherCodeNo(prpCinsuredOldDto.getOtherCodeNo());
            prpPinsuredDto.setOtherCodeValidPeriod(prpCinsuredOldDto.getOtherCodeValidPeriod());
            prpPinsuredDto.setSex(prpCinsuredOldDto.getSex());
            prpPinsuredDtoList.add(prpPinsuredDto);
        }
        blEndorseDto.setPrpPinsuredDtoList(prpPinsuredDtoList);
        convertCollection(blPolicyDtoNew.getPrpCinsuredDtoList(),prpCPinsuredDtoList,PrpCPinsuredDto.class);
        blEndorseDto.setPrpCPinsuredDtoList(prpCPinsuredDtoList);

    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    public  void generatePrpPitemKind(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        int i,j = 0;
        PrpPitemKindDto prpPitemKindDto = null;
        PrpCitemKindDto prpCitemKindOldDto = null;
        PrpCitemKindDto prpCitemKindNewDto = null;
        PrpCitemKindDto prpCitemKindDtoTmp = null;
        String strFlag = "";
        Hashtable hashItemKind = new Hashtable();
        List<PrpCPitemKindDto> prpCPitemKindDtoList =new ArrayList<>();
        List<PrpPitemKindDto> prpPitemKindDtoList =new ArrayList<>();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCitemKindDtoList().size() < blPolicyDtoOld.getPrpCitemKindDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        //将ItemKindNo与其Dto建立映射关系
        for (i = 0; i < blPolicyDtoOld.getPrpCitemKindDtoList().size(); i++) {
            prpCitemKindDtoTmp = blPolicyDtoOld.getPrpCitemKindDtoList().get(i);
            hashItemKind.put("" + prpCitemKindDtoTmp.getItemKindNo(),prpCitemKindDtoTmp);
        }
        //建立映射关系完毕
        //循环赋值
        for (i = 0; i < blPolicyDtoOld.getPrpCitemKindDtoList().size(); i++) {
            prpCitemKindNewDto = blPolicyDtoNew.getPrpCitemKindDtoList().get(i);
            //if(prpCitemKindNewDto.getFlag().length()>0 &&
            //   prpCitemKindNewDto.getFlag().charAt(0)=='I')
            if (StringUtils.isNotEmpty(prpCitemKindNewDto.getFlag()) && prpCitemKindNewDto.getFlag().length() > 0) {
                if (prpCitemKindNewDto.getFlag().charAt(0) == 'I') {
                    prpCitemKindOldDto = prpCitemKindNewDto;
                    prpCitemKindOldDto.setNoTaxPremium(0.00);//营改增-新增险别原值为0
                    prpCitemKindOldDto.setTaxFee(0.00);
                }else if(prpCitemKindNewDto.getFlag().charAt(0) == 'B'||prpCitemKindNewDto.getFlag().charAt(0) == 'D') {
                    prpCitemKindNewDto.setPremium(0.00);
                    prpCitemKindOldDto = (PrpCitemKindDto) hashItemKind.get(""
                            + prpCitemKindNewDto.getItemKindNo());
                } else
                    prpCitemKindOldDto = (PrpCitemKindDto) hashItemKind.get(""
                            + prpCitemKindNewDto.getItemKindNo());
                if (prpCitemKindOldDto == null) {
                    continue;
                }
            } else {
                //按主键ItemKindNo,PolicyNo找到对应的旧数据 (由于PolicyNo一样,不必比较)
                prpCitemKindOldDto = (PrpCitemKindDto) hashItemKind.get(""
                        + prpCitemKindNewDto.getItemKindNo());
                if (prpCitemKindOldDto == null) {
                    continue;
                }
            }
            //营改增添加-设值原值
            prpCitemKindNewDto.setNoTaxPremium(prpCitemKindOldDto.getNoTaxPremium());
            prpCitemKindNewDto.setTaxFee(prpCitemKindOldDto.getTaxFee());
            prpCitemKindNewDto.setTaxFlag(prpCitemKindOldDto.getTaxFlag());
            prpCitemKindNewDto.setTaxRate(prpCitemKindOldDto.getTaxRate());

            prpPitemKindDto = new PrpPitemKindDto();
            prpPitemKindDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPitemKindDto.setPolicyNo(prpCitemKindOldDto.getPolicyNo());
            prpPitemKindDto.setRiskCode(prpCitemKindOldDto.getRiskCode());
            prpPitemKindDto.setItemKindNo(prpCitemKindOldDto.getItemKindNo());
            prpPitemKindDto.setFamilyNo(prpCitemKindOldDto.getFamilyNo());
            prpPitemKindDto.setFamilyName(prpCitemKindOldDto.getFamilyName());
            prpPitemKindDto.setKindCode(prpCitemKindOldDto.getKindCode());
            prpPitemKindDto.setKindName(prpCitemKindOldDto.getKindName());
            prpPitemKindDto.setRationType(prpCitemKindOldDto.getRationType());
            prpPitemKindDto.setItemNo(prpCitemKindOldDto.getItemNo());
            prpPitemKindDto.setItemCode(prpCitemKindOldDto.getItemCode());
            prpPitemKindDto.setItemDetailName(prpCitemKindOldDto.getItemDetailName());
            prpPitemKindDto.setModeCode(prpCitemKindOldDto.getModeCode());
            prpPitemKindDto.setModeName(prpCitemKindOldDto.getModeName());
            prpPitemKindDto.setStartDate(prpCitemKindOldDto.getStartDate());
            prpPitemKindDto.setStartHour(prpCitemKindOldDto.getStartHour());
            prpPitemKindDto.setEndDate(prpCitemKindOldDto.getEndDate());
            prpPitemKindDto.setEndHour(prpCitemKindOldDto.getEndHour());
            prpPitemKindDto.setModel(prpCitemKindOldDto.getModel());
            prpPitemKindDto.setBuyDate(prpCitemKindOldDto.getBuyDate());
            prpPitemKindDto.setAddressNo(prpCitemKindOldDto.getAddressNo());
            prpPitemKindDto.setCalculateFlag(prpCitemKindOldDto.getCalculateFlag());
            prpPitemKindDto.setCurrency(prpCitemKindOldDto.getCurrency());
            prpPitemKindDto.setUnitAmount(prpCitemKindOldDto.getUnitAmount());
            prpPitemKindDto.setQuantity(prpCitemKindOldDto.getQuantity());
            prpPitemKindDto.setUnit(prpCitemKindOldDto.getUnit());
            prpPitemKindDto.setValue(prpCitemKindOldDto.getValue());
            prpPitemKindDto.setAmount(prpCitemKindOldDto.getAmount());
            prpPitemKindDto.setRatePeriod(prpCitemKindOldDto.getRatePeriod());
            prpPitemKindDto.setRate(prpCitemKindOldDto.getRate());
            prpPitemKindDto.setShortRateFlag(prpCitemKindOldDto.getShortRateFlag());
            prpPitemKindDto.setShortRate(prpCitemKindOldDto.getShortRate());
            prpPitemKindDto.setBasePremium(prpCitemKindOldDto.getBasePremium());
            prpPitemKindDto.setBenchmarkPremium(prpCitemKindOldDto.getBenchmarkPremium());
            prpPitemKindDto.setDiscount(prpCitemKindOldDto.getDiscount());
            prpPitemKindDto.setAdjustRate(prpCitemKindOldDto.getAdjustRate());
            prpPitemKindDto.setPremium(prpCitemKindOldDto.getPremium());
            prpPitemKindDto.setTriggerPoint(prpCitemKindOldDto.getTriggerPoint());
            prpPitemKindDto.setTotalLossRatio(prpCitemKindOldDto.getTotalLossRatio());
            prpPitemKindDto.setDeductibleRate(prpCitemKindOldDto.getDeductibleRate());
            prpPitemKindDto.setDeductible(prpCitemKindOldDto.getDeductible());
            prpPitemKindDto.setRegionRate(prpCitemKindOldDto.getRegionRate());
            prpPitemKindDto.setDrinkRate(prpCitemKindOldDto.getDrinkRate());
            prpPitemKindDto.setDrunkRate(prpCitemKindOldDto.getDrunkRate());
            //prpPitemKindDto.setAgeSub(prpCitemKindOldDto.getAgeSub());
            prpPitemKindDto.setUnitDayAmountSub(prpCitemKindOldDto.getUnitDayAmountSub());
            prpPitemKindDto.setDaySub(prpCitemKindOldDto.getDaySub());
            prpPitemKindDto.setCattleType(prpCitemKindOldDto.getCattleType());
            prpPitemKindDto.setUnitPersonLimitAmount(prpCitemKindOldDto.getUnitPersonLimitAmount());
            prpPitemKindDto.setUnitPersonAmount(prpCitemKindOldDto.getUnitPersonAmount());
            prpPitemKindDto.setPersonType(prpCitemKindOldDto.getPersonType());
            prpPitemKindDto.setLawsuitAmount(prpCitemKindOldDto.getLawsuitAmount());

            prpPitemKindDto.setBedNum(prpCitemKindOldDto.getBedNum());
            prpPitemKindDto.setBedPremium(prpCitemKindOldDto.getBedPremium());
            prpPitemKindDto.setHospitalPremium(prpCitemKindOldDto.getHospitalPremium());
            prpPitemKindDto.setKindWorkerNum(prpCitemKindOldDto.getKindWorkerNum());
            prpPitemKindDto.setKindWorkerPremium(prpCitemKindOldDto.getKindWorkerPremium());
            prpPitemKindDto.setClinicNum(prpCitemKindOldDto.getClinicNum());
            prpPitemKindDto.setClinicPremium(prpCitemKindOldDto.getClinicPremium());
            prpPitemKindDto.setnClinicNum(prpCitemKindOldDto.getnClinicNum());
            prpPitemKindDto.setnClinicPremium(prpCitemKindOldDto.getnClinicPremium());
            prpPitemKindDto.setRoomNum(prpCitemKindOldDto.getRoomNum());
            prpPitemKindDto.setRoomPremium(prpCitemKindOldDto.getRoomPremium());
            prpPitemKindDto.setNurseNum(prpCitemKindOldDto.getNurseNum());
            prpPitemKindDto.setNursePremium(prpCitemKindOldDto.getNursePremium());
            prpPitemKindDto.setWorkerPremium(prpCitemKindOldDto.getWorkerPremium());
            prpPitemKindDto.setWorkerNum(prpCitemKindOldDto.getWorkerNum());
            prpPitemKindDto.setQuantityNewborn(prpCitemKindOldDto.getQuantityNewborn());
            prpPitemKindDto.setChargeNewbornFlag(prpCitemKindOldDto.getChargeNewbornFlag());
            prpPitemKindDto.setUnitPremium(prpCitemKindOldDto.getUnitPremium());
            prpPitemKindDto.setOperationNum(prpCitemKindOldDto.getOperationNum());
            prpPitemKindDto.setOperationPremium(prpCitemKindOldDto.getOperationPremium());
            prpPitemKindDto.setMedicalRate(prpCitemKindOldDto.getMedicalRate());
            prpPitemKindDto.setPostRate(prpCitemKindOldDto.getPostRate());
            //营改增添加-设值P表数据
            prpPitemKindDto.setNoTaxPremium(prpCitemKindOldDto.getNoTaxPremium());
            prpPitemKindDto.setTaxFlag(prpCitemKindOldDto.getTaxFlag());
            prpPitemKindDto.setTaxRate(prpCitemKindOldDto.getTaxRate());
            prpPitemKindDto.setTaxFee(prpCitemKindOldDto.getTaxFee());
            prpPitemKindDto.setPremiumCalMethod(prpCitemKindOldDto.getPremiumCalMethod());
            prpPitemKindDto.setForestUse(prpCitemKindOldDto.getForestUse());

            //Flag字段
            if(prpCitemKindOldDto.getFlag()==null){
                prpCitemKindOldDto.setFlag("");
            }
            strFlag = prpCitemKindOldDto.getFlag();
            if (strFlag!=null&&strFlag.length() > 0) {
                strFlag = strFlag.substring(1);
            }
            if (prpCitemKindNewDto.getFlag()!=null&&prpCitemKindNewDto.getFlag().length() > 0) {
                strFlag = prpCitemKindNewDto.getFlag().charAt(0) + strFlag;
            }
            else {
                strFlag = " " + strFlag;
            }
            prpPitemKindDto.setFlag(strFlag);
            //变化量
            if (StringUtils.isNotEmpty(prpCitemKindNewDto.getFlag()) && prpCitemKindNewDto.getFlag().length() > 0) {
                if (prpPitemKindDto.getFlag().charAt(0) == 'I') {
                    prpPitemKindDto.setChgQuantity(prpCitemKindNewDto.getQuantity());
                    prpPitemKindDto.setChgAmount(prpCitemKindNewDto.getAmount());
                    prpPitemKindDto.setChgPremium(prpCitemKindNewDto.getPremium());
                    prpPitemKindDto.setChgUnitPremium(prpCitemKindNewDto.getUnitPremium());
                } else {
                    double dblQuantityNew =Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindNewDto.getQuantity())),2);
                    double dblQuantityOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindOldDto.getQuantity())),2);
                    double dblQuantity = Str.round(dblQuantityNew - dblQuantityOld,2);
                    prpPitemKindDto.setChgQuantity(dblQuantity);
                    double dblAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindNewDto.getAmount())),2);
                    double dblAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindOldDto.getAmount())),2);
                    double dblAmount = Str.round(dblAmountNew - dblAmountOld,2);
                    prpPitemKindDto.setChgAmount(dblAmount);
                    double dblPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindNewDto.getPremium())),4);
                    double dblPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindOldDto.getPremium())),4);
                    double dblPremium = Str.round(dblPremiumNew - dblPremiumOld,4);
                    prpPitemKindDto.setChgPremium(dblPremium);
                    //add by 夏天,河南险种添加单位保费批改
                    if(prpCitemKindNewDto.getUnitPremium()==null){
                        prpCitemKindNewDto.setUnitPremium(0.00);
                    }
                    if(prpCitemKindOldDto.getUnitPremium()==null){
                        prpCitemKindOldDto.setUnitPremium(0.00);
                    }
                    double dblUnitPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindNewDto.getUnitPremium())),4);
                    double dblUnitPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCitemKindOldDto.getUnitPremium())),4);
                    double dblUnitPremium = Str.round(dblUnitPremiumNew - dblUnitPremiumOld,4);
                    prpPitemKindDto.setChgUnitPremium(dblUnitPremium);
                }
            }
            prpPitemKindDtoList.add(prpPitemKindDto);
        }
        blEndorseDto.setPrpPitemKindDtoList(prpPitemKindDtoList);
        convertCollection(blPolicyDtoNew.getPrpCitemKindDtoList(), prpCPitemKindDtoList,PrpCPitemKindDto.class);
        blEndorseDto.setPrpCPitemKindDtoList(prpCPitemKindDtoList);
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:22 2017/11/10
     */
    public  void generatePrpPmain(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        PrpPmainDto prpPmainDto = null;
        PrpCmainDto prpCmainDtoOld = null;
        PrpCmainDto prpCmainDtoNew = null;
        double dbSumAmountOld = 0;
        double dbSumPremiumOld = 0;
        double dbSumAmountNew = 0;
        double dbSumPremiumNew = 0;
        double dbChgAmount = 0;
        double dbChgPremium = 0;
        double dbChgSumDiscount = 0;        //总折扣金额变化量
        double dbSumDiscountNew = 0;        //新的总折扣金额
        double dbSumDiscountOld = 0; 		//旧的总折扣金额
        double dbChgStatQuantity = 0;
        double dbChgInsured = 0;
        double dbStatQuantityOld = 0;
        double dbSumInsuredOld = 0;
        double dbStatQuantityNew = 0;
        double dbSumInsuredNew = 0;
        double dbChgQuantity = 0;//变化的数量
        double dbSumQuantityNew = 0;//新数量
        double dbSumQuantityOld = 0;//旧数量
        double dbChgLimitAmount=0;//变化的事故责任限额
        double dbLimitAmountNew=0;//新事故责任限额
        double dbLimitAmountOld=0;//旧事故责任限额
        double dbChgBasePerformanceRate = 0D ; //绩效比例变化量
        double dbBasePerformanceRateNew = 0D ; //新绩效比例
        double dbBasePerformanceRateOld = 0D ; //旧绩效比例
        int intOld = 0;


        if (blPolicyDtoNew.getPrpCmainDto()==null) {
            throw new DataVerifyException("主表对象不可为空！");
        }

        prpCmainDtoNew = blPolicyDtoNew.getPrpCmainDto();
        if (prpCmainDtoNew.getFlag()!=null&&prpCmainDtoNew.getFlag().length() > 0 && prpCmainDtoNew.getFlag().charAt(0) == 'I') {
            prpCmainDtoOld = prpCmainDtoNew;
            dbChgAmount = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumAmount())),2);
            dbChgPremium = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumPremium())),2);
            dbChgStatQuantity = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getStatQuantity())),2);
            dbChgInsured = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumInsured())),2);
            dbChgQuantity = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumQuantity())),2);
            dbChgSumDiscount = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumDiscount())),2);
            dbChgLimitAmount=Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getLimitAmount())),2);
            dbChgBasePerformanceRate=Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getBasePerformanceRate())),4);
        } else {
            prpCmainDtoOld = blPolicyDtoOld.getPrpCmainDto();
            dbSumAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getSumAmount())),2);
            dbSumPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getSumPremium())),2);

            dbStatQuantityOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getStatQuantity())),2);
            dbSumInsuredOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getSumInsured())),2);

            dbSumAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumAmount())),2);
            dbSumPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumPremium())),4);

            dbStatQuantityNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getStatQuantity())),2);
            dbSumInsuredNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumInsured())),2);
            //增加汇总数量变化量的存储
            dbSumQuantityNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumQuantity())),2);
            dbSumQuantityOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getSumQuantity())),2);

            dbLimitAmountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getLimitAmount())),2);
            dbLimitAmountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getLimitAmount())),2);

            dbBasePerformanceRateNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getBasePerformanceRate())),4);
            dbBasePerformanceRateOld = Str.round(Double.parseDouble(pubTools.chgZero(0.0)),4);
            //总折扣金额变化量
            dbSumDiscountNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoNew.getSumDiscount())),2);
            dbSumDiscountOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainDtoOld.getSumDiscount())),2);
            dbChgSumDiscount = Str.round(dbSumDiscountNew - dbSumDiscountOld,2);
            dbChgAmount = Str.round(dbSumAmountNew - dbSumAmountOld,2);
            dbChgPremium = Str.round(dbSumPremiumNew - dbSumPremiumOld,4);
            dbChgStatQuantity = Str.round(dbStatQuantityNew - dbStatQuantityOld,2);
            dbChgInsured = Str.round(dbSumInsuredNew - dbSumInsuredOld,2);
            dbChgLimitAmount=Str.round(dbLimitAmountNew - dbLimitAmountOld,2);
            dbChgBasePerformanceRate = Str.round(dbBasePerformanceRateNew - dbBasePerformanceRateOld,4);
            intOld++;
        }
        //-- 将prpCmainDtoNew某些字段恢复成原值
        prpCmainDtoNew.setProposalNo(prpCmainDtoOld.getProposalNo());
        //批改后的交费次数\复核人应与原保单相同
        prpCmainDtoNew.setPayTimes(prpCmainDtoOld.getPayTimes());
        prpCmainDtoNew.setApproverCode(prpCmainDtoOld.getApproverCode());
        prpCmainDtoNew.setEndorseTimes(prpCmainDtoOld.getEndorseTimes());
        prpCmainDtoNew.setClaimTimes(prpCmainDtoOld.getClaimTimes());
        prpCmainDtoNew.setUnderwriteCode(prpCmainDtoOld.getUnderwriteCode());
        prpCmainDtoNew.setUnderwriteName(prpCmainDtoOld.getUnderwriteName());
        prpCmainDtoNew.setOperatorCode(prpCmainDtoOld.getOperatorCode());
        prpCmainDtoNew.setInputDate(prpCmainDtoOld.getInputDate());
        prpCmainDtoNew.setInputHour(prpCmainDtoOld.getInputHour());
        prpCmainDtoNew.setUnderwriteEndDate(prpCmainDtoOld.getUnderwriteEndDate());
        prpCmainDtoNew.setUnderwriteFlag(prpCmainDtoOld.getUnderwriteFlag());
        //营改增添加-设值原值
        prpCmainDtoNew.setSumNoTaxPremium(prpCmainDtoOld.getSumNoTaxPremium());//营改增添加-设值原值
        prpCmainDtoNew.setSumTaxFee(prpCmainDtoOld.getSumTaxFee());
            /* 该字段不能恢复为原值 */
        //prpCmainDtoNew.setOthFlag (prpCmainDtoOld.getOthFlag ());
        prpPmainDto = new PrpPmainDto();
        prpPmainDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
        prpPmainDto.setPolicyNo(prpCmainDtoOld.getPolicyNo());
        prpPmainDto.setClassCode(prpCmainDtoOld.getClassCode());
        prpPmainDto.setRiskCode(prpCmainDtoOld.getRiskCode());
        prpPmainDto.setProposalNo(prpCmainDtoOld.getProposalNo());
        prpPmainDto.setContractNo(prpCmainDtoOld.getContractNo());
        prpPmainDto.setPolicySort(prpCmainDtoOld.getPolicySort());
        prpPmainDto.setPrintNo(prpCmainDtoOld.getPrintNo());
        prpPmainDto.setBusinessNature(prpCmainDtoOld.getBusinessNature());
        prpPmainDto.setLanguage(prpCmainDtoOld.getLanguage());
        prpPmainDto.setPolicyType(prpCmainDtoOld.getPolicyType());
        prpPmainDto.setPolicyBizType(prpCmainDtoOld.getPolicyBizType());
        prpPmainDto.setAppliCode(prpCmainDtoOld.getAppliCode());
        prpPmainDto.setAppliName(prpCmainDtoOld.getAppliName());
        prpPmainDto.setAppliAddress(prpCmainDtoOld.getAppliAddress());
        prpPmainDto.setInsuredCode(prpCmainDtoOld.getInsuredCode());
        prpPmainDto.setInsuredName(prpCmainDtoOld.getInsuredName());
        prpPmainDto.setInsuredAddress(prpCmainDtoOld.getInsuredAddress());
        prpPmainDto.setOperateDate(prpCmainDtoOld.getOperateDate());
        prpPmainDto.setStartDate(prpCmainDtoOld.getStartDate());
        prpPmainDto.setStartHour(prpCmainDtoOld.getStartHour());
        prpPmainDto.setEndDate(prpCmainDtoOld.getEndDate());
        prpPmainDto.setEndHour(prpCmainDtoOld.getEndHour());
        prpPmainDto.setPureRate(prpCmainDtoOld.getPureRate());
        prpPmainDto.setDisRate(prpCmainDtoOld.getDisRate());
        prpPmainDto.setDiscount(prpCmainDtoOld.getDiscount());
        prpPmainDto.setCurrency(prpCmainDtoOld.getCurrency());
        prpPmainDto.setSumValue(prpCmainDtoOld.getSumValue());
        prpPmainDto.setSumAmount(prpCmainDtoOld.getSumAmount());
        prpPmainDto.setSumDiscount(prpCmainDtoOld.getSumDiscount());
        prpPmainDto.setSumPremium(prpCmainDtoOld.getSumPremium());
        prpPmainDto.setSumSubPrem(prpCmainDtoOld.getSumSubPrem());
        prpPmainDto.setSumQuantity(prpCmainDtoOld.getSumQuantity());
        prpPmainDto.setJudicalScope(prpCmainDtoOld.getJudicalScope());
        prpPmainDto.setAutoTransRenewFlag(prpCmainDtoOld.getAutoTransRenewFlag());
        prpPmainDto.setArgueSolution(prpCmainDtoOld.getArgueSolution());
        prpPmainDto.setArbitBoardName(prpCmainDtoOld.getArbitBoardName());
        prpPmainDto.setPayTimes(prpCmainDtoOld.getPayTimes());
        prpPmainDto.setEndorseTimes(prpCmainDtoOld.getEndorseTimes());
        prpPmainDto.setClaimTimes(prpCmainDtoOld.getClaimTimes());
        prpPmainDto.setMakeCom(prpCmainDtoOld.getMakeCom());
        prpPmainDto.setOperateSite(prpCmainDtoOld.getOperateSite());
        prpPmainDto.setComCode(prpCmainDtoOld.getComCode());
        prpPmainDto.setHandlerCode(prpCmainDtoOld.getHandlerCode());
        prpPmainDto.setHandler1Code(prpCmainDtoOld.getHandler1Code());
        prpPmainDto.setApproverCode(prpCmainDtoOld.getApproverCode());
        prpPmainDto.setUnderwriteCode(prpCmainDtoOld.getUnderwriteCode());
        prpPmainDto.setUnderwriteName(prpCmainDtoOld.getUnderwriteName());
        prpPmainDto.setOperatorCode(prpCmainDtoOld.getOperatorCode());
        prpPmainDto.setInputDate(prpCmainDtoOld.getInputDate());
        prpPmainDto.setInputHour(prpCmainDtoOld.getInputHour());
        prpPmainDto.setUnderwriteEndDate(prpCmainDtoOld.getUnderwriteEndDate());
        prpPmainDto.setStatisticSym(prpCmainDtoOld.getStatisticSym());
        prpPmainDto.setAgentCode(prpCmainDtoOld.getAgentCode());
        prpPmainDto.setCoinsFlag(prpCmainDtoOld.getCoinsFlag());
        prpPmainDto.setReinsFlag(prpCmainDtoOld.getReinsFlag());
        prpPmainDto.setAllinsFlag(prpCmainDtoOld.getAllinsFlag());
        prpPmainDto.setIsUndwrtFlag(prpCmainDtoOld.getUnderwriteFlag());
        prpPmainDto.setOthFlag(prpCmainDtoOld.getOthFlag());
        prpPmainDto.setFlag(prpCmainDtoNew.getFlag());
        prpPmainDto.setChgAmount(dbChgAmount);
        prpPmainDto.setChgPremium(dbChgPremium);
        prpPmainDto.setChgSubPrem(0.00);
        prpPmainDto.setChgQuantity(Integer.parseInt(new DecimalFormat("0").format(dbChgQuantity)));
        prpPmainDto.setChgSumDiscount(dbChgSumDiscount);
        prpPmainDto.setDisRate1(prpCmainDtoOld.getDisRate1());
        prpPmainDto.setBusinessFlag(prpCmainDtoOld.getBusinessFlag());
        prpPmainDto.setPayMode(prpCmainDtoOld.getPayMode());
        prpPmainDto.setUpdaterCode(prpCmainDtoOld.getUpdaterCode());
        prpPmainDto.setUpdateDate(prpCmainDtoOld.getUpdateDate());
        prpPmainDto.setUpdateHour(prpCmainDtoOld.getUpdateHour());
        prpPmainDto.setSignDate(prpCmainDtoOld.getSignDate());
        prpPmainDto.setShareHolderFlag(prpCmainDtoOld.getShareholderFlag());
        prpPmainDto.setAgreementNo(prpCmainDtoOld.getAgreementNo());
        prpPmainDto.setInquiryNo(prpCmainDtoOld.getInquiryNo());
        prpPmainDto.setRemark(prpCmainDtoOld.getRemark());
        prpPmainDto.setManualType(prpCmainDtoOld.getManualType());
        prpPmainDto.setVisaCode(prpCmainDtoOld.getVisaCode());
        /**
         * 国元项目组 fenglei
         * 农险新统计制度增加字段BusinessType;BusinessType1;UnitCode;StatQuantity;StatUnitCode;SumInsured;ChgStatQuantity;ChgInsured
         */
        prpPmainDto.setBusinessType(prpCmainDtoOld.getBusinessType());
        prpPmainDto.setBusinessType1(prpCmainDtoOld.getBusinessType1());
        prpPmainDto.setUnitCode(prpCmainDtoOld.getUnitCode());
        prpPmainDto.setStatQuantity(prpCmainDtoOld.getStatQuantity());
        prpPmainDto.setStatUnitCode(prpCmainDtoOld.getStatUnitCode());

        prpPmainDto.setSumInsured(prpCmainDtoOld.getSumInsured());
        prpPmainDto.setChgStatQuantity(dbChgStatQuantity);
        prpPmainDto.setChgInsured(dbChgInsured);
        //健康险统计制度增加字段记录专项信息
        prpPmainDto.setArticleType(prpCmainDtoOld.getArticleType());

        prpPmainDto.setBusinessProvince(prpCmainDtoOld.getBusinessProvince());
        prpPmainDto.setBusinessTown(prpCmainDtoOld.getBusinessTown());
        prpPmainDto.setBusinessCounty(prpCmainDtoOld.getBusinessCounty());
        prpPmainDto.setBusinessAreaName(prpCmainDtoOld.getBusinessAreaName());
        prpPmainDto.setStartMinute(prpCmainDtoOld.getStartMinute());
        prpPmainDto.setEndMinute(prpCmainDtoOld.getEndMinute());
        prpPmainDto.setThirdKnow(prpCmainDtoOld.getThirdKnow());
        prpPmainDto.setNCarPerpFlag(prpCmainDtoOld.getnCarPerpFlag());
        prpPmainDto.setLimitAmount(prpCmainDtoOld.getLimitAmount());
        prpPmainDto.setAgentRemark(prpCmainDtoOld.getAgentRemark());
        prpPmainDto.setChgLimitAmount(dbChgLimitAmount);
        /**区域大户代码*/
        prpPmainDto.setRichFlyAreasCode(prpCmainDtoOld.getRichflyAreasCode());
        prpPmainDto.setRichFlyAreasCName(prpCmainDtoOld.getRichflyAreasCName());
        prpPmainDto.setRichFlyCode(prpCmainDtoOld.getRichflyCode());
        prpPmainDto.setRichFlyCName(prpCmainDtoOld.getRichflyCName());
        prpPmainDto.setGroupNo(prpCmainDtoOld.getGroupNo());
        prpPmainDto.setGroupFlag(prpCmainDtoOld.getGroupFlag());
        prpPmainDto.setBasePerformanceRate(prpCmainDtoOld.getBasePerformanceRate());
        prpPmainDto.setEncouragePerformanceRate(prpCmainDtoOld.getEncouragePerformanceRate());
        prpPmainDto.setSumRate(prpCmainDtoOld.getSumRate());
        prpPmainDto.setStandardRate(prpCmainDtoOld.getStandardRate());
        prpPmainDto.setChgBasePerformanceRate(dbChgBasePerformanceRate) ;
        prpPmainDto.setAgriFlag(prpCmainDtoOld.getAgriFlag());
        prpPmainDto.setVersionNo(prpCmainDtoOld.getVersionNo());
        prpPmainDto.setBigMedicalType(prpCmainDtoOld.getBigMedicalType());
        prpPmainDto.setEarningsRate(prpCmainDtoOld.getEarningsRate());
        prpPmainDto.setCoinsPremiumType(prpCmainDtoOld.getCoinsPremiumType());
        prpPmainDto.setBusinessCity(prpCmainDtoOld.getBusinessCity());
        prpPmainDto.setAllianceRate(prpCmainDtoOld.getAllianceRate());
        prpPmainDto.setBusinessArea(prpCmainDtoOld.getBusinessArea());

        prpPmainDto.setEccFlag(prpCmainDtoOld.getEccFlag()) ;
        prpPmainDto.setSsProposalNo(prpCmainDtoOld.getSsProposalNo());
        prpPmainDto.setBusinessYear(prpCmainDtoOld.getBusinessYear());
        prpPmainDto.setMakeArea(prpCmainDtoOld.getMakeArea());
        prpPmainDto.setTopCommisionRate(prpCmainDtoOld.getTopCommisionRate());
        prpPmainDto.setIntCommisionRate(prpCmainDtoOld.getIntCommisionRate());
        prpPmainDto.setSumNoTaxPremium(prpCmainDtoOld.getSumNoTaxPremium());
        prpPmainDto.setSumTaxFee(prpCmainDtoOld.getSumTaxFee());
        prpPmainDto.setNotificationFlag(prpCmainDtoOld.getNotificationFlag());
        prpPmainDto.setInceptionFlag(prpCmainDtoOld.getInceptionFlag());
        prpPmainDto.setSystemFlag("agri");
        blEndorseDto.setPrpPmainDto(prpPmainDto);
        blEndorseDto.setPrpCPmainDto(convert(prpCmainDtoNew,PrpCPmainDto.class));

    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPmainAgri(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        PrpPmainAgriDto prpPmainAgriDto = null;
        PrpCmainAgriDto prpCmainAgriOldDto = null;
        PrpCmainAgriDto prpCmainAgriNewDto = null;
        if (blPolicyDtoNew.getPrpCmainAgriDto()==null) {
            throw new DataVerifyException("mainAgri对象为空！");
        }

        prpCmainAgriNewDto = blPolicyDtoNew.getPrpCmainAgriDto();
        if (prpCmainAgriNewDto.getFlag()!=null&&prpCmainAgriNewDto.getFlag().length() > 0 && prpCmainAgriNewDto.getFlag().charAt(0) == 'I') {
            prpCmainAgriOldDto = prpCmainAgriNewDto;
        } else {
            prpCmainAgriOldDto = blPolicyDtoOld.getPrpCmainAgriDto();
        }
        prpPmainAgriDto = new PrpPmainAgriDto();
        prpPmainAgriDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
        prpPmainAgriDto.setPolicyNo(prpCmainAgriOldDto.getPolicyNo());
        prpPmainAgriDto.setFlag(prpCmainAgriNewDto.getFlag());
        prpPmainAgriDto.setInsureArea(prpCmainAgriOldDto.getInsureArea());
        prpPmainAgriDto.setObserveEndDate(prpCmainAgriOldDto.getObserveEndDate());
        prpPmainAgriDto.setObserveEndHour(prpCmainAgriOldDto.getObserveEndHour());
        prpPmainAgriDto.setDeptName(prpCmainAgriOldDto.getDeptName());
        prpPmainAgriDto.setDeptAddress(prpCmainAgriOldDto.getDeptAddress());
        prpPmainAgriDto.setAreaFlag(prpCmainAgriOldDto.getAreaFlag());
        prpPmainAgriDto.setObservePeriod(prpCmainAgriOldDto.getObservePeriod());
        prpPmainAgriDto.setObserveStartDate(prpCmainAgriOldDto.getObserveStartDate());
        prpPmainAgriDto.setObserveStartHour(prpCmainAgriOldDto.getObserveStartHour());
        prpPmainAgriDto.setRaiseDate(prpCmainAgriOldDto.getRaiseDate());
        prpPmainAgriDto.setRaiseSite(prpCmainAgriOldDto.getRaiseSite());
        prpPmainAgriDto.setRemark(prpCmainAgriOldDto.getRemark());
        prpPmainAgriDto.setRiskCode(prpCmainAgriOldDto.getRiskCode());
        prpPmainAgriDto.setValueRate(prpCmainAgriOldDto.getValueRate());
        prpPmainAgriDto.setSelfPremium(prpCmainAgriOldDto.getSelfPremium());
        double dblPremium =0;
        double dblPremiumNew=0;
        double dblPremiumOld=0;

        if (StringUtils.isNotEmpty(prpCmainAgriNewDto.getFlag()) && prpCmainAgriNewDto.getFlag().length() > 0 &&
                prpCmainAgriNewDto.getFlag().substring(0, 1).equals("I")) {
            dblPremium = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainAgriNewDto.getSelfPremium())),2);
        }else{
            dblPremiumNew = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainAgriNewDto.getSelfPremium())),2);
            dblPremiumOld = Str.round(Double.parseDouble(pubTools.chgZero(prpCmainAgriOldDto.getSelfPremium())),2);
            dblPremium=Str.round(dblPremiumNew-dblPremiumOld,2);
        }
        prpPmainAgriDto.setChgSelfPremium(dblPremium);
        prpPmainAgriDto.setRaiseType(prpCmainAgriOldDto.getRaiseType());
        prpPmainAgriDto.setRelationListNo(prpCmainAgriOldDto.getRelationListNo());
        prpPmainAgriDto.setRelationListNoRemark(prpCmainAgriOldDto.getRelationListNoRemark());

        blEndorseDto.setPrpPmainAgriDto(prpPmainAgriDto);
        blEndorseDto.setPrpCPmainAgriDto(convert(prpCmainAgriNewDto,PrpCPmainAgriDto.class));
    }
    /**
     * @description
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPplan(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PrpPplanDto prpPplanDto = null;
        PrpCplanDto prpCplanOldDto = null;
        PrpCplanDto prpCplanNewDto = null;
        List<PrpPplanDto> prpPplanDtoList = new ArrayList<>();

        int i = 0;
        int intOld = 0;

        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCplanDtoList().size() < blPolicyDtoOld.getPrpCplanDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCplanDtoList().size(); i++) {
            prpCplanNewDto = blPolicyDtoNew.getPrpCplanDtoList().get(i);
            if (prpCplanNewDto.getFlag()!=null &&prpCplanNewDto.getFlag().length() > 0 && prpCplanNewDto.getFlag().charAt(0) == 'I') {
                prpCplanOldDto = prpCplanNewDto;
            } else {
                prpCplanOldDto = blPolicyDtoOld.getPrpCplanDtoList().get(intOld);
                intOld++;
            }
            //营改增添加-设值原值
            prpCplanNewDto.setNoTaxPremium(prpCplanOldDto.getNoTaxPremium());//营改增添加-设值原值
            prpCplanNewDto.setTaxFee(prpCplanOldDto.getTaxFee());

            prpPplanDto = new PrpPplanDto();
            prpPplanDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPplanDto.setEndorseNo1(prpCplanOldDto.getEndorseNo());
            prpPplanDto.setPolicyNo(prpCplanOldDto.getPolicyNo());
            prpPplanDto.setSerialNo(i+1);
            prpPplanDto.setPayNo(prpCplanOldDto.getPayNo());
            prpPplanDto.setPayReason(prpCplanOldDto.getPayReason());
            prpPplanDto.setPlanDate(prpCplanOldDto.getPlanDate());
            prpPplanDto.setCurrency(prpCplanOldDto.getCurrency());
            prpPplanDto.setPlanFee(prpCplanOldDto.getPlanFee());
            prpPplanDto.setPlanRate(prpCplanOldDto.getPlanRate());
            prpPplanDto.setDelinquentFee(prpCplanOldDto.getDelinquentFee());
            prpPplanDto.setPlanStartDate(prpCplanOldDto.getPlanStartDate());
            prpPplanDto.setFlag(prpCplanNewDto.getFlag()); //标志用新的
            prpPplanDto.setNoTaxPremium(prpCplanOldDto.getNoTaxPremium());
            prpPplanDto.setTaxFee(prpCplanOldDto.getTaxFee());
            prpPplanDtoList.add(prpPplanDto);
        }
        blEndorseDto.setPrpPplanDtoList(prpPplanDtoList);
    }
    /**
     * generatePrpPplanCoins
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPplanCoins(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        PrpPplanCoinsDto prpPplanCoinsDto = null;
        PrpCplanCoinsDto prpCplanCoinsOldDto = null;
        PrpCplanCoinsDto prpCplanCoinsNewDto = null;
        List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList=new ArrayList<>();
        List<PrpPplanCoinsDto> prpPplanCoinsDtoList=new ArrayList<>();
        int i = 0;
        int intOld = 0;
        if(blPolicyDtoNew.getPrpCplanCoinsDtoList()==null){
            return;
        }
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCplanCoinsDtoList().size() < blPolicyDtoOld.getPrpCplanCoinsDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCplanCoinsDtoList().size(); i++) {
            prpCplanCoinsNewDto = blPolicyDtoNew.getPrpCplanCoinsDtoList().get(i);
            if (prpCplanCoinsNewDto.getFlag()!=null &&prpCplanCoinsNewDto.getFlag().length() > 0 && prpCplanCoinsNewDto.getFlag().charAt(0) == 'I') {
                prpCplanCoinsOldDto = prpCplanCoinsNewDto;
            } else {
                prpCplanCoinsOldDto = blPolicyDtoOld.getPrpCplanCoinsDtoList().get(intOld);
                intOld++;
            }
            //营改增添加-设值原值
            prpCplanCoinsNewDto.setNoTaxPremium(prpCplanCoinsOldDto.getNoTaxPremium());
            prpCplanCoinsNewDto.setTaxFee(prpCplanCoinsOldDto.getTaxFee());

            prpPplanCoinsDto = new PrpPplanCoinsDto();
            prpPplanCoinsDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPplanCoinsDto.setEndorseNo1(prpCplanCoinsOldDto.getEndorseNo());
            prpPplanCoinsDto.setPolicyNo(prpCplanCoinsOldDto.getPolicyNo());
            prpPplanCoinsDto.setCoinsCode(prpCplanCoinsOldDto.getCoinsCode());
            prpPplanCoinsDto.setSerialNo(prpCplanCoinsOldDto.getSerialNo());
            prpPplanCoinsDto.setPayNo(prpCplanCoinsOldDto.getPayNo());
            prpPplanCoinsDto.setPayReason(prpCplanCoinsOldDto.getPayReason());
            prpPplanCoinsDto.setPlanDate(prpCplanCoinsOldDto.getPlanDate());
            prpPplanCoinsDto.setCurrency(prpCplanCoinsOldDto.getCurrency());
            prpPplanCoinsDto.setPlanFee(prpCplanCoinsOldDto.getPlanFee());
            prpPplanCoinsDto.setPlanRate(prpCplanCoinsOldDto.getPlanRate());
            prpPplanCoinsDto.setDelinquentFee(prpCplanCoinsOldDto.getDelinquentFee());
            prpPplanCoinsDto.setPlanStartDate(prpCplanCoinsOldDto.getPlanStartDate());
            prpPplanCoinsDto.setFlag(prpCplanCoinsNewDto.getFlag()); //标志用新的
            prpPplanCoinsDto.setNoTaxPremium(prpCplanCoinsOldDto.getNoTaxPremium());
            prpPplanCoinsDto.setTaxFee(prpCplanCoinsOldDto.getTaxFee());
            prpPplanCoinsDtoList.add(prpPplanCoinsDto);
        }
        convertCollection(blPolicyDtoNew.getPrpCplanCoinsDtoList(),prpCPplanCoinsDtoList,PrpCPplanCoinsDto.class);
        blEndorseDto.setPrpCPplanCoinsDtoList(prpCPplanCoinsDtoList);
        blEndorseDto.setPrpPplanCoinsDtoList(prpPplanCoinsDtoList);
    }
    /**
     * generatePrpPexpense
     * @param blPolicyDtoOld, blPolicyDtoNew, blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPexpense(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PubTools pubTools = new PubTools();
        PrpCexpenseDto prpCexpenseOldDto = null;
        PrpCexpenseDto prpCexpenseNewDto = null;
        PrpPexpenseDto prpPexpenseDto = null;


        double dbPerformanceOld = 0;
        double dbPerformanceNew = 0;
        double dbChgBasePerformance = 0;
        double dbChgEncouragePerformance = 0;
        int intCurr = 0;
        int i = 0;

        if (blPolicyDtoNew.getPrpCexpenseDto()==null) {
            return;
        }
        prpCexpenseNewDto = blPolicyDtoNew.getPrpCexpenseDto();
        //新增对象的处理
        if (StringUtils.isNotEmpty(prpCexpenseNewDto.getFlag()) && prpCexpenseNewDto.getFlag().length() > 0 &&
                prpCexpenseNewDto.getFlag().substring(0, 1).equals("I")) {
            prpCexpenseOldDto = prpCexpenseNewDto;
            //修改、删除、未修改对象的处理
        } else {
            //intCurr =search(blPolicyDtoOld,prpCexpenseNewDto.getPolicyNo());
            if (intCurr < 0) {
                throw new DataVerifyException("generatePrpPexpense(BLPolicy, BLPolicy) - BLEndorse.generatePrpPexpense==========4244，search没有找到数据");
            } else {
                prpCexpenseOldDto = blPolicyDtoOld.getPrpCexpenseDto();
            }
        }
        prpPexpenseDto = new PrpPexpenseDto();
        prpPexpenseDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
        prpPexpenseDto.setPolicyNo(prpCexpenseOldDto.getPolicyNo());
        prpPexpenseDto.setRiskCode(prpCexpenseOldDto.getRiskCode());
        prpPexpenseDto.setManageFeeRate(prpCexpenseOldDto.getManageFeeRate());
        prpPexpenseDto.setMaxManageFeeRate(prpCexpenseOldDto.getMaxManageFeeRate());
        //add by luyang 救助基金比例 20060616
        prpPexpenseDto.setSalvationFee(prpCexpenseOldDto.getSalvationFee());
        prpPexpenseDto.setSalvationRate(prpCexpenseOldDto.getSalvationRate());
        prpPexpenseDto.setCurrency(prpCexpenseOldDto.getCurrency());
        prpPexpenseDto.setFlag(prpCexpenseNewDto.getFlag());

        prpPexpenseDto.setBasePerformanceRate(prpCexpenseOldDto.getBasePerformanceRate());
        prpPexpenseDto.setBasePerformance(prpCexpenseOldDto.getBasePerformance());
        prpPexpenseDto.setEncouragePerformanceRate(prpCexpenseOldDto.getEncouragePerformanceRate());
        prpPexpenseDto.setEncouragePerformance(prpCexpenseOldDto.getEncouragePerformance());
        prpPexpenseDto.setNoTaxFee(prpCexpenseOldDto.getNoTaxFee());
        prpPexpenseDto.setTaxFee(prpCexpenseOldDto.getTaxFee());
        prpPexpenseDto.setTaxRate(prpCexpenseOldDto.getTaxRate());

        //给ManageFeeRateChg赋值
        if (prpCexpenseNewDto.getFlag().length() > 0 &&
                prpCexpenseNewDto.getFlag().substring(0, 1).equals("I")) {
            dbChgBasePerformance = Double.parseDouble(pubTools.chgZero(prpCexpenseNewDto.getBasePerformance()));
            dbChgEncouragePerformance = Double.parseDouble(pubTools.chgZero(prpCexpenseNewDto.getEncouragePerformance()));
        } else {
            dbPerformanceNew = Double.parseDouble(pubTools.chgZero(prpCexpenseNewDto.getBasePerformance()));
            dbPerformanceOld = Double.parseDouble(pubTools.chgZero(prpCexpenseOldDto.getBasePerformance()));
            dbChgBasePerformance = dbPerformanceNew - dbPerformanceOld;
            dbPerformanceNew = Double.parseDouble(pubTools.chgZero(prpCexpenseNewDto.getEncouragePerformance()));
            dbPerformanceOld = Double.parseDouble(pubTools.chgZero(prpCexpenseOldDto.getEncouragePerformance()));
            dbChgEncouragePerformance = dbPerformanceNew - dbPerformanceOld;
        }

        prpPexpenseDto.setChgBasePerformance(dbChgBasePerformance);
        prpPexpenseDto.setChgEncouragePerformance(dbChgEncouragePerformance);
        blEndorseDto.setPrpPexpenseDto(prpPexpenseDto);
        blEndorseDto.setPrpCPexpenseDto(convert(prpCexpenseNewDto,PrpCPexpenseDto.class));

    }
    /**
     * @param blPolicyDtoOld,C表里的保单对象
     * @param blPolicyDtoNew, 前端传入的对象
     * @param blEndorseDto 要保存的对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPitemKindAgri(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto)throws Exception{
        int i = 0;
        //int intOld = 0;
        PrpPitemKindAgriDto prpPitemKindAgriDto = null;
        List<PrpPitemKindAgriDto> prpPitemKindAgriDtoList = new ArrayList<>();
        PrpCitemKindAgriDto prpPitemKindAgriOldDto = null;
        PrpCitemKindAgriDto prpCitemKindAgriNewDto = null;
        //modify by zhaoning20061221 begin reason:修改P表的取值顺序,让OldItemKindAgri和NewItemKindAgri一一对应
        PrpCitemKindAgriDto prpCitemKindAgriDtoTmp = null;
        Hashtable hashItemKind = new Hashtable();
        List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList=new ArrayList<>();
        //将ItemKindNo、Times与其Dto建立映射关系
        for (i = 0; i < blPolicyDtoOld.getPrpCitemKindAgriDtoList().size(); i++) {
            prpCitemKindAgriDtoTmp = blPolicyDtoOld.getPrpCitemKindAgriDtoList().get(i);
            hashItemKind.put("" + prpCitemKindAgriDtoTmp.getItemKindNo() + prpCitemKindAgriDtoTmp.getTimes(),prpCitemKindAgriDtoTmp);
        }
        //建立映射关系完毕
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCitemKindAgriDtoList().size() < blPolicyDtoOld.getPrpCitemKindAgriDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCitemKindAgriDtoList().size(); i++) {
            prpCitemKindAgriNewDto = blPolicyDtoNew.getPrpCitemKindAgriDtoList().get(i);
            if (prpCitemKindAgriNewDto.getFlag()!=null &&prpCitemKindAgriNewDto.getFlag().length() > 0 && prpCitemKindAgriNewDto.getFlag().charAt(0) == 'I') {
                prpPitemKindAgriOldDto = prpCitemKindAgriNewDto;
            } else {
                prpPitemKindAgriOldDto = (PrpCitemKindAgriDto)hashItemKind.get("" + prpCitemKindAgriNewDto.getItemKindNo() + prpCitemKindAgriNewDto.getTimes());

            }
            prpPitemKindAgriDto = new PrpPitemKindAgriDto();
            prpPitemKindAgriDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPitemKindAgriDto.setDepreciationRate(prpPitemKindAgriOldDto.getDepreciationRate());
            prpPitemKindAgriDto.setDiscountType(prpPitemKindAgriOldDto.getDiscountType());
            prpPitemKindAgriDto.setFlag(prpCitemKindAgriNewDto.getFlag());
            prpPitemKindAgriDto.setGrossQuantity(prpPitemKindAgriOldDto.getGrossQuantity());
            prpPitemKindAgriDto.setItemKindNo(prpPitemKindAgriOldDto.getItemKindNo());
            prpPitemKindAgriDto.setKindCode(prpPitemKindAgriOldDto.getKindCode());
            prpPitemKindAgriDto.setPolicyNo(prpPitemKindAgriOldDto.getPolicyNo());
            prpPitemKindAgriDto.setProportion(prpPitemKindAgriOldDto.getProportion());
            prpPitemKindAgriDto.setRemark(prpPitemKindAgriOldDto.getRemark());
            prpPitemKindAgriDto.setRiskCode(prpPitemKindAgriOldDto.getRiskCode());
            prpPitemKindAgriDto.setUnitAmount(prpPitemKindAgriOldDto.getUnitAmount());
            prpPitemKindAgriDto.setUnitCost(prpPitemKindAgriOldDto.getUnitCost());
            prpPitemKindAgriDto.setUnitOutput(prpPitemKindAgriOldDto.getUnitOutput());
            prpPitemKindAgriDto.setTimes(prpPitemKindAgriOldDto.getTimes());
            prpPitemKindAgriDto.setStratDate(prpPitemKindAgriOldDto.getStratDate());
            prpPitemKindAgriDto.setEndDate(prpPitemKindAgriOldDto.getEndDate());
            prpPitemKindAgriDto.setDistributingRate(prpPitemKindAgriOldDto.getDistributingRate());
            prpPitemKindAgriDto.setInsureArea(prpPitemKindAgriOldDto.getInsureArea());
            prpPitemKindAgriDto.setTimesAmount(prpPitemKindAgriOldDto.getTimesAmount());
            prpPitemKindAgriDtoList.add(prpPitemKindAgriDto);
        }
        blEndorseDto.setPrpPitemKindAgriDtoList(prpPitemKindAgriDtoList);
        convertCollection(blPolicyDtoNew.getPrpCitemKindAgriDtoList(),prpCPitemKindAgriDtoList,PrpCPitemKindAgriDto.class);
        blEndorseDto.setPrpCPitemKindAgriDtoList(prpCPitemKindAgriDtoList);
    }
    /**
     * @param blPolicyDtoOld,C表里的保单对象
     * @param blPolicyDtoNew, 前端传入的对象
     * @param blEndorseDto 要保存的对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPsubSidy(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int i = 0;
        int intOld = 0;
        PrpPsubsidyDto prpPsubsidyDto = null;
        List<PrpPsubsidyDto> prpPsubsidyDtoList = new ArrayList<>();
        PrpCsubsidyDto prppsubsidyOldDto = null;
        PrpCsubsidyDto prpCsubsidyNewDto = null;
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=new ArrayList<>();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCsubsidyDtoList().size() < blPolicyDtoOld.getPrpCsubsidyDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCsubsidyDtoList().size(); i++) {
            prpCsubsidyNewDto = blPolicyDtoNew.getPrpCsubsidyDtoList().get(i);
            if (prpCsubsidyNewDto.getOperationFlag()!=null &&prpCsubsidyNewDto.getOperationFlag().length() > 0 && prpCsubsidyNewDto.getOperationFlag().charAt(0) == 'I') {
                prppsubsidyOldDto = prpCsubsidyNewDto;
            } else {
                prppsubsidyOldDto = blPolicyDtoOld.getPrpCsubsidyDtoList().get(intOld);
                intOld++;
            }
            prpPsubsidyDto = new PrpPsubsidyDto();
            prpPsubsidyDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPsubsidyDto.setBenchmarkPremium(prppsubsidyOldDto.getBenchmarkPremium());
            prpPsubsidyDto.setClassCode(prppsubsidyOldDto.getClassCode());
            prpPsubsidyDto.setComCode(prppsubsidyOldDto.getComCode());
            prpPsubsidyDto.setContractNo(prppsubsidyOldDto.getContractNo());
            prpPsubsidyDto.setCurrency(prppsubsidyOldDto.getCurrency());
            prpPsubsidyDto.setOperationFlag(prppsubsidyOldDto.getOperationFlag());
            prpPsubsidyDto.setPolicyNo(prppsubsidyOldDto.getPolicyNo());
            prpPsubsidyDto.setRiskCode(prppsubsidyOldDto.getRiskCode());
            prpPsubsidyDto.setSubsidyCode(prppsubsidyOldDto.getSubsidyCode());
            prpPsubsidyDto.setSubsidyDepartment(prppsubsidyOldDto.getSubsidyDepartment());
            prpPsubsidyDto.setSubsidyName(prppsubsidyOldDto.getSubsidyName());
            prpPsubsidyDto.setSubsidyPremium(prppsubsidyOldDto.getSubsidyPremium());
            prpPsubsidyDto.setSubsidyRate(prppsubsidyOldDto.getSubsidyRate());
            prpPsubsidyDto.setSubsidyType(prppsubsidyOldDto.getSubsidyType());
            prpPsubsidyDto.setSubsidyTypeName(prppsubsidyOldDto.getSubsidyTypeName());
            prpPsubsidyDtoList.add(prpPsubsidyDto);
        }
        blEndorseDto.setPrpPsubsidyDtoList(prpPsubsidyDtoList);
        convertCollection(blPolicyDtoNew.getPrpCsubsidyDtoList(),prpCPsubsidyDtoList,PrpCPsubsidyDto.class);
        blEndorseDto.setPrpCPsubsidyDtoList(prpCPsubsidyDtoList);
    }
    /**
     * @param blPolicyDtoOld,C表里的保单对象
     * @param blPolicyDtoNew, 前端传入的对象
     * @param blEndorseDto 要保存的对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public  void generatePrpPfeild(ResponseQueryPolicyInfoDto blPolicyDtoOld,ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int i = 0;
        int intOld = 0;
        if(blPolicyDtoOld.getPrpCfeildDtoList()==null||blPolicyDtoOld.getPrpCfeildDtoList().size()==0){
            return;
        }
        PrpPfeildDto prpPfeildDto = null;
        List<PrpPfeildDto> prpPfeildDtoList = new ArrayList<>();
        PrpCfeildDto prppfeildOldDto = null;
        PrpCfeildDto prpCfeildNewDto = null;
        List<PrpCPfeildDto> prpCPfeildDtoList=new ArrayList<>();
        //新的保单中的对象个数应该大于等于旧的保单中的对象个数（因为删除的对象依旧记录在新的保单中）
        if (blPolicyDtoNew.getPrpCfeildDtoList().size() < blPolicyDtoOld.getPrpCfeildDtoList().size()) {
            throw new DataVerifyException("新保单对象个数不可小于旧保单对象个数！");
        }
        for (i = 0; i < blPolicyDtoNew.getPrpCfeildDtoList().size(); i++) {
            prpCfeildNewDto = blPolicyDtoNew.getPrpCfeildDtoList().get(i);
            if (prpCfeildNewDto.getOperationFlag()!=null &&prpCfeildNewDto.getOperationFlag().length() > 0 && prpCfeildNewDto.getOperationFlag().charAt(0) == 'I') {
                prppfeildOldDto = prpCfeildNewDto;
            } else {
                prppfeildOldDto = blPolicyDtoOld.getPrpCfeildDtoList().get(intOld);
                intOld++;
            }
            prpPfeildDto = new PrpPfeildDto();
            prpPfeildDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPfeildDto.setPolicyNo(prppfeildOldDto.getPolicyNo());
            prpPfeildDto.setFeildNo(prppfeildOldDto.getFeildNo());
            prpPfeildDto.setFeildName(prppfeildOldDto.getFeildName());
            prpPfeildDto.setFeildArea(prppfeildOldDto.getFeildArea());
            prpPfeildDto.setRichflyCode(prppfeildOldDto.getRichflyCode());
            prpPfeildDto.setRichflyCName(prppfeildOldDto.getRichflyCName());
            prpPfeildDto.setOperationFlag(prpCfeildNewDto.getOperationFlag());
            prpPfeildDtoList.add(prpPfeildDto);
        }
        blEndorseDto.setPrpPfeildDtoList(prpPfeildDtoList);
        convertCollection(blPolicyDtoNew.getPrpCfeildDtoList(),prpCPfeildDtoList,PrpCPfeildDto.class);
        blEndorseDto.setPrpCPfeildDtoList(prpCPfeildDtoList);
    }
    /**
     * @description
     * @param blPolicyDtoNew, 保单大对象  blEndorseDto ，批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 18:50 2017/12/5
     */
    @Override
    public void settleBeforeSave(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto) throws Exception {
        settlePrpPaddress(blPolicyDtoNew,blEndorseDto);
        settlePrpPcoins(blPolicyDtoNew,blEndorseDto);
        settlePrpPcoinsDetail(blPolicyDtoNew,blEndorseDto);
        settlePrpPengage(blPolicyDtoNew,blEndorseDto);
        settlePrpPfee(blPolicyDtoNew,blEndorseDto);
        settlePrpPinsured(blPolicyDtoNew,blEndorseDto);
        settlePrpPitemKind(blPolicyDtoNew,blEndorseDto);
        settlePrpPplan(blPolicyDtoNew,blEndorseDto);
        settlePrpPplanCoins(blPolicyDtoNew,blEndorseDto);
        settlePrpPexpense(blPolicyDtoNew,blEndorseDto);
        settlePrpPitemKindAgri(blPolicyDtoNew,blEndorseDto);
        settlePrpPsubSidy(blPolicyDtoNew,blEndorseDto);
        settlePrpPfeild(blPolicyDtoNew,blEndorseDto);
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public void settlePrpPaddress(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        if(blEndorseDto.getPrpPaddressDtoList()==null){
            return;
        }
        int lv_size = blEndorseDto.getPrpPaddressDtoList().size();
        PrpPaddressDto prpPaddressDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPaddressDto= blEndorseDto.getPrpPaddressDtoList().get(i);
            if(StringUtils.isEmpty(prpPaddressDto.getFlag())) {

                continue;
            }
            if(prpPaddressDto.getFlag().substring(0,1).equals("U") ||
                    prpPaddressDto.getFlag().substring(0,1).equals("I") ||
                    prpPaddressDto.getFlag().substring(0,1).equals("D")) {
                //在原有的基础上再赋值
                prpPaddressDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPaddressDtoList().add(prpPaddressDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPaddressDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        lv_size = blPolicyDtoNew.getPrpCaddressDtoList().size();
        PrpCaddressDto prpCaddressDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCaddressDto = blPolicyDtoNew.getPrpCaddressDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCaddressDto.getFlag()) && prpCaddressDto.getFlag().substring(0,1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCaddressDto.setFlag("");
                prpPaddressDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blPolicyDtoNew.getPrpCaddressDtoList().add(prpCaddressDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCaddressDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public void settlePrpPcoins(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        if(blEndorseDto.getPrpPcoinsDtoList()==null||blEndorseDto.getPrpPcoinsDtoList().size()==0){
            return;
        }
        //P表数据：变化量（修改、增加、删除）
        //xiaojian_leave：未修改的？
        int lv_size=0;
        if(blEndorseDto.getPrpPcoinsDtoList()!=null){
            lv_size = blEndorseDto.getPrpPcoinsDtoList().size();
        }
        PrpPcoinsDto prpPcoinsDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPcoinsDto= blEndorseDto.getPrpPcoinsDtoList().get(i);
            if(StringUtils.isEmpty(prpPcoinsDto.getFlag())) {
                continue;
            }
            if(prpPcoinsDto.getFlag().substring(0, 1).equals("U") ||
                    prpPcoinsDto.getFlag().substring(0, 1).equals("I") ||
                    prpPcoinsDto.getFlag().substring(0, 1).equals("B") ||
                    prpPcoinsDto.getFlag().substring(0, 1).equals("D")) {
                //在原有的基础上再赋值
                prpPcoinsDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPcoinsDtoList().add(prpPcoinsDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPcoinsDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        if(blPolicyDtoNew.getPrpCcoinsDtoList()!=null){
            lv_size = blPolicyDtoNew.getPrpCcoinsDtoList().size();
        }

        PrpCcoinsDto prpCcoinsDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCcoinsDto = blPolicyDtoNew.getPrpCcoinsDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCcoinsDto.getFlag()) && prpCcoinsDto.getFlag().substring(0, 1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCcoinsDto.setFlag("");
                blPolicyDtoNew.getPrpCcoinsDtoList().add(prpCcoinsDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCcoinsDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public void settlePrpPcoinsDetail(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        //P表数据：变化量（修改、增加、删除）
        //xiaojian_leave：未修改的？
        if(blEndorseDto.getPrpPcoinsDetailDtoList()==null||blEndorseDto.getPrpPcoinsDetailDtoList().size()==0){
            return;
        }
        int lv_size = blEndorseDto.getPrpPcoinsDetailDtoList().size();
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPcoinsDetailDto= blEndorseDto.getPrpPcoinsDetailDtoList().get(i);
            if(StringUtils.isEmpty(prpPcoinsDetailDto.getFlag())) {
                continue;
            }
            if(prpPcoinsDetailDto.getFlag().substring(0,1).equals("U") ||
                    prpPcoinsDetailDto.getFlag().substring(0,1).equals("I") ||
                    prpPcoinsDetailDto.getFlag().substring(0,1).equals("B") ||
                    prpPcoinsDetailDto.getFlag().substring(0,1).equals("D")) {
                //在原有的基础上再赋值
                prpPcoinsDetailDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPcoinsDetailDtoList().add(prpPcoinsDetailDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPcoinsDetailDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        if(blPolicyDtoNew.getPrpCcoinsDetailDtoList()!=null){
            lv_size = blPolicyDtoNew.getPrpCcoinsDetailDtoList().size();
        }

        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCcoinsDetailDto = blPolicyDtoNew.getPrpCcoinsDetailDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCcoinsDetailDto.getFlag()) && prpCcoinsDetailDto.getFlag().substring(0,1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCcoinsDetailDto.setFlag("");
                blPolicyDtoNew.getPrpCcoinsDetailDtoList().add(prpCcoinsDetailDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCcoinsDetailDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:23 2017/11/10
     */
    public void settlePrpPengage(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        if(blEndorseDto.getPrpPengageDtoList()==null||blEndorseDto.getPrpPengageDtoList().size()==0){
            return;
        }
        //p表标的信息整理
        int lv_size = blEndorseDto.getPrpPengageDtoList().size();
        PrpPengageDto prpPengageDto = null;
        for (int i = 0;i< lv_size;i++)
        {   prpPengageDto= blEndorseDto.getPrpPengageDtoList().get(i);
            if (StringUtils.isEmpty(prpPengageDto.getFlag()))
            {continue;}
            if (prpPengageDto.getFlag().substring(0,1).equals("I")||
                    prpPengageDto.getFlag().substring(0,1).equals("U")||
                    prpPengageDto.getFlag().substring(0,1).equals("D"))

            {
                prpPengageDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPengageDtoList().add(prpPengageDto);}
            else
            {continue;}
        }
        for (int i = 0;i<lv_size;i++) {
            blEndorseDto.getPrpPengageDtoList().remove(0);
        }
        //c表特别约定信息整理
        String strFlag = "";
        lv_size = blPolicyDtoNew.getPrpCengageDtoList().size();
        PrpCengageDto prpCengageDto = null;
        for (int i = 0;i<lv_size;i++)
        {  prpCengageDto = blPolicyDtoNew.getPrpCengageDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCengageDto.getFlag())&&prpCengageDto.getFlag().substring(0,1).equals("D")) {
            } else {
                prpCengageDto.setFlag("");
                blPolicyDtoNew.getPrpCengageDtoList().add(prpCengageDto);
            }
        }
        for (int i = 0;i<lv_size;i++) {
            blPolicyDtoNew.getPrpCengageDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPfee(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int lv_size = blEndorseDto.getPrpPfeeDtoList().size();
        PrpPfeeDto prpPfeeDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPfeeDto = blEndorseDto.getPrpPfeeDtoList().get(i);
            if(StringUtils.isEmpty(prpPfeeDto.getFlag())) {
                continue;
            }
            if(prpPfeeDto.getFlag().substring(0,1).equals("U") ||
                    prpPfeeDto.getFlag().substring(0,1).equals("I") ||
                    prpPfeeDto.getFlag().substring(0,1).equals("D")) {
                //在原有的基础上再赋值
                prpPfeeDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPfeeDtoList().add(prpPfeeDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPfeeDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        lv_size = blPolicyDtoNew.getPrpCfeeDtoList().size();
        PrpCfeeDto prpCfeeDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCfeeDto = blPolicyDtoNew.getPrpCfeeDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCfeeDto.getFlag()) && prpCfeeDto.getFlag().substring(0,1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCfeeDto.setFlag("");
                blPolicyDtoNew.getPrpCfeeDtoList().add(prpCfeeDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCfeeDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPinsured(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int lv_size = blEndorseDto.getPrpPinsuredDtoList().size();
        PrpPinsuredDto prpPinsuredDto = null;
        for (int i = 0;i< lv_size;i++)
        {  prpPinsuredDto= blEndorseDto.getPrpPinsuredDtoList().get(i);
            if (StringUtils.isEmpty(prpPinsuredDto.getFlag()))
            {continue;}
            if (prpPinsuredDto.getFlag().substring(0,1).equals("I")||
                    prpPinsuredDto.getFlag().substring(0,1).equals("U")||
                    prpPinsuredDto.getFlag().substring(0,1).equals("D"))
            {
                prpPinsuredDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPinsuredDtoList().add(prpPinsuredDto);}
            else
            {continue;}
        }
        for (int i = 0;i<lv_size;i++) {
            blEndorseDto.getPrpPinsuredDtoList().remove(0);
        }

        //c表被保险人信息整理
        lv_size = blPolicyDtoNew.getPrpCinsuredDtoList().size();
        PrpCinsuredDto prpCinsuredDto = null;
        for (int i = 0;i<lv_size;i++) {
            prpCinsuredDto = blPolicyDtoNew.getPrpCinsuredDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCinsuredDto.getFlag()) && prpCinsuredDto.getFlag().substring(0,1).equals("D")) {
            } else {
                prpCinsuredDto.setFlag("");
                blPolicyDtoNew.getPrpCinsuredDtoList().add(prpCinsuredDto);
            }
        }
        for (int i = 0;i<lv_size;i++) {
            blPolicyDtoNew.getPrpCinsuredDtoList().remove(0);
        }

    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPitemKind(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        // p表标的信息整理
        int lv_size = blEndorseDto.getPrpPitemKindDtoList().size();
        PrpPitemKindDto prpPitemKindDto = null;
        for (int i = 0; i < lv_size; i++) {
            prpPitemKindDto = blEndorseDto.getPrpPitemKindDtoList().get(i);
            if (StringUtils.isEmpty(prpPitemKindDto.getFlag())) {
                continue;
            }
            if (prpPitemKindDto.getFlag().substring(0, 1).equals("I")
                    || prpPitemKindDto.getFlag().substring(0, 1).equals("U")
                    || prpPitemKindDto.getFlag().substring(0, 1).equals("D")
                    || prpPitemKindDto.getFlag().substring(0, 1).equals("B")) {
                prpPitemKindDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPitemKindDtoList().add(prpPitemKindDto);
            } else {
                continue;
            }
        }
        for (int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPitemKindDtoList().remove(0);
        }
        // c表标的信息整理
        String strFlag = "";
        lv_size = blPolicyDtoNew.getPrpCitemKindDtoList().size();
        PrpCitemKindDto prpCitemKindDto = null;
        for (int i = 0; i < lv_size; i++) {
            prpCitemKindDto = blPolicyDtoNew.getPrpCitemKindDtoList().get(i);
            if (StringUtils.isEmpty(prpCitemKindDto.getFlag())) {
                blPolicyDtoNew.getPrpCitemKindDtoList().add(prpCitemKindDto);
            } else {
                strFlag = " " + prpCitemKindDto.getFlag().substring(1, prpCitemKindDto.getFlag().length());
                prpCitemKindDto.setFlag(strFlag);
                blPolicyDtoNew.getPrpCitemKindDtoList().add(prpCitemKindDto);
            }

        }
        for (int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCitemKindDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPplan(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PrpPplanDto prpPplanDto = null;
        PrpCplanDto prpCplanDto = null;

        //批改后将插入新的缴费计划，此时PrpCplan.EndorseNo应该有值，但在jsp文件中无法赋值，所以在此文件中处理
        String strEndorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();
        int intCount = 0;

        //P表数据：变化量（修改、增加、删除，没有未修改的）
        intCount = blEndorseDto.getPrpPplanDtoList().size(); //未处理前批单对象的Size，整理后按这个数量remove
        if(intCount==0){
            return;
        }
        for (int i = 0; i < intCount; i++) {
            prpPplanDto= blEndorseDto.getPrpPplanDtoList().get(i);
            if (StringUtils.isEmpty(prpPplanDto.getFlag())) {
                continue;
            }
            if (prpPplanDto.getFlag().substring(0,1).equals("U") ||
                    prpPplanDto.getFlag().substring(0,1).equals("I") ||
                    prpPplanDto.getFlag().substring(0,1).equals("D")) {
                //获得批单号
                if (!StringUtils.isEmpty(strEndorseNo)) {
                    prpPplanDto.setEndorseNo(strEndorseNo);
                }
                //在原有的基础上再赋值
                //prpPplanDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPplanDtoList().add(prpPplanDto);
            } else {
                continue;
            }
        }


        //只留下上面刚刚setArr的
        for (int i = 0; i < intCount; i++) {
            blEndorseDto.getPrpPplanDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        intCount = blPolicyDtoNew.getPrpCplanDtoList().size();//未处理前保单对象的Size，整理后按这个数量remove
        if(intCount==0){
            return;
        }
        for (int i = 0; i < intCount; i++) {
            prpCplanDto = blPolicyDtoNew.getPrpCplanDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCplanDto.getFlag()) &&
                    prpCplanDto.getFlag().substring(0,1).equals("D")) {
            } else {
                //C表EndorseNo赋值
                if (StringUtils.isNotEmpty(prpCplanDto.getFlag()) &&
                        prpCplanDto.getFlag().substring(0, 1).equals("I") &&
                        strEndorseNo.length() > 0&&"R10,RS3,RS4,RS5,RS6,RS7".indexOf(prpCplanDto.getPayReason())==-1 ) {
                    prpCplanDto.setEndorseNo(strEndorseNo);
                }
                //C表Flag赋空值
                prpCplanDto.setFlag("");
                blPolicyDtoNew.getPrpCplanDtoList().add(prpCplanDto);
            }
        }
        //只留下上面刚刚setArr的
        for (int i = 0; i < intCount; i++) {
            blPolicyDtoNew.getPrpCplanDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPplanCoins(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PrpPplanCoinsDto prpPplanCoinsDto = null;
        PrpCplanCoinsDto prpCplanCoinsDto = null;

        //批改后将插入新的缴费计划，此时PrpCplan.EndorseNo应该有值，但在jsp文件中无法赋值，所以在此文件中处理
        String strEndorseNo = "";
        int intCount = 0;

        //P表数据：变化量（修改、增加、删除，没有未修改的）
        if(blEndorseDto.getPrpPplanCoinsDtoList()==null||blEndorseDto.getPrpPplanCoinsDtoList().size()==0){
            return;
        }
        intCount = blEndorseDto.getPrpPplanCoinsDtoList().size(); //未处理前批单对象的Size，整理后按这个数量remove
        if(intCount==0){
            return;
        }
        for (int i = 0; i < intCount; i++) {
            prpPplanCoinsDto= blEndorseDto.getPrpPplanCoinsDtoList().get(i);
            if (StringUtils.isEmpty(prpPplanCoinsDto.getFlag())) {
                continue;
            }
            if (prpPplanCoinsDto.getFlag().substring(0,1).equals("U") ||
                    prpPplanCoinsDto.getFlag().substring(0,1).equals("I") ||
                    prpPplanCoinsDto.getFlag().substring(0, 1).equals("D") ||
                    prpPplanCoinsDto.getFlag().substring(0, 1).equals("B")) {
                //获得批单号
                if (strEndorseNo.length() == 0) {
                    strEndorseNo = prpPplanCoinsDto.getEndorseNo();
                }
                //在原有的基础上再赋值
                prpPplanCoinsDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPplanCoinsDtoList().add(prpPplanCoinsDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for (int i = 0; i < intCount; i++) {
            blEndorseDto.getPrpPplanCoinsDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        intCount = blPolicyDtoNew.getPrpCplanCoinsDtoList().size();//未处理前保单对象的Size，整理后按这个数量remove
        if(intCount==0){
            return;
        }
        for (int i = 0; i < intCount; i++) {
            prpCplanCoinsDto = blPolicyDtoNew.getPrpCplanCoinsDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCplanCoinsDto.getFlag()) &&
                    prpCplanCoinsDto.getFlag().substring(0,1).equals("D")) {
            } else {
                //C表EndorseNo赋值
                if (StringUtils.isNotEmpty(prpCplanCoinsDto.getFlag()) &&
                        prpCplanCoinsDto.getFlag().substring(0, 1).equals("I") &&
                        prpCplanCoinsDto.getEndorseNo().length() == 0 &&
                        strEndorseNo.length() > 0) {
                    prpCplanCoinsDto.setEndorseNo(strEndorseNo);
                }
                //C表Flag赋空值
                prpCplanCoinsDto.setFlag("");
                blPolicyDtoNew.getPrpCplanCoinsDtoList().add(prpCplanCoinsDto);
            }
        }
        //只留下上面刚刚setArr的
        for (int i = 0; i < intCount; i++) {
            blPolicyDtoNew.getPrpCplanCoinsDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPexpense(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        PrpCexpenseDto prpCexpenseDto = null;
        PrpPexpenseDto prpPexpenseDto = null;
        if(blEndorseDto.getPrpPexpenseDto()==null){
            return;
        }
        //P表数据：变化量（修改、增加、删除）
        prpPexpenseDto = blEndorseDto.getPrpPexpenseDto();
        if(StringUtils.isEmpty(prpPexpenseDto.getFlag())) {
            return;
        }
        if(prpPexpenseDto.getFlag().substring(0, 1).equals("U") ||
                prpPexpenseDto.getFlag().substring(0, 1).equals("I") ||
                prpPexpenseDto.getFlag().substring(0, 1).equals("D")) {
            prpPexpenseDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            blEndorseDto.setPrpPexpenseDto(prpPexpenseDto);
        }
        //C表数据：新数据（未修改、修改、增加，没有删除的）
        prpCexpenseDto = blPolicyDtoNew.getPrpCexpenseDto();
        if(prpCexpenseDto.getFlag().length() > 0 &&
                prpCexpenseDto.getFlag().substring(0, 1).equals("D")) {
        } else {
            if(prpCexpenseDto.getFlag().length()>1)
                prpCexpenseDto.setFlag(" "+prpCexpenseDto.getFlag().substring(1,2));
            else
                prpCexpenseDto.setFlag(" 0");
            blPolicyDtoNew.setPrpCexpenseDto(prpCexpenseDto);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPitemKindAgri(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        int lv_size = blEndorseDto.getPrpPitemKindAgriDtoList().size();
        PrpPitemKindAgriDto prpPitemKindAgriDto = null;
        for (int i = 0; i < lv_size; i++) {
            prpPitemKindAgriDto = blEndorseDto.getPrpPitemKindAgriDtoList().get(i);
            if (StringUtils.isEmpty(prpPitemKindAgriDto.getFlag())) {
                continue;
            }
            if (prpPitemKindAgriDto.getFlag().substring(0, 1).equals("U")
                    || prpPitemKindAgriDto.getFlag().substring(0, 1).equals(
                    "I")
                    || prpPitemKindAgriDto.getFlag().substring(0, 1).equals(
                    "D")
                    || prpPitemKindAgriDto.getFlag().substring(0, 1).equals(
                    "B")) {
                // 在原有的基础上再赋值
                prpPitemKindAgriDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPitemKindAgriDtoList().add(prpPitemKindAgriDto);
            } else {
                continue;
            }
        }
        // 只留下上面刚刚setArr的
        for (int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPitemKindAgriDtoList().remove(0);
        }

        // C表数据：新数据（未修改、修改、增加，没有删除的）
        lv_size = blPolicyDtoNew.getPrpCitemKindAgriDtoList().size();
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        for (int i = 0; i < lv_size; i++) {
            prpCitemKindAgriDto = blPolicyDtoNew.getPrpCitemKindAgriDtoList().get(i);
            if (StringUtils.isNotEmpty(prpCitemKindAgriDto.getFlag())
                    && prpCitemKindAgriDto.getFlag().substring(0, 1).equals(
                    "D")) {
                blPolicyDtoNew.getPrpCitemKindAgriDtoList().add(prpCitemKindAgriDto);
            } else {
                // C表Flag赋空值
                prpCitemKindAgriDto.setFlag("");
                blPolicyDtoNew.getPrpCitemKindAgriDtoList().add(prpCitemKindAgriDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCitemKindAgriDtoList().remove(0);
        }
    }
    /**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPsubSidy(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        if(blEndorseDto.getPrpPsubsidyDtoList()==null||blEndorseDto.getPrpPsubsidyDtoList().size()==0){
            return;
        }
        int lv_size = blEndorseDto.getPrpPsubsidyDtoList().size();
        PrpPsubsidyDto prpPsubsidyDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPsubsidyDto= blEndorseDto.getPrpPsubsidyDtoList().get(i);
            if(StringUtils.isEmpty(prpPsubsidyDto.getOperationFlag())) {
                continue;
            }
            if(     prpPsubsidyDto.getOperationFlag().substring(0,1).equals("U") ||
                    prpPsubsidyDto.getOperationFlag().substring(0,1).equals("I") ||
                    prpPsubsidyDto.getOperationFlag().substring(0,1).equals("D")) {
                //在原有的基础上再赋值
                prpPsubsidyDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPsubsidyDtoList().add(prpPsubsidyDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPsubsidyDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        lv_size = blPolicyDtoNew.getPrpCsubsidyDtoList().size();
        PrpCsubsidyDto prpCsubsidyDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCsubsidyDto = blPolicyDtoNew.getPrpCsubsidyDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCsubsidyDto.getOperationFlag()) && prpCsubsidyDto.getOperationFlag().substring(0,1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCsubsidyDto.setOperationFlag("");
                blPolicyDtoNew.getPrpCsubsidyDtoList().add(prpCsubsidyDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCsubsidyDtoList().remove(0);
        }
    }/**
     * @description
     * @param blPolicyDtoNew, blEndorseDto]
     * @return void
     * @throws
     * @author 李冬松
     * @date 14:24 2017/11/10
     */
    public void settlePrpPfeild(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        if(blEndorseDto.getPrpPfeildDtoList()==null||blEndorseDto.getPrpPfeildDtoList().size()==0){
            return;
        }
        int lv_size = blEndorseDto.getPrpPfeildDtoList().size();
        PrpPfeildDto prpPfeildDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpPfeildDto= blEndorseDto.getPrpPfeildDtoList().get(i);
            if(StringUtils.isEmpty(prpPfeildDto.getOperationFlag())) {
                continue;
            }
            if(     prpPfeildDto.getOperationFlag().substring(0,1).equals("U") ||
                    prpPfeildDto.getOperationFlag().substring(0,1).equals("I") ||
                    prpPfeildDto.getOperationFlag().substring(0,1).equals("D")) {
                //在原有的基础上再赋值
                prpPfeildDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
                blEndorseDto.getPrpPfeildDtoList().add(prpPfeildDto);
            } else {
                continue;
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blEndorseDto.getPrpPfeildDtoList().remove(0);
        }

        //C表数据：新数据（未修改、修改、增加，没有删除的）
        lv_size = blPolicyDtoNew.getPrpCfeildDtoList().size();
        PrpCfeildDto prpCfeildDto = null;
        for(int i = 0; i < lv_size; i++) {
            prpCfeildDto = blPolicyDtoNew.getPrpCfeildDtoList().get(i);
            if(StringUtils.isNotEmpty(prpCfeildDto.getOperationFlag()) && prpCfeildDto.getOperationFlag().substring(0,1).equals("D")) {
            } else {
                //C表Flag赋空值
                prpCfeildDto.setOperationFlag("");
                blPolicyDtoNew.getPrpCfeildDtoList().add(prpCfeildDto);
            }
        }
        //只留下上面刚刚setArr的
        for(int i = 0; i < lv_size; i++) {
            blPolicyDtoNew.getPrpCfeildDtoList().remove(0);
        }
    }
    /**
     * @description 更新批改次数
     * @param policyEndorseDto 保单批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 14:35 2017/11/11
     */
    @Override
    public void updateEndorseTimes(PolicyEndorseDto policyEndorseDto) throws Exception {
        SimpleDateFormat  fm=new SimpleDateFormat("yyyy-MM-dd");
        ResponseQueryPolicyInfoDto blPolicyDtoNew=policyEndorseDto.getBlPolicyInfoDtoNew();
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        int intEndorseTimes=policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCmainDto().getEndorseTimes();
 //       blEndorseDto.getPrpPheadDto().setEndorseTimes(intEndorseTimes-1);
        blEndorseDto.getPrpPheadDto().setValidCountDate(fm.parse("9999-12-31"));
        if(intEndorseTimes==0){
            blPolicyDtoNew.getPrpCmainDto().setEndorseTimes(intEndorseTimes);
        }else {
            blPolicyDtoNew.getPrpCmainDto().setEndorseTimes(intEndorseTimes+1);
        }

        blEndorseDto.getPrpPheadDto().setIsSeeFeeFlag(policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCmainDto().getIsSeeFeeFlag());
    }
    /**
     * 批单保存方法
     * @param  保单大对象, blEndorseDto 批单大对象
     * @return void
     * @throws Exception
     * @author 李冬松
     * @date 19:05 2017/12/5
     */
    @Override
    public void saveEndorseInfo(PolicyEndorseDto policyEndorseDto) throws Exception {
        BLEndorseDto blEndorseDto=policyEndorseDto.getBlEndorseDto();
        String endorseNo = blEndorseDto.getPrpPheadDto().getEndorseNo();
        ResponseQueryPolicyInfoDto blPolicyDtoNew=policyEndorseDto.getBlPolicyInfoDtoNew();

        //删除P表数据
        blpDataService.deleteP(endorseNo);
        // 给CP表赋值 1942行
        blcpDataService.evaluateFromCToCP(blPolicyDtoNew,blEndorseDto,policyEndorseDto.getBlPolicyInfoDtoOld());
        //营改增添加-批单价税分离
        generatePMainForYGZService.dealPMainForYGZ(blPolicyDtoNew,blEndorseDto);
        // 批单保存时对cp表的数据质量进行检查
        blEndorseCheckService.checkCPData(blEndorseDto);
        // 保存CP表 注意先删后插，删除方法在BLCPData的save方法第一行
        blcpDataService.saveCP(blEndorseDto);
        policyEndorseDto.setBlEndorseDto(blEndorseDto);
        //保存P表
        blpDataService.saveP(policyEndorseDto);
    }
}
