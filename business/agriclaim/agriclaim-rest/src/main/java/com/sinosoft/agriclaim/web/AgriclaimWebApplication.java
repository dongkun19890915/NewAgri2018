package com.sinosoft.agriclaim.web;

import com.sinosoft.framework.core.dao.JpaBaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.sinosoft.dms.api","com.sinosoft.txnlist.api","com.sinosoft.agriprpall.api","com.sinosoft.ims.api","com.sinosoft.pms.api","com.sinosoft.notice.api"})
@EnableTransactionManagement
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.sinosoft.agriclaim.core",repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = {"com.sinosoft.agriclaim.core","com.sinosoft.framework"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.agriclaim","com.sinosoft.framework"})
public class AgriclaimWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriclaimWebApplication.class, args);
	}
}
