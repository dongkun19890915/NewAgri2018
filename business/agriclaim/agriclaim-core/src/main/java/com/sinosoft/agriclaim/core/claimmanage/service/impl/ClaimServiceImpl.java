package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompeQueryInDto;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLDocDto;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.ReCaseXMLCommitDto;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLAccIPersonDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLextDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatusKey;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLext;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.core.cetainmanage.dao.PrpLPropDao;
import com.sinosoft.agriclaim.core.cetainmanage.entity.PrpLProp;
import com.sinosoft.agriclaim.core.claimmanage.dao.*;
import com.sinosoft.agriclaim.core.claimmanage.entity.*;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimService;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimViewService;
import com.sinosoft.agriclaim.core.common.enums.AgriclaimWorkProcessEnum;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.common.utils.StringConvert;
import com.sinosoft.agriclaim.core.compensatemanage.service.CompensateService;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLDocDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrpLDoc;
import com.sinosoft.agriclaim.core.prepaymanage.dao.PrpLPrepayDao;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.recasemanage.service.PrpLRecaseService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistRPolicyDao;
import com.sinosoft.agriclaim.core.registmanage.entity.*;
import com.sinosoft.agriclaim.core.registmanage.service.PageInitCommonService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfFlowMainDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMain;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfFlowMainKey;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.agriclaim.core.workflowmanage.service.impl.WorkFlowServiceImpl;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPmainApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCvirturlItemApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCdangerCoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.Str;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiCodeTransferApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.RiskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingSettleListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.SettleMainListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RegisterCoderDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.ValidityAndPKDto;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description 立案服务实现类
 * @author 杨航
 * @date 2017年11月13日
 */
@Service
public class ClaimServiceImpl extends BaseCustomServiceImpl implements ClaimService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClaimServiceImpl.class);

    @Autowired
    private PrpLClaimDao prpLClaimDao;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    @Autowired
    private PageInitCommonService pageInitCommonService;
    @Autowired
    private com.sinosoft.ims.api.kernel.PrpDriskConfigApi prpDriskConfigApi;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpLclaimStatusDao prpLclaimStatusDao;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private ClaimViewService claimViewService;
    @Autowired
    private UserApi userApi;
    @Autowired
    private CompanyApi companyApi;
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private UtiCodeTransferApi utiCodeTransferApi;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpPmainApi prpPmainApi;
    @Autowired
    private PrpPheadApi prpPheadApi;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpLPropDao prpLPropDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private WorkFlowServiceImpl workFlowServiceImpl;
    @Autowired
    private PrpLRegistRPolicyDao prpLRegistRPolicyDao;
    @Autowired
    private PrpLCompensateEarDao prpLCompensateEarDao;
    @Autowired
    private PrpLLTextDao prpLLTextDao;
    @Autowired
    private PrpLClaimLossDao prpLClaimLossDao;
    @Autowired
    private PrpLEarDao prpLEarDao;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private SettleMainListApi settleMainListApi;
    @Autowired
    private PrpLDocDao prpLdocDao;
    @Autowired
    private PrpLClaimFeeDao prpLclaimFeeDao;
    @Autowired
    private PrpLClaimLossDao prpLclaimLossDao;
    @Autowired
    private PrpLAccIPersonDao prpLAccIPersonDao;
    @Autowired
    private PrpLRegistExtDao prpLregistExtDao;
    @Autowired
    private PrpLextDao prpLextDao;
    @Autowired
    private PrpLPrepayDao prpLprepayDao;
    @Autowired
    private PlantingSettleListApi plantingSettleListApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private WorkProcessService workProcessService;
    @Autowired
    private RiskApi riskApi;
    @Autowired
    private CompensateService compensateService;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private PrpLDangerUnitDao prpLDangerUnitDao;
    @Autowired
    private PrpLDangerItemDao prpLDangerItemDao;
    @Autowired
    private PrpLDangerTotDao prpLDangerTotDao;
    @Autowired
    private PrpLDangerCoinsDao prpLDangerCoinsDao;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private PrpCvirturlItemApi prpCvirturlItemApi;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;
    @Autowired
    private SwfFlowMainDao swfFlowMainDao;
    @Autowired
    private PrpLRecaseService prpLRecaseService;
    @Autowired
    private PrpDuserApi prpDuserApi;
    /**
     * @param prpLClaimDto 立案信息对象
     * @return prpLClaimDtoList 立案基本信息集合对象
     * @description 承保需要的服务, 根据条件查询立案信息主表
     * @author 杨航
     * @date 2017年11月13日 下午7:40:23
     */
    public List<PrpLClaimDto> queryPrpLClaimByCondition(PrpLClaimDto prpLClaimDto) {
        if (prpLClaimDto == null) {
            throw new DataVerifyException("查询报案信息主表入参不许为空!");
        } else if (StringUtils.isEmpty(prpLClaimDto.getPolicyNo()) && StringUtils.isEmpty(prpLClaimDto.getClaimNo())) {
            throw new DataVerifyException("查询报案信息主表保单号和立案号不允许同时为空!");
        }
        List<PrpLClaim> prpLClaimList = prpLClaimDao.findAll(Specifications.<PrpLClaim>and()
                .eq(StringUtils.isNotEmpty(prpLClaimDto.getPolicyNo()), "policyNo", prpLClaimDto.getPolicyNo())
                .eq(StringUtils.isNotEmpty(prpLClaimDto.getClaimNo()), "claimNo", prpLClaimDto.getClaimNo()).build());
        List<PrpLClaimDto> prpLClaimDtoList = new ArrayList<PrpLClaimDto>();
        this.convertCollection(prpLClaimList, prpLClaimDtoList, PrpLClaimDto.class);
        return prpLClaimDtoList;
    }

    /**
     * @return responseDto
     * @throws Exception
     * @description:方法功能简述: 立案页面初始化服务接口
     * @author 安齐崇
     * @date 2017年11月16日下午2:25:58
     */
    @Override
    public ClaimPageInitResDto
    claimPageInit(ClaimPageInitReqDto requestDto) throws Exception {
        this.verifyParam(requestDto);
        String registNo = requestDto.getRegistNo();
        /* 立案号，立案后查询必传 */
        String claimNo = requestDto.getClaimNo();
        /* 编辑类型ADD,EDIT,SHOW */
        String editType = requestDto.getEditType();
        /* 把请求信息设置到返参类 */
        ClaimPageInitResDto responseDto = this.convert(requestDto, ClaimPageInitResDto.class);
        /* 设置登录用户信息 */
        this.setUserInfo(responseDto);
        String riskCode = null;
        String policyNo = null;
        /* 通过报案号或立案号查询险种号，并对报案信息或立案信息进行存在性校验 */
        if (StringUtils.isBlank(claimNo)) {
            PrpLRegist prplregist = prpLRegistDao.findOne(new PrpLRegistKey(registNo));
            if (prplregist == null) {
                /* 校验传入的报案号是否有效 */
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("不存在报案号为{}报案信息，请核对！", registNo);
                }
                throw new BusinessException(BusinessException.DataVerifyCatalog, "不存在报案号为" + registNo + "报案信息，请核对！");
            }
            /* 如果查询到报案信息，从报案信息中得到险种编码，否则从立案中获取 */
            riskCode = prplregist.getRiskCode();
            policyNo = prplregist.getPolicyNo();
            responseDto.setPrpLRegistDto(this.convert(prplregist, PrpLRegistDto.class));
        } else {
            PrpLClaim prpLClaim = prpLClaimDao.findOne(new PrpLClaimKey(claimNo));
            if (prpLClaim == null) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("不存在立案号为{}的立案信息，请核对！", claimNo);
                }
                throw new BusinessException(BusinessException.DataVerifyCatalog, "不存在立案号为" + claimNo + "的立案信息，请核对！");
            }
            riskCode = prpLClaim.getRiskCode();
            policyNo = prpLClaim.getPolicyNo();
            /* 这样做后面再用就不用查询数据库了 */
            responseDto.setPrpLClaimDto(this.convert(prpLClaim, PrpLClaimDtoExt.class));
        }
        responseDto.setRiskCode(riskCode);
        responseDto.setPolicyNo(policyNo);
        String riskType = pageInitCommonService.findRiskTypeByCode(riskCode);
        responseDto.setRiskType(riskType);
        /* 如果是ADD编辑类型，校验是否可以立案 */
        if ("ADD".equals(editType)) {
            this.verifyClaim(responseDto);
        }
        /* 如果是养殖险 */
        if ("I".equals(riskType)) {
            claimViewService.prepareCompensateEar(responseDto);
        }
        if ("H".equals(riskType)) {
            claimViewService.prepareDangerUnit(responseDto);
        }
        claimViewService.prepareCommonHead(responseDto);
        claimViewService.prepareCommonClaimLoss(responseDto);
        this.prepareCommon(responseDto);
        /* 格式化返参和暂存提交格式一致 */
        formatData(responseDto);
        responseDto.setPrpCmainDto(null);
        responseDto.setPrpLRegistDto(null);
        if(responseDto.getPrpLclaimLossDtoList() == null){
            responseDto.setPrpLclaimLossDtoList(new ArrayList<>());
        }
         responseDto.setNodeType("claim");
//        if (StringUtils.isNotEmpty(responseDto.getPrpLClaimDto().getLossName())){
//            List<String> list =new ArrayList<>();
//            list.add(responseDto.getPrpLClaimDto().getLossName());
//            QueryItemCodePmsDto queryItemCodePmsDto=new QueryItemCodePmsDto();
//            queryItemCodePmsDto.setRiskCode(responseDto.getRiskCode());
//            queryItemCodePmsDto.setItemCodeList(list);
//            String lossName = prpDitemAgriApi.queryItemName(queryItemCodePmsDto).get(0).getItemCName();
//            responseDto.getPrpLClaimDto().setLossCode(lossName);
//        }
        PrpLRegist prpLRegist = prpLRegistDao.findByRegistNo(registNo);
        responseDto.getPrpLClaimDto().setLossCode(prpLRegist.getLossCode());

        /** 获取危险单位信息 */
        Map<String,String> map = new HashMap<>();
        map.put("policyNo",policyNo);
        map.put("riskCode",riskCode);
        map.put("flag","2");
        List<PrpCvirturlItemDto> prpCvirturlItemDtoList = prpCvirturlItemApi.queryVirturlItemByPolicyNo(map);
        if (prpCvirturlItemDtoList.size()>0 && StringUtils.isNotEmpty(claimNo)){
            DangerUnitBackDto dangerUnitBackDto =this.queryClaimDangerUnit(claimNo,prpCvirturlItemDtoList.get(0).getKindCode());
            if (dangerUnitBackDto != null){
                responseDto.setDangerUnitBackDto(dangerUnitBackDto);
            }
        }
        return responseDto;
    }

    /**
     * @description:方法功能简述:格式化返参和暂存提交格式一致
     * @author 安齐崇
     * @date 2017年12月12日下午12:37:34
     * @param responseDto
     */
    private void formatData(ClaimPageInitResDto responseDto) {
        PrpLclaimStatus prpLclaimStatus = prpLclaimStatusDao
                .findOne(new PrpLclaimStatusKey(responseDto.getClaimNo(), "claim", 0));
        PrpLclaimStatusDto claimStatusDto = new PrpLclaimStatusDto();
        claimStatusDto.setStatus(prpLclaimStatus == null ? "1" : prpLclaimStatus.getStatus());
        List<PrpLLTextDto> prpLLTextDtoList = responseDto.getPrpLLTextDtoList();
        StringBuffer context = new StringBuffer();
        if (prpLLTextDtoList != null && prpLLTextDtoList.size() > 0) {
            for (PrpLLTextDto prpLLTextDto : prpLLTextDtoList) {
                context.append("  ");
                context.append(prpLLTextDto.getContext());
                context.append("\t");
            }
        }
        responseDto.setContext(context.toString());
        responseDto.setPrpLclaimStatusDto(claimStatusDto);
    }
    /**
     * @param responseDto
     * @throws Exception
     * @description:方法功能简述: 完善公共信息，如赔付数量对应的单位信息，机构名称，缴费情况
     * @author 安齐崇
     * @date 2017年11月27日上午9:31:02
     */
    private void prepareCommon(ClaimPageInitResDto responseDto) throws Exception {
        PrpCmainDto prpCmainDto = responseDto.getPrpCmainDto();
        // 取被保险人名称，对于团单需要显示名称
        String strInsuredNameShow = "";
        int insureQuantity = prpCmainDto.getSumQuantity();
        if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
                || insureQuantity <= 1) {
            strInsuredNameShow = prpCmainDto.getInsuredName();
        } else {
            strInsuredNameShow = prpCmainDto.getInsuredName() + "等" + insureQuantity + "人";
        }
		/* 设置共保股东分红业务标志 */

        responseDto.setCoinsFlag(prpCmainDto.getCoinsFlag());
        responseDto.setShareHolderFlag(prpCmainDto.getShareholderFlag());
        responseDto.getPrpLClaimDto().setInsuredNameShow(strInsuredNameShow);
        changeCodeToName(responseDto.getPrpLClaimDto());
		/* 已出险次数 */
        int perilCount = pageInitCommonService.getSamePolicyRegistInfo(responseDto.getPolicyNo(),
                responseDto.getRegistNo());
        responseDto.setPerilCount(perilCount + "");
		/* 设置赔付数量等对应的单位信息 */
        // List<PrpDcodeDto> units =
        // pageInitCommonService.getUnit(responseDto.getRiskCode());
        // responseDto.setUnitList(units);
        int intPayFee = pageInitCommonService.checkPay(responseDto.getPolicyNo());
		/* 缴费状态 */
        responseDto.setPayFeeFlag(intPayFee);
        /* 险种名称 */
        PrpDriskDto prpDriskDto = riskApi.queryriskByPK(responseDto.getRiskCode());
        responseDto.setRiskName(prpDriskDto.getRiskCName());
		/* 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴 */
        String delinquentfeeCase = "";
		/* 若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴 */
        if (intPayFee == -2 && prpCmainDto.getPayTimes() > 1) {
            delinquentfeeCase = pageInitCommonService.getDelinquentfeeCase(prpCmainDto);
        }
        responseDto.setDelinquentfeeCase(delinquentfeeCase);
        this.checkRule(prpCmainDto, responseDto);
    }

    /**
     * @param prpCMain 保单对象
     * @return pageDto 封装数据的对象
     * @description:方法功能简述:校验是否在保险期间内，缴费情况
     * @author 安齐崇
     * @date 2017年11月15日下午12:25:03
     */
    private void checkRule(PrpCmainDto prpCMain, ClaimPageInitResDto pageDto) {
        int checkPay = pageDto.getPayFeeFlag();
        if ("null".equals(pageDto.getMessage()) || StringUtils.isEmpty(pageDto.getMessage())) {
            pageDto.setMessage("");
        }
        if (checkPay != 1) {
            if (checkPay == -1) {
                pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage()) ? "</br>"
                        : "" + pageDto.getMessage() + "保费未缴，请谨慎处理！");
            } else if (checkPay == -2) {
                pageDto.setMessage(StringUtils.isNotBlank(pageDto.getMessage()) ? "</br>"
                        : "" + pageDto.getMessage() + "保费未缴全，请谨慎处理！");
            }
        }
    }

    /**
     * @param prpLClaimDtoExt
     * @throws Exception
     * @description:方法功能简述: 编码转换
     * @author 安齐崇
     * @date 2017年12月4日下午7:02:10
     */
    private void changeCodeToName(PrpLClaimDtoExt prpLClaimDtoExt) throws Exception {
		/* (1)条款名称的转换 */
        String clauseType = prpLClaimDtoExt.getClauseType();
        String clauseName = "";
        prpLClaimDtoExt.setClauseName(clauseName);
		/* (2)对业务归属结构进行转换 */
        String comCode = prpLClaimDtoExt.getComCode();
        PrpDcompanyDto companyDto = companyApi.queryCompanyByComCode(comCode);
        prpLClaimDtoExt.setComName(companyDto == null ? "" : companyDto.getComCName());
		/* (3)对归属业务员进行转换 */
        String handler1Code = prpLClaimDtoExt.getHandler1Code();
        PrpDuserDto userInfo = userApi.queryUserInfo(handler1Code);
        prpLClaimDtoExt.setHandler1Name(userInfo == null ? "" : userInfo.getUserName());
		/* (4)对代理人进行转换 */
        String agentCode = prpLClaimDtoExt.getAgentCode();
        PrpDuserDto agentInfo = null;
        if (agentCode != null) {
            agentInfo = userApi.queryUserInfo(agentCode);
        }
        prpLClaimDtoExt.setAgentName(agentInfo == null ? "" : agentInfo.getUserName());
		/* (5)对经办人进行转换 */
        String handlerCode = prpLClaimDtoExt.getHandlerCode();
        PrpDuserDto handlerInfo = userApi.queryUserInfo(handlerCode);
        prpLClaimDtoExt.setHandlerName(handlerInfo == null ? "" : handlerInfo.getUserName());

		/* (6)对案件性质进行转换 */
        String strClaimType = prpLClaimDtoExt.getClaimType();
        if (strClaimType == null) {
            strClaimType = "";
        }
		/*
		 * String strClaimTypeName =
		 * codeApi.transCodeCodeReturnCodeName("CaseCode", strClaimType, true);
		 * prpLClaimDtoExt.setClaimTypeName(strClaimTypeName);
		 */

		/* (7)对业务类型进行转换 */
		/*
		 * String strBusinessNature = prpLClaimDtoExt.getBusinessNature();
		 * String strBusinessNatureName =
		 * codeApi.transCodeCodeReturnCodeName("BusinessNature",
		 * strBusinessNature, true);
		 * prpLClaimDtoExt.setBusinessNatureName(strBusinessNatureName);
		 */
		/* (8)对makeCom报案登记部门进行转换 */
        String makeCom = prpLClaimDtoExt.getMakeCom();
        PrpDcompanyDto makeComDto = companyApi.queryCompanyByComCode(makeCom);
        prpLClaimDtoExt.setMakeComName(makeComDto == null ? "" : makeComDto.getComCName());
		/* (9)接报案员转换 */
        String operatorCode = prpLClaimDtoExt.getOperatorCode();
        PrpDuserDto operatorInfo = userApi.queryUserInfo(operatorCode);
        prpLClaimDtoExt.setOperatorName(operatorInfo == null ? "" : operatorInfo.getUserName());
    }

    /**
     * @param
     * @return
     * @throws Exception
     * @description:方法功能简述: 当编辑类型是ADD时，即初次立案时，需要对是否符合立案条件进行校验
     * @author 安齐崇
     * @date 2017年11月25日下午1:19:10
     * @throw Exception
     */
    private void verifyClaim(ClaimPageInitResDto responseDto) throws Exception {
		/* 前面已经设置过，不用查数据库了 */
        PrpLRegistDto prplRegistDto = responseDto.getPrpLRegistDto();
        int checkPay = pageInitCommonService.checkPay(responseDto.getPolicyNo());
		/* 获取保费未实收是否立案信息 */
        String configValue = "";
        PrpDriskConfigDto configDto = prpDriskConfigApi.queryByPK("00000000", responseDto.getRiskCode(),
                "ALLOW_UNPAYED_CLAIM");
        configValue = configDto == null ? null : configDto.getConfigValue();
		/* 报案出险延期天数 */
        PrpDriskConfigDto dealyConfigDto = prpDriskConfigApi.queryByPK("00000000", responseDto.getRiskCode(),
                "REPORT_DEFER_DAYS");

        String standard_stringDays = dealyConfigDto == null ? null : dealyConfigDto.getConfigValue();
        if (configValue == null || configValue.equals("")) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("请联系系统管理员，在平台配置系统中进行险种{}保费未实收是否允许立案'的初始化！", responseDto.getRiskCode());
            }
            throw new BusinessException(BusinessException.BusinessCatalog,
                    "请联系系统管理员，在平台配置系统中进行险种" + responseDto.getRiskCode() + "保费未实收是否允许立案'的初始化！");
        }
        if (standard_stringDays == null || standard_stringDays.equals("")) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("请联系系统管理员，在平台配置系统中进行险种{}报案出险延期天数'的初始化！", responseDto.getRiskCode());
            }
            throw new BusinessException(BusinessException.BusinessCatalog,
                    "请联系系统管理员，在平台配置系统中进行险种" + responseDto.getRiskCode() + "报案出险延期天数'的初始化！");
        }
        long standard_days = Long.parseLong(standard_stringDays);
		/* 如果configValue =2 intReturn！=1则表示未交费不能立案 */
        if (configValue.equals("2") && checkPay != 1) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("根据业务规则险种{}保费未缴不能立案", responseDto.getRiskCode());
            }
            throw new BusinessException(BusinessException.BusinessCatalog,
                    "根据业务规则险种" + responseDto.getRiskCode() + "保费未缴不能立案");
        }
		/* 判断报案出险延期天数是否大于系统规定时间，大于不允许立案 */
		DateTime damageDate = new DateTime(prplRegistDto.getDamageStartDate());
		DateTime reportDate = new DateTime(prplRegistDto.getReportDate());
		long report_damage_days = (reportDate.getTime() - damageDate.getTime()) / (1000 * 60 * 60 * 24);
		/* 获取系统规定时间 standard_days */
        if (report_damage_days > standard_days) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("报案号为{}报案出险延期天数大于系统规定时间，不允许立案！", responseDto.getRegistNo());
            }
            throw new BusinessException(BusinessException.BusinessCatalog, "报案出险延期天数大于系统规定时间，不允许立案！");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("policyNo", responseDto.getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
        if (prpCmainDto == null) {
            throw new BusinessException("未查询到保单号为{}的保单信息", responseDto.getPolicyNo());
        }
		/* 出险时间不在保险期间内的案件，报案时系统进行提示，立案时硬控制，走拒赔或特殊案件流程。 */
        if (damageDate.before(prpCmainDto.getStartDate()) || damageDate.after(prpCmainDto.getEndDate())) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("报案号为{}出险时间不在保险期间内，不允许立案！", responseDto.getRegistNo());
            }
            throw new BusinessException(BusinessException.BusinessCatalog, "出险时间不在保险期间内，不允许立案！");
        }
        Specification<PrpLClaim> specification = Specifications.<PrpLClaim>and()
                .eq("registNo", responseDto.getRegistNo()).eq("riskCode", responseDto.getRiskCode()).build();
        List<PrpLClaim> claimList = prpLClaimDao.findAll(specification);
		/* claimList不为空说明查询到该报案已经立过案了 */
        if (claimList.size() > 0) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("报案号为{}的报案已立案！", responseDto.getRegistNo());
            }
            throw new BusinessException(BusinessException.BusinessCatalog,
                    "报案号为" + responseDto.getRegistNo() + "的报案已立案！");
        }
		/* 报案提交状态的案件才可立案 */
        PrpLclaimStatus claimStatus = prpLclaimStatusDao
                .findOne(new PrpLclaimStatusKey(responseDto.getRegistNo(), "regist", 0));
        if (claimStatus != null) {
            if (!claimStatus.getStatus().equals("4")) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("报案号为{}的案件不是报案提交状态，不能立案！", responseDto.getRegistNo());
                }
                throw new BusinessException(BusinessException.BusinessCatalog,
                        "报案号为" + responseDto.getRegistNo() + "的案件不是报案提交状态，不能立案！");
            }
        }
		/* 获取系统设置信息：立案天数 */
        String standardDays = ""; // 获取立案天数
        PrpDriskConfigDto standardDaysDto = prpDriskConfigApi.queryByPK("00000000", responseDto.getRiskCode(),
                "CLAIM_DAYS");
        standardDays = standardDaysDto == null ? null : standardDaysDto.getConfigValue();
        if (standardDays == null || standardDays.equals("")) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("请联系系统管理员，在平台配置系统中进行险种{}立案天数'的初始化！", responseDto.getRiskCode());
            }
            throw new BusinessException(BusinessException.BusinessCatalog,
                    "请联系系统管理员，在平台配置系统中进行险种" + responseDto.getRiskCode() + "'立案天数'的初始化！");
        }
        DateTime currentDate = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY);
        Date registDate = prplRegistDto.getReportDate();

        long current_regist = (currentDate.getTime() - registDate.getTime()) / (1000 * 60 * 60 * 24);

        if (current_regist >= Integer.parseInt(standardDays)) {
            responseDto.setClaimDays("0");
        } else {
            responseDto.setClaimDays("1");
        }
		/* 可以做立案了 */
		/* 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。 */
		/* 如果没有flowID和logno则不进行判断 */
		/* 模板号 */
        Integer modeNo;
        String swfLogFlowID = responseDto.getFlowId();
        String swfLogLogNo = responseDto.getLogNo();
        if (StringUtils.isNotBlank(swfLogFlowID)) {
            modeNo = workFlowService.getModelNo(responseDto.getRiskCode(), prplRegistDto.getComCode());
            if (modeNo.equals(1) || modeNo.equals(12) || modeNo.equals(14) || modeNo.equals(87)) {
                List<SwfLogDto> noSubmitNodesList = swfLogDao.findNodesByConditions(swfLogFlowID, "sched");
                if (noSubmitNodesList.size() < 1) {
					/* 完成调度任务 */
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("工作流{}调度环节没有结束，不能进行立案！", swfLogFlowID);
                    }
                    throw new BusinessException(BusinessException.BusinessCatalog,
                            "工作流" + swfLogFlowID + "调度环节没有结束，不能进行立案！");
                }
            }
            if (StringUtils.isNotBlank(swfLogLogNo)) {
                pageInitCommonService.verifyIsHoldNode(responseDto.getFlowId(), responseDto.getLogNo(),
                        responseDto.getUserCode(), responseDto.getUserName(), responseDto.getClaimNo());
            }
        }
    }

    /**
     * @param
     * @return
     * @description:方法功能简述: 校验数据的合法性
     * @author 安齐崇
     * @date 2017年11月24日下午5:19:13
     * @throw Exception
     */
    private void verifyParam(ClaimPageInitReqDto requestDto) {
        if (requestDto == null) {
            throw new DataVerifyException("请求参数不能为空!");
        }
        if ("ADD".equals(requestDto.getEditType())) {
            if (StringUtils.isEmpty(requestDto.getRegistNo())) {
                throw new DataVerifyException(requestDto.getEditType() + "编辑类型报案号不能为空！");
            }
        } else if ("EDIT".equals(requestDto.getEditType()) || "SHOW".equals(requestDto.getEditType())) {
            if (StringUtils.isEmpty(requestDto.getClaimNo())) {
                throw new DataVerifyException(requestDto.getEditType() + "编辑类型立案号不能为空！");
            }
        } else {
            throw new DataVerifyException(requestDto.getEditType() + "编辑类型不合法，请核对!");
        }
    }

    /**
     * @param responseDto 返回对象
     * @description:方法功能简述: 设置登录用户信息到返回对象
     * @author 安齐崇
     * @date 2017年11月16日上午10:53:43
     */
    private void setUserInfo(ClaimPageInitResDto responseDto) {
		/* 设置用户信息 */
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
        responseDto.setUserCode(userCode);
        responseDto.setUserName(userInfo == null ? "" : userInfo.getUserName());
        responseDto.setComCode(userInfo == null ? "" : userInfo.getComCode());
    }

    /**
     * @param prpLClaimQueryInDto 查询入参对象
     * @return pageInfo 工作流主表信息大对象
     * @description 立案查询入口
     * @author 闫磊
     * @date 2017年11月24日
     */
    @Override
    public PageInfo<SwfLogExtendDto> queryByClaimInDto(PrpLClaimQueryInDto prpLClaimQueryInDto) throws Exception {
        if (prpLClaimQueryInDto == null) {
            throw new BusinessException("prpLClaimQueryInDto对象不允许为null");
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.error(
                        "registNo={},policyNo={},insuredName={},riskCode={},nodeStatus={},flowInTimeStart={},operatorCode={}",
                        prpLClaimQueryInDto.getRegistNo(), prpLClaimQueryInDto.getPolicyNo(),
                        prpLClaimQueryInDto.getInsuredName(), prpLClaimQueryInDto.getRiskCode(),
                        prpLClaimQueryInDto.getNodeStatus(), prpLClaimQueryInDto.getFlowInTimeStart(),
                        prpLClaimQueryInDto.getHandlerCode());
            }
        }
        PageInfo<SwfLogExtendDto> pageInfo = new PageInfo<>();
        Integer pageNo = prpLClaimQueryInDto.getPageNo();
        Integer pageSize = prpLClaimQueryInDto.getPageSize();
        if (pageNo < 1) {
            throw new BusinessException("页码不能小于1");
        }
        if (pageSize < 1) {
            throw new BusinessException("每页数量不能小于1");
        }
        Long totalSizeStrLon = null;
        String conditions = "";
        String conditionsCount = "";
        Map<String, Object> paraMap = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(prpLClaimQueryInDto.getNodeStatus()) && ("8".equals(prpLClaimQueryInDto.getNodeStatus()) || "9".equals(prpLClaimQueryInDto.getNodeStatus()))) {
             pageInfo = compensateService.queryCompensateCancelList(this.convert(prpLClaimQueryInDto, PrpLCompeQueryInDto.class));
             return pageInfo;
        }else {
        }
        conditions = getNodeConditionsByNodeNo(prpLClaimQueryInDto, "query", paraMap);
        conditionsCount = getNodeConditionsByNodeNo(prpLClaimQueryInDto, "count", paraMap);
        Query agentQuery = entityManager.createNativeQuery(conditions.replaceFirst("(?i)1=1 and "," "),SwfLog.class);
        Query agentQueryCount = entityManager.createNativeQuery(conditionsCount.replaceFirst("(?i)1=1 and "," "));
        for (String key : paraMap.keySet()) {
            agentQuery.setParameter(key, paraMap.get(key));
            agentQueryCount.setParameter(key, paraMap.get(key));
        }
        totalSizeStrLon = new BigInteger(agentQueryCount.getSingleResult().toString()).longValue();
        if (pageNo != null) {
            agentQuery.setFirstResult((pageNo.intValue() - 1) * pageSize.intValue());
        }
        if (pageSize != null) {
            agentQuery.setMaxResults(pageSize.intValue());
        }
        List<SwfLog> swfLogList = agentQuery.getResultList();
        List<SwfLogDto> swfLogDto = new ArrayList<>();
        this.convertCollection(swfLogList, swfLogDto, SwfLogDto.class);
        List<SwfLogExtendDto> swfLogExtendDto = new ArrayList<>(swfLogDto.size());
        for (int n = 0; n < swfLogDto.size(); n++) {
            SwfLogExtendDto swfLogExtendDtoNew = new SwfLogExtendDto();
            swfLogExtendDtoNew.setSwfLogDto(swfLogDto.get(n));
            // 根据险种代码转换中文名称
            Map<String, String> riskcodeMap = new HashMap<String, String>();
            riskcodeMap.put("riskCode", swfLogDto.get(n).getRiskCode());
            riskcodeMap.put("isChinese", LanguageFlagConstant.CHINESE);
            String riskName = prpDriskApi.translateCode(riskcodeMap);
            swfLogExtendDtoNew.setRiskName(riskName);
            // 根据报案号查询受损标的名称
            Query lossNameQuery = entityManager.createNativeQuery(
                    "select lossName from PrpLRegist where registNo = '" + swfLogDto.get(n).getRegistNo() + "'");
            String lossName = "";
            if (lossNameQuery.getResultList().size() > 0) {
                lossName = (String) lossNameQuery.getSingleResult();
            }
            swfLogExtendDtoNew.setLossName(lossName);
            // 根据报案号查询立案号
            Query claimQuery = entityManager.createNativeQuery(
                    "select claimNo from PrpLClaim where registNo = '" + swfLogDto.get(n).getRegistNo() + "'");
            String claimNo = "";
            if (claimQuery.getResultList().size() > 0) {
                claimNo = (String) claimQuery.getSingleResult();
            }
            List<PrpLClaim> byRegistNo = prpLClaimDao.findByRegistNo(swfLogDto.get(n).getRegistNo());
            String flag=null;
            if(byRegistNo.size()>0&&byRegistNo!=null){
                flag=byRegistNo.get(0).getCaseType();
            }
            swfLogExtendDtoNew.setFlag(flag);
            swfLogExtendDtoNew.setClaimNo(claimNo);
            swfLogExtendDto.add(swfLogExtendDtoNew);
        }
        /*if ("all".equals(prpLClaimQueryInDto.getNodeStatus())){
            swfLogExtendDto.addAll(compensateService.queryCompensateCancelList(this.convert(prpLClaimQueryInDto,PrpLCompeQueryInDto.class)).getContent());
        }*/
        // 数据存放dto集合
        pageInfo.setContent(swfLogExtendDto);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(totalSizeStrLon);
        return pageInfo;
    }

    /**
     * @param prpLClaimQueryInDto 入参对象
     * @param flag                查询参数
     * @return string 拼接完成的SQL
     * @description 根据对象拼接SQL
     * @author 闫磊
     * @date 2017年11月15日
     */
    private String getNodeConditionsByNodeNo(PrpLClaimQueryInDto prpLClaimQueryInDto, String flag,
                                             Map<String, Object> paraMap) throws Exception {
        String policyNo = prpLClaimQueryInDto.getPolicyNo();
        String claimNo = prpLClaimQueryInDto.getClaimNo();
        String registNo = prpLClaimQueryInDto.getRegistNo();
        String insuredName = prpLClaimQueryInDto.getInsuredName();
        String flowInTimeStart = prpLClaimQueryInDto.getFlowInTimeStart();
        String flowInTimeEnd = prpLClaimQueryInDto.getFlowInTimeEnd() + " 23:59:59";
        String riskType = prpLClaimQueryInDto.getRiskType();
        String nodeStatus = prpLClaimQueryInDto.getNodeStatus();
        String nodeType = prpLClaimQueryInDto.getNodeType();
        String handlerCode = prpLClaimQueryInDto.getHandlerCode();
        StringBuilder stringBuilder = null;
        if ("query".equals(flag)) {
            stringBuilder = new StringBuilder("SELECT s.* from (select sw.* FROM SwfLog sw WHERE sw.nodeType = 'claim' union all select swf.* from swflogstore swf where swf.nodeType='claim' and swf.nodeStatus ='8') s where 1=1 ");
        } else if ("count".equals(flag)) {
            stringBuilder = new StringBuilder("SELECT count(1) from  (select sw.* FROM SwfLog sw WHERE sw.nodeType = 'claim' union all select swf.* from swflogstore swf where swf.nodeType='claim' and swf.nodeStatus ='8')s where 1=1 ");
        }
        this.addStringCondition("nodeType", nodeType, "=", stringBuilder, paraMap);
        // 根据案件类型以及当前处理人员拼接查询条件
        if (StringUtils.isNotEmpty(nodeStatus) && StringUtils.isNotEmpty(handlerCode)) {
            if ("2".equals(nodeStatus) || "4".equals(nodeStatus)) {
                this.addStringCondition("handlerCode", handlerCode, "=", stringBuilder, paraMap);
                if (StringUtils.isNotEmpty(registNo)) {
                    stringBuilder
                            .append(" and exists (select a.* from PrpLClaim a where a.claimNo in (select keyOut from SwfLog ) and a.registNo like '")
                            .append(registNo).append("%')");
                } else {
                    stringBuilder.append(" and exists (select a.* from PrpLClaim a where a.claimNo in (select keyOut from SwfLog ))");
                }
            } else {
                stringBuilder.append(
                        " and (s.handlerCode='" + handlerCode + "' or s.handlerCode is null or s.handlerCode='')");
            }
            if (!"all".equals(nodeStatus)) {
                this.addStringCondition("nodeStatus", nodeStatus, "", stringBuilder, paraMap);
            } else {
                //stringBuilder.append(" and (NodeStatus < '5') ");
            }
        } else {
            throw new BusinessException("当前操作人或者案件状态为空，查询失败");
        }
        if (StringUtils.isNotEmpty(registNo)) {
            stringBuilder.append(" and keyIn like '").append(registNo).append("%'");
        }
        if (StringUtils.isNotEmpty(claimNo)) {
            stringBuilder.append(" and keyOut like '").append(claimNo).append("%'");
        }
        this.addStringCondition("policyNo", policyNo, "*", stringBuilder, paraMap);
        this.addStringCondition("insuredName", insuredName, "*", stringBuilder, paraMap);
        if (StringUtils.isNotEmpty(riskType)) {
            stringBuilder.append(" and s.riskCode in ('");
            Map<String, String> riskCodeMap = new HashMap<String, String>();
            List<String> outerCodeList = new ArrayList<String>();
            if (!"I".equals(riskType) && !"H".equals(riskType)) {
                riskCodeMap.put("riskType", "I");
                List<UtiCodeTransferDto> dtoListI = utiCodeTransferApi.queryByRiskType(riskCodeMap);
                if (dtoListI.size() > 0) {
                    for (int s = 0; s < dtoListI.size(); s++) {
                        outerCodeList.add(dtoListI.get(s).getOuterCode());
                    }
                }
                riskCodeMap.replace("riskType", "H");
                List<UtiCodeTransferDto> dtoListH = utiCodeTransferApi.queryByRiskType(riskCodeMap);
                if (dtoListH.size() > 0) {
                    for (int s = 0; s < dtoListH.size(); s++) {
                        outerCodeList.add(dtoListH.get(s).getOuterCode());
                    }
                }
            } else {
                riskCodeMap.put("riskType", riskType);
                List<UtiCodeTransferDto> dtoList = utiCodeTransferApi.queryByRiskType(riskCodeMap);
                if (dtoList.size() > 0) {
                    for (int s = 0; s < dtoList.size(); s++) {
                        outerCodeList.add(dtoList.get(s).getOuterCode());
                    }
                }
            }
            if (outerCodeList != null && outerCodeList.size() > 0) {
                for (int i = 0; i < outerCodeList.size(); i++) {
                    if (i == outerCodeList.size() - 1) {
                        stringBuilder.append(outerCodeList.get(i));
                    } else {
                        stringBuilder.append(outerCodeList.get(i) + "','");
                    }
                }
            }
            stringBuilder.append("')");
        } else {
            throw new BusinessException("当前操作人或者案件状态为空，查询失败");
        }
        // 业务号为空时拼接工作流开始或者结束时间
        if (StringUtils.isEmpty(policyNo) && StringUtils.isEmpty(registNo) && StringUtils.isEmpty(claimNo)) {
//			stringBuilder.append(" and s.flowInTime between '").append(flowInTimeStart).append("' and '")
//					.append(flowInTimeEnd).append("' ");
            stringBuilder.append(" and flowInTime>=").append("'" + flowInTimeStart + "'").append(" and flowInTime<=")
                    .append("'" + flowInTimeEnd + "'");
        }
        // 工作流状态不能是关闭
        //stringBuilder.append(" and s.flowStatus <> '0' ");
        //

        // 未并案的案件
        stringBuilder.append(" and registNo not in (select registNo from PrpLCombine) ");
        // 新老系统数据区别标志
        stringBuilder.append(" and s.dataFlag is null ");
        stringBuilder.append(" and s.medicalTransitFlag is null ");
        if("query".equals(flag)){
            stringBuilder.append(" order by s.flowInTime desc");
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.error(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }

    /**
     * @throws Exception
     * @description sql参数(String)转换
     * @author 闫磊
     * @date 2017年10月20日 17:30:27
     */
    private void addStringCondition(String name, String value, String sign, StringBuilder strWhere,
                                    Map<String, Object> paraMap) throws Exception {
        if (value != null && !"".equals(value.trim())) {
            if (StringUtils.isNotEmpty(value)) {
                if ("*".equals(sign)) {
                    strWhere.append(" and s." + name + " like :" + name);
                    paraMap.put(name, value + "%");
                } else {
                    strWhere.append(" and s." + name + " = :" + name);
                    paraMap.put(name, value);
                }
            }
        }
    }


    /**
     * @param claimDto
     * @return 立案号
     * @description 立案的环节提交
     * @author yk
     * @date 2017年12月7日 下午4:12:33
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> saveClaim(ClaimDto1 claimDto) throws Exception{


        // 检验前端数据是否传全了
        if (claimDto.getPrpLClaimDto() == null || claimDto.getPrpLclaimStatusDto() == null) {
            throw new DataVerifyException("前端传送数据不全！！");
        }

        String comCode = claimDto.getPrpLClaimDto().getComCode();
        // 工作流号码
        String swfLogFlowID = claimDto.getFlowId();
        // 工作流logno
        String swfLogLogNo = claimDto.getLogNo();
        String riskCode = claimDto.getPrpLClaimDto().getRiskCode();
        String registNo = claimDto.getPrpLClaimDto().getRegistNo();
        String claimNo = claimDto.getClaimNo();
        int year = DateTime.current().getYear();

        // 获取立案号
        if (claimNo == null || claimNo.length() < 1) {
            String tableName = "prplclaim";
            try {
                String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
                BillNoDto billNoDto = new BillNoDto();
                billNoDto.setTableName(tableName);
                billNoDto.setRiskCode(riskCode);
                billNoDto.setiComCode(comCode);
                billNoDto.setiYear(new Integer(year).toString());
                billNoDto.setUserCode(userCode);

                claimNo = billNoApi.getBillNo(billNoDto).get("billNo");
                claimDto.setClaimNo(claimNo);
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("获取立案号：" + claimDto.getPrpLClaimDto().getPolicyNo() + "的报案号:========" + claimNo
                            + "========");
                }
            } catch (Exception e) {
                throw new BusinessException("生成立案号异常！！");
            }
        }


        // 回写表PrpLprop的立案号码
        List<PrpLProp> prpLpropList = prpLPropDao.findByRegistNo(registNo);
        if (prpLpropList != null && prpLpropList.size() > 0) {
            Iterator<PrpLProp> it = prpLpropList.iterator();
            while (it.hasNext()) {
                PrpLProp prpLProp = it.next();
                prpLProp.setClaimNo(claimNo);
            }
        }
        prpLPropDao.save(prpLpropList);

        // 对要保存的立案信息进行组装和修改
        claimDto = getClaimDto(claimDto);

        // 为获取工作流大对象做准备
        PrpLRegist prpLRegist = prpLRegistDao.findByRegistNo(registNo);
        PrpLRegistDto prpLRegistDto = convert(prpLRegist, PrpLRegistDto.class);
        claimDto.getPrpLClaimDto().setBusinessType(prpLRegistDto.getBusinessType());
        claimDto.getPrpLClaimDto().setBusinessType1(prpLRegistDto.getBusinessType1());
        claimDto.getPrpLClaimDto().setBusinessFlag(prpLRegistDto.getBusinessFlag());
        claimDto.getPrpLClaimDto().setOtherFlag(prpLRegistDto.getOtherFlag());
        String riskcode=claimDto.getPrpLClaimDto().getPolicyNo().substring(1,5);
        String classcode=claimDto.getPrpLClaimDto().getPolicyNo().substring(1,3);
        if("3224".equals(riskcode) || "3237".equals(riskcode) || "31".equals(classcode)){
            claimDto.getPrpLClaimDto().setDisasterUnit("11");
            claimDto.getPrpLClaimDto().setAffectedUnit("11");
            claimDto.getPrpLClaimDto().setNoProductionUnit("11");
        }else{
            claimDto.getPrpLClaimDto().setDeathUnit("13");
            claimDto.getPrpLClaimDto().setKillUnit("13");
        }
        if(claimDto.getPrpLClaimDto().getLossQuantity()==null){
            claimDto.getPrpLClaimDto().setLossQuantity(0);
        }
        WorkFlowDto workFlowDto = null;
        SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();

        String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
        String userComCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
        String userName = SinoRequestContext.getCurrentContext().getUser().getUserName();
        swfLogTransferDto.setUserUserCode(userCode);
        swfLogTransferDto.setUserComCode(userComCode);
        swfLogTransferDto.setUserUserName(userName);
        PrpDcompanyDto querPrpDcompanyDto = null;
        try {
            querPrpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
        } catch (Exception e) {
            throw new BusinessException("根据comCode查询querPrpDcompanyDto失败！！");
        }
        swfLogTransferDto.setUserComName(querPrpDcompanyDto.getComCName());
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        if (!(swfLogFlowID == null || "".equals(swfLogFlowID)) && !(swfLogLogNo == null || "".equals(swfLogLogNo))) {
            swfLogDtoDealNode.setFlowId(swfLogFlowID);
            swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
        }
        swfLogDtoDealNode.setNodeType("claim");
        swfLogDtoDealNode.setNodeStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        swfLogDtoDealNode.setBusinessNo(registNo);
        swfLogDtoDealNode.setComCode(comCode);
        swfLogTransferDto.setNextBusinessNo(claimNo);
        // 考虑 到后来几乎都是用clamno做keyin的数值的。。
        swfLogDtoDealNode.setKeyIn(claimNo);
        swfLogDtoDealNode.setKeyOut(claimNo);
        swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
        // 获取工作流大对象

        if ("1".equals(claimDto.getIfAuto())) {
            swfLogTransferDto.getSwfLogDto().setFlowId(swfLogFlowID);
            swfLogTransferDto.getSwfLogDto().setLogNo(4);
//            SwfLogDto swfLogDto = new SwfLogDto();
//            swfLogDto.setFlowId(swfLogFlowID);
//            swfLogDto.setLogNo(4);
//            //如果是种植险,则设置模板号为4
//            if ("1".equals(claimDto.getPrpLClaimDto().getRiskCode().substring(1,2))) {
//                swfLogDto.setModelNo(4);
//            }
//            //如果是养殖险,则设置模板号为2
//            if ("2".equals(claimDto.getPrpLClaimDto().getRiskCode().substring(1,2))) {
//                swfLogDto.setModelNo(2);
//            }
//            swfLogDto.setNodeNo(3);
//            swfLogDto.setNodeName("立案");
//            swfLogDto.setBusinessNo(registNo);
//            swfLogDto.setBeforeHandlerCode(userCode);
//            swfLogDto.setBeforeHandlerName(userName);
//            swfLogDto.setTimeLimit(0);
//            //reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
//            swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
//            swfLogDto.setNodeStatus("0");
//            swfLogDto.setFlowStatus("1");
//            swfLogDto.setPackageId("0");
//            swfLogDto.setTaskNo(0);
//            swfLogDto.setTaskType("S");
//            swfLogDto.setNodeType("claim");
//            List<SwfLogDto> swfFlowNodeList = new ArrayList<SwfLogDto>();
////		this.convertCollection(swfLogDao.findAllByFlowIDAndLogNo(flowId, Integer.parseInt(claimDto.getLogNo())), swfFlowNodeList, SwfLogDto.class);
//            List<SwfLog> swfLogList = swfLogDao.findByFlowIdOrderByLogNo(claimDto.getFlowId());
//            for (SwfLog swfLog : swfLogList) {
//                if (!"4".equals(swfLog.getNodeStatus())) {
//                    swfLog.setNodeStatus("4");
//                }
//            }
//            this.convertCollection(swfLogList, swfFlowNodeList, SwfLogDto.class);
//
//            SwfLogDto swfLogFunctionIn = convert(swfFlowNodeList.get(0), SwfLogDto.class);
//
//
//            int logMaxNo = swfLogFunctionIn.getLogNo() + 1;
//            swfLogLogNo = logMaxNo + "";
//            swfLogDto.setLogNo(logMaxNo);
//            if (!(swfLogFlowID == null || "".equals(swfLogFlowID)) && !(swfLogLogNo == null || "".equals(swfLogLogNo))) {
//                swfLogDtoDealNode.setFlowId(swfLogFlowID);
//                swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
//            }
//
//
//            String titleAttr = "自动立案节点" + "流入时间：" + swfLogDto.getFlowInTime() + " 上一节点操作人:" + userName;
//            swfLogDto.setTitleStr(titleAttr);
//            swfLogDto.setRegistNo(registNo);
//            swfLogDto.setInsuredName(swfLogFunctionIn.getInsuredName());
//            swfLogDto.setLossitemName(swfLogFunctionIn.getLossitemName());
//            swfLogDto.setRiskCode(swfLogFunctionIn.getRiskCode());
//            swfLogDto.setKeyIn(swfLogFunctionIn.getKeyIn());
//            //等于实赔的情况下，就是claimno,buesssno
//            if ("compe".equals(swfLogDto.getNodeType())) {
//                swfLogDto.setKeyIn(swfLogDto.getBusinessNo());
//            }
//            int modelNo = swfLogFunctionIn.getModelNo();
//            int nodeNo = swfLogFunctionIn.getNodeNo();
//            List<SwfNodeDto> wfNodeDtoList = workFlowServiceImpl.findModelNextNodes(modelNo, nodeNo, swfLogTransferDto.getConditionBusinessNo());
//            SwfNodeTransferDto swfNodeTransferDto = new SwfNodeTransferDto();
//            swfNodeTransferDto.setDeptName("");
//            SwfNodeDto wfNodeDto = (SwfNodeDto) wfNodeDtoList.get(0);
//            swfNodeTransferDto.setSwfNodeDto(wfNodeDto);
//            //判断有没有传入的指定的typeflag,需要入swflog的。
//            if (null != swfLogFunctionIn.getTypeFlag() && swfLogFunctionIn.getTypeFlag().length() > 0) {
//                swfNodeTransferDto.setTypeFlag(swfLogFunctionIn.getTypeFlag());
//            }
//            SwfNodeDto swfNodeDto = new SwfNodeDto();
//            swfNodeDto = swfNodeTransferDto.getSwfNodeDto();
//            swfLogDto.setTypeFlag(swfNodeTransferDto.getTypeFlag());
//            swfLogDto.setKeyOut("");
//            swfLogDto.setSubFlowId("0");
//            swfLogDto.setMainFlowId("0");
//            swfLogDto.setPosx(0);
//            swfLogDto.setPosy(0);
//            swfLogDto.setEndFlag(swfNodeDto.getEndFlag());
//            //设置流入时间
//            //reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
//            swfLogDto.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
//            //设置节点的名称
//            swfLogDto.setTitleStr(titleAttr);
//            //设置保单号码
//            swfLogDto.setPolicyNo(swfLogFunctionIn.getPolicyNo());
//            //设置默认节点上的人员
//            swfLogDto.setHandlerCode(swfNodeDto.getHandlerCode());
//            swfLogDto.setHandlerName(swfNodeDto.getHandlerName());
//            swfLogDto.setComCode(swfLogFunctionIn.getComCode());
//            //设置附加数据
//            swfLogDto.setScheduleId(swfNodeTransferDto.getScheduleID());
//            swfLogDto.setLossitemCode(swfNodeTransferDto.getLossItemCode());
//            swfLogDto.setLossitemName(swfNodeTransferDto.getLossItemName());
//            swfLogDto.setInsurecarFlag(swfNodeTransferDto.getInsureCarFlag());
//            swfLogDto.setHandlerRange(swfNodeTransferDto.getHandlerRange());
//            swfLogDto.setExigenceGree(swfNodeTransferDto.getExigenceGree());
//            swfLogDto.setHandleDept(swfNodeTransferDto.getHandleDept());
//            swfLogDto.setDeptName(swfNodeTransferDto.getDeptName());
//            if (("claim".equals(swfLogDto.getNodeType()) && "".equals(swfLogDto.getHandleDept()))
//                    || ("claim".equals(swfLogDto.getNodeType()) && swfLogDto.getHandleDept() == null)) {
//                swfLogDto.setHandleDept(swfLogFunctionIn.getComCode());
//            } else {
//                if ("".equals(swfLogDto.getHandleDept()) || swfLogDto.getHandleDept() == null) {
//                    swfLogDto.setHandleDept(swfLogTransferDto.getNewHandleDept());
//                }
//                if ("".equals(swfLogDto.getHandleDept()) || swfLogDto.getHandleDept() == null) {
//                    swfLogDto.setHandleDept(swfLogTransferDto.getUserComCode());
//                }
//            }
//            if ("".equals(swfLogDto.getDeptName()) || swfLogDto.getDeptName() == null) {
//                swfLogDto.setDeptName(swfLogTransferDto.getNewHandleDept());
//            }
//            if ("".equals(swfLogDto.getDeptName()) || swfLogDto.getDeptName() == null) {
//                swfLogDto.setDeptName(swfLogTransferDto.getUserComName());
//            }
//            //resason :增加立案中数据的支持
//            if ("claim".equals(swfLogDto.getNodeType()) || "compe".equals(swfLogDto.getNodeType()) || "cance".equals(swfLogDto.getNodeType())) {
//                if (!"".equals(swfNodeDto.getRiskCode()) && swfNodeDto.getRiskCode() != null) {
//                    swfLogDto.setRiskCode(swfNodeTransferDto.getRiskCode());
//                }
//                if (!"".equals(swfNodeDto.getPolicyNo()) && swfNodeDto.getPolicyNo() != null) {
//                    swfLogDto.setPolicyNo(swfNodeTransferDto.getPolicyNo());
//                }
//                if (!"".equals(swfNodeDto.getKeyIn()) && swfNodeDto.getKeyIn() != null) {
//                    swfLogDto.setKeyIn(swfNodeTransferDto.getKeyIn());
//                }
//                if (!"".equals(swfNodeDto.getBusinessNo()) && swfNodeDto.getBusinessNo() != null) {
//                    swfLogDto.setBusinessNo(swfNodeTransferDto.getBusinessNo());
//                }
//            }
//            SwfLog swfLog = convert(swfLogDto, SwfLog.class);
//            swfLogDao.saveAndFlush(swfLog);
        }

        workFlowDto = workFlowServiceImpl.viewToDto(swfLogTransferDto);
        if ((workFlowDto.isCreate()) || (workFlowDto.isUpdate()) || (workFlowDto.isSubmit())
                || (workFlowDto.isClose())) {
            saveClaimDto(claimDto);
            if (workFlowDto != null) {
                try {
                    workFlowServiceImpl.deal(workFlowDto);
                } catch (Exception e) {
                    throw new BusinessException("保存工作流出现问题！！");
                }
            }
            // 添加流程查询数据
            PrpLClaimDtoExt prpLClaimDto = claimDto.getPrpLClaimDto();            	
        	if("4".equals(claimDto.getPrpLclaimStatusDto().getStatus())){
				try {
					workProcessService.saveWorkProcess(prpLClaimDto.getPolicyNo(), prpLClaimDto.getRegistNo(), prpLClaimDto.getClaimNo(),null , prpLClaimDto.getClassCode(), prpLClaimDto.getRiskCode(), "claim","compe", AgriclaimWorkProcessEnum.已立案, SinoRequestContext.getCurrentContext().getUserCode());
				} catch (Exception e) {
                    throw new BusinessException("保存到工作流程表失败！！");
				}
			}
        } else {
            saveClaimDto(claimDto);
            throw new BusinessException(claimNo + ";注意:没有发现与工作流流程相关任何数据！！");
        }
        Map<String, String> map = new HashMap<>();
        map.put("claimNo", claimNo);
        return map;
    }


    /**
     * @param claimDto 立案大对象
     * @return claimDto立案大对象
     * @description claimDto对立案大对象进行修改和组装
     * @author yk
     * @date 2017年12月8日 下午3:35:47
     */
    private ClaimDto1 getClaimDto(ClaimDto1 claimDto) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("组装要保存的立案信息dto");
        }

        // 修改立案大对象的prpLclaimDto立案基本信息表大对象
        PrpLClaimDtoExt prpLclaimDto = claimDto.getPrpLClaimDto();
        prpLclaimDto.setLFlag(prpLclaimDto.getLlflag());
        prpLclaimDto.setInputDate(new DateTime(prpLclaimDto.getInputDate(), DateTime.YEAR_TO_DAY));
        String claimNo = claimDto.getClaimNo();
        prpLclaimDto.setClaimNo(claimNo);
        prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(), DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setEndDate(new DateTime(prpLclaimDto.getEndDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setStartDate(new DateTime(prpLclaimDto.getStartDate(), DateTime.YEAR_TO_DAY));
        String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(prpLclaimDto.getDamageStartDate());
        // 获取prpCmainDto，为改变prpLclaimDto的属性做准备
        PrpCmainDto prpCmainDto = getPrpCmainDto(prpLclaimDto.getPolicyNo(),
                dateStr, prpLclaimDto.getDamageStartHour());
        if (prpCmainDto != null) {
            prpLclaimDto.setStartHour(prpCmainDto.getStartHour());
            prpLclaimDto.setEndHour(prpCmainDto.getEndHour());
        } else {
            prpLclaimDto.setStartHour(0);
            prpLclaimDto.setEndHour(24);
        }
        prpLclaimDto.setDamageStartDate(new DateTime(prpLclaimDto.getDamageStartDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDamageEndDate(new DateTime(prpLclaimDto.getDamageEndDate(), DateTime.YEAR_TO_DAY));

        // 添加立案大对象的prpLRegistRPolicy赔案保单关联表实体操作对象
        PrpLRegistRPolicy prpLRegistRPolicy = prpLRegistRPolicyDao
                .findOne(new PrpLRegistRPolicyKey(prpLclaimDto.getRegistNo(), prpLclaimDto.getPolicyNo()));
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = convert(prpLRegistRPolicy, PrpLRegistRPolicyDto.class);
        if (prpLRegistRPolicyDto != null) {
            prpLRegistRPolicyDto.setClaimNo(claimNo);
            prpLRegistRPolicyDto.setFlowId(claimDto.getFlowId());
            claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        }

        // 添加立案大对象的立案文本表prpLltext集合
        List<PrpLLTextDto> prpLltextDtoList = new ArrayList<>();
        String TextTemp = claimDto.getContext();
        int RULE_LENGTH = 70;
        String[] rules = StringGyUtils.split(TextTemp, RULE_LENGTH);
        for (int k = 0; k < rules.length; k++) {
            PrpLLTextDto prpLltextDto = new PrpLLTextDto();
            prpLltextDto.setClaimNo(claimNo);
            prpLltextDto.setContext(rules[k]);
            prpLltextDto.setLineNo(k + 1);
            prpLltextDto.setTextType("09");
            prpLltextDtoList.add(prpLltextDto);
        }
        claimDto.setPrpLltextDtoList(prpLltextDtoList);

        // 添加立案大对象的立案险别估损金额表PrpLClaimLossDto集合
        List<PrpLClaimLossDto> prpLclaimLossDtoList = claimDto.getPrpLclaimLossDtoList();
        for (int i = 0; i < prpLclaimLossDtoList.size(); i++) {
            PrpLClaimLossDto prpLClaimLossDto = prpLclaimLossDtoList.get(i);
            prpLClaimLossDto.setClaimNo(claimNo);
            prpLClaimLossDto.setRiskCode(prpLclaimDto.getRiskCode());
            prpLClaimLossDto.setInputDate(new DateTime(prpLClaimLossDto.getInputDate()));
            prpLClaimLossDto.setSerialNo(i + 1);
        }

        // 添加立案大对象的理赔节点状态表prpLclaimStatusDto对象
        PrpLclaimStatusDto prpLclaimStatusDto = claimDto.getPrpLclaimStatusDto();
        prpLclaimStatusDto.setBusinessno(claimNo);
        prpLclaimStatusDto.setPolicyno(prpLclaimDto.getPolicyNo());
        prpLclaimStatusDto.setNodetype("claim");
        prpLclaimStatusDto.setSerialno(0);
        prpLclaimStatusDto.setRiskcode(prpLclaimDto.getRiskCode());
        String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
//        userCode = "0000000000";
        prpLclaimStatusDto.setHandlercode(userCode);
        prpLclaimStatusDto.setInputdate(prpLclaimDto.getInputDate());
        prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

        // 添加立案大对象的理赔分户清单表PrpLCompensateEarDto集合
        List<PrpLCompensateEarRegistDto> prpLcompensateeartDtoList = claimDto.getPrpLcompensateeartDtoList();
        for (int i = 0; prpLcompensateeartDtoList != null && prpLcompensateeartDtoList.size() > 0
                && i < prpLcompensateeartDtoList.size(); i++) {
            PrpLCompensateEarRegistDto prplCompensateEarDto = prpLcompensateeartDtoList.get(i);
            prplCompensateEarDto.setFCode(prplCompensateEarDto.getCode());
            // prplCompensateEarDto.setClaimNo(prpLclaimDto.getClaimNo());
            prplCompensateEarDto.setDamageCode(prpLclaimDto.getDamageCode());
            prplCompensateEarDto.setDamageName(prpLclaimDto.getDamageName());
            prplCompensateEarDto
                    .setDamageStartDate(new DateTime(prpLclaimDto.getDamageStartDate(), DateTime.YEAR_TO_DAY));
            prplCompensateEarDto.setNodeNo(4);
            prplCompensateEarDto.setNodeType("claim");
            prplCompensateEarDto.setPolicyNo(prpLclaimDto.getPolicyNo());
            prplCompensateEarDto.setRegistNo(prpLclaimDto.getRegistNo());
            prplCompensateEarDto.setBusinessNo(prpLclaimDto.getRegistNo());
        }

        return claimDto;
    }


    /**
     * @param claimDto 保存报案信息大对象
     * @description 保存报案信息
     * @author yk
     * @date 2017年12月8日 下午3:55:59
     */
    private void saveClaimDto(ClaimDto1 claimDto) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("保存立案信息到数据库");
        }

        String claimNo = claimDto.getClaimNo();
        deleteSubInfo(claimNo);

        PrpLClaimDto prpLclaimDto = claimDto.getPrpLClaimDto();
        PrpLClaim prpLClaim = convert(prpLclaimDto, PrpLClaim.class);
        prpLClaimDao.save(prpLClaim);

        if (claimDto.getPrpLcompensateeartDtoList() != null) {
            List<PrpLCompensateEarRegistDto> prpLcompensateeartDtoList = claimDto.getPrpLcompensateeartDtoList();
            List<PrpLCompensateEar> prpLcompensateeartList = new ArrayList<>(prpLcompensateeartDtoList.size());
            convertCollection(prpLcompensateeartDtoList, prpLcompensateeartList, PrpLCompensateEar.class);
            prpLCompensateEarDao.save(prpLcompensateeartList);
        }

        PrpLRegistRPolicyDto prpLRegistRPolicyDto = claimDto.getPrpLRegistRPolicyDto();
        PrpLRegistRPolicy prpLRegistRPolicy = convert(prpLRegistRPolicyDto, PrpLRegistRPolicy.class);
        prpLRegistRPolicyDao.save(prpLRegistRPolicy);

        List<PrpLLTextDto> prpLltextDtoList = claimDto.getPrpLltextDtoList();
        List<PrpLLText> prpLLTextList = new ArrayList<>(prpLltextDtoList.size());
        convertCollection(prpLltextDtoList, prpLLTextList, PrpLLText.class);
        prpLLTextDao.save(prpLLTextList);

        if (claimDto.getPrpLclaimStatusDto().getStatus().equals("4")) {
//			prpAllApi.modifyPrpCmainAddClaimTimes(claimDto.getPrpLClaimDto().getPolicyNo());
            Map<String, String> policyNomap = new HashMap<>();
            policyNomap.put("policyNo", claimDto.getPrpLClaimDto().getPolicyNo());
            try {
                prpCmainApi.modifyPrpCmainAddClaimTimes(policyNomap);
            } catch (Exception e) {
                throw new BusinessException("修改prpcmain表的claimtimes出错！！");
            }
        }
        prpLclaimStatusDao.deleteByBusinessnoAndNodetype(claimDto.getPrpLclaimStatusDto().getBusinessno(), "claim");
        PrpLclaimStatusDto prpLclaimStatusDto = claimDto.getPrpLclaimStatusDto();
        PrpLclaimStatus prpLclaimStatus = convert(prpLclaimStatusDto, PrpLclaimStatus.class);
        prpLclaimStatusDao.save(prpLclaimStatus);
    }


    /**
     * @param claimNo 立案号
     * @description 根据claimNo删除已有数据
     * @author yk
     * @date 2017年12月8日 下午4:27:55
     */
    private void deleteSubInfo(String claimNo) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("删除原有的立案==立案号==" + claimNo);
        }
        prpLClaimLossDao.deleteByClaimNo(claimNo);
        prpLClaimDao.deleteByClaimNo(claimNo);
        prpLCompensateEarDao.deleteByClaimNo(claimNo);
    }

    /**
     * @param strPolicyNo strDamageDate strDamageHour
     * @return PrpCmainDto保单信息主表对象
     * @description 获取prpCmainDto保单信息主表对象，为改变prpLclaimDto的属性做准备
     * @author yk
     * @date 2017年12月8日 下午3:48:14
     */
    private PrpCmainDto getPrpCmainDto(String strPolicyNo, String strDamageDate, String strDamageHour) {

        PrpCmainDto prpCmainDto1 = null;
        Map<String, String> policyNoMap = new HashMap<>();
        policyNoMap.put("policyNo", strPolicyNo);
        PrpCmainDto prpCmainDto2 = prpCmainApi.queryByPK(policyNoMap);

        int theDamageHour = 0;
        if (strDamageHour != null && !strDamageHour.equals("") && strDamageHour.length() > 1) {
            theDamageHour = Integer.parseInt(strDamageHour.substring(0, 2));
        }
        // reason:还原到的时间点精确到天,并且进行格式调整
        if (strDamageDate != null && !strDamageDate.equals("") && strDamageDate.length() > 9) {
            strDamageDate = strDamageDate.split(" ")[0];
        }

        PrpPheadDto prpPheadDto = new PrpPheadDto();
        Map<String, String> prpPheadDtomap = new HashMap<>();
        prpPheadDtomap.put("policyNo", strPolicyNo);
        prpPheadDtomap.put("damageDate", strDamageDate);
        prpPheadDtomap.put("damageHour", theDamageHour + "");
        List<PrpPheadDto> listTemp = null;
        try {
            listTemp = prpPheadApi.queryPrpPheadDtoByNoANDTime(prpPheadDtomap);
        } catch (Exception e) {
            throw new BusinessException("获得PrpPheadDtoList出错！！");
        }
//		 List<PrpPheadDto> listTemp =
//		 prpAllApi.queryPrpPheadDtoByNoANDTime(strPolicyNo, strDamageDate,
//		 theDamageHour);
        // 没有找到符合条件的批单则返回当前保单
        if (listTemp == null || listTemp.size() < 1) {
            prpCmainDto1 = prpCmainDto2;
        } else {
            // 找到后逐级回滚批单信息
            for (int i = 0; i < listTemp.size(); i++) {
                prpPheadDto = (PrpPheadDto) listTemp.get(i);
                prpCmainDto1 = backWard(prpCmainDto2, prpPheadDto.getEndorseNo());
            }
        }

        return prpCmainDto1;
    }

    /**
     * @param prpCmainDto 保单信息主表大对象endorseNo批单号码
     * @return prpCmainDto保单信息主表大对象
     * @description 供调用回滚批单信息
     * @author yk
     * @date 2017年12月8日 下午3:49:55
     */
    public PrpCmainDto backWard(PrpCmainDto prpCmainDto, String endorseNo) {

        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("回滚批单信息");
        }
        Map<String, String> endorseNomap = new HashMap<>();
        endorseNomap.put("endorseNo", endorseNo);
        PrpPmainDto prpPmainDto = null;
        try {
            prpPmainDto = prpPmainApi.queryPrpCmainDtoByEndorseNo(endorseNomap);
        } catch (Exception e1) {
            throw new BusinessException("获得prpPmainDto失败！！");
        }
//		 PrpPmainDto prpPmainDto =
//		 prpAllApi.queryPrpCmainDtoByEndorseNo(endorseNo);
        if (prpPmainDto != null) {
            try {
                PropertyUtils.copyProperties(prpCmainDto, prpPmainDto);
            } catch (Exception e) {
                throw new BusinessException("回滚批单信息失败！！");
            }
        }

        return prpCmainDto;
    }

    /**
     * @param claimCancelDtoList  sql片段
     * @return prpLClaimDtoList 申请注销／拒赔基本信息集合对象
     * @description 申请注销／拒赔 获取申请信息
     * @author 马俊玲
     * @date 2017年11月21日 下午7:40:23
     */
    @Override
    public List<ClaimCancelDto> queryClaimCancelDetail(List<ClaimCancelDto> claimCancelDtoList) {
        if (null == claimCancelDtoList || claimCancelDtoList.size() == 0) {
            String msg = " 请至少选择一条申请信息";
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>>>{}", msg);
            }
            return null;
        }
        // 抛出错误使用的消息传递信息
        String msg = "";
        if (null != claimCancelDtoList && claimCancelDtoList.size() > 0) {
            for (ClaimCancelDto claimCancelDto : claimCancelDtoList) {
                // reason权限判断
                UserInfo user = SinoRequestContext.getCurrentContext().getUser();
                PowerConditionDto powerConditionDto = new PowerConditionDto();
                powerConditionDto.setUserCode(user.getUserCode());
                powerConditionDto.setTaskCodes("TASK_CLAIM_CLAIM_QUERY");

                // 赔案号
                String claimNo = claimCancelDto.getPrpLclaimCancelClaimNo();
                // 报案号
                String registNo = claimCancelDto.getRegistNo();
                String nodeType = claimCancelDto.getNodeType();

                List<PrpLClaim> claimList = null;
                // 报案Dto对象
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("查询报案信息主表>>>>>>>>>>>>>>>{}", registNo);
                }
                PrpLRegistKey prpLRegistKey = new PrpLRegistKey(registNo);
                PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
                // 立案Dto对象
                PrpLClaimDtoExt prpLclaimDto = null;
                PrpLRegistDto prpLRegistDto = null;
                // 由于强三的原因，只要立案超过1个的情况的，注销掉部分，则不进行整个流程的关闭，需要选择是申请哪个注销的。
                // 所以只能依靠registNo来进行判断了
                if (!"compe".equals(nodeType)) {
                    if (registNo == null || registNo.equals("")) {
                        msg = "不合法的报案号码！";
                        if (LOGGER.isErrorEnabled()) {
                            LOGGER.error("拒赔＝＝＝＝＝{}", msg);
                        }
                    }
                    // 1.首先检查registNo是不是合法。如果不合法那么退出
                    if (null == prpLRegist) {
                        msg = "不合法的报案号码！";
                        if (LOGGER.isErrorEnabled()) {
                            LOGGER.error("拒赔＝＝＝＝＝{}", msg);
                        }
                    }
                }
                // 2.将立案信息取出
                if ("compe".equals(nodeType)) {
                    claimList = prpLClaimDao.findByClaimNo(claimNo);
                } else {
                    claimList = prpLClaimDao.findByRegistNoWithEndcaseDate(registNo);
                }
                if (claimList == null || claimList.size() < 1) {
                    // 如果没有立案，先提示，立案后在做拒赔以后要自动写信息到立案表里去'
                    // 整理立案数据
                    msg = "案件目前还没有立案，请先立案后再做注销和拒赔！";
                    if (LOGGER.isErrorEnabled()) {
                        LOGGER.error("拒赔＝＝＝＝＝{}", msg);
                    }

                }
                if (null != claimList && claimList.size() > 0) {
                    for (PrpLClaim prpLClaim : claimList) {
                        prpLclaimDto = convert(prpLClaim, PrpLClaimDtoExt.class);
                        if ("compe".equals(nodeType)) {
                            registNo = prpLclaimDto.getRegistNo();
                        }
                    }
                }
                claimCancelDto.setPrpLClaimDto(prpLclaimDto);
                if (prpLclaimDto == null) {
                    msg = "没有查询到相关立案！";
                    if (LOGGER.isErrorEnabled()) {
                        LOGGER.error("拒赔＝＝＝＝＝{}", msg);
                    }
                }
                // 立案注销/拒赔节点是否已经生成过
                // 商业险立案号是否已经注销/拒赔标志
                String BZFlag = "N";
                if (null != claimList && claimList.size() > 0) {
                    PrpLClaimDtoExt prpLclaimDtotemp = null;
                    List<SwfLog> swfLogDtoList = null;
                    for (PrpLClaim prpLClaim : claimList) {
                        prpLclaimDtotemp = new PrpLClaimDtoExt();
                        prpLclaimDtotemp = convert(prpLClaim, PrpLClaimDtoExt.class);
                        // 设置申请时间
                        prpLclaimDto.setCancelDate(new Date());
                        // 设置申请人
                        prpLclaimDto.setDealerCode(user.getUserCode());
                        prpLclaimDto.setDealerName(user.getUserName());
                        // 设置操作状态为ADD,申请登记，很重要的
//                         prpLclaimDto.setEditType("ADD");
                        swfLogDtoList = new ArrayList<SwfLog>();
                        swfLogDtoList = swfLogDao.findAll(Specifications.<SwfLog>and()
                                .eq("businessNo", prpLclaimDtotemp.getClaimNo()).eq("nodeType", "cance").build());
                        // 非车险是否已经注销/拒赔标志
                        if (swfLogDtoList.size() > 0) {
                            BZFlag = "Y";
                        }
                    }

                }
                if (null != prpLRegist) {
                    prpLRegistDto = convert(prpLRegist, PrpLRegistDto.class);
                }
                claimCancelDto.setPrpLClaimDto(prpLclaimDto);
                claimCancelDto.setInsuredName(prpLclaimDto.getInsuredName());
                claimCancelDto.setDamageAddress(prpLclaimDto.getDamageAddress());
                claimCancelDto.setDamageDate(format.format(prpLclaimDto.getDamageStartDate()));

            }
        }

        return claimCancelDtoList;
    }

    /**
     * @param claimCancleSubmitDtoList
     * @return prpLClaimDtoList 申请注销／拒赔基本信息集合对象
     * @description 申请注销／拒赔
     * @author 马俊玲
     * @date 2017年11月21日 下午7:40:23
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> claimCancelSubmit(List<ClaimCancleSubmitDto> claimCancleSubmitDtoList) throws Exception{
        Map<String, String> resultMap = new HashMap<String, String>();
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        String msg = "";
        StringBuffer result = new StringBuffer();
        if (null != claimCancleSubmitDtoList && claimCancleSubmitDtoList.size() > 0) {
            for (ClaimCancleSubmitDto claimCancleSubmitDto : claimCancleSubmitDtoList) {
                String caseType = claimCancleSubmitDto.getCaseType();
                UserInfo user = SinoRequestContext.getCurrentContext().getUser();
                PrpDuserDto userDto = new PrpDuserDto();
                userDto.setUserCode(user.getUserCode());
                userDto.setComCode(user.getLoginComCode());
                userDto.setUserName(user.getUserName());
                PrpDcompanyDto company = userApi.queryUserCompany(userDto);
                ClaimDto1 claimDto = cancelViewToDto(claimCancleSubmitDto);
                // 以下为工作流使用中的
                String editType = claimCancleSubmitDto.getEditType();
                String nodeType = claimCancleSubmitDto.getNodeType();
                String strClaimNo = claimCancleSubmitDto.getPrpLclaimCancelClaimNo();
                String businessNo = claimCancleSubmitDto.getBusinessNo();
                String registNo = claimCancleSubmitDto.getRegistNo();
                // 工作流号码
                String swfLogFlowID = claimCancleSubmitDto.getSwfLogFlowID();
                // 工作流logno
                int swfLogLogNo = claimCancleSubmitDto.getSwfLogLogNo();
                if ("EDIT".equals(editType) || "ADD".equals(editType)) {
//                    String conditionCom = "flowid = '"+swfLogFlowID +"' and keyin = '"+strClaimNo+"' and nodetype='compp'  and nodestatus <> '0'";
                    List<SwfLog> swflogList = null;
                    swflogList = swfLogDao.findByConditions(swfLogFlowID, strClaimNo, "compp");
                    if (!"26".equals(claimDto.getPrpLClaimDto().getClassCode()) && !"27".equals(claimDto.getPrpLClaimDto().getClassCode()))
                        if (swflogList != null && swflogList.size() > 0) {
                            msg = "案件'" + strClaimNo + "'已经生成计算书，不能对其进行拒赔/注销进行申请、审核的操作!";
                            if (LOGGER.isErrorEnabled()) {
                                LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>{}", msg);
                            }
                            throw new BusinessException(msg);
                        }
                }
                if ("ADD".equals(editType)) {
                    List<SwfLog> cancelList = null;
                    cancelList = swfLogDao.findByPolicyNoAndID(swfLogFlowID, claimDto.getPrpLClaimDto().getPolicyNo(), "cance");
                    if (cancelList != null && cancelList.size() > 0) {
                        msg = "该保单已经申请成功，不允许再次申请！";
                        if (LOGGER.isErrorEnabled()) {
                            LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>{}", msg);
                        }
                        throw new BusinessException(msg);
                    }
                }
                // 防止重复提交
                String oldLastAccessedTime = String.valueOf(claimCancleSubmitDto.getOldCancelAccessedTime());
                if (StringUtils.isNotEmpty(oldLastAccessedTime) && !oldLastAccessedTime.trim().equals("0")) {
                    throw new BusinessException("工作流>>>>>>>>>>{}", "请不要重复提交");
                } else {
                    resultMap.put("oldLastAccessedTime", new Date().getTime() / 1000 + "");
                }
                // 保存立案拒赔注销信息
                // 在uiCLaimAcction里自动识别是否要怎么保存的具体操作
                // 工作流处理过程,如果是ADD的类型，则先指定要到注销/核赔的申请，如果是注销核赔的确定，
                // 直接完成注销核赔的确认
                // -----------------------------------------------------
                // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
                SwfLogDto swfLogDtoDealNode = new SwfLogDto();
                SwfLogDto swfLogNextNode = new SwfLogDto();
                SwfLogTransferDto swfLogTransferDto = new SwfLogTransferDto();

                List<SwfLogDto> nextNodeList = new ArrayList<SwfLogDto>();
                // 申请登记

                if (StringUtils.isNotEmpty(swfLogFlowID)) {
                    swfLogDtoDealNode.setFlowId(swfLogFlowID);
                    swfLogDtoDealNode.setLogNo(swfLogLogNo);
                    swfLogNextNode.setFlowId(swfLogFlowID);
                    swfLogNextNode.setLogNo(swfLogLogNo);

                }
                if ("ADD".equals(editType)) {
                    swfLogDtoDealNode.setNodeType(nodeType);
                    swfLogDtoDealNode.setNodeStatus("4");
                    swfLogDtoDealNode.setBusinessNo(businessNo);
                    swfLogNextNode.setNodeType(nodeType);
                    swfLogNextNode.setNodeStatus("4");
                    swfLogNextNode.setBusinessNo(businessNo);
                    swfLogTransferDto.setNextBusinessNo(claimDto.getPrpLClaimDto().getClaimNo());

                    // 设置流转到注销/拒赔的受理节点去
                    swfLogNextNode.setNodeNo(0);
                    swfLogNextNode.setLogNo(swfLogLogNo);

                    swfLogNextNode.setNodeType("cance");
                    swfLogNextNode.setKeyIn(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogNextNode.setPolicyNo(claimDto.getPrpLClaimDto().getPolicyNo());
                    swfLogNextNode.setRiskCode(claimDto.getPrpLClaimDto().getRiskCode());

                    // 判断是注销还是拒赔，是要放在工作流上的
                    swfLogNextNode.setTypeFlag(caseType);
                    // 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
                    swfLogTransferDto.setNextNodeListType("1");
                    // 考虑 到后来几乎都是用clamno做keyin的数值的。。
                    swfLogDtoDealNode.setKeyIn(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogDtoDealNode.setKeyOut(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogNextNode.setKeyIn(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogNextNode.setKeyOut(claimDto.getPrpLClaimDto().getClaimNo());

                    nextNodeList.add(swfLogNextNode);
                    // 保存注销原因
                    PrpLRegistRPolicyKey prpLRegistRPolicyKey = new PrpLRegistRPolicyKey(
                            claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getPolicyNo());
                    PrpLRegistRPolicyDto prpLRegistRPolicyDto = convert(
                            prpLRegistRPolicyDao.findOne(prpLRegistRPolicyKey), PrpLRegistRPolicyDto.class);
                    if (prpLRegistRPolicyDto != null) {
                        prpLRegistRPolicyDto.setCancelReason(claimCancleSubmitDto.getCancelReason());
                        prpLRegistRPolicyDto.setCancelReasonName(claimCancleSubmitDto.getCancelReasonName());
                        claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
                    }
                } else {

                    swfLogDtoDealNode.setNodeType("cance");
                    swfLogDtoDealNode.setNodeStatus("2");
                    swfLogDtoDealNode.setBusinessNo(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogDtoDealNode.setTypeFlag(caseType);
                    // 生成陪案号
                    String tableName = "prplcaseno";
                    String comCode = user.getLoginComCode();
                    String riskCode = getRiskCode(claimDto.getPrpLClaimDto().getClaimNo(), "ClaimNo");
                    int year = DateTime.current().getYear();
                    BillNoDto billNoDto = new BillNoDto();
                    billNoDto.setiComCode(comCode);
                    billNoDto.setiYear(String.valueOf(year));
                    billNoDto.setRiskCode(riskCode);
                    billNoDto.setTableName(tableName);
                    billNoDto.setUserCode(user.getUserCode());
                    String caseNo;
                    try {
                        caseNo = billNoApi.getBillNo(billNoDto).get("billNo");
                    } catch (Exception e) {
                        msg = "获取单号出错";
                        throw new BusinessException("申请注销／拒赔>>>>>>>>>>>>>>>>>>>>>>{}", msg);
                    }
                    claimDto.getPrpLClaimDto().setCaseNo(caseNo);
                    claimDto.getPrpLClaimDto()
                            .setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
                    claimDto.getPrpLClaimDto().setEndCaserCode(user.getUserCode());
                    claimDto.getPrpLClaimDto().setCaseNo(caseNo);
                    // 最后通过的时候才写这个数据的的
                    claimDto.getPrpLClaimDto()
                            .setCancelDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    claimDto.getPrpLClaimDto().setCaseType(caseType);
                    PrpLRegistRPolicy prpLRegistRPolicy = prpLRegistRPolicyDao.findOne(new PrpLRegistRPolicyKey(
                            claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getPolicyNo()));
                    PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
                    if (null != prpLRegistRPolicy) {
                        prpLRegistRPolicyDto = convert(prpLRegistRPolicy, PrpLRegistRPolicyDto.class);
                    }
                    if (prpLRegistRPolicyDto != null) {
                        prpLRegistRPolicyDto.setValidStatus("0");
                        prpLRegistRPolicyDto.setClaimNo(strClaimNo);
                        prpLRegistRPolicyDto.setCancelReason(claimCancleSubmitDto.getCancelReason());
                        prpLRegistRPolicyDto.setCancelReasonName(claimCancleSubmitDto.getCancelReasonName());
                        claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
                    }
                    List<PrpLClaim> claimList = null;
                    claimList = prpLClaimDao.findByRegistNoAndClaimNo(claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getClaimNo());
                    if (claimList == null || claimList.size() == 0) {
                        List<PrpLRegistRPolicy> registRPolciyList = prpLRegistRPolicyDao.findByConditions(claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getClaimNo());
                        if (registRPolciyList == null || registRPolciyList.size() == 0) {
                            swfLogDtoDealNode.setNodeStatus("4");
                            swfLogDtoDealNode.setEndFlag("1");
                        }
                    }
                    // 需要增加是否需要结束流程的判断如果需要结束则，才结束工作流程。
                    swfLogDtoDealNode.setNodeStatus("4");
                    swfLogDtoDealNode.setEndFlag("1");
                    swfLogDtoDealNode.setKeyIn(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogDtoDealNode.setKeyOut(claimDto.getPrpLClaimDto().getClaimNo());
                    swfLogTransferDto.setNewDeptName(company.getComCName());
                    swfLogTransferDto.setNewHandleDept(company.getComCode());
                    nextNodeList.add(swfLogDtoDealNode);

                }
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>查找工作流信息");
                }
                swfLogTransferDto.setSwfLogDto(swfLogDtoDealNode);
                swfLogTransferDto.setSwfLogNextList(nextNodeList);
                swfLogTransferDto.setUserComCode(user.getLoginComCode());
                swfLogTransferDto.setUserUserCode(user.getUserCode());
                swfLogTransferDto.setUserUserName(user.getUserName());
                swfLogTransferDto.setNextBusinessNo(businessNo);
                swfLogTransferDto.setNewDeptName(company.getComCName());
                swfLogTransferDto.setNewHandleDept(company.getComCode());
                WorkFlowDto workFlowDto = workFlowService.viewToDto(swfLogTransferDto);
                // ------------------------------------------------------------
                // 保存立案信息并查找工作流程

              /*  if ("ADD".equals(editType)) {
                    // add by lixiang start at 2006-6-22
                    // reason:注销/拒赔后，当任务没有被全部注销/拒赔时，可以继续操作，不受流程的申请的影响。
                    // 如果是在理算节点回退的去更新理算节点状态
                    workFlowDto.setUpdate(false);
                    workFlowDto.setUpdateSwfLogDto(null);

                } else {*/

                    if (workFlowDto.getUpdateSwfLogDto() != null) {
                        workFlowDto.getUpdateSwfLogDto().setNodeStatus("8");
                        /*// 不更新另一个节点
                        if ("compe".equals(nodeType)) {
                            workFlowDto.setUpdateSwfLog2Dto(null);
                        } else {
                            // reason:注销/拒赔通过后，将此任务的立案工作流节点变成 4，说明已经提交。
                            List<SwfLog> claimSwfLogList = swfLogDao.findByConditon(swfLogFlowID, "claim", "2",
                                    claimDto.getPrpLClaimDto().getClaimNo());
                            if (claimSwfLogList != null && claimSwfLogList.size() > 0) {
                                claimSwfLogList.get(0).setNodeStatus("4");
                                workFlowDto.setUpdateSwfLog2Dto(convert(claimSwfLogList.get(0), SwfLogDto.class));
                            }
                        }*/
                    }
//                }
                //关联保单历算注销
                if (!"".equals(nodeType) && nodeType.equals("compe")) {

                    List<SwfLogDto> swfLogDtoList = new ArrayList<>();
                    List<SwfPathLogDto> swfpathlogDtoList = new ArrayList<>();
                    if (workFlowDto.getSubmitSwfLogDtoList() != null) {
                        SwfLogDto swfLogDto = null;
                        int logno = 0;
                        for (int i = 0; i < workFlowDto.getSubmitSwfLogDtoList().size(); i++) {
                            swfLogDto = workFlowDto.getSubmitSwfLogDtoList().get(i);
                            if (swfLogDto.getNodeType().equals("compp")) {

                            } else {
                                swfLogDtoList.add(swfLogDto);
                                logno = swfLogDto.getLogNo();
                            }
                        }
                        SwfPathLogDto swfPathLogDto = null;
                        for (int i = 0; i < workFlowDto.getSubmitSwfPathLogDtoList().size(); i++) {
                            swfPathLogDto = workFlowDto.getSubmitSwfPathLogDtoList().get(i);
                            if (logno == swfPathLogDto.getEndNodeNo()) {
                                swfPathLogDto.setStartNodeNo(swfLogDtoDealNode.getLogNo());
                                swfpathlogDtoList.add(swfPathLogDto);
                            }
                        }
                    }
                    workFlowDto.setSubmitSwfPathLogDtoList(swfpathlogDtoList);
                    workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
                }
                if (workFlowService.checkDealDto(workFlowDto)) {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>开始保存申请信息和工作流信息");
                    }
                    save(claimDto, workFlowDto);
                    //发送XML到双核系统
                    List<SwfLogDto> swfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
                    SwfLogDto swfLogNextDto = new SwfLogDto();
                    if (swfLogDtoList.size()>0){
                        swfLogNextDto = swfLogDtoList.get(0);
                    }
                    PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
                    prpLClaimKey.setClaimNo(businessNo);
                    ReCaseXMLCommitDto reCaseXMLCommitDto = new ReCaseXMLCommitDto();//用xml发送的Dto
                    reCaseXMLCommitDto.setlFlowID(swfLogNextDto.getFlowId());
                    reCaseXMLCommitDto.setlLogNo(swfLogNextDto.getLogNo());
                    reCaseXMLCommitDto.setModelType("60");
                    reCaseXMLCommitDto.setCertiType("O");
                    reCaseXMLCommitDto.setBusinessNo(businessNo);
                    reCaseXMLCommitDto.setRiskCode(swfLogNextDto.getRiskCode());
                    reCaseXMLCommitDto.setClassCode(swfLogNextDto.getRiskCode().substring(0,2));
                    PrpLClaimDto prpLClaimDto = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
                    reCaseXMLCommitDto.setComCode(prpLClaimDto.getComCode());
                    reCaseXMLCommitDto.setMakecom(prpLClaimDto.getMakeCom());
                    reCaseXMLCommitDto.setUserCode(userCode);
                    reCaseXMLCommitDto.setHandlerCode(prpLClaimDto.getHandlerCode());
                    reCaseXMLCommitDto.setHandler1Code(prpLClaimDto.getHandler1Code());
                    reCaseXMLCommitDto.setContractNo("");
                    String requestXml ;
                    XmlUtil xmlUtil = new XmlUtil();
                    PacketDto<ReCaseXMLCommitDto> packetDto = new PacketDto<>();
                    packetDto.setBody(reCaseXMLCommitDto);
                    requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
                    JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
                    jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
                    jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
                    NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();

                    String getXml = newAgriPrpallUndwrtService.reCaseSubmit(requestXml);

                //  流程查询服务调用
                    try {
                          if(nodeType.equals("claim")){
                              workProcessService.saveWorkProcess(claimDto.getPrpLClaimDto().getPolicyNo(), claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getClaimNo(), null, claimDto.getPrpLClaimDto().getClassCode(), claimDto.getPrpLClaimDto().getRiskCode(), "claim","claim", AgriclaimWorkProcessEnum.已注销, SinoRequestContext.getCurrentContext().getUserCode());
                          }else if(nodeType.equals("compe")){
                              workProcessService.saveWorkProcess(claimDto.getPrpLClaimDto().getPolicyNo(), claimDto.getPrpLClaimDto().getRegistNo(), claimDto.getPrpLClaimDto().getClaimNo(), null, claimDto.getPrpLClaimDto().getClassCode(), claimDto.getPrpLClaimDto().getRiskCode(), "compe","compe", AgriclaimWorkProcessEnum.已注销, SinoRequestContext.getCurrentContext().getUserCode());
                          }
                        } catch (Exception e) {
                            throw new BusinessException("保存到工作流程表失败！！");
                        }
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>申请注销／拒赔成功");
                    }
                    Document document;
                    try {
                        document = DocumentHelper.parseText(getXml);
                    } catch (DocumentException e) {
                        throw new BusinessException(e.getMessage());
                    }

                    Element requestData =document.getRootElement();
                    Element flowID = requestData.element("flowId");
                    if (StringUtils.isNotEmpty(flowID.getTextTrim())){
                        msg = "申请注销／拒赔成功";
                    }else {
                        msg = "申请注销／拒赔提交失败";
                    }
                    result.append(claimDto.getPrpLClaimDto().getClaimNo() + msg + ";");
                } else {
                    if (LOGGER.isInfoEnabled()) {
                        LOGGER.error("申请注销／拒赔>>>>>>>>>>>>>>>>>>开始保存申请信息");
                    }
                    save(claimDto, null);
                    msg = "申请注销／拒赔成功";
                    result.append(claimDto.getPrpLClaimDto().getClaimNo() + ":" + msg + ";");
                }
            }

        } else {
            String error = "未传入有效的申请信息";
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("申请注销／拒赔＝＝＝＝＝{}", error);
            }
            resultMap.put("error", error);
        }
        resultMap.put("result", result.toString());
        return resultMap;
    }

    /**
     * 保存立案注销时立案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     *
     * @param claimCancleSubmitDto
     * @return claimDto 立案数据传输数据结构
     */
    private ClaimDto1 cancelViewToDto(ClaimCancleSubmitDto claimCancleSubmitDto) {
        ClaimDto1 claimDto = new ClaimDto1();
        UserInfo user = SinoRequestContext.getCurrentContext().getUser();
        String claimNo = "";
        String caseType = "";
        claimNo = claimCancleSubmitDto.getPrpLclaimCancelClaimNo();
        caseType = claimCancleSubmitDto.getCaseType();
        String cancelReaseon = claimCancleSubmitDto.getPrpLclaimContext();
        String prpCancel = claimCancleSubmitDto.getPrpCancel();
        String prpExclusions = claimCancleSubmitDto.getPrpExclusions();
        /*---------------------立案主表prpLclaim------------------------------------*/
        PrpLClaimDtoExt prpLclaimDto = null;
        if ((claimNo == null) || claimNo.equals("")) {
            String msg = " 此案件没有立案，可以通知报案人员进行报案注销操作！";
            if ("1".equals(caseType)) {
                msg = " 此案件没有立案，需要通知立案人员先进行立案后，再申请！";

            }
            throw new BusinessException("注销/拒赔>>>>>>>>>>>>>{}", msg);
        }
        prpLclaimDto = claimDtoToView(claimCancleSubmitDto, claimNo);

        if (prpLclaimDto == null) {
            String msg = "没有查询到相关立案！";
            throw new DataVerifyException("拒赔>>>>>>>>>>>>>>>>>{}", msg);
        }
        // 只update就可以了。
        prpLclaimDto.setFlag("0");

        // 设置第一次进入时的默认信息
        // prpLclaimDto.setCancelDate(new
        // DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDealerCode(user.getUserCode());
        prpLclaimDto.setDealerName(user.getUserName());
        prpLclaimDto.setCancelReason(cancelReaseon);
        prpLclaimDto.setCaseType(caseType);
        if ("1".equals(caseType)) {
            prpLclaimDto.setCancelReasonExplan(prpExclusions);
        } else {
            prpLclaimDto.setCancelReasonExplan(prpCancel);
        }
        // 用工作流的
        claimDto.setPrpLClaimDto(prpLclaimDto);

        /*---------------------立案注销文本表prpLltext------------------------------------*/
        ArrayList prpLltextDtoList = new ArrayList();
        PrpLLTextDto prpLltextDto = null;
        String textTemp = claimCancleSubmitDto.getPrpLclaimContext();
        String[] rules = StringGyUtils.split(textTemp, "RULE_LENGTH");

        // 得到连接串,下面将其切分到数组
       if (rules != null){
           for (int k = 0; k < rules.length; k++) {
               prpLltextDto = new PrpLLTextDto();
               prpLltextDto.setClaimNo(claimNo);
               prpLltextDto.setContext(rules[k]);
               prpLltextDto.setLineNo(k + 1);
               prpLltextDto.setTextType("10");
               prpLltextDtoList.add(prpLltextDto);
           }
       }

        // 装入ClaimDto
        claimDto.setPrpLltextDtoList(prpLltextDtoList);

        /*---------------------立案操作状态内容prpLclaimStatus默认为完成------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus("4");
        prpLclaimStatusDto.setBusinessno(prpLclaimDto.getClaimNo());
        prpLclaimStatusDto.setPolicyno(prpLclaimDto.getPolicyNo());
        prpLclaimStatusDto.setNodetype("claim");
        prpLclaimStatusDto.setSerialno(0);

        // 取得当前用户信息，写操作员信息到实际claimstatus中

        prpLclaimStatusDto.setHandlercode(user.getUserCode());
        prpLclaimStatusDto.setInputdate(prpLclaimDto.getInputDate());
        prpLclaimStatusDto.setOperatedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setRiskcode(prpLclaimDto.getRiskCode());
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        return claimDto;

    }

    private String getRiskCode(String claimNo, String string) {
        String riskCode = "";
        PrpLClaimKey prpLclaimKey = new PrpLClaimKey(claimNo);
        PrpLClaim prpLclaim = prpLClaimDao.findOne(prpLclaimKey);
        riskCode = prpLclaim.getRiskCode();
        return riskCode;
    }

    /**
     * @param claimDto workFlowDto
     * @description 申请注销／拒赔 保存申请信息
     * @author 马俊玲
     * @date 2017年11月21日 下午7:40:23
     */
    @Transactional(rollbackFor = Exception.class)
    private void save(ClaimDto1 claimDto, WorkFlowDto workFlowDto) {
        String msg = "";
        PrpLClaimDto prpLclaimDto = claimDto.getPrpLClaimDto();
        if (null == prpLclaimDto) {
            msg = "没有有效的数据";
            throw new BusinessException("申请注销／拒赔>>>>>>>>>>>>>>>>>>>{}", msg);
        }
        String strCaseType = prpLclaimDto.getCaseType();
        // 如果是立案拒赔或者注销用savecancel的方法
        if ("1".equals(strCaseType) || "0".equals(strCaseType)) {
            saveCancel(claimDto);
        } else {
            // 如果是新增加或者修改那么用insert
        }
        if (workFlowDto != null) {
            try {
                workFlowService.deal(workFlowDto);
            } catch (Exception e) {
                throw new BusinessException("工作流workFlowService.deal(workFlowDto)方法报错");
            }
        }

    }

    /**
     * 填写立案页面及查询立案. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     *
     * @param claimCancleSubmitDto
     * @param claimNo
     */
    private PrpLClaimDtoExt claimDtoToView(ClaimCancleSubmitDto claimCancleSubmitDto, String claimNo) {

        // 查询立案信息
        // 根据立案号查询立案信息
        ClaimDto1 claimDto = findByPrimaryKey(claimNo);
        // 立案基本信息对象
        PrpLClaimDtoExt prpLclaimDto = null;
        // 给prpLclaimDto赋值
        if (claimDto.getPrpLClaimDto() == null) {
            String msg = "案件'" + claimNo + "'无法查询到！";
            throw new DataVerifyException("查询>>>>>>>>>>>>>>>>{}", msg);
        }
        // 通过立案数据传输对象给立案主表信息赋值
        prpLclaimDto = claimDto.getPrpLClaimDto();
        // 待查勘信息操作对象
        // 规范日期格式
        String timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageStartHour());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));

        timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageEndHour());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        // 通过立案基本信息获取险种代码
        // 通过立案基本信息获取报案号
        // 设置立案操作的状态为 案件修改 (正处理任务)
        if (claimDto.getPrpLclaimStatusDto() != null) {
            if (claimDto.getPrpLclaimStatusDto().getStatus().equals("7")) {
                claimDto.getPrpLclaimStatusDto().setStatus("3");
            }
            prpLclaimDto.setStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        } else {
            // 已提交，已经处理完毕的状态
            prpLclaimDto.setStatus("4");
        }
        /*
         * 从保单中获得信息 原因：因为这些保单信息都已经保存到立案表信息中了，故注掉，但是因为需要转换界面上的
         * 车辆信息，所以仍需要去取保单和下面的车辆信息这一个过程。
         */
        PrpCmainDto prpCmainDto = null;
        if (!claimDto.getPrpLClaimDto().getPolicyNo().equals("")) {
            // 查询保单信息
            // 根据出险时间还原保单信息(由于承保系统没有提供涉及到批单的查询服务，暂时只查询保单)
            // endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo(),claimDto.getPrpLclaimDto().getDamageStartDate().toString(),
            // claimDto.getPrpLclaimDto().getDamageStartHour());
            try {
                Map<String, String> policyMap = new HashMap<String, String>();
                policyMap.put("policyNo", claimDto.getPrpLClaimDto().getPolicyNo());
                prpCmainDto = prpCmainApi.queryByPK(policyMap);
            } catch (Exception e) {
                String msg = "没有查询到相应的保单";
                throw new DataVerifyException("申请注销／拒赔>>>>>>>>>>>>>>>>>>>>>>{}", msg);
            }
            prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(), DateTime.YEAR_TO_DAY));
            prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(), DateTime.YEAR_TO_SECOND));
            prpLclaimDto.setCancelDate(new DateTime(claimCancleSubmitDto.getPrpLclaimDto().getCancelDate(), DateTime.YEAR_TO_DAY));
            // 取被保险人名称，对于团单需要显示名称
            String strInsuredNameShow = "";

        }
        return prpLclaimDto;
    }

    @Transactional(rollbackFor = Exception.class)
    private void saveCancel(ClaimDto1 claimDto) {
        String claimNo = "";
        PrpLClaim prpLclaim = convert(claimDto.getPrpLClaimDto(), PrpLClaim.class);
        prpLClaimDao.save(prpLclaim);
        if ("3220".equals(claimDto.getPrpLClaimDto().getRiskCode())
                || "3202".equals(claimDto.getPrpLClaimDto().getRiskCode())
                || "3223".equals(claimDto.getPrpLClaimDto().getRiskCode())
                || "3225".equals(claimDto.getPrpLClaimDto().getRiskCode())
                || "3233".equals(claimDto.getPrpLClaimDto().getRiskCode())) {
            if (claimDto.getPrpLClaimDto().getCancelDate() != null
                    && claimDto.getPrpLClaimDto().getCancelDate() != null) {
                List<PrpLEar> prplEarList = prpLEarDao.findAll(Specifications.<PrpLEar>and()
                        .eq(StringUtils.isNotEmpty(claimDto.getPrpLClaimDto().getRegistNo()), "registNo", claimDto.getPrpLClaimDto().getRegistNo()).build());
                if (null != prplEarList && prplEarList.size() > 0) {
                    for (PrpLEar prpLEar : prplEarList) {
                        prpLEar.setValidStatus("0");
                    }
                    prpLEarDao.save(prplEarList);
                }
            }
        }
        if (("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3186,3149,3150,3148,3174,3151,3152,3153,3154,3155,3156,3228,3190,3191,3132,3172,3194,3193,3187,3178,3176,3177,3161".indexOf(claimDto.getPrpLClaimDto().getRiskCode()) > -1)) {
            String settlelistcode = "";
            List<SettleMainListDto> settlemainlistDtoList = null;
            Map<String, String> listMap = new HashMap<String, String>();
            listMap.put("registerCode", prpLclaim.getClaimNo());
            settlemainlistDtoList = settleMainListApi.queryByRegisterCode(listMap);
            SettleMainListDto settlemainlistDto = null;
            if (null != settlemainlistDtoList && settlemainlistDtoList.size() > 0) {
                settlemainlistDto = settlemainlistDtoList.get(0);
                settlelistcode = settlemainlistDto.getSettleListCode();
                List<SettleMainListDto> settlemainlistDtoList1 = settleMainListApi
                        .queryByRegisterCodeAndValidity(new RegisterCoderDto(claimNo, "2"));
                if (null != settlemainlistDtoList1 && settlemainlistDtoList1.size() > 0) {
                    for (SettleMainListDto settleMainListDto : settlemainlistDtoList1) {
                        settleMainListDto.setValidity("4");
                        settleMainListApi.save(settleMainListDto);
                    }
                }
                List<PlantingSettleListDto> plantingSettlelistDtoList1 = plantingSettleListApi
                        .queryBySettlelistCodeAndValidity(new ValidityAndPKDto(settlelistcode, "1"));
                if (null != plantingSettlelistDtoList1 && plantingSettlelistDtoList1.size() > 0) {
                    for (PlantingSettleListDto plantingSettleListDto : plantingSettlelistDtoList1) {
                        plantingSettleListDto.setValidity("4");
                        plantingSettleListApi.save(plantingSettleListDto);
                    }
                }
            }
        }
        if ("3224,3201,3204,3232,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196"
                .indexOf(claimDto.getPrpLClaimDto().getRiskCode()) > -1) {
            String settlelistcode = "";
            List<SettleMainListDto> settlemainlistDtoList = null;
            Map<String, String> listMap = new HashMap<String, String>();
            listMap.put("registerCode", prpLclaim.getClaimNo());
            settlemainlistDtoList = settleMainListApi.queryByRegisterCode(listMap);
            SettleMainListDto settlemainlistDto = null;
            if (null != settlemainlistDtoList && settlemainlistDtoList.size() > 0) {
                settlemainlistDto = settlemainlistDtoList.get(0);
                settlelistcode = settlemainlistDto.getSettleListCode();
                // 少nyxSettlelist底层类及api等
                // String condition="update nyxSettlelist set validity='4' where
                // Settlelistcode='"+settlelistcode+"' and validity='1'";
                List<SettleMainListDto> settlemainlistDtoList1 = settleMainListApi
                        .queryByRegisterCodeAndValidity(new RegisterCoderDto(claimNo, "2"));
                if (null != settlemainlistDtoList1 && settlemainlistDtoList1.size() > 0) {
                    for (SettleMainListDto settleMainListDto : settlemainlistDtoList1) {
                        settleMainListDto.setValidity("4");
                        settleMainListApi.save(settleMainListDto);
                    }
                }
            }
        }
        String planting31FarmerListFlag = utiPlatConfigRuleApi.queryByPK("claim", "PLNATING_31_FARMER_LIST_FLAG", 1)
                .getRule();
        if (null != planting31FarmerListFlag
                && (planting31FarmerListFlag.indexOf(claimDto.getPrpLClaimDto().getRiskCode()) > -1)) {
            String settlelistcode = "";
            List<SettleMainListDto> settlemainlistDtoList = null;
            Map<String, String> listMap = new HashMap<String, String>();
            listMap.put("registerCode", prpLclaim.getClaimNo());
            settlemainlistDtoList = settleMainListApi.queryByRegisterCode(listMap);
            SettleMainListDto settlemainlistDto = null;
            if (null != settlemainlistDtoList && settlemainlistDtoList.size() > 0) {
                settlemainlistDto = settlemainlistDtoList.get(0);
                settlelistcode = settlemainlistDto.getSettleListCode();
                List<SettleMainListDto> settlemainlistDtoList1 = settleMainListApi
                        .queryByRegisterCodeAndValidity(new RegisterCoderDto(claimNo, "2"));
                if (null != settlemainlistDtoList1 && settlemainlistDtoList1.size() > 0) {
                    for (SettleMainListDto settleMainListDto : settlemainlistDtoList1) {
                        settleMainListDto.setValidity("4");
                        settleMainListApi.save(settleMainListDto);
                    }
                }
                List<PlantingSettleListDto> plantingSettlelistDtoList1 = plantingSettleListApi
                        .queryBySettlelistCodeAndValidity(new ValidityAndPKDto(settlelistcode, "1"));
                if (null != plantingSettlelistDtoList1 && plantingSettlelistDtoList1.size() > 0) {
                    for (PlantingSettleListDto plantingSettleListDto : plantingSettlelistDtoList1) {
                        plantingSettleListDto.setValidity("4");
                        plantingSettleListApi.save(plantingSettleListDto);
                    }
                }
            }
        }
        // 2,增加拒赔和注销赔案的原因
        if (claimDto.getPrpLltextDtoList() != null) {
            List<PrpLLText> prpLLTextList = prpLLTextDao
                    .findByClaimNoAndTextType(claimDto.getPrpLClaimDto().getClaimNo(), "10");
            if (null != prpLLTextList && prpLLTextList.size() > 0) {
                prpLLTextDao.delete(prpLLTextList);
            }
            List<PrpLLText> prpLLTextListSave = new ArrayList<PrpLLText>();
            for (PrpLLTextDto prpLLTextDto : claimDto.getPrpLltextDtoList()) {
                prpLLTextListSave.add(convert(prpLLTextDto, PrpLLText.class));
            }
            prpLLTextDao.save(prpLLTextListSave);
        }

        // 3,更新立案操作状态为已提交
        // 示例未完成
        String statement = "";
        if (claimDto.getPrpLclaimStatusDto() != null) {
            List<PrpLclaimStatus> prpLclaimStatusList = prpLclaimStatusDao.findAll(Specifications.<PrpLclaimStatus>and()
                    .eq(StringUtils.isNotEmpty(claimDto.getPrpLclaimStatusDto().getBusinessno()), "businessno", claimDto.getPrpLclaimStatusDto().getBusinessno())
                    .eq("nodetype", "claim").build());
            if (null != prpLclaimStatusList && prpLclaimStatusList.size() > 0) {
                prpLclaimStatusDao.delete(prpLclaimStatusList);
            }
            prpLclaimStatusDao.save(convert(claimDto.getPrpLclaimStatusDto(), PrpLclaimStatus.class));
        }

        if (claimDto.getPrpLRegistRPolicyDto() != null) {
            List<PrpLRegistRPolicy> prpLRegistRPolicyList = prpLRegistRPolicyDao.findAll(Specifications.<PrpLRegistRPolicy>and()
                    .eq(StringUtils.isNotEmpty(claimDto.getPrpLRegistRPolicyDto().getRegistNo()), "registNo", claimDto.getPrpLRegistRPolicyDto().getRegistNo())
                    .eq(StringUtils.isNotEmpty(claimDto.getPrpLRegistRPolicyDto().getPolicyNo()), "policyNo", claimDto.getPrpLRegistRPolicyDto().getPolicyNo()).build());
            if (null != prpLRegistRPolicyList && prpLRegistRPolicyList.size() > 0) {
                prpLRegistRPolicyDao.delete(prpLRegistRPolicyList);
            }
            prpLRegistRPolicyDao.save(convert(claimDto.getPrpLRegistRPolicyDto(), PrpLRegistRPolicy.class));
        }
    }
    private ClaimDto1 findByPrimaryKey(String claimNo) {
        ClaimDto1 claimDto = new ClaimDto1();
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        if (null == prpLClaim) {
            return null;
        }
        String registNo = prpLClaim.getRegistNo();
        claimDto.setPrpLClaimDto(convert(prpLClaim, PrpLClaimDtoExt.class));
        List<PrpLLText> prpLLTextlist = prpLLTextDao.findByClaimNo(claimNo);
        if (null != prpLLTextlist && prpLLTextlist.size() > 0) {
            List<PrpLLTextDto> prpLltextDtoList = new ArrayList<PrpLLTextDto>();
            for (PrpLLText prpLLText : prpLLTextlist) {
                prpLltextDtoList.add(convert(prpLLText, PrpLLTextDto.class));
            }
            claimDto.setPrpLltextDtoList(prpLltextDtoList);
        }
        List<PrpLDoc> prpLDoclist = prpLdocDao.findAll(Specifications.<PrpLDoc>and()
                .eq(StringUtils.isNotEmpty(claimNo), "claimNo", claimNo).build());
        if (null != prpLDoclist && prpLDoclist.size() > 0) {
            List<PrpLDocDto> prpLDocDtolist = new ArrayList<PrpLDocDto>();
            for (PrpLDoc prpLDoc : prpLDoclist) {
                prpLDocDtolist.add(convert(prpLDoc, PrpLDocDto.class));
            }
            claimDto.setPrpLdocDtoList(prpLDocDtolist);
        }
        List<PrpLClaimFee> prpLclaimFeelist = prpLclaimFeeDao.findAll(Specifications.<PrpLClaimFee>and()
                .eq(StringUtils.isNotEmpty(claimNo), "claimNo", claimNo).build());
        if (null != prpLclaimFeelist && prpLclaimFeelist.size() > 0) {
            List<PrpLClaimFeeDto> prpLClaimFeelist = new ArrayList<PrpLClaimFeeDto>();
            for (PrpLClaimFee prpLClaimFee : prpLclaimFeelist) {
                prpLClaimFeelist.add(convert(prpLClaimFee, PrpLClaimFeeDto.class));
            }
            claimDto.setPrpLclaimFeeDtoList(prpLClaimFeelist);
        }
        List<PrpLClaimLoss> prpLclaimLosslist = prpLclaimLossDao.findByClaimNo(claimNo);
        if (null != prpLclaimLosslist && prpLclaimLosslist.size() > 0) {
            List<PrpLClaimLossDto> prpLclaimLossDtolist = new ArrayList<PrpLClaimLossDto>();
            for (PrpLClaimLoss prpLClaimLoss : prpLclaimLosslist) {
                prpLclaimLossDtolist.add(convert(prpLClaimLoss, PrpLClaimLossDto.class));
            }
            claimDto.setPrpLclaimLossDtoList(prpLclaimLossDtolist);
        }
        List<PrpLclaimStatus> prpLclaimStatuslist = prpLclaimStatusDao.findByCondition(claimNo, 0, "claim");
        if (null != prpLclaimStatuslist && prpLclaimStatuslist.size() > 0) {
            PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
            for (PrpLclaimStatus prpLclaimStatus : prpLclaimStatuslist) {
                prpLclaimStatusDto = convert(prpLclaimStatus, PrpLclaimStatusDto.class);
            }
            claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        }
        List<PrpLAccIPerson> prpLAccIBenPersonList = prpLAccIPersonDao.findAll(Specifications.<PrpLAccIPerson>and()
                .eq(StringUtils.isNotEmpty(registNo), "certiNo", registNo).build());
        if (null != prpLAccIBenPersonList && prpLAccIBenPersonList.size() > 0) {
            List<PrpLAccIPersonDto> prpLAccIPersonDtoList = new ArrayList<PrpLAccIPersonDto>();
            for (PrpLAccIPerson prpLAccIPerson : prpLAccIBenPersonList) {
                prpLAccIPersonDtoList.add(convert(prpLAccIPerson, PrpLAccIPersonDto.class));
            }
            claimDto.setPrplacciBenPersonDtoList(prpLAccIPersonDtoList);
        }
        List<PrpLAccIPerson> prpLAccIPersonList = prpLAccIPersonDao.findAll(Specifications.<PrpLAccIPerson>and()
                .eq(StringUtils.isNotEmpty(registNo), "certiNo", registNo)
                .eq("flag", "1").build());
        if (null != prpLAccIPersonList && prpLAccIPersonList.size() > 0) {
            List<PrpLAccIPersonDto> prpLAccIPersonDtoList = new ArrayList<PrpLAccIPersonDto>();
            for (PrpLAccIPerson prpLAccIPerson : prpLAccIPersonList) {
                prpLAccIPersonDtoList.add(convert(prpLAccIPerson, PrpLAccIPersonDto.class));
            }
            claimDto.setPrpLacciPersonDtoList(prpLAccIPersonDtoList);
        }
        String policyNo = prpLClaim.getPolicyNo();
        List<PrpLRegistExt> prpLregistExtList = prpLregistExtDao.queryByRegistNo(registNo);
        if (null != prpLregistExtList && prpLregistExtList.size() > 0) {
            List<PrpLRegistExtDto> prpLRegistExtDtoList = new ArrayList<PrpLRegistExtDto>();
            for (PrpLRegistExt prpLRegistExt : prpLregistExtList) {
                prpLRegistExtDtoList.add(convert(prpLRegistExt, PrpLRegistExtDto.class));
            }
            claimDto.setPrpLregistExtDtoList(prpLRegistExtDtoList);
        }
        List<PrpLext> prpLextList = prpLextDao.findAll(Specifications.<PrpLext>and()
                .eq(StringUtils.isNotEmpty(claimNo), "certiNo", claimNo)
                .eq("certiType", "03").build());
        if (null != prpLextList && prpLextList.size() > 0) {
            PrpLextDto prpLextDto = new PrpLextDto();
            for (PrpLext prpLext : prpLextList) {
                prpLextDto = convert(prpLext, PrpLextDto.class);
            }
            claimDto.setPrpLextDto(prpLextDto);
        }
        List<PrpLPrepay> prpLPrepayList = prpLprepayDao.findAll(Specifications.<PrpLPrepay>and()
                .eq(StringUtils.isNotEmpty(claimNo), "claimNo", claimNo).build());
        if (null != prpLregistExtList && prpLregistExtList.size() > 0) {
            List<PrpLPrepayDto> prpLprepayDtoList = new ArrayList<PrpLPrepayDto>();
            for (PrpLPrepay prpLPrepay : prpLPrepayList) {
                prpLprepayDtoList.add(convert(prpLPrepay, PrpLPrepayDto.class));
            }
            claimDto.setPrpLprepayDtoList(prpLprepayDtoList);
        }
        return claimDto;
    }


    /**
     * @description: 保存立案估损金额
     * @author 陈旭
     * @date 2017-11-22 15:39:53.061
     * @param modifySumClaimDto
     * @return
     * @throw Exception
     */
    @Transactional
    @Override
    public Map<String, String> saveModify(ModifySaveClaimLossDto modifySaveClaimLossDto)throws Exception {
        List<PrpLClaimLossDto> prpLClaimLossDtoList = modifySaveClaimLossDto.getPrpLclaimLossDtoList();
        String claimNo = modifySaveClaimLossDto.getClaimNo();
        // 修改估损金额信息
        String claimLossNo = "";
        double sumClaimLoss = 0;
        // 删除记录
//				PrpLClaimLoss prpLclaimLoss = new PrpLClaimLoss();
//				prpLClaimLoss.setClaimNo(claimno);
//				prpLClaimLossDao.delete(prpLclaimLoss);

        // 插入记录多条数据
        if(modifySaveClaimLossDto.getPrpLclaimLossDtoList() != null && modifySaveClaimLossDto.getPrpLclaimLossDtoList().size() > 0){
            for (PrpLClaimLossDto prpLClaimLossDto : prpLClaimLossDtoList) {
                sumClaimLoss = sumClaimLoss + prpLClaimLossDto.getSumClaim();
            }
        }
        prpLClaimLossDao.deleteByClaimNo(claimNo);
        List<PrpLClaimLoss> prpLClaimLossList = new ArrayList<>();
        convertCollection(prpLClaimLossDtoList, prpLClaimLossList, PrpLClaimLoss.class);
        prpLClaimLossDao.save(prpLClaimLossList);
        // 更新立案表中的险别估损金额
        PrpLClaim claimDto = prpLClaimDao.findOne(new PrpLClaimKey(claimNo));
        claimDto.setSumClaim(sumClaimLoss);
        prpLClaimDao.save(claimDto);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message","保存成功！！！");
        return map;
    }

    /**
     * （生成危险单位）
     * @author: 王志文
     * @date: 2018/4/11 18:20
     * @param claimNo
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void getLDangerInfoNewL(String claimNo) throws Exception {
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        String policyNo = prpLClaim.getPolicyNo();
        Map<String,String> map = new HashMap<>();
        map.put("policyNo",policyNo);
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(endorseNo) FROM PrpPhead ");
        int count=0;
        if (StringUtils.isNotEmpty(policyNo) && prpLClaim.getDamageStartDate()!= null){
            Map<String,Object> paraMap = new HashMap<>();
            paraMap.put("policyNo",policyNo);
            paraMap.put("damageStartDate",prpLClaim.getDamageStartDate());
            stringBuilder.append(" where policyno=:policyNo and validdate <=:damageStartDate and underwriteflag in ('1','3') ");
            Query query = entityManager.createNativeQuery(stringBuilder.toString());
            this.setQueryParam(query,paraMap);
            BigDecimal result = (BigDecimal)query.getSingleResult();
            count = Integer.valueOf(result.toString());
        }
        Map<String,String> kindMap = new HashMap<>();
        //根据标的序号查询数据库危险单位信息
        List<NewDangerUnitDto> prpdangerUnitList = new ArrayList<>();
        List<PrpLClaimLoss> prpLClaimLosseList = prpLclaimLossDao.findByClaimNo(claimNo);
        for(PrpLClaimLoss prpLClaimLoss:prpLClaimLosseList){
            if(kindMap.containsKey(prpLClaimLoss.getItemKindNo()+"") && "P".equals(prpLClaimLoss.getLossFeeType())){ //赔款部分
                String tempSumLoss=String.valueOf((Double.parseDouble(prpLClaimLoss.getSumClaim()+"")+Double.parseDouble("" + kindMap.get(prpLClaimLoss.getItemKindNo()+""))));
                kindMap.put(prpLClaimLoss.getItemKindNo()+"", tempSumLoss);
            }else if(kindMap.containsKey("f"+prpLClaimLoss.getItemKindNo()+"") && "Z".equals(prpLClaimLoss.getLossFeeType())){ //费用部分
                String tempSumLossFee=String.valueOf((Double.parseDouble(prpLClaimLoss.getSumClaim()+"")+Double.parseDouble("" + kindMap.get("f"+prpLClaimLoss.getItemKindNo()))));
                kindMap.put("f"+prpLClaimLoss.getItemKindNo(), tempSumLossFee);
            }else{
                String itemKindNo = "";
                if (prpLClaimLoss.getItemKindNo() != null){
                    itemKindNo = ""+prpLClaimLoss.getItemKindNo()+"";
                }
                if(count==0){
                    List<NewDangerUnitDto> prpdangerUnitTempList=this.getPrpCdangerUnit(policyNo,itemKindNo);
                    prpdangerUnitList.addAll(prpdangerUnitTempList);
                }else{
                    List<NewDangerUnitDto> prpdangerUnitTempList=this.getPrpPdangerUnit(prpLClaim.getRegistNo(), policyNo, itemKindNo);
                    prpdangerUnitList.addAll(prpdangerUnitTempList);
                }
                if("Z".equals(prpLClaimLoss.getLossFeeType())){
                    kindMap.put("f"+prpLClaimLoss.getItemKindNo(), prpLClaimLoss.getSumClaim()+"");
                }else{
                    kindMap.put(prpLClaimLoss.getItemKindNo()+"", prpLClaimLoss.getSumClaim()+"");
                }
            }

        }
        //危险单位估损金额按照标的序号最后一位减法原则处理
        double dbSumLoss = 0D;
        double dbSumLossFee = 0D;
        double dbshare = 0D;
        double tempSumLoss=0D;
        double tempSumLossFee=0D;
        //判断标的序号是否是此危险单位的最后一个
        boolean flag = false;
        NewDangerUnitDto  newDangerUnitDto=null;
        NewDangerUnitDto  newDangerUnitDtoTemp=null;
        for(int i=0;i<prpdangerUnitList.size();i++){
            newDangerUnitDto= (NewDangerUnitDto)prpdangerUnitList.get(i);
            dbSumLoss = Double.parseDouble(Str.chgStrZero("" + kindMap.get(newDangerUnitDto.getItemkindno())));
            if(kindMap.containsKey("f"+newDangerUnitDto.getItemkindno())){
                dbSumLossFee = Double.parseDouble(Str.chgStrZero("" + kindMap.get("f"+newDangerUnitDto.getItemkindno())));
            }
            dbSumLoss = dbSumLoss + dbSumLossFee ; //赔付金额=赔款 + 费用
            dbshare = Double.parseDouble(Str.chgStrZero(newDangerUnitDto.getDangerkindshare()));
            flag = false;

            for(int j=i+1;j<prpdangerUnitList.size();j++){ //寻找i往后的危险单位有无重复的
                newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(j);
                if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
                    flag = true;
                    break;
                }
            }
            if(flag){ //如果i往后的危险单位有重复的，则按比例计算未决赔款金额
                dbSumLoss = Str.round((dbSumLoss * (dbshare/100)),2);
                dbSumLossFee = Str.round((dbSumLossFee * (dbshare/100)),2);
                newDangerUnitDto.setDangerkindAmount(""+dbSumLoss);
                newDangerUnitDto.setDangerkindFee(""+dbSumLossFee);
            }else{ //如果i往前的危险单位有重复的，则此危险单位当做最后一个，做差
                tempSumLoss = 0;
                tempSumLossFee = 0;
                for(int k=0;k<i;k++){
                    newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(k);
                    if(newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())){
                        tempSumLoss+=Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindAmount()));
                        tempSumLossFee+=Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindFee()));
                    }
                }
                newDangerUnitDto.setDangerkindAmount(""+Str.round((dbSumLoss-tempSumLoss),2));
                newDangerUnitDto.setDangerkindFee(""+Str.round((dbSumLossFee-tempSumLossFee),2));
            }
        }

        String strCoinsFlag = prpCmainDto.getCoinsFlag();
        ArrayList  dangerUnitList = new ArrayList();
        ArrayList  dangerItemList = new ArrayList();
        ArrayList  dangerTotList = new ArrayList();

        double temp=0;
        double sumDangerUnit=0d;
        flag=true;
        NewDangerUnitDto  newDangerUnitDto1=null;
        PrpLDangerItemDto prpLdangerItemDto=null;
        for(int index=0;index<prpdangerUnitList.size();index++){
            newDangerUnitDto1 = prpdangerUnitList.get(index);
            if (Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()) != 0
                    && Double.parseDouble(newDangerUnitDto1.getDangerkindshare()) != 0) {
                prpLdangerItemDto = new PrpLDangerItemDto();
                prpLdangerItemDto.setCertiNo(claimNo); // 立案号
                prpLdangerItemDto.setDangerNo(Integer.parseInt(newDangerUnitDto1.getDangerno())); // 危险单位
                prpLdangerItemDto.setCurrency(newDangerUnitDto1.getCurrency()); // 损失币别
                prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
                prpLdangerItemDto.setKindCode(newDangerUnitDto1.getKindcode());
                prpLdangerItemDto.setKindName(newDangerUnitDto1.getKindname());
                prpLdangerItemDto.setRiskCode(newDangerUnitDto1.getRiskcode());
                prpLdangerItemDto.setAddressName(newDangerUnitDto1.getAddressname());
                prpLdangerItemDto.setPolicyNo(newDangerUnitDto1.getPolicyno());
                prpLdangerItemDto.setDangerDesc(newDangerUnitDto1.getDangerdesc());
                prpLdangerItemDto.setItemCode(newDangerUnitDto1.getItemcode());
                prpLdangerItemDto.setItemName(newDangerUnitDto1.getItemname());
                prpLdangerItemDto.setClaimAddTimes(0);
                // 占比最后一个减法原则
                flag = true;
                for (int i = index + 1; i < prpdangerUnitList.size(); i++) {
                    NewDangerUnitDto newDangerUnitDtoI = prpdangerUnitList.get(i);
                    if (newDangerUnitDto1.getItemkindno().equals(newDangerUnitDtoI.getItemkindno())) {
                        flag = false;
                    }
                }
                if (flag) {
                    temp = 0;
                    for (int k = 0; k < index; k++) {
                        NewDangerUnitDto newDangerUnitDtok = prpdangerUnitList.get(k);
                        if (newDangerUnitDtok.getItemkindno().equals(newDangerUnitDto1.getItemkindno())) {
                            temp += Str.round(Double.parseDouble(newDangerUnitDtok.getDangerkindshare()), 2);
                        }
                    }
                    prpLdangerItemDto.setDangerKindShare(Str.round(100 - temp, 2));
                } else {
                    prpLdangerItemDto.setDangerKindShare(Double.parseDouble(newDangerUnitDto1.getDangerkindshare()));
                }
                prpLdangerItemDto.setSumPaid(Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()), 2));
                prpLdangerItemDto.setSumFee(Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindFee()), 2));
                prpLdangerItemDto.setSerialNo(Integer.parseInt(newDangerUnitDto1.getItemkindno())); // 标的序号
                sumDangerUnit += Str.round(Double.parseDouble(newDangerUnitDto1.getDangerkindAmount()), 2);
                // 加入集合
                if (prpLdangerItemDto != null) {
                    dangerItemList.add(prpLdangerItemDto);
                }
            }
        }
        Iterator iterator = null;
        PrpLDangerTotDto prpLdangerTotDto = null;
        Iterator itTot = null;
        boolean find = true;
        if (dangerItemList != null) {
            iterator = dangerItemList.iterator();
            while (iterator.hasNext()) {
                prpLdangerItemDto = (PrpLDangerItemDto) iterator.next();
                find = false;
                itTot = dangerTotList.iterator();
                while (itTot.hasNext()) {
                    prpLdangerTotDto = (PrpLDangerTotDto) itTot.next();
                    if (prpLdangerTotDto.getDangerNo() == prpLdangerItemDto
                            .getDangerNo()) {
                        find = true;
                        prpLdangerTotDto.setSumPaid(Str.round(prpLdangerTotDto.getSumPaid()
                                + prpLdangerItemDto.getSumPaid(), 2));
                        prpLdangerTotDto.setSumFee(Str.round(prpLdangerTotDto.getSumFee()
                                + prpLdangerItemDto.getSumFee(), 2));
                        prpLdangerTotDto.setSumPaidEx(Str.round(prpLdangerTotDto.getSumPaidEx()
                                + prpLdangerItemDto.getSumPaid(), 2));
                        prpLdangerTotDto.setSumFeeEx(Str.round(prpLdangerTotDto.getSumFeeEx()
                                + prpLdangerItemDto.getSumFee(), 2));
                        break;
                    }
                }
                // 每个危险单位标的的第一次数据的生成
                if (find == false) {
                    prpLdangerTotDto = new PrpLDangerTotDto();

                    prpLdangerTotDto.setCertiNo(claimNo);
                    prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());
                    prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency()); // 标的原币别
                    prpLdangerTotDto.setSumFee(prpLdangerItemDto.getSumFee());
                    prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
                    prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
                    prpLdangerTotDto.setExchRate(1.0);
                    prpLdangerTotDto.setSumFeeEx(prpLdangerItemDto.getSumFee());
                    prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
                    prpLdangerTotDto.setClaimAddTimes(0);
                    // 加入集合
                    if (prpLdangerTotDto != null) {
                        dangerTotList.add(prpLdangerTotDto);
                    }
                }
            }
        }

        // 3、生成危险单位prpLdangerUnit
        Iterator itUnit = null;
        PrpLDangerUnitDto prpLdangerUnitDto = null;
        if (dangerItemList != null) {
            iterator = dangerItemList.iterator();
            while (iterator.hasNext()) {
                prpLdangerItemDto = (PrpLDangerItemDto) iterator.next();
                find = false;
                itUnit = dangerUnitList.iterator();
                while (itUnit.hasNext()) {
                    prpLdangerUnitDto = (PrpLDangerUnitDto) itUnit.next();
                    if (prpLdangerUnitDto.getDangerNo() == prpLdangerItemDto.getDangerNo()) {
                        find = true;
                        prpLdangerUnitDto.setSumLoss(Str.round(prpLdangerUnitDto.getSumLoss()
                                        + prpLdangerItemDto.getSumPaid(), 2));
                        prpLdangerUnitDto.setSumFee(Str.round(prpLdangerItemDto.getSumFee(), 2));
                        prpLdangerUnitDto.setSumNoPaid(Str.round(prpLdangerUnitDto.getSumLoss(), 2));
                        break;
                    }
                }
                // 每个危险单位标的的第一次数据的生成
                if (find == false) {
                    prpLdangerUnitDto = new PrpLDangerUnitDto();
                    prpLdangerUnitDto.setCertiNo(claimNo);
                    prpLdangerUnitDto.setClaimNo(claimNo);
                    prpLdangerUnitDto.setCertiType("1");
                    prpLdangerUnitDto.setRiskCode(prpLdangerItemDto.getRiskCode());
                    prpLdangerUnitDto.setPolicyNo(prpLdangerItemDto.getPolicyNo());
                    prpLdangerUnitDto.setDangerNo(prpLdangerItemDto.getDangerNo());
                    prpLdangerUnitDto.setDangerDesc(prpLdangerItemDto.getDangerDesc());
                    prpLdangerUnitDto.setAddressName(prpLdangerItemDto.getAddressName());
                    prpLdangerUnitDto.setCurrency(prpLdangerItemDto.getCurrency());
                    prpLdangerUnitDto.setSumLoss(prpLdangerItemDto.getSumPaid());
                    prpLdangerUnitDto.setSumPaid(0.0);
                    prpLdangerUnitDto.setSumNoPaid(prpLdangerItemDto.getSumPaid());
                    prpLdangerUnitDto.setSumFee(prpLdangerItemDto.getSumFee());
                    prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);
                    prpLdangerUnitDto.setDamageDate(prpLClaim.getDamageStartDate());
                    prpLdangerUnitDto.setClaimDate(prpLClaim.getClaimDate());
                    prpLdangerUnitDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
                    prpLdangerUnitDto.setBusinessNature(prpCmainDto.getBusinessNature());
                    prpLdangerUnitDto.setBusinessType(prpCmainDto.getBusinessType());
                    prpLdangerUnitDto.setBusinessType1(prpCmainDto.getBusinessType1());
                    prpLdangerUnitDto.setPolicyBizType(prpCmainDto.getPolicyBizType());
                    prpLdangerUnitDto.setPolicyType(prpCmainDto.getPolicyType());
                    prpLdangerUnitDto.setOthFlag(prpCmainDto.getOthFlag());
                    prpLdangerUnitDto.setBusinessProvince(prpCmainDto.getBusinessProvince());
                    prpLdangerUnitDto.setBusinessTown(prpCmainDto.getBusinessTown());
                    prpLdangerUnitDto.setBusinessCounty(prpCmainDto.getBusinessCounty());
                    prpLdangerUnitDto.setBusinessAreaName(prpCmainDto.getBusinessAreaName());
                    prpLdangerUnitDto.setClaimAddTimes(0);
                    // 加入集合
                    if (prpLdangerUnitDto != null) {
                        dangerUnitList.add(prpLdangerUnitDto);
                    }
                }
            }
            // 最后一个占比减法原则
            double dangerShare = 0;
            double tempSumDangerShare = 0;
            PrpLDangerUnitDto prpLdangerUnitDtotemp = null;
            for (int i = 0; i < dangerUnitList.size(); i++) {
                prpLdangerUnitDtotemp = (PrpLDangerUnitDto) dangerUnitList.get(i);
                if (i == (dangerUnitList.size() - 1)) {
                    dangerShare = Str.round(100 - tempSumDangerShare, 2);
                } else {
                    dangerShare = Str.round(prpLdangerUnitDtotemp.getSumLoss() / sumDangerUnit * 100, 2);
                    tempSumDangerShare = Str.round(tempSumDangerShare + dangerShare, 2);
                }
                prpLdangerUnitDtotemp.setDangerShare(dangerShare);
            }
        }

        // 获取实赔信息
        prpLDangerCoinsDao.deleteByCertiNo(claimNo);
        prpLDangerTotDao.deleteByCertiNo(claimNo);
        prpLDangerItemDao.deleteByCertiNo(claimNo);
        prpLDangerUnitDao.deleteByCertiNo(claimNo);

        // 保存新生成的数据
        if (dangerUnitList != null) {
            Iterator iterator1 = dangerUnitList.iterator();
            while (iterator1.hasNext()) {
                prpLdangerUnitDto = (PrpLDangerUnitDto) iterator1.next();
                prpLdangerUnitDto.setClaimAddTimes(0);
                prpLDangerUnitDao.save(this.convert(prpLdangerUnitDto,PrpLDangerUnit.class));
            }
        }
        if (dangerItemList != null) {
            Iterator iterator1 = dangerItemList.iterator();
            while (iterator1.hasNext()) {
                PrpLDangerItemDto prpLdangerItemDto1 = new PrpLDangerItemDto();
                prpLdangerItemDto1 = (PrpLDangerItemDto) iterator1.next();
                prpLdangerItemDto1.setClaimAddTimes(0);
                prpLDangerItemDao.save(this.convert(prpLdangerItemDto1,PrpLDangerItem.class));
            }
        }
        if (dangerTotList != null) {
            Iterator iterator1 = dangerTotList.iterator();
            while (iterator1.hasNext()) {
                PrpLDangerTotDto prpLdangerTotDto1 = new PrpLDangerTotDto();
                prpLdangerTotDto1 = (PrpLDangerTotDto) iterator1.next();
                prpLdangerTotDto1.setClaimAddTimes(0);
                prpLDangerTotDao.save(this.convert(prpLdangerTotDto1,PrpLDangerTot.class));
            }
        }
    }

    private List<NewDangerUnitDto> getPrpCdangerUnit(String policyNo,String itemKindNo){
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("policyNo",policyNo);
        paraMap.put("itemKindNo",itemKindNo);
        StringBuilder stringBuilder =new StringBuilder("  select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname "
                + " from prpcdangeritem m, prpcdangerunit t "
                + " where m.policyno =:policyNo "
                + "  and m.policyno = t.policyno "
                + " and m.dangerno = t.dangerno "
                + " and m.serialno =:itemKindNo "
                +" order by t.dangerno,m.serialno ");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        this.setQueryParam(query,paraMap);
        NewDangerUnitDto newDangerUnitDto ;
        List<NewDangerUnitDto> newDangerUnitDtoList = new ArrayList<>();
        List<Object[]> objectList = query.getResultList();
        if (objectList.size()>0){
            for (Object[] object:objectList){
                newDangerUnitDto= new NewDangerUnitDto();
                newDangerUnitDto.setPolicyno((String)object[10]);
                newDangerUnitDto.setRiskcode((String)object[11]);
                BigDecimal dangerNo = (BigDecimal) object[0];
                newDangerUnitDto.setDangerno(dangerNo.toString());
                newDangerUnitDto.setKindcode((String)object[3]);
                newDangerUnitDto.setKindname((String)object[4]);
                newDangerUnitDto.setDangerdesc((String)object[1]);
                newDangerUnitDto.setAddressname((String)object[2]);
                BigDecimal dangerkindshare = (BigDecimal)object[6];
                newDangerUnitDto.setDangerkindshare(dangerkindshare.toString());
                newDangerUnitDto.setCurrency((String)object[5]);
                newDangerUnitDto.setItemcode((String)object[7]);
                newDangerUnitDto.setItemname((String)object[8]);
                BigDecimal itemKindno = (BigDecimal) object[9];
                newDangerUnitDto.setItemkindno(itemKindno.toString());
                newDangerUnitDto.setBusinessNature((String)object[12]);
                newDangerUnitDto.setPolicyBizType((String)object[13]);
                newDangerUnitDto.setPolicyType((String)object[14]);
                newDangerUnitDto.setOthFlag((String)object[17]);
                newDangerUnitDto.setBusinessType((String)object[16]);
                newDangerUnitDto.setBusinessType1((String)object[15]);
                newDangerUnitDto.setBusinessProvince((String)object[18]);
                newDangerUnitDto.setBusinessTown((String)object[19]);
                newDangerUnitDto.setBusinessCounty((String)object[20]);
                newDangerUnitDto.setBusinessAreaName((String)object[21]);
                newDangerUnitDtoList.add(newDangerUnitDto);
            }
        }
        return newDangerUnitDtoList;
    }

    private List<NewDangerUnitDto> getPrpPdangerUnit(String registNo,String policyNo,String itemKindNo){
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("registNo",registNo);
        paraMap.put("policyNo",policyNo);
        StringBuilder stringBuilder = new StringBuilder("select endorseNo from (select rownum as rn, phead.* from (select endorseNo from prpphead h  " +
                "where h.validdate <=(select t.damagestartdate"
                + " from prplregist t"
                + " where registno =:registNo) "
                + " and policyno =:policyNo "
                + " and underwriteflag in ('1','3') "
                + "  order by h.endorsetimes desc ) phead)" + " where rn = 1");
        StringBuilder sqlp = new StringBuilder("");
        Query query = entityManager.createNativeQuery(stringBuilder.toString());
        this.setQueryParam(query,paraMap);
        List<Object[]> objects = query.getResultList();
        if (objects.size()>0) {
            sqlp.append( "select t.dangerno,t.dangerdesc,t.addressname,m.kindcode,m.kindname,t.currency,m.dangerkindshare,m.itemcode,m.itemdetailname,m.serialno,t.policyno,t.riskcode, nvl(t.businessnature,'') as businessnature,nvl(t.policybiztype,'') as policybiztype ,nvl(t.policytype,'') as policytype,nvl(t.businesstype1,'') as businesstype1,nvl(t.businesstype,'') as businesstype,nvl(t.othflag,'') as othflag,nvl(t.businessprovince,'') as businessprovince,nvl(t.businesstown,'') as businesstown,nvl(t.businesscounty,'') as businesscounty,nvl(t.businessareaname,'') as businessareaname ")
                    .append(" from prppdangeritem m, prppdangerunit t").append(" where m.endorseno = '").append(objects.get(0)[0]).append("' and m.endorseno = t.endorseno")
                    .append(" and m.dangerno = t.dangerno").append(" and m.serialno ='").append(itemKindNo).append("' order by t.dangerno,m.serialno");
        }
        Query query1 = entityManager.createNativeQuery(sqlp.toString());
        List<Object[]> objects1 = query1.getResultList();
        NewDangerUnitDto  newDangerUnitDto= null;
        List<NewDangerUnitDto> newDangerUnitDtos = new ArrayList();
        if (objects1.size()>0) {
            for (Object[] object:objects1){
                newDangerUnitDto= new NewDangerUnitDto();
                newDangerUnitDto.setPolicyno((String)object[10]);
                newDangerUnitDto.setRiskcode((String)object[11]);
                BigDecimal dangerNo = (BigDecimal) object[0];
                newDangerUnitDto.setDangerno(dangerNo.toString());
                newDangerUnitDto.setKindcode((String)object[3]);
                newDangerUnitDto.setKindname((String)object[4]);
                newDangerUnitDto.setDangerdesc((String)object[1]);
                newDangerUnitDto.setAddressname((String)object[2]);
                BigDecimal dangerkindshare = (BigDecimal)object[6];
                newDangerUnitDto.setDangerkindshare(dangerkindshare.toString());
                newDangerUnitDto.setCurrency((String)object[5]);
                newDangerUnitDto.setItemcode((String)object[7]);
                newDangerUnitDto.setItemname((String)object[8]);
                BigDecimal itemKindno = (BigDecimal) object[9];
                newDangerUnitDto.setItemkindno(itemKindno.toString());
                newDangerUnitDto.setBusinessNature((String)object[12]);
                newDangerUnitDto.setPolicyBizType((String)object[13]);
                newDangerUnitDto.setPolicyType((String)object[14]);
                newDangerUnitDto.setOthFlag((String)object[17]);
                newDangerUnitDto.setBusinessType((String)object[16]);
                newDangerUnitDto.setBusinessType1((String)object[15]);
                newDangerUnitDto.setBusinessProvince((String)object[18]);
                newDangerUnitDto.setBusinessTown((String)object[19]);
                newDangerUnitDto.setBusinessCounty((String)object[20]);
                newDangerUnitDto.setBusinessAreaName((String)object[21]);
                newDangerUnitDtos.add(newDangerUnitDto);
            }
        }
        return newDangerUnitDtos;
    }

    /**
     * （生成危险单位）
     * @author: 王志文
     * @date: 2018/4/11 18:20
     * @param prpLclaimDto
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void getLDangerInfo(PrpLClaimDto prpLclaimDto) throws Exception {
        // DBManager dbManager = new DBManager();
        // FIX0313 modify by zhupengju end
        Collection prpLdangerUnitDtoList = new ArrayList();
        //add begin by zhaijq 20060404 存储联共保信息
        DecimalFormat idecimalFormat = new DecimalFormat("0.00");
        List<PrpLDangerCoinsDto> prpLdangerCoinsDtoList  = new ArrayList<>();
        PrpLDangerCoinsDto prpLdangerCoinsDto = null;
        // 获取实赔信息
        //add begin by zhaijq 20060404 存储联共保标志
        Map<String,String> map = new HashMap<>();
        map.put("policyNo",prpLclaimDto.getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
        //add end by zhaijq 20060404

        // 生成PrpLdangerUnit数据
        PrpLDangerUnitDto prpLdangerUnitDto = new PrpLDangerUnitDto();
        prpLdangerUnitDto.setCertiNo(prpLclaimDto.getClaimNo());
        prpLdangerUnitDto.setClaimNo(prpLclaimDto.getClaimNo());
        prpLdangerUnitDto.setCertiType("1");
        prpLdangerUnitDto.setReinsureFlag("0");
        prpLdangerUnitDto.setRiskCode(prpLclaimDto.getRiskCode());
        prpLdangerUnitDto.setPolicyNo(prpLclaimDto.getPolicyNo());
        prpLdangerUnitDto.setDangerNo(1);
        prpLdangerUnitDto.setDangerDesc("");
        prpLdangerUnitDto.setAddressName("");
        prpLdangerUnitDto.setCurrency(prpLclaimDto.getCurrency());
        prpLdangerUnitDto.setSumLoss(prpLclaimDto.getSumClaim());
        prpLdangerUnitDto.setSumNoPaid(prpLclaimDto.getSumClaim());
        // 从立案获取实赔
        prpLdangerUnitDto.setDangerShare(100.0);
        //add begin by zhaijq 20060404 存储联共保标志
        prpLdangerUnitDto.setCoinsFlag(prpCmainDto.getCoinsFlag());
        prpLdangerUnitDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
        prpLdangerUnitDto.setShareHolderFlag(prpCmainDto.getShareholderFlag());

        prpLdangerUnitDto.setBusinessFlag(prpCmainDto.getBusinessFlag());
        prpLdangerUnitDto.setBusinessNature(prpCmainDto.getBusinessNature());
        prpLdangerUnitDto.setBusinessType(prpCmainDto.getBusinessType());
        prpLdangerUnitDto.setBusinessType1(prpCmainDto.getBusinessType1());
        prpLdangerUnitDto.setPolicyBizType(prpCmainDto.getPolicyBizType());
        prpLdangerUnitDto.setPolicyType(prpCmainDto.getPolicyType());
        prpLdangerUnitDto.setOthFlag(prpCmainDto.getOthFlag());
        prpLdangerUnitDto.setBusinessProvince(prpCmainDto.getBusinessProvince());
        prpLdangerUnitDto.setBusinessTown(prpCmainDto.getBusinessTown());
        prpLdangerUnitDto.setBusinessCounty(prpCmainDto.getBusinessCounty());
        prpLdangerUnitDto.setBusinessAreaName(prpCmainDto.getBusinessAreaName());
        prpLdangerUnitDto.setClaimAddTimes(0);
        //add end by zhaijq 20060404
        prpLdangerUnitDtoList.add(prpLdangerUnitDto);

        //add begin by zhaijq 20060404 联共保业务生成赔案危险单位的联共保信息
        double     baseRate = 0d; //我司共保比例
        StringBuilder prpcdangerSQl = new StringBuilder("SELECT p.* FROM PrpCdangerCoins p WHERE p.policyNo=:policyNo ");
        Query query = entityManager.createNativeQuery(prpcdangerSQl.toString());
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("policyNo",prpLclaimDto.getPolicyNo());
        this.setQueryParam(query,paraMap);
        List<Object[]> objects = query.getResultList();
        if (objects != null && objects.size()>0) {
            for (Object [] object :objects){
                if (object[6].equals("1") || object[6].equals("2"))
                {
                    baseRate = baseRate + Double.valueOf(((BigDecimal)object[7]).toString());
                }
            }
        }
        if (!prpLdangerUnitDto.getCoinsFlag().equals("0")) {
            if (objects != null && objects.size()>0) {
                for (Object[] object : objects) {
                    prpLdangerCoinsDto = new PrpLDangerCoinsDto();
                    prpLdangerCoinsDto.setCertiNo(prpLdangerUnitDto.getCertiNo());
                    prpLdangerCoinsDto.setDangerNo(prpLdangerUnitDto.getDangerNo());
                    prpLdangerCoinsDto.setSerialNo(Integer.valueOf(((BigDecimal)object[2]).toString()));
                    prpLdangerCoinsDto.setMainCertiNo(prpLdangerUnitDto.getCertiNo());
                    prpLdangerCoinsDto.setCoinsCode((String) object[4]);
                    prpLdangerCoinsDto.setCoinsName((String) object[5]);
                    prpLdangerCoinsDto.setCoinsType((String) object[6]);
                    prpLdangerCoinsDto.setCoinsRate(Double.valueOf(((BigDecimal)object[7]).toString()));
                    prpLdangerCoinsDto.setChiefFlag((String) object[8]);
                    prpLdangerCoinsDto.setCurrency(prpLdangerUnitDto.getCurrency());
                    prpLdangerCoinsDto.setFlag("");
                    prpLdangerCoinsDto.setClaimAddTimes(0);
                    prpLdangerCoinsDto.setCoinsSumPaid(0.0);
                    prpLdangerCoinsDto.setCoinsSumFee(0.0);

                    if (prpLdangerUnitDto.getCoinsFlag().equals("1") || prpLdangerUnitDto.getCoinsFlag().equals("3")) {
                        //主共主联分摊赔款
                        prpLdangerCoinsDto.setCoinsSumLoss(Double.parseDouble(idecimalFormat.format(prpLdangerUnitDto.getSumLoss() * prpLdangerCoinsDto.getCoinsRate() / 100)));
                        prpLdangerCoinsDto.setCoinsSumNoPaid(Double.parseDouble(idecimalFormat.format(prpLdangerUnitDto.getSumNoPaid() * prpLdangerCoinsDto.getCoinsRate() / 100)));
                    } else if (prpLdangerUnitDto.getCoinsFlag().equals("2")) {
                        //从共保反算他方赔款
                        prpLdangerCoinsDto.setCoinsSumLoss(Double.parseDouble(idecimalFormat.format(prpLdangerUnitDto.getSumLoss() * prpLdangerCoinsDto.getCoinsRate() / baseRate)));
                        prpLdangerCoinsDto.setCoinsSumNoPaid(Double.parseDouble(idecimalFormat.format(prpLdangerUnitDto.getSumNoPaid() * prpLdangerCoinsDto.getCoinsRate() / baseRate)));
                    }

                    prpLdangerCoinsDtoList.add(prpLdangerCoinsDto);
                }
            }
        }
        //add end by zhaijq 200060404

        // 先删除原有的数据
        // FIX0313 delete by zhupengju begin
        // dbManager.beginTransaction();
        // FIX0313 delete by zhupengju end
        prpLDangerUnitDao.deleteByCertiNo(prpLclaimDto.getClaimNo());

        // 保存新生成的数据
        if (prpLdangerUnitDtoList != null) {
            Iterator iterator = prpLdangerUnitDtoList.iterator();
            while (iterator.hasNext()) {
                prpLdangerUnitDto = (PrpLDangerUnitDto) iterator.next();
                prpLdangerUnitDto.setClaimAddTimes(0);
                prpLDangerUnitDao.save(this.convert(prpLdangerUnitDto,PrpLDangerUnit.class));
            }
        }
        //add begin by zhaijq 20060404 存储联共保信息
        prpLDangerCoinsDao.deleteAllByCertiNoAndDangerNo(prpLdangerUnitDto.getClaimNo(),prpLdangerUnitDto.getDangerNo());
        if (prpLdangerCoinsDtoList != null) {
            Iterator iterator = prpLdangerCoinsDtoList.iterator();
            while (iterator.hasNext()) {
                prpLdangerCoinsDto = (PrpLDangerCoinsDto) iterator.next();
                prpLDangerCoinsDao.save(this.convert(prpLdangerCoinsDto,PrpLDangerCoins.class));
            }
        }
    }

    /**
     * （立案页面生成危险单位查询）
     * @author: 王志文
     * @date: 2018/4/13 15:06
     * @param registNo
     * @param kindCode
     * @return
     * @throws Exception
     */
    public DangerUnitBackDto makeDangerUnit(String registNo,String kindCode)throws Exception{
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
        prpLRegistKey.setRegistNo(registNo);
        PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
        StringBuilder maxDangerNoSql = new StringBuilder("select max(p.dangerNo) from PrpCdangerUnit p where p.policyNo =:policyNo ");
        Query query = entityManager.createNativeQuery(maxDangerNoSql.toString());
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("policyNo",prpLRegist.getPolicyNo());
        this.setQueryParam(query,paraMap);
        BigDecimal maxDangerNo = (BigDecimal) query.getSingleResult();
        StringBuilder prpCDangerUnitSql = new StringBuilder("select p.* from PrpCdangerUnit p where p.policyNo =:policyNo and p.dangerNo =:dangerNo ");
        Query query1 = entityManager.createNativeQuery(prpCDangerUnitSql.toString());
        if (maxDangerNo == null){
            paraMap.put("dangerNo",0);
        }else {
            paraMap.put("dangerNo",maxDangerNo);
        }
        this.setQueryParam(query1,paraMap);
        List<Object[]> objects = query1.getResultList();
        DangerUnitBackDto dangerUnitBackDto = new DangerUnitBackDto();
        if (objects != null && objects.size()>0){
            Object[] object = objects.get(0);
            BigDecimal dangerNo = (BigDecimal) object[2];
            dangerUnitBackDto.setDangerNo(Integer.parseInt(dangerNo.toString()));
            dangerUnitBackDto.setDangerDesc((String)object[3]);
            dangerUnitBackDto.setAddressName((String)object[4]);
            String currency = prpDcurrencyApi.translateCode((String)object[9],"zh-CN");
            dangerUnitBackDto.setCurrency(currency);
            BigDecimal dangerKindShare = (BigDecimal) object[13];
            dangerUnitBackDto.setDangerKindShare(Double.parseDouble(dangerKindShare.toString()));
        }
        paraMap.put("itemCode",prpLRegist.getLossCode());
        paraMap.put("kindCode",kindCode);
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(paraMap);
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        if (prpCitemKindDtoList.size()>0){
            prpCitemKindDto = prpCitemKindDtoList.get(0);
        }
        Integer itemKindNo = prpCitemKindDto.getItemKindNo();
        dangerUnitBackDto.setItemKind(itemKindNo);
        dangerUnitBackDto.setKindCode(prpCitemKindDto.getKindCode());
        dangerUnitBackDto.setKindName(prpCitemKindDto.getKindName());
        dangerUnitBackDto.setItemKindName(prpCitemKindDto.getItemDetailName());
        dangerUnitBackDto.setItemKindCode(prpCitemKindDto.getItemCode());
        return dangerUnitBackDto;
    }

    /**
     * （立案页面生成危险单位查询）
     * @author: 王志文
     * @date: 2018/4/13 15:06
     * @param claimNo
     * @param kindCode
     * @return
     * @throws Exception
     */
    private DangerUnitBackDto queryClaimDangerUnit(String claimNo,String kindCode)throws Exception{
        PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
        prpLClaimKey.setClaimNo(claimNo);
        PrpLClaim prpLClaim = prpLClaimDao.findOne(prpLClaimKey);
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
        prpLRegistKey.setRegistNo(prpLClaim.getRegistNo());
        PrpLRegist prpLRegist = prpLRegistDao.findOne(prpLRegistKey);
        List<PrpLDangerUnit> prpLDangerUnits = prpLDangerUnitDao.queryAllByClaimNoAndDangerNo(claimNo,1);
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("policyNo",prpLClaim.getPolicyNo());
        DangerUnitBackDto dangerUnitBackDto = new DangerUnitBackDto();
        if (prpLDangerUnits != null && prpLDangerUnits.size()>0){
            PrpLDangerUnit prpLDangerUnit = prpLDangerUnits.get(0);
            dangerUnitBackDto.setDangerNo(prpLDangerUnit.getDangerNo());
            dangerUnitBackDto.setDangerDesc(prpLDangerUnit.getDangerDesc());
            dangerUnitBackDto.setAddressName(prpLDangerUnit.getAddressName());
            dangerUnitBackDto.setSumLoss(String.valueOf(prpLDangerUnit.getSumLoss()));
            String currency = prpDcurrencyApi.translateCode(prpLDangerUnit.getCurrency(),"zh-CN");
            dangerUnitBackDto.setCurrency(currency);
            dangerUnitBackDto.setDangerKindShare(prpLDangerUnit.getDangerShare());
        }
        paraMap.put("itemCode",prpLRegist.getLossCode());
        paraMap.put("kindCode",kindCode);
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(paraMap);
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        if (prpCitemKindDtoList.size()>0){
            prpCitemKindDto = prpCitemKindDtoList.get(0);
        }
        Integer itemKindNo = prpCitemKindDto.getItemKindNo();
        dangerUnitBackDto.setItemKind(itemKindNo);
        dangerUnitBackDto.setKindCode(prpCitemKindDto.getKindCode());
        dangerUnitBackDto.setKindName(prpCitemKindDto.getKindName());
        dangerUnitBackDto.setItemKindName(prpCitemKindDto.getItemDetailName());
        dangerUnitBackDto.setItemKindCode(prpCitemKindDto.getItemCode());
        return dangerUnitBackDto;
    }
    /**
     * @description 获取自动立案的时间
     * @author 杨航
     * @date 2017年12月13日 下午3:48:31
     * @param flag
     *            H-种植，不传为养殖
     * @return strTime 满足自动立案的时间
     */
    private String getAutoClaimTime(String flag) {
        String strTime = "";
        Date date = null;
        // 获取当前的时间
        DateTime dateTime = new DateTime();
        long time = dateTime.getTime();
        if ("H".equals(flag)) {
            // 获取种植险应该自动立案的时间
            long hTime = time - (239 * 1000 * 60 * 60);
//			long hTime = time - (30*1000 * 60);
            date = new Date(hTime);
        } else if("I".equals(flag)){
            // 获取养殖险应该自动立案的时间
            long iTime = time - (71 * 1000 * 60 * 60);
//			long iTime = time - (30*1000 * 60);
            date = new Date(iTime);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strTime = sdf.format(date);
        return strTime;
    }
    public void autoClaim(String flowId,String registNo){
        ClaimPageInitReqDto claimPageInitReqDto = new ClaimPageInitReqDto();
        claimPageInitReqDto.setRegistNo(registNo);
        claimPageInitReqDto.setEditType("ADD");
//		List<SwfLog> swfLogList = swfLogDao.findByNodeTypeAndRegistNo("regis",registNo);
//		String flowId = swfLogList.get(0).getFlowId();
        try {
            ClaimPageInitResDto claimPageInitResDto = claimPageInit(claimPageInitReqDto);
            ClaimDto1 claimDto = new ClaimDto1();
            claimDto.setPrpLClaimDto(claimPageInitResDto.getPrpLClaimDto());
            if(claimPageInitResDto.getRiskCode()=="3220"){
                Double number = claimPageInitResDto.getPrpLClaimDto().getLossesNumber();
                claimDto.getPrpLClaimDto().setSumClaim(number*1000);
            }else if(claimPageInitResDto.getRiskCode()=="3233"){
                Double number = claimPageInitResDto.getPrpLClaimDto().getLossesNumber();
                claimDto.getPrpLClaimDto().setSumClaim(number*6000);
            }
            PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
            prpLclaimStatusDto.setStatus("4");
            claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
            claimDto.setContext(claimPageInitResDto.getContext());
            List<PrpLClaimLossDtoExt> prpLClaimLossDtoExtList = claimPageInitResDto.getPrpLclaimLossDtoList();
            List<PrpLClaimLossDto> prpLclaimLossDtoList = new ArrayList<>();
            convertCollection(prpLClaimLossDtoExtList, prpLclaimLossDtoList, PrpLClaimLossDto.class);
            claimDto.setPrpLclaimLossDtoList(prpLclaimLossDtoList);
            List<PrpLCompensateEarDto> prpLCompensateEarDtoList = claimPageInitResDto.getPrpLCompensateEarDtoList();
            List<PrpLCompensateEarRegistDto> prpLCompensateEarRegistDtoList = new ArrayList<>();
            convertCollection(prpLCompensateEarDtoList, prpLCompensateEarRegistDtoList,
                    PrpLCompensateEarRegistDto.class);
            claimDto.setPrpLcompensateeartDtoList(prpLCompensateEarRegistDtoList);
            claimDto.setIfAuto("1");

            claimDto.setFlowId(flowId);
            claimDto.setLogNo(claimPageInitResDto.getLogNo());
            saveClaim(claimDto);
        } catch (Exception e) {
            System.err.println("自动立案出错！！");
            throw new BusinessException("自动立案出错！！");

        }
    }

    /**
     * @description 自动立案
     * @author 杨航
     * @date 2017年12月13日 上午10:59:09
     * @param
     * @return
     */
    // todo 测试 修改时间，
    @Scheduled(cron = "0 0 0/2 * * ?")
//    @Scheduled(cron = "0 0 0 1/2 * ? " )
//    @Scheduled(cron = "0 0/5 * * * ? " )
    public void getAutoClaim() { if (LOGGER.isInfoEnabled()) {
            LOGGER.error("自动立案服务开始");
        }
        // 查询种植险、养殖险满足自动立案数据
        String strHTime = this.getAutoClaimTime("H");
        String strITime = this.getAutoClaimTime("I");
        List<SwfLog> swfLogList = new ArrayList<>();
        swfLogList.addAll(this.getSwfLogList(strHTime, "H"));
        swfLogList.addAll(this.getSwfLogList(strITime, "I"));
        // 把满足条件的数据进行自动立案操作
        if (swfLogList != null && swfLogList.size() > 0) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.error("自动立案的数量为{}", swfLogList.size());
            }
            for (SwfLog swfLog : swfLogList) {
                autoClaim(swfLog.getFlowId(),swfLog.getRegistNo());
            }
        }
    }


    /**
     * @description 获取需要自动立案的工作流集合
     * @author 杨航
     * @date 2017年12月13日 下午4:16:47
     * @param flag
     *            H-种植，不传为养殖
     * @return swfLogList 工作流数据集合
     */
    private List<SwfLog> getSwfLogList(String strTime, String flag) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select a                                   ");
        buffer.append("   from SwfLog a                            ");
//        buffer.append("  where not exists (select 1                ");
//        buffer.append("           from SwfLog b                    ");
//        buffer.append("          where a.flowId = b.flowId         ");
//        buffer.append("            and b.nodeType = 'claim')       ");
        buffer.append("    where a.nodeType = 'claim'                ");
        buffer.append("    and a.nodeStatus = '0'                  ");
        buffer.append("    and a.flowInTime < :strTime   and a.flowInTime  > '2018-05-24 15:00:00'    ");
        if ("H".equals(flag)) {
            buffer.append("    and substr(a.riskCode,0,2) = '31'  ");
        } else if("I".equals(flag)){
            buffer.append("    and substr(a.riskCode,0,2) = '32'   ");
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.error("自动立案查询种植险sql为{}", buffer.toString());
        }
        Query query = entityManager.createQuery(buffer.toString());
        query.setParameter("strTime", strTime);
        List<SwfLog> swfLogList = query.getResultList();
        return swfLogList;
    }

    /**
     * （注销拒赔核赔通过回写方法）
     * @author: 王志文
     * @date: 2018/5/4 10:10
     * @param undwrtWriteBackReCaseDto
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveCancelBackByUndwrt(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        SwfLogDto swfLogDto ;
        swfLogDto = prpLRecaseService.checkFlowNode(undwrtWriteBackReCaseDto.getLflowID(),
                undwrtWriteBackReCaseDto.getLlogNo(), undwrtWriteBackReCaseDto.getBusinessNo());
        String checkFlag = swfLogDto.getLogNo().toString();
        if (Integer.parseInt(checkFlag) < 0){
            return checkFlag;
        }
        if (Integer.parseInt(checkFlag) == 0){
            return checkFlag;
        }
        if ("1".equals(undwrtWriteBackReCaseDto.getUndwrtFlag())) {
            swfLogDto.setNodeStatus("4");
            swfLogDto.setHandlerCode(undwrtWriteBackReCaseDto.getHandlerCode());
            swfLogDto.setHandleTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND).toString());
            swfLogDto.setSubmitTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND).toString());
            String handlerName = prpDuserApi.translateCodeByPK(undwrtWriteBackReCaseDto.getHandlerCode());
            swfLogDto.setHandlerName(handlerName);
            SwfFlowMainKey swfFlowMainKey = new SwfFlowMainKey();
            swfFlowMainKey.setFlowId(undwrtWriteBackReCaseDto.getLflowID());
            SwfFlowMain swfFlowMain = swfFlowMainDao.findOne(swfFlowMainKey);
            WorkFlowDto workFlowDto = new WorkFlowDto();
            workFlowDto.setUpdate(true);
            workFlowDto.setUpdateSwfLogDto(swfLogDto);
            workFlowDto.setClose(true);
            workFlowDto.setCloseSwfFlowMainDto(this.convert(swfFlowMain, SwfFlowMainDto.class));
            workFlowService.deal(workFlowDto);
            return checkFlag;
        }
        return checkFlag;
    }
}