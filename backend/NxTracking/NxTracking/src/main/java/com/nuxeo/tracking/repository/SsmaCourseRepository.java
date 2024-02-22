package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.SsmaCourse;

@Repository
public interface SsmaCourseRepository extends JpaRepository<SsmaCourse, Long> { 

	@Query("SELECT o FROM SsmaCourse o WHERE o.id = :id AND o.dateDelete IS NULL")
	SsmaCourse findObjectId(Long id); 
	
	@Query("SELECT o FROM SsmaCourse o WHERE o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<SsmaCourse> findAll(); 

}