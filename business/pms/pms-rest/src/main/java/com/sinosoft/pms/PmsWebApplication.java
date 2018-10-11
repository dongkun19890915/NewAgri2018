package com.sinosoft.pms;

import com.sinosoft.framework.core.dao.JpaBaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sinosoft.pms.core",repositoryFactoryBeanClass = JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = "com.sinosoft.pms.core")
@EnableFeignClients(basePackages={"com.sinosoft.pms.api","com.sinosoft.ims","com.sinosoft.dms"})
@SpringBootApplication(scanBasePackages={
		"com.sinosoft.pms",
		"com.sinosoft.framework"
})
public class PmsWebApplication {
	@RequestMapping
	public String home(){
		return "pms-rest";
	}

	public static void main(String[] args) {
		SpringApplication.run(PmsWebApplication.class, args);
	}

}
