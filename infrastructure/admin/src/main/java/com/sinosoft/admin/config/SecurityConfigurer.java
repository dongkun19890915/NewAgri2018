package com.sinosoft.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jason on 2017/8/24.
 */
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
        http.logout().logoutUrl("/logout");
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login.html","/**/*.css","/**/*.js","/**/*.html","/img/**","/third-party/**").permitAll();
                //.antMatchers("/api/applications/**").permitAll()
                //.antMatchers("/health","/info").permitAll();
        http.authorizeRequests()
                .antMatchers("/**").authenticated();
                /*.and().csrf().ignoringAntMatchers("/api*//**","/mgmt*//**").csrfTokenRepository(csrfTokenRepository())
                .and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);*/

        http.httpBasic();
    }

    /*@Bean
	@ConfigurationProperties("spring.boot.admin.auth")
	public BasicAuthFilter basicAuthFilter() {
		return new BasicAuthFilter();
	}*/

    private CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    private Filter csrfHeaderFilter(){
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                if(csrf != null){
                    Cookie cookie = WebUtils.getCookie(request,"XSRF-TOKEN");
                    String token = csrf.getToken();
                    if(cookie == null || token != null && !token.equals(cookie.getValue())){
                        cookie = new Cookie("XSRF-TOKEN", token);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }

                filterChain.doFilter(request, response);
            }
        };
    }
}
