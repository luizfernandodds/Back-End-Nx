package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SsmaEvent;

@Repository
public interface SsmaEventRepository extends JpaRepository<SsmaEvent, Long> { 

	@Query("SELECT o FROM SsmaEvent o WHERE o.id = :id AND o.dateDelete IS NULL")
	SsmaEvent findObjectId(Long id); 
	
	@Query("SELECT o FROM SsmaEvent o WHERE o.dateDelete IS NULL")
	List<SsmaEvent> findAll(); 

}