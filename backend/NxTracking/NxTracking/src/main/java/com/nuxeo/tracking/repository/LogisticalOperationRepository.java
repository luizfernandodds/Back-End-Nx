package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogisticalOperation;

@Repository
public interface LogisticalOperationRepository extends JpaRepository<LogisticalOperation, Long> { 

	@Query("SELECT o FROM LogisticalOperation o WHERE o.id = :id AND o.dateDelete IS NULL")
	LogisticalOperation findObjectId(Long id); 
	
	@Query("SELECT o FROM LogisticalOperation o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<LogisticalOperation> findByCompany(Long idCompany); 

	@Query("SELECT o FROM LogisticalOperation o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<LogisticalOperation> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM LogisticalOperation o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<LogisticalOperation> findAll(); 

}