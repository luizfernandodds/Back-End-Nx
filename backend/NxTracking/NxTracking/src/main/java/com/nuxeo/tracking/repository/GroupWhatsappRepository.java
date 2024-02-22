package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupWhatsapp;

@Repository
public interface GroupWhatsappRepository extends JpaRepository<GroupWhatsapp, Long> { 

	@Query("SELECT o FROM GroupWhatsapp o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupWhatsapp findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupWhatsapp o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupWhatsapp> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupWhatsapp o WHERE o.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<GroupWhatsapp> findAllCustomer(Long idCustomer); 

}