package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = InsuranceListApi.PATH)
public interface InsuranceListApi {

    public static final String PATH = "insuranceList";

    /**
     * @param
     * @description 传inusreListCode查询Planting31InsuranceList集合
     * 将Planting31InsuranceList集合的每一条entity保存到Planting31PolicyList和Planting31PolicyListOrigin
     * @author: 潘峰
     */
    @RequestMapping(value = "save31PlantingToPlanting", method = {RequestMethod.GET})
    public void save31PlantingToPlanting(@RequestParam("inusreListCode") String inusreListCode) throws Exception;


    /**
     * @param
     * @description 传inusreListCode查询 NyxInsuranceList 集合
     * 将NyxInsuranceList集合的每一条entity保存到NyxPolicyList和NyxPolicyListOrigin
     * @author: 潘峰
     */
    @RequestMapping(value = "saveNyxInsuranceToPolicy", method = {RequestMethod.GET})
    public void saveNyxInsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception;


    /**
     * @param
     * @description 传inusreListCode查询PlantingInsuranceList集合
     * 将 PlantingInsuranceList 集合的每一条entity保存到 PlantingPolicyList 和Plantingpolicylistorigin
     * @author: 潘峰
     */
    @RequestMapping(value = "saveInsuranceToPolicy", method = {RequestMethod.GET})
    public void saveInsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception;


    /**
     * @param
     * @description 传inusreListCode查询PlantingTCirculationList集合
     * 将PlantingTCirculationList集合的每一条entity保存到PlantingCCirculationList和PlantingCCirculationListOrigin
     * @author: 潘峰
     */
    @RequestMapping(value = "saveTCirculationToC", method = {RequestMethod.GET})
    public void saveTCirculationToC(@RequestParam("inusreListCode") String inusreListCode) throws Exception;


    /**
     * @param
     * @description 传RelationListNo查询herdinsurancelist集合
     * 将herdinsurancelist集合的每一条entity保存到herdPolicyList和herdPolicyListOrigin
     * @author: 潘峰
     */
    @RequestMapping(value = "saveHerdinsuranceToPolicy", method = {RequestMethod.GET})
    public void saveHerdinsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception;


    /**
     * 投保清单持久化接口 投保预确认清单数据表 三表同时插入
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param insuranceListDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveInsuranceList",method =RequestMethod.POST)
    public  ResponseDto saveInsuranceList(@RequestBody InsuranceListDto insuranceListDto)throws Exception;

    /**
     * 查询投保清单接口 投保预确认清单数据表 三表同时查
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return List<InsuranceListDto>
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuranceList",method =RequestMethod.POST)
    public InsuranceListDto queryInsuranceList()throws Exception;

    /**
     * 查询金禾主信息
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryAllGisinsuremainlist",method = RequestMethod.POST)
    public @ResponseBody List<GisInsureMainListDto> queryAllGisinsuremainlist()throws Exception;


    /**
     * 查询金禾农户
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryAllGisnyxinsurancelist",method = RequestMethod.POST)
    public List<GisNyxInsuranceListDto> queryAllGisnyxinsurancelist()throws Exception;

    /**
     * 查询金禾农户农田信息
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryAllGisFeild",method = RequestMethod.POST)
    public List<GisFeildDto> queryAllGisFeild()throws Exception;

    /**
     * 查询金禾农户养殖险耳标号
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryAllGisHerdField",method = RequestMethod.POST)
    public List<GisHerdFieldDto> queryAllGisHerdField()throws Exception;


    /**
     * 保存金禾主信息
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisInsureMainListDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveGisInsureMainList",method = RequestMethod.POST)
    public @ResponseBody String saveGisInsureMainList(@RequestBody GisInsureMainListDto gisInsureMainListDto)throws Exception;

    /**
     * 保存金禾农户信息
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisNyxInsuranceListDtoList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveGisnyxinsurancelist",method = RequestMethod.POST)
    public @ResponseBody String saveGisnyxinsurancelist(@RequestBody List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList)throws Exception;

    /**
     * 保存金禾农田信息
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisFeildDtoList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveGisFeild",method = RequestMethod.POST)
    public @ResponseBody String saveGisFeild(@RequestBody List<GisFeildDto> gisFeildDtoList)throws Exception;

    /**
     * 保存金禾养殖险耳标号
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisHerdFieldDtoList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveGisHerdField",method = RequestMethod.POST)
    public @ResponseBody String saveGisHerdField(@RequestBody List<GisHerdFieldDto> gisHerdFieldDtoList)throws Exception;



}