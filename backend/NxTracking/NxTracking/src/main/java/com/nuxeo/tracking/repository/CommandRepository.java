package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> { 

	@Query("SELECT o FROM Command o WHERE o.id = :id")
	Command findObjectId(Long id); 
	
	@Query("SELECT o FROM Command o ORDER BY o.name ASC")
	List<Command> findAll(); 
}