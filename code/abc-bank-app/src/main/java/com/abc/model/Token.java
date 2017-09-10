package com.abc.model;

/**
 * 
 * @author ankul
 * @Purpose This class is responsible for holding token information. It'll have
 *          counter id, service id, and customer id associated with it.
 */
public class Token {

	/**
	 * Token status
	 */
	enum TokenStatus {
		NEW, COMPLETED, CANCELLED;
	}

	/**
	 * token id
	 */
	private int tokenId;

	/**
	 * customer id.
	 */
	private String customerId;

	/**
	 * token status.
	 */
	private String tokenStatus;

	/**
	 * service id.
	 */
	private String serviceId;

	/**
	 * Counter id.
	 */
	private int counterId;

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getTokenStatus() {
		return tokenStatus;
	}

	public void setTokenStatus(String tokenStatus) {
		this.tokenStatus = tokenStatus;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}
}
