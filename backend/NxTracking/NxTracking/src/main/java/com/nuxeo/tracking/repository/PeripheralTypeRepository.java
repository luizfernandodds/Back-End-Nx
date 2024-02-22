package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.PeripheralType;

@Repository
public interface PeripheralTypeRepository extends JpaRepository<PeripheralType, Long> { 

	@Query("SELECT o FROM PeripheralType o WHERE o.id = :id AND o.dateDelete IS NULL")
	PeripheralType findObjectId(Long id); 
	
	@Query("SELECT o FROM PeripheralType o WHERE o.dateDelete IS NULL")
	List<PeripheralType> findAll(); 

}