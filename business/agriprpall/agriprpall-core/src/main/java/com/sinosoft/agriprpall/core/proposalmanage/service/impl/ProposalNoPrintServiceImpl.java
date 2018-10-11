package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.ItemKingAgriccDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.proposalmanage.dao.*;
import com.sinosoft.agriprpall.core.proposalmanage.dao.specification.InsuranceFormPrintSpecBuilder;
import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalNoPrintService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.kernel.PrpDclauseCodeApi;
import com.sinosoft.pms.api.kernel.PrpDrelationClauseCodeApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeDto;
import com.sinosoft.pms.api.kernel.dto.PrpDrelationClauseCodeDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *（投保单打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/5 11:55
 */
@Service
public class ProposalNoPrintServiceImpl extends BaseServiceImpl implements ProposalNoPrintService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalNoPrintServiceImpl.class);
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpTinsuredDao prpTinsuredDao;
    @Autowired
    private PrpTaddressDao prpTaddressDao;
    @Autowired
    private PrpTengageDao prpTengageDao;
    @Autowired
    private PrpTitemKindAgriDao prpTitemKindAgriDao;
    @Autowired
    private PrpTitemKindDao prpTitemKindDao;
    @Autowired
    private PrpTplanDao prpTplanDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    PrpTmainAgriDao prpTmainAgriDao;
    @Autowired
    private PrpTsubsidyDao prpTsubsidyDao;
    @Autowired
    private PrpDclauseCodeApi prpDclauseCodeApi;
    @Autowired
    private PrpDrelationClauseCodeApi prpDrelationClauseCodeApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    /**
     * @description:投保单打印查询
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo 投保单号
     * @return 打印查询所需的数据
     * @throws Exception
     */
    @Override
    public ResponseInsuranceFormPrintDto queryInsuranceFormPrintByCondition(String proposalNo) throws Exception {
        //todo流水号校验，后期增加
        if(StringUtils.isEmpty(proposalNo)){
            throw new DataVerifyException("投保单号不能为空");
        }
        if(proposalNo.substring(0,1).equals("2")){

        }
        //投保单号，保险期间，总保险金额，总保险费查询
        PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
        String comcode=null;
        String operatorCode=null;
        String handlerCode=null;
        String StatUnitCode = null;
        String clauseName="";
        if(prpTmain!=null){
            comcode=prpTmain.getComCode();
            operatorCode=prpTmain.getOperatorCode();
            handlerCode=prpTmain.getHandlerCode();
            StatUnitCode=prpTmain.getStatUnitCode();
            List<PrpDrelationClauseCodeDto> prpDrelationClauseCodeDtoList = new ArrayList<>();
            if(prpTmain.getVersionNo()!=null){
                prpDrelationClauseCodeDtoList = prpDrelationClauseCodeApi.queryByClauseCode(prpTmain.getVersionNo());
                Map<String,String> map=new HashMap<>();
                map.put("clauseCode",prpTmain.getVersionNo());
                PrpDclauseCodeDto prpDclauseCodeDto=prpDclauseCodeApi.queryByPK(map);
                if(prpDclauseCodeDto!=null){
                    clauseName=prpDclauseCodeDto.getClauseName();
                }
            }
        }
        PrpTmainAgri prpTmainAgri = prpTmainAgriDao.findOne( new PrpTmainAgriKey(proposalNo));
        //名称，短信，地址，邮编查询
        Specification<PrpTinsured> prpTinsuredSpecification = InsuranceFormPrintSpecBuilder.prpTinsuredByProposalNoSpecification(proposalNo);
        List<PrpTinsured> prpTinsuredList = prpTinsuredDao.findAll(prpTinsuredSpecification);
        //投保面积，单位约定产量，约定价格，单位保险金额查询
        Specification<PrpTitemKindAgri> prpTitemKindAgriSpecification = InsuranceFormPrintSpecBuilder.prpTitemKindAgriByProposalNoSpecification(proposalNo);
        List<PrpTitemKindAgri> prpTitemKindAgriList = prpTitemKindAgriDao.findAll(prpTitemKindAgriSpecification);
        //保险金额，费率，保险费，主险保费，附加险保费查询
        Specification<PrpTitemKind> prpTitemKindSpecification = InsuranceFormPrintSpecBuilder.prpTitemKindByProposalNoSpecification(proposalNo);
        List<PrpTitemKind> prpTitemKindlist = prpTitemKindDao.findAll(prpTitemKindSpecification);
        //投保财产地点查询
        Specification<PrpTaddress> prpTaddressSpecification = InsuranceFormPrintSpecBuilder.prpTaddressByProposalNoSpecification(proposalNo);
        List<PrpTaddress> prpTaddressList = prpTaddressDao.findAll(prpTaddressSpecification);
        //付费日期查询
        Specification<PrpTplan> prpTplanSpecification = InsuranceFormPrintSpecBuilder.prpTplanByProposalNoSpecification(proposalNo);
        List<PrpTplan> prpTplanList = prpTplanDao.findAll(prpTplanSpecification);
        //绝对免赔率，特约信息查询
        Specification<PrpTengage> prpTengageSpecification = InsuranceFormPrintSpecBuilder.prpTengageProposalNoSpecification(proposalNo);
        List<PrpTengage> prpTengageList = prpTengageDao.findAll(prpTengageSpecification);
        //保险费构成
        Specification<PrpTsubsidy> prpTsubsidySpecification = InsuranceFormPrintSpecBuilder.prpTsubsidyProposalNoSpecification(proposalNo);
        List<PrpTsubsidy> prpTsubsidyList = prpTsubsidyDao.findAll(prpTsubsidySpecification);


        //被保险人信息赋值，
        //定义被保险人信息对象
        InsuredInfoDto insuredInfoDto = new InsuredInfoDto();
        String  codecode= "";
        for (PrpTinsured prpTinsured:prpTinsuredList){
            if("1".equals(prpTinsured.getInsuredFlag())){
                codecode= prpTinsured.getInsuredIdentity();
                insuredInfoDto.setInsuredName(prpTinsured.getInsuredName());
                insuredInfoDto.setMobile(prpTinsured.getPhoneNumber());
                insuredInfoDto.setInsureAddress(prpTinsured.getInsuredAddress());
                insuredInfoDto.setPostCode(prpTinsured.getPostCode());
                insuredInfoDto.setInsuredIdNum(prpTinsured.getIdentifyNumber());
            }else if("2".equals(prpTinsured.getInsuredFlag())){
                insuredInfoDto.setAppInsuredName(prpTinsured.getInsuredName());
            }
        }
        if (prpTaddressList != null && prpTaddressList.size() > 0) {
            insuredInfoDto.setAddressName(prpTaddressList.get(0).getAddressName());
        }
        insuredInfoDto.setInsuredCode(prpTmain.getInsuredCode());
        insuredInfoDto.setOperateDate(DateUtils.dateToStr(prpTmain.getOperateDate()));
        insuredInfoDto.setUnderWriteName(prpTmain.getUnderwriteName());
        if(prpTmainAgri!=null){
            insuredInfoDto.setRemark(prpTmainAgri.getRemark());
            insuredInfoDto.setRemark(prpTmainAgri.getRemark());
            String raiseType="";
            if(com.sinosoft.framework.core.utils.StringUtils.isNotEmpty(prpTmainAgri.getRaiseType())){
                raiseType=prpDcodeApi.translateCode("RaiseType",prpTmainAgri.getRaiseType(),"zh-CN");
            }
            insuredInfoDto.setRaiseType(raiseType);
        }
        insuredInfoDto.setPolicyType(prpTmain.getPolicyType());
        insuredInfoDto.setSumInsured(prpTmain.getSumInsured() + "");

        //主信息赋值
        ResponseInsuranceFormPrintDto responseInsuranceFormPrintDto = new ResponseInsuranceFormPrintDto();
        if("3130".equals(prpTmain.getRiskCode())){//草莓 同投保人判断
            if(insuredInfoDto.getInsuredName().equals(insuredInfoDto.getAppInsuredName())){
                responseInsuranceFormPrintDto.setInsureflag("1");
            }else {
                responseInsuranceFormPrintDto.setInsureflag("2");
            }
        }
        String com=prpTmain.getComCode().substring(0,2);
        responseInsuranceFormPrintDto.setArgueSolution(prpTmain.getArgueSolution());
        if("2".equals(prpTmain.getArgueSolution())){
            if("34".equals(com)){
                responseInsuranceFormPrintDto.setArbitBoardName("合肥市仲裁委员会");
            }else if("41".equals(com)){
                responseInsuranceFormPrintDto.setArbitBoardName("郑州市仲裁委员会");
            }else if("42".equals(com)){
                responseInsuranceFormPrintDto.setArbitBoardName("武汉市仲裁委员会");
            }else if("52".equals(com)){
                responseInsuranceFormPrintDto.setArbitBoardName("贵州市仲裁委员会");
            }
        }
        responseInsuranceFormPrintDto.setProposalNo(prpTmain.getProposalNo());
        PrpDcodeDto prpDcode1Dto = prpDcodeApi.queryByPK("CrossCode", "01");
        PrpDcodeDto prpDcode2Dto = prpDcodeApi.queryByPK("CrossCode", "02");
        PrpDcodeDto prpDcode3Dto = prpDcodeApi.queryByPK("CrossCode", "03");
        if (StringUtils.isNotEmpty(codecode)){
            PrpDcodeDto prpDcode4Dto = prpDcodeApi.queryByPK("InsuredIdentity", codecode);
            insuredInfoDto.setInsuredInsuredidenty(prpDcode4Dto.getCodeCName());
        }
        responseInsuranceFormPrintDto.setCode1(prpDcode1Dto.getCodeCName());
        responseInsuranceFormPrintDto.setCode2(prpDcode2Dto.getCodeCName());
        responseInsuranceFormPrintDto.setCode3(prpDcode3Dto.getCodeCName());
        //保险期间赋值
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        insuredInfoDto.setStartDate(simpleDateFormat.format(prpTmain.getStartDate()));
        insuredInfoDto.setEndDate(simpleDateFormat.format(prpTmain.getEndDate()));
        responseInsuranceFormPrintDto.setInsuredInfoDto(insuredInfoDto);

        //总保费，总保额赋值
        InsuraneItemsDto insuraneItemsDto = new InsuraneItemsDto();
        insuraneItemsDto.setSumAmount(this.doubleToStr(prpTmain.getSumAmount(),2));
        insuraneItemsDto.setSumPremium(this.doubleToStr(prpTmain.getSumPremium(),2));
        if(StringUtils.isNotEmpty(prpTmain.getComCode())){
            String comName=prpDcodeApi.translateCode("BusinessZone",prpTmain.getComCode().substring(0,6),"zh-CN");
            responseInsuranceFormPrintDto.setComName(comName);
        }
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comcode);
        responseInsuranceFormPrintDto.setHandlerName(prpDcompanyDto.getComCName());
        String riskName="";
        if(StringUtils.isNotEmpty(prpTmain.getRiskCode())) {
            Map map = new HashMap();
            map.put("riskCode",prpTmain.getRiskCode());
            map.put("isChinese", LanguageFlagConstant.CHINESE);
            riskName=prpDriskApi.translateCode(map);
        }
        responseInsuranceFormPrintDto.setRiskCName(riskName);
        responseInsuranceFormPrintDto.setClauseName(clauseName);
        //补贴交付比例赋值
//        List<PremiumConDto> list = new ArrayList<>();
        PremiumConDto premiumConDto = new PremiumConDto();
        double subSidy10Rate=0;
        for(PrpTsubsidy prpTsubsidy:prpTsubsidyList){
            if("03".equals(prpTsubsidy.getSubsidyCode())){//中央财政补贴
                premiumConDto.setSubSidy03Rate(this.doubleToStr(prpTsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpTsubsidy.getSubsidyRate();
            }
            if("04".equals(prpTsubsidy.getSubsidyCode())){//省级财政补贴
                premiumConDto.setSubSidy04Rate(this.doubleToStr(prpTsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpTsubsidy.getSubsidyRate();
            }
            if("05".equals(prpTsubsidy.getSubsidyCode())){//地市县财政补贴
                premiumConDto.setSubSidy05Rate(this.doubleToStr(prpTsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpTsubsidy.getSubsidyRate();
            }
            if("06".equals(prpTsubsidy.getSubsidyCode())){//其他来源补贴
                premiumConDto.setSubSidy06Rate(this.doubleToStr(prpTsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpTsubsidy.getSubsidyRate();
            }
            if("07".equals(prpTsubsidy.getSubsidyCode())){//县区财政补贴
                premiumConDto.setSubSidy07Rate(this.doubleToStr(prpTsubsidy.getSubsidyRate(),2));
                subSidy10Rate+=prpTsubsidy.getSubsidyRate();
            }
        }
        premiumConDto.setSubSidy10Rate(this.doubleToStr(100-subSidy10Rate,2));

        //承保明细赋值
        List<ItemKingAgriDto> itemKingAgriDtoList = new ArrayList<>();
        List<ItemKingAgriSubDto> itemKingAgriSubDtoList = new ArrayList<>();
        ItemKingAgriDto itemKingAgriDto = new ItemKingAgriDto();
        ItemKingAgriSubDto itemKingAgriSubDto = new ItemKingAgriSubDto();
        PrpTitemKind prpTitemKind = new PrpTitemKind();
        List<PrpTitemKindAgri> prpTitemKindAgrilist1=new ArrayList<>();
        List<PrpTitemKind> listMain =new ArrayList<>();//主险
        List<PrpTitemKind> listSub =new ArrayList<>();//附加险
        PrpTitemKind listKind =null;
        PrpTitemKind listKindSub =null;
        PrpTitemKindAgri listAgri =null;
        List<ItemKingAgriccDto> itemKingAgriccDtoList=new ArrayList<>();//茬次
        ItemKingAgriccDto itemKingAgriccDto = new ItemKingAgriccDto();

        for (PrpTitemKindAgri prpTitemKindAgri : prpTitemKindAgriList) {
            prpTitemKindAgrilist1.add(prpTitemKindAgri);
            if(prpTitemKindAgri.getEndDate()!=null&&prpTitemKindAgri.getStratDate()!=null){
                SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
                long days=prpTitemKindAgri.getEndDate().getTime()-prpTitemKindAgri.getStratDate().getTime();
                responseInsuranceFormPrintDto.setCmStartDate(format.format(prpTitemKindAgri.getStratDate()));
                responseInsuranceFormPrintDto.setCmEndDate(format.format(prpTitemKindAgri.getEndDate()));
                responseInsuranceFormPrintDto.setDaySum((days/(1000*3600*24))+"");
            }

        }
        for(int i=0;i<prpTitemKindlist.size();i++){
             prpTitemKind = prpTitemKindlist.get(i);
            if(prpTitemKind.getFlag()!=null&&"1".equals(prpTitemKind.getFlag().substring(1,2))){//主险
                  listMain.add(prpTitemKind);
            }else if(prpTitemKind.getFlag()!=null&&"2".equals(prpTitemKind.getFlag().substring(1,2))){//附加险
                listSub.add(prpTitemKind);
            }
        }
        for(int i=0;i<listMain.size();i++){//主险赋值
            itemKingAgriDto = new ItemKingAgriDto();
          if(listMain.size()>4){
              if(!"详见主险清单".equals(itemKingAgriDtoList.get(0).getItemDetailName())){
                  itemKingAgriDto.setItemDetailName("详见主险清单");
                  itemKingAgriDtoList.add(itemKingAgriDto);
              }
          }
            listKind=listMain.get(i);
          for(int j=0;j<prpTitemKindAgrilist1.size();j++){
              listAgri=prpTitemKindAgrilist1.get(j);
              //茬次信息
              itemKingAgriccDto = new ItemKingAgriccDto();
              if(("3102".equals(listAgri.getRiskCode())||"3141".equals(listAgri.getRiskCode())||"3147".equals(listAgri.getRiskCode())||"3134".equals(listAgri.getRiskCode()))&&0!=listAgri.getTimes()){

                  itemKingAgriccDto.setItems(listAgri.getTimes()+"");
                  SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                  if(listAgri.getStratDate()!=null&&listAgri.getEndDate()!=null){
                      itemKingAgriccDto.setItemsDate("自"+format.format(listAgri.getStratDate())+"日起至"+format.format(listAgri.getEndDate())+"日止");
                  }
                  itemKingAgriccDto.setDistributingrate(this.doubleToStr(listAgri.getDistributingRate(),2));
              }
              if(0!=listAgri.getTimes()&&(listAgri.getItemKindNo()==listKind.getItemKindNo())){
                  itemKingAgriccDtoList.add(itemKingAgriccDto);
              }
              //主险标的信息
              if(0==listAgri.getTimes()&&listKind.getItemKindNo().equals(listAgri.getItemKindNo())&&listMain.size()<4){
                  itemKingAgriDto.setItemDetailName(listKind.getItemDetailName());
                  itemKingAgriDto.setInsureArea(listAgri.getInsureArea());
                  itemKingAgriDto.setUnitOutPut(this.doubleToStr(listAgri.getUnitOutput(),2));
                  itemKingAgriDto.setUnitCost(this.doubleToStr(listAgri.getUnitCost(),2));
                  itemKingAgriDto.setUnitAmount(this.doubleToStr(listAgri.getUnitAmount(),2));
                  itemKingAgriDto.setAmount(this.doubleToStr(listKind.getAmount(),2));
                  itemKingAgriDto.setRate(this.doubleToStr(listKind.getRate(),2));
                  itemKingAgriDto.setAdjuStrate(this.doubleToStr(listKind.getPremium(),2));
                  itemKingAgriDto.setDeductibleRate(this.doubleToStr(listKind.getDeductibleRate(),2));
                  itemKingAgriDto.setGrossQuantity(this.doubleToStr(listAgri.getGrossQuantity(),2));
                  itemKingAgriDto.setTimesAmount(this.doubleToStr(listAgri.getTimesAmount(),2));
                  itemKingAgriDto.setProportion(this.doubleToStr(listAgri.getProportion(),2));
                  if (StringUtils.isNotEmpty(StatUnitCode)){
                      PrpDcodeDto prpDcode5Dto = prpDcodeApi.queryByPK("Unit", StatUnitCode);
                      itemKingAgriDto.setUnit(prpDcode5Dto.getCodeCName());
                  }
                  itemKingAgriDtoList.add(itemKingAgriDto);
            }

          }

        }
        responseInsuranceFormPrintDto.setItemKingAgriccDto(itemKingAgriccDto);
        responseInsuranceFormPrintDto.setItemKingAgriccDtoList(itemKingAgriccDtoList);

        for(int i=0;i<listSub.size();i++){//附加险赋值
            itemKingAgriSubDto=new ItemKingAgriSubDto();
            if(listSub.size()>3){
                itemKingAgriSubDto.setSubitemDetailName("详见附加险清单");
                itemKingAgriSubDtoList.add(itemKingAgriSubDto);
              break;
          }

            listKindSub=listSub.get(i);
            for(int j=0;j<prpTitemKindAgrilist1.size();j++){
              listAgri=prpTitemKindAgrilist1.get(j);
              if(listKindSub.getItemKindNo().equals(listAgri.getItemKindNo())){
                  itemKingAgriSubDto.setSubitemDetailName(listKindSub.getItemDetailName());
                  itemKingAgriSubDto.setSubinsureArea(listAgri.getInsureArea());
                  itemKingAgriSubDto.setSubunitOutPut(this.doubleToStr(listAgri.getUnitOutput(),2));
                  itemKingAgriSubDto.setSubunitCost(this.doubleToStr(listAgri.getUnitCost(),2));
                  itemKingAgriSubDto.setSubunitAmount(this.doubleToStr(listAgri.getUnitAmount(),2));
                  itemKingAgriSubDto.setSubamount(this.doubleToStr(listKindSub.getAmount(),2));
                  itemKingAgriSubDto.setSubrate(this.doubleToStr(listKindSub.getRate(),2));
                  itemKingAgriSubDto.setSubadjuStrate(this.doubleToStr(listKindSub.getPremium(),2));
                  itemKingAgriSubDto.setSubdeductibleRate(this.doubleToStr(listKind.getDeductibleRate(),2));
                  itemKingAgriSubDto.setSubgrossQuantity(this.doubleToStr(listAgri.getGrossQuantity(),2));
                  itemKingAgriSubDto.setSubtimesAmount(this.doubleToStr(listAgri.getTimesAmount(),2));
                  if (StringUtils.isNotEmpty(StatUnitCode)){
                      PrpDcodeDto prpDcode5Dto = prpDcodeApi.queryByPK("Unit", StatUnitCode);
                      itemKingAgriSubDto.setSubunit(prpDcode5Dto.getCodeCName());
                  }
              }
          }
            itemKingAgriSubDtoList.add(itemKingAgriSubDto);
        }

        //主险保费
          double amountMain = 0;
        for(int i=0;i<listMain.size();i++){
            amountMain+= listMain.get(i).getPremium();
        }
        itemKingAgriDto.setPremium1(amountMain);
       //附加险保费
        double amountSub = 0;
        for(int i=0;i<listSub.size();i++){
            amountSub+=listSub.get(i).getPremium();
        }
        if(amountSub>0){
            itemKingAgriSubDto.setSubpremium(Double.toString(amountSub));
        }
        responseInsuranceFormPrintDto.setItemKindAgriList(itemKingAgriDtoList);
        responseInsuranceFormPrintDto.setItemKindAgriSubList(itemKingAgriSubDtoList);


        //付费日期赋值
        Double subsidySum=0.00;
        for(PrpTplan prpTplan:prpTplanList){
            SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
           if(1==prpTplan.getPayNo()){
               insuraneItemsDto.setPlanStartdate(format.format(prpTplan.getPlanStartDate()));
           }
            insuraneItemsDto.setPlanDate(format.format(prpTplan.getPlanDate()));
//           PremiumConDto premiumConDto = new PremiumConDto();
            if("RS3".equals(prpTplan.getPayReason())|| "PS3".equals(prpTplan.getPayReason())){//RS3中央财政补贴  PS3中央财政补贴批改
                subsidySum+=prpTplan.getPlanFee();
                premiumConDto.setSubSidy03Premuim(premiumConDto.getSubSidy03Premuim()!=null? premiumConDto.getSubSidy03Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
            }
            if("RS4".equals(prpTplan.getPayReason())|| "PS4".equals(prpTplan.getPayReason())){//RS4省级财政补贴  PS4省级财政补贴批改
                subsidySum+=prpTplan.getPlanFee();
                premiumConDto.setSubSidy04Premuim(premiumConDto.getSubSidy04Premuim()!=null?premiumConDto.getSubSidy04Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
            }
            if("RS5".equals(prpTplan.getPayReason())|| "PS5".equals(prpTplan.getPayReason())){//RS5地方财政补贴 PS5地方财政补贴批改
                subsidySum+=prpTplan.getPlanFee();
                premiumConDto.setSubSidy05Premuim(premiumConDto.getSubSidy05Premuim()!=null?premiumConDto.getSubSidy05Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
            }
            if("RS6".equals(prpTplan.getPayReason())|| "PS6".equals(prpTplan.getPayReason())){//RS6其他来源补贴 PS6其他来源补贴批改
                subsidySum+=prpTplan.getPlanFee();
                premiumConDto.setSubSidy06Premuim(premiumConDto.getSubSidy06Premuim()!=null?premiumConDto.getSubSidy06Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
            }
            if("RS7".equals(prpTplan.getPayReason())|| "PS7".equals(prpTplan.getPayReason())){//RS7县区财政补贴 PS7县区财政补贴
                subsidySum+=prpTplan.getPlanFee();
                premiumConDto.setSubSidy07Premuim(premiumConDto.getSubSidy07Premuim()!=null?premiumConDto.getSubSidy07Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
            }
//            if("R10".equals(prpTplan.getPayReason())|| "P10".equals(prpTplan.getPayReason())){//签单收保费
//                premiumConDto.setSubSidy10Premuim(premiumConDto.getSubSidy10Premuim()!=null?premiumConDto.getSubSidy10Premuim():this.doubleToStr(prpTplan.getPlanFee(),2));
//            }
//            list.add(premiumConDto);
        }
        //农户自缴保费
        Double z=prpTmain.getSumPremium()-subsidySum;
        premiumConDto.setSubSidy10Premuim(this.doubleToStr(z,2));
        responseInsuranceFormPrintDto.setPremiumConDto(premiumConDto);

        //特约内容赋值
        String ClauseCode;
        List<PrpTengage> prpTengages = new ArrayList<>();
        for(int i=0;i<prpTengageList.size();i++){
            PrpTengage prpTengage=new PrpTengage();
            prpTengage = prpTengageList.get(i);
            prpTengages.add(prpTengage);
            ClauseCode=prpTengage.getClauseCode();
            if(ClauseCode!=null&&ClauseCode.trim().substring(0,1).equals("T")&&!(ClauseCode.trim().substring(0,2).equals("TX"))&&prpTengage.getLineNo()!=1){
                insuraneItemsDto.setClauses((insuraneItemsDto.getClauses()==null?"":insuraneItemsDto.getClauses())+prpTengage.getClauses());
            }
        }

        //绝对免赔率赋值
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String result="";
        for(int i=0;i<prpTengageList.size();i++){
            PrpTengage prpTengage=new PrpTengage();
            prpTengage = prpTengageList.get(i);
            if(prpTengage.getClauseCode()!=null&&prpTengage.getClauseCode().startsWith("TX001")&&"1".equals(prpTengage.getTitleFlag())){
                result =prpTengage.getClauses();

            }
        }
        //免赔说明
        String deduText = "";
        for (int i = 0; i < prpTengageList.size(); i++) {
            PrpTengage prpTengage=new PrpTengage();
            prpTengage = prpTengageList.get(i);
            if (prpTengage.getClauseCode() != null && prpTengage.getClauseCode().startsWith("TX004") && "1".equals(prpTengage.getTitleFlag())) {
                deduText = prpTengage.getClauses();
            }
        }
        result =  decimalFormat.format(Double.parseDouble(Str.chgStrZero(result)));
        insuraneItemsDto.setDeductible(result);
        insuraneItemsDto.setDeduText(deduText);
        responseInsuranceFormPrintDto.setInsuraneItemDto(insuraneItemsDto);
        return responseInsuranceFormPrintDto;


    }
    private String doubleToStr(Double val, int i) {
        String patten="#,##0.0";
        for (int a=1;a<i;a++) {
            patten += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(patten);
        val = val == null ? 0.0 : val;
        String strVal = decimalFormat.format(val);
        return strVal;
    }


    /**
     * @description:打印流水号回写
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    @Modifying(clearAutomatically = true)
    public void upDatePrintNo(String proposalNo, String printNo) throws Exception {
        if(StringUtils.isEmpty(proposalNo)){
            throw new DataVerifyException("投保单号不能为空");
        }
        StringBuilder Sql = new StringBuilder("UPDATE  PrpTmain t SET");
        if(printNo!=null){
            Sql.append(" t.printNo='").append(printNo).append("'");
        }
        Sql.append(" WHERE t.proposalNo='").append(proposalNo).append("'");
        System.out.print(Sql);
        Query dataQuery = entityManager.createQuery(Sql.toString());
        int i = dataQuery.executeUpdate();

    }
}