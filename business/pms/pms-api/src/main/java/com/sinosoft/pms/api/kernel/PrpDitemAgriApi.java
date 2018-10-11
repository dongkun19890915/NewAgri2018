package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME,path =PrpDitemAgriApi.PATH )
public interface PrpDitemAgriApi {
    public static final String PATH ="prpditemagri";

    @RequestMapping(value = "queryByPk",method = RequestMethod.POST)
    public @ResponseBody PrpDitemAgriDto queryByPk(@RequestBody Map<String,String> map) throws Exception;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(@RequestBody PrpDitemAgriDto prpDitemAgriDto) throws Exception;

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public void delete(@RequestBody Map<String,String > map)throws Exception;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody PrpDitemAgriDto prpDitemAgriDto)throws Exception;

    /**
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @RequestMapping(value = "queryMainUnderlyingType",method = {RequestMethod.POST})
    @ResponseBody
    List<PrpDitemAgriDto> queryMainUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;
    /**
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @RequestMapping(value = "querySubUnderlyingType",method = {RequestMethod.POST})
    @ResponseBody List<PrpDitemAgriDto> querySubUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception;

    /**
     * 根据险种查询prpditem表
     * @param  map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    @RequestMapping(value = "queryPrpDitemInfoDto",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDitemAgriDto> queryPrpDitemInfoDto(@RequestBody Map<String,String> map)throws Exception;

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
     * * 根据险种代码和标的代码查询标的名称
     * @author: 田慧
     * @date: 15:29
     * @param queryItemCodePmsDto 险种代码和标的代码
     * @return itemNameList 标的名称集合
     * @throws Exception
     */
    @RequestMapping(value = "queryItemName",method = {RequestMethod.POST})
    List<PrpDitemAgriDto> queryItemName(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto)throws Exception;

    /**
     * 根据险种查询prpditem表
     *
     * @param map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    @RequestMapping(value = "queryPrpDitemDto", method = {RequestMethod.POST})
    public @ResponseBody
    Map<String, String> queryPrpDitemDto(@RequestBody Map<String, String> map) throws Exception;
}
