package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfile;

@Repository
public interface OperationalProfileRepository extends JpaRepository<OperationalProfile, Long> { 

	@Query("SELECT o FROM OperationalProfile o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfile findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfile o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<OperationalProfile> findByCompany(Long idCompany); 

	@Query("SELECT o FROM OperationalProfile o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<OperationalProfile> findByCompanyAndCustomer(Long idCustomer); 

	@Query("SELECT o FROM OperationalProfile o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<OperationalProfile> findAll(); 

}