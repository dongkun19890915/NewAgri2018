package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.InsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口实现
 */
@Service
public class InsuranceListServiceImpl extends BaseServiceImpl implements InsuranceListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceListServiceImpl.class);

    @Autowired
    private Planting31InsuranceListDao planting31InsuranceListDao;

    @Autowired
    private Planting31PolicyListDao planting31PolicyListDao;

    @Autowired
    private Planting31PolicyListOriginDao planting31PolicyListOriginDao;

    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;

    @Autowired
    private NyxPolicyListOriginDao nyxPolicyListOriginDao;

    @Autowired
    private PlantingInsuranceListDao plantingInsuranceListDao;

    @Autowired
    private PlantingPolicyListDao plantingPolicyListDao;

    @Autowired
    private PlantingpolicylistoriginDao plantingpolicylistoriginDao;

    @Autowired
    private PlantingTCirculationlistDao plantingTCirculationlistDao;

    @Autowired
    private PlantingCCirculationListOriginDao plantingCCirculationListOriginDao;

    @Autowired
    private PlantingCCirculationListDao plantingCCirculationListDao;

    @Autowired
    private HerdInsuranceListDao herdInsuranceListDao;

    @Autowired
    private HerdPolicyListDao herdPolicyListDao;

    @Autowired
    private HerdPolicyListOriginDao herdPolicyListOriginDao;

    @Autowired
    private NyxInsuranceListDao nyxInsuranceListDao;


    /**
     * @param inusreListCode
     * @description 传inusreListCode查询Planting31InsuranceList集合
     * 将Planting31InsuranceList集合的每一条entity保存到Planting31PolicyList和Planting31PolicyListOrigin
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void findByPlanting31InsuranceList(String inusreListCode) throws Exception {
        List<Planting31InsuranceList> planting31InsuranceLists = planting31InsuranceListDao.findByInusreListCode(inusreListCode);
        List<Planting31PolicyList> planting31PolicyLists = new ArrayList<Planting31PolicyList>(planting31InsuranceLists.size());
        List<Planting31PolicyListOrigin> planting31PolicyListOrigins = new ArrayList<Planting31PolicyListOrigin>(planting31InsuranceLists.size());
        convertCollection(planting31InsuranceLists, planting31PolicyLists, Planting31PolicyList.class);
        convertCollection(planting31InsuranceLists, planting31PolicyListOrigins, Planting31PolicyListOrigin.class);
        planting31PolicyLists = planting31PolicyListDao.save(planting31PolicyLists);
        planting31PolicyListOrigins = planting31PolicyListOriginDao.save(planting31PolicyListOrigins);
        if (planting31PolicyLists == null || planting31PolicyListOrigins == null) {
            throw new BusinessException("保存失败");
        }

    }

    /**
     * @param inusreListCode
     * @description 传inusreListCode查询 NyxInsuranceList 集合
     * 将NyxInsuranceList集合的每一条entity保存到NyxPolicyList和 NyxPolicyListOrigin
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNyxInsuranceToPolicy(String inusreListCode) throws Exception {
        List<NyxInsuranceList> herdInsuranceLists = nyxInsuranceListDao.findByInusreListCode(inusreListCode);
        List<NyxPolicyList> nyxPolicyLists = new ArrayList<NyxPolicyList>(herdInsuranceLists.size());
        List<NyxPolicyListOrigin> nyxPolicyListOrigins = new ArrayList<NyxPolicyListOrigin>(herdInsuranceLists.size());
        convertCollection(herdInsuranceLists, nyxPolicyListOrigins, NyxPolicyListOrigin.class);
        convertCollection(herdInsuranceLists, nyxPolicyLists, NyxPolicyList.class);
        nyxPolicyLists = nyxPolicyListDao.save(nyxPolicyLists);
        nyxPolicyListOrigins = nyxPolicyListOriginDao.save(nyxPolicyListOrigins);
        if (nyxPolicyLists == null || nyxPolicyListOrigins == null) {
            throw new BusinessException("保存失败");
        }
    }

    /**
     * @param inusreListCode
     * @author: 潘峰
     * @description 传inusreListCode查询PlantingInsuranceList集合
     * 将PlantingInsuranceList集合的每一条entity保存到PlantingPolicyList和Plantingpolicylistorigin
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveInsuranceToPolicy(String inusreListCode) throws Exception {

        List<PlantingInsuranceList> plantingInsuranceLists = plantingInsuranceListDao.inusreListCode(inusreListCode);
        List<PlantingPolicyList> plantingPolicyLists = new ArrayList<PlantingPolicyList>(plantingInsuranceLists.size());
        List<Plantingpolicylistorigin> plantingpolicylistorigins = new ArrayList<Plantingpolicylistorigin>(plantingInsuranceLists.size());
        convertCollection(plantingInsuranceLists, plantingPolicyLists, PlantingPolicyList.class);
        convertCollection(plantingInsuranceLists, plantingpolicylistorigins, Plantingpolicylistorigin.class);
        plantingPolicyLists = plantingPolicyListDao.save(plantingPolicyLists);
        plantingpolicylistorigins = plantingpolicylistoriginDao.save(plantingpolicylistorigins);
        if (plantingPolicyLists == null || plantingpolicylistorigins == null) {
            throw new BusinessException("保存失败");
        }

    }

    /**
     * @param inusreListCode @author: 潘峰
     * @description 传inusreListCode查询 PlantingTCirculationList 集合
     * 将PlantingTCirculationList集合的每一条entity保存到 PlantingCCirculationList 和 PlantingCCirculationListOrigin
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTCirculationToC(String inusreListCode) throws Exception {
        List<PlantingTCirculationlist> plantingInsuranceLists = plantingTCirculationlistDao.findByInusreListCode(inusreListCode);
        List<PlantingCCirculationList> plantingCCirculationLists = new ArrayList<PlantingCCirculationList>(plantingInsuranceLists.size());
        List<PlantingCCirculationListOrigin> plantingCCirculationListOrigins = new ArrayList<PlantingCCirculationListOrigin>(plantingInsuranceLists.size());
        convertCollection(plantingInsuranceLists, plantingCCirculationLists, PlantingCCirculationList.class);
        convertCollection(plantingInsuranceLists, plantingCCirculationListOrigins, PlantingCCirculationListOrigin.class);
        plantingCCirculationLists = plantingCCirculationListDao.save(plantingCCirculationLists);
        plantingCCirculationListOrigins = plantingCCirculationListOriginDao.save(plantingCCirculationListOrigins);
        if (plantingCCirculationLists == null || plantingCCirculationListOrigins == null) {
            throw new BusinessException("保存失败");
        }


    }

    /**
     * @param inusrelistCode @description 传RelationListNo查询  herdinsurancelist 集合
     *                       将herdinsurancelist集合的每一条entity保存到 herdPolicyList 和 herdPolicyListOrigin
     * @author: 潘峰
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveHerdinsuranceToPolicy(String inusrelistCode) throws Exception {

        List<HerdInsuranceList> herdInsuranceLists = herdInsuranceListDao.findByInusreListCode(inusrelistCode);
        List<HerdPolicyList> herdPolicyLists = new ArrayList<HerdPolicyList>(herdInsuranceLists.size());
        List<HerdPolicyListOrigin> herdPolicyListOrigins = new ArrayList<HerdPolicyListOrigin>(herdInsuranceLists.size());
        convertCollection(herdInsuranceLists, herdPolicyLists, HerdPolicyList.class);
        convertCollection(herdInsuranceLists, herdPolicyListOrigins, HerdPolicyListOrigin.class);
        herdPolicyLists = herdPolicyListDao.save(herdPolicyLists);
        herdPolicyListOrigins = herdPolicyListOriginDao.save(herdPolicyListOrigins);
        if (herdPolicyLists == null || herdPolicyListOrigins == null) {
            throw new BusinessException("保存失败");
        }
    }
}