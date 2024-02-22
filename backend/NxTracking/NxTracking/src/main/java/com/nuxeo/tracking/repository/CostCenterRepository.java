package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CostCenter;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Long> { 

	@Query("SELECT o FROM CostCenter o WHERE o.id = :id AND o.dateDelete IS NULL")
	CostCenter findObjectId(Long id); 
	
	@Query("SELECT o FROM CostCenter o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CostCenter> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CostCenter o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CostCenter> findByCustomer(Long idCustomer); 
	
}