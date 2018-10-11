package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCplanDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.policymanage.service.VoucherSmsService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.notice.api.common.SendNoticeApi;
import com.sinosoft.notice.api.common.dto.*;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31PolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingPolicyListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 潘峰
 * @date 2017/12/19 上午10:17
 */
@Service
public class VoucherSmsServiceImpl extends BaseServiceImpl implements VoucherSmsService {

    @Autowired
    private PrpCmainDao prpCmainDao;

    @Autowired
    private PlantingPolicyListApi plantingPolicyListApi;

    @Autowired
    private Planting31PolicyListApi planting31PolicyListApi;

    @Autowired
    private NyxPolicyListApi nyxPolicyListApi;

    @Autowired
    private HerdPolicyListApi herdPolicyListApi;

    @Autowired
    private PrpCitemKindDao prpCitemKindDao;

    @Autowired
    private PrpDkindApi prpDkindApi;

    @Autowired
    private SendNoticeApi sendNoticeApi;

    @Autowired
    private PrpCplanDao prpCplanDao;
    @Autowired
    private InsureMainListApi insureMainListApi;
    @Autowired
    private UtiGroupApi utiGroupApi;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 清单存储在planting的险种
     */
    // @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRisk;
    /**
     * 清单存储在planting31的险种
     */
    //  @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Risk;
    /**
     * 清单存储在nyx的险种
     */
    // @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRisk;
    /**
     * 清单存储在herd的险种
     */
    // @Value("${sysconfig.insureListRsk.herd}")
    private String herdRisk;

    /**
     * 新农险系统标志
     */
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;

    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    public void inint() {
        this.plantingRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Risk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        ;
        this.nyxRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        ;
        this.herdRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
        ;
    }
    @Override
    public NoticeReturnDto getSmsContent(ReqMessageDto reqMessageDto) throws Exception {
        inint();
        //通过保单号查清单主表 insureMainList （清单号） 查到 根据清单号到农户信息表查农户信息 （ plantingPolicyList）
        Map<String, String> map = new HashMap<>();
        String policyNo = reqMessageDto.getPolicyNo();
        map.put("policyNo", policyNo);
        List<RepMessageDto> messageList = new ArrayList<>();
        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        String riskCode = prpCmain.getRiskCode();
        if (plantingRisk.contains(riskCode)) {
            List<PlantingPolicyListDto> plantingPolicyListDtos = plantingPolicyListApi.queryPlantingPolicyListByPolicyNO(map);
            plantingPolicyListDtos.forEach(plantingPolicyListDto -> {
                RepMessageDto repMessageDto = buildByPlantingDto(plantingPolicyListDto, prpCmain, getKindName(policyNo));
                messageList.add(repMessageDto);
            });
        } else if (planting31Risk.contains(riskCode)) {
            List<Planting31PolicyListDto> planting31PolicyListDtos = planting31PolicyListApi.queryInsuranceListDtoByPolicyNo(map);
            planting31PolicyListDtos.forEach(planting31PolicyListDto -> {
                RepMessageDto repMessageDto = buildByPlanting31Dto(planting31PolicyListDto, prpCmain, getKindName(policyNo));
                messageList.add(repMessageDto);
            });
        } else if (herdRisk.contains(riskCode)) {
            List<HerdPolicyListDto> herdPolicyListDtos = herdPolicyListApi.queryInsuranceListDtoByPolicyNo(map);
            List<HerdPolicyListDto> _herdPolicyListDtos = new ArrayList<>();
            Map<String, List<HerdPolicyListDto>> collect = herdPolicyListDtos.stream().collect(Collectors.groupingBy(HerdPolicyListDto::getfCode));
            collect.forEach((fCode, herdPolicyListDtoList) -> _herdPolicyListDtos.add(herdPolicyListDtoList.get(0)));
            _herdPolicyListDtos.forEach(herdPolicyListDto -> {
                RepMessageDto repMessageDto = buildByHerdDto(herdPolicyListDto, prpCmain, getKindName(policyNo));
                messageList.add(repMessageDto);
            });
        } else if (nyxRisk.contains(riskCode)) {
            List<NyxPolicyListDto> nyxPolicyListDtos = nyxPolicyListApi.queryInsuranceListDtoByPolicyNo(map);
            nyxPolicyListDtos.forEach(nyxPolicyListDto -> {
                RepMessageDto repMessageDto = buildByNyxDto(nyxPolicyListDto, prpCmain, getKindName(policyNo));
                messageList.add(repMessageDto);
            });
        }
        NoticeConditionDto noticeConditionDto = new NoticeConditionDto();
        noticeConditionDto.setRepMessageDtoList(messageList);
        initReqMessage(reqMessageDto);
        noticeConditionDto.setReqMessageDto(reqMessageDto);
        NoticeReturnDto noticeReturnDto = sendNoticeApi.sendNotice(noticeConditionDto);
        return noticeReturnDto;

    }

    /**
     * 获取kindName
     *
     * @param policyNo
     * @return
     * @author: 何伟东
     * @date: 2018/4/23 17:42
     */
    private String getKindName(String policyNo) {
        //取得kindName 险种值
        List<PrpCitemKind> prpCitemKinds = prpCitemKindDao.findByPolicyNo(policyNo);
        String kindCName = null;
        if (prpCitemKinds.size() > 0 && null != prpCitemKinds) {
            PrpCitemKind prpCitemKind = prpCitemKinds.get(0);
            PrpDkindDto prpDkindDto = prpDkindApi.queryByPK(prpCitemKind.getRiskCode(), prpCitemKind.getKindCode());
            kindCName = prpDkindDto.getKindCName();
        }
        return kindCName;
    }

    /**
     * 短信关联清单查询
     *
     * @param policyNo
     * @return java.lang.Integer
     * @throws
     * @author 李冬松
     * @date 15:55 2018/4/9
     */
    @Override
    public Integer getSendNumber(String policyNo,String loginComCode, String userCode, String tableName, String userCodeFields, String comCodeFields) throws Exception {
        sendNoticeApi.checkAppointment(policyNo);
        StringBuilder checkSql = new StringBuilder("select p from PrpCmain p where policyNo=:policyNo and systemFlag=:systemFlag ");
        //获取权限查询条件
        AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(userCode, loginComCode,
                "", tableName, userCodeFields,
                comCodeFields, "", "p", true);
        String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
        checkSql.append(codePower);
        Query checkQuery = entityManager.createQuery(checkSql.toString());
        checkQuery.setParameter("policyNo",policyNo);
        checkQuery.setParameter("systemFlag",systemFlag);
        List<PrpCmain> resultList = checkQuery.getResultList();
        if (resultList != null && resultList.size() > 0) {
            PrpCmain prpCmain = resultList.get(0);
            if (!prpCmain.getIsSeeFeeFlag().equals("0")) {
                Double sumDelinquentFee = prpCplanDao.sumDelinquentFee(policyNo);
                if (sumDelinquentFee.doubleValue() > 0) {
                    throw new DataVerifyException("见费出单保费未缴齐，不允许发送短信");
                }
            }
            Map<String, String> map = new HashMap<>();
            map.put("policyNo", policyNo);
            return insureMainListApi.queryFarmerNumber(map);
        } else {
            throw new DataVerifyException("没有该保单");
        }

    }

    /**
     * 初始化短信配置
     *
     * @param reqMessageDto
     * @return
     * @author: 潘峰
     * @date: 2017/12/21 下午6:20
     */
    private ReqMessageDto initReqMessage(ReqMessageDto reqMessageDto) {
        reqMessageDto.setNoticeType(MessageConfig.NOTICETYPE_MESSAGE);
        reqMessageDto.setPriority(MessageConfig.PRIORITY_SECOND);
        return reqMessageDto;
    }

    /**
     * 重新构建数据在planting31表的 RepMessageDto
     *
     * @param planting31PolicyListDto
     * @param prpCmain
     * @param kindCName
     * @return
     */
    private RepMessageDto buildByPlanting31Dto(Planting31PolicyListDto planting31PolicyListDto, PrpCmain prpCmain, String kindCName) {
        RepMessageDto repMessageDto = convert(planting31PolicyListDto, RepMessageDto.class);
        repMessageDto.setPhoneNo(planting31PolicyListDto.getPhone());
        buildByPrpCmain(prpCmain, kindCName, repMessageDto);
        return repMessageDto;
    }

    /**
     * 重新构建数据在herd表的 RepMessageDto
     *
     * @param herdPolicyListDto
     * @param prpCmain
     * @param kindCName
     * @return
     */
    private RepMessageDto buildByHerdDto(HerdPolicyListDto herdPolicyListDto, PrpCmain prpCmain, String kindCName) {
        RepMessageDto repMessageDto = convert(herdPolicyListDto, RepMessageDto.class);
        repMessageDto.setInsureArea(herdPolicyListDto.getInsureNumber() * 1.0);
        repMessageDto.setPhoneNo(herdPolicyListDto.getPhone());
        buildByPrpCmain(prpCmain, kindCName, repMessageDto);
        return repMessageDto;
    }

    /**
     * 重新构建数据在nyx表的 RepMessageDto
     *
     * @param nyxPolicyListDto
     * @param prpCmain
     * @param kindCName
     * @return
     */
    private RepMessageDto buildByNyxDto(NyxPolicyListDto nyxPolicyListDto, PrpCmain prpCmain, String kindCName) {
        RepMessageDto repMessageDto = convert(nyxPolicyListDto, RepMessageDto.class);
        repMessageDto.setPhoneNo(nyxPolicyListDto.getPhone());
        buildByPrpCmain(prpCmain, kindCName, repMessageDto);
        return repMessageDto;
    }

    /**
     * 重新构建数据在planting表的 RepMessageDto
     *
     * @param plantingPolicyListDto
     * @param prpCmain
     * @param kindCName
     * @return
     */
    private RepMessageDto buildByPlantingDto(PlantingPolicyListDto plantingPolicyListDto, PrpCmain prpCmain, String kindCName) {
        RepMessageDto repMessageDto = convert(plantingPolicyListDto, RepMessageDto.class);
        repMessageDto.setPhoneNo(plantingPolicyListDto.getPhone());
        buildByPrpCmain(prpCmain, kindCName, repMessageDto);
        return repMessageDto;
    }

    /**
     * 重新构建数据在prpCmain的 RepMessageDto
     *
     * @param prpCmain
     * @param kindCName
     * @param repMessageDto
     * @author: 何伟东
     * @date: 2018/4/23 17:51
     */
    private void buildByPrpCmain(PrpCmain prpCmain, String kindCName, RepMessageDto repMessageDto) {
        if (StringUtils.isNotEmpty(kindCName)) {
            repMessageDto.setKindName(kindCName);
        }
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Optional.ofNullable(prpCmain).map(c -> {
            repMessageDto.setBusinessNo(c.getPolicyNo());
            repMessageDto.setPolicyNo(c.getPolicyNo());
            repMessageDto.setInsuredName(c.getInsuredName());
            repMessageDto.setAppName(c.getAppliName());
            repMessageDto.setAppCode(c.getAppliCode());
            repMessageDto.setMakeCom(c.getMakeCom());
            repMessageDto.setInsuredCode(c.getInsuredCode());
            repMessageDto.setOperateDate(dateformat.format(c.getOperateDate()));
            repMessageDto.setStartDate(dateformat.format(c.getStartDate()));
            repMessageDto.setEndDate(dateformat.format(c.getEndDate()));
            return repMessageDto;
        });
    }


}
