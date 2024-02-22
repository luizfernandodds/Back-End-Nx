package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.InvoicingTargetAttachments;

@Repository
public interface InvoicingTargetAttachmentsRepository extends JpaRepository<InvoicingTargetAttachments, Long> { 

	@Query("SELECT o FROM InvoicingTargetAttachments o WHERE o.id = :id AND o.dateDelete IS NULL")
	InvoicingTargetAttachments findObjectId(Long id); 
	
	@Query("SELECT o FROM InvoicingTargetAttachments o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<InvoicingTargetAttachments> findByCompany(Long idCompany); 

	@Query("SELECT o FROM InvoicingTargetAttachments o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<InvoicingTargetAttachments> findByCustomer(Long idCustomer); 
	
	@Query("SELECT o FROM InvoicingTargetAttachments o WHERE o.costCenterKit.id = :idCostCenterKit AND o.dateDelete IS NULL ORDER BY o.dateCreate DESC")
	List<InvoicingTargetAttachments> findByCostCenterKit(Long idCostCenterKit); 

	@Query("SELECT o FROM InvoicingTargetAttachments o WHERE o.downloadCode = :idDownloadCode AND o.dateDelete IS NULL")
	List<InvoicingTargetAttachments> findByDownloadCode(Long idDownloadCode); 

}