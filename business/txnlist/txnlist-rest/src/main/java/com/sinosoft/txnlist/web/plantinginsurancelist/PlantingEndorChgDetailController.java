package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingEndorChgDetailApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingEndorChgDetailDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingEndorChgDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PlantingEndorChgDetailController.PATH)
public class PlantingEndorChgDetailController implements PlantingEndorChgDetailApi{
    @Autowired
    private PlantingEndorChgDetailService plantingEndorChgDetailService;

    public void removeInsureList(@RequestParam("endorseNo") String endorseNo)throws Exception{
        plantingEndorChgDetailService.removeInsureList(endorseNo);
    }

    @Override
    public void savePlantingEndorChgDetail(@RequestBody List<PlantingEndorChgDetailDto> plantingEndorChgDetailDtoList)throws Exception{
        plantingEndorChgDetailService.savePlantingEndorChgDetail(plantingEndorChgDetailDtoList);
    }

    /**
     * 根据多个批单号查询相应费用类型的结算金额
     *
     * @param param column-费用类型，endoseNos-多个批单号
     * @return 批单号-结算金额键值对
     * @author: 何伟东
     * @date: 2018/1/17 10:51
     */
    @Override
    public @ResponseBody
    Map<String, Double> queryChgPremium(@RequestBody Map<String, Object> param) {
        String column = (String) param.get("column");
        List<String> endorseNos = (List<String>) param.get("endorseNos");
        return plantingEndorChgDetailService.queryChgPremium(column, endorseNos);
    }

    /**
     * 根据批单号码查询planting的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return 分户清单批改变化量信息
     * @author: 何伟东
     * @date: 2018/1/19 9:41
     */
    @Override
    public @ResponseBody
    List<PlantingEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param) {
        return plantingEndorChgDetailService.queryByEndorseNo(param.get("endorseNo"));
    }

    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    public @ResponseBody Map<String,List<PlantingEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList){
        return plantingEndorChgDetailService.queryByEndorseNoList(endorseNoList);
    }
}
