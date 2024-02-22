package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> { 

	List<Company> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT o FROM Company o WHERE o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Company> findByNameLike(String name); 

	@Query("SELECT o FROM Company o WHERE o.dateDelete IS NULL ORDER BY o.id ASC")
	List<Company> findAll(); 
	
	@Query("SELECT o FROM Company o WHERE o.name = :name AND o.dateDelete IS NULL")
	Company findByName(String name); 

	@Query("SELECT o FROM Company o WHERE o.id = :id AND o.dateDelete IS NULL")
	Company findObjectId(Long id); 

}