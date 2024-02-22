package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CostCenterKitItem;

@Repository
public interface CostCenterKitItemRepository extends JpaRepository<CostCenterKitItem, Long> { 

	@Query("SELECT o FROM CostCenterKitItem o WHERE o.id = :id AND o.dateDelete IS NULL")
	CostCenterKitItem findObjectId(Long id); 
	
	@Query("SELECT o FROM CostCenterKitItem o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItem> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CostCenterKitItem o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItem> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM CostCenterKitItem o WHERE o.costCenterKit.id = :idCostCenterKit AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<CostCenterKitItem> findByCostCenterKit(Long idCostCenterKit); 


}