package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.Planting31InsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31InsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.Planting31InsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表controller层
 */
@RestController
@RequestMapping(value = Planting31InsuranceListController.PATH)
public class Planting31InsuranceListController implements Planting31InsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(Planting31InsuranceListController.class);

    @Autowired
    private Planting31InsuranceListService planting31InsuranceListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody Planting31InsuranceListDto planting31InsuranceListDto) {
        planting31InsuranceListService.save(planting31InsuranceListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        planting31InsuranceListService.remove(map.get("inusreListCode"),map.get("kindCode"),map.get("itemCode"),map.get("fIdCard"));
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody Planting31InsuranceListDto planting31InsuranceListDto) {
        planting31InsuranceListService.modify(planting31InsuranceListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public @ResponseBody Planting31InsuranceListDto queryByPK(@RequestBody Map<String,String> map) {
        return planting31InsuranceListService.queryByPK(map.get("inusreListCode"),map.get("kindCode"),map.get("itemCode"),map.get("fIdCard"));
    }

    /**
     * @description:（根据inusreListCode查询Planting31InsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:58
     * @param map 中的inusreListCode为清单编号
     * @return List<Planting31InsuranceListDto>
     */
    public @ResponseBody List<Planting31InsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map){
        return planting31InsuranceListService.queryByInusreListCode(map.get("inusreListCode"));
    }
}
