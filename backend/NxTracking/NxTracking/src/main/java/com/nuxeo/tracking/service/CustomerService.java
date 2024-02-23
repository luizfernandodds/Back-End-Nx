package com.nuxeo.tracking.service;

import java.util.List;

import com.nuxeo.tracking.dto.CustomerDto;
import com.nuxeo.tracking.model.Customer;

public interface CustomerService {

	public Customer findById(Long id);
	public List<Customer> findAll();
	public Customer findByName(String name);
	public List<Customer> findByNameLike(String name);
	public boolean isExist(Customer customer);	
	public Customer save(Customer customer);
	public void deleteById(Long id);
	public void deleteAll();
	public Customer update(Customer customer);
	public CustomerDto convertToDto(Customer customer);
	public Customer convertToEntity(CustomerDto customerDto);
	public List<CustomerDto> convertToListDto(List<Customer> listCustomer);
	public List<Customer> convertToListEntity(List<CustomerDto> listCustomerDto);

}
