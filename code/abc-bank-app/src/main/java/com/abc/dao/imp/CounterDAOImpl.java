package com.abc.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.abc.dao.CounterDAO;
import com.abc.model.ServiceCounter;

@Repository
public class CounterDAOImpl implements CounterDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ServiceCounter> getCounters() {
		final TypedQuery<ServiceCounter> gridsQuery = entityManager
				.createQuery("select c from ServiceCounter c", ServiceCounter.class);
		List<ServiceCounter> counters = gridsQuery.getResultList();
		return counters;
	}

	@Override
	public ServiceCounter getCounterById(int counterId) {
		return entityManager.find(ServiceCounter.class, counterId);
	}
}
