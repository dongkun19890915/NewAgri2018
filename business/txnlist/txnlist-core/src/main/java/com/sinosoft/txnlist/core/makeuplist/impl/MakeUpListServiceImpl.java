package com.sinosoft.txnlist.core.makeuplist.impl;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.agri.core.gycore.dto.Farmer;
import com.sinosoft.framework.agri.core.gycore.dto.FarmerItem;
import com.sinosoft.framework.agri.core.gycore.dto.FarmerList;
import com.sinosoft.framework.agri.core.gycore.dto.GisHerdFieldListDto;
import com.sinosoft.framework.agri.core.utils.ExcelUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.txnlist.api.makeuplist.dto.*;
import com.sinosoft.txnlist.core.common.FileUtil;
import com.sinosoft.txnlist.core.gisinsurelist.dao.*;
import com.sinosoft.txnlist.core.gisinsurelist.entity.*;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.makeuplist.MakeUpListService;
import com.sinosoft.txnlist.core.makeuplist.readexcel.EarLabelExcelReadHandler;
import com.sinosoft.txnlist.core.makeuplist.readexcel.JoinInsuredReadHandler;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.HerdInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.MiddleHerdInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.MiddleHerdInsuranceList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 潘峰
 * @date 2018/1/22 上午10:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MakeUpListServiceImpl extends BaseServiceImpl implements MakeUpListService {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private InsureMainListDao insureMainListDao;

    @Autowired
    private PrpTmainApi prpTmainApi;

    @Autowired
    private GisHerdFieldListDao gisHerdFieldListDao;

    @Autowired
    private GisManFieldListDao gisManFieldListDao;

    @Autowired
    private MiddleHerdInsuranceListDao middleHerdInsuranceListDao;

    @Autowired
    private HerdInsuranceListDao herdInsuranceListDao;

    @Autowired
    private PrpDriskApi prpDriskApi;

    @Autowired
    private PrpDcompanyApi prpDcompanyApi;

    @Autowired
    private PrpDuserApi prpDuserApi;

    @Autowired
    private GisInsureMainListDao gisInsureMainListDao;

    @Autowired
    private GisFarmerItemDao gisFarmerItemDao;

    @Autowired
    private GisFarmerListDao gisFarmerListDao;

    @Autowired
    private GisItemListDao gisItemListDao;

    @Autowired
    private EntityManager entityManager;

    private static GYcoreUtil gYcoreUtil;

    private static QuicklyExportExcel quicklyExportExcel;

    /**
     * 有耳标号和连带被保险人的标的代码
     */
    private final List<String> EARLABLE_JOINTINSUREED_ITEM = Arrays.asList(new String[]{"aa140", "bb110", "ZZ200"});


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
     * 金禾webservice地址
     */
    @Value("${webservice.gycoreService.url}")
    private String gycoreService;

    private static FileUtil fileUtil;

    /**
     * ** 核保标志--** (0 初始值/ 1 通过/ 2 不通过/ 3 无需核保/ 9 待核保)
     */
    private String UNDERWRITEFLAG_INITIAL_VALUE = "0";

    /**
     * 查询导入清单列表
     *
     * @param gisInsureListCode
     * @return
     * @throws Exception
     */
    @Override
    public List<MakeUpListDto> queryMakeUpList(String gisInsureListCode) throws Exception {
        List<InsureMainList> insureMainLists = insureMainListDao.findByGisInsureListCode(gisInsureListCode);
        if (insureMainLists == null || insureMainLists.size() == 0) {
            throw new BusinessException("您输入的清单编号在系统中不存在，请重新输入！");
        }
        Map<String, String> map = new HashMap<>();
        List<MakeUpListDto> makeUpListDtoList = null;
        for (InsureMainList insureMainList : insureMainLists) {
            map.put("proposalNo", insureMainList.getProposalNo());
            map.put("underwriteFlag", UNDERWRITEFLAG_INITIAL_VALUE);
            PrpTmainDto prpTmainDto = prpTmainApi.queryByUnderwriteFlag(map);
            if (prpTmainDto == null) {
                throw new BusinessException("没有查到符合条件的投保单数据，请重新输入！");
            }

            Integer serialNo = insureMainList.getSerialNo();
            Integer herdCount = gisHerdFieldListDao.getCountByInsureListCode(gisInsureListCode);
            if (herdCount < 1) {
                Integer manCount = gisManFieldListDao.getCount(gisInsureListCode);
                if (manCount < 1) {
                    continue;
                }
            }

            MakeUpListDto makeUpListDto;
            makeUpListDto = this.convert(prpTmainDto, MakeUpListDto.class);

            String riskName = prpDriskApi.translateCodeByPK(prpTmainDto.getRiskCode());
            makeUpListDto.setRiskName(riskName);

            String comName = prpDcompanyApi.translateCodeByPK(prpTmainDto.getComCode());
            makeUpListDto.setComName(comName);

            String handlerName = prpDuserApi.translateCodeByPK(prpTmainDto.getHandlerCode());
            makeUpListDto.setHandler1Name(handlerName);
            makeUpListDtoList.add(makeUpListDto);

        }

        return makeUpListDtoList;
    }

    /**
     * 查询金禾清单关联的未提交核保投保单信息
     *
     * @param gisInsureListCode 金禾的清单号码
     * @author: 何伟东
     * @date: 2018/4/17 18:05
     */
    @Override
    public PageInfo<MakeUpListDto> queryMakeUpListByInsureListCode(String gisInsureListCode, int pageNo, int pageSize) throws Exception {
        Integer countByInsureListCode = gisInsureMainListDao.countByInsureListCode(gisInsureListCode);

        if (0 == countByInsureListCode) {
            throw new DataVerifyException("您输入的清单编号在系统中不存在，请重新输入!");
        }
//        Integer countGisHerdFieldList = gisHerdFieldListDao.getCountByInsureListCode(gisInsureListCode);
//        if (countGisHerdFieldList > 0) {
//            throw new DataVerifyException("此清单无需补录，请重新输入!");
//        } else {
//            Integer manCount = gisManFieldListDao.getCount(gisInsureListCode);
//            if (manCount > 0) {
//                throw new DataVerifyException("此清单无需补录，请重新输入!");
//            } else {
        // 根据金禾的清单号码查询还未提交核保的清单信息
        StringBuilder countSql = new StringBuilder("select count(distinct i.proposalNo) from InsureMainList i where i.gisInsureListCode=:gisInsureListCode and i.policyNo is null");
        StringBuilder dataSql = new StringBuilder("select distinct i.proposalNo from InsureMainList i where i.gisInsureListCode=:gisInsureListCode and i.policyNo is null");
        Query countQuery = entityManager.createQuery(countSql.toString());
        countQuery.setParameter("gisInsureListCode", gisInsureListCode);
        Long countSize = (Long) countQuery.getSingleResult();
        PageInfo<MakeUpListDto> makeUpListDtoPageInfo = new PageInfo<>();
        if (countSize > 0) {
            Query dataQuery = entityManager.createQuery(dataSql.toString());
            dataQuery.setParameter("gisInsureListCode", gisInsureListCode);
            dataQuery.setFirstResult((pageNo - 1) * pageSize);
            dataQuery.setMaxResults(pageSize);
            List<String> proposalNos = dataQuery.getResultList();
            List<MakeUpListDto> makeUpListDtos = new ArrayList<>();
            if (proposalNos != null && proposalNos.size() > 0) {
                Map<String, List<String>> reqMap = new HashMap<>(1);
                reqMap.put("proposalNos", proposalNos);
                List<PrpTmainDto> prpTmainDtos = null;
                try {
                    prpTmainDtos = prpTmainApi.queryInitialProposal(reqMap);
                } catch (Exception e) {
//                    throw new BusinessException("该清单有[" + e.getCause().getMessage() + "]个投保单已经提交核保！不能补录清单！");
                    throw new BusinessException("本清单关联保单已提交核保，不可补录清单！");
                }
                if (prpTmainDtos != null && prpTmainDtos.size() > 0) {
                    List<String> riskCodes = new ArrayList<>();
                    List<String> comCodes = new ArrayList<>();
                    List<String> userCodes = new ArrayList<>();
                    prpTmainDtos.forEach(prpTmainDto -> {
                        String riskCode = prpTmainDto.getRiskCode();
                        if (!riskCodes.contains(riskCode)) {
                            riskCodes.add(riskCode);
                        }
                        String comCode = prpTmainDto.getComCode();
                        if (!comCodes.contains(comCode)) {
                            comCodes.add(comCode);
                        }
                        String handlerCode = prpTmainDto.getHandlerCode();
                        if (!userCodes.contains(handlerCode)) {
                            userCodes.add(handlerCode);
                        }
                        String operatorCode = prpTmainDto.getOperatorCode();
                        if (!userCodes.contains(operatorCode)) {
                            userCodes.add(operatorCode);
                        }
                    });
                    // 转译险种代码
                    List<PrpDriskDto> prpDriskDtos = prpDriskApi.queryByRiskCodeList(riskCodes);
                    Map<String, String> riskNameByCode = new HashMap<>();
                    prpDriskDtos.forEach(prpDriskDto -> riskNameByCode.put(prpDriskDto.getRiskCode(), prpDriskDto.getRiskCName()));
                    // 转译机构代码
                    Map<String, String> comNameByCode = prpDcompanyApi.queryComCNameByComCodes(comCodes);
                    // 转译用户代码
                    List<PrpDuserDto> prpDuserDtos = prpDuserApi.queryByUserCodeList(userCodes);
                    Map<String, String> userNameByCode = new HashMap<>();
                    prpDuserDtos.forEach(prpDuserDto -> userNameByCode.put(prpDuserDto.getUserCode(), prpDuserDto.getUserName()));
                    prpTmainDtos.forEach(prpTmainDto -> {
                        MakeUpListDto makeUpListDto = convert(prpTmainDto, MakeUpListDto.class);
                        makeUpListDto.setRiskName(riskNameByCode.get(prpTmainDto.getRiskCode()));
                        makeUpListDto.setComName(comNameByCode.get(prpTmainDto.getComCode()));
                        makeUpListDto.setHandler1Name(userNameByCode.get(prpTmainDto.getHandlerCode()));
                        makeUpListDto.setOperatorName(userNameByCode.get(prpTmainDto.getOperatorCode()));
                        makeUpListDtos.add(makeUpListDto);
                    });
                    makeUpListDtoPageInfo.setContent(makeUpListDtos);
                }
//                else {
//                    throw new DataVerifyException("此清单无需补录，请重新输入!");
//                }
            }
        }

        makeUpListDtoPageInfo.setTotalCount(countSize);
        makeUpListDtoPageInfo.setPages(pageNo);
        return makeUpListDtoPageInfo;
//            }
//        }
    }

    /**
     * 通过查询条件查询清单分页
     *
     * @param listingQueryConditions
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 07/02/2018 9:48 AM
     */
    @Override
    public PageInfo<ListingQueryResults> pageFindByConditions(ListingQueryConditions listingQueryConditions) throws Exception {
        // 统一封装分页响应dto
        PageInfo<ListingQueryResults> pageInfo;
        ListingQueryResults listingQueryResults;
        if (StringUtils.isNotEmpty(listingQueryConditions.getInsureListCode())) {
            pageInfo = new PageInfo<>();
            Integer countByInsureListCode = gisInsureMainListDao.countByInsureListCode(listingQueryConditions.getInsureListCode());
            if (0 == (countByInsureListCode)) {
                throw new DataVerifyException("您输入的清单编号在系统中不存在，请重新输入!");
            }
//            Integer countGisHerdFieldList = gisHerdFieldListDao.getCountByInsureListCode(listingQueryConditions.getInsureListCode());
//            if (countGisHerdFieldList > 0) {
//                throw new DataVerifyException("此清单无需补录，请重新输入!");
//            } else {
//                Integer manCount = gisManFieldListDao.getCount(listingQueryConditions.getInsureListCode());
//                if (manCount > 0) {
//                    throw new DataVerifyException("此清单无需补录，请重新输入!");
//                } else {
            GisInsureMainList gisInsureMainList = gisInsureMainListDao.findByInsureListCodeAndNewFlagEquals(listingQueryConditions.getInsureListCode(), "Y");
            listingQueryResults = this.convert(gisInsureMainList, ListingQueryResults.class);
            // 数据存放dto集合
            List<ListingQueryResults> listingQueryResultsArrayList = new ArrayList<>(1);
            listingQueryResultsArrayList.add(listingQueryResults);
            pageInfo.setContent(listingQueryResultsArrayList);
            // 当前页数
            pageInfo.setPages(listingQueryConditions.getPageNo());
            // 总记录数
            pageInfo.setTotalCount(listingQueryResultsArrayList.size());
//                }
            return pageInfo;
//            }

        } else {
            // 查询数据HQL
            if (listingQueryConditions == null) {
                throw new DataVerifyException("请求参数不能为空！");
            }

            StringBuilder dataHql = new StringBuilder("select pt from GisInsureMainList pt, GisItemList it where pt.newFlag='Y' and it.insureListCode = pt.insureListCode and it.itemCode in (:itemCodes) ");
            // 查询总数量的HQL
            StringBuilder countHql = new StringBuilder("select count(1) from GisInsureMainList pt, GisItemList it where pt.newFlag='Y' and it.insureListCode = pt.insureListCode and it.itemCode in (:itemCodes) ");
            // 条件hql拼接
            StringBuilder condition = new StringBuilder();
            Map<String, String> conditions = new HashMap<>();

            if (StringUtils.isNotEmpty(listingQueryConditions.getListAlias())) {
                condition.append(" AND pt.listAlias = :listAlias");
                conditions.put("listAlias", listingQueryConditions.getListAlias());
            }

            if (StringUtils.isNotEmpty(listingQueryConditions.getAffrimOpName())) {
                condition.append(" AND pt.affrimOpName = :affrimOpName");
                conditions.put("affrimOpName", listingQueryConditions.getAffrimOpName());
            }

            if (StringUtils.isNotEmpty(listingQueryConditions.getfProvinceCode())) {
                condition.append(" AND pt.fProvinceCode = :fProvinceCode");
                conditions.put("fProvinceCode", listingQueryConditions.getfProvinceCode());
            }
            if (StringUtils.isNotEmpty(listingQueryConditions.getfCityCode())) {
                condition.append(" AND pt.fCityCode = :fCityCode");
                conditions.put("fCityCode", listingQueryConditions.getfCityCode());
            }
            if (StringUtils.isNotEmpty(listingQueryConditions.getfCountyCode())) {
                condition.append(" AND pt.fCountyCode = :fCountyCode");
                conditions.put("fCountyCode", listingQueryConditions.getfCountyCode());
            }
            if (StringUtils.isNotEmpty(listingQueryConditions.getfTownCode())) {
                condition.append(" AND pt.fTownCode = :fTownCode");
                conditions.put("fTownCode", listingQueryConditions.getfTownCode());
            }
            if (StringUtils.isNotEmpty(listingQueryConditions.getfVillageCode())) {
                condition.append(" AND pt.fVillageCode = :fVillageCode");
                conditions.put("fVillageCode", listingQueryConditions.getfVillageCode());
            }

            if (StringUtils.isNotEmpty(listingQueryConditions.getBeginTime())) {
                condition.append(" AND pt.listAffrimTime >= to_date(:beginTime, 'yyyy-mm-dd')");
                conditions.put("beginTime", listingQueryConditions.getBeginTime());
            }

            if (StringUtils.isNotEmpty(listingQueryConditions.getEndTime())) {
                condition.append(" AND pt.listAffrimTime <= to_date(:endTime, 'yyyy-mm-dd')");
                conditions.put("endTime", listingQueryConditions.getEndTime());
            }

            countHql.append(condition);
            dataHql.append(condition).append(" order by pt.insureListCode desc");
            // 查询数据hql拼接条件以及排序hql
            Query countQuery = entityManager.createQuery(countHql.toString());
            Query dataQuery = entityManager.createQuery(dataHql.toString());
            // 设置参数
            for (String key : conditions.keySet()) {
                countQuery.setParameter(key, conditions.get(key));
                dataQuery.setParameter(key, conditions.get(key));
            }
            countQuery.setParameter("itemCodes", EARLABLE_JOINTINSUREED_ITEM);
            dataQuery.setParameter("itemCodes", EARLABLE_JOINTINSUREED_ITEM);
            // 查询数据总条数
            long countNum = (long) countQuery.getSingleResult();
            dataQuery.setFirstResult((listingQueryConditions.getPageNo() - 1) * listingQueryConditions.getPageSize());
            dataQuery.setMaxResults(listingQueryConditions.getPageSize());
            // 查询数据
            List<GisInsureMainList> dataList;
            List<ListingQueryResults> listingQueryResultsArrayList = new ArrayList<>();
            // 当查询到的总记录数大于0才继续查询
            if (countNum > 0) {
                dataList = dataQuery.getResultList();
                this.convertCollection(dataList, listingQueryResultsArrayList, ListingQueryResults.class);
            }
            pageInfo = new PageInfo<>();
            // 数据存放dto集合
            pageInfo.setContent(listingQueryResultsArrayList);
            // 当前页数
            pageInfo.setPages(listingQueryConditions.getPageNo());
            // 总记录数
            pageInfo.setTotalCount(countNum);
            return pageInfo;
        }

    }

    /**
     * 导入耳标号清单，并校验
     *
     * @param fileId 文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importEarLabelList(String fileId) throws Exception {
        File file = null;
        try {
            file = getFileUtil().downloadExcel(fileServiceUrl, exportExcelType, fileId);
            ExcelUtil excelUtil = ExcelUtil.initImport();
            EarLabelExcelReadHandler earLabelExcel = new EarLabelExcelReadHandler();
            excelUtil.setStartRowNumber(1).readExcel(file, earLabelExcel);
            Map<CodeKeyDto, Integer> earLabelNumber = earLabelExcel.getEarLabelNumber();
            Integer serialNo = this.importChecklist(earLabelNumber, earLabelExcel.getInusreListCode(), null, true);
            List<EarLabelListDto> earLabelListDtos = earLabelExcel.getEarLabelListDtos();
            Map<String, List<EarLabelListDto>> earLabelListGroupByfCode = earLabelListDtos.stream().collect(Collectors.groupingBy(EarLabelListDto::getfCode));
            // 补录的耳标号信息回写金禾系统
            writebackGIS(earLabelExcel.getInusreListCode(), earLabelListGroupByfCode);
            // 回写gis中间表数据
            saveEarLabelList(earLabelExcel.getInusreListCode(), earLabelListDtos, serialNo);
            // 拆分到业务清单
            splitBusinessListByHerd(earLabelListGroupByfCode, earLabelExcel.getInusreListCode());
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        return "成功";
    }

    /**
     * 拆分保额保费到业务清单表中
     *
     * @param earLabelListGroupByfCode
     * @param insureListCode
     * @date: 2018/05/09 10:17
     * @author: 何伟东
     */
    @Transactional(rollbackFor = Exception.class)
    public void splitBusinessListByHerd(Map<String, List<EarLabelListDto>> earLabelListGroupByfCode, String insureListCode) {
        // 1.获取导入的清单明细数据earLabelListGroupByfCode
        // 2.查询gis清单号关联的所有保单对应的我方清单号
        List<InsureMainList> insureMainLists = insureMainListDao.findByGisInsureListCode(insureListCode);
        List<String> insureListCodes = new ArrayList<>();
        insureMainLists.forEach(insureMainList -> insureListCodes.add(insureMainList.getInusreListCode()));
        // 3.根据2>查询得到的清单号查询分户清单数据
        List<MiddleHerdInsuranceList> middleHerdInsuranceLists = middleHerdInsuranceListDao.findByInusreListCodes(insureListCodes);
        // 4.把导入清单的耳标号信息按照清单号和农户代码分组
        Map<String, Map<String, List<MiddleHerdInsuranceList>>> middleHerdGroupByInusreListCodeAndfCode = middleHerdInsuranceLists.stream().collect(Collectors.groupingBy(MiddleHerdInsuranceList::getInusreListCode, Collectors.groupingBy(MiddleHerdInsuranceList::getfCode)));
        // 5.循环每个清单的每个农户信息将保额保费信息拆分到对应的耳标号中，每个农户的最后一个耳标信息调差
        List<HerdInsuranceList> herdInsuranceLists = new ArrayList<>();
        middleHerdGroupByInusreListCodeAndfCode.forEach((inusreListCode, middleHerdGroupByfCode) -> {
            middleHerdGroupByfCode.forEach((fCode, middleHerd) -> {
                List<EarLabelListDto> earLabelListDtos = earLabelListGroupByfCode.get(fCode);
                int insureCount = earLabelListDtos.size();
                MiddleHerdInsuranceList middleHerdInsuranceList = middleHerd.get(0);
                Double insurePremium = middleHerdInsuranceList.getInsurePremium();
                Double centralPremium = middleHerdInsuranceList.getCentralPremium();
                Double provincePremium = middleHerdInsuranceList.getProvincePremium();
                Double cityPremium = middleHerdInsuranceList.getCityPremium();
                Double townPremium = middleHerdInsuranceList.getTownPremium();
                Double otherPremium = middleHerdInsuranceList.getOtherPremium();
                Map<String, Double> calculateInfo = new HashMap<>(2);
                // 农户自缴保费
                this.calculateCost(insureCount, insurePremium, calculateInfo);
                earLabelListDtos.forEach(earLabelListDto -> {
                    HerdInsuranceList herdInsuranceList = this.convert(middleHerdInsuranceList, HerdInsuranceList.class);
                    herdInsuranceList.setEarlAbel(earLabelListDto.getEarLabel());
                    herdInsuranceList.setInsurePremium(calculateInfo.get("premium"));
                    herdInsuranceLists.add(herdInsuranceList);
                });
                herdInsuranceLists.get(herdInsuranceLists.size() - 1).setInsurePremium(calculateInfo.get("premium_adjust"));
                // 中央财政补贴
                if (centralPremium > 0) {
                    this.calculateCost(insureCount, centralPremium, calculateInfo);
                    herdInsuranceLists.forEach(herdInsuranceList -> herdInsuranceList.setCentralPremium(calculateInfo.get("premium")));
                    herdInsuranceLists.get(herdInsuranceLists.size() - 1).setCentralPremium(calculateInfo.get("premium_adjust"));
                }
                // 省级财政补贴
                if (provincePremium > 0) {
                    this.calculateCost(insureCount, provincePremium, calculateInfo);
                    herdInsuranceLists.forEach(herdInsuranceList -> herdInsuranceList.setProvincePremium(calculateInfo.get("premium")));
                    herdInsuranceLists.get(herdInsuranceLists.size() - 1).setProvincePremium(calculateInfo.get("premium_adjust"));
                }
                // 地市财政补贴
                if (cityPremium > 0) {
                    this.calculateCost(insureCount, cityPremium, calculateInfo);
                    herdInsuranceLists.forEach(herdInsuranceList -> herdInsuranceList.setCityPremium(calculateInfo.get("premium")));
                    herdInsuranceLists.get(herdInsuranceLists.size() - 1).setCityPremium(calculateInfo.get("premium_adjust"));
                }
                // 县区财政补贴
                if (townPremium > 0) {
                    this.calculateCost(insureCount, townPremium, calculateInfo);
                    herdInsuranceLists.forEach(herdInsuranceList -> herdInsuranceList.setTownPremium(calculateInfo.get("premium")));
                    herdInsuranceLists.get(herdInsuranceLists.size() - 1).setTownPremium(calculateInfo.get("premium_adjust"));
                }
                // 其他财政补贴
                if (otherPremium > 0) {
                    this.calculateCost(insureCount, otherPremium, calculateInfo);
                    herdInsuranceLists.forEach(herdInsuranceList -> herdInsuranceList.setOtherPremium(calculateInfo.get("premium")));
                    herdInsuranceLists.get(herdInsuranceLists.size() - 1).setOtherPremium(calculateInfo.get("premium_adjust"));
                }
            });
        });
        // 6.保存含有耳标号信息的数据到业务清单表中
        List<HerdInsuranceList> _herdInsuranceLists = herdInsuranceListDao.queryByInusreListCodes(insureListCodes);
        herdInsuranceListDao.delete(_herdInsuranceLists);
        herdInsuranceListDao.save(herdInsuranceLists);
    }

    /**
     * 导入连带被保险人清单，并校验
     *
     * @param fileId 文件Id
     * @return
     * @date: 2018/2/7 10:24
     * @author: 何伟东
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importJointInsured(String fileId) throws Exception {
        File file = null;
        try {
            file = getFileUtil().downloadExcel(fileServiceUrl, exportExcelType, fileId);
            ExcelUtil excelUtil = ExcelUtil.initImport();
            JoinInsuredReadHandler joinInsuredExcel = new JoinInsuredReadHandler();
            excelUtil.setStartRowNumber(1).readExcel(file, joinInsuredExcel);
            Map<CodeKeyDto, Integer> jointInsuredNumber = joinInsuredExcel.getJointInsuredNumber();
            // todo 此处需要连带被保险人的标的代码暂时写死为null
            Integer serialNo = this.importChecklist(jointInsuredNumber, joinInsuredExcel.getInusreListCode(), null, false);
            List<JointInsuredListDto> jointInsuredListDtos = joinInsuredExcel.getJointInsuredListDtos();
            this.saveJoinInsuredList(jointInsuredListDtos, serialNo);
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        return "成功";
    }

    /**
     * 耳标号清单导入校验操作
     *
     * @param earLabelListDtos
     * @param inusreListCode
     * @param itemCode
     * @return
     * @date: 2018/2/7 15:07
     * @author: 潘峰
     */
    public Integer importChecklist(Map<CodeKeyDto, Integer> earLabelListDtos, String inusreListCode, String itemCode, boolean isEarLabel) throws Exception {
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.findByInsureListCodeAndNewFlagEquals(inusreListCode, "Y");
        if (gisInsureMainList == null) {
            throw new DataVerifyException("清单编号不一致！");
        }
        Integer serialNo = gisInsureMainList.getSerialNo();
        List<GisFarmerItem> gisFarmerItems = gisFarmerItemDao.queryByInsureListCodeAndSerialNoAndItemCodes(inusreListCode, 1, EARLABLE_JOINTINSUREED_ITEM);
        String errorMessageByNum = "您导入的农户数量与该清单的农户数量不一致！";
        String errorMessage;
        if (isEarLabel) {
            errorMessage = "您导入的农户每一标的的投保数量与相应的耳标数量不一致！";
        } else {
            errorMessage = "您导入的农户每一标的的投保数量与相应的连带被保险人数量不一致！";
        }
        if (earLabelListDtos.size() != gisFarmerItems.size()) {
            throw new DataVerifyException(errorMessageByNum);
        }
        for (GisFarmerItem gisFarmerItem : gisFarmerItems) {
            int integer = earLabelListDtos.get(new CodeKeyDto(gisFarmerItem.getfCode(), gisFarmerItem.getItemCode()));
            double insureCount = gisFarmerItem.getInsureCount();
            if (integer != insureCount) {
                throw new DataVerifyException(errorMessage);
            }
        }
        return serialNo;
    }


    /**
     * 保存耳标号清单
     *
     * @param earLabelListDtos 耳标号数据Dto
     * @param serialNo         保存的清单序号
     * @return true-保存成功
     * @date: 2018/2/7 14:55
     * @author: 潘峰
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveEarLabelList(String insureListCode, List<EarLabelListDto> earLabelListDtos, Integer serialNo) throws Exception {
        // 多次补录，先删除再插入数据
        List<GisHerdFieldList> _gisHerdFieldLists = gisHerdFieldListDao.findGisHerdFieldListByCondition(insureListCode, serialNo);
        gisHerdFieldListDao.delete(_gisHerdFieldLists);
        List<GisHerdFieldList> gisHerdFieldLists = new ArrayList<>(earLabelListDtos.size());
        this.convertCollection(earLabelListDtos, gisHerdFieldLists, GisHerdFieldList.class);
        gisHerdFieldLists.forEach(gisHerdFieldList -> gisHerdFieldList.setSerialNo(serialNo));
        gisHerdFieldListDao.save(gisHerdFieldLists);
        return true;
    }

    /**
     * 保存连带被保险人清单
     *
     * @param jointInsuredListDtos 耳标号数据Dto
     * @param serialNo             保存的清单序号
     * @return true-保存成功
     * @date: 2018/2/7 14:55
     * @author: 潘峰
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveJoinInsuredList(List<JointInsuredListDto> jointInsuredListDtos, Integer serialNo) throws Exception {
        List<GisManFieldList> gisManFieldLists = new ArrayList<>(jointInsuredListDtos.size());
        this.convertCollection(jointInsuredListDtos, gisManFieldLists, GisManFieldList.class);
        gisManFieldLists.forEach(gisManFieldList -> gisManFieldList.setSerialNo(serialNo));
        gisManFieldListDao.save(gisManFieldLists);
        return true;
    }


    /**
     * 下载带有农户信息的耳标号清单模板
     *
     * @param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @Override
    public String downloadEarLabelList(String gisInsureListCode) throws Exception {
        Map<String, String> fNamesByCode = new HashMap<>();
        Map<String, String> itemNamesByCode = new HashMap<>();
        List<GisFarmerItem> gisFarmerItems = getGisFarmerInfo(gisInsureListCode, fNamesByCode, itemNamesByCode);

        List<EarLabelListDto> earLabelListDtos = new ArrayList<>();
        convertCollection(gisFarmerItems, earLabelListDtos, EarLabelListDto.class);
        earLabelListDtos.forEach(earLabelListDto -> {
            earLabelListDto.setfName(fNamesByCode.get(earLabelListDto.getfCode()));
            earLabelListDto.setItemName(itemNamesByCode.get(earLabelListDto.getItemCode()));
        });
        String excelName = "EAR_LABEL_LISTING";
        String titleName = "耳标号清单";

        String shortLink = generateShortLink(earLabelListDtos, EarLabelListDto.class, excelName, titleName, 0, 5);
        return shortLink;
    }

    /**
     * 下载带有农户信息的连带被保险人清单模板
     *
     * @param gisInsureListCode - 金禾清单号码
     * @return shortLink
     * @author: 何伟东
     * @date: 2018/4/24 9:56
     */
    @Override
    public String downloadJointInsured(String gisInsureListCode) throws Exception {
        Map<String, String> fNamesByCode = new HashMap<>();
        List<GisFarmerItem> gisFarmerItems = getGisFarmerInfo(gisInsureListCode, fNamesByCode, null);

        List<JointInsuredListDto> jointInsuredListDtos = new ArrayList<>();
        convertCollection(gisFarmerItems, jointInsuredListDtos, JointInsuredListDto.class);
        jointInsuredListDtos.forEach(jointInsuredListDto -> jointInsuredListDto.setfName(fNamesByCode.get(jointInsuredListDto.getfCode())));
        jointInsuredListDtos.get(0).setRelation("配偶；子女；父母；其他等");
        String excelName = "JOINT_INSURED";
        String titleName = "连带被保险人清单";

        String shortLink = generateShortLink(jointInsuredListDtos, JointInsuredListDto.class, excelName, titleName, 0, 8);
        return shortLink;
    }

    /**
     * 校验要补录的耳标号或者连带被保险人是否存在
     *
     * @param gisInsureListCode - 金禾清单号码
     * @author: 何伟东
     * @date: 2018-05-10 14:37
     */
    @Override
    public Integer checkDoesItExist(String gisInsureListCode) throws Exception {
        if (StringUtils.isEmpty(gisInsureListCode)) {
            throw new DataVerifyException("清单号不能为空！");
        }
        int size = 0;
        List<GisHerdFieldList> gisHerdFieldLists = gisHerdFieldListDao.findGisHerdFieldListByCondition(gisInsureListCode, 1);
        if (gisHerdFieldLists != null) {
            size = gisHerdFieldLists.size();
        }
        return size;
    }

    /**
     * 查询农户的基础信息
     *
     * @param gisInsureListCode
     * @param fNamesByCode
     * @param itemNamesByCode
     * @author: 何伟东
     * @date: 2018/4/24 14:32
     */
    private List<GisFarmerItem> getGisFarmerInfo(String gisInsureListCode, Map<String, String> fNamesByCode, Map<String, String> itemNamesByCode) {
        List<GisFarmerItem> gisFarmerItems = gisFarmerItemDao.queryByInsureListCodeAndSerialNoAndItemCodes(gisInsureListCode, 1, EARLABLE_JOINTINSUREED_ITEM);
        if (fNamesByCode != null) {
            List<GisFarmerList> gisFarmerLists = gisFarmerListDao.queryAllByInsurelistCodeAndSerialNo(gisInsureListCode, 1);
            gisFarmerLists.forEach(gisFarmerList -> fNamesByCode.put(gisFarmerList.getfCode(), gisFarmerList.getfName()));
        }
        if (itemNamesByCode != null) {
            List<GisItemList> gisItemLists = gisItemListDao.queryAllByInsureListCodeAndSerialNo(gisInsureListCode, 1);
            gisItemLists.forEach(gisItemList -> itemNamesByCode.put(gisItemList.getItemCode(), gisItemList.getItemName()));
        }
        return gisFarmerItems;
    }

    /**
     * 生成下载短链接
     *
     * @param dataList  数据集合
     * @param tClass
     * @param excelName excel名称
     * @param titleName 标的名称
     * @param lastRow
     * @param lastCol
     * @author: 何伟东
     * @date: 2018/4/24 12:15
     */
    private <T> String generateShortLink(List<T> dataList, Class<T> tClass, String excelName, String titleName, int lastRow, int lastCol) throws Exception {
        File file = null;
        String shortLink;
        try {
            file = getQuicklyExportExcel().quicklyExport(exportExcelType, excelName, titleName, dataList, lastRow, lastCol, tClass);
            shortLink = getFileUtil().uploadFile(fileServiceUrl, file, SinoRequestContext.getCurrentContext().getUserCode(), "agri/tempfile", "agriprpall_MakeUpList");
        } finally {
            if (file != null) {
                file.delete();
            }
        }
        return shortLink;
    }

    /**
     * 计算保费和调差数据
     *
     * @param count         农户的承保数量
     * @param premium       费用
     * @param calculateInfo 存放拆分结果和调差结果的map
     * @date: 2018/3/23 15:52
     * @author: 何伟东
     */
    private Map<String, Double> calculateCost(int count, double premium, Map<String, Double> calculateInfo) {
        if (count <= 0) {
            throw new DataVerifyException("承保数量需要大于0");
        }
        if (premium <= 0) {
            throw new DataVerifyException("保费需要大于0");
        }
        BigDecimal count_b = new BigDecimal(count);
        BigDecimal premium_b = new BigDecimal(premium).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal fPremium = premium_b.divide(count_b, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal fPremium_adjust = premium_b.subtract(fPremium.multiply(count_b.subtract(BigDecimal.ONE)));
        calculateInfo.put("premium", fPremium.doubleValue());
        calculateInfo.put("premium_adjust", fPremium_adjust.doubleValue());
        return calculateInfo;
    }

    /**
     * 清单补录的数据回写到金禾
     *
     * @param inusreListCode           清单号
     * @param earLabelListGroupByfCode 耳标号信息,需要根据农户代码分组
     * @return
     * @date: 2018/3/26 18:35
     * @author: 何伟东
     */
    private void writebackGIS(String inusreListCode, Map<String, List<EarLabelListDto>> earLabelListGroupByfCode) {
        FarmerList farmerList = new FarmerList();
        List<Farmer> farmers = new ArrayList<>();
        // 对已经根据农户代码分组的数据遍历
        earLabelListGroupByfCode.forEach((fCode, earLabelListDtos) -> {
            Farmer farmer = new Farmer();
            farmer.setFcode(fCode);
            List<FarmerItem> farmerItemList = new ArrayList<>();
            FarmerItem farmerItem = new FarmerItem();
            // 获取农户的投保数量
            farmerItem.setInsureCount(String.valueOf(earLabelListDtos.size()));
            // 相同农户代码，根据itemCode分组
            Map<String, List<EarLabelListDto>> earLabelListByItemCode = earLabelListDtos.stream().collect(Collectors.groupingBy(EarLabelListDto::getItemCode));
            earLabelListByItemCode.forEach((itmeCode, earLabelLists) -> {
                farmerItem.setItemCode(itmeCode);
                List<GisHerdFieldListDto> herdFieldList = new ArrayList<>();
                earLabelLists.forEach(earLabelListDto -> {
                    GisHerdFieldListDto gisHerdFieldListDto = new GisHerdFieldListDto();
                    gisHerdFieldListDto.setEarLabel(earLabelListDto.getEarLabel());
                    herdFieldList.add(gisHerdFieldListDto);
                });
                farmerItem.setHerdFieldList(herdFieldList);
                farmerItemList.add(farmerItem);
            });
            farmer.setFarmerItemList(farmerItemList);
            farmers.add(farmer);
        });
        farmerList.setFarmerList(farmers);
        boolean isSuccess = getgYcoreUtil().addListAdditionalData(inusreListCode, farmerList);
        if (!isSuccess) {
            throw new BusinessException("清单补录回写金禾数据失败！");
        }
    }

    /**
     * 获取FileUtil实例
     *
     * @date: 2018/3/23 15:52
     * @author: 何伟东
     */
    private FileUtil getFileUtil() {
        if (fileUtil == null) {
            fileUtil = new FileUtil();
        }
        return fileUtil;
    }

    /**
     * 构建与金禾交互的对象
     *
     * @author: 何伟东
     * @date: 2018/4/19 19:13
     */
    private GYcoreUtil getgYcoreUtil() {
        if (gYcoreUtil == null) {
            gYcoreUtil = new GYcoreUtil(gycoreService);
        }
        return gYcoreUtil;
    }

    /**
     * 构建与快速导出excel工具类的对象
     *
     * @author: 何伟东
     * @date: 2018/4/24 10:53
     */
    private QuicklyExportExcel getQuicklyExportExcel() {
        if (quicklyExportExcel == null) {
            quicklyExportExcel = new QuicklyExportExcel();
        }
        return quicklyExportExcel;
    }
}
