package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * @description 定损清单信息表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingLossRateListApi.PATH)
public interface PlantingLossRateListApi {

    public static final String PATH = "plantingLossRateList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PlantingLossRateListDto plantingLossRateListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PlantingLossRateListDto plantingLossRateListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PlantingLossRateListDto queryByPK(Map<String,String> map);

    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "compareInsurance",method = {RequestMethod.POST})
    void compareInsurance(Map<String,String> map);

    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<PlantingLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @RequestMapping(value = "queryComparable",method = {RequestMethod.POST})
    List<PlantingLossRateListDto> queryComparable(Map<String,String> map);

//    /**
//     * 保存损失率清单 种植险
//     * @author 汪强
//     * @date 2017-11-29
//     * @param plantingLossRateListDtoList
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "savePlantingLossRateList",method = {RequestMethod.POST})
//    @ResponseBody
//    Map<String,String> savePlantingLossRateList(@RequestBody List<PlantingLossRateListDto> plantingLossRateListDtoList)throws Exception;

    /**
     * 查询种植险定损清单
     * @author: 祁小龙
     * @date: 2017/12/29 20:11
     * @param map 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPlantingLossRateListByRegistNo",method = {RequestMethod.POST})
    public @ResponseBody List<PlantingLossRateListDto> queryPlantingLossRateListByRegistNo(@RequestBody Map<String,String> map) throws Exception;


    /**
     * 保存损失率清单 种植险
     * @author  汪强
     * @date 2017-11-29
     * @param plantingLossRateListDtoList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "savePlantingLossRateList",method = {RequestMethod.POST})
    @ResponseBody
    Map<String,String> savePlantingLossRateList(@RequestBody List<PlantingLossRateListDto> plantingLossRateListDtoList)throws Exception;
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPlantingLossRateListByListNo",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<PlantingLossRateListDto> queryPlantingLossRateListByListNo(@RequestBody Map<String,String> map) throws Exception;


}