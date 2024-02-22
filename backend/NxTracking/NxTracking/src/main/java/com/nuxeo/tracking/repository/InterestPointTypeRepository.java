package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.InterestPointType;

@Repository
public interface InterestPointTypeRepository extends JpaRepository<InterestPointType, Long> { 

	@Query("SELECT o FROM InterestPointType o WHERE o.id = :id AND o.dateDelete IS NULL")
	InterestPointType findObjectId(Long id); 
	
	@Query("SELECT o FROM InterestPointType o WHERE o.dateDelete IS NULL ORDER BY o.description ASC")
	List<InterestPointType> findAll(); 

}