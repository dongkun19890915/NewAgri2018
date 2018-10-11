package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.PlantingLossRateListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.PlantingLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.service.PlantingLossRateListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 01:34:50.838 
 * @description 定损清单信息表controller层
 */
@RestController
@RequestMapping(value = PlantingLossRateListController.PATH)
public class PlantingLossRateListController implements PlantingLossRateListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingLossRateListController.class);

    @Autowired
    private PlantingLossRateListService plantingLossRateListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PlantingLossRateListDto plantingLossRateListDto) {
        plantingLossRateListService.save(plantingLossRateListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        plantingLossRateListService.remove(listNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PlantingLossRateListDto plantingLossRateListDto) {
        plantingLossRateListService.modify(plantingLossRateListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingLossRateListDto queryByPK(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        return plantingLossRateListService.queryByPK(listNo,serialNo);
    }

    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareInsurance(@RequestBody Map<String, String> map){
        String listNo = map.get("listNo");
        String registNo = map.get("registNo");
        plantingLossRateListService.compareInsurance(listNo, registNo);
    }

    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<PlantingLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<PlantingLossRateListDto> queryComparable(@RequestBody Map<String, String> map) {
        String policyNo = map.get("policyNo");
        String registNo = map.get("registNo");
        return plantingLossRateListService.queryComparable(policyNo,registNo);
    }
    /**
     * 保存损失率清单 种植险
     * @author 汪强
     * @date 2017-11-29
     * @param plantingLossRateListDtoList
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,String> savePlantingLossRateList(@RequestBody List<PlantingLossRateListDto> plantingLossRateListDtoList)throws Exception{
        plantingLossRateListService.savePlantingLossRateList(plantingLossRateListDtoList);

        Map<String,String> map=new HashMap<String,String>();
        map.put("msg","保存成功");
        return map;
    }

    /**
     * 查询种植险定损清单
     * @author: 祁小龙
     * @date: 2017/12/29 20:11
     * @param map 报案号
     * @return 定损清单集合
     * @throws Exception
     */
     @Override
    public @ResponseBody List<PlantingLossRateListDto> queryPlantingLossRateListByRegistNo(@RequestBody Map<String,String> map) throws Exception{
         String registNo = map.get("registNo");
        return this.plantingLossRateListService.queryPlantingLossRateListByRegistNo(registNo);
     }
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */

    @Override
    public @ResponseBody
    PageInfo<PlantingLossRateListDto> queryPlantingLossRateListByListNo(@RequestBody Map<String, String> map)
            throws Exception {
        return plantingLossRateListService.queryPlantingLossRateListByListNo(map);


    }

}
