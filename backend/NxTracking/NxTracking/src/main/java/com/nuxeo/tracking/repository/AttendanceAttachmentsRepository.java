package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceAttachments;

@Repository
public interface AttendanceAttachmentsRepository extends JpaRepository<AttendanceAttachments, Long> { 

	@Query("SELECT o FROM AttendanceAttachments o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceAttachments findObjectId(Long id); 

	@Query("SELECT o FROM AttendanceAttachments o WHERE o.attendance.id = :idAttendance AND o.dateDelete IS NULL")
	List<AttendanceAttachments> findByAttendance(Long idAttendance); 

	@Query("SELECT o FROM AttendanceAttachments o WHERE o.attendance.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<AttendanceAttachments> findByCustomer(Long idCustomer); 

}