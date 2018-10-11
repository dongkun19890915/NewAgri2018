package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import com.sinosoft.pms.api.kernel.dto.PrpDItemRequestParamsDto;
import com.sinosoft.pms.api.kernel.dto.PrpDitemAgriDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import com.sinosoft.pms.core.kernel.service.PrpDitemAgriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PrpDitemAgriApi.PATH)
public class PrpDitemAgriController implements PrpDitemAgriApi{
    @Autowired
    private PrpDitemAgriService prpDitemAgriService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody PrpDitemAgriDto queryByPk(@RequestBody Map<String, String> map) throws Exception {
        return prpDitemAgriService.queryByPK(map.get("riskCode"),map.get("itemCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(@RequestBody PrpDitemAgriDto prpDitemAgriDto) throws Exception {
        prpDitemAgriService.save(prpDitemAgriDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(@RequestBody Map<String, String> map) throws Exception {
        prpDitemAgriService.remove(map.get("riskCode"),map.get("itemCode"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(@RequestBody PrpDitemAgriDto prpDitemAgriDto) throws Exception {
        prpDitemAgriService.modify(prpDitemAgriDto);
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
    public @ResponseBody
    List<PrpDitemAgriDto> queryMainUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{
        return prpDitemAgriService.queryMainUnderlyingTypeByCondition(prpDItemRequestParamsDto);
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
    public @ResponseBody List<PrpDitemAgriDto> querySubUnderlyingType(@RequestBody PrpDItemRequestParamsDto prpDItemRequestParamsDto) throws Exception{
        return prpDitemAgriService.querySubUnderlyingTypeByCondition(prpDItemRequestParamsDto);
    }

    /**
     * 根据险种查询prpditem表
     * @param  map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    @Override
    public @ResponseBody List<PrpDitemAgriDto> queryPrpDitemInfoDto(@RequestBody Map<String,String> map)throws Exception{
        return prpDitemAgriService.queryPrpDitemInfoDto(map.get("riskCode"),map.get("kindCode"));
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
        return prpDitemAgriService.queryItemCode(itemCName);
    }
    /**
     * * 根据险种代码和标的代码查询标的名称
     * @author: 田慧
     * @date: 15:29
     * @param queryItemCodePmsDto 险种代码和标的代码
     * @return itemNameList 标的名称集合
     * @throws Exception
     */
    @Override
    public  List<PrpDitemAgriDto> queryItemName(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto)throws Exception{
        String riskCode = queryItemCodePmsDto.getRiskCode();
        List<String> itemCodeList = queryItemCodePmsDto.getItemCodeList();
        return prpDitemAgriService.queryItemName(riskCode,itemCodeList);
    }

    /**
     * 根据险种查询prpditem表
     *
     * @param map riskCode 险种代码
     * @return List<PrpDitem> 标的项目代码表信息
     */
    public @ResponseBody
    Map<String, String> queryPrpDitemDto(@RequestBody Map<String, String> map) throws Exception {
        return prpDitemAgriService.queryPrpDitemDto(map);
    }
}
