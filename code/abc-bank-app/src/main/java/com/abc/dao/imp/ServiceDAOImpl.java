package com.abc.dao.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.abc.dao.ServiceDAO;
import com.abc.model.BankingService;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public BankingService getServiceById(String serviceId) {
		return entityManager.find(BankingService.class, serviceId);
	}

}
