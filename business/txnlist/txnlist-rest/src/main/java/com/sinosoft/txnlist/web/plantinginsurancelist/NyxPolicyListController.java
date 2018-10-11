package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxPolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxPolicyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = NyxPolicyListApi.PATH)
public class NyxPolicyListController implements NyxPolicyListApi{
    @Autowired
    private NyxPolicyListService nyxPolicyListService;
    public @ResponseBody
    List<NyxPolicyListDto> queryByInusreListCode(@RequestParam(value = "inusreListCode") String inusreListCode)throws Exception{
        return nyxPolicyListService.findByInusreListCode(inusreListCode);
    }

    /**
     * 根据保单号码查询承保清单数据
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 何伟东
     * @date: 2017/12/28 17:29
     */
    @Override
    public @ResponseBody List<NyxPolicyListDto> queryByPolicyNo(@RequestBody Map<String, String> prarm) {
        return nyxPolicyListService.queryByPolicyNo(prarm.get("policyNo"));
    }
    /**
     * 根据保单号查询NyxPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return NyxPolicyListDto集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<NyxPolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        return nyxPolicyListService.queryInsuranceListDtoByPolicyNo(policyNo);
    }
}
