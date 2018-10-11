package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31InsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Core接口
 */
public interface Planting31InsuranceListService {

    /**
     *@description 新增
     *@param
     */
    void save(Planting31InsuranceListDto planting31InsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String inusreListCode, String itemCode, String kindCode,String fIdCard);
    /**
     *@description 修改
     *@param
     */
    void modify(Planting31InsuranceListDto planting31InsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    Planting31InsuranceListDto queryByPK(String inusreListCode, String itemCode, String kindCode,String fIdCard);

    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListcode 清单编号
     */
    void removeByInusreListcode(String inusreListcode);
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:53
     * @param planting31InsuranceListDtoList 大棚蔬菜集合
     */
    public void saveByList(List<Planting31InsuranceListDto> planting31InsuranceListDtoList);
    /**
     * @description:（根据inusreListCode查询Planting31InsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:58
     * @param inusreListCode 为清单编号
     * @return List<Planting31InsuranceListDto>
     */
    public List<Planting31InsuranceListDto> queryByInusreListCode( String inusreListCode);

    }