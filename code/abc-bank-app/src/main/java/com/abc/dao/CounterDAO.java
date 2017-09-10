package com.abc.dao;

import java.util.List;

import com.abc.model.ServiceCounter;

public interface CounterDAO {

	List<ServiceCounter> getCounters();
	
	ServiceCounter getCounterById(int counterId);
	
}
