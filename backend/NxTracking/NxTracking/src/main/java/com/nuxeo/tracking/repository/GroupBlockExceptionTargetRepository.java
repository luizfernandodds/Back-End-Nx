package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockExceptionTarget;

@Repository
public interface GroupBlockExceptionTargetRepository extends JpaRepository<GroupBlockExceptionTarget, Long> { 

	@Query("SELECT o FROM GroupBlockExceptionTarget o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockExceptionTarget findObjectId(Long id); 

	@Query("SELECT o FROM GroupBlockExceptionTarget o WHERE o.groupBlockException.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockExceptionTarget> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlockExceptionTarget o WHERE o.groupBlockException.customer.id = :idCustomer AND o.dateDelete IS NULL")
	List<GroupBlockExceptionTarget> findAllCustomer(Long idCustomer); 

	@Query("SELECT o FROM GroupBlockExceptionTarget o WHERE o.dateDelete IS NULL")
	List<GroupBlockExceptionTarget> findAll(); 

	@Query("SELECT o FROM GroupBlockExceptionTarget o WHERE o.groupBlockException.id = :idGroupBlockException AND o.dateDelete IS NULL")
	List<GroupBlockExceptionTarget> findAllGroupBlockException(Long idGroupBlockException); 

}