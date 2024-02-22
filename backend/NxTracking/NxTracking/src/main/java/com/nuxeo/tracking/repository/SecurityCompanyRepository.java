package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SecurityCompany;

@Repository
public interface SecurityCompanyRepository extends JpaRepository<SecurityCompany, Long> { 

	@Query("SELECT o FROM SecurityCompany o WHERE o.id = :id AND o.dateDelete IS NULL")
	SecurityCompany findObjectId(Long id); 
	
	@Query("SELECT o FROM SecurityCompany o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.description ASC")
	List<SecurityCompany> findByCompany(Long idCompany); 

}