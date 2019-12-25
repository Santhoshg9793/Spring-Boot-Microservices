/**
 * 
 */
package com.rolemanagement.microservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Santhosh
 *
 */
@ConfigurationProperties(prefix = "role-service")
@Component
@Data
public class RoleConfiguration {

	private Integer roleId;
	private String roleName;
	private String description;
}
