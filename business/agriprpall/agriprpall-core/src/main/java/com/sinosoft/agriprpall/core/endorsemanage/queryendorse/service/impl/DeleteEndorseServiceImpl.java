package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.client.undwrtclient.AgriPrpallUndwrtDeleteEndorseService;
import com.sinosoft.agriprpall.api.endorsemanage.dto.DeleteEndorseRequestDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPdangerPlanDto;
import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPmainAgri;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPheadKey;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.DeleteEndorseService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCplanDao;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorHeadDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorHeadDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorHeadDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Transactional
@Service
public class DeleteEndorseServiceImpl extends BaseCustomServiceImpl implements DeleteEndorseService {

    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteEndorseServiceImpl.class);
    @Autowired
    private PrpCPrenewalDao prpCPrenewalDao;
    @Autowired
    private PrpCPinsuredDao prpCPinsuredDao;
    @Autowired
    private PrpCPinsuredNatureDao prpCPinsuredNatureDao;
    @Autowired
    private PrpCPinsuredArtifDao prpCPinsuredArtifDao;
    @Autowired
    private PrpCPaddressDao prpCPaddressDao;
    @Autowired
    private PrpCPsubsidyDao prpCPsubsidyDao;
    @Autowired
    private PrpCPfeildDao prpCPfeildDao;
    @Autowired
    private PrpCPitemKindDao prpCPitemKindDao;
    @Autowired
    private PrpCPplanDao prpCPplanDao;
    @Autowired
    private PrpCPplanCoinsDao prpCPplanCoinsDao;
    @Autowired
    private PrpCPcoinsDetailDao prpCPcoinsDetailDao;
    @Autowired
    private PrpCPcoinsDao prpCPcoinsDao;
    @Autowired
    private PrpCPfeeDao prpCPfeeDao;
    @Autowired
    private PrpCPengageDao prpCPengageDao;
    @Autowired
    private PrpCPexpenseDao prpCPexpenseDao;
    @Autowired
    private PrpCPmainLoanDao prpCPmainLoanDao;
    @Autowired
    private PrpCPmainDao prpCPmainDao;
    @Autowired
    private PrpCPmainAgriDao prpCPmainAgriDao;
    @Autowired
    private PrpPinsuredDao prpPinsuredDao;
    @Autowired
    private PrpPinsuredNatureDao prpPinsuredNatureDao;
    @Autowired
    private PrpPaddressDao prpPaddressDao;
    @Autowired
    private PrpPinsuredArtifDao prpPinsuredArtifDao;
    @Autowired
    private PrpPitemKindAgriDao prpPitemKindAgriDao;
    @Autowired
    private PrpPsubSidyDao prpPsubSidyDao;
    @Autowired
    private PrpPfeildDao prpPfeildDao;
    @Autowired
    private PrpPitemKindDao prpPitemKindDao;
    @Autowired
    private PrpPengageDao prpPengageDao;
    @Autowired
    private PrpPfeeDao prpPfeeDao;
    @Autowired
    private PrpPplanDao prpPplanDao;
    @Autowired
    private PrpPplanCoinsDao prpPplanCoinsDao;
    @Autowired
    private PrpPmainAgriDao prpPmainAgriDao;
    @Autowired
    private PrpPmainLoanDao prpPmainLoanDao;
    @Autowired
    private PrpPcoinsDetailDao prpPcoinsDetailDao;
    @Autowired
    private PrpPcoinsDao prpPcoinsDao;
    @Autowired
    private PrpPdangerItemDao prpPdangerItemDao;
    @Autowired
    private PrpPdangerTotDao prpPdangerTotDao;
    @Autowired
    private PrpPdangerPlanDao prpPdangerPlanDao;
    @Autowired
    private PrpPdangerUnitDao prpPdangerUnitDao;
    @Autowired
    private PrpPexpenseDao prpPexpenseDao;
    @Autowired
    private PrpCplanDao prpCplanDao;
    @Autowired
    private PrpPtextDao prpPtextDao;
    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpCPitemKindAgriDao prpCPitemKindAgriDao;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private UtiGroupApi utiGroupApi;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl3;
    @Autowired
    private EndorseListApi endorseListApi;
    @Autowired
    private HerdEndorHeadApi herdEndorHeadApi;
    @Autowired
    private NyxEndorHeadApi nyxEndorHeadApi;
    @Autowired
    private PlantingEndorHeadApi plantingEndorHeadApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private ProcessApi processApi;

    /**
     * 批单批量删除（先校验批单号，然后再删除相关的表的数据）
     * @author: 宋振振
     * @date: 2017/11/24 15:16
     * @param deleteEndorseRequestDto 批单批量删除请求
     * @return HashMap 返回删除成功或失败的信息
     * @throws Exception
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public HashMap deleteEndorse(DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception{
        if(deleteEndorseRequestDto.getEndorseNoList().size()==0){
            throw new DataVerifyException("没有接收到批单号！");
        }
        HashMap deleteEndorseInfo = new HashMap();
        //成功信息
        List<String> successMessageList = new ArrayList<>();
        //失败信息
        List<String> failMessageList = new ArrayList<>();
        List<String> endorList=new ArrayList<>();
        String plantingFarmerListFlag =utiPlatConfigRuleApi.getProperty("PLNATING_FARMER_LIST_FLAG");//种植险种清单
        String breedingFarmerListFlag =utiPlatConfigRuleApi.getProperty("BREEDING_FARMER_LIST_FLAG");//养殖险种清单
        String nyxSingleFarmerListFlag =utiPlatConfigRuleApi.getProperty("NYX_SINGLE_FARMER_LIST_FLAG");//农业险种个体清单
        String nyxMultipleFarmerListFlag =utiPlatConfigRuleApi.getProperty("NYX_MULTIPLE_FARMER_LIST_FLAG");//农业险种团体清单

        HashMap endorseNoMap = getEndorseNoMap(deleteEndorseRequestDto);//取得前端传来的批单集合
        for(String endorseNo : deleteEndorseRequestDto.getEndorseNoList()){
            if(StringUtils.isEmpty(endorseNo)){
                throw new DataVerifyException("批单号不能为空！");
            }
            if(endorseNoMap.containsKey(endorseNo)){
                try {
                    PrpPhead prpPhead = prpPheadDao.findOne(new PrpPheadKey(endorseNo));
                    String policyNo = prpPhead.getPolicyNo();
                    //endorseNoMap里面key是批单号，值是批单号对应的险种
                    String strRiskCode= (String) endorseNoMap.get(endorseNo);
                    endorList.add(endorseNo);
                    //调用删除方法，删除批单表，中间表，清单表数据
                    this.cancel(policyNo,endorseNo,strRiskCode,endorList,plantingFarmerListFlag,breedingFarmerListFlag,nyxSingleFarmerListFlag,nyxMultipleFarmerListFlag);

                    successMessageList.add(endorseNo + "删除成功！");

                    // 生成节点数据
                    this.generateNodeData(endorseNo);
                }catch (Exception e){

                    //产生异常,回写清单表数据
                    String strRiskCode= (String) endorseNoMap.get(endorseNo);
                    Map<String,String> map=new HashMap<>();
                    map.put("endorseNo",endorseNo);
                    if (null != breedingFarmerListFlag && null != strRiskCode && breedingFarmerListFlag.indexOf(strRiskCode) > -1) {
                        HerdEndorHeadDto herdEndorHeadDto=herdEndorHeadApi.queryByPK(endorseNo);
                        if(herdEndorHeadDto!=null){
                            map.put("listType","herd");
                        }
                    }
                    if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
                        PlantingEndorHeadDto plantingEndorHeadDto=plantingEndorHeadApi.queryByPK(endorseNo);
                        if(plantingEndorHeadDto!=null){
                            map.put("listType","planting");
                        }
                    }
                    if (null != nyxSingleFarmerListFlag && null != strRiskCode && nyxSingleFarmerListFlag.indexOf(strRiskCode) > -1) {
                        NyxEndorHeadDto nyxEndorHeadDto =nyxEndorHeadApi.queryByPK(endorseNo);
                        if(nyxEndorHeadDto!=null){
                            map.put("listType","nyx");
                        }
                    }
                    if (null != nyxMultipleFarmerListFlag && null != strRiskCode && nyxMultipleFarmerListFlag.indexOf(strRiskCode) > -1) {
                        NyxEndorHeadDto nyxEndorHeadDto =nyxEndorHeadApi.queryByPK(endorseNo);
                        if(nyxEndorHeadDto!=null){
                            map.put("listType","nyx");
                        }
                    }
                    try {
                        endorseListApi.unDeleteEndorseList(map);
                    }catch (Exception ex) {
                        LOGGER.error("批单批量删除的实现类DeleteEndorseServiceImpl运行时发生异常!批单号是" + endorseNo + "!当前时间:" + System.currentTimeMillis());
                        LOGGER.error(ex.getMessage()+ex.toString());
                    }
                    failMessageList.add("此批单号"+endorseNo+"删除时产生异常！");
                    continue;
                }finally {
                    endorList.clear();
                }
            }else{
                failMessageList.add("此批单号"+endorseNo+"不能被删除！");
            }
        }

        if(endorseNoMap.size()==0){
            for(String endorseNo:deleteEndorseRequestDto.getEndorseNoList()){
            failMessageList.add("此批单号"+endorseNo+"不能被删除！");
            }
        }

        deleteEndorseInfo.put("successMessageList",successMessageList);
        deleteEndorseInfo.put("failMessageList",failMessageList);
        return deleteEndorseInfo;
    }

    /**
     * 删除方法，主要为了控制事务方便
     * @author: 宋振振
     * @date: 2017/12/4 18:00
     * @param policyNo 保单号
     * @param endorseNo 批单号
     * @param strRiskCode 险种
     * @param endorList 批单号集合
     * @throws Exception
     */
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor = Exception.class)
    public void cancel(String policyNo,String endorseNo,String strRiskCode,List endorList,String plantingFarmerListFlag,String breedingFarmerListFlag,String nyxSingleFarmerListFlag,String nyxMultipleFarmerListFlag) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空！");
        }
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号不能为空！");
        }

        //删除中间表数据
        cancelCPolicy(policyNo, "Y");
        //删除批单相关表数据
        cancelEndorse(endorseNo);
        //删除清单相关表的数据,调清单系统
        cancelList(endorseNo,strRiskCode,plantingFarmerListFlag,breedingFarmerListFlag,nyxSingleFarmerListFlag,nyxMultipleFarmerListFlag);

        // 调双核系统，进行工作流删除操作 这里传endorList进行批量删除
        PacketDto packetDto = new PacketDto();
        XmlUtil xmlUtil = new XmlUtil();
        packetDto.setBody(endorList);
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallUndwrtDeleteEndorseService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallUndwrtDeleteEndorseService?wsdl".trim());
        AgriPrpallUndwrtDeleteEndorseService reinsService = (AgriPrpallUndwrtDeleteEndorseService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.deleteEndorse(requsetXml);
        PacketDto<String> responsePacketDto = xmlUtil.xmlToPacketDto_bodyDto(responseXml,String.class);
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
         //校验statusCode
        if("9999".equals(statusCode)){
           //throw new Exception("调用双核系统删除工作流的操作失败！");
        }
    }
    /**
     * 根据传来的参数删除清单表的相关数据
     * @author: 宋振振
     * @date: 2017/12/4 9:11
     * @param endorseNo 批单号
     * @param strRiskCode 险种
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelList(String endorseNo,String strRiskCode,String plantingFarmerListFlag,String breedingFarmerListFlag,String nyxSingleFarmerListFlag,String nyxMultipleFarmerListFlag)throws Exception{

        Map<String,String> map=new HashMap<>();
        map.put("endorseNo",endorseNo);

        if (null != breedingFarmerListFlag && null != strRiskCode && breedingFarmerListFlag.indexOf(strRiskCode) > -1) {
            HerdEndorHeadDto herdEndorHeadDto=herdEndorHeadApi.queryByPK(endorseNo);
            if(herdEndorHeadDto!=null){
                 map.put("listType","herd");
                endorseListApi.deleteEndorseList(map);
             }
        }
        if (null != plantingFarmerListFlag && null != strRiskCode && plantingFarmerListFlag.indexOf(strRiskCode) > -1) {
            PlantingEndorHeadDto plantingEndorHeadDto=plantingEndorHeadApi.queryByPK(endorseNo);
            if(plantingEndorHeadDto!=null){
                 map.put("listType","planting");
                endorseListApi.deleteEndorseList(map);
            }
        }
        if (null != nyxSingleFarmerListFlag && null != strRiskCode && nyxSingleFarmerListFlag.indexOf(strRiskCode) > -1) {
            NyxEndorHeadDto nyxEndorHeadDto =nyxEndorHeadApi.queryByPK(endorseNo);
            if(nyxEndorHeadDto!=null){
                  map.put("listType","nyx");
                 endorseListApi.deleteEndorseList(map);
             }
        }
        if (null != nyxMultipleFarmerListFlag && null != strRiskCode && nyxMultipleFarmerListFlag.indexOf(strRiskCode) > -1) {
            NyxEndorHeadDto nyxEndorHeadDto =nyxEndorHeadApi.queryByPK(endorseNo);
            if(nyxEndorHeadDto!=null){
                 map.put("listType","nyx");
                endorseListApi.deleteEndorseList(map);
            }
        }
    }

    /**
     * 根据保单号删除相关表的数据
     * @author: 宋振振
     * @date: 2017/11/24 15:27
     * @param policyNo 保单号
     * @param strOption 用于判断：Y表示删除PrpCPmain信息
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelCPolicy(String policyNo,String strOption)throws Exception{
        //先删子表,后删主表
        prpCPrenewalDao.cancelPrpCPrenewal(policyNo);
        prpCPinsuredDao.cancelPrpCPinsured(policyNo);
        prpCPinsuredNatureDao.cancelPrpCPinsuredNature(policyNo);
        prpCPinsuredArtifDao.deletePrpCPinsuredArtif(policyNo);
        prpCPaddressDao.deleteAllByCondition(policyNo);
        prpCPsubsidyDao.deleteAllByCondition(policyNo);
        prpCPfeildDao.cancelPrpCPfeild(policyNo);
        prpCPitemKindAgriDao.deleteAllByCondition(policyNo);
        prpCPitemKindDao.deleteAllByCondition(policyNo);
        prpCPplanDao.deleteAllByCondition(policyNo);
        prpCPplanCoinsDao.cancelPrpCPplanCoins(policyNo);
        prpCPcoinsDetailDao.deleteAllByCondition(policyNo);
        prpCPcoinsDao.deleteAllByCondition(policyNo);
        prpCPfeeDao.deleteAllByCondition(policyNo);
        prpCPengageDao.deleteAllByCondition(policyNo);
        prpCPexpenseDao.deleteAllByCondition(policyNo);
        prpCPmainLoanDao.deletePrpCPmainLoan(policyNo);
        prpCPmainAgriDao.deleteAllByCondition(policyNo);
        if(strOption.equals("Y"))//Y:删除PrpCPmain信息 N:不删除PrpCPmain信息
        {
            prpCPmainDao.deleteAllByCondition(policyNo);
        }
    }

    /**
     * 根据批单号删除相关表的数据
     * @author: 宋振振
     * @date: 2017/11/24 15:25
     * @param endorseNo 批单号
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void cancelEndorse(String endorseNo)throws Exception{
        prpPinsuredDao.deleteByEndorseNo(endorseNo);
        prpPinsuredNatureDao.cancelPrpPinsuredNature(endorseNo);
        prpPinsuredArtifDao.cancelPrpPinsuredArtif(endorseNo);
        prpPaddressDao.deleteByEndorseNo(endorseNo);
        prpPitemKindAgriDao.deleteByEndorseNo(endorseNo);
        prpPsubSidyDao.deleteByEndorseNo(endorseNo);
        prpPfeildDao.cancelPrpPfeild(endorseNo);
        prpPitemKindDao.deleteByEndorseNo(endorseNo);
        prpPengageDao.deleteByEndorseNo(endorseNo);
        prpPfeeDao.deleteByEndorseNo(endorseNo);
        prpPplanDao.deleteByEndorseNo(endorseNo);
        prpPplanCoinsDao.cancelPrpPplanCoins(endorseNo);
        prpPmainAgriDao.deleteByEndorseNo(endorseNo);
        prpPmainLoanDao.cancelPrpPmainLoan(endorseNo);
        prpPcoinsDetailDao.deleteByEndorseNo(endorseNo);
        prpPcoinsDao.deleteByEndorseNo(endorseNo);
        prpPdangerItemDao.cancelPrpPdangerItem(endorseNo);
        prpPdangerTotDao.cancelPrpPdangerTot(endorseNo);
        prpPdangerPlanDao.cancelPrpPdangerPlan(endorseNo);
        prpPdangerUnitDao.cancelPrpPdangerUnit(endorseNo);
        prpPexpenseDao.deleteByEndorseNo(endorseNo);
        prpCplanDao.deleteByPolicyNo(endorseNo);
        prpPtextDao.cancelPrpPtext(endorseNo);
        prpPmainDao.deleteByEndorseNo(endorseNo);
        prpPheadDao.deleteByEndorseNo(endorseNo);
    }

    /**
     * 批单批量删除校验
     * @author: 宋振振
     * @date: 2017/11/24 15:19
     * @param deleteEndorseRequestDto 批单批量删除请求的Dto
     * @return HashMap 批单号集合
     * @throws Exception
     */
    public HashMap getEndorseNoMap(DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception{
        if(deleteEndorseRequestDto.getEndorseNoList().size()==0){
            throw new DataVerifyException("没有接收到批单号！");
        }
        // commonship/pg/UIEndorseDeleteQueryList.jsp 101-168行 将endorseNoList拼入sql语句，查出可以被删除的批单号塞入map中
        HashMap endorseNoMap = new HashMap();
        Map<String,Object> paraMap=new HashMap<String,Object>();
        StringBuilder sql=new StringBuilder("SELECT p FROM PrpPhead p WHERE ");
        sql.append(" (p.underwriteFlag in('0','2') or p.underwriteFlag is null) ");//批单删除只能删除未复核的批单或核批不通过的批单
        sql.append(" AND p.endorType NOT IN('DW1','DW2') ");//过滤掉低无赔款的批单
        //批单集合
        if(deleteEndorseRequestDto.getEndorseNoList().size()>0){
            sql.append(" and p.endorseNo in(:endorseNo)");
            paraMap.put("endorseNo",deleteEndorseRequestDto.getEndorseNoList());
        }
        sql.append(" AND p.comCode Not like '%YL%'");
        sql.append(" ORDER BY p.endorseNo DESC ");

        Query dataQuery=entityManager.createQuery(sql.toString());
        this.setQueryParam(dataQuery,paraMap);
        List<PrpPhead> prpPheadList=dataQuery.getResultList();

        for(PrpPhead prpPhead:prpPheadList){
            endorseNoMap.put(prpPhead.getEndorseNo(),prpPhead.getRiskCode());
        }

        return endorseNoMap;
    }

    /**
     * 生成节点数据
     *
     * @param endorseNo 批单号码
     * @return
     * @date: 2018/4/9 11:10
     * @author: 何伟东
     */
    private void generateNodeData(String endorseNo) throws Exception {
        String operatorCode = SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(operatorCode);
        Date nowDate = new Date();
        ProcessDto processDto = new ProcessDto.Builder()
                .stepCode(NodeType.DELETE_ENDORSE_NODE)
                .stateCode(NodeState.PROCESSED)
                .bizCode(endorseNo)
                .inflowTime(nowDate)
                .outflowTime(nowDate)
                .opCode(operatorCode)
                .opName(prpDuserDto.getUserName())
                .opTime(nowDate)
                .resultCode(NodeResultCode.ENDORSE_DELETE)
                .build();
        processApi.generateNodeData(processDto);
    }
}
