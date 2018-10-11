package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME,path = Planting31PolicyListApi.PATH)
public interface Planting31PolicyListApi {
    public static final String PATH="Planting31PolicyList";

    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody
    List<Planting31PolicyListDto> queryByInusreListCode(@RequestParam(value = "inusreListCode") String inusreListCode)throws Exception;

    /**
     * 根据保单号查询Planting31PolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return Planting31PolicyListDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuranceListDtoByPolicyNo", method = RequestMethod.POST)
    @ResponseBody List<Planting31PolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception;

}
