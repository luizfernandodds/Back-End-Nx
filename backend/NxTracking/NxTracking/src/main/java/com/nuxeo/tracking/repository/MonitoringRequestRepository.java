package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequest;

@Repository
public interface MonitoringRequestRepository extends JpaRepository<MonitoringRequest, Long> { 

	@Query("SELECT o FROM MonitoringRequest o WHERE o.id = :id AND o.dateDelete IS NULL")
	MonitoringRequest findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequest o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<MonitoringRequest> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MonitoringRequest o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<MonitoringRequest> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM MonitoringRequest o WHERE o.customer.company.id = :idCompany AND o.targetControl.identifier LIKE %:identifier% AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<MonitoringRequest> findByCompanyLikeName(Long idCompany, String identifier); 

	@Query("SELECT o FROM MonitoringRequest o WHERE o.customer.id = :idCustomer AND o.targetControl.identifier LIKE %:identifier% AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<MonitoringRequest> findByCustomerLikeName(Long idCustomer, String identifier); 

}