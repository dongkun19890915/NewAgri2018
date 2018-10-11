package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiGroupRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiGroupRuleDto;
import com.sinosoft.ims.core.auth.service.UtiGroupRuleService;
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
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupRulecontroller层
 */
@RestController
@RequestMapping(value = UtiGroupRuleController.PATH)
public class UtiGroupRuleController implements UtiGroupRuleApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiGroupRuleController.class);

    @Autowired
    private UtiGroupRuleService utiGroupRuleService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiGroupRuleDto utiGroupRuleDto) {
        utiGroupRuleService.save(utiGroupRuleDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String groupCode,Integer serialNo) {
        utiGroupRuleService.remove(groupCode,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiGroupRuleDto utiGroupRuleDto) {
        utiGroupRuleService.modify(utiGroupRuleDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiGroupRuleDto queryByPK(@RequestBody String groupCode,Integer serialNo) {
        return utiGroupRuleService.queryByPK(groupCode,serialNo);
    }
}
