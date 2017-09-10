package com.abc.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.abc.dao.CounterDAO;
import com.abc.dao.ServiceDAO;
import com.abc.model.BankingService;
import com.abc.model.ServiceCounter;
import com.abc.model.Token;
import com.abc.service.CounterService;

@org.springframework.stereotype.Service
public class CounterServiceImpl implements CounterService {

	/**
	 * List of available counters throughout the application. Get counter from
	 * this list and then add token in counter.
	 */
	private static Map<Integer, Queue<Token>> availableCounters;
	@Autowired
	private CounterDAO counterDAO;

	@Autowired
	private ServiceDAO serviceDAO;

	@PostConstruct
	public void initialize() {
		availableCounters = new ConcurrentHashMap<>();
		List<ServiceCounter> counters = counterDAO.getCounters();
		if (!CollectionUtils.isEmpty(counters))
			for (ServiceCounter counter : counters) {
				availableCounters.put(counter.getCounterId(), new LinkedList<Token>());
			}
	}

	@Override
	public Map<Integer, Queue<Token>> getCounters() {
		return availableCounters;
	}

	@Override
	public boolean serve(Token token) {
		String serviceId = token.getServiceId();
		BankingService service = serviceDAO.getServiceById(serviceId);
		List<BankingService> subordinates = service.getSubordinates();
		for(BankingService service1 : subordinates) {
			service1.getActivity();
			System.out.println(service1.getActivity() + " performed ");
			System.out.println("comment added by ");
		}
		System.out.println(service.getActivity() + " performed ");
		return true;
	}

	@Override
	public synchronized boolean updateCounter(int counterId) {

		return false;
	}

	@Override
	public void assignTokenToCounter(Token token) {
		BankingService service = serviceDAO.getServiceById(token.getServiceId());
		List<ServiceCounter> counters = service.getCounters();
		int counterId = 0;
		int min = Integer.MAX_VALUE;
		// below logic is for getting right counter. this should have some
		// business logic. below implementation is not very efficient.
		//TODO provide better logic here.
		for (ServiceCounter counter : counters) {
			Queue<Token> tokenQues = availableCounters.get(counter.getCounterId());
			if (tokenQues.size() <= min) {
				min = tokenQues.size();
				counterId = counter.getCounterId();
			}
		}
		Queue<Token> tokens = availableCounters.get(counterId);
		token.setCounterId(counterId);
		tokens.add(token);
	}

	@Override
	public ServiceCounter getCounterById(int counterId) {
		return counterDAO.getCounterById(counterId);
	}

}
