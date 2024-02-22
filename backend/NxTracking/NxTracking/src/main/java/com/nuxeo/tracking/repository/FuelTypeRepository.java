package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> { 

	@Query("SELECT o FROM FuelType o WHERE o.id = :id AND o.dateDelete IS NULL")
	FuelType findObjectId(Long id); 
	
	@Query("SELECT o FROM FuelType o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<FuelType> findAll(); 

}