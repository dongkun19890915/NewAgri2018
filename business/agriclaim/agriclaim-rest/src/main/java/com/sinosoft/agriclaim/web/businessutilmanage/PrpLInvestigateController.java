package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLInvestigateApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLInvestigateDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLInvestigateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 案情调查信息表controller层
 */
@RestController
@RequestMapping(value = PrpLInvestigateController.PATH)
public class PrpLInvestigateController implements PrpLInvestigateApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLInvestigateController.class);

    @Autowired
    private PrpLInvestigateService prpLInvestigateService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLInvestigateDto prpLInvestigateDto) {
        prpLInvestigateService.save(prpLInvestigateDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("registNo") String registNo, @RequestParam("serialNo")java.lang.Double serialNo, @RequestParam("objectType")String objectType) {
        prpLInvestigateService.remove(registNo,serialNo,objectType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLInvestigateDto prpLInvestigateDto) {
        prpLInvestigateService.modify(prpLInvestigateDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLInvestigateDto queryByPK(@RequestParam("registNo") String registNo,@RequestParam("serialNo")java.lang.Double serialNo,@RequestParam("objectType")String objectType) {
        return prpLInvestigateService.queryByPK(registNo,serialNo,objectType);
    }
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
    @Override
    public @ResponseBody
    Map<String,String> saveInvestigation(@RequestParam("registNo")String registNo,@RequestParam("nodeStatus")String nodeStatus,
                             @RequestParam("handlerCode") String handlerCode, @RequestParam("handlerName") String handlerName,
                             @RequestParam("userComCode") String userComCode,
                             @RequestParam("userComCname") String userComCname) throws Exception{
        return prpLInvestigateService.saveInvestigation(registNo,nodeStatus,handlerCode,handlerName,userComCode,userComCname) ;
    }
    /**
     * 发起调查
     * @author: 孙朋飞
     * @date: 2018/3/30 17:14
     * @param map 报案号registNo,保单号-policyNo,被调度人代码-nextHandlerCode，被调度人姓名-nextHandlerName
     * @return 发起调查成功
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> submitInvestigation(@RequestBody Map<String, String> map) throws Exception {
        return prpLInvestigateService.submitInvestigation(map.get("registNo"),map.get("policyNo"),map.get("nextHandlerCode"),map.get("nextHandlerName"));
    }
}
