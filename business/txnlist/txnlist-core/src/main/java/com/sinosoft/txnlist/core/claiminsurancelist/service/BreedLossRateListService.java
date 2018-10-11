package com.sinosoft.txnlist.core.claiminsurancelist.service;


import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 06:26:52.496 
 * @description 养殖险定损清单信息表Core接口
 */
public interface BreedLossRateListService {

    /**
     *@description 新增
     *@param
     */
    void save(BreedLossRateListDto breedLossRateListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String listNo,String serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(BreedLossRateListDto breedLossRateListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    BreedLossRateListDto queryByPK(String listNo,String serialNo);
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
     * @return List<BreedLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    List<BreedLossRateListDto> queryComparable(String policyNo, String registNo);
    /**
     * 查询定损清单
     * @author: 孙朋飞
     * @date: 2017/12/29 20:11
     * @param registNo 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    public List<BreedLossRateListDto> queryBreedLossRateListByRegistNo(String registNo) throws Exception;
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    PageInfo<BreedLossRateListDto> queryBreedLossRateListDtoByListNo(Map<String, String> map)throws Exception;

    /**
     * 根据定损清单号删除养植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    Map<String, String> deleteBreedLossRateListByListNo(Map<String, String> map);
}