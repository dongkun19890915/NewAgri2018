package com.sinosoft.demo.web;

import com.sinosoft.framework.core.dao.JpaBaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@ServletComponentScan
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sinosoft.demo.core",repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = {"com.sinosoft.demo.core","com.sinosoft.framework"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.demo","com.sinosoft.framework"})
public class DemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}
}
