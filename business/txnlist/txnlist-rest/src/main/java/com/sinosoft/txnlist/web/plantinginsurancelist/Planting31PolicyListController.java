package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31PolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31PolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31PolicyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = Planting31PolicyListApi.PATH)
public class Planting31PolicyListController implements Planting31PolicyListApi{
    @Autowired
    private Planting31PolicyListService planting31PolicyListService;
    @Override
    public @ResponseBody List<Planting31PolicyListDto> queryByInusreListCode(@RequestParam(value = "inusreListCode") String inusreListCode) throws Exception {
        return planting31PolicyListService.findByInusreListCode(inusreListCode);
    }
    /**
     * 根据保单号查询Planting31PolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return Planting31PolicyListDto集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<Planting31PolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        return planting31PolicyListService.queryInsuranceListDtoByPolicyNo(policyNo);
    }
}
