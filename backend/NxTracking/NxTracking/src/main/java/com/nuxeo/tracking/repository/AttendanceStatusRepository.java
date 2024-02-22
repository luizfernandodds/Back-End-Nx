package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceStatus;

@Repository
public interface AttendanceStatusRepository extends JpaRepository<AttendanceStatus, Long> { 

	@Query("SELECT o FROM AttendanceStatus o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceStatus findObjectId(Long id); 
	
	@Query("SELECT o FROM AttendanceStatus o WHERE o.dateDelete IS NULL")
	List<AttendanceStatus> findAllCompany(); 

	@Query("SELECT o FROM AttendanceStatus o WHERE o.id NOT IN (3) AND o.dateDelete IS NULL")
	List<AttendanceStatus> findAllCompanyNotIn3(); 

}