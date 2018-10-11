package com.sinosoft.agriprpall.web.common;


import com.sinosoft.agriprpall.api.common.GYcoreUtilApi;
import com.sinosoft.framework.agri.core.gycore.GYcoreUtil;
import com.sinosoft.framework.agri.core.gycore.UserAreaRoleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * *公共封装
 * @Author: 田慧
 * @Date: 2017/12/13 17:40
 */
@RestController
@RequestMapping(value = GYcoreUtilController.PATH)
public class GYcoreUtilController implements GYcoreUtilApi{
    private static Logger LOGGER = LoggerFactory.getLogger(GYcoreUtilController.class);
    /**
     * 金禾webservice地址
     */
    @Value("${webservice.gycoreService.url}")
    private String gycoreService;
    /**
     * 获取用户区域权限 核心段获取用户区域权限，五级联选。
     * @author: 田健
     * @date: 2018/3/26 14:32
     * @param map 中得userCode为人员代码，parentID为区域代码，第一级代码为0
     * @return 区域代码集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<UserAreaRoleEntity> getUserRegion(@RequestBody Map<String,String> map) throws Exception {
        return new GYcoreUtil(gycoreService).getUserRegion(map.get("userCode"), map.get("parentID"));
    }

}
