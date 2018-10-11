package com.sinosoft.agriclaim.web.prepaymanage;

import com.sinosoft.agriclaim.api.prepaymanage.PrpLPreChargeApi;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPreChargeService;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPreChargeDto;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔费用信息表controller层
 */
@RestController
@RequestMapping(value = PrpLPreChargeController.PATH)
public class PrpLPreChargeController implements PrpLPreChargeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPreChargeController.class);

    @Autowired
    private PrpLPreChargeService prpLPreChargeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPreChargeDto prpLPreChargeDto) {
        prpLPreChargeService.save(prpLPreChargeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer id) {
        prpLPreChargeService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPreChargeDto prpLPreChargeDto) {
        prpLPreChargeService.modify(prpLPreChargeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPreChargeDto queryByPK(@RequestBody java.lang.Integer id) {
        return prpLPreChargeService.queryByPK(id);
    }
}
