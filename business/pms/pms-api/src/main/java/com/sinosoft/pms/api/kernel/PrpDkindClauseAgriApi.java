package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseAgriDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@RequestMapping(name = PMSConstant.PMS_SERVICE_NAME,path =PrpDkindClauseAgriApi.PATH )
public interface PrpDkindClauseAgriApi {

    public static String PATH="prpDkindClauseAgri";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public PrpDkindClauseAgriDto queryByPk(@RequestBody Map<String,String> map) throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDkindClauseAgriDto prpDkindClauseAgriDto)throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,String> map)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDkindClauseAgriDto prpDkindClauseAgriDto)throws Exception;

}
