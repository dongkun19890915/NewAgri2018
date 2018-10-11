package com.sinosoft.agriclaim.api.claimmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimPrintDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimEndCaseDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案基本信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLClaimApi.PATH)
public interface PrpLClaimApi {

    public static final String PATH = "prpLClaim";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLClaimDto prpLClaimDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String claimNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLClaimDto prpLClaimDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLClaimDto queryByPK(String claimNo);

    /**
     * （理赔打印 列表查询接口）
     * @author: 王志文
     * @date: 2017/11/20 17:43
     * @param claimPrintDto 页面输入框输入数据
     * @return 分页数据列表
     */
    @RequestMapping(value = "queryListByPrintType",method = {RequestMethod.POST})
    PageInfo queryListByPrintType(@RequestBody ClaimPrintDto claimPrintDto) throws Exception;

    /**
     * （根据保单号查询PrpLClaim表）
     * @author: 王志文
     * @date: 2017/11/21 10:44
     * @param policyNo 保单号
     * @return PrpLClaimDto 的集合
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    List<PrpLClaimDto> queryByPolicyNo(String policyNo)throws Exception;
    /**
     * （根据立案号、报案号、保单号查询结案登记页面详细信息）
     * @author: 董坤
     * @date: 2017/11/11 10:41
     * @param prpLClaimDto （只有立案号、报案号、保单号）
     * @return 结案登记展示页面相关信息
     */
    @RequestMapping(value = "queryEndCaseDetailByCondition",method = {RequestMethod.POST})
    @ResponseBody PrpLClaimEndCaseDto queryEndCaseDetailByCondition(@RequestBody PrpLClaimDto prpLClaimDto) throws Exception;

    /**
     *（结案登记页面详细信息保存）
     * @author: 董坤
     * @date: 2017/11/13 14:31
     * @param prpLClaimEndCaseDto 结案登记展示页面相关信息
     * @return 结案信息保存成功与否信息
     */
    @RequestMapping(value = "saveEndCaseInfo",method = {RequestMethod.POST})
    @ResponseBody
    Map<String,String> saveEndCaseInfo(@RequestBody PrpLClaimEndCaseDto prpLClaimEndCaseDto) throws Exception;
}