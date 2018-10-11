package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 理赔查询免赔率接口
 * @author: 田健
 * @date: 2018/4/13 11:46
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ClaimQueryDeductiblerateApi.PATH)
public interface ClaimQueryDeductiblerateApi {
    public static final String PATH = "ClaimQueryDeductiblerate";

    /**
     *  根据保单号、标的、险别查询免赔率
     * @author: 田健
     * @date: 2018/4/13 11:48
     * @param map 中的key为保单号、标的、险别
     * @return
     */
    @RequestMapping(value = "queryDeductiblerate",method = {RequestMethod.POST})
    public @ResponseBody ClaimQueryDeductiblerateDto queryDeductiblerate(@RequestBody Map<String,String> map) throws Exception;
}
