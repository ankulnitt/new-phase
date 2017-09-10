package com.abc.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author ankul Class is used for type of services available in ABC bank.
 *
 */
@Entity(name = "service")
public class BankingService {

	/*
	 * Service id
	 */
	@Id
	@Column(name = "service_id")
	private String serviceId;

	/*
	 * type of activity like cash deposit, withdraw etc.
	 */
	@Column(name = "activity")
	private String activity;

	/*
	 * Comment provided by operator.
	 */
	@Column(name = "comment")
	private String comment;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_id")
	private BankingService parent;

	/*
	 * A bank service may have further sub-services. This list will have those
	 * sub-services of a bank.
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
	private List<BankingService> subordinates = new LinkedList<>();

	/*
	 * A service can have specific counters or it can be performed on multiple
	 * counter. so this list will have list of counters associated with a
	 * service.
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "service")
	private List<ServiceCounter> counters;

	
	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BankingService getParent() {
		return parent;
	}

	public void setParent(BankingService parent) {
		this.parent = parent;
	}

	public List<BankingService> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<BankingService> subordinates) {
		this.subordinates = subordinates;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public List<ServiceCounter> getCounters() {
		return counters;
	}

	public void setCounters(List<ServiceCounter> counters) {
		this.counters = counters;
	}

}
