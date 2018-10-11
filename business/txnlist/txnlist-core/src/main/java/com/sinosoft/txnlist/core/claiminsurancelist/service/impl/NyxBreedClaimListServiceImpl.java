package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.agriprpall.api.policymanage.PrpCitemKindApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDclauseCodeApi;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateHerdListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateWholeListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxBreedClaimListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxBreedClaimListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.NyxBreedClaimListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxBreedClaimList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.NyxBreedClaimListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateMainListService;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxBreedClaimListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdPolicyListService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 03:26:32.072 
 * @description 养殖险理赔清单信息表Core接口实现
 */
@Service
public class NyxBreedClaimListServiceImpl extends BaseCustomServiceImpl implements NyxBreedClaimListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxBreedClaimListServiceImpl.class);
    
    @Autowired
    private NyxBreedClaimListDao nyxBreedClaimListDao;
    @Autowired
    private HerdPolicyListService herdPolicyListService;
    @Autowired
    private LossRateMainListService lossRateMainListService;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpCitemKindApi prpCitemKindApi;
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private PrpDclauseCodeApi prpDclauseCodeApi;
    /**
     *@description 新增
     *@param
     */
    public void save(NyxBreedClaimListDto nyxBreedClaimListDto) {
        NyxBreedClaimList nyxBreedClaimList = this.convert(nyxBreedClaimListDto, NyxBreedClaimList.class);
        nyxBreedClaimListDao.save(nyxBreedClaimList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo,String serialNo) {
        NyxBreedClaimListKey nyxBreedClaimListKey = new NyxBreedClaimListKey(listNo,serialNo);
        nyxBreedClaimListDao.delete(nyxBreedClaimListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(NyxBreedClaimListDto nyxBreedClaimListDto) {
        NyxBreedClaimList nyxBreedClaimList = this.convert(nyxBreedClaimListDto, NyxBreedClaimList.class);
        nyxBreedClaimListDao.save(nyxBreedClaimList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxBreedClaimListDto queryByPK(String listNo,String serialNo) {
        NyxBreedClaimListKey nyxBreedClaimListKey = new NyxBreedClaimListKey(listNo,serialNo);
        NyxBreedClaimList nyxBreedClaimList = nyxBreedClaimListDao.findOne(nyxBreedClaimListKey);
        return this.convert(nyxBreedClaimList,NyxBreedClaimListDto.class);
    }



    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode封装查询条件数据  当前页数pageNo 每页显示行数pageSize
     * @Return pageInfo 分页查询结果集，总记录数totalCount 当前页数  pages
     */

    public PageInfo<NyxBreedClaimListDto> queryNyxBreedClaimListByCondition(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)  {

        if (requestNyxBreedClaimListDto.getPageSize() == 0) {
            requestNyxBreedClaimListDto.setPageSize(20);
        }
        if (requestNyxBreedClaimListDto.getPageNo() < 1) {
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (requestNyxBreedClaimListDto.getPageSize() < 1) {
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        StringBuilder count = new StringBuilder(200);
        StringBuilder sql = new StringBuilder(200);

        count.append("SELECT  COUNT(1) FROM NyxBreedClaimList p ");
        sql.append("SELECT p FROM NyxBreedClaimList p ");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();
        //有可选条件
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getListNo())) {
            conditionList.add("and p.listNo=:listNo");
            paraMap.put("listNo", requestNyxBreedClaimListDto.getListNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getPolicyNo())) {
            conditionList.add("and p.policyNo=:policyNo");
            paraMap.put("policyNo", requestNyxBreedClaimListDto.getPolicyNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getCompensateNo())) {
            conditionList.add("and p.compensateNo=:compensateNo");
            paraMap.put("compensateNo", requestNyxBreedClaimListDto.getCompensateNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getRegistNo())) {
            conditionList.add("and p.registNo=:registNo");
            paraMap.put("registNo", requestNyxBreedClaimListDto.getRegistNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getfCode())) {
            conditionList.add("and p.fCode=:fCode");
            paraMap.put("fCode", requestNyxBreedClaimListDto.getfCode());
        }


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
        dataQuery.setFirstResult((requestNyxBreedClaimListDto.getPageNo() - 1) * requestNyxBreedClaimListDto.getPageSize());
        dataQuery.setMaxResults(requestNyxBreedClaimListDto.getPageSize());

        long countNum = (long) countQuery.getSingleResult();

        List<NyxBreedClaimList> resultList = dataQuery.getResultList();
        List<NyxBreedClaimListDto> NyxBreedClaimListDtoList = new ArrayList<>();

        convertCollection(resultList, NyxBreedClaimListDtoList, NyxBreedClaimListDto.class);
        //统一封装分页响应dto
        PageInfo<NyxBreedClaimListDto> pageInfo = new PageInfo<NyxBreedClaimListDto>();
        pageInfo.setContent(NyxBreedClaimListDtoList);// 数据存放dto集合
        pageInfo.setPages(requestNyxBreedClaimListDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;

    }

    /**
     * @Description: 理赔清单数据查询（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param requestNyxBreedClaimListDto  listNo  policyNo  registNo  compensateNo fCode
     * @Return List<NyxBreedClaimListDto> 结果集，
     */
    public List<NyxBreedClaimListDto> queryNyxBreedClaimListByConditions(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto)  {

        StringBuilder sql = new StringBuilder(200);

        sql.append("SELECT p FROM NyxBreedClaimList p ");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();
        //有可选条件
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getListNo())) {
            conditionList.add("and p.listNo=:listNo");
            paraMap.put("listNo", requestNyxBreedClaimListDto.getListNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getPolicyNo())) {
            conditionList.add("and p.policyNo=:policyNo");
            paraMap.put("policyNo", requestNyxBreedClaimListDto.getPolicyNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getCompensateNo())) {
            conditionList.add("and p.compensateNo=:compensateNo");
            paraMap.put("compensateNo", requestNyxBreedClaimListDto.getCompensateNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getRegistNo())) {
            conditionList.add("and p.registNo=:registNo");
            paraMap.put("registNo", requestNyxBreedClaimListDto.getRegistNo());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getfCode())) {
            conditionList.add("and p.fCode=:fCode");
            paraMap.put("fCode", requestNyxBreedClaimListDto.getfCode());
        }
        if (StringUtils.isNotEmpty(requestNyxBreedClaimListDto.getNodeType())) {
            conditionList.add("and p.nodeType=:nodeType");
            paraMap.put("nodeType", requestNyxBreedClaimListDto.getNodeType());
        }

        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
        }
        sql.append(" order by to_number(p.serialNo)");
        Query dataQuery = entityManager.createQuery(sql.toString());

        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            dataQuery.setParameter(entry.getKey(), entry.getValue());

        }
        List<NyxBreedClaimList> resultList = dataQuery.getResultList();
        List<NyxBreedClaimListDto> NyxBreedClaimListDtoList = new ArrayList<>();

        convertCollection(resultList, NyxBreedClaimListDtoList, NyxBreedClaimListDto.class);
        return NyxBreedClaimListDtoList;
    }


    /**
     * @Description: 理赔清单计算书号关联（养殖险）
     * @throws Exception
     * @Author:李文刚
     * @Date：2017/12/28 9:09
     * @Param   listNo  compensateNo
     * @Return
     */
    public  void  updateNyxBreedClaimListCompensateNo(Map<String ,String > map) {
        String listNo = map.get("listNo");
        String compensateNo = map.get("compensateNo");
        // 必传值
        if (StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("理赔清单号不能为空");
        }
        if (StringUtils.isEmpty(compensateNo)) {
            throw new DataVerifyException("计算书号不能为空");
        }
        nyxBreedClaimListDao.updateNyxBreedClaimListByListNo(listNo,compensateNo);
        /*RequestNyxBreedClaimListDto requestNyxBreedClaimListDto = new RequestNyxBreedClaimListDto();
        requestNyxBreedClaimListDto.setCompensateNo(compensateNo);
        requestNyxBreedClaimListDto.setListNo(listNo);
        //得到查询的dto结果集
        List<NyxBreedClaimListDto> nyxBreedClaimListDtolist = this.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
        //数据表集合
        List<NyxBreedClaimList> nyxBreedClaimListList = new ArrayList<>();
        //把dto的集合转为数据表集合，并批量保存。
        convertCollection(nyxBreedClaimListDtolist,nyxBreedClaimListList,NyxBreedClaimList.class);
        nyxBreedClaimListDao.save(nyxBreedClaimListList);*/
    }
    /**
     * 批量保存养殖险险理赔清单信息
     * @author: 孙朋飞
     * @date: 2017/12/29 11:42
     * @param nyxBreedClaimListDtos 理赔清单的集合
     * @return 是否保存成功
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSaveNyxBreedClaimList(List<NyxBreedClaimListDto> nyxBreedClaimListDtos) throws Exception {
//        List<NyxBreedClaimList> nyxBreedClaimLists=new ArrayList<>();
//        this.convertCollection(nyxBreedClaimListDtos,nyxBreedClaimLists,NyxBreedClaimList.class);
//        for (int i = 0; i < nyxBreedClaimLists.size(); i++) {
//            nyxBreedClaimLists.get(i).setSerialNo(String.valueOf(i + 1));
//        }
//        nyxBreedClaimListDao.save(nyxBreedClaimLists);
        List<NyxBreedClaimList> nyxBreedClaimLists=new ArrayList<>();
        this.convertCollection(nyxBreedClaimListDtos,nyxBreedClaimLists,NyxBreedClaimList.class);
        for (int i = 0; i < nyxBreedClaimLists.size(); i++) {
            nyxBreedClaimLists.get(i).setSerialNo(String.valueOf(i + 1));
            entityManager.persist(nyxBreedClaimLists.get(i));
        }
        entityManager.flush();
        entityManager.clear();
        return true;
    }

    /**
     * 养殖险根据保单号、报案号查询承保清单、定损清单封装理赔清单
     * map 保单号、报案号
     * @author: 王心洋
     * @date: 2018/03/31
     * @throws Exception
     */
    @Override
    public void assembleNyxBreedClaimList(String policyNo,String registNo,String compensateNo) throws Exception{
        List<HerdPolicyListDto> herdPolicyListDtoList = herdPolicyListService.queryByPolicyNo(policyNo);
        if(herdPolicyListDtoList==null || herdPolicyListDtoList.size()<=0){
            throw new BusinessException("没有承保清单信息！");
        }
        LossRateWholeListDto lossRateWholeListDto =
                lossRateMainListService.queryComparable(policyNo,registNo);
        if(lossRateWholeListDto==null || lossRateWholeListDto.getLossRateMainListDto()==null){
            throw new BusinessException("没有定损清单信息！");
        }
        NyxBreedClaimListDto nyxBreedClaimListDto;
        List<NyxBreedClaimListDto> nyxBreedClaimListDtoList = new ArrayList<>();
        nyxBreedClaimListDto = new NyxBreedClaimListDto();
        for(LossRateHerdListDto lossRateHerdListDto:lossRateWholeListDto.getLossRateHerdListDtoList()) {
            nyxBreedClaimListDto.setListNo(lossRateWholeListDto.getLossRateMainListDto().getLossListCode());
            nyxBreedClaimListDto.setSerialNo(lossRateWholeListDto.getLossRateMainListDto().getSerialNo() + "");
            nyxBreedClaimListDto.setPolicyNo(lossRateWholeListDto.getLossRateMainListDto().getPolicyNo());
            nyxBreedClaimListDto.setRegistNo(lossRateWholeListDto.getLossRateMainListDto().getBizNo());
            nyxBreedClaimListDto.setCompensateNo(compensateNo);
            for(int i=0;i<lossRateWholeListDto.getLossRateItemListDtoList().size();i++) {
                if(lossRateHerdListDto.getfCode().equals(lossRateWholeListDto.getLossRateItemListDtoList().get(i).getfCode())
                        && lossRateHerdListDto.getItemCode().equals(lossRateWholeListDto.getLossRateItemListDtoList().get(i).getItemCode())) {
                    nyxBreedClaimListDto.setItemCode(lossRateWholeListDto.getLossRateItemListDtoList().get(i).getItemCode());
                    nyxBreedClaimListDto.setfCode(lossRateWholeListDto.getLossRateItemListDtoList().get(i).getfCode());
                    nyxBreedClaimListDto.setfName(lossRateWholeListDto.getLossRateItemListDtoList().get(i).getfName());
                    break;
                }
            }
            for(int i=0;i<lossRateWholeListDto.getLossRateLossListDtoList().size();i++) {
                if(lossRateHerdListDto.getfCode().equals(lossRateWholeListDto.getLossRateLossListDtoList().get(i).getfCode())
                        && lossRateHerdListDto.getItemCode().equals(lossRateWholeListDto.getLossRateLossListDtoList().get(i).getItemCode())
                        && lossRateHerdListDto.getLossSerialNo().equals(lossRateWholeListDto.getLossRateLossListDtoList().get(i).getLossSerialNo())) {
                    nyxBreedClaimListDto.setPayAmount(lossRateWholeListDto.getLossRateLossListDtoList().get(i).getLossMoney());
                    break;
                }
            }
            nyxBreedClaimListDto.setEarConNo(lossRateHerdListDto.getEarLabel());
            for(int i=0;i<herdPolicyListDtoList.size();i++) {
                if(lossRateHerdListDto.getfCode().equals(herdPolicyListDtoList.get(i).getfCode())) {
                    nyxBreedClaimListDto.setfIdCard(herdPolicyListDtoList.get(i).getfIdCard());
                    nyxBreedClaimListDto.setPhoneNumber(herdPolicyListDtoList.get(i).getPhone());
                    nyxBreedClaimListDto.setBankAccount(herdPolicyListDtoList.get(i).getBankCard());
                    nyxBreedClaimListDto.setPayType("C");
                    break;
                }
            }
            nyxBreedClaimListDtoList.add(nyxBreedClaimListDto);
        }
        batchSaveNyxBreedClaimList(nyxBreedClaimListDtoList);
    }
    /**
     * 根据报案号和清单号回写立安好
     * @author:
     * @date: 2018/3/27 19:49
     * @param
     * @param
     * @return
     * @throws Exception
     */
    public void saveclaimNo(String listNo,String registNo,String claimNo) throws Exception{
        nyxBreedClaimListDao.saveclaimNo(listNo,registNo,claimNo);
    }
    /**
     * 根据报案号删除理赔清单信息
     * @author: 陈道洋
     * @date: 2018/3/27 18:43
     * @param registNo 报案号
     * @throws Exception
     */
    @Override
    public void deleteNyxBreedClaimListByRegistNo(String registNo,String compensateNo,String nodeType) throws Exception {
//        if (StringUtils.isNotEmpty(compensateNo) && compensateNo.startsWith("6")){
//            nyxBreedClaimListDao.deleteNyxBreedClaimListByRegistNoandAndCompensateNo(registNo,compensateNo,nodeType);
//        }else {
            nyxBreedClaimListDao.deleteNyxPlantingClaimListByRegistNo(registNo,nodeType);
//        }
    }

    /**
     * （养殖险计算过程生成）
     * @author: 王志文
     * @date: 2018/4/27 10:35
     * @param policyNo
     * @param kindCode
     * @param listNo
     * @param registNo
     * @return
     * @throws Exception
     */
    public Map<String, Object> queryBreedProcess(String policyNo,String kindCode, String listNo,String registNo)throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if ("3220".equals(policyNo.substring(1,5))){
            //该险种无对应计算公式
            resultMap.put("code","2222");
            return resultMap;
        }
        Integer count = nyxBreedClaimListDao.checkCompeNodeType(listNo);
        if (count == 0){
            resultMap.put("code","1111");
            return resultMap;
        }
        List<String> itemCodeList = nyxBreedClaimListDao.getItemCodeCountByBillNo(listNo);
        List<Long> deathAmountList = nyxBreedClaimListDao.queryCountEarNoByListNo(listNo);
        List<Double> deductionAmountList = nyxBreedClaimListDao.queryDeductionAmountSum(listNo);
        Double deductionAmount = 0.0;
        if (deductionAmountList.size()>0){
            if (deductionAmountList.get(0) != null){
                deductionAmount = deductionAmountList.get(0);
            }
        }
        if (itemCodeList.size()>1){
            resultMap.put("code","3333");
        }
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(registNo);
        String riskCName = prpDriskApi.translateCodeByPK(prpLRegistDto.getRiskCode());
        resultMap.put("riskCName",riskCName);
        Map<String,Object> paraMap = new HashMap<>();
        paraMap.put("policyNo",policyNo);
        paraMap.put("kindCode",kindCode);
        paraMap.put("itemCode",prpLRegistDto.getLossCode());
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        List<PrpCitemKindDto> prpCitemKindDtoList = prpCitemKindApi.queryAllByPolicyNoAndKindCodeAndItemCode(paraMap);
        if (prpCitemKindDtoList.size()>0){
            prpCitemKindDto = prpCitemKindDtoList.get(0);
        }
        Double unitAmount = 0.0;
        if (prpCitemKindDto!= null){
            unitAmount = prpCitemKindDto.getUnitAmount();
        }
        if (deathAmountList.size() == 1){
            Map<String,String> map = new HashMap<>();
            map.put("policyNo",policyNo);
            PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(map);
            String versionNo = "";
            if (prpCmainDto != null){
                versionNo = prpCmainDto.getVersionNo();
            }
            map.put("clauseCode",versionNo);
            PrpDclauseCodeDto prpDclauseCodeDto = prpDclauseCodeApi.queryByPK(map);
            String businessType = prpDclauseCodeDto.getBusinessType();
            Double settleAmount = nyxBreedClaimListDao.querySumSettleAmountByListNoAndNodeType(listNo,"compe");
            if (StringUtils.isNotEmpty(businessType) && "00".equals(businessType)){
                Double result = deathAmountList.get(0)*unitAmount;
                Double settleResult = settleAmount - result;
                if (settleResult != null && settleResult != 0.0){
                    //手动输入金额，无计算过程
                    resultMap.put("riskCName",null);
                    resultMap.put("description",null);
                    resultMap.put("code","4444");
                }else {
                    String formula = deathAmountList.get(0)+"×"+unitAmount;
                    resultMap.put("result",result);
                    resultMap.put("description","赔偿金额 = 死亡数量×每头保险金额");
                    resultMap.put("formula",formula+"="+result);
                }
            }else {
                Double result = deathAmountList.get(0)*(unitAmount-deductionAmount);
                Double settleResult = settleAmount - result;
                if (settleResult != null && settleResult != 0.0){
                    //手动输入金额，无计算过程
                    resultMap.put("riskCName",null);
                    resultMap.put("description",null);
                    resultMap.put("code","4444");
                }else {
                    String formula = deathAmountList.get(0) + "×(" + unitAmount + "-" + deductionAmount + ")";
                    resultMap.put("result", result);
                    resultMap.put("description", "赔偿金额 = 死亡数量×(每头保险金额-每头基础母牛政府扑杀专项补贴金额)");
                    resultMap.put("formula", formula + "=" + result);
                }
            }
        }else {
            resultMap.put("code","3333");
        }
        return resultMap;
    }
    /**
     * （根据立案号号查立案信息）
     * @author: 陈道洋
     * @date: 2018/4/26 20:45
     * @param map
     * @return
     * @throws Exception
     */
    public List<NyxBreedClaimListDto> queryByClaimNo(List<String> list)throws  Exception{
        List<NyxBreedClaimList> nyxBreedClaimLists=null;
        if (list.size() > 0) {
           nyxBreedClaimLists = nyxBreedClaimListDao.queryByClaimNo(list);
        }
        List<NyxBreedClaimListDto> nyxBreedClaims=new ArrayList<>();
       this.convertCollection(nyxBreedClaimLists,nyxBreedClaims,NyxBreedClaimListDto.class);
        return nyxBreedClaims;
    }

}