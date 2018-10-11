package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31EndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31EndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31EndorChgDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31endorchgdetailcontroller层
 */
@RestController
@RequestMapping(value = Planting31EndorChgDetailController.PATH)
public class Planting31EndorChgDetailController implements Planting31EndorChgDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(Planting31EndorChgDetailController.class);

    @Autowired
    private Planting31EndorChgDetailService planting31EndorChgDetailService;



    public void removePlanting31EndorChgDetail(@RequestParam("endorseNo") String endorseNo)throws Exception{
        planting31EndorChgDetailService.removePlanting31EndorChgDetail(endorseNo);
    }

    @Override
    public void savePlanting31EndorChgDetail(@RequestBody List<Planting31EndorChgDetailDto> planting31EndorChgDetailDtoList)throws Exception{
        planting31EndorChgDetailService.savePlanting31EndorChgDetail(planting31EndorChgDetailDtoList);
    }
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public @ResponseBody Map<String,List<Planting31EndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList){
        return planting31EndorChgDetailService.queryByEndorseNoList(endorseNoList);
    }

    /**
     * 根据批单号码查询planting31的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return List<Planting31EndorChgDetailDto>
     * @date: 2018/4/13 17:25
     * @author: 何伟东
     */
    @Override
    public @ResponseBody
    List<Planting31EndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String,String> param) {
        return planting31EndorChgDetailService.queryByEndorseNo(param.get("endorseNo"));
    }
}
