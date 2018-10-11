package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.MiddleHerdInsuranceListDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口
 */
public interface MiddleHerdInsuranceListService {
    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListCode 清单编号
     */
    void removeByInusreListcode(String inusreListCode);

    /**
     * 批量保存清单信息
     * @author: 田健
     * @date: 2018/3/7 17:30
     * @param middleHerdInsuranceListDtoList 不带耳标号的清单信息，到农户
     */
    public void saveByList(List<MiddleHerdInsuranceListDto> middleHerdInsuranceListDtoList);
    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    void save(MiddleHerdInsuranceListDto middleHerdInsuranceListDto);

    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param inusreListCode 清单编号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     */
    void remove(String inusreListCode,String fCode,String kindCode);
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    void modify(MiddleHerdInsuranceListDto middleHerdInsuranceListDto);
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param inusreListCode 清单编号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     * @return 养殖险对象
     */
    MiddleHerdInsuranceListDto queryByPK(String inusreListCode,String fCode,String kindCode);

    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return 清单表信息集合
     */
    List<MiddleHerdInsuranceListDto> queryByInusreListCode(String inusreListCode);
}