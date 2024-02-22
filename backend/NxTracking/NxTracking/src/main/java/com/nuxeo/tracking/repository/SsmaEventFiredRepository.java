package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CheckList;
import com.nuxeo.tracking.model.SsmaEventFired;

@Repository
public interface SsmaEventFiredRepository extends JpaRepository<SsmaEventFired, Long> { 

	@Query("SELECT o FROM SsmaEventFired o WHERE o.id = :id AND o.dateDelete IS NULL")
	SsmaEventFired findObjectId(Long id); 
	
	@Query("SELECT o FROM SsmaEventFired o WHERE o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<SsmaEventFired> findAll(); 

	@Query("SELECT o FROM SsmaEventFired o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CheckList> findByCompany(Long idCompany); 

	@Query("SELECT o FROM SsmaEventFired o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CheckList> findByCompanyAndCustomer(Long idCustomer); 
}