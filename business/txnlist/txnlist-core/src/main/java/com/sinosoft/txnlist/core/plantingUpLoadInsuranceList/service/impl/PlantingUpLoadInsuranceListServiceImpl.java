package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.service.impl;

import com.sinosoft.txnlist.api.plantingUpLoadInsuranceList.dto.PlantingUpLoadInsuranceListDto;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.dao.PlantingUpLoadInsuranceListDao;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.dao.specification.PlantingUpLoadInsuranceListSpecBuilder;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity.PlantingUpLoadInsuranceList;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity.PlantingUpLoadInsuranceListKey;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.service.PlantingUpLoadInsuranceListService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * @description plantingUpLoadInsuranceListCore接口实现
 */
@Service
public class PlantingUpLoadInsuranceListServiceImpl extends BaseServiceImpl implements PlantingUpLoadInsuranceListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingUpLoadInsuranceListServiceImpl.class);
    
    @Autowired
    private PlantingUpLoadInsuranceListDao plantingUpLoadInsuranceListDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Transactional
    public void save(PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto) {
        PlantingUpLoadInsuranceList plantingUpLoadInsuranceList = this.convert(plantingUpLoadInsuranceListDto, PlantingUpLoadInsuranceList.class);
        plantingUpLoadInsuranceListDao.save(plantingUpLoadInsuranceList);
    }
    /**
     *@description 删除
     *@param
     */
    @Transactional
    public void remove(String inusreListCode,String fCode) {
        PlantingUpLoadInsuranceListKey plantingUpLoadInsuranceListKey = new PlantingUpLoadInsuranceListKey(inusreListCode,fCode);
        plantingUpLoadInsuranceListDao.delete(plantingUpLoadInsuranceListKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Transactional
    public void modify(PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto) {
        PlantingUpLoadInsuranceList plantingUpLoadInsuranceList = this.convert(plantingUpLoadInsuranceListDto, PlantingUpLoadInsuranceList.class);
        plantingUpLoadInsuranceListDao.save(plantingUpLoadInsuranceList);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Transactional
    public PlantingUpLoadInsuranceListDto queryByPK(String inusreListCode,String fCode) {
        PlantingUpLoadInsuranceListKey plantingUpLoadInsuranceListKey = new PlantingUpLoadInsuranceListKey(inusreListCode,fCode);
        PlantingUpLoadInsuranceList plantingUpLoadInsuranceList = plantingUpLoadInsuranceListDao.findOne(plantingUpLoadInsuranceListKey);
        return this.convert(plantingUpLoadInsuranceList,PlantingUpLoadInsuranceListDto.class);
    }
    /**
     *@description 按inusreListCode查询集合
     *@param
     */
    @Transactional
    public List<PlantingUpLoadInsuranceListDto> queryByInsureListCode(String inusreListCode) {
        List<PlantingUpLoadInsuranceList> listPlantingUpLoadInsuranceList = new ArrayList<PlantingUpLoadInsuranceList>();
        List<PlantingUpLoadInsuranceListDto> listPlantingUpLoadInsuranceListDto = new ArrayList<PlantingUpLoadInsuranceListDto>();
        listPlantingUpLoadInsuranceList =plantingUpLoadInsuranceListDao.findAll(PlantingUpLoadInsuranceListSpecBuilder.Specification(inusreListCode));
        this.convertCollection(listPlantingUpLoadInsuranceList,listPlantingUpLoadInsuranceListDto,PlantingUpLoadInsuranceListDto.class);
        return listPlantingUpLoadInsuranceListDto;
    }
    /**
     * @description:（批量保存）
     * @author: 王心洋
     * @date: 2017/10/24 17:55
     * @param plantingUpLoadInsuranceListDtoList
     */
    @Transactional
    public void saveByList(List<PlantingUpLoadInsuranceListDto> plantingUpLoadInsuranceListDtoList){
        List<PlantingUpLoadInsuranceList> listPlantingUpLoadInsuranceList = new ArrayList<PlantingUpLoadInsuranceList>();
        this.convertCollection(plantingUpLoadInsuranceListDtoList,listPlantingUpLoadInsuranceList,PlantingUpLoadInsuranceList.class);
        plantingUpLoadInsuranceListDao.save(listPlantingUpLoadInsuranceList);
    }

    /**
     * @description:（批量修改）
     * @author: 王心洋
     * @date: 2017/10/24 18:25
     * @param plantingUpLoadInsuranceListDtoList
     */
    //todo 原生sql
    @Transactional
    public void modifyBylist(List<PlantingUpLoadInsuranceListDto> plantingUpLoadInsuranceListDtoList){
        SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd") ;
        List<PlantingUpLoadInsuranceList> listPlantingUpLoadInsuranceList = new ArrayList<PlantingUpLoadInsuranceList>();
        this.convertCollection(plantingUpLoadInsuranceListDtoList,listPlantingUpLoadInsuranceList,PlantingUpLoadInsuranceList.class);
        for(PlantingUpLoadInsuranceList plantingUpLoadInsuranceList:listPlantingUpLoadInsuranceList){
            String sql=" update PlantingUpLoadInsuranceList a set ";
            StringBuilder strWhere = new StringBuilder();
            strWhere.append(" a.phone         ='"+plantingUpLoadInsuranceList.getPhone()+"'");
            strWhere.append(",a.zhibuka       ='"+plantingUpLoadInsuranceList.getZhiBuKa()+"'");
            strWhere.append(",a.fname         ='"+plantingUpLoadInsuranceList.getFName()+"'");
            strWhere.append(",a.fidcard       ='"+plantingUpLoadInsuranceList.getFIdCard()+"'");
            strWhere.append(",a.flag          ='"+plantingUpLoadInsuranceList.getFlag()+"'");
            strWhere.append(",a.taxarea       ='"+plantingUpLoadInsuranceList.getTaxArea()+"'");
            strWhere.append(",a.insurearea    ='"+plantingUpLoadInsuranceList.getInsureArea()+"'");
            strWhere.append(",a.remark        ='"+plantingUpLoadInsuranceList.getRemark()+"'");
            strWhere.append(",a.teamname      ='"+plantingUpLoadInsuranceList.getTeamName()+"'");
            strWhere.append(",a.fieldsource   ='"+plantingUpLoadInsuranceList.getFieldSource()+"'");
            strWhere.append(",a.flag1         ='"+plantingUpLoadInsuranceList.getFlag1()+"'");
            strWhere.append(",a.operatedate   ='"+plantingUpLoadInsuranceList.getOperateDate()+"'");
            strWhere.append(",a.warrant       ='"+plantingUpLoadInsuranceList.getWarrant()+"'");
            strWhere.append(",a.atarea        ='"+plantingUpLoadInsuranceList.getAtArea()+"'");
            strWhere.append(",a.littleareaname='"+plantingUpLoadInsuranceList.getLittleAreaName()+"'");
            strWhere.append(",a.woodlandarea  ='"+plantingUpLoadInsuranceList.getWoodLandArea()+"'");
            strWhere.append(" where a.InusreListCode = '"+plantingUpLoadInsuranceList.getInusreListCode()+"'");
            strWhere.append(" and a.FCode='"+plantingUpLoadInsuranceList.getFCode()+"'");
            sql +=strWhere.toString();
            javax.persistence.Query dataQuery= entityManager.createNativeQuery(sql);
            int i=  dataQuery.executeUpdate();
            System.err.print(i);
        }
    }

    /**
     *@description 按insureListCode删除
     * @author: 王心洋
     * @date: 2017/10/24 17:11
     *@param inusreListcode
     */
    public void removeByInusreListcode(String inusreListcode){
        plantingUpLoadInsuranceListDao.removeByInusreListcode(inusreListcode);
    }
}