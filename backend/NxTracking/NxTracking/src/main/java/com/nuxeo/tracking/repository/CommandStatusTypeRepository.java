package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CommandStatusType;

@Repository
public interface CommandStatusTypeRepository extends JpaRepository<CommandStatusType, Long> { 

	@Query("SELECT o FROM CommandStatusType o WHERE o.id = :id")
	CommandStatusType findObjectId(Long id); 
	
	@Query("SELECT o FROM CommandStatusType o ORDER BY o.name ASC")
	List<CommandStatusType> findAll(); 
}