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
@FeignClient(name = "rolemanagement-zuul-server",contextId = "employee-service")
@RibbonClient(name = "employee-service")
public interface EmployeeService {


	@RequestMapping(value = "/employee-service/employee/{empId}")
	public EmployeeRole getEmployeeDetails(@PathVariable Integer empId);

}
