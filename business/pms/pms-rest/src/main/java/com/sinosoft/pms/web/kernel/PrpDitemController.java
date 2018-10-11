package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDitemApi;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemDto;
import com.sinosoft.pms.core.kernel.service.PrpDitemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546
 * @description 标的项目代码表controller层
 */
@RestController
@RequestMapping(value = PrpDitemController.PATH)
public class PrpDitemController implements PrpDitemApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDitemController.class);

    @Autowired
    private PrpDitemService prpDitemService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDitemDto prpDitemDto) {
        prpDitemService.save(prpDitemDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestParam("riskCode") String riskCode,@RequestParam("itemCode") String itemCode) {
        prpDitemService.remove(riskCode,itemCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDitemDto prpDitemDto) {
        prpDitemService.modify(prpDitemDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpDitemDto queryByPK(String riskCode,String itemCode) {
        return prpDitemService.queryByPK(riskCode,itemCode);
    }
    /**
     * @description:（查询主险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpDitemDto> queryMainUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{
        return prpDitemService.queryMainUnderlyingTypeByCondition(prpDItemRequestParamsDto);
    }

    /**
     * @description:（查询附加险标的信息）
     * @author: 董坤
     * @date: 2017/10/14 9:35
     * @param prpDItemRequestParamsDto
     * @return List<PrpDItemDto>
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpDitemDto> querySubUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{
        return prpDitemService.querySubUnderlyingTypeByCondition(prpDItemRequestParamsDto);
    }

    /**
     * 根据险种查询prpditem表
     * @param  map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public @ResponseBody List<PrpDitemDto> queryPrpDitemInfoDto(@RequestBody Map<String,String> map)throws Exception{
        return prpDitemService.queryPrpDitemInfoDto(map.get("riskCode"),map.get("kindCode"));
    }
    /**
     *  根据标的名称查询标的代码
     * @author: 田慧
     * @date: 2017/12/22 11:12
     * @param map 键为itemCName
     * @return itemCode的集合
     * @throws Exception
     */
    @Override
    public  List<String> queryItemCode(@RequestBody Map<String,String> map)throws Exception{
        String itemCName = map.get("itemCName");
        if (StringUtils.isEmpty(itemCName)){
            throw new DataVerifyException("标的名称不能为空!");
        }
        return prpDitemService.queryItemCode(itemCName);
    }

    /**
     * 根据险种代码和多个标的代码查询标的中文名称
     *
     * @param param riskCode-险种代码；itemCodes-标的代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Override
    public @ResponseBody
    Map<String, String> queryByItemCodes(@RequestBody Map<String, Object> param) {
        return prpDitemService.queryByItemCodes((String) param.get("riskCode"), (List<String>) param.get("itemCodes"));
    }

    /**
     * 根据险种代码查询对应的标的信息
     *
     * @param param riskCode-险种代码
     * @return 标的代码-标的名称
     * @author: 何伟东
     * @date: 2018/1/11 19:29
     */
    @Override
    public @ResponseBody
    List<PrpDitemDto> queryByRiskCode(@RequestBody Map<String, String> param) {
        return prpDitemService.queryByRiskCode(param.get("riskCode"));
    }
}
