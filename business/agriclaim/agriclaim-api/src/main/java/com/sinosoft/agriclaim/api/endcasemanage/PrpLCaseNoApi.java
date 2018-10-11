package com.sinosoft.agriclaim.api.endcasemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.endcasemanage.dto.PrpLCaseNoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:42:04.174 
 * @description 赔案号表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCaseNoApi.PATH)
public interface PrpLCaseNoApi {

    public static final String PATH = "prpLCaseNo";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLCaseNoDto prpLCaseNoDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("certiNo") String certiNo,@RequestParam("certiType")String certiType,@RequestParam("caseNo")String caseNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLCaseNoDto prpLCaseNoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCaseNoDto queryByPK(@RequestParam("certiNo") String certiNo,@RequestParam("certiType")String certiType,@RequestParam("caseNo")String caseNo);

    /**
     * @author jiaoyunzhen
     * @serialData 2017年12月22日09:40:29
     */
    @RequestMapping(value = "count",method = {RequestMethod.POST})
    int count(@RequestParam("caseNo") String caseNo, @RequestParam("strCaseNo") String strCaseNo);

}