package com.sinosoft.framework.agri.core.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @Package: pterosaur.account.config.druid
 * @Description: 监控数据库性能
 * @author: 周家伟
 * @date: 2018-03-19
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),// IP白名单 (没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value=""),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="test"),// 用户名
                @WebInitParam(name="loginPassword",value="test"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet  extends StatViewServlet{
}
