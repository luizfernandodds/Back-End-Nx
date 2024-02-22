package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.MaintenanceDone;

@Repository
public interface MaintenanceDoneRepository extends JpaRepository<MaintenanceDone, Long> { 

	@Query("SELECT o FROM MaintenanceDone o WHERE o.id = :id AND o.dateDelete IS NULL")
	MaintenanceDone findObjectId(Long id); 
	
	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.description ASC")
	List<MaintenanceDone> findByCompany(Long idCompany); 

	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.description ASC")
	List<MaintenanceDone> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM MaintenanceDone o WHERE o.dateDelete IS NULL ORDER BY o.description ASC")
	List<MaintenanceDone> findAll(); 

	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.id = :idCustomer AND o.dateMaitenance >= :begin AND o.dateMaitenance <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<MaintenanceDone> findByCustomerAndDate(Long idCustomer, LocalDateTime begin, LocalDateTime end); 

	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.id = :idCustomer AND o.maintenance.analysis = :unit AND o.dateMaitenance >= :begin AND o.dateMaitenance <= :end AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<MaintenanceDone> findByCustomerAndUnit(Long idCustomer, LocalDateTime begin, LocalDateTime end, int unit); 

//	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.id = :idCustomer AND o.maintenance.id = :idMaintenance AND o.valueMaitenance = (SELECT MAX(_md.valueMaintenance) FROM MaintenanceDone _md WHERE _md.maintenance.id = :idMaintenance AND md.target = _md.target)")
//	List<MaintenanceDone> findByCustomerAndMaintenanceAndTarget(Long idMaintenance, Long idCustomer); 

	@Query("SELECT o FROM MaintenanceDone o WHERE o.customer.id = :idCustomer AND o.maintenance.id = :idMaintenance AND o.dateMaitenance = (SELECT MAX(_md.dateMaitenance) FROM MaintenanceDone _md WHERE _md.maintenance.id = :idMaitenance AND _md.target.id = :idTarget)")
	List<MaintenanceDone> findByMaintenanceAndTarget(Long idMaintenance, Long idTarget); 

}