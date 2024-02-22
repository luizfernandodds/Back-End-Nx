package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttendanceSituation;

@Repository
public interface AttendanceSituationRepository extends JpaRepository<AttendanceSituation, Long> { 

	@Query("SELECT o FROM AttendanceSituation o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttendanceSituation findObjectId(Long id); 
	
	@Query("SELECT o FROM AttendanceSituation o WHERE o.dateDelete IS NULL")
	List<AttendanceSituation> findAll(); 

}