package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileSsmaPerformance;

@Repository
public interface OperationalProfileSsmaPerformanceRepository extends JpaRepository<OperationalProfileSsmaPerformance, Long> { 

	@Query("SELECT o FROM OperationalProfileSsmaPerformance o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileSsmaPerformance findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileSsmaPerformance o WHERE o.operationalProfile.id = :idOperationalProfile AND o.dateDelete IS NULL")
	List<OperationalProfileSsmaPerformance> findByOperationalProfile(Long idOperationalProfile); 

	@Query("SELECT o FROM OperationalProfileEvent o WHERE o.dateDelete IS NULL ORDER BY o.id ASC")
	List<OperationalProfileSsmaPerformance> findAll(); 

}