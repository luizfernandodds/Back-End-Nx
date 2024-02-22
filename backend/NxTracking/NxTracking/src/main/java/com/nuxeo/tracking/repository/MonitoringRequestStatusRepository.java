package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequestStatus;

@Repository
public interface MonitoringRequestStatusRepository extends JpaRepository<MonitoringRequestStatus, Long> { 

	@Query("SELECT o FROM MonitoringRequestStatus o WHERE o.id = :id")
	MonitoringRequestStatus findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequestStatus o WHERE o.customer.company.id = :idCompany")
	List<MonitoringRequestStatus> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MonitoringRequestStatus o WHERE o.customer.id = :idCustomer")
	List<MonitoringRequestStatus> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM MonitoringRequestStatus o WHERE o.monitoringRequest.id = :idMonitoringRequest")
	List<MonitoringRequestStatus> findByMonitoringRequest(Long idMonitoringRequest); 

}