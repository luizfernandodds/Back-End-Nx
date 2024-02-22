package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.LoginTechnicalSheet;

@Repository
public interface LoginTechnicalSheetRepository extends JpaRepository<LoginTechnicalSheet, Long> { 

	@Query("SELECT o FROM LoginTechnicalSheet o WHERE o.id = :id")
	LoginTechnicalSheet findObjectId(Long id); 
	
	@Query("SELECT o FROM LoginTechnicalSheet o WHERE o.login.id = :idLogin AND o.technicalSheet.dateDelete IS NULL ORDER BY o.id ASC")
	List<LoginTechnicalSheet> findByLogin(Long idLogin); 

	@Query("SELECT DISTINCT(o) FROM LoginTechnicalSheet o WHERE o.technicalSheet.dateDelete IS NULL ORDER BY o.id ASC")
	List<LoginTechnicalSheet> findAll(); 

	@Query("SELECT o FROM LoginTechnicalSheet o WHERE o.login.id = :idLogin AND o.technicalSheet.postOfficeLine.id = :idLine AND o.technicalSheet.dateDelete IS NULL")
	List<LoginTechnicalSheet> findByLoginAndLine(Long idLogin, Long idLine); 

}