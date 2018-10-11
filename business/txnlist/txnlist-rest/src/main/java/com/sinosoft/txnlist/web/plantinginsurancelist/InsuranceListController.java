package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.txnlist.api.gisinsurelist.dto.GisInsureMainListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.InsuranceListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.*;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表controller层
 */
@RestController
@RequestMapping(value = InsuranceListApi.PATH)
public class InsuranceListController implements InsuranceListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingInsuranceListController.class);

    @Autowired
    private InsuranceListService insuranceListService;
    @Autowired
    private GisInsureMainListService gisInsureMainListService;
    @Autowired
    private GisNyxInsuranceListService gisNyxInsuranceListService;
    @Autowired
    private GisFeildService gisFeildService;
    @Autowired
    private GisHerdFieldService gisHerdFieldService;


    /**
     * @param inusreListCode
     * @description 传inusreListCode查询Planting31InsuranceList集合
     * 将Planting31InsuranceList集合的每一条entity保存到Planting31PolicyList和Planting31PolicyListOrigin
     */
    @Override
    public void save31PlantingToPlanting(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        insuranceListService.findByPlanting31InsuranceList(inusreListCode);
    }

    /**
     * @param inusreListCode
     * @description 传inusreListCode查询NyxInsuranceList集合
     * 将NyxInsuranceList集合的每一条entity保存到NyxPolicyList和NyxPolicyListOrigin
     */
    @Override
    public void saveNyxInsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        insuranceListService.saveNyxInsuranceToPolicy(inusreListCode);
    }

    /**
     * @param inusreListCode
     * @description 传inusreListCode查询PlantingInsuranceList集合
     * 将PlantingInsuranceList集合的每一条entity保存到PlantingPolicyList和Plantingpolicylistorigin
     */
    @Override
    public void saveInsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        insuranceListService.saveInsuranceToPolicy(inusreListCode);
    }

    /**
     * @param inusreListCode @author: 潘峰
     * @description 传inusreListCode查询PlantingTCirculationList集合
     * 将PlantingTCirculationList集合的每一条entity保存到PlantingCCirculationList和PlantingCCirculationListOrigin
     */
    @Override
    public void saveTCirculationToC(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        insuranceListService.saveTCirculationToC(inusreListCode);
    }

    /**
     * @param inusreListCode @description 传RelationListNo查询herdinsurancelist集合
     *                       将herdinsurancelist集合的每一条entity保存到herdPolicyList和herdPolicyListOrigin
     * @author: 潘峰
     */
    @Override
    public void saveHerdinsuranceToPolicy(@RequestParam("inusreListCode") String inusreListCode) throws Exception {
        insuranceListService.saveHerdinsuranceToPolicy(inusreListCode);
    }

    /**
     * 投保清单持久化接口 投保预确认清单数据表 三表同时插入
     *
     * @param insuranceListDto
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseDto saveInsuranceList(@RequestBody InsuranceListDto insuranceListDto) throws Exception {
        //金禾主信息
        GisInsureMainListDto gisInsureMainListDto = insuranceListDto.getGisInsureMainListDto();
        //金禾农户信息
        List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList = insuranceListDto.getGisNyxInsuranceListDto();
        //金禾农田信息
        List<GisFeildDto> gisFeildListDto = insuranceListDto.getGisFeildDtoList();
        //金禾养殖险耳标号表
        List<GisHerdFieldDto> gisHerdFieldDtoList = insuranceListDto.getGisHerdFieldDtoList();


        //保存数据
        Integer serialNo = gisInsureMainListService.saveGisInsureMainList(gisInsureMainListDto);

        //农户关联主表序列号
        for (GisNyxInsuranceListDto gisNyxInsuranceListDto : gisNyxInsuranceListDtoList) {
            gisNyxInsuranceListDto.setSerialNo(serialNo);
        }
        gisNyxInsuranceListService.saveGisNyxInsuranceList(gisNyxInsuranceListDtoList);

        //农田关联主表序列号
        if (gisFeildListDto != null) {
            for (GisFeildDto gisFeildDto : gisFeildListDto) {
                gisFeildDto.setSerialNo(serialNo);
            }
            gisFeildService.saveGisFeild(gisFeildListDto);
        }

        //养殖关联主表序列号
        if(gisHerdFieldDtoList!=null) {
            for (GisHerdFieldDto gisHerdFieldDto : gisHerdFieldDtoList) {
                gisHerdFieldDto.setSerialNo(serialNo);
            }
            gisHerdFieldService.saveGisHerdField(gisHerdFieldDtoList);
        }


        ResponseDto responseDto = ResponseDto.instance("success");
        return responseDto;
    }


    /**
     * 查询投保清单接口 投保预确认清单数据表 三表同时查
     *
     * @param
     * @return InsuranceListDto
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public InsuranceListDto queryInsuranceList() throws Exception {
        InsuranceListDto insuranceListDto = new InsuranceListDto();
        //金禾主信息
        GisInsureMainListDto gisInsureMainListDto = gisInsureMainListService.get("1234563", 1);
        //金禾农户信息
        List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList = gisNyxInsuranceListService.queryAll();
        //金禾农田信息
        List<GisFeildDto> gisFeildListDto = gisFeildService.queryAll();

        insuranceListDto.setGisInsureMainListDto(gisInsureMainListDto);
        insuranceListDto.setGisNyxInsuranceListDto(gisNyxInsuranceListDtoList);
        insuranceListDto.setGisFeildDtoList(gisFeildListDto);
        return insuranceListDto;
    }

    /**
     * 查询金禾主信息
     *
     * @param
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisInsureMainListDto> queryAllGisinsuremainlist() throws Exception {
        return gisInsureMainListService.queryAll();
    }

    /**
     * 查询金禾农户
     *
     * @param
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisNyxInsuranceListDto> queryAllGisnyxinsurancelist() throws Exception {
        return gisNyxInsuranceListService.queryAll();
    }

    /**
     * 查询金禾农户农田信息
     *
     * @param
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisFeildDto> queryAllGisFeild() throws Exception {
        return gisFeildService.queryAll();
    }

    /**
     * 查询金禾农户养殖险耳标号
     *
     * @param
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public List<GisHerdFieldDto> queryAllGisHerdField() throws Exception {
        return gisHerdFieldService.queryAll();
    }


    /**
     * 保存金禾主信息
     *
     * @param gisInsureMainListDto
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public String saveGisInsureMainList(@RequestBody GisInsureMainListDto gisInsureMainListDto) throws Exception {
        gisInsureMainListService.saveGisInsureMainList(gisInsureMainListDto);
        return "success";
    }

    /**
     * 保存金禾农户信息
     *
     * @param gisNyxInsuranceListDtoList
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public String saveGisnyxinsurancelist(@RequestBody List<GisNyxInsuranceListDto> gisNyxInsuranceListDtoList) throws Exception {
        gisNyxInsuranceListService.saveGisNyxInsuranceList(gisNyxInsuranceListDtoList);
        return "success";
    }

    /**
     * 保存金禾农田信息
     * @param gisFeildDtoList
     * @return
     * @throws Exception
     * @author: 汪强
     * @date: 9:00 2017/11/06
     */
    @Override
    public String saveGisFeild(@RequestBody List<GisFeildDto> gisFeildDtoList) throws Exception {
        gisFeildService.saveGisFeild(gisFeildDtoList);
        return "success";
    }

    /**
     * 保存金禾养殖险耳标号
     * @author: 汪强
     * @date: 9:00 2017/11/06
     * @param gisHerdFieldDtoList
     * @return
     * @throws Exception
     */
    @Override
    @RequestMapping(value = "saveGisHerdField",method = RequestMethod.POST)
    public @ResponseBody String saveGisHerdField(@RequestBody List<GisHerdFieldDto> gisHerdFieldDtoList)throws Exception{
        gisHerdFieldService.saveGisHerdField(gisHerdFieldDtoList);
        return "success";
    }


}
