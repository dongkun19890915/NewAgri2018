package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestUnderwriteSubmitDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUnderwriteSubmitDto;
import com.sinosoft.agriprpall.api.client.undwrtclient.AgriPrpallUndwrtService;
import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.common.GetRuleInUtiPlatConfigRuleService;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainAgriDao;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.UndwrtSubmitService;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.UserInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.MiddleHerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.MiddleHerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 04:00:52.059
 * @description 工作流主表Core接口实现
 */
@Service
public class UndwrtSubmitServiceImpl extends BaseServiceImpl implements UndwrtSubmitService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UndwrtSubmitServiceImpl.class);


    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpTmainAgriDao prpTmainAgriDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private ProcessApi processApi;
    @Autowired
    private GetRuleInUtiPlatConfigRuleService getRuleInUtiPlatConfigRuleService;
    private XmlUtil xmlUtil;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl1;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private NyxInsuranceListApi nyxInsuranceListApi;
    @Autowired
    private HerdInsuranceListApi herdInsuranceListApi;
    @Autowired
    private MiddleHerdInsuranceListApi middleHerdInsuranceListApi;

    /**
     * 提交核保接口
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param undwrtEndorSubmitDto 入参对象
     * @return ResponseDto 提交核保状态与工作流号
     * @throws Exception
     */
    public List submitUndwrtByProposal(UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception {
        //接收参数
        String[] proposalno=undwrtEndorSubmitDto.getProposalno();
        UserInfo userinfo = SinoRequestContext.getCurrentContext().getUser();
        String userCode = userinfo.getUserCode();
        String DLComCode = undwrtEndorSubmitDto.getDLComCode();
        //todo 写死，为投保单
        String strBizType = "PROPOSAL";
        String strBizName = "";
        String CertiType = "";
        String StatusPic = "";
        String edittype = "Query";
        if (strBizType.equals(getProperty("BIZTYPE_PROPOSAL"))) {
            strBizName = "投保单";
            CertiType = "T";
        } else {
            strBizName = "保单";
            CertiType = "P";
        }
        //定义变量
        int index = 0;
        String[] checkboxAssess = proposalno;
        String strUnderWriteFlag = "";
        String strPolicyNo = "";
        String strProposalNo = "";
        String strMessage = "";
        String strUnderWriteFailMessage = "";
        String strGetFlagFailMessage = "";
        String strPrpslToPoliFailMessage = "";
        String strPrpslToPoliSuccessMessage = "";
        String strPrpslToPoliSuccessMessa = "";
        String strPrpslToPoliTextFailMessage = "";
        String strmagss = "";
        String strRiskCode = "";
        PrpTmainDto prpTmainDto = new PrpTmainDto();
        String strFlowId = "";
        String strComCode = "";
        String strUserCode = userCode;
        String strMakeCom = "";
        String strHandlerCode = "";
        String strHandler1Code = "";
        String strClassCode = "";
        String contractNo = "";
        int intReturn = 0;
        String strHandelType = "";
        String strDLComCode = DLComCode;
        //1.从Utiplatconfigrule表获取配置走规则自动核保，还是手动提交核保
        // 从平台系统获取规则引擎 下面注释为影像涉及，先注掉
//        strHandelType = queryfindOne("prpall", "ILOG_SWITCH", 1 + "");
//        //影像系统添加
//        String role = "";
//        String appcode = "";
        String proposalNo = "";
//        String appname = "";
//        String username = "";
//        String comcode = "";
//        String comname = "";
        int t = 0;
//        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(userCode);
//        username = prpDuserDto.getUserName();
//        String comCode = prpDuserDto.getComCode();
//        PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comCode);
//        comcode = prpDuserDto.getComCode();
//        comname = prpDcompanyDto.getComCName();
        PrpCmainDto prpCMainDto = new PrpCmainDto();
        //5.结果信息存list返回
        List list = new ArrayList();
        for (index = 0; index < checkboxAssess.length; index++) {
            //提交核保
            if (strBizType.equals(getProperty("BIZTYPE_PROPOSAL"))) //投保单
            {
                //提交核保入口统一
                proposalNo = checkboxAssess[index];
                PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
                prpTmainDto = convert(prpTmain, PrpTmainDto.class);
                strComCode = prpTmainDto.getMakeCom();
                strRiskCode = prpTmainDto.getRiskCode();
                strProposalNo = checkboxAssess[index];
                strComCode = prpTmainDto.getComCode();
                strMakeCom = prpTmainDto.getMakeCom();
                strClassCode = prpTmainDto.getClassCode();
                strUnderWriteFlag = prpTmainDto.getUnderwriteFlag();
                strHandlerCode = prpTmainDto.getHandlerCode();
                strHandler1Code = prpTmainDto.getHandler1Code();
                contractNo = prpTmainDto.getContractNo();
                //增加养殖险在提交核保时对清单关联的校验 added by GYIC liyang 20110826 start!
                /*String checkResult = checkInsurceListRelationInPrpTmainAgri(strRiskCode, strProposalNo);
                if (null != checkResult && !"".equals(checkResult))
                    throw new Exception(checkResult);*/
                //增加养殖险在提交核保时对清单关联的校验 added by GYIC liyang 20110826 end!
                prpTmainDto.setApproverCode(strUserCode);
                prpTmain = convert(prpTmainDto, PrpTmain.class);
                prpTmainDao.save(prpTmain);
                // 与镜像系统交互
                /*if (strRiskCode != null) {
                    prpdimagecodeDto = blPrpdimagecodeFacade.findByPrimaryKey(strRiskCode, "0000000000");
                    role = prpdimagecodeDto.getPrpallrole();
                    appcode = prpdimagecodeDto.getPrpallcode();
                    appname = prpdimagecodeDto.getPrpallname();
                    //String businessno= "1111111111";
                    String businessno = dbPrpTmain.getProposalNo();
                    StringBuffer s = new StringBuffer();
                    s.append("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA>");
                    s.append("<USER_CODE>");
                    s.append(strUserCode);
                    s.append("</USER_CODE>");

                    s.append("<USER_NAME>");
                    s.append(username);
                    s.append("</USER_NAME>");

                    s.append("<ORG_CODE>");
                    s.append(comcode);
                    s.append("</ORG_CODE>");

                    s.append("<ORG_NAME>");
                    s.append(comname);
                    s.append("</ORG_NAME>");

                    s.append("<ROLE_CODE>");
                    s.append(role);
                    s.append("</ROLE_CODE>");

                    s.append("</BASE_DATA><META_DATA><BATCH>");

                    s.append("<APP_CODE>");
                    s.append(appcode);
                    s.append("</APP_CODE>");

                    s.append("<APP_NAME>");
                    s.append(appname);
                    s.append("</APP_NAME>");

                    s.append("<BUSI_NO>");
                    s.append(businessno);
                    s.append("</BUSI_NO>");

                    s.append("</BATCH></META_DATA></root>");
                    try {
                        //result = blPrpdimagecodeFacade.imageStatistics(s.toString());
                        //System.err.println(result);
                        // String newxml = blPrpdimagecodeFacade.html2xml(result);
                        String newxml = "";
                        String nodeID = "";
                        String strWaning = "";
                        Collection nodes = new ArrayList();
                        if (strRiskCode.substring(0, 2).equals("32") && dbPrpTmain.getSumInsured().equals("1")) {
                            //PrpdcertifycheckDto prpdcertifycheck32 = new PrpdcertifycheckDto();
                            //prpdcertifycheck32.setRiskcode(strRiskCode);
                            //prpdcertifycheck32.setCertifyname("养殖保险现场查验记录");
                            //prpdcertifycheck32.setCertifytype("A0340/A03400080");
                            //prpdcertifycheck32.setValidstatus("1");
                            //nodes.add(prpdcertifycheck32);
                            nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(strRiskCode, "prpall_CS");

                        } else {

                            nodes = blPrpdcertifycheckFacade.findAllByPrimaryKey(strRiskCode, "prpall_C");
                        }
                        HashMap hm = blPrpdimagecodeFacade.imageNodeCheck(newxml, nodes);
                        strWaning = blPrpdcertifycheckFacade.checkMustUpload(nodes, hm);
                        if (!strWaning.equals("")) {
                            throw new Exception(strWaning);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }

                }*/
//                //判断影像是否上传
//                StringBuffer uffer=new StringBuffer();
//                uffer.append(" select count(1) from prpmaterial where businessno='");
//                uffer.append(proposalNo);
//                uffer.append("' ");
//                Query query=entityManager.createNativeQuery(uffer.toString());
//                Object countNum = query.getSingleResult();
//                if(Integer.parseInt(countNum.toString())<=0){
//                    if(checkboxAssess.length>1){
//                        strMessage+="自动剔除未上传投保单！";
//                    }else{
//                        strMessage+="该投保单未上传";
//                    }
//                    list.add(strMessage);
//                    break;
//                }
//
//                //判断清单是否补录
                 //todo  getProperty("PLNATING_FARMER_LIST_FLAG") 配置出来
                if (strRiskCode != null && "3220,3233".indexOf(strRiskCode) > -1) {
                    List<InsureMainListDto> insureMainListDtoList=insureMainListApi.queryByProposalNo(proposalNo);
                    String inusreListCode="";
                    if(insureMainListDtoList.size()>0){
                        inusreListCode=insureMainListDtoList.get(0).getInusreListCode();
                    }
                    Map<String,String> map= new HashMap<>();
                    map.put("inusreListCode",inusreListCode);
               //     List<NyxInsuranceListDto> nyxInsuranceListDtos = nyxInsuranceListApi.queryByInusreListCode(map);
                    List<HerdInsuranceListDto> herdInsuranceListDtos = herdInsuranceListApi.queryByInusreListCode(map);
               //     List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtos = middleHerdInsuranceListApi.queryByInusreListCode(map);
                    if((herdInsuranceListDtos!=null && herdInsuranceListDtos.size()<=0)){
                        if(checkboxAssess.length>1){
                            strMessage+="自动剔除未补录耳标号投保单！";
                        }else{
                            strMessage+="该投保单未补录耳标号";
                        }
                        list.add(strMessage);
                        continue;
                    }
                }
                //2.判断清单是否导出
//                if (strRiskCode != null && getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(strRiskCode) > -1) {
//                    String inusrelistCode = "";
//                    PrpTmainAgri prpTmainAgri = prpTmainAgriDao.findOne(new PrpTmainAgriKey(proposalNo));
//                    PrpTmainAgriDto prpTmainAgriDto = convert(prpTmainAgri, PrpTmainAgriDto.class);
//                    inusrelistCode = prpTmainAgriDto.getRelationListNo();
//                    InsureMainListDto insureMainListDto = insureMainListApi.queryByPK(inusrelistCode);
//                    if (insureMainListDto != null) {
//                        if (insureMainListDto.getExportFlag() != null && insureMainListDto.getExportFlag().equals("1")) {
//                            //strReturn = "Succes";
//                        } else {
//                            throw new DataVerifyException("清单未导出，不允许提交核保！！");
//                        }
//                    }
//                }

                //投保单保存时数据质量检查
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String strStartDate = sdf.format(prpTmainDto.getStartDate());
                //政策性商业性标志
                String businessType1 = prpTmainDto.getBusinessType1();
                //如果此投保单为政策性农险倒签单
                if (checkAgriIsDaoQian(strStartDate, businessType1)) {
                    throw new Exception("政策性农险起保日期早于核保日期的投保单不允许提交核保！");
                }
            }
            //add by lianjingwei 加上判断当没有提交过核保的时候才提交strFlowId 2005-11-10 11:40:21
            //3.提交核保主方法
            if (!strUnderWriteFlag.equals("9") && !strUnderWriteFlag.equals("1") && !strUnderWriteFlag.equals("3")) {
                //TODO 自动提交核保注掉
                /*if ("1".equals(strHandelType)) {//走规则引擎
                    String strResultType = "";
                    if("01".equals(strClassCode)){//企财险
                        ILogBusinessProperty iLogBusinessProperty = new ILogBusinessProperty();
                        prpAutoCheckDto = iLogBusinessProperty.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("03".equals(strClassCode)){//普通家财险
                        ILogCommonPenates iLogCommonPenates = new ILogCommonPenates();
                        prpAutoCheckDto = iLogCommonPenates.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("04".equals(strClassCode)){//特殊家财险
                        ILogSpecialPenates iLogSpecialPenates = new ILogSpecialPenates();
                        prpAutoCheckDto = iLogSpecialPenates.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("08".equals(strClassCode)){//08-工程一切险类
                        ILogProject iLogProject = new ILogProject();
                        prpAutoCheckDto = iLogProject.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("09".equals(strClassCode)){//09-国内货物运输
                        ILogTransport iLogTransport = new ILogTransport();
                        prpAutoCheckDto = iLogTransport.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("10".equals(strClassCode)){//10-进出口货运险
                        ILogFreight iLogFreight = new ILogFreight();
                        prpAutoCheckDto = iLogFreight.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("11".equals(strClassCode)){//11-船舶类保险
                        ILogShip iLogShip = new ILogShip();
                        prpAutoCheckDto = iLogShip.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("15".equals(strClassCode)){//15-责任保险
                        ILogResponsibility iLogResponsibility = new ILogResponsibility();
                        prpAutoCheckDto = iLogResponsibility.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("21".equals(strClassCode)){//21-信用保险
                        ILogCreditKeepAssets iLogCreditKeepAssets = new ILogCreditKeepAssets();
                        prpAutoCheckDto = iLogCreditKeepAssets.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("22".equals(strClassCode)){//22-保证保险
                        ILogEnsure iLogEnsure = new ILogEnsure();
                        prpAutoCheckDto = iLogEnsure.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("26".equals(strClassCode)){//26-短期健康
                        ILogShortTime iLogShortTime = new ILogShortTime();
                        prpAutoCheckDto = iLogShortTime.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("27".equals(strClassCode)){//27-意外险类
                        ILogAccident iLogAccident = new ILogAccident();
						 *//* prpAutoCheckDto = iLogAccident.doILog(CertiType,"",checkboxAssess[index],"","",
                                    strClassCode,strRiskCode,strDLComCode,"");*//*
                        prpAutoCheckDto.setBusinessNo("1");
                        prpAutoCheckDto.setProposalNoJQX("2");
                        prpAutoCheckDto.setRuleContent("3");
                        prpAutoCheckDto.setRuleCode("RIRT1002");
                        prpAutoCheckDto.setRuleName("6");
                        prpAutoCheckDto.setSerialNo(7);
                        prpAutoCheckDto.setSeeFeeFlag("0");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("28".equals(strClassCode)){//28-大病医疗险类
                        ILogBigIllness iLogBigIllness = new ILogBigIllness();
                        prpAutoCheckDto = iLogBigIllness.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("31".equals(strClassCode)){//31-种植类保险
                        ILogPlant iLogPlant = new ILogPlant();
                        prpAutoCheckDto = iLogPlant.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("32".equals(strClassCode)){//32-养殖保险
                        ILogCultivation iLogCultivation = new ILogCultivation();
                        prpAutoCheckDto = iLogCultivation.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("YA".equals(strClassCode)){//YA-国内水路、陆路货物运输预约保险
                        ILogSubscribe iLogSubscribe = new ILogSubscribe();
                        prpAutoCheckDto = iLogSubscribe.doILog(CertiType,"",checkboxAssess[index],"","",
                                strClassCode,strRiskCode,strDLComCode,"");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else if("ZH".equals(strClassCode)){//ZH-组合保险类
                        ILogZh iLogZh = new ILogZh();
//						  prpAutoCheckDto = iLogZh.doILog(CertiType,"",checkboxAssess[index],"","",
//									strClassCode,strRiskCode,strDLComCode,"");
                        prpAutoCheckDto.setBusinessNo("1");
                        prpAutoCheckDto.setProposalNoJQX("2");
                        prpAutoCheckDto.setRuleContent("3");
                        prpAutoCheckDto.setRuleCode("RIRT1002");
                        prpAutoCheckDto.setRuleName("6");
                        prpAutoCheckDto.setSerialNo(7);
                        prpAutoCheckDto.setSeeFeeFlag("0");
                        strResultType = prpAutoCheckDto.getRuleCode();
                    }else{

                    }
                    if(prpAutoCheckDto!=null){
                        prpAutoCheckDto.setFlag("1");
                    }
                    if("RIRT1001".equals(strResultType)){
                        strFlowId += prpAutoCheckDto.getBusinessNo()+"违反下列规则，已提交人工核保：";
                        //读取规则引擎返回参数的违反规则信息
                        String[] strResult = prpAutoCheckDto.getRuleContent().split("");
                        for(int i = 0,j=1;i < strResult.length;i++){
                            if(null != strResult[i] && !"".equals(strResult[i])){
                                strFlowId += j + "、" + strResult[i] + "";
                                j++;
                            }
                        }
                        //规则引擎违反信息写入表
                        BLPrpAutoCheck blPrpAutoCheck = new BLPrpAutoCheck();
                        blPrpAutoCheck.save(prpAutoCheckDto,"");
                        dbPrpTmain.getInfo(strProposalNo);
                        dbPrpTmain.setIsSeeFeeFlag(prpAutoCheckDto.getSeeFeeFlag());
                        dbPrpTmain.update();
                        //提交双核
                        String stFlowId = "";
                        UndwrtLogger.printData("[提交人工核保入口 执行后 ]\t"+strProposalNo);
                        stFlowId += blTaskFacade.start("11",CertiType,strProposalNo,
                                strRiskCode,strClassCode,strComCode,strMakeCom,strUserCode,strHandlerCode,
                                strHandler1Code,"")  + "";
                        strFlowId = stFlowId + "  " + strFlowId;
                    }else if("RIRT1002".equals(strResultType)){
                        //规则引擎违反信息写入表
                        BLPrpAutoCheck blPrpAutoCheck = new BLPrpAutoCheck();
                        blPrpAutoCheck.save(prpAutoCheckDto,"");
                        dbPrpTmain.getInfo(strProposalNo);
                        dbPrpTmain.setIsSeeFeeFlag(prpAutoCheckDto.getSeeFeeFlag());
                        dbPrpTmain.update();
                        //自动核保
                        strFlowId += blTaskFacade.start(true,"11",CertiType,
                                strProposalNo,strRiskCode,strClassCode,strComCode,strMakeCom,
                                strUserCode,strHandlerCode,strHandler1Code,contractNo) + "";
                        strFlowId += prpAutoCheckDto.getBusinessNo()+"自动核保通过";
                        //向数据库添加inceptionflag与notificationflag
                        String strSQL = " Select * From PrpCmain Where ProposalNo = " + "'" + checkboxAssess[index] + "'";
                        Vector List=dbPrpCmain.findByConditions(strSQL);
                        Enumeration enu = List.elements();
                        while (enu.hasMoreElements()) {
                            prpCmainSchema = (PrpCmainSchema)enu.nextElement();
                        }
                        String conditions  = "update prpcmain set isonline='"+dbPrpTmainService.getIsOnline()+"',handler1name='"+dbPrpTmainService.getHandler1name()+"' ,agentname='"+dbPrpTmainService.getAgentname()+"',wxchannelcode='"+dbPrpTmainService.getWXChannelCode()+"' where proposalno='"+proposalno+"'";
                        int rs = db.executeUpdate(conditions);
                        conditions="";
                        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<String, String> entry = it.next();
                            conditions="update PrpCinsured set customersequenceNo='"+entry.getValue()+"' where policyno='"+prpCmainSchema.getPolicyNo()+"' and serialNo='"+entry.getKey()+"'";
                            db.executeUpdate(conditions);
                        }
                        //调用转保单-自动核保与意健险平台交互的接口方法
                        UIElectronicCommerceService_SsproposalSaveToPolicy us = new UIElectronicCommerceService_SsproposalSaveToPolicy();
                        List<PropReturnInfo>	list = us.ssproposalSaveToPolicy(proposalno, prpAutoCheckDto);
                        AutoPolicy.setList(list);
                        db.commitTransaction();

                    }else if("RIRT1003".equals(strResultType)){
                        BLWfLogFacade blWfLogFacade = new BLWfLogFacade();
                        strFlowId += prpAutoCheckDto.getBusinessNo()+"不符合自核规则，已下发修改，下发原因为：";
                        //读取规则引擎返回参数的违反规则信息
                        String[] strResult = prpAutoCheckDto.getRuleContent().split("");
                        for(int i = 0,j=1;i < strResult.length;i++){
                            if(null != strResult[i] && !"".equals(strResult[i])){
                                strFlowId += j + "、" + strResult[i] + "";
                                j++;
                            }
                        }
                        //规则引擎违反信息写入表
                        BLPrpAutoCheck blPrpAutoCheck = new BLPrpAutoCheck();
                        blPrpAutoCheck.save(prpAutoCheckDto,"");
                        dbPrpTmain.getInfo(strProposalNo);
                        dbPrpTmain.setIsSeeFeeFlag(prpAutoCheckDto.getSeeFeeFlag());
                        dbPrpTmain.update();
                        //提交核保工作流
                        String stFlowId = "";
                        stFlowId = blTaskFacade.start("11",CertiType,strProposalNo,strRiskCode,strClassCode,strComCode,
                                strMakeCom,strUserCode,strHandlerCode,strHandler1Code,contractNo);
                        String strWfLogCon = " FLOWID = '" + stFlowId + "' AND LOGNO = (SELECT MAX(LOGNO) " +
                                " FROM WFLOG WHERE FLOWID = '" + stFlowId + "') ";
                        ArrayList<WfLogDto> listWfLog = (ArrayList<WfLogDto>)blWfLogFacade.
                                findByConditions(strWfLogCon);
                        if(listWfLog.size() > 0){
                            WfLogDto wfLogDto = new WfLogDto();
                            wfLogDto = listWfLog.get(0);
                            //下发修改工作流到“出单员”
                            blWfLogFacade.submitTask(stFlowId, wfLogDto.getModelNo(), 1, wfLogDto.getBusinessType(),
                                    wfLogDto.getBusinessNo(), wfLogDto.getFlowStatus(),wfLogDto.getFlag(), strUserCode, "");
                        }
                        strFlowId = stFlowId + " " + strFlowId;
                        //blWfLogFacade.submitTask(stFlowId, ModelNo, NodeNo, BusinessType, BusinessNo, FlowStatus,
                        //		Flag, UserCode, OperatorCode);
                    }else if("RIRT0000".equals(strResultType)){
                        strFlowId += prpAutoCheckDto.getBusinessNo()+"自动核保异常！";
                        //规则引擎违反信息写入表
                        BLPrpAutoCheck blPrpAutoCheck = new BLPrpAutoCheck();
                        blPrpAutoCheck.save(prpAutoCheckDto,"");
                        strmagss="自动核保异常";
                    }else if("NICE0000".equals(strResultType) || "NITE0000".equals(strResultType)
                            || "NISE0000".equals(strResultType)){
                        //规则引擎违反信息写入表
                        BLPrpAutoCheck blPrpAutoCheck = new BLPrpAutoCheck();
                        blPrpAutoCheck.save(prpAutoCheckDto,"");
                        if("NITE0000".equals(strResultType)){
                            strUnderWriteFailMessage = "网络连接超时，无法提交规则引擎！请通知相关人员调试网络！";
                        }else{
                            strUnderWriteFailMessage = "网络连接中断，无法提交规则引擎！请通知相关人员调试网络！";
                        }
                    }else{
                        strUnderWriteFailMessage = "自核引擎异常，请尝试重新提交！";
                    }
                    prpAuto.setBusinessno(prpAutoCheckDto.getBusinessNo());
                    prpAuto.setProposalnojqx(prpAutoCheckDto.getProposalNoJQX());
                    prpAuto.setRulecode(prpAutoCheckDto.getRuleCode());
                    prpAuto.setRulecontent(prpAutoCheckDto.getRuleContent());
                    prpAuto.setRulename(prpAutoCheckDto.getRuleName());
                    prpAuto.setSerialno(String.valueOf(prpAutoCheckDto.getSerialNo()));
                    ruleMessageList.add(prpAuto);
                    AutoPolicy.setRuleMessageList(ruleMessageList);*/
//                } else {
                    // 等待核保核赔系统
                   /* strFlowId += "" +start("11", CertiType, strProposalNo, strRiskCode,
                            strClassCode, strComCode, strMakeCom,
                            strUserCode, strHandlerCode, strHandler1Code, "");*/
                    RequestUnderwriteSubmitDto underwriteSubmitDto = new RequestUnderwriteSubmitDto();
                    underwriteSubmitDto.setModelType("11");
                    underwriteSubmitDto.setCertiType(CertiType);
                    underwriteSubmitDto.setBusinessNo(strProposalNo);


                    underwriteSubmitDto.setRiskCode(strRiskCode);
                    underwriteSubmitDto.setClassCode(strClassCode);
                    underwriteSubmitDto.setComCode(strComCode);
                    underwriteSubmitDto.setMakecom(strMakeCom);
                    underwriteSubmitDto.setUserCode(strUserCode);
                    underwriteSubmitDto.setHandlerCode(strHandlerCode);
                    underwriteSubmitDto.setHandler1Code(strHandler1Code);
                    underwriteSubmitDto.setContractNo("");
                    PacketDto<RequestUnderwriteSubmitDto> packeDto = new PacketDto<RequestUnderwriteSubmitDto>();
                    packeDto.setBody(underwriteSubmitDto);
                    xmlUtil = new XmlUtil();
                    String Xml = xmlUtil.packetDtoToXml_bodyDto(packeDto);
                    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
                    factory.setServiceClass(AgriPrpallUndwrtService.class);
                    factory.setAddress(webserviceUrl1+"/webAgriPrpallService/services/AgriPrpallUndwrtService?wsdl".trim());
                    AgriPrpallUndwrtService port = (AgriPrpallUndwrtService) factory.create();
                    String responseXml = port.underwriteSubmit(Xml);
                    PacketDto<ResponseUnderwriteSubmitDto> responsepackeDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml, ResponseUnderwriteSubmitDto.class);
                    String   message= responsepackeDto.getHead().getReturnMessage();
                     String statusCode=responsepackeDto.getHead().getReturnStatusCode();
                     if("9999".equals(statusCode)){
                            throw new DataVerifyException(message);
                     }
                    ResponseUnderwriteSubmitDto responseUnderwriteSubmitDto = responsepackeDto.getBody();
                    strFlowId += responseUnderwriteSubmitDto.getFlowId();
            } else {
                strMessage = "" + strBizName + "已经提交核保，无需再次提交！" + strFlowId + "";
                StatusPic = "500";
            }
            //判断UnderwriteFlag状态： 核保标志--0初始值/1通过/2不通过/3 无需核保 9待核保
            if (strBizType.equals(getProperty("BIZTYPE_PROPOSAL"))) //投保单
            {
                strUnderWriteFlag = prpTmainDto.getUnderwriteFlag();
            }

            if (strUnderWriteFlag != null && strUnderWriteFlag.equals("3")) //无需核保
            {
                if (strBizType.equals(getProperty("BIZTYPE_PROPOSAL"))) //投保单
                {
                    //投保单转保单
                    //strPolicyNo = blProposalPolicy.proposalToPolicy(checkboxAssess[index],session.getId());
                    proposalNo = checkboxAssess[index];
                    String strWhere=" select c from PrpCmain c where c.proposalNo=:proposalNo ";
                    Query query=entityManager.createQuery(strWhere);
                    List<PrpCmain> prpCmains=query.getResultList();
                    PrpCmain prpCmainone=new PrpCmain();
                    if (prpCmains!=null){
                         prpCmainone=prpCmains.get(0);
                    }
                    prpCMainDto = convert(prpCmainone,PrpCmainDto.class);
                    if (prpCMainDto.getProposalNo() != null)
                        strPolicyNo = prpCMainDto.getPolicyNo();
                    strPrpslToPoliSuccessMessa += "投保单（" + checkboxAssess[index] + "）转成保单（" + strPolicyNo + "）成功";
                                                  /* + "<input type=button name=\"forwardButton\" class=button value=\"打印保单\" onclick=\"printPolicy(\'"+ strPolicyNo +"\');\">";*/
                    //投保单文本转保单文本
                    if (("NONEFORMAT_RISK").indexOf(strRiskCode) != -1) {
                        strMessage += "";
                        try {
                            ProposalTextToPolicyText(strProposalNo, strPolicyNo);
                        } catch (Exception e) {
                            strPrpslToPoliTextFailMessage += checkboxAssess[index] + "";
                        }
                    }

                } else //保单
                {
                    strPrpslToPoliSuccessMessage += "保单（" + checkboxAssess[index] + "）无需核保";
                    StatusPic = "500";
                }

            }


        //4.结果信息合并
        if (!strUnderWriteFailMessage.equals("")) {
            strMessage += "" + strBizName + "提交核保失败：" + strUnderWriteFailMessage + "";
            StatusPic = "500";
        }
        if (!strGetFlagFailMessage.equals("")) {
            strMessage += "下列" + strBizName + "提交核保成功，但取核保标志失败：" + strGetFlagFailMessage + "";
            StatusPic = "500";
        }
        if (!strPrpslToPoliFailMessage.equals("")) //只有投保单才有的strPrpslToPoliFailMessage
        {
            strMessage += "下列投保单自动核保，但投保单转保单失败：" + strPrpslToPoliFailMessage + "";
            StatusPic = "500";
        }
        if (!strPrpslToPoliTextFailMessage.equals("")) {
            strMessage += "下列投保单自动核保，投保单转保单成功，但文本转换失败：" + strPrpslToPoliTextFailMessage + "";
            StatusPic = "500";
        }
        if (strMessage.equals("")) {
            //strMessage = "<p>"+strBizName +"提交核保成功。返回工作流" + strFlowId+"</P>";

            //chengkai;20060720;核保后可重新录入投保单。begin
            strMessage = "" + strBizName + "提交核保成功。返回工作流号如下" + strFlowId + "";
            StatusPic = "200";
        }

        if (!strPrpslToPoliSuccessMessage.equals("")) {
            strMessage += "" + strBizName + "自动核保：" + strPrpslToPoliSuccessMessage + "";
            StatusPic = "500";
        }
        if (!strPrpslToPoliSuccessMessa.equals("")) {
            strMessage += "" + strBizName + "自动核保：" + strPrpslToPoliSuccessMessa + "";
            StatusPic = "200";
        }
            list.add(checkboxAssess[index] + strMessage);
            // 生成流程节点数据
            PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
            this.generateNodeData(prpTmain);
        }
        return list;
    }

    /**
     * 生成节点数据
     *
     * @param prpTmain 投保单主要信息
     * @return
     * @date: 2018/4/9 11:10
     * @author: 何伟东
     */
    private void generateNodeData(PrpTmain prpTmain) throws Exception {
        if (prpTmain != null) {
            // 生成投保单提交核保节点数据
            String approverCode = prpTmain.getApproverCode();
            Date nowDate = new Date();
            PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(approverCode);
            ProcessDto submitProposalProcessDto = new ProcessDto.Builder()
                    .stepCode(NodeType.SUBMIT_PROPOSAL_NODE)
                    .stateCode(NodeState.PROCESSED)
                    .bizCode(prpTmain.getProposalNo())
                    .inflowTime((Date) nowDate.clone())
                    .outflowTime((Date) nowDate.clone())
                    .opCode(approverCode)
                    .opName(prpDuserDto.getUserName())
                    .opTime((Date) nowDate.clone())
                    .resultCode(NodeResultCode.PROPOSAL_SUBMIT)
                    .build();
            // 同时生成核保未处理节点
            ProcessDto auditProposalProcessDto = new ProcessDto.Builder()
                    .stepCode(NodeType.AUDIT_PROPOSAL_NODE)
                    .stateCode(NodeState.UNPROCESSED)
                    .bizCode(prpTmain.getProposalNo())
                    .inflowTime((Date) nowDate.clone())
                    .opCode(approverCode)
                    .opName(prpDuserDto.getUserName())
                    .opTime((Date) nowDate.clone())
                    .resultCode(NodeResultCode.EMPTY)
                    .build();
            List<ProcessDto> processDtos = new ArrayList<>();
            processDtos.add(submitProposalProcessDto);
            processDtos.add(auditProposalProcessDto);
            processApi.generateMultipleNodeData(processDtos);
        }
    }

    /**
     * 平台对接
     * @author: 钱浩
     * @date: 2017/10/25 11:23
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    private String getProperty(String paramCode) throws Exception {
        //String tableName=getRuleInUtiPlatConfigRuleService.getProperty(paramCode);
       String tableName= utiPlatConfigRuleApi.getProperty(paramCode);
        return tableName;
    }

    /**
     * 平台交互
     * @author: 钱浩
     * @date: 2017/11/10 16:19
     * @param systemCode
     * @param paramCode
     * @param serialNo
     * @return
     */
    //todo
    private String queryfindOne(String systemCode, String paramCode, String serialNo)throws Exception {
       String tablename= getRuleInUtiPlatConfigRuleService.queryfindOne(systemCode, paramCode, serialNo);
        return tablename;
    }

    /**
     * 政策性农险判断
     * @author: 钱浩
     * @date: 2017/11/10 16:13
     * @param strStartDate 开始时间
     * @param businessType1 类型
     * @return
     * @throws Exception
     */
    private boolean checkAgriIsDaoQian(String strStartDate, String businessType1) throws Exception {
        //政策性农险是否允许倒签单控制的开关：0，不做控制；1，控制不允许倒签
        String AGRIJIANFEI_SWITCH = getProperty("AGRIJIANFEI_SWITCH");
        if (AGRIJIANFEI_SWITCH == null || "0".equals(AGRIJIANFEI_SWITCH)
                || "1".equals(AGRIJIANFEI_SWITCH)) {
            return false;
        }
        boolean returnFlag = false;
        //当前日期
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //起保日期小于当前日期并且此投保单为政策性农险
        if (date.after(sdf.parse(strStartDate)) && !"00".equals(businessType1)
                && !"".equals(businessType1)) {
            returnFlag = true;//此保单为政策性倒签单
        } else {
            returnFlag = false;
        }
        return returnFlag;
    }
/*
    private String start(String modelType, String certiType, String businessNo,
                        String riskCode, String classCode, String comCode, String makecom,
                        String userCode, String handlerCode, String handler1Code, String contractNo) throws Exception
    {

        Utiplatconfigrule platformclient =utiplatconfigruleDao.findOne(new UtiplatconfigruleKey("prpall", "NEW_VERIFY_SWITCH", 1));
        UtiplatconfigruleDto  utiPlatConfigRuleDto=convert(platformclient, UtiplatconfigruleDto.class);
        //新双核审核权限开关
        String strSwitch = utiPlatConfigRuleDto.getRule();
        String flowID = "";
        if("1".equals(strSwitch) && ("11".equals(modelType) || "22".equals(modelType))  &&
                ("T".equals(certiType) || "E".equals(certiType) || "C".equals(certiType) || "Y".equals(certiType))){//新审核权限开关打开，且是提交核保或是核赔
                int modelNo = getModelNo(modelType, riskCode, comCode);
                PrpDcompany prpDcompany=prpDcompanyDao.findOne(new PrpDcompanyKey(comCode));
                PrpDcompanyDto prpDcompanyDto=convert(prpDcompany,PrpDcompanyDto.class);
                String marketType = prpDcompanyDto.getMarketType();
                if(marketType==null || "".equals(marketType)){
                    throw new Exception("机构未配置所属的事业部类型！");
                }

                StringBuffer sqlBuffer = new StringBuffer();
                sqlBuffer.append("select nvl(min(u.verifylevel),-1)");
                sqlBuffer.append("  from uwgradepower u");
                sqlBuffer.append(" where (u.classcode like '%"+classCode+"%' or u.riskcode like '%"+riskCode+"%')");
                sqlBuffer.append("   and (u.exceptriskcode is null or u.riskcode not like '%"+riskCode+"%')");
                if(!"YL".equals(comCode.subSequence(6, 8))){
                    sqlBuffer.append("   and u.comcode not like '%YL%' ");
                }
                sqlBuffer.append("   and u.comcode in (select comcode");
                sqlBuffer.append("                       from prpdcompany p");
                sqlBuffer.append("                      start with p.comcode = '"+comCode+"'");
                //处理医疗事业部
                if("YL".equals(comCode.subSequence(6, 8))){
                    sqlBuffer.append("     connect by p.comcode = prior p.upperylcomcode");
                }else{
                    sqlBuffer.append("     connect by p.comcode = prior p.uppercomcode");
                }
                sqlBuffer.append("                            and prior p.comcode <> p.comcode)");

                sqlBuffer.append("   and u.markettype = '"+marketType+"'");
                PrpTmainDto prpTmainDto=new PrpTmainDto();
                if("T".equals(certiType)){
                    String proposalNo=businessNo;
                    PrpTmain prpTmain=prpTmainDao.findOne(new PrpTmainKey(proposalNo));
                     prpTmainDto=convert(prpTmain,PrpTmainDto.class);
                }
                String businesstype1 = prpTmainDto.getBusinessType1();
                if(businesstype1!=null){

                } else {
                    throw new Exception("未查询业务号"+businessNo+"对应的业务信息，请联系管理员！");
                }
                sqlBuffer.append("   and instr(u.policytype,'"+businesstype1+"',1,1) > 0");
                if("11".equals(modelType)){//提交核保
                    sqlBuffer.append("   and u.uwtype='HB'");
                } else if("22".equals(modelType)){//提交核赔
                    sqlBuffer.append("   and u.uwtype='HP'");
                }
                int verifylevel = -1;
               Query  nativeQuery= entityManager.createNativeQuery(sqlBuffer.toString());
                Object obj= nativeQuery.getSingleResult();
                System.out.print(obj.toString());
                verifylevel=Integer.parseInt(obj.toString());
                //verifylevel= nativeQuery.getSingleResult();
                if(verifylevel == -1){
                    throw new Exception("未设置核保权限组人员，请联系系统管理员！");
                }
                WfLogDto wfLogDto=new WfLogDto();
                this.flag="claim";
                this.verifySwitch="1";
                String startType = checkStartType(businessNo);
                flowID = dealFirstTrans(modelNo, certiType, businessNo,
                        startType, verifylevel, "0",
                        riskCode, classCode, comCode,
                        makecom, handlerCode, handler1Code,
                        userCode, contractNo,"1");
        }
        return flowID;
    } */

    /**
     * 是转保单
     * @author: 钱浩
     * @date: 2017/11/10 16:15
     * @param ProposalNo 投保单号
     * @param PolicyNo 保单号
     * @throws Exception
     */
    private void ProposalTextToPolicyText(String ProposalNo, String PolicyNo)
            throws Exception {
        String fromFile = "";
        String toFile = "";

        try {
            fromFile = getProperty("DOC_HOME") + File.separator + ProposalNo;
            toFile = getProperty("DOC_HOME") + File.separator + PolicyNo;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFile));
            StringBuffer strBuffer = new StringBuffer();
            String strLine = "";
            boolean bReplaceOK = false;

            while ((strLine = bufferedReader.readLine()) != null) {
                if (bReplaceOK == false) {
                    if (strLine.indexOf("<!--<PolicyNo>-->") != -1) {
                        strLine = replace(strLine, "<!--<PolicyNo>-->", PolicyNo);
                        bReplaceOK = true;
                    }
                }

                strBuffer.append(strLine + "\n");
            }
            bufferedReader.close();

            bufferedWriter.write(strBuffer.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
    }

    /**
     * 工具类
     * @author: 钱浩
     * @date: 2017/11/10 16:16
     * @param strMain
     * @param strFind
     * @param strReplaceWith
     * @return
     */
    private static String replace(String strMain, String strFind, String strReplaceWith) {
        String strReturn = "";
        int intStartIndex = 0;
        int intEndIndex = 0;

        if ((strMain == null) || (strMain.equals(""))) {
            return "";
        }
        while ((intEndIndex = strMain.indexOf(strFind, intStartIndex)) > -1) {
            strReturn = strReturn + strMain.substring(intStartIndex, intEndIndex) + strReplaceWith;
            intStartIndex = intEndIndex + strFind.length();
        }

        strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
        return strReturn;
    }
    /*
    *//**
     * 查询模版号
     * @param modelType : 模版类型
     * @param riskCode  ：险种代码
     * @param comCode   ：部门代码
     * @return：void
     * @throws Exception
     *//*
    private int getModelNo(String modelType, String riskCode, String comCode) throws Exception,
            Exception
    {
        int modelNo = 0;
        String statementStr = " SELECT a.ModelNo FROM SwfModelUse a,SwfModelMain b "
                + " WHERE b.ModelType = '" +	modelType + "'"
                + "	AND b.ModelNo = a.ModelNo"
                + "	AND a.riskcode ='" + riskCode + "'"
                + "	AND a.comcode='" + comCode + "'"
                + "	AND a.ModelStatus = '1'";

        Query nativeQuery=entityManager.createNativeQuery(statementStr);
        Object obj= nativeQuery.getSingleResult();
        modelNo =Integer.parseInt(obj.toString());
        return modelNo;
    }
    *//**
     * @desc 判断工作流为新启动还是待修改
     * @param iBusinessNo
     *            业务号
     * @return flag(U:修改, N:新启动, 0:出错)
     * @Author :liuyang
     *//*
    private String checkStartType(String iBusinessNo)throws Exception {
        String startType = "";
        String strWherePart = "";
        String strWherePartLogNo = "";
        int IntMaxLogNo=0;
        int intCount = 0;
        int intCount1 = 0;
        strWherePartLogNo= " BusinessNo ='" + iBusinessNo + "'";
        strWherePart = " BusinessNo ='" + iBusinessNo + "'"
                + " AND NodeStatus<>'0'" + " AND NodeStatus<>'4'";
          String   strWherePart1=" SELECT count(*) FROM WfLog WHERE " +strWherePart;
            Query nativeQuery=entityManager.createNativeQuery(strWherePart1);
            intCount=nativeQuery.getFirstResult();
            strWherePartLogNo="select max(logno) maxlogno from wflog where "+strWherePartLogNo;
            Query nativeQuery1=entityManager.createNativeQuery(strWherePartLogNo);
            IntMaxLogNo=nativeQuery1.getFirstResult();
            if (intCount == 0) {
                startType = "N";
            }
            if (intCount == 1) {
                strWherePart =" SELECT count(*) FROM WfLog WHERE "+ strWherePart.trim() + " AND LogNo='"+IntMaxLogNo+"'";
                Query nativeQuery2=entityManager.createNativeQuery(strWherePart1);
                intCount1=nativeQuery2.getFirstResult();
                if (intCount1 == 1) {
                    startType = "U";
                } else {
                    throw new Exception();
                }
            }

        return startType;
    }
    *//**
     * @desc 对复核后的任务进行处理
     * @Author : 双核项目组
     * @param iModelNo
     *            模板号
     * @param iCertiType
     *            单证类型
     * @param iBusinessNo
     *            业务号
     * @param iFlag
     *            是修改还是新启动标志
     * @param iNodeNo
     *            起始节点
     * @param iOption
     *            是出单员提交还是双核内部提交
     * @param iComCode
     *            部门代码
     * @return WfLogSchema对象, 对象中的有效属性是FlowID, NodeNo
     * @throws Exception
     *//*
    private String dealFirstTrans(int iModelNo, String iCertiType, String iBusinessNo, String iFlag, int iNodeNo, String iOption,
                                 String iRiskCode, String iClassCode, String iComCode, String iMakeCom, String iHandlerCode, String iHandler1Code,
                                 String iUserCode, String iContractNo,String verifySwitch)
            throws  Exception {
        WfLogDto wfLogDto = new WfLogDto();
        String strFlowID = "";
            wfLogDto = dealFirst( iModelNo, iCertiType,
                    iBusinessNo, iFlag, iRiskCode, iClassCode, iComCode,
                    iMakeCom, iUserCode, iHandlerCode, iHandler1Code,
                    iContractNo);
            strFlowID = wfLogDto.getFlowid();
            if("32".equals(iRiskCode.substring(0, 2))&&("C".equals(iCertiType)||"O".equals(iCertiType)||"B".equals(iCertiType))){
                *//*submitYZRiskCode( strFlowID, iModelNo, iNodeNo, iCertiType,
                        iBusinessNo, "0", iOption, iUserCode, "", iRiskCode);*//*
            }else{
                this.submit( strFlowID, iModelNo, iNodeNo, iCertiType,
                        iBusinessNo, "0", iOption, iUserCode, "");
            }
        return strFlowID;
    }

    *//**
     * @Author : 双核项目组
     * @desc 由业务提交核保任务处理
     * @param modelNo
     *            模板号
     * @param certiType
     *            单证类型
     * @param businessNo
     *            业务号
     * @param flag
     *            是修改还是新启动标志
     * @param riskCode
     *            险种
     * @param classCode
     *            险类
     * @param comCode 归属部门
     * @param makeCom 出单机构
     * @param userCode 业务操作人员
     * @param handlerCode 业务经办人员
     * @param handlerCode 业务归属人员
     * @param contractNo 合同号
     * @return WfLogDto对象
     * @throws Exception
     *//*
    private WfLogDto dealFirst( int modelNo, String certiType, String businessNo, String flag, String riskCode,
                               String classCode, String comCode, String makeCom, String userCode, String handlerCode, String handler1Code, String contractNo)
            throws  Exception {
    WfLogDto wfLogDto = new WfLogDto();
    PrpDuserDto prpDuserDto = new PrpDuserDto();
    PrpDcompanyDto prpDcompanyDto = new PrpDcompanyDto();
    String strFlowID = "";
    String strWfPackageID = "";
    String userName = "";
    String insuredCode = "";
    String insuredName = "";
    String licenseNo = "";
    String riskCategory = getRiskCategoryByRiskCode( riskCode);
    String relateContractNo = null;
    String[] identifyTypeNumber = null;
        // WfPackage是否要保存
        strWfPackageID = create( modelNo,
                certiType, businessNo, comCode);
        prpDuserDto = convert(prpDuserDao.findOne(new PrpDuserKey(userCode)),PrpDuserDto.class);
        userName = prpDuserDto.getUserName();
        PrpDcodeDto prpDcodeDto=new PrpDcodeDto();
        wfLogDto.setRiskCategory(riskCategory);
        wfLogDto.setReinsStatus("");
        if (flag.equals("N")) // 启动工作流
        {
            strFlowID = this.getSoleFlowID(comCode);
            if("1".equals(verifySwitch) && ("T".equals(certiType) || "E".equals(certiType) || "C".equals(certiType) || "Y".equals(certiType))){

                //todo 后期
                if("T".equals(certiType) || "E".equals(certiType)){
                  String   codeType="HBVerifyLevel";
                   String  codeCode="1";
                    prpDcodeDto =convert(prpDcodeDao.findOne(new PrpDcodeKey(codeType,codeCode)),PrpDcodeDto.class);
                }
                wfLogDto.setNodeName(prpDcodeDto.getCodeCName());
                wfLogDto.setTimeLimit(0);
            } else {
                Integer nodeNo=1;
                SWfNodeDto wfNodeDto =convert(sWfNodeDao.findOne(new SWfNodeKey(modelNo,nodeNo)),SWfNodeDto.class);
                wfLogDto.setNodeName(wfNodeDto.getNodeName());
                wfLogDto.setTimeLimit(wfNodeDto.getTimeLimit());
            }
            wfLogDto.setLogno(1);
            wfLogDto.setModelno(modelNo);
            wfLogDto.setNodeno(1);
            wfLogDto.setBusinessType(certiType);
            wfLogDto.setBusinessno(businessNo);
            wfLogDto.setDeptCode(comCode);
            prpDcompanyDto = convert(prpDcompanyDao.findOne(new PrpDcompanyKey(comCode)),PrpDcompanyDto.class);
            wfLogDto.setDeptName(prpDcompanyDto.getComcName());
            wfLogDto.setOperatorCode(userCode);
            wfLogDto.setOperatorName(userName);
            wfLogDto.setFlowinTime(new DateTime().current().toString()
                    .substring(0, 19));
            wfLogDto.setHandleTime(new DateTime().current().toString()
                    .substring(0, 19));
            wfLogDto.setNodeStatus("3");//在this.submit中插入和更新标志位 3已处理未流转
            wfLogDto.setFlowStatus("0");
            wfLogDto.setPackageid(strWfPackageID);
            wfLogDto.setFlowid(strFlowID);
            if (contractNo.length() > 0) {
                wfLogDto.setContractno(contractNo);
                // 以下信息为业务传送过来的信息
            }
            wfLogDto.setMakeCom(makeCom);
            wfLogDto.setComCode(comCode);
            wfLogDto.setRiskCode(riskCode);
            wfLogDto.setClassCode(classCode);
            wfLogDto.setHandler1Code(handler1Code);
            wfLogDto.setHandlerCode(handlerCode);

            if (certiType.equals("T")) {
                String proposalNo=businessNo;
                PrpTmainDto prpTmainDto =convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
                insuredCode = prpTmainDto.getInSuredCode();
                insuredName = prpTmainDto.getInSuredName();
                // 针对车险插入被保人姓名，车牌号码
						*//*DBPrpTitemCar dbPrpTitemCar = new DBPrpTitemCar(
                                dbManager);
						PrpTitemCarDto prpTitemCarDto = dbPrpTitemCar
								.findByPrimaryKey(businessNo, 1);
						if(prpTitemCarDto != null){//如果可以取到车牌号给车牌号赋值
						  licenseNo = prpTitemCarDto.getLicenseNo();
						  wfLogDto.setLicenseNo(licenseNo);
						}*//*
                wfLogDto.setInsuredCode(insuredCode);
                wfLogDto.setInsuredName(insuredName);
                wfLogDto.setIdentifyType("");
                wfLogDto.setIdentifyNumber("");
                // FIX0315 insert by liufengyao begin
                int dangerno = 1;
                DateTime date = new DateTime("2011-02-27", DateTime.YEAR_TO_DAY);
                //生成危险单位

                dangerno += getTDangerInfo(businessNo, false,false, dangerno,"");
                getTDangerInfo(businessNo, true,false,dangerno,"");
                setTDangerShare(businessNo);
            }
            //
            // 理赔工作流数据
            if (this.flag.equals("claim")) {
                wfLogDto.setRelateFlowid("");
                wfLogDto.setRelateLogno(0);
            }
            wfLogDao.save(convert(wfLogDto,WfLog.class));

            //chengkai;2006-07-20;如果是出单员，则插入出单员意见。begin
            if (wfLogDto.getNodeno() == 1){
                insertUwNotionByMakeUser(wfLogDto,certiType);
            }
            //end


            WfFlowMainDto wfFlowMainDto = new WfFlowMainDto();
            wfFlowMainDto.setFlowId(strFlowID);
            if (certiType.equals("T") || certiType.equals("P")) {
                wfFlowMainDto.setFlowName("核保工作流");
            }
            if (certiType.equals("E")) {
                wfFlowMainDto.setFlowName("核批工作流");
            }
            if (certiType.equals("C")) {
                wfFlowMainDto.setFlowName("核赔工作流");
            }
            if (certiType.equals("Y")) {
                wfFlowMainDto.setFlowName("核赔工作流");
            }
            wfFlowMainDto.setFlowStatus("1");
            wfFlowMainDto.setCreatDate(new DateTime().current().toString()
                    .substring(0, 19));
            WfFlowMain wfFlowMain=convert(wfFlowMainDto,WfFlowMain.class);
            wfFlowMainDao.save(wfFlowMain);
        }
		return wfLogDto;
    }

    *//**
     * 任务提交
     *
     * @param flowID
     *            工作流ID
     * @param modelNo
     *            模版号
     * @param nodeNo
     *            节点号
     * @param certiType
     *            单证类型
     * @param businessNo
     *            业务号
     * @param flowStatus
     *            流转状态标志 0:正常流转 1:回退
     * @param flag
     *            操作标志(0:复核/修改后的提交,1:核保核赔中的提交)
     * @param userCode
     *            用户代码

     * @param operatorCode
     *            String Return 无
     * @throws Exception
     *//*
    private boolean submit( String flowID, int modelNo,
                          int nodeNo, String certiType, String businessNo, String flowStatus,
                          String flag, String userCode, String operatorCode)
            throws Exception {
        boolean blnReturn = false;
        String strWherePart = "";
        int intCount = 0;
        char chCertiType = certiType.charAt(0);
        WfLogDto wfLogOldDto = new WfLogDto();
        WfLogDto wfLogNewDto = new WfLogDto();
        String strUnderWriteCode = "";
        DateTime underWriteDate = new DateTime(new DateTime().current().toString().substring(0, 10));
        String strBusinessSource = "prp"; // 业务数据来源:reins再保险/prp业务
        strWherePart ="SELECT count(*) FROM WfLog WHERE "+ "FlowID='" + flowID.trim() + "'";
        try {
          Query  query= entityManager.createNativeQuery(strWherePart);
            intCount=Integer.parseInt(query.getSingleResult().toString());
            String flowid=flowID;
            Integer logno=(Integer)intCount;
            wfLogOldDto=convert(wfLogDao.findOne(new WfLogKey(flowid,logno)),WfLogDto.class);
            // --1.生成新日志 wflog 表更新和插入记录
            generate(flowID, modelNo, nodeNo, flowStatus, operatorCode);
            intCount++;
             flowid=flowID;
             logno=intCount;
            wfLogNewDto=convert( wfLogDao.findOne(new WfLogKey(flowid,logno)),WfLogDto.class);
            boolean blnResult = false;
            if("1".equals(verifySwitch) && (chCertiType == 'T' || chCertiType == 'E' ||
                    chCertiType == 'C' || chCertiType == 'Y')){
                PrpDcodeDto prpDcodeDto = null;
                String codeType="";
                String codeCode="";
                if(chCertiType == 'T' || chCertiType == 'E'){
                    codeType="HBVerifyLevel";
                    codeCode=nodeNo+"";
                    prpDcodeDto =convert(prpDcodeDao.findOne(new PrpDcodeKey(codeType,codeCode)),PrpDcodeDto.class);
                }
                if("1".equals(prpDcodeDto.getFlag())){//表示可以作为结束节点
                    blnResult = true;
                }
            } else {
               String strWherePart1 = "ModelNo=" + modelNo + " AND NodeNo<>" + nodeNo + " AND EndFlag='1'";
                strWherePart1=" SELECT count(*) FROM SWfNode WHERE  "+strWherePart1;
                int con=entityManager.createNativeQuery(strWherePart1).getFirstResult();
                if(con>0){
                    blnResult=false ;
                }
            }
          if (!blnResult) // --2.1.如果当前节点TO不是核保通过节点  提交核保
            {
                String nodeType = "0";
                // --2.1.1.判断当前节点TO是否为打回修改节点
                if (nodeNo == 1) { //打回修改节点
                    strUnderWriteCode = userCode;
                    // 倒数第二个参数表示1:远程核保 0:非远程核保
                    // 最后一个参数表示reins:再保险 prp:业务
                    *//*blPrpFeedBackAction.echo(dbManager, chCertiType, businessNo, "2", strUnderWriteCode, underWriteDate, "1", strBusinessSource);*//*
                } else { //不是打回修改节点

                    if (!wfLogNewDto.getNodeStatus().equals("0") && (wfLogNewDto.getLogno() == 2 || wfLogOldDto.getNodeno() == 1)) {
                        echoSubmit( chCertiType, businessNo, "9", strBusinessSource);
                    } else {
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return blnReturn;
    }

    private String getRiskCategoryByRiskCode(String riskCode) throws Exception {
        Prpdrisk prpdrisk=prpdriskDao.findOne(new PrpdriskKey(riskCode));
        String classCode=prpdrisk.getClassCode();
        Prpdclass prpdclass=prpdclassDao.findOne(new PrpdclassKey(classCode));

        return prpdclass.getRiskcategory();
    }
    *//**
     * 根据部门和时间生成信息包号
     *//*
    private String getSolePackageID (String comCode)
            throws Exception {
        String wfPackageID = "";
        String currentTime = new DateTime().current().toString();
        String currentYear = currentTime.substring(0,4);
        String currentMonth = currentTime.substring(5,7);
        String currentDay = currentTime.substring(8,10);
        String currentHour = currentTime.substring(11,13);
        String currentMinute = currentTime.substring(14,16);
        String currentSecond = currentTime.substring(17,19);
        String currentMM = currentTime.substring(20,23);
        wfPackageID = comCode+currentYear+currentMonth+currentDay+currentHour+currentMinute+currentSecond+currentMM;
        return wfPackageID;

    }

    *//**
     * 创建工作流包信息表
     * @param iModelNo 模版号
     * @param  iBusinessNo 业务号
     *//*
    private String create( int iModelNo, String iCertiType, String iBusinessNo, String iComCode)
            throws  Exception {
        String wfPackageID="";
        int intResult = 0;
        String riskCode = "";
        String  comCode = iComCode;
        char certiType = iCertiType.charAt(0);
        //this.wfPackageID = dbWfPackage.getMaxPackageID(this.comCode);
        wfPackageID = getSolePackageID(comCode);
        if (wfPackageID == null || wfPackageID.length() == 0) {
            throw new Exception("获取 PackageID 失败[100]!");
        }
        String mainStatement = " Insert Into WfPackage (" +
                " PackageID," +
                " DetailNo," +
                " DetailContent," +
                " Flag)";
        String statement = mainStatement + " values('"+wfPackageID+"','"+1+"','"+"省略 " + iBusinessNo + " 的摘要信息"+"','"+this.flag+"')";
        Query query=entityManager.createNativeQuery(statement);

        return wfPackageID;
    }
    *//**
     * 根据部门和时间生成信息包号
     *
     *//*
    private String getSoleFlowID(String comCode) throws  Exception {
        String flowID = "";
        String currentTime = new DateTime().current().toString();
        String currentYear = currentTime.substring(0, 4);
        String currentMonth = currentTime.substring(5, 7);
        String currentDay = currentTime.substring(8, 10);
        String currentHour = currentTime.substring(11, 13);
        String currentMinute = currentTime.substring(14, 16);
        String currentSecond = currentTime.substring(17, 19);
        String currentMM = currentTime.substring(20, 23);
        flowID = comCode + currentYear + currentMonth + currentDay
                + currentHour + currentMinute + currentSecond + currentMM;
        return flowID;

    }

    *//**
     * 将制单员的说明，插入到UwNotion表中。如果是出单员，则插入出单员意见
     *//*
    private void insertUwNotionByMakeUser( WfLogDto wfLogDto , String iCertiType)
            throws Exception {
        if (wfLogDto == null) {
            return;
        }
        UwNotionDto uwNotionDto=new UwNotionDto();
        PrpTmain prpTmain=null;
        if(iCertiType.equals("T")){//判断业务类型
            String proposalNo=wfLogDto.getBusinessno();
             prpTmain=prpTmainDao.findOne(new PrpTmainKey(proposalNo));
            uwNotionDto.setHandleText(prpTmain.getReMark());//出单员的意见
        }

        if (prpTmain !=null) {
            uwNotionDto.setFlowId(wfLogDto.getFlowid());
            uwNotionDto.setLogNo(wfLogDto.getLogno());
            if (!"".equals(uwNotionDto.getHandleText()) && uwNotionDto.getHandleText() != null){
                uwNotionDao.save(convert(uwNotionDto,UwNotion.class));
            }
        }
    }

    *//**
     * 生成工作流中一个节点
     *
     * @param iFlowID,iModelNo,iNodeNo,iFlowStatus
     * @throws Exception
     *//*
    private boolean generate( String iFlowID, int iModelNo,
                             int iNodeNo, String iFlowStatus, String iHandleCode)
            throws  Exception {
        boolean blnReturn = false;
        int intCount = 0;
        String strNowTime = "";
        PrpDcodeDto prpDcodeDto=new PrpDcodeDto();
        WfLogDto wfLogCurrDto = new WfLogDto();
        WfLogDto wfLogNextDto = new WfLogDto();
        strNowTime = new DateTime().current().toString().substring(0, 19);
        String  strWherePart ="SELECT count(*) FROM WfLog WHERE "+ "FlowID='" + iFlowID.trim() + "'";
        try {
            String strwhere=" select * from wflog where "+" FlowID='" + iFlowID + "' AND NodeStatus='0'";
            Query queryList=entityManager.createNativeQuery(strwhere);
            List wfLogList=queryList.getResultList();

            if (wfLogList.size() > 0) {
                throw new Exception("该工作流已审核通过，请不要重复操作！");
            }
            intCount=Integer.parseInt(entityManager.createNativeQuery(strWherePart).getSingleResult().toString());
            String flowid=iFlowID;
            Integer logno=intCount;
            String codeType="";
            String codeCode="";
            wfLogCurrDto = convert(wfLogDao.findOne(new WfLogKey(flowid,logno)),WfLogDto.class);
            if("1".equals(verifySwitch) && ("T".equals(wfLogCurrDto.getBusinessType()) || "E".equals(wfLogCurrDto.getBusinessType()) ||
                    "C".equals(wfLogCurrDto.getBusinessType()) || "Y".equals(wfLogCurrDto.getBusinessType()))){
                if("T".equals(wfLogCurrDto.getBusinessType()) || "E".equals(wfLogCurrDto.getBusinessType())){
                    codeType="HBVerifyLevel";
                    codeCode=iNodeNo+"";
                    prpDcodeDto =convert(prpDcodeDao.findOne(new PrpDcodeKey(codeType,codeCode)),PrpDcodeDto.class);
                }
                wfLogNextDto.setNodeno(Integer.parseInt(prpDcodeDto.getCodeCode()));
                wfLogNextDto.setNodeName(prpDcodeDto.getCodeCName());
                wfLogNextDto.setTimeLimit(0);
            }
            // 为生成新的节点做数据准备
            intCount += 1;
            wfLogNextDto.setFlowid(iFlowID);
            wfLogNextDto.setLogno(intCount);
            wfLogNextDto.setModelno(iModelNo);
            wfLogNextDto.setBusinessType(wfLogCurrDto.getBusinessType());
            wfLogNextDto.setBusinessno(wfLogCurrDto.getBusinessno());
            wfLogNextDto.setFlowinTime(strNowTime);
            wfLogNextDto.setNodeStatus("1");//插入一条新记录为1待处理
            wfLogNextDto.setFlowStatus(iFlowStatus);
            wfLogNextDto.setOperatorCode(iHandleCode);
            wfLogNextDto.setPackageid(wfLogCurrDto.getPackageid());
            wfLogNextDto.setContractno(wfLogCurrDto.getContractno());
            wfLogNextDto.setClassCode(wfLogCurrDto.getClassCode());
            wfLogNextDto.setRiskCode(wfLogCurrDto.getRiskCode());
            wfLogNextDto.setHandlerCode(wfLogCurrDto.getHandlerCode());
            wfLogNextDto.setHandler1Code(wfLogCurrDto.getHandler1Code());
            wfLogNextDto.setComCode(wfLogCurrDto.getComCode());
            wfLogNextDto.setMakeCom(wfLogCurrDto.getMakeCom());
            wfLogNextDto.setInsuredCode(wfLogCurrDto.getInsuredCode());
            wfLogNextDto.setInsuredName(wfLogCurrDto.getInsuredName());
            wfLogNextDto.setLicenseno(wfLogCurrDto.getLicenseno());
            wfLogNextDto.setRiskCategory(wfLogCurrDto.getRiskCategory());
            wfLogNextDto.setIdentifyType(wfLogCurrDto.getIdentifyType());
            wfLogNextDto.setIdentifyNumber(wfLogCurrDto.getIdentifyNumber());
            wfLogNextDto.setReinsStatus(wfLogCurrDto.getReinsStatus());
            wfLogNextDto.setPolicyno(wfLogCurrDto.getPolicyno());
            wfLogNextDto.setClaimno(wfLogCurrDto.getClaimno());

            if (false) {
                wfLogNextDto.setRelateFlowid("");
                wfLogNextDto.setRelateLogno(0);
            } else {
                wfLogNextDto.setRelateFlowid(wfLogCurrDto.getRelateFlowid());
                wfLogNextDto.setRelateLogno(wfLogCurrDto.getRelateLogno());
            }
            wfLogDao.save(convert(wfLogNextDto,WfLog.class));
            wfLogCurrDto.setHandleTime(strNowTime);
            wfLogCurrDto.setNodeStatus("4");//当前一条记录更新为4以处理
            if(wfLogCurrDto.getNodeno()>wfLogNextDto.getNodeno()){
                wfLogCurrDto.setFlag("1");
            }
            wfLogCurrDto.setSubmitTime(strNowTime);
            wfLogDao.save(convert(wfLogCurrDto,WfLog.class));
            blnReturn = true;
        } catch (Exception e) {
            throw e;
        }
        return blnReturn;
    }

    *//**
     *
     * @param certiType
     * @param businessNo
     * @param flag
     * @param businessSource
     * @return
     * @throws Exception
     *//*
    private boolean echoSubmit(char certiType, String businessNo, String flag, String businessSource)
            throws  Exception
    {
        boolean blnReturn = false;
        PrpTmainDto prpTmainDto = new PrpTmainDto();
        try {
            switch (certiType) {
                case 'T':
                    String proposalNo=businessNo;
                    prpTmainDto= convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
                    prpTmainDto.setUnderwriteFlag(flag);
                    prpTmainDao.save(convert(prpTmainDto,PrpTmain.class));
                    blnReturn = true;
                    break;
                default:
                    throw new Exception( "无此单证类型");
            }
        }
        catch (Exception e) {
            throw new Exception();
        }

        return blnReturn;
    }

    public int getTDangerInfo(String proposalNo, boolean exitemFlag, boolean isThirdDuty, int dangerNo, String dumRiskCode) throws Exception
    {
        TDangerDto tDangerDto = new TDangerDto();
        PrpTdangerUnitDto PrpTdangerUnitDto = null;
        Collection PrpTdangerItemDtoList = new ArrayList();
        Collection PrpTdangerTotDtoList = new ArrayList();
        Collection PrpTdangerPlanDtoList = new ArrayList();
        Collection PrpTdangerCoinsDtoList = new ArrayList();

        PrpTdangerUnitDto = getInfoByProposalNo( proposalNo, dangerNo, exitemFlag, isThirdDuty, dumRiskCode);

        PrpTdangerItemDtoList =getInfoByProposalNo( PrpTdangerUnitDto.getRiskCode(), proposalNo, exitemFlag, isThirdDuty, dangerNo, dumRiskCode);

        PrpTdangerTotDtoList = getInfoByProposalNo( proposalNo, PrpTdangerUnitDto.getRiskCode(), PrpTdangerItemDtoList, PrpTdangerCoinsDtoList);

        PrpTdangerPlanDtoList =getInfoByProposalNo(proposalNo, PrpTdangerTotDtoList);

        PrpTdangerUnitDto = updateAmount(PrpTdangerUnitDto, PrpTdangerCoinsDtoList, PrpTdangerTotDtoList);

        PrpTdangerCoinsDtoList = getInfoByProposalNoNew(PrpTdangerUnitDto.getRiskCode(), proposalNo, PrpTdangerTotDtoList, PrpTdangerUnitDto);
        tDangerDto.setPrpTdangerUnitDto(PrpTdangerUnitDto);
        tDangerDto.setPrpTdangerItemDtoList(PrpTdangerItemDtoList);
        tDangerDto.setPrpTdangerTotDtoList(PrpTdangerTotDtoList);
        tDangerDto.setPrpTdangerPlanDtoList(PrpTdangerPlanDtoList);
        tDangerDto.setPrpTdangerCoinsDtoList(PrpTdangerCoinsDtoList);

        delete(proposalNo, PrpTdangerUnitDto.getDangerNo());

        save(tDangerDto);
        int dangerCount = 0;
        if ((PrpTdangerUnitDto != null) && (PrpTdangerItemDtoList != null) && (PrpTdangerItemDtoList.size() > 0))
        {
            dangerCount = 1;
        }
        return dangerCount;
    }

    public PrpTdangerUnitDto getInfoByProposalNo(String proposalNo, int dangerNo, boolean exitemFlag, boolean isThirdDuty, String dumRiskCode)
            throws Exception
    {
        PrpTdangerUnitDto prpTdangerUnitDto = new PrpTdangerUnitDto();

        String groupFlag = "";
        PrpTmainDto  prpTmainDto=convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
        prpTdangerUnitDto.setProposalNo(prpTmainDto.getProposalNo());
        prpTdangerUnitDto.setRiskCode(prpTmainDto.getRiskCode());
        prpTdangerUnitDto.setDangerNo(dangerNo);

        prpTdangerUnitDto.setLimitAmount(prpTmainDto.getLimitAmount());
        prpTdangerUnitDto.setGroupFlag(groupFlag);
        prpTdangerUnitDto.setCoinsFlag(prpTmainDto.getCoinsFlag());
        prpTdangerUnitDto.setShareholderFlag(prpTmainDto.getShareholderFlag());
        prpTdangerUnitDto.setBusinessFlag(prpTmainDto.getBusinessFlag());
        prpTdangerUnitDto.setBusinessNature(prpTmainDto.getBusinessNature());
        prpTdangerUnitDto.setBusinessType(prpTmainDto.getBusinessType());
        prpTdangerUnitDto.setBusinessType1(prpTmainDto.getBusinessType1());
        prpTdangerUnitDto.setPolicybizType(prpTmainDto.getPolicybizType());
        prpTdangerUnitDto.setPolicyType(prpTmainDto.getPolicyType());
        prpTdangerUnitDto.setOthFlag(prpTmainDto.getOthFlag());
        prpTdangerUnitDto.setBusinessprovince(prpTmainDto.getBusinessProvince());
        prpTdangerUnitDto.setBusinesstown(prpTmainDto.getBusinessTown());
        prpTdangerUnitDto.setBusinessCounty(prpTmainDto.getBusinessCounty());
        prpTdangerUnitDto.setBusinessAreaName(prpTmainDto.getBusinessAreaname());

        if ("1".equals(prpTmainDto.getBusinessFlag()))
        {
            prpTdangerUnitDto.setFlag("00");
        } else if (exitemFlag)
        {
            prpTdangerUnitDto.setFlag("01");
        }
        else {
            prpTdangerUnitDto.setFlag("10");
        }
        Collection fhRetenDtoList = null;
        String     riskCode       = "";
        String     uwYear         = "";
        String     riskLevel      = "";
        String     riskLevelDesc  = "";
        String     retCurrency    = "";
        String     conditions     = "";
        String     flag           = "";
        Double     retentionValue =new Double(0);
        Double     RetentionRate =new Double(0) ;
        String 	   businessType = "" ;
        String startDate="";

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        startDate= simpleDateFormat.format(prpTmainDto.getStartDate());
        riskCode = prpTmainDto.getRiskCode();
        businessType = prpTdangerUnitDto.getBusinessType();
        if(!"".equals(dumRiskCode)){//组合险类
            riskCode=dumRiskCode;
            prpTdangerUnitDto.setDumriskCode(dumRiskCode);
            prpTdangerUnitDto.setZhFlag("1");
        }else{
            prpTdangerUnitDto.setZhFlag("0");
        }
        //获取该险种默认的危险单位
        conditions = " f.riskCode =:riskCode AND subStr(Flag,1,1)='1' and  SINOSOFT_to_date( :startDate,'yyyy-mm-dd') >=f.startDate " +
                "and SINOSOFT_to_date(:startDate,'yyyy-mm-dd')<= f.endDate ";
        //意键险取默认自留额
        //现金保险要根据 行业类别 取最大自留额
        conditions += " AND ( f.businessType =:businessType  or  f.businessType = '99' )" ;

        String strwhere=" select f  from FhReten f where " +conditions;
       Query query= entityManager.createQuery(strwhere);
        query.setParameter("riskCode",riskCode);
        query.setParameter("startDate",startDate);
        query.setParameter("businessType",businessType);
        List<FhReten> resultList=query.getResultList();
        for(FhReten fhReten:resultList){

            FhRetenDto fhRetenDto=convert(fhReten,FhRetenDto.class);
            riskLevel      = fhRetenDto.getRiskLevel();
            riskLevelDesc  = fhRetenDto.getRiskClassDesc();
            retCurrency    = fhRetenDto.getCurrency();
            retentionValue = fhRetenDto.getRetentionValue();
            RetentionRate  = fhRetenDto.getRetentionrate();
            flag           = fhRetenDto.getFlag();
        }
        prpTdangerUnitDto.setRiskLevel(riskLevel);
        prpTdangerUnitDto.setRiskLevelDesc(riskLevelDesc);
        prpTdangerUnitDto.setRetentionrate(RetentionRate);//合约适用比例
        prpTdangerUnitDto.setRetentionrateFlag("0");//合约适用比例申报标识
        if(flag!=null && flag.length()>=2){
            if(flag.substring(1, 2).equals("1")){//flag第二位为1，则不设置风险等级，由核保去选
                prpTdangerUnitDto.setRiskLevel("");//
                prpTdangerUnitDto.setRiskLevelDesc("");
            }
        }
        prpTdangerUnitDto.setRetcurrency(retCurrency);
        prpTdangerUnitDto.setRetentionValue(retentionValue);
        if (exitemFlag)
        {
            prpTdangerUnitDto.setDangerDesc("除外责任危险单位");
        }if (isThirdDuty)
    {
        prpTdangerUnitDto.setDangerDesc("第三者责任危险单位");
    }
    else {
        prpTdangerUnitDto.setDangerDesc("危险单位" + dangerNo);
    }
        prpTdangerUnitDto.setBusinessNature(prpTmainDto.getBusinessNature());
        prpTdangerUnitDto.setBusinessType(prpTmainDto.getBusinessType());
        prpTdangerUnitDto.setBusinessType1(prpTmainDto.getBusinessType1());
        prpTdangerUnitDto.setPolicybizType(prpTmainDto.getPolicybizType());
        prpTdangerUnitDto.setPolicyType(prpTmainDto.getPolicyType());
        prpTdangerUnitDto.setOthFlag(prpTmainDto.getOthFlag());
        prpTdangerUnitDto.setBusinessprovince(prpTmainDto.getBusinessProvince());
        prpTdangerUnitDto.setBusinesstown(prpTmainDto.getBusinessTown());
        prpTdangerUnitDto.setBusinessCounty(prpTmainDto.getBusinessCounty());
        prpTdangerUnitDto.setBusinessAreaName(prpTmainDto.getBusinessAreaname());
        return prpTdangerUnitDto;
    }

    public Collection getInfoByProposalNo(String proposalNo, String riskCode, Collection prpTdangerItemDtoList, Collection prpTdangerCoinsDtoList)
            throws Exception
    {
        Collection prpTdangerTotDtoList = new ArrayList();
        PrpTdangerTotDto prpTdangerTotDto = null;
        PrpTfeeDto prpTfeeDto = null;
        Iterator iterator = null;
        Iterator itTot = null;
        PrpTdangerItemDto prpTdangerItemDto = null;
        Collection prpTfeeList = null;
        boolean find = true;

        if (prpTdangerItemDtoList != null)
        {
            iterator = prpTdangerItemDtoList.iterator();

            while (iterator.hasNext())
            {
                prpTdangerItemDto = (PrpTdangerItemDto)iterator.next();
                find = false;
                itTot = prpTdangerTotDtoList.iterator();

                while (itTot.hasNext())
                {
                    prpTdangerTotDto = (PrpTdangerTotDto)itTot.next();
                    if ((prpTdangerTotDto.getDangerNo() == prpTdangerItemDto.getDangerNo()) && (prpTdangerTotDto.getScurrency().equals(prpTdangerItemDto.getCurrency())))
                    {
                        find = true;
                        if (prpTdangerItemDto.getCalculateFlag().equals("Y"))
                        {
                            prpTdangerTotDto.setAmount(round(prpTdangerTotDto.getAmount() + prpTdangerItemDto.getAmount(), 2));
                        }
                        prpTdangerTotDto.setPremium(round(prpTdangerTotDto.getPremium() + prpTdangerItemDto.getPremium(), 2));
                    }

                }

                if (!find)
                {
                    prpTdangerTotDto = new PrpTdangerTotDto();
                    prpTdangerTotDto.setProposalNo(proposalNo);
                    prpTdangerTotDto.setDangerNo(prpTdangerItemDto.getDangerNo());
                    prpTdangerTotDto.setScurrency(prpTdangerItemDto.getCurrency());

                    if (prpTdangerItemDto.getCalculateFlag().equals("Y"))
                    {
                        prpTdangerTotDto.setAmount(prpTdangerItemDto.getAmount());
                    }
                    prpTdangerTotDto.setPremium(prpTdangerItemDto.getPremium());
                    prpTdangerTotDtoList.add(prpTdangerTotDto);
                }
            }
        }
        double exchRate = 0.0D;
        String strWhere=" select f from PrpTfee f where  f.proposalNo=:proposalNo  ";
        Query entityManagerQuery=entityManager.createQuery(strWhere);
        entityManagerQuery.setParameter("proposalNo",proposalNo);
        List<PrpTfeeDto> prpTfeeDtoList=new ArrayList<PrpTfeeDto>();
        List<PrpTfee> prpTfeeList1=entityManagerQuery.getResultList();
        convertCollection(prpTfeeList1,prpTfeeDtoList,PrpTfeeDto.class);
        itTot = prpTdangerTotDtoList.iterator();
        while(itTot.hasNext())
        {
            prpTdangerTotDto = (PrpTdangerTotDto)itTot.next();
            iterator = prpTfeeDtoList.iterator();
            while (iterator.hasNext())
            {
                prpTfeeDto = (PrpTfeeDto)iterator.next();
                if (prpTdangerTotDto.getScurrency().equals(prpTfeeDto.getCurrency()))
                exchRate = prpTfeeDto.getExchangeRate1();
                prpTdangerTotDto.setExchrate(exchRate);
                prpTdangerTotDto.setTcurrency(prpTfeeDto.getCurrency1());
                prpTdangerTotDto.setTcurrency(prpTfeeDto.getCurrency1());
                prpTdangerTotDto.setAmountex(round(prpTdangerTotDto.getAmount() * exchRate, 2));
                prpTdangerTotDto.setPremiumex(round(prpTdangerTotDto.getPremium() * exchRate, 2));
                break;
            }

        }

        return prpTdangerTotDtoList;
     }

    public Collection getInfoByProposalNo( String proposalNo, Collection prpTdangerTotDtoList)
            throws Exception
    {
        Collection PrpTdangerPlanDtoList = new ArrayList();
        String strWhere=" select f from PrpTplan f where  f.proposalNo=:proposalNo  ";
        Query entityManagerQuery=entityManager.createQuery(strWhere);
        entityManagerQuery.setParameter("proposalNo",proposalNo);
        List<PrpTplanDto> PrpTplanDtoList=new ArrayList<PrpTplanDto>();
        List<PrpTplan>  prpTplans=entityManagerQuery.getResultList();
        convertCollection(prpTplans,PrpTplanDtoList,PrpTplanDto.class);
        PrpTdangerTotDto prpTdangerTotDto = null;
        DateTime planDate = new DateTime(DateTime.current().toString().substring(0, 10));
        long serialNo = 0L;
        double sumPlanFee = 0.0D;
        double planFee = 0.0D;
        double premium = 0.0D;
        double sumTemPremium = 0.0D;
        int planMaxSize = 0;
        int planSize = 0;

        if (PrpTplanDtoList != null) {
            Iterator itPlan = PrpTplanDtoList.iterator();
            while (itPlan.hasNext())
            {
                planMaxSize++;
                PrpTplanDto prpTplanDto = (PrpTplanDto)itPlan.next();
                sumPlanFee += prpTplanDto.getPlanFee();
            }
            Iterator iteratorTdangerTot = prpTdangerTotDtoList.iterator();
            while (iteratorTdangerTot.hasNext()) {
                prpTdangerTotDto = (PrpTdangerTotDto)iteratorTdangerTot.next();
                itPlan = PrpTplanDtoList.iterator();
                sumTemPremium = 0.0D;
                planSize = 0;
                while (itPlan.hasNext())
                {
                    planSize++;
                    PrpTplanDto prpTplanDto = (PrpTplanDto)itPlan.next();
                    PrpTdangerPlanDto prpTdangerPlanDto = new PrpTdangerPlanDto();
                    prpTdangerPlanDto.setProposalNo(prpTdangerTotDto.getProposalNo());
                    prpTdangerPlanDto.setDangerNo(prpTdangerTotDto.getDangerNo());
                    prpTdangerPlanDto.setSerialNo((int)prpTplanDto.getSerialNo());
                    prpTdangerPlanDto.setPayNo((int)prpTplanDto.getPayNo());
                    prpTdangerPlanDto.setPlanDate(prpTplanDto.getPlanstartDate());
                    prpTdangerPlanDto.setCurrency(prpTplanDto.getCurrency());
                    premium = prpTdangerTotDto.getPremium();
                    if (sumPlanFee == 0.0D)
                    {
                        planFee = premium;
                    }
                    else if (planSize == planMaxSize)
                    {
                        planFee = premium - sumTemPremium;
                    }
                    else {
                        planFee = round(premium * prpTplanDto.getPlanFee() / sumPlanFee, 2);
                    }

                    sumTemPremium += planFee;
                    prpTdangerPlanDto.setPlanFee(planFee);
                    PrpTdangerPlanDtoList.add(prpTdangerPlanDto);
                }
            }
        }

        return PrpTdangerPlanDtoList;
    }


    public PrpTdangerUnitDto updateAmount(PrpTdangerUnitDto prpTdangerUnitDto, Collection prpTdangerCoinsDtoList, Collection prpTdangerTotDtoList)
            throws Exception
    {
        Iterator iterator = null;
        double sumAmount = 0.0D;
        double sumPremium = 0.0D;
        double sumDisFee = 0.0D;
        String currency = "";

        sumDisFee =getDisPremiumT(prpTdangerUnitDto.getProposalNo());

        if ((prpTdangerTotDtoList != null) && (prpTdangerTotDtoList.size() > 0))
        {
            iterator = prpTdangerTotDtoList.iterator();
            while (iterator.hasNext())
            {
                PrpTdangerTotDto prpTdangerTotDto = (PrpTdangerTotDto)iterator.next();
                sumAmount += prpTdangerTotDto.getAmountex();
                sumPremium += prpTdangerTotDto.getPremiumex();
                currency = prpTdangerTotDto.getTcurrency();
            }
        }

        prpTdangerUnitDto.setDisfee(sumDisFee);
        prpTdangerUnitDto.setAmount(sumAmount);
        prpTdangerUnitDto.setPremium(sumPremium);
        prpTdangerUnitDto.setCurrency(currency);
        prpTdangerUnitDto.setSpecurrency(currency);

        return prpTdangerUnitDto;
    }

    public Collection getInfoByProposalNoNew( String riskCode, String proposalNo, Collection prpTdangerTotDtoList, PrpTdangerUnitDto prpTdangerUnitDto)
            throws Exception
    {
        Collection prpTdangerCoinsDtoList = new ArrayList();
        PrpTdangerCoinsDto prpTdangerCoinsDto = null;
        PrpTcoinsDto prpTcoinsDto = null;

        String strWhere = " select * from  PrpTcoins where "+ " proposalNo='" + proposalNo + "'";
         Query query=entityManager.createNativeQuery(strWhere);
         List<Object> prpTcoinsDtoList=query.getResultList();

        PrpTmainDto  prpTmainDto=convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
        String coinsFlag = prpTmainDto.getCoinsFlag();
        if (("1".equals(coinsFlag)) || ("3".equals(coinsFlag))) {
            if ((prpTcoinsDtoList != null) && (prpTcoinsDtoList.size() > 0))
            {
                Iterator iterator = prpTdangerTotDtoList.iterator();
                while (iterator.hasNext())
                {
                    PrpTdangerTotDto prpTdangerTotDto = (PrpTdangerTotDto)iterator.next();
                    for(Object obj : prpTcoinsDtoList){
                        prpTcoinsDto = (PrpTcoinsDto)obj;
                        prpTdangerCoinsDto = new PrpTdangerCoinsDto();

                        prpTdangerCoinsDto.setProposalNo(prpTdangerTotDto.getProposalNo());
                        prpTdangerCoinsDto.setDangerNo(prpTdangerTotDto.getDangerNo());
                        prpTdangerCoinsDto.setSerialNo(prpTcoinsDto.getSerialNo());
                        prpTdangerCoinsDto.setMainproposalNo(prpTdangerTotDto.getProposalNo());
                        prpTdangerCoinsDto.setCoinsCode(prpTcoinsDto.getCoinsCode());
                        prpTdangerCoinsDto.setCoinsName(prpTcoinsDto.getCoinsName());
                        prpTdangerCoinsDto.setCoinsType(prpTcoinsDto.getCoinsType());
                        prpTdangerCoinsDto.setCoinsRate(prpTcoinsDto.getCoinsRate());
                        prpTdangerCoinsDto.setChiefFlag(prpTcoinsDto.getChiefFlag());
                        prpTdangerCoinsDto.setProportionFlag(prpTcoinsDto.getProportionFlag());
                        prpTdangerCoinsDto.setCurrency(prpTdangerTotDto.getScurrency());
                        prpTdangerCoinsDto.setCoinsAmount(Double.parseDouble(String.valueOf(prpTdangerTotDto.getAmount() * prpTcoinsDto.getCoinsRate() / 100.0D)));
                        prpTdangerCoinsDto.setCoinsPremium(Double.parseDouble(String.valueOf(prpTdangerTotDto.getPremium() * prpTcoinsDto.getCoinsRate() / 100.0D)));
                        prpTdangerCoinsDto.setMiddlecostFee(0.0D);
                        prpTdangerCoinsDto.setFlag("");

                        prpTdangerCoinsDtoList.add(prpTdangerCoinsDto);
                    }
                }
            }
        } else if ((("2".equals(coinsFlag)) || ("4".equals(coinsFlag))) &&
                (prpTcoinsDtoList != null) && (prpTcoinsDtoList.size() > 0))
        {
            double dangerUnitAmount = 0.0D;
            double dangerUnitPremium = 0.0D;
            Iterator prpTcoinsIterator = prpTcoinsDtoList.iterator();

            while (prpTcoinsIterator.hasNext()) {
                prpTcoinsDto = (PrpTcoinsDto)prpTcoinsIterator.next();
                if ("1".equals(prpTcoinsDto.getCoinsType())) {
                    dangerUnitAmount = round(prpTdangerUnitDto.getAmount() / (prpTcoinsDto.getCoinsRate() / 100.0D), 2);
                    dangerUnitPremium = round(prpTdangerUnitDto.getPremium() / (prpTcoinsDto.getCoinsRate() / 100.0D), 2);
                }

            }

            Iterator iterator = prpTdangerTotDtoList.iterator();
            while (iterator.hasNext())
            {
                PrpTdangerTotDto prpTdangerTotDto = (PrpTdangerTotDto)iterator.next();
                Iterator itCoins = prpTcoinsDtoList.iterator();
                while (itCoins.hasNext())
                {
                    prpTcoinsDto = (PrpTcoinsDto)itCoins.next();
                    prpTdangerCoinsDto = new PrpTdangerCoinsDto();

                    prpTdangerCoinsDto.setProposalNo(prpTdangerTotDto.getProposalNo());
                    prpTdangerCoinsDto.setDangerNo(prpTdangerTotDto.getDangerNo());
                    prpTdangerCoinsDto.setSerialNo(prpTcoinsDto.getSerialNo());
                    prpTdangerCoinsDto.setMainproposalNo(prpTdangerTotDto.getProposalNo());
                    prpTdangerCoinsDto.setCoinsCode(prpTcoinsDto.getCoinsCode());
                    prpTdangerCoinsDto.setCoinsName(prpTcoinsDto.getCoinsName());
                    prpTdangerCoinsDto.setCoinsType(prpTcoinsDto.getCoinsType());
                    prpTdangerCoinsDto.setCoinsRate(prpTcoinsDto.getCoinsRate());
                    prpTdangerCoinsDto.setChiefFlag(prpTcoinsDto.getChiefFlag());
                    prpTdangerCoinsDto.setProportionFlag(prpTcoinsDto.getProportionFlag());
                    prpTdangerCoinsDto.setCurrency(prpTdangerTotDto.getScurrency());

                    if ("1".equals(prpTcoinsDto.getCoinsType())) {
                        prpTdangerCoinsDto.setCoinsAmount(round(prpTdangerUnitDto.getAmount(), 2));
                        prpTdangerCoinsDto.setCoinsPremium(round(prpTdangerUnitDto.getPremium(), 2));
                    } else {
                        prpTdangerCoinsDto.setCoinsAmount(round(dangerUnitAmount * prpTcoinsDto.getCoinsRate() / 100.0D, 2));
                        prpTdangerCoinsDto.setCoinsPremium(round(dangerUnitPremium * prpTcoinsDto.getCoinsRate() / 100.0D, 2));
                    }

                    prpTdangerCoinsDto.setMiddlecostFee(0.0D);
                    prpTdangerCoinsDto.setFlag("");

                    prpTdangerCoinsDtoList.add(prpTdangerCoinsDto);
                }

            }

        }

        return prpTdangerCoinsDtoList;
    }

    public void setTDangerShare(String proposalNo)
            throws Exception
    {
        String strWhere=" select f from PrpTdangerUnit f where  f.proposalNo=:proposalNo  ";
        Query entityManagerQuery=entityManager.createQuery(strWhere);
        entityManagerQuery.setParameter("proposalNo",proposalNo);
        List<PrpTdangerUnit>  prpTdangerUnitList=entityManagerQuery.getResultList();
        PrpTmainDto  prpTmainDto=convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
        PrpTdangerUnit prpTdangerUnit = null;
        double dangerShare = 0.0D;
        double tempDangerShare = 0.0D;
        for (int i = 0; i < prpTdangerUnitList.size(); i++)
        {
            prpTdangerUnit = (PrpTdangerUnit)prpTdangerUnitList.get(i);
            if (i == prpTdangerUnitList.size() - 1)
            {
                dangerShare = round(100.0D - tempDangerShare, 2);
            }
            else {
                dangerShare = round(prpTdangerUnit.getAmount() / prpTmainDto.getSumAmount() * 100.0D, 2);
                tempDangerShare = round(dangerShare + tempDangerShare, 2);
            }
            prpTdangerUnit.setDangerShare(dangerShare);

            prpTdangerUnitDao.save(prpTdangerUnit);
        }
    }

    public Collection getInfoByProposalNo(String riskCode, String proposalNo, boolean exitemFlag, boolean isThirdDuty, int dangerNo, String dumRiskCode)
            throws Exception
    {
        Collection PrpTdangerItemDtoList = new ArrayList();
        Collection PrpTitemKindDtoList = new ArrayList();
        List<PrpTitemKindDto> prpTitemKindDtoList = new ArrayList<PrpTitemKindDto>();
        PrpTdangerItemDto prpTdangerItemDto = new PrpTdangerItemDto();
        PrpTitemKindDto prpTitemKindDto = new PrpTitemKindDto();

        PrpTaddressDto prpTaddressDto = new PrpTaddressDto();
        String strWhere=" select f from PrpTaddress f where  f.proposalNo=:proposalNo  ";
        Query entityManagerQuery=entityManager.createQuery(strWhere);
        entityManagerQuery.setParameter("proposalNo",proposalNo);
        List<PrpTaddress>  PrpTaddressDtoList=entityManagerQuery.getResultList();
        PrpTmainDto  prpTmainDto=convert(prpTmainDao.findOne(new PrpTmainKey(proposalNo)),PrpTmainDto.class);
        String conditions = "";
        String riskcode = "";
        PrpDriskConfigDto prpDriskConfigDto = new PrpDriskConfigDto();
        riskcode = prpTmainDto.getRiskCode();

        if (!exitemFlag) {
            conditions = " proposalNo='" + proposalNo + "'and kindcode not in(" + " select distinct(d.itemkind)" + "   from fhexitemkind d, fhtreaty y" + " where d.treatyno = y.treatyno" + "   and d.riskcode = '" + riskcode + "'" + "   and SINOSOFT_to_date('" + prpTmainDto.getStartDate() + "', 'yyyy-mm-dd') >= startdate" + "   and SINOSOFT_to_date('" + prpTmainDto.getStartDate() + "', 'yyyy-mm-dd') <= enddate)";
        }
        else
        {
            conditions = " proposalNo='" + proposalNo + "'and kindcode  in(" + " select distinct(d.itemkind)" + "   from fhexitemkind d, fhtreaty y" + " where d.treatyno = y.treatyno" + "   and d.riskcode = '" + riskcode + "'" + "   and SINOSOFT_to_date('" + prpTmainDto.getStartDate() + "', 'yyyy-mm-dd') >= startdate" + "   and SINOSOFT_to_date('" + prpTmainDto.getStartDate() + "', 'yyyy-mm-dd') <= enddate)";
        }

        if ((isThirdDuty) && ("08".equals(prpTmainDto.getClassCode())))
        {
            conditions = conditions + " and kindcode='002' and amount!=0";
        }
        else if ("08".equals(prpTmainDto.getClassCode()))
            conditions = conditions + " and (kindcode!='002' or (kindcode='002' and amount=0)) ";
        else if ((prpDriskConfigDto != null) && ("1".equals(prpDriskConfigDto.getConfigValue()))) {
            conditions = conditions + " and substr(kindcode,0,4)='" + riskcode + "'";
        }
        String strWhere1=" select * from PrpTitemKind where  "+conditions;
       Query query= entityManager.createNativeQuery(strWhere1,PrpTitemKind.class);
              List<PrpTitemKind> prpTitemKindList =query.getResultList();
              convertCollection(prpTitemKindList,prpTitemKindDtoList,PrpTitemKindDto.class);
        String postCode = "";
        String addressName = "";

        int i = 1;
        if (prpTitemKindDtoList != null)
        {
            Iterator itor = prpTitemKindDtoList.iterator();

            while (itor.hasNext())
            {
                prpTitemKindDto = (PrpTitemKindDto)itor.next();

                prpTdangerItemDto = new PrpTdangerItemDto();

                prpTdangerItemDto.setProposalNo(proposalNo);
                prpTdangerItemDto.setRiskCode(prpTitemKindDto.getRiskCode());
                prpTdangerItemDto.setDangerNo(dangerNo);

                prpTdangerItemDto.setSerialNo(Integer.parseInt(String.valueOf(prpTitemKindDto.getItemkindNo())));

                prpTdangerItemDto.setKindFlag("0");

                if ((prpDriskConfigDto != null) && ("1".equals(prpDriskConfigDto.getConfigValue())))
                    riskcode = dumRiskCode;
                else {
                    riskcode = prpTitemKindDto.getRiskCode();
                }

                if (("2714".equals(riskcode)) || ("3221".equals(riskcode)))
                {
                    prpTdangerItemDto.setItemCode(prpTitemKindDto.getRationType());
                }
                else {
                    prpTdangerItemDto.setItemCode(prpTitemKindDto.getItemCode());
                }
                prpTdangerItemDto.setItemdetailName(prpTitemKindDto.getItemdetailName());
                prpTdangerItemDto.setKindCode(prpTitemKindDto.getKindCode());
                prpTdangerItemDto.setKindName(prpTitemKindDto.getKindName());

                postCode = "";
                addressName = "";
                Iterator itoradd = PrpTaddressDtoList.iterator();

                while (itoradd.hasNext())
                {
                    prpTaddressDto = new PrpTaddressDto();
                    prpTaddressDto = (PrpTaddressDto)itoradd.next();

                    if (prpTitemKindDto.getAddressNo() == prpTaddressDto.getAddressNo())
                    {
                        postCode = prpTaddressDto.getAddressCode();
                        addressName = prpTaddressDto.getAddressName();
                    }

                }

                prpTdangerItemDto.setPostCode(postCode);
                prpTdangerItemDto.setAddressName(addressName);
                prpTdangerItemDto.setCurrency(prpTitemKindDto.getCurrency());
                prpTdangerItemDto.setAmount(prpTitemKindDto.getAmount());
                prpTdangerItemDto.setPremium(prpTitemKindDto.getPremium());
                prpTdangerItemDto.setCalculateFlag(prpTitemKindDto.getCalculateFlag());

                if (exitemFlag)
                {
                    prpTdangerItemDto.setFlag("1");
                }
                else {
                    prpTdangerItemDto.setFlag("0");
                }

                prpTdangerItemDto.setDangerKindShare(100.0D);

                PrpTdangerItemDtoList.add(prpTdangerItemDto);
                i++;
            }
        }

        return PrpTdangerItemDtoList;
    }

    *//**
     * @author
     * @desc 得到生成中间费用
     * @param iProposalNo
     * @throws Exception
     *//*
    public double getDisPremiumT(String iProposalNo) throws Exception
    {

        String strWhere = "";
        String strCurrency1 = "";
        double dblDisRate1 = 0;
        double dblDisFee1Left = 0;
        double dblSelfRate1 = 100;
        double dbDisPremium = 0;
        double dblPremium1Sum = 0;
        PrpTmainDto prpTmainDto=convert(prpTmainDao.findOne(new PrpTmainKey(iProposalNo)),PrpTmainDto.class);
        dblDisRate1 = Double.parseDouble(chgStrZero( String.valueOf(prpTmainDto.getDisrate1())));
        if(dblDisRate1 == 0) {
            return dbDisPremium;
        }
        return dbDisPremium;
    }

    public  String chgStrZero(String iValue)
    {
        String value = null;

        if (iValue == null)
            value = "0";
        else if (iValue.trim().length() == 0)
            value = "0";
        else {
            value = iValue;
        }
        return value.trim();
    }
    public  double round(double v, int scale)
    {
        BigDecimal b = new BigDecimal(Double.toString(v));

        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, 4).doubleValue();
    }
    *//**
     * 危险单位信息删除
     * @param proposalNo 投保单号
     * @param dangerNo   危险单位号
     * @return
     * @throws Exception
     *//*
    public void delete(String proposalNo, int dangerNo)throws Exception
    {
        String conditions = " ProposalNo = '" + proposalNo + "' And DangerNo = "+dangerNo;
        String strPrpTdangerRisk="DELETE FROM PrpTdangerRisk WHERE " +conditions;
        String strPrpTreinstrial="DELETE FROM PrpTreinstrial WHERE " +conditions;
        String strTreinsShare="DELETE FROM PrpTreinsShare WHERE " +conditions;
        String strPrpTdangerPlan="DELETE FROM PrpTdangerPlan WHERE " +conditions;
        String strPrpTdangerTot="DELETE FROM PrpTdangerTot WHERE " +conditions;
        String strPrpTdangerItem="DELETE FROM PrpTdangerItem WHERE " +conditions;
        String strPrpTdangerCoins="DELETE FROM PrpTdangerCoins WHERE " +conditions;
        String strPrpTdangerUnit="DELETE FROM PrpTdangerUnit WHERE " +conditions;
        entityManager.createNativeQuery(strPrpTdangerRisk);
        entityManager.createNativeQuery(strPrpTreinstrial);
        entityManager.createNativeQuery(strTreinsShare);
        entityManager.createNativeQuery(strPrpTdangerPlan);
        entityManager.createNativeQuery(strPrpTdangerTot);
        entityManager.createNativeQuery(strPrpTdangerItem);
        entityManager.createNativeQuery(strPrpTdangerCoins);
        entityManager.createNativeQuery(strPrpTdangerUnit);

    }

    *//**
     * 保存危险单位信息
     * @param tDangerDto 投保单危险单位信息
     * @return
     * @throws Exception
     *//*
    public void save(TDangerDto tDangerDto)
            throws Exception
    {
        if (tDangerDto.getPrpTdangerUnitDto() != null
                && tDangerDto.getPrpTdangerItemDtoList() != null
                && tDangerDto.getPrpTdangerItemDtoList().size() > 0)
        {
            PrpTdangerUnit prpTdangerUnit=convert(tDangerDto.getPrpTdangerUnitDto(),PrpTdangerUnit.class);
            prpTdangerUnitDao.save(prpTdangerUnit);
        }
        if (tDangerDto.getPrpTdangerItemDtoList() != null && tDangerDto.getPrpTdangerItemDtoList().size()>0)
        {
            for(Object obj : tDangerDto.getPrpTdangerItemDtoList()){
                PrpTdangerItemDto prpTdangerItemDto=(PrpTdangerItemDto)obj;
                PrpTdangerItem prpTdangerItem=convert(prpTdangerItemDto,PrpTdangerItem.class);
                prpTdangerItemDao.save(prpTdangerItem);

            }
        }
        if (tDangerDto.getPrpTdangerTotDtoList() != null && tDangerDto.getPrpTdangerTotDtoList().size()>0)
        {
            for(Object obj : tDangerDto.getPrpTdangerTotDtoList()){
                PrpTdangerTotDto prpTdangerTotDto=(PrpTdangerTotDto)obj;
                PrpTdangerTot prpTdangerTot=convert(prpTdangerTotDto,PrpTdangerTot.class);
                prpTdangerTotDao.save(prpTdangerTot);

            }
        }
        if (tDangerDto.getPrpTdangerPlanDtoList() != null && tDangerDto.getPrpTdangerPlanDtoList().size()>0)
        {
            for(Object obj : tDangerDto.getPrpTdangerPlanDtoList()){
                PrpTdangerPlanDto PrpTdangerPlanDto=(PrpTdangerPlanDto)obj;
                PrpTdangerPlan prpTdangerPlan=convert(PrpTdangerPlanDto,PrpTdangerPlan.class);
                prpTdangerPlanDao.save(prpTdangerPlan);

            }
        }
        if (tDangerDto.getPrpTdangerCoinsDtoList() != null && tDangerDto.getPrpTdangerCoinsDtoList().size()>0 )
        {
            for(Object obj : tDangerDto.getPrpTdangerCoinsDtoList()){
                PrpTdangerCoinsDto PrpTdangerCoinsDto=(PrpTdangerCoinsDto)obj;
                PrpTdangerCoins prpTdangerCoins=convert(PrpTdangerCoinsDto,PrpTdangerCoins.class);
                prpTdangerCoinsDao.save(prpTdangerCoins);

            }
        }
    }*/

}