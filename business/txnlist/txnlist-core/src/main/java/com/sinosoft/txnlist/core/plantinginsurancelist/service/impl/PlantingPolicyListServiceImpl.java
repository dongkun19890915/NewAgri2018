package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.insuremainlist.dao.InsureMainListDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingPolicyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlantingPolicyListServiceImpl extends BaseServiceImpl implements PlantingPolicyListService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PlantingPolicyListServiceImpl.class);

    @Autowired
    private PlantingPolicyListDao plantingPolicyListDao;
    @Autowired
    private PlantingPolicyList_OldDao plantingPolicyList_OldDao;
    @Autowired
    private NyxPolicyListDao nyxPolicyListDao;
    @Autowired
    private Planting31PolicyListDao planting31PolicyListDao;
    @Autowired
    private HerdPolicyListDao herdPolicyListDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private InsureMainListDao insureMainListDao;

    /**
     * :（根据inusreListCode查询PlantingPolicyList集合）
     * @author: 王心洋
     * @date: 2017/11/08
     * @param inusreListCode
     * @return   List<PlantingPolicyListDto>
     */
    @Transactional
    public List<PlantingPolicyListDto> queryByInusreListCode(String inusreListCode) {
        List<PlantingPolicyList> plantingPolicyListList = plantingPolicyListDao.findByInusreListCode(inusreListCode);
        List<PlantingPolicyListDto> plantingPolicyListDtoList = new ArrayList<>();
        this.convertCollection(plantingPolicyListList,plantingPolicyListDtoList,PlantingPolicyListDto.class);
        return plantingPolicyListDtoList;
    }
    /**
     * :（根据inusreListCode查询PlantingPolicyList_OLD集合）
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<PlantingPolicyListDto>
     */
    @Transactional
    public List<PlantingPolicyListDto> queryOLDByInusreListCode(String inusreListCode) {
        List<PlantingPolicyList_Old> plantingPolicyListList = plantingPolicyList_OldDao.findOLDByInusreListCode(inusreListCode);
        List<PlantingPolicyListDto> plantingPolicyListDtoList = new ArrayList<>();
        this.convertCollection(plantingPolicyListList,plantingPolicyListDtoList,PlantingPolicyListDto.class);
        return plantingPolicyListDtoList;
    }

    /**
     * 根据 inusreListCode 查询 NyxPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<NyxPolicyListDto>
     */
    @Override
    public List<NyxPolicyListDto> queryNyxByInsureListCode(String inusreListCode) {
        List<NyxPolicyList> nyxPolicyListList = nyxPolicyListDao.queryNyxByInsureListCode(inusreListCode);
        List<NyxPolicyListDto> nyxPolicyListDtoList = new ArrayList<>();
        this.convertCollection(nyxPolicyListList,nyxPolicyListDtoList,NyxPolicyListDto.class);
        return nyxPolicyListDtoList;
    }

    /**
     *  根据 inusreListCode 查询 Planting31PolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<Planting31PolicyListDto>
     */
    @Override
    public List<Planting31PolicyListDto> queryPlanting31ByInsuereListCode(String inusreListCode) {
        List<Planting31PolicyList> planting31PolicyListList = planting31PolicyListDao.queryPlanting31ByInsuereListCode(inusreListCode);
        List<Planting31PolicyListDto> planting31PolicyListDtoList = new ArrayList<>();
        this.convertCollection(planting31PolicyListList,planting31PolicyListDtoList,Planting31PolicyListDto.class);
        return planting31PolicyListDtoList;
    }

    /**
     *  根据 inusreListCode 查询 HerdPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<HerdPolicyListDto>
     */
    @Override
    public List<HerdPolicyListDto> queryHerdByInsureListCode(String inusreListCode) {
        List<HerdPolicyList> herdPolicyListList = herdPolicyListDao.queryHerdByInsureListCode(inusreListCode);
        List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
        this.convertCollection(herdPolicyListList,herdPolicyListDtoList,HerdPolicyListDto.class);
        return herdPolicyListDtoList;
    }
    /**
     *  根据 查询条件 查询 HerdPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param endorseConditionDto
     * @return List<HerdPolicyListDto>
     */
    @Override
    public List<HerdPolicyListDto> queryHerdByConditions(EndorseConditionDto endorseConditionDto)  throws Exception{
        StringBuilder dataHql = new StringBuilder("select hp from HerdPolicyList hp where");
        StringBuilder condition = new StringBuilder();
        StringBuilder conditions1 = new StringBuilder();
        Map<String,String> conditions = new HashMap<>();
        String fCode = endorseConditionDto.getfCode();
        String fIdCard = endorseConditionDto.getfIdCard();
        String earLabel = endorseConditionDto.getEarLabel();
        String fName = endorseConditionDto.getfName();
        String bankCard = endorseConditionDto.getBankCard();
        String inusrelistcode = endorseConditionDto.getInusreListCode();
        condition.append(" hp.inusrelistcode = :inusrelistcode");
        conditions1.append(" hp.inusrelistcode = :inusrelistcode");
        if (StringUtils.isNotEmpty(fCode)) {
            condition.append(" AND hp.fCode = :fCode");
            conditions.put("fCode", fCode);
        }
        if (StringUtils.isNotEmpty(fIdCard)) {
            condition.append(" AND hp.fIdCard = :fIdCard");
            conditions.put("fIdCard", fIdCard);
        }
        if (StringUtils.isNotEmpty(earLabel)) {
            String[] arrValue = split(earLabel,"\r\n");

            for(int j=0; j<arrValue.length; j++){
                arrValue[j] = replace(arrValue[j],"\r\n","").trim();
            }
            int index1 = 0;
            for(index1 = 0; index1<arrValue.length; index1++){
                if(arrValue[index1].equals(""))
                    continue;
                else
                    break;
            }
            if(index1!=arrValue.length) {
                condition.append(" AND hp.earlAbel in ('").append(arrValue[index1]).append("'");
                for (int j = index1 + 1; j < arrValue.length; j++) {
                    if (arrValue[j].equals("")) continue;
                    condition.append(",'").append(arrValue[j]).append("'");
                }
                condition.append(")");
            }
        }
        if (StringUtils.isNotEmpty(fName)) {
            condition.append(" AND hp.fName = :fName");
            conditions.put("fName", fName);
        }
        if (StringUtils.isNotEmpty(bankCard)) {
            condition.append(" AND hp.bankCard = :bankCard");
            conditions.put("bankCard", bankCard);
        }
        //取未显示在页面的记录
        dataHql.append(" inusrelistcode='").append(inusrelistcode).append("' and earLabel not in (select earLabel from HerdPolicyList where").append(condition).append(")");
        Query dataQuery = entityManager.createQuery(dataHql.toString());
        // 设置参数
        for (String key:conditions.keySet()) {
            dataQuery.setParameter(key,conditions.get(key));
        }
        List<HerdPolicyList> herdPolicyListList = new ArrayList<>();
        herdPolicyListList = dataQuery.getResultList();
        List<HerdPolicyListDto> herdPolicyListDtoList = new ArrayList<>();
        this.convertCollection(herdPolicyListList,herdPolicyListDtoList,HerdPolicyListDto.class);
        return herdPolicyListDtoList;
    }


    public static String[] split(String strIn,String strDelimiters) throws Exception {
        int theIndex     = 0;
        String[] arrReturn = null;    //返回值字符串数组
        String strErrorMessage = "";  //错误信息
        int intCount = 0;             //数组的大小

        if (strIn.equals("") || strIn==null || strDelimiters.equals("") || strDelimiters==null)
        {
            strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): 待拆分字符串和分隔符串都不能为空";
            throw new Exception(strErrorMessage);  //待拆分字符串和分隔符串都不能为空
        }

        if (strIn.length() < strDelimiters.length())
        {
            strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): 待拆分字符串比分隔符串还要短";
            throw new Exception(strErrorMessage);  //待拆分字符串比分隔符串还要短
        }

        //计算字符串有多少个分隔符
        String strTemp = strIn;
        while(strTemp!="" && strTemp!=null) {
            theIndex = strTemp.indexOf(strDelimiters);
            if(theIndex == -1) {
                break;
            }
            intCount++;
            strTemp = strTemp.substring(theIndex+strDelimiters.length());
        }
        arrReturn = new String[++intCount];
        //生成字符串数组
        for(int i=0;i<intCount-1;i++) {
            theIndex = strIn.indexOf(strDelimiters);
            arrReturn[i] = strIn.substring(0,theIndex);
            strIn = strIn.substring(theIndex+strDelimiters.length());
        }
        arrReturn[intCount-1] = strIn;
        return arrReturn;
    }
    /**
     * 字符串替换函数
     * @param strMain：原串，strFind：查找字符串，strReplaceWith：替换字符串
     * @return 替换后的字符串，如果原串为空或者为""，则返回""
     */
    public static String replace(String strMain,String strFind,String strReplaceWith)
    {
        String strReturn  = "";
        int intStartIndex = 0,
                intEndIndex   = 0;

        if(StringUtils.isEmpty(strMain))
            return "";

        while((intEndIndex=strMain.indexOf(strFind,intStartIndex))>-1)
        {
            strReturn = strReturn + strMain.substring(intStartIndex,intEndIndex) + strReplaceWith;
            intStartIndex = intEndIndex + strFind.length();
        }

        strReturn = strReturn + strMain.substring(intStartIndex,strMain.length());
        return strReturn;
    }

    @Override
    public List<PlantingPolicyListDto> queryByInsureMainListByPolicyNO(String policyNo) {
//        List<InsureMainList> insureMainLists = insureMainListDao.findByPolicyNo(policyNo);
//
//        if (insureMainLists.size() > 0) {
//            InsureMainList insureMainList = insureMainLists.get(0);
//            List<PlantingPolicyList> plantingPolicyLists = plantingPolicyListDao.findByInusreListCode(insureMainList.getInusreListCode());
//            List<PlantingPolicyListDto> plantingPolicyListDtos = new ArrayList<>(plantingPolicyLists.size());
//            this.convertCollection(plantingPolicyLists, plantingPolicyListDtos, PlantingPolicyListDto.class);
//            return plantingPolicyListDtos;
//        } else {
//            LOGGER.error("此清单号没有信息");
//            throw new DataVerifyException("此清单号没有信息");
//        }
        String inusreListCode = insureMainListDao.findInusreListCodeByPolicyNo(policyNo);
        if (StringUtils.isNotEmpty(inusreListCode)) {
            List<PlantingPolicyList> plantingPolicyLists = plantingPolicyListDao.queryByInusreListCode(inusreListCode);
            List<PlantingPolicyListDto> plantingPolicyListDtos = new ArrayList<>(plantingPolicyLists.size());
            this.convertCollection(plantingPolicyLists, plantingPolicyListDtos, PlantingPolicyListDto.class);
            return plantingPolicyListDtos;

        } else {
            LOGGER.error("此清单号没有信息");
            throw new DataVerifyException("此清单号没有信息");
        }
    }



    @Override
    public List<PlantingPolicyListDto> findPlantingPolicyListByInsureListCode(String insureListCode) throws Exception {
        if(StringUtils.isEmpty((insureListCode))){
            throw new DataVerifyException("insureListCode为空！");
        }
        List<PlantingPolicyList> plantingPolicyListList=null;
        plantingPolicyListList=plantingPolicyListDao.findByInusreListCode(insureListCode);
        if(plantingPolicyListList==null){
            List<PlantingPolicyList_Old> plantingPolicyList_oldList=new ArrayList<>();
            plantingPolicyList_oldList=plantingPolicyList_OldDao.findOLDByInusreListCode(insureListCode);
            convertCollection(plantingPolicyList_oldList,plantingPolicyListList,PlantingPolicyList.class);
        }
        List<PlantingPolicyListDto> plantingPolicyListDtoList=new ArrayList<>();
        convertCollection(plantingPolicyListList,plantingPolicyListDtoList,PlantingPolicyListDto.class);
        return plantingPolicyListDtoList;
    }


    /**
     *  根据GIS清单号查询承保清单 种植险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    @Override
    public List<PlantingPolicyListDto> queryByGisInsureListCode(String gisInsureListCode) throws Exception {
        if(StringUtils.isEmpty(gisInsureListCode)){
            LOGGER.warn("请求参数不能为空");
            throw new DataVerifyException("请求参数不能为空！");
        }
        //RISKCODE=3107原方法
        //RISKCODE=3220 查HERDSETTLELIST
        List<PlantingPolicyList> plantingPolicyListList = plantingPolicyListDao.queryByGisInsureListCode(gisInsureListCode);
        List<PlantingPolicyListDto> plantingPolicyListDtoList = new ArrayList<PlantingPolicyListDto>();
        this.convertCollection(plantingPolicyListList, plantingPolicyListDtoList, PlantingPolicyListDto.class);
        return plantingPolicyListDtoList;
    }
}
