package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.ClaimApi;
import com.sinosoft.agriclaim.api.compensatemanage.CompensateApi;
import com.sinosoft.agriclaim.api.prepaymanage.PrepayApi;
import com.sinosoft.agriclaim.api.registmanage.RegistApi;
import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryRepolicynoDto;
import com.sinosoft.agriprpall.api.client.rinsclient.AgriPrpallRelateRepolicynoService;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCrenewalDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCrenewal;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTrenewalDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewal;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewalKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryRelationService;
import com.sinosoft.dms.api.dict.PrpDprovinceConfigApi;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QueryRelationImpl extends BaseServiceImpl implements QueryRelationService {

    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpTrenewalDao prpTrenewalDao;
    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    private PrpCrenewalDao prpCrenewalDao;
    @Autowired
    private ClaimApi claimApi;
    @Autowired
    private RegistApi registApi;
    @Autowired
    private PrepayApi prepayApi;
    @Autowired
    private CompensateApi compensateApi;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webserviceUrl3;
    /**
     * 投保单关联查询(根据投保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/5 17:30
     * @param proposalNo 投保单号
     * @return QueryRelationResponseDto 返回与投保单号相关联的单号的Dto
     * @throws Exception
     */
    @Override
    public QueryRelationResponseDto queryRelateByProposalNo(String proposalNo) throws Exception {
        //校验入参
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号proposalNo入参不能为空！");
        }

        String policyNo = "";
        String strRiskCode = "";
        String strClassCode = "";
        String strComCode = "";
        String strVersionNo="";
        String strVersionType="";
        QueryRelationResponseDto queryRelationResponseDto=new QueryRelationResponseDto();
        queryRelationResponseDto.setProposalNo(proposalNo);
        PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
        if(prpTmain==null){
            throw new DataVerifyException("没有查询到PrpTmain表的数据！");
        }
        strRiskCode = prpTmain.getRiskCode();
        queryRelationResponseDto.setRiskCode(strRiskCode);
        strClassCode = prpTmain.getClassCode();
        queryRelationResponseDto.setClassCode(strClassCode);
        strComCode = prpTmain.getComCode();

        List<PrpCmain> prpCmainList = prpCmainDao.findPrpCmainByProposalNo(proposalNo);
        PrpTrenewal prpTrenewal = prpTrenewalDao.findOne(new PrpTrenewalKey(proposalNo));
//        if(prpTrenewal==null){
//            throw new DataVerifyException("没有查询到PrpTrenewal表的数据！");
//        }
        if (prpCmainList.size()>0) {
            policyNo = prpCmainList.get(0).getPolicyNo();
            queryRelationResponseDto.setPolicyNo(policyNo);
            List<PrpPhead> prpPheadList = prpPheadDao.findPrpPheadByPolicyNo(policyNo);
            List<PrpPheadDto> prpPheadDtoList=new ArrayList<>();
            convertCollection(prpPheadList,prpPheadDtoList,PrpPheadDto.class);
            queryRelationResponseDto.setPrpPheadDtoList(prpPheadDtoList);

            //调用理赔系统
            //立案  传policyNo查询PrpLclaim
            PrpLClaimDto prpLClaimDto=new PrpLClaimDto();
            prpLClaimDto.setPolicyNo(policyNo);
            //转换为理赔的dto，然后再把返回的理赔系统的list转换为承保系统的list
            com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto prpLClaimDto1=null;
            prpLClaimDto1=convert(prpLClaimDto,com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto.class);
            List<com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto> prpLclaimDtoList1=claimApi.queryPrpLClaimByCondition(prpLClaimDto1);
            List<PrpLClaimDto> prpLclaimDtoList=new ArrayList<>();
            convertCollection(prpLclaimDtoList1,prpLclaimDtoList,PrpLClaimDto.class);
            queryRelationResponseDto.setPrpLclaimDtoList(prpLclaimDtoList);
            //报案  传policyNo查询PrpLregist
            PrpLRegistDto prpLRegistDto=new PrpLRegistDto();
            prpLRegistDto.setPolicyNo(policyNo);
            com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto prpLRegistDto1=null;
            prpLRegistDto1=convert(prpLRegistDto,com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto.class);
            List<com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto> prpLRegistDtoList1=registApi.queryPrpLRegistByCondition(prpLRegistDto1);
            List<PrpLRegistDto> prpLRegistDtoList=new ArrayList<>();
            convertCollection(prpLRegistDtoList1,prpLRegistDtoList,PrpLRegistDto.class);
            queryRelationResponseDto.setPrpLRegistDtoList(prpLRegistDtoList);
            //预赔  传policyNo查询PrpLprepay
            PrpLPrepayDto prpLPrepayDto=new PrpLPrepayDto();
            prpLPrepayDto.setPolicyNo(policyNo);
            com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto prpLPrepayDto1=null;
            prpLPrepayDto1=convert(prpLPrepayDto,com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto.class);
            List<com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto> prpLPrepayDtoList1=prepayApi.queryPrpLPrepayByCondition(prpLPrepayDto1);
            List<PrpLPrepayDto> prpLPrepayDtoList=new ArrayList<>();
            convertCollection(prpLPrepayDtoList1,prpLPrepayDtoList,PrpLPrepayDto.class);
            queryRelationResponseDto.setPrpLPrepayDtoList(prpLPrepayDtoList);
            //实赔  传policyNo查询PPrpLcompensate
            PrpLCompensateDto prpLCompensateDto=new PrpLCompensateDto();
            prpLCompensateDto.setPolicyNo(policyNo);
            com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto prpLCompensateDto1=null;
            prpLCompensateDto1=convert(prpLCompensateDto,com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto.class);
            List<com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto> prpLCompensateDtoList1=compensateApi.queryPrpLCompensateByCondition(prpLCompensateDto1);
            List<PrpLCompensateDto> prpLCompensateDtoList=new ArrayList<>();
            convertCollection(prpLCompensateDtoList1,prpLCompensateDtoList,PrpLCompensateDto.class);
            queryRelationResponseDto.setPrpLCompensateDtoList(prpLCompensateDtoList);
            // 调用再保系统 传PolicyNo查FcoRepolicy的repolicyno
            PacketDto packetDto = new PacketDto();
            packetDto.setBody(policyNo);
            XmlUtil xmlUtil = new XmlUtil();
            String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.setServiceClass(AgriPrpallRelateRepolicynoService.class);
            jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallRelateRepolicynoService?wsdl".trim());
            AgriPrpallRelateRepolicynoService reinsService = (AgriPrpallRelateRepolicynoService) jaxWsProxyFactoryBean.create();
            String responseXml = reinsService.queryRelateRepolicyno(requsetXml);
            PacketDto<List<ResponseQueryRepolicynoDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml,ResponseQueryRepolicynoDto.class, "responseQueryRepolicynoDto");
            String statusCode = responsePacketDto.getHead().getReturnStatusCode();
            // 校验statusCode
            if("9999".equals(statusCode)){
                throw new Exception("调用再保系统获取分保保单号的操作失败！");
            }
            String repolicyno="";
            if(responsePacketDto.getBody().size()!=0){
                repolicyno=responsePacketDto.getBody().get(0).getRepolicyno();
            }
            queryRelationResponseDto.setRepolicyNo(repolicyno);
        }

        return queryRelationResponseDto;
    }
    /**
     * 保单/批单关联查询(根据保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/10 9:55
     * @param bizNo 业务号即保单号
     * @return 返回与保单号相关联的单号的Dto
     * @throws Exception
     */
    @Override
    public QueryRelationResponseDto queryRelateByBizNo(String bizNo)throws Exception{
        //校验入参
        if (StringUtils.isEmpty(bizNo)) {
            throw new DataVerifyException("保单号入参不能为空！");
        }

        String riskCode="";
        String strVersionNo="";
        String strVersionType="";
        String riskClass="";//险类,险种的第一个字母
        String strComCode="";
        QueryRelationResponseDto queryRelationResponseDto=new QueryRelationResponseDto();

        PrpCmain prpCmain=prpCmainDao.findOne(new PrpCmainKey(bizNo));
        if(prpCmain==null){
            throw new DataVerifyException("没有查询到PrpCmain表的数据！");
        }
        riskCode=prpCmain.getRiskCode();
        riskClass = riskCode.substring(0,1);
        queryRelationResponseDto.setRiskCode(riskCode);
        queryRelationResponseDto.setRiskClass(riskClass);
        strComCode=prpCmain.getComCode();
        List<PrpPhead> prpPheadList=prpPheadDao.findPrpPheadByPolicyNo(bizNo);
        for(PrpPhead prpPhead:prpPheadList){
            queryRelationResponseDto.setEndorseNo(prpPhead.getEndorseNo());
            queryRelationResponseDto.setEndorType(prpPhead.getEndorType());
        }

        List<PrpCrenewal> prpCrenewalList=prpCrenewalDao.findPrpCrenewalByPolicyNo(bizNo);
        for(PrpCrenewal prpCrenewal:prpCrenewalList){
            queryRelationResponseDto.setOldPolicyNo(prpCrenewal.getOldPolicyNo());
        }

        //调用理赔系统
        //立案  传policyNo查询PrpLclaim
        PrpLClaimDto prpLClaimDto=new PrpLClaimDto();
        prpLClaimDto.setPolicyNo(bizNo);
        //转换为理赔的dto，然后再把返回的理赔系统的list转换为承保系统的list
        com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto prpLClaimDto1=null;
        prpLClaimDto1=convert(prpLClaimDto,com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto.class);
        List<com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto> prpLclaimDtoList1=claimApi.queryPrpLClaimByCondition(prpLClaimDto1);
        List<PrpLClaimDto> prpLclaimDtoList=new ArrayList<>();
        convertCollection(prpLclaimDtoList1,prpLclaimDtoList,PrpLClaimDto.class);
        queryRelationResponseDto.setPrpLclaimDtoList(prpLclaimDtoList);
        //报案  传policyNo查询PrpLregist
        PrpLRegistDto prpLRegistDto=new PrpLRegistDto();
        prpLRegistDto.setPolicyNo(bizNo);
        com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto prpLRegistDto1=null;
        prpLRegistDto1=convert(prpLRegistDto,com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto.class);
        List<com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto> prpLRegistDtoList1=registApi.queryPrpLRegistByCondition(prpLRegistDto1);
        List<PrpLRegistDto> prpLRegistDtoList=new ArrayList<>();
        convertCollection(prpLRegistDtoList1,prpLRegistDtoList,PrpLRegistDto.class);
        queryRelationResponseDto.setPrpLRegistDtoList(prpLRegistDtoList);
        //预赔  传policyNo查询PrpLprepay
        PrpLPrepayDto prpLPrepayDto=new PrpLPrepayDto();
        prpLPrepayDto.setPolicyNo(bizNo);
        com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto prpLPrepayDto1=null;
        prpLPrepayDto1=convert(prpLPrepayDto,com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto.class);
        List<com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPrepayDto> prpLPrepayDtoList1=prepayApi.queryPrpLPrepayByCondition(prpLPrepayDto1);
        List<PrpLPrepayDto> prpLPrepayDtoList=new ArrayList<>();
        convertCollection(prpLPrepayDtoList1,prpLPrepayDtoList,PrpLPrepayDto.class);
        queryRelationResponseDto.setPrpLPrepayDtoList(prpLPrepayDtoList);
        //实赔  传policyNo查询PPrpLcompensate
        PrpLCompensateDto prpLCompensateDto=new PrpLCompensateDto();
        prpLCompensateDto.setPolicyNo(bizNo);
        com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto prpLCompensateDto1=null;
        prpLCompensateDto1=convert(prpLCompensateDto,com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto.class);
        List<com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto> prpLCompensateDtoList1=compensateApi.queryPrpLCompensateByCondition(prpLCompensateDto1);
        List<PrpLCompensateDto> prpLCompensateDtoList=new ArrayList<>();
        convertCollection(prpLCompensateDtoList1,prpLCompensateDtoList,PrpLCompensateDto.class);
        queryRelationResponseDto.setPrpLCompensateDtoList(prpLCompensateDtoList);
        // 调用再保系统 传PolicyNo查FcoRepolicy集合
        PacketDto packetDto = new PacketDto();
        packetDto.setBody(bizNo);
        XmlUtil xmlUtil = new XmlUtil();
        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AgriPrpallRelateRepolicynoService.class);
        jaxWsProxyFactoryBean.setAddress(webserviceUrl3+"/webAgriPrpallService/services/AgriPrpallRelateRepolicynoService?wsdl".trim());
        AgriPrpallRelateRepolicynoService reinsService = (AgriPrpallRelateRepolicynoService) jaxWsProxyFactoryBean.create();
        String responseXml = reinsService.queryRelateRepolicyno(requsetXml);
        PacketDto<List<ResponseQueryRepolicynoDto>> responsePacketDto = xmlUtil.xmlToPacketDto_bodyList(responseXml,ResponseQueryRepolicynoDto.class, "responseQueryRepolicynoDto");
        String statusCode = responsePacketDto.getHead().getReturnStatusCode();
        // 校验statusCode
        if("9999".equals(statusCode)){
            throw new Exception("调用再保系统获取分保保单号的操作失败！");
        }
        String repolicyno=responsePacketDto.getBody().get(0).getRepolicyno();
        queryRelationResponseDto.setRepolicyNo(repolicyno);

        return queryRelationResponseDto;
    }
}
