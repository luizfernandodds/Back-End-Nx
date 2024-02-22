package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginEventSentinel;

@Repository
public interface LoginEventSentinelRepository extends JpaRepository<LoginEventSentinel, Long> { 

	@Query("SELECT o FROM LoginEventSentinel o WHERE o.id = :id AND o.dateDelete IS NULL")
	LoginEventSentinel findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginEventSentinel o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<LoginEventSentinel> findByCompany(Long idCompany); 

	@Query("SELECT o FROM LoginEventSentinel o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<LoginEventSentinel> findByCustomer(Long idCustomer); 

}