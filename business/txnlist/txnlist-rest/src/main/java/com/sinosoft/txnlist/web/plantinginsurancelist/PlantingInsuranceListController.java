package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.PlantingInsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.PlantingInsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 03:27:26.178 
 * @description 投保明细表controller层
 */
@RestController
@RequestMapping(value = PlantingInsuranceListController.PATH)
public class PlantingInsuranceListController implements PlantingInsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingInsuranceListController.class);

    @Autowired
    private PlantingInsuranceListService plantingInsuranceListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PlantingInsuranceListDto plantingInsuranceListDto) {
        plantingInsuranceListService.save(plantingInsuranceListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("inusrelistcode") String inusrelistcode,@RequestParam("fcode") String fcode,@RequestParam("kindcode") String kindcode) {
        plantingInsuranceListService.remove(inusrelistcode,fcode,kindcode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PlantingInsuranceListDto plantingInsuranceListDto) {
        plantingInsuranceListService.modify(plantingInsuranceListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PlantingInsuranceListDto queryByPK(@RequestParam("inusrelistcode") String inusrelistcode, @RequestParam("fcode") String fcode, @RequestParam("kindcode") String kindcode) {
        return plantingInsuranceListService.queryByPK(inusrelistcode,fcode,kindcode);
    }

    /**
     * @description:（根据inusreListCode查询PlantingInsuranceList）
     * @author: 田健
     * @date: 2017/10/20 11:47
     * @param inusreListCode
     * @return
     */
    public @ResponseBody List<PlantingInsuranceListDto> queryByInusreListCode(@RequestParam("inusrelistcode") String inusreListCode){
        return plantingInsuranceListService.queryByInusreListCode(inusreListCode);
    }
    /**
     * @description:（批量保存）
     * @author: 田健
     * @date: 2017/10/20 11:48
     * @param plantingInsuranceListDtoList
     */
    public String saveByList (@RequestBody List<PlantingInsuranceListDto> plantingInsuranceListDtoList){
         plantingInsuranceListService.saveByList(plantingInsuranceListDtoList);
         return "success";
    }

    /**
     * @description:（批量修改）
     * @author: 田健
     * @date: 2017/10/20 11:48
     * @param plantingInsuranceListDtoList
     */
    public void modifyBylist(@RequestBody List<PlantingInsuranceListDto> plantingInsuranceListDtoList){
        plantingInsuranceListService.modifyBylist(plantingInsuranceListDtoList);
    }

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:49
     * @param inusreListcode
     * @return int
     */
    public int getSumInsured(@RequestParam("inusrelistcode") String inusreListcode){
        return plantingInsuranceListService.getSumInsured(inusreListcode);
    }

    /**
     * @description:（根据inreListcode查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:49
     * @param inusreListcode
     * @return PlantingInsuranceListDto
     */
    public PlantingInsuranceListDto getSumFee(@RequestParam("inusrelistcode") String inusreListcode){
        return plantingInsuranceListService.getSumFee(inusreListcode);
    }
    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:50
     * @param inusreListcode
     */
    public void removeByInusreListcode(@RequestParam("inusrelistcode") String inusreListcode){
        plantingInsuranceListService.removeByInusreListcode(inusreListcode);
    }

    /**
     * @description:PlantingInsuranceList分页查询
     * @author: 陈道洋
     * @date: 2017/10/31 11:45
     * @param inusreListCode 清单编号
     * @param pageNo 页码
     * @param pageSize 每页条数
     * @return 查询结果所需数据
     */
    @Override
    public @ResponseBody PageInfo<PlantingInsuranceListDto>  queryPlantingInsuranceInfo(@RequestParam("inusreListCode") String inusreListCode, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) throws Exception {
        return plantingInsuranceListService.queryPlantingInsuranceInfo(inusreListCode,pageNo,pageSize);
    }

    /**
     * @description:根据inusrelistcode查询PlantingInsuranceList表
     * @author: 陈道洋
     * @date: 2017/10/31 15:59
     * @param inusreListCode 清单编号
     * @return  PlantingInsuranceList表的数据
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PlantingInsuranceListDto> queryPlantingInsuranceListInfo(@RequestParam(value = "inusreListCode") String inusreListCode) throws Exception {
        return plantingInsuranceListService.queryPlantingInsuranceListInfo(inusreListCode);
    }
    /**
     * 根据清单号和农户代查询标的代码
     *
     * @param prarm policyNo-保单号码
     * @return 承保分户清单数据
     * @author: 陈道洋
     * @date: 2018/02/26 15:34
     */
    @Override
    public @ResponseBody PlantingInsuranceListDto queryByInusreListCodeAndFcode(String inusreListCode,String fCode  )throws Exception{
        return plantingInsuranceListService.queryByInusreListCodeAndFcode(inusreListCode,fCode);
    }
}
