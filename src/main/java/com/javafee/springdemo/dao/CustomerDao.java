package com.javafee.springdemo.dao;

import java.util.List;

import com.javafee.springdemo.entity.Customer;

public interface CustomerDao {
	List<Customer> getCustomers();

	List<Customer> searchCustomersByName(String name);

	Customer getCustomerById(int id);

	void deleteCustomer(Customer customer);

	void deleteCustomerById(int id);

	void saveCustomer(Customer customer);
}
