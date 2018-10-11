package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546
 * @description 标的项目代码表Api接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDitemApi.PATH)
public interface PrpDitemApi {

    String PATH = "prpDitem";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDitemDto prpDitemDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("riskCode") String riskCode, @RequestParam("itemCode") String itemCode);

    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDitemDto prpDitemDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDitemDto queryByPK(@RequestParam("riskCode") String riskCode, @RequestParam("itemCode") String itemCode);
    /**
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @RequestMapping(value = "queryMainUnderlyingType",method = {RequestMethod.POST})
    @ResponseBody List<PrpDitemDto> queryMainUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;
    /**
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @RequestMapping(value = "querySubUnderlyingType",method = {RequestMethod.POST})
    @ResponseBody List<PrpDitemDto> querySubUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;

    /**
     * 根据险种查询prpditem表
     * @param  map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    @RequestMapping(value = "queryPrpDitemInfoDto",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDitemDto> queryPrpDitemInfoDto(@RequestBody Map<String,String> map)throws Exception;

    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param map 键为itemCName
     * @return itemCode的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryItemCode",method = {RequestMethod.POST})
    List<String> queryItemCode(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据险种代码和多个标的代码查询标的中文名称
     *
     * @param param riskCode-险种代码；itemCode标的代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @RequestMapping(value = "queryByItemCodes", method = {RequestMethod.POST})
    @ResponseBody
    Map<String, String> queryByItemCodes(@RequestBody Map<String, Object> param);

    /**
     * 根据险种代码查询对应的标的信息
     *
     * @param param riskCode-险种代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @RequestMapping(value = "queryByRiskCode", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDitemDto> queryByRiskCode(@RequestBody Map<String, String> param);
}