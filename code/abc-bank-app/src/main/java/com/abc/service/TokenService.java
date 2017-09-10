package com.abc.service;

import com.abc.model.Token;

/**
 * 
 * @author ankul
 * @purpose Interface to provide APIs to handle token related services.
 *
 */
public interface TokenService {

	/**
	 * @purpose API to get token by providing customer id and service id.
	 * @param customerId
	 *            {@link String} customer id
	 * @param serviceId
	 *            {@link String} service id
	 * @return {@link Token}
	 */
	Token getToken(String customerId, String serviceId);

	/**
	 * API to update token status.
	 * 
	 * @param token
	 * @return
	 */
	boolean updateToken(Token token);

}
