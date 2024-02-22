package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.DriverHistoric;

@Repository
public interface DriverHistoricRepository extends JpaRepository<DriverHistoric, Long> { 

	@Query("SELECT o FROM DriverHistoric o WHERE o.id = :id AND o.dateDelete IS NULL")
	DriverHistoric findObjectId(Long id); 
	
}