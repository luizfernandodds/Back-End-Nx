package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Protocol;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> { 

	@Query("SELECT o FROM Protocol o WHERE o.id = :id AND o.dateDelete IS NULL")
	Protocol findObjectId(Long id); 

	@Query("SELECT o FROM Protocol o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<Protocol> findAll(); 

	@Query("SELECT o FROM Protocol o WHERE o.name = :name AND o.dateDelete IS NULL")
	Protocol findByName(String name); 

}