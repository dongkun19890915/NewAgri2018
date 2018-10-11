package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCvirturlItemApi.PATH)
public interface PrpCvirturlItemApi {

    public static final String PATH = "prpCvirturlItem";

    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 宋振振
     * @date: 2017/12/15 15:01
     * @param map PolicyNo保单号,FamilyNo分户序号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo",method = {RequestMethod.POST})
    public @ResponseBody List<PrpCvirturlItemDto> queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据policyNo保单号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 安齐崇
     * @date: 2018/1/24 15:01
     * @param map policyNo保单号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    @RequestMapping(value = "queryVirturlItemByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody List<PrpCvirturlItemDto> queryVirturlItemByPolicyNo(@RequestBody Map<String,String> map)throws Exception;

}
