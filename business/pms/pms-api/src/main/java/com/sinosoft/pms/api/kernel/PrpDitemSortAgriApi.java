package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDitemSortAgriDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME,path = PrpDitemSortAgriApi.PATH)
public interface PrpDitemSortAgriApi {
    public static final String PATH="prpditemsortagri";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public PrpDitemSortAgriDto queryByPk(@RequestBody Map<String,String> map) throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDitemSortAgriDto prpDitemSortAgriDto) throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,String > map)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDitemSortAgriDto prpDitemSortAgriDto)throws Exception;
}
