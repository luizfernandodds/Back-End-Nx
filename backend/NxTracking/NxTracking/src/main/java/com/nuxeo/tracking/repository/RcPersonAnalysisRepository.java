package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.RcPersonAnalysis;

@Repository
public interface RcPersonAnalysisRepository extends JpaRepository<RcPersonAnalysis, Long> { 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.id = :id AND o.dateDelete IS NULL")
	RcPersonAnalysis findObjectId(Long id); 
	
	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<RcPersonAnalysis> findByCompany(Long idCompany); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<RcPersonAnalysis> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.dateDelete IS NULL ORDER BY o.name ASC")
	List<RcPersonAnalysis> findAll(); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.loginCreate = :idLogin AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<RcPersonAnalysis> findByLogin(Long idLogin); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.dateReturnAnalysis IS NULL AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<RcPersonAnalysis> findByReturnAnalysis(); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.document = :document AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDateAndDocument(String document, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDate(LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL GROUP BY o.createTimeMillisecond ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDateGroupByCreateMilli(LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.document = :document AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.createTimeMillisecond = :createTimeMillisecond AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDateAndDocumentAndCreateMilli(String document, LocalDateTime begin, LocalDateTime end, Long createTimeMillisecond); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.dateDelete IS NULL GROUP BY o.createTimeMillisecond ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDateAndCustomerGroupByCreateMilli(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM RcPersonAnalysis o WHERE o.customer.id = :idCustomer AND o.dateCreate >= :begin AND o.dateCreate <= :end AND o.document = :document GROUP BY o.createTimeMillisecond ORDER BY o.dateCreate DESC")
	List<RcPersonAnalysis> findByDateAndDocumentGroupByCreateMilliAndCustomer(Long idCustomer, LocalDateTime begin, LocalDateTime end, String document); 

}