package com.abc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Token;
import com.abc.service.CounterService;
import com.abc.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

	private static int tokenCount = 0;
	
	@Autowired
	private CounterService counterService;
	@Override
	public synchronized Token getToken(String customerId, String serviceId) {
		tokenCount++;
		Token token = new Token();
		token.setTokenId(tokenCount);
		token.setServiceId(serviceId);
		counterService.assignTokenToCounter(token);
		return token;
	}

	@Override
	public boolean updateToken(Token token) {
		// TODO Auto-generated method stub
		return false;
	}
}
