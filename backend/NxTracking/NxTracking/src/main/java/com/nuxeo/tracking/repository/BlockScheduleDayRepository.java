package com.nuxeo.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.BlockScheduleDay;

@Repository
public interface BlockScheduleDayRepository extends JpaRepository<BlockScheduleDay, Long> { 

	@Query("SELECT o FROM BlockScheduleDay o WHERE o.id = :id")
	BlockScheduleDay findObjectId(Long id); 
	
}