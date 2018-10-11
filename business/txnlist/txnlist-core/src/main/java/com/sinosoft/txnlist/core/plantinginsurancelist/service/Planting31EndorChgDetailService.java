package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31endorchgdetailCore接口
 */
public interface Planting31EndorChgDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(Planting31EndorChgDetailDto planting31EndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode, String endorseNo, String kindCode, String itemCode, String fIdCard);
    /**
     *@description 修改
     *@param
     */
    void modify(Planting31EndorChgDetailDto planting31EndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    Planting31EndorChgDetailDto queryByPK(String inusreListCode, String endorseNo, String kindCode, String itemCode, String fIdCard);

    public void removePlanting31EndorChgDetail(String endorseNo)throws Exception;

    public void savePlanting31EndorChgDetail(List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList)throws Exception;
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    Map<String,List<Planting31EndorChgDetailDto>> queryByEndorseNoList(List<String> endorseNoList);

    /**
     * 根据批单号码查询planting31的批改变化量清单
     *
     * @param endorseNo 批单号码
     * @return List<Planting31EndorChgDetailDto>
     * @date: 2018/4/13 17:25
     * @author: 何伟东
     */
    List<Planting31EndorChgDetailDto> queryByEndorseNo(String endorseNo);
}