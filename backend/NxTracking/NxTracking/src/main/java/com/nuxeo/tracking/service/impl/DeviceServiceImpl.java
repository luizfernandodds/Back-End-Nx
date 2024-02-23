package com.nuxeo.tracking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuxeo.tracking.dto.DeviceDto;
import com.nuxeo.tracking.model.Device;
import com.nuxeo.tracking.repository.DeviceRepository;
import com.nuxeo.tracking.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository repository;
 
    private ModelMapper modelMapper;

	@Override
	public Device findById(Long id) {
		return repository.findById(id).orElse(new Device());
	}
	
	@Override
	public List<Device> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Device> findByNameLike(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	

	@Override
	public Device findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public boolean isExist(Device device) {
		return findByName(device.getName())!=null;
	}
	
	@Override
	public Device save(Device device) {
		return repository.save(device);
	}

	@Override
	public Device update(Device device) {
		return repository.save(device);
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
	public DeviceDto convertToDto(Device device) {
		modelMapper = new ModelMapper();
		DeviceDto deviceDto = modelMapper.map(device, DeviceDto.class);
	    return deviceDto;
	}
	
	@Override
	public Device convertToEntity(DeviceDto deviceDto) {
		modelMapper = new ModelMapper();
		Device device = modelMapper.map(deviceDto, Device.class);
	    return device;
	}
	
	@Override
	public List<DeviceDto> convertToListDto(List<Device> listDevice) {
		modelMapper = new ModelMapper();
		List<DeviceDto> listDeviceDto = Arrays.asList(modelMapper.map(listDevice,  DeviceDto[].class));
	    return listDeviceDto;
	}
	
	@Override
	public List<Device> convertToListEntity(List<DeviceDto> listDeviceDto) {
		modelMapper = new ModelMapper();
		List<Device> listDevice = Arrays.asList(modelMapper.map(listDeviceDto, Device[].class));
	    return listDevice;
	}
	
}
