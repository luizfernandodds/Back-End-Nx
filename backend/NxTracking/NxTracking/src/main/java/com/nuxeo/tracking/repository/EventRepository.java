package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> { 

	@Query("SELECT o FROM Event o WHERE o.id = :id AND o.dateDelete IS NULL")
	Event findObjectId(Long id); 
	
	@Query("SELECT o FROM Event o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Event> findByCompany(Long idCompany); 

	@Query("SELECT o FROM Event o WHERE o.customer.company.id = :idCompany AND o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Event> findByCompanyAndCustomer(Long idCompany, Long idCustomer); 
	
	@Query("SELECT o FROM Event o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Event> findAll(); 

}