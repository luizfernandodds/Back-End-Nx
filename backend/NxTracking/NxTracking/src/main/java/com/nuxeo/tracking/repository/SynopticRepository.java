package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Synoptic;

@Repository
public interface SynopticRepository extends JpaRepository<Synoptic, Long> { 

	@Query("SELECT o FROM Synoptic o WHERE o.id = :id AND o.dateDelete IS NULL")
	Synoptic findObjectId(Long id); 
	
	@Query("SELECT o FROM Synoptic o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.company ASC")
	List<Synoptic> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Synoptic o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.company ASC")
	List<Synoptic> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Synoptic o WHERE o.dateDelete IS NULL ORDER BY o.company ASC")
	List<Synoptic> findAll(); 

}