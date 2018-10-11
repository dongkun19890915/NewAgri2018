package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.PlantingLossRateListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.PlantingLossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.PlantingLossRateListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.PlantingLossRateListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * @description 定损清单信息表Core接口实现
 */
@Service
public class PlantingLossRateListServiceImpl extends BaseServiceImpl implements PlantingLossRateListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingLossRateListServiceImpl.class);
    
    @Autowired
    private PlantingLossRateListDao plantingLossRateListDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(PlantingLossRateListDto plantingLossRateListDto) {
        PlantingLossRateList plantingLossRateList = this.convert(plantingLossRateListDto, PlantingLossRateList.class);
        plantingLossRateListDao.save(plantingLossRateList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo,String serialNo) {
        PlantingLossRateListKey plantingLossRateListKey = new PlantingLossRateListKey(listNo,serialNo);
        plantingLossRateListDao.delete(plantingLossRateListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PlantingLossRateListDto plantingLossRateListDto) {
        PlantingLossRateList plantingLossRateList = this.convert(plantingLossRateListDto, PlantingLossRateList.class);
        plantingLossRateListDao.save(plantingLossRateList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingLossRateListDto queryByPK(String listNo,String serialNo) {
        PlantingLossRateListKey plantingLossRateListKey = new PlantingLossRateListKey(listNo,serialNo);
        PlantingLossRateList plantingLossRateList = plantingLossRateListDao.findOne(plantingLossRateListKey);
        return this.convert(plantingLossRateList,PlantingLossRateListDto.class);
    }

    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareInsurance(String listNo, String registNo) {
        plantingLossRateListDao.compareInsurance(listNo, registNo);
    }

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<PlantingLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<PlantingLossRateListDto> queryComparable(String policyNo, String registNo) {
        List<PlantingLossRateList> plantingLossRateList = plantingLossRateListDao.queryComparable(policyNo, registNo);
        List<PlantingLossRateListDto> plantingLossRateListDtoList = new ArrayList<>();
        this.convertCollection(plantingLossRateList,plantingLossRateListDtoList,PlantingLossRateListDto.class);
        return plantingLossRateListDtoList;
    }

    /**
     * 保存损失率清单
     * @author 汪强
     * @date 2017-11-29
     * @param plantingLossRateListDtoList
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePlantingLossRateList(List<PlantingLossRateListDto> plantingLossRateListDtoList)throws Exception{
        List<PlantingLossRateList> plantingLossRateListList=new ArrayList<>();
        this.convertCollection(plantingLossRateListDtoList,plantingLossRateListList, PlantingLossRateList.class);
        plantingLossRateListDao.save(plantingLossRateListList);
    }

    /**
     * 查询种植险定损清单
     * @author: 祁小龙
     * @date: 2017/12/29 20:11
     * @param registNo 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    public List<PlantingLossRateListDto> queryPlantingLossRateListByRegistNo(String registNo) throws Exception{
        List<PlantingLossRateList>  plantingLossRateLists =  this.plantingLossRateListDao.queryPlantingLossRateListByRegistNo(registNo);
        List<PlantingLossRateListDto> plantingLossRateListDtoList = new ArrayList<PlantingLossRateListDto>();
        this.convertCollection(plantingLossRateLists,plantingLossRateListDtoList,PlantingLossRateListDto.class);
        return plantingLossRateListDtoList;
    }
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Override
    public PageInfo<PlantingLossRateListDto> queryPlantingLossRateListByListNo(Map<String, String> map) {
        String listNo = map.get("listNo");
        String pageNo = map.get("pageNo");
        String pageSize = map.get("pageSize");
        int pageNoInt = 0;
        int pageSizeInt = 0;
        if(StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("定损清单号不能为空");
        }
        Map< String, String> paramMap=new HashMap<>();
        StringBuilder str=new StringBuilder("select p from PlantingLossRateList p where 1=1 ");
        StringBuilder countsql=new StringBuilder("select count(1) from PlantingLossRateList p where 1=1 ");
        if(StringUtils.isNotEmpty(listNo)) {
            str.append("AND p.listNo =:listNo");
            countsql.append("AND p.listNo =:listNo");
            paramMap.put("listNo", listNo);
        }
        Query createQuery = entityManager.createQuery(str.toString());
        Query countQuery = entityManager.createQuery(countsql.toString());
        for (String key : paramMap.keySet()) {
            createQuery.setParameter(key,paramMap.get(key));
            countQuery.setParameter(key,paramMap.get(key));
        }
        if(StringUtils.isNotEmpty(pageNo) && StringUtils.isNotEmpty(pageSize)) {
            pageNoInt= Integer.parseInt(pageNo);
            pageSizeInt= Integer.parseInt(pageSize);
            createQuery.setFirstResult((pageNoInt - 1) * pageSizeInt);
            createQuery.setMaxResults(pageSizeInt);
        }
        Long totalSize = (Long) countQuery.getSingleResult();
        List<PlantingLossRateList>  plantingLossRateList= createQuery.getResultList();
        List<PlantingLossRateListDto> plantingLossRateListDto=new  ArrayList<>();
        this.convertCollection(plantingLossRateList, plantingLossRateListDto, PlantingLossRateListDto.class);
        PageInfo< PlantingLossRateListDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(plantingLossRateListDto);
        pageInfo.setPages(pageNoInt);
        pageInfo.setTotalCount(totalSize);
        return pageInfo;
    }
}