package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 特别约定表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = PrpCengageApi.PATH)
public interface PrpCengageApi {

    public static final String PATH = "prpCEngage";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpCengageDto prpCEngageDto);

    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpCengageDto prpCEngageDto);

    /**
     * @description: （保单抄件通过保单号查找特别约定）
     * @author: 王志文
     * @date: 2017/11/16 8:51
     * @param policyNo
     * @return
     */
    @RequestMapping(value = "queryEngageByPolicyNo",method = {RequestMethod.POST})
    List<PrpCengageDto> queryEngageByPolicyNo(@RequestParam("policyNo") String policyNo);
}