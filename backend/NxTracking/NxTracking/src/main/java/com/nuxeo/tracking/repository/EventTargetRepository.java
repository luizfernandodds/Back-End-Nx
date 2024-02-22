package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.EventTarget;

@Repository
public interface EventTargetRepository extends JpaRepository<EventTarget, Long> { 

	@Query("SELECT o FROM EventTarget o WHERE o.id = :id ")
	EventTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM EventTarget o WHERE o.idTarget = :idTarget")
	List<EventTarget> findByTarget(Long idTarget); 

	@Query("SELECT o FROM EventTarget o WHERE o.event.id = :idEvent")
	List<EventTarget> findByEvent(Long idEvent); 

	@Query("SELECT o FROM EventTarget o WHERE o.idTarget = :idTarget AND o.event.id = :idEvent")
	List<EventTarget> findByTargetAndEvent(Long idTarget, Long idEvent); 

}