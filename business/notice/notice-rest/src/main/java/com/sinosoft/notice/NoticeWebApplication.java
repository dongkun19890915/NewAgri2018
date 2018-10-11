package com.sinosoft.notice;

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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaofeng on 2017/7/28.
 */

@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableScheduling
@EnableFeignClients(basePackages = {"com.sinosoft.dms.api", "com.sinosoft.txnlist.api", "com.sinosoft.dms.api", "com.sinosoft.ims.api"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sinosoft.notice.core",repositoryFactoryBeanClass= JpaBaseDaoFactoryBean.class)
@EntityScan(basePackages = "com.sinosoft.notice.core")
@SpringBootApplication(scanBasePackages={"com.sinosoft.notice","com.sinosoft.framework"})
public class NoticeWebApplication {

    private Logger logger = LoggerFactory.getLogger(NoticeWebApplication.class);

    @RequestMapping
    public String home(){
        return "notice-rest";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(NoticeWebApplication.class).web(true).run(args);
    }
}
