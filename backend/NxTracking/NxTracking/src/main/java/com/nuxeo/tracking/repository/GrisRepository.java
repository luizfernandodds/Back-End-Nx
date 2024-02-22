package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Gris;

@Repository
public interface GrisRepository extends JpaRepository<Gris, Long> { 

	@Query("SELECT o FROM Gris o WHERE o.id = :id AND o.dateDelete IS NULL")
	Gris findObjectId(Long id); 
	
	@Query("SELECT o FROM Gris o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Gris> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Gris o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Gris> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM Gris o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Gris> findAll(); 

}