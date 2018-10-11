package com.sinosoft.agriprpall.api.common;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.agri.core.gycore.UserAreaRoleEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * *公共封装
 * @Author: 田慧
 * @Date: 2017/12/13 17:40
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = GYcoreUtilApi.PATH)

public interface GYcoreUtilApi {
    public static final String PATH = "GYcoreUtil";

    /**
     * 获取用户区域权限 核心段获取用户区域权限，五级联选。
     * @author: 田健
     * @date: 2018/3/26 14:32
     * @param map 中得userCode为人员代码，parentID为区域代码，第一级代码为0
     * @return 区域代码集合
     * @throws Exception
     */
    @RequestMapping(value = "getUserRegion",method = {RequestMethod.POST})
    public @ResponseBody List<UserAreaRoleEntity> getUserRegion(@RequestBody Map<String,String> map) throws Exception;
}
