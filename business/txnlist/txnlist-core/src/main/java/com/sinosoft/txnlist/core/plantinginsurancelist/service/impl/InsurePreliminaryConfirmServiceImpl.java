package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.gisinsurelist.dto.*;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.gisinsurelist.dao.*;
import com.sinosoft.txnlist.core.gisinsurelist.entity.*;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.InsureMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.InsurePreliminaryConfirmService;
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
 * @Author: 潘峰
 * @Date: 2017/11/6 下午3:20
 * 投保预确认清单ServiceImpl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InsurePreliminaryConfirmServiceImpl extends BaseServiceImpl implements InsurePreliminaryConfirmService {

    @Autowired
    private GisFeildDao gisFeildDao;

    @Autowired
    private GisInsureMainListDao gisInsureMainListDao;

    @Autowired
    private GisNyxInsuranceListDao gisNyxInsuranceListDao;

    @Autowired
    private InsureMainListDao insureMainListDao;

    @Autowired
    private HerdInsuranceListDao herdInsuranceListDao;

    @Autowired
    private PlantingInsuranceListDao plantingInsuranceListDao;

    @Autowired
    private NyxInsuranceListDao nyxInsuranceListDao;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private GisHerdFieldDao gisHerdFieldDao;
    @Autowired
    private GisFarmerListDao gisFarmerListDao;
    @Autowired
    private GisFieldListDao gisFieldListDao;
    @Autowired
    private GisHerdFieldListDao gisHerdFieldListDao;
    @Autowired
    private GisManFieldListDao gisManFieldListDao;
    @Autowired
    private GisFarmerItemDao gisFarmerItemDao;

    /**
     * 投保预确认清单编号查询，查询 主信息，农户信息，田快信息
     * 如果用户传入insureListCode 则通过 insureListCode 模糊查询，否则全查
     *
     * @param requestDto 用户输入的查询条件
     * @return PageInfo<GisInsureMainListDto>  GisInsureMainListDto是主信息，农户信息，田快信息
     * @author: 潘峰
     * @date: 2017/11/6 下午2:18
     */
    @Override
    public PageInfo<GisInsureMainListDto> findGisInsureMainList(RequestInsuranceQueryDto requestDto) {
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
        StringBuilder dataHql = new StringBuilder("select pt from GisInsureMainList pt where pt.newFlag='Y' ");
        // 查询总数量的HQL
        StringBuilder countHql = new StringBuilder("select count(1) from GisInsureMainList pt where pt.newFlag='Y' ");
        // 条件hql拼接
        StringBuilder condition = new StringBuilder();
        Map<String, String> conditions = new HashMap<>();

        if (StringUtils.isNotEmpty(requestDto.getInsureListCode())) {
            condition.append(" AND pt.insureListCode = :insureListCode");
            conditions.put("insureListCode", requestDto.getInsureListCode());
        }

        if (StringUtils.isNotEmpty(requestDto.getListAlias())) {
            condition.append(" AND pt.listAlias = :listAlias");
            conditions.put("listAlias", requestDto.getListAlias());
        }

        if (StringUtils.isNotEmpty(requestDto.getOpName())) {
            condition.append(" AND pt.opName = :opName");
            conditions.put("opName", requestDto.getOpName());
        }

//        if (StringUtils.isNotEmpty(requestDto.getfAreaCode())) {
//            condition.append(" AND pt.fAreaCode = :fAreaCode");
//            conditions.put("fAreaCode", requestDto.getfAreaCode());
//        }

        if (StringUtils.isNotEmpty(requestDto.getBeginTime())) {
            condition.append(" AND pt.listAffrimTime >= to_date(:beginTime, 'yyyy-mm-dd')");
            conditions.put("beginTime", requestDto.getBeginTime());
        }

        if (StringUtils.isNotEmpty(requestDto.getEndTime())) {
            condition.append(" AND pt.listAffrimTime <= to_date(:endTime, 'yyyy-mm-dd')");
            conditions.put("endTime", requestDto.getEndTime());
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
        // 统一封装分页响应dto
        PageInfo<GisInsureMainListDto> pageInfo = new PageInfo<>();
        // 数据存放dto集合
        pageInfo.setContent(gisInsureMainListDtos);
        // 当前页数
        pageInfo.setPages(requestDto.getPageNo());
        // 总记录数
        pageInfo.setTotalCount(countNum);
        return pageInfo;
    }


    /**
     * 种植险：投保清单持久化服务：保存投保清单(农险一期)
     * @param insurePreliminaryConfirmDto 清单主表信息、种植险农户信息
     * @return void
     * @author: 潘峰
     * @date: 2017/11/16 下午2:37
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePlantingInsurePreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto)  throws Exception{
        // 保存清单主表信息
        this.saveInsureMainList(insurePreliminaryConfirmDto.getInsureMainListDto());
        //PlantingInsuranceList 保存这张表
        List<PlantingInsuranceListDto> plantingInsuranceListDtos = insurePreliminaryConfirmDto.getPlantingInsuranceListDtos();
        if (plantingInsuranceListDtos != null) {
            List<PlantingInsuranceList> plantingInsuranceLists = new ArrayList<>(plantingInsuranceListDtos.size());
            this.convertCollection(plantingInsuranceListDtos, plantingInsuranceLists, PlantingInsuranceList.class);
            plantingInsuranceListDao.save(plantingInsuranceLists);
        } else {
            throw new DataVerifyException("投保清单表数据不能为空！");
        }
    }

    /**
     * 养殖险：投保清单持久化服务(农险一期)
     * @author: 何伟东
     * @date: 2017/12/5 14:34
     * @param insurePreliminaryConfirmDto 清单主表信息、养殖险农户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveHerdInseredPreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto)  throws Exception{
        //todo 保费计算清单交互方式
        // 保存清单主表信息
        this.saveInsureMainList(insurePreliminaryConfirmDto.getInsureMainListDto());
        // 保存养殖险投保清单信息
        List<HerdInsuranceListDto> herdInsuranceListDtos = insurePreliminaryConfirmDto.getHerdInsuranceListDtos();
        if (herdInsuranceListDtos != null && herdInsuranceListDtos.size() > 0) {
            List<HerdInsuranceList> herdInsuranceLists = new ArrayList<>(herdInsuranceListDtos.size());
            this.convertCollection(herdInsuranceListDtos, herdInsuranceLists, HerdInsuranceList.class);
            herdInsuranceListDao.save(herdInsuranceLists);
        } else {
            throw new DataVerifyException("投保清单表数据不能为空！");
        }
    }

    /**
     * 农业险：投保清单持久化服务(农险二期)
     * @author: 何伟东
     * @date: 2017/12/8 15:01
     * @param insurePreliminaryConfirmDto 清单主表信息、农业险农户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNyxInseredPreliminaryConfirm(InsurePreliminaryConfirmDto insurePreliminaryConfirmDto) throws Exception {
        // 保存清单主表信息
        this.saveInsureMainList(insurePreliminaryConfirmDto.getInsureMainListDto());
        List<NyxInsuranceListDto> nyxInsuranceListDtos = insurePreliminaryConfirmDto.getNyxInsuranceListDtos();
        if (nyxInsuranceListDtos != null && nyxInsuranceListDtos.size()>0) {
            List<NyxInsuranceList> nyxInsuranceLists = new ArrayList<>();
            this.convertCollection(nyxInsuranceListDtos,nyxInsuranceLists,NyxInsuranceList.class);
            nyxInsuranceListDao.save(nyxInsuranceLists);
        } else {
            throw new DataVerifyException("投保清单表数据不能为空！");
        }
    }

    /**
     * 保存清单主表数据
     *
     * @author: 何伟东
     * @date: 2017/12/8 15:10
     * @param insureMainListDto 清单主表信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveInsureMainList(InsureMainListDto insureMainListDto) throws Exception{
        if (insureMainListDto != null) {
            InsureMainList insureMainList = this.convert(insureMainListDto, InsureMainList.class);
            insureMainListDao.save(insureMainList);
        } else {
            throw new DataVerifyException("清单主表数据不能为空！");
        }
    }

    /**
     * 通过清单编号查询投保预确认清单信息 主信息，农户信息，田快信息
     * @param insureListCode
     * @return InsurePreliminaryConfirmDto insureMainListDto,gisNyxInsuranceListDtos,gisFeildDtos
     * @author: 潘峰
     * @date: 2017/11/7 下午5:24
     */
    @Override
    public InsurePreliminaryConfirmDto queryInsurePreliminaryConfirm(String insureListCode) throws DataVerifyException {
        GisInsureMainList gisInsureMainList = gisInsureMainListDao.findByInsureListCodeAndNewFlagEquals(insureListCode, "Y");
        InsurePreliminaryConfirmDto insurePreliminaryConfirmDto = new InsurePreliminaryConfirmDto();
        if (gisInsureMainList != null) {
            GisInsureMainListDto gisInsureMainListDto = this.convert(gisInsureMainList, GisInsureMainListDto.class);
            insurePreliminaryConfirmDto.setGisInsureMainListDto(gisInsureMainListDto);
        } else {
            throw new DataVerifyException("没有查询到["+insureListCode+"]清单！");
        }
        Integer serialNo = gisInsureMainList.getSerialNo();

        List<GisFarmerList> gisFarmerListList=gisFarmerListDao.queryAllByInsurelistCodeAndSerialNo(insureListCode, serialNo);
        if (gisFarmerListList != null) {
            List<GisFarmerListDto> gisFarmerListDtos = new ArrayList<>(gisFarmerListList.size());
            this.convertCollection(gisFarmerListList, gisFarmerListDtos, GisFarmerListDto.class);
            insurePreliminaryConfirmDto.setGisFarmerListDtos(gisFarmerListDtos);
        }
        List<GisFarmerItem> gisFarmerItemList=gisFarmerItemDao.queryAllByInsureListCodeAndSerialNo(insureListCode,serialNo);
        if(gisFarmerItemList!=null){
            List<GisFarmerItemDto> gisFarmerItemDtoList=new ArrayList<>();
            convertCollection(gisFarmerItemList,gisFarmerItemDtoList,GisFarmerItemDto.class);
            insurePreliminaryConfirmDto.setGisFarmerItemDtoList(gisFarmerItemDtoList);
        }
        List<GisFieldList> gisFieldLists=gisFieldListDao.findGisFieldListByCondition(insureListCode, serialNo);
        if(gisFieldLists.size()>0){
            List<GisFieldListDto> gisFieldListDtos=new ArrayList<>(gisFieldLists.size());
            this.convertCollection(gisFieldLists,gisFieldListDtos,GisFieldListDto.class);
            insurePreliminaryConfirmDto.setGisFieldListDtos(gisFieldListDtos);
        }
        List<GisHerdFieldList> gisHerdFieldLists=gisHerdFieldListDao.findGisHerdFieldListByCondition(insureListCode, serialNo);
        if(gisHerdFieldLists.size()>0){
            List<GisHerdFieldListDto> gisHerdFieldListDtos=new ArrayList<>(gisHerdFieldLists.size());
            this.convertCollection(gisHerdFieldLists,gisHerdFieldListDtos,GisHerdFieldListDto.class);
            insurePreliminaryConfirmDto.setGisHerdFieldListDtos(gisHerdFieldListDtos);
        }
        List<GisManFieldList> gisManFieldListList = gisManFieldListDao.queryByFind(insureListCode, serialNo);
        if (gisHerdFieldLists.size() > 0) {
            List<GisManFieldListDto> gisHerdFieldListDtos = new ArrayList<>();
            this.convertCollection(gisManFieldListList, gisHerdFieldListDtos, GisManFieldListDto.class);
            insurePreliminaryConfirmDto.setGisManFieldListDtoList(gisHerdFieldListDtos);
        }
//        List<GisNyxInsuranceList> gisNyxInsuranceLists = gisNyxInsuranceListDao.findByInsureListCodeAndSerialNo(insureListCode, serialNo);
//        if (gisNyxInsuranceLists != null) {
//            List<GisNyxInsuranceListDto> gisNyxInsuranceListDtos = new ArrayList<>(gisNyxInsuranceLists.size());
//            this.convertCollection(gisNyxInsuranceLists, gisNyxInsuranceListDtos, GisNyxInsuranceListDto.class);
//            insurePreliminaryConfirmDto.setGisNyxInsuranceListDtos(gisNyxInsuranceListDtos);
//        }
//        List<GisFeild> gisFeilds = gisFeildDao.findByInsureListCodeAndSerialNo(insureListCode, serialNo);
//        if (gisFeilds.size() > 0) {
//            List<GisFeildDto> gisFeildDtos = new ArrayList<>(gisFeilds.size());
//            this.convertCollection(gisFeilds, gisFeildDtos, GisFeildDto.class);
//            insurePreliminaryConfirmDto.setGisFeildDtos(gisFeildDtos);
//        }
//        List<GisHerdField> gisHerdFields = gisHerdFieldDao.findByInsureListCodeAndSerialNo(insureListCode,serialNo);
//        if(gisHerdFields.size()>0){
//            List<GisHerdFieldDto> gisHerdFieldDtos = new ArrayList<>();
//            this.convertCollection(gisHerdFields,gisHerdFieldDtos,GisHerdFieldDto.class);
//            insurePreliminaryConfirmDto.setGisHerdFieldDtos(gisHerdFieldDtos);
//        }
        return insurePreliminaryConfirmDto;
}


}
