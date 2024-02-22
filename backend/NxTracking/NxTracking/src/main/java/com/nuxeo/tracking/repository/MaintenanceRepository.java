package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> { 

	@Query("SELECT o FROM Maintenance o WHERE o.id = :id AND o.dateDelete IS NULL")
	Maintenance findObjectId(Long id); 
	
	@Query("SELECT o FROM Maintenance o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Maintenance> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Maintenance o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Maintenance> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Maintenance o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Maintenance> findAll(); 

	@Query("SELECT o FROM Maintenance o WHERE o.customer.id = :idCustomer AND o.analysis = :unit AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Maintenance> findByCustomerAndAnalysis(Long idCustomer, int unit); 

}