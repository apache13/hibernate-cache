package com.apache13.hibernatecache.controller;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apache13.hibernatecache.entity.Customer;
import com.apache13.hibernatecache.service.ICustomerService;

@RestController
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable @NotNull @DecimalMin("0") Integer id) {
		long start = System.currentTimeMillis();
		try {
			return customerService.getCustomerById(id);
		}finally {
			System.out.println("Using time : "+(System.currentTimeMillis()-start)+" ms.");
		}
	}
}
