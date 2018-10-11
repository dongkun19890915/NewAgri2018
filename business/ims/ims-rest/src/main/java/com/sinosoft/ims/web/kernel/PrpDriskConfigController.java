package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDriskConfigApi;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import com.sinosoft.ims.core.kernel.service.PrpDriskConfigService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDriskConfigcontroller层
 */
@RestController
@RequestMapping(value = PrpDriskConfigController.PATH)
public class PrpDriskConfigController implements PrpDriskConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskConfigController.class);

    @Autowired
    private PrpDriskConfigService prpDriskConfigService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDriskConfigDto prpDriskConfigDto) {
        prpDriskConfigService.save(prpDriskConfigDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("comCode") String comCode,@RequestParam("riskCode") String riskCode,@RequestParam("configCode")  String configCode) {
        prpDriskConfigService.remove(comCode,riskCode,configCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDriskConfigDto prpDriskConfigDto) {
        prpDriskConfigService.modify(prpDriskConfigDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDriskConfigDto queryByPK(@RequestParam("comCode") String comCode,@RequestParam("riskCode") String riskCode,@RequestParam("configCode")  String configCode) {
        return prpDriskConfigService.queryByPK(comCode,riskCode,configCode);
    }
    @Override
    @ResponseBody
    public PrpDriskConfigDto getConfig(String comCode, String riskCode, String configCode) throws Exception {
        return prpDriskConfigService.queryByPK(comCode, riskCode, configCode);
    }

    @Override
    public String getConfigValue(String comCode, String riskCode, String configCode) throws Exception {
        PrpDriskConfigDto prpDriskConfigDto = prpDriskConfigService.queryByPK(comCode, riskCode, configCode);
        if(prpDriskConfigDto == null){
            return null;
        }
        return prpDriskConfigDto.getConfigValue();
    }


    @Override
    @ResponseBody
    public List<PrpDriskConfigDto> getConfigSenior(@RequestBody PrpDriskConfigDto requestPrpDriskConfigDto) throws Exception {
        return prpDriskConfigService.query(requestPrpDriskConfigDto);
    }
}
