package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.*;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.*;
import com.sinosoft.txnlist.core.claiminsurancelist.service.*;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxPolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.Planting31PolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingPolicyListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31PolicyList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingPolicyList;
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
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单主表Core接口实现
 */
@Service
@Transactional
public class LossRateMainListServiceImpl extends BaseCustomServiceImpl implements LossRateMainListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRateMainListServiceImpl.class);
    
    @Autowired
    private LossRateMainListDao lossRateMainListDao;
    @Autowired
    private LossRateMainListService lossRateMainListService;
    @Autowired
    private LossRateItemListService lossRateItemListService;
    @Autowired
    private LossRateLossListService lossRateLossListService;
    @Autowired
    private LossRateHerdListService lossRateHerdListService;
    @Autowired
    private LossRatePersListService lossRatePersListService;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private InsureMainListDao insureMainListDao;
    @Autowired
    private PlantingPolicyListDao plantingPolicyListDao;
    @Autowired
    private PrpLRegistApi prpLRegistApi;
    @Autowired
    private LossRateItemListDao lossRateItemListDao;
    @Autowired
    private LossRateLossListDao lossRateLossListDao;
    @Autowired
    private LossRateHerdListDao lossRateHerdListDao;
    @Autowired
    private LossRatePersListDao lossRatePersListDao;
    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;
    @Autowired
    private Planting31PolicyListDao planting31PolicyListDao;
    /**
     *@description 新增
     *@param
     */
    public void save(LossRateMainListDto lossRateMainListDto) {
        LossRateMainList lossRateMainList = this.convert(lossRateMainListDto, LossRateMainList.class);
        lossRateMainListDao.save(lossRateMainList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String lossListCode,java.lang.Integer serialNo) {
        LossRateMainListKey lossRateMainListKey = new LossRateMainListKey(lossListCode,serialNo);
        lossRateMainListDao.delete(lossRateMainListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRateMainListDto lossRateMainListDto) {
        LossRateMainList lossRateMainList = this.convert(lossRateMainListDto, LossRateMainList.class);
        lossRateMainListDao.save(lossRateMainList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateMainListDto queryByPK(String lossListCode,java.lang.Integer serialNo) {
        LossRateMainListKey lossRateMainListKey = new LossRateMainListKey(lossListCode,serialNo);
        LossRateMainList lossRateMainList = lossRateMainListDao.findOne(lossRateMainListKey);
        return this.convert(lossRateMainList,LossRateMainListDto.class);
    }

    /**
     *@description 按清单号查询最大序列号
     *@param lossListCode 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    public Integer queryMaxSerialByLossListCode(String lossListCode) throws Exception{
        Integer serialNo = lossRateMainListDao.queryMaxSerialByLossListCode(lossListCode);
        if(serialNo == null){
            serialNo = 0;
        }
        return serialNo;
    }

    /**
     * 按条件查询实体集合
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return List<LossRateMainListDto>定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public List<LossRateMainListDto> queryByConditions(String policyNo, String bizNo) throws Exception{
        StringBuilder stringBuilder = new StringBuilder("select l.* from LossRateMainList l,(select m.lossListCode,max(m.serialNo) maxSerialNo ");
        stringBuilder.append("from LossRateMainList m group by m.lossListCode) lm ");
        stringBuilder.append("where l.policyNo=:policyNo and (l.bizNo=:bizNo or l.bizNo=:policyNo) ");
        stringBuilder.append("and l.lossListCode=lm.lossListCode and l.serialNo=lm.maxSerialNo");
        Map<String,Object> map = new HashMap<>();
        map.put("policyNo",policyNo);
        map.put("bizNo",bizNo);
        Query dataQuery= entityManager.createNativeQuery(stringBuilder.toString(),LossRateMainList.class);
        this.setQueryParam(dataQuery,map);
        List<LossRateMainList> lossRateMainListList = dataQuery.getResultList();//lossRateMainListDao.queryByConditions(policyNo, bizNo);
        List<LossRateMainListDto> lossRateMainListDtoList = new ArrayList<>();
        if(lossRateMainListList!=null) {
            this.convertCollection(lossRateMainListList, lossRateMainListDtoList, LossRateMainListDto.class);
        }
        return lossRateMainListDtoList;
    }

    /**
     * 关联报案号和清单信息
     * @param lossListCode 损失率清单号
     * @param bizNo 报案号
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public void compareInsurance(String lossListCode, String bizNo,String checkBoxFlag,String serialNo) throws Exception{
        PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(bizNo);
        lossRateMainListDao.updateLossListCheckBoxFlag(prpLRegistDto.getPolicyNo(),bizNo);
        String checked = "";
        if ("true".equals(checkBoxFlag)|| "1".equals(checkBoxFlag)){
            checked = "1";
        }
        lossRateMainListDao.compareInsurance(lossListCode, bizNo,checked,Integer.parseInt(serialNo));
    }

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return LossRateWholeListDto定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public LossRateWholeListDto queryComparable(String policyNo, String bizNo) throws Exception{
        LossRateWholeListDto lossRateWholeListDto = new LossRateWholeListDto();
        LossRateMainListDto lossRateMainListDto = new LossRateMainListDto();
        List<LossRateItemListDto> lossRateItemListDtoList = new ArrayList<>();
        List<LossRateLossListDto> lossRateLossListDtoList = new ArrayList<>();
        List<LossRateHerdListDto> lossRateHerdListDtoList = new ArrayList<>();
        List<LossRatePersListDto> lossRatePersListDtoList = new ArrayList<>();
        //根据保单号和报案号查询serialNo最大的有效清单对象
        LossRateMainList lossRateMainList = lossRateMainListDao.queryComparable(policyNo, bizNo);
        if(lossRateMainList!=null) {
            lossRateMainListDto = this.convert(lossRateMainList,LossRateMainListDto.class);
            String lossListCode = lossRateMainListDto.getLossListCode();
            int serialNo = lossRateMainListDto.getSerialNo();
            lossRateItemListDtoList = lossRateItemListService.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
            lossRateLossListDtoList = lossRateLossListService.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
            lossRateHerdListDtoList = lossRateHerdListService.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
            lossRatePersListDtoList = lossRatePersListService.queryBylossListCodeAndSerialNo(lossListCode,serialNo);

        }
        lossRateWholeListDto.setLossRateMainListDto(lossRateMainListDto);
        lossRateWholeListDto.setLossRateItemListDtoList(lossRateItemListDtoList);
        lossRateWholeListDto.setLossRateLossListDtoList(lossRateLossListDtoList);
        lossRateWholeListDto.setLossRateHerdListDtoList(lossRateHerdListDtoList);
        lossRateWholeListDto.setLossRatePersListDtoList(lossRatePersListDtoList);
        return lossRateWholeListDto;
    }

    /**
     * 根据保单号、报案号查询定损清单表中有耳标号的清单号
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return String 清单号
     * @author 王心洋
     * @time 2018-01-23
     */
    @Override
    public String queryEarLabelCount(String policyNo,String bizNo) throws Exception{
        List<String> lossListCodeList;
        StringBuilder stringBuilder = new StringBuilder("select lh.lossListCode from LossRateHerdList lh,(select m.lossListCode,max(m.serialNo) maxSerialNo ");
        stringBuilder.append("from LossRateMainList m where m.policyNo=:policyNo and m.bizNo=:bizNo group by m.lossListCode,m.serialNo) lm ");
        stringBuilder.append("where lh.lossListCode=lm.lossListCode and lh.serialNo=lm.maxSerialNo and (lh.earLabel is not null or lh.earLabel<>'') group by lh.lossListCode");
        Map<String,Object> map = new HashMap<>();
        map.put("policyNo",policyNo);
        map.put("bizNo",bizNo);
        Query dataQuery= entityManager.createNativeQuery(stringBuilder.toString());
        this.setQueryParam(dataQuery,map);
        lossListCodeList = dataQuery.getResultList();
        if(lossListCodeList!=null && lossListCodeList.size()>0) {
            return lossListCodeList.get(0);
        }else{
            return  null;
        }
    }
    /**
     * 查询养殖险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 9:26
     * @param registNo 报案号
     * @param policyNo 保单号
     * @param nodeType 节点类型
     * @param lossListCode 清单号
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @Override
    public List<ResponseBreedLossRateListDto> queryBreedLossRateListByLossListCode(String registNo,String policyNo,String nodeType,String lossListCode) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new BusinessException("保单号不能为空！");
        }
        Map<String,String> condition= new HashMap<>();
        StringBuilder conditions1=new StringBuilder();
        StringBuilder conditions2=new StringBuilder();
        StringBuilder conditions3=new StringBuilder();
        conditions1.append(" t1.policyNo=:policyNo");
        conditions2.append(" t.policyNo=:policyNo");
        conditions3.append(" main.policyNo=:policyNo");
        condition.put("policyNo",policyNo);
        if("regis".equals(nodeType)&&StringUtils.isEmpty(registNo)){
            //如果是报案环节 根据保单号和清单号查询
            conditions1.append(" and t1.losslistcode=:lossListCode");
            conditions2.append(" and t.losslistcode=:lossListCode");
            conditions3.append(" and main.losslistcode=:lossListCode");
            condition.put("lossListCode",lossListCode);
        }
        if(StringUtils.isNotEmpty(registNo)){
            conditions1.append(" and t1.bizno =:registNo");
            conditions2.append(" and t.bizno =:registNo");
            conditions3.append(" and main.bizno =:registNo");
            condition.put("registNo",registNo);
        }

        //查询是否关联
        /*boolean flag = lossRateMainListService.queryLossRateMainListByRegistNoAndLossListCode(registNo, lossListCode);
        if(flag){
            conditions4=" and main.checkBoxFlag='1' ";
        }*/
        StringBuilder sql=new StringBuilder();
        sql.append(" select rownum,");
        sql.append(" main.serialno,");
        sql.append(" main.policyno,");
        sql.append(" main.bizno,");
        sql.append(" main.losslistcode,");
        sql.append(" main.listaffirmtime,");
        sql.append(" main.deathquantity,");
        sql.append(" main.killquantity,");
        sql.append(" main.checkcontext,");
        sql.append(" list.lossamount,");
        sql.append(" item.fcode,");
        sql.append(" item.fname,");
        sql.append(" item.fidcard,");
        sql.append(" list.itemCode,");
        sql.append(" herd.earlabel,");
        sql.append(" list.lossmoney,");
        sql.append(" main.remark,");
        sql.append(" main.origin,");
        sql.append(" main.nodeorigin");
        sql.append(" from LossRateHerdList herd");
        sql.append(" left join LossRateLossList list");
        sql.append(" on herd.losslistcode=list.losslistcode");
        sql.append(" and herd.serialno=list.serialno");
        sql.append(" and herd.fcode=list.fcode");
        sql.append(" and herd.itemcode=list.itemcode");
        sql.append(" and herd.lossserialno=list.lossserialno");
        sql.append(" left join LossRateItemList item");
        sql.append(" on list.losslistcode=item.losslistcode");
        sql.append(" and list.serialno=item.serialno");
        sql.append(" and list.fcode=item.fcode");
        sql.append(" and list.itemcode=item.itemcode");
        sql.append(" left join (select *");
        sql.append(" from lossratemainlist t1 where ");
        sql.append(conditions1);
        sql.append(" and t1.serialno in ");
        sql.append(" (select max(t.serialno) as serialno");
        sql.append(" from lossratemainlist t where ");
        sql.append(conditions2);
        sql.append(" group by t.origin )) main");
        sql.append(" on item.losslistcode=main.losslistcode");
        sql.append(" and item.serialno=main.serialno WHERE ");
        sql.append(conditions3);
        Query nativeQuery = entityManager.createNativeQuery(sql.toString(),BreedLossRateListInfo.class);
        for (Map.Entry<String, String> entry : condition.entrySet()) {
            nativeQuery.setParameter(entry.getKey(),entry.getValue());
        }
        List<BreedLossRateListInfo> resultList = nativeQuery.getResultList();
        List<ResponseBreedLossRateListDto> responseBreedLossRateList=new ArrayList<>();
        convertCollection(resultList,responseBreedLossRateList,ResponseBreedLossRateListDto.class);
        return responseBreedLossRateList;
    }
    /**
     * 查询种植险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 14:40
     * @param  registNo 报案号
     * @param policyNo 保单号
     * @param nodeType 节点类型
     * @param lossListCode 清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @Override
    public List<ResponsePlantingLossRateListDto> queryPlantingLossRateListByLossListCode(String registNo,String policyNo,String nodeType,String lossListCode) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new BusinessException("保单号不能为空！");
        }
        Map<String,String> condition= new HashMap<>();
        StringBuilder conditions1=new StringBuilder();
        StringBuilder conditions2=new StringBuilder();
        StringBuilder conditions3=new StringBuilder();
        conditions1.append(" t1.policyNo=:policyNo");
        conditions2.append(" t.policyNo=:policyNo");
        conditions3.append(" main.policyNo=:policyNo");
        condition.put("policyNo",policyNo);
        if("regis".equals(nodeType)){
            //如果是报案环节 根据保单号和清单号查询
            conditions1.append(" and t1.losslistcode=:lossListCode");
            conditions2.append(" and t.losslistcode=:lossListCode");
            conditions3.append(" and main.losslistcode=:lossListCode");
            condition.put("lossListCode",lossListCode);
        }
        if(StringUtils.isNotEmpty(registNo)){
            conditions1.append(" and t1.bizno =:registNo");
            conditions2.append(" and t.bizno =:registNo");
            conditions3.append(" and main.bizno =:registNo");
            condition.put("registNo",registNo);
        }

        //查询是否关联 先注掉
        /*boolean flag = lossRateMainListService.queryLossRateMainListByRegistNoAndLossListCode(registNo, lossListCode);
        if(flag){
            conditions4=" and main.checkBoxFlag='1' ";
        }*/
        String riskCode = policyNo.substring(1, 5);
        StringBuilder sql=new StringBuilder();
        sql.append(" select rownum,");
        sql.append(" main.serialno,");
        sql.append(" main.policyno,");
        sql.append(" main.bizno,");
        sql.append(" main.lossListCode,");
        sql.append(" main.listaffirmtime,");
        sql.append(" main.disasterarea,");
        sql.append(" main.affectedarea,");
        sql.append(" main.noproductionarea,");
        sql.append(" main.checkcontext,");
        sql.append(" item.fcode,");
        sql.append(" item.fname,");
        sql.append(" item.itemcode,");
        sql.append(" item.fidCard,");
        sql.append(" list.lossrate,");
        sql.append(" list.lossamount,");
        sql.append(" list.lossmoney,");
        sql.append(" list.versionno,");
        sql.append(" main.remark,");
        sql.append(" main.origin,");
        sql.append(" main.nodeOrigin");
        if("3129".equals(riskCode)){
            sql.append(", pers.name");
        }
        sql.append(" from LossRateLossList list");
        if("3129".equals(riskCode)){
            sql.append(" left join lossrateperslist pers");
            sql.append(" on list.losslistcode=pers.losslistcode");
            sql.append(" and list.serialno=pers.serialno");
            sql.append(" and list.fcode=pers.fcode");
            sql.append(" and list.itemcode=pers.itemcode");
            sql.append(" and list.lossserialno=pers.lossserialno");
            sql.append(" left join LossRateItemList item");
            sql.append(" on pers.losslistcode = item.losslistcode");
            sql.append(" and pers.serialno = item.serialno");
            sql.append(" and pers.fcode = item.fcode");
            sql.append(" and pers.itemcode = item.itemcode");
        }else{
            sql.append(" left join LossRateItemList item");
            sql.append(" on list.losslistcode = item.losslistcode");
            sql.append(" and list.serialno = item.serialno");
            sql.append(" and list.fcode = item.fcode");
            sql.append(" and list.itemcode = item.itemcode");
        }
        sql.append(" left join (select *");
        sql.append("  from lossratemainlist t1 where ");
        sql.append(conditions1);
        sql.append(" and t1.serialno in ");
        sql.append(" (select max(t.serialno) as serialno");
        sql.append(" from lossratemainlist t where ");
        sql.append(conditions2);
        sql.append(" group by t.origin )) main");
        sql.append(" on item.losslistcode = main.losslistcode");
        sql.append(" and item.serialno = main.serialno where ");
        sql.append(conditions3);
        List<ResponsePlantingLossRateListDto> responsePlantingLossRateList=new ArrayList<>();
        if("3129".equals(riskCode)){
            //草莓组合保险
            Query nativeQuery = entityManager.createNativeQuery(sql.toString(), PlantingLossRateListInfos.class);
            for (Map.Entry<String, String> entry : condition.entrySet()) {
                nativeQuery.setParameter(entry.getKey(),entry.getValue());
            }
            List<PlantingLossRateListInfos> resultList = nativeQuery.getResultList();
            convertCollection(resultList,responsePlantingLossRateList,ResponsePlantingLossRateListDto.class);
        }else{
            Query nativeQuery = entityManager.createNativeQuery(sql.toString(), PlantingLossRateListInfo.class);
            for (Map.Entry<String, String> entry : condition.entrySet()) {
                nativeQuery.setParameter(entry.getKey(),entry.getValue());
            }
            List<PlantingLossRateListInfo> resultList = nativeQuery.getResultList();
            convertCollection(resultList,responsePlantingLossRateList,ResponsePlantingLossRateListDto.class);
        }
        //查询承保面积
        //通过policyNo查询清单号
        Map<String, Double> map = new HashMap<>();
        String inusreListCodeByPolicyNo = insureMainListDao.findInusreListCodeByPolicyNo(policyNo);
        if ("3107".equals(riskCode) || "3108".equals(riskCode) || "3155".equals(riskCode) || "3162".equals(riskCode) || "3101".equals(riskCode) || "3114".equals(riskCode)
                || "3122".equals(riskCode) || "3126".equals(riskCode) || "3161".equals(riskCode)) {
            List<PlantingPolicyList> plantingPolicyLists = plantingPolicyListDao.findInsureAreaByInusreListCodeAndfcode2(inusreListCodeByPolicyNo);
            for (PlantingPolicyList plantingPolicyList1 : plantingPolicyLists) {
                map.put(plantingPolicyList1.getfCode() + plantingPolicyList1.getItemCode(), plantingPolicyList1.getInsureArea());
            }
        } else if ("3141".equals(riskCode) || "3147".equals(riskCode)) {
            List<Planting31PolicyList> planting31PolicyList = planting31PolicyListDao.findPlanting31PolicyListByConditions1(inusreListCodeByPolicyNo);
            for (Planting31PolicyList planting31PolicyList1 : planting31PolicyList) {
                map.put(planting31PolicyList1.getfCode() + planting31PolicyList1.getItemCode(), planting31PolicyList1.getInsureArea());
            }
        } else {
            List<NyxPolicyList> nyxPolicyList = nyxPolicyListDao.findNyxPolicyListByLossListCodeAndItemCode1(inusreListCodeByPolicyNo);
            for (NyxPolicyList nyxPolicyList1 : nyxPolicyList) {
                map.put(nyxPolicyList1.getfCode() + nyxPolicyList1.getItemCode(), nyxPolicyList1.getInsureArea());
            }
        }

        for (ResponsePlantingLossRateListDto responsePlantingLossRateListDto : responsePlantingLossRateList) {
            //单险别单标的
            if("3107".equals(riskCode)||"3108".equals(riskCode)||"3155".equals(riskCode)||"3162".equals(riskCode)||"3101".equals(riskCode)||"3114".equals(riskCode)
                    ||"3122".equals(riskCode)||"3126".equals(riskCode)||"3161".equals(riskCode)){
//                Double plantingPolicyList = plantingPolicyListDao.findInsureAreaByInusreListCodeAndfcode2(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getFcode(),responsePlantingLossRateListDto.getItemCode());
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
                }
                //responsePlantingLossRateListDto.setfAreaCode(plantingPolicyList.getfAreaCode());
                //responsePlantingLossRateListDto.setKindCode(plantingPolicyList.getKindCode());
            }else if("3141".equals(riskCode)||"3147".equals(riskCode)){
//                List<Double> planting31PolicyList = planting31PolicyListDao.findPlanting31PolicyListByConditions1(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getFcode(), responsePlantingLossRateListDto.getItemCode());
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
                }
            }else{
                //如果是多险别多标的 查询nyxpolicylist
//                List<Double> nyxPolicyList= nyxPolicyListDao.findNyxPolicyListByLossListCodeAndItemCode1(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getItemCode(),responsePlantingLossRateListDto.getFcode());
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
                    //responsePlantingLossRateListDto.setfAreaCode(nyxPolicyList.getfAreaCode());
                    //responsePlantingLossRateListDto.setKindCode(policyList.getKindCode());
               }
            }


        }
        return responsePlantingLossRateList;
    }
    /**
     * 查询养殖险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 9:26
     * @param registNo 报案号
     * @param lossListCode 清单号
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @Override
    public List<ResponseBreedLossRateListDto> downloadlList(String registNo,String lossListCode,String policyNo) throws Exception {
        //根据清单号或者报案号查询
        String conditions1="";
        String conditions2="";
        String conditions3="";
        String conditions4="";
        if(StringUtils.isEmpty(registNo)&&StringUtils.isEmpty(lossListCode)){
            throw new BusinessException("报案号和清单号不能同时为空!");
        }
        Map<String,String> condition= new HashMap<>();
        if(StringUtils.isNotEmpty(registNo)){
            conditions1=" t1.bizno =:registNo";
            conditions2=" t.bizno =:registNo";
            conditions3=" main.bizno=:registNo";
            condition.put("registNo",registNo);
        }
        if(StringUtils.isNotEmpty(lossListCode)){
            conditions1=" t1.losslistcode=:lossListCode";
            conditions2=" t.losslistcode=:lossListCode";
            conditions3=" main.losslistcode=:lossListCode";
            condition.put("lossListCode",lossListCode);
        }
        if(StringUtils.isNotEmpty(registNo)&&StringUtils.isNotEmpty(lossListCode)){
            conditions1="t1.bizno =:registNo and t1.losslistcode=:lossListCode";
            conditions2=" t.bizno =:registNo and t.losslistcode=:lossListCode";
            conditions3=" main.bizno=:registNo and main.losslistcode=:lossListCode";
        }
        if(registNo!=null&&policyNo!=null){
            conditions4=" and main.checkBoxFlag='1' ";
        }
        StringBuilder sql=new StringBuilder();
        sql.append(" select rownum,");
        sql.append(" main.serialno,");
        sql.append(" main.policyno,");
        sql.append(" main.bizno,");
        sql.append(" main.losslistcode,");
        sql.append(" main.listaffirmtime,");
        sql.append(" main.deathquantity,");
        sql.append(" main.killquantity,");
        sql.append(" main.checkcontext,");
        sql.append(" list.lossamount,");
        sql.append(" item.fcode,");
        sql.append(" item.fname,");
        sql.append(" list.itemCode,");
        sql.append(" item.fidcard,");
        sql.append(" herd.earlabel,");
        sql.append(" list.lossmoney,");
        sql.append(" main.remark,");
        sql.append(" main.origin,");
        sql.append(" main.nodeorigin");
        sql.append(" from LossRateHerdList herd");
        sql.append(" left join LossRateLossList list");
        sql.append(" on herd.losslistcode=list.losslistcode");
        sql.append(" and herd.serialno=list.serialno");
        sql.append(" and herd.fcode=list.fcode");
        sql.append(" and herd.itemcode=list.itemcode");
        sql.append(" and herd.lossserialno=list.lossserialno");
        sql.append(" left join LossRateItemList item");
        sql.append(" on list.losslistcode=item.losslistcode");
        sql.append(" and list.serialno=item.serialno");
        sql.append(" and list.fcode=item.fcode");
        sql.append(" and list.itemcode=item.itemcode");
        sql.append(" left join (select *");
        sql.append(" from lossratemainlist t1 where ");
        sql.append(conditions1);
        sql.append(" and t1.serialno in ");
        sql.append(" (select max(t.serialno) as serialno");
        sql.append(" from lossratemainlist t where ");
        sql.append(conditions2);
        sql.append(" group by t.origin )) main");
        sql.append(" on item.losslistcode=main.losslistcode");
        sql.append(" and item.serialno=main.serialno WHERE ");
        sql.append(conditions3);
        sql.append(conditions4);
        Query nativeQuery = entityManager.createNativeQuery(sql.toString(),BreedLossRateListInfo.class);
        for (Map.Entry<String, String> entry : condition.entrySet()) {
            nativeQuery.setParameter(entry.getKey(),entry.getValue());
        }
        List<BreedLossRateListInfo> resultList = nativeQuery.getResultList();
        List<ResponseBreedLossRateListDto> responseBreedLossRateList=new ArrayList<>();
        convertCollection(resultList,responseBreedLossRateList,ResponseBreedLossRateListDto.class);
        return responseBreedLossRateList;
    }
    /**
     * 查询种植险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 14:40
     * @param  registNo 报案号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @Override
    public List<ResponsePlantingLossRateListDto> plantingdownloadlList(String registNo,String lossListCode,String policyNo) throws Exception {
        String conditions1="";
        String conditions2="";
        String conditions3="";
        String conditions4="";
        if(StringUtils.isEmpty(registNo)&&StringUtils.isEmpty(lossListCode)){
            throw new BusinessException("报案号和清单号不能同时为空!");
        }
        Map<String,String> condition= new HashMap<>();
        if(StringUtils.isNotEmpty(registNo)){
            conditions1=" t1.bizno =:registNo";
            conditions2=" t.bizno =:registNo";
            conditions3=" main.bizno=:registNo";
            condition.put("registNo",registNo);
        }
        if(StringUtils.isNotEmpty(lossListCode)){
            conditions1=" t1.losslistcode=:lossListCode";
            conditions2=" t.losslistcode=:lossListCode";
            conditions3=" main.losslistcode=:lossListCode";
            condition.put("lossListCode",lossListCode);
        }
        if(StringUtils.isNotEmpty(registNo)&&StringUtils.isNotEmpty(lossListCode)){
            conditions1="t1.bizno =:registNo and t1.losslistcode=:lossListCode";
            conditions2=" t.bizno =:registNo and t.losslistcode=:lossListCode";
            conditions3=" main.bizno=:registNo and main.losslistcode=:lossListCode";
        }
        if(lossListCode==null){
            conditions4=" and main.checkBoxFlag='1' ";
        }

        String riskCode = policyNo.substring(1, 5);
        StringBuilder sql=new StringBuilder();
        sql.append(" select rownum,");
        sql.append(" main.serialno,");
        sql.append(" main.policyno,");
        sql.append(" main.bizno,");
        sql.append(" main.lossListCode,");
        sql.append(" main.listaffirmtime,");
        sql.append(" main.disasterarea,");
        sql.append(" main.affectedarea,");
        sql.append(" main.noproductionarea,");
        sql.append(" main.checkcontext,");
        sql.append(" item.fcode,");
        sql.append(" item.fname,");
        sql.append(" item.itemcode,");
        sql.append(" item.fidCard,");
        sql.append(" list.lossrate,");
        sql.append(" list.lossamount,");
        sql.append(" list.lossmoney,");
        sql.append(" list.versionno,");
        sql.append(" main.remark,");
        sql.append(" main.origin,");
        sql.append(" main.nodeOrigin");
        if("3129".equals(riskCode)){
            sql.append(", pers.name");
        }
        sql.append(" from LossRateLossList list");
        if("3129".equals(riskCode)){
            sql.append(" left join lossrateperslist pers");
            sql.append(" on list.losslistcode=pers.losslistcode");
            sql.append(" and list.serialno=pers.serialno");
            sql.append(" and list.fcode=pers.fcode");
            sql.append(" and list.itemcode=pers.itemcode");
            sql.append(" and list.lossserialno=pers.lossserialno");
            sql.append(" left join LossRateItemList item");
            sql.append(" on pers.losslistcode = item.losslistcode");
            sql.append(" and pers.serialno = item.serialno");
            sql.append(" and pers.fcode = item.fcode");
            sql.append(" and pers.itemcode = item.itemcode");
        }else{
            sql.append(" left join LossRateItemList item");
            sql.append(" on list.losslistcode = item.losslistcode");
            sql.append(" and list.serialno = item.serialno");
            sql.append(" and list.fcode = item.fcode");
            sql.append(" and list.itemcode = item.itemcode");
        }
        sql.append(" left join (select *");
        sql.append("  from lossratemainlist t1 where ");
        sql.append(conditions1);
        sql.append(" and t1.serialno in ");
        sql.append(" (select max(t.serialno) as serialno");
        sql.append(" from lossratemainlist t where ");
        sql.append(conditions2);
        sql.append(" group by t.origin )) main");
        sql.append(" on item.losslistcode = main.losslistcode");
        sql.append(" and item.serialno = main.serialno where ");
        sql.append(conditions3);
        sql.append(conditions4);

        List<ResponsePlantingLossRateListDto> responsePlantingLossRateList=new ArrayList<>();
        if("3129".equals(riskCode)){
            //草莓组合保险
            Query nativeQuery = entityManager.createNativeQuery(sql.toString(), PlantingLossRateListInfos.class);
            for (Map.Entry<String, String> entry : condition.entrySet()) {
                nativeQuery.setParameter(entry.getKey(),entry.getValue());
            }
            List<PlantingLossRateListInfos> resultList = nativeQuery.getResultList();
            convertCollection(resultList,responsePlantingLossRateList,ResponsePlantingLossRateListDto.class);
        }else{
            Query nativeQuery = entityManager.createNativeQuery(sql.toString(), PlantingLossRateListInfo.class);
            for (Map.Entry<String, String> entry : condition.entrySet()) {
                nativeQuery.setParameter(entry.getKey(),entry.getValue());
            }
            List<PlantingLossRateListInfo> resultList = nativeQuery.getResultList();
            convertCollection(resultList,responsePlantingLossRateList,ResponsePlantingLossRateListDto.class);
        }
        //查询承保面积
        //通过policyNo查询清单号
        Map<String, Double> map = new HashMap<>();
        String inusreListCodeByPolicyNo = insureMainListDao.findInusreListCodeByPolicyNo(policyNo);
        if ("3107".equals(riskCode) || "3108".equals(riskCode) || "3155".equals(riskCode) || "3162".equals(riskCode) || "3101".equals(riskCode) || "3114".equals(riskCode)
                || "3122".equals(riskCode) || "3126".equals(riskCode) || "3161".equals(riskCode)) {
            List<PlantingPolicyList> plantingPolicyLists = plantingPolicyListDao.findInsureAreaByInusreListCodeAndfcode2(inusreListCodeByPolicyNo);
            for (PlantingPolicyList plantingPolicyList1 : plantingPolicyLists) {
                map.put(plantingPolicyList1.getfCode() + plantingPolicyList1.getItemCode(), plantingPolicyList1.getInsureArea());
            }
        } else if ("3141".equals(riskCode) || "3147".equals(riskCode)) {
            List<Planting31PolicyList> planting31PolicyList = planting31PolicyListDao.findPlanting31PolicyListByConditions1(inusreListCodeByPolicyNo);
            for (Planting31PolicyList planting31PolicyList1 : planting31PolicyList) {
                map.put(planting31PolicyList1.getfCode() + planting31PolicyList1.getItemCode(), planting31PolicyList1.getInsureArea());
            }
        } else {
            List<NyxPolicyList> nyxPolicyList = nyxPolicyListDao.findNyxPolicyListByLossListCodeAndItemCode1(inusreListCodeByPolicyNo);
            for (NyxPolicyList nyxPolicyList1 : nyxPolicyList) {
                map.put(nyxPolicyList1.getfCode() + nyxPolicyList1.getItemCode(), nyxPolicyList1.getInsureArea());
            }
        }
        //查询承保面积
        for (ResponsePlantingLossRateListDto responsePlantingLossRateListDto : responsePlantingLossRateList) {
            //通过policyNo查询清单号
            //单险别单标的
            if("3107".equals(riskCode)||"3108".equals(riskCode)||"3155".equals(riskCode)||"3162".equals(riskCode)||"3101".equals(riskCode)||"3114".equals(riskCode)
                    ||"3122".equals(riskCode)||"3126".equals(riskCode)||"3161".equals(riskCode)){
//                PlantingPolicyList plantingPolicyList = plantingPolicyListDao.findInsureAreaByInusreListCodeAndfcode1(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getFcode(),responsePlantingLossRateListDto.getItemCode());
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
               }
                //responsePlantingLossRateListDto.setfAreaCode(plantingPolicyList.getfAreaCode());
                //responsePlantingLossRateListDto.setKindCode(plantingPolicyList.getKindCode());
            }else if("3141".equals(riskCode)||"3147".equals(riskCode)){
//                List<Planting31PolicyList> planting31PolicyList = planting31PolicyListDao.findPlanting31PolicyListByConditions(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getFcode(), responsePlantingLossRateListDto.getItemCode());
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
                }
            }else{

                //如果是多险别多标的 查询nyxpolicylist
//                List<NyxPolicyList> nyxPolicyList= nyxPolicyListDao.findNyxPolicyListByLossListCodeAndItemCode(inusreListCodeByPolicyNo, responsePlantingLossRateListDto.getItemCode(),responsePlantingLossRateListDto.getFcode());
//                if(nyxPolicyList!=null&&nyxPolicyList.size()>0){
//                    responsePlantingLossRateListDto.setInsureArea(nyxPolicyList.get(0).getInsureArea());
//                    //responsePlantingLossRateListDto.setfAreaCode(nyxPolicyList.getfAreaCode());
//                    //responsePlantingLossRateListDto.setKindCode(policyList.getKindCode());
//                }
                if (map.containsKey(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode())) {
                    responsePlantingLossRateListDto.setInsureArea(map.get(responsePlantingLossRateListDto.getFcode() + responsePlantingLossRateListDto.getItemCode()));
                }
            }


        }
        return responsePlantingLossRateList;
    }

    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLossRateAllList(LossRateWholeListDto requestGYLossRateAllListDto) throws Exception {
        /** 手工导入设置导入来源标识 */
        System.out.println("-----------------------------------");
        long n1 = System.currentTimeMillis();
        requestGYLossRateAllListDto.getLossRateMainListDto().setOrigin("1");
        requestGYLossRateAllListDto.getLossRateMainListDto().setCheckBoxFlag("0");
        lossRateMainListService.save(requestGYLossRateAllListDto.getLossRateMainListDto());
        if(requestGYLossRateAllListDto.getLossRateItemListDtoList()!=null){
//            List<LossRateItemList> lossRateItemList=new ArrayList<>();
//            this.convertCollection(requestGYLossRateAllListDto.getLossRateItemListDtoList(),lossRateItemList,LossRateItemList.class);
//            lossRateItemListDao.save(lossRateItemList);
            List<LossRateItemList> lossRateItemList=new ArrayList<>();
            this.convertCollection(requestGYLossRateAllListDto.getLossRateItemListDtoList(),lossRateItemList,LossRateItemList.class);
            //去重
            LossRateItemList losstemp1, losstemp2;
            for (int i = 0; i < lossRateItemList.size() - 1; i++) {
                losstemp1 = lossRateItemList.get(i);
                for (int j = lossRateItemList.size() - 1; j > i; j--) {
                    losstemp2 = lossRateItemList.get(j);
                    if (losstemp1.getLossListCode().equals(losstemp2.getLossListCode()) && losstemp1.getSerialNo().equals(losstemp2.getSerialNo()) && losstemp1.getfCode().equals(losstemp2.getfCode()) && losstemp1.getItemCode().equals(losstemp2.getItemCode())) {
                        lossRateItemList.remove(j);
                    }
                }
            }
            for (LossRateItemList lossRateItem : lossRateItemList) {
                entityManager.persist(lossRateItem);
            }
            entityManager.flush();
            entityManager.clear();

            entityManager.flush();
            entityManager.clear();
        }
        //数据量比较大
        if(requestGYLossRateAllListDto.getLossRateLossListDtoList()!=null){
//            List<LossRateLossList> lossRateLossList=new ArrayList<>();
//            this.convertCollection(requestGYLossRateAllListDto.getLossRateLossListDtoList(),lossRateLossList,LossRateLossList.class);
//            lossRateLossListDao.save(lossRateLossList);
            for (int i = 0; i < requestGYLossRateAllListDto.getLossRateLossListDtoList().size(); i++) {
                LossRateLossList lossRateLossList = convert(requestGYLossRateAllListDto.getLossRateLossListDtoList().get(i), LossRateLossList.class);
                entityManager.persist(lossRateLossList);
                ////                if(i%100==0) {
//                    entityManager.flush();
//                    entityManager.clear();
//                }
            }
            entityManager.flush();
            entityManager.clear();
        }
        if(requestGYLossRateAllListDto.getLossRateHerdListDtoList()!=null){
//            List<LossRateHerdList> lossRateHerdList=new ArrayList<>();
//            this.convertCollection(requestGYLossRateAllListDto.getLossRateHerdListDtoList(),lossRateHerdList,LossRateHerdList.class);
//            lossRateHerdListDao.save(lossRateHerdList);
            for (int i = 0; i < requestGYLossRateAllListDto.getLossRateHerdListDtoList().size(); i++) {
                LossRateHerdList lossRateHerdList = convert(requestGYLossRateAllListDto.getLossRateHerdListDtoList().get(i), LossRateHerdList.class);
                entityManager.persist(lossRateHerdList);
            }
            entityManager.flush();
            entityManager.clear();
        }
        if(requestGYLossRateAllListDto.getLossRatePersListDtoList()!=null){
//            List<LossRatePersList> lossRatePersList=new ArrayList<>();
//            this.convertCollection(requestGYLossRateAllListDto.getLossRatePersListDtoList(),lossRatePersList,LossRatePersList.class);
//            lossRatePersListDao.save(lossRatePersList);
            for (int i = 0; i < requestGYLossRateAllListDto.getLossRatePersListDtoList().size(); i++) {
                LossRatePersList lossRatePersList = convert(requestGYLossRateAllListDto.getLossRatePersListDtoList().get(i), LossRatePersList.class);
                entityManager.persist(lossRatePersList);
            }
            entityManager.flush();
            entityManager.clear();
        }
        LOGGER.warn("监测2-1、lossRateMainListService.save：" + ((System.currentTimeMillis() - n1)));
    }
    /**
     * 通过报案号和清单号查询是否关联
     * @author: 孙朋飞
     * @date: 2018/3/31 16:09
     * @param registNo 报案号
     * @param lossListCode 清单号
     * @return 是否关联
     * @throws Exception
     */
    @Override
    public boolean queryLossRateMainListByRegistNoAndLossListCode(String registNo, String lossListCode) {
        StringBuilder conditions=new StringBuilder();
        Map<String,String> condition= new HashMap<>();
        if(StringUtils.isNotEmpty(registNo)){
            conditions.append(" and p.bizNo=:registNo");
            condition.put("registNo",registNo);
        }
        if(StringUtils.isNotEmpty(lossListCode)){
            conditions.append(" and p.lossListCode=:lossListCode");
            condition.put("lossListCode",lossListCode);
        }
        StringBuilder sql=new StringBuilder("select p from LossRateMainList p where p.checkBoxFlag='1' ");
        sql.append(conditions);
        Query query = entityManager.createQuery(sql.toString());
        for (Map.Entry<String, String> entry : condition.entrySet()) {
            query.setParameter(entry.getKey(),entry.getValue());
        }
        List<LossRateMainList> resultList = query.getResultList();
        if(resultList.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public void queryByPolicyNo(String policyNo ,String nodeOrigin,String registNo) throws Exception {
        List<LossRateMainList> lossRateMainListList = lossRateMainListDao.queryBypolicyNo(policyNo,nodeOrigin,registNo);
        int serialNo=0;
        List<String> list  = new ArrayList<>();
        for(int i=0;i<lossRateMainListList.size();i++){
            list.add(lossRateMainListList.get(i).getLossListCode());
            serialNo=lossRateMainListList.get(i).getSerialNo();
        }
        if(list.size()>0){
            lossRateItemListDao.deleteByLossListCodeList(list,serialNo);
            lossRateLossListDao.deleteByLossListCodeList(list,serialNo);
            lossRateHerdListDao.deleteByLossListCodeList(list,serialNo);
            lossRatePersListDao.deleteByLossListCodeList(list,serialNo);
            lossRateMainListDao.deleteByLossListCodeList(list,nodeOrigin);
        }

    }

    @Override
    public List<LossRateMainListDto> queryByregistNo(String registNo) throws Exception {
        List<LossRateMainList> lossRateMainLists = lossRateMainListDao.queryByregistNo(registNo);
       List<LossRateMainListDto>  lossRateMainListDtos = new ArrayList<>();
        convertCollection(lossRateMainLists,lossRateMainListDtos,LossRateMainListDto.class);
        return lossRateMainListDtos;
    }

    /**
     * 通过保单号和报案号查询查勘编号（checkId）
     * @param （policyNo保单号 bizNo报案号）
     * @return 查勘编号（checkId）
     * @throws Exception
     * @author: 李文刚
     * @date: 2018/4/16 16:09
     */
    public List<LossRateMainListDto> findCheckId(LossRateMainListDto lossRateMainListDto) throws Exception{
        String policyNo=lossRateMainListDto.getPolicyNo();
        String bizNo=lossRateMainListDto.getBizNo();
        if(StringUtils.isEmpty(policyNo)){
            throw new BusinessException("保单号不能为空!");
        }
        if(StringUtils.isEmpty(bizNo)){
            throw new BusinessException("报案号不能为空!");
        }
        StringBuilder sql =new StringBuilder();
        sql.append(" select m.* from LossRateMainList m where m.policyNo=:policyNo " +
                "and m.bizNo=:bizNo and m.serialNo=(select max(m.serialNo)from LossRateMainList m " +
                "where m.policyNo=:policyNo and m.bizNo=:bizNo )" );
        Map<String, String> condition = new HashMap<>();
        condition.put("policyNo", policyNo);
        condition.put("bizNo", bizNo);

        Query query = entityManager.createNativeQuery(sql.toString(),LossRateMainList.class);

        for (Map.Entry<String, String> entry : condition.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List<LossRateMainList> resultList = query.getResultList();
        List<LossRateMainListDto> lossRateMainListDtoList = new ArrayList<>();
        //数据库对象集合转为dto对象集
        convertCollection(resultList, lossRateMainListDtoList, LossRateMainListDto.class);
        return lossRateMainListDtoList;
    }
    /**
     * 根据清单号和保单号回写报案号
     * @author: 孙朋飞
     * @date: 2018/4/23 9:26
     * @param lossListCode 清单号
     * @param policyNo 保单号
     * @param registNo 报案号
     * @throws Exception
     */
    @Override
    public void updateLossRateMainListByLossListCode(String lossListCode, String policyNo, String registNo) throws Exception {
        if(StringUtils.isEmpty(lossListCode)){
            throw new BusinessException("清单号不能为空!");
        }
        if(StringUtils.isEmpty(policyNo)){
            throw new BusinessException("保单号不能为空!");
        }
        if(StringUtils.isEmpty(registNo)){
            throw  new BusinessException("报案号不能为空!");
        }
        lossRateMainListDao.updateLossRateMainListByLossListCode(lossListCode,policyNo,registNo);
    }


}