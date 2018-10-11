package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = HerdPolicyListApi.PATH)
public interface HerdPolicyListApi {
    public static final String PATH = "herdPolicyList";

    /**
     * 按照fCardId,inusreListCode查询查询结果集
     *@param fIdCard 农户身份证
     *@param inusreListCode 投保清单编号
     *@return List<HerdPolicyListDto> HerdPolicyList结果集合
     * @author 王心洋
     * @time 2017-11-17
     */
    @RequestMapping(value = "queryByfIdCardAndInusreListCode",method = {RequestMethod.POST})
    List<HerdPolicyListDto> queryByfIdCardAndInusreListCode(@RequestParam("fIdCard") String fIdCard,@RequestParam("inusreListCode") String inusreListCode);
    /**
    *
    * @param inusreListCode
    * @return java.util.List<com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto>
    * @throws Exception
    * @author 李冬松
    * @date 10:33 2017/11/22
    */
    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody List<HerdPolicyListDto> queryByInusreListCode(@RequestParam(value = "inusreListCode") String inusreListCode)throws Exception;

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 龚翔
     * @date: 2018/02/26 15:34
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    @ResponseBody List<HerdPolicyListDto> queryByPolicyNo(@RequestBody Map<String, String> prarm)throws Exception;
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @RequestMapping(value = "queryByInusreListCodeAndFcode",method = {RequestMethod.POST})
    @ResponseBody HerdPolicyListDto queryByInusreListCodeAndFcode(@RequestParam (value="inusreListCode")String inusreListCode,@RequestParam (value="fCode")String fCode  )throws Exception;

    /**
     * 根据保单号查询HerdPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return HerdPolicyList集合
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuranceListDtoByPolicyNo", method = RequestMethod.POST)
    @ResponseBody List<HerdPolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception;
}
