package com.apache13.hibernatecache.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache13.hibernatecache.entity.Customer;
import com.apache13.hibernatecache.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Customer getCustomerById(Integer id) {		
		return customerRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id, Customer.class.getName()));
	}

}
