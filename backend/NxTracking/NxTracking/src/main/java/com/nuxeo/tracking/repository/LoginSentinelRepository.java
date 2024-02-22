package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginSentinel;

@Repository
public interface LoginSentinelRepository extends JpaRepository<LoginSentinel, Long> { 

	@Query("SELECT o FROM LoginSentinel o WHERE o.id = :id")
	LoginSentinel findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginSentinel o WHERE o.loginEventSentinel.id = :idLoginEventSentinel ORDER BY o.id ASC")
	List<LoginSentinel> findByLoginEventSentinel(Long idLoginEventSentinel); 
	
}