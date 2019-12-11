/**
 * 
 */
package com.rolemanagement.microservices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Santhosh
 *
 */
@Entity
@Table(name = "employee_role")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ROLE_SEQ")
	@SequenceGenerator(name = "EMPLOYEE_ROLE_SEQ", sequenceName = "EMPLOYEE_ROLE_SEQ", allocationSize = 1)
	@Column(name = "id")
	private Integer id;

	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "role_id")
	private Integer roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "description")
	private String description;

}
