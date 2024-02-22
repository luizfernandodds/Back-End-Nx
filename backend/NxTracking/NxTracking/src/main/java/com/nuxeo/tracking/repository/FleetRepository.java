package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Fleet;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> { 

	@Query("SELECT o FROM Fleet o WHERE o.id = :id AND o.dateDelete IS NULL")
	Fleet findObjectId(Long id); 
	
	@Query("SELECT o FROM Fleet o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Fleet> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Fleet o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Fleet> findByCustomer(Long idCustomer); 

}