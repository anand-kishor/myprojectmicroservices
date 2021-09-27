package com.cloudm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigServer
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class SpringcloudmicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudmicroservicesApplication.class, args);
	}

}
