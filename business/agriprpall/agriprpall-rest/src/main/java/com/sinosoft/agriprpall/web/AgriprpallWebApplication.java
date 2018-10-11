package com.sinosoft.agriprpall.web;

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

@EnableScheduling
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.sinosoft.txnlist.api", "com.sinosoft.dms.api", "com.sinosoft.ims.api", "com.sinosoft.pms.api", "com.sinosoft.notice.api", "com.sinosoft.agriclaim.api"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sinosoft.agriprpall.core",repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = {"com.sinosoft.agriprpall.core","com.sinosoft.framework"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.agriprpall","com.sinosoft.framework"})
public class AgriprpallWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriprpallWebApplication.class, args);
	}
}
