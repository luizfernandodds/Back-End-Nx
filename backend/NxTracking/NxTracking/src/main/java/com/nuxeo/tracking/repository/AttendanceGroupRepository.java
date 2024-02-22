package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceGroup;

@Repository
public interface AttendanceGroupRepository extends JpaRepository<AttendanceGroup, Long> { 

	@Query("SELECT o FROM AttendanceGroup o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceGroup findObjectId(Long id); 
	
}