package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDfacConfigApi;
import com.sinosoft.ims.api.kernel.dto.PrpDfacConfigDto;
import com.sinosoft.ims.core.kernel.service.PrpDfacConfigService;
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
 * @description 临分权限控制表controller层
 */
@RestController
@RequestMapping(value = PrpDfacConfigController.PATH)
public class PrpDfacConfigController implements PrpDfacConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDfacConfigController.class);

    @Autowired
    private PrpDfacConfigService prpDfacConfigService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDfacConfigDto prpDfacConfigDto) {
        prpDfacConfigService.save(prpDfacConfigDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String id) {
        prpDfacConfigService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDfacConfigDto prpDfacConfigDto) {
        prpDfacConfigService.modify(prpDfacConfigDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDfacConfigDto queryByPK(@RequestBody String id) {
        return prpDfacConfigService.queryByPK(id);
    }
}
