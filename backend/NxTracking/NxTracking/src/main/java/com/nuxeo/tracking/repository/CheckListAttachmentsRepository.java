package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.CheckListAttachments;

@Repository
public interface CheckListAttachmentsRepository extends JpaRepository<CheckListAttachments, Long> { 

	@Query("SELECT o FROM CheckListAttachments o WHERE o.id = :id AND o.dateDelete IS NULL")
	CheckListAttachments findObjectId(Long id); 
	
	@Query("SELECT o FROM CheckListAttachments o WHERE o.checklist.customer.company.id = :idCompany AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CheckListAttachments> findByCompany(Long idCompany); 

	@Query("SELECT o FROM CheckListAttachments o WHERE o.checklist.customer.id = :idCustomer AND o.dateDelete IS NULL ORDER BY o.name ASC")
	List<CheckListAttachments> findByCustomer(Long idCustomer); 

}