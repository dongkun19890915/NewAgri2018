package com.sinosoft.txnlist.api.plantingUpLoadInsuranceList;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantingUpLoadInsuranceList.dto.PlantingUpLoadInsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * @description plantingUpLoadInsuranceListApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingUpLoadInsuranceListApi.PATH)
public interface PlantingUpLoadInsuranceListApi {

    public static final String PATH = "plantingUpLoadInsuranceList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("inusreListCode") String inusreListCode,@RequestParam("fCode") String fCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PlantingUpLoadInsuranceListDto queryByPK(@RequestParam("inusreListCode") String inusreListCode,@RequestParam("fCode")String fCode);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByInsureListCode",method = {RequestMethod.POST})
    List<PlantingUpLoadInsuranceListDto> queryByInsureListCode(@RequestParam("inusreListCode") String inusreListCode);
    /**
     *@description 按insureListCode删除
     * @author: 王心洋
     * @date: 2017/10/24 17:11
     *@param inusreListcode
     */
    @RequestMapping(value = "removeByInusreListcode",method = {RequestMethod.GET})
    public void removeByInusreListcode(@RequestParam("inusrelistcode") String inusreListcode);
}