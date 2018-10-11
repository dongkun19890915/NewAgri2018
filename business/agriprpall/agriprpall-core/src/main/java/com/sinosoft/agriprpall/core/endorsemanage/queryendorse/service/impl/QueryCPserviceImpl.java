package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.*;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCPservice;
import com.sinosoft.dms.api.customer.PrpDcustomLevelTraceApi;
import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.api.dict.PrpCountryCodeApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.PrpTownCodeApi;
import com.sinosoft.dms.api.dict.dto.PrpCountryCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.dms.api.dict.dto.PrpTownCodeDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.PrpdclassApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureListDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *（通过保单号查询CP表信息实现类）
 * @Author: 李冬松
 * @Date: 2017/11/8 14:19
 */
@Service
public class QueryCPserviceImpl extends BaseServiceImpl implements QueryCPservice {
    @Autowired
    private PrpCPmainDao prpCPmainDao;
    @Autowired
    private PrpCPitemKindDao prpCPitemKindDao;

    @Autowired
    private PrpCPitemKindAgriDao prpCPitemKindAgriDao;
    @Autowired
    private PrpCPfeeDao prpCPfeeDao;
    @Autowired
    private PrpCPplanDao prpCPplanDao;
    @Autowired
    private PrpCPaddressDao prpCPaddressDao;
    @Autowired
    private PrpCPmainAgriDao prpCPmainAgriDao;

    @Autowired
    private PrpCPengageDao prpCPengageDao;
    @Autowired
    private PrpCPitemAgriDao prpCPitemAgriDao;
    @Autowired
    private PrpCPcoinsDao prpCPcoinsDao;
    @Autowired
    private PrpCPexpenseDao prpCPexpenseDao;
    @Autowired
    private PrpCPsubsidyDao prpCPsubsidyDao;
    @Autowired
    private PrpCPinsuredDao prpCPinsuredDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpTownCodeApi prpTownCodeApi;
    @Autowired
    private PrpCountryCodeApi prpCountryCodeApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;
    @Autowired
    private PrpdclassApi prpdclassApi;

    /**
    *  通过保单号查询CP表信息实现方法
    * @param policyNo  保单号
    * @return CPpolicyDto
    * @throws Exception
    * @author 李冬松
    * @date 9:53 2017/11/24
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CPpolicyDto queryCPolicyInfo(String policyNo) throws Exception {
        String languageFlag="zh-CN";
        CPpolicyDto cPpolicyDto=new CPpolicyDto();
        if(StringUtils.isEmpty(policyNo)){
            throw new Exception("保单号不能为空");
        }

        PrpCPmainKey prpCPmainKey=new PrpCPmainKey(policyNo);
        PrpCPmain prpCPmain=prpCPmainDao.findOne(prpCPmainKey);
        PrpCPmainDto prpCPmainDto=convert(prpCPmain,PrpCPmainDto.class);
        cPpolicyDto.setPrpCPmainDto(prpCPmainDto);

        List<PrpCPitemKind> prpCPitemKindList = prpCPitemKindDao.findPrpCPItemKindsByPolicyNo(policyNo);
        List<PrpCPitemKindDto> prpCPitemKindDtoList =new ArrayList<PrpCPitemKindDto>();
        convertCollection(prpCPitemKindList, prpCPitemKindDtoList,PrpCPitemKindDto.class);
        cPpolicyDto.setPrpCPitemKindDtoList(prpCPitemKindDtoList);

        List<PrpCPitemKindAgri> prpCPitemKindAgriList = prpCPitemKindAgriDao.findPrpCPItemKindAgriByPolicyNo(policyNo);
        List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList =new ArrayList<PrpCPitemKindAgriDto>();
        convertCollection(prpCPitemKindAgriList, prpCPitemKindAgriDtoList,PrpCPitemKindAgriDto.class);
        cPpolicyDto.setPrpCPitemKindAgriDtoList(prpCPitemKindAgriDtoList);

        List<PrpCPfee> prpCPfeeList=prpCPfeeDao.findPrpCPfeeByPolicyNo(policyNo);
        List<PrpCPfeeDto> prpCPfeeDtoList=new ArrayList<>();
        convertCollection(prpCPfeeList,prpCPfeeDtoList,PrpCPfeeDto.class);
        cPpolicyDto.setPrpCPfeeDtoList(prpCPfeeDtoList);

        List<PrpCPplan> prpCPplanList = prpCPplanDao.findPrpCPPlanByPolicyNo(policyNo);
        List<PrpCPplanDto> prpCPplanDtoList =new ArrayList<PrpCPplanDto>();
        convertCollection(prpCPplanList, prpCPplanDtoList,PrpCPplanDto.class);
        cPpolicyDto.setPrpCPplanDtoList(prpCPplanDtoList);

        List<PrpCPaddress> prpCPaddressList=prpCPaddressDao.findPrpCPaddressByPolicyNo(policyNo);
        List<PrpCPaddressDto> prpCPaddressDtoList=new ArrayList<PrpCPaddressDto>();
        convertCollection(prpCPaddressList,prpCPaddressDtoList,PrpCPaddressDto.class);
        cPpolicyDto.setPrpCPaddressDtoList(prpCPaddressDtoList);

        PrpCPmainAgriKey prpCPmainAgriKey=new PrpCPmainAgriKey(policyNo);
        PrpCPmainAgri prpCPmainAgri=prpCPmainAgriDao.findOne(prpCPmainAgriKey);
        PrpCPmainAgriDto prpCPmainAgriDto=convert(prpCPmainAgri,PrpCPmainAgriDto.class);
        cPpolicyDto.setPrpCPmainAgriDto(prpCPmainAgriDto);



        List<PrpCPengage> prpCPengageList = prpCPengageDao.queryAllByCondition(policyNo);
        List<PrpCPengageDto> prpCPengageDtoList =new ArrayList<>();
        convertCollection(prpCPengageList, prpCPengageDtoList,PrpCPengageDto.class);
        cPpolicyDto.setPrpCPengageDtoList(prpCPengageDtoList);


        List<PrpCPitemAgri> prpCPitemAgriList=prpCPitemAgriDao.queryAllByCondition(policyNo);
        List<PrpCPitemAgriDto> prpCPitemAgriDtoList=new ArrayList<>();
        convertCollection(prpCPitemAgriList,prpCPitemAgriDtoList,PrpCPitemAgriDto.class);
        cPpolicyDto.setPrpCPitemAgriDtoList(prpCPitemAgriDtoList);

        List<PrpCPcoins> prpCPcoinsList=prpCPcoinsDao.queryAllByCondition(policyNo);
        List<PrpCPcoinsDto> prpCPcoinsDtoList=new ArrayList<>();
        convertCollection(prpCPcoinsList,prpCPcoinsDtoList,PrpCPcoinsDto.class);
        cPpolicyDto.setPrpCPcoinsDtoList(prpCPcoinsDtoList);

        PrpCPexpense prpCPexpense = prpCPexpenseDao.queryAllByCondition(policyNo);
        cPpolicyDto.setPrpCPexpenseDto(convert(prpCPexpense,PrpCPexpenseDto.class));

        List<PrpCPsubsidy> prpCPsubsidyList=prpCPsubsidyDao.queryAllByCondition(policyNo);
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=new ArrayList<>();
        convertCollection(prpCPsubsidyList,prpCPsubsidyDtoList,PrpCPsubsidyDto.class);
        cPpolicyDto.setPrpCPsubsidyDtoList(prpCPsubsidyDtoList);

        List<PrpCPinsured> prpCPinsuredList=prpCPinsuredDao.queryAllByCondition(policyNo);
        List<PrpCPinsuredDto> prpCPinsuredDtoList=new ArrayList<>();
        convertCollection(prpCPinsuredList,prpCPinsuredDtoList,PrpCPinsuredDto.class);
        cPpolicyDto.setPrpCPinsuredDtoList(prpCPinsuredDtoList);

        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = new PrpDcustomerTaxPayInfoDto();
        //被保险人
        PrpCPinsuredDto prpCinsuredDtoIns = new PrpCPinsuredDto();

        /** 获取金禾清单号，添加金禾清单对象 add by 王保良 20180104 */
        GisInsureMainListDto gisInsureMainListDto=new GisInsureMainListDto();
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(policyNo);
        if (insureMainListDtoList!=null && insureMainListDtoList.size()!=0) {
            String gisInsureListCode = "";
            Map<String, String> map = new HashMap<>();
            gisInsureListCode = insureMainListDtoList.get(0).getGisInsureListCode();
            Integer serialNo = insureMainListDtoList.get(0).getSerialNo();

            String serialNo1 = String.valueOf(serialNo);
            Map<String, String> map5 = new HashMap<>();
            map5.put("gisInsureMainListCode", gisInsureListCode);
            map5.put("serialNo", serialNo1);
            map5.get("serialNo");
//        String listTypeFlag=gisInsureListApi.queryByPk(map5).getListType();
//        String insureListCode=gisInsureListApi.queryByPk(map5).getInsureListCode();
            gisInsureMainListDto = gisInsureListApi.queryByPk(map5);
        }
        GisInsureListDto gisInsureListDto=new GisInsureListDto();
        gisInsureListDto.setGisInsureMainListDto(gisInsureMainListDto);
        cPpolicyDto.setGisInsureListDto(gisInsureListDto);

        String riskCode = prpCPmain.getRiskCode();
        String businessProvinceName = "";
        String businessTownName = "";
        String businessCountyName = "";
        String businessCityName = "";
        String businessAreaName = "";
        String jobtitleName = "";
        String businessSortName = "";
        String insuredIdentityName = "";
        String riskLevelName = "";
        String insuredTypeName = "";
        String insuredFlagName = "";
        String insuredNatureName = "";
        String insuredLanguageName = "";
        String feeCurrencyName = "";
        String feeCurrencyName1 = "";
        String feeCurrencyName2 = "";
        String planCurrencyName = "";
        //归属机构
        String comName = "";
        //经办人
        String tHandlerName = "";
        //归属业务员
        String tHandler1Name = "";
        //最近修改员
        String updaterName = "";
        //操作员
        String operatorName = "";
        //险种名称
        String riskCodeName = "";
        //险种名称
        String classCodeName = "";

        //下拉选内容，单独放入ResponseDto里
        List<PrpDcodeDto> riskCodeNameList = prpDcodeApi.queryCodeInfoByCodeType("PolicyType",riskCode);
        List<PrpDcodeDto> languageNameList = prpDcodeApi.queryCodeInfoByCodeType("Language",riskCode);
        List<PrpDcodeDto> businessNatureNameList = prpDcodeApi.queryCodeInfoByCodeType("Language",riskCode);
        List<PrpDcodeDto> policySortNameList = prpDcodeApi.queryCodeInfoByCodeType("PolicySort",riskCode);
        List<PrpDcodeDto> businessTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("BusinessType0",riskCode);
        List<PrpDcodeDto> businessTypeNameList1 = prpDcodeApi.queryCodeInfoByCodeType("BusinessType1",riskCode);
        List<PrpDcodeDto> statUnitCodeNameList = prpDcodeApi.queryCodeInfoByCodeType("Unit",riskCode);
        List<PrpDcodeDto> articleTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("ArticleType",riskCode);
        List<PrpDcodeDto> cattleTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("CattleType",riskCode);
        List<PrpDcodeDto> raiseTypeNameList = new ArrayList<>();


        if(StringUtils.isNotEmpty(prpCPmain.getBusinessProvince())) {
            businessProvinceName = prpDcodeApi.translateCode("BusinessZone", prpCPmain.getBusinessProvince(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCPmain.getBusinessTown())) {
            businessTownName = prpDcodeApi.translateCode("BusinessZone", prpCPmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCPmain.getBusinessCounty())) {
            businessCountyName = prpDcodeApi.translateCode("BusinessZone", prpCPmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpCPmain.getBusinessCity())) {
            PrpTownCodeDto prpTownCodeDto = prpTownCodeApi.queryByPK(prpCPmain.getBusinessCity());
            if (prpTownCodeDto != null) {
                businessCityName = prpTownCodeDto.getCodeCname();
            }
        }
        if(StringUtils.isNotEmpty(prpCPmain.getBusinessArea())) {
            PrpCountryCodeDto prpCountryCodeDto = prpCountryCodeApi.queryByCodeCode(prpCPmain.getBusinessArea());
            if (prpCountryCodeDto != null) {
                businessAreaName = prpCountryCodeDto.getCodeCName();
            }
        }
        if(StringUtils.isNotEmpty(riskCode)) {
            Map<String,String> map1 = new HashMap<>();
            map1.put("riskCode",riskCode);
            riskCodeName = prpDriskApi.queryByPK(map1).getRiskCName();
        }
        if(StringUtils.isNotEmpty(prpCPmainDto.getClassCode())) {
            PrpDclassDto prpDclassDto=prpdclassApi.queryByPK(prpCPmainDto.getClassCode());
            if(prpDclassDto!=null){
                classCodeName=prpDclassDto.getClassName();
            }
        }
        if(LanguageFlagConstant.CHINESE.equals(languageFlag)){
            if(StringUtils.isNotEmpty(prpCPmainDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpCPmainDto.getComCode()).getComCName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpCPmainDto.getHandlerCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpCPmainDto.getHandler1Code()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpCPmainDto.getUpdaterCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getOperatorCode())){
                operatorName = prpDuserApi.queryByPK(prpCPmainDto.getOperatorCode()).getUserName();
            }
        }else{
            if(StringUtils.isNotEmpty(prpCPmainDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpCPmainDto.getComCode()).getComEName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpCPmainDto.getHandlerCode()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpCPmainDto.getHandler1Code()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpCPmainDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpCPmainDto.getUpdaterCode()).getUserEName();
            }
        }

        prpCPmainDto.setBusinessProvinceName(businessProvinceName);
        prpCPmainDto.setBusinessTownName(businessTownName);
        prpCPmainDto.setBusinessCountyName(businessCountyName);
        prpCPmainDto.setBusinessCityName(businessCityName);
        prpCPmainDto.setBusinessAreaName(businessAreaName);
        prpCPmainDto.setComName(comName);
        prpCPmainDto.settHandlerName(tHandlerName);
        prpCPmainDto.settHandler1Name(tHandler1Name);
        prpCPmainDto.setUpdaterName(updaterName);
        prpCPmainDto.setOperatorName(operatorName);
        prpCPmainDto.setRiskCodeName(riskCodeName);
        prpCPmainDto.setClassCodeName(classCodeName);

        //prpCinsured表数据
        for(int i=0;i<prpCPinsuredDtoList.size();i++) {
            jobtitleName = prpCPinsuredDtoList.get(i).getJobTitle();
            businessSortName = prpCPinsuredDtoList.get(i).getBusinessSort();
            insuredIdentityName = prpCPinsuredDtoList.get(i).getInsuredIdentity();
            if (StringUtils.isNotEmpty(prpCPinsuredDtoList.get(i).getInsuredCode())) {
                riskLevelName = prpDcustomLevelTraceApi.findRiskLevelByCode(prpCPinsuredDtoList.get(i).getInsuredCode());
            }
            insuredTypeName = prpCPinsuredDtoList.get(i).getInsuredType();
            insuredFlagName = prpCPinsuredDtoList.get(i).getInsuredFlag();
            insuredNatureName = prpCPinsuredDtoList.get(i).getInsuredNature();
            insuredLanguageName = prpCPinsuredDtoList.get(i).getLanguage();
            if (StringUtils.isEmpty(jobtitleName)) {
                jobtitleName = "00";
            }
            if (StringUtils.isEmpty(businessSortName)) {
                businessSortName = "9999";
            }
            if (StringUtils.isNotEmpty(jobtitleName)) {
                jobtitleName = prpDcodeApi.translateCode("BusinessType", jobtitleName, languageFlag);
            }
            if (StringUtils.isNotEmpty(businessSortName)) {
                businessSortName = prpDcodeApi.translateCode("BusinessSort", businessSortName, languageFlag);
            }
            if (StringUtils.isNotEmpty(insuredIdentityName)) {
                insuredIdentityName = prpDcodeApi.translateCode("InsuredIdentity", insuredIdentityName, languageFlag);
            }
            if (StringUtils.isNotEmpty(riskLevelName)) {
                riskLevelName = prpDcodeApi.translateCode("RiskLevel", riskLevelName, languageFlag);
            }
            if (StringUtils.isNotEmpty(insuredTypeName)) {
                insuredTypeName = prpDcodeApi.translateCode("InsuredType", insuredTypeName, languageFlag);
            }
            if (StringUtils.isNotEmpty(insuredFlagName)) {
                insuredFlagName = prpDcodeApi.translateCode("InsuredFlag", insuredFlagName, languageFlag);
            }
            if (StringUtils.isNotEmpty(insuredNatureName)) {
                insuredNatureName = prpDcodeApi.translateCode("BusinessDetail", insuredNatureName, languageFlag);
            }
            if (StringUtils.isNotEmpty(insuredLanguageName)) {
                insuredLanguageName = prpDcodeApi.translateCode("Language", insuredLanguageName, languageFlag);
            }

            prpCPinsuredDtoList.get(i).setJobtitleName(jobtitleName);
            prpCPinsuredDtoList.get(i).setBusinessSortName(businessSortName);
            prpCPinsuredDtoList.get(i).setInsuredIdentityName(insuredIdentityName);
            prpCPinsuredDtoList.get(i).setRiskLevelName(riskLevelName);
            prpCPinsuredDtoList.get(i).setInsuredTypeName(insuredTypeName);
            prpCPinsuredDtoList.get(i).setInsuredFlagName(insuredFlagName);
            prpCPinsuredDtoList.get(i).setInsuredNatureName(insuredNatureName);
            prpCPinsuredDtoList.get(i).setInsuredLanguageName(insuredLanguageName);

            //根据投保人查询发票信息
            if (prpCPinsuredDtoList.get(i).getInsuredFlag().equals("2")) {//投保人
                prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCPinsuredDtoList.get(i).getInsuredCode());
            }
            if (prpCPinsuredDtoList.get(i).getInsuredFlag().equals("1")) {//被保人
                prpCinsuredDtoIns = prpCPinsuredDtoList.get(i);
        }
        }
            //处理发票信息
            if(prpCinsuredDtoIns != null){
                if(prpDcustomerTaxPayInfoDto.getPayInfoObject()!=null && prpDcustomerTaxPayInfoDto.getPayInfoObject().equals("2") ){
                    prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredDtoIns.getInsuredCode());
                }
            } else {
                prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredDtoIns.getInsuredCode());
            }

            //prpcMainAgri表翻译
            if(prpCPmainAgriDto!=null){
                if("3137".equals(riskCode)||"3139".equals(riskCode)||"3173".equals(riskCode)){
                    raiseTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("HRaiseType",riskCode);
                }
            }

            //prpCfee表
            for(int i=0;i<prpCPfeeDtoList.size();i++){
                feeCurrencyName = prpCPfeeDtoList.get(i).getCurrency();
                if(StringUtils.isNotEmpty(feeCurrencyName)) {
                    feeCurrencyName = prpDcurrencyApi.translateCode(feeCurrencyName, languageFlag);
                }
                if(feeCurrencyName1.length()==0){
                    feeCurrencyName1 = prpCPfeeDtoList.get(i).getCurrency1();
                    if(StringUtils.isNotEmpty(feeCurrencyName1)) {
                        feeCurrencyName1 = prpDcurrencyApi.translateCode(feeCurrencyName1, languageFlag);
                    }
                    feeCurrencyName2 = prpCPfeeDtoList.get(i).getCurrency2();
                    if(StringUtils.isNotEmpty(feeCurrencyName2)) {
                        feeCurrencyName2 = prpDcurrencyApi.translateCode(feeCurrencyName2, languageFlag);
                    }
                }
                prpCPfeeDtoList.get(i).setFeeCurrencyName(feeCurrencyName);
                prpCPfeeDtoList.get(i).setFeeCurrencyName1(feeCurrencyName1);
                prpCPfeeDtoList.get(i).setFeeCurrencyName2(feeCurrencyName2);
            }

            //prpCplan表
            for(int i=0;i<prpCPplanDtoList.size();i++){
                planCurrencyName = prpCPplanDtoList.get(i).getCurrency();
                if(StringUtils.isNotEmpty(planCurrencyName)) {
                    planCurrencyName = prpDcurrencyApi.translateCode(planCurrencyName, languageFlag);
                }
                prpCPplanDtoList.get(i).setPlanCurrencyName(planCurrencyName);
            }
//            // 特别约定信息PP
//            List<QueryProposalPrpTengageDto> prpTengageDtoList = new ArrayList<>();
//            QueryProposalPrpTengageDto prpTengageDto = null;
//            for (PrpCPengage prpCPengage : prpCPengageList) {
//                if (prpTengageDto == null || !prpCPengage.getClauseCode().equals(prpTengageDto.getClauseCode())) {
//                    prpTengageDto = new QueryProposalPrpTengageDto();
//                    prpTengageDto.setClauseCode(prpCPengage.getClauseCode());
//                    prpTengageDto.setSerialNo(prpCPengage.getSerialNo());
//                    prpTengageDto.setFlag(prpCPengage.getFlag());
//                    prpTengageDtoList.add(prpTengageDto);
//                }
//                // 条款标题名称
//                if ("0".equals(prpCPengage.getTitleFlag())) {
//                    prpTengageDto.setClauseName(prpCPengage.getClauses());
//                } else {
//                    if (StringUtils.isEmpty(prpTengageDto.getClausesContent())) {
//                        prpTengageDto.setClausesContent(prpCPengage.getClauses());
//                    } else {
//                        prpTengageDto.setClausesContent(prpTengageDto.getClausesContent() + prpCPengage.getClauses());
//                    }
//                }
//            }
//        cPpolicyDto.setQueryProposalPrpTengageDtoList(prpTengageDtoList);
        cPpolicyDto.setPrpDcustomerTaxPayInfoDto(prpDcustomerTaxPayInfoDto);
        return cPpolicyDto;
    }
}