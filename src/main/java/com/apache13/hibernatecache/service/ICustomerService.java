package com.apache13.hibernatecache.service;

import com.apache13.hibernatecache.entity.Customer;

public interface ICustomerService {
	public Customer getCustomerById(Integer id);
}
