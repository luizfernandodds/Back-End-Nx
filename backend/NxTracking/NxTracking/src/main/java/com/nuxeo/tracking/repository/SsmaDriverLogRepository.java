package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SsmaDriverLog;

@Repository
public interface SsmaDriverLogRepository extends JpaRepository<SsmaDriverLog, Long> { 

	@Query("SELECT o FROM SsmaDriverLog o WHERE o.id = :id")
	SsmaDriverLog findObjectId(Long id); 
	
}