package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.WorkFlowRecApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.WorkFlowRecService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.WorkFlowRecDto;
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
 * @description 流程监控表controller层
 */
@RestController
@RequestMapping(value = WorkFlowRecController.PATH)
public class WorkFlowRecController implements WorkFlowRecApi {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkFlowRecController.class);

    @Autowired
    private WorkFlowRecService workFlowRecService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody WorkFlowRecDto workFlowRecDto) {
        workFlowRecService.save(workFlowRecDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String nodeCode,String businessNo,java.lang.Integer serialNo) {
        workFlowRecService.remove(nodeCode,businessNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody WorkFlowRecDto workFlowRecDto) {
        workFlowRecService.modify(workFlowRecDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public WorkFlowRecDto queryByPK(@RequestBody String nodeCode,String businessNo,java.lang.Integer serialNo) {
        return workFlowRecService.queryByPK(nodeCode,businessNo,serialNo);
    }
}
