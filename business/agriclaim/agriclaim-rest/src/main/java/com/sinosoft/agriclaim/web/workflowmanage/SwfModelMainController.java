package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfModelMainApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfModelMainService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfModelMainDto;
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
 * @description 模板主表controller层
 */
@RestController
@RequestMapping(value = SwfModelMainController.PATH)
public class SwfModelMainController implements SwfModelMainApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfModelMainController.class);

    @Autowired
    private SwfModelMainService swfModelMainService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfModelMainDto swfModelMainDto) {
        swfModelMainService.save(swfModelMainDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.lang.Integer modelNo) {
        swfModelMainService.remove(modelNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfModelMainDto swfModelMainDto) {
        swfModelMainService.modify(swfModelMainDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfModelMainDto queryByPK(@RequestBody java.lang.Integer modelNo) {
        return swfModelMainService.queryByPK(modelNo);
    }
}
