package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiSysParamApi;
import com.sinosoft.ims.api.auth.dto.UtiSysParamDto;
import com.sinosoft.ims.core.auth.service.UtiSysParamService;
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
 * @description UtiSysParamcontroller层
 */
@RestController
@RequestMapping(value = UtiSysParamController.PATH)
public class UtiSysParamController implements UtiSysParamApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiSysParamController.class);

    @Autowired
    private UtiSysParamService utiSysParamService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiSysParamDto utiSysParamDto) {
        utiSysParamService.save(utiSysParamDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String systemCode,String paramCode) {
        utiSysParamService.remove(systemCode,paramCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiSysParamDto utiSysParamDto) {
        utiSysParamService.modify(utiSysParamDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSysParamDto queryByPK(@RequestBody String systemCode,String paramCode) {
        return utiSysParamService.queryByPK(systemCode,paramCode);
    }
}
