package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.PrplReturnVisitSwflogApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.PrplReturnVisitSwflogService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrplReturnVisitSwflogDto;
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
 * @time  2017-11-10 02:50:26.122 
 * @description 回访工作流表controller层
 */
@RestController
@RequestMapping(value = PrplReturnVisitSwflogController.PATH)
public class PrplReturnVisitSwflogController implements PrplReturnVisitSwflogApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrplReturnVisitSwflogController.class);

    @Autowired
    private PrplReturnVisitSwflogService prplReturnVisitSwflogService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrplReturnVisitSwflogDto prplReturnVisitSwflogDto) {
        prplReturnVisitSwflogService.save(prplReturnVisitSwflogDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String businessNo,String nodeType) {
        prplReturnVisitSwflogService.remove(businessNo,nodeType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrplReturnVisitSwflogDto prplReturnVisitSwflogDto) {
        prplReturnVisitSwflogService.modify(prplReturnVisitSwflogDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrplReturnVisitSwflogDto queryByPK(@RequestBody String businessNo,String nodeType) {
        return prplReturnVisitSwflogService.queryByPK(businessNo,nodeType);
    }
}
