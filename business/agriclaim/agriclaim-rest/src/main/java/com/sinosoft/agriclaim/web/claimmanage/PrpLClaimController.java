package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLConfigurationDto;
import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimApi;
import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimPrintDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimEndCaseDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLConfigurationService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案基本信息表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimController.PATH)
public class PrpLClaimController implements PrpLClaimApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimController.class);

    @Autowired
    private PrpLClaimService prpLClaimService;
    @Autowired
    private PrpLConfigurationService prpLConfigurationService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimDto prpLClaimDto) {
        prpLClaimService.save(prpLClaimDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo) {
        prpLClaimService.remove(claimNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimDto prpLClaimDto) {
        prpLClaimService.modify(prpLClaimDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimDto queryByPK(@RequestBody String claimNo) {
        return prpLClaimService.queryByPK(claimNo);
    }

    /**
     * （理赔打印 列表查询接口）
     * @author: 王志文
     * @date: 2017/11/20 17:43
     * @param claimPrintDto 页面输入框输入数据
     * @return 分页数据列表
     */
    @Override
    public PageInfo queryListByPrintType(@RequestBody ClaimPrintDto claimPrintDto)  throws Exception{
        return prpLClaimService.queryAgriByPrintType(claimPrintDto);
    }

    /**
     * （根据保单号查询PrpLClaim表）
     * @author: 王志文
     * @date: 2017/11/21 10:44
     * @param policyNo 保单号
     * @return PrpLClaimDto 的集合
     */
    @Override
    public List<PrpLClaimDto> queryByPolicyNo(String policyNo)throws Exception {
        return prpLClaimService.queryByPolicyNo(policyNo);
    }
    /**
     * （根据立案号、报案号、保单号查询结案登记页面详细信息）
     * @param prpLClaimDto （只有立案号、报案号、保单号）
     * @return 结案登记展示页面相关信息
     * @author: 董坤
     * @date: 2017/11/11 10:41
     */
    @Override
    public @ResponseBody PrpLClaimEndCaseDto queryEndCaseDetailByCondition(@RequestBody PrpLClaimDto prpLClaimDto) throws Exception{
        PrpLClaimEndCaseDto prpLClaimEndCaseDto = prpLClaimService.queryEndCaseDetailByCondition(prpLClaimDto);
        return prpLClaimEndCaseDto;
    }

    /**
     * （结案登记页面详细信息保存）
     * @param prpLClaimEndCaseDto 结案登记展示页面相关信息
     * @return 结案信息保存成功与否信息
     * @author: 董坤
     * @date: 2017/11/13 14:31
     */
    @Override
    public @ResponseBody
    Map<String,String> saveEndCaseInfo(@RequestBody PrpLClaimEndCaseDto prpLClaimEndCaseDto) throws Exception{
        String message = prpLClaimService.saveEndCaseInfo(prpLClaimEndCaseDto);
        Map<String,String> map = new HashMap<>();
        map.put("message",message);
        return map;
    }
}
