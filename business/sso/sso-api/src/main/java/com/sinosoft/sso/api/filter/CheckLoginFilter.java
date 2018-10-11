package com.sinosoft.sso.api.filter;

import com.sinosoft.sso.api.AuthApi;
import com.sinosoft.sso.api.dto.AuthResp;
import com.sinosoft.sso.api.dto.UserInfo;
import com.sinosoft.sso.api.util.ConstantUtil;
import com.sinosoft.sso.api.util.UrlConcat;
import com.sinosoft.sso.api.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by gaofeng on 2017/8/24.
 */
@WebFilter(urlPatterns = "/*")
public class CheckLoginFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(CheckLoginFilter.class);
    @Value("${filter.none.path}")
    private String noneFilter ;

    private String tokenVerifyURL = null; // 单点登陆系统验证地址

    private String tokenCancelURL=null; //token注销接口地址

    private List<String> notCheckURLList = new ArrayList<String>(); //白名单

    private String loginURL = null; //登陆地址

    @Value("${token.maxAge}")
    private String maxAge = null;

    private String logoutURL = null; //注销地址

    private int cookieMaxAge = ConstantUtil.COOKIE_MAX_AGE;

    @Value("${sso.url}")
    private String ssoUrl ;

    @Autowired
    private AuthApi authApi;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
        logger.info("into CheckLoginFilter:"+uri);
        //白名单中不需要校验
        if(!needCheck(uri)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //回写token的请求
        String token = null;//票据
        if(uri.equals(ConstantUtil.COOKIE_PATH)){//回写Cookie地址
            System.out.println("开始回写地址了........高");
            token = request.getParameter("token");
            if(token != null && !"".equals(token)){
                logger.debug("开始回写Cookie");
                Cookie cookie = new Cookie(ConstantUtil.COOKIE_NAME, token);
                cookie.setMaxAge(cookieMaxAge);
                cookie.setPath("/");
                response.addCookie(cookie);
                response.setStatus(200);
                response.setHeader("P3P", "CP=\"NOI ADM DEV COM NAV OUR\""); //解决ie8、9cookie无法跨域写问题
                try {
                    response.getWriter().write("successCallback({\"oss\":\"sinosoft\"})");
                    response.getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                logger.error("token参数为空，无法回写cookie");
                response.setStatus(400);
                response.setHeader(ConstantUtil.RESP_MSG_HEADER_NAME, "token参数为空，无法回写cookie");
            }
            return;
        }

        //获取cookie中的Token
        token = WebUtil.getTokenFromCookie(request);

        //是否为注销登陆请求---如果前台注销指定/api/sso/logout
        if(uri.equals(ConstantUtil.LOGOUT_PATH) || uri.equals("/api/sso"+ConstantUtil.LOGOUT_PATH)){//注销登陆地址
            try{
                UserInfo user = cancelToken(token);
                if(user == null){
                    response.setHeader(ConstantUtil.RESP_MSG_HEADER_NAME,"已注销或登陆已失效");
                }else{
                    response.setHeader(ConstantUtil.RESP_MSG_HEADER_NAME, "注销成功");

                }
                response.setStatus(300); //重定向到登陆页面 //汪强修改 300改301
                //response.setHeader("Location",loginURL);//汪强修改 增加
                response.setHeader("RedirectLocation",loginURL); //汪强修改
                //response.setHeader("RedirectLocation",logoutURL);
                //logger.debug("注销登陆:{}",user.getUserCode());
                return;
            }catch(Exception e){
                response.setStatus(500); //服务内部错误
                response.setHeader(ConstantUtil.RESP_MSG_HEADER_NAME, "调用token注销服务异常");
                logger.error("调用token注销服务异常", e);
                return;
            }
        }

        //校验token是否有效(调用sso系统)
        try
        {
            UserInfo user = validToken(token);//TODO 汪强修改 避免登录验证 网关转发
            ////1、注释掉上面一行代码 UserInfo user = validToken(token);
            ////2、放开下面三行代码
//            UserInfo user=new UserInfo();
//            user.setUserCode("340501");//TODO  汪强修改 临时添加 免登录测试使用
//            user.setUserName("政策性农险公司业务");//TODO  汪强修改 临时添加  免登录测试使用
//            user.setLoginComCode("3400000000");//TODO  汪强修改 临时添加  免登录测试使用

            /**
             * 无效的Token返回未授权状态，并返回登陆认证页面地址
             * 因为前端是ajax调用，此处不能直接用redirect，需前端根据此信息处理跳转
             */
            if(user == null)
            {
                logger.info("未授权的访问:token="+token);
                response.setStatus(401); //未授权的访问
                response.setHeader(ConstantUtil.AUTH_URL_HEADER_NAME,  loginURL+"?"+ConstantUtil.AUTH_URL_PARAM_NAME+"=");
                return;
            }else{
                logger.info("通过授权认证:token="+token);
                //通过认证，将当前的用户信息放到request中，供后续逻辑使用
                request.setAttribute(ConstantUtil.USER_ATTRIBE_NAME, user);
                //每次访问都需要重新设置cookie
                Cookie cookie = new Cookie(ConstantUtil.COOKIE_NAME, token);
                cookie.setMaxAge(cookieMaxAge);
                cookie.setPath("/");
                response.addCookie(cookie);
                response.setStatus(200);
                response.setHeader("P3P", "CP=\"NOI ADM DEV COM NAV OUR\""); //解决ie8、9cookie无法跨域写问题
            }
        }
        catch (Exception e)
        {
            logger.error("调用token验证服务异常",e);
            response.setStatus(500); //服务内部错误
            response.setHeader(ConstantUtil.RESP_MSG_HEADER_NAME, "调用token验证服务异常");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * @description 校验白名单过滤
     * @param uri 待校验的uri地址
     * @return boolean
     * @author ZhangJiansen
     * @date 2016年9月30日下午5:15:37
     */
    private boolean needCheck(String uri){
        AntPathMatcher matcher = new AntPathMatcher();
        for(String url:notCheckURLList){
            if(matcher.match(url, uri) || uri.indexOf(url)==0){
                logger.debug("url {} doesn't need check",uri);
                return false;
            }
        }
        logger.debug("url {} need check",uri);
        return true;
    }

    /**
     *
     * @description 调用sso系统校验token有效性<p>
     *                       如果配置了dubbo服务，则通过rpc调用<br>
     *                       如果未配置dubbo，则通过http调用
     * @param token token信息
     * @return UserInfo
     * @author ZhangJiansen
     * @throws Exception
     * @date 2016年9月30日下午5:12:25
     */
    private UserInfo validToken(String token) throws Exception
    {
        logger.info("into 1 validToken");
        UserInfo userinfo = null;
        //增加空判断
        if(StringUtils.isEmpty(token)){
            return null;
        }

        /*if(SpringContextUtil.getApplicationContext() != null){*/
        if(true){
            logger.debug("SpringContextUtil is not null");

            AuthResp resp = null;
            if (null != token) {
                resp = authApi.validToken(token);
            }
            if(resp == null || !resp.getRetCode().equals("200")){
                logger.info("validToken: valid");
                return null;
            }else{
                logger.debug("validToken: invalid");
                return resp.getUserInfo();
            }
        }

        //没有用dubbo，直接使用http接口
        String urlStr = tokenVerifyURL+"?token=" + token;
        URL url;
        HttpURLConnection httpConnection;
        int returnCode;
        try {
            logger.debug("interact with sso by http");
            url = new URL(urlStr);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");// 设置请求方式
            httpConnection.setDoOutput(true); // 设置允许输出
            httpConnection.setDoInput(true);
            httpConnection.setUseCaches(false); // 设置不用缓存
            httpConnection.setConnectTimeout(6000);
            httpConnection.setReadTimeout(6000);

            httpConnection.connect();
            returnCode = httpConnection.getResponseCode(); // 查看请求是否成功

            if (returnCode == HttpURLConnection.HTTP_OK) {// 请求发送成功
                //todo 后面解决
                /*Object obj = new ObjectInputStream(httpConnection.getInputStream()).readObject();
                ObjectInputStream ois = new ObjectInputStream(httpConnection.getInputStream());
                userinfo = (UserInfo) ois.readObject();
                ois.close();*/
            }else{
                logger.error("调用校验token接口错误,statuscode={},urlStr={}",returnCode,urlStr);
            }

            httpConnection.disconnect();

            return userinfo;
        }catch (Exception e){
            logger.error("调用单点登录系统异常",e);
            throw e;
        }
    }

    /**
     *
     * @description 调用sso系统注销token<p>
     *                       如果配置了dubbo服务，则通过rpc调用<br>
     *                       如果未配置dubbo，则通过http调用
     * @param token token信息
     * @return UserInfo
     * @author ZhangJiansen
     * @throws Exception
     * @date 2016年9月30日下午5:12:25
     */
    private UserInfo cancelToken(String token) throws Exception
    {
        UserInfo userinfo = null;

        //使用dubbo接口调用
        /*if(SpringContextUtil.getApplicationContext() != null){*/
        if(true){
            logger.debug("SpringContextUtil is not null");
            AuthResp resp = authApi.logout(token);
            if(resp == null || !resp.getRetCode().equals("200")){
                return null;
            }else{
                return resp.getUserInfo();
            }
        }

        //没有用dubbo，直接使用http接口
        String urlStr = tokenCancelURL+"?token=" + token;
        URL url;
        HttpURLConnection httpConnection;
        int returnCode;
        try {
            logger.debug("interact with sso by http");
            url = new URL(urlStr);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");// 设置请求方式
            httpConnection.setDoOutput(true); // 设置允许输出
            httpConnection.setDoInput(true);
            httpConnection.setUseCaches(false); // 设置不用缓存
            httpConnection.setConnectTimeout(6000);
            httpConnection.setReadTimeout(6000);

            httpConnection.connect();
            returnCode = httpConnection.getResponseCode(); // 查看请求是否成功

            if (returnCode == HttpURLConnection.HTTP_OK) {// 请求发送成功
                ObjectInputStream ois = new ObjectInputStream(httpConnection.getInputStream());
                userinfo = (UserInfo) ois.readObject();
                ois.close();
            }else{
                logger.error("调用注销token接口错误,statuscode={},urlStr={}",returnCode,urlStr);
            }

            httpConnection.disconnect();

            return userinfo;
        }catch (Exception e){
            logger.error("调用单点登录系统异常",e);
            throw e;
        }
    }

    /**
     *
     * @description 拼接url
     * @param url
     * @param suffix
     * @return
     * @author ZhangJiansen
     * @date 2016年10月9日下午4:20:35
     */
    private String concatUrl(String url, String suffix){
        if(url.endsWith("/")){
            return url+suffix;
        }else{
            return url+"/"+suffix;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        loginURL = concatUrl(concatUrl(ssoUrl, ConstantUtil.SSO_PAGE_REQ_PATH),ConstantUtil.SSO_PAGE_LOGIN_REQ_PATH);
        logoutURL = concatUrl(concatUrl(ssoUrl,ConstantUtil.SSO_PAGE_REQ_PATH),ConstantUtil.SSO_PAGE_LOGOUT_REQ_PATH);
        tokenVerifyURL = concatUrl(concatUrl(ssoUrl,ConstantUtil.SSO_API_REQ_PATH),ConstantUtil.SSO_API_VALID_REQ_PATH);
        tokenCancelURL= UrlConcat.instance(ssoUrl)
                .concat(ConstantUtil.SSO_API_REQ_PATH)
                .concat(ConstantUtil.SSO_API_LOGOUT_REQ_PATH)
                .getUrl();
        logger.debug("*************单点登录系统taoken超时时间*****************maxAge="+maxAge);
        if(maxAge != null && !maxAge.isEmpty()){
            cookieMaxAge = Integer.parseInt(maxAge);
        }

        if(noneFilter != null){
            StringTokenizer st = new StringTokenizer(noneFilter, ",");
            notCheckURLList.clear();
            while(st.hasMoreTokens()){
                notCheckURLList.add(st.nextToken());
            }
        }
        logger.debug("*************单点登录过滤器初始化结束*****************");
    }

    @Override
    public void destroy() {
        notCheckURLList.clear();
    }
}
