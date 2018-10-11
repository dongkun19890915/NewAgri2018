package com.sinosoft.agriclaim.web.schedulemanage;

import com.sinosoft.agriclaim.api.schedulemanage.PrpLScheduleMainWfApi;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainWfService;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainWfDto;
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
 * @description 调度任务/查勘任务主表controller层
 */
@RestController
@RequestMapping(value = PrpLScheduleMainWfController.PATH)
public class PrpLScheduleMainWfController implements PrpLScheduleMainWfApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleMainWfController.class);

    @Autowired
    private PrpLScheduleMainWfService prpLScheduleMainWfService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
        prpLScheduleMainWfService.save(prpLScheduleMainWfDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer scheduleId,String registNo) {
        prpLScheduleMainWfService.remove(scheduleId,registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLScheduleMainWfDto prpLScheduleMainWfDto) {
        prpLScheduleMainWfService.modify(prpLScheduleMainWfDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleMainWfDto queryByPK(@RequestBody java.lang.Integer scheduleId,String registNo) {
        return prpLScheduleMainWfService.queryByPK(scheduleId,registNo);
    }
}
