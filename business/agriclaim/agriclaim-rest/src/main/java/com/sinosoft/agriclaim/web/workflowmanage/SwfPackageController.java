package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.SwfPackageApi;
import com.sinosoft.agriclaim.core.workflowmanage.service.SwfPackageService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfPackageDto;
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
 * @description 工作流明细信息包表controller层
 */
@RestController
@RequestMapping(value = SwfPackageController.PATH)
public class SwfPackageController implements SwfPackageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SwfPackageController.class);

    @Autowired
    private SwfPackageService swfPackageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SwfPackageDto swfPackageDto) {
        swfPackageService.save(swfPackageDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String packageId,java.lang.Integer detailNo) {
        swfPackageService.remove(packageId,detailNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SwfPackageDto swfPackageDto) {
        swfPackageService.modify(swfPackageDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SwfPackageDto queryByPK(@RequestBody String packageId,java.lang.Integer detailNo) {
        return swfPackageService.queryByPK(packageId,detailNo);
    }
}
