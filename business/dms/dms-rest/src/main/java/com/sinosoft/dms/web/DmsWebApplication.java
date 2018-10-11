package com.sinosoft.dms.web;

import com.sinosoft.framework.core.dao.JpaBaseDaoFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.sinosoft.agriprpall.api","com.sinosoft.ims.api","com.sinosoft.pms.api","com.sinosoft.txnlist.api","com.sinosoft.agriclaim.api"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.sinosoft.dms.core","com.sinosoft.txnlist.api"},repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = {"com.sinosoft.dms.core","com.sinosoft.framework"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.dms","com.sinosoft.framework"})
public class DmsWebApplication {

    private Logger logger = LoggerFactory.getLogger(DmsWebApplication.class);

	public static void main(String[] args) {
        new SpringApplicationBuilder(DmsWebApplication.class).web(true).run(args);
	}
}
