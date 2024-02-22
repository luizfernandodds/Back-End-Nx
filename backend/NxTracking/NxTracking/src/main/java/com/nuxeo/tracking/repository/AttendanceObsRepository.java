package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceObs;

@Repository
public interface AttendanceObsRepository extends JpaRepository<AttendanceObs, Long> { 

	@Query("SELECT o FROM AttendanceNotes o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceObs findObjectId(Long id); 
	
	@Query("SELECT o FROM AttendanceObs o WHERE o.attendance.customer.company.id = :idCompany AND o.attendance.id = :idAttendance AND o.dateDelete IS NULL")
	List<AttendanceObs> findByCompanyAndAttendance(Long idCompany, Long idAttendance); 

	@Query("SELECT o FROM AttendanceObs o WHERE o.attendance.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<AttendanceObs> findByCompany(Long idCompany); 

	@Query("SELECT o FROM AttendanceObs o WHERE o.attendance.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<AttendanceObs> findByCompanyAndCustomer(Long idCustomer); 

}