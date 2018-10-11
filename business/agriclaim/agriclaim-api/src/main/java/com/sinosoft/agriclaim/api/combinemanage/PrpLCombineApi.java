package com.sinosoft.agriclaim.api.combinemanage;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLCombineDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * @description 合并案件
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCombineApi.PATH)
public interface PrpLCombineApi {

    public static final String PATH = "prpLCombine";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody  PrpLCombineDto prpLCombineDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("registNo") String registNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpLCombineDto prpLCombineDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCombineDto queryByPK(@RequestParam("registNo") String registNo);
    
    /**
     * @descption 新增合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 新增合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
    @RequestMapping(value = "saveCombine",method = {RequestMethod.POST})
    Map<String,String> saveCombine(@RequestBody   List<PrpLCombineDto>  prpLCombineDtos) throws Exception;
    
    /**
     * @descption 删除合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 删除合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
    @RequestMapping(value = "logicRemoveCombine",method = {RequestMethod.POST})
    Map<String,String> logicRemoveCombine(@RequestBody List<PrpLCombineDto>  prpLCombineDtos) throws Exception;
    
    
   /**
     * @descption 合并查勘定损页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并查勘定损页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComCheckDetailQueryDto>  返回初始化对象集合
     */
    @RequestMapping(value = "comCheckPageInit",method = {RequestMethod.POST})
    List<ComCheckDetailQueryDto>  comCheckPageInit(@RequestBody List<Map<String,String>> listMap) throws Exception;
    
    /**
     * @descption 合并立案页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并立案页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComClaimDetailQueryDto>  返回初始化对象集合
     */
    @RequestMapping(value = "comClaimPageInit",method = {RequestMethod.POST})
    List<ComClaimDetailQueryDto>  comClaimPageInit(@RequestBody  List<Map<String,String>> listMap) throws Exception;
     
    /**
     * @descption 合并案件查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCaseQueryInDto 合并案件查询条件组织的对象
     * @return PageInfo 包含并案信息的PageInfo对象
     */
    @RequestMapping(value = "queryByComCaseInDto",method = {RequestMethod.POST})
    @ResponseBody PageInfo queryByComCaseInDto(@RequestBody ComCaseQueryInDto comCaseQueryInDto);
    /**
     * @descption 合并查勘定损查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并查勘定损查询条件组织的对象
     * @return PageInfo 包含合并查勘定损信息的PageInfo对象
     */
    @RequestMapping(value = "queryByComCheckInDto",method = {RequestMethod.POST})
    @ResponseBody PageInfo queryByComCheckInDto(@RequestBody ComCheckQueryInDto comCheckQueryInDto) throws Exception;
    /**
     * @descption 合并立案查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并立案查询条件组织的对象
     * @return PageInfo 包含合并立案信息的PageInfo对象
     */
    @RequestMapping(value = "queryByComClaimInDto",method = {RequestMethod.POST})
    @ResponseBody PageInfo queryByComClaimInDto(@RequestBody ComClaimQueryInDto comClaimQueryInDto) throws Exception;
    /**
     * @descption 合并查勘定损暂存、提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并查勘定损暂存、提交信息列表
     */
    @RequestMapping(value = "saveSubmitComCheck",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> saveSubmitComCheck(@RequestBody List<ComCheckInDto> comCheckInDtoList) throws Exception;
    /**
     * @descption 合并立案提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并立案提交信息列表
     */
    @RequestMapping(value = "saveSubmitComClaim",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> saveSubmitComClaim(@RequestBody List<ComClaimInDto> comCheckInDtoList) throws Exception;
 
}