package com.nuxeo.tracking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuxeo.tracking.dto.DriverDto;
import com.nuxeo.tracking.model.Driver;
import com.nuxeo.tracking.repository.DriverRepository;
import com.nuxeo.tracking.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository repository;
 
    private ModelMapper modelMapper;

	@Override
	public Driver findById(Long id) {
		return repository.findById(id).orElse(new Driver());
	}
	
	@Override
	public List<Driver> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Driver> findByNameLike(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	

	@Override
	public Driver findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public boolean isExist(Driver driver) {
		return findByName(driver.getName())!=null;
	}
	
	@Override
	public Driver save(Driver driver) {
		return repository.save(driver);
	}

	@Override
	public Driver update(Driver driver) {
		return repository.save(driver);
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
	public DriverDto convertToDto(Driver driver) {
		modelMapper = new ModelMapper();
		DriverDto driverDto = modelMapper.map(driver, DriverDto.class);
	    return driverDto;
	}
	
	@Override
	public Driver convertToEntity(DriverDto driverDto) {
		modelMapper = new ModelMapper();
		Driver driver = modelMapper.map(driverDto, Driver.class);
	    return driver;
	}
	
	@Override
	public List<DriverDto> convertToListDto(List<Driver> listDriver) {
		modelMapper = new ModelMapper();
		List<DriverDto> listDriverDto = Arrays.asList(modelMapper.map(listDriver,  DriverDto[].class));
	    return listDriverDto;
	}
	
	@Override
	public List<Driver> convertToListEntity(List<DriverDto> listDriverDto) {
		modelMapper = new ModelMapper();
		List<Driver> listDriver = Arrays.asList(modelMapper.map(listDriverDto, Driver[].class));
	    return listDriver;
	}
	
}
