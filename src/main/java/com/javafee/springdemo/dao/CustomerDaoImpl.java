package com.javafee.springdemo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javafee.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Customer order by lastName, firstName", Customer.class).getResultList();
	}

	@Override
	public List<Customer> searchCustomersByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query;
		if (name != null && name.trim().length() > 0) {
			query = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName");
			query.setParameter("theName", "%" + name.toLowerCase() + "%");
		} else
			query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Customer where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}
}
