package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = PlantingInsuranceListApi.PATH)
public interface PlantingInsuranceListApi {

    public static final String PATH = "plantingInsuranceList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PlantingInsuranceListDto plantingInsuranceListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("inusrelistcode") String inusrelistcode,@RequestParam("fcode") String fcode,@RequestParam("kindcode") String kindcode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PlantingInsuranceListDto plantingInsuranceListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PlantingInsuranceListDto queryByPK(@RequestParam("inusrelistcode") String inusrelistcode,@RequestParam("fcode") String fcode,@RequestParam("kindcode") String kindcode);

    /**
     * @description:（根据inusreListCode查询PlantingInsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:58
     * @param inusreListCode
     * @return List<PlantingInsuranceListDto>
     */
    @RequestMapping(value ="queryByInusreListCode",method = RequestMethod.GET)
    List<PlantingInsuranceListDto> queryByInusreListCode (@RequestParam("inusrelistcode") String inusreListCode);

    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:58
     * @param plantingInsuranceListDtoList
     */
    @RequestMapping(value = "saveByList" ,method = {RequestMethod.POST})
    @ResponseBody String saveByList (@RequestBody List<PlantingInsuranceListDto> plantingInsuranceListDtoList);

    /**
     * @description:（批量修改）
     * @author: 田健
     * @date: 2017/10/20 11:59
     * @param plantingInsuranceListDtoList
     */
    @RequestMapping( value = "modifyBylist" ,method = {RequestMethod.POST})
    void modifyBylist(@RequestBody List<PlantingInsuranceListDto> plantingInsuranceListDtoList);

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:59
     * @param inusreListcode
     * @return
     */
    @RequestMapping(value = "getSumInsured",method = {RequestMethod.GET})
    public int getSumInsured(@RequestParam("inusrelistcode") String inusreListcode);

    /**
     * @description:（根据inreListcode查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 12:00
     * @param inusreListcode
     * @return PlantingInsuranceListDto
     */
    @RequestMapping(value = "getSumFee",method = {RequestMethod.GET})
    public PlantingInsuranceListDto getSumFee(@RequestParam("inusrelistcode") String inusreListcode);

    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 12:01
     * @param inusreListcode
     */
    @RequestMapping(value = "removeByInusreListcode",method = {RequestMethod.GET})
    public void removeByInusreListcode(@RequestParam("inusrelistcode") String inusreListcode);
    /**
     * @description:PlantingInsuranceList分页查询
     * @author: 陈道洋
     * @date: 2017/10/20 12:01
     * @param inusreListCode 清单编号
     */
    @RequestMapping(value = "queryPlantingInsuranceInfo",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<PlantingInsuranceListDto>   queryPlantingInsuranceInfo(@RequestParam("inusreListCode") String inusreListCode, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) throws Exception;

    /**
     * @description:根据inusrelistcode查询PlantingInsuranceList表
     * @author: 陈道洋
     * @date: 2017/10/20 12:01
     * @param inusreListCode 清单编号
     */
    @RequestMapping(value = "queryPlantingInsuranceListInfo",method = {RequestMethod.POST})
    public @ResponseBody List<PlantingInsuranceListDto> queryPlantingInsuranceListInfo(@RequestParam("inusreListCode") String inusreListCode) throws Exception;
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @RequestMapping(value = "queryByInusreListCodeAndFcode",method = {RequestMethod.POST})
    @ResponseBody PlantingInsuranceListDto queryByInusreListCodeAndFcode(@RequestParam (value="inusreListCode")String inusreListCode,@RequestParam (value="fCode")String fCode  )throws Exception;
}