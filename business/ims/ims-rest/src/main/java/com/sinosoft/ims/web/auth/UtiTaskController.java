package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiTaskApi;
import com.sinosoft.ims.api.auth.dto.UtiTaskDto;
import com.sinosoft.ims.core.auth.service.UtiTaskService;
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
 * @time  2017-11-05 01:10:45.148 
 * @description UtiTaskcontroller层
 */
@RestController
@RequestMapping(value = UtiTaskController.PATH)
public class UtiTaskController implements UtiTaskApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiTaskController.class);

    @Autowired
    private UtiTaskService utiTaskService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiTaskDto utiTaskDto) {
        utiTaskService.save(utiTaskDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String taskCode) {
        utiTaskService.remove(taskCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiTaskDto utiTaskDto) {
        utiTaskService.modify(utiTaskDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiTaskDto queryByPK(@RequestBody String taskCode) {
        return utiTaskService.queryByPK(taskCode);
    }
}
