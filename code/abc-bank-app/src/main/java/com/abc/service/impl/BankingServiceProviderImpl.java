package com.abc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.dao.ServiceDAO;
import com.abc.model.BankingService;
import com.abc.service.BankingServiceProvider;

@Service
public class BankingServiceProviderImpl implements BankingServiceProvider {

	@Autowired
	private ServiceDAO serviceDAO;

	@Override
	public BankingService getServiceById(String serviceId) {
		return serviceDAO.getServiceById(serviceId);
	}

}
