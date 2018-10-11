package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;

import java.util.List;
import java.util.Map;

/**
 * *查询投保清单
 * @Author: 田慧
 * @Date: 2017/12/11 16:11
 */
public interface NyxInsuranceListService {
    /**
     * 批量保存清单表信息
     * @author: 田健
     * @date: 2017/12/20 17:01
     * @param nyxInsuranceListDtos 清单信息集合
     */

    public void saveByList (List<NyxInsuranceListDto> nyxInsuranceListDtos) throws Exception;
    /**
     * （根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param inusreListCode
     * @return nyxInsuranceListDto 返回各项补贴金额
     */
    public NyxInsuranceListDto getSumFee(String inusreListCode);

    /**
     * @param inusreListcode
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:54
     */
    void removeByInusreListcode(String inusreListcode);
    /**
     *  根据条件查询投保清单中农户户次
     * @author: 田慧
     * @date: 2017/12/11 19:33
     * @param inusrelistCode 投保清单编号
     * @return 返回FIdCard的总条数
     * @throws Exception
     */
    public Map<String,Long> queryFIdCardByInusrelistCode(String inusrelistCode)throws Exception;

    /**
     * 根据条件查询投保清单中总户数
     * @author: 田慧
     * @date: 2017/12/11 20:00
     * @param inusreListCode 投保清单编号
     * @return 返回areaNumber总数
     * @throws Exception
     */
    public Map<String,Double> queryAreaNumberByInusrelistCode(String inusreListCode) throws Exception;
    /**
     * 根据清单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param inusreListCode 清单编号
     * @return 清单表信息集合
     */
    public List<NyxInsuranceListDto> queryByInusreListCode(String inusreListCode);

    /**
     * 根据保单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return NyxInsuranceListDto集合
     * @throws Exception
     */
    List<NyxInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(String policyNo);
}
