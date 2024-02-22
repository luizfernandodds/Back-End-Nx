package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Sensors;

@Repository
public interface SensorsRepository extends JpaRepository<Sensors, Long> { 

	@Query("SELECT o FROM Sensors o WHERE o.id = :id AND o.dateDelete IS NULL")
	Sensors findObjectId(Long id); 
	
}