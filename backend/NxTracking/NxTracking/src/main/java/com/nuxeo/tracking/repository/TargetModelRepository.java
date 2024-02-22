package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.TargetModel;

@Repository
public interface TargetModelRepository extends JpaRepository<TargetModel, Long> { 

	@Query("SELECT o FROM TargetModel o WHERE o.id = :id AND o.dateDelete IS NULL")
	TargetModel findObjectId(Long id); 
	
}