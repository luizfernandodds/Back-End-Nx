package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.TypeBlockTarget;

@Repository
public interface TypeBlockTargetRepository extends JpaRepository<TypeBlockTarget, Long> { 

	@Query("SELECT o FROM TypeBlockTarget o WHERE o.id = :id AND o.dateDelete IS NULL")
	TypeBlockTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM TypeBlockTarget o WHERE o.dateDelete IS NULL")
	List<TypeBlockTarget> findAll(); 

}