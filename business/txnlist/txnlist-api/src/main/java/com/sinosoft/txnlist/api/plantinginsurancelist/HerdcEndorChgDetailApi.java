package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdcEndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-14 07:07:05.012
 * @description 养殖险保单清单最新数据表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = HerdcEndorChgDetailApi.PATH)
public interface HerdcEndorChgDetailApi {
    public static final String PATH = "herdcEndorChgDetail";

    @RequestMapping(value = "removeByInsureListCode",method = {RequestMethod.POST})
    public void removeByInsureListCode(@RequestParam(value = "insureListCode") String insureListCode)throws Exception;

    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public void save(@RequestBody List<HerdcEndorChgDetailDto> herdcEndorChgDetailDtoList)throws Exception;

    @RequestMapping(value = "queryByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<HerdcEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String,String> map)throws Exception;

}
