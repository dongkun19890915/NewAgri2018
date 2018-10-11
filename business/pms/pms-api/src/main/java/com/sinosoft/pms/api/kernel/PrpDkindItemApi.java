package com.sinosoft.pms.api.kernel;

import com.sinosoft.pms.api.PMSConstant;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDkindItemDto;
import com.sinosoft.pms.api.kernel.dto.QueryItemCodePmsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindItemApi接口
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = PrpDkindItemApi.PATH)
public interface PrpDkindItemApi {

    String PATH = "prpDkindItem";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDkindItemDto prpDkindItemDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("riskCode") String riskCode, @RequestParam("kindCode") String kindCode, @RequestParam("itemCode") String itemCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDkindItemDto prpDkindItemDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDkindItemDto queryByPK(@RequestParam("riskCode") String riskCode, @RequestParam("kindCode") String kindCode, @RequestParam("itemCode") String itemCode);

    /**
     * * 根据险种代码和险别代码查询标的代码
     * @author: 田慧
     * @date: 13:22
     * @return itemCodeList 标的代码集合
     */
    @RequestMapping(value = "queryItemCode",method = {RequestMethod.POST})
    List<String> queryItemCode(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto) throws Exception;

    /**
     * 根据险别和险种及标的代码查询险别标的关联表
     * @author: 刘曼曼
     * @date: 10:29 10:29
     * @param queryItemCodePmsDto 险种代码,险别代码，标的代码
     * @return List<PrpDkindItemDto> 询险别标的关联表集合
     */
    @RequestMapping(value = "queryFlag",method = {RequestMethod.POST})
    @ResponseBody List<PrpDkindItemDto> queryFlag(@RequestBody QueryItemCodePmsDto queryItemCodePmsDto)throws Exception;
}