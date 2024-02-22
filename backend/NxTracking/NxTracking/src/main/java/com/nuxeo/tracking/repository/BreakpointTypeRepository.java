package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.BreakpointType;

@Repository
public interface BreakpointTypeRepository extends JpaRepository<BreakpointType, Long> { 

	@Query("SELECT o FROM BreakpointType o WHERE o.id = :id AND o.dateDelete IS NULL")
	BreakpointType findObjectId(Long id); 
	
	@Query("SELECT o FROM BreakpointType o WHERE o.dateDelete IS NULL")
	List<BreakpointType> findAll(); 

}