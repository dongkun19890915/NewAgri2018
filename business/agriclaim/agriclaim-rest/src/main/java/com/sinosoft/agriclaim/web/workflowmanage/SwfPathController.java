package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfPathApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPathService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPathDto;
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
 * @description 工作流路径定义表controller层
 */
@RestController
@RequestMapping(value = SwfPathController.PATH)
public class SwfPathController implements SwfPathApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfPathController.class);

    @Autowired
    private SwfPathService swfPathService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfPathDto swfPathDto) {
        swfPathService.save(swfPathDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer modelNo,java.lang.Integer pathNo) {
        swfPathService.remove(modelNo,pathNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfPathDto swfPathDto) {
        swfPathService.modify(swfPathDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPathDto queryByPK(@RequestBody java.lang.Integer modelNo,java.lang.Integer pathNo) {
        return swfPathService.queryByPK(modelNo,pathNo);
    }
}
