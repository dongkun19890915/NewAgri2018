package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfLogStoreApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfLogStoreService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogStoreDto;
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
 * @description 工作流日志表1controller层
 */
@RestController
@RequestMapping(value = SwfLogStoreController.PATH)
public class SwfLogStoreController implements SwfLogStoreApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfLogStoreController.class);

    @Autowired
    private SwfLogStoreService swfLogStoreService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfLogStoreDto swfLogStoreDto) {
        swfLogStoreService.save(swfLogStoreDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String flowId,java.lang.Integer logNo) {
        swfLogStoreService.remove(flowId,logNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfLogStoreDto swfLogStoreDto) {
        swfLogStoreService.modify(swfLogStoreDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfLogStoreDto queryByPK(@RequestBody String flowId,java.lang.Integer logNo) {
        return swfLogStoreService.queryByPK(flowId,logNo);
    }
}
