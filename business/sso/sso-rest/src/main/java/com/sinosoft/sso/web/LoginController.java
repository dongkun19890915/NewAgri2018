package com.sinosoft.sso.web;

import com.sinosoft.sso.api.util.ConstantUtil;
import com.sinosoft.sso.api.util.UrlConcat;
import com.sinosoft.sso.core.entity.TokenInfo;
import com.sinosoft.sso.core.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * 
 * @description SSO系统操作功能
 * @author ZhangJiansen
 * @date 2016年9月30日下午4:40:51
 */
@Controller
@RequestMapping(ConstantUtil.SSO_PAGE_REQ_PATH)
public class LoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private TokenService tokenService;

    @Value("${front.url}")
    private String frontUrl ;
    
    /**
     * 
     * @description 直接访问SSO系统登录页
     * @param returnUrl 需要跳转的页面url
     * @return ModelAndView 返回登陆页面
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:41:25
     */
    @RequestMapping(ConstantUtil.SSO_PAGE_LOGIN_REQ_PATH)
    public ModelAndView login(@RequestParam(value=ConstantUtil.AUTH_URL_PARAM_NAME,required=false) String returnUrl, HttpServletRequest request){
        logger.debug("跳转登陆页面");
        ModelAndView mv = new ModelAndView();
        String logoutPath = UrlConcat.instance(ConstantUtil.SSO_PAGE_REQ_PATH)
                .concat(ConstantUtil.SSO_PAGE_LOGOUT_REQ_PATH)
                .getUrl();
        String authPath = UrlConcat.instance(ConstantUtil.SSO_API_REQ_PATH)
                .concat(ConstantUtil.SSO_API_AUTH_REQ_PATH)
                .getUrl();
        String statusPath = UrlConcat.instance(ConstantUtil.SSO_API_REQ_PATH)
                .concat(ConstantUtil.SSO_API_STATUS_REQ_PATH)
                .getUrl();
        String referer = request.getHeader("Referer");
        /*如果请求路径中未指定跳转路径，则使用上一页面的路径*/
        if(returnUrl==null || returnUrl.isEmpty()){
            returnUrl = referer;
        }
        mv.addObject("logoutPath", logoutPath);
        mv.addObject("authPath", authPath);
        mv.addObject("statusPath", statusPath);
        mv.addObject(ConstantUtil.AUTH_URL_PARAM_NAME, returnUrl);
        mv.setViewName("login");
        return mv;
    }
    
    //测试页面，可以删除
    @RequestMapping("test")
    public String index(){
        return "test";
    }
    
    /**
     * 
     * @description 提供页面上注销登陆功能
     * @param token 从cookie中获取token
     * @return ModelAndView 提示信息页面
     * @author ZhangJiansen
     * @date 2016年9月30日下午4:42:34
     */
    @RequestMapping(ConstantUtil.SSO_PAGE_LOGOUT_REQ_PATH)
    public ModelAndView logout(@CookieValue(value=ConstantUtil.COOKIE_NAME,required=false) String token)
    {

        logger.debug("注销登陆");
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("result");
    	
    	if(token == null || token.isEmpty()){
    	    logger.debug("还未登录");
    		mv.addObject("message", "还未登录");
        	//return mv;
        }
        
        TokenInfo info = tokenService.getToken(token);
        if(info == null){ 
            logger.debug("此token已注销过");     	
    		mv.addObject("message", "此token已注销过");
        	//return mv;
        }
        
        tokenService.deleteToken(token);
        
        logger.debug("注销登录成功");
		mv.addObject("message", "注销登录成功");
		
		//注销后统一跳转到单点登录界面， 其返回界面默认为gscore-front
		ResourceBundle bundle = ResourceBundle.getBundle("comm.config.application");  
        String frontUrl =  bundle.getString("front.url");
        String ssoUrl =  bundle.getString("sso.url");  
		return new ModelAndView("redirect:" + ssoUrl+"/login?"+ConstantUtil.AUTH_URL_PARAM_NAME+"="+frontUrl);
    }
    
}
