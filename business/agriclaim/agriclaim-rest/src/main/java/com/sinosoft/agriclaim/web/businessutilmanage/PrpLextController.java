package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLextApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLextService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLextDto;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔扩展系统表controller层
 */
@RestController
@RequestMapping(value = PrpLextController.PATH)
public class PrpLextController implements PrpLextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLextController.class);

    @Autowired
    private PrpLextService prpLextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLextDto prpLextDto) {
        prpLextService.save(prpLextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String certiNo,String certiType) {
        prpLextService.remove(certiNo,certiType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLextDto prpLextDto) {
        prpLextService.modify(prpLextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLextDto queryByPK(@RequestBody String certiNo,String certiType) {
        return prpLextService.queryByPK(certiNo,certiType);
    }
}
