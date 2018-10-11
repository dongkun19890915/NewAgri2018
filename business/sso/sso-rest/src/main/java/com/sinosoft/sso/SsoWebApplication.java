package com.sinosoft.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableDiscoveryClient
@EnableCircuitBreaker
@ServletComponentScan("com.sinosoft.sso.api")
@EnableFeignClients(basePackages = {"com.sinosoft.ims.api"})
@SpringBootApplication(scanBasePackages = {
        "com.sinosoft.sso",
        "com.sinosoft.framework"
})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class SsoWebApplication {
    @RequestMapping
    public String home() {
        return "sso-service";
    }

    public static void main(String[] args) {
        SpringApplication.run(SsoWebApplication.class, args);
    }

}
