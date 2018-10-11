package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLInvestigateDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 案情调查信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLInvestigateApi.PATH)
public interface PrpLInvestigateApi {

    public static final String PATH = "prpLInvestigate";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLInvestigateDto prpLInvestigateDto);


    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("registNo") String registNo,@RequestParam("serialNo")java.lang.Double serialNo,@RequestParam("objectType")String objectType);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLInvestigateDto prpLInvestigateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLInvestigateDto queryByPK(@RequestParam("registNo") String registNo,@RequestParam("serialNo")java.lang.Double serialNo,@RequestParam("objectType")String objectType);

    /**
     * 调查流程节点
     * @author: 孙朋飞
     * @date: 2018/2/22 10:43
     * @param nodeStatus 节点状态
     * @param registNo 报案号
     * @param handlerCode 处理人代码
     * @param handlerName 处理人名称
     * @param userComCode 用户机构代码
     * @param userComCname 用户机构名称
     * @return 报案号
     * @throws Exception
     */
    @RequestMapping(value = "saveInvestigation",method = {RequestMethod.GET})
    public @ResponseBody Map<String,String> saveInvestigation(@RequestParam("registNo")String registNo,@RequestParam("nodeStatus")String nodeStatus,
                                                              @RequestParam("handlerCode") String handlerCode,@RequestParam("handlerName") String handlerName,
                                                              @RequestParam("userComCode") String userComCode,
                                                              @RequestParam("userComCname") String userComCname) throws Exception;

    /**
     * 发起调查
     * @author: 孙朋飞
     * @date: 2018/3/30 17:14
     * @param map 报案号registNo,保单号-policyNo,被调度人代码-nextHandlerCode，被调度人姓名-nextHandlerName
     * @return 发起调查成功
     * @throws Exception
     */
    @RequestMapping(value = "submitInvestigation",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String>  submitInvestigation(@RequestBody Map<String,String> map)throws Exception;

}