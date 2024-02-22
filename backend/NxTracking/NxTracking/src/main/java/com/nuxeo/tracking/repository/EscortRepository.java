package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Escort;

@Repository
public interface EscortRepository extends JpaRepository<Escort, Long> { 

	@Query("SELECT o FROM Escort o WHERE o.id = :id AND o.dateDelete IS NULL")
	Escort findObjectId(Long id); 
	
	@Query("SELECT o FROM Escort o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.car ASC")
	List<Escort> findByCompany(Long idCompany); 

}