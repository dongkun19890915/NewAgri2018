package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDprovinceConfigDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-31 01:52:20.999 
 *  省级机构配置表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDprovinceConfigApi.PATH)
public interface PrpDprovinceConfigApi {

    public static final String PATH = "prpDprovinceConfig";

    /**
     * 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    public void save(@RequestBody PrpDprovinceConfigDto prpDprovinceConfigDto);

    /**
     * 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    public void remove(@RequestParam(value = "comCode") String comCode,@RequestParam(value = "riskCode") String riskCode);
    /**
     * 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    public void modify(@RequestBody PrpDprovinceConfigDto prpDprovinceConfigDto);
    /**
     * 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PrpDprovinceConfigDto queryByPK(@RequestParam(value = "comCode") String comCode, @RequestParam(value = "riskCode") String riskCode);
}