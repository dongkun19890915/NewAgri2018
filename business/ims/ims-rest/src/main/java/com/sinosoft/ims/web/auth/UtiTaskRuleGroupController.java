package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiTaskRuleGroupApi;
import com.sinosoft.ims.api.auth.dto.UtiTaskRuleGroupDto;
import com.sinosoft.ims.core.auth.service.UtiTaskRuleGroupService;
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
 * @description UtiTaskRuleGroupcontroller层
 */
@RestController
@RequestMapping(value = UtiTaskRuleGroupController.PATH)
public class UtiTaskRuleGroupController implements UtiTaskRuleGroupApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiTaskRuleGroupController.class);

    @Autowired
    private UtiTaskRuleGroupService utiTaskRuleGroupService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiTaskRuleGroupDto utiTaskRuleGroupDto) {
        utiTaskRuleGroupService.save(utiTaskRuleGroupDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String ruleGroupCode) {
        utiTaskRuleGroupService.remove(ruleGroupCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiTaskRuleGroupDto utiTaskRuleGroupDto) {
        utiTaskRuleGroupService.modify(utiTaskRuleGroupDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiTaskRuleGroupDto queryByPK(@RequestBody String ruleGroupCode) {
        return utiTaskRuleGroupService.queryByPK(ruleGroupCode);
    }
}
