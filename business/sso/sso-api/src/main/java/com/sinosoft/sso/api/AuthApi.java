package com.sinosoft.sso.api;

import com.sinosoft.sso.SSOConstant;
import com.sinosoft.sso.api.dto.AuthResp;
import com.sinosoft.sso.api.util.ConstantUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangJiansen
 * @description 权限验证
 * @date 2016年9月30日下午5:39:30
 */
@FeignClient(name = SSOConstant.SSO_SERVICE_NAME, path = AuthApi.PATH)
public interface AuthApi {

    String PATH = ConstantUtil.SSO_API_REQ_PATH;

    @RequestMapping(value = "valid", method = RequestMethod.POST)
    AuthResp validToken(String token);

    @RequestMapping(value = "status", method = RequestMethod.GET)
    AuthResp checkLogin(HttpServletRequest request);

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    AuthResp logout(@CookieValue(value=ConstantUtil.COOKIE_NAME,required=false) String token)throws Exception;

    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    AuthResp getLoginUserInfo(String token);

    /**
     * 修改用户密码
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @RequestMapping(value = "modifypwd", method = RequestMethod.GET)
    Map<String,String> modifypwd(@RequestParam("oldpwd") String oldpwd, @RequestParam("oldpwd") String newpwd)throws Exception;
}
