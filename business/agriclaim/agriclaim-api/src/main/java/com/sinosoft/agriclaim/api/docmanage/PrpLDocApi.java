package com.sinosoft.agriclaim.api.docmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListDto;
import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListRequestDto;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLDocDto;
import com.sinosoft.agriclaim.api.docmanage.dto.SaveCertifyDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 索赔单证信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLDocApi.PATH)
public interface PrpLDocApi {

    public static final String PATH = "prpLDoc";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLDocDto prpLDocDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String claimNo,String docCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLDocDto prpLDocDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLDocDto queryByPK(String claimNo,String docCode);
    @RequestMapping(value = "queryClaimList", method = RequestMethod.POST)
    @ResponseBody
    public ClaimListDto queryClaimList(ClaimListRequestDto requestDto) throws Exception;
    /**
     * @description:方法功能简述: 索赔清单保存
     * @author 安齐崇
     * @date 2017年12月8日下午5:53:05
     * @param requestDto 请求参数dto
     * @return map 响应信息
     */
    @RequestMapping(value = "saveCertify", method = RequestMethod.POST)
    @ResponseBody
    Map<String,String> saveCertify(@RequestBody SaveCertifyDto requestDto);
}