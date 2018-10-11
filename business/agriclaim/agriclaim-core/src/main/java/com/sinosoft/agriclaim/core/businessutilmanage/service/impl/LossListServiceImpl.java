package com.sinosoft.agriclaim.core.businessutilmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestQueryClaimListDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseCheckDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.LossListService;
import com.sinosoft.agriclaim.core.businessutilmanage.utils.FileUtil;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateDao;
import com.sinosoft.agriclaim.core.paymentmanage.service.PaymentGetNoUtilService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfPathLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLogKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfPathLogKey;
import com.sinosoft.agriprpall.api.endorsemanage.PrpCitemKindAgriApi;
import com.sinosoft.agriprpall.api.policymanage.ClaimQueryDeductiblerateApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.proposalmanage.PlantingExcelApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.excel.POIUtils;
import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.agri.core.utils.ExcelUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.txnlist.api.claiminsurancelist.*;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class LossListServiceImpl implements LossListService {

    @Autowired
    PlantingLossRateListApi plantingLossRateListApi;
    @Autowired
    BreedLossRateListApi breedLossRateListApi;
    @Autowired
    LossRateListApi lossRateListApi;
    @Autowired
    InsureMainListApi insureMainListApi;
    @Autowired
    NyxPolicyListApi nyxPolicyListApi;
    @Autowired
    HerdPolicyListApi herdPolicyListApi;
    @Autowired
    NyxPlantingClaimListApi nyxPlantingClaimListApi;
    @Autowired
    NyxBreedClaimListApi nyxBreedClaimListApi;
    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Value("${exportExcelType}")
    private String exportExcelType;
    @Autowired
    private PrpLClaimDao prpLClaimDao;

    @Autowired
    private PrpLRegistDao prpLRegistDao;

    @Autowired
    private PaymentGetNoUtilService paymentGetNoUtilService;
    @Autowired
    private LossRateMainListApi lossRateMainListApi;
    @Autowired
    private SpecCaseListApi specCaseListApi;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PlantingExcelApi plantingExcelApi;
    @Autowired
    private ClaimQueryDeductiblerateApi claimQueryDeductiblerateApi;
    @Autowired
    private SwfPathLogDao swfPathLogDao;
    @Autowired
    private NyxEffectiveAmountApi nyxEffectiveAmountApi;
    @Autowired
    private PrpCitemKindAgriApi prpCitemKindAgriApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpLCompensateDao prpLCompensateDao;

    private Map<String,String> identifyTypeMap;
    private Map<String,String> receiverTypMap;
    private Map<String,String> accountFlagMap;
    private Map<String,String> accountTypeMap;

    public LossListServiceImpl(){
        //证件类型
        identifyTypeMap = new HashMap<>();
        identifyTypeMap.put("01","01-身份证");
        identifyTypeMap.put("02","02-户口簿");
        identifyTypeMap.put("03","03-护照");
        identifyTypeMap.put("04","04-军官证");
        identifyTypeMap.put("05","05-驾驶执照");
        identifyTypeMap.put("06","06-返乡证");
        identifyTypeMap.put("26","26-外国人永久居留身份证");
        identifyTypeMap.put("59","59-其他");
        identifyTypeMap.put("61","61-组织机构代码证");
        identifyTypeMap.put("62","62-税务登记证");
        identifyTypeMap.put("63","63-工商登记证");
        identifyTypeMap.put("64","64-统一社会信用代码证");
        identifyTypeMap.put("99","99-其他");

        //领款人类型
        receiverTypMap = new HashMap<>();
        receiverTypMap.put("t01","t01-投保人");
        receiverTypMap.put("t02","t02-被保险人");
        receiverTypMap.put("t03","t03-受益人");
        receiverTypMap.put("t04","t04-其他个人");
        receiverTypMap.put("t05","t05-其他单位");

        //账号属性
        accountFlagMap = new HashMap<>();
        accountFlagMap.put("1","1-个人");
        accountFlagMap.put("2","2-单位");
        //账号类型
        accountTypeMap = new HashMap<>();
        accountTypeMap.put("00","00-银行卡");
        accountTypeMap.put("01","01-存折");
        accountTypeMap.put("03","03-对公账户");

    }

    /**
     * 按条件查询定损实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public List<LossRateListDto> queryLossByConditions(Map<String, String> map) {
        return lossRateListApi.queryByConditions(map);
    }

    /**
     * 关联种植险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void comparePlantingInsurance(Map<String, String> map) {
        //回写定损清单主表
        lossRateListApi.compareInsurance(map);
        //回写种植险定损清单子表
        plantingLossRateListApi.compareInsurance(map);
    }

    /**
     * 关联养殖险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareBreedInsurance(Map<String, String> map) {
        //回写定损清单主表
        lossRateListApi.compareInsurance(map);
        //回写养殖险定损清单子表
        breedLossRateListApi.compareInsurance(map);
    }

    /**
     * 查询定损清单和承保清单拼接种植险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxPlantingClaimListDto> 种植险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<NyxPlantingClaimListDto> queryPlantingClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        String policyNo = requestQueryClaimListDto.getPolicyNo();
        String registNo = requestQueryClaimListDto.getRegistNo();
        Map<String, String> map = new HashMap<>();
        map.put("policyNo", policyNo);
        map.put("registNo", registNo);
        //获取定损清单对象集合
        List<PlantingLossRateListDto> plantingLossRateListDtoList = plantingLossRateListApi.queryComparable(map);
        if (plantingLossRateListDtoList == null || plantingLossRateListDtoList.size() == 0) {
            throw new BusinessException("没有已关联的定损清单数据！");
        }
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(policyNo);
        if (insureMainListDtoList == null || insureMainListDtoList.size() == 0) {
            throw new BusinessException("承保清单未找到数据！");
        }
        //获取承保清单号
        String inusreListCode = insureMainListDtoList.get(0).getInusreListCode();
        //根据承保清单号获取承保清单子表所有农户信息列表
        List<NyxPolicyListDto> nyxPolicyListDtoList = nyxPolicyListApi.queryByInusreListCode(inusreListCode);
        //定义返回值对象集合
        NyxPlantingClaimListDto nyxPlantingClaimListDto = new NyxPlantingClaimListDto();
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = new ArrayList<>();
        //农户对比标识
        int index = 1;
        //按照农户代码筛选出险的农户清单
        for (int i = 0; i < plantingLossRateListDtoList.size(); i++) {
            for (int j = 0; j < nyxPolicyListDtoList.size(); j++) {
                if (StringUtils.isNotEmpty(plantingLossRateListDtoList.get(i).getfCode())
                        && plantingLossRateListDtoList.get(i).getfCode().equals(nyxPolicyListDtoList.get(j).getfCode())) {
                    nyxPlantingClaimListDto.setListNo(requestQueryClaimListDto.getListNo());
                    nyxPlantingClaimListDto.setSerialNo(index + "");
                    nyxPlantingClaimListDto.setPolicyNo(policyNo);
                    nyxPlantingClaimListDto.setRegistNo(registNo);
                    if (StringUtils.isNotEmpty(requestQueryClaimListDto.getCompensateNo())) {
                        nyxPlantingClaimListDto.setCompensateNo(requestQueryClaimListDto.getCompensateNo());
                    }
                    nyxPlantingClaimListDto.setfCode(nyxPolicyListDtoList.get(j).getfCode());
                    nyxPlantingClaimListDto.setfName(nyxPolicyListDtoList.get(j).getfName());
                    nyxPlantingClaimListDto.setfIdCard(nyxPolicyListDtoList.get(j).getfIdCard());
                    nyxPlantingClaimListDto.setPhoneNumber(nyxPolicyListDtoList.get(j).getPhone());
                    //todo
                    //nyxPlantingClaimListDto.setRemainingArea 	();//计算剩余面积
                    //nyxPlantingClaimListDto.setRemainingAmount 	(remainingAmount);//剩余保额
                    nyxPlantingClaimListDto.setClaimRiskCode(nyxPolicyListDtoList.get(j).getKindCode());//险别
                    nyxPlantingClaimListDto.setFieldSource(nyxPolicyListDtoList.get(j).getFieldSource());
                    //nyxPlantingClaimListDto.setClaimRate 		(plantingLossRateListDtoList.get(i));//赔付比例
                    nyxPlantingClaimListDto.setLossArea(plantingLossRateListDtoList.get(i).getLossArea());
                    nyxPlantingClaimListDto.setLossRate(plantingLossRateListDtoList.get(i).getLossRate());
                    //nyxPlantingClaimListDto.setSettleAmount 	(plantingLossRateListDtoList.get(i));//赔偿金额
                    nyxPlantingClaimListDto.setBankAccount(nyxPolicyListDtoList.get(j).getBankCard());
                    nyxPlantingClaimListDto.setItemCode(nyxPolicyListDtoList.get(j).getItemCode());
                    nyxPlantingClaimListDto.setPayType("C");//支付类型
                    nyxPlantingClaimListDtoList.add(nyxPlantingClaimListDto);
                    index++;
                }
            }
        }
        if (index < plantingLossRateListDtoList.size()) {
            throw new BusinessException("定损清单存在农户信息在承保清单中找不到！");
        }
        return nyxPlantingClaimListDtoList;
    }

    /**
     * 查询定损清单和承保清单拼接养殖险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxBreedClaimListDto> 养殖险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<NyxBreedClaimListDto> queryBreedClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        String policyNo = requestQueryClaimListDto.getPolicyNo();
        String registNo = requestQueryClaimListDto.getRegistNo();
        Map<String, String> map = new HashMap<>();
        map.put("policyNo", policyNo);
        map.put("registNo", registNo);
        List<BreedLossRateListDto> breedLossRateListDtoList = breedLossRateListApi.queryComparable(map);
        if (breedLossRateListDtoList == null || breedLossRateListDtoList.size() == 0) {
            throw new BusinessException("没有已关联的定损清单数据！");
        }
        List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(policyNo);
        if (insureMainListDtoList == null || insureMainListDtoList.size() == 0) {
            throw new BusinessException("承保清单未找到数据！");
        }
        //获取承保清单号
        String inusreListCode = insureMainListDtoList.get(0).getInusreListCode();
        //根据承保清单号获取承保清单子表所有农户信息列表
        List<HerdPolicyListDto> herdPolicyListDtoList = herdPolicyListApi.queryByInusreListCode(inusreListCode);
        //定义返回值对象集合
        NyxBreedClaimListDto nyxBreedClaimListDto = new NyxBreedClaimListDto();
        List<NyxBreedClaimListDto> nyxBreedClaimListDtoList = new ArrayList<>();
        //农户对比标识
        int index = 1;
        //按照农户代码筛选出险的农户清单
        for (int i = 0; i < breedLossRateListDtoList.size(); i++) {
            for (int j = 0; j < herdPolicyListDtoList.size(); j++) {
                if (StringUtils.isNotEmpty(breedLossRateListDtoList.get(i).getfCode())
                        && breedLossRateListDtoList.get(i).getfCode().equals(herdPolicyListDtoList.get(j).getfCode())
                        && breedLossRateListDtoList.get(i).getEarConNo().equals(herdPolicyListDtoList.get(j).getEarlAbel())) {
                    nyxBreedClaimListDto.setListNo(requestQueryClaimListDto.getListNo());
                    nyxBreedClaimListDto.setSerialNo(index + "");
                    nyxBreedClaimListDto.setPolicyNo(policyNo);
                    nyxBreedClaimListDto.setRegistNo(registNo);
                    if (StringUtils.isNotEmpty(requestQueryClaimListDto.getCompensateNo())) {
                        nyxBreedClaimListDto.setCompensateNo(requestQueryClaimListDto.getCompensateNo());
                    }
                    nyxBreedClaimListDto.setfCode(herdPolicyListDtoList.get(j).getfCode());
                    nyxBreedClaimListDto.setfName(herdPolicyListDtoList.get(j).getfName());
                    nyxBreedClaimListDto.setfIdCard(herdPolicyListDtoList.get(j).getfIdCard());
                    nyxBreedClaimListDto.setPhoneNumber(herdPolicyListDtoList.get(j).getPhone());
                    nyxBreedClaimListDto.setBankAccount(herdPolicyListDtoList.get(j).getBankCard());
                    nyxBreedClaimListDto.setEarConNo(herdPolicyListDtoList.get(j).getEarlAbel());
                    nyxBreedClaimListDto.setPayAmount(breedLossRateListDtoList.get(i).getPayAmount());
                    nyxBreedClaimListDto.setPayType("C");
                    nyxBreedClaimListDto.setItemCode("");//标的信息
                    nyxBreedClaimListDtoList.add(nyxBreedClaimListDto);
                    index++;
                }
            }
        }
        if (index < breedLossRateListDtoList.size()) {
            throw new BusinessException("定损清单存在农户信息在承保清单中找不到！");
        }
        return nyxBreedClaimListDtoList;
    }

    /**
     * 种植险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @Override
    public String expPlantingClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        //调用查询接口

        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = this.queryPlantingClaimList(requestQueryClaimListDto);
        String titleName = "";
        String excelName = "";
        String shortLinkId = null;
        // 采用反射的方式动态修改注解内容
        Class<NyxPlantingClaimListDto> plantingClaimListClass = NyxPlantingClaimListDto.class;
        /** 修改部分字段为显示或不显示 */
        // 当日清单通过动态修改注解的方式屏蔽delinQuentFee字段为不导出到Excel
        /*POIUtils.modfiyAnnotationKey(plantingClaimListClass,"delinQuentFee","enabled",false);
        // 通过动态修改注解的方式修改planFee字段为导出到Excel
        POIUtils.modfiyAnnotationKey(plantingClaimListClass,"planFee","enabled",true);
        POIUtils.modfiyAnnotationKey(plantingClaimListClass,"delinQuentFee","value","未缴保险费");*/
        excelName = titleName = "国元保险理赔清单";

        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    nyxPlantingClaimListDtoList, 1, 8, plantingClaimListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * 养殖险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @Override
    public String expBreedClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        //调用查询接口

        List<NyxBreedClaimListDto> nyxBreedClaimListDtoList = this.queryBreedClaimList(requestQueryClaimListDto);
        String titleName = "";
        String excelName = "";
        String shortLinkId = null;
        // 采用反射的方式动态修改注解内容
        Class<NyxBreedClaimListDto> breedClaimListClass = NyxBreedClaimListDto.class;
        excelName = titleName = "国元保险理赔清单";

        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    nyxBreedClaimListDtoList, 1, 8, breedClaimListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }


    /**
     * 种植险理赔清单导出Excel
     * @param requestNyxPlantingClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码 、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */
    @Override
    public Map<String,String> nyxPlantingClaimListExportExcel(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception {
        Map<String,String> map = new HashMap();
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = new ArrayList<>();
        Class<NyxPlantingClaimListDto> claimListDtoClass = NyxPlantingClaimListDto.class;
        String classCode=requestNyxPlantingClaimListDto.getPolicyNo().substring(1,5);
        String titleName = "";
        String excelName = "";
        String shortLinkId = "";
        int lastCol;
        FileOutputStream os =null;
        FileInputStream finput=null;
        //免赔率查询
        Map<String,String> queryMap = new HashMap<>();
        List<PrpCitemKindDto> prpCitemKindDtos = prpCitemKindApi.queryItemCodeByPolicyNo(requestNyxPlantingClaimListDto.getPolicyNo());
        List<ClaimQueryDeductiblerateDto>  claimQueryDeductiblerateDtoList = new ArrayList<>();
        for(int i=0;i<prpCitemKindDtos.size();i++){
            queryMap.put("policyNo",prpCitemKindDtos.get(i).getPolicyNo());
            queryMap.put("itemCode",prpCitemKindDtos.get(i).getItemCode());
            queryMap.put("kindCode",prpCitemKindDtos.get(i).getKindCode());
            ClaimQueryDeductiblerateDto claimQueryDeductiblerateDto = claimQueryDeductiblerateApi.queryDeductiblerate(queryMap);
            claimQueryDeductiblerateDtoList.add(claimQueryDeductiblerateDto);
        }
        if("3130".equals(classCode)){
            POIUtils.modfiyAnnotationKey(claimListDtoClass,"name","enabled",true);
            POIUtils.modfiyAnnotationKey(claimListDtoClass,"no","enabled",true);
            lastCol=22;
        }else{
            POIUtils.modfiyAnnotationKey(claimListDtoClass,"name","enabled",false);
            POIUtils.modfiyAnnotationKey(claimListDtoClass,"no","enabled",false);
            lastCol=20;
        }
        if("3224".equals(classCode)||"3237".equals(classCode)){
            excelName = titleName = "养殖险理赔清单";
        }else{
            excelName = titleName = "种植险理赔清单";
        }
        Class<NyxPlantingClaimListDto> plantingClaimListClass = NyxPlantingClaimListDto.class;
        nyxPlantingClaimListDtoList = nyxPlantingClaimListApi.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
        if(nyxPlantingClaimListDtoList.size()<1){
            requestNyxPlantingClaimListDto.setNodeType("claim");
            nyxPlantingClaimListDtoList = nyxPlantingClaimListApi.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
        }
        List<PrpLClaim> prpLClaims = prpLClaimDao.queryAllByRegistNo(requestNyxPlantingClaimListDto.getRegistNo());
        NyxPlantingClaimListDto nyxPlantingClaimListDto1=new NyxPlantingClaimListDto();
        PrpLRegist byRegistNo = prpLRegistDao.findByRegistNo(requestNyxPlantingClaimListDto.getRegistNo());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date reportDate = byRegistNo.getReportDate();
        Date damageStartDate = byRegistNo.getDamageStartDate();
        List<PrpCitemKindDto> prpCitemKindDtos1 = prpCitemKindApi.queryItemCodeByPolicyNo(requestNyxPlantingClaimListDto.getPolicyNo());
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map2.put("policyNo", requestNyxPlantingClaimListDto.getPolicyNo());
        map2.put("starDate", format.format(damageStartDate));
        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtos1) {
            map1.put(prpCitemKindDto.getKindCode() + prpCitemKindDto.getItemCode(), prpCitemKindDto.getItemNo());
        }
        Map<String, Double> map3 = nyxEffectiveAmountApi.queryNyxEffectiveAmountByPolicyNo1(map2);
        if(nyxPlantingClaimListDtoList.size()>0) {
            for (int i = 0; i < nyxPlantingClaimListDtoList.size(); i++) {
                //有效保额的校验
                NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
                nyxEffectiveAmountDto.setPolicyNo(nyxPlantingClaimListDtoList.get(i).getPolicyNo());
                nyxEffectiveAmountDto.setRiskCode(nyxPlantingClaimListDtoList.get(i).getPolicyNo().substring(1,5));
                nyxEffectiveAmountDto.setKindCode(nyxPlantingClaimListDtoList.get(i).getClaimRiskCode());
                nyxEffectiveAmountDto.setItemCode(nyxPlantingClaimListDtoList.get(i).getItemCode());
                nyxEffectiveAmountDto.setfCode(nyxPlantingClaimListDtoList.get(i).getfCode());
                Map<String,Object> params=new HashMap<>();
                params.put("policyNo",nyxPlantingClaimListDtoList.get(i).getPolicyNo());
                params.put("kindCode",nyxPlantingClaimListDtoList.get(i).getClaimRiskCode());
                params.put("itemCode",nyxPlantingClaimListDtoList.get(i).getItemCode());
                params.put("riskCode",nyxPlantingClaimListDtoList.get(i).getPolicyNo().substring(1,5));
                params.put("registNo",nyxPlantingClaimListDtoList.get(i).getRegistNo());
                params.put("reportDate", format.format(reportDate));
//                List<PrpCitemKindDto> prpCitemKindDtos1 = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(params);
                Integer itemKindNo=0;
                if (map1.containsKey(nyxPlantingClaimListDtoList.get(i).getClaimRiskCode() + nyxPlantingClaimListDtoList.get(i).getItemCode())) {
                    itemKindNo = map1.get(nyxPlantingClaimListDtoList.get(i).getClaimRiskCode() + nyxPlantingClaimListDtoList.get(i).getItemCode());
                }
                params.put("itemKindNo",itemKindNo);
                //茬次
                int flag = nyxPlantingClaimListApi.checkStubbleByRegistNo1(params);
                nyxEffectiveAmountDto.setFlag(flag);
                //根据报案号查询出险日期
                nyxEffectiveAmountDto.setStartDate(byRegistNo.getDamageStartDate());
//                NyxEffectiveAmountDto nyxEffectiveAmountDto1 = nyxEffectiveAmountApi.queryAll(nyxEffectiveAmountDto);
                if (map3 == null) {
                    throw new BusinessException("保单有效保额为空,请核对！");
                }

                nyxPlantingClaimListDtoList.get(i).setEffectiveGuarantee(String.valueOf(map3.get(nyxEffectiveAmountDto.getfCode() + nyxEffectiveAmountDto.getItemCode() + nyxEffectiveAmountDto.getKindCode() + nyxEffectiveAmountDto.getFlag())));
                if ("C".equals(nyxPlantingClaimListDtoList.get(i).getPayType())) {
                    nyxPlantingClaimListDtoList.get(i).setPayType("C-实赔");
                }else{
                    nyxPlantingClaimListDtoList.get(i).setPayType("Y-预赔");
                }
            }
        }
        if(nyxPlantingClaimListDtoList.size()<1||nyxPlantingClaimListDtoList==null&&"import".equals(requestNyxPlantingClaimListDto.getType())){
            Map<String,String> lossMap = new HashMap();
            lossMap.put("policyNo",requestNyxPlantingClaimListDto.getPolicyNo());
            lossMap.put("registNo",requestNyxPlantingClaimListDto.getRegistNo());
            List<ResponsePlantingLossRateListDto> responsePlantingLossRateList = null;
            responsePlantingLossRateList = lossRateMainListApi.queryPlantingLossRateListByLossListCode(lossMap);

            //种植险
            if (responsePlantingLossRateList != null && responsePlantingLossRateList.size() > 0) {
                //添加下载逻辑
                //组装数据
                Map<String, String> itemMap = new HashMap<>();
                itemMap.put("riskCode", requestNyxPlantingClaimListDto.getPolicyNo().substring(1, 5));
                Map<String, String> prpDitemAgriDtoMap = prpDitemAgriApi.queryPrpDitemDto(itemMap);
                List<PrpDitemAgriDto> prpDitemAgriDtoList=new ArrayList<>();
                        for (int i = 0; i < responsePlantingLossRateList.size(); i++) {
                            NyxPlantingClaimListDto nyxPlantingClaimListDto = new NyxPlantingClaimListDto();
//                            if("1".equals(responsePlantingLossRateList.get(i).getOrigin())){
                                nyxPlantingClaimListDto.setSerialNo(String.valueOf(i+1));
                                nyxPlantingClaimListDto.setPolicyNo(responsePlantingLossRateList.get(i).getPolicyNo());
                                nyxPlantingClaimListDto.setRegistNo(responsePlantingLossRateList.get(i).getBizNo());
                                if(prpLClaims.size()>0) {
                                    nyxPlantingClaimListDto.setClaimNo(prpLClaims.get(0).getClaimNo());
                                }
                                nyxPlantingClaimListDto.setfCode(responsePlantingLossRateList.get(i).getFcode());
                                nyxPlantingClaimListDto.setfName(responsePlantingLossRateList.get(i).getFname());
                                nyxPlantingClaimListDto.setfIdCard(responsePlantingLossRateList.get(i).getFidCard());
                            if (prpDitemAgriDtoMap.size() > 0) {
                                    nyxPlantingClaimListDto.setItemCode(responsePlantingLossRateList.get(i).getItemCode() + "-" + prpDitemAgriDtoMap.get(responsePlantingLossRateList.get(i).getItemCode()));
                                }
                                nyxPlantingClaimListDto.setLossArea(responsePlantingLossRateList.get(i).getLossAmount());
                                nyxPlantingClaimListDto.setLossRate(responsePlantingLossRateList.get(i).getLossRate());
                                nyxPlantingClaimListDto.setClaimRiskCode(responsePlantingLossRateList.get(i).getKindCode());
                                nyxPlantingClaimListDto.setSettleAmount(responsePlantingLossRateList.get(i).getLossMoney());
                                nyxPlantingClaimListDtoList.add(nyxPlantingClaimListDto);
//                            }
                }
            }else{
                    //查询承保清单
                    //查询养殖险承保清单
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    List<AcceptInsuranceDto> acceptInsuranceDtos =null;
                    if(StringUtils.isEmpty(requestNyxPlantingClaimListDto.getRegistNo())){
                        //报案登记的时候取出险时间为当前时间
                        lossMap.put("validDate",simpleDateFormat.format(new Date()));
                        acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(lossMap);
                    }else{
                        //查询出险时间
                        PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(requestNyxPlantingClaimListDto.getRegistNo());
                        lossMap.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
                        acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(lossMap);
                    }
                    //组装种植险的定损清单数据
                    if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
                        throw new Exception("保单清单异常，无法生成理赔清单");
                    }
                    for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                        NyxPlantingClaimListDto nyxPlantingClaimListDto = new NyxPlantingClaimListDto();
                        nyxPlantingClaimListDto.setPolicyNo(lossMap.get("policyNo"));
                        nyxPlantingClaimListDto.setRegistNo(lossMap.get("registNo"));
                        nyxPlantingClaimListDto.setfCode(acceptInsuranceDto.getfCode());
                        nyxPlantingClaimListDto.setfName(acceptInsuranceDto.getfName());
                        nyxPlantingClaimListDto.setfIdCard(acceptInsuranceDto.getfIdCard());
                        nyxPlantingClaimListDto.setItemCode(acceptInsuranceDto.getItemCode());
                        nyxPlantingClaimListDtoList.add(nyxPlantingClaimListDto);
                    }
            }
        }
        for(int i=0;i<nyxPlantingClaimListDtoList.size();i++){
            if(claimQueryDeductiblerateDtoList.get(0).getEachDeductibleRate()!=null&&claimQueryDeductiblerateDtoList.get(0).getEachDeductibleRate()!="") {
                nyxPlantingClaimListDtoList.get(i).setDeductible(claimQueryDeductiblerateDtoList.get(0).getEachDeductibleRate());//绝对免赔率
            }else{
                nyxPlantingClaimListDtoList.get(i).setDeductible("0");
            }
            for(int j=0;j<claimQueryDeductiblerateDtoList.size();j++){
                if(nyxPlantingClaimListDtoList.get(i).getItemCode().split("-")[0].equals(claimQueryDeductiblerateDtoList.get(j).getItemCode())){
                    nyxPlantingClaimListDtoList.get(i).setAccident(String.valueOf(claimQueryDeductiblerateDtoList.get(j).getDeductibleRate()));//每次事故免赔率
                }
            }

        }
        if(nyxPlantingClaimListDtoList.size()<1||nyxPlantingClaimListDtoList==null){
            throw new BusinessException("无种植险理赔清单数据信息");
        }
        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    nyxPlantingClaimListDtoList, 1, lastCol, plantingClaimListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> list=new ArrayList<>();
            HashSet<String> kingList = new HashSet<>();
            List<String> typelist=new ArrayList<>();
//            for (NyxPlantingClaimListDto nyxPlantingClaimListDto  : nyxPlantingClaimListDtoList) {
//                if(nyxPlantingClaimListDto.getItemCode()!=null){
//                    list.add(prpDitemAgriDto.getItemCode()+"-"+prpDitemAgriDto.getItemCName());
//                }
//            }
//            for (NyxPlantingClaimListDto nyxPlantingClaimListDto  : nyxPlantingClaimListDtoList) {
//                if(nyxPlantingClaimListDto.getPayType()!=null){
                    typelist.add("C-实赔");
                    typelist.add("Y-预赔");
//                }
//            }
            List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryItemCodeByPolicyNo(requestNyxPlantingClaimListDto.getPolicyNo());
            for(PrpCitemKindDto prpCitemKindDto:prpCitemKindDtoList){
                if(prpCitemKindDto.getKindCode()!=null&&prpCitemKindDto.getKindName()!=null){
                    kingList.add(prpCitemKindDto.getKindCode()+"-"+prpCitemKindDto.getKindName());
                }
            }
//            if(list!=null&&list.size()>0){
//                FileInputStream finput = new FileInputStream(file.getAbsolutePath());
//                POIFSFileSystem fs = new POIFSFileSystem(finput);
//                HSSFWorkbook hs = new HSSFWorkbook(fs);
//                HSSFSheet sheet = hs.getSheetAt(0);
//                //list转为数组
//                int size = list.size();
//                Integer currentRow=size+3;
//                CellRangeAddressList regions = new CellRangeAddressList(3, currentRow, 10, 10);//标的下拉框
//                // 创建下拉列表数据
//                DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])list.toArray(new String[size]));
//                // 绑定
//                HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
//                sheet.addValidationData(dataValidation);
//                os = new FileOutputStream(file.getAbsolutePath());
//                hs.write(os);
//            }
            finput = new FileInputStream(file.getAbsolutePath());
            POIFSFileSystem fs = new POIFSFileSystem(finput);
            HSSFWorkbook hs = new HSSFWorkbook(fs);
            HSSFSheet sheet = hs.getSheetAt(0);
            int size1 = nyxPlantingClaimListDtoList.size();
            if(typelist!=null&&typelist.size()>0){
                //list转为数组
                int size2 = typelist.size();
                Integer currentRow=size1+2;
                CellRangeAddressList regions1 = new CellRangeAddressList(3, currentRow, 18, 18);//险别下拉框
                // 创建下拉列表数据
                DVConstraint constraint1 = DVConstraint.createExplicitListConstraint((String[])typelist.toArray(new String[size2]));
                // 绑定
                HSSFDataValidation dataValidation1 = new HSSFDataValidation(regions1, constraint1);
                sheet.addValidationData(dataValidation1);
                /*os = new FileOutputStream(file.getAbsolutePath());
                hs.write(os);*/
            }
            if(kingList!=null&&kingList.size()>0){
               /* FileInputStream finput = new FileInputStream(file.getAbsolutePath());
                POIFSFileSystem fs = new POIFSFileSystem(finput);
                HSSFWorkbook hs = new HSSFWorkbook(fs);
                HSSFSheet sheet = hs.getSheetAt(0);
                //list转为数组
                int size1 = nyxPlantingClaimListDtoList.size();*/
                int size2=kingList.size();
                Integer currentRow=size1+2;
                CellRangeAddressList regions1 = new CellRangeAddressList(3, currentRow, 9, 9);//险别下拉框
                // 创建下拉列表数据
                DVConstraint constraint1 = DVConstraint.createExplicitListConstraint((String[])kingList.toArray(new String[size2]));
                // 绑定
                HSSFDataValidation dataValidation1 = new HSSFDataValidation(regions1, constraint1);
                sheet.addValidationData(dataValidation1);
            }
            //创建批注
            HSSFPatriarch p=sheet.createDrawingPatriarch();
            //批注行与列
            HSSFCell cell = sheet.getRow(2).getCell(14);

            //前四个参数是坐标点,后四个参数是编辑和显示批注时的大小.
            HSSFComment comment=p.createComment(new HSSFClientAnchor(0,0,0,0,(short)3,4,(short)5,6));
            //输入批注信息
            comment.setString(new HSSFRichTextString("请输入0-1之间的数!"));
            //将批注添加到单元格对象中
            cell.setCellComment(comment);
            os = new FileOutputStream(file.getAbsolutePath());
            hs.write(os);
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
            map.put("shortLink",shortLinkId);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
            if(os!=null){
                os.close();
            }
            if(finput!=null){
                finput.close();
            }

        }
        return map;
    }

    /**
     * 养殖险理赔清单导出Excel
     * @param requestNyxBreedClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */

    @Override
    public Map<String,String> nyxBreedClaimListExportExcel(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto) throws Exception {
        List<NyxBreedClaimListDto> nyxBreedClaimListDtoList = new ArrayList<>();
        Map<String,String> map = new HashMap();
        String titleName = "";
        String excelName = "";
        String shortLinkId = "";
        FileOutputStream os =null;
        excelName = titleName = "养殖险理赔清单";
        Class<NyxBreedClaimListDto> breedClaimListClass = NyxBreedClaimListDto.class;
            nyxBreedClaimListDtoList = nyxBreedClaimListApi.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
            if(nyxBreedClaimListDtoList.size()<1){
                requestNyxBreedClaimListDto.setNodeType("claim");
                nyxBreedClaimListDtoList =nyxBreedClaimListApi.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
            }
        if(nyxBreedClaimListDtoList.size()>0) {
            //初始化耳标号是否赔付
            String policyNo="";
            List<String> prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByPolicyNo(nyxBreedClaimListDtoList.get(0).getPolicyNo());
            List<NyxBreedClaimListDto> breedClaimListDtos = nyxBreedClaimListApi.queryByClaimNo(prpLCompensateList);
            if(breedClaimListDtos.size()>0) {
                for (int i = 0; i < nyxBreedClaimListDtoList.size(); i++) {
                    nyxBreedClaimListDtoList.get(i).setIsIndemnity("否");
                    for (int j = 0; j < breedClaimListDtos.size(); j++) {
                        if (nyxBreedClaimListDtoList.get(i).getEarConNo().equals(breedClaimListDtos.get(j).getEarConNo())){
                            nyxBreedClaimListDtoList.get(i).setIsIndemnity("是");
                            break;
                        }
                    }
                    //核赔通过
//                if("1".equals(prpLCompensateList.get(i).getUnderWriteFlag())){
//                    policyNo=prpLCompensateList.get(i).getPolicyNo();
//                }
                }
            }else{
                for(int i = 0; i < nyxBreedClaimListDtoList.size(); i++){
                    nyxBreedClaimListDtoList.get(i).setIsIndemnity("否");
                }
            }
//            //查询清单信息
//            List<InsureMainListDto> insureMainListDtoList=null ;
//            if(!"".equals(policyNo)){
//                 insureMainListDtoList = insureMainListApi.queryByPolicyNo(policyNo);
//                List<HerdPolicyListDto> herdPolicyListDtos = herdPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
//                for (int i = 0; i < nyxBreedClaimListDtoList.size(); i++) {
//                    nyxBreedClaimListDtoList.get(i).setIsIndemnity("否");
//                    for(int j=0;j<herdPolicyListDtos.size();j++){
//                        if(nyxBreedClaimListDtoList.get(i).getEarConNo().equals(herdPolicyListDtos.get(j).getEarlAbel())){
//                            nyxBreedClaimListDtoList.get(i).setIsIndemnity("是");
//                        }
//                    }
//                }
//            }
            for (int i = 0; i < nyxBreedClaimListDtoList.size(); i++) {
                if ("C".equals(nyxBreedClaimListDtoList.get(i).getPayType())) {
                    nyxBreedClaimListDtoList.get(i).setPayType("C-实赔");
                }else{
                    nyxBreedClaimListDtoList.get(i).setPayType("Y-预赔");
                }
            }
        }
          if(nyxBreedClaimListDtoList.size()<1||nyxBreedClaimListDtoList==null&&requestNyxBreedClaimListDto.getType()=="import"){
              Map<String,String> lossMap = new HashMap();
              lossMap.put("policyNo",requestNyxBreedClaimListDto.getPolicyNo());
              lossMap.put("registNo",requestNyxBreedClaimListDto.getRegistNo());
              List<ResponseBreedLossRateListDto> responseBreedLossRateList=null;
              responseBreedLossRateList = lossRateMainListApi.queryBreedLossRateListByLossListCode(lossMap);
              List<PrpLClaim> prpLClaims = prpLClaimDao.queryAllByRegistNo(requestNyxBreedClaimListDto.getRegistNo());
              if (responseBreedLossRateList != null && responseBreedLossRateList.size() > 0) {
                  //添加下载逻辑
                  //组装数据
                  List<PrpDitemAgriDto> prpDitemAgriDtoList=new ArrayList<>();
                  for (int i = 0; i < responseBreedLossRateList.size(); i++) {
                      Map<String,String> itemMap = new HashMap<>();
                      itemMap.put("riskCode",requestNyxBreedClaimListDto.getPolicyNo().substring(1,5));
                      itemMap.put("itemCode",responseBreedLossRateList.get(i).getItemCode());
                      PrpDitemAgriDto prpDitemAgriDto = prpDitemAgriApi.queryByPk(itemMap);
                      if(prpDitemAgriDto!=null){
                          prpDitemAgriDtoList.add(prpDitemAgriDto);
                      }
                      NyxBreedClaimListDto nyxBreedClaimListDto = new NyxBreedClaimListDto();
//                      if("1".equals(responseBreedLossRateList.get(i).getOrigin())){
                          nyxBreedClaimListDto.setSerialNo(String.valueOf(i+1));
                          nyxBreedClaimListDto.setPolicyNo(responseBreedLossRateList.get(i).getPolicyNo());
                          nyxBreedClaimListDto.setRegistNo(responseBreedLossRateList.get(i).getBizNo());
                          if(prpLClaims.size()>0){
                              nyxBreedClaimListDto.setClaimNo(prpLClaims.get(0).getClaimNo());
                          }
                          nyxBreedClaimListDto.setfCode(responseBreedLossRateList.get(i).getFcode());
                          nyxBreedClaimListDto.setfName(responseBreedLossRateList.get(i).getFname());
                      if(prpDitemAgriDtoList.size()>0){
                          nyxBreedClaimListDto.setItemCode(prpDitemAgriDtoList.get(i).getItemCode()+"-"+prpDitemAgriDtoList.get(i).getItemCName());
                      }
                          nyxBreedClaimListDto.setfIdCard(responseBreedLossRateList.get(i).getfIdCard());
                          nyxBreedClaimListDto.setEarConNo(responseBreedLossRateList.get(i).getEarLabel());
                          nyxBreedClaimListDto.setIsIndemnity("否");
                          nyxBreedClaimListDtoList.add(nyxBreedClaimListDto);
//                      }
                  }
                  List<String> prpLCompensateList = prpLCompensateDao.queryPrpLCompensatesByPolicyNo(nyxBreedClaimListDtoList.get(0).getPolicyNo());
                  List<NyxBreedClaimListDto> breedClaimListDtos = nyxBreedClaimListApi.queryByClaimNo(prpLCompensateList);
                  if(breedClaimListDtos.size()>0) {
                      for (int i = 0; i < nyxBreedClaimListDtoList.size(); i++) {
                          nyxBreedClaimListDtoList.get(i).setIsIndemnity("否");
                          for (int j = 0; j < breedClaimListDtos.size(); j++) {
                              if (nyxBreedClaimListDtoList.get(i).getEarConNo().equals(breedClaimListDtos.get(j).getEarConNo())){
                                  nyxBreedClaimListDtoList.get(i).setIsIndemnity("是");
                                  break;
                              }
                          }
                      }
                  }
              }else{
                  //查询承保清单
                  //查询养殖险承保清单
                  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                  List<AcceptInsuranceDto> acceptInsuranceDtos =null;
                  if(StringUtils.isEmpty(requestNyxBreedClaimListDto.getRegistNo())){
                      //报案登记的时候取出险时间为当前时间
                      lossMap.put("validDate",simpleDateFormat.format(new Date()));
                      acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(lossMap);
                  }else{
                      //查询出险时间
                      PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(map.get("registNo"));
                      lossMap.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
                      acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(lossMap);
                  }
                  //组装种植险的定损清单数据
                  if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
                      throw new Exception("保单清单异常，无法生成理赔清单");
                  }
                  for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                      NyxBreedClaimListDto nyxBreedClaimListDto = new NyxBreedClaimListDto();
                      nyxBreedClaimListDto.setPolicyNo(lossMap.get("policyNo"));
                      nyxBreedClaimListDto.setRegistNo(lossMap.get("registNo"));
                      nyxBreedClaimListDto.setfCode(acceptInsuranceDto.getfCode());
                      nyxBreedClaimListDto.setfName(acceptInsuranceDto.getfName());
                      nyxBreedClaimListDto.setfIdCard(acceptInsuranceDto.getfIdCard());
                      nyxBreedClaimListDto.setItemCode(acceptInsuranceDto.getItemCode());
                      nyxBreedClaimListDtoList.add(nyxBreedClaimListDto);
                  }
              }
          }
        if(nyxBreedClaimListDtoList.size()<1||nyxBreedClaimListDtoList==null){
            throw new BusinessException("无养殖险理赔清单数据");
        }
        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    nyxBreedClaimListDtoList, 1, 15, breedClaimListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> list=new ArrayList<>();
            HashSet<String> kingList = new HashSet<>();
//            for (NyxBreedClaimListDto nyxBreedClaimListDto  : nyxBreedClaimListDtoList) {
//                if(nyxBreedClaimListDto.getItemCode()!=null){
//                    list.add(prpDitemAgriDto.getItemCode()+"-"+prpDitemAgriDto.getItemCName());
//                }
//            }
            List<String> typelist=new ArrayList<>();
//            for (NyxBreedClaimListDto nyxBreedClaimListDto  : nyxBreedClaimListDtoList) {
//                if(nyxBreedClaimListDto.getItemCode()!=null){
                    typelist.add("C-实赔");
                    typelist.add("Y-预赔");
//                }
//            }
            List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryItemCodeByPolicyNo(requestNyxBreedClaimListDto.getPolicyNo());
            for(PrpCitemKindDto prpCitemKindDto:prpCitemKindDtoList){
                if(prpCitemKindDto.getKindCode()!=null&&prpCitemKindDto.getKindName()!=null){
                    kingList.add(prpCitemKindDto.getKindCode()+"-"+prpCitemKindDto.getKindName());
                }
            }
//            if(list!=null&&list.size()>0){
//                FileInputStream finput = new FileInputStream(file.getAbsolutePath());
//                POIFSFileSystem fs = new POIFSFileSystem(finput);
//                HSSFWorkbook hs = new HSSFWorkbook(fs);
//                HSSFSheet sheet = hs.getSheetAt(0);
//                //list转为数组
//                int size = list.size();
//                Integer currentRow=size+3;
//                CellRangeAddressList regions = new CellRangeAddressList(3, currentRow, 10, 10);//标的下拉框
//                // 创建下拉列表数据
//                DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])list.toArray(new String[size]));
//                // 绑定
//                HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
//                sheet.addValidationData(dataValidation);
//                os = new FileOutputStream(file.getAbsolutePath());
//                hs.write(os);
//            }
            if(typelist!=null&&typelist.size()>0){
                FileInputStream finput = new FileInputStream(file.getAbsolutePath());
                POIFSFileSystem fs = new POIFSFileSystem(finput);
                HSSFWorkbook hs = new HSSFWorkbook(fs);
                HSSFSheet sheet = hs.getSheetAt(0);
                //list转为数组
                int size1 = nyxBreedClaimListDtoList.size();
                int size2 = typelist.size();
                Integer currentRow=size1+2;
                CellRangeAddressList regions1 = new CellRangeAddressList(3, currentRow, 13, 13);//险别下拉框
                // 创建下拉列表数据
                DVConstraint constraint1 = DVConstraint.createExplicitListConstraint((String[])typelist.toArray(new String[size2]));
                // 绑定
                HSSFDataValidation dataValidation1 = new HSSFDataValidation(regions1, constraint1);
                sheet.addValidationData(dataValidation1);
                os = new FileOutputStream(file.getAbsolutePath());
                hs.write(os);
            }
            if(kingList!=null&&kingList.size()>0){
                FileInputStream finput = new FileInputStream(file.getAbsolutePath());
                POIFSFileSystem fs = new POIFSFileSystem(finput);
                HSSFWorkbook hs = new HSSFWorkbook(fs);
                HSSFSheet sheet = hs.getSheetAt(0);
                //list转为数组
                int size1 = nyxBreedClaimListDtoList.size();
                int size2=kingList.size();
                Integer currentRow=size1+2;
                CellRangeAddressList regions1 = new CellRangeAddressList(3, currentRow, 9, 9);//险别下拉框
                // 创建下拉列表数据
                DVConstraint constraint1 = DVConstraint.createExplicitListConstraint((String[])kingList.toArray(new String[size2]));
                // 绑定
                HSSFDataValidation dataValidation1 = new HSSFDataValidation(regions1, constraint1);
                sheet.addValidationData(dataValidation1);
                os = new FileOutputStream(file.getAbsolutePath());
                hs.write(os);
            }
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统value = {char[48]@31466}
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
            map.put("shortLink",shortLinkId);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return map;

    }

    /**
     * （种植险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/28 20:34
     * @param fileId  文件标识id
     * @param comCode 班表机构
     * @param growthPeriod 苗期
     * @param nodeType 节点类型
     * @param  damageWay 出险方式
     * @param damageDegree 溃塘程度/泛塘时间
     * @return 返回清单号和总赔偿金额
     * @throws Exception
     */
    @Override
    public Map<String,Object> importPlantingClaimListExcel(String fileId, String comCode,String growthPeriod,String nodeType,String damageWay,String damageDegree) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空!");
        }
        if (StringUtils.isEmpty(growthPeriod)) {
            throw new DataVerifyException("请选择生长期!");
        }
        if (StringUtils.isEmpty(fileId)) {
            throw new DataVerifyException("文件传入失败!");
        }
        //初始化工具类
        ExcelUtil excelUtil = ExcelUtil.initImport();
        Map<String, String> otherParams = new HashMap<String, String>();
        otherParams.put("fileId", fileId);
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = null;
        File file = null;
        try {
            file = File.createTempFile("种植险理赔清单", exportExcelType);
            FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, otherParams);
            BussinessListReader bussinessListReader = new BussinessListReader();
            excelUtil.setStartRowNumber(3).readExcel(file, bussinessListReader);
            nyxPlantingClaimListDtoList = bussinessListReader.getNyxPlantingClaimListDtoList();
        } finally {
            //删除本地临时文件
            if (file != null) {
                file.delete();
            }
        }
        //清单号
        String tableName = "PRPLPAYBILL";
        String riskCode = "";
        String registNo= "";
        if (nyxPlantingClaimListDtoList != null && nyxPlantingClaimListDtoList.size() > 0) {
            if (nyxPlantingClaimListDtoList.get(0) != null) {
                PrpLRegist  prpLRegist = prpLRegistDao.findByRegistNo(nyxPlantingClaimListDtoList.get(0).getRegistNo());
                registNo=nyxPlantingClaimListDtoList.get(0).getRegistNo();
                if (prpLRegist != null) {
                    riskCode = prpLRegist.getClassCode() + "00";
                } else {
                    throw new BusinessException("没有此报案号信息!");
                }
            }
        }
        //校验清单要和承保清单的一致性
        //根据保单号查询承保清单
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> param=new HashMap<>();
        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
        if(nyxPlantingClaimListDtoList!=null&&nyxPlantingClaimListDtoList.size()>0){
            param.put("policyNo",nyxPlantingClaimListDtoList.get(0).getPolicyNo());
            //查询出险时间
            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(nyxPlantingClaimListDtoList.get(0).getRegistNo());
            param.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
        }
        acceptInsuranceDtos= plantingExcelApi.queryInsureListInfo(param);
        for (NyxPlantingClaimListDto nyxPlantingClaimListDto : nyxPlantingClaimListDtoList) {
            boolean flag1=true;
            for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                    /*比较险别，农户名称，标的。 */
                if(nyxPlantingClaimListDto.getClaimRiskCode().equals(acceptInsuranceDto.getKindCode())&&
                        nyxPlantingClaimListDto.getfName().equals(acceptInsuranceDto.getfName())&&
                        nyxPlantingClaimListDto.getItemCode().equals(acceptInsuranceDto.getItemCode())
                        ){
                    flag1=false;
                }
            }
            if(flag1){
                throw new BusinessException("【序号:"+nyxPlantingClaimListDto.getSerialNo()+"】险别、农户名称、标的与承保清单不一致！");
            }
        }
        int year = new DateTime(DateTime.current().toString()).getYear();
        String listNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
        Double lossEsnumBer=0D;//赔付数量
        Integer damageInsured=0;//出险户次
        Double noProductionArea=0D;//绝产面积
        Double sumAmount=0D;//赔偿金额
        BigDecimal settleAmount = new BigDecimal("0");
        List<String> fcodeList=new ArrayList<>();
        List<NyxPlantingClaimListDto> nyxPlantingClaimList=new ArrayList<>();
        List<NyxPlantingClaimListDto> nyxPlantingClaim=new ArrayList<>();
        List<PrpCitemKindDto> prpCitemKindDtos = prpCitemKindApi.queryItemCodeByPolicyNo(nyxPlantingClaimListDtoList.get(0).getPolicyNo());
        PrpLRegist byRegistNo = prpLRegistDao.findByRegistNo(nyxPlantingClaimListDtoList.get(0).getRegistNo());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date reportDate = byRegistNo.getReportDate();
        Date damageStartDate = byRegistNo.getDamageStartDate();
        List<PrpCitemKindDto> prpCitemKindDtos1 = prpCitemKindApi.queryItemCodeByPolicyNo(nyxPlantingClaimListDtoList.get(0).getPolicyNo());
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        map2.put("policyNo", nyxPlantingClaimListDtoList.get(0).getPolicyNo());
        map2.put("starDate", format.format(damageStartDate));
        for (PrpCitemKindDto prpCitemKindDto : prpCitemKindDtos1) {
            map1.put(prpCitemKindDto.getKindCode() + prpCitemKindDto.getItemCode(), prpCitemKindDto.getItemNo());
        }
        Map<String, Double> map3 = nyxEffectiveAmountApi.queryNyxEffectiveAmountByPolicyNo1(map2);
        //查询绝产率
        for (NyxPlantingClaimListDto nyxPlantingClaimListDto : nyxPlantingClaimListDtoList) {
            //有效保额的校验
            NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
            nyxEffectiveAmountDto.setPolicyNo(nyxPlantingClaimListDto.getPolicyNo());
            nyxEffectiveAmountDto.setRiskCode(nyxPlantingClaimListDto.getPolicyNo().substring(1,5));
            nyxEffectiveAmountDto.setKindCode(nyxPlantingClaimListDto.getClaimRiskCode());
            nyxEffectiveAmountDto.setItemCode(nyxPlantingClaimListDto.getItemCode());
            nyxEffectiveAmountDto.setfCode(nyxPlantingClaimListDto.getfCode());
            Map<String,Object> params=new HashMap<>();
            params.put("policyNo",nyxPlantingClaimListDto.getPolicyNo());
            params.put("kindCode",nyxPlantingClaimListDto.getClaimRiskCode());
            params.put("itemCode",nyxPlantingClaimListDto.getItemCode());
            params.put("registNo",nyxPlantingClaimListDto.getRegistNo());
            params.put("riskCode",nyxPlantingClaimListDto.getPolicyNo().substring(1,5));
            params.put("reportDate", format.format(reportDate));
            //茬次
            Integer itemKindNo=0;
            if (map1.containsKey(nyxPlantingClaimListDto.getClaimRiskCode() + nyxPlantingClaimListDto.getItemCode())) {
                itemKindNo = map1.get(nyxPlantingClaimListDto.getClaimRiskCode() + nyxPlantingClaimListDto.getItemCode());
            }
            params.put("itemKindNo",itemKindNo);
            //茬次
            int flag = nyxPlantingClaimListApi.checkStubbleByRegistNo1(params);
            nyxEffectiveAmountDto.setFlag(flag);
            //根据报案号查询出险日期
            nyxEffectiveAmountDto.setStartDate(byRegistNo.getDamageStartDate());
//            NyxEffectiveAmountDto nyxEffectiveAmountDto1 = nyxEffectiveAmountApi.queryAll(nyxEffectiveAmountDto);
            if (map3 == null) {
                throw new BusinessException("保单有效保额为空,请核对！");
            }
            Double amount = map3.get(nyxEffectiveAmountDto.getfCode() + nyxEffectiveAmountDto.getItemCode() + nyxEffectiveAmountDto.getKindCode() + nyxEffectiveAmountDto.getFlag());

            if(StringUtils.isNotEmpty(nyxPlantingClaimListDto.getEffectiveGuarantee())){
                if (Double.valueOf(nyxPlantingClaimListDto.getEffectiveGuarantee()) > amount) {
                    throw new BusinessException("填写的有效保额大于保单有效保额,请核对!");
                }
            }
            nyxPlantingClaimListDto.setEffectiveGuarantee(String.valueOf(amount));
            //-----有效保额结束---------
            nyxPlantingClaimListDto.setListNo(listNo);
            nyxPlantingClaimListDto.setNodeType(nodeType);
            //计算农户的数量
            if(!fcodeList.contains(nyxPlantingClaimListDto.getfCode())){
                fcodeList.add(nyxPlantingClaimListDto.getfCode());
            }

            if(nyxPlantingClaimListDto.getLossArea()!=null){
                //赔付数量等于受损面积之和
                lossEsnumBer+=nyxPlantingClaimListDto.getLossArea();
                if(prpCitemKindDtos!=null&&prpCitemKindDtos.get(0).getTotalLossRatio()!=null){
                    if(nyxPlantingClaimListDto.getLossRate()>prpCitemKindDtos.get(0).getTotalLossRatio()){
                        noProductionArea+=nyxPlantingClaimListDto.getLossArea();
                    }
                }
            }
            if(nyxPlantingClaimListDto.getSettleAmount()!=null){
//                sumAmount+=nyxPlantingClaimListDto.getSettleAmount();
                BigDecimal resultAmount = new BigDecimal(String.valueOf(nyxPlantingClaimListDto.getSettleAmount())).setScale(2,BigDecimal.ROUND_HALF_UP);
                settleAmount=settleAmount.add(resultAmount);
            }
            nyxPlantingClaimList.add(nyxPlantingClaimListDto);
        }
        /*当受损标的有多种大棚蔬菜时，只能输入一种大棚蔬菜校验*/

//            List<NyxPlantingClaimListDto> nyxPlantingClaimListDtos = nyxPlantingClaimListApi.queryAllByRegistNoAndNodeType(registNo,nodeType);
            //理算先删除之前导入的信息
//            if (nyxPlantingClaimListDtos.size()>0){
//                nyxPlantingClaimListApi.deleteNyxPlantingClaimListByRegistNoAndNodeType(registNo,nodeType);
//            }
            //理算的话使用计算的值重新赋值
            //sumAmount=0D;
        for (NyxPlantingClaimListDto nyxPlantingClaimListDto : nyxPlantingClaimList) {
                Map<String, Object> returnMap=null;
                if(nyxPlantingClaimListDto.getSettleAmount()==null ){
                    if(!"3237".equals(nyxPlantingClaimListDto.getPolicyNo().substring(1,5))) {
                        returnMap = nyxPlantingClaimListApi.queryClaimBillBySave(nyxPlantingClaimListDto, growthPeriod, damageWay, damageDegree);
                    }
                }
                if(returnMap!=null){
                    Object result = returnMap.get("result");
                    Object formula = returnMap.get("formula");
//                    Double resultAmount = Double.valueOf(String.valueOf(returnMap.get("result")));
                    if(result!=null){
                        nyxPlantingClaimListDto.setSettleAmount(Double.valueOf(String.valueOf(returnMap.get("result"))));
                        BigDecimal resultAmount = new BigDecimal(String.valueOf(returnMap.get("result"))).setScale(2,BigDecimal.ROUND_HALF_UP);
                        settleAmount=settleAmount.add(resultAmount);
//                        sumAmount+=resultAmount;
                    }
                    if(formula!=null){
                        nyxPlantingClaimListDto.setFormula(String.valueOf(formula));
                    }
                }
                nyxPlantingClaim.add(nyxPlantingClaimListDto);
            }
        if(fcodeList!=null){
            damageInsured=fcodeList.size();
        }
        if(nyxPlantingClaim!=null&&nyxPlantingClaim.size()>0){
            //删除历史数据
            if ("claim".equals(nodeType)){
                nyxPlantingClaimListApi.deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(registNo,"",nodeType);
            }else if ("compe".equals(nodeType)){
                for(int i=0;i<nyxPlantingClaim.size();i++){
                    if("".equals(nyxPlantingClaim.get(i).getClaimNo())){
                        throw new BusinessException("立案号不能为空");
                    }
                }
                List<SwfLog> swfLogList = swfLogDao.queryByRegistNo(registNo);
                if (swfLogList.size()>0){
                    String flowId = swfLogList.get(0).getFlowId();
                    Integer maxPathNo = swfPathLogDao.getMaxPathNo(flowId);
                    SwfPathLogKey swfPathLogKey = new SwfPathLogKey();
                    swfPathLogKey.setPathNo(maxPathNo);
                    swfPathLogKey.setFlowId(flowId);
                    SwfPathLog swfPathLog = swfPathLogDao.findOne(swfPathLogKey);
                    SwfLogKey swfLogKey = new SwfLogKey();
                    swfLogKey.setLogNo(swfPathLog.getEndNodeNo());
                    swfLogKey.setFlowId(flowId);
                    SwfLog swfLog = swfLogDao.findOne(swfLogKey);
                    nyxPlantingClaimListApi.deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(registNo,swfLog.getBusinessNo(),nodeType);
                }
            }
            nyxPlantingClaimListApi.batchSaveNyxPlantingClaimList(nyxPlantingClaim);
        }else{
            nyxPlantingClaimListApi.batchSaveNyxPlantingClaimList(nyxPlantingClaimList);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("listNo",listNo);
        map.put("sumAmount",settleAmount);
        map.put("lossEsnumBer",lossEsnumBer);
        map.put("damageInsured",damageInsured);
        map.put("noProductionArea",noProductionArea);
        return map;
    }

    /**
     * 导入excel回调接口实现类
     * @Author: 孙朋飞
     * @Date: 2018/1/3 9:44
     */
    public class BussinessListReader implements ReadHandler {
        //存储导入的list集合
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = new ArrayList<>();

        /**
         * excel导入数据
         * @author: 孙朋飞
         * @date: 2018/1/3 9:48
         * @param sheetIndex 当前sheet页的页码,从0开始
         * @param rowIndex   当前行的行号，从0开始
         * @param row        当前行数据
         */
        @Override
        public void handler(int sheetIndex, int rowIndex, List<String> row) throws Exception{
            NyxPlantingClaimListDto nyxPlantingClaimListDto = new NyxPlantingClaimListDto();
            if(row.get(0)!=null){
                nyxPlantingClaimListDto.setSerialNo(row.get(0));
            }else{
                throw new BusinessException("序号不能为空");
            }
            if(StringUtils.isEmpty(row.get(1))){
                throw new BusinessException("保单号不能为空");
            }
            nyxPlantingClaimListDto.setPolicyNo(row.get(1));
            if(StringUtils.isEmpty(row.get(2))){
                throw new BusinessException("报案号不能为空");
            }
            nyxPlantingClaimListDto.setRegistNo(row.get(2));
            nyxPlantingClaimListDto.setClaimNo(row.get(3));
            nyxPlantingClaimListDto.setCompensateNo(row.get(4));
            if(StringUtils.isEmpty(row.get(5))){
                throw new BusinessException("农户代码不能为空");
            }
            nyxPlantingClaimListDto.setfCode(row.get(5));
            if(StringUtils.isEmpty(row.get(6))){
                throw new BusinessException("农户姓名不能为空");
            }
            nyxPlantingClaimListDto.setfName(row.get(6));
            nyxPlantingClaimListDto.setfIdCard(row.get(7));
            nyxPlantingClaimListDto.setPhoneNumber(row.get(8));
            if(StringUtils.isEmpty(row.get(9))){
                throw new BusinessException("赔付险别代码不能为空");
            }
            nyxPlantingClaimListDto.setClaimRiskCode(row.get(9).split("-")[0]);
            if(StringUtils.isEmpty(row.get(10))){
                throw new BusinessException("标的号码不能为空");
            }
            nyxPlantingClaimListDto.setItemCode(row.get(10).split("-")[0]);
            if (StringUtils.isNotEmpty(row.get(11))) {
                nyxPlantingClaimListDto.setLossArea(Double.valueOf(row.get(11)));
            }else{
                throw new BusinessException("受损面积不能为空");
            }
            if (StringUtils.isNotEmpty(row.get(12))) {
                nyxPlantingClaimListDto.setLossRate(Double.valueOf(row.get(12)));
            }else{
                throw new BusinessException("损失率不能为空");
            }
            nyxPlantingClaimListDto.setEffectiveGuarantee(row.get(13));
            if (StringUtils.isNotEmpty(row.get(14))) {
                Double claimRate = Double.valueOf(row.get(14));
                if(claimRate>1||claimRate<0){
                    throw new BusinessException("赔付比例为0-1之间");
                }
                nyxPlantingClaimListDto.setClaimRate(claimRate);
            }
            nyxPlantingClaimListDto.setAccident(row.get(15));
            nyxPlantingClaimListDto.setDeductible(row.get(16));
            if (StringUtils.isNotEmpty(row.get(17))) {
                nyxPlantingClaimListDto.setSettleAmount(Double.valueOf(row.get(17)));
            }
            if(StringUtils.isEmpty(row.get(18))){
                throw new BusinessException("赔付类型不能为空");
            }
            nyxPlantingClaimListDto.setPayType(row.get(18).split("-")[0]);
            nyxPlantingClaimListDto.setFormula(row.get(19));
            nyxPlantingClaimListDto.setDeductionAmount(row.get(20));
            try{
                nyxPlantingClaimListDto.setName(row.get(21));
                nyxPlantingClaimListDto.setNo(row.get(22));
            }catch(Exception e){

            }
            nyxPlantingClaimListDtoList.add(nyxPlantingClaimListDto);
        }

        public List<NyxPlantingClaimListDto> getNyxPlantingClaimListDtoList() {
            return nyxPlantingClaimListDtoList;
        }
    }

    /**
     * （养殖险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/29 11:08
     * @param fileId  文件标识id
     * @param comCode 机构代码
     * @return 返回清单号和支付金额
     * @throws Exception
     */
    @Override
    public Map<String,Object> importBreedClaimListExcel(String fileId, String comCode,String growthPeriod,String nodeType) throws Exception {
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空!");
        }
        if (StringUtils.isEmpty(fileId)) {
            throw new DataVerifyException("文件传入失败!");
        }
        //初始化工具类
        ExcelUtil excelUtil = ExcelUtil.initImport();
        Map<String, String> otherParams = new HashMap<String, String>();
        otherParams.put("fileId", fileId);
        List<NyxBreedClaimListDto> nyxBreedClaimListDtos = null;
        File file = null;
        try {
            file = File.createTempFile("养殖险理赔清单", exportExcelType);
            FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, otherParams);
            BreedBussinessListReader breedBussinessListReader = new BreedBussinessListReader();
            excelUtil.setStartRowNumber(3).readExcel(file, breedBussinessListReader);
            nyxBreedClaimListDtos = breedBussinessListReader.getNyxBreedClaimListDtos();
        } finally {
            //删除本地临时文件
            if (file != null) {
                file.delete();
            }
        }
        //校验定损清单要和承保清单的一致性
        //根据保单号查询承保清单
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> param=new HashMap<>();
        param.put("policyNo",nyxBreedClaimListDtos.get(0).getPolicyNo());
        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
        //查询出险时间
        PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(nyxBreedClaimListDtos.get(0).getRegistNo());
        param.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
        acceptInsuranceDtos =  plantingExcelApi.queryInsureListInfo(param);
        for (NyxBreedClaimListDto nyxBreedClaimListDto : nyxBreedClaimListDtos) {
            boolean flag1=true;
            for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                    /*比较险别，农户名称，标的。 */
                if(nyxBreedClaimListDto.getClaimRiskCode().equals(acceptInsuranceDto.getKindCode())&&
                        nyxBreedClaimListDto.getfName().equals(acceptInsuranceDto.getfName())&&
                        nyxBreedClaimListDto.getItemCode().equals(acceptInsuranceDto.getItemCode())
                        ){
                    flag1=false;

                }
            }
            if(flag1){
                throw new BusinessException("【序号:"+nyxBreedClaimListDto.getSerialNo()+"】险别、农户名称、标的与承保清单不一致！");
            }
        }
        //清单号
        String tableName = "PRPLPAYBILL";
        String riskCode = "";
        if (nyxBreedClaimListDtos != null && nyxBreedClaimListDtos.size() > 0) {
            if (nyxBreedClaimListDtos.get(0) != null) {
                PrpLRegist  prpLRegist = prpLRegistDao.findByRegistNo(nyxBreedClaimListDtos.get(0).getRegistNo());
                if (prpLRegist != null) {
                    riskCode = prpLRegist.getClassCode() + "00";
                } else {
                    throw new BusinessException("没有此报案号信息!");
                }
            }
        }
        int year = new DateTime(DateTime.current().toString()).getYear();
        Double sumAmount=0D;
        BigDecimal settleAmount = new BigDecimal("0");
        String listNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
        String registNo = nyxBreedClaimListDtos.get(0).getRegistNo();
        for (NyxBreedClaimListDto nyxBreedClaimListDto : nyxBreedClaimListDtos) {
            nyxBreedClaimListDto.setListNo(listNo);
            nyxBreedClaimListDto.setNodeType(nodeType);
            if(nyxBreedClaimListDto.getPayAmount()!=null){
//                sumAmount+=nyxBreedClaimListDto.getPayAmount();
                BigDecimal resultAmount = new BigDecimal(nyxBreedClaimListDto.getPayAmount()).setScale(2,BigDecimal.ROUND_HALF_UP);
                settleAmount=settleAmount.add(resultAmount);
            }
        }
        //删除历史数据
        Map<String,Object> returnMap=new HashMap<>();
        if ("claim".equals(nodeType)){
            nyxBreedClaimListApi.deleteNyxBreedClaimListByRegistNo(registNo,"",nodeType);
        }else if ("compe".equals(nodeType)){
            List<String> list = new ArrayList<>();
            for(int i=0;i<nyxBreedClaimListDtos.size();i++){
                if("".equals(nyxBreedClaimListDtos.get(i).getClaimNo())){
                    throw new BusinessException("立案号不能为空");
                }
                list.add(nyxBreedClaimListDtos.get(i).getEarConNo());
            }

//            }

            List<SwfLog> swfLogList = swfLogDao.queryByRegistNo(registNo);
            if (swfLogList.size()>0){
                String flowId = swfLogList.get(0).getFlowId();
                Integer maxPathNo = swfPathLogDao.getMaxPathNo(flowId);
                SwfPathLogKey swfPathLogKey = new SwfPathLogKey();
                swfPathLogKey.setPathNo(maxPathNo);
                swfPathLogKey.setFlowId(flowId);
                SwfPathLog swfPathLog = swfPathLogDao.findOne(swfPathLogKey);
                SwfLogKey swfLogKey = new SwfLogKey();
                swfLogKey.setLogNo(swfPathLog.getEndNodeNo());
                swfLogKey.setFlowId(flowId);
                SwfLog swfLog = swfLogDao.findOne(swfLogKey);
                nyxBreedClaimListApi.deleteNyxBreedClaimListByRegistNo(registNo,swfLog.getBusinessNo(),nodeType);
            }
        }
        //查询已赔付的
        List<String> compensateList = prpLCompensateDao.queryPrpLCompensatesByPolicyNo(nyxBreedClaimListDtos.get(0).getPolicyNo());
        List<NyxBreedClaimListDto> breedClaimListDtos = nyxBreedClaimListApi.queryByClaimNo(compensateList);
//            List<PrpLCompensate> prpLCompensateList=null;
//            if(breedClaimListDtos.size()>0){
//               prpLCompensateListpensateList = prpLCompensateDao.queryAllByCompensateNoLike(breedClaimListDtos.get(0).getCompensateNo());
//            }
//            if(prpLCompensateList!=null){
        List<String>  backlist = new ArrayList<>();
        String s = "下列耳标号已经赔付过，无法再次进行赔付:\r\n";
//                if("1".equals(prpLCompensateList.get(0).getUnderWriteFlag())){
//                    List<InsureMainListDto> insureMainListDtoList = insureMainListApi.queryByPolicyNo(prpLCompensateList.get(0).getPolicyNo());
//                    List<HerdPolicyListDto> herdPolicyListDtos = herdPolicyListApi.queryByInusreListCode(insureMainListDtoList.get(0).getInusreListCode());
        //核赔通过
        for(int j=0;j<nyxBreedClaimListDtos.size();j++){
            for(int u=0;u<breedClaimListDtos.size();u++){
                if(nyxBreedClaimListDtos.get(j).getEarConNo().equals(breedClaimListDtos.get(u).getEarConNo())){
                    backlist.add(nyxBreedClaimListDtos.get(j).getEarConNo());
                }
            }
        }
//                }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<backlist.size();i++){
            str.append(backlist.get(i)+",") ;
            if(i!=0&&i%3==0){//三条换行
                str.append("\r\n");
            }
        }
        if(backlist.size()>0){
            throw new BusinessException(s+str.toString());
        }
        //保存
        nyxBreedClaimListApi.batchSaveNyxBreedClaimList(nyxBreedClaimListDtos);
        returnMap.put("listNo",listNo);
        returnMap.put("sumAmount",settleAmount);
        return returnMap;
    }

    /**
     * 导入excel回调接口实现类
     * @Author: 孙朋飞
     * @Date: 2018/1/3 9:44
     */
    public class BreedBussinessListReader implements ReadHandler {
        //存储导入的list集合
        List<NyxBreedClaimListDto> nyxBreedClaimListDtos = new ArrayList<>();

        /**
         * excel导入数据
         * @author: 孙朋飞
         * @date: 2018/1/3 9:48
         * @param sheetIndex 当前sheet页的页码,从0开始
         * @param rowIndex   当前行的行号，从0开始
         * @param row        当前行数据
         */
        @Override
        public void handler(int sheetIndex, int rowIndex, List<String> row)throws Exception {
            NyxBreedClaimListDto nyxBreedClaimListDto = new NyxBreedClaimListDto();
            if(StringUtils.isEmpty(row.get(0))){
                throw new BusinessException("序号不能为空");
            }
            nyxBreedClaimListDto.setSerialNo(row.get(0));
            if(StringUtils.isEmpty(row.get(1))){
                throw new BusinessException("保单号不能为空");
            }
            nyxBreedClaimListDto.setPolicyNo(row.get(1));
            if(StringUtils.isEmpty(row.get(2))){
                throw new BusinessException("报案号不能为空");
            }
            nyxBreedClaimListDto.setRegistNo(row.get(2));
            nyxBreedClaimListDto.setClaimNo(row.get(3));
            nyxBreedClaimListDto.setCompensateNo(row.get(4));
            if(StringUtils.isEmpty(row.get(5))){
                throw new BusinessException("农户代码不能为空");
            }
            nyxBreedClaimListDto.setfCode(row.get(5));
            if(StringUtils.isEmpty(row.get(6))){
                throw new BusinessException("农户姓名不能为空");
            }
            nyxBreedClaimListDto.setfName(row.get(6));
            nyxBreedClaimListDto.setfIdCard(row.get(7));
            nyxBreedClaimListDto.setPhoneNumber(row.get(8));
            if(StringUtils.isEmpty(row.get(9))){
                throw new BusinessException("险别不能为空");
            }
            nyxBreedClaimListDto.setClaimRiskCode(row.get(9).split("-")[0]);
//            nyxBreedClaimListDto.setBankAccount(row.get(9));
            if(StringUtils.isEmpty(row.get(10))){
                throw new BusinessException("标的号码不能为空");
            }
            nyxBreedClaimListDto.setItemCode(row.get(10).split("-")[0]);
            if(StringUtils.isEmpty(row.get(11))){
                throw new BusinessException("耳标号不能为空");
            }
            nyxBreedClaimListDto.setEarConNo(row.get(11));
            if (StringUtils.isNotEmpty(row.get(12))) {
                nyxBreedClaimListDto.setPayAmount(Double.valueOf(row.get(12)));
            }
            if(StringUtils.isEmpty(row.get(13))){
                throw new BusinessException("赔付类型不能为空");
            }
            nyxBreedClaimListDto.setPayType(row.get(13).split("-")[0]);
            nyxBreedClaimListDto.setFormula(row.get(14));
            nyxBreedClaimListDto.setDeductionAmount(row.get(15));
            nyxBreedClaimListDtos.add(nyxBreedClaimListDto);
        }

        public List<NyxBreedClaimListDto> getNyxBreedClaimListDtos() {
            return nyxBreedClaimListDtos;
        }
    }

    /**
     * （养殖险定损清单数据的下载）
     * @author: 孙朋飞
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expBreedLossRateList(Map<String, String> map) throws Exception {
        String registNo = map.get("registNo");
        if (StringUtils.isEmpty(registNo)) {
            throw new DataVerifyException("报案号不能为空!");
        }
        //查询数据
        List<BreedLossRateListDto> breedLossRateListDtos = breedLossRateListApi.queryBreedLossRateListByRegistNo(map);
        if (breedLossRateListDtos == null || breedLossRateListDtos.size() == 0) {
            throw new BusinessException("没有此养殖险定损清单数据!");
        }
        String titleName = "";
        String excelName = "";
        String shortLinkId = null;
        // 采用反射的方式动态修改注解内容
        Class<BreedLossRateListDto> responseNyxPolicyListDtoClass = BreedLossRateListDto.class;
        excelName = titleName = "国元农业保险定损清单（能繁母猪养殖保险）";
        for (int i = 0; i < breedLossRateListDtos.size(); i++) {
            breedLossRateListDtos.get(i).setSerialNo(String.valueOf(i + 1));
        }
        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    breedLossRateListDtos, 1, 7, responseNyxPolicyListDtoClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * （种植险定损清单数据的下载）
     * @author: 祁小龙
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expPlantingLossRateList(Map<String, String> map) throws Exception {
        String registNo = map.get("registNo");
        if (StringUtils.isEmpty(registNo)) {
            throw new DataVerifyException("报案号不能为空!");
        }
        //查询数据
        List<PlantingLossRateListDto> plantingLossRateListDtos = plantingLossRateListApi.queryPlantingLossRateListByRegistNo(map);
        String titleName = "";
        String excelName = "";
        String shortLinkId = null;
        // 采用反射的方式动态修改注解内容
        Class<PlantingLossRateListDto> responseNyxPolicyListDtoClass = PlantingLossRateListDto.class;
        excelName = titleName = "国元农业保险定损清单（种植险）";

        if (plantingLossRateListDtos.size() > 0) {
            for (int i = 0; i < plantingLossRateListDtos.size(); i++) {
                plantingLossRateListDtos.get(i).setSerialNo(String.valueOf(i + 1));
            }
        } else {
            PlantingLossRateListDto data = new PlantingLossRateListDto();
            data.setSerialNo(" ");
            plantingLossRateListDtos.add(data);
        }
        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    plantingLossRateListDtos, 1, 9, responseNyxPolicyListDtoClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * 定损清单下载（种植险和养殖险）
     * @author: 孙朋飞
     * @date: 2018/1/19 14:15
     * @param map 清单号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public String expBreedAndPlantingLossRateList(Map<String, String> map) throws Exception {

        List<ResponseBreedLossRateListDto> responseBreedLossRateList=null;
        List<ResponsePlantingLossRateListDto> responsePlantingLossRateList = null;
        List<ResponsePlantingLossRateListDto> plantingList=new ArrayList<>();
        String classCode=map.get("policyNo").substring(1,3);
        String riskCode=map.get("policyNo").substring(1,5);
        if("32".equals(classCode)&&!"3224".equals(riskCode)&&!"3237".equals(riskCode)){
            responseBreedLossRateList = lossRateMainListApi.queryBreedLossRateListByLossListCode(map);
        }else{
            responsePlantingLossRateList = lossRateMainListApi.queryPlantingLossRateListByLossListCode(map);
        }
        String titleName = "";
        String excelName = "";
        String shortLinkId = null;
        File file = null;
        FileOutputStream os =null;
        FileInputStream finput =null;
        try {
            //养殖险
            if("32".equals(classCode)&&!"3224".equals(riskCode)&&!"3237".equals(riskCode)){
                List<ResponseBreedLossRateListDto> breedList=new ArrayList<>();
                if (responseBreedLossRateList != null && responseBreedLossRateList.size() > 0) {
                    //添加下载逻辑
                    //组装数据
                    for (int i = 0; i < responseBreedLossRateList.size(); i++) {
                        if("0".equals(responseBreedLossRateList.get(i).getOrigin())){
                            breedList.add(responseBreedLossRateList.get(i));
                        }
                    }
                    if(!"0".equals(map.get("origin"))){
                        if(breedList==null||breedList.size()==0){
                            for (int i = 0; i < responseBreedLossRateList.size(); i++) {
                                if("1".equals(responseBreedLossRateList.get(i).getOrigin())){
                                    breedList.add(responseBreedLossRateList.get(i));
                                }
                            }
                        }
                    }
                    if(breedList==null||breedList.size()==0){
                        return null;
                    }

                }else{
                    if(!"0".equals(map.get("origin"))){
                        //查询养殖险承保清单
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
                        if(StringUtils.isEmpty(map.get("registNo"))){
                            //报案登记的时候取出险时间为当前时间
                            map.put("validDate",simpleDateFormat.format(new Date()));
                            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
                        }else{
                            //查询出险时间
                            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(map.get("registNo"));
                            map.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
                            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
                        }
                        //组装养殖险的定损清单数据
                        if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
                            throw new Exception("保单清单异常，无法生成定损清单");
                        }
                        for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {
                            ResponseBreedLossRateListDto responseBreedDto = new ResponseBreedLossRateListDto();
                            responseBreedDto.setPolicyNo(map.get("policyNo"));
                            responseBreedDto.setBizNo(map.get("registNo"));
                            responseBreedDto.setFcode(acceptInsuranceDto.getfCode());
                            responseBreedDto.setFname(acceptInsuranceDto.getfName());
                            responseBreedDto.setItemCode(acceptInsuranceDto.getItemCode());
                            responseBreedDto.setEarLabel(acceptInsuranceDto.getEarlAbel());
                            responseBreedDto.setRemark(acceptInsuranceDto.getRemark());
                            responseBreedDto.setfIdCard(acceptInsuranceDto.getfIdCard());
                            breedList.add(responseBreedDto);
                        }

                    }else{
                        return null;
                    }


                }
                // 采用反射的方式动态修改注解内容
                Class<ResponseBreedLossRateListDto> responseBreedLossRateListDtoClass = ResponseBreedLossRateListDto.class;
                excelName = titleName = "国元农业保险定损清单（养殖险）";
                /*for (int i = 0; i < breedList.size(); i++) {
                    breedList.get(i).setSerialNo(String.valueOf(i + 1));
                    if("0".equals(breedList.get(i).getOrigin())){
                        breedList.get(i).setOrigin("金禾");
                    }else if("1".equals(breedList.get(i).getOrigin())){
                        breedList.get(i).setOrigin("手动");
                    }
                }*/
                //Excel导出类型判断：.xls 97-2003 版本 Excel
                for (int i = 0; i < breedList.size(); i++) {
                    breedList.get(i).setSerialNo(String.valueOf(i + 1));
                    Map<String,String> parmMap=new HashMap<>();
                    parmMap.put("riskCode",riskCode);
                    parmMap.put("itemCode",breedList.get(i).getItemCode());
                    PrpDitemAgriDto prpDitemAgriDto = prpDitemAgriApi.queryByPk(parmMap);
                    if(prpDitemAgriDto!=null){
                        breedList.get(i).setItemCode(breedList.get(i).getItemCode()+"-"+prpDitemAgriDto.getItemCName());
                    }else{
                        breedList.get(i).setItemCode(breedList.get(i).getItemCode());
                    }
                }
                QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
                file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                        breedList, 1, 11, responseBreedLossRateListDtoClass);
            }else{
                //种植险
                if (responsePlantingLossRateList != null && responsePlantingLossRateList.size() > 0) {
                    //添加下载逻辑
                    //组装数据

                    for (int i = 0; i < responsePlantingLossRateList.size(); i++) {
                        if("0".equals(responsePlantingLossRateList.get(i).getOrigin())){
                            plantingList.add(responsePlantingLossRateList.get(i));
                        }
                    }
                    if(!"0".equals(map.get("origin"))){
                        if(plantingList==null||plantingList.size()==0){
                            for (int i = 0; i < responsePlantingLossRateList.size(); i++) {
                                if("1".equals(responsePlantingLossRateList.get(i).getOrigin())){
                                    plantingList.add(responsePlantingLossRateList.get(i));
                                }
                            }
                        }
                    }
                if(plantingList==null||plantingList.size()==0){
                    return null;
                }
                /*for (int i = 0; i < plantingList.size(); i++) {
                    plantingList.get(i).setSerialNo(String.valueOf(i + 1));
                    if("0".equals(plantingList.get(i).getOrigin())){
                        plantingList.get(i).setOrigin("金禾");
                    }else if("1".equals(plantingList.get(i).getOrigin())){
                        plantingList.get(i).setOrigin("手动");
                    }
                }*/
                }else{
                    if(!"0".equals(map.get("origin"))){
                        //查询承保清单
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        List<AcceptInsuranceDto> acceptInsuranceDtos =null;
                        if(StringUtils.isEmpty(map.get("registNo"))){
                            //报案登记的时候取出险时间为当前时间
                            map.put("validDate",simpleDateFormat.format(new Date()));
                            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
                        }else{
                            //查询出险时间
                            PrpLRegist prplRegist = prpLRegistDao.findByRegistNo(map.get("registNo"));
                            map.put("validDate",simpleDateFormat.format(prplRegist.getDamageStartDate()));
                            acceptInsuranceDtos = plantingExcelApi.queryInsureListInfo(map);
                        }
                        //组装种植险的定损清单数据
                        if(acceptInsuranceDtos==null||acceptInsuranceDtos.size()==0){
                            throw new Exception("保单清单异常，无法生成定损清单");
                        }
                        for (AcceptInsuranceDto acceptInsuranceDto : acceptInsuranceDtos) {

                            ResponsePlantingLossRateListDto responsePlantingDto = new ResponsePlantingLossRateListDto();
                            responsePlantingDto.setPolicyNo(map.get("policyNo"));
                            responsePlantingDto.setBizNo(map.get("registNo"));
                            responsePlantingDto.setFcode(acceptInsuranceDto.getfCode());
                            responsePlantingDto.setFname(acceptInsuranceDto.getfName());
                            responsePlantingDto.setRemark(acceptInsuranceDto.getRemark());
                            responsePlantingDto.setFidCard(acceptInsuranceDto.getfIdCard());
                            //responsePlantingDto.setKindCode(acceptInsuranceDto.getKindCode());
                            responsePlantingDto.setItemCode(acceptInsuranceDto.getItemCode());
                            if(StringUtils.isNotEmpty(acceptInsuranceDto.getInsureArea())){
                                responsePlantingDto.setInsureArea(Double.valueOf(acceptInsuranceDto.getInsureArea()));
                            }

                            //遍历plantingList 如果农户代码和标的一致 则不重复添加
                            /*if(plantingList!=null&&plantingList.size()>=1){
                                for (ResponsePlantingLossRateListDto responsePlantingLossRateListDto : plantingList) {
                                    if(responsePlantingLossRateListDto.getItemCode().equals(responsePlantingDto.getItemCode())&&responsePlantingLossRateListDto.getFcode().equals(responsePlantingDto.getFcode())){
                                        //不做任何操作
                                    }else{
                                        plantingList.add(responsePlantingDto);
                                    }
                                }
                            }else{
                                plantingList.add(responsePlantingDto);
                            }*/
                            plantingList.add(responsePlantingDto);
                        }
                        //对list进行过滤
                        for(int i=0;i< plantingList.size()-1;i++){
                            for(int j= plantingList.size()-1;j>i;j--){
                                if(plantingList.get(j).getFcode().equals(plantingList.get(i).getFcode())&&plantingList.get(j).getItemCode().equals(plantingList.get(i).getItemCode())){
                                    plantingList.remove(j);
                                }
                            }
                        }
                    }else{
                        return null;
                    }

                }
                // 采用反射的方式动态修改注解内容
                Class<ResponsePlantingLossRateListDto> responsePlantingLossRateListDtoClass = ResponsePlantingLossRateListDto.class;
                if("3224".equals(riskCode)||"3237".equals(riskCode)){
                    excelName = titleName = "国元农业保险定损清单（养殖险）";
                }else{
                    excelName = titleName = "国元农业保险定损清单（种植险）";
                }
                Integer lastCol;
                if("3129".equals(map.get("policyNo").substring(1,5))){
                    //草莓组合保险
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"name","enabled",true);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"versionNo","enabled",true);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"lossMoney","enabled",true);
                    lastCol=15;
                }else {
                    //非草莓组合保险
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"name","enabled",false);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"versionNo","enabled",false);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"lossMoney","enabled",false);
                    lastCol=12;
                }
                Map<String, String> parmMap = new HashMap<>();
                parmMap.put("riskCode", riskCode);
                Map<String, String> queryPrpDitemDtoMap = prpDitemAgriApi.queryPrpDitemDto(parmMap);
                for (int i = 0; i < plantingList.size(); i++) {
                    plantingList.get(i).setSerialNo(String.valueOf(i + 1));
                    //根据险别和标的查询

                    if (queryPrpDitemDtoMap.containsKey(plantingList.get(i).getItemCode())) {
                        plantingList.get(i).setItemCode(plantingList.get(i).getItemCode() + "-" + queryPrpDitemDtoMap.get(plantingList.get(i).getItemCode()));
                    }else{
                        plantingList.get(i).setItemCode(plantingList.get(i).getItemCode());
                    }
                }
                //Excel导出类型判断：.xls 97-2003 版本 Excel
                QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
                file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                        plantingList, 1, lastCol, responsePlantingLossRateListDtoClass);
            }
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            if("31".equals(classCode)||"3224".equals(riskCode)||"3237".equals(riskCode)){
                List<String> list=new ArrayList<>();
                for (ResponsePlantingLossRateListDto plantingLossRateListDto : plantingList) {
                    if(plantingLossRateListDto.getItemCode()!=null){
                        list.add(plantingLossRateListDto.getItemCode());
                    }
                    //根据标的代码查询标的名称

                }
                Set set = new  HashSet();
                List newList = new  ArrayList();
                for (String cd:list) {
                    if(set.add(cd)){
                        newList.add(cd);
                    }
                }
                if(newList!=null&&newList.size()>0){
                    String absolutePath = file.getAbsolutePath();
                    String ext = absolutePath.substring(absolutePath.lastIndexOf("."));
                    finput = new FileInputStream(absolutePath);
                    int size = newList.size();
                    Integer currentRow=plantingList.size()+2;
                    CellRangeAddressList regions = new CellRangeAddressList(3, currentRow, 7, 7);
                    if(".xls".equals(ext)){
                        POIFSFileSystem fs = new POIFSFileSystem(finput);

                        HSSFWorkbook hs = new HSSFWorkbook(fs);
                        HSSFSheet sheet = hs.getSheetAt(0);
                        //list转为数组
                        // 创建下拉列表数据
                        DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])newList.toArray(new String[size]));
                        // 绑定
                        HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                        sheet.addValidationData(dataValidation);
                        os = new FileOutputStream(file.getAbsolutePath());
                        hs.write(os);
                    }else if(".xlsx".equals(ext)){
                        XSSFWorkbook sheets = new XSSFWorkbook(finput);
                        XSSFSheet sheetAt = sheets.getSheetAt(0);
                        XSSFDataValidationHelper xssfDataValidationHelper = new XSSFDataValidationHelper(sheetAt);
                        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) xssfDataValidationHelper
                                .createExplicitListConstraint((String[])newList.toArray(new String[size]));
                        XSSFDataValidation validation = (XSSFDataValidation) xssfDataValidationHelper.createValidation(
                                dvConstraint, regions);
                        sheetAt.addValidationData(validation);
                        os = new FileOutputStream(file.getAbsolutePath());
                        sheets.write(os);
                    }



                }
            }
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        }finally {
            //删除临时文件
            if(file!=null){
                file.delete();
            }
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(finput);
        }
            return shortLinkId;
    }
    /**
     * 定损清单下载（种植险和养殖险）
     * @author: 陈道洋
     * @date: 2018/1/19 14:15
     * @param map 清单号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public String downloadlList(Map<String, String> map) throws Exception {
        System.out.println("-----------------------------------");
        long n1 = System.currentTimeMillis();
        List<ResponseBreedLossRateListDto> responseBreedLossRateList = lossRateMainListApi.downloadlList(map);
        System.err.println("监测2-1、lossRateMainListService.save：" + ((System.currentTimeMillis() - n1)));
        List<ResponsePlantingLossRateListDto> responsePlantingLossRateList = null;
        if (responseBreedLossRateList == null || responseBreedLossRateList.size() == 0) {
            responsePlantingLossRateList = lossRateMainListApi.plantingdownloadlList(map);
        }
        System.err.println("监测2-2、lossRateMainListService.save：" + ((System.currentTimeMillis() - n1)));
        String classCode=map.get("policyNo").substring(1,3);
        String riskCode=map.get("policyNo").substring(1,5);
        String titleName = "";
        String excelName = "";
        Map<String, String> parmMap = new HashMap<>();
        parmMap.put("riskCode", riskCode);
        Map<String, String> prpDitemAgriDtoMap = prpDitemAgriApi.queryPrpDitemDto(parmMap);
        String shortLinkId = null;
        File file = null;
        FileOutputStream os =null;
        try {
            if (responseBreedLossRateList != null && responseBreedLossRateList.size() > 0) {
                // 采用反射的方式动态修改注解内容
                Class<ResponseBreedLossRateListDto> responseBreedLossRateListDtoClass = ResponseBreedLossRateListDto.class;
                excelName = titleName = "国元农业保险定损清单（养殖险）";
                for (int i = 0; i < responseBreedLossRateList.size(); i++) {
                    responseBreedLossRateList.get(i).setSerialNo(String.valueOf(i + 1));
                    if("0".equals(responseBreedLossRateList.get(i).getOrigin())){
                        responseBreedLossRateList.get(i).setOrigin("金禾");
                    }else if("1".equals(responseBreedLossRateList.get(i).getOrigin())){
                        responseBreedLossRateList.get(i).setOrigin("手动");
                    }
                    responseBreedLossRateList.get(i).setSerialNo(String.valueOf(i + 1));
                    if (prpDitemAgriDtoMap.containsKey(responseBreedLossRateList.get(i).getItemCode())) {
                        responseBreedLossRateList.get(i).setItemCode(responseBreedLossRateList.get(i).getItemCode() + "-" + prpDitemAgriDtoMap.get(responseBreedLossRateList.get(i).getItemCode()));
                    }else{
                        responseBreedLossRateList.get(i).setItemCode(responseBreedLossRateList.get(i).getItemCode());
                    }
                }
                //Excel导出类型判断：.xls 97-2003 版本 Excel
                QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
                file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                        responseBreedLossRateList, 1, 11, responseBreedLossRateListDtoClass);

            } else if (responsePlantingLossRateList != null && responsePlantingLossRateList.size() > 0) {
                // 采用反射的方式动态修改注解内容
                Class<ResponsePlantingLossRateListDto> responsePlantingLossRateListDtoClass = ResponsePlantingLossRateListDto.class;
                excelName = titleName = "国元农业保险定损清单（种植险）";
                Integer lastCol;
                if("3130".equals(map.get("policyNo").substring(1,5))){
                    //草莓组合保险
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"name","enabled",true);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"versionNo","enabled",true);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"lossMoney","enabled",true);
                    lastCol=16;
                }else {
                    //非草莓组合保险
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"name","enabled",false);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"versionNo","enabled",false);
                    POIUtils.modfiyAnnotationKey(responsePlantingLossRateListDtoClass,"lossMoney","enabled",false);
                    lastCol=13;
                }
                for (int i = 0; i < responsePlantingLossRateList.size(); i++) {
                    responsePlantingLossRateList.get(i).setSerialNo(String.valueOf(i + 1));
                    if("0".equals(responsePlantingLossRateList.get(i).getOrigin())){
                        responsePlantingLossRateList.get(i).setOrigin("金禾");
                    }else if("1".equals(responsePlantingLossRateList.get(i).getOrigin())){
                        responsePlantingLossRateList.get(i).setOrigin("手动");
                    }
                    responsePlantingLossRateList.get(i).setSerialNo(String.valueOf(i + 1));

                    if (prpDitemAgriDtoMap.containsKey(responsePlantingLossRateList.get(i).getItemCode())) {
                        responsePlantingLossRateList.get(i).setItemCode(responsePlantingLossRateList.get(i).getItemCode() + "-" + prpDitemAgriDtoMap.get(responsePlantingLossRateList.get(i).getItemCode()));
                    }else{
                        responsePlantingLossRateList.get(i).setItemCode(responsePlantingLossRateList.get(i).getItemCode());
                    }
                }
                //Excel导出类型判断：.xls 97-2003 版本 Excel
                QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
                file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                        responsePlantingLossRateList, 1, lastCol, responsePlantingLossRateListDtoClass);
            }else{
                throw new BusinessException("此报案号无定损清单!");
            }
            System.err.println("监测2-3、lossRateMainListService.save：" + ((System.currentTimeMillis() - n1)));
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            if("31".equals(classCode)){
                List<String> list=new ArrayList<>();
                for (ResponsePlantingLossRateListDto plantingLossRateListDto : responsePlantingLossRateList) {
                    if(!list.contains(plantingLossRateListDto.getItemCode())){
                        list.add(plantingLossRateListDto.getItemCode());
                    }
                }
                if(list!=null&&list.size()>0){
                    FileInputStream finput = new FileInputStream(file.getAbsolutePath());
                    POIFSFileSystem fs = new POIFSFileSystem(finput);
                    HSSFWorkbook hs = new HSSFWorkbook(fs);
                    HSSFSheet sheet = hs.getSheetAt(0);
                    //list转为数组
                    int size = list.size();
                    int size1=responsePlantingLossRateList.size();
                    Integer currentRow=size1+2;
                    CellRangeAddressList regions = new CellRangeAddressList(3, currentRow, 7, 7);
                    // 创建下拉列表数据
                    DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])list.toArray(new String[size]));
                    // 绑定
                    HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                    sheet.addValidationData(dataValidation);
                    os = new FileOutputStream(file.getAbsolutePath());
                    hs.write(os);
                }
            }else{
                List<String> list=new ArrayList<>();
                for (ResponseBreedLossRateListDto responseBreedLossRateListDto : responseBreedLossRateList) {
                    if(!list.contains(responseBreedLossRateListDto.getItemCode())){
                        list.add(responseBreedLossRateListDto.getItemCode());
                    }
                }
                if(list!=null&&list.size()>0){
                    FileInputStream finput = new FileInputStream(file.getAbsolutePath());
                    POIFSFileSystem fs = new POIFSFileSystem(finput);
                    HSSFWorkbook hs = new HSSFWorkbook(fs);
                    HSSFSheet sheet = hs.getSheetAt(0);
                    //list转为数组
                    int size = list.size();
                    int size1=responseBreedLossRateList.size();
                    Integer currentRow=size1+2;
                    CellRangeAddressList regions = new CellRangeAddressList(3, currentRow, 7, 7);
                    // 创建下拉列表数据
                    DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])list.toArray(new String[size]));
                    // 绑定
                    HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
                    sheet.addValidationData(dataValidation);
                    os = new FileOutputStream(file.getAbsolutePath());
                    hs.write(os);
                }
            }
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
            System.err.println("监测2-5、lossRateMainListService.save：" + ((System.currentTimeMillis() - n1)));
        }finally {
            //删除临时文件
            if(file!=null){
                file.delete();
            }
        }
        return shortLinkId;
    }
    /**
     * 特殊赔案清单下载
     * @author: 孙朋飞
     * @date: 2018/1/23 9:47
     * @param map 清单号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public String expSpecCaseList(Map<String, String> map) throws Exception {
        if(StringUtils.isEmpty(map.get("listNo"))){
            throw new DataVerifyException("清单号不能为空!");
        }
        String titleName = "";
        String excelName= "";
        excelName=titleName= "国元农业保险特殊赔案分户清单";
        Class<SpecCaseListDto> specCaseListDtoClass = SpecCaseListDto.class;
        File file = null;
        String shortLinkId = null;
        List<SpecCaseListDto>  specCaseListDtoList = specCaseListApi.querySpecCaseListByNoPage(map);
        if(specCaseListDtoList==null ||specCaseListDtoList.size()==0){
            throw new BusinessException("无此清单号分户清单信息!");
        }
        for(int i=0;i<specCaseListDtoList.size();i++){
            if("Y".equals(specCaseListDtoList.get(i).getSettleType())){
                specCaseListDtoList.get(i).setSettleType("Y-预赔");
            }else{
                specCaseListDtoList.get(i).setSettleType("C-实赔");
            }
            specCaseListDtoList.get(i).setIdentifyType(identifyTypeMap.get(specCaseListDtoList.get(i).getIdentifyType()));
            specCaseListDtoList.get(i).setReceiverType(receiverTypMap.get(specCaseListDtoList.get(i).getReceiverType()));
            specCaseListDtoList.get(i).setAccountFlag(accountFlagMap.get(specCaseListDtoList.get(i).getAccountFlag()));
            specCaseListDtoList.get(i).setAccountType(accountTypeMap.get(specCaseListDtoList.get(i).getAccountType()));
        }
        try{
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType,excelName,titleName,
                    specCaseListDtoList,1,20, specCaseListDtoClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> selectList=new ArrayList<>();
            //收款人类型下拉选
            List<PrpDcodeDto> prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("ReceiverType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),7);
            //收款人证件类型下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("IdentifyType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),9);
            //银行账号属性下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("AccountType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),16);
            //银行账号类型下拉选
            selectList = new ArrayList<>();
            selectList.add("00-银行卡");
            selectList.add("01-存折");
            selectList.add("03-对公账户");
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),17);
            //赔付类型
            selectList = new ArrayList<>();
            selectList.add("C-实赔");
            selectList.add("Y-预赔");
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),19);
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl,file,userCode,systemId,bussType);
        }finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * 特殊赔案清单模板下载
     * @author: 王心洋
     * @date: 2018/4/12
     * @param map 保单号 出险日期
     * @return 生成下载短链接
     * @throws Exception
     */
    public Map<String,String> expSpecCaseModelList(Map<String,String> map) throws Exception {
        List<AcceptInsuranceDto> acceptInsuranceDtoList = plantingExcelApi.queryInsureListInfo(map);
        if(acceptInsuranceDtoList==null ||acceptInsuranceDtoList.size()==0){
            throw new BusinessException("无此单号承保清单信息!");
        }
        String titleName = "";
        String excelName= "";
        excelName=titleName= "国元农业保险特殊赔案分户清单";
        Class<SpecCaseListDto> specCaseListDtoClass = SpecCaseListDto.class;
        File file = null;
        String shortLinkId;
        SpecCaseListDto specCaseListDto;
        List<SpecCaseListDto>  specCaseListDtoList = new ArrayList<>();
        AcceptInsuranceDto acceptInsuranceDto;
        boolean flag;
        for(int i=0;i<acceptInsuranceDtoList.size();i++){
            flag = true;
//            for(int j=0;j<i;j++){
//                if(StringUtils.isNotEmpty(acceptInsuranceDtoList.get(i).getfCode())&&acceptInsuranceDtoList.get(i).getfCode().equals(acceptInsuranceDtoList.get(j).getfCode())
//                        && StringUtils.isNotEmpty(acceptInsuranceDtoList.get(i).getfName())&&acceptInsuranceDtoList.get(i).getfName().equals(acceptInsuranceDtoList.get(j).getfName())){
//                    specCaseListDtoList.get(j).setSettleAmount(Double.parseDouble(acceptInsuranceDtoList.get(i).getSumAmount())+specCaseListDtoList.get(j).getSettleAmount());
//                    flag= false;
//                    break;
//                }
//            }
            if(flag) {
                acceptInsuranceDto = acceptInsuranceDtoList.get(i);
                specCaseListDto = new SpecCaseListDto();
                specCaseListDto.setSerialNo((i + 1) + "");
                specCaseListDto.setPolicyNo(map.get("policyNo"));
                specCaseListDto.setRegistNo(map.get("registNo"));
                specCaseListDto.setClaimNo(map.get("claimNo"));
                specCaseListDto.setFcode(acceptInsuranceDto.getfCode());
                specCaseListDto.setFname(acceptInsuranceDto.getfName());
                specCaseListDto.setIdentifyType("01");
                specCaseListDto.setIdentifyNumber(acceptInsuranceDto.getfIdCard());
                specCaseListDto.setBankAccount(acceptInsuranceDto.getZhiBuKa());
                specCaseListDto.setPhoneNumber(acceptInsuranceDto.getPhone());
                specCaseListDto.setSettleType("Y");
                // 预赔清单模板下载的时候金额默认为空。祁小龙 20180430
                //specCaseListDto.setSettleAmount(Double.parseDouble(acceptInsuranceDto.getSumAmount()));
                specCaseListDtoList.add(specCaseListDto);
            }
        }
        for(int i=0;i<specCaseListDtoList.size();i++){
            specCaseListDtoList.get(i).setSerialNo(String.valueOf(i + 1));
            if("Y".equals(specCaseListDtoList.get(i).getSettleType())){
                specCaseListDtoList.get(i).setSettleType("Y-预赔");
            }else{
                specCaseListDtoList.get(i).setSettleType("C-实赔");
            }
            specCaseListDtoList.get(i).setIdentifyType(identifyTypeMap.get(specCaseListDtoList.get(i).getIdentifyType()));
            specCaseListDtoList.get(i).setReceiverType(receiverTypMap.get(specCaseListDtoList.get(i).getReceiverType()));
            specCaseListDtoList.get(i).setAccountFlag(accountFlagMap.get(specCaseListDtoList.get(i).getAccountFlag()));
            specCaseListDtoList.get(i).setAccountType(accountTypeMap.get(specCaseListDtoList.get(i).getAccountType()));
        }
        try{
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType,excelName,titleName,
                    specCaseListDtoList,1,20, specCaseListDtoClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> selectList=new ArrayList<>();
            //收款人类型下拉选
            List<PrpDcodeDto> prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("ReceiverType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),7);
            //收款人证件类型下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("IdentifyType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),9);
            //银行账号属性下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("AccountType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),16);
            //银行账号类型下拉选
            selectList = new ArrayList<>();
            selectList.add("00-银行卡");
            selectList.add("01-存折");
            selectList.add("03-对公账户");
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),17);
            //赔付类型
            selectList = new ArrayList<>();
            selectList.add("C-实赔");
            selectList.add("Y-预赔");
            this.addExcelSelect(selectList,file,specCaseListDtoList.size(),19);
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_businessutilmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl,file,userCode,systemId,bussType);
        }finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        Map<String,String> shortLink = new HashMap<>();
        shortLink.put("shortLink",shortLinkId);
        return shortLink;
    }

    /**
     *特殊赔案清单的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/24 14:23
     * @param fileId 文件id和comCode
     * @return 返回预赔金额和清单号
     * @throws Exception
     */
    @Override
    public Map<String,Object> importSpecCaseListExcel(String fileId,String comCode) throws Exception {
        if (StringUtils.isEmpty(fileId)) {
            throw new DataVerifyException("文件传入失败!");
        }
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空!");
        }
        //初始化工具类
        ExcelUtil excelUtil = ExcelUtil.initImport();
        Map<String, String> otherParams = new HashMap<String, String>();
        otherParams.put("fileId", fileId);
        List<SpecCaseListDto> specCaseListDtoList = null;
        File file = null;
        try {
            file = File.createTempFile("特殊赔案清单", exportExcelType);
            FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, otherParams);
            SpecCaseListReader specCaseListReader = new SpecCaseListReader();
            excelUtil.setStartRowNumber(3).readExcel(file, specCaseListReader);
            specCaseListDtoList = specCaseListReader.getSpecCaseListDtos();
        } finally {
            //删除本地临时文件
            if (file != null) {
                file.delete();
            }
        }
        Double settleAmount=0D;
        //清单号
        String tableName = "PRPLPAYBILL";
        String riskCode = "";
        if (specCaseListDtoList != null && specCaseListDtoList.size() > 0) {
            if (specCaseListDtoList.get(0) != null) {
                List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByRegistNo(specCaseListDtoList.get(0).getRegistNo());
                if (prpLClaimList != null && prpLClaimList.size() > 0) {
                    riskCode = prpLClaimList.get(0).getClassCode() + "00";
                } else {
                    throw new BusinessException("没有此报案号信息!");
                }
            }
        }
        int year = new DateTime(DateTime.current().toString()).getYear();
        int serialNo = 1;
        String listNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
        //保存
        if(specCaseListDtoList!=null && specCaseListDtoList.size()>0){
            for (SpecCaseListDto specCaseListDto : specCaseListDtoList) {
                //计算总金额
                if(specCaseListDto.getSettleAmount()!=null){
                    settleAmount+=specCaseListDto.getSettleAmount();
                }
                specCaseListDto.setSerialNo((serialNo++)+"");
                specCaseListDto.setListNo(listNo);
            }
            specCaseListApi.batchSaveSpecCaseList(specCaseListDtoList);
        }
        Map<String,Object> returnParam=new HashMap<>();
        returnParam.put("settleAmount",settleAmount);
        returnParam.put("listNo",listNo);
        return returnParam;
    }



    /**
     * 导入excel回调接口实现类
     *
     * @Author: 孙朋飞
     * @Date: 2018/1/24 14:40
     */
    public class SpecCaseListReader implements ReadHandler {
        //存储导入的list集合
        List<SpecCaseListDto> specCaseListDtos = new ArrayList<>();

        /**
         * excel导入数据
         * @param sheetIndex 当前sheet页的页码,从0开始
         * @param rowIndex   当前行的行号，从0开始
         * @param row        当前行数据
         * @author: 孙朋飞
         * @date: 2018/1/24 14:40
         */
        @Override
        public void handler(int sheetIndex, int rowIndex, List<String> row) {
            SpecCaseListDto specCaseListDto = new SpecCaseListDto();
            if(StringUtils.isEmpty(row.get(0))){
                throw new BusinessException("序号不能为空");
            }
            specCaseListDto.setSerialNo(row.get(0));
            if(StringUtils.isEmpty(row.get(1))){
                throw new BusinessException("保单号码不能为空");
            }
            specCaseListDto.setPolicyNo(row.get(1));
            if(StringUtils.isEmpty(row.get(2))){
                throw new BusinessException("报案号不能为空");
            }
            specCaseListDto.setRegistNo(row.get(2));
            if(StringUtils.isEmpty(row.get(3))){
                throw new BusinessException("立案号不能为空");
            }
            specCaseListDto.setClaimNo(row.get(3));
            specCaseListDto.setPreCompensateNo(row.get(4));
            if(StringUtils.isEmpty(row.get(5))){
                throw new BusinessException("农户代码不能为空");
            }
            specCaseListDto.setFcode(row.get(5));
            if(StringUtils.isEmpty(row.get(6))){
                throw new BusinessException("农户姓名不能为空");
            }
            specCaseListDto.setFname(row.get(6));
            if(StringUtils.isEmpty(row.get(7))){
                throw new BusinessException("领款人类型不能为空");
            }
            specCaseListDto.setReceiverType(row.get(7).split("-")[0]);
            if(StringUtils.isEmpty(row.get(8))){
                throw new BusinessException("领款人名称不能为空");
            }
            specCaseListDto.setReceiverName(row.get(8));
            if(StringUtils.isEmpty(row.get(9))){
                throw new BusinessException("领款人证件类型不能为空");
            }
            specCaseListDto.setIdentifyType(row.get(9).split("-")[0]);
            if(StringUtils.isEmpty(row.get(10))){
                throw new BusinessException("领款人证件号不能为空");
            }
            specCaseListDto.setIdentifyNumber(row.get(10));
            specCaseListDto.setBankType(row.get(11));
            specCaseListDto.setProvinceName(row.get(12));
            specCaseListDto.setCityName(row.get(13));
            if(StringUtils.isEmpty(row.get(14))){
                throw new BusinessException("开户银行名称不能为空");
            }
            specCaseListDto.setBankName(row.get(14));
            if(StringUtils.isEmpty(row.get(15))){
                throw new BusinessException("银行账号不能为空");
            }
            specCaseListDto.setBankAccount(row.get(15));
            if(StringUtils.isEmpty(row.get(16))){
                throw new BusinessException("账号属性不能为空");
            }
            specCaseListDto.setAccountFlag(row.get(16).split("-")[0]);
            if(StringUtils.isEmpty(row.get(17))){
                throw new BusinessException("账号类型不能为空");
            }
            specCaseListDto.setAccountType(row.get(17).split("-")[0]);
            specCaseListDto.setPhoneNumber(row.get(18));
            if(StringUtils.isEmpty(row.get(19))){
                throw new BusinessException("赔款类型不能为空");
            }
            specCaseListDto.setSettleType(row.get(19).split("-")[0]);
            if(StringUtils.isEmpty(row.get(20))){
                throw new BusinessException("赔款金额不能为空");
            }
            specCaseListDto.setSettleAmount(Double.valueOf(row.get(20)));
            specCaseListDtos.add(specCaseListDto);
        }

        public List<SpecCaseListDto> getSpecCaseListDtos() {
            return specCaseListDtos;
        }
    }
    /**
     * 查询查勘页面初始化成灾面积等
     * @author: 孙朋飞
     * @date: 2018/4/13 16:22
     * @param map registNo-报案号，policyNo-保单号
     * @return 查勘定损登记集合
     * @throws Exception
     */
    @Override
    public ResponseCheckDto queryBreedAndPlantingLossRateListPageInit(Map<String, String> map) throws Exception {
        List<ResponseBreedLossRateListDto> responseBreedLossRateList=null;
        List<ResponsePlantingLossRateListDto> responsePlantingLossRateList = null;
        ResponseCheckDto responseCheckDto = null;
        String classCode=map.get("policyNo").substring(1,3);
        if("32".equals(classCode)){
            responseBreedLossRateList = lossRateMainListApi.queryBreedLossRateListByLossListCode(map);
            List<ResponseBreedLossRateListDto> breedList=new ArrayList<>();
            for (int i = 0; i < responseBreedLossRateList.size(); i++) {
                if("0".equals(responseBreedLossRateList.get(i).getOrigin())){
                    breedList.add(responseBreedLossRateList.get(i));
                }
            }
            if(breedList!=null&&breedList.size()>0){
                responseCheckDto = new ResponseCheckDto();
                responseCheckDto.setDeathQuantity(breedList.get(0).getDeathQuantity());
                responseCheckDto.setKillQuantity(breedList.get(0).getKillQuantity());
                responseCheckDto.setContext(breedList.get(0).getCheckContext());
                responseCheckDto.setUnderWriteEndDate(breedList.get(0).getListAffirmTime());
                //赔付数量
                Double lossEsnumber=0d;
                Integer damageInsured=0;
                for (ResponseBreedLossRateListDto responseBreedLossRateListDto : responseBreedLossRateList) {
                    if(responseBreedLossRateListDto.getLossAmount()!=null){
                        lossEsnumber+=responseBreedLossRateListDto.getLossAmount();
                    }
                    List<String> fcodeList=new ArrayList<>();
                    //计算农户的数量
                    if(!fcodeList.contains(responseBreedLossRateListDto.getFcode())){
                        fcodeList.add(responseBreedLossRateListDto.getFcode());
                    }
                    if(fcodeList!=null){
                        damageInsured=fcodeList.size();
                    }
                }
                responseCheckDto.setDamageInsured(damageInsured);
                responseCheckDto.setLossEsnumBer(lossEsnumber);
            }
        }else{
            responsePlantingLossRateList = lossRateMainListApi.queryPlantingLossRateListByLossListCode(map);
            List<ResponsePlantingLossRateListDto> plantingList=new ArrayList<>();
            for (int i = 0; i < responsePlantingLossRateList.size(); i++) {
                if("0".equals(responsePlantingLossRateList.get(i).getOrigin())){
                    plantingList.add(responsePlantingLossRateList.get(i));
                }
            }
            if(plantingList!=null&&plantingList.size()>0){

                responseCheckDto = new ResponseCheckDto();
                responseCheckDto.setAffectEDarea(plantingList.get(0).getAffectedArea());
                responseCheckDto.setDisasterArea(plantingList.get(0).getDisasterArea());
                responseCheckDto.setNoProductionArea(plantingList.get(0).getNoProductionArea());
                responseCheckDto.setContext(plantingList.get(0).getCheckContext());
                responseCheckDto.setUnderWriteEndDate(plantingList.get(0).getListAffirmTime());
                //赔付数量
                Double lossEsnumber=0d;
                Integer damageInsured=0;
                for (ResponsePlantingLossRateListDto responsePlantingLossRateListDto : plantingList) {
                    if(responsePlantingLossRateListDto.getLossAmount()!=null){
                        lossEsnumber+=responsePlantingLossRateListDto.getLossAmount();
                    }
                    List<String> fcodeList=new ArrayList<>();
                    //计算农户的数量
                    if(!fcodeList.contains(responsePlantingLossRateListDto.getFcode())){
                        fcodeList.add(responsePlantingLossRateListDto.getFcode());
                    }
                    if(fcodeList!=null){
                        damageInsured=fcodeList.size();
                    }
                }
                responseCheckDto.setDamageInsured(damageInsured);
                responseCheckDto.setLossEsnumBer(lossEsnumber);

            }
        }
        return responseCheckDto;
    }
    void addExcelSelect(List<String> list,File file, int currentRow, int colNum) throws Exception {
        if (list != null && list.size() > 0) {
            FileOutputStream os;
            FileInputStream finput = new FileInputStream(file.getAbsolutePath());
            POIFSFileSystem fs = new POIFSFileSystem(finput);
            HSSFWorkbook hs = new HSSFWorkbook(fs);
            HSSFSheet sheet = hs.getSheetAt(0);
            //list转为数组
            int size = list.size();
            CellRangeAddressList regions = new CellRangeAddressList(3, currentRow + 2, colNum, colNum);
            // 创建下拉列表数据
            DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[]) list.toArray(new String[size]));
            // 绑定
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            sheet.addValidationData(dataValidation);
            os = new FileOutputStream(file.getAbsolutePath());
            hs.write(os);
        }
    }
}