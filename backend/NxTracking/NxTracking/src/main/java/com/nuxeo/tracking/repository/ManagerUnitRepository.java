package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ManagerUnit;

@Repository
public interface ManagerUnitRepository extends JpaRepository<ManagerUnit, Long> { 

	@Query("SELECT o FROM ManagerUnit o WHERE o.id = :id AND o.dateDelete IS NULL")
	ManagerUnit findObjectId(Long id); 
	
	@Query("SELECT o FROM ManagerUnit o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ManagerUnit> findByCompany(Long idCompany); 

	@Query("SELECT o FROM ManagerUnit o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ManagerUnit> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM ManagerUnit o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<ManagerUnit> findAll(); 

}