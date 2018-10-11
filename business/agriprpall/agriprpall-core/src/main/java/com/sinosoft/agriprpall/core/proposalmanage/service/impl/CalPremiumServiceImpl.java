package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalPremiumResponseDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainAgriDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.CalPremiumService;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainAgriService;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdFarmerItemDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 种植险、养殖险公用计算方法（点击币别确认时）
 *
 * @Author: 田健
 * @Date: 2017/12/20 20:55
 */

@Service
public class CalPremiumServiceImpl implements CalPremiumService {
    @Autowired
    private PlantingInsuranceListApi plantingInsuranceListApi;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpTmainAgriService prpTmainAgriService;
    @Autowired
    private NyxInsuranceListApi nyxInsuranceListApi;
    @Autowired
    private GisInsureListApi gisInsureListApi;

    /**
     * 清单存储在planting的险种
     */
    // @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRisk;
    /**
     * 清单存储在planting31的险种
     */
    //   @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Risk;
    /**
     * 清单存储在nyx的险种
     */
    //  @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRisk;
    /**
     * 清单存储在herd的险种
     */
    //  @Value("${sysconfig.insureListRsk.herd}")
    private String herdRisk;
    /**
     * 草莓组合险种
     */
    private String riskCode3129 = "3129";

    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    public void inint() {
        this.plantingRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Risk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        this.nyxRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        this.herdRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
    }

    /**
     * 种植险、养殖险公用计算方法（点击币别确认时）
     * 1、flag为T02时，根据inusreListCode查询清单表,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param calPremiumDto 计算费用请求入参：包含清单号、金禾清单号、险别、标的、总保额、费率、补贴比例等信息
     * @return CalPremiumResponseDto 计算返回信息
     * @throws Exception
     * @author: 田健
     * @date: 2017/12/20 20:47
     */
    @Override
    public CalPremiumResponseDto CurrencyEnsure(CalPremiumDto calPremiumDto) throws Exception {
        inint();
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        //老系统从页面获取
        String riskCode = calPremiumDto.getRiskCode();
        // 清单存储在planting
        if (plantingRisk.contains(riskCode)) {
            calPremiumResponseDto = checkInsuranceCode(calPremiumDto);
        }
        // 清单存储在herd
        else if (herdRisk.contains(riskCode)) {
            calPremiumResponseDto = UICheckHerdInsuranceCode(calPremiumDto);
        }
        // 清单存储在nyx,此类别包含草莓信贷组合险
        else if (nyxRisk.contains(riskCode)) {
            // 草莓信贷组合险单独处理
            if (riskCode3129.equals(riskCode)) {
                calPremiumResponseDto = checkZHInsuranceList(calPremiumDto);
            } else {
                calPremiumResponseDto = checkInsuranceCode3224(calPremiumDto);
            }
        }
        // 清单存储在planting31
        else if (planting31Risk.contains(riskCode)) {
            calPremiumResponseDto = check31InsuranceCode(calPremiumDto);
        }
        return calPremiumResponseDto;
    }

    /**
     * 3129组合险
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param calPremiumDto 保费计算请求dto
     * @return CalPremiumResponseDto 返回dto
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/20 11:43
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto checkZHInsuranceList(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        String riskCode = calPremiumDto.getRiskCode();//老系统从页面获取
        String flag = calPremiumDto.getFlag();
        String inusreListCode = calPremiumDto.getInusrelistcode();//清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();//金禾的清单号
        String serialNo = calPremiumDto.getSerialNo();//金禾的清单序列号
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            String times = "";
            if(StringUtils.isNotEmpty(calPremiumDto.getTimes())){
                times = calPremiumDto.getTimes();
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }

            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            queryGisFarmerItemDto.setSerialNo(serialNo);//清单序号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);//清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);//标的清单编号
            queryGisFarmerItemDto.setKindCodeList(kindCodeList);//标的清单编号
            //查询金禾中间表信息获得清单农户、标的、投保数量等信息
            Map<String, List<GisFarmerItemForPremiumDto>> map = gisInsureListApi.queryGisZHFarmerItemInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);//我方清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            txnlistDetailedMainDto.setRiskCode(riskCode);//险种代码
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));//险类
            txnlistDetailedMainDto.setSerialNo(serialNo);//清单序号
            txnlistDetailedMainDto.setValidity("1");//同老系统保持一致
            //----------组装清单主表数据end------------------
            //----------保存投种植险保清单明细表start-----------------------
            //--------------循环标的清单编号itemListCodes------------
            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = checkZHPlantingCommonMethod(kindCodeList, itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList, rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate, centralRate, provinceRate, cityRate, townRate, otherRate, map);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            txnlistDetailedDto.setTimes(times);
            txnlistDetailedDto.setItemCodeList(kindCodeList);
            //调取清单服务进行保存
            Boolean booleanflag = false;

            ResponseDto responseDto = gisInsureListApi.checkZHInsuranceCode(txnlistDetailedDto);
            if ((boolean) responseDto.getResultObj()) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
            if("9999".equals(responseDto.getResultCode())){
                throw new BusinessException(responseDto.getResultMsg());
            }

        } else if ("getFee".equals(flag)) {//获取补贴费用及自缴份额，给页面赋值（回写主险保费、缴费计划中的信息）
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setRiskCode(riskCode);
            Map<String, NyxInsuranceInfoDto> insuranceInfoMap = gisInsureListApi.findNyxInsuranceInfo(requestInsuranceInfoDto);

            NyxInsuranceInfoDto insuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                insuranceInfoDto = insuranceInfoMap.get(KingItemCode);
                //此处只有组合险走，故无需加判断
                bigList.add(String.valueOf(insuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(insuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(insuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(insuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(insuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(insuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(insuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium() + insuranceInfoDto.getCentralPremium() + insuranceInfoDto.getProvincePremium()
                        + insuranceInfoDto.getCityPremium() + insuranceInfoDto.getTownPremium() + insuranceInfoDto.getOtherPremium()));
                count = insuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setKindCodeList(kindCodeList);
            calPremiumResponseDto.setItemCodeList(itemCodeList);
        } else if ("Delete".equals(flag)) {//删除清单信息,新系统应该不需要
            InsureMainListDto insureMainListDto = new InsureMainListDto();
            insureMainListDto = insureMainListApi.queryByPK(inusreListCode);
            if (insureMainListDto != null) {
                //根据清单号删除insureMainList与 plantingInsuranceList
                insureMainListApi.remove(inusreListCode);
                plantingInsuranceListApi.removeByInusreListcode(inusreListCode);
                calPremiumResponseDto.setMessage("删除关联成功！");
            } else {
                throw new DataVerifyException("删除关联失败！");
            }

        }
        return calPremiumResponseDto;
    }

    /**
     * 组合险表方法
     *
     * @param itemListCodes          标的清单号集合
     * @param riskCode               险种
     * @param inusreListCode         清单编号
     * @param kindCodeList           险别集合
     * @param agriUnitAmountMainList 单位保额集合
     * @param rateList               费率集合
     * @param shortRateFlagList      短期费率方式集合
     * @param shortRateList          短期费率集合
     * @param startDate              保险起期
     * @param endDate                保险止期
     * @param calculateFlagList      主、附险标识
     * @param fplanRate              自缴份额
     * @param centralRate            中央财政补贴比例
     * @param provinceRate           省级财政补贴比例
     * @param cityRate               地、市财政补贴比例
     * @param townRate               区县补贴份额
     * @param otherRate              其他比例补贴
     * @param map                    农户标的集合
     * @return
     * @author: 钱浩
     * @date: 2018/3/11 14:40
     */
    private List<TxnlistDetailedSubDto> checkZHPlantingCommonMethod(List<String> itemCodeList, List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<GisFarmerItemForPremiumDto>> map) {
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList;
        GisFarmerItemForPremiumDto gisFarmerItemForPremiumDto;
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<>();
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        for (int i = 0; i < itemCodeList.size(); i++) {
            gisFarmerItemForPremiumDtoList = (List<GisFarmerItemForPremiumDto>) map.get(itemCodeList.get(i));
                for (int j = 0; j < gisFarmerItemForPremiumDtoList.size(); j++) {
                    gisFarmerItemForPremiumDto = gisFarmerItemForPremiumDtoList.get(j);
                    txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                    txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                    txnlistDetailedSubDto.setfCode(gisFarmerItemForPremiumDto.getfCode());//农户代码
                    txnlistDetailedSubDto.setItemCode(gisFarmerItemForPremiumDto.getItemCode());//标的代码
                    txnlistDetailedSubDto.setBusinessNo(gisFarmerItemForPremiumDto.getfIdCard());//存农户身份证号码
                    if (agriUnitAmountMainList.get(i) != null) {
                        txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                    } else {
                        txnlistDetailedSubDto.setAmount(0.00);
                    }
                    txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                    txnlistDetailedSubDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(gisFarmerItemForPremiumDto.getInsureCount())));
                    txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                    txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                    // 育种数量，养殖险没有耳标号的存储投保数量
                    if (riskCode.startsWith("32")) {
                        txnlistDetailedSubDto.setBreedingNumber(txnlistDetailedSubDto.getInsureNumber());
                    }
                    // 育种数量，种植险默认0
                    else {
                        txnlistDetailedSubDto.setBreedingNumber(0);
                    }
                    //从金禾中间表取值
                    txnlistDetailedSubDto.setfCode(gisFarmerItemForPremiumDto.getfCode());
                    txnlistDetailedSubDto.setPhone(gisFarmerItemForPremiumDto.getfPhone());
                    txnlistDetailedSubDto.setBank(gisFarmerItemForPremiumDto.getBankName());
                    txnlistDetailedSubDto.setfName(gisFarmerItemForPremiumDto.getfName());
                    txnlistDetailedSubDto.setfIdCard(gisFarmerItemForPremiumDto.getfIdCard());
                    txnlistDetailedSubDto.setZhiBuKa(gisFarmerItemForPremiumDto.getAccountNo());
                    txnlistDetailedSubDto.setInsureArea(gisFarmerItemForPremiumDto.getInsureArea());
                    if ("3129".equals(riskCode)) {
                        if (gisFarmerItemForPremiumDto.getGisManFieldListDtoList() != null && gisFarmerItemForPremiumDto.getGisManFieldListDtoList().size() > 0) {
                            txnlistDetailedSubDto.setInsureArea(Double.parseDouble(gisFarmerItemForPremiumDto.getGisManFieldListDtoList().size() + ""));
                        }
                    }
                    // 赔付数量投保默认0，理赔时会回写此字段
                    txnlistDetailedSubDto.setSettleNumber(0);
                    txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                    txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                    txnlistDetailedSubDto.setIndexCode("1");//老系统在暂存清单时传死为1
                    txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                    txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                    txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                    txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                    txnlistDetailedSubDto.setIndustryCategory(gisFarmerItemForPremiumDto.getIndustryCategory());//行业类别
                    txnlistDetailedSubDto.setLoanContractNo(gisFarmerItemForPremiumDto.getLoanContractNo());//贷款合同编号
                    txnlistDetailedSubDto.setLoanBankAccount(gisFarmerItemForPremiumDto.getLoanBankAccount());//险类代码
                    txnlistDetailedSubDto.setLoadAmount(gisFarmerItemForPremiumDto.getLoadAmount());//险类代码
                    txnlistDetailedSubDto.setLoanPeriod(gisFarmerItemForPremiumDto.getLoanPeriod());//险类代码
                    txnlistDetailedSubDto.setLoanUse(gisFarmerItemForPremiumDto.getLoanUse());//险类代码
                    txnlistDetailedSubDto.setGuarantor(gisFarmerItemForPremiumDto.getGuarantor());//险类代码
                    //总保额，获取页面的从单位保额乘以投保面积
                    txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(gisFarmerItemForPremiumDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                    //总保费
                    txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN)).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    if ("3129M003".equals(itemCodeList.get(i))) {
                        txnlistDetailedSubDto.setSumAmount(gisFarmerItemForPremiumDto.getLoadAmount());
                        if (gisFarmerItemForPremiumDto.getLoadAmount() >= 100000) {//小额贷款大于10w按10w算
                            txnlistDetailedSubDto.setSumPremium(new BigDecimal(Double.toString(100000.00)).multiply(new BigDecimal(Double.toString(txnlistDetailedSubDto.getRate()))).doubleValue());
                        } else {
                            txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate()))).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                        }
                    }
                    if ("3129M002".equals(itemCodeList.get(i))) {
                        Double rate = 0.0000;
                        if (gisFarmerItemForPremiumDto.getGisManFieldListDtoList() != null && gisFarmerItemForPremiumDto.getGisManFieldListDtoList().size() > 0) {
                            for (GisManFieldListDto gisManFieldListDto : gisFarmerItemForPremiumDto.getGisManFieldListDtoList()) {
                                String industryCategory = gisManFieldListDto.getIndustryCategory();
                                if ("1".equals(industryCategory)) {
                                    rate += 0.14;
                                } else if ("2".equals(industryCategory)) {
                                    rate += 0.18;
                                } else if ("3".equals(industryCategory)) {
                                    rate += 0.23;
                                } else if ("4".equals(industryCategory)) {
                                    rate += 0.35;
                                } else if ("5".equals(industryCategory)) {
                                    rate += 0.53;
                                } else if ("6".equals(industryCategory)) {
                                    rate += 0.68;
                                }
                            }
                            txnlistDetailedSubDto.setRate(new BigDecimal(rate).divide(new BigDecimal(gisFarmerItemForPremiumDto.getGisManFieldListDtoList().size()), 4, BigDecimal.ROUND_HALF_UP).doubleValue());//费率
                            txnlistDetailedSubDto.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(gisFarmerItemForPremiumDto.getGisManFieldListDtoList().size())).doubleValue());
                            txnlistDetailedSubDto.setSumPremium((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply((new BigDecimal(txnlistDetailedSubDto.getRate()).divide(new BigDecimal(100), 4, BigDecimal.ROUND_HALF_UP))).doubleValue()));
                            txnlistDetailedSubDto.setGisManFieldListDtoList(gisFarmerItemForPremiumDto.getGisManFieldListDtoList());
                        } else {
                            txnlistDetailedSubDto.setRate(0.00);
                            txnlistDetailedSubDto.setSumAmount(0.00);
                            txnlistDetailedSubDto.setSumPremium(0.00);
                        }
                    }
                    // ---------------------------------------农户自缴---------------------------------------------
                    txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    // ---------------------------------------补贴金额---------------------------------------------
                    //中央财政补贴
                    txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //省级财政补贴，看
                    txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //地市财政补贴
                    txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //县(区)财政补贴
                    txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //其他来源补贴
                    txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //  尾差处理
                    if (!"0".equals(otherRate)) {
                        txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                    } else if (!"0".equals(townRate)) {
                        txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                    } else if (!"0".equals(cityRate)) {
                        txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                    } else if (!"0".equals(provinceRate)) {
                        txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                    } else if (!"0".equals(centralRate)) {
                        txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                    }
                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
                }
        }
        return txnlistDetailedSubDtoList;
    }

    /**
     * 3224
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param calPremiumDto 保费计算请求dto
     * @return CalPremiumResponseDto 返回dto
     * @throws Exception
     * @author: 田健
     * @date: 2017/10/20 11:43
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto checkInsuranceCode3224(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        String policyType = calPremiumDto.getPolicyType();//养殖方式
        String riskCode = calPremiumDto.getRiskCode();//老系统从页面获取
        String flag = calPremiumDto.getFlag();
        String inusreListCode = calPremiumDto.getInusrelistcode();//清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();//金禾的清单号
        String serialNo = calPremiumDto.getSerialNo();//金禾的清单序列号
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            String times = "";
            if(StringUtils.isNotEmpty(calPremiumDto.getTimes())){
                times = calPremiumDto.getTimes();
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }

            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            queryGisFarmerItemDto.setSerialNo(serialNo);//清单序号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);//清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);//标的清单编号
            //查询金禾中间表信息获得清单农户、标的、投保数量等信息
            Map<String, List<GisFarmerItemForPremiumDto>> map = gisInsureListApi.queryGisFarmerItemInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);//我方清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            txnlistDetailedMainDto.setRiskCode(riskCode);//险种代码
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));//险类
            txnlistDetailedMainDto.setSerialNo(serialNo);//清单序号
            txnlistDetailedMainDto.setValidity("1");//同老系统保持一致
            //----------组装清单主表数据end------------------
            //----------保存投种植险保清单明细表start-----------------------
            //--------------循环标的清单编号itemListCodes------------
            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = checkNyxPlantingCommonMethod(policyType,itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList, rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate, centralRate, provinceRate, cityRate, townRate, otherRate, map);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            txnlistDetailedDto.setTimes(times);
            //调取清单服务进行保存
            Boolean booleanflag = false;
            ResponseDto responseDto = gisInsureListApi.checkNyxInsuranceCode(txnlistDetailedDto);
            if ((boolean) responseDto.getResultObj()) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
            if ("9999".equals(responseDto.getResultCode())) {
                throw new BusinessException(responseDto.getResultMsg());
            }
        } else if ("getFee".equals(flag)) {//获取补贴费用及自缴份额，给页面赋值（回写主险保费、缴费计划中的信息）
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setRiskCode(riskCode);
            Map<String, NyxInsuranceInfoDto> insuranceInfoMap = gisInsureListApi.findNyxInsuranceInfo(requestInsuranceInfoDto);
            NyxInsuranceInfoDto nyxInsuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                nyxInsuranceInfoDto = insuranceInfoMap.get(KingItemCode);
                bigList.add(String.valueOf(nyxInsuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(nyxInsuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(nyxInsuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(nyxInsuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium() + nyxInsuranceInfoDto.getCentralPremium() + nyxInsuranceInfoDto.getProvincePremium()
                        + nyxInsuranceInfoDto.getCityPremium() + nyxInsuranceInfoDto.getTownPremium() + nyxInsuranceInfoDto.getOtherPremium()));
                count = nyxInsuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            calPremiumResponseDto.setKindCodeList(kindCodeList);
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setItemCodeList(itemCodeList);
        } else if ("Delete".equals(flag)) {//删除清单信息,新系统应该不需要
            InsureMainListDto insureMainListDto = new InsureMainListDto();
            insureMainListDto = insureMainListApi.queryByPK(inusreListCode);
            if (insureMainListDto != null) {
                //根据清单号删除insureMainList与 plantingInsuranceList
                insureMainListApi.remove(inusreListCode);
                plantingInsuranceListApi.removeByInusreListcode(inusreListCode);
                calPremiumResponseDto.setMessage("删除关联成功！");
            } else {
                throw new DataVerifyException("删除关联失败！");
            }

        }
        return calPremiumResponseDto;
    }

    /**
     * 种植险多险别多标的组装字表方法
     *
     * @param itemListCodes          标的清单号集合
     * @param riskCode               险种
     * @param inusreListCode         清单编号
     * @param kindCodeList           险别集合
     * @param agriUnitAmountMainList 单位保额集合
     * @param rateList               费率集合
     * @param shortRateFlagList      短期费率方式集合
     * @param shortRateList          短期费率集合
     * @param startDate              保险起期
     * @param endDate                保险止期
     * @param calculateFlagList      主、附险标识
     * @param fplanRate              自缴份额
     * @param centralRate            中央财政补贴比例
     * @param provinceRate           省级财政补贴比例
     * @param cityRate               地、市财政补贴比例
     * @param townRate               区县补贴份额
     * @param otherRate              其他比例补贴
     * @param map                    农户标的集合
     * @return
     * @author: 田健
     * @date: 2018/3/11 14:40
     */
    private List<TxnlistDetailedSubDto> checkNyxPlantingCommonMethod(String policyType ,List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<GisFarmerItemForPremiumDto>> map) {
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList;
        GisFarmerItemForPremiumDto gisFarmerItemForPremiumDto;
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<>();
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        for (int i = 0; i < itemListCodes.size(); i++) {
            gisFarmerItemForPremiumDtoList = map.get(itemListCodes.get(i));
            for (int j = 0; j < gisFarmerItemForPremiumDtoList.size(); j++) {
                gisFarmerItemForPremiumDto = gisFarmerItemForPremiumDtoList.get(j);
                txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                //养殖方式
                txnlistDetailedSubDto.setBreedingKind(policyType==null?"":policyType);
                txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                txnlistDetailedSubDto.setfCode(gisFarmerItemForPremiumDto.getfCode());//农户代码
                txnlistDetailedSubDto.setItemCode(gisFarmerItemForPremiumDto.getItemCode());//标的代码
                txnlistDetailedSubDto.setBusinessNo(gisFarmerItemForPremiumDto.getfIdCard());//存农户身份证号码
                txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                txnlistDetailedSubDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(gisFarmerItemForPremiumDto.getInsureCount())));
                txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                txnlistDetailedSubDto.setPhone(gisFarmerItemForPremiumDto.getfPhone());
                txnlistDetailedSubDto.setBank(gisFarmerItemForPremiumDto.getBankName());
                txnlistDetailedSubDto.setfName(gisFarmerItemForPremiumDto.getfName());
                txnlistDetailedSubDto.setfIdCard(gisFarmerItemForPremiumDto.getfIdCard());
                txnlistDetailedSubDto.setZhiBuKa(gisFarmerItemForPremiumDto.getAccountNo());
                txnlistDetailedSubDto.setInsureArea(gisFarmerItemForPremiumDto.getInsureCount());
                // 育种数量，养殖险没有耳标号的存储投保数量
                if (riskCode.startsWith("32")) {
                    txnlistDetailedSubDto.setBreedingNumber(txnlistDetailedSubDto.getInsureNumber());
                }
                // 育种数量，种植险默认0
                else {
                    txnlistDetailedSubDto.setBreedingNumber(0);
                }
                // 赔付数量投保默认0，理赔时会回写此字段
                txnlistDetailedSubDto.setSettleNumber(0);
                txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                txnlistDetailedSubDto.setIndexCode("1");//老系统在暂存清单时传死为1
                txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));//险类代码
                //总保额，获取页面的从单位保额乘以投保面积
                txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(gisFarmerItemForPremiumDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                //总保费
                txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate())).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate()).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                // ---------------------------------------农户自缴---------------------------------------------
                txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                // ---------------------------------------补贴金额---------------------------------------------
                //中央财政补贴
                txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //省级财政补贴，看
                txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //地市财政补贴
                txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //县(区)财政补贴
                txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //其他来源补贴
                txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //  尾差处理
                if (!"0".equals(otherRate)) {
                    txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                } else if (!"0".equals(townRate)) {
                    txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                } else if (!"0".equals(cityRate)) {
                    txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                } else if (!"0".equals(provinceRate)) {
                    txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                } else if (!"0".equals(centralRate)) {
                    txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                }
                txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
            }
        }
        return txnlistDetailedSubDtoList;
    }

    /**
     * 3101
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param calPremiumDto 保费计算请求dto
     * @return CalPremiumResponseDto 返回dto
     * @throws Exception
     * @author: 田健
     * @date: 2017/10/20 11:43
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto checkInsuranceCode(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        //老系统从页面获取
        String riskCode = calPremiumDto.getRiskCode();
        String flag = calPremiumDto.getFlag();
        //清单号
        String inusreListCode = calPremiumDto.getInusrelistcode();
        //金禾的清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();
        //金禾的清单序列号
        String serialNo = calPremiumDto.getSerialNo();
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            //保存请求次数
            String times = "";
            if(StringUtils.isNotEmpty(calPremiumDto.getTimes())){
                times = calPremiumDto.getTimes();
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }

            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            //清单序号
            queryGisFarmerItemDto.setSerialNo(serialNo);
            //清单编号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);
            //标的清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);
            //查询金禾中间表信息获得清单农户、标的、投保数量等信息
            Map<String, List<GisFarmerItemForPremiumDto>> map = gisInsureListApi.queryGisFarmerItemInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            //我方清单编号
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);
            //金禾清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            //险种代码
            txnlistDetailedMainDto.setRiskCode(riskCode);
            //险类
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));
            //清单序号
            txnlistDetailedMainDto.setSerialNo(serialNo);
            //同老系统保持一致
            txnlistDetailedMainDto.setValidity("1");
            //----------组装清单主表数据end------------------
            //----------保存投种植险保清单明细表start-----------------------
            //--------------循环标的清单编号itemListCodes------------
            List<GisFarmerItemDto> gisFarmerItemDtoList = null;
            GisFarmerItemDto gisFarmerItemDto = null;
            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<>();
            TxnlistDetailedSubDto txnlistDetailedSubDto = null;
            // 保费计算
            plantingMethodBase(itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList,
                    rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate,
                    centralRate, provinceRate, cityRate, townRate, otherRate, map, txnlistDetailedSubDtoList);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            txnlistDetailedDto.setTimes(times);//保存请求次数
            //调取清单服务进行保存
            ResponseDto responseDto = gisInsureListApi.checkInsuranceCode(txnlistDetailedDto);

            if ((boolean) responseDto.getResultObj()) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
            if("9999".equals(responseDto.getResultCode())){
                throw new BusinessException(responseDto.getResultMsg());
            }
        } else if ("getFee".equals(flag)) {//获取补贴费用及自缴份额，给页面赋值（回写主险保费、缴费计划中的信息）
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            Map<String, InsuranceInfoDto> insuranceInfoMap = gisInsureListApi.findInsuranceInfo(requestInsuranceInfoDto);
            InsuranceInfoDto insuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                insuranceInfoDto = insuranceInfoMap.get(KingItemCode);
                bigList.add(String.valueOf(insuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(insuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(insuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(insuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(insuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(insuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(insuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium() + insuranceInfoDto.getCentralPremium() + insuranceInfoDto.getProvincePremium()
                        + insuranceInfoDto.getCityPremium() + insuranceInfoDto.getTownPremium() + insuranceInfoDto.getOtherPremium()));
                count = insuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setKindCodeList(kindCodeList);
            calPremiumResponseDto.setItemCodeList(itemCodeList);
        } else if ("Delete".equals(flag)) {//删除清单信息,新系统应该不需要
            InsureMainListDto insureMainListDto = new InsureMainListDto();
            insureMainListDto = insureMainListApi.queryByPK(inusreListCode);
            if (insureMainListDto != null) {
                //根据清单号删除insureMainList与 plantingInsuranceList
                insureMainListApi.remove(inusreListCode);
                plantingInsuranceListApi.removeByInusreListcode(inusreListCode);
                calPremiumResponseDto.setMessage("删除关联成功！");
            } else {
                throw new DataVerifyException("删除关联失败！");
            }

        }
        return calPremiumResponseDto;
    }

    /**
     * 种植险保费计算
     *
     * @param itemListCodes             标的集合
     * @param riskCode                  险种代码
     * @param inusreListCode            清单号码
     * @param kindCodeList              险别集合
     * @param agriUnitAmountMainList    单位保额集合
     * @param rateList                  费率集合
     * @param shortRateFlagList         短期费率标志集合
     * @param shortRateList             短期费率集合
     * @param startDate                 保险起期
     * @param endDate                   保险止期
     * @param calculateFlagList         主/附险标识
     * @param fplanRate                 自缴保费份额
     * @param centralRate               中央财政补贴份额
     * @param provinceRate              省级补贴份额
     * @param cityRate                  地市补贴份额
     * @param townRate                  区县补贴份额
     * @param otherRate                 其他补贴份额
     * @param map                       农户标的集合
     * @param txnlistDetailedSubDtoList 清单明细集合
     * @date: 2018/3/8 20:21
     * @author: 何伟东
     */
    private void plantingMethodBase(List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<GisFarmerItemForPremiumDto>> map, List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList) {
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList;
        GisFarmerItemForPremiumDto gisFarmerItemForPremiumDto;
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        for (int i = 0; i < itemListCodes.size(); i++) {
            gisFarmerItemForPremiumDtoList = map.get(itemListCodes.get(i));
            for (int j = 0; j < gisFarmerItemForPremiumDtoList.size(); j++) {
                gisFarmerItemForPremiumDto = gisFarmerItemForPremiumDtoList.get(j);
                txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                //清单编号
                txnlistDetailedSubDto.setInusreListCode(inusreListCode);
                //农户代码
                txnlistDetailedSubDto.setfCode(gisFarmerItemForPremiumDto.getfCode());
                txnlistDetailedSubDto.setfIdCard(gisFarmerItemForPremiumDto.getfIdCard());//农户身份证
                txnlistDetailedSubDto.setfName(gisFarmerItemForPremiumDto.getfName());//农户姓名
                txnlistDetailedSubDto.setPhone(gisFarmerItemForPremiumDto.getfPhone());//联系电话
                txnlistDetailedSubDto.setBank(gisFarmerItemForPremiumDto.getBankName());//开户银行
                txnlistDetailedSubDto.setZhiBuKa(gisFarmerItemForPremiumDto.getAccountNo());
                //标的代码
                txnlistDetailedSubDto.setItemCode(gisFarmerItemForPremiumDto.getItemCode());
                //单位保额
                txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));
                //主险标志
                txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));
                //险别序号
                txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));
                //费率
                txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));
                txnlistDetailedSubDto.setInsureArea(gisFarmerItemForPremiumDto.getInsureCount());
                txnlistDetailedSubDto.setZhiBuKa(gisFarmerItemForPremiumDto.getAccountNo());
                txnlistDetailedSubDto.setfPhone(gisFarmerItemForPremiumDto.getfPhone());
                txnlistDetailedSubDto.setBank(gisFarmerItemForPremiumDto.getBankName());
                //短期费率
                txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));
                //短期费率方式
                txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));
                //老系统在暂存清单时传死为1
                txnlistDetailedSubDto.setIndexCode("1");
                //同老系统保持一致
                txnlistDetailedSubDto.setValidity("1");
                //起保日期
                txnlistDetailedSubDto.setStartDate(startDate);
                //终保日期
                txnlistDetailedSubDto.setEndDate(endDate);
                //险种代码
                txnlistDetailedSubDto.setRiskCode(riskCode);
                //险类代码
                txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));
                //总保额，获取页面的从单位保额乘以投保面积
                txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(gisFarmerItemForPremiumDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                //总保费
                txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate()).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate()).divide(BigDecimal.TEN.multiply(BigDecimal.TEN)))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                // ---------------------------------------农户自缴---------------------------------------------
                txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                // ---------------------------------------补贴金额---------------------------------------------
                //中央财政补贴
                txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //省级财政补贴，看
                txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //地市财政补贴
                txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //县(区)财政补贴
                txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //其他来源补贴
                txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //  尾差处理
                if (!"0".equals(otherRate)) {
                    txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                } else if (!"0".equals(townRate)) {
                    txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                } else if (!"0".equals(cityRate)) {
                    txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                } else if (!"0".equals(provinceRate)) {
                    txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                } else if (!"0".equals(centralRate)) {
                    txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                }
                txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
            }
        }
    }

    /**
     * 3220险种类走的方法
     *
     * @param calPremiumDto 保费计算请求Dto
     * @return CalPremiumResponseDto 返回信息
     * @throws Exception
     * @author: 田健
     * @date: 2017/12/8 11:19
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto UICheckHerdInsuranceCode(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        String policyType = calPremiumDto.getPolicyType();//养殖方式
        String riskCode = calPremiumDto.getRiskCode();//老系统从页面获取
        String inusreListCode = calPremiumDto.getInusrelistcode();//清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();//金禾的清单号
        String serialNo = calPremiumDto.getSerialNo();//金禾的清单序列号
        String strUserCode = SinoRequestContext.getCurrentContext().getUserCode();//获取userCode代码
        String strProposalNo = calPremiumDto.getProposalNo();
        String flag = calPremiumDto.getFlag();
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        BigDecimal singleSumAmount = null;
        double dbSumAmount = 0d;
        if ("getFee".equals(flag)) {//老系统有问题代码UICheckPlantingHerdInsuranceCode.jsp
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            Map<String, NyxInsuranceInfoDto> herdInsuranceInfoMap = gisInsureListApi.findHerdInsuranceInfo(requestInsuranceInfoDto);
            NyxInsuranceInfoDto nyxInsuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                nyxInsuranceInfoDto = herdInsuranceInfoMap.get(KingItemCode);
                bigList.add(String.valueOf(nyxInsuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(nyxInsuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(nyxInsuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(nyxInsuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium() + nyxInsuranceInfoDto.getCentralPremium() + nyxInsuranceInfoDto.getProvincePremium()
                        + nyxInsuranceInfoDto.getCityPremium() + nyxInsuranceInfoDto.getTownPremium() + nyxInsuranceInfoDto.getOtherPremium()));
                count = nyxInsuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setKindCodeList(kindCodeList);
            calPremiumResponseDto.setItemCodeList(itemCodeList);
        } else if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            //保存请求次数
            String times = "";
            if(StringUtils.isNotEmpty(calPremiumDto.getTimes())){
                times = calPremiumDto.getTimes();
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }
            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            //清单序号
            queryGisFarmerItemDto.setSerialNo(serialNo);
            //清单编号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);
            //标的清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);
            //查询金禾中间表信息获得清单农户、标的、投保数量、耳标号等信息
            Map<String, List<HerdFarmerItemDto>> map = gisInsureListApi.queryFarmerItemAndHerdFieldListInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            //我方清单编号
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);
            //金禾清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            //险种代码
            txnlistDetailedMainDto.setRiskCode(riskCode);
            //险类
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));
            //清单序号
            txnlistDetailedMainDto.setSerialNo(serialNo);
            //同老系统保持一致
            txnlistDetailedMainDto.setValidity("1");
            //----------组装清单主表数据end------------------
            // ----------保存养殖险明细表start-----------------------

            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<TxnlistDetailedSubDto>();
            // 保费计算
            this.herdMethodBase(policyType,itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList, rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate, centralRate, provinceRate, cityRate, townRate, otherRate, map, txnlistDetailedSubDtoList);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            txnlistDetailedDto.setTimes(times);//保存请求次数
            //调取清单服务进行保存
            Boolean booleanflag = false;
            //调取清单服务进行保存
            ResponseDto responseDto = gisInsureListApi.UICheckHerdInsuranceCode(txnlistDetailedDto);
            if ((boolean) responseDto.getResultObj()) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
            if("9999".equals(responseDto.getResultCode())){
                throw new BusinessException(responseDto.getResultMsg());
            }
        }

        return calPremiumResponseDto;
    }

    /**
     * 养殖险不带耳标号的存nyxinsurancelist
     *
     * @param calPremiumDto 保费计算请求Dto
     * @return CalPremiumResponseDto 返回信息
     * @throws Exception
     * @author: 田健
     * @date: 2017/12/8 11:19
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto checkNyxInsuranceList(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        String riskCode = calPremiumDto.getRiskCode();//老系统从页面获取
        String policyType = calPremiumDto.getPolicyType();//养殖方式
        String inusreListCode = calPremiumDto.getInusrelistcode();//清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();//金禾的清单号
        String serialNo = calPremiumDto.getSerialNo();//金禾的清单序列号
        String strUserCode = SinoRequestContext.getCurrentContext().getUserCode();//获取userCode代码
        String strProposalNo = calPremiumDto.getProposalNo();
        String flag = calPremiumDto.getFlag();
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        BigDecimal singleSumAmount = null;
        double dbSumAmount = 0d;
        if ("getFee".equals(flag)) {//老系统有问题代码UICheckPlantingHerdInsuranceCode.jsp
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setRiskCode(riskCode);
            Map<String, NyxInsuranceInfoDto> nyxInsuranceInfomap = gisInsureListApi.findNyxInsuranceInfo(requestInsuranceInfoDto);
            NyxInsuranceInfoDto nyxInsuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                nyxInsuranceInfoDto = nyxInsuranceInfomap.get(KingItemCode);
                //此处确定只有养殖险故无需加判断
                bigList.add(String.valueOf(nyxInsuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(nyxInsuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(nyxInsuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(nyxInsuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(nyxInsuranceInfoDto.getfPremium() + nyxInsuranceInfoDto.getCentralPremium() + nyxInsuranceInfoDto.getProvincePremium()
                        + nyxInsuranceInfoDto.getCityPremium() + nyxInsuranceInfoDto.getTownPremium() + nyxInsuranceInfoDto.getOtherPremium()));
                count = nyxInsuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setItemCodeList(itemCodeList);//标的代码
            calPremiumResponseDto.setKindCodeList(kindCodeList);//险别代码
        } else if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }
            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            //清单序号
            queryGisFarmerItemDto.setSerialNo(serialNo);
            //清单编号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);
            //标的清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);
            //查询金禾中间表信息获得清单农户、标的、投保数量、耳标号等信息
            Map<String, List<HerdFarmerItemDto>> map = gisInsureListApi.queryFarmerItemAndHerdFieldListInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            //我方清单编号
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);
            //金禾清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            //险种代码
            txnlistDetailedMainDto.setRiskCode(riskCode);
            //险类
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));
            //清单序号
            txnlistDetailedMainDto.setSerialNo(serialNo);
            //同老系统保持一致
            txnlistDetailedMainDto.setValidity("1");
            //----------组装清单主表数据end------------------
            // ----------保存养殖险明细表start-----------------------

            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<TxnlistDetailedSubDto>();
            // 保费计算
            this.herdMethodBaseForNyxInsuranceList(policyType,itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList, rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate, centralRate, provinceRate, cityRate, townRate, otherRate, map, txnlistDetailedSubDtoList);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            //调取清单服务进行保存
            Boolean booleanflag = false;
            try {
                booleanflag = gisInsureListApi.checkNyxInsuranceCodeForbreeding(txnlistDetailedDto);
            }catch (Exception e){
                e.printStackTrace();
                throw e;
            }
            if (booleanflag) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
        }

        return calPremiumResponseDto;
    }

    /**
     * 养殖险保费计算
     *
     * @param itemListCodes             标的集合
     * @param riskCode                  险种代码
     * @param inusreListCode            清单号码
     * @param kindCodeList              险别集合
     * @param agriUnitAmountMainList    单位保额集合
     * @param rateList                  费率集合
     * @param shortRateFlagList         短期费率标志集合
     * @param shortRateList             短期费率集合
     * @param startDate                 保险起期
     * @param endDate                   保险止期
     * @param calculateFlagList         主/附险标识
     * @param fplanRate                 自缴保费份额
     * @param centralRate               中央财政补贴份额
     * @param provinceRate              省级补贴份额
     * @param cityRate                  地市补贴份额
     * @param townRate                  区县补贴份额
     * @param otherRate                 其他补贴份额
     * @param map                       农户标的集合
     * @param txnlistDetailedSubDtoList 清单明细集合
     * @date: 2018/3/8 20:54
     * @author: 何伟东
     */
    private void herdMethodBase(String policyType,List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<HerdFarmerItemDto>> map, List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList) {
        List<HerdFarmerItemDto> herdFarmerItemDtoList;
        for (int i = 0; i < itemListCodes.size(); i++) {
            herdFarmerItemDtoList = new ArrayList<>();
            herdFarmerItemDtoList = map.get(itemListCodes.get(i));
            if (StringUtils.isNotEmpty(herdFarmerItemDtoList.get(0).getEarLabel())) {//耳标号一个是空，所有都是空，如果有不为空的，那就所有都不为空，跟需求确认过
                TxnlistDetailedSubDto txnlistDetailedSubDto = null;
                for (int j = 0; j < herdFarmerItemDtoList.size(); j++) {
                    txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                    //养殖方式
                    txnlistDetailedSubDto.setBreedingKind(policyType==null?"":policyType);
                    txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                    txnlistDetailedSubDto.setfCode(herdFarmerItemDtoList.get(j).getfCode());//农户代码
                    txnlistDetailedSubDto.setItemCode(herdFarmerItemDtoList.get(j).getItemCode());//标的代码
                    txnlistDetailedSubDto.setEarlAbel(herdFarmerItemDtoList.get(j).getEarLabel());//耳标号
                    txnlistDetailedSubDto.setInsureNumber(1);//若有耳标号则投保数量为1
                    txnlistDetailedSubDto.setBreedingAreaCode(herdFarmerItemDtoList.get(j).getBreedingAreaCode());//养殖地点代码
                    txnlistDetailedSubDto.setBreedingAreaName(herdFarmerItemDtoList.get(j).getBreedingAreaName());//养殖地点名称
                    txnlistDetailedSubDto.setAnimalAge(herdFarmerItemDtoList.get(j).getAnimalAge());//畜龄
                    txnlistDetailedSubDto.setSpecies(herdFarmerItemDtoList.get(j).getSpecies());//养殖品种
                    txnlistDetailedSubDto.setfIdCard(herdFarmerItemDtoList.get(j).getfIdCard());//农户身份证
                    txnlistDetailedSubDto.setfName(herdFarmerItemDtoList.get(j).getfName());//农户姓名
                    txnlistDetailedSubDto.setPhone(herdFarmerItemDtoList.get(j).getfPhone());//联系电话
                    txnlistDetailedSubDto.setBank(herdFarmerItemDtoList.get(j).getBankName());//开户银行
                    txnlistDetailedSubDto.setBankCard(herdFarmerItemDtoList.get(j).getBankNumber());//银行卡帐号
                    txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                    txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                    txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                    txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                    txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                    txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                    txnlistDetailedSubDto.setIndexCode(String.valueOf(j + 1));//老系统在暂存清单时传死为1
                    txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                    txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                    txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                    txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                    txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));//险类代码
                    //总保额，如果耳标号存在，则每个耳标号代表一头猪或者一只鸡等
                    txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(1).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                    //总保费
                    txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate()).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    // ---------------------------------------农户自缴---------------------------------------------
                    txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    // ---------------------------------------补贴金额---------------------------------------------
                    //中央财政补贴
                    txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //省级财政补贴，看
                    txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //地市财政补贴
                    txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //县(区)财政补贴
                    txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //其他来源补贴
                    txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //  尾差处理
                    if (!"0".equals(otherRate)) {
                        txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                    } else if (!"0".equals(townRate)) {
                        txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                    } else if (!"0".equals(cityRate)) {
                        txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                    } else if (!"0".equals(provinceRate)) {
                        txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                    } else if (!"0".equals(centralRate)) {
                        txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                    }
                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
                }

            } else {
                TxnlistDetailedSubDto txnlistDetailedSubDto = null;
                for (int j = 0; j < herdFarmerItemDtoList.size(); j++) {
                    txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                    //养殖方式
                    txnlistDetailedSubDto.setBreedingKind(policyType==null?"":policyType);
                    txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                    txnlistDetailedSubDto.setfCode(herdFarmerItemDtoList.get(j).getfCode());//农户代码
                    txnlistDetailedSubDto.setfName(herdFarmerItemDtoList.get(j).getfName());//农户姓名
                    txnlistDetailedSubDto.setfIdCard(herdFarmerItemDtoList.get(j).getfIdCard());//农户身份证
                    txnlistDetailedSubDto.setItemCode(herdFarmerItemDtoList.get(j).getItemCode());//标的代码
                    txnlistDetailedSubDto.setPhone(herdFarmerItemDtoList.get(j).getfPhone());//联系电话
                    txnlistDetailedSubDto.setBank(herdFarmerItemDtoList.get(j).getBankName());//开户银行
                    txnlistDetailedSubDto.setBankCard(herdFarmerItemDtoList.get(j).getBankNumber());//银行卡帐号
                    txnlistDetailedSubDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(herdFarmerItemDtoList.get(j).getInsureCount())));
                    txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                    txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                    txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                    txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                    txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                    txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                    txnlistDetailedSubDto.setIndexCode(String.valueOf(j + 1));//老系统在暂存清单时传死为1
                    txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                    txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                    txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                    txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                    txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));//险类代码
                    //总保额，获取页面的从单位保额乘以投保面积
                    txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(herdFarmerItemDtoList.get(j).getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                    //总保费
                    txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN)).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    // ---------------------------------------农户自缴---------------------------------------------
                    txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    // ---------------------------------------补贴金额---------------------------------------------
                    //中央财政补贴
                    txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //省级财政补贴，看
                    txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //地市财政补贴
                    txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //县(区)财政补贴
                    txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //其他来源补贴
                    txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //  尾差处理
                    if (!"0".equals(otherRate)) {
                        txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                    } else if (!"0".equals(townRate)) {
                        txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                    } else if (!"0".equals(cityRate)) {
                        txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                    } else if (!"0".equals(provinceRate)) {
                        txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                    } else if (!"0".equals(centralRate)) {
                        txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                    }
                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
                }
            }
        }
    }

    /**
     * 养殖险保费计算
     *
     * @param itemListCodes             标的集合
     * @param riskCode                  险种代码
     * @param inusreListCode            清单号码
     * @param kindCodeList              险别集合
     * @param agriUnitAmountMainList    单位保额集合
     * @param rateList                  费率集合
     * @param shortRateFlagList         短期费率标志集合
     * @param shortRateList             短期费率集合
     * @param startDate                 保险起期
     * @param endDate                   保险止期
     * @param calculateFlagList         主/附险标识
     * @param fplanRate                 自缴保费份额
     * @param centralRate               中央财政补贴份额
     * @param provinceRate              省级补贴份额
     * @param cityRate                  地市补贴份额
     * @param townRate                  区县补贴份额
     * @param otherRate                 其他补贴份额
     * @param map                       农户标的集合
     * @param txnlistDetailedSubDtoList 清单明细集合
     * @date: 2018/3/8 20:54
     * @author: 何伟东
     */
    private void herdMethodBaseForNyxInsuranceList(String policyType,List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<HerdFarmerItemDto>> map, List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList) {
        List<HerdFarmerItemDto> herdFarmerItemDtoList;
        for (int i = 0; i < itemListCodes.size(); i++) {
            herdFarmerItemDtoList = new ArrayList<>();
            herdFarmerItemDtoList = map.get(itemListCodes.get(i));
            if (StringUtils.isNotEmpty(herdFarmerItemDtoList.get(0).getEarLabel())) {//耳标号一个是空，所有都是空，如果有不为空的，那就所有都不为空，跟需求确认过
                TxnlistDetailedSubDto txnlistDetailedSubDto = null;
                for (int j = 0; j < herdFarmerItemDtoList.size(); j++) {
                    txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                    //养殖方式
                    txnlistDetailedSubDto.setBreedingKind(policyType==null?"":policyType);
                    txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                    txnlistDetailedSubDto.setfCode(herdFarmerItemDtoList.get(j).getfCode());//农户代码
                    txnlistDetailedSubDto.setItemCode(herdFarmerItemDtoList.get(j).getItemCode());//标的代码
                    txnlistDetailedSubDto.setEarlAbel(herdFarmerItemDtoList.get(j).getEarLabel());//耳标号
                    txnlistDetailedSubDto.setInsureNumber(1);//若有耳标号则投保数量为1
                    txnlistDetailedSubDto.setBreedingAreaCode(herdFarmerItemDtoList.get(j).getBreedingAreaCode());//养殖地点代码
                    txnlistDetailedSubDto.setBreedingAreaName(herdFarmerItemDtoList.get(j).getBreedingAreaName());//养殖地点名称
                    txnlistDetailedSubDto.setAnimalAge(herdFarmerItemDtoList.get(j).getAnimalAge());//畜龄
                    txnlistDetailedSubDto.setSpecies(herdFarmerItemDtoList.get(j).getSpecies());//养殖品种
                    txnlistDetailedSubDto.setBusinessNo(herdFarmerItemDtoList.get(j).getEarLabel());//NyxINsuranceList表中需要存取，有耳标号则存耳标号没有就存农户代码
                    txnlistDetailedSubDto.setfIdCard(herdFarmerItemDtoList.get(j).getfIdCard());//农户身份证
                    txnlistDetailedSubDto.setfName(herdFarmerItemDtoList.get(j).getfName());//农户姓名
                    txnlistDetailedSubDto.setPhone(herdFarmerItemDtoList.get(j).getfPhone());//联系电话
                    txnlistDetailedSubDto.setBank(herdFarmerItemDtoList.get(j).getBankName());//开户银行
                    txnlistDetailedSubDto.setBankCard(herdFarmerItemDtoList.get(j).getBankNumber());//银行卡帐号
                    txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                    txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                    txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                    // 有耳标号的险种，保费计算时有耳标号，育种数量为1
                    txnlistDetailedSubDto.setBreedingNumber(1);
                    // 赔付数量0
                    txnlistDetailedSubDto.setSettleNumber(0);
                    txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                    txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                    txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                    txnlistDetailedSubDto.setIndexCode(String.valueOf(j + 1));//老系统在暂存清单时传死为1
                    txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                    txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                    txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                    txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                    txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));//险类代码
                    //总保额，如果耳标号存在，则每个耳标号代表一头猪或者一只鸡等
                    txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(1).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                    //总保费
                    txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN)).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    // ---------------------------------------农户自缴---------------------------------------------
                    txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    // ---------------------------------------补贴金额---------------------------------------------
                    //中央财政补贴
                    txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //省级财政补贴，看
                    txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //地市财政补贴
                    txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //县(区)财政补贴
                    txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //其他来源补贴
                    txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //  尾差处理
                    if (!"0".equals(otherRate)) {
                        txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                    } else if (!"0".equals(townRate)) {
                        txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                    } else if (!"0".equals(cityRate)) {
                        txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                    } else if (!"0".equals(provinceRate)) {
                        txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                    } else if (!"0".equals(centralRate)) {
                        txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                    }
                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
                }

            } else {
                TxnlistDetailedSubDto txnlistDetailedSubDto = null;
                for (int j = 0; j < herdFarmerItemDtoList.size(); j++) {
                    txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                    //养殖方式
                    txnlistDetailedSubDto.setBreedingKind(policyType==null?"":policyType);
                    txnlistDetailedSubDto.setInusreListCode(inusreListCode);//清单编号
                    txnlistDetailedSubDto.setfCode(herdFarmerItemDtoList.get(j).getfCode());//农户代码
                    txnlistDetailedSubDto.setItemCode(herdFarmerItemDtoList.get(j).getItemCode());//标的代码
                    txnlistDetailedSubDto.setInsureNumber(Integer.parseInt(new java.text.DecimalFormat("0").format(herdFarmerItemDtoList.get(j).getInsureCount())));
                    txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));//单位保额
                    txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));//主险标志
                    txnlistDetailedSubDto.setfIdCard(herdFarmerItemDtoList.get(j).getfIdCard());//农户身份证
                    txnlistDetailedSubDto.setfName(herdFarmerItemDtoList.get(j).getfName());//农户姓名
                    txnlistDetailedSubDto.setPhone(herdFarmerItemDtoList.get(j).getfPhone());//联系电话
                    txnlistDetailedSubDto.setBank(herdFarmerItemDtoList.get(j).getBankName());//开户银行
                    txnlistDetailedSubDto.setBankCard(herdFarmerItemDtoList.get(j).getBankNumber());//银行卡帐号
                    txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));//险别序号
                    txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));//费率
                    txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));//短期费率
                    txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));//短期费率方式
                    txnlistDetailedSubDto.setIndexCode(String.valueOf(j + 1));//老系统在暂存清单时传死为1
                    // 有耳标号的险种，保费计算时无耳标号，育种数量为投保数量
                    txnlistDetailedSubDto.setBreedingNumber(txnlistDetailedSubDto.getInsureNumber());
                    // 赔付数量0
                    txnlistDetailedSubDto.setSettleNumber(0);
                    txnlistDetailedSubDto.setValidity("1");//同老系统保持一致
                    txnlistDetailedSubDto.setStartDate(startDate);//起保日期
                    txnlistDetailedSubDto.setEndDate(endDate);//终保日期
                    txnlistDetailedSubDto.setRiskCode(riskCode);//险种代码
                    txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));//险类代码
                    //总保额，获取页面的从单位保额乘以投保面积
                    txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(herdFarmerItemDtoList.get(j).getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                    //总保费
                    txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                    // ---------------------------------------农户自缴---------------------------------------------
                    txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    // ---------------------------------------补贴金额---------------------------------------------
                    //中央财政补贴
                    txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //省级财政补贴，看
                    txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //地市财政补贴
                    txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //县(区)财政补贴
                    txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //其他来源补贴
                    txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                    //  尾差处理
                    if (!"0".equals(otherRate)) {
                        txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                    } else if (!"0".equals(townRate)) {
                        txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                    } else if (!"0".equals(cityRate)) {
                        txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                        .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                    } else if (!"0".equals(provinceRate)) {
                        txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                    } else if (!"0".equals(centralRate)) {
                        txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                                new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                    }
                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
                }
            }
        }
    }

    /**
     * 获取投保清单中农户户次与投保清单中总投保数量
     *
     * @param strInsuranceCode 清单号
     * @return map 集合包含户次信息与投保数量
     * @author: 田健
     * @date: 2017/12/7 11:10
     */
    private Map<String, String> getSumInsuredAndSumInsuredFarmer(String strInsuranceCode) throws Exception {
        String dbInsureNo = null;
        String iSumInsuredFarmer = null;
        Map<String, String> map = new HashMap<>();
        map.put("inusrelistCode", strInsuranceCode);
        // 调用清单系统查询投保清单中总投保数量
        Map<String, Double> returndbInsureNo = new HashMap<>();
        returndbInsureNo = nyxInsuranceListApi.queryAreaNumberByInusrelistCode(map);
        dbInsureNo = String.valueOf(returndbInsureNo.get("Message"));
        //  调用清单系统查询投保清单中农户户次
        Map<String, Long> returniSumInsuredFarmer = new HashMap<>();
        returniSumInsuredFarmer = nyxInsuranceListApi.queryFIdCardByInusrelistCode(map);
        iSumInsuredFarmer = String.valueOf(returniSumInsuredFarmer.get("Message"));
        Map<String, String> parmap = new HashMap<String, String>();
        parmap.put("dbInsureNo", String.valueOf(dbInsureNo));
        parmap.put("iSumInsuredFarmer", String.valueOf(iSumInsuredFarmer));
        return parmap;
    }

    /**
     * 删除养殖险的信息
     *
     * @param strInsuranceCode （清单号）
     * @return 返回成功与失败字符串
     * @throws Exception
     * @author: 田健
     * @date: 2017/12/6 19:22
     */
    private String deleteBreedingInsureList(String strInsuranceCode) throws Exception {
        String strReturn = "";
        try {
            insureMainListApi.remove(strInsuranceCode);
            //调用养殖险删除方法
            strReturn = "Delete,删除清单" + strInsuranceCode + "成功！";
        } catch (Exception e) {
            strReturn = "删除清单失败！";
        }
        return strReturn;
    }

    /**
     * 更新投保单与清单关联信息
     *
     * @param strProposalNo (投保单号)
     * @param strReturn     信息
     * @return 返回失败或成功信息
     * @author: 田健
     * @date: 2017/12/6 19:38
     */
    private String deleteRelationInPrpTmainAgri(String strProposalNo, String strReturn) {
        PrpTmainAgriDto prpTmainAgriDto = prpTmainAgriService.queryByPK(strProposalNo);
        prpTmainAgriDto.setRelationListNo("");
        prpTmainAgriDto.setRelationListNoRemark("");
        try {
            prpTmainAgriService.save(prpTmainAgriDto);
        } catch (Exception e) {
            strReturn += "  更新投保单与清单关联失败！";
        }
        return strReturn;
    }

    /**
     * 3101
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param calPremiumDto 保费计算请求dto
     * @return CalPremiumResponseDto 返回dto
     * @throws Exception
     * @author: 田健
     * @date: 2017/10/20 11:43
     */
    @Transactional(rollbackFor = Exception.class)
    public CalPremiumResponseDto check31InsuranceCode(CalPremiumDto calPremiumDto) throws Exception {
        if (StringUtils.isEmpty(calPremiumDto.getFlag())) {
            throw new DataVerifyException("flag标识不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getInusrelistcode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getGisInusrelistcode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(calPremiumDto.getSerialNo())) {
            throw new DataVerifyException("金禾的清单序列号不能为空！");
        }
        List<String> itemListCodes = calPremiumDto.getItemListCodes();
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单编号不能为空！");
        }
        List<String> kindCodeList = calPremiumDto.getKindCodeList();
        if (kindCodeList.size() == 0) {
            throw new DataVerifyException("险别序号不能为空！");
        }
        List<String> itemCodeList = calPremiumDto.getItemCodeList();
        if (itemCodeList.size() == 0) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        //老系统从页面获取
        String riskCode = calPremiumDto.getRiskCode();
        String flag = calPremiumDto.getFlag();
        //清单号
        String inusreListCode = calPremiumDto.getInusrelistcode();
        //金禾的清单号
        String gisInusreListCode = calPremiumDto.getGisInusrelistcode();
        //金禾的清单序列号
        String serialNo = calPremiumDto.getSerialNo();
        CalPremiumResponseDto calPremiumResponseDto = new CalPremiumResponseDto();
        if ("T02".equals(flag)) {
            if (StringUtils.isEmpty(calPremiumDto.getProposalNo())) {
                throw new DataVerifyException("投保单号不能为空！");
            }
            String proposalNo = calPremiumDto.getProposalNo();
            List<String> agriUnitAmountMainList = calPremiumDto.getAgriUnitAmountMainList();
            if (agriUnitAmountMainList.size() == 0) {
                throw new DataVerifyException("单位保额不能为空！");
            }
            List<String> rateList = calPremiumDto.getRateList();
            if (rateList.size() == 0) {
                throw new DataVerifyException("费率不能为空！");
            }
            List<String> shortRateFlagList = calPremiumDto.getShortRateFlagList();
            if (shortRateFlagList.size() == 0) {
                throw new DataVerifyException("短期费率方式不能为空！");
            }
            List<String> shortRateList = calPremiumDto.getShortRateList();
            if (shortRateList.size() == 0) {
                throw new DataVerifyException("短期费率不能为空！");
            }
            if (calPremiumDto.getStartDate() == null) {
                throw new DataVerifyException("起保日期不能为空！");
            }
            Date startDate = calPremiumDto.getStartDate();
            if (calPremiumDto.getEndDate() == null) {
                throw new DataVerifyException("终保日期不能为空！");
            }
            Date endDate = calPremiumDto.getEndDate();
            List<String> calculateFlagList = calPremiumDto.getCalculateFlagList();
            if (calculateFlagList.size() == 0) {
                throw new DataVerifyException("主险标志不能为空！");
            }
            String times = "";
            if(StringUtils.isNotEmpty(calPremiumDto.getTimes())){
                times = calPremiumDto.getTimes();
            }
            //补贴比例
            //自留份额比例
            String fplanRate = calPremiumDto.getFplanRate();
            if (StringUtils.isEmpty(fplanRate)) {
                fplanRate = "0";
            }
            //中央财政补贴比例
            String centralRate = calPremiumDto.getCentralRate();
            if (StringUtils.isEmpty(centralRate)) {
                centralRate = "0";
            }
            //省级财政补贴比例
            String provinceRate = calPremiumDto.getProvinceRate();
            if (StringUtils.isEmpty(provinceRate)) {
                provinceRate = "0";
            }
            //地市财政补贴比例
            String cityRate = calPremiumDto.getCityRate();
            if (StringUtils.isEmpty(cityRate)) {
                cityRate = "0";
            }
            //县（区）财政补贴比例
            String townRate = calPremiumDto.getTownRate();
            if (StringUtils.isEmpty(townRate)) {
                townRate = "0";
            }
            //其他补贴比例
            String otherRate = calPremiumDto.getOtherRate();
            if (StringUtils.isEmpty(otherRate)) {
                otherRate = "0";
            }

            // 从金禾中间表取数据，金禾的清单号gisInusreListCode
            QueryGisFarmerItemDto queryGisFarmerItemDto = new QueryGisFarmerItemDto();
            //清单序号
            queryGisFarmerItemDto.setSerialNo(serialNo);
            //清单编号
            queryGisFarmerItemDto.setInsureListCode(gisInusreListCode);
            //标的清单编号
            queryGisFarmerItemDto.setItemListCodes(itemListCodes);
            //查询金禾中间表信息获得清单农户、标的、投保数量等信息
            Map<String, List<GisFarmerItemForPremiumDto>> map = gisInsureListApi.queryGisFarmerItemInfo(queryGisFarmerItemDto);
            //----------组装清单主表数据start------------------
            TxnlistDetailedMainDto txnlistDetailedMainDto = new TxnlistDetailedMainDto();
            //我方清单编号
            txnlistDetailedMainDto.setInusreListCode(inusreListCode);
            //金禾清单编号
            txnlistDetailedMainDto.setGisInsureListCode(gisInusreListCode);
            txnlistDetailedMainDto.setProposalNo(proposalNo);
            //险种代码
            txnlistDetailedMainDto.setRiskCode(riskCode);
            //险类
            txnlistDetailedMainDto.setClassCode(riskCode.substring(0, 2));
            //清单序号
            txnlistDetailedMainDto.setSerialNo(serialNo);
            //同老系统保持一致
            txnlistDetailedMainDto.setValidity("1");
            //----------组装清单主表数据end------------------
            //----------保存投种植险保清单明细表start-----------------------
            //--------------循环标的清单编号itemListCodes------------
            List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<TxnlistDetailedSubDto>();
            Map<String, List<TxnlistDetailedSubDto>> txnlistDetailedmap = new HashMap<String, List<TxnlistDetailedSubDto>>();
            // 保费计算
            planting31MethodBase(itemListCodes, riskCode, inusreListCode, kindCodeList, agriUnitAmountMainList,
                    rateList, shortRateFlagList, shortRateList, startDate, endDate, calculateFlagList, fplanRate,
                    centralRate, provinceRate, cityRate, townRate, otherRate, map, txnlistDetailedSubDtoList);
            //----------保存投种植险保清单明细表end-----------------------
            TxnlistDetailedDto txnlistDetailedDto = new TxnlistDetailedDto();
            txnlistDetailedDto.setTxnlistDetailedMainDto(txnlistDetailedMainDto);
            txnlistDetailedDto.setTxnlistDetailedSubDtoList(txnlistDetailedSubDtoList);
            txnlistDetailedDto.setTimes(times);
            Boolean booleanflag = false;
            //调取清单服务进行保存
            ResponseDto responseDto = gisInsureListApi.check31InsuranceCode(txnlistDetailedDto);
            if ((boolean) responseDto.getResultObj()) {
                calPremiumResponseDto.setMessage("Success");
            } else {
                calPremiumResponseDto.setMessage("Failed");
            }
            if("9999".equals(responseDto.getResultCode())){
                throw new BusinessException(responseDto.getResultMsg());
            }
        } else if ("getFee".equals(flag)) {//获取补贴费用及自缴份额，给页面赋值（回写主险保费、缴费计划中的信息）
            //本方法虽然只针对单险别单标的险种，但是为了与多险别多标的险种返回格式的统一，故返回设置为lsit
            RequestInsuranceInfoDto requestInsuranceInfoDto = new RequestInsuranceInfoDto();
            requestInsuranceInfoDto.setInsureListCode(inusreListCode);//清单编号
            requestInsuranceInfoDto.setGisInsureListCode(gisInusreListCode);//金禾清单编号
            requestInsuranceInfoDto.setItemListCodeList(itemListCodes);//标的清单编号
            requestInsuranceInfoDto.setSerialNo(Integer.valueOf(serialNo));//清单序号
            requestInsuranceInfoDto.setKindCodeList(kindCodeList);
            requestInsuranceInfoDto.setItemCodeList(itemCodeList);
            Map<String, InsuranceInfoDto> insuranceInfoMap = gisInsureListApi.find31InsuranceInfo(requestInsuranceInfoDto);
            InsuranceInfoDto insuranceInfoDto = null;
            List<String> bigList = new ArrayList<String>();
            List<String> sumPremiumList = new ArrayList<String>();
            List<String> fPremiumList = new ArrayList<String>();
            List<String> centralPremiumList = new ArrayList<String>();
            List<String> provincePremiumList = new ArrayList<String>();
            List<String> cityPremiummList = new ArrayList<String>();
            List<String> townPremiumList = new ArrayList<String>();
            List<String> otherPremiumList = new ArrayList<String>();
            List<String> itemListCodesAdd = new ArrayList<>();
            List<String> iSumInsuredList = new ArrayList<>();
            Long count = 0L;
            String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                insuranceInfoDto = insuranceInfoMap.get(KingItemCode);
                bigList.add(String.valueOf(insuranceInfoDto.getInsureArea()));
                itemListCodesAdd.add(itemListCodes.get(i));
                //每个标的的农户数量
                iSumInsuredList.add(String.valueOf(insuranceInfoDto.getiSumInsured()));
                fPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium()));
                centralPremiumList.add(String.valueOf(insuranceInfoDto.getCentralPremium()));
                provincePremiumList.add(String.valueOf(insuranceInfoDto.getProvincePremium()));
                cityPremiummList.add(String.valueOf(insuranceInfoDto.getCityPremium()));
                townPremiumList.add(String.valueOf(insuranceInfoDto.getTownPremium()));
                otherPremiumList.add(String.valueOf(insuranceInfoDto.getOtherPremium()));
                sumPremiumList.add(String.valueOf(insuranceInfoDto.getfPremium() + insuranceInfoDto.getCentralPremium() + insuranceInfoDto.getProvincePremium()
                        + insuranceInfoDto.getCityPremium() + insuranceInfoDto.getTownPremium() + insuranceInfoDto.getOtherPremium()));
                count = insuranceInfoDto.getConut();
            }
            calPremiumResponseDto.setFlag("getFee");
            //农户数量
            calPremiumResponseDto.setiSumInsuredList(iSumInsuredList);
            calPremiumResponseDto.setItemListCodes(itemListCodesAdd);//标的清单编号
            calPremiumResponseDto.setBigList(bigList);//承保面积
            calPremiumResponseDto.setKindCodeList(kindCodeList);
            //总的承保数量
            calPremiumResponseDto.setCount(String.valueOf(count));
            calPremiumResponseDto.setfPremiumList(fPremiumList);//自留份额比例
            calPremiumResponseDto.setCentralPremiumList(centralPremiumList);//中央财政补贴比例
            calPremiumResponseDto.setProvincePremiumList(provincePremiumList);//省级财政补贴比例
            calPremiumResponseDto.setCityPremiumList(cityPremiummList);//地市财政补贴比例
            calPremiumResponseDto.setTownPremiumList(townPremiumList);//县（区）财政补贴比例
            calPremiumResponseDto.setOtherPremiumList(otherPremiumList);//其他补贴比例
            calPremiumResponseDto.setSumPremiumList(sumPremiumList);//总保费
            calPremiumResponseDto.setItemCodeList(itemCodeList);
        } else if ("Delete".equals(flag)) {//删除清单信息,新系统应该不需要
            InsureMainListDto insureMainListDto = new InsureMainListDto();
            insureMainListDto = insureMainListApi.queryByPK(inusreListCode);
            if (insureMainListDto != null) {
                //根据清单号删除insureMainList与 plantingInsuranceList
                insureMainListApi.remove(inusreListCode);
                plantingInsuranceListApi.removeByInusreListcode(inusreListCode);
                calPremiumResponseDto.setMessage("删除关联成功！");
            } else {
                throw new DataVerifyException("删除关联失败！");
            }

        }
        return calPremiumResponseDto;
    }

    /**
     * 31大棚蔬菜保费计算
     *
     * @param itemListCodes             标的集合
     * @param riskCode                  险种代码
     * @param inusreListCode            清单号码
     * @param kindCodeList              险别集合
     * @param agriUnitAmountMainList    单位保额集合
     * @param rateList                  费率集合
     * @param shortRateFlagList         短期费率标志集合
     * @param shortRateList             短期费率集合
     * @param startDate                 保险起期
     * @param endDate                   保险止期
     * @param calculateFlagList         主/附险标识
     * @param fplanRate                 自缴保费份额
     * @param centralRate               中央财政补贴份额
     * @param provinceRate              省级补贴份额
     * @param cityRate                  地市补贴份额
     * @param townRate                  区县补贴份额
     * @param otherRate                 其他补贴份额
     * @param map                       农户标的集合
     * @param txnlistDetailedSubDtoList 清单明细集合
     * @date: 2018/3/8 20:21
     * @author: 何伟东
     */
    private void planting31MethodBase(List<String> itemListCodes, String riskCode, String inusreListCode, List<String> kindCodeList, List<String> agriUnitAmountMainList, List<String> rateList, List<String> shortRateFlagList, List<String> shortRateList, Date startDate, Date endDate, List<String> calculateFlagList, String fplanRate, String centralRate, String provinceRate, String cityRate, String townRate, String otherRate, Map<String, List<GisFarmerItemForPremiumDto>> map, List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList) {
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList;
        GisFarmerItemForPremiumDto gisFarmerItemForPremiumDto;
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        for (int i = 0; i < itemListCodes.size(); i++) {
            gisFarmerItemForPremiumDtoList = map.get(itemListCodes.get(i));
            for (int j = 0; j < gisFarmerItemForPremiumDtoList.size(); j++) {
                gisFarmerItemForPremiumDto = gisFarmerItemForPremiumDtoList.get(j);
                txnlistDetailedSubDto = new TxnlistDetailedSubDto();
                //清单编号
                txnlistDetailedSubDto.setInusreListCode(inusreListCode);
                //排序序号
                txnlistDetailedSubDto.setIndexCode(String.valueOf(j + 1));
                //农户代码
                txnlistDetailedSubDto.setfCode(gisFarmerItemForPremiumDto.getfCode());
                //标的代码
                txnlistDetailedSubDto.setItemCode(gisFarmerItemForPremiumDto.getItemCode());
                //单位保额
                txnlistDetailedSubDto.setAmount(Double.valueOf(agriUnitAmountMainList.get(i)));
                //主险标志
                txnlistDetailedSubDto.setCalculateFlag(calculateFlagList.get(i));
                //险别序号
                txnlistDetailedSubDto.setKindCode(kindCodeList.get(i));
                txnlistDetailedSubDto.setfName(gisFarmerItemForPremiumDto.getfName());
                txnlistDetailedSubDto.setBank(gisFarmerItemForPremiumDto.getBankName());
                txnlistDetailedSubDto.setfIdCard(gisFarmerItemForPremiumDto.getfIdCard());
                txnlistDetailedSubDto.setfPhone(gisFarmerItemForPremiumDto.getfPhone());
                txnlistDetailedSubDto.setZhiBuKa(gisFarmerItemForPremiumDto.getAccountNo());
                txnlistDetailedSubDto.setInsureArea(gisFarmerItemForPremiumDto.getInsureCount());
                //费率
                txnlistDetailedSubDto.setRate(Double.valueOf(rateList.get(i)));
                //短期费率
                txnlistDetailedSubDto.setShortRate(Double.valueOf(shortRateList.get(i)));
                //短期费率方式
                txnlistDetailedSubDto.setShortRateFlag(shortRateFlagList.get(i));
                //老系统在暂存清单时传死为1
                txnlistDetailedSubDto.setIndexCode("1");
                //同老系统保持一致
                txnlistDetailedSubDto.setValidity("1");
                //起保日期
                txnlistDetailedSubDto.setStartDate(startDate);
                //终保日期
                txnlistDetailedSubDto.setEndDate(endDate);
                //险种代码
                txnlistDetailedSubDto.setRiskCode(riskCode);
                //险类代码
                txnlistDetailedSubDto.setClassCode(riskCode.substring(0, 2));
                //总保额，获取页面的从单位保额乘以投保面积
                txnlistDetailedSubDto.setSumAmount((new BigDecimal(txnlistDetailedSubDto.getAmount()).multiply(new BigDecimal(gisFarmerItemForPremiumDto.getInsureCount()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP)).doubleValue()));
                //总保费
                txnlistDetailedSubDto.setSumPremium(((new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(new BigDecimal(txnlistDetailedSubDto.getRate()).multiply(new BigDecimal(txnlistDetailedSubDto.getShortRate())).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue()));
                // ---------------------------------------农户自缴---------------------------------------------
                txnlistDetailedSubDto.setfPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(fplanRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                // ---------------------------------------补贴金额---------------------------------------------
                //中央财政补贴
                txnlistDetailedSubDto.setCentralPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(centralRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //省级财政补贴，看
                txnlistDetailedSubDto.setProvincePremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(provinceRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //地市财政补贴
                txnlistDetailedSubDto.setCityPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(cityRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //县(区)财政补贴
                txnlistDetailedSubDto.setTownPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(townRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //其他来源补贴
                txnlistDetailedSubDto.setOtherPremium(((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(new BigDecimal(otherRate))).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP).doubleValue());
                //  尾差处理
                if (!"0".equals(otherRate)) {
                    txnlistDetailedSubDto.setOtherPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getTownPremium())))).doubleValue());
                } else if (!"0".equals(townRate)) {
                    txnlistDetailedSubDto.setTownPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())).add(new BigDecimal(txnlistDetailedSubDto.getCityPremium())))).doubleValue());
                } else if (!"0".equals(cityRate)) {
                    txnlistDetailedSubDto.setCityPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium()))
                                    .add(new BigDecimal(txnlistDetailedSubDto.getProvincePremium())))).doubleValue());
                } else if (!"0".equals(provinceRate)) {
                    txnlistDetailedSubDto.setProvincePremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()).add(new BigDecimal(txnlistDetailedSubDto.getCentralPremium())))).doubleValue());
                } else if (!"0".equals(centralRate)) {
                    txnlistDetailedSubDto.setCentralPremium((new BigDecimal(txnlistDetailedSubDto.getSumPremium()).subtract(
                            new BigDecimal(txnlistDetailedSubDto.getfPremium()))).doubleValue());
                }
                //判断txnlistDetailedmap中key是否存在，存在就把值加进value，不存在就新建一个map，put进去
//                if (txnlistDetailedmap.containsKey(gisFarmerItemDto.getfCode())) {
//                    txnlistDetailedmap.get(gisFarmerItemDto.getfCode()).add(txnlistDetailedSubDto);
//                } else {
//                    txnlistDetailedSubDtoList = new ArrayList<TxnlistDetailedSubDto>();
//                    txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
//                    txnlistDetailedmap.put(gisFarmerItemDto.getfCode(), txnlistDetailedSubDtoList);
//                }
                txnlistDetailedSubDtoList.add(txnlistDetailedSubDto);
            }
        }
    }
}
