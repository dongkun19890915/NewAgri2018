package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiConfigApi;
import com.sinosoft.ims.api.auth.dto.UtiConfigDto;
import com.sinosoft.ims.core.auth.service.UtiConfigService;
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
 * @time  2017-11-05 01:10:12.703 
 * @description UtiConfigcontroller层
 */
@RestController
@RequestMapping(value = UtiConfigController.PATH)
public class UtiConfigController implements UtiConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiConfigController.class);

    @Autowired
    private UtiConfigService utiConfigService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiConfigDto utiConfigDto) {
        utiConfigService.save(utiConfigDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String configCode) {
        utiConfigService.remove(configCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiConfigDto utiConfigDto) {
        utiConfigService.modify(utiConfigDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiConfigDto queryByPK(@RequestBody String configCode) {
        return utiConfigService.queryByPK(configCode);
    }
}
