package com.abc.service;

import com.abc.model.Token;

/**
 * @author ankul
 * @Purpose This interface to be implemented by token consumers.
 *
 */
public interface Consumer {
	/**
	 * 
	 * @param token
	 *            {@link Token} to be processed.
	 * @return boolean status.
	 */
	public boolean consume(Token token);

	/**
	 * Notify token generator.
	 */
	public void finishConsumption();
}
