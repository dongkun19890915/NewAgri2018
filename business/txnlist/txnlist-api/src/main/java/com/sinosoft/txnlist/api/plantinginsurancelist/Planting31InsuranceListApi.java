package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.Planting31InsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = Planting31InsuranceListApi.PATH)
public interface Planting31InsuranceListApi {

    public static final String PATH = "planting31InsuranceList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(Planting31InsuranceListDto planting31InsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(Planting31InsuranceListDto planting31InsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody Planting31InsuranceListDto queryByPK(@RequestBody Map<String,String> map);

    /**
     * @description:（根据inusreListCode查询Planting31InsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:58
     * @param map 中的inusreListCode为清单编号
     * @return List<Planting31InsuranceListDto>
     */
    @RequestMapping(value ="queryByInusreListCode",method = {RequestMethod.POST})
    @ResponseBody List<Planting31InsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map);
}