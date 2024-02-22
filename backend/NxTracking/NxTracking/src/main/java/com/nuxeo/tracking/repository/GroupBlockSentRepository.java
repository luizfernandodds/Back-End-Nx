package com.nuxeo.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nuxeo.tracking.model.GroupBlockSent;

@Repository
public interface GroupBlockSentRepository extends JpaRepository<GroupBlockSent, Long> { 

	@Query("SELECT o FROM GroupBlockSent o WHERE o.id = :id AND o.dateDelete IS NULL")
	GroupBlockSent findObjectId(Long id); 
	
	@Query("SELECT o FROM GroupBlockSent o WHERE o.customer.company.id = :idCompany AND o.dateDelete IS NULL")
	List<GroupBlockSent> findAllCompany(Long idCompany); 

	@Query("SELECT o FROM GroupBlockSent o WHERE o.groupBlock.id = :idGroupBlock AND o.dateDelete IS NULL")
	List<GroupBlockSent> findAllGroupBlock(Long idGroupBlock); 

}