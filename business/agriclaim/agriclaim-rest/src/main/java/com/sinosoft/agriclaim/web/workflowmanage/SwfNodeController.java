package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfNodeApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfNodeService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfNodeDto;
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
 * @description 工作流节点定义表controller层
 */
@RestController
@RequestMapping(value = SwfNodeController.PATH)
public class SwfNodeController implements SwfNodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfNodeController.class);

    @Autowired
    private SwfNodeService swfNodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfNodeDto swfNodeDto) {
        swfNodeService.save(swfNodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer modelNo,java.lang.Integer nodeNo) {
        swfNodeService.remove(modelNo,nodeNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfNodeDto swfNodeDto) {
        swfNodeService.modify(swfNodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfNodeDto queryByPK(@RequestBody java.lang.Integer modelNo,java.lang.Integer nodeNo) {
        return swfNodeService.queryByPK(modelNo,nodeNo);
    }
}
