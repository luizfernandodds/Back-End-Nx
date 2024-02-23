package com.nuxeo.tracking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuxeo.tracking.dto.CustomerDto;
import com.nuxeo.tracking.model.Customer;
import com.nuxeo.tracking.repository.CustomerRepository;
import com.nuxeo.tracking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;
 
    private ModelMapper modelMapper;

	@Override
	public Customer findById(Long id) {
		return repository.findById(id).orElse(new Customer());
	}
	
	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Customer> findByNameLike(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	

	@Override
	public Customer findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public boolean isExist(Customer customer) {
		return findByName(customer.getName())!=null;
	}
	
	@Override
	public Customer save(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return repository.save(customer);
	}
	
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public CustomerDto convertToDto(Customer customer) {
		modelMapper = new ModelMapper();
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
	    return customerDto;
	}
	
	@Override
	public Customer convertToEntity(CustomerDto customerDto) {
		modelMapper = new ModelMapper();
		Customer customer = modelMapper.map(customerDto, Customer.class);
	    return customer;
	}
	
	@Override
	public List<CustomerDto> convertToListDto(List<Customer> listCustomer) {
		modelMapper = new ModelMapper();
		List<CustomerDto> listCustomerDto = Arrays.asList(modelMapper.map(listCustomer,  CustomerDto[].class));
	    return listCustomerDto;
	}
	
	@Override
	public List<Customer> convertToListEntity(List<CustomerDto> listCustomerDto) {
		modelMapper = new ModelMapper();
		List<Customer> listCustomer = Arrays.asList(modelMapper.map(listCustomerDto, Customer[].class));
	    return listCustomer;
	}
	
}
