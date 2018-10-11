package com.sinosoft.ims.api.kernel;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.PrpDriskConfigDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * @description PrpDriskConfigApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = PrpDriskConfigApi.PATH)
public interface PrpDriskConfigApi {

    public static final String PATH = "prpDriskConfig";

    /**
     * @param
     * @description 新增
     */
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    void save(@RequestBody PrpDriskConfigDto prpDriskConfigDto);

    /**
     * @param
     * @description 删除
     */
    @RequestMapping(value = "remove", method = {RequestMethod.POST})
    void remove(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode);

    /**
     * @param
     * @description 修改
     */
    @RequestMapping(value = "modify", method = {RequestMethod.POST})
    void modify(@RequestBody PrpDriskConfigDto prpDriskConfigDto);

    /**
     * @param
     * @description 按主键查询实体
     */
    @RequestMapping(value = "queryByPK", method = {RequestMethod.POST})
    PrpDriskConfigDto queryByPK(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode);

    /**
     * 根据主键（机构代码、险种代码、配置类型）查询配置结果
     *
     * @param comCode
     * @param riskCode
     * @param configCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getconfig", method = RequestMethod.POST)
    @ResponseBody
    PrpDriskConfigDto getConfig(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode) throws Exception;

    /**
     * 根据自定义内容查询配置
     *
     * @param requestPrpDriskConfigDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getconfigsenior", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<PrpDriskConfigDto> getConfigSenior(@RequestBody PrpDriskConfigDto requestPrpDriskConfigDto) throws Exception;

    /**
     * 根据主键（机构代码、险种代码、配置类型）查询配置结果ConfigValue的值
     *
     * @param comCode
     * @param riskCode
     * @param configCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getconfigvalue", method = RequestMethod.POST)
    String getConfigValue(@RequestParam("comCode") String comCode, @RequestParam("riskCode") String riskCode, @RequestParam("configCode") String configCode) throws Exception;
}