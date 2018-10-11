package com.sinosoft.agriclaim.web.schedulemanage;

import com.sinosoft.agriclaim.api.schedulemanage.PrpLScheduleMainApi;
import com.sinosoft.agriclaim.core.schedulemanage.service.PrpLScheduleMainService;
import com.sinosoft.agriclaim.api.schedulemanage.dto.PrpLScheduleMainDto;
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
 * @description 调度任务主表controller层
 */
@RestController
@RequestMapping(value = PrpLScheduleMainController.PATH)
public class PrpLScheduleMainController implements PrpLScheduleMainApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLScheduleMainController.class);

    @Autowired
    private PrpLScheduleMainService prpLScheduleMainService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLScheduleMainDto prpLScheduleMainDto) {
        prpLScheduleMainService.save(prpLScheduleMainDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Double scheduleId,String registNo,java.lang.Double serialNo) {
        prpLScheduleMainService.remove(scheduleId,registNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLScheduleMainDto prpLScheduleMainDto) {
        prpLScheduleMainService.modify(prpLScheduleMainDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLScheduleMainDto queryByPK(@RequestBody java.lang.Double scheduleId,String registNo,java.lang.Double serialNo) {
        return prpLScheduleMainService.queryByPK(scheduleId,registNo,serialNo);
    }
}
