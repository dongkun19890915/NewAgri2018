package com.sinosoft.registry;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryApplication {

	public static void main(String[] args) {
	    new SpringApplicationBuilder(RegistryApplication.class).bannerMode(Banner.Mode.CONSOLE).web(true).run(args);
	}
}
