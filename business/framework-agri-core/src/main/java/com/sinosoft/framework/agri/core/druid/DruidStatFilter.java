package com.sinosoft.framework.agri.core.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @Package: pterosaur.account.config.filter
 * @Description: 拦截druid监控请求
 * @author: 周家伟
 * @date: 2018-03-19
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",initParams={@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")})
public class DruidStatFilter extends WebStatFilter {
}
