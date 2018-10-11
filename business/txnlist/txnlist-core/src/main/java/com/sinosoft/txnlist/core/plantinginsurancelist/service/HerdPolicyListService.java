package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface HerdPolicyListService {

    /**
     * 按照fCardId,inusreListCode查询查询结果集
     *@param fIdCard 农户身份证
     *@param inusreListCode 投保清单编号
     *@return List<HerdPolicyListDto> HerdPolicyList结果集合
     * @author 王心洋
     * @time 2017-11-17
     */
    public List<HerdPolicyListDto> queryByfIdCardAndInusreListCode(String fIdCard, String inusreListCode);
    /**
    *
    * @param insureListCode
    * @return java.util.List<com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto>
    * @throws Exception
    * @author 李冬松
    * @date 10:36 2017/11/22
    */
    public List<HerdPolicyListDto> queryByInsureListCode(String insureListCode)throws Exception;

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param policyNo 保单号码
     * @return 承保分户清单数据
     * @author: 龚翔
     * @date: 2017/02/26 17:29
     */
    List<HerdPolicyListDto> queryByPolicyNo(String policyNo)throws Exception;
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @ResponseBody
    HerdPolicyListDto queryByInusreListCodeAndFcode(String inusreListCode,String fCode  )throws Exception;

    /**
     * 根据保单号查询HerdPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param policyNo 为保单号
     * @return HerdPolicyListDto集合
     * @throws Exception
     */
    List<HerdPolicyListDto> queryInsuranceListDtoByPolicyNo(String policyNo);
}
