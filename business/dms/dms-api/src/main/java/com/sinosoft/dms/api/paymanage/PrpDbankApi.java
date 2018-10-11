package com.sinosoft.dms.api.paymanage;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.paymanage.dto.PrpDbankDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * @description 银行定义表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDbankApi.PATH)
public interface PrpDbankApi {

    public static final String PATH = "prpDBank";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDbankDto prpDBankDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("bankCode") String bankCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDbankDto prpDBankDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody
    PrpDbankDto queryByPK(@RequestParam("bankCode") String bankCode);
    @RequestMapping(value = "getBanklist",method = {RequestMethod.POST})
    @ResponseBody
	List<PrpDbankDto> getBanklist(@RequestBody Map<String, String> map_banklist);
}