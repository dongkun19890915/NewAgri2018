package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfModelUseApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfModelUseService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelUseDto;
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
 * @description 模板使用设置controller层
 */
@RestController
@RequestMapping(value = SwfModelUseController.PATH)
public class SwfModelUseController implements SwfModelUseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfModelUseController.class);

    @Autowired
    private SwfModelUseService swfModelUseService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfModelUseDto swfModelUseDto) {
        swfModelUseService.save(swfModelUseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer modelNo,String riskCode,String comCode,String modelType) {
        swfModelUseService.remove(modelNo,riskCode,comCode,modelType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfModelUseDto swfModelUseDto) {
        swfModelUseService.modify(swfModelUseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfModelUseDto queryByPK(@RequestBody java.lang.Integer modelNo,String riskCode,String comCode,String modelType) {
        return swfModelUseService.queryByPK(modelNo,riskCode,comCode,modelType);
    }
}
