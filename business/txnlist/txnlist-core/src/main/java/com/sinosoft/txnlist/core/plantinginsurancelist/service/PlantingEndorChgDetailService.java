package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;

import java.util.List;
import java.util.Map;

public interface PlantingEndorChgDetailService {


    public void removeInsureList(String endorseNo)throws Exception;

    public void savePlantingEndorChgDetail(List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList)throws Exception;

    /**
     * 根据多个批单号查询相应费用类型的结算金额
     *
     * @param column-费用类型
     * @param endoseNos-多个批单号
     * @return 批单号-结算金额键值对
     * @author: 何伟东
     * @date: 2018/1/17 10:51
     */
    Map<String, Double> queryChgPremium(String column, List<String> endoseNos);

    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    List<PlantingEndorChgDetailDto> queryByEndorseNo(String endorseNo);
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public Map<String,List<PlantingEndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList);
}
