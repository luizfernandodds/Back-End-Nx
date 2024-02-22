package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.Sentinel;

@Repository
public interface SentinelRepository extends JpaRepository<Sentinel, Long> { 

	@Query("SELECT o FROM Sentinel o WHERE o.id = :id AND o.dateDelete IS NULL")
	Sentinel findObjectId(Long id); 

	@Query("SELECT o FROM Sentinel o INNER JOIN FETCH o.attendanceSituation INNER JOIN FETCH o.eventFired LEFT JOIN FETCH o.driver INNER JOIN FETCH o.ssmaEventFired INNER JOIN FETCH o.login INNER JOIN FETCH o.target")
	List<Sentinel> findAll(); 
}