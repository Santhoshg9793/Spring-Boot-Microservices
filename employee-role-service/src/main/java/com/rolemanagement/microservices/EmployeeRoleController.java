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
	public ServiceResponse saveEmployeeDetails(@PathVariable Integer empId, @PathVariable String roleName) {
		log.info("Inside saveEmployeeDetails method");
		ServiceResponse res = new ServiceResponse();
		EmployeeRole employeeRole = new EmployeeRole();
		EmployeeRole roleEntity = new EmployeeRole();

		employeeRole = employeeService.getEmployeeDetails(empId);
		roleEntity = roleService.getRoleByName(roleName);

		if (roleEntity != null && employeeRole != null) {
			employeeRole.setRoleId(roleEntity.getRoleId());
			employeeRole.setRoleName(roleEntity.getRoleName());
			employeeRoleRepository.save(employeeRole);
			if (roleEntity.getRoleId() == 0) {
				res.setMessage("Role details are defaulted, please validate later!!");

			} else {
				res.setMessage("Saved successfully!!!");

			}
		} else {
			res.setMessage("Please enter valide data");

		}
		res.setStatus(200);
		return res;
	}

}
