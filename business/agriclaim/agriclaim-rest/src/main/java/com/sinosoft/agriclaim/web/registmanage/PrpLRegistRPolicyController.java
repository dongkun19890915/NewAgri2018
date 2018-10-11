package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistRPolicyApi;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistRPolicyService;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistRPolicyDto;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 赔案保单关联表controller层
 */
@RestController
@RequestMapping(value = PrpLRegistRPolicyController.PATH)
public class PrpLRegistRPolicyController implements PrpLRegistRPolicyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRegistRPolicyController.class);

    @Autowired
    private PrpLRegistRPolicyService prpLRegistRPolicyService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
        prpLRegistRPolicyService.save(prpLRegistRPolicyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String policyNo) {
        prpLRegistRPolicyService.remove(registNo,policyNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
        prpLRegistRPolicyService.modify(prpLRegistRPolicyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistRPolicyDto queryByPK(@RequestBody String registNo,String policyNo) {
        return prpLRegistRPolicyService.queryByPK(registNo,policyNo);
    }
}
