package com.sinosoft.txnlist.core.gisinsurelist.service.impl;

import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.agri.core.gycore.dto.UserRegion;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.JdbcUtils;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.gisinsurelist.constant.CheckDataConstant;
import com.sinosoft.txnlist.core.gisinsurelist.dao.*;
import com.sinosoft.txnlist.core.gisinsurelist.entity.*;
import com.sinosoft.txnlist.core.gisinsurelist.service.GisInsureListService;
import com.sinosoft.txnlist.core.insuremainlist.dao.CMTManFieldListDao;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMTManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.service.InsureMainListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 金禾中间表数据操作类ServiceImpl
 *
 * @Author: 何伟东
 * @Date: 2018/1/15 16:46
 */
@Service
public class GisInsureListServiceImpl extends BaseCustomServiceImpl implements GisInsureListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GisInsureListServiceImpl.class);

    @Autowired
    private GisInsureMainListDao gisInsureMainListDao;
    @Autowired
    private InsureMainListDao insureMainListDao;
    @Autowired
    private GisFarmerItemDao gisFarmerItemDao;
    @Autowired
    private GisHerdFieldListDao gisHerdFieldListDao;
    @Autowired
    private NyxInsuranceListService NyxInsuranceListService;
    @Autowired
    private CMTManFieldListDao cmtManFieldListDao;
    @Autowired
    private GisItemListDao gisItemListDao;
    @Autowired
    private GisFarmerListDao gisFarmerListDao;
    @Autowired
    private HerdInsuranceListDao herdInsuranceListDao;
    @Autowired
    private InsureMainListService insureMainListService;
    @Autowired
    private PlantingInsuranceListService plantingInsuranceListService;
    @Autowired
    private Planting31InsuranceListService planting31InsuranceListService;
    @Autowired
    private PlantingInsuranceListDao plantingInsuranceListDao;
    @Autowired
    private Planting31InsuranceListDao planting31InsuranceListDao;
    @Autowired
    private HerdInsuranceListService herdInsuranceListService;
    @Autowired
    private MiddleHerdInsuranceListService middleHerdInsuranceListService;
    @Autowired
    private MiddleHerdInsuranceListDao middleHerdInsuranceListDao;
    @Autowired
    private NyxInsuranceListDao nyxInsuranceListDao;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDitemApi prpDitemApi;

    @Value("${exportExcelType}")
    private String exportExcelType;
    @Value("${fileService.url}")
    private String fileServiceUrl;

    @Value("${webservice.gycoreService.url}")
    private String gycoreService;

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${spring.datasource.url}")
    private String DATASOURCE_URL;

    @Value("${spring.datasource.username}")
    private String DATASOURCE_USERNAME;

    @Value("${spring.datasource.password}")
    private String DATASOURCE_PASSWORD;

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER_CLASS_NAME;

    private static JdbcUtils jdbcUtils;

    /**
     * 清单保存次数，
     */
    private final String saveDetailedListTimes = "1";

    /**
     * 查询GisFarmerItem表
     *
     * @param insureListCode 清单号
     * @param serialNo       序列号
     * @param itemListCodes  标的清单号
     * @return gisFarmerItemInfoDtoList
     * @throws Exception
     * @Author: 李冬松
     */
    @Override
    public Map<String, List<GisFarmerItemForPremiumDto>> queryGisFarmerItemInfo(String insureListCode, String serialNo, List<String> itemListCodes) throws Exception {
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单号不可为空！");
        }

        // 关联查询农户标的关联信息
        StringBuilder dataSql = new StringBuilder("select gfi.*, gf.fIdCard, gf.fName,gf.fPhone,gf.bankName,gf.accountName,gf.accountNo,gf.insureArea, gi.itemType, gi.itemName " +
                "from GisFarmerItem gfi, GisFarmerList gf, GisItemList gi " +
                "where gfi.insureListCode = :insureListCode and gfi.serialNo = :serialNo " +
                "and gfi.itemListCode in (:itemListCode) and gfi.insureListCode = gf.insureListCode " +
                "and gfi.insureListCode = gi.insureListCode and gfi.serialNo = gf.serialNo and gfi.serialNo = gi.serialNo " +
                "and gfi.fCode = gf.fCode and gfi.itemCode = gi.itemCode");
        Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), GisFarmerItemInfo.class);
        dataQuery.setParameter("insureListCode", insureListCode);
        dataQuery.setParameter("serialNo", serialNo);
        dataQuery.setParameter("itemListCode", itemListCodes);
        List<GisFarmerItemInfo> gisFarmerItemList = dataQuery.getResultList();
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList = new ArrayList<>();
        convertCollection(gisFarmerItemList, gisFarmerItemForPremiumDtoList, GisFarmerItemForPremiumDto.class);
        // 将查询得到的结果按照itemListCode分组
        Map<String, List<GisFarmerItemForPremiumDto>> groupByItemListCodeMap = gisFarmerItemForPremiumDtoList.stream().collect(Collectors.groupingBy(GisFarmerItemForPremiumDto::getItemListCode));
        return groupByItemListCodeMap;
    }

    /**
     * 根据清单号、序列号、标的代码查询农户与耳标号信息
     *
     * @param insureListCode 清单号
     * @param serialNo       序列号
     * @param itemListCodes  标的代码集合
     * @return map集合，key是标的清单号，value值是农户信息与耳标号信息Dto
     * @throws Exception
     * @author: 田健
     * @date: 2018/3/1 10:31
     */
    @Override
    public Map<String, List<HerdFarmerItemDto>> queryFarmerItemAndHerdFieldListInfo(String insureListCode, String serialNo, List<String> itemListCodes) throws Exception {
        FarmerItemAndHerdFieldListTempDto farmerItemAndHerdFieldListTempDto = null;
        List<HerdFarmerItemDto> herdFarmerItemDtoList = null;
        Map<String, List<HerdFarmerItemDto>> herdFarmerItemMap = new HashMap<>();
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单号不可为空！");
        }
        int serial = Integer.parseInt(serialNo);
        Map<String, Object> map = null;
        //循环标的清单号，方便放入map集合中
        for (int i = 0; i < itemListCodes.size(); i++) {
            map = new HashMap<>();
            herdFarmerItemDtoList = new ArrayList<>();
            StringBuilder strWhere = new StringBuilder("  select rownum,a.* from ( ");
            strWhere.append("select t.earLabel,t.insureListCode,t.itemCode,i.fCode,t.serialNo," +
                    "t.breedingAreaCode,t.breedingAreaName,t.aniMalage,t.species,i.itemListCode,i.insureCount,j.fidcard,j.fphone,j.bankname,j.banknumber,j.fname " +
                    "  from GisHerdFieldList t" +
                    "  left join GisFarmerItem i" +
                    "    on t.insureListCode = i.insureListCode" +
                    "   and t.fCode = i.fCode" +
                    "   and t.serialNo = i.serialNo" +
                    "   left join GisFarmerList j " +
                    "   on t.insureListCode = j.insureListCode" +
                    "   and t.serialNo = j.serialNo" +
                    "   and t.fCode = j.fCode " +
                    "   union all " +
                    " select '' as earLabel,i.insureListCode,i.itemCode,i.fCode,i.serialNo,'' as breedingAreaCode," +
                    "'' as breedingAreaName,0 as aniMalage,'' as species,i.itemListCode,i.insureCount,j.fidcard,j.fphone,j.bankname,j.banknumber,j.fname " +
                    "   from GisFarmerItem i" +
                    "   left join GisFarmerList j " +
                    "   on i.insureListCode = j.insureListCode" +
                    "   and i.serialNo = j.serialNo" +
                    "   and i.fCode = j.fCode " +
                    "  where not exists (select 1" +
                    "           from GisHerdFieldList t" +
                    "          where t.insureListCode = i.insureListCode " +
                    "            and t.fCode = i.fCode" +
                    "            and t.serialNo = i.serialNo)) a where ");
            strWhere.append(" a.insureListCode=:insureListCode ");
            map.put("insureListCode", insureListCode);
            strWhere.append("and a.serialNo=:serialNo ");
            map.put("serialNo", serial);
            strWhere.append("and a.itemListCode=:itemListCode");
            map.put("itemListCode", itemListCodes.get(i));

            Query dataQuery = entityManager.createNativeQuery(strWhere.toString(), HerdFarmerItem.class);
            this.setQueryParam(dataQuery, map);
            List list = dataQuery.getResultList();
            List<HerdFarmerItem> list2 = dataQuery.getResultList();
            this.convertCollection(list2, herdFarmerItemDtoList, HerdFarmerItemDto.class);
            herdFarmerItemMap.put(itemListCodes.get(i), herdFarmerItemDtoList);
        }
        return herdFarmerItemMap;
    }

    /**
     * 金禾系统调用交易清单接口查看保单信息
     *
     * @param gisInsureListCode 金禾清单号码
     * @date: 2018/4/12 17:01 （修改优化）
     * @author: 何伟东
     */
    @Override
    public UnderwritingListDto underwritingListQuery(String gisInsureListCode) throws Exception {
        if (StringUtils.isEmpty(gisInsureListCode) || StringUtils.isEmpty(gisInsureListCode.trim())) {
            throw new DataVerifyException("投保预确认清单号不能为空！");
        }
        // 根据金禾清单号码查询该清单关联的保单号
        List<String> policyNoList = insureMainListDao.findGisInsureListCode(gisInsureListCode);
        UnderwritingListDto underwritingListDto = new UnderwritingListDto();
        List<com.sinosoft.txnlist.api.gisinsurelist.dto.PrpCmainDto> prpCmainDtoList = new ArrayList<>();
        // 清单关联的有保单则进行下一步处理
        if (policyNoList != null && policyNoList.size() > 0) {
            Map<String, List<String>> param = new HashMap<>(1);
            param.put("policyNos", policyNoList);
            // 根据保单号查询对应的保单信息
            List<PrpCmainDto> prpCmainDtos = prpCmainApi.queryPolicyInfoByPolicyNos(param);
            List<String> comCodes = new ArrayList<>();
            List<String> riskCodes = new ArrayList<>();
            List<String> userCodes = new ArrayList<>();
            Map<String, String> operatorCodeOfPolicyNo = new HashMap<>();
            // 遍历查询得到的保单信息，汇总所有的comcCode、riskCode、userCode，用于批量查询转译代码含义
            prpCmainDtos.forEach(prpCmainDto -> {
                String comCode = prpCmainDto.getComCode();
                String makeCom = prpCmainDto.getMakeCom();
                if (!comCodes.contains(comCode)) {
                    comCodes.add(comCode);
                }
                if (!comCodes.contains(makeCom)) {
                    comCodes.add(makeCom);
                }
                String riskCode = prpCmainDto.getRiskCode();
                if (!riskCodes.contains(riskCode)) {
                    riskCodes.add(riskCode);
                }
                String operatorCode = prpCmainDto.getOperatorCode();
                if (!userCodes.contains(operatorCode)) {
                    userCodes.add(operatorCode);
                }
                // 由于返回的dto中不含有operatorCode，所以遍历时做保单号与operatorCode的关联操作，方便返回值的名称转译
                operatorCodeOfPolicyNo.put(prpCmainDto.getPolicyNo(), operatorCode);
            });
            // 根据保单号查询对应的险别标的信息
            List<PrpCitemKindDto> prpCitemKindDtos = prpCitemKindApi.queryItemKindByPolicyNos(param);
            // 转译机构代码对应的机构名称
            Map<String, String> comNameByComCode = prpDcompanyApi.queryComCNameByComCodes(comCodes);
            // 转译险种代码对应的险种名称
            List<PrpDriskDto> prpDriskDtos = prpDriskApi.queryByRiskCodeList(riskCodes);
            Map<String, String> riskNameByRiskCode = new HashMap<>();
            prpDriskDtos.forEach(prpDriskDto -> riskNameByRiskCode.put(prpDriskDto.getRiskCode(), prpDriskDto.getRiskCName()));
            // 转译用户代码对应的用户名称
            List<PrpDuserDto> prpDuserDtos = prpDuserApi.queryByUserCodeList(userCodes);
            Map<String, String> userNameByUserCode = new HashMap<>();
            prpDuserDtos.forEach(prpDuserDto -> userNameByUserCode.put(prpDuserDto.getUserCode(), prpDuserDto.getUserName()));
            // 将查询到的保单信息convert为要返回的dto集合
            convertCollection(prpCmainDtos, prpCmainDtoList, com.sinosoft.txnlist.api.gisinsurelist.dto.PrpCmainDto.class);
            // 标的险别信息按照保单号分组
            Map<String, List<PrpCitemKindDto>> prpCitemKindGroupByPolicyNo = prpCitemKindDtos.stream().collect(Collectors.groupingBy(PrpCitemKindDto::getPolicyNo));
            // 完善返回dto的信息
            prpCmainDtoList.forEach(prpCmainDto -> {
                String policyNo = prpCmainDto.getPolicyNo();
                List<PrpCitemKindDto> _prpCitemKindDtos = prpCitemKindGroupByPolicyNo.get(policyNo);
                List<com.sinosoft.txnlist.api.gisinsurelist.dto.PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
                this.convertCollection(_prpCitemKindDtos, prpCitemKindDtoList, com.sinosoft.txnlist.api.gisinsurelist.dto.PrpCitemKindDto.class);
                prpCmainDto.setRiskName(riskNameByRiskCode.get(prpCmainDto.getRiskCode()));
                prpCmainDto.setComName(comNameByComCode.get(prpCmainDto.getComCode()));
                prpCmainDto.setMakeComName(comNameByComCode.get(prpCmainDto.getMakeCom()));
                prpCmainDto.setOperatorName(userNameByUserCode.get(operatorCodeOfPolicyNo.get(prpCmainDto.getPolicyNo())));
                // flag.substring(1, 2)是获取主险附加险的标志
                prpCitemKindDtoList.forEach(prpCitemKindDto -> {
                    String flag = prpCitemKindDto.getFlag();
                    if (StringUtils.isNotEmpty(flag)) {
                        prpCitemKindDto.setFlag(flag.substring(1, 2));
                    }
                });
                prpCmainDto.setItemKindInfoList(prpCitemKindDtoList);
            });
        }
        underwritingListDto.setPolicyInfoList(prpCmainDtoList);
        underwritingListDto.setInsureListCode(gisInsureListCode);
        return underwritingListDto;
    }


    @Override
    public String markListDownload(String insureListCode, String serialNo, List<String> itemListCodes) throws Exception {
        PageInfo<List<GisFarmerItemDto>> listPageInfo = queryGisFarmerItemInfoDetail(insureListCode, serialNo, itemListCodes, 1, 1000);
        List<List<GisFarmerItemDto>> content = listPageInfo.getContent();
        List<GisFarmerItemDto> gisFarmerItemDtos = content.get(0);
        for (int i = 0; i < gisFarmerItemDtos.size(); i++) {
            gisFarmerItemDtos.get(i).setSequenceNo(i + 1);
//            gisFarmerItemDto.setSequenceNo(gisFarmerItemDto.getSequenceNo() + 1);
        }
        QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        File file = null;
        String s;
        try {
            file = quicklyExportExcel.quicklyExport(exportExcelType, "标的清单列表", "标的清单列表", gisFarmerItemDtos, 1, 6, GisFarmerItemDto.class);
            s = uploadFile(fileServiceUrl, file, userCode, "agri/tempfile", "txnlist_markListDownload");
        } finally {
            if (null != file) {
                file.delete();
            }
        }
        return s;
    }

    /**
     * 短链接有效时长,默认一小时
     */
    private String validWhenLong = "3600000";

    public String uploadFile(String fileServiceUrl, File file, String userCode, String systemId, String bussType) throws Exception {
        String fileId = null;
        String shortLinkId = null;
        // 上传文件到fileServer
        Map<String, String> uploadFileMap = new HashMap<>(3);
        uploadFileMap.put("userCode", userCode);
        uploadFileMap.put("systemId", systemId);
        uploadFileMap.put("bussType", bussType);
        Map<String, String> uploadFileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file, uploadFileMap);
        if (uploadFileResult != null && StringUtils.isNotEmpty(uploadFileResult.get("fileId"))) {
            fileId = uploadFileResult.get("fileId");
        }
        // 生成短链接服务调用
        if (StringUtils.isNotEmpty(fileId)) {
            Map<String, String> shortLinkMap = new HashMap<>(3);
            shortLinkMap.put("userCode", userCode);
            shortLinkMap.put("fileId", fileId);
            shortLinkMap.put("validWhenLong", validWhenLong);
            Map<String, String> shortLinkResult = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", shortLinkMap);
            shortLinkId = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + shortLinkResult.get("shortLinkId");
        }
        if (StringUtils.isEmpty(shortLinkId)) {
            throw new BusinessException("生成文件下载短链接失败！");
        }
        return shortLinkId;
    }

    /**
     * 根据清单号和序列号查询金禾清单gisFarmerItem表
     *
     * @param insureListCode, serialNo, itemListCodes 序列号和清单号map
     * @return gisFarmerItemInfoDtoList 金禾主表部分信息集合
     * @throws Exception
     * @Author: 钱浩
     */
    public Map<String, List<GisFarmerItemForPremiumDto>> queryGisZHFarmerItemInfo(String insureListCode, String serialNo, List<String> itemListCodes, List<String> itemCodeList) throws Exception {
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单号不可为空！");
        }
        List<GisFarmerItemForPremiumDto> gisFarmerItemForPremiumDtoList = null;
        Map map = null;
        Map<String, List<GisFarmerItemForPremiumDto>> herdFarmerItemMap = new HashMap<>();
        for (int i = 0; i < itemCodeList.size(); i++) {
            gisFarmerItemForPremiumDtoList = new ArrayList<>();
            StringBuilder dataSql = new StringBuilder("select gfi.*, gf.fIdCard, gf.fName,gf.fPhone,gf.bankName,gf.accountName,gf.accountNo,gf.insureArea, gi.itemType, gi.itemName," +
                    "gf.industryCategory,gf.loanContractNo,gf.loanBankAccount,gf.loadAmount,gf.guarantor,gf.loanPeriod,gf.loanUse " +
                    "from GisFarmerItem gfi, GisFarmerList gf, GisItemList gi " +
                    "where gfi.insureListCode = :insureListCode and gfi.serialNo = :serialNo " +
                    "and gfi.itemListCode in (:itemListCode) and gfi.insureListCode = gf.insureListCode " +
                    "and gfi.insureListCode = gi.insureListCode and gfi.serialNo = gf.serialNo and gfi.serialNo = gi.serialNo " +
                    "and gfi.fCode = gf.fCode and gfi.itemCode = gi.itemCode");
            Query dataQuery = entityManager.createNativeQuery(dataSql.toString(), GisZHFarmerItemInfo.class);
            dataQuery.setParameter("insureListCode", insureListCode);
            dataQuery.setParameter("serialNo", serialNo);
            dataQuery.setParameter("itemListCode", itemListCodes.get(i));
            List<GisZHFarmerItemInfo> herdFarmerItemList = dataQuery.getResultList();
            this.convertCollection(herdFarmerItemList, gisFarmerItemForPremiumDtoList, GisFarmerItemForPremiumDto.class);
            if ("3129M002".equals(itemCodeList.get(i))) {
                StringBuilder builder = new StringBuilder();
                builder.append(" select p from GisManFieldList p where p.insureListCode=:insureListCode and serialNo=:serialNo ");
                Query query = entityManager.createQuery(builder.toString());
                query.setParameter("insureListCode", insureListCode);
                query.setParameter("serialNo", Integer.parseInt(serialNo));
                List<GisManFieldList> gisManFieldListList = query.getResultList();
                List<GisManFieldListDto> gisManFieldListDtos = new ArrayList<GisManFieldListDto>();
                convertCollection(gisManFieldListList, gisManFieldListDtos, GisManFieldListDto.class);
                if (herdFarmerItemList != null && herdFarmerItemList.size() > 0) {
                    gisFarmerItemForPremiumDtoList.get(0).setGisManFieldListDtoList(gisManFieldListDtos);
                }
            }
            herdFarmerItemMap.put(itemCodeList.get(i), gisFarmerItemForPremiumDtoList);
        }
        return herdFarmerItemMap;
    }

    /**
     * 查询GisFarmerItem表
     *
     * @param insureListCode 清单号
     * @param serialNo       序列号
     * @param itemListCodes  标的清单号
     * @return gisFarmerItemInfoDtoList
     * @throws Exception
     * @Author: 李冬松
     */
    @Override
    public PageInfo<List<GisFarmerItemDto>> queryGisFarmerItemInfoDetail(String insureListCode, String serialNo, List<String> itemListCodes, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        if (itemListCodes.size() == 0) {
            throw new DataVerifyException("标的清单号不可为空！");
        }
        int serial = Integer.parseInt(serialNo);
        StringBuilder dataSql = new StringBuilder("select g from GisFarmerItem g where g.insureListCode=:insureListCode and g.serialNo=:serial and g.itemListCode in (:itemListCodes)");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        dataQuery.setParameter("insureListCode", insureListCode);
        dataQuery.setParameter("serial", serial);
        dataQuery.setParameter("itemListCodes", itemListCodes);
        dataQuery.setFirstResult((pageNo - 1) * pageSize);
        dataQuery.setMaxResults(pageSize);

        //List<GisFarmerItem> gisFarmerItemList = gisFarmerItemDao.queryAllByCondition(insureListCode, serial, itemListCodes);
        Long count = gisFarmerItemDao.queryCountByCondition(insureListCode, serial, itemListCodes);
        List<GisFarmerItemDto> gisFarmerItemDtoList = new ArrayList<>();
        List<GisFarmerItem> gisFarmerItemList = dataQuery.getResultList();
        convertCollection(gisFarmerItemList, gisFarmerItemDtoList, GisFarmerItemDto.class);
        List<List<GisFarmerItemDto>> gisFarmerItemDtoListList = new ArrayList<>();
        PageInfo<List<GisFarmerItemDto>> pageInfo = new PageInfo<>();
        List<GisFarmerItemDto> gisFarmerItemDtos = null;
        for (int i = 0; i < itemListCodes.size(); i++) {
            gisFarmerItemDtos = new ArrayList<>();
            for (int j = 0; j < gisFarmerItemDtoList.size(); j++) {
                if (itemListCodes.get(i).equals(gisFarmerItemDtoList.get(j).getItemListCode())) {
                    gisFarmerItemDtos.add(gisFarmerItemDtoList.get(j));
                }
            }
            gisFarmerItemDtoListList.add(gisFarmerItemDtos);
        }

        // 数据存放dto集合
        pageInfo.setContent(queryDetailInfo(gisFarmerItemDtoListList));
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(count);
        return pageInfo;
    }


    /**
     * 查询GisFarmerItem表子方法
     *
     * @param map 以标的清单号为Key,以GISFARMERITEM为value的map
     * @return java.util.Map<java.lang.String,java.util.List<com.sinosoft.txnlist.api.gisinsurelist.dto.GisFarmerItemDto>>
     * @throws Exception
     * @author 李冬松
     * @date 19:13 2018/2/1
     */
    public Map<String, List<GisFarmerItemDto>> queryDetailInfo(Map<String, List<GisFarmerItemDto>> map) throws Exception {
        List<GisFarmerItemDto> gisFarmerItemDtoList;
        for (String key : map.keySet()) {
            gisFarmerItemDtoList = map.get(key);
            for (int i = 0; i < gisFarmerItemDtoList.size(); i++) {
                GisFarmerList gisFarmerList = gisFarmerListDao.queryAllByInsurelistCodeAndSerialNoAndFCode(gisFarmerItemDtoList.get(i).getInsureListCode()
                        , gisFarmerItemDtoList.get(i).getSerialNo(), gisFarmerItemDtoList.get(i).getfCode());
                GisItemList gisItemList = gisItemListDao.queryByCondition(gisFarmerItemDtoList.get(i).getInsureListCode()
                        , gisFarmerItemDtoList.get(i).getSerialNo(), gisFarmerItemDtoList.get(i).getItemCode());
                gisFarmerItemDtoList.get(i).setfName(gisFarmerList.getfName());
                gisFarmerItemDtoList.get(i).setItemType(gisItemList.getItemType());
                gisFarmerItemDtoList.get(i).setItemName(gisItemList.getItemName());
            }
            map.put(key, gisFarmerItemDtoList);
        }
        return map;
    }

    /**
     * 查询GisFarmerItem表子方法
     *
     * @param gisFarmerItemDtoListList 以标的清单号为Key,以GISFARMERITEM为value的map
     * @return java.util.Map<java.lang.String,java.util.List<com.sinosoft.txnlist.api.gisinsurelist.dto.GisFarmerItemDto>>
     * @throws Exception
     * @author 李冬松
     * @date 19:13 2018/2/1
     */
    public List<List<GisFarmerItemDto>> queryDetailInfo(List<List<GisFarmerItemDto>> gisFarmerItemDtoListList) throws Exception {
        for (List<GisFarmerItemDto> gisFarmerItemDtoList : gisFarmerItemDtoListList) {
            for (int i = 0; i < gisFarmerItemDtoList.size(); i++) {
                GisFarmerList gisFarmerList = gisFarmerListDao.queryAllByInsurelistCodeAndSerialNoAndFCode(gisFarmerItemDtoList.get(i).getInsureListCode()
                        , gisFarmerItemDtoList.get(i).getSerialNo(), gisFarmerItemDtoList.get(i).getfCode());
                GisItemList gisItemList = gisItemListDao.queryByCondition(gisFarmerItemDtoList.get(i).getInsureListCode()
                        , gisFarmerItemDtoList.get(i).getSerialNo(), gisFarmerItemDtoList.get(i).getItemCode());
                gisFarmerItemDtoList.get(i).setfName(gisFarmerList.getfName());
                gisFarmerItemDtoList.get(i).setItemType(gisItemList.getItemType());
                gisFarmerItemDtoList.get(i).setItemName(gisItemList.getItemName());
            }
        }
        return gisFarmerItemDtoListList;
    }

    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     *
     * @param requestDto 用户输入的查询条件
     * @return PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 李冬松
     * @date: 2017/11/6 下午2:18
     */
    @Override
    public PageInfo<GisInsureMainListDto> findGisInsureMainList(RequestInsuranceQueryDto requestDto) throws Exception {
        // 统一封装分页响应dto
        PageInfo<GisInsureMainListDto> pageInfo = new PageInfo<>();
        // 查询数据HQL
        if (requestDto == null) {
            throw new DataVerifyException("请求参数不能为空！");
        }
        if (requestDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (requestDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        String riskCode = requestDto.getRiskCode();
        List<PrpDitemDto> prpDitemDtos = null;
        if (StringUtils.isNotEmpty(riskCode)) {
            Map<String, String> param = new HashMap<>();
            param.put("riskCode", riskCode);
            prpDitemDtos = prpDitemApi.queryByRiskCode(param);
        }

        StringBuilder dataHql = new StringBuilder("select distinct pt from GisInsureMainList pt ");
        // 查询总数量的HQL
        StringBuilder countHql = new StringBuilder("select count(distinct pt.insureListCode) from GisInsureMainList pt ");
        // 条件hql拼接
        StringBuilder condition = new StringBuilder();
        Map<String, Object> conditions = new HashMap<>();

        //判断用户权限，如果用户没有选权限，则查询用户全部权限下的数据。
        String[][] connectionSymbol = parseRegionCondition(requestDto);
        //没有省市五级权限。
        boolean flag = false;

        // 清单查询新增险种条件
        if (prpDitemDtos != null) {
            condition.append(", GisItemList gi where pt.newFlag='Y' and gi.insureListCode = pt.insureListCode and gi.itemCode in (:itemCodeList) ");
            List<String> itemCodeList = new ArrayList<>();
            prpDitemDtos.forEach(prpDitemDto -> itemCodeList.add(prpDitemDto.getItemCode()));
            conditions.put("itemCodeList", itemCodeList);
        } else {
            // 清单补录和投保单录入的标识；有耳标号和连带被保险人的标的代码
            if ("makeUpList".equals(requestDto.getQueryScenes())) {
                condition.append(", GisItemList gi WHERE gi.insureListCode = pt.insureListCode AND gi.itemCode in (:itemCodes) AND pt.newFlag='Y' ");
                conditions.put("itemCodes", Arrays.asList(new String[]{"aa140", "bb110", "ZZ200"}));
            } else {
                condition.append("where pt.newFlag='Y' ");
            }
        }

        if (StringUtils.isNotEmpty(requestDto.getInsureListCode())) {
            condition.append("AND pt.insureListCode like :insureListCode ");
            conditions.put("insureListCode", "%" + requestDto.getInsureListCode() + "%");
        }

        if (StringUtils.isNotEmpty(requestDto.getListAlias())) {
            condition.append("AND pt.listAlias like :listAlias ");
            conditions.put("listAlias", "%" + requestDto.getListAlias() + "%");
        }

        if (StringUtils.isNotEmpty(requestDto.getOpName())) {
            condition.append("AND pt.opName = :opName ");
            conditions.put("opName", requestDto.getOpName());
        }

        if (requestDto.getfProvinceCodes() != null && !requestDto.getfProvinceCodes().isEmpty()) {
            condition.append(connectionSymbol[0][0]).append(" pt.fProvinceCode in :fProvinceCode")
                    .append(connectionSymbol[1][0]).append(" ");
            conditions.put("fProvinceCode", requestDto.getfProvinceCodes());
            flag = true;
        }
        if (requestDto.getfCityCodes() != null && !requestDto.getfCityCodes().isEmpty()) {
            condition.append(connectionSymbol[0][1]).append(" pt.fCityCode in :fCityCode")
                    .append(connectionSymbol[1][1]).append(" ");
            conditions.put("fCityCode", requestDto.getfCityCodes());
            flag = true;
        }
        if (requestDto.getfCountyCodes() != null && !requestDto.getfCountyCodes().isEmpty()) {
            condition.append(connectionSymbol[0][2]).append(" pt.fCountyCode in :fCountyCode")
                    .append(connectionSymbol[1][2]).append(" ");
            conditions.put("fCountyCode", requestDto.getfCountyCodes());
            flag = true;
        }
        if (requestDto.getfTownCodes() != null && !requestDto.getfTownCodes().isEmpty()) {
            condition.append(connectionSymbol[0][3]).append(" pt.fTownCode in :fTownCode")
                    .append(connectionSymbol[1][3]).append(" ");
            conditions.put("fTownCode", requestDto.getfTownCodes());
            flag = true;
        }
        if (requestDto.getfVillageCodes() != null && !requestDto.getfVillageCodes().isEmpty()) {
            condition.append(connectionSymbol[0][4]).append(" pt.fVillageCode in :fVillageCode")
                    .append(connectionSymbol[1][4]).append(" ");
            conditions.put("fVillageCode", requestDto.getfVillageCodes());
            flag = true;
        }

        if (StringUtils.isNotEmpty(requestDto.getBeginTime())) {
            condition.append("AND TRUNC(pt.listAffrimTime) >= to_date(:beginTime, 'yyyy-MM-dd') ");
            conditions.put("beginTime", requestDto.getBeginTime());
        }

        if (StringUtils.isNotEmpty(requestDto.getEndTime())) {
            condition.append("AND TRUNC(pt.listAffrimTime) <= to_date(:endTime, 'yyyy-MM-dd') ");
            conditions.put("endTime", requestDto.getEndTime());
        }

        //没有省市五级权限。提前终止，不查询
        if (!flag) {
            return pageInfo;
        }

        countHql.append(condition);
        dataHql.append(condition).append(" order by pt.insureListCode desc ");
        // 查询数据hql拼接条件以及排序hql
        Query countQuery = entityManager.createQuery(countHql.toString());
        Query dataQuery = entityManager.createQuery(dataHql.toString());
        // 设置参数
        for (String key : conditions.keySet()) {
            countQuery.setParameter(key, conditions.get(key));
            dataQuery.setParameter(key, conditions.get(key));
        }
        // 查询数据总条数
        long countNum = (long) countQuery.getSingleResult();
        dataQuery.setFirstResult((requestDto.getPageNo() - 1) * requestDto.getPageSize());
        dataQuery.setMaxResults(requestDto.getPageSize());
        // 查询数据
        List<GisInsureMainList> dataList;
        List<GisInsureMainListDto> gisInsureMainListDtos = new ArrayList<>();
        // 当查询到的总记录数大于0才继续查询
        if (countNum > 0) {
            dataList = dataQuery.getResultList();
            this.convertCollection(dataList, gisInsureMainListDtos, GisInsureMainListDto.class);
        }
        // 数据存放dto集合
        pageInfo.setContent(gisInsureMainListDtos);
        // 当前页数
        pageInfo.setPages(requestDto.getPageNo());
        // 总记录数
        pageInfo.setTotalCount(countNum);
        return pageInfo;
    }

    /**
     * 判断用户权限，如果用户没有选权限，则查询用户全部权限下的数据。
     *
     * @param requestDto
     */
    private String[][] parseRegionCondition(RequestInsuranceQueryDto requestDto) {
        String[][] connectionSymbol = new String[][]{{null, null, null, null, null}, {"", "", "", "", ""}};

        List<String> rfProvinceCodes = requestDto.getfProvinceCodes();
        if (rfProvinceCodes != null && rfProvinceCodes.size() > 0) {
            connectionSymbol = new String[][]{{"AND", "AND", "AND", "AND", "AND"}, {"", "", "", "", ""}};
            return connectionSymbol;
        }

        UserRegion userRegion;
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        if (userCode.isEmpty() || userCode.equals("00000000")) {
            userRegion = new UserRegion();
        } else {
            GYcoreUtil gYcoreUtil = new GYcoreUtil(gycoreService);
            userRegion = gYcoreUtil.getUserAllRegion(userCode);
        }


        List<String> fProvinceCodes = userRegion.getfProvinceCodes();
        if (requestDto.getfProvinceCodes() == null || requestDto.getfProvinceCodes().size() < 1) {
            requestDto.setfProvinceCodes(fProvinceCodes);
            if (fProvinceCodes != null && fProvinceCodes.size() > 0) {
                connectionSymbol[0][0] = "AND (";
                connectionSymbol[1][0] = ")";
            }
        } else {
            requestDto.setfProvinceCodes(requestDto.getfProvinceCodes());
            connectionSymbol[0][0] = "AND";
        }

        List<String> fCityCodes = userRegion.getfCityCodes();
        if (requestDto.getfCityCodes() == null || requestDto.getfCityCodes().size() < 1) {
            requestDto.setfCityCodes(fCityCodes);
            if (fCityCodes != null && fCityCodes.size() > 0) {
                initConnectionSymbol(connectionSymbol, 1);
            }
        } else {
            requestDto.setfCityCodes(requestDto.getfCityCodes());
            connectionSymbol[0][1] = "AND";
        }

        List<String> fCountyCodes = userRegion.getfCountyCodes();
        if (requestDto.getfCountyCodes() == null || requestDto.getfCountyCodes().size() < 1) {
            requestDto.setfCountyCodes(fCountyCodes);
            if (fCountyCodes != null && fCountyCodes.size() > 0) {
                initConnectionSymbol(connectionSymbol, 2);
            }
        } else {
            requestDto.setfCountyCodes(requestDto.getfCountyCodes());
            connectionSymbol[0][2] = "AND";
        }

        List<String> fTownCodes = userRegion.getfTownCodes();
        if (requestDto.getfTownCodes() == null || requestDto.getfTownCodes().size() < 1) {
            requestDto.setfTownCodes(fTownCodes);
            if (fTownCodes != null && fTownCodes.size() > 0) {
                initConnectionSymbol(connectionSymbol, 3);
            }
        } else {
            requestDto.setfTownCodes(requestDto.getfTownCodes());
            connectionSymbol[0][3] = "AND";
        }

        List<String> fVillageCodes = userRegion.getfVillageCodes();
        if (requestDto.getfVillageCodes() == null || requestDto.getfVillageCodes().size() < 1) {
            requestDto.setfVillageCodes(fVillageCodes);
            if (fVillageCodes != null && fVillageCodes.size() > 0) {
                initConnectionSymbol(connectionSymbol, 4);
            }
        } else {
            requestDto.setfVillageCodes(requestDto.getfVillageCodes());
            connectionSymbol[0][4] = "AND";
        }
        for (int i = 0; i < connectionSymbol[0].length; i++) {
            String connectionSymbolStr = connectionSymbol[0][i];
            if (StringUtils.isEmpty(connectionSymbolStr)) {
                connectionSymbol[0][i] = "AND";
            }
        }
        return connectionSymbol;
    }

    private void initConnectionSymbol(String[][] connectionSymbol, int y) {
        if (StringUtils.isNotEmpty(connectionSymbol[1][y - 1])) {
            connectionSymbol[0][y] = "OR";
            connectionSymbol[1][y] = ")";
            connectionSymbol[1][y - 1] = "";
        } else {
            if (StringUtils.isNotEmpty(connectionSymbol[0][y - 1])) {
                connectionSymbol[0][y] = "OR (";
            } else {
                connectionSymbol[0][y] = "AND (";
            }
            connectionSymbol[1][y] = ")";
        }
    }

    /**
     * 通过清单号和序列号查询GisItemList信息
     *
     * @param insureListCode 清单号
     * @param serialNo       序列号
     * @return gisItemListDtoList gisItemList表集合
     * @throws Exception
     * @Author: 李冬松
     */
    @Override
    public List<GisItemListDto> findGisItemListByInsureListCodeAndserialNo(String insureListCode, String serialNo) throws Exception {
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        List<GisItemList> gisItemLists = gisItemListDao.queryAllByInsureListCodeAndSerialNo(insureListCode, Integer.parseInt(serialNo));
        List<GisItemListDto> gisItemListDtoList = new ArrayList<>();
        convertCollection(gisItemLists, gisItemListDtoList, GisItemListDto.class);
        return gisItemListDtoList;
    }

    /**
     * 查询GisFarmerList表信息
     *
     * @param
     * @return java.util.List<GisFarmerListDto> gisFarmerListdTO集合
     * @throws Exception
     * @author 李冬松
     * @date 15:50 2018/1/19
     */
    @Override
    public ResponseGisMainAndFarmerListDto findGisFarmerListByInsureListCodeAndserialNo(RequestQueryFarmerDto requestDto) throws Exception {
        String insureListCode = requestDto.getInsureListCode();
        String serialNo = requestDto.getSerialNo();
        List<GisFarmerListDto> gisFarmerListDtos = new ArrayList<>();
        ResponseGisMainAndFarmerListDto responseGisMainAndFarmerListDto = new ResponseGisMainAndFarmerListDto();
        if (StringUtils.isEmpty(insureListCode) || StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("清单号或序列号不可为空！");
        }
        //查询gisFarmerList投保预确认农户清单表信息
        int serial = Integer.parseInt(serialNo);

        StringBuilder dataSql = new StringBuilder("select g from GisFarmerList g where g.insureListCode=:insureListCode and g.serialNo=:serial order by g.insureListCode desc");
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        dataQuery.setParameter("insureListCode", insureListCode);
        dataQuery.setParameter("serial", serial);
        dataQuery.setFirstResult((requestDto.getPageNo() - 1) * requestDto.getPageSize());
        dataQuery.setMaxResults(requestDto.getPageSize());

        List<GisFarmerList> gisFarmerListList = gisFarmerListDao.queryAllByInsurelistCodeAndSerialNo(insureListCode, serial);
        int countNum = gisFarmerListList.size();
        List<GisFarmerListDto> gisFarmerListDtoList = new ArrayList<>();
        if (countNum > 0) {
            convertCollection(gisFarmerListList, gisFarmerListDtoList, GisFarmerListDto.class);
        }
        gisFarmerListDtoList = dataQuery.getResultList();
        responseGisMainAndFarmerListDto.setGisFarmerListDtoList(gisFarmerListDtoList);
        //gisFarmerListDtos.setPages(requestDto.getPageNo());
        responseGisMainAndFarmerListDto.setCount(countNum);
        //查询GisInsureMainList投保预确认数据主表信息
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(insureListCode, serial);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        responseGisMainAndFarmerListDto.setGisInsureMainListDto(gisInsureMainListDto);
        return responseGisMainAndFarmerListDto;
    }

    @Override
    public List<GisFarmerListDto> findGisFarmerListInfo(String insureListCode, String serialNo, String itemCode) throws Exception {
        return null;
    }

    /**
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean checkInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        String times = txnlistDetailedDto.getTimes();
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        // List<PlantingInsuranceListDto> plantingInsuranceListDtoList = new ArrayList<PlantingInsuranceListDto>();
        List<PlantingInsuranceListDto> plantingInsuranceListDtoListTemp = new ArrayList<PlantingInsuranceListDto>();
        // PlantingInsuranceListDto plantingInsuranceListDtoTemp = null;
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        //老系統从plantingInsuranceList中查的，新系统需要从中间表中获取
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        //保存清单主表
        insureMainListDto.setGisInsureListCode(gisInsureMainListDto.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainListDto.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainListDto.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainListDto.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        //insureMainListDto.setPolicyName();//投保人名称
        //保存投种植险保清单明细表
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PlantingInsuranceListDto plantingInsuranceListDto = null;
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            plantingInsuranceListDto = convert(txnlistDetailedSubDto, PlantingInsuranceListDto.class);
            //老系统从session中获取的，新系统应该从页面传入String strAreasCode = (String)session.getValue("AreasCode");
            if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                            if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                                throw new Exception("金禾中间表区域代码不能为空");
                            } else {
                                plantingInsuranceListDto.setfAreaCode(gisInsureMainListDto.getfProvinceCode());
                            }
                        } else {
                            plantingInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        plantingInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                    }
                } else {
                    plantingInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
                }
            } else {
                plantingInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
            }
            // 老系统从excel中获取的，计算保费前与计算保费后这个字段都没更新,默认0.00
            plantingInsuranceListDto.setTaxArea(0.00);
            plantingInsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            plantingInsuranceListDto.setOpTime(new Date());

            //将每组数据放到list中
            plantingInsuranceListDtoListTemp.add(plantingInsuranceListDto);
        }

        boolean flag = false;
        this.saveinsureMainLIstMethod(times, insureMainListDto);
        try {
            //保存清单子表
            if ("3141".equals(insureMainListDto.getRiskCode())) {
                List<Planting31InsuranceListDto> planting31InsuranceListDtoList = new ArrayList<>();
                this.convertCollection(plantingInsuranceListDtoListTemp, planting31InsuranceListDtoList, Planting31InsuranceListDto.class);
                planting31InsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                planting31InsuranceListService.saveByList(planting31InsuranceListDtoList);
            } else {
                //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
                plantingInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                plantingInsuranceListService.saveByList(plantingInsuranceListDtoListTemp);
            }

            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存清单子表信息失败！");
        }
        return flag;
    }

    /**
     * 清单主表保存方法，如果保存次数为1，则用entityManager.persist方法进行保存，如果表中数据有则报主键冲突
     * @author: 田健
     * @date: 2018/5/25 14:31
     * @param times 保存次数
     * @param insureMainListDto 清单主表信息
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveinsureMainLIstMethod(String times, InsureMainListDto insureMainListDto) throws Exception {
        try {
            if (saveDetailedListTimes.equals(times)) {
                //保存清单主表
                insureMainListService.persist(insureMainListDto);

            } else {
                insureMainListService.save(insureMainListDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 31大棚蔬菜险类
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean check31InsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        String times = txnlistDetailedDto.getTimes();
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        List<Planting31InsuranceListDto> planting31InsuranceListDtoListTemp = new ArrayList<Planting31InsuranceListDto>();
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        //保存清单主表
        insureMainListDto.setGisInsureListCode(gisInsureMainListDto.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainListDto.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainListDto.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainListDto.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        //insureMainListDto.setPolicyName();//投保人名称
        //保存投种植险保清单明细表
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Planting31InsuranceListDto planting31InsuranceListDto = null;
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            planting31InsuranceListDto = convert(txnlistDetailedSubDto, Planting31InsuranceListDto.class);
            //从金禾中间表取值
            if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                            if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                                throw new Exception("金禾中间表区域代码不能为空");
                            } else {
                                planting31InsuranceListDto.setfAreaCode(gisInsureMainListDto.getfProvinceCode());
                            }
                        } else {
                            planting31InsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        planting31InsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                    }
                } else {
                    planting31InsuranceListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
                }
            } else {
                planting31InsuranceListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
            }
            // 老系统从excel中获取的，计算保费前与计算保费后这个字段都没更新,默认0.00
            planting31InsuranceListDto.setTaxArea(0.00);
            planting31InsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            planting31InsuranceListDto.setOpTime(new Date());
            //将每组数据放到list中
            planting31InsuranceListDtoListTemp.add(planting31InsuranceListDto);
        }


        boolean flag = false;
        this.saveinsureMainLIstMethod(times, insureMainListDto);
        try {
            //保存清单子表
            planting31InsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
            planting31InsuranceListService.saveByList(planting31InsuranceListDtoListTemp);

            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存清单子表信息失败！");
        }
        return flag;
    }

    /**
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean checkNyxInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        String times = txnlistDetailedDto.getTimes();
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        List<NyxInsuranceListDto> nyxInsuranceListDtoListTemp = new ArrayList<NyxInsuranceListDto>();
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        //老系統从plantingInsuranceList中查的，新系统需要从中间表中获取
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        //保存清单主表
        insureMainListDto.setGisInsureListCode(gisInsureMainListDto.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainListDto.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainListDto.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainListDto.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        //insureMainListDto.setPolicyName();//投保人名称
        //保存投种植险保清单明细表
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NyxInsuranceListDto nyxInsuranceListDto = null;
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            nyxInsuranceListDto = convert(txnlistDetailedSubDto, NyxInsuranceListDto.class);

            if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                            if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                                throw new Exception("金禾中间表区域代码不能为空");
                            } else {
                                nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getfProvinceCode());
                            }
                        } else {
                            nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                    }
                } else {
                    nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
                }
            } else {
                nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
            }
            // 老系统从excel中获取的，计算保费前与计算保费后这个字段都没更新,默认0.00
            nyxInsuranceListDto.setTaxArea(0.00);
            // 种植险，没有耳标号的险种存投保数量
            nyxInsuranceListDto.setAreaNumber(nyxInsuranceListDto.getInsureNumber());
            nyxInsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            nyxInsuranceListDto.setOpTime(new Date());
            //将每组数据放到list中
            nyxInsuranceListDtoListTemp.add(nyxInsuranceListDto);
        }


        boolean flag = false;
        this.saveinsureMainLIstMethod(times, insureMainListDto);
        try {
            //保存清单子表
            //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
            NyxInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
            NyxInsuranceListService.saveByList(nyxInsuranceListDtoListTemp);
            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存清单子表信息失败！");
        }
        return flag;
    }

    /**
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean checkZHInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        String times =txnlistDetailedDto.getTimes();
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        List<NyxInsuranceListDto> nyxInsuranceListDtoListTemp = new ArrayList<NyxInsuranceListDto>();
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        //老系統从plantingInsuranceList中查的，新系统需要从中间表中获取
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        //保存清单主表
        insureMainListDto.setGisInsureListCode(gisInsureMainListDto.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainListDto.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainListDto.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainListDto.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        //insureMainListDto.setPolicyName();//投保人名称
        //保存投种植险保清单明细表
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NyxInsuranceListDto nyxInsuranceListDto = null;
        CMTManFieldList cmTManFieldList = null;
        List<CMTManFieldList> cmcManFieldLists = new ArrayList<>();
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            nyxInsuranceListDto = convert(txnlistDetailedSubDto, NyxInsuranceListDto.class);
            //老系统从session中获取的，新系统应该从页面传入String strAreasCode = (String)session.getValue("AreasCode");
            if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                            if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                                throw new Exception("金禾中间表区域代码不能为空");
                            } else {
                                nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getfProvinceCode());
                            }
                        } else {
                            nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                    }
                } else {
                    nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
                }
            } else {
                nyxInsuranceListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
                //将每组数据放到list中
                nyxInsuranceListDtoListTemp.add(nyxInsuranceListDto);
            }
            // 老系统从excel中获取的，计算保费前与计算保费后这个字段都没更新,默认0.00
            nyxInsuranceListDto.setTaxArea(0.00);
            // 种植险，没有耳标号的险种存投保数量
            nyxInsuranceListDto.setAreaNumber(nyxInsuranceListDto.getInsureNumber());
            nyxInsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            nyxInsuranceListDto.setOpTime(new Date());
            List<GisManFieldListDto> gisManFieldListDtoList = txnlistDetailedSubDto.getGisManFieldListDtoList();
            if (gisManFieldListDtoList != null && gisManFieldListDtoList.size() > 0) {
                convertCollection(gisManFieldListDtoList, cmcManFieldLists, CMTManFieldList.class);
                for (CMTManFieldList cmcManFieldList1 : cmcManFieldLists) {
                    String industryCategory = cmcManFieldList1.getIndustryCategory();
                    Double strr = 0.00;
                    //按总保费*（类别费率/总费率）或总保额*（类别费率/总费率）分别平分到每个人
                    if ("1".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.14).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.14).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.14);
                    } else if ("2".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.18).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.18).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.18);
                    } else if ("3".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.23).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.23).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.23);
                    } else if ("4".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.35).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.35).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.35);
                    } else if ("5".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.53).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.53).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.14);
                    } else if ("6".equals(industryCategory)) {
                        cmcManFieldList1.setSumAmount(new BigDecimal(txnlistDetailedSubDto.getSumAmount()).multiply(((new BigDecimal(0.68).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setSumPremium(new BigDecimal(txnlistDetailedSubDto.getSumPremium()).multiply(((new BigDecimal(0.68).multiply(new BigDecimal(gisManFieldListDtoList.size()))).divide(new BigDecimal(txnlistDetailedSubDto.getRate()), 4, BigDecimal.ROUND_HALF_UP))).doubleValue());
                        cmcManFieldList1.setRate(0.68);
                    }
                    cmcManFieldList1.setInsureListCode(inusreListCode);
                    cmcManFieldList1.setKindCode(txnlistDetailedSubDto.getKindCode());
                }
            }
        }
        boolean flag = false;
        this.saveinsureMainLIstMethod(times, insureMainListDto);
        try {
            //保存清单子表
            //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
            NyxInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
            NyxInsuranceListService.saveByList(nyxInsuranceListDtoListTemp);
            if (cmcManFieldLists != null && cmcManFieldLists.size() > 0) {
                cmtManFieldListDao.save(cmcManFieldLists);
            }
            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存清单信息失败！");
        }
        return flag;
    }

    /**
     * 带耳标号的存NyxinsuranceList
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @param txnlistDetailedDto 保费计算请求dto
     * @return boolean true为保存成功，false为失败
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean checkNyxInsuranceCodeForbreeding(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        //老系統从plantingInsuranceList中查的，新系统需要从中间表中获取
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        //保存清单主表
        insureMainListDto.setGisInsureListCode(gisInsureMainListDto.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainListDto.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainListDto.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainListDto.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainListDto.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainListDto.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainListDto.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainListDto.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainListDto.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainListDto.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainListDto.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainListDto.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainListDto.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        //insureMainListDto.setPolicyName();//投保人名称
        //保存投种植险保清单明细表
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = null;
        TxnlistDetailedSubDto txnlistDetailedSubDto;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        NyxInsuranceListDto nyxInsuranceListDto = null;
        List<NyxInsuranceListDto> nyxInsuranceListDtoList = new ArrayList<NyxInsuranceListDto>();
        txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            nyxInsuranceListDto = convert(txnlistDetailedSubDto, NyxInsuranceListDto.class);
            //从金禾中间表取值
            nyxInsuranceListDto.setfCode(txnlistDetailedSubDto.getfCode());
            nyxInsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            nyxInsuranceListDto.setOpTime(new Date());
            //防止没有耳标号转不过去middleHerdInsuranceListDtoList对象
            nyxInsuranceListDto.setInsurePremium(nyxInsuranceListDto.getfPremium());
            //有耳标号的情况下此字段存1
            if (StringUtils.isNotEmpty(nyxInsuranceListDto.getBusinessNo())) {
                nyxInsuranceListDto.setAreaNumber(1.0);
            }
            // 没有耳标号的存储投保数量
            else {
                nyxInsuranceListDto.setAreaNumber(nyxInsuranceListDto.getInsureNumber());
            }
            //将每组数据放到list中
            nyxInsuranceListDtoList.add(nyxInsuranceListDto);
        }
        boolean flag = false;
        try {
            //保存清单主表
            insureMainListService.save(insureMainListDto);
            //保存清单子表
            //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
            //保存清单子表
            if (StringUtils.isNotEmpty(nyxInsuranceListDtoList.get(0).getBusinessNo())) {//没有耳标号的情况下存中间表，进行耳标补录
                //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
                NyxInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                NyxInsuranceListService.saveByList(nyxInsuranceListDtoList);
            } else {
                List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList = new ArrayList<>();
                convertCollection(nyxInsuranceListDtoList, middleHerdInsuranceListDtoList, MiddleHerdInsuranceListDto.class);
                middleHerdInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                middleHerdInsuranceListService.saveByList(middleHerdInsuranceListDtoList);
            }
            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存失败！");
        }
        return flag;
    }

    /**
     * 养殖险
     * 1、flag为T02时，根据inusreListCode查询,然后根据查询的信息计算补贴金额与农户自缴金额，回写清单表
     * 2、flag为getFee时,往前端返回补贴金额与农户自缴金额等信息
     * 3、flag为Delete时，删除清单信息
     *
     * @return boolean true为保存成功，false为失败     * @param txnlistDetailedDto 保费计算请求dto
     * @throws Exception
     * @author: 李冬松
     * @date: 2017/10/20 11:43
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean UICheckHerdInsuranceCode(TxnlistDetailedDto txnlistDetailedDto) throws Exception {
        String times = txnlistDetailedDto.getTimes();
        TxnlistDetailedMainDto txnlistDetailedMainDto = txnlistDetailedDto.getTxnlistDetailedMainDto();
        int serialNo = Integer.parseInt(txnlistDetailedMainDto.getSerialNo());
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getInusreListCode())) {
            throw new DataVerifyException("清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getProposalNo())) {
            throw new DataVerifyException("投保单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getGisInsureListCode())) {
            throw new DataVerifyException("金禾清单号不能为空！");
        }
        if (StringUtils.isEmpty(txnlistDetailedMainDto.getRiskCode())) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        String inusreListCode = txnlistDetailedMainDto.getInusreListCode();//清单号
        String gisInusreListCode = txnlistDetailedMainDto.getGisInsureListCode();//金禾的清单号
        List<HerdInsuranceListDto> herdInsuranceListDtoList = new ArrayList<HerdInsuranceListDto>();
        InsureMainListDto insureMainListDto = new InsureMainListDto();
        // 从金禾中间表取数据，金禾的清单号gisInusreListCode
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInusreListCode, serialNo);
        //保存清单主表--------------------组装开始---------------------------------------------------
        insureMainListDto.setGisInsureListCode(gisInsureMainList.getInsureListCode());//金禾清单号
        insureMainListDto.setInusreListCode(inusreListCode);//我们自己系统生成的清单号
        insureMainListDto.setProposalNo(txnlistDetailedMainDto.getProposalNo());//回写投保单号，新系统放在保费计算处，跟需求确认
        //获取金禾中间表区域代码转存到清单表
        if (StringUtils.isEmpty(gisInsureMainList.getpVillageCode())) {
            if (StringUtils.isEmpty(gisInsureMainList.getpTownCode())) {
                if (StringUtils.isEmpty(gisInsureMainList.getpCountyCode())) {
                    if (StringUtils.isEmpty(gisInsureMainList.getpCityCode())) {
                        if (StringUtils.isEmpty(gisInsureMainList.getfProvinceCode())) {
                            throw new Exception("金禾中间表区域代码不能为空");
                        } else {
                            insureMainListDto.setfAreaCode(gisInsureMainList.getpCityCode());
                        }
                    } else {
                        insureMainListDto.setfAreaCode(gisInsureMainList.getpCityCode());
                    }
                } else {
                    insureMainListDto.setfAreaCode(gisInsureMainList.getpCountyCode());
                }
            } else {
                insureMainListDto.setfAreaCode(gisInsureMainList.getpTownCode());
            }
        } else {
            insureMainListDto.setfAreaCode(gisInsureMainList.getpVillageCode());
        }
        // //获取金禾中间表区域名称转存到清单表
        if (StringUtils.isEmpty(gisInsureMainList.getpVillageName())) {
            if (StringUtils.isEmpty(gisInsureMainList.getpTownName())) {
                if (StringUtils.isEmpty(gisInsureMainList.getpCountyName())) {
                    if (StringUtils.isEmpty(gisInsureMainList.getpCityName())) {
                        if (StringUtils.isEmpty(gisInsureMainList.getfProvinceName())) {
                            throw new Exception("金禾中间表区域地址不能为空");
                        } else {
                            insureMainListDto.setRemark(gisInsureMainList.getpCityName());
                        }
                    } else {
                        insureMainListDto.setRemark(gisInsureMainList.getpCityName());
                    }
                } else {
                    insureMainListDto.setRemark(gisInsureMainList.getpCountyName());
                }
            } else {
                insureMainListDto.setRemark(gisInsureMainList.getpTownName());
            }
        } else {
            insureMainListDto.setRemark(gisInsureMainList.getpVillageName());
        }
        insureMainListDto.setClassCode(txnlistDetailedMainDto.getClassCode());
        insureMainListDto.setRiskCode(txnlistDetailedMainDto.getRiskCode());
        insureMainListDto.setValidity(txnlistDetailedMainDto.getValidity());
        insureMainListDto.setSerialNo(Integer.valueOf(txnlistDetailedMainDto.getSerialNo()));
        insureMainListDto.setUpdateCode(SinoRequestContext.getCurrentContext().getUserCode());
        insureMainListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
        // -----------------------------------组装结束----------------------------------------------
        //保存养殖险清单明细表
        List<TxnlistDetailedSubDto> txnlistDetailedSubDtoList = new ArrayList<>();
        TxnlistDetailedSubDto txnlistDetailedSubDto = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HerdInsuranceListDto herdInsuranceListDto = null;
        txnlistDetailedSubDtoList = txnlistDetailedDto.getTxnlistDetailedSubDtoList();
        for (int i = 0; i < txnlistDetailedSubDtoList.size(); i++) {
            txnlistDetailedSubDto = txnlistDetailedSubDtoList.get(i);
            herdInsuranceListDto = convert(txnlistDetailedSubDto, HerdInsuranceListDto.class);
            //从金禾中间表取值
            herdInsuranceListDto.setfCode(txnlistDetailedSubDto.getfCode());
            herdInsuranceListDto.setInsurePremium(txnlistDetailedSubDto.getfPremium());
            herdInsuranceListDto.setOpCode(SinoRequestContext.getCurrentContext().getUserCode());
            herdInsuranceListDto.setOpTime(new Date());
            herdInsuranceListDto.setAreaNumber(0.00);//老系统写死
            //将每组数据放到list中
            herdInsuranceListDtoList.add(herdInsuranceListDto);
        }

        boolean flag = false;
        this.saveinsureMainLIstMethod(times, insureMainListDto);
        try {
            //保存清单子表
            if (StringUtils.isNotEmpty(herdInsuranceListDtoList.get(0).getEarlAbel())) {
                //在此先删后插，为了防止上一次操作与本次操作的险别条数不一样，可能会导致数据错误。
                herdInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                herdInsuranceListService.saveByList(herdInsuranceListDtoList);
            } else {
                List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList = new ArrayList<>();
                convertCollection(herdInsuranceListDtoList, middleHerdInsuranceListDtoList, MiddleHerdInsuranceListDto.class);
                middleHerdInsuranceListService.removeByInusreListcode(insureMainListDto.getInusreListCode());
                middleHerdInsuranceListService.saveByList(middleHerdInsuranceListDtoList);
            }
            flag = true;
        } catch (Exception e) {
            throw new DataVerifyException("保存清单子表信息失败！");
        }
        return flag;
    }

    /**
     * 31险类
     * 根据标的清单号查询plantingInsuranceList表信息
     *
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @Override
    public Map<String, InsuranceInfoDto> findInsuranceInfo(RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        List<String> itemListCodeList = requestInsuranceInfoDto.getItemListCodeList();
        String insureListCode = requestInsuranceInfoDto.getInsureListCode();//我方清单编号
        String gisInsureListCode = requestInsuranceInfoDto.getGisInsureListCode();//金禾清单编号
        List<String> itemCodeList = requestInsuranceInfoDto.getItemCodeList();
        List<String> kindCodeList = requestInsuranceInfoDto.getKindCodeList();
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单号不可为空！");
        }
        Integer serialNo = requestInsuranceInfoDto.getSerialNo();
        if (serialNo == null) {
            throw new DataVerifyException("序列号不可为空！");
        }
        Map<String, InsuranceInfoDto> map = new HashMap<>();
        InsuranceInfoDto insuranceInfoDto = new InsuranceInfoDto();
        //查询总的农户数量
        int conut = plantingInsuranceListDao.getSumInsured(insureListCode);
        String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
        for (int i = 0; i < kindCodeList.size(); i++) {
            KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
            insuranceInfoDto = plantingInsuranceListDao.queryByConditioin(insureListCode, itemCodeList.get(i), kindCodeList.get(i), gisInsureListCode, serialNo, itemListCodeList.get(i));
            insuranceInfoDto.setConut(conut);//将农户数量放到insuranceInfoDto中
            map.put(KingItemCode, insuranceInfoDto);
        }
        return map;
    }

    /**
     * 31大棚蔬菜险类
     * 根据标的清单号查询plantingInsuranceList表信息
     *
     * @param requestInsuranceInfoDto 请求入参，具体见dto
     * @return java.util.Map<java.lang.String,com.sinosoft.txnlist.api.gisinsurelist.dto.InsuranceInfoDto> 返回标的清单号对应的plantinginsuranceListDto信息
     * @throws Exception
     * @author 李冬松
     * @date 15:44 2018/1/19
     */
    @Override
    public Map<String, InsuranceInfoDto> find31InsuranceInfo(RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        List<String> itemListCodeList = requestInsuranceInfoDto.getItemListCodeList();
        String insureListCode = requestInsuranceInfoDto.getInsureListCode();//我方清单编号
        String gisInsureListCode = requestInsuranceInfoDto.getGisInsureListCode();//金禾清单编号
        List<String> itemCodeList = requestInsuranceInfoDto.getItemCodeList();
        List<String> kindCodeList = requestInsuranceInfoDto.getKindCodeList();
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单号不可为空！");
        }
        Integer serialNo = requestInsuranceInfoDto.getSerialNo();
        if (serialNo == null) {
            throw new DataVerifyException("序列号不可为空！");
        }
        Map<String, InsuranceInfoDto> map = new HashMap<>();
        InsuranceInfoDto insuranceInfoDto = new InsuranceInfoDto();
        //查询总的农户数量
        int conut = planting31InsuranceListDao.getSumInsured(insureListCode);
        String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
        for (int i = 0; i < kindCodeList.size(); i++) {
            KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
            insuranceInfoDto = planting31InsuranceListDao.queryByConditioin(insureListCode, kindCodeList.get(i), itemCodeList.get(i), gisInsureListCode, serialNo, itemListCodeList.get(i));
            insuranceInfoDto.setConut(conut);//将农户数量放到insuranceInfoDto中
            map.put(KingItemCode, insuranceInfoDto);
        }
        return map;
    }

    /**
     * 32险类
     * 根据标的清单号查询herdInsuranceList表信息
     *
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     * @author: 田健
     * @date: 2018/3/2 17:21
     */
    @Override
    public Map<String, NyxInsuranceInfoDto> findHerdInsuranceInfo(RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        List<String> itemListCodeList = requestInsuranceInfoDto.getItemListCodeList();
        String insureListCode = requestInsuranceInfoDto.getInsureListCode();//我方清单编号
        String gisInsureListCode = requestInsuranceInfoDto.getGisInsureListCode();//金禾清单编号
        List<String> kindCodeList = requestInsuranceInfoDto.getKindCodeList();
        List<String> itemCodeList = requestInsuranceInfoDto.getItemCodeList();
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单号不可为空！");
        }
        Integer serialNo = requestInsuranceInfoDto.getSerialNo();
        if (serialNo == null) {
            throw new DataVerifyException("序列号不可为空！");
        }
        if (StringUtils.isEmpty(gisInsureListCode)) {
            throw new DataVerifyException("金禾清单号不可为空！");
        }
        Map<String, NyxInsuranceInfoDto> herdInsuranceInfoDtoMap = new HashMap<>();
        NyxInsuranceInfoDto nyxInsuranceInfoDto = null;
        //查询总的农户数量
        int conut = herdInsuranceListDao.getSumInsured(insureListCode);
        if (conut == 0) {
            conut = middleHerdInsuranceListDao.getSumInsured(insureListCode);
        }
        String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
        for (int i = 0; i < itemListCodeList.size(); i++) {
            KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
            nyxInsuranceInfoDto = new NyxInsuranceInfoDto();
            nyxInsuranceInfoDto = herdInsuranceListDao.queryByConditioin(insureListCode, itemListCodeList.get(i), serialNo, gisInsureListCode, kindCodeList.get(i), itemCodeList.get(i));
            if (nyxInsuranceInfoDto.getfPremium() == null) {//如果herdInsuranceInfoDto为null，则表示耳标号没有，数据存中间表
                nyxInsuranceInfoDto = middleHerdInsuranceListDao.queryByConditioinForHerd(insureListCode, itemListCodeList.get(i), serialNo, gisInsureListCode, kindCodeList.get(i), itemCodeList.get(i));
            }
            nyxInsuranceInfoDto.setConut(conut);//将农户数量放到insuranceInfoDto中
            herdInsuranceInfoDtoMap.put(KingItemCode, nyxInsuranceInfoDto);
        }
        return herdInsuranceInfoDtoMap;
    }

    /**
     * 32险类，存nyxinsurancelist
     * 根据标的清单号查询herdInsuranceList表信息
     *
     * @param requestInsuranceInfoDto 清单号、标的清单集合
     * @return map中的key值是标的清单号，value值是此标的清单下的农户信息金额集合
     * @throws Exception
     * @author: 田健
     * @date: 2018/3/2 17:21
     */
    @Override
    public Map<String, NyxInsuranceInfoDto> findNyxInsuranceInfo(RequestInsuranceInfoDto requestInsuranceInfoDto) throws Exception {
        List<String> itemListCodeList = requestInsuranceInfoDto.getItemListCodeList();
        List<String> itemCodeList = requestInsuranceInfoDto.getItemCodeList();
        List<String> kindCodeList = requestInsuranceInfoDto.getKindCodeList();//险别代码
        String insureListCode = requestInsuranceInfoDto.getInsureListCode();//我方清单编号
        String gisInsureListCode = requestInsuranceInfoDto.getGisInsureListCode();//金禾清单编号
        String riskCode = requestInsuranceInfoDto.getRiskCode();
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单号不可为空！");
        }
        Integer serialNo = requestInsuranceInfoDto.getSerialNo();
        if (serialNo == null) {
            throw new DataVerifyException("序列号不可为空！");
        }
        if (StringUtils.isEmpty(gisInsureListCode)) {
            throw new DataVerifyException("金禾清单号不可为空！");
        }
        Map<String, NyxInsuranceInfoDto> herdInsuranceInfoDtoMap = new HashMap<>();
        NyxInsuranceInfoDto nyxInsuranceInfoDto;
        //查询总的农户数量
        int conut = nyxInsuranceListDao.getSumInsured(insureListCode);

        String KingItemCode = "";//将标的险别拼接成字符串作为唯一识别id
        if ("31".equals(riskCode.substring(0, 2))) {
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                if ("3129".equals(riskCode) && "".equals(kindCodeList.get(i))) {
                    int cot = cmtManFieldListDao.findAllByIn(insureListCode);
                    conut += cot;
                }
                nyxInsuranceInfoDto = nyxInsuranceListDao.queryByConditioinForPlant(insureListCode, itemListCodeList.get(i), serialNo, gisInsureListCode, itemCodeList.get(i), kindCodeList.get(i));
                nyxInsuranceInfoDto.setConut(conut);//将农户数量放到insuranceInfoDto中
                herdInsuranceInfoDtoMap.put(KingItemCode, nyxInsuranceInfoDto);
            }
        } else {
            HerdInsuranceInfoDto herdInsuranceInfoDto;
            for (int i = 0; i < kindCodeList.size(); i++) {
                KingItemCode = kindCodeList.get(i) + itemCodeList.get(i);
                nyxInsuranceInfoDto = nyxInsuranceListDao.queryByConditioinForHerd(insureListCode, itemListCodeList.get(i), serialNo, gisInsureListCode, itemCodeList.get(i), kindCodeList.get(i));
                if (nyxInsuranceInfoDto.getfPremium() == null) {//如果herdInsuranceInfoDto为null，则表示耳标号没有，数据存中间表
                    conut = middleHerdInsuranceListDao.getSumInsured(insureListCode);
                    nyxInsuranceInfoDto = middleHerdInsuranceListDao.queryByConditioinForHerd(insureListCode, itemListCodeList.get(i), serialNo, gisInsureListCode, itemCodeList.get(i), kindCodeList.get(i));
                }
                nyxInsuranceInfoDto.setConut(conut);//将农户数量放到insuranceInfoDto中
                herdInsuranceInfoDtoMap.put(KingItemCode, nyxInsuranceInfoDto);
            }
        }
        return herdInsuranceInfoDtoMap;
    }

    @Override
    public GisInsureMainListDto queryByPk(String gisInsureMainListCode, String serialNo) throws Exception {
        Integer serial = Integer.parseInt(serialNo);
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.queryAllByInsureListCodeAndSerialNo(gisInsureMainListCode, serial);
        GisInsureMainListDto gisInsureMainListDto = convert(gisInsureMainList, GisInsureMainListDto.class);
        return gisInsureMainListDto;
    }

    /**
     * 根据清单编号、序号、标的代码
     *
     * @param insureListCode 清单编号
     * @param serialNo       序号
     * @param itemCode       标的代码
     * @return itemListCode 标的清单编号
     * @author: 何伟东
     * @date: 2018/01/22 20:39
     */
    @Override
    public String queryItemListCodeByPK(String insureListCode, Integer serialNo, String itemCode) {
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单编号不能为空！");
        }
        if (serialNo == null) {
            throw new DataVerifyException("序号不能为空！");
        }
        if (StringUtils.isEmpty(itemCode)) {
            throw new DataVerifyException("标的代码不能为空！");
        }
        GisItemList gisItemList = gisItemListDao.findOne(new GisItemListKey(insureListCode, serialNo, itemCode));
        if (gisItemList == null) {
            throw new DataVerifyException("没有查询到该清单的标的信息！");
        }
        return gisItemList.getItemListCode();
    }

    /**
     * 保存和校验接收的金禾投保预确认清单数据
     *
     * @param gisItemListRequestDto 接收金禾数据的dto
     * @return true-成功
     * @author: 何伟东
     * @date: 2018/01/30 9:08
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveAndCheckGisInsureList(GisItemListRequestDto gisItemListRequestDto) throws Exception {
        LOGGER.error("开始接收投保预确认清单数据");
        long startTime = System.currentTimeMillis();
        // 基本的非空校验数据
        this.checkGisInsureList(gisItemListRequestDto);
        long checkEndTime = System.currentTimeMillis();
        LOGGER.error("非空校验数据耗时：" + ((checkEndTime - startTime) / 1000.00) + " s");
        // 把入参转换成容易保存的结构数据
        GisInsureListDto gisInsureListDto = this.buildGisInsureListDto(gisItemListRequestDto);
        long buildEndTime = System.currentTimeMillis();
        LOGGER.error("构建数据Dto耗时：" + ((buildEndTime - checkEndTime) / 1000.00) + " s");
        // 业务数据校验
        this.checkBusinessData(gisInsureListDto);
        long businessCheckTime = System.currentTimeMillis();
        LOGGER.error("业务数据校验耗时：" + ((businessCheckTime - buildEndTime) / 1000.00) + " s");
        // 保存数据
        this.saveGisInsureList(gisInsureListDto);
        long saveEndTime = System.currentTimeMillis();
        LOGGER.error("保存数据据耗时：" + ((saveEndTime - businessCheckTime) / 1000.00) + " s");
        LOGGER.error("总耗时耗时：" + ((saveEndTime - startTime) / 1000.00) + " s");
        LOGGER.error("接收投保预确认清单数据结束");
        return true;
    }

    /**
     * 根据清单号和序号查询农户的承保明细内容
     *
     * @param insureMainList
     * @param serialNo
     * @param fCode
     * @return GisFieldListDto
     * @author: 王保良，何伟东2018/4/27修改
     * @date: 2018/01/30 9:08
     */
    @Override
    public PageInfo queryGisFieldList(String insureMainList, Integer serialNo, String fCode, String itemCode, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(insureMainList)) {
            throw new DataVerifyException("清单编号不能为空");
        }
        if (serialNo == null) {
            throw new DataVerifyException("序号不能为空");
        }
        if (StringUtils.isEmpty(fCode)) {
            throw new DataVerifyException("农户代码不能为空");
        }
        if (StringUtils.isEmpty(itemCode)) {
            throw new DataVerifyException("标的代码不能为空");
        }
        // 有耳标号的标的,查看耳标号清单
        String earLabelItem = "bb110,aa140";
        // 连带被保险人标的,查看连带被保险人清单
        String joinInsuredItem = "ZZ200";
        // 小额贷款责任险标的，查看贷款信息
        String loadItem = "YY100";
        // 类种植险的养殖险标的,查看地图信息
        String similarPlantingItem = "dd210,dd230";

        String tableName;
        String detailsType;
        // 有耳标号的标的,查看耳标号清单
        if (earLabelItem.contains(itemCode)) {
            tableName = "GisHerdFieldList";
            detailsType = "earLabel";
        }
        // 连带被保险人标的,查看连带被保险人清单
        else if (joinInsuredItem.equals(itemCode)) {
            tableName = "GisManFieldList";
            detailsType = "joinInsured";
        }
        // 小额贷款责任险标的，查看贷款信息
        else if (loadItem.equals(itemCode)) {
            tableName = "GisFarmerList";
            detailsType = "load";
        }
        // 类种植险的养殖险标的,查看地图信息
        else if (similarPlantingItem.contains(itemCode)) {
            tableName = null;
            detailsType = "showMap";
        }
        // 其他的种植险标的全部都是查看田块信息
        else {
            tableName = "GisFieldList";
            detailsType = "other";
        }
        // 统一封装分页响应dto
        PageInfo pageInfo = new PageInfo<>();
        if (StringUtils.isNotEmpty(tableName)) {
            StringBuilder countSql = new StringBuilder("SELECT count(1) FROM ");
            String whereSql = " i where  i.insureListCode = :insureListCode AND i.serialNo = :serialNo AND i.fCode = :fCode";
            countSql.append(tableName).append(whereSql);
            Query countQuery = entityManager.createQuery(countSql.toString());
            countQuery.setParameter("insureListCode", insureMainList);
            countQuery.setParameter("serialNo", serialNo);
            countQuery.setParameter("fCode", fCode);
            Long countSize = (Long) countQuery.getSingleResult();
            if (countSize > 0) {
                StringBuilder dataSql = new StringBuilder("SELECT i FROM ");
                dataSql.append(tableName).append(whereSql);
                Query dataQuery = entityManager.createQuery(dataSql.toString());
                dataQuery.setParameter("insureListCode", insureMainList);
                dataQuery.setParameter("serialNo", serialNo);
                dataQuery.setParameter("fCode", fCode);
                dataQuery.setFirstResult((pageNo - 1) * pageSize);
                dataQuery.setMaxResults(pageSize);
                List resultList = dataQuery.getResultList();
                InsureDetailsDto insureDetailsDto = new InsureDetailsDto();
                insureDetailsDto.setDetailsType(detailsType);
                insureDetailsDto.setContent(resultList);
                // 数据存放dto集合
                pageInfo.setContent(Arrays.asList(insureDetailsDto));
                // 总记录数
                pageInfo.setTotalCount(countSize);
            }
        } else {
            InsureDetailsDto insureDetailsDto = new InsureDetailsDto();
            insureDetailsDto.setDetailsType(detailsType);
            pageInfo.setContent(Arrays.asList(insureDetailsDto));
            // 总记录数
            pageInfo.setTotalCount(0);
        }
        // 当前页数
        pageInfo.setPages(pageNo);

        return pageInfo;
    }

    /**
     * 根据清单号和序号农户代码查询耳标号信息）
     *
     * @param insureMainList 清单号
     * @param serialNo       序列号
     * @param fCode          农户代码
     * @return GisHerdFieldListDto集合  预投保清单农户标的清单明细表（物）Dto
     * @throws Exception
     * @author: 田健
     * @date: 2018/3/7 11:49
     */
    @Override
    public PageInfo<GisHerdFieldListDto> queryHerdGisFieldList(String insureMainList, Integer serialNo, String fCode, Integer pageNo, Integer pageSize) throws Exception {
        if (StringUtils.isEmpty(insureMainList)) {
            throw new DataVerifyException("清单编号不能为空");
        }
        if (serialNo == null) {
            throw new DataVerifyException("序号不能为空");
        }
        List<String> list = new ArrayList<>();
        list.add(fCode);
        List<GisHerdFieldList> gisHerdFieldLists = gisHerdFieldListDao.findGisHerdFieldListByInsureListCodeAndSerialNoAndFCode(insureMainList, serialNo, list);
        Long count = gisHerdFieldListDao.findCountByInsureListCodeAndSerialNoAndFCode(insureMainList, serialNo, list);
        List<GisHerdFieldListDto> gisHerdFieldListDtoList = new ArrayList<>();
        convertCollection(gisHerdFieldLists, gisHerdFieldListDtoList, GisHerdFieldListDto.class);
        // 统一封装分页响应dto
        PageInfo<GisHerdFieldListDto> pageInfo = new PageInfo<>();
        // 数据存放dto集合
        pageInfo.setContent(gisHerdFieldListDtoList);
        // 当前页数
        pageInfo.setPages(pageNo);
        // 总记录数
        pageInfo.setTotalCount(count);
        return pageInfo;
    }

    /**
     * 保存金禾交易清单中间表数据
     *
     * @param gisInsureListDto 金禾交易清单中间表dto
     * @return true-成功
     * @date: 2018/01/30 9:08
     * @author: 何伟东
     */
    public Boolean saveGisInsureList(GisInsureListDto gisInsureListDto) throws Exception {
        if (gisInsureListDto == null) {
            throw new DataVerifyException("数据不能为空！");
        }
        GisInsureMainListDto gisInsureMainListDto = gisInsureListDto.getGisInsureMainListDto();
        if (gisInsureMainListDto == null) {
            throw new DataVerifyException("主表数据不能为空！");
        }
        List<? extends GisFarmerListDto> gisFarmerListDtos = gisInsureListDto.getGisFarmerListDtos();
        if (gisFarmerListDtos == null || gisFarmerListDtos.size() < 1) {
            throw new DataVerifyException("农户数据不能为空！");
        }
        List<GisItemListDto> gisItemListDtos = gisInsureListDto.getGisItemListDtos();
        if (gisItemListDtos == null || gisItemListDtos.size() < 1) {
            throw new DataVerifyException("标的数据不能为空！");
        }
        List<? extends GisFarmerItemDto> gisFarmerItemDtos = gisInsureListDto.getGisFarmerItemDtos();
        if (gisFarmerItemDtos == null || gisFarmerItemDtos.size() < 1) {
            throw new DataVerifyException("农户标的关联数据不能为空！");
        }
        String insureListCode = gisInsureMainListDto.getInsureListCode();
        // 1、生成最新序列号 如果没有查到则为零
        Integer serialNo = gisInsureMainListDao.getMaxSerialNo(insureListCode) + 1;
        // 2、判断是否最新保单标志 Y N 如果序列号为1 则说明是库里没有记录，是最新保单
        if (serialNo > 1) {
            //3、修改库里其它记录为非最新保单标志
            gisInsureMainListDao.updateNewFlag(insureListCode, "N");
        }
        // 保存主表数据
        GisInsureMainList gisInsureMainList = convert(gisInsureMainListDto, GisInsureMainList.class);
        gisInsureMainList.setSerialNo(serialNo);
        entityManager.persist(gisInsureMainList);// 只有一条主表数据所以用entityManager.persist
        entityManagerFlushAndClear();
        // 保存标的数据
        List<GisItemList> gisItemLists = new ArrayList<>();
        convertCollection(gisItemListDtos, gisItemLists, GisItemList.class);
        for (int i = 0; i < gisItemLists.size(); i++) {
            GisItemList gisItemList = gisItemLists.get(i);
            gisItemList.setSerialNo(serialNo);
        }
        this.saveBatchByJdbc(gisItemLists);
        // 保存农户数据
        List<GisFarmerList> gisFarmerLists = new ArrayList<>();
        convertCollection(gisFarmerListDtos, gisFarmerLists, GisFarmerList.class);
//        Map<String, ? extends List<? extends GisFarmerListDto>> gisFarmerListDtoByfCode = gisFarmerListDtos.stream().collect(Collectors.groupingBy(GisFarmerListDto::getfCode));
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < gisFarmerLists.size(); i++) {
            GisFarmerList gisFarmerList = gisFarmerLists.get(i);
//            GisFarmerListDto gisFarmerListDto = gisFarmerListDtoByfCode.get(gisFarmerList.getfCode()).get(0);
//            String loanPeriod = gisFarmerListDto.getLoanPeriod();
//            String loadAmount = gisFarmerListDto.getLoadAmount();
//            gisFarmerList.setLoanPeriod(dateFormat.parse(loanPeriod));
//            gisFarmerList.setLoadAmount(Double.parseDouble(loadAmount));
            gisFarmerList.setInsureListCode(gisInsureMainList.getInsureListCode());
            gisFarmerList.setSerialNo(serialNo);
        }
        this.saveBatchByJdbc(gisFarmerLists);
        // 保存农户标的关联表数据
        List<GisFarmerItem> gisFarmerItems = new ArrayList<>();
        convertCollection(gisFarmerItemDtos, gisFarmerItems, GisFarmerItem.class);
        for (int i = 0; i < gisFarmerItems.size(); i++) {
            GisFarmerItem gisFarmerItem = gisFarmerItems.get(i);
            gisFarmerItem.setSerialNo(serialNo);
        }
        this.saveBatchByJdbc(gisFarmerItems);
        // 田块信息数据
        List<GisFieldListDto> gisFieldListDtos = gisInsureListDto.getGisFieldListDtos();
        if (gisFieldListDtos != null && gisFieldListDtos.size() > 0) {
            List<GisFieldList> gisFeildDtos = new ArrayList<>();
            convertCollection(gisFieldListDtos, gisFeildDtos, GisFieldList.class);
            for (int i = 0; i < gisFeildDtos.size(); i++) {
                GisFieldList gisFieldList = gisFeildDtos.get(i);
                gisFieldList.setSerialNo(serialNo);
            }
            this.saveBatchByJdbc(gisFeildDtos);
        }
        // 农户标的清单明细表（物）
        List<GisHerdFieldListDto> gisHerdFieldListDtos = gisInsureListDto.getGisHerdFieldListDtos();
        if (gisHerdFieldListDtos != null && gisHerdFieldListDtos.size() > 0) {
            List<GisHerdFieldList> gisHerdFieldLists = new ArrayList<>();
            convertCollection(gisHerdFieldListDtos, gisHerdFieldLists, GisHerdFieldList.class);
            for (int i = 0; i < gisHerdFieldLists.size(); i++) {
                GisHerdFieldList gisHerdFieldList = gisHerdFieldLists.get(i);
                gisHerdFieldList.setSerialNo(serialNo);
            }
            this.saveBatchByJdbc(gisHerdFieldLists);
        }
        // 农户标的清单明细表（人）
        List<GisManFieldListDto> gisManFieldListDtos = gisInsureListDto.getGisManFieldListDtos();
        if (gisManFieldListDtos != null && gisManFieldListDtos.size() > 0) {
            List<GisManFieldList> gisManFieldLists = new ArrayList<>();
            convertCollection(gisManFieldListDtos, gisManFieldLists, GisManFieldList.class);
            gisManFieldLists.forEach(gisManFieldList -> gisManFieldList.setSerialNo(serialNo));
            for (int i = 0; i < gisManFieldLists.size(); i++) {
                GisManFieldList gisManFieldList = gisManFieldLists.get(i);
                gisManFieldList.setSerialNo(serialNo);
            }
            this.saveBatchByJdbc(gisManFieldLists);
        }
        return true;
    }


    /**
     * jdbc 的批量保存方法
     * @param list
     */
    private void saveBatchByJdbc(List list) {
        JdbcUtils jdbcUtils = this.getJdbcUtils();
        jdbcUtils.insertBatch(list);
    }

    private JdbcUtils getJdbcUtils() {
        if (jdbcUtils == null) {
            jdbcUtils = new JdbcUtils(DRIVER_CLASS_NAME, DATASOURCE_URL, DATASOURCE_USERNAME, DATASOURCE_PASSWORD);
        }
        return jdbcUtils;
    }

    private void entityManagerFlushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    /**
     * 校验金禾投保预确认清单的数据质量
     * 此方法仅校验简单的字段不为空和总分校验,与业务相关的校验在checkBusinessData中实现
     *
     * @param gisItemListRequestDto 从报文中解析得到的数据
     * @return true-校验通过
     * @date: 2018/1/31 16:02
     * @author: 何伟东
     */
    private void checkGisInsureList(GisItemListRequestDto gisItemListRequestDto) throws Exception {
        if (gisItemListRequestDto == null) {
            throw new DataVerifyException("清单主信息不能为空");
        }
        // 校验农户数量，总分是否一致
        Integer fCount = gisItemListRequestDto.getfCount();
        List<FarmerRequestDto> farmerList = gisItemListRequestDto.getFarmerList();
        if (farmerList != null && farmerList.size() > 0) {
            if (farmerList.size() != fCount) {
                throw new DataVerifyException("主表农户数量fCount与实际农户数量不一致");
            }
        } else {
            throw new DataVerifyException("农户信息不能为空");
        }
        // 主表数据校验
        // 清单类型可以为空
        if (StringUtils.isNotEmpty(gisItemListRequestDto.getListTypeFlag())) {
            CheckDataConstant.MAIN_FIELD.put("listTypeFlag", new String[]{"P", "E"});
        } else {
            CheckDataConstant.MAIN_FIELD.remove("listTypeFlag");
        }
        this.subCheckField(gisItemListRequestDto.getClass(), gisItemListRequestDto, CheckDataConstant.MAIN_FIELD);
        // 标的数据校验
        List<GisItemListDto> gisItemListDtos = gisItemListRequestDto.getItemList();
        if (gisItemListDtos != null && gisItemListDtos.size() > 0) {
            for (GisItemListDto gisItemListDto : gisItemListDtos) {
                this.subCheckField(gisItemListDto.getClass(), gisItemListDto, CheckDataConstant.ITEM_FIELD);
            }
        } else {
            throw new DataVerifyException("标的信息不能为空");
        }
        // 农户数据校验
        List<FarmerRequestDto> gisFarmerLists = gisItemListRequestDto.getFarmerList();
        if (gisFarmerLists != null && gisFarmerLists.size() > 0) {
            for (int i = 0; i < gisFarmerLists.size(); i++) {
                FarmerRequestDto farmerRequestDto = gisFarmerLists.get(i);
                if (farmerRequestDto != null) {
                    // 农户主要信息校验
                    this.subCheckField(farmerRequestDto.getClass(), farmerRequestDto, CheckDataConstant.FARMER_FIELD);
                    List<FarmerItemRequestDto> farmerItemList = farmerRequestDto.getFarmerItemList();
                    if (farmerItemList != null && farmerItemList.size() > 0) {
                        for (int j = 0; j < farmerItemList.size(); j++) {
                            FarmerItemRequestDto farmerItemRequestDto = farmerItemList.get(j);
                            // 农户标的信息关联数据校验
                            this.subCheckField(farmerItemRequestDto.getClass(), farmerItemRequestDto, CheckDataConstant.FARMER_ITEM_FIELD);
                            // 农户标的清单明细（物）数据校验
                            List<GisHerdFieldListDto> herdFieldList = farmerItemRequestDto.getHerdFieldList();
                            if (herdFieldList != null && herdFieldList.size() > 0) {
                                for (int k = 0; k < herdFieldList.size(); k++) {
                                    GisHerdFieldListDto gisHerdFieldListDto = herdFieldList.get(k);
                                    if (gisHerdFieldListDto != null) {
                                        this.subCheckField(gisHerdFieldListDto.getClass(), gisHerdFieldListDto, CheckDataConstant.FARMER_ITEM_HERD_FIELD);
                                    } else {
                                        throw new DataVerifyException("农户标的清单明细（物）不能为空");
                                    }
                                }
                            }
                            // 农户标的清单明细（人）数据校验
                            List<GisManFieldListDto> manFieldList = farmerItemRequestDto.getManFieldList();
                            if (manFieldList != null && manFieldList.size() > 0) {
                                for (int l = 0; l < manFieldList.size(); l++) {
                                    GisManFieldListDto gisManFieldListDto = manFieldList.get(l);
                                    if (gisManFieldListDto != null) {
                                        this.subCheckField(gisManFieldListDto.getClass(), gisManFieldListDto, CheckDataConstant.FARMER_ITEM_MAN_FIELD);
                                    } else {
                                        throw new DataVerifyException("农户标的清单明细（人）不能为空");
                                    }
                                }
                            }
                        }
                    } else {
                        throw new DataVerifyException("农户的标的信息不能为空");
                    }
                    // 农户的田块信息校验
                    List<GisFieldListDto> plantingFieldList = farmerRequestDto.getPlantingFieldList();
                    if (plantingFieldList != null && plantingFieldList.size() > 0) {
                        for (int m = 0; m < plantingFieldList.size(); m++) {
                            GisFieldListDto gisFieldListDto = plantingFieldList.get(m);
                            if (gisFieldListDto != null) {
                                this.subCheckField(gisFieldListDto.getClass(), gisFieldListDto, CheckDataConstant.FARMER_FIELD_FIELD);
                            } else {
                                throw new DataVerifyException("农户田块信息不能为空");
                            }
                        }
                    }
                } else {
                    throw new DataVerifyException("农户信息不能为空");
                }
            }
        } else {
            throw new DataVerifyException("农户信息不能为空");
        }
    }

    /**
     * 投保预确认清单的业务数据质量校验
     *
     * @param gisInsureListDto 构建完成的dto数据
     * @author: 何伟东
     * @date: 2018/4/25 9:40
     */
    private void checkBusinessData(GisInsureListDto gisInsureListDto) {
        // 校验投保小额贷款责任险的农户的必传信息
        // 小额贷款责任险代码
        String loanItemCode = "YY100";
        List<? extends GisFarmerListDto> gisFarmerListDtos = gisInsureListDto.getGisFarmerListDtos();
        List<? extends GisFarmerItemDto> gisFarmerItemDtos = gisInsureListDto.getGisFarmerItemDtos();
        Map<String, ? extends List<? extends GisFarmerListDto>> gisFarmerListDtoByfCode = gisFarmerListDtos.stream().collect(Collectors.groupingBy(GisFarmerListDto::getfCode));
        gisFarmerItemDtos.forEach(gisFarmerItemDto -> {
            String itemCode = gisFarmerItemDto.getItemCode();
            String fCode = gisFarmerItemDto.getfCode();
            if (loanItemCode.equals(itemCode)) {
                GisFarmerListDto gisFarmerListDto = gisFarmerListDtoByfCode.get(fCode).get(0);
                // 行业类别
                String industryCategory = gisFarmerListDto.getIndustryCategory();
                if (StringUtils.isEmpty(industryCategory)) {
                    throw new DataVerifyException("投保小额贷款责任险的农户行业类别(industryCategory)不能为空！");
                }
                // 贷款金额
                String loadAmount = gisFarmerListDto.getLoadAmount();
                if (StringUtils.isEmpty(loadAmount)) {
                    throw new DataVerifyException("投保小额贷款责任险的农户贷款金额(loadAmount)不能为空！");
                } else {
                    try {
                        double _loadAmount = Double.parseDouble(loadAmount);
                        if (_loadAmount <= 0) {
                            throw new DataVerifyException("投保小额贷款责任险的农户贷款金额(loadAmount)需要大于0！");
                        }
                    } catch (NumberFormatException e) {
                        throw new DataVerifyException("投保小额贷款责任险的农户贷款金额(loadAmount)格式不正确！");
                    }

                }
            }
        });
        //校验金禾传的4、5级区域代码是否为空，如果为空则存999与老系统核心保持一致
        GisInsureMainListDto gisInsureMainListDto = gisInsureListDto.getGisInsureMainListDto();
        if(StringUtils.isEmpty(gisInsureMainListDto.getpTownCode())){//如果镇级区域代码为空，则县级前6位加999000
            gisInsureMainListDto.setpTownCode(gisInsureMainListDto.getpCountyCode().substring(0,6)+"999000");
            gisInsureMainListDto.setpTownName("其他");
        }
        if(StringUtils.isEmpty(gisInsureMainListDto.getpVillageCode())){//如果村级区域代码没传，则镇级前九位加999
            gisInsureMainListDto.setpVillageCode(gisInsureMainListDto.getpTownCode().substring(0,9)+"999");
            gisInsureMainListDto.setpVillageName("其他");
        }
    }

    /**
     * 利用反射校验数据是否为空,或值是否在一个范围内
     *
     * @param object     待校验的数据
     * @param fieldNames 需要校验不为空的属性名称和范围
     * @date: 2018/2/1 17:43
     * @author: 何伟东
     */
    private <T> void subCheckField(Class<? extends T> oClass, T object, Map<String, String[]> fieldNames) throws Exception {
        Set<String> fieldSet = fieldNames.keySet();
        for (String fieldName : fieldSet) {
            Field oField = getField(oClass, fieldName);
            oField.setAccessible(true);
            Object getField = oField.get(object);
            boolean isCheck = this.subCheckField(getField, fieldNames.get(fieldName));
            if (!isCheck) {
                this.throwErrorMessage(fieldName, fieldNames.get(fieldName));
            }
        }
    }

    /**
     * 获取的指定属性的Field
     *
     * @param oClass   对象的class类
     * @param fielName 属性名
     * @return Field
     * @date: 2018/2/1 17:43
     * @author: 何伟东
     */
    private Field getField(Class<?> oClass, String fielName) throws NoSuchFieldException {
        Field declaredField = null;
        NoSuchFieldException noSuchFieldException = null;
        while (oClass != null) {
            try {
                declaredField = oClass.getDeclaredField(fielName);
            } catch (NoSuchFieldException e) {
                oClass = oClass.getSuperclass();
                if (noSuchFieldException == null) {
                    noSuchFieldException = e;
                }
                continue;
            }
            break;
        }
        if (declaredField == null) {
            throw noSuchFieldException;
        }
        return declaredField;
    }

    /**
     * 校验数据是否在可选范围内，或者是否为空
     *
     * @param field 待校验的数据
     * @param range 可选范围,可为空
     * @return true-符合规则，false-不符合规则
     * @date: 2018/2/1 14:26
     * @author: 何伟东
     */
    private <F> boolean subCheckField(F field, F[] range) {
        if (range == null || range.length < 1) {
            if (field instanceof String) {
                return StringUtils.isNotEmpty((String) field);
            } else if (field instanceof Double) {
                Double d = (Double) field;
                return d != null || !d.equals(0.0);
            } else {
                return field != null;
            }
        } else {
            for (F f : range) {
                if (f.equals(field)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 抛出错误信息
     *
     * @param fieldName 字段名称
     * @param range     字段的可选值范围，可以为空
     * @date: 2018/2/1 14:38
     * @author: 何伟东
     */
    private void throwErrorMessage(String fieldName, String[] range) {
        StringBuilder message = new StringBuilder();
        message.append(fieldName).append("的值不能为空");
        if (range != null && range.length > 0) {
            message.append("，并且需要在").append(Arrays.toString(range)).append("范围内");
        }
        LOGGER.error(message.toString());
        throw new DataVerifyException(message.toString());
    }

    /**
     * 将从报文中解析的数据转换成便于保存的结构
     *
     * @param gisItemListRequestDto 从报文中解析得到的数据
     * @return GisInsureListDto
     * @date: 2018/1/31 20:12
     * @author: 何伟东
     */
    private GisInsureListDto buildGisInsureListDto(GisItemListRequestDto gisItemListRequestDto) {
        GisInsureListDto gisInsureListDto = new GisInsureListDto();
        String insureListCode = gisItemListRequestDto.getInsureListCode();
        // 主表数据
        gisInsureListDto.setGisInsureMainListDto(gisItemListRequestDto);
        // 标的数据
        List<GisItemListDto> gisItemListDtos = gisItemListRequestDto.getItemList();
        Map<String, String> itemlistCode = new HashMap<>();
        gisItemListDtos.forEach(gisItemListDto -> {
            gisItemListDto.setInsureListCode(insureListCode);
            itemlistCode.put(gisItemListDto.getItemCode(), gisItemListDto.getItemListCode());
        });
        gisInsureListDto.setGisItemListDtos(gisItemListDtos);
        // 农户信息
        List<FarmerRequestDto> farmerList = gisItemListRequestDto.getFarmerList();
        farmerList.forEach(farmerRequestDto -> farmerRequestDto.setInusreListCode(insureListCode));
        gisInsureListDto.setGisFarmerListDtos(farmerList);

        // 农户田块数据
        List<GisFieldListDto> gisFieldListDtos = new ArrayList<>();
        // 农户标的明细信息（物）
        List<GisHerdFieldListDto> gisHerdFieldListDtos = new ArrayList<>();
        // 农户标的明细信息（人）
        List<GisManFieldListDto> gisManFieldListDtos = new ArrayList<>();
        farmerList.forEach(farmerRequestDto -> {
            String fCode = farmerRequestDto.getfCode();
            List<GisFieldListDto> plantingFieldList = farmerRequestDto.getPlantingFieldList();
            if (plantingFieldList != null && plantingFieldList.size() > 0) {
                plantingFieldList.forEach(gisFieldListDto -> {
                    gisFieldListDto.setInsureListCode(insureListCode);
                    gisFieldListDto.setfCode(fCode);
                });
                gisFieldListDtos.addAll(plantingFieldList);
            }
            List<FarmerItemRequestDto> farmerItemList = farmerRequestDto.getFarmerItemList();
            if (farmerItemList != null && farmerItemList.size() > 0) {
                // 农户标的关联表
                farmerItemList.forEach(farmerItemRequestDto -> {
                    farmerItemRequestDto.setInsureListCode(insureListCode);
                    farmerItemRequestDto.setfCode(fCode);
                    String itemCode = farmerItemRequestDto.getItemCode();
                    farmerItemRequestDto.setItemListCode(itemlistCode.get(itemCode));
                    List<GisHerdFieldListDto> herdFieldList = farmerItemRequestDto.getHerdFieldList();
                    if (herdFieldList != null && herdFieldList.size() > 0) {
                        herdFieldList.forEach(gisHerdFieldListDto -> {
                            gisHerdFieldListDto.setInsureListCode(insureListCode);
                            gisHerdFieldListDto.setItemCode(itemCode);
                            gisHerdFieldListDto.setfCode(fCode);
                        });
                        gisHerdFieldListDtos.addAll(herdFieldList);
                    }
                    List<GisManFieldListDto> manFieldList = farmerItemRequestDto.getManFieldList();
                    if (manFieldList != null && manFieldList.size() > 0) {
                        manFieldList.forEach(gisManFieldListDto -> {
                            gisManFieldListDto.setInsureListCode(insureListCode);
                            gisManFieldListDto.setItemCode(itemCode);
                            gisManFieldListDto.setfCode(fCode);
                        });
                        gisManFieldListDtos.addAll(manFieldList);
                    }
                });
                List<FarmerItemRequestDto> gisFarmerItemDtos = (List<FarmerItemRequestDto>) gisInsureListDto.getGisFarmerItemDtos();
                if (gisFarmerItemDtos != null) {
                    gisFarmerItemDtos.addAll(farmerItemList);
                } else {
                    gisInsureListDto.setGisFarmerItemDtos(farmerItemList);
                }
            }
        });
        gisInsureListDto.setGisFieldListDtos(gisFieldListDtos);
        gisInsureListDto.setGisHerdFieldListDtos(gisHerdFieldListDtos);
        gisInsureListDto.setGisManFieldListDtos(gisManFieldListDtos);
        return gisInsureListDto;
    }

    /**
     * 金禾的清单号和险种的标的匹配，有至少一个匹配时才能出单
     *
     * @param gisInsureListCode - 金禾的清单号码
     * @param serialNo          - 序号
     * @param riskCode          - 险种代码
     * @return message - 成功
     * @author: 何伟东
     * @date: 2018/4/27 11:02
     */
    @Override
    public String matchGisItemList(String gisInsureListCode, String serialNo, String riskCode) {
        if (StringUtils.isEmpty(gisInsureListCode)) {
            throw new DataVerifyException("金禾清单号码不能为空！");
        }
        if (StringUtils.isEmpty(serialNo)) {
            throw new DataVerifyException("序号不能为空！");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        List<GisItemList> gisItemLists = gisItemListDao.queryAllByInsureListCodeAndSerialNo(gisInsureListCode, Integer.parseInt(serialNo));
        List<String> itemCodes = new ArrayList<>();
        gisItemLists.forEach(gisItemList -> itemCodes.add(gisItemList.getItemCode()));
        Map<String, Object> param = new HashMap<>();
        param.put("riskCode", riskCode);
        param.put("itemCodes", itemCodes);
        Map<String, String> itemCodeMap = prpDitemApi.queryByItemCodes(param);
        if (itemCodeMap == null || itemCodeMap.size() < 1) {
            throw new BusinessException("所选险种与关联的清单没有匹配的标的，请重新选择！");
        }
        return "成功";
    }

    /**
     * 保费计算时校验标的清单与标的是否匹配（除新单外）
     *
     * @param gisInsureListCode 金禾清单编号
     * @param serialNo          序列号
     * @param itemCodeLists     标的代码集合
     * @param itemListCodes     标的清单号集合
     * @return map集合 ，key为1：数据匹配 ，0:数据不匹配
     * @author: 田健
     * @date: 2018/5/17 20:15
     */
    public Map<String, String> CheckItemCodeListMethod(String gisInsureListCode, Integer serialNo, List<String> itemCodeLists, List<String> itemListCodes) {
        Map<String, String> map = new HashMap<>();
        int count = 0;
        String flag = "0";
        for (int i = 0; i < itemCodeLists.size(); i++) {
            List<GisFarmerItem> gisFarmerItemList = gisFarmerItemDao.CheckItemCodeListMethod(gisInsureListCode, serialNo, itemCodeLists.get(i), itemListCodes.get(i));
            if (gisFarmerItemList.size() > 0) {
                count++;
            }
        }
        if (count == itemCodeLists.size()) {//如果flag等于itemCodeLists的条数代表标的清单数据全部符合
            flag = "1";
        }
        map.put("flag", flag);
        return map;
    }

    public List<GisFarmerItemDto> queryInsureCount(String gisInsureListCode, String serialNo, String itemCode) throws Exception {
        if (StringUtils.isEmpty(gisInsureListCode) || StringUtils.isEmpty(serialNo) || StringUtils.isEmpty(itemCode)) {
            throw new DataVerifyException("清单号或序列号或标的号为空！");
        }
        int serial = Integer.valueOf(serialNo);
        List<GisFarmerItem> gisFarmerItemList = gisFarmerItemDao.queryInsureCount(gisInsureListCode, serial, itemCode);
        List<GisFarmerItemDto> gisFarmerItemDtoList = new ArrayList<>();
        convertCollection(gisFarmerItemList, gisFarmerItemDtoList, GisFarmerItemDto.class);
        return gisFarmerItemDtoList;
    }

    public GisInsureMainListDto querySerialNo(String insureListCode) throws Exception {
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.findByInsureListCodeAndNewFlagEquals(insureListCode, "Y");
        return convert(gisInsureMainList, GisInsureMainListDto.class);
    }
}