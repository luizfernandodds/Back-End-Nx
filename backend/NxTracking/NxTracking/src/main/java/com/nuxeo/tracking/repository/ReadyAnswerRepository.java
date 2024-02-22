package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.ReadyAnswer;

@Repository
public interface ReadyAnswerRepository extends JpaRepository<ReadyAnswer, Long> { 

	@Query("SELECT o FROM ReadyAnswer o WHERE o.id = :id AND o.dateDelete IS NULL")
	ReadyAnswer findObjectId(Long id); 
	
}