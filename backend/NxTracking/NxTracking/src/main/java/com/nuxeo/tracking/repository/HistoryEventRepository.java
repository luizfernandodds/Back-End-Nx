package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.HistoryEvent;

@Repository
public interface HistoryEventRepository extends JpaRepository<HistoryEvent, Long> { 

	@Query("SELECT o FROM HistoryEvent o WHERE o.id = :id")
	HistoryEvent findObjectId(Long id); 
	
	@Query("SELECT o FROM HistoryEvent o WHERE o.customer.company.id = :idCompany ORDER BY o.treatedby ASC")
	List<HistoryEvent> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM HistoryEvent o WHERE o.customer.id = :idCustomer ORDER BY o.treatedby ASC")
	List<HistoryEvent> findAllCustomer(Long idCustomer); 

	@Query("SELECT o FROM HistoryEvent o WHERE o.idTarget = :idTarget ORDER BY o.dateCreate DESC")
	List<HistoryEvent> findAllTarget(Long idTarget); 

	@Query("SELECT DISTINCT o FROM HistoryEvent o WHERE o.idEventFired = :idEventFired AND o.attendanceSituation.id = 2")
	List<HistoryEvent> findTreatedBy(Long idEventFired); 

}