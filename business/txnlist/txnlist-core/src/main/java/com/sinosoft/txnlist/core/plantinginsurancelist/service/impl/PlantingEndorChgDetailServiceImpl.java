package com.sinosoft.txnlist.core.plantinginsurancelist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.dao.PlantingEndorChgDetailDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingEndorChgDetailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
public class PlantingEndorChgDetailServiceImpl  extends BaseServiceImpl implements PlantingEndorChgDetailService {
    /** log日志 */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PlantingEndorChgDetailServiceImpl.class);
    @Autowired
    private PlantingEndorChgDetailDao plantingEndorChgDetailDao;
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void removeInsureList(String endorseNo)throws Exception{
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号不能为空!");
        }
        plantingEndorChgDetailDao.deleteInsureList(endorseNo);
    }


    @Override
    public void savePlantingEndorChgDetail(List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList)throws Exception{
        if(plantingEndorChgDetailDtoList.size()==0){
            throw new DataVerifyException("集合不能为空！");
        }
        List<PlantingEndorChgDetail> plantingEndorChgDetailList=new ArrayList<PlantingEndorChgDetail>();
        convertCollection(plantingEndorChgDetailDtoList,plantingEndorChgDetailList,PlantingEndorChgDetail.class);
        plantingEndorChgDetailDao.save(plantingEndorChgDetailList);
    }


    /**
     * 根据多个批单号查询相应费用类型的结算金额
     *
     * @param column-费用类型
     * @param endorseNos-多个批单号
     * @return 批单号-结算金额键值对
     * @author: 何伟东
     * @date: 2018/1/17 10:51
     */
    @Override
    public Map<String, Double> queryChgPremium(String column, List<String> endorseNos) {
        if (StringUtils.isEmpty(column)) {
            throw new DataVerifyException("费用类型不能为空！");
        }
        if (endorseNos == null || endorseNos.size() < 1) {
            throw new DataVerifyException("至少需要一个批单号码！");
        }
        StringBuilder dataSql = new StringBuilder("select sum(p.").append(column).append("),p.endorseNo from PlantingEndorChgDetail p ");
        dataSql.append("where p.endorseNo in (:endorseNos) group by p.endorseNo");
        Query query = entityManager.createQuery(dataSql.toString());
        query.setParameter("endorseNos", endorseNos);
        List<Object[]> resultList = query.getResultList();
        Map<String, Double> returnMap = new HashMap<>();
        resultList.forEach(objects -> {
            Double premium = (Double) objects[0];
            String endorseNo = (String) objects[1];
            returnMap.put(endorseNo, premium);
        });
        return returnMap;
    }

    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    @Override
    public List<PlantingEndorChgDetailDto> queryByEndorseNo(String endorseNo) {
        if (StringUtils.isEmpty(endorseNo)) {
            throw new DataVerifyException("批单号码不能为空！");
        }
        List<PlantingEndorChgDetail> plantingEndorChgDetails = plantingEndorChgDetailDao.findByEndorseNo(endorseNo);
        if (plantingEndorChgDetails == null || plantingEndorChgDetails.size() < 1) {
            throw new DataVerifyException("没有查询到" + endorseNo + "批单的分户清单变化量信息！");
        }
        List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtos = new ArrayList<>();
        convertCollection(plantingEndorChgDetails,plantingEndorChgDetailDtos,PlantingEndorChgDetailDto.class);
        return plantingEndorChgDetailDtos;
    }

    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @Override
    public Map<String,List<PlantingEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList){
        if (endorseNoList.size()==0) {
            throw new DataVerifyException("批单号码集合不能为空！");
        }
        Map<String,List<PlantingEndorChgDetailDto>> map = new HashMap<>();
        for(int i=0;i<endorseNoList.size();i++){
            List<PlantingEndorChgDetail> plantingEndorChgDetails = plantingEndorChgDetailDao.findByEndorseNo(endorseNoList.get(i));
            List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtos = new ArrayList<>();
            convertCollection(plantingEndorChgDetails,plantingEndorChgDetailDtos,PlantingEndorChgDetailDto.class);
            map.put(endorseNoList.get(i),plantingEndorChgDetailDtos);
        }
        return map;
    }
}
