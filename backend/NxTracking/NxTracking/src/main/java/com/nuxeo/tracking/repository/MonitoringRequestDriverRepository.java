package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequestDriver;

@Repository
public interface MonitoringRequestDriverRepository extends JpaRepository<MonitoringRequestDriver, Long> { 

	@Query("SELECT o FROM MonitoringRequestDriver o WHERE o.id = :id AND o.dateDelete IS NULL")
	MonitoringRequestDriver findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequestDriver o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<MonitoringRequestDriver> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MonitoringRequestDriver o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<MonitoringRequestDriver> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM MonitoringRequestDriver o WHERE o.monitoringRequest.id = :idMonitoringRequest AND o.dateDelete IS NULL")
	List<MonitoringRequestDriver> findByMonitoringRequest(Long idMonitoringRequest); 

}