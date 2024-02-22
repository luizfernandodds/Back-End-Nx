package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileEvent;

@Repository
public interface OperationalProfileEventRepository extends JpaRepository<OperationalProfileEvent, Long> { 

	@Query("SELECT o FROM OperationalProfileEvent o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileEvent findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileEvent o WHERE o.type = :type AND o.dateDelete IS NULL")
	List<OperationalProfileEvent> findByType(Long type); 
	
	@Query("SELECT o FROM OperationalProfileEvent o WHERE o.dateDelete IS NULL ORDER BY o.eventName ASC")
	List<OperationalProfileEvent> findAll(); 

}