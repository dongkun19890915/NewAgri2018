package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.RequestQueryVisaCodeDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryVisaCodeDto;
import com.sinosoft.agriprpall.api.policymanage.VisaApi;
import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.proposalmanage.dao.*;
import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.service.GroupProposalService;
import com.sinosoft.agriprpall.core.proposalmanage.service.LeviedFeeService;
import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalSaveService;
import com.sinosoft.agriprpall.core.proposalmanage.service.UpdateCustomerInfoService;
import com.sinosoft.agriprpall.core.proposalmanage.util.ProposalCheck;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.customer.*;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.api.dict.PrpDprovinceConfigApi;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.framework.agri.core.constant.EditTypeConstant;
import com.sinosoft.framework.agri.core.gycore.BankInfo;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.txnlist.api.gisinsurelist.GisInsureListApi;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 投保单保存Impl
 *
 * @Author: 何伟东
 * @Date: 2017/10/26 14:53
 */
@Service
public class ProposalSaveServiceImpl extends BaseServiceImpl implements ProposalSaveService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalSaveServiceImpl.class);
    //    /**
//     * 见费出单险种
//     */
//    @Value("${sysconfig.common.IS_SEE_FEE_RISK}")
//    private String IS_SEE_FEE_RISK;
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpTrenewalDao prpTrenewalDao;
    @Autowired
    private PrpTinsuredDao prpTinsuredDao;
    @Autowired
    private PrpTaddressDao prpTaddressDao;
    @Autowired
    private PrpTcoinsDao prpTcoinsDao;
    @Autowired
    private PrpTcoinsDetailDao prpTcoinsDetailDao;
    @Autowired
    private PrpTplanCoinsDao prpTplanCoinsDao;
    @Autowired
    private PrpTengageDao prpTengageDao;
    @Autowired
    private PrpTexpenseDao prpTexpenseDao;
    @Autowired
    private PrpTfeeDao prpTfeeDao;
    @Autowired
    private PrpTfeildDao prpTfeildDao;
    @Autowired
    private PrpTitemKindDao prpTitemKindDao;
    @Autowired
    private PrpTitemKindAgriDao prpTitemKindAgriDao;
    @Autowired
    private PrpTmainAgriDao prpTmainAgriDao;
    @Autowired
    private PrpTmainLoanDao prpTmainLoanDao;
    @Autowired
    private PrpTplanDao prpTplanDao;
    @Autowired
    private PrpTsubsidyDao prpTsubsidyDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDprovinceConfigApi prpDprovinceConfigApi;
    @Autowired
    private UtiPlatConfigRuleApi sysConfig;
    @Autowired
    private LeviedFeeService leviedFeeService;
    @Autowired
    private GroupProposalService groupProposalService;
    @Autowired
    private PrpDcustomerIdvApi prpDcustomerIdvApi;
    @Autowired
    private PrpDcustomerUnitApi prpDcustomerUnitApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;
    @Autowired
    private PrpDcustomerApi prpDcustomerApi;
    @Autowired
    private ProposalCheck proposalCheck;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private VisaApi visaApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private ProcessApi processApi;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcustomLevelTraceApi prpDcustomLevelTraceApiInsured;
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;//新农险标识（mian表中的systemflag,用于区分新农险系统与老系统的数据）

    @Autowired
    private UpdateCustomerInfoService updateCustomerInfoService;
    @Autowired
    private GisInsureListApi gisInsureListApi;

    /**
     * 暂存状态
     */
    private final String TEMPORARY_SAVE = "0";
    /**
     * 保存状态
     */
    private final String SAVE = "1";
    /**
     * 修改状态
     */
    private final String MODIFY = "2";



    /**
     * 投保单保存方法
     *
     * @param proposalSaveDto 投保单大对象
     * @return 投保单单号
     * @throws Exception
     * @author: 何伟东
     * @date: 2017/10/26 14:48
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String save(ProposalSaveDto proposalSaveDto) throws Exception {
        if (proposalSaveDto == null) {
            throw new DataVerifyException("投保单数据不能为空！");
        }
        if (StringUtils.isEmpty(proposalSaveDto.getEditType())) {
            throw new DataVerifyException("投保保存类型不能为空！");
        }
        PrpTmainDto prpTmainDto = proposalSaveDto.getPrpTmainDto();
        if (prpTmainDto == null) {
            throw new DataVerifyException("投保单主信息数据不能为空！");
        }
        String proposalNo = prpTmainDto.getProposalNo();
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号码不能为空！");
        }
        String riskCode = proposalSaveDto.getPrpTmainDto().getRiskCode();
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        //GetRuleInUtiPlatConfigRuleService sysConfig= new GetRuleInUtiPlatConfigRuleServiceImpl();
        String comCodeForTemp = prpTmainDto.getComCode();
        //开头为5个0 的机构
        if (comCodeForTemp.startsWith("00000")) {
            comCodeForTemp = "0000000000";
        }
        // 政策性标志
        String ZCFlag = "";
        // 根据comCodeForTemp到PrpDcompany省级机构代码
        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryProvinceComByComCode(comCodeForTemp);
        if (prpDcompanyDto != null) {
            // 查询省级机构配置信息
            PrpDprovinceConfigDto prpDprovinceConfigAgriDto = prpDprovinceConfigApi.queryByPK(prpDcompanyDto.getComCode(), riskCode);
            if (prpDprovinceConfigAgriDto != null) {
                ZCFlag = prpDprovinceConfigAgriDto.getBisinessType1();
            }
        }
        String editType = proposalSaveDto.getEditType();
        String saveFlag = "";// I 新保；R 续保
        // 新保
        if (sysConfig.getProperty(EditTypeConstant.EDITTYPE_NEW).equals(editType)
                || sysConfig.getProperty(EditTypeConstant.EDITTYPE_COPY_PROPOSAL).equals(editType)
                || sysConfig.getProperty(EditTypeConstant.EDITTYPE_COPY_POLICY).equals(editType)) {
            saveFlag = "I";
        } else if (sysConfig.getProperty(EditTypeConstant.EDITTYPE_RENEWAL).equals(editType)) {// 续保
            saveFlag = "R";
        } else {
            throw new BusinessException("未知编辑类型:" + editType);
        }
        // 续保保单OthFlag设置为续保
        if (sysConfig.getProperty(EditTypeConstant.EDITTYPE_RENEWAL).equals(editType)) {
            prpTmainDto.setOthFlag("100000YY000000000000");
        }

        try {
            // 政策性标志校验
            String businessType1 = prpTmainDto.getBusinessType1();
//            if ("01".equals(businessType1) && !"ZC".equals(ZCFlag)) {
//                throw new DataVerifyException("此险种政策/商业标志不能选择中央政策性!");
//            }
            String oldPolicyNo = "";
            if(proposalSaveDto.getPrpTrenewalDto()!=null){
                oldPolicyNo = proposalSaveDto.getPrpTrenewalDto().getOldPolicyNo();
            }
            // 对投保单数据进行价税分离操作
            leviedFeeService.dealTMainForYGZ(proposalSaveDto);
            //我们自己生成的客户代码 (投保人的)
            String customerCode="";
            /**将客户号放入业务表prptinsured  通过insureCode判断投保人和被保险人是不是同一个人
             * 如果是同一个人,则只要生成一个customerCode并保存到投保人和被投保人中,如果不是同一个人
             * ,则生成两个customerCode分别放入到投保人和被投保人信息中*/
            //获取客户类型 和需求确认过 投保人和被保险人一般是同一个人 所以获取投保人的客户类型即可
            String customerType=proposalSaveDto.getAppliInsuredDto().getInsuredType();
            /** '3' 代表非企业团体,就是散户 如果是散户 (投保人和被投保人是同一个人) 保存到prpdcustomerUnit中*/
            if ("3".equals(customerType)){
                /** 获取客户名  */
                String insureName=proposalSaveDto.getAppliInsuredDto().getInsuredName();
                Map<String,String> map=new HashMap<>();
                map.put("insureName",insureName);
                //是散户的情况下 用用户名去查询是否已经有相关的数据了
                List<PrpDcustomerUnitDto> prpDcustomerUnitDtoList=prpDcustomerUnitApi.queryByInsureName(map);
                //如果已经有相关的数据了 则直接使用老的客户代码
                if (prpDcustomerUnitDtoList!=null && prpDcustomerUnitDtoList.size()>0){
                    customerCode=prpDcustomerUnitDtoList.get(0).getCustomerCode();
                    proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    proposalSaveDto.getInsuredDto().setInsuredCode(customerCode);
                }
                //如果没有查到以前的相关数据 则生成新的customerCode
                else {
                    customerCode=this.getAppliCustomerCode(proposalSaveDto);
                    proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    proposalSaveDto.getInsuredDto().setInsuredCode(customerCode);
                }
            }
            /** 如果是大户 客户类型是个人或是单位 个人保存到prpdcustomerIdv中 单位保存到prpDcustomerUnit*/
            else if ("2".equals(customerType)||"1".equals(customerType)){
                /** 如果是大户 则投保人和被投保人可能出现不是同一个人的情况 根据insureCode判断他们是否是同一个人*/
                if (proposalSaveDto.getAppliInsuredDto().getIdentifyNumber().equals(proposalSaveDto.getInsuredDto().getIdentifyNumber())) {
                    //如果是同一个人 ,先去判断这个大户在基础表中是不是已经存在了(根据证件类型和证件号码去匹配)
                    Map<String,String> map=new HashMap<>();
                    map.put("identifyType",proposalSaveDto.getAppliInsuredDto().getIdentifyType());
                    map.put("identifyNumber",proposalSaveDto.getAppliInsuredDto().getIdentifyNumber());
                    List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList=prpDcustomerIdvApi.queryPrpDcustomerByIndentity(map);
                    //如果已经存在了 则直接用老的客户代码放入即可
                    if (prpDcustomerIdvDtoList!=null && prpDcustomerIdvDtoList.size()>0){
                        customerCode=prpDcustomerIdvDtoList.get(0).getCustomerCode();
                        proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                        proposalSaveDto.getInsuredDto().setInsuredCode(customerCode);
                    }else {
                        //如果不存在,则用新生成的客户代码
                        /**获取客户号 */
                        customerCode=this.getAppliCustomerCode(proposalSaveDto);
                        proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                        proposalSaveDto.getInsuredDto().setInsuredCode(customerCode);
                    }
                }
                /** 如果他们不是同一个人 */
                else {
                    //先处理投保人的 去查询是不是已经有投保人的相关信息了
                    Map<String,String> map=new HashMap<>();
                    map.put("identifyType",proposalSaveDto.getAppliInsuredDto().getIdentifyType());
                    map.put("identifyNumber",proposalSaveDto.getAppliInsuredDto().getIdentifyNumber());
                    List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList=prpDcustomerIdvApi.queryPrpDcustomerByIndentity(map);
                    //如果已经有相关的了 则直接用老的customerCode
                    if (prpDcustomerIdvDtoList!=null && prpDcustomerIdvDtoList.size()>0){
                        customerCode=prpDcustomerIdvDtoList.get(0).getCustomerCode();
                        proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    } else {
                        //如果不存在,则用新生成的客户代码
                        /**获取客户号 */
                        customerCode=this.getAppliCustomerCode(proposalSaveDto);
                        proposalSaveDto.getAppliInsuredDto().setInsuredCode(customerCode);
                    }
                    //此处处理被保险人的
                    Map<String,String> map1=new HashMap<>();
                    map1.put("identifyType",proposalSaveDto.getInsuredDto().getIdentifyType());
                    map1.put("identifyNumber",proposalSaveDto.getInsuredDto().getIdentifyNumber());
                    List<PrpDcustomerIdvDto> prpDcustomerIdvDtoList1=prpDcustomerIdvApi.queryPrpDcustomerByIndentity(map1);
                    //如果已经有了相关的信息 则就用老的customerCode
                    if (prpDcustomerIdvDtoList1!=null && prpDcustomerIdvDtoList1.size()>0){
                        customerCode=prpDcustomerIdvDtoList1.get(0).getCustomerCode();
                        proposalSaveDto.getInsuredDto().setInsuredCode(customerCode);
                    }
                    else {
                        //再生成被保险人的客户代码,再放入被保险人的信息中
                        String customerCode2 = this.getInsureCustomerCode(proposalSaveDto);
                        proposalSaveDto.getInsuredDto().setInsuredCode(customerCode2);
                    }
                }
            }
             //投保人与被保险人 是同一个人
            if(proposalSaveDto.getAppliInsuredDto().getIdentifyNumber()==null){
                proposalSaveDto.getAppliInsuredDto().setIdentifyNumber("");
            }
            if(proposalSaveDto.getInsuredDto().getIdentifyNumber()==null){
                proposalSaveDto.getInsuredDto().setIdentifyNumber("");
            }
            if (proposalSaveDto.getAppliInsuredDto().getIdentifyNumber().equals(proposalSaveDto.getInsuredDto().getIdentifyNumber())) {
                //客户风险等级历史轨迹保存逻辑start
                int maxLineNo = 1;
                PrpDcustomLevelTraceDto prpDcustomLevelTraceDto = prpDcustomLevelTraceApi.findRiskLevelByCustomerCode(customerCode);
                if (prpDcustomLevelTraceDto != null) {
                    prpDcustomLevelTraceDto.setOldRiskLevel(prpDcustomLevelTraceDto.getNewRiskLevel());
                    maxLineNo = prpDcustomLevelTraceDto.getLineNo() + 1;
                }
                if (prpDcustomLevelTraceDto == null) {
                    prpDcustomLevelTraceDto = new PrpDcustomLevelTraceDto();
                }
                prpDcustomLevelTraceDto.setCustomerCode(customerCode);
                prpDcustomLevelTraceDto.setLineNo(maxLineNo);
                prpDcustomLevelTraceDto.setOperateCode(proposalSaveDto.getPrpTmainDto().getOperatorCode());
                prpDcustomLevelTraceDto.setOperateDate(proposalSaveDto.getPrpTmainDto().getOperateDate());
                prpDcustomLevelTraceDto.setNewRiskLevel(proposalSaveDto.getAppliInsuredDto().getRiskLevel());
                prpDcustomLevelTraceApi.save(prpDcustomLevelTraceDto);
                //end
            } else{
                //客户风险等级历史轨迹保存逻辑start
                //投保人风险等级轨迹
                int maxLineNoAppli = 1;
                PrpDcustomLevelTraceDto prpDcustomLevelTraceDtoAppli = prpDcustomLevelTraceApi.findRiskLevelByCustomerCode(proposalSaveDto.getAppliInsuredDto().getInsuredCode());
                if (prpDcustomLevelTraceDtoAppli != null) {
                    prpDcustomLevelTraceDtoAppli.setOldRiskLevel(prpDcustomLevelTraceDtoAppli.getNewRiskLevel());
                    maxLineNoAppli = prpDcustomLevelTraceDtoAppli.getLineNo() + 1;
                }
                if (prpDcustomLevelTraceDtoAppli == null) {
                    prpDcustomLevelTraceDtoAppli = new PrpDcustomLevelTraceDto();
                }
                prpDcustomLevelTraceDtoAppli.setCustomerCode(proposalSaveDto.getAppliInsuredDto().getInsuredCode());
                prpDcustomLevelTraceDtoAppli.setLineNo(maxLineNoAppli);
                prpDcustomLevelTraceDtoAppli.setOperateCode(proposalSaveDto.getPrpTmainDto().getOperatorCode());
                prpDcustomLevelTraceDtoAppli.setOperateDate(proposalSaveDto.getPrpTmainDto().getOperateDate());
                prpDcustomLevelTraceDtoAppli.setNewRiskLevel(proposalSaveDto.getAppliInsuredDto().getRiskLevel());
                prpDcustomLevelTraceApi.save(prpDcustomLevelTraceDtoAppli);
                //被保险人风险等级轨迹
                int maxLineNoInsured = 1;
                PrpDcustomLevelTraceDto prpDcustomLevelTraceDtoInsured = prpDcustomLevelTraceApiInsured.findRiskLevelByCustomerCode(proposalSaveDto.getInsuredDto().getInsuredCode());
                if (prpDcustomLevelTraceDtoInsured != null) {
                    prpDcustomLevelTraceDtoInsured.setOldRiskLevel(prpDcustomLevelTraceDtoInsured.getNewRiskLevel());
                    maxLineNoInsured = prpDcustomLevelTraceDtoInsured.getLineNo() + 1;
                }
                if (prpDcustomLevelTraceDtoInsured == null) {
                    prpDcustomLevelTraceDtoInsured = new PrpDcustomLevelTraceDto();
                }
                prpDcustomLevelTraceDtoInsured.setCustomerCode(proposalSaveDto.getInsuredDto().getInsuredCode());
                prpDcustomLevelTraceDtoInsured.setLineNo(maxLineNoAppli);
                prpDcustomLevelTraceDtoInsured.setOperateCode(proposalSaveDto.getPrpTmainDto().getOperatorCode());
                prpDcustomLevelTraceDtoInsured.setOperateDate(proposalSaveDto.getPrpTmainDto().getOperateDate());
                prpDcustomLevelTraceDtoInsured.setNewRiskLevel(proposalSaveDto.getInsuredDto().getRiskLevel());
                prpDcustomLevelTraceApiInsured.save(prpDcustomLevelTraceDtoInsured);
            }
            // 暂存时此处需要判断跳过投保单质量检查,1-保存，0-暂存
            if ("1".equals(proposalSaveDto.getIsSaveFlag())) { // 投保单质量检查
                //校验共保信息
                CheckRenewalMethod(prpTmainDto, riskCode, saveFlag, oldPolicyNo);
                proposalCheck.checkData(proposalSaveDto);
            }
            //如果是暂存，则在此给UnderwriteFlag赋值为8
            if ("0".equals(proposalSaveDto.getPrpTmainDto().getUnderwriteFlag()) && "0".equals(proposalSaveDto.getIsSaveFlag())) {
                proposalSaveDto.getPrpTmainDto().setUnderwriteFlag("8");
            }
            //如果是暂存后再保存的情况下则将UnderwriteFlag赋值为0初始值
            if ("8".equals(proposalSaveDto.getPrpTmainDto().getUnderwriteFlag()) && "1".equals(proposalSaveDto.getIsSaveFlag())) {
                proposalSaveDto.getPrpTmainDto().setUnderwriteFlag("0");
            }
            String isseefeerisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "ISSEEFEERISK", 1).getRule();
            if (isseefeerisk != null) {

            } else {
                isseefeerisk = "0";
            }
            // 见费出单标志赋值
            if (isseefeerisk.indexOf(riskCode) > -1) {
                prpTmainDto.setIsSeeFeeFlag("1");// 见费出单
            } else {
                prpTmainDto.setIsSeeFeeFlag("0");// 非见费出单
            }
            // 投保单保存
            this.saveData(proposalSaveDto);
            // 生成虚拟分户信息

            if (groupProposalService.isGroupProposal(riskCode)) {
                groupProposalService.createVirtualItem(proposalSaveDto);
            }
        } catch (Exception e) {
            // 投保单的非修改(即新保、复制、续保)的保存失败，放回业务号
            if ("R".equals(saveFlag)) {
                String tableName = sysConfig.getProperty("PROPOSAL_TABLE");
                // TODO 需要 bill.putNo(tableName,proposalNo);
                //备注：新系统与老系统有区别，一进入投保单录入页面就生成投保单号，故在此无需反向删除单号
            }
            e.printStackTrace();
            throw e;
        }
        // 投保单的非修改(即新保、复制、续保)的保存成功，注销业务号
        if (!"U".equals(saveFlag)) {
            String tableName = sysConfig.getProperty("PROPOSAL_TABLE");
            // TODO 需要bill.deleteNo(tableName,proposalNo);
            //备注：新系统与老系统有区别，一进入投保单录入页面就生成投保单号，故在此无需反向删除单号
        }
        //与需求沟通过，投保单在保费计算时就存到清单表中，保存时不再回写投保单号。存在垃圾数据会用定时任务去清理
//        if ("1".equals(proposalSaveDto.getIsSaveFlag())) {//只有是保存时且投保单保存成功
//            //回写清单投保单号与清单状态
//            insureMainListApi.relatedInsuranceNo(proposalSaveDto.getPrpTmainAgriDto().getRelationListNo(), proposalNo, "1");
//        }

        // 投保单保存时，回写客户信息
        if ("1".equals(proposalSaveDto.getIsSaveFlag())) {
            this.UpdateCustomerInfo(proposalSaveDto.getAppliInsuredDto());
        }

        // 投保单保存成功时生成该节点的已完成数据
        try {
            if ("1".equals(proposalSaveDto.getIsSaveFlag())) {
                if (StringUtils.isEmpty(proposalSaveDto.getAddEditExamine())) {
                    // 投保单保存
                    this.generateNodeData(prpTmainDto, SAVE);
                } else {
                    // 投保单修改
                    this.generateNodeData(prpTmainDto, MODIFY);
                }
            } else if ("0".equals(proposalSaveDto.getIsSaveFlag())) {
                // 投保单暂存
                this.generateNodeData(prpTmainDto, TEMPORARY_SAVE);
            }
        } catch (Exception e) {
            LOGGER.error("节点数据推送至金禾系统失败!{}", e.getMessage());
            throw new BusinessException("保存失败，请尝试重新保存！");
        }
        return proposalNo;
    }

    /**
     *  校验共保信息
     * @author: 田健
     * @date: 2018/4/27 18:28
     * @param prpTmainDto 投保单主表对象
     * @param riskCode 险种
     * @param saveFlag 暂存、保存标志
     * @param oldPolicyNo 被续保的保单号
     * @throws ParseException
     */
    private void CheckRenewalMethod(PrpTmainDto prpTmainDto, String riskCode, String saveFlag, String oldPolicyNo) throws ParseException {
        if ("R".equals(saveFlag)) {
            // 校验被续保保单是否脱保
            if (StringUtils.isNotEmpty(oldPolicyNo)) {
                PrpCmain oldPrpCmain = prpCmainDao.findOne(new PrpCmainKey(oldPolicyNo));
                long dayCount = this.getDayMinus(prpTmainDto.getStartDate(), prpTmainDto.getStartHour(), oldPrpCmain.getEndDate(), oldPrpCmain.getEndHour());
                dayCount = Math.abs(dayCount);
                // 种植险脱保时间为365天，其他险类脱保时间为90天
                if ("31".equals(riskCode.substring(0, 2))) {
                    if (dayCount > 365) {
                        throw new DataVerifyException("被续保保单已经脱保，不允许使用续保标志。请进行修改！");
                    }
                } else {
                    if (dayCount > 90) {
                        throw new DataVerifyException("被续保保单已经脱保，不允许使用续保标志。请进行修改！");
                    }
                }
            }
            // 校验续保时间是否大于90天
            long dayCount = this.getDayMinus(prpTmainDto.getStartDate(), prpTmainDto.getStartHour(), prpTmainDto.getEndDate(), prpTmainDto.getEndHour());
            dayCount = Math.abs(dayCount);
            if (dayCount <= 90) {
                throw new DataVerifyException("续保保单保险期间小于或等于90天，不允许使用续保标志。请进行修改！");
            }
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate 开始时间
     * @param startHour 开始小时
     * @param endDate   结束时间
     * @param endHour   结束小时
     * @return 相差天数
     * @throws ParseException
     * @author: 何伟东
     * @date: 2017/10/28 9:06
     */
    private long getDayMinus(Date startDate, int startHour, Date endDate, int endHour) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.HOUR_OF_DAY, startHour);
        long startTime = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        calendar.add(Calendar.HOUR_OF_DAY, endHour);
        long endTime = calendar.getTimeInMillis();
        long betweenDays = (endTime - startTime) / (1000 * 3600 * 24);
        return betweenDays;
    }

    /**
     * 获取投保人客户号
     *
     * @param proposalSaveDto 投保单保存大对象
     * @author: 王保良
     * @date: 2017/10/29 14:21
     */
    private String getAppliCustomerCode(ProposalSaveDto proposalSaveDto) throws Exception{
        String customerType=proposalSaveDto.getAppliInsuredDto().getInsuredType();
        Map<String,String> map= new HashMap<>();
        map.put("iCustomerType",customerType);
        map.put("iMakeCom",proposalSaveDto.getPrpTmainDto().getMakeCom());
        //生成客户号
        String customerCode=billNoApi.apply(map);
        return customerCode;
    }

    /**
     * 获取被保险人客户号
     *
     * @param proposalSaveDto 投保单保存大对象
     * @author: 王保良
     * @date: 2017/10/29 14:21
     */
    private String getInsureCustomerCode(ProposalSaveDto proposalSaveDto) throws Exception{
        String customerType=proposalSaveDto.getInsuredDto().getInsuredType();
        Map<String,String> map= new HashMap<>();
        map.put("iCustomerType",customerType);
        map.put("iMakeCom",proposalSaveDto.getPrpTmainDto().getMakeCom());
        //生成客户号
        String customerCode=billNoApi.apply(map);
        return customerCode;
    }

    /**
     * 保存投保单大对象
     *
     * @param proposalSaveDto 投保单保存大对象
     * @author: 何伟东
     * @date: 2017/10/29 14:21
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveData(ProposalSaveDto proposalSaveDto)  throws Exception {
        if(StringUtils.isNotEmpty(proposalSaveDto.getAddEditExamine())){//修改
            this.updateProposal(proposalSaveDto);
        }else{//保存
            try {
                this.saveProposal(proposalSaveDto);
            }catch (Exception e){
                Throwable t = e.getCause();
                //捕获ConstraintViolationException这个异常，进行判断是否主键冲突
                if( t instanceof ConstraintViolationException){
                   throw new Exception("此业务号已经存在，请联系系统管理员！");
                }
                e.printStackTrace();
            }
        }
        //投保单暂存时，若果不点击保费计算，清单信息是没有存储的，导致在投保单修改时金禾清单会丢失。所以
        //在此判断是否做了计算，如果没有计算，我们收集信息存到清单主表中
        if("0".equals(proposalSaveDto.getIsSaveFlag())){
            //根据我方清单号查询清单主表信息，
            InsureMainListDto insureMainListDto = insureMainListApi.queryByPK(proposalSaveDto.getPrpTmainAgriDto().getRelationListNo());
            if(insureMainListDto==null){
                InsureMainListDto insureMainListDtotemp = new InsureMainListDto();
                insureMainListDtotemp.setInusreListCode(proposalSaveDto.getPrpTmainAgriDto().getRelationListNo());
                insureMainListDtotemp.setGisInsureListCode(proposalSaveDto.getGisInsureListCode());
                insureMainListDtotemp.setProposalNo(proposalSaveDto.getPrpTmainDto().getProposalNo());
                insureMainListDtotemp.setSerialNo(Integer.parseInt(proposalSaveDto.getSerialNo()));
                insureMainListApi.save(insureMainListDtotemp);
            }
        }
    }

    /**
     * 保存投保单对象
     * @author: 田健
     * @date: 2018/5/24 16:56
     * @param proposalSaveDto 投保单对象
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveProposal(ProposalSaveDto proposalSaveDto) throws Exception {
        // 投保单基本信息保存
        PrpTmainDto prpTmainDto = generatePrpTmain(proposalSaveDto);
        if (prpTmainDto != null) {
            PrpTmain prpTmain = convert(prpTmainDto, PrpTmain.class);
            entityManager.persist(prpTmain);
        }
        // 农险投保单基本信息保存
        PrpTmainAgriDto prpTmainAgriDto = proposalSaveDto.getPrpTmainAgriDto();
        if (prpTmainAgriDto != null) {
            entityManager.persist(convert(prpTmainAgriDto, PrpTmainAgri.class));
        }
        // 共保信息保存
        PrpTrenewalDto prpTrenewalDto = proposalSaveDto.getPrpTrenewalDto();
        if (prpTrenewalDto != null) {
            entityManager.persist(convert(prpTrenewalDto, PrpTrenewal.class));
        }
        //页面分别传投保人与被保险人2个Dto在此转换对象
        //begin
        List<PrpTinsuredDto> prpTinsuredDtoList = new ArrayList<PrpTinsuredDto>();
        if (proposalSaveDto.getAppliInsuredDto() == null) {
            throw new BusinessException("投保人客户信息不能为空！");
        }
        if (proposalSaveDto.getInsuredDto() == null) {
            throw new BusinessException("被保险人客户信息不能为空！");
        }

        PrpTinsuredDto appliPrpTinsuredDto = this.convert(proposalSaveDto.getAppliInsuredDto(), PrpTinsuredDto.class);
        PrpTinsuredDto insuredPrpTinsuredDto = this.convert(proposalSaveDto.getInsuredDto(), PrpTinsuredDto.class);
        prpTinsuredDtoList.add(appliPrpTinsuredDto);
        prpTinsuredDtoList.add(insuredPrpTinsuredDto);
        //end
        if (prpTinsuredDtoList != null && prpTinsuredDtoList.size() > 0) {
            List<PrpTinsured> prpTinsuredList = new ArrayList<>();
            convertCollection(prpTinsuredDtoList, prpTinsuredList, PrpTinsured.class);
            for (PrpTinsured prpTinsured : prpTinsuredList) {
                entityManager.persist(prpTinsured);
            }
        }

        // 客户信息保存start
        this.SaveCustomerInfo(proposalSaveDto);
        // 客户信息保存end

        // 地址信息保存
        PrpTaddressDto prpTaddressDto = proposalSaveDto.getPrpTaddressDto();
        if (prpTaddressDto != null) {
            entityManager.persist(convert(prpTaddressDto, PrpTaddress.class));
        }
        // 共保信息保存
        List<PrpTcoinsDto> prpTcoinsDtoList = proposalSaveDto.getPrpTcoinsDtoList();
        if (prpTcoinsDtoList != null && prpTcoinsDtoList.size() > 0) {
            List<PrpTcoins> prpTcoinsList = new ArrayList<>();
            convertCollection(prpTcoinsDtoList, prpTcoinsList, PrpTcoins.class);
            for (PrpTcoins prpTcoins : prpTcoinsList) {
                entityManager.persist(prpTcoins);
            }
        }
        // 共保信息明细信息保存
        List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList = proposalSaveDto.getPrpTcoinsDetailDtoList();
        if (prpTcoinsDetailDtoList != null && prpTcoinsDetailDtoList.size() > 0) {
            List<PrpTcoinsDetail> prpTcoinsDetailList = new ArrayList<>();
            convertCollection(prpTcoinsDetailDtoList, prpTcoinsDetailList, PrpTcoinsDetail.class);
            for (PrpTcoinsDetail prpTcoinsDetail : prpTcoinsDetailList) {
                entityManager.persist(prpTcoinsDetail);
            }
        }
        // 共保方收费计划信息保存
        List<PrpTplanCoinsDto> prpTplanCoinsDtoList = proposalSaveDto.getPrpTplanCoinsDtoList();
        if (prpTplanCoinsDtoList != null && prpTplanCoinsDtoList.size() > 0) {
            List<PrpTplanCoins> prpTplanCoinsList = new ArrayList<>();
            convertCollection(prpTplanCoinsDtoList, prpTplanCoinsList, PrpTplanCoins.class);
            for (PrpTplanCoins prpTplanCoins : prpTplanCoinsList) {
                entityManager.persist(prpTplanCoins);
            }
        }
        //拆分特约信息
        if (proposalSaveDto.getPrpTengageDtoList() != null) {
            if (proposalSaveDto.getPrpTengageDtoList().size() != 0) {
                ungroup(proposalSaveDto);
            }
        }
        // 特别约定信息保存
        List<PrpTengageDto> prpTengageDtoList = proposalSaveDto.getPrpTengageDtoList();
        if (prpTengageDtoList != null && prpTengageDtoList.size() > 0) {
            List<PrpTengage> prpTengageList = new ArrayList<>();
            convertCollection(prpTengageDtoList, prpTengageList, PrpTengage.class);
            for (PrpTengage prpTengage : prpTengageList) {
                entityManager.persist(prpTengage);
            }
        }
        // 纳税信息保存
        PrpTexpenseDto prpTexpenseDto = proposalSaveDto.getPrpTexpenseDto();
        if (prpTexpenseDto != null) {
            entityManager.persist(convert(prpTexpenseDto, PrpTexpense.class));
        }
        // 投保单保额保费信息保存
        PrpTfeeDto prpTfeeDto = proposalSaveDto.getPrpTfeeDto();
        if (prpTfeeDto != null) {
            entityManager.persist(convert(prpTfeeDto, PrpTfee.class));
        }
        // 标的信息保存
        List<PrpTitemKindDto> prpTitemKindDtoList = proposalSaveDto.getPrpTitemKindDtoList();
        if (prpTitemKindDtoList != null && prpTitemKindDtoList.size() > 0) {
            List<PrpTitemKind> prpTitemKindList = new ArrayList<>();
            convertCollection(prpTitemKindDtoList, prpTitemKindList, PrpTitemKind.class);
            for(PrpTitemKind prpTitemKind:prpTitemKindList){
                entityManager.persist(prpTitemKind);
            }
        }
        // 农险标的信息保存
        List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList = proposalSaveDto.getPrpTitemKindAgriDtoList();
        if (prpTitemKindAgriDtoList != null && prpTitemKindAgriDtoList.size() > 0) {
            List<PrpTitemKindAgri> prpTitemKindAgriList = new ArrayList<>();
            convertCollection(prpTitemKindAgriDtoList, prpTitemKindAgriList, PrpTitemKindAgri.class);
            for (PrpTitemKindAgri prpTitemKindAgri : prpTitemKindAgriList) {
                entityManager.persist(prpTitemKindAgri);
            }
        }
        // 缴费计划信息保存
        List<PrpTplanDto> prpTplanDtoList = proposalSaveDto.getPrpTplanDtoList();
        if (prpTplanDtoList != null && prpTplanDtoList.size() > 0) {
            List<PrpTplan> prpTplanList = new ArrayList<>();
            convertCollection(prpTplanDtoList, prpTplanList, PrpTplan.class);
            for (PrpTplan prpTplan : prpTplanList) {
                entityManager.persist(prpTplan);
            }
        }
        // 补贴信息保存
        List<PrpTsubsidyDto> prpTsubsidyDtoList = proposalSaveDto.getPrpTsubsidyDtoList();
        if (prpTsubsidyDtoList != null && prpTsubsidyDtoList.size() > 0) {
            List<PrpTsubsidy> prpTsubsidyList = new ArrayList<>();
            convertCollection(prpTsubsidyDtoList, prpTsubsidyList, PrpTsubsidy.class);
            for (PrpTsubsidy prpTsubsidy : prpTsubsidyList) {
                entityManager.persist(prpTsubsidy);
            }
        }
        entityManager.flush();//刷新保存到数据库中
    }
    /**
     * 更新投保单对象
     * @author: 田健
     * @date: 2018/5/24 16:56
     * @param proposalSaveDto 投保单对象
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateProposal(ProposalSaveDto proposalSaveDto) throws Exception {
        // 投保单基本信息保存
        PrpTmainDto prpTmainDto = generatePrpTmain(proposalSaveDto);
        //保存之前先删除信息
        this.cancel(prpTmainDto.getProposalNo());

        if (prpTmainDto != null) {
             PrpTmain prpTmain = prpTmainDao.saveAndFlush(convert(prpTmainDto, PrpTmain.class));
            if (prpTmain == null) {
                throw new BusinessException("投保单基本信息保存失败！");
            }
        }
        // 农险投保单基本信息保存
        PrpTmainAgriDto prpTmainAgriDto = proposalSaveDto.getPrpTmainAgriDto();
        if (prpTmainAgriDto != null) {
            PrpTmainAgri prpTmainAgri = prpTmainAgriDao.saveAndFlush(convert(prpTmainAgriDto, PrpTmainAgri.class));
            if (prpTmainAgri == null) {
                throw new BusinessException("农险投保单基本信息保存失败！");
            }
        }
        // 共保信息保存
        PrpTrenewalDto prpTrenewalDto = proposalSaveDto.getPrpTrenewalDto();
        if (prpTrenewalDto != null) {
            PrpTrenewal prpTrenewal = prpTrenewalDao.saveAndFlush(convert(prpTrenewalDto, PrpTrenewal.class));
            if (prpTrenewal == null) {
                throw new BusinessException("共保信息保存失败！");
            }
        }
        //页面分别传投保人与被保险人2个Dto在此转换对象
        //begin
        List<PrpTinsuredDto> prpTinsuredDtoList = new ArrayList<PrpTinsuredDto>();
        if (proposalSaveDto.getAppliInsuredDto() == null) {
            throw new BusinessException("投保人客户信息不能为空！");
        }
        if (proposalSaveDto.getInsuredDto() == null) {
            throw new BusinessException("被保险人客户信息不能为空！");
        }

        PrpTinsuredDto appliPrpTinsuredDto = this.convert(proposalSaveDto.getAppliInsuredDto(), PrpTinsuredDto.class);
        PrpTinsuredDto insuredPrpTinsuredDto = this.convert(proposalSaveDto.getInsuredDto(), PrpTinsuredDto.class);
        prpTinsuredDtoList.add(appliPrpTinsuredDto);
        prpTinsuredDtoList.add(insuredPrpTinsuredDto);
        //end
        if (prpTinsuredDtoList != null && prpTinsuredDtoList.size() > 0) {
            List<PrpTinsured> prpTinsuredList = new ArrayList<>();
            convertCollection(prpTinsuredDtoList, prpTinsuredList, PrpTinsured.class);
            List<PrpTinsured> prpTinsureds = prpTinsuredDao.save(prpTinsuredList);
            if (prpTinsureds == null || prpTinsureds.size() == 0) {
                throw new BusinessException("客户信息保存失败！");
            }
        }

        // 客户信息保存start
        this.SaveCustomerInfo(proposalSaveDto);
        // 客户信息保存end

        // 地址信息保存
        PrpTaddressDto prpTaddressDto = proposalSaveDto.getPrpTaddressDto();
        if (prpTaddressDto != null) {
            PrpTaddress prpTaddress = prpTaddressDao.saveAndFlush(convert(prpTaddressDto, PrpTaddress.class));
            if (prpTaddress == null) {
                throw new BusinessException("地址信息保存失败！");
            }
        }
        // 共保信息保存
        List<PrpTcoinsDto> prpTcoinsDtoList = proposalSaveDto.getPrpTcoinsDtoList();
        if (prpTcoinsDtoList != null && prpTcoinsDtoList.size() > 0) {
            List<PrpTcoins> prpTcoinsList = new ArrayList<>();
            convertCollection(prpTcoinsDtoList, prpTcoinsList, PrpTcoins.class);
            List<PrpTcoins> prpTcoinss = prpTcoinsDao.save(prpTcoinsList);
            if (prpTcoinss == null || prpTcoinss.size() == 0) {
                throw new BusinessException("共保信息保存失败！");
            }
        }
        // 共保信息明细信息保存
        List<PrpTcoinsDetailDto> prpTcoinsDetailDtoList = proposalSaveDto.getPrpTcoinsDetailDtoList();
        if (prpTcoinsDetailDtoList != null && prpTcoinsDetailDtoList.size() > 0) {
            List<PrpTcoinsDetail> prpTcoinsDetailList = new ArrayList<>();
            convertCollection(prpTcoinsDetailDtoList, prpTcoinsDetailList, PrpTcoinsDetail.class);
            List<PrpTcoinsDetail> prpTcoinsDetails = prpTcoinsDetailDao.save(prpTcoinsDetailList);
            if (prpTcoinsDetails == null || prpTcoinsDetails.size() == 0) {
                throw new BusinessException("共保信息明细信息保存失败！");
            }
        }
        // 共保方收费计划信息保存
        List<PrpTplanCoinsDto> prpTplanCoinsDtoList = proposalSaveDto.getPrpTplanCoinsDtoList();
        if (prpTplanCoinsDtoList != null && prpTplanCoinsDtoList.size() > 0) {
            List<PrpTplanCoins> prpTplanCoinsList = new ArrayList<>();
            convertCollection(prpTplanCoinsDtoList, prpTplanCoinsList, PrpTplanCoins.class);
            List<PrpTplanCoins> prpTcoinsDetails = prpTplanCoinsDao.save(prpTplanCoinsList);
            if (prpTcoinsDetails == null || prpTcoinsDetails.size() == 0) {
                throw new BusinessException("共保方收费计划信息保存失败！");
            }
        }
        //拆分特约信息
        if(proposalSaveDto.getPrpTengageDtoList()!=null){
            if(proposalSaveDto.getPrpTengageDtoList().size()!=0){
                ungroup(proposalSaveDto);
            }
        }
        // 特别约定信息保存
        List<PrpTengageDto> prpTengageDtoList = proposalSaveDto.getPrpTengageDtoList();
        if (prpTengageDtoList != null && prpTengageDtoList.size() > 0) {
            List<PrpTengage> prpTengageList = new ArrayList<>();
            convertCollection(prpTengageDtoList, prpTengageList, PrpTengage.class);
            List<PrpTengage> prpTengages = prpTengageDao.save(prpTengageList);
            if (prpTengages == null || prpTengages.size() == 0) {
                throw new BusinessException("特别约定信息保存失败！");
            }
        }
        // 纳税信息保存
        PrpTexpenseDto prpTexpenseDto = proposalSaveDto.getPrpTexpenseDto();
        if (prpTexpenseDto != null) {
            PrpTexpense prpTexpense = prpTexpenseDao.saveAndFlush(convert(prpTexpenseDto, PrpTexpense.class));
            if (prpTexpense == null) {
                throw new BusinessException("纳税信息保存失败！");
            }
        }
        // 投保单保额保费信息保存
        PrpTfeeDto prpTfeeDto = proposalSaveDto.getPrpTfeeDto();
        if (prpTfeeDto != null) {
            PrpTfee prpTfee = prpTfeeDao.saveAndFlush(convert(prpTfeeDto, PrpTfee.class));
            if (prpTfee == null) {
                throw new BusinessException("投保单保额保费信息保存失败！");
            }
        }
        // 大户田块信息保存
//        List<PrpTfeildDto> prpTfeildDtoList = proposalSaveDto.getPrpTfeildDtoList();
//        if (prpTfeildDtoList != null && prpTfeildDtoList.size() > 0) {
//            List<PrpTfeild> prpTfeildList = new ArrayList<>();
//            convertCollection(prpTfeildDtoList, prpTfeildList, PrpTfeild.class);
//            List<PrpTfeild> prpTfeilds = prpTfeildDao.save(prpTfeildList);
//            if (prpTfeilds == null || prpTfeilds.size() == 0) {
//                throw new BusinessException("大户田块信息保存失败！");
//            }
//        }
        // 标的信息保存
        List<PrpTitemKindDto> prpTitemKindDtoList = proposalSaveDto.getPrpTitemKindDtoList();
        if (prpTitemKindDtoList != null && prpTitemKindDtoList.size() > 0) {
            List<PrpTitemKind> prpTitemKindList = new ArrayList<>();
            convertCollection(prpTitemKindDtoList, prpTitemKindList, PrpTitemKind.class);
            List<PrpTitemKind> prpTitemKinds = prpTitemKindDao.save(prpTitemKindList);
            if (prpTitemKinds == null && prpTitemKinds.size() == 0) {
                throw new BusinessException("标的信息保存失败！");
            }
        }
        // 农险标的信息保存
        List<PrpTitemKindAgriDto> prpTitemKindAgriDtoList = proposalSaveDto.getPrpTitemKindAgriDtoList();
        if (prpTitemKindAgriDtoList != null && prpTitemKindAgriDtoList.size() > 0) {
            List<PrpTitemKindAgri> prpTitemKindAgriList = new ArrayList<>();
            convertCollection(prpTitemKindAgriDtoList, prpTitemKindAgriList, PrpTitemKindAgri.class);
            List<PrpTitemKindAgri> prpTitemKindAgris = prpTitemKindAgriDao.save(prpTitemKindAgriList);
            if (prpTitemKindAgris == null || prpTitemKindAgris.size() == 0) {
                throw new BusinessException("农险标的信息保存失败！");
            }
        }
        // 贷款保险保单信息保存
//        PrpTmainLoanDto prpTmainLoanDto = proposalSaveDto.getPrpTmainLoanDto();
//        if (prpTmainLoanDto != null) {
//            PrpTmainLoan prpTmainLoan = prpTmainLoanDao.saveAndFlush(convert(prpTmainLoanDto, PrpTmainLoan.class));
//            if (prpTmainLoan == null) {
//                throw new BusinessException("贷款保险保单信息保存失败！");
//            }
//        }
        // 缴费计划信息保存
        List<PrpTplanDto> prpTplanDtoList = proposalSaveDto.getPrpTplanDtoList();
        if (prpTplanDtoList != null && prpTplanDtoList.size() > 0) {
            List<PrpTplan> prpTplanList = new ArrayList<>();
            convertCollection(prpTplanDtoList, prpTplanList, PrpTplan.class);
            List<PrpTplan> prpTplans = prpTplanDao.save(prpTplanList);
            if (prpTplans == null || prpTplans.size() == 0) {
                throw new BusinessException("缴费计划信息保存失败！");
            }
        }
        // 补贴信息保存
        List<PrpTsubsidyDto> prpTsubsidyDtoList = proposalSaveDto.getPrpTsubsidyDtoList();
        if (prpTsubsidyDtoList != null && prpTsubsidyDtoList.size() > 0) {
            List<PrpTsubsidy> prpTsubsidyList = new ArrayList<>();
            convertCollection(prpTsubsidyDtoList, prpTsubsidyList, PrpTsubsidy.class);
            List<PrpTsubsidy> prpTsubsidies = prpTsubsidyDao.save(prpTsubsidyList);
            if (prpTsubsidies == null || prpTsubsidies.size() == 0) {
                throw new BusinessException("补贴信息保存失败！");
            }
        }
    }

    /**
     * //生成单证类型保存到prptmainDto中\将生成的客户号(投保人)保存到prptmainDto中\将systemFlag保存到prptmainDto
     * @author: 田健
     * @date: 2018/5/24 16:59
     * @param proposalSaveDto 投保单大对象
     * @throws Exception
     */
    private PrpTmainDto generatePrpTmain(ProposalSaveDto proposalSaveDto) throws Exception {
        PrpTmainDto prpTmainDto = proposalSaveDto.getPrpTmainDto();
        //生成单证类型保存到prptmainDto中
        RequestQueryVisaCodeDto requestQueryVisaCodeDto = new RequestQueryVisaCodeDto();
        requestQueryVisaCodeDto.setComCode(prpTmainDto.getComCode());
        requestQueryVisaCodeDto.setCertiType("P");
        requestQueryVisaCodeDto.setRiskCode(prpTmainDto.getRiskCode());
        ResponseQueryVisaCodeDto responseQueryVisaCodeDto = visaApi.visaType(requestQueryVisaCodeDto);
        prpTmainDto.setVisaCode(responseQueryVisaCodeDto.getVisaCode());
        //将生成的客户号(投保人)保存到prptmainDto中
        prpTmainDto.setInsuredCode(proposalSaveDto.getInsuredDto().getInsuredCode());
        prpTmainDto.setAppliCode(proposalSaveDto.getAppliInsuredDto().getInsuredCode());
        //设置标识符
        prpTmainDto.setSystemFlag(systemFlag);
        return prpTmainDto;
    }

    /**
     * 保存之前先删后插
     * @author: 田健
     * @date: 2018/4/12 15:50
     * @param proposalNo 投保单号
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancel(String proposalNo) throws Exception{
        //先删后插，防止垃圾数据
        prpTplanDao.deleteByProposalNo(proposalNo);
        prpTitemKindAgriDao.deleteByProposalNo(proposalNo);
        prpTitemKindDao.deleteByProposalNo(proposalNo);
        prpTsubsidyDao.deleteByProposalNo(proposalNo);
        prpTfeeDao.deleteByProposalNo(proposalNo);
        prpTexpenseDao.deleteByProposalNo(proposalNo);
        prpTengageDao.deleteByProposalNo(proposalNo);
        prpTplanCoinsDao.deleteByProposalNo(proposalNo);
        prpTcoinsDetailDao.deleteByProposalNo(proposalNo);
        prpTcoinsDao.deleteByProposalNo(proposalNo);
        prpTaddressDao.deleteByProposalNo(proposalNo);
        prpTinsuredDao.deleteByProposalNo(proposalNo);
        prpTrenewalDao.deleteByProposalNo(proposalNo);
        prpTmainAgriDao.deleteByProposalNo(proposalNo);
        prpTmainDao.deleteByProposalNo(proposalNo);
    }
    /**
     * 保存客户信息及发票信息
     * @author: 田健
     * @date: 2017/12/25 18:04
     * @param proposalSaveDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void SaveCustomerInfo(ProposalSaveDto proposalSaveDto) throws Exception {
        //获取客户代码(投保人的)
        String appliCustomerCode=proposalSaveDto.getAppliInsuredDto().getInsuredCode();
        //获取客户代码(被保险人的)
        String insureCustomerCode=proposalSaveDto.getInsuredDto().getInsuredCode();
        //获取金禾的投保人的客户代码
        String gisAppliInsureCode=proposalSaveDto.getAppliInsuredDto().getCertificateName();
        //获取金禾的被保险人的客户代码
        String gisInsureCode=proposalSaveDto.getInsuredDto().getCertificateName();

        //如果是散户,则查询基础表中是否已经有数据了
        List<PrpDcustomerDto> prpDcustomerDtos = new ArrayList<>();
        PrpDcustomerDto appliprpDcustomerDto = new PrpDcustomerDto();
        PrpDcustomerDto insuredprpDcustomerDto = new PrpDcustomerDto();
        List<PrpDcustomerIdvDto> prpDcustomerIdvDtos = new ArrayList<>();
        PrpDcustomerIdvDto appliprpDcustomerIdvDto = new PrpDcustomerIdvDto();
        PrpDcustomerIdvDto insuredprpDcustomerIdvDto = new PrpDcustomerIdvDto();
        List<PrpDcustomerUnitDto> prpDcustomerUnitDtos = new ArrayList<>();
        PrpDcustomerUnitDto appliprpDcustomerUnitDto = new PrpDcustomerUnitDto();
        PrpDcustomerUnitDto insuredprpDcustomerUnitDto = new PrpDcustomerUnitDto();
        AppliInsuredDto appliInsuredDto = proposalSaveDto.getAppliInsuredDto();
        InsuredDto insuredDto = proposalSaveDto.getInsuredDto();
        //组装投保人客户信息主表start
        //此处保存我们自己生成的客户代码
        appliprpDcustomerDto.setCustomerCode(appliCustomerCode);
        //用prpDcustomer中的remark作为借用字段保存
        appliprpDcustomerDto.setRemark(gisAppliInsureCode);
        appliprpDcustomerDto.setCustomerType(appliInsuredDto.getInsuredType());
        appliprpDcustomerDto.setCustomerCName(appliInsuredDto.getInsuredName());
        appliprpDcustomerDto.setAddressCName(appliInsuredDto.getInsuredAddress());
        appliprpDcustomerDto.setValidStatus("1");
        prpDcustomerDtos.add(appliprpDcustomerDto);
        //组装投保人客户信息主表end
        //组装被保险人客户信息主表start
        //此处保存我们自己生成的客户代码
        insuredprpDcustomerDto.setCustomerCode(insureCustomerCode);
        //用prpDcustomer中的remark作为借用字段保存
        insuredprpDcustomerDto.setRemark(gisInsureCode);
        insuredprpDcustomerDto.setCustomerType(appliInsuredDto.getInsuredType());
        insuredprpDcustomerDto.setCustomerCName(appliInsuredDto.getInsuredName());
        insuredprpDcustomerDto.setAddressCName(appliInsuredDto.getInsuredAddress());
        insuredprpDcustomerDto.setValidStatus("1");
        prpDcustomerDtos.add(insuredprpDcustomerDto);
        //组装被保险人客户信息主表end
        //获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = simpleDateFormat.parse(simpleDateFormat.format(date));

        /**  根据insuredType的不同(大户或者是散户) 组装prpcustomerIdv表或者是prpDcustomerUnit表*/
        /**  如果是大户  组装prpDcustomerIdv表*/
        if("1".equals(appliInsuredDto.getInsuredType())){//个体客户信息
            //组装个体客户投保人信息start
            //此处放置我们自己生成的投保人的客户代码
            appliprpDcustomerIdvDto.setCustomerCode(appliCustomerCode);
            //用prpDcustomerIdv中的articleCode作为借用字段放置金禾的客户代码 此处为投保人的
            appliprpDcustomerIdvDto.setArticleCode(gisAppliInsureCode);
            appliprpDcustomerIdvDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());//操作人代码
            appliprpDcustomerIdvDto.setCustomerKind(appliInsuredDto.getInsuredType());//客户类型
            appliprpDcustomerIdvDto.setComCode(proposalSaveDto.getPrpTmainDto().getComCode());//归属机构代码
            appliprpDcustomerIdvDto.setInputDate(date);//输入日期
            appliprpDcustomerIdvDto.setUpdateDate(date);//修改日期
            appliprpDcustomerIdvDto.setNewCustomerCode(insureCustomerCode);
            appliprpDcustomerIdvDto.setCustomerCName(appliInsuredDto.getInsuredName());
            appliprpDcustomerIdvDto.setAddressCName(appliInsuredDto.getInsuredAddress());
            appliprpDcustomerIdvDto.setValidStatus("1");
            appliprpDcustomerIdvDto.setIdentifyType(appliInsuredDto.getIdentifyType());
            appliprpDcustomerIdvDto.setIdentifyNumber(appliInsuredDto.getIdentifyNumber());
            appliprpDcustomerIdvDto.setPhoneNumber(appliInsuredDto.getPhoneNumber());
            appliprpDcustomerIdvDto.setMobile(appliInsuredDto.getMobile());
            appliprpDcustomerIdvDto.setLinkAddress(appliInsuredDto.getPostAddress());
            appliprpDcustomerIdvDto.setPostCode(appliInsuredDto.getPostCode());
            appliprpDcustomerIdvDto.setIsCareClaim(appliInsuredDto.getIsCareClaim());
            appliprpDcustomerIdvDto.setCashFocus(appliInsuredDto.getCashFocus());
            appliprpDcustomerIdvDto.setSex(appliInsuredDto.getSex());
            appliprpDcustomerIdvDto.setValidPeriod3(appliInsuredDto.getValidPeriod3());
            appliprpDcustomerIdvDto.setNationality(appliInsuredDto.getNationality());
            appliprpDcustomerIdvDto.setJobTitle(appliInsuredDto.getJobTitle());
            appliprpDcustomerIdvDto.setRiskLevel(appliInsuredDto.getRiskLevel());
            prpDcustomerIdvDtos.add(appliprpDcustomerIdvDto);
            //组装个体客户投保人信息end


            //组装个体客户被保险人人信息start
            //此处在customer中放置我们自己生成的被保险人客户编码
            insuredprpDcustomerIdvDto.setCustomerCode(appliCustomerCode);
            //此处借用prpDcustomerIdv中的article字段作为借用字段保存被保险人的金禾客户编码
            insuredprpDcustomerIdvDto.setArticleCode(gisInsureCode);
            insuredprpDcustomerIdvDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());
            insuredprpDcustomerIdvDto.setCustomerKind(insuredDto.getInsuredType());//客户类型
            insuredprpDcustomerIdvDto.setComCode( proposalSaveDto.getPrpTmainDto().getComCode());//归属机构代码
            insuredprpDcustomerIdvDto.setInputDate(date);//输入日期
            insuredprpDcustomerIdvDto.setUpdateDate(date);//修改日期
            insuredprpDcustomerIdvDto.setNewCustomerCode(insureCustomerCode);
            insuredprpDcustomerIdvDto.setCustomerCName(insuredDto.getInsuredName());
            insuredprpDcustomerIdvDto.setAddressCName (insuredDto.getInsuredAddress());
            insuredprpDcustomerIdvDto.setValidStatus  ("1");
            insuredprpDcustomerIdvDto.setIdentifyType(insuredDto.getIdentifyType());
            insuredprpDcustomerIdvDto.setIdentifyNumber(insuredDto.getIdentifyNumber());
            insuredprpDcustomerIdvDto.setPhoneNumber(insuredDto.getPhoneNumber());
            insuredprpDcustomerIdvDto.setMobile(insuredDto.getMobile());
            insuredprpDcustomerIdvDto.setLinkAddress(insuredDto.getPostAddress());
            insuredprpDcustomerIdvDto.setPostCode(insuredDto.getPostCode());
            insuredprpDcustomerIdvDto.setIsCareClaim(insuredDto.getIsCareClaim());
            insuredprpDcustomerIdvDto.setCashFocus(insuredDto.getCashFocus());
            insuredprpDcustomerIdvDto.setSex(insuredDto.getSex());
            insuredprpDcustomerIdvDto.setValidPeriod3(insuredDto.getValidPeriod3());
            insuredprpDcustomerIdvDto.setNationality(insuredDto.getNationality());
            insuredprpDcustomerIdvDto.setJobTitle(insuredDto.getJobTitle());
            insuredprpDcustomerIdvDto.setRiskLevel(insuredDto.getRiskLevel());
            prpDcustomerIdvDtos.add(insuredprpDcustomerIdvDto);
            //组装个体客户被保险人人信息end
        }else{
            /** 如果是散户(集体客户) 即insureType='3'或'2';,则保存到prpDcustomerUnit中*/
            //组装集体客户投保人信息start
            //此处放置我们自己生成的被保险人的客户代码
            appliprpDcustomerUnitDto.setCustomerCode(appliCustomerCode);
            //此处用prpDcustomer中的articleCode作为借用字段保存金禾的客户代码
            appliprpDcustomerUnitDto.setArticleCode(gisAppliInsureCode);
            appliprpDcustomerUnitDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());//操作人代码
            appliprpDcustomerUnitDto.setCustomerKind(appliInsuredDto.getInsuredType());//客户类型
            appliprpDcustomerUnitDto.setIdentifyValidPeriod(appliInsuredDto.getValidPeriod3());//证件有效期
            appliprpDcustomerUnitDto.setComType(appliInsuredDto.getBusinessSort());//公司性质
            appliprpDcustomerUnitDto.setComCode(proposalSaveDto.getPrpTmainDto().getComCode());//归属机构代码
            appliprpDcustomerUnitDto.setInputDate(date);//输入日期
            appliprpDcustomerUnitDto.setUpdateDate(date);//修改日期
            appliprpDcustomerUnitDto.setNewCustomerCode(insureCustomerCode);
            appliprpDcustomerUnitDto.setCustomerCName(appliInsuredDto.getInsuredName());
            appliprpDcustomerUnitDto.setAddressCName(appliInsuredDto.getInsuredAddress());
            appliprpDcustomerUnitDto.setValidStatus("1");
            appliprpDcustomerUnitDto.setIdentifyType(appliInsuredDto.getIdentifyType());
            appliprpDcustomerUnitDto.setOrganizeCode(appliInsuredDto.getIdentifyNumber());
            appliprpDcustomerUnitDto.setPhoneNumber(appliInsuredDto.getPhoneNumber());
            appliprpDcustomerUnitDto.setPostAddress(appliInsuredDto.getPostAddress());
            appliprpDcustomerUnitDto.setPostCode(appliInsuredDto.getPostCode());
            appliprpDcustomerUnitDto.setLinkerName(appliInsuredDto.getLinkerName());
            appliprpDcustomerUnitDto.setIsCareClaim(appliInsuredDto.getIsCareClaim());
            appliprpDcustomerUnitDto.setCashFocus(appliInsuredDto.getCashFocus());
            appliprpDcustomerUnitDto.setRiskLevel(appliInsuredDto.getRiskLevel());
            prpDcustomerUnitDtos.add(appliprpDcustomerUnitDto);
            //组装集体客户投保人信息end


            //组装集体客户被保险人人信息start
            //此处在customer中保存我们自己生成的投保人客户代码
            insuredprpDcustomerUnitDto.setCustomerCode(insureCustomerCode);
            //此处借用prpDcustomer中的articleCode字段用来保存金禾的客户编码
            insuredprpDcustomerUnitDto.setArticleCode(gisInsureCode);
            insuredprpDcustomerUnitDto.setOperatorCode(SinoRequestContext.getCurrentContext().getUserCode());//操作人代码

            insuredprpDcustomerUnitDto.setCustomerKind(insuredDto.getInsuredType());//客户类型
            insuredprpDcustomerUnitDto.setIdentifyValidPeriod(insuredDto.getValidPeriod3());//证件有效期
            insuredprpDcustomerUnitDto.setComType(insuredDto.getBusinessSort());//公司性质
            insuredprpDcustomerUnitDto.setComCode(proposalSaveDto.getPrpTmainDto().getComCode());//归属机构代码
            insuredprpDcustomerUnitDto.setInputDate(date);//输入日期
            insuredprpDcustomerUnitDto.setUpdateDate(date);//修改日期
            insuredprpDcustomerUnitDto.setNewCustomerCode(insureCustomerCode);
            insuredprpDcustomerUnitDto.setCustomerCName(insuredDto.getInsuredName());
            insuredprpDcustomerUnitDto.setAddressCName (insuredDto.getInsuredAddress());
            insuredprpDcustomerUnitDto.setValidStatus  ("1");
            insuredprpDcustomerUnitDto.setIdentifyType(insuredDto.getIdentifyType());
            insuredprpDcustomerUnitDto.setOrganizeCode(insuredDto.getIdentifyNumber());
            insuredprpDcustomerUnitDto.setPhoneNumber(insuredDto.getPhoneNumber());
            insuredprpDcustomerUnitDto.setPostAddress(insuredDto.getPostAddress());
            insuredprpDcustomerUnitDto.setPostCode(insuredDto.getPostCode());
            insuredprpDcustomerUnitDto.setIsCareClaim(insuredDto.getIsCareClaim());
            insuredprpDcustomerUnitDto.setCashFocus(insuredDto.getCashFocus());
            insuredprpDcustomerUnitDto.setRiskLevel(insuredDto.getRiskLevel());
            prpDcustomerUnitDtos.add(insuredprpDcustomerUnitDto);
            //组装集体客户被保险人人信息end
        }


        //发票信息  发票信息中就不用保存金禾的客户代码了
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto = new PrpDcustomerTaxPayInfoDto();
        prpDcustomerTaxPayInfoDto = proposalSaveDto.getPrpDcustomerTaxPayInfoDto();
        String customerCode1 = "";
        String InsuredType = "";
        if(prpDcustomerTaxPayInfoDto!= null){
            if("1".equals(prpDcustomerTaxPayInfoDto.getPayInfoObject())){
                //投保人类型
                InsuredType = appliInsuredDto.getInsuredType();//投保人客户类型
                customerCode1 = appliCustomerCode;//投保人客户代码
            }else{
                //被保险人类型
                InsuredType = insuredDto.getInsuredType();//被保人客户类型
                customerCode1 = insureCustomerCode;//被保人客户代码
            }
            prpDcustomerTaxPayInfoDto.setCustomerCode(customerCode1);
            prpDcustomerTaxPayInfoDto.setCustomerType(InsuredType);
        }else{
            throw new BusinessException("发票购货方信息为空!");
        }


        //统一进行保存
        //保存主表信息
        String info =  prpDcustomerApi.saveByList(prpDcustomerDtos);
        //保存个体信息
        if(prpDcustomerIdvDtos.size()>0){
            String info1 = prpDcustomerIdvApi.saveByList(prpDcustomerIdvDtos);
        }
        //保存集体客户信息
        if(prpDcustomerUnitDtos.size()>0){
            String info2 =   prpDcustomerUnitApi.saveByList(prpDcustomerUnitDtos);
        }
        //保存发票信息systemflag
        String info3=  prpDcustomerTaxPayInfoApi.save(prpDcustomerTaxPayInfoDto);
    }

    /**
     * 将PrpTengage中对象按照FIELDLENGHT长度拆分成多个PrpTengage对象信息
     * @author: 田健
     * @date: 2018/1/8 10:18
     * @param proposalSaveDto 投保单大对象
     * @return ProposalSaveDto 投保单大对象
     */
    public ProposalSaveDto ungroup(ProposalSaveDto proposalSaveDto){
        PrpTengageDto prpTengageDto = null;//原有Dto
        PrpTengageDto prpTengageAddDto = null;//新增Dto
        List<PrpTengageDto> prpTengageDtoList = new ArrayList<PrpTengageDto>();
        String[] arrClauses = {}; //拆分的条款数组
        int intLineNo = 0; //行号
        int intSerialNo = 0; //序号
        int intSetSeriNo = 1;
        int i, j = 0; //循环变量
        intLineNo = 0;
        intSerialNo = proposalSaveDto.getPrpTengageDtoList().get(0).getSerialNo();
        //循环拆分
        for (i = 0; i < proposalSaveDto.getPrpTengageDtoList().size(); i++) {
            prpTengageDto = proposalSaveDto.getPrpTengageDtoList().get(i);
            //拆分
            if (StringUtils.isEmpty(prpTengageDto.getClauses())) {
                String[] arrTemp = new String[1];
                arrTemp[0] = "";
                arrClauses = arrTemp;
            } else {
                arrClauses = splits(prpTengageDto.getClauses(), AgriPrpallConstant.FIELDLENGHT);
            }

            //判断是否重新计算行号
            if (intSerialNo != prpTengageDto.getSerialNo()) {
                intLineNo = 0;
                intSerialNo = prpTengageDto.getSerialNo();
                intSetSeriNo++;
            }
            //赋值
            for (j = 0; j<arrClauses.length; j++) {
                //长度校验
                if(arrClauses[j].getBytes().length > AgriPrpallConstant.FIELDLENGHT) {
                    LOGGER.error("ungroup() - length>FIELDLENGHT:" + arrClauses[j]);
                }

                intLineNo++; //行号加一
                prpTengageAddDto = new PrpTengageDto();
                prpTengageAddDto.setProposalNo(prpTengageDto.getProposalNo());
                prpTengageAddDto.setRiskCode(prpTengageDto.getRiskCode());
                prpTengageAddDto.setSerialNo(intSetSeriNo);
                prpTengageAddDto.setLineNo(intLineNo);
                prpTengageAddDto.setClauseCode(prpTengageDto.getClauseCode());
                prpTengageAddDto.setClauses(arrClauses[j]); //节FIELDLENGHT长
                prpTengageAddDto.setTitleFlag(prpTengageDto.getTitleFlag());
                prpTengageAddDto.setFlag(prpTengageDto.getFlag());
                prpTengageDtoList.add(prpTengageAddDto);
            }
        }
        proposalSaveDto.getPrpTengageDtoList().clear();
        proposalSaveDto.setPrpTengageDtoList(prpTengageDtoList);
        return proposalSaveDto;
    }

    /**
     * 用来拆分特约信息
     * @author: 田健
     * @date: 2018/2/2 8:42
     * @param originalString 字符串
     * @param splitByteLength 要截取的长度
     * @return 返回的字符串集合
     */
    public static String[] splits(String originalString, int splitByteLength){
        if(originalString.isEmpty()){
            return null;
        }

        int total=originalString.length();
        //获取数组总长度
        int len=(int)  Math.ceil(total/Double.valueOf(splitByteLength));
        //截取的起始位置
        int startIndex,endIndex;

        String[] ary=new String[len];
        String temp;
        for(int i=0;i<len;i++){
            startIndex=i*splitByteLength;
            endIndex=(i+1)*splitByteLength;
            if(endIndex>total){
                endIndex=total;
            }
            temp=originalString.substring(startIndex,endIndex);
            ary[i]=temp;
        }
        return ary;
    }

    /**
     * 生成节点数据
     *
     * @param prpTmainDto 投保单主要信息
     * @return
     * @date: 2018/4/9 11:10
     * @author: 何伟东
     */
    private void generateNodeData(PrpTmainDto prpTmainDto,String saveFlag) throws Exception {
        String stepCode = NodeType.ADD_PROPOSAL_NODE;
        String stateCode = NodeState.PROCESSED;
        String resultCode = NodeResultCode.PROPOSAL_SAVE;
        // 暂存
        if (TEMPORARY_SAVE.equals(saveFlag)) {
            stateCode = NodeState.PROCESSING;
            resultCode = NodeResultCode.PROPOSAL_SAVE_TEMP;
        }
        // 修改
        else if (MODIFY.equals(saveFlag)) {
            stateCode = NodeState.PROCESSING;
            stepCode = NodeType.MODIFY_PROPOSAL_NODE;
            resultCode = NodeResultCode.PROPOSAL_MODIFY_SAVE;
        }
        ProcessDto processDto = new ProcessDto.Builder()
                .stepCode(stepCode)
                .stateCode(stateCode)
                .bizCode(prpTmainDto.getProposalNo())
                .inflowTime(new Date())
                .opCode(prpTmainDto.getOperatorCode())
                .opName(prpTmainDto.getOperatorName())
                .opTime(prpTmainDto.getOperateDate())
                .resultCode(resultCode)
                .build();
        processApi.generateNodeData(processDto);
    }

    /**
     * 回写客户信息
     *
     * @param appliInsuredDto 投保投保人信息
     * @return
     * @date: 2018-05-21 15:16
     * @author: 何伟东
     */
    public void UpdateCustomerInfo(AppliInsuredDto appliInsuredDto) {
        try {
            if (appliInsuredDto != null && StringUtils.isNotEmpty(appliInsuredDto.getProposalNo())) {
                String proposalNo = appliInsuredDto.getProposalNo();
                List<InsureMainListDto> insureMainListDtos = insureMainListApi.queryByProposalNo(proposalNo);
                if (insureMainListDtos != null && insureMainListDtos.size() > 0) {
                    InsureMainListDto insureMainListDto = insureMainListDtos.get(0);
                    String gisInsureListCode = insureMainListDto.getGisInsureListCode();
                    Integer serialNo = insureMainListDto.getSerialNo();
                    Map<String, String> param = new HashMap<>();
                    param.put("gisInsureMainListCode", gisInsureListCode);
                    param.put("serialNo", Integer.toString(serialNo));
                    GisInsureMainListDto gisInsureMainListDto = gisInsureListApi.queryByPk(param);
                    String listType = gisInsureMainListDto.getListType();
                    String certificateName = appliInsuredDto.getCertificateName();
                    BankInfo bankInfo = BankInfo.newBankInfo()
                            .farmCode(certificateName)// 客户代码
                            .fidType(appliInsuredDto.getIdentifyType())// 证件类型
                            .fidCard(appliInsuredDto.getIdentifyNumber())// 证件号码
                            .fPhone(appliInsuredDto.getMobile())// 联系手机
                            .bankType("")// 开户银行大类
                            .bank(appliInsuredDto.getBank())// 开户银行
                            .bankNo(appliInsuredDto.getAccount())// 银行卡号
                            .build();
                    updateCustomerInfoService.sendGis(certificateName, listType, bankInfo);
                }
            }
        } catch (Exception e) {
            LOGGER.error("更新客户信息到金禾系统失败!{}", e.getMessage());
        }
    }
}
