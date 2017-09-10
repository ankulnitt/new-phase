package com.abc.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.abc.dao.CustomerDAO;
import com.abc.exception.ApplicationException;
import com.abc.model.Customer;

@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void registerCustomer(Customer customer) throws ApplicationException {
		try {
			entityManager.persist(customer);
		} catch (Exception exception) {
			
			throw new ApplicationException(exception);
		}
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return entityManager.find(Customer.class, customerId);
	}

}
