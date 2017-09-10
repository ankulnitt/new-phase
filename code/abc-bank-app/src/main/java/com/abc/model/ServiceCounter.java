package com.abc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author ankul
 * This class is responsible for counters to provide actual service.
 *
 */
@Entity
@Table(name = "service_counter")
public class ServiceCounter {

	/*
	 * type of counters.
	 */
	enum CounterType {
		NORMAL, PRIVILEGED;
	}

	/*
	 * Counter Id
	 */
	@Id
	@Column(name = "counter_id")
	private int counterId;

	/*
	 * Counter is used for which service.
	 */
	@Column(name = "purpose")
	private String purpose;

	/**
	 * Counter type.
	 */
	@Column(name = "counter_type")
	private String counterType;
	
	@Column(name="operator")
	private String operator;
	
	/*
	 * Service provide by counter.
	 */
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="service_id")
	private BankingService service;

	
	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCounterType() {
		return counterType;
	}

	public void setCounterType(String counterType) {
		this.counterType = counterType;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public BankingService getService() {
		return service;
	}
	
	public void setService(BankingService service) {
		this.service = service;
	}
	
//	public Queue<Token> getTokens() {
//		return tokens;
//	}
//	
//	public void setTokens(Queue<Token> tokens) {
//		this.tokens = tokens;
//	}
//	
//	public void addToken(Token token){
//		this.tokens.add(token);
//	}
}
