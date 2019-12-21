/**
 * 
 */
package com.rolemanagement.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Santhosh
 *
 */
@RestController
@EnableHystrix
public class RoleController {
	private static Logger log = LoggerFactory.getLogger(RoleController.class);


	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/role/{roleName}", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getRoleByNameFallback")
	public Role getRoleByName(@PathVariable String roleName) {
		log.info("Inside getRoleByName method");
		Role role=roleRepository.findByRoleName(roleName);
		role.getRoleId();//Added to simulate fault tolerance incase if we pass data npt on DB
		return role;
	}
	
	public Role getRoleByNameFallback(@PathVariable String roleName) {
		return Role.builder().roleId(0).roleName("Default Role").description("This is default system role").build();
	}

}
