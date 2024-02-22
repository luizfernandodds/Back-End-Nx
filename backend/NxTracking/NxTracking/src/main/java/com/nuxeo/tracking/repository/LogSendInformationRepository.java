package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogSendInformation;
import com.nuxeo.tracking.model.LogisticalOperation;

@Repository
public interface LogSendInformationRepository extends JpaRepository<LogSendInformation, Long> { 

	@Query("SELECT o FROM LogSendInformation o WHERE o.id = :id")
	LogSendInformation findObjectId(Long id); 
	
	@Query("SELECT o FROM LogSendInformation o WHERE o.customer.id = :idCustomer ORDER BY o.dateCreate ASC")
	List<LogisticalOperation> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM LogSendInformation o WHERE o.customer.company.id = :idCompany ORDER BY o.dateCreate ASC")
	List<LogisticalOperation> findByCompany(Long idCompany); 

}