package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178
 *  投保明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingPolicyListApi.PATH)
public interface PlantingPolicyListApi {

    public static final String PATH = "plantingPolicyList";
    /**
     * :（根据inusreListCode查询PlantingInsuranceList）
     * @author: 王心洋
     * @date: 2017/11/08
     * @param inusreListCode
     * @return List<PlantingInsuranceListDto>
     */
    @RequestMapping(value ="queryByPolicyNo",method = RequestMethod.POST)
    @ResponseBody List<PlantingPolicyListDto> queryByInusreListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception;
    /**
     * :（根据inusreListCode查询PlantingInsuranceList_OLD集合）
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<PlantingInsuranceListDto>
     */
    @RequestMapping(value ="queryOLDByPolicyNo",method = RequestMethod.POST)
    @ResponseBody List<PlantingPolicyListDto> queryOLDByInusreListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception;
    /**
     *  根据 inusreListCode 查询 NyxPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<NyxPolicyListDto>
     */
    @RequestMapping(value ="queryNyxByInsureListCode",method = RequestMethod.POST)
    @ResponseBody List<NyxPolicyListDto> queryNyxByInsureListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception;

    /**
     *  根据 inusreListCode 查询 Planting31PolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param map inusreListCode
     * @return List<Planting31PolicyListDto>
     */
    @RequestMapping(value ="queryPlanting31ByInsuereListCode",method = RequestMethod.POST)
    @ResponseBody List<Planting31PolicyListDto> queryPlanting31ByInsuereListCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     *  根据 inusreListCode 查询 HerdPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param inusreListCode
     * @return List<HerdPolicyListDto>
     */
    @RequestMapping(value ="queryHerdByInsureListCode",method = RequestMethod.POST)
    @ResponseBody List<HerdPolicyListDto> queryHerdByInsureListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception;

    /**
     *  根据 查询条件 查询 HerdPolicyListDto 集合
     * @author: 王心洋
     * @date: 2017/11/09
     * @param endorseConditionDto
     * @return List<HerdPolicyListDto>
     */
    @RequestMapping(value ="queryHerdByConditions",method = RequestMethod.POST)
    List<HerdPolicyListDto> queryHerdByConditions(EndorseConditionDto endorseConditionDto) throws Exception;

    @RequestMapping(value = "queryPlantingPolicyListByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<PlantingPolicyListDto> queryPlantingPolicyListByInsureListCode(@RequestParam(value = "insureListCode") String insureListCode)throws Exception;


    /**
     *  根据GIS清单号查询 承保清单 种植险
     * @author: 汪强
     * @date: 2017/11/28
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     */
    @RequestMapping(value ="queryByGisInsureListCode",method = RequestMethod.POST)
    @ResponseBody List<PlantingPolicyListDto> queryByGisInsureListCode(@RequestParam("gisInsureListCode") String gisInsureListCode) throws Exception;
    /**
     * :（根据inusreListCode查询PlantingInsuranceList）
     *
     * @param map policyNo
     * @return List<PlantingInsuranceListDto>
     * @author: 潘峰
     * @date: 2017/12/11
     */
    @RequestMapping(value = "queryPlantingPolicyListByPolicyNO", method = RequestMethod.POST)
    List<PlantingPolicyListDto> queryPlantingPolicyListByPolicyNO(@RequestBody Map<String, String> map) throws Exception;
}
