package com.sinosoft.admin.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.ListConfig;
import com.hazelcast.config.MapConfig;
import de.codecentric.boot.admin.discovery.DefaultServiceInstanceConverter;
import de.codecentric.boot.admin.discovery.ServiceInstanceConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason on 2017/8/24.
 */
@Configuration
public class HazelcastConfigurer {
    @Bean
    public Config hazelcastConfig() {
        return new Config().setProperty("hazelcast.jmx", "true")
                .addMapConfig(new MapConfig("spring-boot-admin-application-store").setBackupCount(1)
                        .setEvictionPolicy(EvictionPolicy.NONE))
                .addListConfig(new ListConfig("spring-boot-admin-event-store").setBackupCount(1)
                        .setMaxSize(1000));
    }

    @Bean
    public ServiceInstanceConverter serviceInstanceConverter(){
        return new DefaultServiceInstanceConverter();
    }
}
