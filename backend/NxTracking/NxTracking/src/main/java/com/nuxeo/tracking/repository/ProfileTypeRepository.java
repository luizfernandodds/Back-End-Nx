package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ProfileType;

@Repository
public interface ProfileTypeRepository extends JpaRepository<ProfileType, Long> { 

	@Query("SELECT o FROM ProfileType o WHERE o.id = :id AND o.dateDelete IS NULL")
	ProfileType findObjectId(Long id); 
	
}