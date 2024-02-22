package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.DevicePeripheral;

@Repository
public interface DevicePeripheralRepository extends JpaRepository<DevicePeripheral, Long> { 

	@Query("SELECT o FROM DevicePeripheral o WHERE o.id = :id AND o.dateDelete IS NULL")
	DevicePeripheral findObjectId(Long id); 
	
}