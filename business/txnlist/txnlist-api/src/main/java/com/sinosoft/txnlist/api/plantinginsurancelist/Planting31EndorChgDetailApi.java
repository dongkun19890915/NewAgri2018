package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31endorchgdetailApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = Planting31EndorChgDetailApi.PATH)
public interface Planting31EndorChgDetailApi {

    public static final String PATH = "planting31EndorChgDetail";



    @RequestMapping(value = "removePlanting31EndorChgDetail",method = {RequestMethod.POST})
    public void removePlanting31EndorChgDetail(@RequestParam("endorseNo") String endorseNo)throws Exception;

    @RequestMapping(value = "savePlanting31EndorChgDetail",method = {RequestMethod.POST})
    public void savePlanting31EndorChgDetail(@RequestBody List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList)throws Exception;
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @RequestMapping(value = "queryByEndorseNoList",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,List<Planting31EndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList);

    /**
     * 根据批单号码查询planting31的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return List<Planting31EndorChgDetailDto>
     * @date: 2018/4/13 17:25
     * @author: 何伟东
     */
    @RequestMapping(value = "queryByEndorseNo", method = {RequestMethod.POST})
    @ResponseBody
    List<Planting31EndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String,String> param);
}