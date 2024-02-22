package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileSsmaCourse;

@Repository
public interface OperationalProfileSsmaCourseRepository extends JpaRepository<OperationalProfileSsmaCourse, Long> { 

	@Query("SELECT o FROM OperationalProfileSsmaCourse o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileSsmaCourse findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileSsmaCourse o WHERE o.operationalProfile.id = :idOperationalProfile AND o.dateDelete IS NULL")
	List<OperationalProfileSsmaCourse> findByOperationalProfile(Long idOperationalProfile); 

	@Query("SELECT o FROM OperationalProfileSsmaCourse o WHERE o.dateDelete IS NULL")
	List<OperationalProfileSsmaCourse> findAll(); 

}