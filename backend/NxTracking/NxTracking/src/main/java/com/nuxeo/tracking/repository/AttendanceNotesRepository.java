package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceNotes;

@Repository
public interface AttendanceNotesRepository extends JpaRepository<AttendanceNotes, Long> { 

	@Query("SELECT o FROM AttendanceNotes o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceNotes findObjectId(Long id); 
	
	@Query("SELECT o FROM AttendanceNotes o WHERE o.attendance.customer.company.id = :idCompany AND o.attendance.id = :idAttendance AND o.dateDelete IS NULL")
	List<AttendanceNotes> findAllCompany(Long idCompany, Long idAttendance); 

}