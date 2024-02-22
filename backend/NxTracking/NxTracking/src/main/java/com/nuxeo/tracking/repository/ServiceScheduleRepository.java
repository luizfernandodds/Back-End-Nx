package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ServiceSchedule;

@Repository
public interface ServiceScheduleRepository extends JpaRepository<ServiceSchedule, Long> { 

	@Query("SELECT o FROM ServiceSchedule o WHERE o.id = :id AND o.dateDelete IS NULL")
	ServiceSchedule findObjectId(Long id); 
	
}