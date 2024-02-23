package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> { 
	
	List<Driver> findByNameContainingIgnoreCase(String name);

	@Query("SELECT o FROM Driver o WHERE o.id = :id AND o.dateDelete IS NULL")
	Driver findObjectId(Long id); 

	@Query("SELECT o FROM Driver o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Driver> findByCustomer(Long idCustomer); 

	@Query("SELECT o FROM Driver o WHERE o.name = :name AND o.dateDelete IS NULL")
	Driver findByName(String name); 

	@Query("SELECT o FROM Driver o WHERE o.customer.id = :idCustomer AND o.name = :name AND o.dateDelete IS NULL")
	Driver findByNameAndCustomer(String name, Long idCustomer); 

	@Query("SELECT o FROM Driver o WHERE o.name LIKE %:name% AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Driver> findByNameLike(String name); 

}