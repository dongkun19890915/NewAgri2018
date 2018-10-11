package com.sinosoft.txnlist.web.plantingUpLoadInsuranceList;

import com.sinosoft.txnlist.api.plantingUpLoadInsuranceList.PlantingUpLoadInsuranceListApi;
import com.sinosoft.txnlist.api.plantingUpLoadInsuranceList.dto.PlantingUpLoadInsuranceListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.service.PlantingUpLoadInsuranceListService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * @description plantingUpLoadInsuranceListcontroller层
 */
@RestController
@RequestMapping(value = PlantingUpLoadInsuranceListController.PATH)
public class PlantingUpLoadInsuranceListController implements PlantingUpLoadInsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingUpLoadInsuranceListController.class);

    @Autowired
    private PlantingUpLoadInsuranceListService plantingUpLoadInsuranceListService;


   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto) {
        plantingUpLoadInsuranceListService.save(plantingUpLoadInsuranceListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String inusreListCode,String fCode) {
        plantingUpLoadInsuranceListService.remove(inusreListCode,fCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PlantingUpLoadInsuranceListDto plantingUpLoadInsuranceListDto) {
        plantingUpLoadInsuranceListService.modify(plantingUpLoadInsuranceListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingUpLoadInsuranceListDto queryByPK(@RequestBody String inusreListCode,String fCode) {
        return plantingUpLoadInsuranceListService.queryByPK(inusreListCode,fCode);
    }

    /**
     *@description 按inusreListCode查询集合
     * @author 王心洋
     * @date: 2017/10/24 17:15
     * @param inusreListCode
     * @return
     */
    @Override
    public List<PlantingUpLoadInsuranceListDto> queryByInsureListCode(String inusreListCode) {
        return plantingUpLoadInsuranceListService.queryByInsureListCode(inusreListCode);
    }
    /**
     *@description 按inusreListCode删除数据
     * @author 王心洋
     * @date: 2017/10/24 17:15
     * @param inusreListCode
     * @return
     */
    @Override
    public void removeByInusreListcode(String inusreListCode) {
        plantingUpLoadInsuranceListService.removeByInusreListcode(inusreListCode);
    }
}
