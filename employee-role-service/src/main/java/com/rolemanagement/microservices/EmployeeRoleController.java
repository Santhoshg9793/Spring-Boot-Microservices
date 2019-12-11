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
public class EmployeeRoleController {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeRoleController.class);


	@Autowired
	private EmployeeRoleRepository employeeRoleRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/employee/{empId}/role/{roleName}", method=RequestMethod.GET)
	public void saveEmployeeDetails(@PathVariable Integer empId, @PathVariable String roleName) {
		log.info("Inside saveEmployeeDetails method");

		EmployeeRole employeeRole = new EmployeeRole();
		EmployeeRole roleEntity = new EmployeeRole();

		employeeRole = employeeService.getEmployeeDetails(empId);
		roleEntity = roleService.getRoleByName(roleName);

		employeeRole.setRoleId(roleEntity.getRoleId());
		employeeRole.setRoleName(roleEntity.getRoleName());

		employeeRoleRepository.save(employeeRole);
	}

}
