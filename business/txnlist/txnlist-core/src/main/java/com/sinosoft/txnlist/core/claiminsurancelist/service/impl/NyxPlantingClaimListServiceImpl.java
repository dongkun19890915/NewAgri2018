package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;


import com.sinosoft.agriclaim.api.businessutilmanage.PrpLConfigurationApi;
import com.sinosoft.agriclaim.api.businessutilmanage.PrpLFormulaConfigApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLFormulaConfigDto;
import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriprpall.api.endorsemanage.PrpCitemKindAgriApi;
import com.sinosoft.agriprpall.api.policymanage.ClaimQueryDeductiblerateApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.NyxPlantingClaimListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxPlantingClaimList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxPlantingClaimListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxPlantingClaimListService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 种植险理赔清单信息表Core接口实现
 */
@Service
public class NyxPlantingClaimListServiceImpl extends BaseCustomServiceImpl implements NyxPlantingClaimListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxPlantingClaimListServiceImpl.class);

    @Autowired
    private NyxPlantingClaimListDao nyxPlantingClaimListDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Value("${exportExcelType}")
    private String exportExcelType;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private PrpLFormulaConfigApi prpLFormulaConfigApi;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpLConfigurationApi prpLConfigurationApi;
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpCitemKindAgriApi prpCitemKindAgriApi;
    @Autowired
    private NyxEffectiveAmountApi nyxEffectiveAmountApi;
    @Autowired
    private ClaimQueryDeductiblerateApi claimQueryDeductiblerateApi;

    /**
     *@description 新增
     *@param
     */
    public void save(NyxPlantingClaimListDto nyxPlantingClaimListDto) {
        NyxPlantingClaimList nyxPlantingClaimList = this.convert(nyxPlantingClaimListDto, NyxPlantingClaimList.class);
        nyxPlantingClaimListDao.save(nyxPlantingClaimList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo,String serialNo) {
        NyxPlantingClaimListKey nyxPlantingClaimListKey = new NyxPlantingClaimListKey(listNo,serialNo);
        nyxPlantingClaimListDao.delete(nyxPlantingClaimListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxPlantingClaimListDto nyxPlantingClaimListDto) {
        NyxPlantingClaimList nyxPlantingClaimList = this.convert(nyxPlantingClaimListDto, NyxPlantingClaimList.class);
        nyxPlantingClaimListDao.save(nyxPlantingClaimList);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public NyxPlantingClaimListDto queryByPK(String listNo,String serialNo) {
        NyxPlantingClaimListKey nyxPlantingClaimListKey = new NyxPlantingClaimListKey(listNo,serialNo);
        NyxPlantingClaimList nyxPlantingClaimList = nyxPlantingClaimListDao.findOne(nyxPlantingClaimListKey);
        return this.convert(nyxPlantingClaimList,NyxPlantingClaimListDto.class);
    }



    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */

    public PageInfo<NyxPlantingClaimListDto> queryNyxPlantingClaimListByCondition(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)  {

        if (requestNyxPlantingClaimListDto.getPageSize() == 0) {
            requestNyxPlantingClaimListDto.setPageSize(20);
        }
        if (requestNyxPlantingClaimListDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (requestNyxPlantingClaimListDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        StringBuilder count = new StringBuilder(200);
        StringBuilder sql = new StringBuilder(200);

        count.append("SELECT  COUNT(1) FROM NyxPlantingClaimList p ");
        sql.append("SELECT p FROM NyxPlantingClaimList p ");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();
        //有可选条件
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getListNo())) {
            conditionList.add("and p.listNo=:listNo");
            paraMap.put("listNo", requestNyxPlantingClaimListDto.getListNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getPolicyNo())) {
            conditionList.add("and p.policyNo=:policyNo");
            paraMap.put("policyNo", requestNyxPlantingClaimListDto.getPolicyNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getCompensateNo())) {
            conditionList.add("and p.compensateNo=:compensateNo");
            paraMap.put("compensateNo", requestNyxPlantingClaimListDto.getCompensateNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getRegistNo())) {
            conditionList.add("and p.registNo=:registNo");
            paraMap.put("registNo", requestNyxPlantingClaimListDto.getRegistNo());
        }
//        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getfCode())) {
//            conditionList.add("and p.fCode=:fCode");
//            paraMap.put("fCode", requestNyxPlantingClaimListDto.getfCode());
//        }


        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
            count.append(" where");
            count.append(dateCondition);
        }

        Query dataQuery = entityManager.createQuery(sql.toString());
        Query countQuery = entityManager.createQuery(count.toString());
        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());
            countQuery.setParameter(entry.getKey(), entry.getValue());
        }
        //当前页第一条数据在总数据中位置
        dataQuery.setFirstResult((requestNyxPlantingClaimListDto.getPageNo() - 1) * requestNyxPlantingClaimListDto.getPageSize());
        dataQuery.setMaxResults(requestNyxPlantingClaimListDto.getPageSize());

        long countNum = (long) countQuery.getSingleResult();

        List<NyxPlantingClaimList> resultList = dataQuery.getResultList();
        List<NyxPlantingClaimListDto> NyxPlantingClaimListDtoList = new ArrayList<>();

        convertCollection(resultList, NyxPlantingClaimListDtoList, NyxPlantingClaimListDto.class);
        //统一封装分页响应dto
        PageInfo<NyxPlantingClaimListDto> pageInfo = new PageInfo<NyxPlantingClaimListDto>();
        pageInfo.setContent(NyxPlantingClaimListDtoList);// 数据存放dto集合
        pageInfo.setPages(requestNyxPlantingClaimListDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }

    /**
     * @Description: 理赔清单数据查询（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxPlantingClaimListDto   listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return List<NyxPlantingClaimListDto> 结果集，
     */
    public List<NyxPlantingClaimListDto> queryNyxPlantingClaimListByConditions(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto)  {
        StringBuilder sql = new StringBuilder(200);


        sql.append("SELECT p FROM NyxPlantingClaimList p ");
        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();
        //有可选条件
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getListNo())) {
            conditionList.add("and p.listNo=:listNo");
            paraMap.put("listNo", requestNyxPlantingClaimListDto.getListNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getPolicyNo())) {
            conditionList.add("and p.policyNo=:policyNo");
            paraMap.put("policyNo", requestNyxPlantingClaimListDto.getPolicyNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getCompensateNo())) {
            conditionList.add("and p.compensateNo=:compensateNo");
            paraMap.put("compensateNo", requestNyxPlantingClaimListDto.getCompensateNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getRegistNo())) {
            conditionList.add("and p.registNo=:registNo");
            paraMap.put("registNo", requestNyxPlantingClaimListDto.getRegistNo());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getfCode())) {
            conditionList.add("and p.fCode=:fCode");
            paraMap.put("fCode", requestNyxPlantingClaimListDto.getfCode());
        }
        if (StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getNodeType())) {
            conditionList.add("and p.nodeType=:nodeType");
            paraMap.put("nodeType", requestNyxPlantingClaimListDto.getNodeType());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
            sql.append(" order by to_number(SERIALNO) ");
        }

        Query dataQuery = entityManager.createQuery(sql.toString());

        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());
        }
        List<NyxPlantingClaimList> resultList = dataQuery.getResultList();
        List<NyxPlantingClaimListDto> NyxPlantingClaimListDtoList = new ArrayList<>();

        convertCollection(resultList, NyxPlantingClaimListDtoList, NyxPlantingClaimListDto.class);
        return NyxPlantingClaimListDtoList;
    }


    /**
     * @Description: 理赔清单计算书号关联（种植险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    public  void  updateNyxPlantingClaimListCompensateNo(Map<String ,String > map){
        String listNo = map.get("listNo");
        String compensateNo =  map.get("compensateNo");
        // 必传值
        if(StringUtils.isEmpty(listNo)){
            throw new DataVerifyException("理赔清单号不能为空");
        }
        if(StringUtils.isEmpty(compensateNo)){
            throw new DataVerifyException("计算书号不能为空");
        }
        RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto = new RequestNyxPlantingClaimListDto();
//        requestNyxPlantingClaimListDto.setCompensateNo(compensateNo);
        requestNyxPlantingClaimListDto.setListNo(listNo);
        //查询得到dto的集合
        //数据表集合
        List<NyxPlantingClaimList> nyxPlantingClaimListList=new ArrayList<>();
        List<NyxPlantingClaimListDto>  nyxPlantingClaimListDtolist  =  this.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
        if (nyxPlantingClaimListDtolist.size()>0){
            for (NyxPlantingClaimListDto nyxPlantingClaimListDto:nyxPlantingClaimListDtolist){
                nyxPlantingClaimListDto.setCompensateNo(compensateNo);
                nyxPlantingClaimListList.add(this.convert(nyxPlantingClaimListDto,NyxPlantingClaimList.class));
            }
        }
        //把dto的集合转为数据表集合，并批量保存。
        nyxPlantingClaimListDao.save(nyxPlantingClaimListList);
    }
    /**
     * 批量保存理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 9:55
     * @param nyxPlantingClaimListDtoList 理赔清单集合
     * @return 是否保存成功
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSaveNyxPlantingClaimList(List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList) throws Exception {
        List<NyxPlantingClaimList> nyxPlantingClaimLists=new ArrayList<>();
        this.convertCollection(nyxPlantingClaimListDtoList,nyxPlantingClaimLists,NyxPlantingClaimList.class);
        for (int i = 0; i < nyxPlantingClaimLists.size(); i++) {
            nyxPlantingClaimLists.get(i).setSerialNo(String.valueOf(i + 1));
            entityManager.persist(nyxPlantingClaimLists.get(i));
        }
//        nyxPlantingClaimListDao.save(nyxPlantingClaimLists);
//        for (NyxPlantingClaimList nyxPlantingClaimListDtoList1 : nyxPlantingClaimLists) {
//            entityManager.persist(nyxPlantingClaimListDtoList1);
//        }
        entityManager.flush();
        entityManager.clear();
        return true;
    }

    /**
     * （赔款费用计算）
     * @author: 王志文
     * @date: 2017/12/29 18:11
     * @param policyNo 保单号
     * @param billNo 清单号
     * @param kindCode 险别代码
     * @param growthPeriod 作物苗期
     * @return 计算结果 Map
     * @throws Exception 异常信息
     */
    @Override
    public Map<String, Object> queryClaimBillSummary(String policyNo,String kindCode, String billNo, String growthPeriod,String registNo,String damageWay,String damageDegree) throws Exception {
        Map<String,Object> resultMap = new HashMap<>();
        if("3136".equals(policyNo.substring(1,5))||"3198".equals(policyNo.substring(1,5))
                ||"3225".equals(policyNo.substring(1,5))||"3175".equals(policyNo.substring(1,5))||"3220".equals(policyNo.substring(1,5))){
            //该险种无对应计算公式
            resultMap.put("code","2222");
            return resultMap;
        }
        Integer count = nyxPlantingClaimListDao.checkCompeNodeType(billNo);
        if (count == 0){
            //请导入清单后生成赔款计算过程
            resultMap.put("code","1111");
            return resultMap;
        }
        List<Double> objects = nyxPlantingClaimListDao.getLossRateGroupCountByBillNo(billNo);
        List<Double> objects1 = nyxPlantingClaimListDao.getClaimRateGroupCountByBillNo(billNo);
        List<String> stringList = nyxPlantingClaimListDao.getItemCodeCountByBillNo(billNo);
        if (objects.size() == 1 && objects1.size() <= 1 && stringList.size()==1){
            if (!"3149".equals(policyNo.substring(1, 5)) && StringUtils.isEmpty(growthPeriod)) {
                throw new BusinessException("请选择生长期！");
            }
            Double claimRate = 0.0;
            Double lossRate = 0.0;
            if (objects1.size() == 1){
                claimRate = objects1.get(0);
            }
            if (objects.size() == 1){
                lossRate = objects.get(0);
            }
            resultMap = getResultMap(policyNo,kindCode,billNo,growthPeriod,claimRate,lossRate,registNo,damageWay,damageDegree);
            return resultMap;
        }else if (objects.size()>1 || objects1.size()>1 || stringList.size()>1){
            //详见清单
            resultMap.put("code","3333");
            return resultMap;
        }
        return resultMap;
    }

    /**
     * （获取结果）
     * @author: 王志文
     * @date: 2017/12/29 20:07
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @param billNo 清单号
     * @param growthPeriod 苗期
     * @return 计算结果的map集合
     * @throws Exception 异常信息
     */
    private Map<String,Object> getResultMap(String policyNo,String kindCode,String billNo, String growthPeriod,Double claimRate,Double lossRate,String registNo,String damageWay,String damageDegree)throws Exception{
        Map<String,String> map = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(registNo);
        String itemCode = "";
        if (prpLRegistDto!= null){
            itemCode = prpLRegistDto.getLossCode();
        }
        map.put("policyNo",policyNo);
        resultMap.put("policyNo",policyNo);
        resultMap.put("kindCode",kindCode);
        resultMap.put("itemCode",itemCode);
        String riskCode = policyNo.substring(1,5);
        String riskCName = prpDriskApi.translateCodeByPK(riskCode);
        resultMap.put("riskCName",riskCName);
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(resultMap);
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        if (prpCitemKindDtoList.size()>0){
            prpCitemKindDto = prpCitemKindDtoList.get(0);
        }
        Integer itemKindNo = prpCitemKindDto.getItemKindNo();
        resultMap.put("itemKindNo",itemKindNo);
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
        String versionNo = "";
        if (prpCmainDto != null){
            versionNo = prpCmainDto.getVersionNo();
        }
        //根据报案日期判断当前报案标的所属茬次
        int times = this.checkStubbleByRegistNo(registNo,resultMap);
        resultMap.put("times",times);
        PrpCitemKindAgriDto prpCitemKindAgriDto = prpCitemKindAgriApi.queryByPk(resultMap);
        String formula = "";
        PrpLConfigurationDto prpLConfigurationDto = new PrpLConfigurationDto();
        prpLConfigurationDto.setClauseNumber(versionNo);
        prpLConfigurationDto.setItemCode(prpCitemKindDto.getItemCode());
        prpLConfigurationDto.setKindCode(prpCitemKindDto.getKindCode());
        List<PrpLConfigurationDto> prpLConfigurationDtoList = prpLConfigurationApi.queryPrpLConfigurationDtoListByCondition(prpLConfigurationDto);
        if (prpLConfigurationDtoList.size()>0){
            for (PrpLConfigurationDto prpLConfigDto:prpLConfigurationDtoList) {
                if (StringUtils.isNotEmpty(prpLConfigDto.getCalculationMethod())){
                    //部分损失和全部损失的区分标识
                    String calculationMethod = "";
                    Double totalLossRate = prpCitemKindDto.getTotalLossRatio();
                    if (totalLossRate == null){
                        totalLossRate = 100.00;
                    }
                    if (("3141".equals(riskCode)||"3147".equals(riskCode)) && totalLossRate > lossRate){
                        calculationMethod = "02";
                    }else if (("3141".equals(riskCode)||"3147".equals(riskCode)) && totalLossRate < lossRate){
                        calculationMethod = "01";
                    }else if ("3130".equals(riskCode) && ("01".equals(growthPeriod)||"02".equals(growthPeriod))){
                        //保险草莓在定植缓苗期、生长期出险
                        calculationMethod = "03";
                    }else if ("3130".equals(riskCode) && "03".equals(growthPeriod)){
                        //保险草莓在采收期出险
                        calculationMethod = "04";
                    }else if ("3224".equals(riskCode)){
                        //取出险方式
                        if ("mt".equals(damageWay)){
                            calculationMethod = "05";
                        }else if ("kt".equals(damageWay)){
                            calculationMethod = "06";
                        }else if ("ft".equals(damageWay)){
                            calculationMethod = "07";
                        }
                    }
                    if (calculationMethod.equals(prpLConfigDto.getCalculationMethod())){
                        prpLConfigurationDto = prpLConfigDto;
                        break;
                    }
                }else {
                    prpLConfigurationDto = prpLConfigurationDtoList.get(0);
                }
            }
            resultMap.put("description",prpLConfigurationDto.getFormulaDescribing());
            formula = prpLConfigurationDto.getFormula();
        }
        String[] configCodes =formula.split("]");
        if (StringUtils.isEmpty(formula) || configCodes.length == 0){
            resultMap.put("formula","没有对应计算公式");
            return resultMap;
        }
        for (String a : configCodes ){
            int k = a.indexOf("[");
            String configCode = a.substring(k+1,a.length());
            PrpLFormulaConfigDto prpLFormulaConfigDto = new PrpLFormulaConfigDto();
            prpLFormulaConfigDto.setRiskCode(prpCmainDto.getRiskCode());
            prpLFormulaConfigDto.setConfigCode(configCode);
            //出苗期等时期需要添加
            prpLFormulaConfigDto.setReserve1(growthPeriod);
            if ("lossarea".equals(configCode)){
                prpLFormulaConfigDto.setReserve2("1");
            }
            List<PrpLFormulaConfigDto> prpLFormulaConfigDtoList = prpLFormulaConfigApi.queryPrpLFormulaConfigDtoListByCondition(prpLFormulaConfigDto);
            if (prpLFormulaConfigDtoList.size() > 0 ){
                prpLFormulaConfigDto = prpLFormulaConfigDtoList.get(0);
                Double resultDouble = 0.0;
                if ("0".equals(prpLFormulaConfigDto.getConfigUrationType())){
                    if ("compestandard".equals(configCode)){
                        if (claimRate == null){
                            claimRate = Double.valueOf(prpLFormulaConfigDto.getConfigUrationContent());
                        }
                        BigDecimal unitAmount = new BigDecimal(prpCitemKindDto.getUnitAmount().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                        BigDecimal claimRatec = new BigDecimal(claimRate.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                        resultDouble = Double.valueOf(unitAmount.multiply(claimRatec).toString());
                        map.put(configCode,String.valueOf(resultDouble));
                    }else if("deductible".equals(configCode)){//绝对免赔率
                        Map<String,String> deductibleRateMap = new HashMap<>();
                        deductibleRateMap.put("policyNo",policyNo);
                        deductibleRateMap.put("kindCode",kindCode);
                        deductibleRateMap.put("itemCode",itemCode);
                        ClaimQueryDeductiblerateDto claimQueryDeductiblerateDto = claimQueryDeductiblerateApi.queryDeductiblerate(deductibleRateMap);
                        if (claimQueryDeductiblerateDto != null && StringUtils.isNotEmpty(claimQueryDeductiblerateDto.getEachDeductibleRate())){
                            map.put(configCode,String.valueOf(Double.valueOf(claimQueryDeductiblerateDto.getEachDeductibleRate())/100));
                        }else {
                            map.put(configCode,"0");
                        }
                    }else if("unitAmount".equals(configCode)){
                        resultDouble = prpCitemKindDto.getUnitAmount();
                        map.put(configCode,String.valueOf(resultDouble));
                    }else if("distrate".equals(configCode)){
                        if (prpCitemKindAgriDto != null){
                            if (prpCitemKindAgriDto.getDistributingRate() != null){
                                map.put(configCode,String.valueOf(prpCitemKindAgriDto.getDistributingRate()/100));
                            }else {
                                map.put(configCode,"0");
                            }
                        }
                    }else if("comperate".equals(configCode)){
                        resultDouble = Double.parseDouble(prpLFormulaConfigDto.getConfigUrationContent())/100;
                        map.put(configCode,String.valueOf(resultDouble));
                    }else if("harvestDate".equals(configCode)){
                        Long startDate = prpCitemKindAgriDto.getStratDate().getTime();
                        Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                        Long harvestDate = endDate - startDate;
                        map.put(configCode,String.valueOf(harvestDate/(1000*60*60*24)));
                    }else if("regisHarvestDate".equals(configCode)){
                        Long damageStartDate = prpLRegistDto.getDamageStartDate().getTime();
                        Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                        Long regisHarvestDate = endDate - damageStartDate;
                        map.put(configCode,String.valueOf(regisHarvestDate/(1000*60*60*24)));
                    }else if ("insuramount".equals(configCode)){
                        //保险金额
                        resultMap.put("code","3333");
                        return resultMap;
                    }else if ("TTimeRate".equals(configCode)||"ITimeRate".equals(configCode)){
                        map.put(configCode,damageDegree);
                    }else {
                        resultDouble = Double.parseDouble(prpLFormulaConfigDto.getConfigUrationContent())/100;
                        map.put(configCode,String.valueOf(resultDouble*prpCitemKindDto.getUnitAmount()));
                    }
                }else if ("1".equals(prpLFormulaConfigDto.getConfigUrationType())){
                    Map<String,Object> paraMap = new HashMap<>();
                    Query query = entityManager.createNativeQuery(prpLFormulaConfigDto.getConfigUrationContent());
                    if ("1".equals(prpLFormulaConfigDto.getReserve2())){
                        paraMap.put("listNo",billNo);
                    }else {
                        //预留按农户代码计算损失率损失面积
                    }
                    this.setQueryParam(query,paraMap);
                    BigDecimal sumAmount = (BigDecimal) query.getSingleResult();
                    if (sumAmount != null){
                        resultDouble = sumAmount.doubleValue();
                    }
                    map.put(configCode,String.valueOf(resultDouble));
                }
                if ("lossrate".equals(configCode)){
                    if ("3149".equals(riskCode)){
                        resultDouble = this.calculate3149LossRate(resultDouble);
                    }else {
                        resultDouble = this.calculateLossRate(prpCitemKindDto,resultDouble);
                    }
                    map.put(configCode,String.valueOf(resultDouble/100));
                    BigDecimal bg = new BigDecimal(resultDouble);
                    resultMap.put("lossrate",bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
                }
            }
            if (configCode.startsWith("0") || configCode.startsWith("1")){
                map.put(configCode,configCode);
            }
            String configCode1 = a.substring(k,a.length())+"]";
            formula = formula.replace(configCode1, map.get(prpLFormulaConfigDto.getConfigCode()));
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("js");
        if (engine == null) {
            throw new BusinessException("No engine for JavaScript");
        }
        try{
            Double settleAmount = nyxPlantingClaimListDao.querySumSettleAmountByListNoAndNodeType(billNo,"compe");
            Object result1= engine.eval(formula);
            BigDecimal   b   =   new   BigDecimal(Double.valueOf(result1.toString()));
            double result2 = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            Double settleResult = settleAmount - result2 ;
            if (settleResult != null && settleResult != 0.0){
                //手动输入金额，无计算过程
                resultMap.put("lossrate",null);
                resultMap.put("riskCName",null);
                resultMap.put("description",null);
                resultMap.put("code","4444");
            }else {
                formula = formula.replace('*','x');
                resultMap.put("result",result2);
                resultMap.put("lossrate",lossRate);
                resultMap.put("formula",formula+"="+result2);
            }
        }
        catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return resultMap;
    }

    /**
     * （生成赔款计算过程供清单保存时调用）
     * @author: 王志文
     * @date: 2018/1/30 16:08
     * @param nyxPlantingClaimListDto 清单数据dto
     * @param growthPeriod  生长期
     * @return 计算结果
     * @throws Exception
     */
    @Override
    public Map<String, Object> queryClaimBillBySave(NyxPlantingClaimListDto nyxPlantingClaimListDto, String growthPeriod,String damageWay,String damageDegree) throws Exception {
        String policyNo = nyxPlantingClaimListDto.getPolicyNo();
        String kindCode = nyxPlantingClaimListDto.getClaimRiskCode();
        String registNo = nyxPlantingClaimListDto.getRegistNo();
        String riskCode = policyNo.substring(1,5);
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(registNo);
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,String> map = new HashMap<>();
        if (StringUtils.isNotEmpty(policyNo)){
            resultMap.put("policyNo",policyNo);
            map.put("policyNo",policyNo);
        }
        if (StringUtils.isNotEmpty(kindCode)){
            resultMap.put("kindCode",kindCode);
        }
        if (prpLRegistDto!= null){
            resultMap.put("itemCode",nyxPlantingClaimListDto.getItemCode());
        }
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(resultMap);
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        if (prpCitemKindDtoList.size()>0){
            prpCitemKindDto = prpCitemKindDtoList.get(0);
        }
        Integer itemKindNo = prpCitemKindDto.getItemKindNo();
        resultMap.put("itemKindNo",itemKindNo);
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
        String versionNo = "";
        if (prpCmainDto != null){
            versionNo = prpCmainDto.getVersionNo();
        }
        //根据报案日期判断当前报案标的所属茬次
        int times = checkStubbleByRegistNo(registNo,resultMap);
        resultMap.put("times",times);
        PrpCitemKindAgriDto prpCitemKindAgriDto = prpCitemKindAgriApi.queryByPk(resultMap);
        String formula = "";
        PrpLConfigurationDto prpLConfigurationDto = new PrpLConfigurationDto();
        prpLConfigurationDto.setClauseNumber(versionNo);
        if (StringUtils.isNotEmpty(riskCode)){
            prpLConfigurationDto.setRiskCode(riskCode);
        }
        if (StringUtils.isNotEmpty(nyxPlantingClaimListDto.getItemCode())){
            prpLConfigurationDto.setItemCode(nyxPlantingClaimListDto.getItemCode());
        }
        if (StringUtils.isNotEmpty(nyxPlantingClaimListDto.getClaimRiskCode())){
            prpLConfigurationDto.setKindCode(nyxPlantingClaimListDto.getClaimRiskCode());
        }
        List<PrpLConfigurationDto> prpLConfigurationDtoList = prpLConfigurationApi.queryPrpLConfigurationDtoListByCondition(prpLConfigurationDto);
        if (prpLConfigurationDtoList.size()>0){
            for (PrpLConfigurationDto prpLConfigDto:prpLConfigurationDtoList) {
                if (StringUtils.isNotEmpty(prpLConfigDto.getCalculationMethod())){
                    //部分损失和全部损失的区分标识
                    String calculationMethod = "";
                    Double totalLossRate = prpCitemKindDto.getTotalLossRatio();
                    if (totalLossRate == null){
                        totalLossRate = 100.00;
                    }
                    if (("3141".equals(riskCode)||"3147".equals(riskCode)) && totalLossRate > nyxPlantingClaimListDto.getLossRate()){
                        calculationMethod = "02";
                    }else if (("3141".equals(riskCode)||"3147".equals(riskCode)) && totalLossRate < nyxPlantingClaimListDto.getLossRate()){
                        calculationMethod = "01";
                    }else if ("3130".equals(riskCode) && ("01".equals(growthPeriod)||"02".equals(growthPeriod))){
                        calculationMethod = "03";
                    }else if ("3130".equals(riskCode) && "03".equals(growthPeriod)){
                        calculationMethod = "04";
                    }else if ("3224".equals(riskCode)){
                        if ("mt".equals(damageWay)){
                            calculationMethod = "05";
                        }else if ("kt".equals(damageWay)){
                            calculationMethod = "06";
                        }else if ("ft".equals(damageWay)){
                            calculationMethod = "07";
                        }
                    }
                    if (calculationMethod.equals(prpLConfigDto.getCalculationMethod())){
                        prpLConfigurationDto = prpLConfigDto;
                        break;
                    }
                }else {
                    prpLConfigurationDto = prpLConfigurationDtoList.get(0);
                }
            }
            resultMap.put("description",prpLConfigurationDto.getFormulaDescribing());
            formula = prpLConfigurationDto.getFormula();
        }
        if (StringUtils.isEmpty(formula)){
            throw new BusinessException("没有对应计算公式，请手动输入赔偿金额！");
        }
        String[] configCodes =formula.split("]");

        for (String a : configCodes){
            int k = a.indexOf("[");
            String configCode = a.substring(k+1,a.length());
            PrpLFormulaConfigDto prpLFormulaConfigDto = new PrpLFormulaConfigDto();
            prpLFormulaConfigDto.setRiskCode(riskCode);
            prpLFormulaConfigDto.setConfigCode(configCode);
            //出苗期等时期需要添加
            prpLFormulaConfigDto.setReserve1(growthPeriod);
            List<PrpLFormulaConfigDto> prpLFormulaConfigDtoList = prpLFormulaConfigApi.queryPrpLFormulaConfigDtoListByCondition(prpLFormulaConfigDto);
            if (prpLFormulaConfigDtoList.size() > 0 ){
                prpLFormulaConfigDto = prpLFormulaConfigDtoList.get(0);
            }
            //赔偿标准
            if ("compestandard".equals(configCode)){
                if (nyxPlantingClaimListDto.getClaimRate() != null && nyxPlantingClaimListDto.getClaimRate() != 0.0){
                    BigDecimal unitAmount = new BigDecimal(prpCitemKindDto.getUnitAmount().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal claimRate = new BigDecimal(nyxPlantingClaimListDto.getClaimRate().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    map.put(configCode,String.valueOf(unitAmount.multiply(claimRate)));
                }else {
                    BigDecimal unitAmount = new BigDecimal(prpCitemKindDto.getUnitAmount().toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal claimRate = new BigDecimal(prpLFormulaConfigDto.getConfigUrationContent()).setScale(2, BigDecimal.ROUND_HALF_UP);
                    map.put(configCode,String.valueOf(unitAmount.multiply(claimRate)));
                }
            }
            //损失率 / 损失程度
            if ("lossrate".equals(configCode)){
                Double rate = nyxPlantingClaimListDto.getLossRate();
                if ("3149".equals(riskCode)){
                    rate = this.calculate3149LossRate(rate);
                }else {
                    rate = this.calculateLossRate(prpCitemKindDto,rate);
                }
                map.put(configCode,String.valueOf(rate/100));
            }
            //损失面积
            if("lossarea".equals(configCode)){
                map.put(configCode,String.valueOf(nyxPlantingClaimListDto.getLossArea()));
            }
            //单位面积保险金额
            if ("unitAmount".equals(configCode)){
                if (prpCitemKindDto.getUnitAmount()!= null){
                    map.put(configCode,String.valueOf(prpCitemKindDto.getUnitAmount()));
                }else {
                    map.put(configCode,"0");
                }
            }
            //相应茬次保险金额分布比例
            if ("distrate".equals(configCode)){
                if (prpCitemKindAgriDto != null){
                    if (prpCitemKindAgriDto.getDistributingRate() != null){
                        map.put(configCode,String.valueOf(prpCitemKindAgriDto.getDistributingRate()/100));
                    }else {
                        map.put(configCode,"0");
                    }
                }
            }
            //绝对免赔率
            if ("deductible".equals(configCode)){
                if (nyxPlantingClaimListDto.getDeductible()!= null){
                    map.put(configCode,String.valueOf(Double.parseDouble(nyxPlantingClaimListDto.getDeductible())/100));
                }else{
                    map.put(configCode,"0");
                }
            }
            //不同生长周期赔偿比例
            if ("comperate".equals(configCode)){
                map.put(configCode,String.valueOf(Double.parseDouble(prpLFormulaConfigDto.getConfigUrationContent())/100));
            }
            if("harvestDate".equals(configCode)){
                Long startDate = prpCitemKindAgriDto.getStratDate().getTime();
                Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                Long harvestDate = endDate - startDate;
                map.put(configCode,String.valueOf(harvestDate/(1000*60*60*24)));
            }
            if("regisHarvestDate".equals(configCode)){
                Long damageStartDate = prpLRegistDto.getDamageStartDate().getTime();
                Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                Long regisHarvestDate = endDate - damageStartDate;
                map.put(configCode,String.valueOf(regisHarvestDate/(1000*60*60*24)));
            }
            if ("harvestedAmount".equals(configCode) || "deductionAmount".equals(configCode)){
                String deductionAmount = "";
                if (StringUtils.isNotEmpty(nyxPlantingClaimListDto.getDeductionAmount())){
                    deductionAmount = nyxPlantingClaimListDto.getDeductionAmount();
                }else {
                    deductionAmount = "0";
                }
                map.put(configCode,deductionAmount);
            }
            if ("TTimeRate".equals(configCode)||"ITimeRate".equals(configCode)){
                map.put(configCode,damageDegree);
            }
            //保险金额
            if ("insuramount".equals(configCode)){
                NyxEffectiveAmountDto nyxEffectiveAmountDto = new NyxEffectiveAmountDto();
                nyxEffectiveAmountDto.setPolicyNo(nyxPlantingClaimListDto.getPolicyNo());
                nyxEffectiveAmountDto.setRiskCode(riskCode);
                nyxEffectiveAmountDto.setKindCode(kindCode);
                nyxEffectiveAmountDto.setItemCode(nyxPlantingClaimListDto.getItemCode());
                nyxEffectiveAmountDto.setfCode(nyxPlantingClaimListDto.getfCode());
                nyxEffectiveAmountDto.setFlag(times);
                nyxEffectiveAmountDto.setStartDate(prpLRegistDto.getDamageStartDate());
                NyxEffectiveAmountDto nyxEffectiveAmountDto1 = nyxEffectiveAmountApi.queryAll(nyxEffectiveAmountDto);
                if (nyxEffectiveAmountDto1 != null){
                    map.put(configCode,nyxEffectiveAmountDto1.getAmount().toString());
                }else {
                    map.put(configCode,"0");
                }
            }
            if (configCode.startsWith("0") || configCode.startsWith("1")){
                map.put(configCode,configCode);
            }
            String configCode1 = a.substring(k,a.length())+"]";
            formula = formula.replace(configCode1, map.get(configCode));
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("js");
        if (engine == null) {
            throw new BusinessException("No engine for JavaScript");
        }
        try{
            Object result1= engine.eval(formula);
            BigDecimal   b   =   new   BigDecimal(Double.valueOf(result1.toString()));
            double result2 = b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            formula = formula.replace('*','x');
            resultMap.put("result",result2);
            resultMap.put("formula",formula+"="+result2);
        }
        catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return resultMap;
    }

    /**
     * （通过免赔率起赔点和全损率计算最终赔偿损失率）
     * @author: 王志文
     * @date: 2018/1/30 10:59
     * @param prpCitemKindDto
     * @param rate 损失率
     * @return 计算后损失率
     */
    private Double calculateLossRate(PrpCitemKindDto prpCitemKindDto,Double rate){
        Double lossRate = 0.0;
        //起赔点
        Double triggerPoint = prpCitemKindDto.getTriggerPoint();
        //全损率
        Double totalLossRate = prpCitemKindDto.getTotalLossRatio();

        if (triggerPoint == null){
            triggerPoint = 0.0;
        }
        if (totalLossRate == null){
            totalLossRate = 100.0;
        }
        if (rate >= triggerPoint) {
            if (rate >= totalLossRate) {
                lossRate = 100.0;
            } else {
                lossRate = rate;
            }
        }else{
            lossRate = 0.0;
        }
        return lossRate;
    }

    /**
     * （根据出险日期判断当前报案标的所属茬次）
     * @author: 王志文
     * @date: 2018/4/18 19:00
     * @param registNo
     * @param map
     * @return
     * @throws Exception
     */
    public int checkStubbleByRegistNo(String registNo,Map<String,Object> map)throws Exception{
        PrpLRegistDto registDto = prpLRegistApi.queryByPK(registNo);
        Date reportDate = registDto.getDamageStartDate();
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList =
                prpCitemKindAgriApi.queryListByPolicyNoAndKindCodeAndTimesDate(map);
        for (PrpCitemKindAgriDto prpCitemKindAgriDto: prpCitemKindAgriDtoList) {
            if (prpCitemKindAgriDto.getStratDate() != null && prpCitemKindAgriDto.getEndDate() != null
                    && StringUtils.isNotEmpty(prpCitemKindAgriDto.getStratDate().toString())
                    && StringUtils.isNotEmpty(prpCitemKindAgriDto.getEndDate().toString())){
                Long startDate = prpCitemKindAgriDto.getStratDate().getTime();
                Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                Long registDate = reportDate.getTime();
                if (registDate > startDate && registDate <endDate){
                    if (prpCitemKindAgriDto.getTimes()>0){
                        return prpCitemKindAgriDto.getTimes();
                    }
                }
            }else {
                continue;
            }
        }
        return 0;
    }

    /**
     * （根据出险日期判断当前报案标的所属茬次）
     *
     * @param
     * @param map
     * @return
     * @throws Exception
     * @author: 王志文
     * @date: 2018/4/18 19:00
     */
    public int checkStubbleByRegistNo1(Map<String, Object> map) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate1 = (String) map.get("reportDate");
        Date reportDate = format.parse(reportDate1);
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList =
                prpCitemKindAgriApi.queryListByPolicyNoAndKindCodeAndTimesDate(map);
        for (PrpCitemKindAgriDto prpCitemKindAgriDto : prpCitemKindAgriDtoList) {
            if (prpCitemKindAgriDto.getStratDate() != null && prpCitemKindAgriDto.getEndDate() != null
                    && StringUtils.isNotEmpty(prpCitemKindAgriDto.getStratDate().toString())
                    && StringUtils.isNotEmpty(prpCitemKindAgriDto.getEndDate().toString())) {
                Long startDate = prpCitemKindAgriDto.getStratDate().getTime();
                Long endDate = prpCitemKindAgriDto.getEndDate().getTime();
                Long registDate = reportDate.getTime();
                if (registDate > startDate && registDate < endDate) {
                    if (prpCitemKindAgriDto.getTimes() > 0) {
                        return prpCitemKindAgriDto.getTimes();
                    }
                }
            } else {
                continue;
            }
        }
        return 0;
    }
    /**
     * 根据报案号删除理赔清单信息
     * @author: 孙朋飞
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    @Override
    public void deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(String registNo,String compensateNo,String nodeType) throws Exception {
//        if (StringUtils.isNotEmpty(compensateNo) && compensateNo.startsWith("6")){
//            nyxPlantingClaimListDao.deleteNyxPlantingClaimListByRegistNoAndCompensateNoAndNodeType(registNo,compensateNo,nodeType);
//        }else {
            nyxPlantingClaimListDao.deleteNyxPlantingClaimListByRegistNo(registNo,nodeType);
//        }
    }

    /**
     * （报案号和节点状态查询数据）
     * @author: 王志文
     * @date: 2018/3/27 19:49
     * @param registNo
     * @param nodeType
     * @return
     * @throws Exception
     */
    public List<NyxPlantingClaimListDto> queryAllByRegistNoAndNodeType(String registNo,String nodeType){
        List<NyxPlantingClaimList> nyxPlantingClaimLists = nyxPlantingClaimListDao.queryAllByRegistNoAndNodeType(registNo,nodeType);
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList = new ArrayList<>();
        this.convertCollection(nyxPlantingClaimLists,nyxPlantingClaimListDtoList,NyxPlantingClaimListDto.class);
        return nyxPlantingClaimListDtoList;
    }
    /**
     * 根据报案号和清单号回写立案号
     * @author:
     * @date: 2018/3/27 19:49
     * @param
     * @param
     * @return
     * @throws Exception
     */
    public void saveclaimNo(String listNo,String registNo,String claimNo) throws Exception{
        nyxPlantingClaimListDao.saveclaimNo(listNo,registNo,claimNo);
    }

    /**
     * （3149险种公式计算损失率）
     * @author: 王志文
     * @date: 2018/5/23 15:20
     * @param rate
     * @return
     */
    private Double calculate3149LossRate(Double rate){
        if (rate>90.0){
            return 100.0;
        }else if (rate < 10.0){
            return 0.0;
        }
        return rate;
    }
}