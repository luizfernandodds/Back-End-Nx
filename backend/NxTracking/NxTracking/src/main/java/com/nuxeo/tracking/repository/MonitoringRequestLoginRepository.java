package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MonitoringRequestLogin;

@Repository
public interface MonitoringRequestLoginRepository extends JpaRepository<MonitoringRequestLogin, Long> { 

	@Query("SELECT o FROM MonitoringRequestLogin o WHERE o.id = :id")
	MonitoringRequestLogin findObjectId(Long id); 
	
	@Query("SELECT o FROM MonitoringRequestLogin o WHERE o.customer.company.id = :idCompany")
	List<MonitoringRequestLogin> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MonitoringRequestLogin o WHERE o.customer.id = :idCustomer")
	List<MonitoringRequestLogin> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM MonitoringRequestLogin o WHERE o.monitoringRequest.id = :idMonitoringRequest")
	List<MonitoringRequestLogin> findByMonitoringRequest(Long idMonitoringRequest); 

	@Query("SELECT o FROM MonitoringRequestLogin o WHERE o.login.id = :idLogin")
	List<MonitoringRequestLogin> findByLogin(Long idLogin); 

}