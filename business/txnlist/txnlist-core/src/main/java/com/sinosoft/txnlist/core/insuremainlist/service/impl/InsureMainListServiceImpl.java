package com.sinosoft.txnlist.core.insuremainlist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainListKey;
import com.sinosoft.txnlist.core.insuremainlist.service.InsureMainListService;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-17 07:14:54.112
 * @description 清单主表Core接口实现
 */
@Service
public class InsureMainListServiceImpl extends BaseServiceImpl implements InsureMainListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InsureMainListServiceImpl.class);


    /**
     * 投保单号码前缀
     */
    private final String PROPOSAL_PREFIX = "1";
    /**
     * 保单号码前缀
     */
    private final String POLICY_PREFIX = "2";
    /**
     * 批单号码前缀
     */
    private final String ENDORSE_PREFIX = "3";
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 清单存储在planting的险种
     */
//    @Value("${sysconfig.insureListRsk.planting}")
    private String plantingRisk;
    /**
     * 清单存储在planting31的险种
     */
//    @Value("${sysconfig.insureListRsk.planting31}")
    private String planting31Risk;
    /**
     * 清单存储在nyx的险种
     */
//    @Value("${sysconfig.insureListRsk.nyx}")
    private String nyxRisk;
    /**
     * 清单存储在herd的险种
     */
//    @Value("${sysconfig.insureListRsk.herd}")
    private String herdRisk;

    @Autowired
    private InsureMainListDao insureMainListDao;
//    @Autowired
//    private PlantingPolicyListService plantingPolicyListService;
//    @Autowired
//    private Planting31PolicyListService planting31PolicyListService;
//    @Autowired
//    private HerdPolicyListService herdPolicyListService;
//    @Autowired
//    private NyxPolicyListService nyxPolicyListService;

    @Autowired
    private PlantingEndorHeadDao plantingEndorHeadDao;

    @Autowired
    private HerdEndorHeadDao herdEndorHeadDao;

    @Autowired
    private NyxEndorHeadDao nyxEndorHeadDao;

    @Autowired
    private PlantingPolicyListDao plantingPolicyListDao;

    @Autowired
    private Planting31PolicyListDao planting31PolicyListDao;

    @Autowired
    private HerdPolicyListDao herdPolicyListDao;

    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;

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
    /**
     * @param
     * @description 新增
     */
    public void save(InsureMainListDto insureMainListDto) throws Exception{
        InsureMainList insureMainList = this.convert(insureMainListDto, InsureMainList.class);
        insureMainListDao.save(insureMainList);
    }
    /**
     * @param
     * @description 新增
     */
    @Transactional(rollbackFor = Exception.class)
    public void persist(InsureMainListDto insureMainListDto) throws Exception{
        InsureMainList insureMainList = this.convert(insureMainListDto, InsureMainList.class);
        try{
            entityManager.persist(insureMainList);
            entityManager.flush();//刷新保存到数据库中
        }catch (Exception e){
            Throwable t = e.getCause();
            //捕获ConstraintViolationException这个异常，进行判断是否主键冲突
            if (t instanceof ConstraintViolationException) {
                throw new Exception("此业务清单号已经存在，请联系系统管理员！");
            }
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String inusreListCode) {
        InsureMainListKey insureMainListKey = new InsureMainListKey(inusreListCode);
        insureMainListDao.delete(insureMainListKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(InsureMainListDto insureMainListDto) {
        InsureMainList insureMainList = this.convert(insureMainListDto, InsureMainList.class);
        insureMainListDao.save(insureMainList);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public InsureMainListDto queryByPK(String inusreListCode) {
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号inusreListCode不能为空！");
        }
        InsureMainListKey insureMainListKey = new InsureMainListKey(inusreListCode);
        InsureMainList insureMainList = insureMainListDao.findOne(insureMainListKey);
        return this.convert(insureMainList, InsureMainListDto.class);
    }

    /**
     * @param proposalNo
     * @return
     * @description: 根据投保单号查询
     * @author: 何伟东
     * @date: 2017/10/26 9:22
     */
    @Override
    public List<InsureMainListDto> queryByProposalNo(String proposalNo) {
        List<InsureMainList> insureMainLists = insureMainListDao.findByProposalNo(proposalNo);
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        convertCollection(insureMainLists, insureMainListDtoList, InsureMainListDto.class);
        return insureMainListDtoList;
    }

    /**
     * @param policyNo
     * @return
     * @description: 根据保单号查询集合
     * @author: 王心洋
     * @date: 2017/10/26 9:22
     */
    @Override
    public List<InsureMainListDto> queryByPolicyNo(String policyNo) throws Exception {
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        convertCollection(insureMainLists, insureMainListDtoList, InsureMainListDto.class);
        return insureMainListDtoList;
    }

    /**
     * 根据清单编号回写投保单号和清单标志
     *
     * @param inusreListCode 清单编号
     * @param proposalNo     投保单号
     * @param validity       清单标志
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/15 17:40
     */
    @Override
    public void relatedInsuranceNo(String inusreListCode, String proposalNo, String validity) throws Exception {
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("请传入清单编号");
        }
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("请传入投保单号");
        }
        if (StringUtils.isEmpty(validity)) {
            throw new DataVerifyException("请传入清单标志");
        }

        int updateInsuredMainList = insureMainListDao.updateInsuredMainList(proposalNo, validity, inusreListCode);
        if (updateInsuredMainList <= 0) {
            throw new BusinessException("没有可以更新的数据");
        }
    }

    /**
     * @param policyNo
     * @return
     * @throws
     * @description: 方法功能简述：根据保单号查清单信息
     * @author: 杨成程
     * @date: 2017/11/28 11:44
     */
    @Override
    public List<InsureMainListDto> queryByPolicyNoAndValidity(String policyNo) {
        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNoAndValidity(policyNo);
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        convertCollection(insureMainLists, insureMainListDtoList, InsureMainListDto.class);
        return insureMainListDtoList;
    }

    /**
     * @param fname   农户姓名
     * @param fCardID 身份证号
     * @return list
     * @throws
     * @description: 方法功能简述：根据农户姓名和身份证号查清单信息
     * @author: 马俊玲
     * @date: 2017/11/28 11:44
     */
    @Override
    public List<String> queryByCondition(String fname, String fCardID) {
        List<String> resultList = null;
        if (StringUtils.isBlank(fCardID) && StringUtils.isNotBlank(fname)) {
            resultList = insureMainListDao.findByFname(fname);
        }
        if (StringUtils.isNotBlank(fCardID) && StringUtils.isBlank(fname)) {
            resultList = insureMainListDao.findByFname(fname);
        }
        if (StringUtils.isBlank(fCardID) && StringUtils.isNotBlank(fname)) {
            resultList = insureMainListDao.findByFcardId(fCardID);
        }
        if (StringUtils.isNotBlank(fCardID) && StringUtils.isNotBlank(fname)) {
            resultList = insureMainListDao.findByCondition(fname, fCardID);
        }
        return resultList;
    }

    /**
     * @param insureListCode
     * @return insureMainListList
     * @description: 方法功能简述：根据投保单清单编号查清单信息
     * @author: majunlng
     * @date: 2017/11/28 11:44
     */
    @Override
    public List<InsureMainListDto> findByInsureListCode(String insureListCode) throws Exception {
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("insureListCode为空！");
        }
        List<InsureMainList> insureMainListList = insureMainListDao.queryByInsureListCode(insureListCode);
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        convertCollection(insureMainListList, insureMainListDtoList, InsureMainListDto.class);
        return insureMainListDtoList;
    }

    /**
     * 判断有无此清单号
     *
     * @param insureListCode 清单号
     * @return String Y：有此清单号；N：无此清单号
     * @throws Exception
     * @author: 李冬松
     * @date: 2018/1/16 11:44
     */
    @Override
    public Map<String, String> isInInsureMainList(String insureListCode) throws Exception {
        String flag = "N";
        Map<String, String> map = new HashMap<String, String>();
        if (StringUtils.isEmpty(insureListCode)) {
            throw new DataVerifyException("清单号不可为空！");
        }
        List<InsureMainList> insureMainListList = new ArrayList<>();
        insureMainListList = insureMainListDao.queryAllByCondition(insureListCode);
        if (insureMainListList != null && insureMainListList.size() > 0) {
            flag = "Y";
        }
        map.put("message", flag);
        return map;
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
    public Integer queryFarmerNumber(String policyNo) throws Exception {
        inint();
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("查询清单时保单号为空！");
        }
        List<InsureMainList> insureMainListList = insureMainListDao.findByPolicyNo(policyNo);
        if (insureMainListList == null || insureMainListList.size() == 0) {
            throw new DataVerifyException("该保单号没有对应的清单信息!");
        }
        /*获取清单主表的清单号*/
        InsureMainList insureMainList = insureMainListList.get(0);
        String inusreListCode = insureMainList.getInusreListCode();
        String riskCode = insureMainList.getRiskCode();
        int farmerCount = 0;
        if (plantingRisk.contains(riskCode)) {
            farmerCount = plantingPolicyListDao.findFarmerPhoneNumberCount(inusreListCode);
        } else if (planting31Risk.contains(riskCode)) {
            farmerCount = planting31PolicyListDao.findFarmerPhoneNumberCount(inusreListCode);
        } else if (herdRisk.contains(riskCode)) {
            farmerCount = herdPolicyListDao.findFarmerPhoneNumberCount(inusreListCode);
        } else if (nyxRisk.contains(riskCode)) {
            farmerCount = nyxPolicyListDao.findFarmerPhoneNumberCount(inusreListCode);
        }
        return farmerCount;
    }

    /**
     * 根据金禾清单编号查询保单号
     *
     * @param gisInsureListCode 金禾清单编号
     * @return List<String> 保单号
     * @throws Exception
     * @author: 刘曼曼
     * @date: 12:07 12:07
     */
    @Override
    public List<String> queryByGisInsureListCode(String gisInsureListCode) throws Exception {
        if (StringUtils.isEmpty(gisInsureListCode)) {
            throw new DataVerifyException("清单编号不能为空");
        }
        List<String> policyNoList = insureMainListDao.findGisInsureListCode(gisInsureListCode);
        return policyNoList;
    }

    /**
     * 根据投保单号码号查询保单号
     * @author: 刘曼曼
     * @date: 12:07 12:07
     * @param proposalNos 投保单号码
     * @return  List<String> 清单主表信息
     * @throws Exception
     */
    @Override
    public List<InsureMainListDto> findAllByProposalNos(List<String> proposalNos) throws Exception {
        if (proposalNos == null || proposalNos.size() == 0) {
            throw new DataVerifyException("至少需要一个投保单号码！");
        }
        List<InsureMainList> insureMainLists = insureMainListDao.findAllByProposalNos(proposalNos);

        List<InsureMainListDto> insureMainListDtos = new ArrayList<>();
        convertCollection(insureMainLists, insureMainListDtos, InsureMainListDto.class);
        return insureMainListDtos;
    }

    /**
     * 根据金禾清单编号查询投保单号
     *
     * @param proposalNos 金禾清单编号
     * @return List<String> 投保单号
     * @throws Exception
     * @author: 汪强
     * @date: 12:07 12:07
     */
    @Override
    public List<String> queryByGisProposalNo(List<String> proposalNos) throws Exception {
        if (proposalNos == null || proposalNos.size() == 0) {
            throw new DataVerifyException("清单编号不能为空");
        }
        List<String> gisInsureListCodes = insureMainListDao.findGisInsureListCode(proposalNos);
        return gisInsureListCodes;
    }

    /**
     * 根据业务号码（投保单号、保单号、批单号）查询金禾的清单号
     *
     * @param bizCode 业务号
     * @return gisInsureListCode 金禾清单号
     * @date: 2018/4/8 15:43
     * @author: 何伟东
     */
    @Override
    public String findGisInsureListCodeByBizCode(String bizCode) {
        inint();
        String gisInsureListCode = null;
        if (bizCode == null) {
            throw new DataVerifyException("业务号不能为空！");
        }
        if (bizCode.startsWith(PROPOSAL_PREFIX)) {
            List<InsureMainList> insureMainLists = insureMainListDao.findByProposalNo(bizCode);
            if (insureMainLists != null && insureMainLists.size() > 0) {
                gisInsureListCode = insureMainLists.get(0).getGisInsureListCode();
            }
        } else if (bizCode.startsWith(POLICY_PREFIX)) {
            List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(bizCode);
            if (insureMainLists != null && insureMainLists.size() > 0) {
                gisInsureListCode = insureMainLists.get(0).getGisInsureListCode();
            }
        } else if (bizCode.startsWith(ENDORSE_PREFIX)) {
            String riskCode = bizCode.substring(1, 5);
            String insureListCode = "";
            if (plantingRisk.contains(riskCode) || planting31Risk.contains(riskCode)) {
                PlantingEndorHead plantingEndorHead = plantingEndorHeadDao.findOne(new PlantingEndorHeadKey(bizCode));
                if (plantingEndorHead != null) {
                    insureListCode = plantingEndorHead.getInusreListCode();
                }
            } else if (herdRisk.contains(riskCode)) {
                HerdEndorHead herdEndorHead = herdEndorHeadDao.findOne(new HerdEndorHeadKey(bizCode));
                if (herdEndorHead != null) {
                    insureListCode = herdEndorHead.getInusreListCode();
                }
            } else if (nyxRisk.contains(riskCode)) {
                NyxEndorHead nyxEndorHead = nyxEndorHeadDao.findOne(new NyxEndorHeadKey(bizCode));
                if (nyxEndorHead != null) {
                    insureListCode = nyxEndorHead.getInusreListCode();
                }
            }
            InsureMainList insureMainList = insureMainListDao.findOne(new InsureMainListKey(insureListCode));
            if (insureMainList != null) {
                gisInsureListCode = insureMainList.getGisInsureListCode();
            }
        }
        return gisInsureListCode;
    }

    /**
     * 根据投保单单号批量查询金禾的清单号下面的清单信息
     *
     * @param proposalNos 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/21 17:43
     */
    @Override
    public List<InsureMainListDto> queryByProposalNos(List<String> proposalNos) throws Exception {
        if (proposalNos.isEmpty()) {
            throw new DataVerifyException("至少需要一个投保单号码！");
        }
        List<InsureMainListDto> insureMainListDtos = new ArrayList<>();
        List<String> gisInsureListCode = insureMainListDao.findGisInsureListCodeByProposalNos(proposalNos);
        List<InsureMainList> insureMainLists = insureMainListDao.findByGisInsureListCodes(gisInsureListCode);
        convertCollection(insureMainLists, insureMainListDtos, InsureMainListDto.class);
        return insureMainListDtos;
    }
    /**
     * 根据耳标号和农户姓名查询保单信息
     *
     * @param
     * @author: 陈道洋
     * @date: 2018/4/21 17:43
     */
    @Override
    public List<InsureMainListDto> queryByEarableandFname(String earlAbel, String fName) throws Exception {
        if(StringUtils.isEmpty(earlAbel)&&StringUtils.isEmpty(fName)){
            throw new DataVerifyException("耳标号与农户姓名不能同时为空！");
        }
        StringBuilder str = new StringBuilder();
        str.append("select * from HerdPolicyList where 1=1");
        if(StringUtils.isNotEmpty(earlAbel)){
            str.append( " and earlAbel ='").append(earlAbel).append("'");
        }
        if(StringUtils.isNotEmpty(fName)){
            str.append( " and fName ='").append(fName).append("'");
        }
        Query query = entityManager.createNativeQuery(str.toString(), HerdPolicyList.class);
        List <HerdPolicyList> herdPolicyLists = query.getResultList();
        HashSet list = new HashSet();
       for(int i=0;i<herdPolicyLists.size();i++){
           String inusreListCode = herdPolicyLists.get(i).getInusreListCode();
           list.add(inusreListCode);
       }
        List<InsureMainList> insureMainListList = insureMainListDao.findByInsureListCodes(list);
        List<InsureMainListDto> insureMainListDtoList = new ArrayList<>();
        convertCollection(insureMainListList,insureMainListDtoList,InsureMainListDto.class);
        return insureMainListDtoList;
    }
}