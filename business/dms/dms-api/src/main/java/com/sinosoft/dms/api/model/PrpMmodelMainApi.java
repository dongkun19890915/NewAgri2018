package com.sinosoft.dms.api.model;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainInfoDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainRequestDto;
import com.sinosoft.dms.api.model.dto.QueryPrpMmodelMainDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板配置主表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpMmodelMainApi.PATH)
public interface PrpMmodelMainApi {

    public static final String PATH = "prpMmodelMain";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpMmodelMainDto prpMmodelMainDto);
    /**
     *  保存模板信息
     * @author: 田慧
     * @date: 2017/11/11 15:53
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @throws Exception
     */
    @RequestMapping(value = "saveButton",method ={RequestMethod.POST})
    public @ResponseBody Map<String,String> saveButton(@RequestBody PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception;


    /**
     *  根据模板代码修改模板信息
     * @author: 田慧
     * @date: 2017/11/9 19:35
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @return
     */
    @RequestMapping(value = "modifyByModelCode",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> modifyByModelCode(@RequestBody PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception;
    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String modelCode);

    /**
     *   根据模板代码删除全部模板信息
     * @author: 田慧
     * @date: 2017/11/9 18:01
     * @param modelCodeList  页面接收的模板代码的集合
     * @return
     */
    @RequestMapping(value = "removeAllByModelCode",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> removeAllByModelCode(@RequestBody List<String> modelCodeList)throws Exception;

    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpMmodelMainDto prpMmodelMainDto);

    /**
     *  模板的停用启用功能
     * @author: 田慧
     * @date: 2017/11/9 16:11
     * @param prpMmodelMainDto  模板配置主表Dto
     */
    @RequestMapping(value = "modifyValidstatusByModelCode",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String>  modifyValidstatusByModelCode(@RequestBody PrpMmodelMainDto prpMmodelMainDto)throws Exception;
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody PrpMmodelMainDto queryByPK(String modelcode);

    /**
     *  根据条件查询模板信息
     * @author: 田慧
     * @date: 2017/11/9 10:55
     * @param prpMmodelMainRequestDto 自定义的toD包括模板代码、模板机构、
     *                              被保险人名称、模板创建有效起期、模板创建有效止期
     *                                险种、标的、创建人名称、政策/商业标志、有效字段
     * @return 返回分页信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpMmodelMainByCondition",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<QueryPrpMmodelMainDto> queryPrpMmodelMainByCondition(@RequestBody PrpMmodelMainRequestDto prpMmodelMainRequestDto)throws Exception;

    /**
     * 根据超链接查询模板信息
     * @author: 田慧
     * @date: 2017/11/14 20:19
     * @param map 模板代码
     * @return 返回模板信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpMmodelMainByHyperLink",method = {RequestMethod.POST})
    public @ResponseBody PrpMmodelMainInfoDto queryPrpMmodelMainByHyperLink(@RequestBody Map<String,Object> map) throws Exception;

    /**
     * * （请具体描述此方法的用途及逻辑）
     * @author: 田慧
     * @date: 19:22
     * @param map 键为 modelCode 模板号码、userCode 用户代码、comCode 机构代码
     * @return 机构树信息
     * @throws Exception
     */
    @RequestMapping(value = "getCompanyTree",method = {RequestMethod.POST})
    public @ResponseBody PrpMmodelMainInfoDto getCompanyTree(@RequestBody Map<String,Object> map) throws Exception;

    /**
     *  根据险种代码和机构代码查询模板配置主表信息
     * @author: 田慧
     * @date: 2017/12/11 11:45
     * @param map 包括riskCode 险种代码、comCode  机构代码
     * @return PrpMmodelMainDto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpMmodelMainByRiskCodeAndComCode",method = {RequestMethod.POST})
    public @ResponseBody List<PrpMmodelMainDto> queryPrpMmodelMainByRiskCodeAndComCode(@RequestBody Map<String,String> map)throws Exception;

    /**
     * * 根据模板代码查询模板配置主表信息
     * @author: 田慧
     * @date: 10:25
     * @param map modelCode 模板代码
     * @return PrpMmodelMainDto
     * @throws Exception
     */
    @RequestMapping(value = "getPrpmmodelmainInfo",method = {RequestMethod.POST})
    @ResponseBody PrpMmodelMainDto getPrpmmodelmainInfo(@RequestBody Map<String,String> map) throws Exception;
}