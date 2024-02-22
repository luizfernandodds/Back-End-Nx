package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.TypeTracker;

@Repository
public interface TypeTrackerRepository extends JpaRepository<TypeTracker, Long> { 

	@Query("SELECT o FROM TypeTracker o WHERE o.id = :id AND o.dateDelete IS NULL")
	TypeTracker findObjectId(Long id); 
	
	@Query("SELECT o FROM TypeTracker o WHERE o.dateDelete IS NULL ORDER BY o.description ASC")
	List<TypeTracker> findByAll(); 

}