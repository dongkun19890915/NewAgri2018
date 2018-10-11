package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLClaimPolicyApi;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimPolicyService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimPolicyDto;
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
 * @time  2017-11-08 05:39:53.061 
 * @description 立案保单清单表controller层
 */
@RestController
@RequestMapping(value = PrpLClaimPolicyController.PATH)
public class PrpLClaimPolicyController implements PrpLClaimPolicyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLClaimPolicyController.class);

    @Autowired
    private PrpLClaimPolicyService prpLClaimPolicyService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLClaimPolicyDto prpLClaimPolicyDto) {
        prpLClaimPolicyService.save(prpLClaimPolicyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo) {
        prpLClaimPolicyService.remove(claimNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLClaimPolicyDto prpLClaimPolicyDto) {
        prpLClaimPolicyService.modify(prpLClaimPolicyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimPolicyDto queryByPK(@RequestBody String claimNo) {
        return prpLClaimPolicyService.queryByPK(claimNo);
    }
}
