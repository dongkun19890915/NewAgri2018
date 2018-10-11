package com.sinosoft.agriprpall.core.proposalmanage.service.impl;


import com.sinosoft.agriprpall.api.process.ProcessApi;
import com.sinosoft.agriprpall.api.process.dto.ProcessDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.process.constant.NodeResultCode;
import com.sinosoft.agriprpall.core.process.constant.NodeState;
import com.sinosoft.agriprpall.core.process.constant.NodeType;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTrenewalDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainKey;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewal;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewalKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.WithdrawSubmitService;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time 2017-10-22 07:33:55.391
 * @description PrpTrenewalCore接口实现
 */
@Service
public class WithdrawSubmitServiceImpl extends BaseServiceImpl implements WithdrawSubmitService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WithdrawSubmitServiceImpl.class);

    @Autowired
    private PrpTrenewalDao prpTrenewalDao;
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private ProcessApi processApi;

    /**
     * @param
     * @description 新增
     */
    public void save(PrpTrenewalDto prpTrenewalDto) {
        PrpTrenewal prpTrenewal = this.convert(prpTrenewalDto, PrpTrenewal.class);
        prpTrenewalDao.save(prpTrenewal);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String proposalNo) {
        PrpTrenewalKey prpTrenewalKey = new PrpTrenewalKey(proposalNo);
        prpTrenewalDao.delete(prpTrenewalKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(PrpTrenewalDto prpTrenewalDto) {
        PrpTrenewal prpTrenewal = this.convert(prpTrenewalDto, PrpTrenewal.class);
        prpTrenewalDao.save(prpTrenewal);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public PrpTrenewalDto queryByPK(String proposalNo) {
        PrpTrenewalKey prpTrenewalKey = new PrpTrenewalKey(proposalNo);
        PrpTrenewal prpTrenewal = prpTrenewalDao.findOne(prpTrenewalKey);
        return this.convert(prpTrenewal, PrpTrenewalDto.class);
    }

    /**
     * 撤单
     * @author: 钱浩
     * @date: 2017/10/22 16:30
     * @param proposalNo 投保单号
     * @return ResponseDto： 撤单状态：成功或失败
     * @throws Exception
     */
    public Map<String,String> withdrawProposal(String proposalNo) throws Exception {
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        //1.t表修改OthFlag 成撤单标志
        PrpTmain prpTmain = prpTmainDao.findOne(new PrpTmainKey(proposalNo));
        String strOthFlag = prpTmain.getOthFlag();
        int intLength = strOthFlag.length();
        if (intLength < 4) {
            for (int i = 0; i < 4 - intLength; i++) {
                strOthFlag = strOthFlag + "0";
            }
        }
        if (strOthFlag.length() > 4) {
            strOthFlag = strOthFlag.substring(0, 3) + "2" + strOthFlag.substring(4);
        } else if (strOthFlag.length() == 4) {
            strOthFlag = strOthFlag.substring(0, 3) + "2";
        }
        prpTmain.setOthFlag(strOthFlag);
        prpTmainDao.save(prpTmain);
        //再保接口调用
//        RequestUpdateEnquiryFlagDto requestUpdateEnquiryFlagDto = new RequestUpdateEnquiryFlagDto();
//        requestUpdateEnquiryFlagDto.setType("T");
//        requestUpdateEnquiryFlagDto.setCertifyNo(proposalNo);
//        requestUpdateEnquiryFlagDto.setVerifyFlag("5");
//        PacketDto packetDto = new PacketDto();
//        packetDto.setBody(requestUpdateEnquiryFlagDto);
//        XmlUtil xmlUtil = new XmlUtil();
//        String requsetXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallReinsService.class);
//        jaxWsProxyFactoryBean.setAddress(webserviceUrl3);
//        NewAgriPrpallReinsService newAgriPrpallReinsService = (NewAgriPrpallReinsService) jaxWsProxyFactoryBean.create();
//        String rsponseXml = newAgriPrpallReinsService.updateEnquiryFlag(requsetXml);
//        PacketDto<String> responseDto = xmlUtil.xmlToPacketDto_bodyDto(rsponseXml, String.class);
//        String statusCode = responseDto.getHead().getReturnStatusCode();
//        //2.判断连接返回
//        if ("9999".equals(statusCode)) {
//            throw new DataVerifyException(responseDto.getHead().getReturnMessage());
//        }
        //2.投保单撤单 保单othflag标志回写，prptrenewal记录删除  start
        PrpTrenewal prpTrenewal = prpTrenewalDao.findOne(new PrpTrenewalKey(proposalNo));
        if (prpTrenewal != null) {
            PrpCmain prpCMain = prpCmainDao.findOne(new PrpCmainKey(prpTrenewal.getOldPolicyNo()));
            strOthFlag = prpCMain.getOthFlag();
            intLength = strOthFlag.length();
            if (intLength < 2) {
                for (int i = 0; i < 2 - intLength; i++) {
                    strOthFlag = strOthFlag + "0";
                }
            }
            if (strOthFlag.length() > 2) {
                strOthFlag = strOthFlag.substring(0, 1) + "0" + strOthFlag.substring(2);
            } else if (strOthFlag.length() == 2) {
                strOthFlag = strOthFlag.substring(0, 1) + "0";
            }
            prpCMain.setOthFlag(strOthFlag);
            prpCmainDao.save(prpCMain);
            prpTrenewalDao.delete(new PrpTrenewalKey(proposalNo));
        }
        Map<String,String> map=new HashMap<String,String>();
        map.put("message", "撤单成功!");
        // 生成节点数据
        this.generateNodeData(prpTmain);
        return map;
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
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(userCode);
        ProcessDto processDto = new ProcessDto.Builder()
                .stepCode(NodeType.DELETE_PROPOSAL_NODE)
                .stateCode(NodeState.PROCESSED)
                .bizCode(prpTmain.getProposalNo())
                .inflowTime(new Date())
                .outflowTime(new Date())
                .opCode(userCode)
                .opName(prpDuserDto.getUserName())
                .opTime(new Date())
                .resultCode(NodeResultCode.PROPOSAL_DELETE)
                .build();
        processApi.generateNodeData(processDto);
    }
}