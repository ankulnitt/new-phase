package com.abc.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abc.dao.CustomerDAO;
import com.abc.exception.ApplicationException;
import com.abc.model.Customer;
import com.abc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Value("${max}")
	private int max;
	
	@Value("${min}")
	private int min;

	@Autowired
	private CustomerDAO customerDao;
	@Override
	public String registerCustomer(Customer customer) throws ApplicationException {
		String customerId = "";
		try {
			customerId = generateCustomerId();
			System.out.println("Customer Id : " + customerId);
			customer.setCustomerId(customerId);
			customerDao.registerCustomer(customer);
		} catch (ApplicationException applicationException) {
			throw new ApplicationException(applicationException);
		}
		return customerId;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.getCustomerById(customerId);
	}

	private String generateCustomerId() {
		StringBuilder customerIdBuilder = new StringBuilder("abc00");
		Random random = new Random();
		int randomNo = random.ints(min, (max + 1)).findFirst().getAsInt();
		customerIdBuilder.append(randomNo);
		return customerIdBuilder.toString();
	}

}
