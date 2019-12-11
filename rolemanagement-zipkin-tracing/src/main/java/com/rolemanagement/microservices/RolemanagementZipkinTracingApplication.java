package com.rolemanagement.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class RolemanagementZipkinTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RolemanagementZipkinTracingApplication.class, args);
	}

}
