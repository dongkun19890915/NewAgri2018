package com.sinosoft.txnlist.web;

import com.sinosoft.framework.core.dao.JpaBaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.sinosoft.agriprpall.api", "com.sinosoft.agriclaim.api", "com.sinosoft.pms.api", "com.sinosoft.ims.api"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sinosoft.txnlist.core",repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = {"com.sinosoft.txnlist.core","com.sinosoft.framework"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.txnlist","com.sinosoft.framework"})
public class TxnListWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxnListWebApplication.class, args);
	}
}
