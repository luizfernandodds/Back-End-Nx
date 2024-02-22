package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogTravelSchedule;

@Repository
public interface LogTravelScheduleRepository extends JpaRepository<LogTravelSchedule, Long> { 

	@Query("SELECT o FROM LogTravelSchedule o WHERE o.id = :id")
	LogTravelSchedule findObjectId(Long id); 
	
	@Query("SELECT o FROM LogTravelSchedule AS o WHERE o.travelSchedule.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end ORDER BY o.dateCreate DESC")
	List<LogTravelSchedule> findByCustomerAndDate(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM LogTravelSchedule AS o WHERE o.travelSchedule.customer.company.id = :idCompany AND o.dateCreate >= :begin AND o.dateCreate <= :end ORDER BY o.dateCreate DESC")
	List<LogTravelSchedule> findByCompanyAndDate(Long idCompany, LocalDateTime begin, LocalDateTime end); 

}