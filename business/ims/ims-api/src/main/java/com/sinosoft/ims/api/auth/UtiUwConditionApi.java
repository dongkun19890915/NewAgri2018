package com.sinosoft.ims.api.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiUwConditionDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:11:08.689 
 * @description UtiUwConditionApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiUwConditionApi.PATH)
public interface UtiUwConditionApi {

    public static final String PATH = "utiUwCondition";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiUwConditionDto utiUwConditionDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String classCode, String uwType, String factorCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiUwConditionDto utiUwConditionDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiUwConditionDto queryByPK(String comCode, Integer modelNo, Integer nodeNo, String riskCode, String classCode, String uwType, String factorCode);
}