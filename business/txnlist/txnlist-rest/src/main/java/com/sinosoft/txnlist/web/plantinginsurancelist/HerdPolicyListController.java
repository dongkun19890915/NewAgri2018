package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdPolicyListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdPolicyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = HerdPolicyListApi.PATH)
public class HerdPolicyListController implements HerdPolicyListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingInsuranceListController.class);

    @Autowired
    private HerdPolicyListService herdPolicyListService;
    /**
     * 按照fCardId,inusreListCode查询查询结果集
     *@param fIdCard 农户身份证
     *@param inusreListCode 投保清单编号
     *@return List<HerdPolicyListDto> HerdPolicyList结果集合
     * @author 王心洋
     * @time 2017-11-17
     */
    @Override
    public List<HerdPolicyListDto> queryByfIdCardAndInusreListCode(String fIdCard, String inusreListCode) {
        return herdPolicyListService.queryByfIdCardAndInusreListCode(fIdCard,inusreListCode);
    }

    @Override
    public @ResponseBody List<HerdPolicyListDto> queryByInusreListCode(String inusreListCode) throws Exception {

        return herdPolicyListService.queryByInsureListCode(inusreListCode);
    }
    /**
     * 根据保单号码查询承保清单数据
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 龚翔
     * @date: 2018/02/26 17:29
     */
    @Override
    public @ResponseBody List<HerdPolicyListDto> queryByPolicyNo(@RequestBody Map<String, String> prarm) throws Exception{
        return herdPolicyListService.queryByPolicyNo(prarm.get("policyNo"));
    }
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @Override
    public @ResponseBody HerdPolicyListDto queryByInusreListCodeAndFcode(String inusreListCode,String fCode  )throws Exception{
        return herdPolicyListService.queryByInusreListCodeAndFcode(inusreListCode,fCode);
    }
    /**
     * 根据保单号查询HerdPolicyList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return HerdPolicyList集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<HerdPolicyListDto> queryInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        return herdPolicyListService.queryInsuranceListDtoByPolicyNo(policyNo);
    }
}
