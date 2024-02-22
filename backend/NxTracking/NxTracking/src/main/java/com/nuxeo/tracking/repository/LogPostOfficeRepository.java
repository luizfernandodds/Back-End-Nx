package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LogPostOffice;

@Repository
public interface LogPostOfficeRepository extends JpaRepository<LogPostOffice, Long> { 

	@Query("SELECT o FROM LogPostOffice o WHERE o.id = :id")
	LogPostOffice findObjectId(Long id); 

}