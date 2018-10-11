package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31CpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31cpendorchgdetailApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = Planting31CpEndorChgDetailApi.PATH)
public interface Planting31CpEndorChgDetailApi {

    public static final String PATH = "planting31CpEndorChgDetail";



    @RequestMapping(value = "removePlantingCpEndorChgDetail",method = {RequestMethod.POST})
    public void removePlanting31CpEndorChgDetail(@RequestParam("inusreListCode") String inusreListCode)throws  Exception;

    @RequestMapping(value = "savePlantingCpEndorChgDetail",method = {RequestMethod.POST})
    public void savePlanting31CpEndorChgDetail(@RequestBody List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList)throws  Exception;

    @RequestMapping(value = "queryByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody
    List<Planting31CpEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String,String> map)throws Exception;

}