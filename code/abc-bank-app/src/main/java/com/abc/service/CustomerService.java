package com.abc.service;

import com.abc.exception.ApplicationException;
import com.abc.model.Customer;

/**
 * 
 * @author ankul
 * @purpose Interface is responsible for provide service APIs to manages
 *          customers information like registration.
 */
public interface CustomerService {

	/**
	 * @Purpose API to register new customer in application.
	 * @param customer
	 *            {@link Customer}
	 * @return String customer id
	 * @throws ApplicationException
	 *             If some database error occures.
	 */
	String registerCustomer(Customer customer) throws ApplicationException;

	/**
	 * @Purpose API to get customer details by customer id.
	 * @param customerId
	 *            {@link String} customer id.
	 * @return {@link Customer}
	 */
	Customer getCustomerById(String customerId);
}
