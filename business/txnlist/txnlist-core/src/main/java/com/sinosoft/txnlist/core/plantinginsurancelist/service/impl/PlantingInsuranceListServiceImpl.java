package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingInsuranceListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.specification.plantinginsurancelistSpecBuilder;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingInsuranceListKey;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingInsuranceListService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Core接口实现
 */
@Service
public class PlantingInsuranceListServiceImpl extends BaseCustomServiceImpl implements PlantingInsuranceListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingInsuranceListServiceImpl.class);
    
    @Autowired
    private PlantingInsuranceListDao plantingInsuranceListDao;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PlantingInsuranceListDto plantingInsuranceListDto) {
        PlantingInsuranceList plantingInsuranceList = this.convert(plantingInsuranceListDto, PlantingInsuranceList.class);
        plantingInsuranceListDao.save(plantingInsuranceList);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String inusrelistcode,String fcode,String kindcode) {
        PlantingInsuranceListKey plantingInsuranceListKey = new PlantingInsuranceListKey(inusrelistcode,fcode,kindcode);
        plantingInsuranceListDao.delete(plantingInsuranceListKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PlantingInsuranceListDto plantingInsuranceListDto) {
        PlantingInsuranceList plantingInsuranceList = this.convert(plantingInsuranceListDto, PlantingInsuranceList.class);
        plantingInsuranceListDao.save(plantingInsuranceList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PlantingInsuranceListDto queryByPK(String inusrelistcode,String fcode,String kindcode) {
        PlantingInsuranceListKey plantingInsuranceListKey = new PlantingInsuranceListKey(inusrelistcode,fcode,kindcode);
        PlantingInsuranceList plantingInsuranceList = plantingInsuranceListDao.findOne(plantingInsuranceListKey);
        return this.convert(plantingInsuranceList,PlantingInsuranceListDto.class);
    }

    /**
     * @description:（根据inusreListCode查询PlantingInsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:55
     * @param inusreListCode
     * @return List<PlantingInsuranceListDto>
     */
    @Override
    public List<PlantingInsuranceListDto> queryByInusreListCode (String inusreListCode){
        List<PlantingInsuranceList> listPlantingInsuranceList = new ArrayList<PlantingInsuranceList>();
        List<PlantingInsuranceListDto> plantingInsuranceListDtoList = new ArrayList<PlantingInsuranceListDto>();
        listPlantingInsuranceList =plantingInsuranceListDao.findAll(plantinginsurancelistSpecBuilder.Specification(inusreListCode));
        this.convertCollection(listPlantingInsuranceList,plantingInsuranceListDtoList,PlantingInsuranceListDto.class);
        return plantingInsuranceListDtoList;
    }
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:55
     * @param plantingInsuranceListDtoList
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveByList(List<PlantingInsuranceListDto> plantingInsuranceListDtoList){
        List<PlantingInsuranceList> listPlantingInsuranceList = new ArrayList<PlantingInsuranceList>();
        this.convertCollection(plantingInsuranceListDtoList,listPlantingInsuranceList,PlantingInsuranceList.class);
        plantingInsuranceListDao.save(listPlantingInsuranceList);
    }

    /**
     * @description:（批量修改）
     * @author: 田健
     * @date: 2017/10/20 11:56
     * @param plantingInsuranceListDtoList
     */
    //TODO 原生sql
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyBylist(List<PlantingInsuranceListDto> plantingInsuranceListDtoList){
        SimpleDateFormat dateFormat = new  SimpleDateFormat("yyyy-MM-dd") ;
        List<PlantingInsuranceList> listPlantingInsuranceList = new ArrayList<PlantingInsuranceList>();
        this.convertCollection(plantingInsuranceListDtoList,listPlantingInsuranceList,PlantingInsuranceList.class);
        for(PlantingInsuranceList plantingInsuranceList:listPlantingInsuranceList){
            StringBuilder strWhere = new StringBuilder("  update PlantingInsuranceList a set ");
            Map<String,Object> map= new HashMap<>();
            strWhere.append(" a.kindCode = :kindCode");
            map.put("kindCode",plantingInsuranceList.getKindCode());
            strWhere.append(" , a.amount = :getAmount");
            map.put("amount",plantingInsuranceList.getAmount());
            strWhere.append(" , a.rate= :rate");
            map.put("rate",plantingInsuranceList.getRate());
            strWhere.append(" , a.shortRateFlag= :shortRateFlag");
            map.put("shortRateFlag",plantingInsuranceList.getShortRateFlag());
            strWhere.append(" , a.shortRate=:shortRate");
            map.put("shortRate",plantingInsuranceList.getShortRate());
            strWhere.append(" , a.sumAmount=:sumAmount ");
            map.put("sumAmount",plantingInsuranceList.getSumAmount());
            strWhere.append(" , a.sumPremium=:sumPremium");
            map.put("sumPremium",plantingInsuranceList.getSumAmount());
            //strWhere.append(" , a.StartDate='"+plantingInsuranceList.getStartdate()+"'");
            String StartDate = dateFormat.format(plantingInsuranceList.getStartDate());
            strWhere.append(" , a.startDate= to_date(:startDate,'yyyy-MM-dd')");
            map.put("startDate",StartDate);
            String EndDate = dateFormat.format(plantingInsuranceList.getEndDate());
            strWhere.append(" , a.endDate= to_date(:EndDate,'yyyy-MM-dd')");
            map.put("EndDate",EndDate);
            if(plantingInsuranceList.getWarrant()==null){
                strWhere.append(" , a.warrant=''");
            }else{
                strWhere.append(" , a.warrant=:warrant ");
                map.put("warrant",plantingInsuranceList.getWarrant());
            }
            strWhere.append(" , a.fPremium=:fPremium ");
            map.put("fPremium",plantingInsuranceList.getfPremium());
            strWhere.append(" , a.centralPremium=:centralPremium ");
            map.put("centralPremium",plantingInsuranceList.getCentralPremium());
            strWhere.append(" , a.provincePremium=:provincePremium ");
            map.put("provincePremium",plantingInsuranceList.getProvincePremium());
            strWhere.append(" , a.cityPremium=:cityPremium ");
            map.put("cityPremium",plantingInsuranceList.getCityPremium());
            strWhere.append(" , a.townPremium=:townPremium ");
            map.put("townPremium",plantingInsuranceList.getTownPremium());
            strWhere.append(" , a.otherPremium=:otherPremium ");
            map.put("otherPremium",plantingInsuranceList.getOtherPremium());
            if ("".equals(plantingInsuranceList.getWoodlandArea()) || plantingInsuranceList.getWoodlandArea() == null) {
                strWhere.append(" , a.woodlandArea= '0'");
            }else{
                strWhere.append(" , a.woodlandArea=:woodlandArea ");
                map.put("woodlandArea",plantingInsuranceList.getWoodlandArea());
            }
            strWhere.append(" , a.calculateFlag=:calculateFlag ");
            map.put("calculateFlag",plantingInsuranceList.getCalculateFlag());
            strWhere.append(" where a.inusreListCode = :inusreListCode ");
            map.put("inusreListCode",plantingInsuranceList.getInusreListCode());
            strWhere.append(" and a.cCode=:cCode ");
            map.put("cCode",plantingInsuranceList.getfCode());
            javax.persistence.Query dataQuery= entityManager.createNativeQuery(strWhere.toString());
            this.setQueryParam(dataQuery,map);
            int i=  dataQuery.executeUpdate();
            System.err.print(i);
        }

    }
    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     * @return int
     */
    @Override
    public int getSumInsured(String inusreListCode) {
        int iSumInsured = plantingInsuranceListDao.getSumInsured(inusreListCode);
        return iSumInsured;
    }
    /**
     * @description:（根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     * @return PlantingInsuranceListDto
     */
    @Override
    public PlantingInsuranceListDto getSumFee(String inusreListCode) {
        PlantingInsuranceListDto plantingInsuranceListDto = new PlantingInsuranceListDto();
        List<Object[]> list = new ArrayList<Object[]>();
        list = plantingInsuranceListDao.getSumFee(inusreListCode);
        //将查询出的结果放进dto中
        plantingInsuranceListDto.setSumPremium((Double) list.get(0)[0]);
        plantingInsuranceListDto.setfPremium((Double) list.get(0)[1]);
        plantingInsuranceListDto.setCentralPremium((Double) list.get(0)[2]);
        plantingInsuranceListDto.setProvincePremium((Double) list.get(0)[3]);
        plantingInsuranceListDto.setCityPremium((Double) list.get(0)[4]);
        plantingInsuranceListDto.setTownPremium((Double) list.get(0)[5]);
        plantingInsuranceListDto.setOtherPremium((Double) list.get(0)[6]);
        return  plantingInsuranceListDto;
    }

    /**
     * @description:（根据inusreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeByInusreListcode(String inusreListCode) {
        plantingInsuranceListDao.removeByInusreListCode(inusreListCode);
    }
    /**
     * @description:（PlantingInsuranceList分页查询）
     * @author: 陈道洋
     * @date: 2017/11/2 20:41
     * @param inusreListCode 清单编号
     * @param pageNo 页码
     * @param pageSize 每页条数
     * @return 查询结果数据
     * @throws Exception
     */
    @Override
    public PageInfo<PlantingInsuranceListDto> queryPlantingInsuranceInfo(String inusreListCode, int pageNo, int pageSize) throws Exception {
        if (StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("投保清单编号不能为空！");
        }
        if (pageNo<1){
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if (pageSize<1){
            throw new DataVerifyException("查询每页数量不能小于1！");
        }
        //查询数据
        StringBuilder dateSql = new StringBuilder("SELECT pi FROM PlantingInsuranceList pi WHERE");
        //查询总数量
        StringBuilder countSql = new StringBuilder("SELECT count(1) FROM PlantingInsuranceList pi WHERE");
        Map<String,Object> conditions= new HashMap<>();
        //拼接条件
        dateSql.append(" pi.inusreListCode=:inusreListCode");
        countSql.append(" pi.inusreListCode=:inusreListCode");
        conditions.put("inusreListCode",inusreListCode);
        //5、创建查询对象
       Query dateQuery = entityManager.createQuery(dateSql.toString());
       Query countQuery = entityManager.createQuery(countSql.toString());
        //6、设置参数
       this.setQueryParam(dateQuery,pageNo,pageSize,conditions);
       this.setQueryParam(countQuery,conditions);

        //查询数据总条数
        long countNum = (long)countQuery.getSingleResult();
        //查询数据
        List<PlantingInsuranceList>datelist = new ArrayList<>();
        List<PlantingInsuranceListDto>reslist=new ArrayList<>();
        if(countNum>0){
            datelist=dateQuery.getResultList();
            convertCollection(datelist,reslist,PlantingInsuranceListDto.class);
        }
        // 统一封装分页响应dto
        PageInfo<PlantingInsuranceListDto> pageInfo=this.setPageInfo(reslist,pageNo,countNum,PlantingInsuranceListDto.class);
        return pageInfo;
    }

    /**
     * @description::根据inusrelistcode查询PlantingInsuranceList表
     * @author: 陈道洋
     * @date: 2017/10/31 16:03
     * @param inusreListCode 清单编号
     * @return PlantingInsuranceList表的数据
     * @throws Exception
     */
    @Override
    public List<PlantingInsuranceListDto> queryPlantingInsuranceListInfo(String inusreListCode) throws Exception {
        if(StringUtils.isEmpty(inusreListCode)){
            throw new DataVerifyException("投保清单编号不能为空！");
        }
        List<PlantingInsuranceList> plantingInsuranceLists = plantingInsuranceListDao.findByInusreListCode(inusreListCode);
        List<PlantingInsuranceListDto> reslist = new ArrayList<>();
        convertCollection(plantingInsuranceLists,reslist,PlantingInsuranceListDto.class);
        return reslist;
    }
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param    - 保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @Override
    public PlantingInsuranceListDto queryByInusreListCodeAndFcode(String inusreListCode, String fCode) throws Exception {
        if (StringUtils.isEmpty(inusreListCode)) {
            throw new DataVerifyException("清单号不能为空");
        }
        if (StringUtils.isEmpty(fCode)) {
            throw new DataVerifyException("农户代码不能为空");
        }
        PlantingInsuranceList plantingInsuranceList = plantingInsuranceListDao.queryByInusreListCodeAndFcode(inusreListCode, fCode);
        PlantingInsuranceListDto plantingInsuranceListDto = this.convert(plantingInsuranceList, PlantingInsuranceListDto.class);
        return plantingInsuranceListDto;
    }
}