package com.nuxeo.tracking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuxeo.tracking.dto.PeripheralDto;
import com.nuxeo.tracking.model.Peripheral;
import com.nuxeo.tracking.repository.PeripheralRepository;
import com.nuxeo.tracking.service.PeripheralService;

@Service
public class PeripheralServiceImpl implements PeripheralService {

	@Autowired
	private PeripheralRepository repository;
 
    private ModelMapper modelMapper;

	@Override
	public Peripheral findById(Long id) {
		return repository.findById(id).orElse(new Peripheral());
	}
	
	@Override
	public List<Peripheral> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Peripheral> findByNameLike(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}
	

	@Override
	public List<Peripheral> findBySerial(String serial) {
		return repository.findBySerialContainingIgnoreCase(serial);
	}
	
	@Override
	public boolean isExist(Peripheral peripheral) {
		return findByNameLike(peripheral.getName())!=null;
	}
	
	@Override
	public Peripheral save(Peripheral peripheral) {
		return repository.save(peripheral);
	}

	@Override
	public Peripheral update(Peripheral peripheral) {
		return repository.save(peripheral);
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
	public PeripheralDto convertToDto(Peripheral peripheral) {
		modelMapper = new ModelMapper();
		PeripheralDto peripheralDto = modelMapper.map(peripheral, PeripheralDto.class);
	    return peripheralDto;
	}
	
	@Override
	public Peripheral convertToEntity(PeripheralDto peripheralDto) {
		modelMapper = new ModelMapper();
		Peripheral peripheral = modelMapper.map(peripheralDto, Peripheral.class);
	    return peripheral;
	}
	
	@Override
	public List<PeripheralDto> convertToListDto(List<Peripheral> listPeripheral) {
		modelMapper = new ModelMapper();
		List<PeripheralDto> listPeripheralDto = Arrays.asList(modelMapper.map(listPeripheral,  PeripheralDto[].class));
	    return listPeripheralDto;
	}
	
	@Override
	public List<Peripheral> convertToListEntity(List<PeripheralDto> listPeripheralDto) {
		modelMapper = new ModelMapper();
		List<Peripheral> listPeripheral = Arrays.asList(modelMapper.map(listPeripheralDto, Peripheral[].class));
	    return listPeripheral;
	}
	
}
