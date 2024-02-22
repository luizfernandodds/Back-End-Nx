package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogType;

@Repository
public interface LogTypeRepository extends JpaRepository<LogType, Long> { 

	@Query("SELECT o FROM LogType o WHERE o.id = :id")
	LogType findObjectId(Long id); 
}