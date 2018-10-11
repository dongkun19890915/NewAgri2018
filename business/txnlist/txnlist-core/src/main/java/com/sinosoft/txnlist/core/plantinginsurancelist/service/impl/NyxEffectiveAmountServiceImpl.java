package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.HerdInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.NyxEffectiveAmountDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEffectiveAmountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
public class NyxEffectiveAmountServiceImpl extends BaseServiceImpl implements NyxEffectiveAmountService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(NyxEffectiveAmountServiceImpl.class);

    @Autowired
    private NyxEffectiveAmountDao nyxEffectiveAmountDao;
    @PersistenceContext
    private EntityManager entityManager;
    //   @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRiskcode;
    //   @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Riskcode;
    //   @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRiskcode;
    //  @Value("${sysconfig.insureListRsk.herd}")
    private String herdRiskcode;
    @Autowired
    private HerdInsuranceListApi herdInsuranceListApi;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;

    public void inint() {
        this.plantingRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING", 1).getRule();
        this.planting31Riskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "PLANTING31", 1).getRule();
        ;
        this.nyxRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "NYX", 1).getRule();
        ;
        this.herdRiskcode = utiPlatConfigRuleApi.queryByPK("newagriprpall", "HERD", 1).getRule();
        ;
    }
    /**
     * 根据主键及日期查询有效保额表
     * @author: 刘曼曼
     * @date: 15:44 15:44
     * @param nyxEffectiveAmountDto
     * @return NyxEffectiveAmountDto有效保额数据
     */
    @Override
    public NyxEffectiveAmountDto queryAll(NyxEffectiveAmountDto nyxEffectiveAmountDto) throws Exception{
        if(nyxEffectiveAmountDto==null){
           throw  new DataVerifyException("参数不可为空！");
        }
        if(StringUtils.isEmpty(nyxEffectiveAmountDto.getPolicyNo())){
            throw  new DataVerifyException("保单号不可为空！");
        }
        if(StringUtils.isEmpty(nyxEffectiveAmountDto.getRiskCode())){
            throw  new DataVerifyException("险种代码不可为空！");
        }
        if(StringUtils.isEmpty(nyxEffectiveAmountDto.getKindCode())){
            throw  new DataVerifyException("险别代码不可为空！");
        }
        if(StringUtils.isEmpty(nyxEffectiveAmountDto.getItemCode())){
            throw  new DataVerifyException("标的代码不可为空！");
        }
        if(StringUtils.isEmpty(nyxEffectiveAmountDto.getfCode())){
            throw  new DataVerifyException("农户代码不可为空！");
        }
        if(nyxEffectiveAmountDto.getFlag()==null){
            throw  new DataVerifyException("其他不可为空！");
        }
        NyxEffectiveAmount nyxEffectiveAmount=nyxEffectiveAmountDao.findByNew(nyxEffectiveAmountDto.getPolicyNo(),nyxEffectiveAmountDto.getRiskCode(),nyxEffectiveAmountDto.getKindCode(),nyxEffectiveAmountDto.getItemCode(),nyxEffectiveAmountDto.getfCode(),nyxEffectiveAmountDto.getFlag(),nyxEffectiveAmountDto.getStartDate());
        NyxEffectiveAmountDto nyxEffectiveAmountDto1=convert(nyxEffectiveAmount,NyxEffectiveAmountDto.class);
        return nyxEffectiveAmountDto1;
    }

    /**
     * 根据需要插入或修改数据
     * @author: 刘曼曼
     * @date: 15:39 15:39
     * @param requestNyxEffectiveAmountDto
     * @return Map
     */
    @Transactional
    @Override
    public Map<String,String> modifyNyxEffectiveAmount(RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto) throws Exception{
        if(requestNyxEffectiveAmountDto.getNyxEffectiveAmountDtoList()==null){
            throw  new DataVerifyException("NyxEffectiveAmountDto不可为空！");
        }
        if(StringUtils.isEmpty(requestNyxEffectiveAmountDto.getJudgeFlag())){
            throw  new DataVerifyException("标识不可为空！");
        }
        //取出参数
        List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList=requestNyxEffectiveAmountDto.getNyxEffectiveAmountDtoList();

        //定义参数
        List<String> policyNos=new ArrayList<>();
        List<String> riskCodes=new ArrayList<>();
        List<String> kindCodes=new ArrayList<>();
        List<String> itemCodes=new ArrayList<>();
        List<String> fCodes=new ArrayList<>();
        List<Integer> flags=new ArrayList<>();
        Map<String,String> map =new HashMap<>();
        try {
            //判断是批增批减 或是理赔，1-批增，2-批减，3-理赔
            if (!"3".equals(requestNyxEffectiveAmountDto.getJudgeFlag())) {
                for (NyxEffectiveAmountDto nyxEffectiveAmountDto : nyxEffectiveAmountDtoList) {
                    policyNos.add(nyxEffectiveAmountDto.getPolicyNo());
                    riskCodes.add(nyxEffectiveAmountDto.getRiskCode());
                    kindCodes.add(nyxEffectiveAmountDto.getKindCode());
                    itemCodes.add(nyxEffectiveAmountDto.getItemCode());
                    fCodes.add(nyxEffectiveAmountDto.getfCode());
                    flags.add(nyxEffectiveAmountDto.getFlag());
                }
                //先查询最新数据
                List<NyxEffectiveAmount> nyxEffectiveAmountList = nyxEffectiveAmountDao.findNyxEffectiveAmountList(policyNos, riskCodes, kindCodes, itemCodes, fCodes, flags);
                if ("1".equals(requestNyxEffectiveAmountDto.getJudgeFlag())) {
                    //批增
                    for (NyxEffectiveAmountDto nyxEffectiveAmountDto : nyxEffectiveAmountDtoList) {
                        for (NyxEffectiveAmount nyxEffectiveAmount : nyxEffectiveAmountList) {
                            if (nyxEffectiveAmountDto.getPolicyNo().equals(nyxEffectiveAmount.getPolicyNo())
                                    && nyxEffectiveAmountDto.getRiskCode().equals(nyxEffectiveAmount.getRiskCode())
                                    && nyxEffectiveAmountDto.getKindCode().equals(nyxEffectiveAmount.getKindCode())
                                    && nyxEffectiveAmountDto.getItemCode().equals(nyxEffectiveAmount.getItemCode())
                                    && nyxEffectiveAmountDto.getfCode().equals(nyxEffectiveAmount.getfCode())
                                    && nyxEffectiveAmountDto.getFlag() == nyxEffectiveAmount.getFlag()) {

                                nyxEffectiveAmountDto.setAmount(nyxEffectiveAmount.getAmount() + nyxEffectiveAmountDto.getChgAmount());
                                nyxEffectiveAmountDto.setSerialNo(nyxEffectiveAmount.getSerialNo() + 1);
                            }
                        }
                    }
                    List<NyxEffectiveAmount> nyxEffectiveAmountList1 = new ArrayList<NyxEffectiveAmount>();
                    convertCollection(nyxEffectiveAmountDtoList, nyxEffectiveAmountList1, NyxEffectiveAmount.class);
                    if (nyxEffectiveAmountList1.size()>0) {
                        nyxEffectiveAmountDao.save(nyxEffectiveAmountList1);
                        map.put("messege","保存成功！");
                    }
                } else if ("2".equals(requestNyxEffectiveAmountDto.getJudgeFlag())) {
                    //批减
                    for (NyxEffectiveAmountDto nyxEffectiveAmountDto : nyxEffectiveAmountDtoList) {
                        for (NyxEffectiveAmount nyxEffectiveAmount : nyxEffectiveAmountList) {
                            if (nyxEffectiveAmountDto.getPolicyNo().equals(nyxEffectiveAmount.getPolicyNo())
                                    && nyxEffectiveAmountDto.getRiskCode().equals(nyxEffectiveAmount.getRiskCode())
                                    && nyxEffectiveAmountDto.getKindCode().equals(nyxEffectiveAmount.getKindCode())
                                    && nyxEffectiveAmountDto.getItemCode().equals(nyxEffectiveAmount.getItemCode())
                                    && nyxEffectiveAmountDto.getfCode().equals(nyxEffectiveAmount.getfCode())
                                    && nyxEffectiveAmountDto.getFlag() == nyxEffectiveAmount.getFlag()) {
                                nyxEffectiveAmountDto.setAmount(nyxEffectiveAmount.getAmount() - nyxEffectiveAmountDto.getChgAmount());
                                nyxEffectiveAmountDto.setSerialNo(nyxEffectiveAmount.getSerialNo() + 1);
                            }
                        }
                    }
                    List<NyxEffectiveAmount> nyxEffectiveAmountList1 = new ArrayList<NyxEffectiveAmount>();
                    convertCollection(nyxEffectiveAmountDtoList, nyxEffectiveAmountList1, NyxEffectiveAmount.class);
                    if (nyxEffectiveAmountList1.size()>0) {
                        nyxEffectiveAmountDao.save(nyxEffectiveAmountList1);
                        map.put("messege","保存成功！");
                    }
                }
            } else {
                //理赔
                List<NyxEffectiveAmount> nyxEffectiveAmountList = nyxEffectiveAmountDao.findNyxEffectiveAmount(nyxEffectiveAmountDtoList.get(0).getPolicyNo(), nyxEffectiveAmountDtoList.get(0).getRiskCode(), nyxEffectiveAmountDtoList.get(0).getKindCode(), nyxEffectiveAmountDtoList.get(0).getItemCode(), nyxEffectiveAmountDtoList.get(0).getfCode(), nyxEffectiveAmountDtoList.get(0).getFlag());
                if (nyxEffectiveAmountList != null && nyxEffectiveAmountList.size() > 0) {
                    for (NyxEffectiveAmount nyxEffectiveAmount : nyxEffectiveAmountList) {
                        nyxEffectiveAmount.setAmount(nyxEffectiveAmount.getAmount() - nyxEffectiveAmountDtoList.get(0).getChgAmount());
                    }
                    if (nyxEffectiveAmountList != null && nyxEffectiveAmountList.size() > 0) {
                        nyxEffectiveAmountDao.save(nyxEffectiveAmountList);
                        map.put("messege", "修改成功！");
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            map.put("messege","保存失败！");
        }

        return map;
    }

    /**
     * 保存NyxEffectiveAmount表
     * @author: 刘曼曼
     * @date: 17:42 17:42
     * @param nyxEffectiveAmountDtoList
     * @return Map<String,String>
     * @throws Exception
     */
    @Transactional
    @Override
    public Map<String,String> saveNyxEffectiveAmount(List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList) throws Exception{

        if(nyxEffectiveAmountDtoList.size()==0){
            throw  new DataVerifyException("NyxEffectiveAmountDto参数不可为空！");
        }

        List<NyxEffectiveAmount> nyxEffectiveAmountList = new ArrayList<NyxEffectiveAmount>();
        convertCollection(nyxEffectiveAmountDtoList,nyxEffectiveAmountList,NyxEffectiveAmount.class);
        Map<String,String> map =new HashMap<>();
        try {
            if (nyxEffectiveAmountList.size()>0) {
                nyxEffectiveAmountDao.save(nyxEffectiveAmountList);
                map.put("messege","保存成功！");
            }
        }catch (Exception e) {
            e.printStackTrace();
            map.put("messege","保存失败！");
        }
        return map;
    }

    /*
     *根据保单号查询最大的数据
     * @author: 钱浩
     * @date: 2018/4/12 下午 14:22
     *
     */
    public Map<String, Double> queryNyxEffectiveAmount(Boolean flse, String riskCode, String inusreListCode, String policyNo) throws Exception {
        inint();
        String strWhere1 = "select p.*, n.amount  as effamount, n.serialno " +
                " from ";
        String strWhere2 = "";
        Boolean fse = true;
        if (plantingRiskcode.contains(riskCode)) {
            strWhere2 = "plantingInsuranceList ";
        } else if (herdRiskcode.contains(riskCode)) {
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("inusreListCode", inusreListCode);
            List<HerdInsuranceListDto> herdInsuranceListDtoList;
            long count = herdInsuranceListApi.countByInusreListCode(stringStringMap);
            if (count == 0) {//如果herdInsuranceListDtoList还有可能是耳标号没传，存临时表
                fse = false;
                strWhere2 = "middleHerdInsuranceList ";
            } else {
                strWhere2 = "herdInsuranceList ";

            }
        } else if (nyxRiskcode.contains(riskCode)) {
            strWhere2 = "nyxInsuranceList ";
        } else if (planting31Riskcode.contains(riskCode)) {
            strWhere2 = "planting31InsuranceList ";
        }
        String strWhere = strWhere1 + strWhere2 +
                "p, nyxEffectiveAmount n , InsureMainList i " +
                " where p.fcode = n.fcode " +
                " and p.kindcode = n.kindcode " +
                " and p.itemcode = n.itemcode " +
                " and p.inusreListCode = i.inusreListCode " +
                " and i.policyNo = n.policyNo " +
                " and n.policyNo ='" + policyNo + "'" +
                " and n.serialno = (select max(c.serialno) " +
                " from nyxeffectiveamount c " +
                " where c.policyNo='" + policyNo +
                "')";
        Query query = null;
        if (plantingRiskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, PlantingInsuranceListAmount.class);
        } else if (herdRiskcode.contains(riskCode)) {
            if (fse) {//如果herdInsuranceListDtoList还有可能是耳标号没传，存临时表
                query = entityManager.createNativeQuery(strWhere, HerdInsuranceListAmount.class);
            } else {
                query = entityManager.createNativeQuery(strWhere, MiddleHerdInsuranceListAmount.class);
            }
        } else if (nyxRiskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, NyxInsuranceListAmount.class);
        } else if (planting31Riskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, Planting31InsuranceListAmount.class);
        }
        List<PlantingInsuranceListAmount> plantingInsuranceListAmounts = null;
        List<NyxInsuranceListAmount> nyxInsuranceListAmounts = null;
        List<HerdInsuranceListAmount> herdInsuranceListAmounts = null;
        List<MiddleHerdInsuranceListAmount> middleHerdInsuranceListAmounts = null;
        List<Planting31InsuranceListAmount> planting31InsuranceListAmounts = null;
        if (plantingRiskcode.contains(riskCode)) {
            plantingInsuranceListAmounts = query.getResultList();
        } else if (herdRiskcode.contains(riskCode)) {
            if (fse) {
                herdInsuranceListAmounts = query.getResultList();
            } else {
                middleHerdInsuranceListAmounts = query.getResultList();
            }
        } else if (nyxRiskcode.contains(riskCode)) {
            nyxInsuranceListAmounts = query.getResultList();
        } else if (planting31Riskcode.contains(riskCode)) {
            planting31InsuranceListAmounts = query.getResultList();
        }
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        if (plantingInsuranceListAmounts != null) {
            for (PlantingInsuranceListAmount plant : plantingInsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (herdInsuranceListAmounts != null) {
            for (HerdInsuranceListAmount plant : herdInsuranceListAmounts) {
                hashMap.put(riskCode + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (middleHerdInsuranceListAmounts != null) {
            for (MiddleHerdInsuranceListAmount plant : middleHerdInsuranceListAmounts) {
                hashMap.put(riskCode + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (planting31InsuranceListAmounts != null) {
            for (Planting31InsuranceListAmount plant : planting31InsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (nyxInsuranceListAmounts != null) {
            for (NyxInsuranceListAmount plant : nyxInsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        return hashMap;
    }
    /**
     *  根据businessNo查询有效保额信息`
     * @author: 田健
     * @date: 2018/5/16 18:44
     * @param riskCode 险种代码
     * @param inusreListCode 清单编号
     * @param businessNo 业务号
     * @return 有效保额map集合
     * @throws Exception
     */
    public Map<String, Double> queryNyxEffectiveAmountByBusinessNo(String riskCode, String inusreListCode, String businessNo) throws Exception {
        inint();
        String strWhere1 = "select p.*, n.amount  as effamount, n.serialno " +
                " from ";
        String strWhere2 = "";
        Boolean fse = true;
        if (plantingRiskcode.contains(riskCode)) {
            strWhere2 = "plantingInsuranceList ";
        } else if (herdRiskcode.contains(riskCode)) {
            Map<String, String> stringStringMap = new HashMap<>();
            stringStringMap.put("inusreListCode", inusreListCode);
            List<HerdInsuranceListDto> herdInsuranceListDtoList;
            long count = herdInsuranceListApi.countByInusreListCode(stringStringMap);
            if (count == 0) {//如果herdInsuranceListDtoList还有可能是耳标号没传，存临时表
                fse = false;
                strWhere2 = "middleHerdInsuranceList ";
            } else {
                strWhere2 = "herdInsuranceList ";

            }
        } else if (nyxRiskcode.contains(riskCode)) {
            strWhere2 = "nyxInsuranceList ";
        } else if (planting31Riskcode.contains(riskCode)) {
            strWhere2 = "planting31InsuranceList ";
        }
        String strWhere = strWhere1 + strWhere2 +
                "p, nyxEffectiveAmount n , InsureMainList i" +
                " where p.fcode = n.fcode " +
                " and p.kindcode = n.kindcode " +
                " and p.itemcode = n.itemcode " +
                " and p.inusreListCode = i.inusreListCode " +
                " and i.policyNo = n.policyNo " +
                " and n.businessNo ='" + businessNo + "'" +
                " and n.serialno = (select max(c.serialno) " +
                " from nyxeffectiveamount c " +
                " where c.businessNo='" + businessNo +
                "')";
        Query query = null;
        if (plantingRiskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, PlantingInsuranceListAmount.class);
        } else if (herdRiskcode.contains(riskCode)) {
            if (fse) {//如果herdInsuranceListDtoList还有可能是耳标号没传，存临时表
                query = entityManager.createNativeQuery(strWhere, HerdInsuranceListAmount.class);
            } else {
                query = entityManager.createNativeQuery(strWhere, MiddleHerdInsuranceListAmount.class);
            }
        } else if (nyxRiskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, NyxInsuranceListAmount.class);
        } else if (planting31Riskcode.contains(riskCode)) {
            query = entityManager.createNativeQuery(strWhere, Planting31InsuranceListAmount.class);
        }
        List<PlantingInsuranceListAmount> plantingInsuranceListAmounts = null;
        List<NyxInsuranceListAmount> nyxInsuranceListAmounts = null;
        List<HerdInsuranceListAmount> herdInsuranceListAmounts = null;
        List<MiddleHerdInsuranceListAmount> middleHerdInsuranceListAmounts = null;
        List<Planting31InsuranceListAmount> planting31InsuranceListAmounts = null;
        if (plantingRiskcode.contains(riskCode)) {
            plantingInsuranceListAmounts = query.getResultList();
        } else if (herdRiskcode.contains(riskCode)) {
            if (fse) {
                herdInsuranceListAmounts = query.getResultList();
            } else {
                middleHerdInsuranceListAmounts = query.getResultList();
            }
        } else if (nyxRiskcode.contains(riskCode)) {
            nyxInsuranceListAmounts = query.getResultList();
        } else if (planting31Riskcode.contains(riskCode)) {
            planting31InsuranceListAmounts = query.getResultList();
        }
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        if (plantingInsuranceListAmounts != null) {
            for (PlantingInsuranceListAmount plant : plantingInsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (herdInsuranceListAmounts != null) {
            for (HerdInsuranceListAmount plant : herdInsuranceListAmounts) {
                hashMap.put(riskCode + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (middleHerdInsuranceListAmounts != null) {
            for (MiddleHerdInsuranceListAmount plant : middleHerdInsuranceListAmounts) {
                hashMap.put(riskCode + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (planting31InsuranceListAmounts != null) {
            for (Planting31InsuranceListAmount plant : planting31InsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        if (nyxInsuranceListAmounts != null) {
            for (NyxInsuranceListAmount plant : nyxInsuranceListAmounts) {
                hashMap.put(plant.getRiskCode() + plant.getKindCode() + plant.getItemCode() + plant.getfCode(), plant.getEffamount());
            }
        }
        return hashMap;
    }
    /**
     * 查询保单的有效保额
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     * @param  policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     */
    @Override
    public Map<String, Double> queryNyxEffectiveAmountByPolicyNo(String policyNo,Date startDate) throws Exception {
        Double nyxEffectiveAmountByPolicyNo = nyxEffectiveAmountDao.findNyxEffectiveAmountByPolicyNo(policyNo,startDate);
        if (nyxEffectiveAmountByPolicyNo == null) {
            nyxEffectiveAmountByPolicyNo = 0D;
        }
        Map<String,Double> map=new HashMap<>();
        map.put("amount",nyxEffectiveAmountByPolicyNo);
        return map;
    }

    /**
     * 查询保单的有效保额
     *
     * @param policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     */
    @Override
    public Map<String, Double> queryNyxEffectiveAmountByPolicyNo1(String policyNo, Date startDate) throws Exception {
        List<NyxEffectiveAmount> nyxEffectiveAmountList = nyxEffectiveAmountDao.findNyxEffectiveAmountByPolicyNo1(policyNo, startDate);
        Map<String, Double> map = new HashMap<>();
        for (NyxEffectiveAmount nyxEffectiveAmount : nyxEffectiveAmountList) {
            map.put(nyxEffectiveAmount.getfCode() + nyxEffectiveAmount.getItemCode() + nyxEffectiveAmount.getKindCode() + nyxEffectiveAmount.getFlag(), nyxEffectiveAmount.getAmount());
        }
        return map;
    }

}