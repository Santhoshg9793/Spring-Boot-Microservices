/**
 * 
 */
package com.rolemanagement.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Santhosh
 *
 */
@RestController
public class RoleController {
	private static Logger log = LoggerFactory.getLogger(RoleController.class);


	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/role/{roleName}", method=RequestMethod.GET)
	public Role getRoleByName(@PathVariable String roleName) {
		log.info("Inside getRoleByName method");
		return roleRepository.findByRoleName(roleName);
	}

}
