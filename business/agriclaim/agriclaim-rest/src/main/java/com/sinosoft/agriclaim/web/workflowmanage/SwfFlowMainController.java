package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfFlowMainApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfFlowMainService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfFlowMainDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 流程主表controller层
 */
@RestController
@RequestMapping(value = SwfFlowMainController.PATH)
public class SwfFlowMainController implements SwfFlowMainApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfFlowMainController.class);

    @Autowired
    private SwfFlowMainService swfFlowMainService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfFlowMainDto swfFlowMainDto) {
        swfFlowMainService.save(swfFlowMainDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String flowId) {
        swfFlowMainService.remove(flowId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfFlowMainDto swfFlowMainDto) {
        swfFlowMainService.modify(swfFlowMainDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfFlowMainDto queryByPK(@RequestBody String flowId) {
        return swfFlowMainService.queryByPK(flowId);
    }
}
