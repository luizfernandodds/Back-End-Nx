package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.InvoicingTargetAccredit;

@Repository
public interface InvoicingTargetAccreditRepository extends JpaRepository<InvoicingTargetAccredit, Long> { 

	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.id = :id AND o.dateDelete IS NULL")
	InvoicingTargetAccredit findObjectId(Long id); 
	
	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<InvoicingTargetAccredit> findByCompany(Long idCompany); 

	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<InvoicingTargetAccredit> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.dateDelete IS NULL ORDER BY o.dateCreate ASC")
	List<InvoicingTargetAccredit> findAll(); 

	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.costCenterKit.id = :idCostCenterKit AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<InvoicingTargetAccredit> findByCostCenterKit(Long idCostCenterKit); 

	@Query("SELECT o FROM InvoicingTargetAccredit o WHERE o.costCenterKit.id = :idCostCenterKit AND o.kit.id = :idKit AND o.target.id = :idTarget AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<InvoicingTargetAccredit> findByCostCenterKitAndKitAndTarget(Long idCostCenterKit, Long idKit, Long idTarget); 

}