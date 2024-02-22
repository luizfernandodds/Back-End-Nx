package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceStatusLog;

@Repository
public interface AttendanceStatusLogRepository extends JpaRepository<AttendanceStatusLog, Long> { 

	@Query("SELECT o FROM AttendanceStatusLog o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceStatusLog findObjectId(Long id); 
	
}