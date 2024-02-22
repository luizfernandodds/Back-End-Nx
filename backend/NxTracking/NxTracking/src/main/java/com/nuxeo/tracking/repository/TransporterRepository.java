package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Transporter;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> { 

	@Query("SELECT o FROM Transporter o WHERE o.id = :id AND o.dateDelete IS NULL")
	Transporter findObjectId(Long id); 
	
	@Query("SELECT o FROM Transporter o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Transporter> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Transporter o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Transporter> findByCompanyAndCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Transporter o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Transporter> findAll(); 

}