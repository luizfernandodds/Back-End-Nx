package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.EventFired;

@Repository
public interface EventFiredRepository extends JpaRepository<EventFired, Long> { 

	@Query("SELECT o FROM EventFired o WHERE o.id = :id AND o.dateDelete IS NULL")
	EventFired findObjectId(Long id); 
	
	@Query("SELECT o FROM EventFired o WHERE o.customer.company.id = :idCompany ORDER BY o.eventName ASC")
	List<EventFired> findByCompany(Long idCompany); 

	@Query("SELECT o FROM EventFired o WHERE o.customer.id = :idCustomer ORDER BY o.eventName ASC")
	List<EventFired> findByCustomer(Long idCustomer); 

}