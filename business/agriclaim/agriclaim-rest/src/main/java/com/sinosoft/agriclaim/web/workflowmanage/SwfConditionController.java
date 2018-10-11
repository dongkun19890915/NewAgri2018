package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfConditionApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfConditionService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfConditionDto;
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
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流条件描述表controller层
 */
@RestController
@RequestMapping(value = SwfConditionController.PATH)
public class SwfConditionController implements SwfConditionApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfConditionController.class);

    @Autowired
    private SwfConditionService swfConditionService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfConditionDto swfConditionDto) {
        swfConditionService.save(swfConditionDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo) {
        swfConditionService.remove(modelNo,pathNo,conditionNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfConditionDto swfConditionDto) {
        swfConditionService.modify(swfConditionDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfConditionDto queryByPK(@RequestBody java.lang.Integer modelNo,java.lang.Integer pathNo,java.lang.Integer conditionNo,java.lang.Integer serialNo) {
        return swfConditionService.queryByPK(modelNo,pathNo,conditionNo,serialNo);
    }
}
