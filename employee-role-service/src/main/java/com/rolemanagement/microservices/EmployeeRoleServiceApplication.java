package com.rolemanagement.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.rolemanagement.microservices")
@EnableDiscoveryClient
public class EmployeeRoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRoleServiceApplication.class, args);
	}

}
