package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.InvoicingTargetDiscount;

@Repository
public interface InvoicingTargetDiscountRepository extends JpaRepository<InvoicingTargetDiscount, Long> { 

	@Query("SELECT o FROM InvoicingTargetDiscount o WHERE o.id = :id AND o.dateDelete IS NULL")
	InvoicingTargetDiscount findObjectId(Long id); 
	
	@Query("SELECT o FROM InvoicingTargetDiscount o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<InvoicingTargetDiscount> findByCompany(Long idCompany); 

	@Query("SELECT o FROM InvoicingTargetDiscount o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<InvoicingTargetDiscount> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM InvoicingTargetDiscount o WHERE o.costCenterKit.id = :idCostCenterKit AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<InvoicingTargetDiscount> findByCostCenterKit(Long idCostCenterKit); 

}