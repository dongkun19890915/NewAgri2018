package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDcertifycheckDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-04 09:05:54.250 
 * @description 单证校验信息表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcertifycheckApi.PATH)
public interface PrpDcertifycheckApi {

    public static final String PATH = "prpDcertifycheck";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpDcertifycheckDto prpDcertifycheckDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String riskCode,String nodeType,String certifyType);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDcertifycheckDto prpDcertifycheckDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcertifycheckDto queryByPK(String riskCode,String nodeType,String certifyType);
}