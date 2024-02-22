package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.EventSentinel;

@Repository
public interface EventSentinelRepository extends JpaRepository<EventSentinel, Long> { 

	@Query("SELECT o FROM EventSentinel o WHERE o.id = :id AND o.dateDelete IS NULL")
	EventSentinel findObjectId(Long id); 
	
	@Query("SELECT o FROM EventSentinel o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<EventSentinel> findAllCompany(Long idCompany); 

}