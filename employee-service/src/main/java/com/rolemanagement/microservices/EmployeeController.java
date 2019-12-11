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
public class EmployeeController {

	private static Logger log = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping(value = "/employee/{empId}", method=RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable Integer empId) {
		log.info("Inside getEmployeeDetails method");
		return employeeRepository.getOne(empId);
	}

}
