package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiPlatConfigApi;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigDto;
import com.sinosoft.ims.core.auth.service.UtiPlatConfigService;
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
 * @description UtiPlatConfigcontroller层
 */
@RestController
@RequestMapping(value = UtiPlatConfigController.PATH)
public class UtiPlatConfigController implements UtiPlatConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiPlatConfigController.class);

    @Autowired
    private UtiPlatConfigService utiPlatConfigService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiPlatConfigDto utiPlatConfigDto) {
        utiPlatConfigService.save(utiPlatConfigDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("systemCode") String systemCode,@RequestParam("paramCode")String paramCode) {
        utiPlatConfigService.remove(systemCode,paramCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiPlatConfigDto utiPlatConfigDto) {
        utiPlatConfigService.modify(utiPlatConfigDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiPlatConfigDto queryByPK(@RequestParam("systemCode")  String systemCode,@RequestParam("paramCode") String paramCode) {
        return utiPlatConfigService.queryByPK(systemCode,paramCode);
    }
}
