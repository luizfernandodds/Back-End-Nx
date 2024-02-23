package com.nuxeo.tracking.service;

import java.util.List;

import com.nuxeo.tracking.dto.DeviceDto;
import com.nuxeo.tracking.model.Device;

public interface DeviceService {

	public Device findById(Long id);
	public List<Device> findAll();
	public Device findByName(String name);
	public List<Device> findByNameLike(String name);
	public boolean isExist(Device device);	
	public Device save(Device device);
	public void deleteById(Long id);
	public void deleteAll();
	public Device update(Device device);
	public DeviceDto convertToDto(Device device);
	public Device convertToEntity(DeviceDto deviceDto);
	public List<DeviceDto> convertToListDto(List<Device> listDevice);
	public List<Device> convertToListEntity(List<DeviceDto> listDeviceDto);

}
