package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.IntegrationPostOffice;

@Repository
public interface IntegrationPostOfficeRepository extends JpaRepository<IntegrationPostOffice, Long> { 

	@Query("SELECT o FROM IntegrationPostOffice o WHERE o.id = :id")
	IntegrationPostOffice findObjectId(Long id); 
	
	@Query("SELECT o FROM IntegrationPostOffice o WHERE o.travelSchedule.id = :idTravelSchedule")
	List<IntegrationPostOffice> findAllTravelSchedule(Long idTravelSchedule); 

	@Query("SELECT o FROM IntegrationPostOffice o WHERE o.statusIntegration.id = :idStatusIntegration")
	List<IntegrationPostOffice> findAllStatusIntegration(Long idStatusIntegration); 

}