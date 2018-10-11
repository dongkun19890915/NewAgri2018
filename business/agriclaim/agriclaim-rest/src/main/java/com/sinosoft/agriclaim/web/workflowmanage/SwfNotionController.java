package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfNotionApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.ResponseSwfNotionInfoDto;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNotionService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNotionDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 处理意见表controller层
 */
@RestController
@RequestMapping(value = SwfNotionController.PATH)
public class SwfNotionController implements SwfNotionApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfNotionController.class);

    @Autowired
    private SwfNotionService swfNotionService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfNotionDto swfNotionDto) {
        swfNotionService.save(swfNotionDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String flowId,java.lang.Integer logNo,java.lang.Integer lineNo) {
        swfNotionService.remove(flowId,logNo,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfNotionDto swfNotionDto) {
        swfNotionService.modify(swfNotionDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfNotionDto queryByPK(@RequestBody String flowId,java.lang.Integer logNo,java.lang.Integer lineNo) {
        return swfNotionService.queryByPK(flowId,logNo,lineNo);
    }
    /**
     * 根据流程编号和序号查询审核意见
     * @author: 孙朋飞
     * @date: 2018/4/26 19:37
     * @param map businessNo-流程id
     * @return 审核意见的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<ResponseSwfNotionInfoDto> querySwfNotionByFlowId(@RequestBody Map<String, String> map) throws Exception {
        return swfNotionService.querySwfNotionByFlowId(map.get("businessNo"));
    }
}
