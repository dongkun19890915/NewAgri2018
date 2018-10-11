package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDvoucherConfigDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME,path = PrpDvoucherConfigApi.PATH)
public interface PrpDvoucherConfigApi {
    public static final String PATH="prpdvoucherconfig";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public PrpDvoucherConfigDto queryByPk(@RequestBody Map<String,String> map)throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDvoucherConfigDto prpDvoucherConfigDto )throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDvoucherConfigDto prpDvoucherConfigDto)throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,String> map)throws Exception;
}
