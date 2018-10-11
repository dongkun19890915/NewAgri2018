package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingPolicyListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingPolicyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PlantingPolicyListController.PATH)
public class PlantingPolicyListController implements PlantingPolicyListApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PlantingPolicyListController.class);

    @Autowired
    private PlantingPolicyListService plantingPolicyListService;

    /**
     * :（根据policyNo查询PlantingPolicyList集合）
     *
     * @param inusreListCode
     * @return List<PlantingPolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/08
     */
    @Override
    public List<PlantingPolicyListDto> queryByInusreListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        return plantingPolicyListService.queryByInusreListCode(inusreListCode);
    }

    /**
     * 根据policyNo查询PlantingPolicyList_OLDDto集合
     *
     * @param inusreListCode 清单号
     * @return List<PlantingPolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/09
     */
    @Override
    public List<PlantingPolicyListDto> queryOLDByInusreListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        return plantingPolicyListService.queryOLDByInusreListCode(inusreListCode);
    }

    /**
     * 根据 inusreListCode 查询 NyxPolicyListDto 集合
     *
     * @param inusreListCode 清单号
     * @return List<NyxPolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/09
     */
    @Override
    public List<NyxPolicyListDto> queryNyxByInsureListCode(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        return plantingPolicyListService.queryNyxByInsureListCode(inusreListCode);
    }

    /**
     * 根据 inusreListCode 查询 Planting31PolicyListDto 集合
     *
     * @param map inusreListCode 清单号
     * @return List<Planting31PolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/09
     */
    @Override
    public @ResponseBody List<Planting31PolicyListDto> queryPlanting31ByInsuereListCode(@RequestBody Map<String,String> map) throws Exception {
        String inusreListCode=map.get("inusreListCode");
        return plantingPolicyListService.queryPlanting31ByInsuereListCode(inusreListCode);
    }

    /**
     * 根据 inusreListCode 查询 Planting31PolicyListDto 集合
     *
     * @param inusreListCode 清单号
     * @return List<Planting31PolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/09
     */
    @Override
    public List<HerdPolicyListDto> queryHerdByInsureListCode(@RequestParam("inusreListCode")  String inusreListCode) throws Exception {
        return plantingPolicyListService.queryHerdByInsureListCode(inusreListCode);
    }

    /**
     * 根据 查询条件 查询 HerdPolicyListDto 集合
     *
     * @param endorseConditionDto
     * @return List<HerdPolicyListDto>
     * @author: 王心洋
     * @date: 2017/11/09
     */
    @Override
    public List<HerdPolicyListDto> queryHerdByConditions(@RequestBody EndorseConditionDto endorseConditionDto) throws Exception {
        return plantingPolicyListService.queryHerdByConditions(endorseConditionDto);
    }

    /**
     * 根据GIS清单号查询承保清单 种植险
     * @param gisInsureListCode
     * @return List<PlantingPolicyListDto>
     * @author: 汪强
     * @date: 2017/11/28
     */
    @Override
    public List<PlantingPolicyListDto> queryByGisInsureListCode(@RequestParam("gisInsureListCode") String gisInsureListCode) throws Exception {
        return plantingPolicyListService.queryByGisInsureListCode(gisInsureListCode);
    }

    /**
     * :（根据inusreListCode查询PlantingInsuranceList）
     *
     * @param map policyNo
     * @return List<PlantingInsuranceListDto>
     * @author: 潘峰
     * @date: 2017/12/11
     */
    @Override
    public List<PlantingPolicyListDto> queryPlantingPolicyListByPolicyNO(@RequestBody Map<String, String> map) throws Exception {
        String policyNo = map.get("policyNo");
        return plantingPolicyListService.queryByInsureMainListByPolicyNO(policyNo);
    }

    @Override
    public @ResponseBody List<PlantingPolicyListDto> queryPlantingPolicyListByInsureListCode(@RequestParam(value = "insureListCode") String insureListCode) throws Exception {
        return plantingPolicyListService.findPlantingPolicyListByInsureListCode(insureListCode);
    }
}
