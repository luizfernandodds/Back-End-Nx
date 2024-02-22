package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.EventType;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> { 

	@Query("SELECT o FROM EventType o WHERE o.id = :id AND o.dateDelete IS NULL")
	EventType findObjectId(Long id); 
	
	@Query("SELECT o FROM EventType o WHERE o.dateDelete IS NULL ORDER BY o.i18nName ASC")
	List<EventType> findAll(); 

}