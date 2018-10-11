package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiMenuTaskApi;
import com.sinosoft.ims.api.auth.dto.UtiMenuTaskDto;
import com.sinosoft.ims.core.auth.service.UtiMenuTaskService;
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
 * @description UtiMenuTaskcontroller层
 */
@RestController
@RequestMapping(value = UtiMenuTaskController.PATH)
public class UtiMenuTaskController implements UtiMenuTaskApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiMenuTaskController.class);

    @Autowired
    private UtiMenuTaskService utiMenuTaskService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiMenuTaskDto utiMenuTaskDto) {
        utiMenuTaskService.save(utiMenuTaskDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String menuId) {
        utiMenuTaskService.remove(menuId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiMenuTaskDto utiMenuTaskDto) {
        utiMenuTaskService.modify(utiMenuTaskDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiMenuTaskDto queryByPK(@RequestBody String menuId) {
        return utiMenuTaskService.queryByPK(menuId);
    }
}
