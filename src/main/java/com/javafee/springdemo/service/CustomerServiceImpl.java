package com.javafee.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javafee.springdemo.dao.CustomerDao;
import com.javafee.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public List<Customer> searchCustomersByName(String name) {
		return customerDao.searchCustomersByName(name);
	}

	@Transactional
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	@Transactional
	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	@Transactional
	@Override
	public void deleteCustomerById(int id) {
		customerDao.deleteCustomerById(id);
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
}
