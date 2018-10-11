package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME,path = NyxPolicyListApi.PATH)
public interface NyxPolicyListApi {
    public static final String PATH="nyxPolicyList";
    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody
    List<NyxPolicyListDto> queryByInusreListCode(@RequestParam(value = "inusreListCode") String inusreListCode)throws Exception;

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 何伟东
     * @date: 2017/12/28 17:29
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    @ResponseBody List<NyxPolicyListDto> queryByPolicyNo(@RequestBody Map<String, String> prarm);
    /**
     * 根据保单号查询NyxPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return NyxPolicyListDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuranceListDtoByPolicyNo", method = RequestMethod.POST)
    @ResponseBody List<NyxPolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception;
}
