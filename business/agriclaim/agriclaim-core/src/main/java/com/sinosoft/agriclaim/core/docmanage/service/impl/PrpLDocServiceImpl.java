package com.sinosoft.agriclaim.core.docmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDtoExt;
import com.sinosoft.agriclaim.api.docmanage.dto.*;
import com.sinosoft.agriclaim.api.registmanage.dto.RegistDto;
import com.sinosoft.agriclaim.core.businessutilmanage.dao.PrpLclaimStatusDao;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLclaimStatus;
import com.sinosoft.agriclaim.core.checkmanage.dao.PrplQualityCheckDao;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrplQualityCheck;
import com.sinosoft.agriclaim.core.checkmanage.service.CheckDataService;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLCertifyCollectDao;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLCertifyImgDao;
import com.sinosoft.agriclaim.core.docmanage.dao.PrpLDocDao;
import com.sinosoft.agriclaim.core.docmanage.dao.PrplCertifyDirectDao;
import com.sinosoft.agriclaim.core.docmanage.entity.*;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLDocService;
import com.sinosoft.agriclaim.core.docmanage.service.PrplCertifyDirectService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistExtDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriclaim.core.registmanage.service.RegistDataService;
import com.sinosoft.agriclaim.core.workflowmanage.dao.PrplReturnVisitSwflogDao;
import com.sinosoft.agriclaim.core.workflowmanage.dao.SwfLogDao;
import com.sinosoft.agriclaim.core.workflowmanage.entity.PrplReturnVisitSwflog;
import com.sinosoft.agriclaim.core.workflowmanage.entity.SwfLog;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 索赔单证信息表Core接口实现
 */
@Service
public class PrpLDocServiceImpl extends BaseServiceImpl implements PrpLDocService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLDocServiceImpl.class);
    
    @Autowired
    private PrpLDocDao prpLDocDao;
    @Autowired
    private CheckDataService checkDataService;
    @Autowired
    private PrpLRegistDao prplRegistDao;
    @Autowired
    private RegistDataService registDataService;
    @Autowired
    private PrpDuserApi userApi;
    @Autowired
    private PrpLClaimDao prplClaimDao;
    @Autowired
    private PrplCertifyDirectService prplCertifyDirectService;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
//    @PersistenceContext
    @Autowired
    private SwfLogDao swfLogDao;
    @Autowired
    private PrplCertifyDirectDao prplCertifyDirectDao;
    @Autowired
    private PrpLCertifyCollectDao prpLCertifyCollectDao;
    @Autowired
    private PrpLCertifyImgDao prpLCertifyImgDao;
    @Autowired
    private PrplQualityCheckDao prplQualityCheckDao;
    @Autowired
    private PrpLRegistExtDao prpLRegistExtDao;
    @Autowired
    private PrplReturnVisitSwflogDao prplReturnVisitSwflogDao;
    @Autowired
    private PrpLclaimStatusDao prpLclaimStatusDao;


    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpLDocDto prpLDocDto) {
        PrpLDoc prpLDoc = this.convert(prpLDocDto, PrpLDoc.class);
        prpLDocDao.save(prpLDoc);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String claimNo,String docCode) {
        PrpLDocKey prpLDocKey = new PrpLDocKey(claimNo,docCode);
        prpLDocDao.delete(prpLDocKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLDocDto prpLDocDto) {
        PrpLDoc prpLDoc = this.convert(prpLDocDto, PrpLDoc.class);
        prpLDocDao.save(prpLDoc);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLDocDto queryByPK(String claimNo,String docCode) {
        PrpLDocKey prpLDocKey = new PrpLDocKey(claimNo,docCode);
        PrpLDoc prpLDoc = prpLDocDao.findOne(prpLDocKey);
        return this.convert(prpLDoc,PrpLDocDto.class);
    }
    @Override
    public ClaimListDto findClaimList(ClaimListRequestDto requestDto) throws Exception {
        LOGGER.error("into  ClaimListServiceImpl.findClaimList：索赔清单查询");
        String registNo = requestDto.getRegistNo();
        PrpLRegist prplregist = prplRegistDao.findOne(new PrpLRegistKey(registNo));
        String riskCode = prplregist == null ? "" : prplregist.getRiskCode();
        ClaimListDto responseDto = new ClaimListDto();
        responseDto.setRiskCode(riskCode);
        responseDto.setRegistNo(registNo);
        responseDto.setFlowId(requestDto.getFlowId());
        responseDto.setPolicyNo(prplregist == null ? "" : prplregist.getPolicyNo());
        this.certifyDtoToView(responseDto, requestDto);
        return responseDto;
    }
    public void certifyDtoToView(ClaimListDto responseDto, ClaimListRequestDto requestDto) throws Exception {
        String userCode = null;
        String status = requestDto.getStatus();
        if (StringUtils.isBlank(userCode)) {
            userCode = SinoRequestContext.getCurrentContext().getUserCode();
        }
        PrpDuserDto userInfo = userApi.queryByPK(userCode);
        String registNo = requestDto.getRegistNo();
        String nodeType = requestDto.getNodeType();
        String uploadNodeFlag = nodeType;
        String swfLogLogNo = requestDto.getLogNo();
        String swfLogFlowID = requestDto.getFlowId();
        CertifyDto certifyDto = checkDataService.findCertifyDtoByRegistNo(registNo);
        RegistDto registDto = registDataService.findRegistDtoByRegistNo(registNo);
		/* 是否是关联保单 */
        String relatePolicyFlag = "0";
        if (registDto.getPrpLRegistRPolicyDtoList().size() > 1) {
            relatePolicyFlag = "1";
        }
        responseDto.setRelatePolicyFlag(relatePolicyFlag);
		/* 获得强制保单的关联信息 */
        if ("1".equals(relatePolicyFlag)) {
            responseDto.setPrpLRegistRPolicyCompel(registDto.getPrpLRegistRPolicyDtoOfCompel());
        }
        // responseDto.setPrpLregistDto(registDto.getPrpLRegistDto());
        PrpLcertifyCollectDtoExt prpLcertifyCollectDto = null;
		/* 如果已经存在单证主表(PrpLcertifyCollect)信息 */
        if (certifyDto != null && certifyDto.getPrpLcertifyCollectDtoExt() != null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("----已经存在单证主表信息---------");
            }
            prpLcertifyCollectDto = certifyDto.getPrpLcertifyCollectDtoExt();
            // 设置状态，原来有的取原来的，没有的设置为1
            if (certifyDto.getPrpLclaimStatusDto() != null) {
                prpLcertifyCollectDto.setStatus(certifyDto.getPrpLclaimStatusDto().getStatus());
            } else {
                prpLcertifyCollectDto.setStatus("1");
            }
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("----不存在单证主表信息---------" + registDto.getPrpLRegistDto().getPolicyNo());

            }
            prpLcertifyCollectDto = new PrpLcertifyCollectDtoExt();
            prpLcertifyCollectDto.setBusinessNo(registNo);
            prpLcertifyCollectDto.setPolicyNo(registDto.getPrpLRegistDto().getPolicyNo());
            prpLcertifyCollectDto.setLossItemCode("1");
            prpLcertifyCollectDto.setLossItemName("标的名称");
            prpLcertifyCollectDto.setPicCount(0d);
            prpLcertifyCollectDto.setUploadYear(String.valueOf(new DateTime(DateTime.current().toString()).getYear()));
            prpLcertifyCollectDto.setRiskCode(registDto.getPrpLRegistDto().getRiskCode());
            prpLcertifyCollectDto.setStartDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
            prpLcertifyCollectDto.setStartHour(String.valueOf(DateTime.current().getHour()));
            prpLcertifyCollectDto.setEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
            prpLcertifyCollectDto.setEndHour(String.valueOf(DateTime.current().getHour()));
            if (userInfo == null) {
                prpLcertifyCollectDto.setOperatorCode(registDto.getPrpLRegistDto().getHandlerCode());
            } else {
                prpLcertifyCollectDto.setOperatorCode(userInfo.getUserCode());
            }
            prpLcertifyCollectDto.setContent("");
            prpLcertifyCollectDto.setFlag("");
			/* 事故类型 */
            prpLcertifyCollectDto.setCaseFlag("0000");
            prpLcertifyCollectDto.setStatus("1");
        }
        // 工作流的东西
        if (!prpLcertifyCollectDto.getStatus().equals("4")) {
            String msg = "";
            // 校验立案是否注销拒赔
            Object[] claimList1 = prplClaimDao.findByQueryConditions(registNo);

            List<PrpLClaimDtoExt> claimList = new ArrayList<PrpLClaimDtoExt>();
            for (Object object : claimList1) {
                Object[] objects = (Object[]) object;
                PrpLClaimDtoExt claimDtoExt = new PrpLClaimDtoExt();
                claimDtoExt.setClaimNo((String) objects[0]);
                claimDtoExt.setRegistNo((String) objects[1]);
                claimDtoExt.setOperatorCode((String) objects[2]);
                claimDtoExt.setCaseType((String) objects[3]);
                claimDtoExt.setOperateDate(new DateTime((Date) objects[4], DateTime.YEAR_TO_DAY).toString());
                claimDtoExt.setStatus((String) objects[5]);
                claimDtoExt.setRiskCode((String) objects[6]);
                claimDtoExt.setReportDate((Date) objects[7]);
                claimDtoExt.setInputDate((Date) objects[8]);
                claimList.add(claimDtoExt);
            }
            Iterator<PrpLClaimDtoExt> it = claimList.iterator();
            while (it.hasNext()) {
                PrpLClaimDtoExt prplClaim = (PrpLClaimDtoExt) it.next();
                if (null != prplClaim.getCaseType() && prplClaim.getCaseType().trim().equals("0"))
                    msg = "该案已经注销";
                else {
                    msg = "";
                    break;
                }
                if (prplClaim.getCaseType().trim().equals("1"))
                    msg = "该案已经拒赔";
                else {
                    msg = "";
                    break;
                }
            }
            prpLcertifyCollectDto.setNoSubmitMsg(msg);
        }
        if (status != null && !status.equals("")) {
            prpLcertifyCollectDto.setStatus(status);
        }
        // 把单证主表设置到 prpLcertifyCollectDto
        responseDto.setPrpLcertifyCollectDtoExt(prpLcertifyCollectDto);
        // 处理单证及影像表(PrpLcertifyImg)
        PrpLCertifyImgDtoExt prpLcertifyImgDto = new PrpLCertifyImgDtoExt();
        prpLcertifyImgDto.setCertifyImgDtoList(certifyDto.getPrpLcertifyImgDtoList());
        if (certifyDto.getPrpLcertifyImgDtoList() != null) {
            LOGGER.debug("---处理单证及影像表------" + certifyDto.getPrpLcertifyImgDtoList().size() + "|"
                    + certifyDto.getPrpLcertifyDirectDtoList().size());
        }
        prpLcertifyImgDto.setUploadNodeFlag(uploadNodeFlag);
        prpLcertifyImgDto.setBusinessNo(registNo);
        prpLcertifyImgDto.setPolicyNo(registDto.getPrpLRegistDto().getPolicyNo());
        prpLcertifyImgDto.setSignInDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLcertifyImgDto.setThirdPartyCode("9999999999");
        if (userInfo == null) {
            prpLcertifyImgDto.setCollectorName(registDto.getPrpLRegistDto().getHandlerCode());
        } else {
            prpLcertifyImgDto.setCollectorName(userInfo.getUserCode());
        }
        prpLcertifyImgDto.setFlag("1");
        responseDto.setPrpLCertifyImgDtoExt(prpLcertifyImgDto);
        PrplCertifyDirectDtoExt prpLcertifyDirectDto = new PrplCertifyDirectDtoExt();
        if (registDto != null) {
            if (registDto.getPrpLRegistDto() != null) {
                String riskcode = registDto.getPrpLRegistDto().getRiskCode();
                if (riskcode.startsWith("32")) {

                    if (certifyDto.getPrpLcertifyDirectDtoList() != null
                            && certifyDto.getPrpLcertifyDirectDtoList().size() > 0) {
                        boolean upload = false;
                        int serialno = 0;
                        for (int i = 0; i < certifyDto.getPrpLcertifyDirectDtoList().size(); i++) {
                            serialno++;
                            PrplCertifyDirectDto tempDto = (PrplCertifyDirectDto) certifyDto
                                    .getPrpLcertifyDirectDtoList().get(i);
                            String typecode = tempDto.getTypeCode();
                            if ("A008".equals(typecode)) {
                                upload = true;
                                break;
                            }
                        }
                        if (false == upload) {
                            PrplCertifyDirectDto prpLcertifyDirectDtoForTemp = new PrplCertifyDirectDto();
                            prpLcertifyDirectDtoForTemp.setRegistNo(registDto.getPrpLRegistDto().getRegistNo());
                            prpLcertifyDirectDtoForTemp.setSerialNo(serialno + 1);
                            prpLcertifyDirectDtoForTemp.setRiskCode(riskcode);
                            prpLcertifyDirectDtoForTemp.setPolicyNo(registDto.getPrpLRegistDto().getPolicyNo());
                            prpLcertifyDirectDtoForTemp.setLossItemCode("5");
                            prpLcertifyDirectDtoForTemp.setTypeCode("A008");
                            prpLcertifyDirectDtoForTemp.setTypeName("出险现场照片");
                            prpLcertifyDirectDtoForTemp.setColumnValue("columevaue");
                            try {
                                prplCertifyDirectService.save(prpLcertifyDirectDtoForTemp);
                            } catch (Exception ex) {

                            }
                            certifyDto.getPrpLcertifyDirectDtoList().add(prpLcertifyDirectDtoForTemp);
                        }
                        prpLcertifyDirectDto.setPrplCertifyDirectDtoList(certifyDto.getPrpLcertifyDirectDtoList());
                        responseDto.setPrplCertifyDirectDtoExt(prpLcertifyDirectDto);
                    } else {
                        prpLcertifyDirectDto.setRegistNo(registDto.getPrpLRegistDto().getRegistNo());
                        prpLcertifyDirectDto.setSerialNo(1);
                        prpLcertifyDirectDto.setRiskCode(riskcode);
                        prpLcertifyDirectDto.setPolicyNo(registDto.getPrpLRegistDto().getPolicyNo());
                        prpLcertifyDirectDto.setLossItemCode("5");
                        prpLcertifyDirectDto.setTypeCode("A008");
                        prpLcertifyDirectDto.setTypeName("出险现场照片");
                        prpLcertifyDirectDto.setColumnValue("columevaue");
                        try {
                            prplCertifyDirectService.save(prpLcertifyDirectDto);
                        } catch (Exception ex) {

                        }
                        ArrayList prpLcertifyDirectDtoList = new ArrayList();
                        prpLcertifyDirectDtoList.add(prpLcertifyDirectDto);
                        prpLcertifyDirectDto.setPrplCertifyDirectDtoList(prpLcertifyDirectDtoList);
                        responseDto.setPrplCertifyDirectDtoExt(prpLcertifyDirectDto);
                    }
                } else {
                    prpLcertifyDirectDto.setPrplCertifyDirectDtoList(certifyDto.getPrpLcertifyDirectDtoList());
                    responseDto.setPrplCertifyDirectDtoExt(prpLcertifyDirectDto);
                }
            } else {
                prpLcertifyDirectDto.setPrplCertifyDirectDtoList(certifyDto.getPrpLcertifyDirectDtoList());
                responseDto.setPrplCertifyDirectDtoExt(prpLcertifyDirectDto);
            }
        } else {
            prpLcertifyDirectDto.setPrplCertifyDirectDtoList(certifyDto.getPrpLcertifyDirectDtoList());
            responseDto.setPrplCertifyDirectDtoExt(prpLcertifyDirectDto);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("codeType", "ImageType");
        map.put("riskCode", registDto.getPrpLRegistDto().getRiskCode());
        map.put("hpFlag", -1);
        List<PrpDcodeDto> imageTypeList = prpDcodeApi.getOptionCode(map);
        responseDto.setImageTypeList(imageTypeList);
        String riskCode = prpLcertifyDirectDto.getRiskCode() == null ? "" : prpLcertifyDirectDto.getRiskCode();
        map.put("codeType", "CertiQuality");
        map.put("riskCode", registDto.getPrpLRegistDto().getRiskCode());
        map.put("hpFlag", -1);
        List<PrpDcodeDto> certiQuality = prpDcodeApi.getOptionCode(map);
        responseDto.setQualityCheckList(certiQuality);
		/* 根据需要标志，都上传了。。就认为是齐全的，如果有需要标志的，但是没上传，就是认为不齐全的。 */
        StringBuffer stringBuffer = new StringBuffer();
		/* 物损收集标志 */
        String cltPropFlag = "1";
		/* 全损收集标志 no support */
        String cltAllLossFlag = "1";
        List<PrpDcodeDto> uploadList = new ArrayList<>();

        LOGGER.debug("----不存在单证主表信息--stringBuffer-------" + stringBuffer.toString());
		/* 物损收集标志 */
        prpLcertifyCollectDto.setCltPropFlag(cltPropFlag);
		/* 全损收集标志 */
        prpLcertifyCollectDto.setCltAllLossFlag(cltAllLossFlag);
		/* 得到实赔类型列表 */
        LOGGER.debug("---处理单证及影像表---imageTypeList---" + imageTypeList.size());
        responseDto.setPrpLregistDto(registDto.getPrpLRegistDto());
        responseDto.setCertifyDto(certifyDto);
    }
    @Override
    public Map<String, String> saveCertify(SaveCertifyDto requestDto) {
        String flowId = requestDto.getFlowId();
        String logNo = requestDto.getLogNo();
        List<SwfLog> swfLogs = swfLogDao.findAll(Specifications.<SwfLog> and().eq("flowId", flowId)
                .eq("nodeType", "cance").in("nodeStatus", "0", "2").build());
        if (swfLogs != null && swfLogs.size() > 0) {
            throw new BusinessException("案件已经申请注销拒赔！");
        }
        List<SwfLog> swfLogList = swfLogDao.findAll(Specifications.<SwfLog> and().eq("flowId", flowId)
                .eq("logNo", logNo).eq("nodeType", "certi").eq("nodeStatus", "4").build());
        if (swfLogList != null && swfLogList.size() > 0) {
            throw new BusinessException("案件单证环节已经处理！");
        }
        this.saveCertifyInfo(requestDto);
        Map<String, String> map = new HashMap<>();
        map.put("code", "0000");
        map.put("msg", "保存成功！");
        return map;
    }
    @Transactional(value = TxType.REQUIRED)
    private void saveCertifyInfo(SaveCertifyDto saveCertifyDto) {
        CertifyDto certifyDto = saveCertifyDto.getCertifyDto();
        String registNo = saveCertifyDto.getRegistNo();
        String policyNo = saveCertifyDto.getPolicyNo();
        List<PrpDcodeDto> imageTypeList = saveCertifyDto.getImageTypeList();
		/* 先删除再插入 */
        prplCertifyDirectDao.deleteByRegistNo(registNo);
		/* 插入 */
        List<PrplCertifyDirect> prplCertifyDirectList = new ArrayList<>();
        int serialNo = 0;
        if (imageTypeList != null) {
            for (PrpDcodeDto prpDcodeDto : imageTypeList) {
                PrplCertifyDirect prplCertifyDirect = new PrplCertifyDirect();
                serialNo++;
                prplCertifyDirect.setRegistNo(registNo);
                prplCertifyDirect.setPolicyNo(policyNo);
                prplCertifyDirect.setTypeCode(prpDcodeDto.getCodeCode());
                prplCertifyDirect.setTypeName(prpDcodeDto.getCodeCName());
                prplCertifyDirect.setSerialNo(serialNo);
                prplCertifyDirect.setLossItemCode(serialNo + "");
                prplCertifyDirectList.add(prplCertifyDirect);
            }
            prplCertifyDirectDao.save(prplCertifyDirectList);
        } else {
            // 首先删除原来的相关数据
            deleteSubInfo(saveCertifyDto);
            PrpLCertifyCollect prpLCertifyCollect = this.convert(certifyDto.getPrpLcertifyCollectDtoExt(),
                    PrpLCertifyCollect.class);
            prpLCertifyCollectDao.save(prpLCertifyCollect);
            if (certifyDto.getPrpLcertifyImgDtoList() != null && certifyDto.getPrpLcertifyImgDtoList().size() > 0) {
                List<PrpLCertifyImg> prpLcertifyImgDtoList = new ArrayList<>();
                this.convertCollection(certifyDto.getPrpLcertifyImgDtoList(),prpLcertifyImgDtoList,
                        PrpLCertifyImg.class);
                prpLCertifyImgDao.save(prpLcertifyImgDtoList);
            }
            if (certifyDto.getPrpLqualityCheckDtoList() != null && certifyDto.getPrpLqualityCheckDtoList().size() > 0) {
                List<PrplQualityCheck> prpLqualityCheckList = new ArrayList<>();
                this.convertCollection(certifyDto.getPrpLqualityCheckDtoList(), prpLqualityCheckList,
                        PrplQualityCheck.class);
                prplQualityCheckDao.save(prpLqualityCheckList);
            }

            if (certifyDto.getPrpLregistExtDtoList() != null && certifyDto.getPrpLregistExtDtoList().size() > 0) {
                List<PrpLRegistExt> prpLregistExtList = new ArrayList<>();
                this.convertCollection(certifyDto.getPrpLregistExtDtoList(), prpLregistExtList, PrpLRegistExt.class);
                prpLRegistExtDao.save(prpLregistExtList);
            }

            // 回访信息
            if (certifyDto.getPrplreturnvisitswflogDto() != null) {
                prplReturnVisitSwflogDao
                        .save(this.convert(certifyDto.getPrplreturnvisitswflogDto(), PrplReturnVisitSwflog.class));
            }
            /**进行状态的改变*/
            updateClaimStatus(certifyDto);
        }
    }
    private void updateClaimStatus(CertifyDto certifyDto) {
        // 示例未完成
        String nodeType = certifyDto.getNodeType();
        if (nodeType.equals("certi")) {
            if (certifyDto.getPrpLclaimStatusDto() != null) {
                prpLclaimStatusDao.deleteByContion(certifyDto.getPrpLclaimStatusDto().getBusinessno(), "certi");
                prpLclaimStatusDao.save(this.convert(certifyDto.getPrpLclaimStatusDto(), PrpLclaimStatus.class));
            }
        }

    }
    /**
     * @description:方法功能简述:删除相关数据
     * @author 安齐崇
     * @date 2017年12月23日下午5:15:47
     * @param claimListDto
     */
    private void deleteSubInfo(SaveCertifyDto saveCertifyDto) {
        CertifyDto certifyDto = saveCertifyDto.getCertifyDto();
        if (certifyDto.getPrpLcertifyCollectDtoExt() != null) {
            prpLCertifyCollectDao.deleteByBusinessNo(certifyDto.getPrpLcertifyCollectDtoExt().getBusinessNo().trim());
        }
        if (certifyDto.getPrpLcertifyImgDtoList() != null && certifyDto.getPrpLcertifyImgDtoList().size() > 0) {
            prpLCertifyImgDao.deleteByBusinessNo(certifyDto.getPrpLcertifyCollectDtoExt().getBusinessNo().trim());
        }
        if (certifyDto.getPrpLqualityCheckDtoList() != null && certifyDto.getPrpLqualityCheckDtoList().size() > 0) {
            prplQualityCheckDao.deleteByRegistNo(certifyDto.getPrpLcertifyCollectDtoExt().getBusinessNo().trim());
        }
        prpLRegistExtDao.deleteByRegistNo(certifyDto.getPrpLcertifyCollectDtoExt().getBusinessNo());
    }
}