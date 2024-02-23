package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Company;
import com.nuxeo.tracking.model.Peripheral;

@Repository
public interface PeripheralRepository extends JpaRepository<Peripheral, Long> {
	
	List<Peripheral> findByNameContainingIgnoreCase(String name);
	List<Peripheral> findBySerialContainingIgnoreCase(String serial); 

	@Query("SELECT o FROM Peripheral o WHERE o.id = :id AND o.dateDelete IS NULL")
	Peripheral findObjectId(Long id); 
	
	@Query("SELECT o FROM Peripheral o WHERE o.serial = :serial AND o.dateDelete IS NULL ORDER BY o.serial ASC")
	List<Peripheral> findBySerial(String serial); 

	@Query("SELECT o FROM Peripheral o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Peripheral> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Peripheral o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Peripheral> findAll(); 
	
	@Query("SELECT o FROM Company o WHERE o.name = :name AND o.dateDelete IS NULL")
	Company findByName(String name); 

}