package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogAccident;

@Repository
public interface LogAccidentRepository extends JpaRepository<LogAccident, Long> { 

	@Query("SELECT o FROM LogAccident o WHERE o.id = :id AND o.dateDelete IS NULL")
	LogAccident findObjectId(Long id); 
	
	@Query("SELECT o FROM LogAccident o WHERE o.dateDelete IS NULL")
	List<LogAccident> findAll(); 

}