package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.StatusSm;

@Repository
public interface StatusSmRepository extends JpaRepository<StatusSm, Long> { 

	@Query("SELECT o FROM StatusSm o WHERE o.id = :id AND o.dateDelete IS NULL")
	StatusSm findObjectId(Long id); 
	
	@Query("SELECT o FROM StatusSm o WHERE o.dateDelete IS NULL")
	List<StatusSm> findAll(); 

}