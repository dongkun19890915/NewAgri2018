package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.service;


import com.sinosoft.txnlist.api.plantingUpLoadInsuranceList.dto.PlantingUpLoadInsuranceListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * @description plantingUpLoadInsuranceListCore接口
 */
public interface PlantingUpLoadInsuranceListService {

    /**
     *@description 新增
     *@param
     */
    void save(PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode,String fCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PlantingUpLoadInsuranceListDto queryByPK(String inusreListCode,String fCode);

    /**
     *@description 按inusreListCode查询集合
     * @author: 王心洋
     * @date: 2017/10/24 17:11
     * @param plantingUpLoadInsuranceListDtoList
     */
    void modifyBylist(List<PlantingUpLoadInsuranceListDto> plantingUpLoadInsuranceListDtoList);

    /**
     *@description 按inusreListCode查询集合
     * @author: 王心洋
     * @date: 2017/10/24 17:11
     *@param
     */
    List<PlantingUpLoadInsuranceListDto> queryByInsureListCode(String inusreListCode);
    /**
     *@description 按insureListCode删除
     * @author: 王心洋
     * @date: 2017/10/24 17:11
     *@param inusreListcode
     */
    public void removeByInusreListcode(String inusreListcode);
}