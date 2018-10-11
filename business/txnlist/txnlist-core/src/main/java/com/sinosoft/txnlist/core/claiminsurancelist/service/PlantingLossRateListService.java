package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * @description 定损清单信息表Core接口
 */
public interface PlantingLossRateListService {

    /**
     *@description 新增
     *@param
     */
    void save(PlantingLossRateListDto plantingLossRateListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo,String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PlantingLossRateListDto plantingLossRateListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PlantingLossRateListDto queryByPK(String listNo,String serialNo);
    /**
     * 关联报案号和清单信息
     * @param listNo 损失率清单号
     * @param registNo 报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    void compareInsurance(String listNo, String registNo);

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param registNo 报案号
     * @return List<PlantingLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    List<PlantingLossRateListDto> queryComparable(String policyNo, String registNo);



    /**
     * 保存损失率清单 种植险
     * @author 汪强
     * @date 2017-11-29
     * @param plantingLossRateListDtoList
     * @throws Exception
     */
    void savePlantingLossRateList(List<PlantingLossRateListDto> plantingLossRateListDtoList)throws Exception;

    /**
     * 查询种植险定损清单
     * @author: 祁小龙
     * @date: 2017/12/29 20:11
     * @param registNo 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    List<PlantingLossRateListDto> queryPlantingLossRateListByRegistNo(String registNo) throws Exception;
    /**
     * 根据定损清单号查询种植险定损清单
     *
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */

    PageInfo<PlantingLossRateListDto> queryPlantingLossRateListByListNo(Map<String, String> map) throws Exception;
}