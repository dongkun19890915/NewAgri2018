package com.sinosoft.dms.core.model.service;


import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainInfoDto;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainRequestDto;
import com.sinosoft.dms.api.model.dto.QueryPrpMmodelMainDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.CompanyListDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:35:35.009 
 * @description 模板配置主表Core接口
 */
public interface PrpMmodelMainService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpMmodelMainDto prpMmodelMainDto);


    /**
     *  保存模板信息
     * @author: 田慧
     * @date: 2017/11/11 15:49
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @throws Exception
     */
    public Map<String,String> saveButton(PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception;


    /**
     *  根据模板代码修改模板信息
     * @author: 田慧
     * @date: 2017/11/9 19:28
     * @param prpMmodelMainInfoDto 模板配置主表Dto、模板机构配置表Dto、模板保险地址表Dto、模板共保信息表Dto、模板客户纳税人信息表Dto、
     *         模板特别约定表Dto、模板保险关系人表Dto、 模板农业险保单信息Dto、保单基本信息表Dto、模板农险标的附加表Dto、标的子险信息Dto
     * @return   成功success
     * @return
     */
    public Map<String,String>  modifyByModelCode(PrpMmodelMainInfoDto prpMmodelMainInfoDto)throws Exception;

    /**
     *@description 删除
     *@param
     */
    void remove(String modelcode);


    /**
     *  根据模板代码删除模板信息
     * @author: 田慧
     * @date: 2017/11/9 18:09
     * @param @RequestBody List<PrpMmodelMainDto> prpMmodelMainDtoList 页面接收的模板代码的集合
     * @return
     */
    public Map<String,String>  removeAllByModelCode(@RequestBody List<String> prpMmodelMainDtoList)throws Exception ;
    /**
     *@description 修改
     *@param
     */
    void modify(PrpMmodelMainDto prpMmodelMainDto);

    /**
     *  模板的停用启用功能
     * @author: 田慧
     * @date: 2017/11/9 16:04
     * @param prpMmodelMainDto  模板配置主表Dto
     */
    public Map<String,String>  modifyValidstatusByModelCode(PrpMmodelMainDto prpMmodelMainDto)throws Exception;
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpMmodelMainDto queryByPK(String modelcode);

    /**
     *  根据条件查询模板信息
     * @author: 田慧
     * @date: 2017/11/9 10:38
     * @param prpMmodelMainRequestDto 自定义的toD包括模板代码、模板机构、
     *                              被保险人名称、模板创建有效起期、模板创建有效止期
     *                                险种、标的、创建人名称、政策/商业标志、有效字段
     * @return 返回分页信息
     * @throws Exception
     */
    public PageInfo<QueryPrpMmodelMainDto> queryPrpMmodelMainByCondition(PrpMmodelMainRequestDto prpMmodelMainRequestDto)throws Exception;

    /**
     *  根据超链接查询模板信息
     * @author: 田慧
     * @date: 2017/11/14 20:24P
     * @param  modelCode 模板代码
     * @return 返回模板信息
     * @throws Exception
     */
    public PrpMmodelMainInfoDto queryPrpMmodelMainByHyperLink(String modelCode,String userCode,String comCode)throws Exception;
    /**
     * * （查询机构树）
     * @author: 田慧
     * @date: 19:19
     * @param modelCode 模板号码
     * @param userCode 用户代码
     * @param comCode 机构代码
     * @return companyListDtoList
     * @throws Exception
     */
     PrpMmodelMainInfoDto getCompanyTree (String modelCode, String userCode, String comCode) throws Exception;
    /**
     *  根据险种代码和机构代码查询模板配置主表信息
     * @author: 田慧
     * @date: 2017/12/11 11:45
     * @param riskCode 险种代码
     * @param comCode  机构代码
     * @return PrpMmodelMainDto的集合
     * @throws Exception
     */
    public List<PrpMmodelMainDto> queryPrpMmodelMainByRiskCodeAndComCode(String riskCode,String comCode)throws Exception;
    /**
     * * 根据模板代码查询模板配置主表信息
     * @author: 田慧
     * @date: 10:25
     * @param map modelCode 模板代码
     * @return PrpMmodelMainDto
     * @throws Exception
     */
    PrpMmodelMainDto getPrpmmodelmainInfo(Map<String,String> map) throws Exception;
}