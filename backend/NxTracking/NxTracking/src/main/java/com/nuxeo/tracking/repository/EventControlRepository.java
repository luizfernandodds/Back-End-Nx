package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.EventControl;

@Repository
public interface EventControlRepository extends JpaRepository<EventControl, Long> { 

	@Query("SELECT o FROM EventControl o WHERE o.id = :id")
	EventControl findObjectId(Long id); 

	@Query("SELECT o FROM EventControl o ORDER BY o.description ASC")
	List<EventControl> findAll(); 

}