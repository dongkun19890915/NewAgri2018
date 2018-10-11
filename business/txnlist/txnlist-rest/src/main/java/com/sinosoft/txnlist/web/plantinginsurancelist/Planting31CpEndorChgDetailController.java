package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31CpEndorChgDetailApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31CpEndorChgDetailService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31CpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description planting31cpendorchgdetailcontroller层
 */
@RestController
@RequestMapping(value = Planting31CpEndorChgDetailController.PATH)
public class Planting31CpEndorChgDetailController implements Planting31CpEndorChgDetailApi {

    private static Logger LOGGER = LoggerFactory.getLogger(Planting31CpEndorChgDetailController.class);

    @Autowired
    private Planting31CpEndorChgDetailService planting31CpEndorChgDetailService;




    @Override
    public void removePlanting31CpEndorChgDetail(@RequestParam("inusreListCode") String inusreListCode)throws  Exception{
        this.planting31CpEndorChgDetailService.removePlanting31CpEndorChgDetail(inusreListCode);
    }

    @Override
    public void savePlanting31CpEndorChgDetail(@RequestBody List<Planting31CpEndorChgDetailDto> planting31CpEndorChgDetailDtoList)throws  Exception{
        this.planting31CpEndorChgDetailService.savePlanting31CpEndorChgDetail(planting31CpEndorChgDetailDtoList);
    }

    @Override
    public List<Planting31CpEndorChgDetailDto> queryByInsureListCode(Map<String, String> map) throws Exception {
        return null;
    }
}
