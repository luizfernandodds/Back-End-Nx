package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileType;

@Repository
public interface OperationalProfileTypeRepository extends JpaRepository<OperationalProfileType, Long> { 

	@Query("SELECT o FROM OperationalProfileType o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileType findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileType o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<OperationalProfileType> findAll(); 

}