package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfPathLogApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathLogService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathLogDto;
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
 * @description 工作流路径日志表controller层
 */
@RestController
@RequestMapping(value = SwfPathLogController.PATH)
public class SwfPathLogController implements SwfPathLogApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfPathLogController.class);

    @Autowired
    private SwfPathLogService swfPathLogService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfPathLogDto swfPathLogDto) {
        swfPathLogService.save(swfPathLogDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String flowId,java.lang.Integer pathNo) {
        swfPathLogService.remove(flowId,pathNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfPathLogDto swfPathLogDto) {
        swfPathLogService.modify(swfPathLogDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPathLogDto queryByPK(@RequestBody String flowId,java.lang.Integer pathNo) {
        return swfPathLogService.queryByPK(flowId,pathNo);
    }
}
