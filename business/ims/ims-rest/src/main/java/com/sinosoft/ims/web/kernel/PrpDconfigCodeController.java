package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDconfigCodeApi;
import com.sinosoft.ims.api.kernel.dto.PrpDconfigCodeDto;
import com.sinosoft.ims.core.kernel.service.PrpDconfigCodeService;
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
 * @description 开关配置表controller层
 */
@RestController
@RequestMapping(value = PrpDconfigCodeController.PATH)
public class PrpDconfigCodeController implements PrpDconfigCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDconfigCodeController.class);

    @Autowired
    private PrpDconfigCodeService prpDconfigCodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDconfigCodeDto prpDconfigCodeDto) {
        prpDconfigCodeService.save(prpDconfigCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.util.Date id) {
        prpDconfigCodeService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDconfigCodeDto prpDconfigCodeDto) {
        prpDconfigCodeService.modify(prpDconfigCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDconfigCodeDto queryByPK(@RequestBody java.util.Date id) {
        return prpDconfigCodeService.queryByPK(id);
    }
}
