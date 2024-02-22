package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.TechnicalSheet;

@Repository
public interface TechnicalSheetRepository extends JpaRepository<TechnicalSheet, Long> { 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.id = :id AND o.dateDelete IS NULL")
	TechnicalSheet findObjectId(Long id); 
	
	@Query("SELECT o FROM TechnicalSheet o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.numberLineTec ASC")
	List<TechnicalSheet> findByCompany(Long idCompany); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.numberLineTec ASC")
	List<TechnicalSheet> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM TechnicalSheet o WHERE o.dateDelete IS NULL ORDER BY o.numberLineTec ASC")
	List<TechnicalSheet> findAll(); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.customer.id = :idCustomer AND o.postOfficeLine.id = :idLine AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByCustomerAndLine(Long idCustomer, Long idLine); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.customer.id = :idCustomer AND o.active = true AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByCustomerAndActive(Long idCustomer); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.customer.id = :idCustomer AND o.numberLineTec LIKE %:number% AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByCustomerAndNumber(Long idCustomer, String number); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.loginCreate = :idLogin AND o.postOfficeLine.id = :idLine AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByLoginAndLine(Long idLogin, Long idLine); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.loginCreate = :idLogin AND o.dateDelete IS NULL")
	List<TechnicalSheet> findAllLogin(Long idLogin); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.managerUnit.id in (:listManagerUnit) AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByListManagerUnit(List<Long> listManagerUnit); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.managerUnit.id in (:listManagerUnit) AND o.postOfficeLine.id = :idLine AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByListManagerUnitAndLine(List<Long> listManagerUnit, Long idLine); 

	@Query("SELECT o FROM TechnicalSheet o WHERE o.managerUnit.id in (:listTechnicalSheet) AND o.dateDelete IS NULL")
	List<TechnicalSheet> findByListTechnicalSheet(List<Long> listTechnicalSheet); 

}