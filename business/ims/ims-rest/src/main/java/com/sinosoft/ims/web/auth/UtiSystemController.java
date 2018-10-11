package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiSystemApi;
import com.sinosoft.ims.api.auth.dto.UtiSystemDto;
import com.sinosoft.ims.core.auth.service.UtiSystemService;
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
 * @description UtiSystemcontroller层
 */
@RestController
@RequestMapping(value = UtiSystemController.PATH)
public class UtiSystemController implements UtiSystemApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiSystemController.class);

    @Autowired
    private UtiSystemService utiSystemService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiSystemDto utiSystemDto) {
        utiSystemService.save(utiSystemDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String utiSystem) {
        utiSystemService.remove(utiSystem);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiSystemDto utiSystemDto) {
        utiSystemService.modify(utiSystemDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSystemDto queryByPK(@RequestBody String utiSystem) {
        return utiSystemService.queryByPK(utiSystem);
    }
}
