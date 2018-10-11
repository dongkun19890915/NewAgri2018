package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31CpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.Planting31CpEndorChgDetail;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31cpendorchgdetailCore接口
 */
public interface Planting31CpEndorChgDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode, String kindCode, String itemCode, String fIdCard);
    /**
     *@description 修改
     *@param
     */
    void modify(Planting31CpEndorChgDetailDto planting31CpEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    Planting31CpEndorChgDetailDto queryByPK(String inusreListCode, String kindCode, String itemCode, String fIdCard);

    public void removePlanting31CpEndorChgDetail(String inusreListCode)throws  Exception;

    public void savePlanting31CpEndorChgDetail(List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList)throws  Exception;

    public List<Planting31CpEndorChgDetailDto> queryByInsureListCode(String insureListCode)throws Exception;

}