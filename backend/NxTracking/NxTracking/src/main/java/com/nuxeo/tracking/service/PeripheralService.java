package com.nuxeo.tracking.service;

import java.util.List;

import com.nuxeo.tracking.dto.PeripheralDto;
import com.nuxeo.tracking.model.Peripheral;

public interface PeripheralService {

	public Peripheral findById(Long id);
	public List<Peripheral> findAll();
	public List<Peripheral> findBySerial(String serial);
	public List<Peripheral> findByNameLike(String name);
	public boolean isExist(Peripheral peripheral);	
	public Peripheral save(Peripheral peripheral);
	public void deleteById(Long id);
	public void deleteAll();
	public Peripheral update(Peripheral peripheral);
	public PeripheralDto convertToDto(Peripheral peripheral);
	public Peripheral convertToEntity(PeripheralDto peripheralDto);
	public List<PeripheralDto> convertToListDto(List<Peripheral> listPeripheral);
	public List<Peripheral> convertToListEntity(List<PeripheralDto> listPeripheralDto);

}
