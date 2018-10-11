package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.PrpDprovinceConfigApi;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import com.sinosoft.dms.core.dict.service.PrpDprovinceConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447
 * @description 币别代码表controller层
 */
@RestController
@RequestMapping(value = PrpDprovinceConfigController.PATH)
public class PrpDprovinceConfigController implements PrpDprovinceConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDprovinceConfigController.class);

    @Autowired
    private PrpDprovinceConfigService prpDprovinceConfigService;

    /**
     * 新增
     *@param
     */
    @Override
    public void save(@RequestBody PrpDprovinceConfigDto prpDprovinceConfigDto) {
        prpDprovinceConfigService.save(prpDprovinceConfigDto);
    }

    /**
     * 删除
     *@param
     */
    @Override
    public void remove(@RequestParam(value = "comCode") String comCode, @RequestParam(value = "riskCode") String riskCode) {
        prpDprovinceConfigService.remove(comCode, riskCode);
    }

    /**
     * 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDprovinceConfigDto prpDprovinceConfigDto) {
        prpDprovinceConfigService.modify(prpDprovinceConfigDto);
    }

    /**
     * 按主键查询实体
     *@param
     */
    @Override
    public @ResponseBody PrpDprovinceConfigDto queryByPK(@RequestParam(value = "comCode") String comCode, @RequestParam(value = "riskCode") String riskCode) {
        PrpDprovinceConfigDto prpDprovinceConfigDto = prpDprovinceConfigService.queryByPK(comCode, riskCode);
        return prpDprovinceConfigDto;
    }
}
