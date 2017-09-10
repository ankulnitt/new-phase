package com.abc.dao;

import com.abc.model.BankingService;

public interface ServiceDAO {

	BankingService getServiceById(String serviceId);
}
