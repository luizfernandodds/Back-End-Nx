package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceFlag;

@Repository
public interface AttendanceFlagRepository extends JpaRepository<AttendanceFlag, Long> { 

	@Query("SELECT o FROM AttendanceFlag o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceFlag findObjectId(Long id); 
	
}