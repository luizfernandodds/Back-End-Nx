package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceHistory;

@Repository
public interface AttendanceHistoryRepository extends JpaRepository<AttendanceHistory, Long> { 

	@Query("SELECT o FROM AttendanceHistory o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceHistory findObjectId(Long id); 
	
}