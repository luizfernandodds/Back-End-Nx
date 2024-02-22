package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.AttachmentType;

@Repository
public interface AttachmentTypeRepository extends JpaRepository<AttachmentType, Long> { 

	@Query("SELECT o FROM AttachmentType o WHERE o.id = :id AND o.dateDelete IS NULL")
	AttachmentType findObjectId(Long id); 
	
}