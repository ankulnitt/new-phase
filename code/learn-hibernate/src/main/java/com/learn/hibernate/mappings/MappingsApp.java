package com.learn.hibernate.mappings;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learn.hibernate.cache.model.HibernateUtil;
import com.learn.hibernate.mappings.manytoone.Order;
import com.learn.hibernate.mappings.manytoone.OrderItem;

public class MappingsApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		OrderItem order = getOrder();
		session.save(order);
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}

	private static OrderItem getOrder() {
		Order order = new Order();
//		order.setOrderId(12);
		order.setTotalPrice(123);
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(2);
		orderItem.setItemName("item1");
		orderItem.setOrder(order);
		
		return orderItem;
	}
}
