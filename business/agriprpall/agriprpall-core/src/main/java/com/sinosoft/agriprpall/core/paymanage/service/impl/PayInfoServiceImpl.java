package com.sinosoft.agriprpall.core.paymanage.service.impl;

import com.sinosoft.agriprpall.api.paymanage.dto.*;
import com.sinosoft.agriprpall.core.common.util.file.FileUtil;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpCPinsured;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmainKey;
import com.sinosoft.agriprpall.core.paymanage.dao.*;
import com.sinosoft.agriprpall.core.paymanage.entity.*;
import com.sinosoft.agriprpall.core.paymanage.excel.read.PayInfoExcelRead;
import com.sinosoft.agriprpall.core.paymanage.service.PayInfoService;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.ExcelUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.PrpDkindApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.*;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 支付信息维护模块ServiceImpl
 *
 * @author: 何伟东
 * @date: 2017/12/20 18:08
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class PayInfoServiceImpl extends BaseCustomServiceImpl implements PayInfoService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpPayMainDao prpPayMainDao;
    @Autowired
    private PrpPayMainHisDao prpPayMainHisDao;
    @Autowired
    private PrpPaySubDao prpPaySubDao;
    @Autowired
    private EndorseListApi endorseListApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpDkindApi prpDkindApi;
    @Autowired
    private PrpDitemApi prpDitemApi;
    @Autowired
    private PlantingEndorChgDetailApi plantingEndorChgDetailApi;
    @Autowired
    private Planting31EndorChgDetailApi planting31EndorChgDetailApi;
    @Autowired
    private HerdEndorChgDetailApi herdEndorChgDetailApi;
    @Autowired
    private NyxEndorChgDetailApi nyxEndorChgDetailApi;
    @Autowired
    private UtiGroupApi utiGroupApi;


    @Autowired
    private PrpPmainDao prpPmainDao;
    @Autowired
    private TempCostTypeDao tempCostTypeDao;
    @Autowired
    private PrpCpayInfoDao prpCpayInfoDao;


    /**
     * 快速导出excel工具类
     */
    private static QuicklyExportExcel quicklyExportExcel;

    /**
     * 文件工具类
     */
    private static FileUtil fileUtil;

    /**
     * Excel导出的版本配置
     */
    @Value("${exportExcelType}")
    private String exportExcelType;

    /**
     * fileService的服务器地址
     */
    @Value("${fileService.url}")
    private String fileServiceUrl;

    /**
     * 新农险系统标志
     */
    @Value("${sysconfig.common.systemFlag}")
    private String systemFlag;

    /**
     * 清单存储在planting的险种
     */
    private String plantingRisk;

    /**
     * 清单存储在planting31的险种
     */
    private String planting31Risk;

    /**
     * 清单存储在nyx的险种
     */
    private String nyxRisk;

    /**
     * 清单存储在herd的险种
     */
    private String herdRisk;

    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    public void inint() {
        this.plantingRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Risk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        this.nyxRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        this.herdRisk = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
    }

    /**
     * 支付信息录入列表信息查询
     *
     * @param queryPayInfoByConditionDto 查询条件
     * @param isInput                    true-支付信息录入查询;false-支付信息修改查询
     * @return 符合条件的列表信息
     * @author: 何伟东
     * @date: 2017/12/20 17:53
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageInfo<ResponsePayInfoDto> queryPayInfoByCondition(QueryPayInfoByConditionDto queryPayInfoByConditionDto, boolean isInput) throws Exception {
        if (queryPayInfoByConditionDto == null) {
            throw new DataVerifyException("入参不能为空！");
        }
        String costType = queryPayInfoByConditionDto.getCostType();
        int pageNo = queryPayInfoByConditionDto.getPageNo();
        if (pageNo < 1) {
            throw new DataVerifyException("页码不能小于1");
        }
        int pageSize = queryPayInfoByConditionDto.getPageSize();
        if (pageSize < 1) {
            throw new DataVerifyException("每页数量不能小于1");
        }

        // 查询费用类型对应的收付原因，并且转换成可关联的数据结构存储到临时表
        Map<String, String> map = new HashMap<>(1);
        Map<String, Object> param = new HashMap<>();

        String costTypeCondition = "";
        if (StringUtils.isNotEmpty(costType) && !"-1".equals(costType)) {
            map.put("codeCode", costType);
            costTypeCondition = " and ps.costType=:costType";
            param.put("costType", costType);
        }
        map.put("codeType", "CostType");
        List<PrpDcodeDto> prpDcodeDtos = prpDcodeApi.queryCodeInfoByTypeAndCode(map);
        Map<String, PrpDcodeDto> costTypeMap = new HashMap<>();
        List<TempCostType> tempCostTypes = new ArrayList<>();
        prpDcodeDtos.forEach(prpDcodeDto -> {
            String codeCode = prpDcodeDto.getCodeCode();
            String newCodeCode = prpDcodeDto.getNewCodeCode();
            String[] codes = newCodeCode.split(",");
            for (int i = 0; i < codes.length; i++) {
                TempCostType tempCostType = new TempCostType(codeCode, codes[i]);
                tempCostTypes.add(tempCostType);
            }
            costTypeMap.put(codeCode, prpDcodeDto);
        });
        tempCostTypeDao.save(tempCostTypes);
        // 费用类型整理结束
        String inputCondition = (isInput ?
                " not exists (select 1 from PrpPaySub ps where ps.endorseNo = pm.endorseNo and ps.costType = tc.costType" + costTypeCondition + ") and pm.chgPremium < 0 " :
                " exists (select 1 from PrpPaySub ps where ps.endorseNo = pm.endorseNo  and ps.costType = tc.costType" + costTypeCondition + ") ") +
                " and pm.endorseNo = pl.endorseNo AND pm.systemFlag = :systemFlag AND pl.payReason = tc.payReason";
        StringBuilder dataSql = new StringBuilder("select new ResTempCostType(pm.endorseNo, tc.costType, pm.policyNo, pm.insuredName, pl.payReason, pl.delinquentFee, sum(pl.planFee), pm.chgPremium ,pm.makeCom) " +
                "from PrpPmain pm, PrpCPplan pl, TempCostType tc where")
                .append(inputCondition);

        StringBuilder countSql = new StringBuilder("select count(1) from PrpPmain pm, PrpCPplan pl, TempCostType tc where").append(inputCondition);
        StringBuilder conditionSql = new StringBuilder();
        // 仅在录入支付信息查询时加入权限条件
        if (isInput) {
            //获取权限查询条件
            AddCodePowerConditionDto addCodePowerConditionDto = new AddCodePowerConditionDto(
                    SinoRequestContext.getCurrentContext().getUserCode(),
                    queryPayInfoByConditionDto.getLoginComCode(),
                    queryPayInfoByConditionDto.getLoginGradeCodes(),
                    "PrpPmain",
                    "userCode",
                    "comCode",
                    "",
                    "pm",
                    true);
            String codePower = utiGroupApi.addCodePower(addCodePowerConditionDto);
            dataSql.append(codePower);
            countSql.append(codePower);
        }
        param.put("systemFlag", systemFlag);
        // 批单号
        if (StringUtils.isNotEmpty(queryPayInfoByConditionDto.getEndorseNo())) {
            conditionSql.append(" and pm.endorseNo like :endorseNo");
            param.put("endorseNo", "%" + queryPayInfoByConditionDto.getEndorseNo() + "%");
        }
        // 保单号
        if (StringUtils.isNotEmpty(queryPayInfoByConditionDto.getPolicyNo())) {
            conditionSql.append(" and pm.policyNo like :policyNo");
            param.put("policyNo", "%" + queryPayInfoByConditionDto.getPolicyNo() + "%");
        }
        // 被保险人名称
        if (StringUtils.isNotEmpty(queryPayInfoByConditionDto.getInsuredName())) {
            conditionSql.append(" and pm.insuredName like :insuredName");
            param.put("insuredName", "%" + queryPayInfoByConditionDto.getInsuredName() + "%");
        }
        // 投保人名称
        if (StringUtils.isNotEmpty(queryPayInfoByConditionDto.getAppliName())) {
            conditionSql.append(" and pm.appliName like :appliName");
            param.put("appliName", "%" + queryPayInfoByConditionDto.getAppliName() + "%");
        }
        countSql.append(conditionSql);
        Query countQuery = entityManager.createQuery(countSql.toString());
        this.setQueryParam(countQuery, param);
        long countSize = (long) countQuery.getSingleResult();
        PageInfo<ResponsePayInfoDto> returnPageInfo;
        if (countSize > 0) {
            // 分组条件
            String groupBy = " group by tc.costType, pm.endorseNo, pm.policyNo, pm.insuredName, pl.payReason, pl.delinquentFee, pm.chgPremium, pm.makeCom";
            dataSql.append(conditionSql).append(groupBy).append(" order by pm.endorseNo desc");
            Query dataQuery = entityManager.createQuery(dataSql.toString());
            this.setQueryParam(dataQuery, pageNo, pageSize, param);
            List<ResTempCostType> dateResultList = dataQuery.getResultList();
            List<ResponsePayInfoDto> responsePayInfoDtos = new ArrayList<>();
            this.convertCollection(dateResultList, responsePayInfoDtos, ResponsePayInfoDto.class);
            List<String> comCodes = new ArrayList<>();
            // 获取查询结果中的不重复的出单机构代码和批单号码
            dateResultList.forEach(resTempCostType -> {
                String makeCom = resTempCostType.getMakeCom();
                if (comCodes.indexOf(makeCom) < 0) {
                    comCodes.add(makeCom);
                }
            });
            // 转译机构名称
            Map<String, String> comInfo = prpDcompanyApi.queryComCNameByComCodes(comCodes);
            responsePayInfoDtos.forEach(responsePayInfoDto -> {
                // 出单机构
                String makeCom = responsePayInfoDto.getMakeCom();
                responsePayInfoDto.setMakeComName(comInfo.get(makeCom));
                String _costType = responsePayInfoDto.getCostType();
                responsePayInfoDto.setCostType(costTypeMap.get(_costType).getCodeCName());
                responsePayInfoDto.setCostTypeCode(_costType);
            });
            returnPageInfo = this.setPageInfo(responsePayInfoDtos, pageNo, countSize, ResponsePayInfoDto.class);
        } else {
            returnPageInfo = new PageInfo<>();
            returnPageInfo.setTotalCount(0);
            returnPageInfo.setPages(pageNo);
        }
        return returnPageInfo;
    }

    /**
     * 保存整单支付信息，支持多个批单批量录入一条支付信息
     *
     * @param requestSavePayInfoDto 批单号码(支持批量录入整单支付信息)，整单支付信息
     * @param isModify              true-修改支付信息，false-新增支付信息
     * @author: 何伟东
     * @date: 2017/12/22 10:30
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, String> saveSinglePayInfo(RequestSavePayInfoDto requestSavePayInfoDto, boolean isModify) throws Exception {
        if (requestSavePayInfoDto == null) {
            throw new DataVerifyException("入参不能为空！");
        }
        String loginComCode = requestSavePayInfoDto.getLoginComCode();
        List<PrpPaySubDto> prpPaySubDtos = requestSavePayInfoDto.getSubInfo();
        if (prpPaySubDtos == null || prpPaySubDtos.size() < 1) {
            throw new DataVerifyException("批单号码和费用类型不能为空！");
        }
        if (isModify) {
            if (StringUtils.isEmpty(requestSavePayInfoDto.getEndorseNo())) {
                throw new DataVerifyException("批单号码不能为空！");
            }
        } else {
            if (StringUtils.isEmpty(loginComCode)) {
                throw new DataVerifyException("登录机构不能为空！");
            }
        }
        if (requestSavePayInfoDto.getPrpPayMainDto() == null) {
            throw new DataVerifyException("整单支付信息不能为空！");
        }
        // 获取支付号
        String payNo = this.getPayNo(prpPaySubDtos.get(0).getEndorseNo(), prpPaySubDtos.get(0).getCostType(), loginComCode, isModify);
        // 修改支付信息操作，记录修改轨迹信息，不修改子表的关联信息
        PrpPayMainDto prpPayMainDto = requestSavePayInfoDto.getPrpPayMainDto();
        PrpPayMain prpPayMain = convert(prpPayMainDto, PrpPayMain.class);
        if (isModify) {
            // 保存轨迹信息
            this.saveHisInfo(payNo);
        }
        // 新增支付信息操作，新增时不保存轨迹信息
        else {
            // 生成多条子表关联数据
            List<PrpPaySub> prpPaySubs = new ArrayList<>(prpPaySubDtos.size());
            prpPaySubDtos.forEach(prpPaySubDto -> {
                PrpPaySub prpPaySub = new PrpPaySub();
                String endorseNo = prpPaySubDto.getEndorseNo();
                prpPaySub.setPayNo(payNo);
                prpPaySub.setEndorseNo(endorseNo);
                prpPaySub.setPayType("0");
                prpPaySub.setCostType(prpPaySubDto.getCostType());
                prpPaySubs.add(prpPaySub);
            });
            prpPaySubDao.save(prpPaySubs);
        }
        prpPayMain.setPayNo(payNo);
        // 若整单支付信息录入时没有农户号码，设置主键信息为领款人证件号码
        if (StringUtils.isEmpty(prpPayMain.getfCode())) {
            prpPayMain.setfCode(prpPayMain.getCertifyNo());
        }
        prpPayMainDao.save(prpPayMain);
        List<PrpCpayInfo> prpCpayInfos = new ArrayList<>();
        prpPaySubDtos.forEach(prpPaySubDto -> {
            String endorseNo = prpPaySubDto.getEndorseNo();
            try {
                PrpPayMain _prpPayMain = (PrpPayMain) prpPayMain.clone();
                PrpCpayInfo prpCpayInfo = convert(_prpPayMain, PrpCpayInfo.class);
                prpCpayInfo.setEndorseNo(endorseNo);
                prpCpayInfo.setReceiverFullName(_prpPayMain.getReceiverName());
                prpCpayInfo.setUrgentType(_prpPayMain.getUgentType());
                prpCpayInfo.setBusinessNo2(_prpPayMain.getRouteNum());
                prpCpayInfos.add(prpCpayInfo);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        });
        prpCpayInfoDao.save(prpCpayInfos);
        Map<String, String> p = new HashMap<>(1);
        p.put("msg", "成功");
        return p;
    }

    /**
     * 保存清单支付信息，不支持批量录入
     *
     * @param requestSavePayInfoDto 清单支付批单号码，清单支付信息
     * @param isModify              true-修改支付信息，false-新增支付信息
     * @author: 何伟东
     * @date: 2017/12/22 16:49
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveListPayInfo(RequestSavePayInfoDto requestSavePayInfoDto, boolean isModify) throws Exception {
        if (requestSavePayInfoDto == null) {
            throw new DataVerifyException("入参不能为空");
        }
        String endorseNo = requestSavePayInfoDto.getEndorseNo();
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空");
        }
        String loginComCode = requestSavePayInfoDto.getLoginComCode();
        if (StringUtils.isEmpty(loginComCode) && !isModify) {
            throw new DataVerifyException("登录机构不能为空！");
        }
        String costType = requestSavePayInfoDto.getCostType();
        if (StringUtils.isEmpty(costType)) {
            throw new DataVerifyException("费用类型不能为空！");
        }
        if (requestSavePayInfoDto.getPrpPayMainDtos() == null || requestSavePayInfoDto.getPrpPayMainDtos().size() < 1) {
            throw new DataVerifyException("清单支付信息至少有一条");
        }
        // 数据校验
        List<PrpPayMainDto> prpPayMainDtos = requestSavePayInfoDto.getPrpPayMainDtos();
        // 农户代码列表
        List<String> fCodes = new ArrayList<>();
        // 农户代码和保费变化量信息
        Map<String, Double> chgPremium = new HashMap<>();
        // 遍历入参的dto数据取出农户代码和结算金额信息
        prpPayMainDtos.forEach(prpPayMainDto -> {
            String fCode = prpPayMainDto.getfCode();
            if (chgPremium.get(fCode) != null) {
                throw new DataVerifyException("农户" + fCode + "有多条支付信息");
            }
            chgPremium.put(fCode, prpPayMainDto.getChgPremium());
            fCodes.add(fCode);
        });
        // 查询批改分户清单，得到该批单号对应的所有批改过的农户代码和结算金额信息
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        param.put("column", this.getCostTypeToColumnName(requestSavePayInfoDto.getCostType()));
        param.put("riskCode", this.getRiskCode(endorseNo));
        Map<String, Double> farmerInfo = endorseListApi.getFarmerInfo(param);
        // 数据校验：不允许新增或减少农户个数
        if (prpPayMainDtos.size() != farmerInfo.size()) {
            throw new DataVerifyException("仅能修改农户支付相关信息，不允许新增或减少农户");
        }
        // 数据校验：不允许修改农户的结算金额信息，也不能修改农户的主键信息
        fCodes.forEach(fCode -> {
            Double chgSumPremium = Math.abs(farmerInfo.get(fCode));
            if (chgSumPremium != null) {
                if (!chgSumPremium.equals(chgPremium.get(fCode))) {
                    throw new DataVerifyException("不能修改农户" + fCode + "的结算金额，修改前" + chgSumPremium + "；修改后" + chgPremium.get(fCode));
                }
            } else {
                throw new DataVerifyException("批单" + endorseNo + "没有农户" + fCode + "的信息，或没有对做农户" + fCode + "进行批减保费的操作，不允许录入支付信息");
            }
        });
        this.checkPrpPayMainInfo(prpPayMainDtos);
        // 获取支付号
        String payNo = this.getPayNo(endorseNo, costType, loginComCode, isModify);
        // 修改支付信息操作，记录修改轨迹信息，不修改子表的关联信息
        if (isModify) {
            // 保存轨迹信息
            this.saveHisInfo(payNo);
        }
        // 新增支付信息操作，新增时不保存轨迹信息
        else {
            // 生成一条子表关联数据
            PrpPaySub prpPaySub = new PrpPaySub();
            prpPaySub.setPayType("1");
            // 批单号
            prpPaySub.setEndorseNo(endorseNo);
            // 支付号
            prpPaySub.setPayNo(payNo);
            // 费用类型字段
            prpPaySub.setCostType(requestSavePayInfoDto.getCostType());
            prpPaySubDao.save(prpPaySub);
        }
        // 生成多条主表支付信息
        List<PrpPayMain> prpPayMains = new ArrayList<>();
        this.convertCollection(prpPayMainDtos, prpPayMains, PrpPayMain.class);
        // 填充主表数据的支付号
        prpPayMains.forEach(prpPayMain -> prpPayMain.setPayNo(payNo));
        prpPayMainDao.save(prpPayMains);
    }

    /**
     * 支付信息明细信息查询
     *
     * @param endorseNo 批单号码
     * @param costType  费用类型
     * @return prpPaySubDtos-支付信息类型以及关联数据，List<PrpPayMainDto>-支付信息主要数据
     * @author: 何伟东
     * @date: 2017/12/26 10:46
     */
    @Override
    public ResponsePayInfoDetailsDto queryPayInfoDetails(String endorseNo, String costType) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        ResponsePayInfoDetailsDto responsePayInfoDetailsDto = new ResponsePayInfoDetailsDto();
        PrpPaySub prpPaySub = prpPaySubDao.findByEndorseNoAndCostType(endorseNo, costType);
        if (prpPaySub != null) {
            PrpPaySubDto prpPaySubDto = this.convert(prpPaySub, PrpPaySubDto.class);
            responsePayInfoDetailsDto.setPrpPaySubDto(prpPaySubDto);
            List<PrpPayMain> prpPayMains = prpPayMainDao.findByPayNo(prpPaySubDto.getPayNo());
            List<PrpPayMainDto> prpPayMainDtos = new ArrayList<>();
            if (prpPayMains != null && prpPayMains.size() > 0) {
                this.convertCollection(prpPayMains, prpPayMainDtos, PrpPayMainDto.class);
            }
            // 根据费用类型查询该类型对应的字段名称
            String column = this.getCostTypeToColumnName(prpPaySub.getCostType());
            // 查询批改分户清单，得到该批单号对应的所有批改过的农户代码和结算金额信息
            Map<String, String> param = new HashMap<>(1);
            param.put("column", column);
            param.put("endorseNo", endorseNo);
            param.put("riskCode", this.getRiskCode(endorseNo));
            Map<String, Double> farmerInfo = endorseListApi.getFarmerInfo(param);
            prpPayMainDtos.forEach(prpPayMainDto -> prpPayMainDto.setChgPremium(farmerInfo.get(prpPayMainDto.getfCode())));
            responsePayInfoDetailsDto.setPrpPayMainDtos(prpPayMainDtos);
        }
        return responsePayInfoDetailsDto;
    }

    /**
     * 清单支付信息录入，导出Excel
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:37
     */
    @Override
    public String exportExcel(String endorseNo, String costType) throws Exception {
        ResponsePayInfoDetailsDto responsePayInfoDetailsDto = this.queryPayInfoDetails(endorseNo, costType);
        PrpPmain prpPmain = prpPmainDao.queryAllByEndorseNo(endorseNo);
        String policyNo = prpPmain.getPolicyNo();
        List<PrpPayMainDto> prpPayMainDtos = responsePayInfoDetailsDto.getPrpPayMainDtos();
        String costName = this.getCostName(costType);
        // 证件类型代码集合
        List<String> certifyTypes = new ArrayList<>();
        // 领款人类型代码集合
        List<String> receiverTypes = new ArrayList<>();
        // 账号属性代码集合
        List<String> accountTypes = new ArrayList<>();
        // 账号类型代码集合
        List<String> accountFlags = new ArrayList<>();
        // 遍历存储数据的list取出需要转译的代码
        for (int i = 0; i < prpPayMainDtos.size(); i++) {
            PrpPayMainDto prpPayMainDto = prpPayMainDtos.get(i);
            prpPayMainDto.setSerialNo(i + 1);
            prpPayMainDto.setEndorseNo(endorseNo);
            prpPayMainDto.setPolicyNo(policyNo);
            // 获取各类型代码放到List中，并去重
            String certifyType = prpPayMainDto.getCertifyType();
            if (certifyTypes.indexOf(certifyType) < 0) {
                certifyTypes.add(certifyType);
            }
            // receiverType-领款人类型
            String receiverType = prpPayMainDto.getReceiverType();
            if (receiverTypes.indexOf(receiverType) < 0) {
                receiverTypes.add(receiverType);
            }
            // accountType-账号属性
            String accountType = prpPayMainDto.getAccountType();
            if (accountTypes.indexOf(accountType) < 0) {
                accountTypes.add(accountType);
            }
            // accountFlag-账号类型
            String accountFlag = prpPayMainDto.getAccountFlag();
            if (accountFlags.indexOf(accountFlag) < 0) {
                accountFlags.add(accountFlag);
            }
        }
        Map<String, String> certifyTypeCName = prpDcodeApi.queryCertifyTypeByCodes(certifyTypes);
        Map<String, String> receiverTypeCName = prpDcodeApi.queryReceiverTypesByCodes(receiverTypes);
        Map<String, String> accountTypeCName = prpDcodeApi.queryAccountTypeByCodes(accountTypes);
        Map<String, String> accountFlagCName = prpDcodeApi.queryAccountFlagByCodes(accountFlags);
        prpPayMainDtos.forEach(prpPayMainDto -> {
            String certifyType = prpPayMainDto.getCertifyType();
            prpPayMainDto.setCertifyType(certifyTypeCName.get(certifyType));
            String receiverType = prpPayMainDto.getReceiverType();
            prpPayMainDto.setReceiverType(receiverTypeCName.get(receiverType));
            String accountType = prpPayMainDto.getAccountType();
            prpPayMainDto.setAccountType(accountTypeCName.get(accountType));
            String accountFlag = prpPayMainDto.getAccountFlag();
            prpPayMainDto.setAccountFlag(accountFlagCName.get(accountFlag));
        });

        String excelName = "批单" + endorseNo + "(" + costName + ")支付清单";
        String titleName = "支付清单";
        String shortLink = this.exportExcel(prpPayMainDtos, PrpPayMainDto.class, excelName, titleName, 1, 17);
        return shortLink;
    }

    /**
     * 清单支付信息录入，导入Excel
     *
     * @param requestImportPayListDto 入参Dto
     * @return list<prpPaymainDto> 从文件中读取的数据
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    public List<PrpPayMainDto> importExcel(RequestImportPayListDto requestImportPayListDto) throws Exception {
        String fileId = requestImportPayListDto.getFileId();
        if (StringUtils.isEmpty(fileId)) {
            throw new DataVerifyException("fileId不能为空！");
        }
        List<PrpPayMainDto> prpPayMainDtos;
        File file = null;
        try {
            // 使用fileId下载文件
            file = this.getFileUtil().downloadExcel(fileServiceUrl, exportExcelType, fileId);
            ExcelUtil excelUtil = ExcelUtil.initImport();
            PayInfoExcelRead payInfoExcelRead = new PayInfoExcelRead();
            excelUtil.setStartRowNumber(3).readExcel(file, payInfoExcelRead);
            prpPayMainDtos = payInfoExcelRead.getPrpPayMainDtos();
        } catch (Exception e) {
            throw new BusinessException("请检查清单文件内容和格式是否正确！");
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        // 调用保存服务保存数据
        RequestSavePayInfoDto requestSavePayInfoDto = new RequestSavePayInfoDto();
        requestSavePayInfoDto.setPrpPayMainDtos(prpPayMainDtos);
        requestSavePayInfoDto.setEndorseNo(requestImportPayListDto.getEndorseNo());
        requestSavePayInfoDto.setCostType(requestImportPayListDto.getCostType());
        requestSavePayInfoDto.setLoginComCode(requestImportPayListDto.getLoginComCode());
        this.saveListPayInfo(requestSavePayInfoDto, requestImportPayListDto.getModify());
        return prpPayMainDtos;
    }

    /**
     * 根据领款人类型，证件号码，批单号集合，同步账户信息
     *
     * @param endorseNos   批单号集合
     * @param receiverType 领款人类型
     * @param certifyNo    证件号码
     * @param certiType    证件类型
     * @return 账户信息
     * @author: 何伟东
     * @date: 2018/1/16 14:25
     */
    @Override
    public List<SynchronizeInfoDto> synchronizeAccount(List<String> endorseNos, String receiverType, String certiType, String certifyNo) {
        if (endorseNos == null || endorseNos.size() < 1) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        if (StringUtils.isEmpty(receiverType)) {
            throw new DataVerifyException("领款人类型不能为空！");
        }
        if (StringUtils.isEmpty(certiType)) {
            throw new DataVerifyException("证件类型不能为空！");
        }
        if (StringUtils.isEmpty(certifyNo)) {
            throw new DataVerifyException("证件号码不能为空！");
        }
        String insuredFlag;
        switch (receiverType) {
            // 投保人类型
            case "t01":
                insuredFlag = "2";
                break;
            // 被保险人类型
            case "t02":
                insuredFlag = "1";
                break;
            default:
                throw new DataVerifyException("农险仅能同步投保人/被保险人类型！");
        }
        StringBuilder dataSql = new StringBuilder("select pi from PrpPhead ph,PrpCPinsured pi where " +
                "ph.endorseNo in(:endorseNos) " +
                "and ph.policyNo=pi.policyNo " +
                "and pi.insuredFlag=:insuredFlag " +
                "and pi.identifyType=:identifyType " +
                "and pi.identifyNumber=:identifyNumber");
        Query query = entityManager.createQuery(dataSql.toString());
        query.setParameter("endorseNos", endorseNos);
        query.setParameter("insuredFlag", insuredFlag);
        query.setParameter("identifyType", certiType);
        query.setParameter("identifyNumber", certifyNo);
        List<PrpCPinsured> prpCPinsureds = query.getResultList();
        if (prpCPinsureds == null || prpCPinsureds.size() < 1) {
            throw new DataVerifyException("没有查询到符合条件的领款人信息！");
        }
        List<SynchronizeInfoDto> synchronizeInfoDtos = new ArrayList<>();
        this.convertCollection(prpCPinsureds, synchronizeInfoDtos, SynchronizeInfoDto.class);
        return synchronizeInfoDtos;
    }

    /**
     * 下载批改变化量清单excel文件
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    public Map<String, String> exportEndorseList(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        String shortLink = null;
        String excelName = "批单" + endorseNo + "批改清单";
        String sheetName = "批量变化量清单";
        int lastRow = 1;
        int lastCol = 31;
        Map<List, Class> dataListMap = this.queryEndorseInfo(endorseNo);
        if (!dataListMap.isEmpty()) {
            List dataList = dataListMap.keySet().iterator().next();
            Class aClass = dataListMap.get(dataList);
            shortLink = exportExcel(dataList, aClass, excelName, sheetName, lastRow, lastCol);
        }
        Map<String, String> returnMap = new HashMap<>(1);
        returnMap.put("shortLink", shortLink);
        return returnMap;
    }

    /**
     * 查询批改的变化量信息
     *
     * @param endorseNo 批单号码
     * @return key-查询到的数据集合，value-数据集合的class
     * @date: 2018/05/03 18:07
     * @author: 何伟东
     */
    private Map<List, Class> queryEndorseInfo(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        inint();
        PrpPmain prpPmain = prpPmainDao.queryAllByEndorseNo(endorseNo);
        String policyNo = prpPmain.getPolicyNo();
        String riskCode = prpPmain.getRiskCode();
        Map<String, String> endorType = new HashMap<>(3);
        endorType.put("I", "新增");
        endorType.put("D", "删除");
        endorType.put("U", "修改");
        Map<List, Class> retrunMap = new HashMap<>();
        if (plantingRisk.contains(riskCode)) {
            List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtos = this.getExportPlantingList(riskCode, policyNo, endorseNo, endorType);
            retrunMap.put(plantingEndorChgDetailDtos, PlantingEndorChgDetailDto.class);
        } else if (planting31Risk.contains(riskCode)) {
            List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtos = this.getExportPlanting31List(riskCode, policyNo, endorseNo, endorType);
            retrunMap.put(planting31EndorChgDetailDtos, Planting31EndorChgDetailDto.class);
        } else if (herdRisk.contains(riskCode)) {
            List<HerdEndorChgDetailDto> herdEndorChgDetailDtos = this.getExportHerdList(riskCode, policyNo, endorseNo, endorType);
            retrunMap.put(herdEndorChgDetailDtos, HerdEndorChgDetailDto.class);
        } else if (nyxRisk.contains(riskCode)) {
            List<NyxEndorChgDetailDto> nyxEndorChgDetailDtos = this.getExportNyxList(riskCode, policyNo, endorseNo, endorType);
            retrunMap.put(nyxEndorChgDetailDtos, NyxEndorChgDetailDto.class);
        }
        return retrunMap;
    }


    /**
     * 获取planting表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param endorType 批改类型
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<PlantingEndorChgDetailDto> getExportPlantingList(String riskCode, String policyNo, String endorseNo, Map<String, String> endorType) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtos = plantingEndorChgDetailApi.queryByEndorseNo(param);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < plantingEndorChgDetailDtos.size(); i++) {
            PlantingEndorChgDetailDto plantingEndorChgDetailDto = plantingEndorChgDetailDtos.get(i);
            plantingEndorChgDetailDto.setSerialNo(i + 1);
            plantingEndorChgDetailDto.setPolicyNo(policyNo);
            // 批改类型转译
            String flag = plantingEndorChgDetailDto.getFlag();
            flag = flag.contains("U") ? "U" : flag;
            plantingEndorChgDetailDto.setFlag(endorType.get(flag));
            // 险别代码
            String kindCode = plantingEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = plantingEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = plantingEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        plantingEndorChgDetailDtos.forEach(plantingEndorChgDetailDto -> {
            String kindCode = plantingEndorChgDetailDto.getKindCode();
            plantingEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = plantingEndorChgDetailDto.getItemCode();
            plantingEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
            String shortRateFlag = plantingEndorChgDetailDto.getShortRateFlag();
            plantingEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
            Date startDate = plantingEndorChgDetailDto.getStartDate();
            plantingEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
            Date endDate = plantingEndorChgDetailDto.getEndDate();
            plantingEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return plantingEndorChgDetailDtos;
    }

    /**
     * 获取planting31表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param endorType 批改类型
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<Planting31EndorChgDetailDto> getExportPlanting31List(String riskCode, String policyNo, String endorseNo, Map<String, String> endorType) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtos = planting31EndorChgDetailApi.queryByEndorseNo(param);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < planting31EndorChgDetailDtos.size(); i++) {
            Planting31EndorChgDetailDto planting31EndorChgDetailDto = planting31EndorChgDetailDtos.get(i);
            planting31EndorChgDetailDto.setSerialNo(i + 1);
            planting31EndorChgDetailDto.setPolicyNo(policyNo);
            // 批改类型转译
            String flag = planting31EndorChgDetailDto.getFlag();
            flag = flag.contains("U") ? "U" : flag;
            planting31EndorChgDetailDto.setFlag(endorType.get(flag));
            // 险别代码
            String kindCode = planting31EndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = planting31EndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = planting31EndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        planting31EndorChgDetailDtos.forEach(planting31EndorChgDetailDto -> {
            String kindCode = planting31EndorChgDetailDto.getKindCode();
            planting31EndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = planting31EndorChgDetailDto.getItemCode();
            planting31EndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
            String shortRateFlag = planting31EndorChgDetailDto.getShortRateFlag();
            planting31EndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
            Date startDate = planting31EndorChgDetailDto.getStartDate();
            planting31EndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
            Date endDate = planting31EndorChgDetailDto.getEndDate();
            planting31EndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return planting31EndorChgDetailDtos;
    }

    /**
     * 获取herd表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param endorType 批改类型
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<HerdEndorChgDetailDto> getExportHerdList(String riskCode, String policyNo, String endorseNo, Map<String, String> endorType) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<HerdEndorChgDetailDto> herdEndorChgDetailDtos = herdEndorChgDetailApi.queryByEndorseNo(param);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < herdEndorChgDetailDtos.size(); i++) {
            HerdEndorChgDetailDto herdEndorChgDetailDto = herdEndorChgDetailDtos.get(i);
            herdEndorChgDetailDto.setSerialNo(i + 1);
            herdEndorChgDetailDto.setPolicyNo(policyNo);
            // 批改类型转译
            String flag = herdEndorChgDetailDto.getFlag();
            flag = flag.contains("U") ? "U" : flag;
            herdEndorChgDetailDto.setFlag(endorType.get(flag));
            // 险别代码
            String kindCode = herdEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = herdEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = herdEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        herdEndorChgDetailDtos.forEach(herdEndorChgDetailDto -> {
            String kindCode = herdEndorChgDetailDto.getKindCode();
            herdEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = herdEndorChgDetailDto.getItemCode();
            herdEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
            String shortRateFlag = herdEndorChgDetailDto.getShortRateFlag();
            herdEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
            Date startDate = herdEndorChgDetailDto.getStartDate();
            herdEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
            Date endDate = herdEndorChgDetailDto.getEndDate();
            herdEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return herdEndorChgDetailDtos;
    }

    /**
     * 获取nyx表的数据
     *
     * @param riskCode  险种代码
     * @param policyNo  保单号
     * @param endorseNo 批单号
     * @param endorType 批改类型
     * @return List<PlantingEndorChgDetailDto>
     * @date: 2018/4/13 17:01
     * @author: 何伟东
     */
    private List<NyxEndorChgDetailDto> getExportNyxList(String riskCode, String policyNo, String endorseNo, Map<String, String> endorType) throws Exception {
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<NyxEndorChgDetailDto> nyxEndorChgDetailDtos = nyxEndorChgDetailApi.queryByEndorseNo(param);
        List<String> kindCodes = new ArrayList<>();
        List<String> itemCodes = new ArrayList<>();
        List<String> shortRateFlags = new ArrayList<>();
        for (int i = 0; i < nyxEndorChgDetailDtos.size(); i++) {
            NyxEndorChgDetailDto nyxEndorChgDetailDto = nyxEndorChgDetailDtos.get(i);
            nyxEndorChgDetailDto.setSerialNo(i + 1);
            nyxEndorChgDetailDto.setPolicyNo(policyNo);
            // 批改类型转译
            String flag = nyxEndorChgDetailDto.getFlag();
            flag = flag.contains("U") ? "U" : flag;
            nyxEndorChgDetailDto.setFlag(endorType.get(flag));
            // 险别代码
            String kindCode = nyxEndorChgDetailDto.getKindCode();
            if (kindCodes.indexOf(kindCode) < 0) {
                kindCodes.add(kindCode);
            }
            // 标的代吗
            String itemCode = nyxEndorChgDetailDto.getItemCode();
            if (itemCodes.indexOf(itemCode) < 0) {
                itemCodes.add(itemCode);
            }
            // 短期费率方式
            String shortRateFlag = nyxEndorChgDetailDto.getShortRateFlag();
            if (shortRateFlags.indexOf(shortRateFlag) < 0) {
                shortRateFlags.add(shortRateFlag);
            }
        }
        Map<String, String> shortRateNames = prpDcodeApi.queryShortRateFlagByCodes(shortRateFlags);
        Map<String, Object> queryKind = new HashMap<>(2);
        queryKind.put("riskCode", riskCode);
        queryKind.put("kindCodes", kindCodes);
        Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
        Map<String, Object> queryItem = new HashMap<>(2);
        queryItem.put("riskCode", riskCode);
        queryItem.put("itemCodes", itemCodes);
        Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy年MM月dd日");
        nyxEndorChgDetailDtos.forEach(nyxEndorChgDetailDto -> {
            String kindCode = nyxEndorChgDetailDto.getKindCode();
            nyxEndorChgDetailDto.setKindName(kindCode + "-" + kindNames.get(kindCode));
            String itemCode = nyxEndorChgDetailDto.getItemCode();
            nyxEndorChgDetailDto.setItemName(itemCode + "-" + itemName.get(itemCode));
            String shortRateFlag = nyxEndorChgDetailDto.getShortRateFlag();
            nyxEndorChgDetailDto.setShortRateFlag(shortRateNames.get(shortRateFlag));
            Date startDate = nyxEndorChgDetailDto.getStartDate();
            nyxEndorChgDetailDto.setStartDateStr(dateFormater.format(startDate));
            Date endDate = nyxEndorChgDetailDto.getEndDate();
            nyxEndorChgDetailDto.setEndDateStr(dateFormater.format(endDate));
        });
        return nyxEndorChgDetailDtos;
    }

    /**
     * 查询批单的支付信息类型
     *
     * @param endorseNo 批单号码
     * @param costType  批单号码
     * @return payType-文件下载短链接
     * @author: 何伟东
     * @date: 2018/2/8 10:38
     */
    @Override
    public String queryPayInfoType(String endorseNo, String costType) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        if (StringUtils.isEmpty(costType)) {
            throw new DataVerifyException("费用类型不能为空！");
        }
        PrpPaySub prpPaySub = prpPaySubDao.findByEndorseNoAndCostType(endorseNo, costType);
        if (prpPaySub == null) {
            throw new DataVerifyException("未查询到该批单费用类型对应的支付信息！");
        }
        return prpPaySub.getPayType();
    }

    /**
     * 下载支付清单的模板文件
     *
     * @param endorseNo 批单号码
     * @param costType  费用类型
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2018/05/03 17:14
     */
    @Override
    public String downloadPayListTempLate(String endorseNo, String costType) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        if (StringUtils.isEmpty(costType)) {
            throw new DataVerifyException("费用类型不能为空！");
        }
        Map<List, Class> dataListMap = this.queryEndorseInfo(endorseNo);
        String shortLink = "";
        if (!dataListMap.isEmpty()) {
            String costName = this.getCostTypeToColumnName(costType);
            List<PrpPayMainDto> prpPayMainDtos = new ArrayList<>();
            List dataList = dataListMap.keySet().iterator().next();
            Class aClass = dataListMap.get(dataList);
            Field endorseNoField = aClass.getDeclaredField("endorseNo");
            endorseNoField.setAccessible(true);
            Field policyNoField = aClass.getDeclaredField("policyNo");
            policyNoField.setAccessible(true);
            Field fCodeField = aClass.getDeclaredField("fCode");
            fCodeField.setAccessible(true);
            Field fNameField = aClass.getDeclaredField("fName");
            fNameField.setAccessible(true);
            Field costNameField = aClass.getDeclaredField(costName);
            costNameField.setAccessible(true);

            for (int i = 0; i < dataList.size(); i++) {
                Object o = dataList.get(i);
                PrpPayMainDto prpPayMainDto = new PrpPayMainDto();
                String _endorseNo = (String) endorseNoField.get(o);
                String policyNo = (String) policyNoField.get(o);
                String fCode = (String) fCodeField.get(o);
                String fName = (String) fNameField.get(o);
                Double chgPremium = (Double) costNameField.get(o);
                prpPayMainDto.setSerialNo(i + 1);
                prpPayMainDto.setEndorseNo(_endorseNo);
                prpPayMainDto.setPolicyNo(policyNo);
                prpPayMainDto.setfCode(fCode);
                prpPayMainDto.setfName(fName);
                prpPayMainDto.setChgPremium(chgPremium * -1);
                prpPayMainDtos.add(prpPayMainDto);
            }
            String excelName = "批单" + endorseNo + "(" + getCostName(costType) + ")支付清单";
            String titleName = "支付清单";
            shortLink = this.exportExcel(prpPayMainDtos, PrpPayMainDto.class, excelName, titleName, 1, 17);
        }
        return shortLink;
    }

    /**
     * 查询开户银行信息
     *
     * @param bank bank
     * @return 开户银行信息
     * @author: 何伟东
     * @date: 2018-05-15 11:32
     */
    @Override
    public List<PrpDBankBranchDto> getBankInfo(String bank) throws Exception {

        StringBuilder dataSql = new StringBuilder("select * from PrpDBankBranch");

        if (StringUtils.isNotEmpty(bank)) {
            dataSql.append(" where bank_name like :bank or bank_number like :bank");
        }
        Query dataQuery = entityManager.createNativeQuery(dataSql.toString());
        if (StringUtils.isNotEmpty(bank)) {
            dataQuery.setParameter("bank", "%" + bank + "%");
        }
        dataQuery.setMaxResults(100);
        List<Object[]> resultList = dataQuery.getResultList();
        List<PrpDBankBranchDto> prpDBankBranchDtos = new ArrayList<>();

        resultList.forEach(objects -> {
            PrpDBankBranchDto prpDBankBranchDto = new PrpDBankBranchDto();
            prpDBankBranchDto.setBankNumber((String) objects[0]);
            prpDBankBranchDto.setBankName((String) objects[1]);
            prpDBankBranchDto.setBankTypeCode((String) objects[2]);
            prpDBankBranchDto.setBankTypeName((String) objects[3]);
            prpDBankBranchDto.setBankClearCode((String) objects[4]);
            prpDBankBranchDto.setCpcc((String) objects[5]);
            prpDBankBranchDto.setProvCode((String) objects[6]);
            prpDBankBranchDto.setBankClearName((String) objects[7]);
            prpDBankBranchDto.setProvName((String) objects[8]);
            prpDBankBranchDto.setCreatedBy((String) objects[9]);
            prpDBankBranchDto.setCreationDate((String) objects[10]);
            prpDBankBranchDto.setLastUpdateBy((String) objects[11]);
            prpDBankBranchDto.setLastUpdateDate((String) objects[12]);
            prpDBankBranchDto.setBelongBankValue((String) objects[13]);
            prpDBankBranchDto.setBelongBankName((String) objects[14]);
            prpDBankBranchDto.setId((String) objects[15]);
            prpDBankBranchDto.setCityCode((String) objects[16]);
            prpDBankBranchDto.setCityName((String) objects[17]);
            prpDBankBranchDto.setHeadBankFlag((String) objects[18]);
            prpDBankBranchDto.setDetailBankCode((String) objects[19]);
            prpDBankBranchDto.setDetalBankCode((String) objects[20]);
            prpDBankBranchDto.setDetalBankName((String) objects[21]);
            prpDBankBranchDto.setRoutingNumber((String) objects[22]);
            prpDBankBranchDto.setCountry((String) objects[23]);
            prpDBankBranchDtos.add(prpDBankBranchDto);
        });
        System.out.println(resultList);

        return prpDBankBranchDtos;
    }

    /**
     * 导出批改后清单excel文件(已过时)
     *
     * @param endorseNo 批单号码
     * @return shortLink-文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 10:38
     */
    @Override
    @Deprecated
    public String exportCPEndorseList(String endorseNo) throws Exception {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        Map<String, String> param = new HashMap<>(1);
        param.put("endorseNo", endorseNo);
        List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtos = endorseListApi.queryNyxCpEndorChgDetail(param);
        String shortLink = null;
        if (nyxCpEndorChgDetailDtos != null && nyxCpEndorChgDetailDtos.size() > 0) {
            List<CPEndorseListToExcelDto> cpEndorseListToExcelDtos = new ArrayList<>();
            this.convertCollection(nyxCpEndorChgDetailDtos, cpEndorseListToExcelDtos, CPEndorseListToExcelDto.class);
            List<String> kindCodes = new ArrayList<>();
            List<String> itemCodes = new ArrayList<>();
            int serialNo = 1;
            for (CPEndorseListToExcelDto cpEndorseListToExcelDto : cpEndorseListToExcelDtos) {
                cpEndorseListToExcelDto.setSerialNo(serialNo++);
                String kindCode = cpEndorseListToExcelDto.getKindCode();
                if (kindCodes.indexOf(kindCode) < 0) {
                    kindCodes.add(kindCode);
                }
                String itemCode = cpEndorseListToExcelDto.getItemCode();
                if (itemCodes.indexOf(itemCode) < 0) {
                    itemCodes.add(itemCode);
                }
            }
            String riskCode = nyxCpEndorChgDetailDtos.get(0).getRiskCode();
            Map<String, Object> queryKind = new HashMap<>(2);
            queryKind.put("riskCode", riskCode);
            queryKind.put("kindCodes", kindCodes);
            Map<String, String> kindNames = prpDkindApi.queryByKindCodes(queryKind);
            Map<String, Object> queryItem = new HashMap<>(2);
            queryItem.put("riskCode", riskCode);
            queryItem.put("itemCodes", itemCodes);
            Map<String, String> itemName = prpDitemApi.queryByItemCodes(queryItem);
            cpEndorseListToExcelDtos.forEach(cpEndorseListToExcelDto -> {
                String kindCode = cpEndorseListToExcelDto.getKindCode();
                cpEndorseListToExcelDto.setKindName(kindNames.get(kindCode));
                String itemCode = cpEndorseListToExcelDto.getItemCode();
                cpEndorseListToExcelDto.setItemName(itemName.get(itemCode));
            });
            String excelName = "批单" + endorseNo + "批改后清单";
            shortLink = this.exportExcel(cpEndorseListToExcelDtos, CPEndorseListToExcelDto.class, excelName, excelName, 1, 32);
        }
        return shortLink;
    }

    /**
     * 修改支付信息时根据支付号码生成轨迹信息
     *
     * @param payNo 支付号
     * @author: 何伟东
     * @date: 2017/12/26 18:17
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveHisInfo(String payNo) {
        // 得到修改前的数据，保存到轨迹表
        List<PrpPayMain> prpPayMains = prpPayMainDao.findByPayNo(payNo);
        // 获取可用的序列号
        Integer maxSerialNo = this.getSerialNo(payNo);
        List<PrpPayMainHis> prpPayMainHiss = new ArrayList<>();
        this.convertCollection(prpPayMains, prpPayMainHiss, PrpPayMainHis.class);
        for (PrpPayMainHis prpPayMainHis : prpPayMainHiss) {
            prpPayMainHis.setSerialNo(maxSerialNo);
        }
        // 保存轨迹信息
        prpPayMainHisDao.save(prpPayMainHiss);
    }

    /**
     * 导出excel
     *
     * @param dataList 数据集合
     * @param aClass   存放数据的dto
     * @return shortLink
     * @date: 2018/4/13 16:43
     * @author: 何伟东
     */
    private <T> String exportExcel(List<T> dataList, Class<T> aClass, String excelName, String sheetName, int lastRow, int lastCol) throws Exception {
        File file = null;
        String shortLink;
        try {
            // 生成Excel文件到本地并获取改文件的File对象
            file = this.getQuicklyExportExcel().quicklyExport(exportExcelType, excelName, sheetName, excelName, dataList, lastRow, lastCol, aClass);
            // 将文件上传到fileserver服务器并生成文件下载的短链接地址
            shortLink = this.getFileUtil().setValidWhenLong(3600000).uploadFile(fileServiceUrl, file, SinoRequestContext.getCurrentContext().getUserCode(), "agri/tempfile", "agriprpall_paymanage");
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLink;
    }

    /**
     * 查询批单的险种代码
     *
     * @param endorseNo 批单号
     * @return 险种代码
     * @date: 2018/4/13 14:46
     * @author: 何伟东
     */
    private String getRiskCode(String endorseNo) {
        PrpPmain prpPmain = prpPmainDao.findOne(new PrpPmainKey(endorseNo));
        if (prpPmain == null) {
            throw new DataVerifyException("未查询到批单信息！");
        }
        return prpPmain.getRiskCode();
    }


    /**
     * 根据费用类型代码获取费用类型名称
     *
     * @param costType 费用类型代码
     * @return 费用类型名称
     * @author: 何伟东
     * @date: 2018/1/18 17:19
     */
    private String getCostName(String costType) {
        // 查询费用类型的中文名称
        Map<String, String> costTypeParam = new HashMap<>(1);
        costTypeParam.put("costType", costType);
        Map<String, String> costTypeName = prpDcodeApi.queryCostTypeByCode(costTypeParam);
        return costTypeName.get("costTypeName");
    }

    /**
     * 根据费用类型查询该类型对应的字段名称
     *
     * @param costType 费用类型
     * @return 字段名称
     * @author: 何伟东
     * @date: 2018/1/18 16:11
     */
    private String getCostTypeToColumnName(String costType) {
        String column;
        PrpDcodeDto prpDcodeDto = prpDcodeApi.queryByPK("CostType", costType);
        if (prpDcodeDto != null) {
            column = prpDcodeDto.getOldCodeCode();
        } else {
            throw new DataVerifyException("费用类型不不正确！");
        }
        return column;
    }

    /**
     * 获取支付信息轨迹表中可用的序号
     *
     * @param payNo 支付号
     * @return 可用的序号
     * @author: 何伟东
     * @date: 2017/12/26 17:16
     */
    private Integer getSerialNo(String payNo) {
        Integer maxSerialNo = prpPayMainHisDao.queryMaxSerialNo(payNo);
        maxSerialNo = (maxSerialNo == null ? 0 : maxSerialNo) + 1;
        return maxSerialNo;
    }

    /**
     * 根据是否修改操作获取支付号，修改时获取原支付号，新增时创建一个支付号
     *
     * @param endorseNo    批单号码
     * @param isModify     true-支付信息录入查询;false-支付信息修改查询
     * @param loginComCode 登录机构
     * @return 支付号
     * @author: 何伟东
     * @date: 2017/12/26 18:05
     */
    private String getPayNo(String endorseNo, String costType, String loginComCode, boolean isModify) throws Exception {
        String payNo;
        if (isModify) {
            PrpPaySub prpPaySub = prpPaySubDao.findByEndorseNoAndCostType(endorseNo, costType);
            payNo = prpPaySub.getPayNo();
        } else {
            BillNoDto billNoDto = new BillNoDto();
            billNoDto.setTableName("prppaymain");
            billNoDto.setRiskCode("");
            billNoDto.setiComCode(loginComCode);
            Map<String, String> billNo = billNoApi.getBillNo(billNoDto);
            payNo = billNo.get("billNo");
        }
        return payNo;
    }

    /**
     * 校验支付信息主表数据否正确
     *
     * @param prpPayMainDtos 支付信息主表数据
     * @return
     * @date: 2018/4/14 17:49
     * @author: 何伟东
     */
    private void checkPrpPayMainInfo(List<PrpPayMainDto> prpPayMainDtos) {
        Map<String, String> reqParam = new HashMap();
        // 领款人类型
        reqParam.put("codeType", "ReceiverType");
        List<PrpDcodeDto> receiverType = prpDcodeApi.queryCodeInfoByTypeAndCode(reqParam);
        Map<String, List<PrpDcodeDto>> receiverTypeName = receiverType.stream().collect(Collectors.groupingBy(PrpDcodeDto::getCodeCName));
        // 证件类型
        reqParam.put("codeType", "CertiType");
        List<PrpDcodeDto> certiType = prpDcodeApi.queryCodeInfoByTypeAndCode(reqParam);
        Map<String, List<PrpDcodeDto>> certiTypeName = certiType.stream().collect(Collectors.groupingBy(PrpDcodeDto::getCodeCName));
        // 账号属性
        reqParam.put("codeType", "AccountType");
        List<PrpDcodeDto> accountType = prpDcodeApi.queryCodeInfoByTypeAndCode(reqParam);
        Map<String, List<PrpDcodeDto>> accountTypeName = accountType.stream().collect(Collectors.groupingBy(PrpDcodeDto::getCodeCName));
        // 账号类型
        reqParam.put("codeType", "AccountFlag");
        List<PrpDcodeDto> accountFlag = prpDcodeApi.queryCodeInfoByTypeAndCode(reqParam);
        Map<String, List<PrpDcodeDto>> accountFlagName = accountFlag.stream().collect(Collectors.groupingBy(PrpDcodeDto::getCodeCName));
        prpPayMainDtos.forEach(prpPayMainDto -> {
            List<PrpDcodeDto> _receiverType = receiverTypeName.get(prpPayMainDto.getReceiverType());
            if (_receiverType != null && _receiverType.size() > 0) {
                prpPayMainDto.setReceiverType(_receiverType.get(0).getCodeCode());
            } else {
                throw new DataVerifyException("领款人类型只能填写：" + getCodeName(receiverType));
            }
            List<PrpDcodeDto> _certiType = certiTypeName.get(prpPayMainDto.getCertifyType());
            if (_certiType != null && _certiType.size() > 0) {
                prpPayMainDto.setCertifyType(_certiType.get(0).getCodeCode());
            } else {
                throw new DataVerifyException("证件类型只能填写：" + getCodeName(certiType));
            }
            List<PrpDcodeDto> _accountType = accountTypeName.get(prpPayMainDto.getAccountType());
            if (_accountType != null && _accountType.size() > 0) {
                prpPayMainDto.setAccountType(_accountType.get(0).getCodeCode());
            } else {
                throw new DataVerifyException("账号属性只能填写：" + getCodeName(accountType));
            }
            List<PrpDcodeDto> _accountFlag = accountFlagName.get(prpPayMainDto.getAccountFlag());
            if (_accountFlag != null && _accountFlag.size() > 0) {
                prpPayMainDto.setAccountFlag(_accountFlag.get(0).getCodeCode());
            } else {
                throw new DataVerifyException("账号类型只能填写：" + getCodeName(accountFlag));
            }
        });
    }


    /**
     * 查询批改的变化量信息
     *
     * @param prpDcodeDtos PrpDcode数据集合
     * @return list 代码的所有中文名称
     * @date: 2018/05/03 18:07
     * @author: 何伟东
     */
    private List<String> getCodeName(List<PrpDcodeDto> prpDcodeDtos) {
        List<String> codeName = new ArrayList<>();
        prpDcodeDtos.forEach(prpDcodeDto -> codeName.add(prpDcodeDto.getCodeCName()));
        return codeName;
    }

    /**
     * 获取快速导出excel实例
     *
     * @return quicklyExportExcel
     * @author: 何伟东
     * @date: 2018/1/11 11:06
     */
    private QuicklyExportExcel getQuicklyExportExcel() {
        if (quicklyExportExcel == null) {
            quicklyExportExcel = new QuicklyExportExcel();
        }
        return quicklyExportExcel;
    }

    /**
     * 获取文件操作类实例
     *
     * @return fileUtil
     * @author: 何伟东
     * @date: 2018/1/11 11:06
     */
    private FileUtil getFileUtil() {
        if (fileUtil == null) {
            fileUtil = new FileUtil();
        }
        return fileUtil;
    }
}