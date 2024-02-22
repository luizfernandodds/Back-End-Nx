package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileSsmaConfig;

@Repository
public interface OperationalProfileSsmaConfigRepository extends JpaRepository<OperationalProfileSsmaConfig, Long> { 

	@Query("SELECT o FROM OperationalProfileSsmaConfig o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileSsmaConfig findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileSsmaConfig o WHERE o.operationalProfile.id = :idOperationalProfile AND o.dateDelete IS NULL")
	List<OperationalProfileSsmaConfig> findByOperationalProfile(Long idOperationalProfile); 

	@Query("SELECT o FROM OperationalProfileSsmaConfig o WHERE o.dateDelete IS NULL")
	List<OperationalProfileSsmaConfig> findAll(); 

}