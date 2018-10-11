package com.sinosoft.txnlist.core.plantinginsurancelist.service;


import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Core接口
 */
public interface HerdInsuranceListService {
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:53
     * @param herdInsuranceListDtoList
     */
    public void saveByList(List<HerdInsuranceListDto> herdInsuranceListDtoList);
    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:54
     * @param inusreListcode
     */
    void removeByInusreListcode(String inusreListcode);
    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param herdInsuranceListDto 养殖险Dto
     */
    void save(HerdInsuranceListDto herdInsuranceListDto);

    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param inusreListCode 清单编号
     * @param earlAbel 耳标号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     */
    void remove(String inusreListCode, String earlAbel,String fCode,String kindCode);
    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param herdInsuranceListDto 养殖险Dto
     */
    void modify(HerdInsuranceListDto herdInsuranceListDto);
    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param inusreListCode 清单编号
     * @param earlAbel 耳标号
     * @param fCode 农户代码
     * @param kindCode 险别代码
     * @return 养殖险对象
     */
    HerdInsuranceListDto queryByPK(String inusreListCode, String earlAbel,String fCode,String kindCode);

    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return qing'dan'bioa
     */
    List<HerdInsuranceListDto> queryByInusreListCode(String inusreListCode);

    /**
     * 根据保单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return NyxInsuranceListDto集合
     * @throws Exception
     */
    List<HerdInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(String policyNo);

    /**
     * @author:
     * @date: 2018/5/22 下午 18:18
     */
    long countByInusreListCode(String inusreListCode);

}