package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequestAdditionalPoint;

@Repository
public interface MonitoringRequestAdditionalPointRepository extends JpaRepository<MonitoringRequestAdditionalPoint, Long> { 

	@Query("SELECT o FROM MonitoringRequestAdditionalPoint o WHERE o.id = :id AND o.dateDelete IS NULL")
	MonitoringRequestAdditionalPoint findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequestAdditionalPoint o WHERE o.monitoringRequest.id = :idMonitoringRequest AND o.dateDelete IS NULL")
	List<MonitoringRequestAdditionalPoint> findByMonitoringRequest(Long idMonitoringRequest); 

}