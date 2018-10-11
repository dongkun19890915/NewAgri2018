package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingEndorChgDetailApi.PATH)
public interface PlantingEndorChgDetailApi {
    public static final String PATH = "plantingEndorChgDetail";

    @RequestMapping(value = "removeInsureList",method = {RequestMethod.POST})
    public void removeInsureList(@RequestParam("endorseNo") String endorseNo)throws Exception;

    @RequestMapping(value = "savePlantingEndorChgDetail",method = {RequestMethod.POST})
    public void savePlantingEndorChgDetail(@RequestBody List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList)throws Exception;

    /**
     * 根据多个批单号查询相应费用类型的结算金额
     *
     * @param param column-费用类型，endoseNos-多个批单号
     * @return 批单号-结算金额键值对
     * @author: 何伟东
     * @date: 2018/1/17 10:51
     */
    @RequestMapping(value = "queryChgPremium", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, Double> queryChgPremium(@RequestBody Map<String, Object> param);


    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    @RequestMapping(value = "queryByEndorseNo", method = {RequestMethod.POST})
    @ResponseBody
    List<PlantingEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param);
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @RequestMapping(value = "queryByEndorseNoList", method = {RequestMethod.POST})
    @ResponseBody Map<String,List<PlantingEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList);
}
