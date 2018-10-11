package com.sinosoft.agriclaim.web.cetainmanage;

import com.sinosoft.agriclaim.api.cetainmanage.PrpLCetainLossApi;
import com.sinosoft.agriclaim.core.cetainmanage.service.PrpLCetainLossService;
import com.sinosoft.agriclaim.api.cetainmanage.dto.PrpLCetainLossDto;
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
 * @time  2017-11-08 05:36:28.690 
 * @description 确定损失表（无表名）controller层
 */
@RestController
@RequestMapping(value = PrpLCetainLossController.PATH)
public class PrpLCetainLossController implements PrpLCetainLossApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCetainLossController.class);

    @Autowired
    private PrpLCetainLossService prpLCetainLossService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCetainLossDto prpLCetainLossDto) {
        prpLCetainLossService.save(prpLCetainLossDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Double id) {
        prpLCetainLossService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCetainLossDto prpLCetainLossDto) {
        prpLCetainLossService.modify(prpLCetainLossDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCetainLossDto queryByPK(@RequestBody java.lang.Double id) {
        return prpLCetainLossService.queryByPK(id);
    }
}
