/**
 * 
 */
package com.rolemanagement.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santhosh
 *
 */
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Integer> {

}
