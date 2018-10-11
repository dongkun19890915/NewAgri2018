package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.core.TransformationUtil.TransformTToC;
import com.sinosoft.agriprpall.core.policymanage.dao.*;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.policymanage.service.ProposalToPolicyService;
import com.sinosoft.agriprpall.core.proposalmanage.dao.*;
import com.sinosoft.agriprpall.core.proposalmanage.dao.specification.ProposalToPolicySpecBuilder;
import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.service.GroupProposalService;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsuranceListApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProposalToPolicyServiceImpl extends BaseServiceImpl implements ProposalToPolicyService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalToPolicyServiceImpl.class);
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpTrenewalDao prpTrenewalDao;
    @Autowired
    private PrpCrenewalDao prpCrenewalDao;
    @Autowired
    private PrpTaddressDao prpTaddressDao;
    @Autowired
    private PrpCaddressDao prpCaddressDao;
    @Autowired
    private PrpTitemKindDao prpTitemKindDao;
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private PrpTinsuredDao prpTinsuredDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Autowired
    private PrpTplanDao prpTplanDao;
    @Autowired
    private PrpCplanDao prpCplanDao;
    @Autowired
    private PrpTplanCoinsDao prpTplanCoinsDao;
    @Autowired
    private PrpCplanCoinsDao prpCplanCoinsDao;
    @Autowired
    private PrpTfeeDao prpTfeeDao;
    @Autowired
    private PrpCfeeDao prpCfeeDao;
    @Autowired
    private PrpTengageDao prpTengageDao;
    @Autowired
    private PrpCengageDao prpCengageDao;
    @Autowired
    private PrpTcoinsDao prpTcoinsDao;
    @Autowired
    private PrpCcoinsDao prpCcoinsDao;
    @Autowired
    private PrpTcoinsDetailDao prpTcoinsDetailDao;
    @Autowired
    private PrpCcoinsDetailDao prpCcoinsDetailDao;
    @Autowired
    private PrpTmainAgriDao prpTmainAgriDao;
    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;
    @Autowired
    private PrpTmainLoanDao prpTmainLoanDao;
    @Autowired
    private PrpCmainLoanDao prpCmainLoanDao;
    @Autowired
    private PrpTitemKindAgriDao prpTitemKindAgriDao;
    @Autowired
    private PrpCitemKindAgriDao prpCitemKindAgriDao;
    @Autowired
    private PrpTfeildDao prpTfeildDao;
    @Autowired
    private PrpCfeildDao prpCfeildDao;
    @Autowired
    private PrpTsubsidyDao prpTsubsidyDao;
    @Autowired
    private PrpCsubsidyDao prpCsubsidyDao;
    @Autowired
    private PrpTexpenseDao prpTexpenseDao;
    @Autowired
    private PrpCexpenseDao prpCexpenseDao;
    @Autowired
    private PrpCmainOriginDao prpCmainOriginDao;
    @Autowired
    private PrpCitemKindOriginDao prpCitemKindOriginDao;
    @Autowired
    private PrpCfeeOriginDao prpCfeeOriginDao;
    @Autowired
    private PrpCexpenseOriginDao prpCexpenseOriginDao;
    @Autowired
    private PrpCcoinsOriginDao prpCcoinsOriginDao;
    @Autowired
    private PrpCcoinsDetailOriginDao prpCcoinsDetailOriginDao;
    @Autowired
    private PrpCvirturlItemDao prpCvirturlItemDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private InsuranceListApi insuranceListApi;
    @Autowired
    private UtiPlatConfigRuleApi sysConfig;
    @Autowired
    private GroupProposalService groupProposalService;
    /**
     * 转保单(通过投保单号查询投保单相关表,然后将投保单相关表的数据转储到保单相关表)
     * @author: 宋振振
     * @date: 2017/10/26 17:53
     * @param iProposalNo 投保单号
     * @param  userCode 员工代码
     * @return policyNo 保单号
     * @throws Exception
     */
    @Transactional
    public String proposalToPolicy(String iProposalNo,String userCode)throws Exception{
        //校验入参
        if(StringUtils.isEmpty(iProposalNo)){
            throw new DataVerifyException("投保单号入参不能为空！");
        }
        if(StringUtils.isEmpty(userCode)){
            throw new DataVerifyException("投保单号入参不能为空！");
        }
        String strPolicyNo="";
        String strOldPolicyNo="";
        String strOthFlag ="";
        String strRiskCode ="";

        PrpTmain prpTmain=prpTmainDao.findOne(new PrpTmainKey(iProposalNo));
        if(prpTmain==null){
            throw new Exception("根据投保单" + iProposalNo + "没有查到PrpTmain表的数据!");
        }
        strRiskCode=prpTmain.getRiskCode();
        String intYear = new Date().getYear()+"";//new Date().get(Date.YEAR);
        BillNoDto billNoDto=new BillNoDto();
        //校验保单号类型
        if(StringUtils.isNotEmpty(prpTmain.getManualType())&&StringUtils.isNotEmpty(prpTmain.getPolicyNo())){//ManualType是保单号类型
            strPolicyNo=prpTmain.getPolicyNo();
        }else {
            //调整单号生成规则，根据配置信息生成单号，按出单部门或者归属部门
            // 调用平台交互获取String strType = sysConfig.getProperty("BILLNO_POLICY_RULE");
            String strType=sysConfig.getProperty("BILLNO_POLICY_RULE");
            if(strType!=null&&"ComCode".equals(strType)){//按出单部门或者归属部门
                // 调用dms生成保单号,传参sysConfig.getProperty("POLICY_TABLE"),PrpTmain.getRiskCode(),PrpTmain.getComCode(),intYear
                billNoDto.setTableName(sysConfig.getProperty("POLICY_TABLE"));
                billNoDto.setRiskCode(prpTmain.getRiskCode());
                billNoDto.setiComCode(prpTmain.getComCode());
                billNoDto.setiYear(intYear);
                billNoDto.setUserCode(userCode);
                Map<String,String> map=billNoApi.getBillNo(billNoDto);
                strPolicyNo=map.get("billNo");
            }else{
                // 调用dms生成保单号,传参SysConfig.getProperty("POLICY_TABLE"),PrpTmain.getRiskCode(),PrpTmain.getMakeCom(),intYear
                billNoDto.setTableName(sysConfig.getProperty("POLICY_TABLE"));
                billNoDto.setRiskCode(prpTmain.getRiskCode());
                billNoDto.setiComCode(prpTmain.getMakeCom());
                billNoDto.setiYear(intYear);
                billNoDto.setUserCode(userCode);
                Map<String,String> map=billNoApi.getBillNo(billNoDto);
                strPolicyNo=map.get("billNo");
            }
        }

        //核保通过页面刷新时不能重复生成保单的控制
        List<PrpCmain> prpCmainList=prpCmainDao.findPrpCmainByProposalNo(iProposalNo);
        if(prpCmainList.size()>0){
            throw new Exception("投保单" + iProposalNo + "已经生成保单!");
        }
        if (strPolicyNo.length() == 0) {
            throw new Exception(prpTmain.getMakeCom().trim() + " 编组的单号没有初始化!");
        }

        //转保单
        //reason：被续保的保单在续保的投保单核保之后应该置标志位
        PrpTrenewal prpTrenewal= prpTrenewalDao.findOne(new PrpTrenewalKey(iProposalNo));
        if(prpTrenewal!=null){
            strOldPolicyNo=prpTrenewal.getOldPolicyNo();
            PrpCmain prpCmain=prpCmainDao.findOne(new PrpCmainKey(strOldPolicyNo));
            strOthFlag=prpCmain.getOthFlag();
            strOthFlag=strOthFlag.substring(0, 1) + "1" + strOthFlag.substring(2, strOthFlag.length());
            prpCmain.setOthFlag(strOthFlag);
            prpCmainDao.save(prpCmain);

            //reason：在被续保的T保单通过核保生成续保保单，应该在续保信息表PrpCrenewal里面也设置关联
            PrpCrenewal prpCrenewal=TransformTToC.setPrpTrenewalToPrpCrenewal(prpTrenewal);
            prpCrenewal.setPolicyNo(strPolicyNo);
            prpCrenewalDao.save(prpCrenewal);
        }

        //投保单信息主表转保单信息主表
        PrpCmain prpCmain=TransformTToC.setPrpTmainToPrpCmain(prpTmain);
        prpCmain.setPolicyNo(strPolicyNo);
        prpCmainDao.save(prpCmain);

        //保险地址表
        List<PrpTaddress> prpTaddressList=prpTaddressDao.findAll(ProposalToPolicySpecBuilder.prpTaddressByProposalNoSpecification(iProposalNo));
        List<PrpCaddress> prpCaddressList=new ArrayList<PrpCaddress>();
        PrpCaddress prpCaddress=null;
        for(PrpTaddress prpTaddress:prpTaddressList){
            prpCaddress=TransformTToC.setPrpTaddressToPrpCaddress(prpTaddress);
            prpCaddress.setPolicyNo(strPolicyNo);
            prpCaddressList.add(prpCaddress);
        }
        prpCaddressDao.save(prpCaddressList);

        //标的子险信息
        List<PrpTitemKind> prpTitemKindList=prpTitemKindDao.findAll(ProposalToPolicySpecBuilder.prpTitemKindByProposalNoSpecification(iProposalNo));
        List<PrpCitemKind> prpCitemKindList=new ArrayList<PrpCitemKind>();
        PrpCitemKind prpCitemKind=null;
        for(PrpTitemKind prpTitemKind:prpTitemKindList){
            prpCitemKind=TransformTToC.setPrpTitemKindToPrpCitemKind(prpTitemKind);
            prpCitemKind.setPolicyNo(strPolicyNo);
            prpCitemKindList.add(prpCitemKind);
        }
        prpCitemKindDao.save(prpCitemKindList);

        //保险关系人表
        List<PrpTinsured> prpTinsuredList=prpTinsuredDao.findAll(ProposalToPolicySpecBuilder.prpTinsuredByProposalNoSpecification(iProposalNo));
        List<PrpCinsured> prpCinsuredList=new ArrayList<PrpCinsured>();
        PrpCinsured prpCinsured=null;
        for(PrpTinsured prpTinsured:prpTinsuredList){
            prpCinsured=TransformTToC.setPrpTinsuredToPrpCinsured(prpTinsured);
            prpCinsured.setPolicyNo(strPolicyNo);
            prpCinsuredList.add(prpCinsured);
        }
        prpCinsuredDao.save(prpCinsuredList);

        //收费计划表
        List<PrpTplan> prpTplanList=prpTplanDao.findAll(ProposalToPolicySpecBuilder.prpTplanByProposalNoSpecification(iProposalNo));
        List<PrpCplan> prpCplanList=new ArrayList<PrpCplan>();
        PrpCplan prpCplan=null;
        for(PrpTplan prpTplan:prpTplanList){
            prpCplan=TransformTToC.setPrpTplanToPrpCplan(prpTplan);
            prpCplan.setPolicyNo(strPolicyNo);
            prpCplanList.add(prpCplan);
        }
        prpCplanDao.save(prpCplanList);

        //共保方收费计划表
        List<PrpTplanCoins> prpTplanCoinsList=prpTplanCoinsDao.findAll(ProposalToPolicySpecBuilder.prpTplanCoinsByProposalNoSpecification(iProposalNo));
        List<PrpCplanCoins> prpCplanCoinsList=new ArrayList<PrpCplanCoins>();
        PrpCplanCoins prpCplanCoins=null;
        for(PrpTplanCoins prpTplanCoins:prpTplanCoinsList){
            prpCplanCoins=TransformTToC.setPrpCplanCoinsToPrpCplanCoins(prpTplanCoins);
            prpCplanCoins.setPolicyNo(strPolicyNo);
            prpCplanCoinsList.add(prpCplanCoins);
        }
        prpCplanCoinsDao.save(prpCplanCoinsList);

        //保单保额保费表
        List<PrpTfee> prpTfeeList=prpTfeeDao.findAll(ProposalToPolicySpecBuilder.prpTfeeByProposalNoSpecification(iProposalNo));
        List<PrpCfee> prpCfeeList=new ArrayList<PrpCfee>();
        PrpCfee prpCfee=null;
        for(PrpTfee prpTfee:prpTfeeList){
            prpCfee=TransformTToC.setPrpTfeeToPrpCfee(prpTfee);
            prpCfee.setPolicyNo(strPolicyNo);
            prpCfeeList.add(prpCfee);
        }
        prpCfeeDao.save(prpCfeeList);

        //特别约定表
        List<PrpTengage> prpTengageList=prpTengageDao.findAll(ProposalToPolicySpecBuilder.prpTengageByProposalNoSpecification(iProposalNo));
        PrpCengage prpCengage=null;
        List<PrpCengage> prpCengageList=new ArrayList<PrpCengage>();
        for(PrpTengage prpTengage:prpTengageList){
            prpCengage=TransformTToC.setPrpTengageTOPrpCengage(prpTengage);
            prpCengage.setPolicyNo(strPolicyNo);
            prpCengageList.add(prpCengage);
        }
        prpCengageDao.save(prpCengageList);

        //共保信息表
        List<PrpTcoins> prpTcoinsList=prpTcoinsDao.findAll(ProposalToPolicySpecBuilder.prpTcoinsByProposalNoSpecification(iProposalNo));
        List<PrpCcoins> prpCcoinsList=new ArrayList<PrpCcoins>();
        PrpCcoins prpCcoins=null;
        for(PrpTcoins prpTcoins:prpTcoinsList){
            prpCcoins=TransformTToC.setPrpTcoinsToPrpCcoins(prpTcoins);
            prpCcoins.setPolicyNo(strPolicyNo);
            prpCcoinsList.add(prpCcoins);
        }
        prpCcoinsDao.save(prpCcoinsList);

        //共保信息明细表
        List<PrpTcoinsDetail> prpTcoinsDetailList=prpTcoinsDetailDao.findAll(ProposalToPolicySpecBuilder.prpTcoinsDetailByProposalNoSpecification(iProposalNo));
        List<PrpCcoinsDetail> prpCcoinsDetailList=new ArrayList<PrpCcoinsDetail>();
        PrpCcoinsDetail prpCcoinsDetail=null;
        for(PrpTcoinsDetail prpTcoinsDetail:prpTcoinsDetailList){
            prpCcoinsDetail=TransformTToC.setPrpTcoinsDetailToPrpCcoinsDetail(prpTcoinsDetail);
            prpCcoinsDetail.setPolicyNo(strPolicyNo);
            prpCcoinsDetailList.add(prpCcoinsDetail);
        }
        prpCcoinsDetailDao.save(prpCcoinsDetailList);

        //农业险投保单信息表
        List<PrpTmainAgri> prpTmainAgriList=prpTmainAgriDao.findAll(ProposalToPolicySpecBuilder.prpTmainAgriByProposalNoSpecification(iProposalNo));
        List<PrpCmainAgri> prpCmainAgriList=new ArrayList<PrpCmainAgri>();
        PrpCmainAgri prpCmainAgri=null;
        for(PrpTmainAgri prpTmainAgri:prpTmainAgriList){
            prpCmainAgri=TransformTToC.setPrpTmainAgriToPrpCmainAgri(prpTmainAgri);
            prpCmainAgri.setPolicyNo(strPolicyNo);
            prpCmainAgriList.add(prpCmainAgri);
        }
        prpCmainAgriDao.save(prpCmainAgriList);

        //贷款保险保单信息
        List<PrpTmainLoan> prpTmainLoanList=prpTmainLoanDao.findAll(ProposalToPolicySpecBuilder.prpTmainLoanByProposalNoSpecification(iProposalNo));
        List<PrpCmainLoan> prpCmainLoanList=new ArrayList<PrpCmainLoan>();
        PrpCmainLoan prpCmainLoan=null;
        for(PrpTmainLoan prpTmainLoan:prpTmainLoanList){
            prpCmainLoan=TransformTToC.setPrpTmainLoanToPrpCmainLoan(prpTmainLoan);
            prpCmainLoan.setPolicyNo(strPolicyNo);
            prpCmainLoanList.add(prpCmainLoan);
        }
        prpCmainLoanDao.save(prpCmainLoanList);

        //农险标的信息表
        List<PrpTitemKindAgri> prpTitemKindAgris=prpTitemKindAgriDao.findAll(ProposalToPolicySpecBuilder.prpTitemKindAgriByProposalNoSpecification(iProposalNo));
        List<PrpCitemKindAgri> prpCitemKindAgriList=new ArrayList<PrpCitemKindAgri>();
        PrpCitemKindAgri prpCitemKindAgri=null;
        for(PrpTitemKindAgri prpTitemKindAgri:prpTitemKindAgris){
            prpCitemKindAgri=TransformTToC.setPrpTitemKindAgriToPrpCitemKindAgri(prpTitemKindAgri);
            prpCitemKindAgri.setPolicyNo(strPolicyNo);
            prpCitemKindAgriList.add(prpCitemKindAgri);
        }
        prpCitemKindAgriDao.save(prpCitemKindAgriList);

        //大户田块信息
        List<PrpTfeild> prpTfeildList=prpTfeildDao.findAll(ProposalToPolicySpecBuilder.prpTfeildByProposalNoSpecification(iProposalNo));
        List<PrpCfeild> prpCfeildList=new ArrayList<PrpCfeild>();
        PrpCfeild prpCfeild=null;
        for(PrpTfeild prpTfeild:prpTfeildList){
            prpCfeild=TransformTToC.setPrpTfeildToPrpCfeild(prpTfeild);
            prpCfeild.setPolicyNo(strPolicyNo);
            prpCfeildList.add(prpCfeild);
        }
        prpCfeildDao.save(prpCfeildList);

        //补贴表
        List<PrpTsubsidy> prpTsubsidyList=prpTsubsidyDao.findAll(ProposalToPolicySpecBuilder.prpTsubsidyByProposalNoSpecification(iProposalNo));
        List<PrpCsubsidy> prpCsubsidyList=new ArrayList<PrpCsubsidy>();
        PrpCsubsidy prpCsubsidy=null;
        for(PrpTsubsidy prpTsubsidy:prpTsubsidyList){
            prpCsubsidy=TransformTToC.setPrpTsubsidyToPrpCsubsidy(prpTsubsidy);
            prpCsubsidy.setPolicyNo(strPolicyNo);
            prpCsubsidyList.add(prpCsubsidy);
        }
        prpCsubsidyDao.save(prpCsubsidyList);

        //税表
        List<PrpTexpense> prpTexpenseList=prpTexpenseDao.findAll(ProposalToPolicySpecBuilder.prpTexpenseByProposalNoSpecification(iProposalNo));
        List<PrpCexpense> PrpCexpenseList=new ArrayList<PrpCexpense>();
        PrpCexpense prpCexpense=null;
        for(PrpTexpense prpTexpense:prpTexpenseList){
            prpCexpense=TransformTToC.setPrpTexpenseToPrpCexpense(prpTexpense);
            prpCexpense.setPolicyNo(strPolicyNo);
            PrpCexpenseList.add(prpCexpense);
        }
        prpCexpenseDao.save(PrpCexpenseList);

        //回写保单号到清单主表
        if(("3141".equals(strRiskCode)) || ("3147".equals(strRiskCode))){
            int prpTmainAgriIndex = 0;
            for(prpTmainAgriIndex=0;prpTmainAgriIndex<prpTmainAgriList.size();prpTmainAgriIndex++){
                PrpTmainAgri prpTmainAgri=prpTmainAgriList.get(prpTmainAgriIndex);
                // 调用清单系统，传inusreListCode查询InsureMainList集合
                //入参不能为null
                InsureMainListDto insureMainListDto=insureMainListApi.queryByPK(prpTmainAgri.getRelationListNo());
                if(insureMainListDto!=null){
                    insureMainListDto.setPolicyNo(strPolicyNo);
                    insureMainListDto.setValidity("2");// 更改标志位为 2：正常
                    // 调用清单系统，传inusreListCode更新清单主表insureMainList
                    insureMainListApi.modify(insureMainListDto);

                    //调用清单系统Planting31InsuranceList转到Planting31PolicyList和Planting31PolicyListOrigin表
                    insuranceListApi.save31PlantingToPlanting(insureMainListDto.getInusreListCode());

                }
            }
        }
        if("3224".equals(strRiskCode) ){
            int prpTmainAgriIndex = 0;
            for(prpTmainAgriIndex=0;prpTmainAgriIndex<prpTmainAgriList.size();prpTmainAgriIndex++) {
                PrpTmainAgri prpTmainAgri = prpTmainAgriList.get(prpTmainAgriIndex);
                // 传投保清单编号调用清单系统
                //入参不能为null
                InsureMainListDto insureMainListDto=insureMainListApi.queryByPK(prpTmainAgri.getRelationListNo());
                if(insureMainListDto!=null) {
                    insureMainListDto.setPolicyNo(strPolicyNo);
                    insureMainListDto.setValidity("2");// 更改标志位为 2：正常
                    // 调用清单系统，传inusreListCode更新清单主表insureMainList
                    insureMainListApi.modify(insureMainListDto);
                    // 调用清单系统NyxInsuranceList转到NyxPolicyList和NyxPolicyListOrigin
                    insuranceListApi.saveNyxInsuranceToPolicy(insureMainListDto.getInusreListCode());
                }
            }
        }

        // 农险平台二期改造:所有31和32的险种都加清单;这里都回写清单主表的保单号
        // 调用平台交互获取plantingbreedingFarmerListSingleFlag与plantingbreedingFarmerListMultiFlag
        //String plantingbreedingFarmerListSingleFlag = SysConfig.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");
        //String plantingbreedingFarmerListMultiFlag = SysConfig.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");
        String plantingbreedingFarmerListSingleFlag =sysConfig.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");
        String plantingbreedingFarmerListMultiFlag =sysConfig.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");
        if(plantingbreedingFarmerListSingleFlag.contains(strRiskCode)
                || plantingbreedingFarmerListMultiFlag.contains(strRiskCode)){
            int prpTmainAgriIndex = 0;
            for(prpTmainAgriIndex=0;prpTmainAgriIndex<prpTmainAgriList.size();prpTmainAgriIndex++){
                PrpTmainAgri prpTmainAgri=prpTmainAgriList.get(prpTmainAgriIndex);
                InsureMainListDto insureMainListDto=null;
                if(prpTmainAgri.getRelationListNo()!=null){
                    insureMainListDto=insureMainListApi.queryByPK(prpTmainAgri.getRelationListNo());
                }
                if(insureMainListDto!=null){
                    insureMainListDto.setPolicyNo(strPolicyNo);
                    insureMainListDto.setValidity("2");// 更改标志位为 2：正常
                    insureMainListApi.modify(insureMainListDto);

                    // 调用清单系统NyxInsuranceList转为NyxPolicyList和NyxPolicyListOrigin
                    insuranceListApi.saveNyxInsuranceToPolicy(insureMainListDto.getInusreListCode());
                }
            }
        }

        //保存成功后，增加电子档案 T02 复制数据 到 C01
        // 调用平台交互获取plantingbreedingFarmerListSingleFlag与plantingbreedingFarmerListMultiFlag
        //String breedingFarmerListFlag = SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
        //String plantingFarmerListFlag = SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG");
        String breedingFarmerListFlag =sysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
        String plantingFarmerListFlag =sysConfig.getProperty("PLNATING_FARMER_LIST_FLAG");
        if((null!=breedingFarmerListFlag && breedingFarmerListFlag.indexOf(strRiskCode)>-1) || (null!=plantingFarmerListFlag && plantingFarmerListFlag.indexOf(strRiskCode)>-1)){
            for(int prpTmainAgriIndex=0;prpTmainAgriIndex<prpTmainAgriList.size();prpTmainAgriIndex++){
                PrpTmainAgri prpTmainAgri=prpTmainAgriList.get(prpTmainAgriIndex);
                InsureMainListDto insureMainListDto=null;
                InsureMainListDto insureMainListDto1=null;
                //判断入参不能为null
                if(StringUtils.isNotEmpty(prpTmainAgri.getRelationListNo())){
                    insureMainListDto=insureMainListApi.queryByPK(prpTmainAgri.getRelationListNo());
                }
                if(StringUtils.isNotEmpty(prpTmainAgri.getCirculationCode())){
                    insureMainListDto1=insureMainListApi.queryByPK(prpTmainAgri.getCirculationCode());
                }
                if(insureMainListDto!=null){
                    String riskCode =insureMainListDto.getRiskCode();

                    //这句判断为了养殖险上线时屏蔽掉种植险改造
                    if((null!= breedingFarmerListFlag && breedingFarmerListFlag.indexOf(riskCode)>-1)|| (null!=plantingFarmerListFlag && plantingFarmerListFlag.indexOf(strRiskCode)>-1)){
                        insureMainListDto.setPolicyNo(strPolicyNo);
                        insureMainListDto.setValidity("2");// 更改标志位为 2：正常
                        insureMainListApi.modify(insureMainListDto);

                        if(insureMainListDto1!=null){
                            insureMainListDto1.setPolicyNo(strPolicyNo);
                            insureMainListDto1.setValidity("2");// 更改标志位为 2：正常
                            insureMainListApi.modify(insureMainListDto1);
                        }
                        if(null!= plantingFarmerListFlag && plantingFarmerListFlag.indexOf(riskCode)>-1){//种植险
                            //为了养殖险上线，暂时屏蔽种植险部分
                            // 调用清单系统，PlantingInsuranceList转到PlantingPolicyList和Plantingpolicylistorigin
                            insuranceListApi.saveInsuranceToPolicy(insureMainListDto.getInusreListCode());
                            //土地流转清单
                            if(insureMainListDto1!=null){
                                // 调用清单系统，PlantingTCirculationList转到PlantingCCirculationList和PlantingCCirculationListOrigin
                                insuranceListApi.saveTCirculationToC(insureMainListDto1.getInusreListCode());
                            }
                        }else {//养殖险
                            // 调用清单系统,herdinsurancelist转到herdPolicyList和herdPolicyListOrigin
                            insuranceListApi.saveHerdinsuranceToPolicy(prpTmainAgri.getRelationListNo());
                        }
                    }
                }
            }
        }
        //转原始保单
        PrpCmainOrigin prpCmainOrigin=TransformTToC.setPrpTmainToPrpCmainOrigin(prpTmain,strPolicyNo);
        prpCmainOriginDao.save(prpCmainOrigin);

        //原始标的子险信息
        List<PrpCitemKindOrigin> prpCitemKindOriginList=new ArrayList<PrpCitemKindOrigin>();
        PrpCitemKindOrigin prpCitemKindOrigin=null;
        for(PrpTitemKind prpTitemKind:prpTitemKindList){
            prpCitemKindOrigin=TransformTToC.setPrpTitemKindToPrpCitemKindOrigin(prpTitemKind,strPolicyNo);
            prpCitemKindOriginList.add(prpCitemKindOrigin);
        }
        prpCitemKindOriginDao.save(prpCitemKindOriginList);

        //原始保单保额保费表
        List<PrpCfeeOrigin> prpCfeeOriginList=new ArrayList<PrpCfeeOrigin>();
        PrpCfeeOrigin prpCfeeOrigin=null;
        for(PrpTfee prpTfee:prpTfeeList){
            prpCfeeOrigin=TransformTToC.setPrpTfeeToPrpCfeeOrigin(prpTfee,strPolicyNo);
            prpCfeeOriginList.add(prpCfeeOrigin);
        }
        prpCfeeOriginDao.save(prpCfeeOriginList);

        //原始共保信息表
        List<PrpCcoinsOrigin> prpCcoinsOriginList=new ArrayList<PrpCcoinsOrigin>();
        PrpCcoinsOrigin prpCcoinsOrigin=null;
        for(PrpTcoins prpTcoins:prpTcoinsList){
            prpCcoinsOrigin=TransformTToC.setPrpTcoinsToPrpCcoinsOrigin(prpTcoins,strPolicyNo);
            prpCcoinsOriginList.add(prpCcoinsOrigin);
        }
        prpCcoinsOriginDao.save(prpCcoinsOriginList);

        //原始共保信息明细表
        List<PrpCcoinsDetailOrigin> prpCcoinsDetailOriginList=new ArrayList<PrpCcoinsDetailOrigin>();
        PrpCcoinsDetailOrigin prpCcoinsDetailOrigin=null;
        for(PrpTcoinsDetail prpTcoinsDetail:prpTcoinsDetailList){
            prpCcoinsDetailOrigin=TransformTToC.setPrpTcoinsDetailToPrpCcoinsDetailOrigin(prpTcoinsDetail,strPolicyNo);
            prpCcoinsDetailOriginList.add(prpCcoinsDetailOrigin);
        }
        prpCcoinsDetailOriginDao.save(prpCcoinsDetailOriginList);

        //原始税表
        List<PrpCexpenseOrigin> prpCexpenseOriginList=new ArrayList<PrpCexpenseOrigin>();
        PrpCexpenseOrigin prpCexpenseOrigin=null;
        for(PrpTexpense prpTexpense:prpTexpenseList){
            prpCexpenseOrigin=TransformTToC.setPrpTexpenseToPrpCexpenseOrigin(prpTexpense,strPolicyNo);
            prpCexpenseOriginList.add(prpCexpenseOrigin);
        }
        prpCexpenseOriginDao.save(prpCexpenseOriginList);
        prpCexpenseOriginDao.flush();//一定要放在save方法的后面

        // 用友接口国元暂时不用

        //核保通过后判断是否是虚拟分户险种，是的话就存储虚拟分户数据
          if(groupProposalService.isGroupProposal(strRiskCode)){
             prpCvirturlItemDao.updateVirtualItem(strPolicyNo,iProposalNo);
         }

        //删除单号
        String strGroupNo="";
        String strMaxUse="";
        String[] strPickNo = new String[3];
        // 保存成功后删除获取的单号,调用dms的单号检查方法pickNo("prpcmain",strPolicyNo)
        strPickNo=billNoApi.pickNo("prpcmain",strPolicyNo);
        strGroupNo = strPickNo[1];
        strMaxUse = strPickNo[2];
        // 调用dms的删除单号方法
        //删除prpmaxuse中的最大号记录
        billNoApi.deleteNo(strGroupNo,"prpcmain",strMaxUse);

        return strPolicyNo;
    }
}

