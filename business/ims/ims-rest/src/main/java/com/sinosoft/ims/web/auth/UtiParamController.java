package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiParamApi;
import com.sinosoft.ims.api.auth.dto.UtiParamDto;
import com.sinosoft.ims.core.auth.service.UtiParamService;
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
 * @description UtiParamcontroller层
 */
@RestController
@RequestMapping(value = UtiParamController.PATH)
public class UtiParamController implements UtiParamApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiParamController.class);

    @Autowired
    private UtiParamService utiParamService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiParamDto utiParamDto) {
        utiParamService.save(utiParamDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String paramCode) {
        utiParamService.remove(paramCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiParamDto utiParamDto) {
        utiParamService.modify(utiParamDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiParamDto queryByPK(@RequestBody String paramCode) {
        return utiParamService.queryByPK(paramCode);
    }
}
