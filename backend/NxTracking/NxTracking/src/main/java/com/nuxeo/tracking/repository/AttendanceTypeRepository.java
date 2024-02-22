package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceType;

@Repository
public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Long> { 

	@Query("SELECT o FROM AttendanceType o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceType findObjectId(Long id); 
	
	@Query("SELECT o FROM AttendanceType o WHERE o.dateDelete IS NULL")
	List<AttendanceType> findAll(); 

}