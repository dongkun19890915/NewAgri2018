package com.sinosoft.agriclaim.api.workflowmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.ResponseSwfNotionInfoDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNotionDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 处理意见表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = SwfNotionApi.PATH)
public interface SwfNotionApi {

    public static final String PATH = "swfNotion";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(SwfNotionDto swfNotionDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(SwfNotionDto swfNotionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    SwfNotionDto queryByPK(String flowId,java.lang.Integer logNo,java.lang.Integer lineNo);

    /**
     * 根据流程编号和序号查询审核意见
     * @author: 孙朋飞
     * @date: 2018/4/26 19:37
     * @param map businessNo-流程id
     * @return 审核意见的集合
     * @throws Exception
     */
    @RequestMapping(value="querySwfNotionByFlowId",method = {RequestMethod.POST})
    public @ResponseBody List<ResponseSwfNotionInfoDto> querySwfNotionByFlowId(@RequestBody Map<String,String> map) throws Exception;
}