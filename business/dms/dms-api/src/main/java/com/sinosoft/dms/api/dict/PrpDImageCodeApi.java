package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDImageCodeDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-27 03:00:47.370 
 * @description 承保理赔镜像代码表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDImageCodeApi.PATH)
public interface PrpDImageCodeApi {

    public static final String PATH = "prpDImageCode";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDImageCodeDto prpDImageCodeDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam(value = "riskCode") String riskCode, @RequestParam(value = "comCode") String comCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDImageCodeDto prpDImageCodeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody
    PrpDImageCodeDto queryByPK(@RequestParam(value = "riskCode") String riskCode,@RequestParam(value = "comCode") String comCode);
}