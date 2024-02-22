package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.PostOfficeLine;

@Repository
public interface PostOfficeLineRepository extends JpaRepository<PostOfficeLine, Long> { 

	@Query("SELECT o FROM PostOfficeLine o WHERE o.id = :id AND o.dateDelete IS NULL")
	PostOfficeLine findObjectId(Long id); 
	
	@Query("SELECT o FROM PostOfficeLine o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<PostOfficeLine> findByCompany(Long idCompany); 

	@Query("SELECT o FROM PostOfficeLine o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<PostOfficeLine> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM PostOfficeLine o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<PostOfficeLine> findAll(); 

}