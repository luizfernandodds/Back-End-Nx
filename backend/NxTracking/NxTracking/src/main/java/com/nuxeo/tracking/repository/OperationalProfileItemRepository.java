package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.OperationalProfileItem;

@Repository
public interface OperationalProfileItemRepository extends JpaRepository<OperationalProfileItem, Long> { 

	@Query("SELECT o FROM OperationalProfileItem o WHERE o.id = :id AND o.dateDelete IS NULL")
	OperationalProfileItem findObjectId(Long id); 
	
	@Query("SELECT o FROM OperationalProfileItem o WHERE o.operationalProfile.id = :idOperationalProfile AND o.dateDelete IS NULL")
	List<OperationalProfileItem> findByOperationalProfile(Long idOperationalProfile); 

}