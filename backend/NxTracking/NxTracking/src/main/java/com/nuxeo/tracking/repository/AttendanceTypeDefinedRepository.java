package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceTypeDefined;

@Repository
public interface AttendanceTypeDefinedRepository extends JpaRepository<AttendanceTypeDefined, Long> { 

	@Query("SELECT o FROM AttendanceTypeDefined o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceTypeDefined findObjectId(Long id); 
	
}