package com.abc.dao;

import com.abc.exception.ApplicationException;
import com.abc.model.Customer;

public interface CustomerDAO {

	public void registerCustomer(Customer customer) throws ApplicationException;
	
	public Customer getCustomerById(String customerId);
}
