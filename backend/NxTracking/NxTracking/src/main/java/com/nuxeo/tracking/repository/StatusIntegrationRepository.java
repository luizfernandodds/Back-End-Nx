package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.StatusIntegration;

@Repository
public interface StatusIntegrationRepository extends JpaRepository<StatusIntegration, Long> { 

	@Query("SELECT o FROM StatusIntegration o ORDER BY o.description ASC")
	StatusIntegration findObjectId(Long id); 
	
	@Query("SELECT o FROM StatusIntegration o ORDER BY o.description ASC")
	List<StatusIntegration> findAll(); 

}