package com.abc.service;

import com.abc.model.BankingService;

public interface BankingServiceProvider {

	/**
	 * @Purpose 
	 * @param serviceId
	 * @return
	 */
	BankingService getServiceById(String serviceId);

}
