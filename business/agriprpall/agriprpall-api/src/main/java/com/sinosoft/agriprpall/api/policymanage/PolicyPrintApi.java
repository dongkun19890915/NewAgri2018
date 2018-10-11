package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.ResItemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseItemKindDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524 
 * @description 保单标的子险信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PolicyPrintApi.PATH)
public interface PolicyPrintApi {

    public static final String PATH = "policymanage";

    /**
     * @description: 根据保单号查询主险信息
     * @author: 何伟东
     * @date: 2017/10/22 16:10
     * @param policyNo
     * @return
     */
    @GetMapping(value = "queryMainItemKindListByPolicyNo")
    public @ResponseBody
    ResItemKindDto queryMainItemKindListByPolicyNo(@RequestParam(value = "policyNo") String policyNo);

    /**
     * @description: 根据保单号查询附件险信息
     * @author: 何伟东
     * @date: 2017/10/22 16:10
     * @param policyNo
     * @return
     */
    @GetMapping(value = "querySubItemKindListByPolicyNo")
    public @ResponseBody
    ResItemKindDto querySubItemKindListByPolicyNo(@RequestParam(value = "policyNo") String policyNo);

}