package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.BreedLossRateListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.BreedLossRateList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.BreedLossRateListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.BreedLossRateListService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
 * @time  2017-12-25 06:26:52.496 
 * @description 养殖险定损清单信息表Core接口实现
 */
@Service
public class BreedLossRateListServiceImpl extends BaseServiceImpl implements BreedLossRateListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BreedLossRateListServiceImpl.class);
    
    @Autowired
    private BreedLossRateListDao breedLossRateListDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    public void save(BreedLossRateListDto breedLossRateListDto) {
        BreedLossRateList breedLossRateList = this.convert(breedLossRateListDto, BreedLossRateList.class);
        breedLossRateListDao.save(breedLossRateList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String listNo,String serialNo) {
        BreedLossRateListKey breedLossRateListKey = new BreedLossRateListKey(listNo,serialNo);
        breedLossRateListDao.delete(breedLossRateListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(BreedLossRateListDto breedLossRateListDto) {
        BreedLossRateList breedLossRateList = this.convert(breedLossRateListDto, BreedLossRateList.class);
        breedLossRateListDao.save(breedLossRateList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public BreedLossRateListDto queryByPK(String listNo,String serialNo) {
        BreedLossRateListKey breedLossRateListKey = new BreedLossRateListKey(listNo,serialNo);
        BreedLossRateList breedLossRateList = breedLossRateListDao.findOne(breedLossRateListKey);
        return this.convert(breedLossRateList,BreedLossRateListDto.class);
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
        breedLossRateListDao.compareInsurance(listNo, registNo);
    }

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<BreedLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<BreedLossRateListDto> queryComparable(String policyNo, String registNo) {
        List<BreedLossRateList> plantingLossRateList = breedLossRateListDao.queryComparable(policyNo, registNo);
        List<BreedLossRateListDto> plantingLossRateListDtoList = new ArrayList<>();
        this.convertCollection(plantingLossRateList,plantingLossRateListDtoList,BreedLossRateListDto.class);
        return plantingLossRateListDtoList;
    }
    /**
     * 查询定损清单
     * @author: 孙朋飞
     * @date: 2017/12/29 20:11
     * @param registNo 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    @Override
    public List<BreedLossRateListDto> queryBreedLossRateListByRegistNo(String registNo) throws Exception {
        List<BreedLossRateList> breedLossRateList = breedLossRateListDao.findBreedLossRateListByRegistNo(registNo);
        List<BreedLossRateListDto> breedLossRateListDtos=new ArrayList<>();
        this.convertCollection(breedLossRateList,breedLossRateListDtos,BreedLossRateListDto.class);
        return breedLossRateListDtos;
    }
    /**
     * 根据定损清单号查询种植险定损清单
     *
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Override
    public PageInfo<BreedLossRateListDto> queryBreedLossRateListDtoByListNo(Map<String, String> map) throws Exception {
        String listNo = map.get("listNo");
        String pageNo = map.get("pageNo");
        String pageSize=map.get("pageSize");
        int pageNoInt = 0;
        int pageSizeInt = 0;
        Map<String, String> paramMap=new HashMap<>();
        StringBuilder stringbuider=new StringBuilder("select p from BreedLossRateList p where 1=1");
        StringBuilder countSql = new StringBuilder("select count(1) from BreedLossRateList p where 1=1 ");
        if(StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("定损清单号不能为空");

        }
        if(StringUtils.isNotEmpty(listNo)) {
            stringbuider.append("AND p.listNo =:listNo");
            countSql.append("AND p.listNo =:listNo");
            paramMap.put("listNo", listNo);
        }
        Query createQuery = entityManager.createQuery(stringbuider.toString());
        Query countQuery = entityManager.createQuery(countSql.toString());
        for (String key : paramMap.keySet()) {
            createQuery.setParameter(key,paramMap.get(key));
            countQuery.setParameter(key, paramMap.get(key));
        }
        if(StringUtils.isNotEmpty(pageNo) && StringUtils.isNotEmpty(pageSize)) {
            pageNoInt= Integer.parseInt(pageNo);
            pageSizeInt= Integer.parseInt(pageSize);
            createQuery.setFirstResult((pageNoInt - 1) * pageSizeInt);
            createQuery.setMaxResults(pageSizeInt);
        }
        Long totalSize = (Long) countQuery.getSingleResult();
        List<BreedLossRateList>  breedLossRateList= createQuery.getResultList();
        List<BreedLossRateListDto> breedLossRateListDto=new  ArrayList<>();
        this.convertCollection(breedLossRateList, breedLossRateListDto, BreedLossRateListDto.class);
        PageInfo< BreedLossRateListDto> pageInfo=new PageInfo<>();
        pageInfo.setContent(breedLossRateListDto);
        pageInfo.setPages(pageNoInt);
        pageInfo.setTotalCount(totalSize);
        return pageInfo;
    }
    /**
     * 根据定损清单号删除养植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Override
    public Map<String, String> deleteBreedLossRateListByListNo(Map<String, String> map) {
        Map<String, String> resultMap=new HashMap<>();
        String message="";
        String listNo = map.get("listNo");
        if(StringUtils.isEmpty(listNo)) {
            throw new DataVerifyException("理算清单号不能为空");

        }
        int i = breedLossRateListDao.deleteByListNo(listNo);
        if(i>-1) {
            message="操作成功";
        }else {
            message="操作失败";
        }

        resultMap.put("message", message);
        return resultMap;

    }
}