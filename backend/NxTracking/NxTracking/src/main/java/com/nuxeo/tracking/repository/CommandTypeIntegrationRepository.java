package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CommandTypeIntegration;

@Repository
public interface CommandTypeIntegrationRepository extends JpaRepository<CommandTypeIntegration, Long> { 

	@Query("SELECT o FROM CommandTypeIntegration o WHERE o.id = :id AND o.dateDelete IS NULL")
	CommandTypeIntegration findObjectId(Long id); 

	@Query("SELECT o FROM CommandTypeIntegration o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CommandTypeIntegration> findAll(); 

	@Query("SELECT o FROM CommandTypeIntegration o WHERE o.name = :name AND o.dateDelete IS NULL")
	CommandTypeIntegration findByName(String name); 
}