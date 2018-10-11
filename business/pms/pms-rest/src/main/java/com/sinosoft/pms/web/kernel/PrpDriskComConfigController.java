package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDriskComConfigApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskComConfigDto;
import com.sinosoft.pms.core.kernel.service.PrpDriskComConfigService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDriskComConfigcontroller层
 */
@RestController
@RequestMapping(value = PrpDriskComConfigController.PATH)
public class PrpDriskComConfigController implements PrpDriskComConfigApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskComConfigController.class);

    @Autowired
    private PrpDriskComConfigService prpDriskComConfigService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDriskComConfigDto prpDriskComConfigDto) {
        prpDriskComConfigService.save(prpDriskComConfigDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody java.util.Date id) {
        prpDriskComConfigService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDriskComConfigDto prpDriskComConfigDto) {
        prpDriskComConfigService.modify(prpDriskComConfigDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDriskComConfigDto queryByPK(@RequestBody java.util.Date id) {
        return prpDriskComConfigService.queryByPK(id);
    }
}
