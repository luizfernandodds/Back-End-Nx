package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { 

	@Query("SELECT o FROM Customer o WHERE o.id = :id AND o.dateDelete IS NULL")
	Customer findObjectId(Long id); 

	@Query("SELECT o FROM Customer o WHERE o.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Customer> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Customer o WHERE o.name = :name AND o.dateDelete IS NULL")
	Customer findByName(String name); 
	
	@Query("SELECT o FROM Customer o WHERE o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Customer> findByNameLike(String name); 

	@Query("SELECT o FROM Company o WHERE o.dateDelete IS NULL ORDER BY o.id ASC")
	List<Customer> findAll(); 
	
}