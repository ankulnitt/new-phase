package com.abc.service;

import java.util.Map;
import java.util.Queue;

import com.abc.model.ServiceCounter;
import com.abc.model.Token;

/**
 * 
 * @author ankul
 * @Puspose This interface to be implemented by counter service providers
 */
public interface CounterService {

	/**
	 * API to get counters with tokens queue associated with it.
	 * 
	 * @return
	 */
	Map<Integer, Queue<Token>> getCounters();

	/**
	 * @Purpose API to provide actual service implementation.
	 * @param token
	 *            {@link Token}
	 * @return served status.
	 */
	boolean serve(Token token);

	/**
	 * This method is for updating counter. Updating counter means update
	 * available tokens on given counter at any period of time. This method will
	 * be called while generating token. In token generation, token will be
	 * assigned to a counter. So a new token would be added into this counter's
	 * token's queue. This method should be synchronized.
	 * 
	 * @param counterId
	 * @return
	 */
	boolean updateCounter(int counterId);

	/**
	 * API to assign counter to token.
	 * @param token 
	 */
	void assignTokenToCounter(Token token);

	
	ServiceCounter getCounterById(int counterId);
}
