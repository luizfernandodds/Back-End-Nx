package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.BlockScheduleType;

@Repository
public interface BlockScheduleTypeRepository extends JpaRepository<BlockScheduleType, Long> { 

	@Query("SELECT o FROM BlockScheduleType o WHERE o.id = :id AND o.dateDelete IS NULL")
	BlockScheduleType findObjectId(Long id); 
	
	@Query("SELECT o FROM BlockScheduleType o WHERE o.dateDelete IS NULL")
	List<BlockScheduleType> findAll(); 

}