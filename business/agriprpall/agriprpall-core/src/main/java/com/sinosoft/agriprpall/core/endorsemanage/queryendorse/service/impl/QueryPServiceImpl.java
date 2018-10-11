package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.*;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryPService;
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
import com.sinosoft.framework.exception.DataVerifyException;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  P表查询服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class QueryPServiceImpl extends BaseServiceImpl implements QueryPService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryPServiceImpl.class);

    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpPengageDao prpPengageDao;
    @Autowired
    private PrpPaddressDao prpPaddressDao;
    @Autowired
    private PrpPcoinsDao prpPcoinsDao;
    @Autowired
    private PrpPexpenseDao prpPexpenseDao;
    @Autowired
    private PrpPfeeDao prpPfeeDao;
    @Autowired
    private PrpPinsuredDao prpPinsuredDao;
    @Autowired
    private PrpPitemKindAgriDao prpPitemKindAgriDao;
    @Autowired
    private PrpPitemKindDao prpPitemKindDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private PrpPplanDao prpPplanDao;
    @Autowired
    private PrpPsubSidyDao prpPsubSidyDao;
    @Autowired
    private PrpPcoinsDetailDao prpPcoinsDetailDao;
    @Autowired
    private PrpPmainAgriDao prpPmainAgriDao;
    @Autowired
    private PrpPplanCoinsDao prpPplanCoinsDao;
    @Autowired
    private PrpPfeildDao prpPfeildDao;
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

    //copy表
    @Autowired
    private PrpPheadCopyDao prpPheadCopyDao;
    @Autowired
    private PrpPengageCopyDao prpPengageCopyDao;
    @Autowired
    private PrpPaddressCopyDao prpPaddressCopyDao;
    @Autowired
    private PrpPcoinsCopyDao prpPcoinsCopyDao;
    @Autowired
    private PrpPexpenseCopyDao prpPexpenseCopyDao;
    @Autowired
    private PrpPfeeCopyDao prpPfeeCopyDao;
    @Autowired
    private PrpPinsuredCopyDao prpPinsuredCopyDao;
    @Autowired
    private PrpPitemKindAgriCopyDao prpPitemKindAgriCopyDao;
    @Autowired
    private PrpPitemKindCopyDao prpPitemKindCopyDao;
    @Autowired
    private PrpPmainCopyDao prpPmainCopyDao;
    @Autowired
    private PrpPplanCopyDao prpPplanCopyDao;
    @Autowired
    private PrpPsubSidyCopyDao prpPsubSidyCopyDao;
    @Autowired
    private PrpPcoinsDetailCopyDao prpPcoinsDetailCopyDao;
    @Autowired
    private PrpPmainAgriCopyDao prpPmainAgriCopyDao;
    @Autowired
    private PrpPplanCoinsCopyDao prpPplanCoinsCopyDao;
    @Autowired
    private PrpPfeildCopyDao prpPfeildCopyDao;

    /**
     *  根据批单号查询出相应的Blendorse中的P表大对象
     * @param endorseNo 批单号
     * @return BlendorseDto(查出来的是所有的P表对象)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BLEndorseDto queryP(String endorseNo) throws Exception{
        if (StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号不能为空");
        }

        String languageFlag="zh-CN";
        BLEndorseDto blEndorseDto=new BLEndorseDto();

        PrpPheadKey prpPheadKey=new PrpPheadKey(endorseNo);
        PrpPhead prpPhead=prpPheadDao.findOne(prpPheadKey);
        if (prpPhead==null){
            throw new DataVerifyException("该批单头信息不存在");
        }
        PrpPheadDto prpPheadDto=convert(prpPhead, PrpPheadDto.class);
        blEndorseDto.setPrpPheadDto(prpPheadDto);

        List<PrpPengage> prpPengageList=prpPengageDao.findAllByEndorseNo(endorseNo);
        List<PrpPengageDto> prpPengageDtoList=new ArrayList<>();
        convertCollection(prpPengageList,prpPengageDtoList,PrpPengageDto.class);
        blEndorseDto.setPrpPengageDtoList(prpPengageDtoList);

        List<PrpPaddress> prpPaddressList=prpPaddressDao.findAllByEndorseNo(endorseNo);
        List<PrpPaddressDto> prpPaddressDtoList=new ArrayList<>();
        convertCollection(prpPaddressList,prpPaddressDtoList,PrpPaddressDto.class);
        blEndorseDto.setPrpPaddressDtoList(prpPaddressDtoList);

        List<PrpPcoins> prpPcoinsList=prpPcoinsDao.findAllByEndorseNo(endorseNo);
        List<PrpPcoinsDto> prpPcoinsDtoList=new ArrayList<>();
        convertCollection(prpPcoinsList,prpPcoinsDtoList,PrpPcoinsDto.class);
        blEndorseDto.setPrpPcoinsDtoList(prpPcoinsDtoList);

        PrpPexpenseKey prpPexpenseKey=new PrpPexpenseKey(endorseNo);
        PrpPexpense prpPexpense=prpPexpenseDao.findOne(prpPexpenseKey);
        PrpPexpenseDto prpPexpenseDto=convert(prpPexpense,PrpPexpenseDto.class);
        blEndorseDto.setPrpPexpenseDto(prpPexpenseDto);

        List<PrpPfee> prpPfeeList=prpPfeeDao.findAllByEndorseNo(endorseNo);
        List<PrpPfeeDto> prpPfeeDtoList=new ArrayList<>();
        convertCollection(prpPfeeList,prpPfeeDtoList,PrpPfeeDto.class);
        blEndorseDto.setPrpPfeeDtoList(prpPfeeDtoList);

        List<PrpPinsured> prpPinsuredList=prpPinsuredDao.findAllByEndorseNo(endorseNo);
        List<PrpPinsuredDto> prpPinsuredDtoList=new ArrayList<>();
        convertCollection(prpPinsuredList,prpPinsuredDtoList,PrpPinsuredDto.class);
        blEndorseDto.setPrpPinsuredDtoList(prpPinsuredDtoList);

        List<PrpPitemKindAgri> prpPitemKindAgriList=prpPitemKindAgriDao.findAllByEndorseNo(endorseNo);
        List<PrpPitemKindAgriDto> prpPitemKindAgriDtoList=new ArrayList<>();
        convertCollection(prpPitemKindAgriList,prpPitemKindAgriDtoList,PrpPitemKindAgriDto.class);
        blEndorseDto.setPrpPitemKindAgriDtoList(prpPitemKindAgriDtoList);

        List<PrpPitemKind> prpPitemKindList=prpPitemKindDao.findAllByEndorseNo(endorseNo);
        List<PrpPitemKindDto> prpPitemKindDtoList=new ArrayList<>();
        convertCollection(prpPitemKindList,prpPitemKindDtoList,PrpPitemKindDto.class);
        blEndorseDto.setPrpPitemKindDtoList(prpPitemKindDtoList);

        PrpPmainKey prpPmainKey=new PrpPmainKey(endorseNo);
        PrpPmain prpPmain=prpPmainDao.findOne(prpPmainKey);
        PrpPmainDto prpPmainDto=convert(prpPmain,PrpPmainDto.class);
        blEndorseDto.setPrpPmainDto(prpPmainDto);

        List<PrpPplan> prpPplanList=prpPplanDao.findAllByEndorseNo(endorseNo);
        List<PrpPplanDto> prpPplanDtoList=new ArrayList<>();
        convertCollection(prpPplanList,prpPplanDtoList,PrpPplanDto.class);
        blEndorseDto.setPrpPplanDtoList(prpPplanDtoList);

        List<PrpPsubSidy> prpPsubSidyList=prpPsubSidyDao.findAllByEndorseNo(endorseNo);
        List<PrpPsubsidyDto> prpPsubsidyDtoList=new ArrayList<>();
        convertCollection(prpPsubSidyList,prpPsubsidyDtoList,PrpPsubsidyDto.class);
        blEndorseDto.setPrpPsubsidyDtoList(prpPsubsidyDtoList);

        List<PrpPcoinsDetail> prpPcoinsDetailList=prpPcoinsDetailDao.findAllByEndorseNo(endorseNo);
        List<PrpPcoinsDetailDto> prpPcoinsDetailDtoList=new ArrayList<>();
        convertCollection(prpPcoinsDetailList,prpPcoinsDetailDtoList,PrpPcoinsDetailDto.class);
        blEndorseDto.setPrpPcoinsDetailDtoList(prpPcoinsDetailDtoList);

        PrpPmainAgriKey prpPmainAgriKey=new PrpPmainAgriKey(endorseNo);
        PrpPmainAgri prpPmainAgri=prpPmainAgriDao.findOne(prpPmainAgriKey);
        PrpPmainAgriDto prpPmainAgriDto=convert(prpPmainAgri,PrpPmainAgriDto.class);
        blEndorseDto.setPrpPmainAgriDto(prpPmainAgriDto);

        List<PrpPplanCoins> prpPplanCoinsList=prpPplanCoinsDao.findAllByEndorseNo(endorseNo);
        List<PrpPplanCoinsDto> prpPplanCoinsDtoList=new ArrayList<>();
        convertCollection(prpPplanCoinsList,prpPplanCoinsDtoList,PrpPplanCoinsDto.class);
        blEndorseDto.setPrpPplanCoinsDtoList(prpPplanCoinsDtoList);

        List<PrpPfeild> prpPfeildList=prpPfeildDao.findAllByEndorseNo(endorseNo);
        List<PrpPfeildDto> prpPfeildDtoList=new ArrayList<>();
        convertCollection(prpPfeildList,prpPfeildDtoList,PrpPfeildDto.class);
        blEndorseDto.setPrpPfeildDtoList(prpPfeildDtoList);

        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto=new PrpDcustomerTaxPayInfoDto();

        //被保险人
        PrpPinsuredDto prpCinsuredDtoIns = new PrpPinsuredDto();


        String policyNo= prpPhead.getPolicyNo();
        String listTypeFlag="";
        String insureListCode="";
        GisInsureMainListDto gisInsureMainListDto=new GisInsureMainListDto();
        /** 获取金禾清单号，添加金禾清单对象 add by 王心洋 20180104 */
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
            gisInsureMainListDto=gisInsureListApi.queryByPk(map5);
        }

        String riskCode = prpPmain.getRiskCode();

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
        //险类名称
        String className="";


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

        if(StringUtils.isNotEmpty(prpPmain.getBusinessProvince())) {
            businessProvinceName = prpDcodeApi.translateCode("BusinessZone", prpPmain.getBusinessProvince(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpPmain.getBusinessTown())) {
            businessTownName = prpDcodeApi.translateCode("BusinessZone", prpPmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpPmain.getBusinessCounty())) {
            businessCountyName = prpDcodeApi.translateCode("BusinessZone", prpPmain.getBusinessTown(), languageFlag);
        }
        if(StringUtils.isNotEmpty(prpPmain.getBusinessCity())) {
            PrpTownCodeDto prpTownCodeDto = prpTownCodeApi.queryByPK(prpPmainDto.getBusinessCity());
            if (prpTownCodeDto != null) {
                businessCityName = prpTownCodeDto.getCodeCname();
            }
        }
        if(StringUtils.isNotEmpty(prpPmain.getBusinessArea())) {
            PrpCountryCodeDto prpCountryCodeDto = prpCountryCodeApi.queryByCodeCode(prpPmainDto.getBusinessArea());
            if (prpCountryCodeDto != null) {
                businessAreaName = prpCountryCodeDto.getCodeCName();
            }
        }
        if(StringUtils.isNotEmpty(riskCode)) {
            Map<String,String> map1 = new HashMap<>();
            map1.put("riskCode",riskCode);
            riskCodeName = prpDriskApi.queryByPK(map1).getRiskCName();
        }
        if(StringUtils.isNotEmpty(prpPmainDto.getClassCode())) {
            PrpDclassDto prpDclassDto=prpdclassApi.queryByPK(prpPmainDto.getClassCode());
            if(prpDclassDto!=null){
                className=prpDclassDto.getClassName();
            }
        }
        if(LanguageFlagConstant.CHINESE.equals(languageFlag)){
            if(StringUtils.isNotEmpty(prpPmainDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpPmainDto.getComCode()).getComCName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpPmainDto.getHandlerCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpPmainDto.getHandler1Code()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpPmainDto.getUpdaterCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getOperatorCode())){
                operatorName = prpDuserApi.queryByPK(prpPmainDto.getOperatorCode()).getUserName();
            }
        }else{
            if(StringUtils.isNotEmpty(prpPmainDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpPmainDto.getComCode()).getComEName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpPmainDto.getHandlerCode()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpPmainDto.getHandler1Code()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpPmainDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpPmainDto.getUpdaterCode()).getUserEName();
            }
        }

        prpPmainDto.setBusinessProvinceName(businessProvinceName);
        prpPmainDto.setBusinessTownName(businessTownName);
        prpPmainDto.setBusinessCountyName(businessCountyName);
        prpPmainDto.setBusinessCityName(businessCityName);
        prpPmainDto.setBusinessAreaName(businessAreaName);
        prpPmainDto.setComName(comName);
        prpPmainDto.settHandlerName(tHandlerName);
        prpPmainDto.settHandler1Name(tHandler1Name);
        prpPmainDto.setUpdaterName(updaterName);
        prpPmainDto.setOperatorName(operatorName);
        prpPmainDto.setRiskCodeName(riskCodeName);
        prpPmainDto.setClassCodeName(className);


        //prpCinsured表数据
        for(int i=0;i<prpPinsuredDtoList.size();i++){
            jobtitleName = prpPinsuredDtoList.get(i).getJobTitle();
            businessSortName = prpPinsuredDtoList.get(i).getBusinessSort();
            insuredIdentityName = prpPinsuredDtoList.get(i).getInsuredIdentity();
            if(StringUtils.isNotEmpty(prpPinsuredDtoList.get(i).getInsuredCode())) {
                riskLevelName = prpDcustomLevelTraceApi.findRiskLevelByCode(prpPinsuredDtoList.get(i).getInsuredCode());
            }
            insuredTypeName = prpPinsuredDtoList.get(i).getInsuredType();
            insuredFlagName = prpPinsuredDtoList.get(i).getInsuredFlag();
            insuredNatureName = prpPinsuredDtoList.get(i).getInsuredNature();
            insuredLanguageName = prpPinsuredDtoList.get(i).getLanguage();
            if(StringUtils.isEmpty(jobtitleName)){
                jobtitleName = "00";
            }
            if(StringUtils.isEmpty(businessSortName)){
                businessSortName = "9999";
            }
            if(StringUtils.isNotEmpty(jobtitleName)){
                jobtitleName = prpDcodeApi.translateCode("BusinessType",jobtitleName,languageFlag);
            }
            if(StringUtils.isNotEmpty(businessSortName)){
                businessSortName = prpDcodeApi.translateCode("BusinessSort",businessSortName,languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredIdentityName)) {
                insuredIdentityName = prpDcodeApi.translateCode("InsuredIdentity", insuredIdentityName, languageFlag);
            }
            if(StringUtils.isNotEmpty(riskLevelName)) {
                riskLevelName = prpDcodeApi.translateCode("RiskLevel", riskLevelName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredTypeName)) {
                insuredTypeName = prpDcodeApi.translateCode("InsuredType", insuredTypeName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredFlagName)) {
                insuredFlagName = prpDcodeApi.translateCode("InsuredFlag", insuredFlagName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredNatureName)) {
                insuredNatureName = prpDcodeApi.translateCode("BusinessDetail", insuredNatureName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredLanguageName)) {
                insuredLanguageName = prpDcodeApi.translateCode("Language", insuredLanguageName, languageFlag);
            }

            prpPinsuredDtoList.get(i).setJobtitleName(jobtitleName);
            prpPinsuredDtoList.get(i).setBusinessSortName(businessSortName);
            prpPinsuredDtoList.get(i).setInsuredIdentityName(insuredIdentityName);
            prpPinsuredDtoList.get(i).setRiskLevelName(riskLevelName);
            prpPinsuredDtoList.get(i).setInsuredTypeName(insuredTypeName);
            prpPinsuredDtoList.get(i).setInsuredFlagName(insuredFlagName);
            prpPinsuredDtoList.get(i).setInsuredNatureName(insuredNatureName);
            prpPinsuredDtoList.get(i).setInsuredLanguageName(insuredLanguageName);

            //根据投保人查询发票信息
            if(prpPinsuredDtoList.get(i).getInsuredFlag().equals("2")){//投保人
                prpDcustomerTaxPayInfoDto = prpDcustomerTaxPayInfoApi.queryByPK(prpPinsuredDtoList.get(i).getInsuredCode());
            }
            if(prpPinsuredDtoList.get(i).getInsuredFlag().equals("1")){//被保人
                prpCinsuredDtoIns = prpPinsuredDtoList.get(i);
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
        if(prpPmainAgriDto!=null){
            if("3137".equals(riskCode)||"3139".equals(riskCode)||"3173".equals(riskCode)){
                raiseTypeNameList = prpDcodeApi.queryCodeInfoByCodeType("HRaiseType",riskCode);
            }
        }

        //prpCfee表
        for(int i=0;i<prpPfeeDtoList.size();i++){

            String currency2Name=prpDcodeApi.queryByPK("CURRENCY_CI",prpPfeeDtoList.get(i).getCurrency2()).getCodeCName();
            prpPfeeDtoList.get(i).setCurrency2Name(currency2Name);
            feeCurrencyName = prpPfeeDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(feeCurrencyName)) {
                feeCurrencyName = prpDcurrencyApi.translateCode(feeCurrencyName, languageFlag);
            }
            if(feeCurrencyName1.length()==0){
                feeCurrencyName1 = prpPfeeDtoList.get(i).getCurrency1();
                if(StringUtils.isNotEmpty(feeCurrencyName1)) {
                    feeCurrencyName1 = prpDcurrencyApi.translateCode(feeCurrencyName1, languageFlag);
                }
                feeCurrencyName2 = prpPfeeDtoList.get(i).getCurrency2();
                if(StringUtils.isNotEmpty(feeCurrencyName2)) {
                    feeCurrencyName2 = prpDcurrencyApi.translateCode(feeCurrencyName2, languageFlag);
                }
            }
            prpPfeeDtoList.get(i).setFeeCurrencyName(feeCurrencyName);
            prpPfeeDtoList.get(i).setFeeCurrencyName1(feeCurrencyName1);
            prpPfeeDtoList.get(i).setFeeCurrencyName2(feeCurrencyName2);
        }

        //prpCplan表
        for(int i=0;i<prpPplanDtoList.size();i++){
            planCurrencyName = prpPplanDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(planCurrencyName)) {
                planCurrencyName = prpDcurrencyApi.translateCode(planCurrencyName, languageFlag);
            }
            prpPplanDtoList.get(i).setPlanCurrencyName(planCurrencyName);
        }

        blEndorseDto.setPrpDcustomerTaxPayInfoDto(prpDcustomerTaxPayInfoDto);

        GisInsureListDto gisInsureListDto=new GisInsureListDto();
        gisInsureListDto.setGisInsureMainListDto(gisInsureMainListDto);
        blEndorseDto.setGisInsureListDto(gisInsureListDto);

        // 特别约定信息
        List<QueryProposalPrpTengageDto> prpTengageDtoList = new ArrayList<>();
        QueryProposalPrpTengageDto prpTengageDto = null;
        for (PrpPengage prpTengage : prpPengageList) {
            if (prpTengageDto == null || !prpTengage.getClauseCode().equals(prpTengageDto.getClauseCode())) {
                prpTengageDto = new QueryProposalPrpTengageDto();
                prpTengageDto.setClauseCode(prpTengage.getClauseCode());
                prpTengageDto.setSerialNo(prpTengage.getSerialNo());
                prpTengageDtoList.add(prpTengageDto);
            }
            // 条款标题名称
            if ("0".equals(prpTengage.getTitleFlag())){
                prpTengageDto.setClauseName(prpTengage.getClauses());
            } else {
                if (StringUtils.isEmpty(prpTengageDto.getClausesContent())) {
                    prpTengageDto.setClausesContent(prpTengage.getClauses());
                } else {
                    prpTengageDto.setClausesContent(prpTengageDto.getClausesContent() + prpTengage.getClauses());
                }
            }
        }

        blEndorseDto.setQueryProposalPrpTengageDtoList(prpTengageDtoList);

        //copy表
        PrpPheadCopyKey prpPheadCopyKey=new PrpPheadCopyKey(endorseNo);
        PrpPheadCopy prpPheadCopy=prpPheadCopyDao.findOne(prpPheadCopyKey);
        if (prpPheadCopy==null){
            throw new DataVerifyException("该批单头信息不存在");
        }
        PrpPheadCopyDto prpPheadCopyDto=convert(prpPheadCopy, PrpPheadCopyDto.class);
        blEndorseDto.setPrpPheadCopyDto(prpPheadCopyDto);

        List<PrpPengageCopy> prpPengageCopyList=prpPengageCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPengageCopyDto> prpPengageCopyDtoList=new ArrayList<>();
        convertCollection(prpPengageCopyList,prpPengageCopyDtoList,PrpPengageCopyDto.class);
        blEndorseDto.setPrpPengageCopyDtoList(prpPengageCopyDtoList);

        List<PrpPaddressCopy> prpPaddressCopyList=prpPaddressCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPaddressCopyDto> prpPaddressCopyDtoList=new ArrayList<>();
        convertCollection(prpPaddressCopyList,prpPaddressCopyDtoList,PrpPaddressCopyDto.class);
        blEndorseDto.setPrpPaddressCopyDtoList(prpPaddressCopyDtoList);

        List<PrpPcoinsCopy> prpPcoinsCopyList=prpPcoinsCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPcoinsCopyDto> prpPcoinsCopyDtoList=new ArrayList<>();
        convertCollection(prpPcoinsCopyList,prpPcoinsCopyDtoList,PrpPcoinsCopyDto.class);
        blEndorseDto.setPrpPcoinsCopyDtoList(prpPcoinsCopyDtoList);

        PrpPexpenseCopyKey prpPexpenseCopyKey=new PrpPexpenseCopyKey(endorseNo);
        PrpPexpenseCopy prpPexpenseCopy=prpPexpenseCopyDao.findOne(prpPexpenseCopyKey);
        PrpPexpenseCopyDto prpPexpenseCopyDto=convert(prpPexpenseCopy,PrpPexpenseCopyDto.class);
        blEndorseDto.setPrpPexpenseCopyDto(prpPexpenseCopyDto);

        List<PrpPfeeCopy> prpPfeeCopyList=prpPfeeCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPfeeCopyDto> prpPfeeCopyDtoList=new ArrayList<>();
        convertCollection(prpPfeeCopyList,prpPfeeCopyDtoList,PrpPfeeCopyDto.class);
        blEndorseDto.setPrpPfeeCopyDtoList(prpPfeeCopyDtoList);

        List<PrpPinsuredCopy> prpPinsuredCopyList=prpPinsuredCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPinsuredCopyDto> prpPinsuredCopyDtoList=new ArrayList<>();
        convertCollection(prpPinsuredCopyList,prpPinsuredCopyDtoList,PrpPinsuredCopyDto.class);
        blEndorseDto.setPrpPinsuredCopyDtoList(prpPinsuredCopyDtoList);

        List<PrpPitemKindAgriCopy> prpPitemKindAgriCopyList=prpPitemKindAgriCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPitemKindAgriCopyDto> prpPitemKindAgriCopyDtoList=new ArrayList<>();
        convertCollection(prpPitemKindAgriCopyList,prpPitemKindAgriCopyDtoList,PrpPitemKindAgriCopyDto.class);
        blEndorseDto.setPrpPitemKindAgriCopyDtoList(prpPitemKindAgriCopyDtoList);

        List<PrpPitemKindCopy> prpPitemKindCopyList=prpPitemKindCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPitemKindCopyDto> prpPitemKindCopyDtoList=new ArrayList<>();
        convertCollection(prpPitemKindCopyList,prpPitemKindCopyDtoList,PrpPitemKindCopyDto.class);
        blEndorseDto.setPrpPitemKindCopyDtoList(prpPitemKindCopyDtoList);

        PrpPmainCopyKey prpPmainCopyKey=new PrpPmainCopyKey(endorseNo);
        PrpPmainCopy prpPmainCopy=prpPmainCopyDao.findOne(prpPmainCopyKey);
        PrpPmainCopyDto prpPmainCopyDto=convert(prpPmainCopy,PrpPmainCopyDto.class);
        blEndorseDto.setPrpPmainCopyDto(prpPmainCopyDto);

        List<PrpPplanCopy> prpPplanCopyList=prpPplanCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPplanCopyDto> prpPplanCopyDtoList=new ArrayList<>();
        convertCollection(prpPplanCopyList,prpPplanCopyDtoList,PrpPplanCopyDto.class);
        blEndorseDto.setPrpPplanCopyDtoList(prpPplanCopyDtoList);

        List<PrpPsubSidyCopy> prpPsubSidyCopyList=prpPsubSidyCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPsubsidyCopyDto> prpPsubsidyCopyDtoList=new ArrayList<>();
        convertCollection(prpPsubSidyCopyList,prpPsubsidyCopyDtoList,PrpPsubsidyCopyDto.class);
        blEndorseDto.setPrpPsubsidyCopyDtoList(prpPsubsidyCopyDtoList);

        List<PrpPcoinsDetailCopy> prpPcoinsDetailCopyList=prpPcoinsDetailCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPcoinsDetailCopyDto> prpPcoinsDetailCopyDtoList=new ArrayList<>();
        convertCollection(prpPcoinsDetailCopyList,prpPcoinsDetailCopyDtoList,PrpPcoinsDetailCopyDto.class);
        blEndorseDto.setPrpPcoinsDetailCopyDtoList(prpPcoinsDetailCopyDtoList);

        PrpPmainAgriCopyKey prpPmainAgriCopyKey=new PrpPmainAgriCopyKey(endorseNo);
        PrpPmainAgriCopy prpPmainAgriCopy=prpPmainAgriCopyDao.findOne(prpPmainAgriCopyKey);
        PrpPmainAgriCopyDto prpPmainAgriCopyDto=convert(prpPmainAgriCopy,PrpPmainAgriCopyDto.class);
        blEndorseDto.setPrpPmainAgriCopyDto(prpPmainAgriCopyDto);

        List<PrpPplanCoinsCopy> prpPplanCoinsCopyList=prpPplanCoinsCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPplanCoinsCopyDto> prpPplanCoinsCopyDtoList=new ArrayList<>();
        convertCollection(prpPplanCoinsCopyList,prpPplanCoinsCopyDtoList,PrpPplanCoinsCopyDto.class);
        blEndorseDto.setPrpPplanCoinsCopyDtoList(prpPplanCoinsCopyDtoList);

        List<PrpPfeildCopy> prpPfeildCopyList=prpPfeildCopyDao.findAllByEndorseNo(endorseNo);
        List<PrpPfeildCopyDto> prpPfeildCopyDtoList=new ArrayList<>();
        convertCollection(prpPfeildCopyList,prpPfeildCopyDtoList,PrpPfeildCopyDto.class);
        blEndorseDto.setPrpPfeildCopyDtoList(prpPfeildCopyDtoList);

        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoCopyDto=new PrpDcustomerTaxPayInfoDto();

        //被保险人
        PrpPinsuredCopyDto prpCinsuredCopyDtoIns = new PrpPinsuredCopyDto();
        if(LanguageFlagConstant.CHINESE.equals(languageFlag)){
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpPmainCopyDto.getComCode()).getComCName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpPmainCopyDto.getHandlerCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpPmainCopyDto.getHandler1Code()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpPmainCopyDto.getUpdaterCode()).getUserName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getOperatorCode())){
                operatorName = prpDuserApi.queryByPK(prpPmainCopyDto.getOperatorCode()).getUserName();
            }
        }else{
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getComCode())) {
                comName = prpDcompanyApi.queryByPK(prpPmainCopyDto.getComCode()).getComEName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getHandlerCode())) {
                tHandlerName = prpDuserApi.queryByPK(prpPmainCopyDto.getHandlerCode()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getHandler1Code())) {
                tHandler1Name = prpDuserApi.queryByPK(prpPmainCopyDto.getHandler1Code()).getUserEName();
            }
            if(StringUtils.isNotEmpty(prpPmainCopyDto.getUpdaterCode())){
                updaterName = prpDuserApi.queryByPK(prpPmainCopyDto.getUpdaterCode()).getUserEName();
            }
        }

        prpPmainCopyDto.setBusinessProvinceName(businessProvinceName);
        prpPmainCopyDto.setBusinessTownName(businessTownName);
        prpPmainCopyDto.setBusinessCountyName(businessCountyName);
        prpPmainCopyDto.setBusinessCityName(businessCityName);
        prpPmainCopyDto.setBusinessAreaName(businessAreaName);
        prpPmainCopyDto.setComName(comName);
        prpPmainCopyDto.settHandlerName(tHandlerName);
        prpPmainCopyDto.settHandler1Name(tHandler1Name);
        prpPmainCopyDto.setUpdaterName(updaterName);
        prpPmainCopyDto.setOperatorName(operatorName);
        prpPmainCopyDto.setRiskCodeName(riskCodeName);
        prpPmainCopyDto.setClassCodeName(className);


        //prpCinsured表数据
        for(int i=0;i<prpPinsuredCopyDtoList.size();i++){
            jobtitleName = prpPinsuredCopyDtoList.get(i).getJobTitle();
            businessSortName = prpPinsuredCopyDtoList.get(i).getBusinessSort();
            insuredIdentityName = prpPinsuredCopyDtoList.get(i).getInsuredIdentity();
            if(StringUtils.isNotEmpty(prpPinsuredCopyDtoList.get(i).getInsuredCode())) {
                riskLevelName = prpDcustomLevelTraceApi.findRiskLevelByCode(prpPinsuredCopyDtoList.get(i).getInsuredCode());
            }
            insuredTypeName = prpPinsuredCopyDtoList.get(i).getInsuredType();
            insuredFlagName = prpPinsuredCopyDtoList.get(i).getInsuredFlag();
            insuredNatureName = prpPinsuredCopyDtoList.get(i).getInsuredNature();
            insuredLanguageName = prpPinsuredCopyDtoList.get(i).getLanguage();
            if(StringUtils.isEmpty(jobtitleName)){
                jobtitleName = "00";
            }
            if(StringUtils.isEmpty(businessSortName)){
                businessSortName = "9999";
            }
            if(StringUtils.isNotEmpty(jobtitleName)){
                jobtitleName = prpDcodeApi.translateCode("BusinessType",jobtitleName,languageFlag);
            }
            if(StringUtils.isNotEmpty(businessSortName)){
                businessSortName = prpDcodeApi.translateCode("BusinessSort",businessSortName,languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredIdentityName)) {
                insuredIdentityName = prpDcodeApi.translateCode("InsuredIdentity", insuredIdentityName, languageFlag);
            }
            if(StringUtils.isNotEmpty(riskLevelName)) {
                riskLevelName = prpDcodeApi.translateCode("RiskLevel", riskLevelName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredTypeName)) {
                insuredTypeName = prpDcodeApi.translateCode("InsuredType", insuredTypeName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredFlagName)) {
                insuredFlagName = prpDcodeApi.translateCode("InsuredFlag", insuredFlagName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredNatureName)) {
                insuredNatureName = prpDcodeApi.translateCode("BusinessDetail", insuredNatureName, languageFlag);
            }
            if(StringUtils.isNotEmpty(insuredLanguageName)) {
                insuredLanguageName = prpDcodeApi.translateCode("Language", insuredLanguageName, languageFlag);
            }

            prpPinsuredCopyDtoList.get(i).setJobtitleName(jobtitleName);
            prpPinsuredCopyDtoList.get(i).setBusinessSortName(businessSortName);
            prpPinsuredCopyDtoList.get(i).setInsuredIdentityName(insuredIdentityName);
            prpPinsuredCopyDtoList.get(i).setRiskLevelName(riskLevelName);
            prpPinsuredCopyDtoList.get(i).setInsuredTypeName(insuredTypeName);
            prpPinsuredCopyDtoList.get(i).setInsuredFlagName(insuredFlagName);
            prpPinsuredCopyDtoList.get(i).setInsuredNatureName(insuredNatureName);
            prpPinsuredCopyDtoList.get(i).setInsuredLanguageName(insuredLanguageName);

            //根据投保人查询发票信息
            if(prpPinsuredCopyDtoList.get(i).getInsuredFlag().equals("2")){//投保人
                prpDcustomerTaxPayInfoCopyDto = prpDcustomerTaxPayInfoApi.queryByPK(prpPinsuredCopyDtoList.get(i).getInsuredCode());
            }
            if(prpPinsuredCopyDtoList.get(i).getInsuredFlag().equals("1")){//被保人
                prpCinsuredCopyDtoIns = prpPinsuredCopyDtoList.get(i);
            }
        }

        //处理发票信息
        if(prpCinsuredCopyDtoIns != null){
            if(prpDcustomerTaxPayInfoCopyDto.getPayInfoObject()!=null && prpDcustomerTaxPayInfoCopyDto.getPayInfoObject().equals("2") ){
                prpDcustomerTaxPayInfoCopyDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredCopyDtoIns.getInsuredCode());
            }
        } else {
            prpDcustomerTaxPayInfoCopyDto = prpDcustomerTaxPayInfoApi.queryByPK(prpCinsuredCopyDtoIns.getInsuredCode());
        }


        //prpCfee表
        for(int i=0;i<prpPfeeCopyDtoList.size();i++){

            String currency2Name=prpDcodeApi.queryByPK("CURRENCY_CI",prpPfeeCopyDtoList.get(i).getCurrency2()).getCodeCName();
            prpPfeeCopyDtoList.get(i).setCurrency2Name(currency2Name);
            feeCurrencyName = prpPfeeCopyDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(feeCurrencyName)) {
                feeCurrencyName = prpDcurrencyApi.translateCode(feeCurrencyName, languageFlag);
            }
            if(feeCurrencyName1.length()==0){
                feeCurrencyName1 = prpPfeeCopyDtoList.get(i).getCurrency1();
                if(StringUtils.isNotEmpty(feeCurrencyName1)) {
                    feeCurrencyName1 = prpDcurrencyApi.translateCode(feeCurrencyName1, languageFlag);
                }
                feeCurrencyName2 = prpPfeeCopyDtoList.get(i).getCurrency2();
                if(StringUtils.isNotEmpty(feeCurrencyName2)) {
                    feeCurrencyName2 = prpDcurrencyApi.translateCode(feeCurrencyName2, languageFlag);
                }
            }
            prpPfeeCopyDtoList.get(i).setFeeCurrencyName(feeCurrencyName);
            prpPfeeCopyDtoList.get(i).setFeeCurrencyName1(feeCurrencyName1);
            prpPfeeCopyDtoList.get(i).setFeeCurrencyName2(feeCurrencyName2);
        }

        //prpCplan表
        for(int i=0;i<prpPplanCopyDtoList.size();i++){
            planCurrencyName = prpPplanCopyDtoList.get(i).getCurrency();
            if(StringUtils.isNotEmpty(planCurrencyName)) {
                planCurrencyName = prpDcurrencyApi.translateCode(planCurrencyName, languageFlag);
            }
            prpPplanCopyDtoList.get(i).setPlanCurrencyName(planCurrencyName);
        }

        blEndorseDto.setPrpDcustomerTaxPayInfoCopyDto(prpDcustomerTaxPayInfoCopyDto);


        // 特别约定信息
        List<QueryProposalPrpTengageDto> prpTengageCopyDtoList = new ArrayList<>();
        QueryProposalPrpTengageDto prpTengageCopyDto = null;
        for (PrpPengageCopy prpTengageCopy : prpPengageCopyList) {
            if (prpTengageCopyDto == null || !prpTengageCopy.getClauseCode().equals(prpTengageCopyDto.getClauseCode())) {
                prpTengageCopyDto = new QueryProposalPrpTengageDto();
                prpTengageCopyDto.setClauseCode(prpTengageCopy.getClauseCode());
                prpTengageCopyDto.setSerialNo(prpTengageCopy.getSerialNo());
                prpTengageCopyDto.setFlag(prpTengageCopy.getFlag());
                prpTengageCopyDtoList.add(prpTengageCopyDto);
            }
            // 条款标题名称
            if ("0".equals(prpTengageCopy.getTitleFlag())){
                prpTengageCopyDto.setClauseName(prpTengageCopy.getClauses());
            } else {
                if (StringUtils.isEmpty(prpTengageCopyDto.getClausesContent())) {
                    prpTengageCopyDto.setClausesContent(prpTengageCopy.getClauses());
                } else {
                    prpTengageCopyDto.setClausesContent(prpTengageCopyDto.getClausesContent() + prpTengageCopy.getClauses());
                }
            }
        }

        blEndorseDto.setQueryProposalPrpTengageCopyDtoList(prpTengageCopyDtoList);
        return blEndorseDto;
    }
}
