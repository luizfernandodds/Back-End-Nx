package com.nuxeo.tracking.service;

import java.util.List;

import com.nuxeo.tracking.dto.DriverDto;
import com.nuxeo.tracking.model.Driver;

public interface DriverService {

	public Driver findById(Long id);
	public List<Driver> findAll();
	public Driver findByName(String name);
	public List<Driver> findByNameLike(String name);
	public boolean isExist(Driver driver);	
	public Driver save(Driver driver);
	public void deleteById(Long id);
	public void deleteAll();
	public Driver update(Driver driver);
	public DriverDto convertToDto(Driver driver);
	public Driver convertToEntity(DriverDto driverDto);
	public List<DriverDto> convertToListDto(List<Driver> listDriver);
	public List<Driver> convertToListEntity(List<DriverDto> listDriverDto);

}
