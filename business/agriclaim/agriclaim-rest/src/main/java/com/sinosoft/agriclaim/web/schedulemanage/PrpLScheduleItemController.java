package com.sinosoft.agriclaim.web.schedulemanage;

import com.sinosoft.agriclaim.api.schedulemanage.PrpLScheduleItemApi;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleItemService;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleItemDto;
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
 * @time  2017-11-08 05:45:58.930 
 * @description 调度任务标的表controller层
 */
@RestController
@RequestMapping(value = PrpLScheduleItemController.PATH)
public class PrpLScheduleItemController implements PrpLScheduleItemApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleItemController.class);

    @Autowired
    private PrpLScheduleItemService prpLScheduleItemService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLScheduleItemDto prpLScheduleItemDto) {
        prpLScheduleItemService.save(prpLScheduleItemDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo) {
        prpLScheduleItemService.remove(scheduleId,registNo,itemNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLScheduleItemDto prpLScheduleItemDto) {
        prpLScheduleItemService.modify(prpLScheduleItemDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleItemDto queryByPK(@RequestBody java.lang.Integer scheduleId,String registNo,java.lang.Integer itemNo) {
        return prpLScheduleItemService.queryByPK(scheduleId,registNo,itemNo);
    }
}
