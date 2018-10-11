package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.EndorseListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批改清单操作ServiceImpl
 *
 * @Author: 陈道洋
 * @Date: 2017/11/14 11:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EndorseListServiceImpl extends BaseCustomServiceImpl implements EndorseListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndorseListServiceImpl.class);

    /**
     * 批改清单类型：种植险清单
     */
    private final String ENDORSE_LIST_TYPE_PLANTING = "planting";
    /**
     * 批改清单类型：农业险
     */
    private final String ENDORSE_LIST_TYPE_NYX = "nyx";
    /**
     * 批改清单类型：养殖险
     */
    private final String ENDORSE_LIST_TYPE_HERD = "herd";

    @Autowired
    private PlantingEndorHeadDao plantingEndorHeadDao;
    @Autowired
    private PlantingEndorChgDetailDao plantingEndorChgDetailDao;
    @Autowired
    private PlantingCpEndorChgDetailDao plantingCpEndorChgDetailDao;

    @Autowired
    private HerdEndorHeadDao herdEndorHeadDao;
    @Autowired
    private HerdEndorChgDetailDao herdEndorChgDetailDao;
    @Autowired
    private HerdcEndorChgDetailDao herdcEndorChgDetailDao;

    @Autowired
    private NyxEndorHeadDao nyxEndorHeadDao;
    @Autowired
    private NyxEndorChgDetailDao nyxEndorChgDetailDao;
    @Autowired
    private NyxCpEndorChgDetailDao nyxCpEndorChgDetailDao;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 清单存储在planting的险种
     */
    //@Value("${sysconfig.insureListRsk.planting}")
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
    //@Value("${sysconfig.insureListRsk.herd}")
    private String herdRisk;

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
     * 种植险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @throws Exception
     * @author: 陈道洋
     * @date: 2017/11/14 11:03
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePlantingEndorseList(RequestEndorseListDto requestEndorseListDto) throws DataVerifyException {
        if (requestEndorseListDto == null) {
            throw new DataVerifyException("批改清单数据不能为空！");
        }
        //批改清单主表保存
        PlantingEndorHeadDto plantingEndorHeadDto = requestEndorseListDto.getPlantingEndorHeadDto();
        if (plantingEndorHeadDto != null) {
            PlantingEndorHead plantingEndorHead = this.convert(plantingEndorHeadDto, PlantingEndorHead.class);
            plantingEndorHeadDao.saveAndFlush(plantingEndorHead);
        } else {
            throw new DataVerifyException("批改清单主要数据不能为空！");
        }
        //批改清单明细表保存
        List<PlantingEndorChgDetailDto> plantingEndorChgDetailList = requestEndorseListDto.getPlantingEndorChgDetailDtoList();
        if (plantingEndorChgDetailList != null && plantingEndorChgDetailList.size() > 0) {
            List<PlantingEndorChgDetail> plantingEndorChgDetails = new ArrayList<>();
            this.convertCollection(plantingEndorChgDetailList, plantingEndorChgDetails, PlantingEndorChgDetail.class);
            plantingEndorChgDetailDao.save(plantingEndorChgDetails);
        } else {
            throw new DataVerifyException("批改清单明细数据不能为空！");
        }
        //批改清单最新数据表保存
        List<PlantingCpEndorChgDetailDto> plantingCpEndorChgDetailList = requestEndorseListDto.getPlantingCpEndorChgDetailDtoList();
        if (plantingCpEndorChgDetailList != null && plantingCpEndorChgDetailList.size() > 0) {
            List<PlantingCpEndorChgDetail> plantingCpEndorChgDetails = new ArrayList<>();
            this.convertCollection(plantingCpEndorChgDetailList, plantingCpEndorChgDetails, PlantingCpEndorChgDetail.class);
            plantingCpEndorChgDetailDao.save(plantingCpEndorChgDetails);
        } else {
            throw new DataVerifyException("批改清单最新数据不能为空！");
        }

    }

    /**
     * 养殖险：批改清单持久化接口(农险一期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveHerdEndorseList(RequestEndorseListDto requestEndorseListDto) throws DataVerifyException {
        if (requestEndorseListDto == null) {
            throw new DataVerifyException("批改清单数据不能为空！");
        }
        // 批改清单主表保存
        HerdEndorHeadDto herdEndorHeadDto = requestEndorseListDto.getHerdEndorHeadDto();
        if (herdEndorHeadDto != null) {
            HerdEndorHead herdEndorHead = this.convert(herdEndorHeadDto, HerdEndorHead.class);
            herdEndorHeadDao.save(herdEndorHead);
        } else {
            throw new DataVerifyException("批改清单主要数据不能为空！");
        }
        // 批改清单明细表保存
        List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList = requestEndorseListDto.getHerdEndorChgDetailDtoList();
        if (herdEndorChgDetailDtoList != null && herdEndorChgDetailDtoList.size() > 0) {
            List<HerdEndorChgDetail> herdEndorChgDetailList = new ArrayList<>();
            this.convertCollection(herdEndorChgDetailDtoList, herdEndorChgDetailList, HerdEndorChgDetail.class);
            herdEndorChgDetailDao.save(herdEndorChgDetailList);
        } else {
            throw new DataVerifyException("批改清单明细数据不能为空！");
        }
        // 批改清单最新数据表保存
        List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList = requestEndorseListDto.getHerdcEndorChgDetailDtoList();
        if (herdcEndorChgDetailDtoList != null && herdcEndorChgDetailDtoList.size() > 0) {
            List<HerdcEndorChgDetail> herdcEndorChgDetailList = new ArrayList<>();
            this.convertCollection(herdcEndorChgDetailDtoList, herdcEndorChgDetailList, HerdcEndorChgDetail.class);
            herdcEndorChgDetailDao.save(herdcEndorChgDetailList);
        } else {
            throw new DataVerifyException("批改清单最新数据不能为空！");
        }
    }

    /**
     * 农业险：批改清单持久化接口(农险二期)
     *
     * @param requestEndorseListDto 需要保存的数据的Dto
     * @author: 何伟东
     * @date: 2017/12/8 9:58
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNyxEndorseList(RequestEndorseListDto requestEndorseListDto) throws DataVerifyException {
        if (requestEndorseListDto == null) {
            throw new DataVerifyException("批改清单数据不能为空！");
        }
        // 批改清单主表保存
        NyxEndorHeadDto nyxEndorHeadDto = requestEndorseListDto.getNyxEndorHeadDto();
        if (nyxEndorHeadDto != null) {
            NyxEndorHead nyxEndorHead = this.convert(nyxEndorHeadDto, NyxEndorHead.class);
            nyxEndorHeadDao.save(nyxEndorHead);
        } else {
            throw new DataVerifyException("批改清单主要数据不能为空！");
        }
        // 批改清单明细表保存
        List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList = requestEndorseListDto.getNyxEndorChgDetailDtoList();
        if (nyxEndorChgDetailDtoList != null && nyxEndorChgDetailDtoList.size() > 0) {
            List<NyxEndorChgDetail> nyxEndorChgDetailList = new ArrayList<>();
            this.convertCollection(nyxEndorChgDetailDtoList, nyxEndorChgDetailList, NyxEndorChgDetail.class);
            nyxEndorChgDetailDao.save(nyxEndorChgDetailList);
        } else {
            throw new DataVerifyException("批改清单明细数据不能为空！");
        }
        // 批改清单最新数据表保存
        List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList = requestEndorseListDto.getNyxCpEndorChgDetailDtoList();
        if (nyxCpEndorChgDetailDtoList != null && nyxCpEndorChgDetailDtoList.size() > 0) {
            List<NyxCpEndorChgDetail> nyxCpEndorChgDetailList = new ArrayList<>();
            this.convertCollection(nyxCpEndorChgDetailDtoList, nyxCpEndorChgDetailList, NyxCpEndorChgDetail.class);
            nyxCpEndorChgDetailDao.save(nyxCpEndorChgDetailList);
        } else {
            throw new DataVerifyException("批改清单最新数据不能为空！");
        }
    }

    /**
     * 修改批改清单是否删除字段
     *
     * @param endorseNo 批单号码
     * @param listType  清单类型（planting-种植险，herd-养殖险，nyx-农业险）
     * @param isDelete  是否删除true删除false取消删除
     * @return lineNo 修改的行数
     * @author: 何伟东
     * @date: 2017/12/11 15:37
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateIsDeleteFlag(String endorseNo, String listType, boolean isDelete) throws DataVerifyException {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空!");
        }
        if (StringUtils.isEmpty(listType)) {
            throw new DataVerifyException("清单类型不能为空！");
        }
        int lineNo = 0;
        // 种植险批改清单
        if (ENDORSE_LIST_TYPE_PLANTING.equalsIgnoreCase(listType)) {
            if (isDelete) {
                // 删除清单
                lineNo = plantingEndorHeadDao.updateIsDeleteFlag(endorseNo, "0");
            } else {
                // 取消删除
                lineNo = plantingEndorHeadDao.updateIsDeleteFlag(endorseNo, "1");
            }
        }
        // 养殖险批改清单
        else if (ENDORSE_LIST_TYPE_HERD.equalsIgnoreCase(listType)) {
            if (isDelete) {
                // 删除清单
                lineNo = herdEndorHeadDao.updateIsDeleteFlag(endorseNo, "0");
            } else {
                // 取消删除
                lineNo = herdEndorHeadDao.updateIsDeleteFlag(endorseNo, "1");
            }
        }
        // 农业险批改清单
        else if (ENDORSE_LIST_TYPE_NYX.equalsIgnoreCase(listType)) {
            if (isDelete) {
                // 删除清单
                lineNo = nyxEndorHeadDao.updateIsDeleteFlag(endorseNo, "0");
            } else {
                // 取消删除
                lineNo = nyxEndorHeadDao.updateIsDeleteFlag(endorseNo, "1");
            }
        }
        // 清单类型不正确
        else {
            throw new DataVerifyException("清单类型不正确！");
        }
        return lineNo;
    }

    /**
     * 根据批单号码查询批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @author: 何伟东
     * @date: 2017/12/23 12:08
     */
    @Override
    public Map<String, Double> getFarmerInfo(String column, String endorseNo, String riskCode) throws Exception {

        if (StringUtils.isEmpty(column)) {
            throw new DataVerifyException("费用类型不能为空");
        }
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空");
        }
        inint();
        Map<String, Double> farmerInfo = new HashMap<>();
        if (plantingRisk.contains(riskCode)) {
            farmerInfo = getPlantingFarmerInfo(column, endorseNo);
        } else if (planting31Risk.contains(riskCode)) {
            farmerInfo = getPlanting31FarmerInfo(column, endorseNo);
        } else if (herdRisk.contains(riskCode)) {
            farmerInfo = getHerdFarmerInfo(column, endorseNo);
        } else if (nyxRisk.contains(riskCode)) {
            farmerInfo = getNyxFarmerInfo(column, endorseNo);
        }
        return farmerInfo;
    }

    /**
     * 根据批单号码查询planting表中批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @date: 2018/4/13 14:39
     * @author: 何伟东
     */
    private Map<String, Double> getPlantingFarmerInfo(String column, String endorseNo) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder condition = new StringBuilder("select n from PlantingEndorChgDetail n where n.endorseNo = :endorseNo and n." + column + " < 0 ");
        Query query = entityManager.createQuery(condition.toString());
        query.setParameter("endorseNo", endorseNo);
        List<PlantingEndorChgDetail> plantingEndorChgDetails = query.getResultList();
        if (plantingEndorChgDetails == null || plantingEndorChgDetails.size() < 1) {
            throw new DataVerifyException("没有查询到该批单的分户信息");
        }
        // 利用反射获取对应缴费类型的费用信息
        Field columnField = PlantingEndorChgDetail.class.getDeclaredField(column);
        columnField.setAccessible(true);
        Map<String, Double> farmerInfo = new HashMap<>();
        for (PlantingEndorChgDetail plantingEndorChgDetail : plantingEndorChgDetails) {
            Double chgPremium = (Double) columnField.get(plantingEndorChgDetail);
            String fCode = plantingEndorChgDetail.getfCode();
            if (farmerInfo.containsKey(fCode)) {
                chgPremium += farmerInfo.get(fCode);
            }
            farmerInfo.put(fCode, chgPremium);
        }
        return farmerInfo;
    }

    /**
     * 根据批单号码查询planting31表中批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @date: 2018/4/13 14:39
     * @author: 何伟东
     */
    private Map<String, Double> getPlanting31FarmerInfo(String column, String endorseNo) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder condition = new StringBuilder("select n from Planting31EndorChgDetail n where n.endorseNo = :endorseNo and n." + column + " < 0 ");
        Query query = entityManager.createQuery(condition.toString());
        query.setParameter("endorseNo", endorseNo);
        List<Planting31EndorChgDetail> planting31EndorChgDetails = query.getResultList();
        if (planting31EndorChgDetails == null || planting31EndorChgDetails.size() < 1) {
            throw new DataVerifyException("没有查询到该批单的分户信息");
        }
        // 利用反射获取对应缴费类型的费用信息
        Field columnField = Planting31EndorChgDetail.class.getDeclaredField(column);
        columnField.setAccessible(true);
        Map<String, Double> farmerInfo = new HashMap<>();
        for (Planting31EndorChgDetail planting31EndorChgDetail : planting31EndorChgDetails) {
            Double chgPremium = (Double) columnField.get(planting31EndorChgDetail);
            String fCode = planting31EndorChgDetail.getfCode();
            if (farmerInfo.containsKey(fCode)) {
                chgPremium += farmerInfo.get(fCode);
            }
            farmerInfo.put(fCode, chgPremium);
        }
        return farmerInfo;
    }

    /**
     * 根据批单号码查询herd表中批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @date: 2018/4/13 14:39
     * @author: 何伟东
     */
    private Map<String, Double> getHerdFarmerInfo(String column, String endorseNo) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder condition = new StringBuilder("select n from HerdEndorChgDetail n where n.endorseNo = :endorseNo and n." + column + " < 0 ");
        Query query = entityManager.createQuery(condition.toString());
        query.setParameter("endorseNo", endorseNo);
        List<HerdEndorChgDetail> herdEndorChgDetails = query.getResultList();
        if (herdEndorChgDetails == null || herdEndorChgDetails.size() < 1) {
            throw new DataVerifyException("没有查询到该批单的分户信息");
        }
        // 利用反射获取对应缴费类型的费用信息
        Field columnField = HerdEndorChgDetail.class.getDeclaredField(column);
        columnField.setAccessible(true);
        Map<String, Double> farmerInfo = new HashMap<>();
        for (HerdEndorChgDetail herdEndorChgDetail : herdEndorChgDetails) {
            Double chgPremium = (Double) columnField.get(herdEndorChgDetail);
            String fCode = herdEndorChgDetail.getfCode();
            if (farmerInfo.containsKey(fCode)) {
                chgPremium += farmerInfo.get(fCode);
            }
            farmerInfo.put(fCode, chgPremium);
        }
        return farmerInfo;
    }

    /**
     * 根据批单号码查询herd表中批改过的农户代码和农户变化保费
     *
     * @param endorseNo 批单号
     * @param column    字段名
     * @return key-农户代码；value-变化的保费
     * @date: 2018/4/13 14:39
     * @author: 何伟东
     */
    private Map<String, Double> getNyxFarmerInfo(String column, String endorseNo) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder condition = new StringBuilder("select n from NyxEndorChgDetail n where n.endorseNo = :endorseNo and n." + column + " < 0 ");
        Query query = entityManager.createQuery(condition.toString());
        query.setParameter("endorseNo", endorseNo);
        List<NyxEndorChgDetail> nyxEndorChgDetails = query.getResultList();
        if (nyxEndorChgDetails == null || nyxEndorChgDetails.size() < 1) {
            throw new DataVerifyException("没有查询到该批单的分户信息");
        }
        // 利用反射获取对应缴费类型的费用信息
        Field columnField = NyxEndorChgDetail.class.getDeclaredField(column);
        columnField.setAccessible(true);
        Map<String, Double> farmerInfo = new HashMap<>();
        for (NyxEndorChgDetail nyxEndorChgDetail : nyxEndorChgDetails) {
            Double chgPremium = (Double) columnField.get(nyxEndorChgDetail);
            String fCode = nyxEndorChgDetail.getfCode();
            if (farmerInfo.containsKey(fCode)) {
                chgPremium += farmerInfo.get(fCode);
            }
            farmerInfo.put(fCode, chgPremium);
        }
        return farmerInfo;
    }

    /**
     * 根据批单号码查询批减保费的农户信息(支持分页)
     *
     * @param endorseNo  批单号码
     * @param pageNo     页数
     * @param pageSize   每页数量
     * @param pagination 是否分页
     * @return List<NyxEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @Override
    public PageInfo<NyxEndorChgDetailDto> queryNyxEndorChgDetail(String endorseNo, int pageNo, int pageSize, boolean pagination) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空!");
        }
        if (pagination) {
            if (pageNo < 1) {
                throw new DataVerifyException("页数不能小于1");
            }
            if (pageSize < 1) {
                throw new DataVerifyException("每页数量不能小于1");
            }
        }
        Map<String, Object> param = new HashMap<>();
        StringBuilder dateSql = new StringBuilder("SELECT e FROM NyxEndorChgDetail e WHERE e.chgSumPremium < 0");
        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM NyxEndorChgDetail e WHERE e.chgSumPremium < 0");
        dateSql.append(" AND e.endorseNo = :endorseNo");
        countSql.append(" AND e.endorseNo = :endorseNo");
        param.put("endorseNo", endorseNo);
        dateSql.append(" ORDER BY e.businessNo DESC");
        countSql.append(" ORDER BY e.businessNo DESC");
        Query countQuery = entityManager.createQuery(countSql.toString());
        this.setQueryParam(countQuery, param);
        long countSize = (long) countQuery.getSingleResult();
        PageInfo<NyxEndorChgDetailDto> returnPageInfo;
        if (countSize > 0) {
            Query dataResult = entityManager.createQuery(dateSql.toString());
            if (pagination) {
                this.setQueryParam(dataResult, pageNo, pageSize, param);
            } else {
                this.setQueryParam(dataResult, param);
            }
            List<NyxEndorChgDetailDto> nyxEndorChgDetails = dataResult.getResultList();
            returnPageInfo = this.setPageInfo(nyxEndorChgDetails, pageNo, countSize, NyxEndorChgDetailDto.class);
        } else {
            returnPageInfo = new PageInfo<>();
            returnPageInfo.setTotalCount(0);
            returnPageInfo.setPages(pageNo);
        }
        return returnPageInfo;
    }

    /**
     * 根据批单号码查询批改后的分户清单
     *
     * @param endorseNo 批单号码
     * @return List<NyxCpEndorChgDetailDto> 符合条件的数据
     * @author: 何伟东
     * @date: 2017/12/25 16:01
     */
    @Override
    public List<NyxCpEndorChgDetailDto> queryNyxCpEndorChgDetail(String endorseNo) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号不能为空！");
        }
        NyxEndorHead nyxEndorHead = nyxEndorHeadDao.findOne(new NyxEndorHeadKey(endorseNo));
        if (nyxEndorHead == null) {
            throw new DataVerifyException(endorseNo + "没有对应的分户清单！");
        }
        String policyNo = nyxEndorHead.getPolicyNo();
        String inusreListCode = nyxEndorHead.getInusreListCode();
        List<NyxCpEndorChgDetail> nyxCpEndorChgDetails = nyxCpEndorChgDetailDao.findByInusreListCode(inusreListCode);
        List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtos = new ArrayList<>();
        this.convertCollection(nyxCpEndorChgDetails, nyxCpEndorChgDetailDtos, NyxCpEndorChgDetailDto.class);
        nyxCpEndorChgDetailDtos.forEach(nyxCpEndorChgDetailDto -> {
            nyxCpEndorChgDetailDto.setPolicyNo(policyNo);
            nyxCpEndorChgDetailDto.setEndorseNo(endorseNo);
        });
        return nyxCpEndorChgDetailDtos;
    }
}
