package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpModelCoinsDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = DMSConstant.DMS_SERVICE_NAME,path =PrpModelCoinsDetailApi.PATH )
public interface PrpModelCoinsDetailApi {
    public static final String PATH="prpmodelcoinsdetail";

    @RequestMapping(value = "queryByPK",method = RequestMethod.POST)
    public PrpModelCoinsDetailDto queryByPk(@RequestBody Map<String,Object> map)throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpModelCoinsDetailDto prpModelCoinsDetailDto)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpModelCoinsDetailDto prpModelCoinsDetailDto)throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,Object> map)throws Exception;
}
