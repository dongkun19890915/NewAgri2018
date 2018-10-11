package com.sinosoft.agriclaim.core.combinemanage.service;


import java.util.List;
import java.util.Map;

import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCaseQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComCheckQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimDetailQueryDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryInDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.ComClaimQueryOutDto;
import com.sinosoft.agriclaim.api.combinemanage.dto.PrpLCombineDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-25 08:10:12.537 
 * @description 并案关联表Core接口
 */
public interface PrpLCombineService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCombineDto prpLCombineDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCombineDto prpLCombineDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCombineDto queryByPK(String registNo);
    
    /**
     * @descption 新增合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 新增合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
    Map<String,String> saveCombine(List<PrpLCombineDto>  prpLCombineDtos) throws Exception;
    
    /**
     * @descption 删除合并案件服务
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<PrpLCombineDto> 删除合并案件条件组织的对象集合
     * @return Map 返回是否成功
     */
    Map<String,String> logicRemoveComCase(List<PrpLCombineDto>  prpLCombineDtos) throws Exception;
    
    /**
     * @descption 合并查勘定损页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并查勘定损页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComCheckDetailQueryDto>  返回初始化对象集合
     */
    List<ComCheckDetailQueryDto> comCheckPageInit(List<Map<String,String>> listMap) throws Exception;

    /**
     * @descption 合并立案页面初始化（ADD ,EDIT.SHOW）
     * @author moujiaxing
     * @date 2017-12-01
     * @param List<Map<String,String>> 合并立案页面初始化（ADD ,EDIT.SHOW）条件组织的对象集合
     * @return List<ComClaimDetailQueryDto>  返回初始化对象集合
     */
    List<ComClaimDetailQueryDto>  comClaimPageInit(List<Map<String,String>> listMap) throws Exception;

 /**
     * @descption 合并案件查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCaseQueryInDto 合并案件查询条件组织的对象
     * @return PageInfo 包含并案信息的PageInfo对象
     */
    PageInfo<ComCaseQueryOutDto> queryByComCaseInDto(ComCaseQueryInDto comCaseQueryInDto);
    
    /**
     * @descption 合并查勘定损查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并查勘定损查询条件组织的对象
     * @return PageInfo 包含合并查勘定损信息的PageInfo对象
     */
    PageInfo<ComCheckQueryOutDto> queryByComCheckInDto(ComCheckQueryInDto comCheckQueryInDto) throws Exception;
    /**
     * @descption 合并立案查询服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckQueryInDto 合并立案查询条件组织的对象
     * @return PageInfo 包含合并立案信息的PageInfo对象
     */
    PageInfo<ComClaimQueryOutDto> queryByComClaimInDto(ComClaimQueryInDto comClaimQueryInDto) throws Exception;
    /**
     * @descption 合并查勘定损暂存、提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并查勘定损暂存、提交信息列表
     */
    public @ResponseBody Map<String,String> saveSubmitComCheck(List<ComCheckInDto> comCheckInDtoList)throws Exception;
    /**
     * @descption 合并立案提交服务
     * @author liyang
     * @date 2017-12-01
     * @param comCheckInDtoList 合并立案提交信息列表
     */
    Map<String,String> saveSubmitComClaim(List<ComClaimInDto> comCheckInDtoList)throws Exception;
}