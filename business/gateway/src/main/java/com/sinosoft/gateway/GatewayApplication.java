package com.sinosoft.gateway;

import com.sinosoft.gateway.filter.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@ServletComponentScan("com.sinosoft.sso.api")
@EnableFeignClients(basePackages = {"com.sinosoft.sso.api"})
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public TestFilter testFilter(){
	    return new TestFilter();
    }
}
