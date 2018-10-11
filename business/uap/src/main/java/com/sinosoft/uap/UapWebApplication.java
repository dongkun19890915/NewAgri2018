package com.sinosoft.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.sinosoft.demo.api","com.sinosoft.txnlist.api","com.sinosoft.ims.api","com.sinosoft.agriclaim.api","com.sinosoft.agriprpall.api"})
@SpringBootApplication(scanBasePackages={"com.sinosoft.uap"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class UapWebApplication {
	public static void main(String[] args) {

		SpringApplication.run(UapWebApplication.class, args);
	}
}
