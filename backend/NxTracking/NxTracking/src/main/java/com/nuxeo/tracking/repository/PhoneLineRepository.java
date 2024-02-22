package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.PhoneLine;

@Repository
public interface PhoneLineRepository extends JpaRepository<PhoneLine, Long> { 

	@Query("SELECT o FROM PhoneLine o WHERE o.id = :id AND o.dateDelete IS NULL")
	PhoneLine findObjectId(Long id); 

	@Query("SELECT o FROM PhoneLine o WHERE o.dateDelete IS NULL ORDER BY o.number ASC")
	List<PhoneLine> findAll(); 

}