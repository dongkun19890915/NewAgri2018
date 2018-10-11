package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpMmodelMainApi;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainInfoDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainRequestDto;
import com.sinosoft.dms.api.model.dto.QueryPrpMmodelMainDto;
import com.sinosoft.dms.core.model.service.PrpMmodelMainService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板配置主表controller层
 */
@RestController
@RequestMapping(value = PrpMmodelMainController.PATH)
public class PrpMmodelMainController implements PrpMmodelMainApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpMmodelMainController.class);

    @Autowired
    private PrpMmodelMainService prpMmodelMainService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpMmodelMainDto prpMmodelMainDto) {

        prpMmodelMainService.save(prpMmodelMainDto);
    }

    /**
     *  保存模板信息
     * @author: 田慧
     * @date: 2017/11/11 15:58
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @throws Exception
     */
    @Override
    public @ResponseBody
    Map<String,String> saveButton(@RequestBody PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception{
       return prpMmodelMainService.saveButton(prpMmodelMainInfoDto);
    }
    /**
     *  根据模板代码修改模板信息
     * @author: 田慧
     * @date: 2017/11/9 19:29
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @return
     */
    @Override
    public @ResponseBody Map<String,String> modifyByModelCode(@RequestBody PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception{
        return  prpMmodelMainService.modifyByModelCode(prpMmodelMainInfoDto);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String modelCode) {
        prpMmodelMainService.remove(modelCode);
    }

    /**
     *  根据模板代码删除全部模板信息
     * @author: 田慧
     * @date: 2017/11/9 18:07
     * @param modelCodeList 页面接收的模板代码的集合
     * @return
     */
    @Override
    public @ResponseBody Map<String,String> removeAllByModelCode(@RequestBody List<String> modelCodeList) throws Exception{
        return prpMmodelMainService.removeAllByModelCode(modelCodeList) ;
    }

    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpMmodelMainDto prpMmodelMainDto) {
        prpMmodelMainService.modify(prpMmodelMainDto);
    }

    /**
     *   模板的停用启用功能
     * @author: 田慧
     * @date: 2017/11/9 16:06
     * @param prpMmodelMainDto  模板配置主表Dto
     */
    @Override
    public @ResponseBody Map<String,String> modifyValidstatusByModelCode(@RequestBody PrpMmodelMainDto prpMmodelMainDto)throws Exception{
       return  prpMmodelMainService.modifyValidstatusByModelCode(prpMmodelMainDto) ;
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public @ResponseBody PrpMmodelMainDto queryByPK(@RequestBody String modelCode) {
        return prpMmodelMainService.queryByPK(modelCode);
    }

    /**
     *  根据条件查询模板信息
     * @author: 田慧
     * @date: 2017/11/9 10:44
     * @param prpMmodelMainRequestDto 自定义的toD包括模板代码、模板机构、
     *                              被保险人名称、模板创建有效起期、模板创建有效止期
     *                                险种、标的、创建人名称、政策/商业标志、有效字段
     * @return 返回分页信息
     */
    @Override
    public @ResponseBody
    PageInfo<QueryPrpMmodelMainDto> queryPrpMmodelMainByCondition(@RequestBody PrpMmodelMainRequestDto prpMmodelMainRequestDto)throws Exception{
        return  prpMmodelMainService.queryPrpMmodelMainByCondition(prpMmodelMainRequestDto);

    }

    /**
     *  根据超链接查询模板信息
     * @author: 田慧
     * @date: 2017/11/14 20:22
     * @param map 模板代码
     * @return 返回模板信息
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpMmodelMainInfoDto queryPrpMmodelMainByHyperLink(@RequestBody Map<String,Object> map) throws Exception{
        return  prpMmodelMainService.queryPrpMmodelMainByHyperLink((String) map.get("modelCode"),(String)map.get("userCode"),(String)map.get("comCode"));

    }
    /**
     * * （请具体描述此方法的用途及逻辑）
     * @author: 田慧
     * @date: 19:22
     * @param map 键为 modelCode 模板号码、userCode 用户代码、comCode 机构代码
     * @return 机构树信息
     * @throws Exception
     */
   @Override
    public @ResponseBody PrpMmodelMainInfoDto getCompanyTree(@RequestBody Map<String,Object> map) throws Exception{
       return  prpMmodelMainService.getCompanyTree((String) map.get("modelCode"),(String)map.get("userCode"),(String)map.get("comCode"));

   }
    /**
     *  根据险种代码和机构代码查询模板配置主表信息
     * @author: 田慧
     * @date: 2017/12/11 11:45
     * @param map 包括riskCode 险种代码、comCode  机构代码
     * @return PrpMmodelMainDto的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpMmodelMainDto> queryPrpMmodelMainByRiskCodeAndComCode(@RequestBody Map<String,String> map)throws Exception{
        String riskCode = map.get("riskCode");
        String comCode = map.get("comCode");
        return prpMmodelMainService.queryPrpMmodelMainByRiskCodeAndComCode(riskCode,comCode);
    }
    /**
     * * 根据模板代码查询模板配置主表信息
     * @author: 田慧
     * @date: 10:25
     * @param map modelCode 模板代码
     * @return PrpMmodelMainDto
     * @throws Exception
     */
    @Override
    public @ResponseBody PrpMmodelMainDto getPrpmmodelmainInfo(@RequestBody Map<String,String> map) throws Exception{
        return prpMmodelMainService.getPrpmmodelmainInfo(map);
    }
}
