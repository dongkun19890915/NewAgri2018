package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingSettleListDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.ValidityAndPKDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description plantingsettlelistApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingSettleListApi.PATH)
public interface PlantingSettleListApi {

    public static final String PATH = "plantingSettleList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PlantingSettleListDto plantingSettleListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("settleListCode") String settleListCode,@RequestParam("fCode") String fCode,
                @RequestParam("kindCode") String kindCode,@RequestParam("classCode") String classCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PlantingSettleListDto plantingSettleListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PlantingSettleListDto queryByPK(@RequestParam("settleListCode") String settleListCode,@RequestParam("fCode")String fCode,
                                    @RequestParam("kindCode")String kindCode,@RequestParam("classCode")String classCode);
    /**
     * @author 马俊玲
     *@description 查询实体
     *@param
     */
    @RequestMapping(value = "queryBySettlelistCodeAndValidity",method = {RequestMethod.POST})
    List<PlantingSettleListDto> queryBySettlelistCodeAndValidity(@RequestBody ValidityAndPKDto validityAndPKDto);
}