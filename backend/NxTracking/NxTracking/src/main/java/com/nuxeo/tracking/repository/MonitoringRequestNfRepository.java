package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequestNf;

@Repository
public interface MonitoringRequestNfRepository extends JpaRepository<MonitoringRequestNf, Long> { 

	@Query("SELECT o FROM MonitoringRequestNf o WHERE o.id = :id AND o.dateDelete IS NULL")
	MonitoringRequestNf findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequestNf o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<MonitoringRequestNf> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MonitoringRequestNf o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<MonitoringRequestNf> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM MonitoringRequestNf o WHERE o.monitoringRequest.id = :idMonitoringRequest AND o.dateDelete IS NULL")
	List<MonitoringRequestNf> findByMonitoringRequest(Long idMonitoringRequest); 

}