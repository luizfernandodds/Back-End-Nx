package com.nuxeo.tracking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CostCenterKitItemTarget;

@Repository
public interface CostCenterKitItemTargetRepository extends JpaRepository<CostCenterKitItemTarget, Long> { 

	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.id = :id AND o.dateDelete IS NULL")
	CostCenterKitItemTarget findObjectId(Long id); 
	
	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItemTarget> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItemTarget> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.costCenterKitItem.id = :idCostCenterKitItem AND o.target.id = :idTarget AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItemTarget> findByCostCenterKitItemAndTarget(Long idCostCenterKitItem, Long idTarget); 

	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.customer.id = :idCustomer AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.costCenterKit.customerSelected.id DESC")
	List<CostCenterKitItemTarget> findByCustomerAndDate(Long idCustomer, LocalDateTime end); 

	@Query("SELECT o FROM CostCenterKitItemTarget o WHERE o.customer.company.id = :idCompany AND o.dateCreate <= :end AND o.dateDelete IS NULL ORDER BY o.costCenterKit.customerSelected.id DESC")
	List<CostCenterKitItemTarget> findByCompanyAndDate(Long idCompany, LocalDateTime end); 

}