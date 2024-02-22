package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Isca;

@Repository
public interface IscaRepository extends JpaRepository<Isca, Long> { 

	@Query("SELECT o FROM Isca o WHERE o.id = :id AND o.dateDelete IS NULL")
	Isca findObjectId(Long id); 
	
	@Query("SELECT o FROM Isca o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<Isca> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Isca o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.id ASC")
	List<Isca> findByCustomer(Long idCustomer); 
}