/**
 * 
 */
package com.rolemanagement.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Santhosh
 *
 */
@FeignClient(name = "rolemanagement-zuul-server",contextId = "role-service")
@RibbonClient(name = "role-service")
public interface RoleService {
	
	@RequestMapping(value = "/role-service/role/{roleName}")
	public EmployeeRole getRoleByName(@PathVariable String roleName);

}
