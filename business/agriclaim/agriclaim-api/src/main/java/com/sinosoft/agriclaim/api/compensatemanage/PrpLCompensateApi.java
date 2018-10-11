package com.sinosoft.agriclaim.api.compensatemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算书表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCompensateApi.PATH)
public interface PrpLCompensateApi {

    public static final String PATH = "prpLCompensate";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLCompensateDto prpLCompensateDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String compensateNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLCompensateDto prpLCompensateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCompensateDto queryByPK(String compensateNo);

    /**
     * 承保清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/28 17:47
     * @param param policyNo 保单号
     * @return 下载链接
     * @throws Exception
     */
    @RequestMapping(value = "expNyxPolicyList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> expNyxPolicyList(@RequestBody Map<String,String> param) throws Exception;


    /**
     *  根据立案号查询PrpLCompensate信息
     * @author: 周柯宇
     * @date: 2017-12-7 17:02:49
     * @param proposalNo 投保单号
     * @return prpLCompensateDtoList  返回赔款计算书表表Dto集合
     */
    @RequestMapping(value = "queryClaimNo",method = {RequestMethod.POST})
    @ResponseBody
    public List<PrpLCompensateDto> queryClaimNo(@RequestParam("claimNo") String claimNo) throws Exception;

    /**
     * （按险种代码查询理算数据）
     * @author: 王志文
     * @date: 2018/3/28 16:02
     * @param riskCode
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryByRiskCode",method = {RequestMethod.POST})
    List<PrpLCompensateDto> queryByRiskCode(@RequestParam("riskCode") String riskCode)throws Exception;
}