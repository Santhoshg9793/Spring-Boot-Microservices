/**
 * 
 */
package com.rolemanagement.microservices;

import lombok.Data;

/**
 * @author Santhosh
 *
 */
@Data
public class ServiceResponse {

	private Integer status;
	private String error;
	private String message;
}
