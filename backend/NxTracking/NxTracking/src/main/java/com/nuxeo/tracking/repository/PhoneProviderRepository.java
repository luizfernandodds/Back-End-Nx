package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.PhoneProvider;

@Repository
public interface PhoneProviderRepository extends JpaRepository<PhoneProvider, Long> { 

	@Query("SELECT o FROM PhoneProvider o WHERE o.id = :id AND o.dateDelete IS NULL")
	PhoneProvider findObjectId(Long id); 

	@Query("SELECT o FROM PhoneProvider o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<PhoneProvider> findAll(); 

}