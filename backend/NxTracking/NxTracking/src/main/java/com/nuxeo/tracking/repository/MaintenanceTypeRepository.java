package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MaintenanceType;

@Repository
public interface MaintenanceTypeRepository extends JpaRepository<MaintenanceType, Long> { 

	@Query("SELECT o FROM MaintenanceType o WHERE o.id = :id")
	MaintenanceType findObjectId(Long id); 
	
	@Query("SELECT o FROM MaintenanceType o ORDER BY o.name ASC")
	List<MaintenanceType> findAll(); 

}